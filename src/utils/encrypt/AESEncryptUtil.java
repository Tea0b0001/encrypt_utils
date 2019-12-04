package utils.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptUtil {


    private static final String AES_NAME = "AES";
    private static final String UTF8_NAME = "utf-8";
    //"算法/模式/补码方式"
    private static final String AES_CIPHER = "AES/ECB/PKCS5Padding";

    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            throw new IllegalArgumentException("key不能为空");
        }
        if (sKey.length() != 16) {
            throw new IllegalArgumentException("key长度要为16位");
        }
        try {
            byte[] src = sSrc.getBytes(UTF8_NAME);
            byte[] key = sKey.getBytes(UTF8_NAME);
            return encrypt(src, key);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static String encrypt(byte[] src, byte[] key) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, AES_NAME);
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(src);
            return new String(encrypted, UTF8_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String sSrc, String sKey) {
        if (sKey == null) {
            throw new IllegalArgumentException("key不能为空");
        }
        if (sKey.length() != 16) {
            throw new IllegalArgumentException("key长度要为16位");
        }

        try {
            byte[] src = sSrc.getBytes(UTF8_NAME);
            byte[] key = sKey.getBytes(UTF8_NAME);
            return decrypt(key, src);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String decrypt(byte[] src, byte[] key) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, AES_NAME);
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] original = cipher.doFinal(src);
            return new String(original, UTF8_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
