package net.quackster.icarus.messages.outgoing.room.user;

import net.quackster.icarus.game.user.Session;
import net.quackster.icarus.messages.Message;
import net.quackster.icarus.netty.readers.Request;

public class GetRoomRightsListMessageEvent implements Message {

	@Override
	public void handle(Session session, Request request) {
		
		System.out.println("XDDDDDDDDDDD");
	}

}
