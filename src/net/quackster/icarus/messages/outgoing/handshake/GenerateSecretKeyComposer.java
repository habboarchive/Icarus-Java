package net.quackster.icarus.messages.outgoing.handshake;

import net.quackster.icarus.messages.headers.Outgoing;
import net.quackster.icarus.netty.readers.Response;

public class GenerateSecretKeyComposer extends Response {
	
	public GenerateSecretKeyComposer(String encryptedPublicKey) {
		
		this.init(Outgoing.SecretKeyMessageComposer);	
		this.appendString(encryptedPublicKey);
		this.appendBoolean(false);
	}
}
