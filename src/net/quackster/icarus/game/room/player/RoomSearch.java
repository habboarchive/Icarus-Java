package net.quackster.icarus.game.room.player;

import net.quackster.icarus.game.room.Room;
import net.quackster.icarus.game.room.model.Point;
import net.quackster.icarus.game.user.Session;

public class RoomSearch {

	private Room room;

	public RoomSearch(Room room) {
		this.room = room;
	}

	public Session findUser(Point coord) {

		try {
			return room.getUsers().stream().filter(session -> session.getRoomUser().getPoint().sameAs(coord) && !session.getRoomUser().isWalking()).findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}
}