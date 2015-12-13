package net.quackster.icarus.messages.incoming.room;

import net.quackster.icarus.Icarus;
import net.quackster.icarus.game.room.Room;
import net.quackster.icarus.game.room.model.RoomModel;
import net.quackster.icarus.game.user.Session;
import net.quackster.icarus.messages.Message;
import net.quackster.icarus.messages.headers.Outgoing;
import net.quackster.icarus.netty.readers.Request;
import net.quackster.icarus.netty.readers.Response;

public class RequestHeightmapMessageEvent implements Message {

	@Override
	public void handle(Session session, Request request) {

		Room room = Icarus.getDao().getRoom().getRoom(request.readInt(), true);
		
		if (room == null) {
			return;
		}
		
		RoomModel roomModel = room.getModel();
		
		Response response = new Response(Outgoing.HeightMapMessageComposer);
		response.appendInt32(roomModel.getMapSizeX() * roomModel.getMapSizeY());

		for (int i = 0; i < roomModel.getMapSizeY(); i++) {
			for (int j = 0; j < roomModel.getMapSizeX(); j++) {
				response.appendShort((int) (roomModel.getSquareHeight()[j][i] * 256));
			}
		}

		session.send(response);

		response = new Response(Outgoing.FloorMapMessageComposer);
		response.appendBoolean(true);
		response.appendInt32(room.getWallHeight());
		response.appendString(room.getModel().getFloorMap());
		session.send(response);
	}

}
