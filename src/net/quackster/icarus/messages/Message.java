package net.quackster.icarus.messages;

import net.quackster.icarus.game.user.Session;
import net.quackster.netty.readers.Request;

public interface Message {
	public void handle(Session session, Request request);
}