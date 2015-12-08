package net.quackster.icarus.messages.incoming.room;

import net.quackster.icarus.game.user.Session;
import net.quackster.icarus.game.user.client.SessionRoom;
import net.quackster.icarus.messages.Message;
import net.quackster.icarus.netty.readers.Request;

public class UserWalkMessageEvent implements Message {

	@Override
	public void handle(Session session, Request request) {

		int X = request.readInt();
		int Y = request.readInt();

		try {

			if (X == session.getRoomUser().getX() && Y == session.getRoomUser().getY()) {
				return;
			}

			SessionRoom roomUser = session.getRoomUser();
			roomUser.createPathfinder();

			roomUser.setGoalX(X);
			roomUser.setGoalY(Y);
			roomUser.setPath(roomUser.getPathfinder().calculateShortestPath(roomUser.getPoint(), roomUser.getGoalPoint()));

			System.out.println("PATHFINDER SIZE: " + roomUser.getPath().size());

			roomUser.setWalking(true);
			
		}catch (Exception e) {
			e.printStackTrace();

		}
	}
}