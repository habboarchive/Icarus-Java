package net.quackster.icarus.game.room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import net.quackster.icarus.Icarus;
import net.quackster.icarus.game.entity.EntityType;
import net.quackster.icarus.game.entity.IEntity;
import net.quackster.icarus.game.room.model.Point;
import net.quackster.icarus.game.room.model.RoomModel;
import net.quackster.icarus.game.room.player.RoomSearch;
import net.quackster.icarus.game.room.player.RoomUser;
import net.quackster.icarus.game.room.settings.RoomType;
import net.quackster.icarus.game.user.Session;
import net.quackster.icarus.log.Log;
import net.quackster.icarus.messages.outgoing.room.PrepareRoomMessageComposer;
import net.quackster.icarus.messages.outgoing.room.RoomModelMessageComposer;
import net.quackster.icarus.messages.outgoing.room.RoomRatingMessageComposer;
import net.quackster.icarus.messages.outgoing.room.RoomRightsLevelMessageComposer;
import net.quackster.icarus.messages.outgoing.room.RoomSpacesMessageComposer;
import net.quackster.icarus.messages.outgoing.room.user.HotelViewMessageComposer;
import net.quackster.icarus.messages.outgoing.room.user.RemoveUserMessageComposer;
import net.quackster.icarus.netty.readers.Response;

public class Room {

	private int privateId;
	private int[][] collisionMap;
	private boolean disposed;

	private RoomSearch search;
	private RoomData data;

	private List<IEntity> entities;

	private ScheduledFuture<?> tickTask;

	public Room() {
		this.search = new RoomSearch(this);
		this.data = new RoomData(this);
		this.entities = new ArrayList<IEntity>();
	}

	public void leaveRoom(Session session, boolean hotelView) {

		if (hotelView) {;
		session.send(new HotelViewMessageComposer());
		}

		this.send(new RemoveUserMessageComposer(session.getRoomUser().getVirtualId()));

		RoomUser roomUser = session.getRoomUser();

		roomUser.stopWalking(false);
		roomUser.reset();

		this.entities.remove(session);
		this.dispose();

		session.getMessenger().sendStatus(false);
	}

	public boolean hasRights(int userId) {

		if (this.data.getOwnerId() == userId) {
			return true;
		} else {
			return this.data.getRights().contains(userId);
		}
	}

	public void loadRoom(Session session) {

		RoomUser roomUser = session.getRoomUser();

		roomUser.setRoom(this);
		roomUser.setLoadingRoom(true);
		roomUser.getStatuses().clear();

		session.send(new RoomModelMessageComposer(this));

		if (!this.data.getFloor().equals("0")) {
			session.send(new RoomSpacesMessageComposer("floor", this.data.getFloor()));
		}

		if (!this.data.getWall().equals("0")) {
			session.send(new RoomSpacesMessageComposer("wallpaper", this.data.getWall()));
		}

		session.send(new RoomSpacesMessageComposer("landscape", this.data.getLandscape()));
		session.send(new RoomRatingMessageComposer(roomUser, this.data.getScore()));
		session.send(new RoomRightsLevelMessageComposer(roomUser));
		session.send(new PrepareRoomMessageComposer(this));

	}


	public void firstEntry() {

		if (this.getUsers().size() != 0) {
			return;
		}
		
		this.disposed = false;

		this.setTickTask(Icarus.getUtilities().getThreadPooling().getScheduledThreadPool().scheduleAtFixedRate(new RoomCycle(this), 0, 500, TimeUnit.MILLISECONDS));
		this.regenerateCollisionMap();

		/*Bot mahBawt = new Bot();

		mahBawt.getRoomUser().setRoom(this);
		mahBawt.getRoomUser().setX(this.getData().getModel().getDoorX());
		mahBawt.getRoomUser().setY(this.getData().getModel().getDoorY());
		mahBawt.getRoomUser().setHeight(this.getData().getModel().getHeight(mahBawt.getRoomUser().getPoint()));
		mahBawt.getRoomUser().setVirtualId(this.getVirtualId());

		this.entities.add(mahBawt);*/
	}


	public void regenerateCollisionMap() {

		if (this.data.getModel() == null) {
			return;
		}

		int mapSizeX = this.data.getModel().getMapSizeX();
		int mapSizeY = this.data.getModel().getMapSizeY();

		int[][] collisionMap = new int[mapSizeX][mapSizeY]; 

		for(int y = 0; y < mapSizeY; y++) {
			for(int x = 0; x < mapSizeX; x++) {

				if (this.data.getModel().getSquareStates()[x][y] == RoomModel.OPEN) {

					collisionMap[x][y] = RoomModel.OPEN;

					if (!this.getData().isAllowWalkthrough()) { // if the room doesn't want players to be able to walk into each other

						if (this.search.findUser(new Point(x, y)) != null) {
							collisionMap[x][y] = RoomModel.CLOSED;
						}
					}

				} else {
					collisionMap[x][y] = RoomModel.CLOSED;
				}
			}
		}

		this.collisionMap = collisionMap;
	}


	public void send(Response response, boolean checkRights) {

		if (this.disposed) {
			return;
		}

		for (Session session : this.getUsers()) {

			if (checkRights && this.hasRights(session.getDetails().getId())) {
				Log.println("(" + session.getDetails().getUsername() + ") SENT: " + response.getHeader() + " / " + response.getBodyString());
				session.send(response);
			}
		}
	}


	public void send(Response response) {

		if (this.disposed) {
			return;
		}

		for (Session session : this.getUsers()) {
			session.send(response);
		}
	}

	public RoomData getData() {
		return data;
	}

	public RoomSearch getSearch() {
		return this.search;
	}

	public List<IEntity> getEntities() {
		return entities;
	}

	public List<IEntity> getEntities(EntityType type) {
		List<IEntity> e = new ArrayList<IEntity>();

		for (IEntity entity : this.entities) {
			if (entity.getType() == type) {
				e.add(entity);
			}
		}

		return e;
	}

	public List<Session> getUsers() {

		List<Session> sessions = new ArrayList<Session>();

		for (IEntity entity : this.getEntities(EntityType.PLAYER)) {
			Session session = (Session)entity;
			sessions.add(session);
		}

		return sessions;
	}

	public int getVirtualId() {
		this.privateId = this.privateId + 1;
		return this.privateId;
	}

	public int[][] getCollisionMap() {
		return collisionMap;
	}

	public void setTickTask(ScheduledFuture<?> task) {
		this.tickTask = task;
	}

	public String getPassword() {
		return "xd";
	}

	public void dispose() {

		if (this.disposed) {
			return;
		}

		try {

			if (this.data.getRoomType() == RoomType.PRIVATE) {
				if (this.getUsers().size() > 0) {
					return;
				}
			}
			
			if (this.tickTask != null) {
				this.tickTask.cancel(true);
				this.tickTask = null;
			}
			
			this.collisionMap = null;
			this.entities.clear();

			if (Icarus.getServer().getSessionManager().findById(this.data.getOwnerId()) == null && this.data.getRoomType() == RoomType.PRIVATE) { 
				
				System.out.println("Room ID (" + this.data.getId() + ") deleted");
				
				this.data.dispose();
				this.data = null;
			
				this.search.dispose();
				this.search = null;
				this.entities = null;
				
				Icarus.getGame().getRoomManager().getLoadedRooms().remove(this);
			}

			this.disposed = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsers(ArrayList<IEntity> entities) {
		this.entities = entities;
	}


}
