package net.quackster.icarus.game.encryption;

/**
 * Written by Scott Stamp
 * Edited: 11/25/2015 (Scott Stamp).
 * (from Morgoth, thanks Jordan!)
 */
import java.math.BigInteger;

public class RSA {

	public BigInteger exponent;
    public BigInteger N;
    public BigInteger D;
    
    public boolean decryptable;
    public boolean encryptable;
    private BigInteger zero = new BigInteger("0");

    public RSA() {
    	this.init();
    }

    public void init() {
    	
        N = new BigInteger("ac7f00c70bb1306c35bc55344239bca22f880bb70f8d1bcc2be360d25c4abaf8f899f9e3d4eed83ef320645f10f844639f4971c85124ae54e9b3ca76f66bc524ac3bfc81e3cb39b66a2a9d04b5cfccde118867741a10e6f3359a5a7987ef01cf3cc8098595d56ac59f3770eec06dbf4fd1227ca20b98196c7cc4ee4f5519e39d", 16);
        exponent = new BigInteger("10001", 16);
        D = new BigInteger("968e2f2e8bdcf687ac0b1a4f07727f5b0ba3719e30bb97c48795e91f1220c3baa4b937eb8c217faac9e7bed35eeb623d957cb40c040ec0fe2a109ba9638142ca45769a5cf68ccc3a42ec7d3aa112ad012d3d2843d9cc0c3c504ffbbbddbba3716043f65e15149935a52c1d1d71d5c589d5563784c97a91bc55e50d26ec2da2dd", 16);

        encryptable = (N != null && N != zero && exponent != zero);
        decryptable = (encryptable && D != zero && D != null);
    }

    public int getBlockSize() {
        return (N.bitLength() + 7) / 8;
    }

    public BigInteger doPublic(BigInteger x) {
        if (this.encryptable) {
            return x.modPow(new BigInteger(this.exponent + ""), this.N);
        }

        return zero;
    }

    public String encrypt(String text) {
        BigInteger m = new BigInteger(this.pkcs1pad2(text.getBytes(), this.getBlockSize()));

        if (m.equals(zero)) {
            return null;
        }

        BigInteger c = this.doPublic(m);

        if (c.equals(zero)) {
            return null;
        }

        String result = c.toString(16);

        if ((result.length() & 1) == 0) {
            return result;
        }

        return "0" + result;
    }

    public String sign(String text) {
    	
        BigInteger m = new BigInteger(this.pkcs1pad2(text.getBytes(), this.getBlockSize()));

        if (m.equals(zero)) {
            return null;
        }

        BigInteger c = this.DoPrivate(m);

        if (c.equals(zero)) {
            return null;
        }

        String result = c.toString(16);

        if ((result.length() & 1) == 0) {
            return result;
        }

        return "0" + result;
    }

    private byte[] pkcs1pad2(byte[] data, int n) {
        byte[] bytes = new byte[n];

        int i = data.length - 1;

        while (i >= 0 && n > 11) {
            bytes[--n] = data[i--];
        }

        bytes[--n] = 0;

        while (n > 2) {
            bytes[--n] = (byte) 0xFF;
        }

        bytes[--n] = (byte) 1;
        bytes[--n] = 0;

        return bytes;
    }

    public BigInteger DoPrivate(BigInteger x) {
        if (this.decryptable) {
            return x.modPow(this.D, this.N);
        }

        return zero;
    }

    public String decrypt(String ctext) {
        BigInteger c = new BigInteger(ctext, 16);
        BigInteger m = this.DoPrivate(c);

        if (m.equals(zero)) {
            return null;
        }

        byte[] bytes = this.pkcs1unpad2(m, this.getBlockSize());

        if (bytes == null) {
            return null;
        }

        return new String(bytes);
    }

    /**
     * @param src
     * @param n
     * @return
     */
    private byte[] pkcs1unpad2(BigInteger src, int n) {
        byte[] bytes = src.toByteArray();
        byte[] out;
        int i = 0;

        while (i < bytes.length && bytes[i] == 0) {
            ++i;
        }

        if (bytes.length - i != n - 1 || bytes[i] > 2) {
            return null;
        }

        ++i;

        while (bytes[i] != 0) {
            if (++i >= bytes.length) {
                return null;
            }
        }

        out = new byte[(bytes.length - i) + 1];
        int p = 0;

        while (++i < bytes.length) {
            out[p++] = (bytes[i]);
        }

        return out;
    }
}