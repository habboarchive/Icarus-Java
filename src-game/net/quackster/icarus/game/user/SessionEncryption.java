package net.quackster.icarus.game.user;

import net.quackster.icarus.game.encryption.RC4;
import net.quackster.icarus.game.encryption.RSA;
import net.quackster.icarus.game.encryption.DiffieHellman;

public class SessionEncryption {

	private RC4 RC4;
	private DiffieHellman diffieHellman;
	private RSA RSA;
	private boolean encrypted;

	public SessionEncryption() {
		
		this.RC4 = null;
		this.RSA = new RSA();
		this.diffieHellman = new DiffieHellman();
	}
	
	public void dispose() {
		
		this.RC4 = null;
		this.RSA = null;
		this.diffieHellman = null;
	}
	
	public boolean isEncrypted () {
		return encrypted;
	}
	
	public void setEncrypted(boolean flag) {
		this.encrypted = flag;
	}
	
	public void setRC4(RC4 rC4) {
		this.RC4 = rC4;
	}
	
	public RC4 getRC4() {
		return RC4;
	}

	public DiffieHellman getDiffieHellman() {
		return diffieHellman;
	}

	public RSA getRSA() {
		return RSA;
	}
}