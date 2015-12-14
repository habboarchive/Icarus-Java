package net.quackster.icarus.messages.incoming.handshake;

import net.quackster.icarus.Icarus;
import net.quackster.icarus.game.user.Session;
import net.quackster.icarus.messages.Message;
import net.quackster.icarus.messages.outgoing.handshake.AuthenticationOKMessageComposer;
import net.quackster.icarus.messages.outgoing.handshake.UniqueMachineIDMessageComposer;
import net.quackster.icarus.messages.outgoing.user.HomeRoomMessageComposer;
import net.quackster.icarus.messages.outgoing.user.LandingWidgetMessageComposer;
import net.quackster.icarus.netty.readers.Request;

public class SSOTicketMessageEvent implements Message {

	@Override
	public void handle(Session session, Request request) {

		boolean loginSuccess = Icarus.getDao().getPlayer().login(session, request.readString());
		
		if (!loginSuccess) {
			session.close();
			return;
		}
		
		if (session.getMachineId() == null) {
			session.close();
			return;
		}
		
		// clear any duplicate peoples
		Icarus.getServer().getSessionManager().checkForDuplicates(session);
		
		session.send(new UniqueMachineIDMessageComposer(session.getMachineId()));
		session.send(new AuthenticationOKMessageComposer());
		session.send(new HomeRoomMessageComposer(2, false));
		session.send(new LandingWidgetMessageComposer());
		
		Icarus.getDao().getRoom().getPlayerRooms(session.getDetails(), true);
	}
}