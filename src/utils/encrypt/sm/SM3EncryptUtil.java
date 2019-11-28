package utils.encrypt.sm;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import utils.encrypt.CommonEncryptUtil;

import java.io.UnsupportedEncodingException;

/**
 * SM3加密工具类
 * @author Tea0b0001
 * 2019/11/28
 */
public class SM3EncryptUtil {

    private static final SM3Digest SM3_DIGEST = new SM3Digest();
    private static final HMac HMAC = new HMac(SM3_DIGEST);
    private static final String UTF8_ENCODING = "UTF-8";

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String encrypt(String str) {
        return encrypt(str, UTF8_ENCODING);
    }

    /**
     * 加密，带密钥
     *
     * @param str 加密数据
     * @param key 密钥
     * @return
     */
    public static String encryptWithKey(String str, String key) {
        return encryptWithKey(str, UTF8_ENCODING, key, UTF8_ENCODING);
    }

    /**
     * 加密
     *
     * @param str 加密数据
     * @param encoding 编码
     * @return
     */
    public static String encrypt(String str, String encoding) {
        try {
            return encrypt(str.getBytes(encoding));
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    /**
     * 加密，带密钥
     *
     * @param str 加密数据
     * @param strEncoding 数据编码
     * @param key 密钥
     * @param keyEncoding 密钥编码
     * @return
     */
    public static String encryptWithKey(String str, String strEncoding, String key, String keyEncoding) {
        try {
            return encryptWithKey(str.getBytes(strEncoding), key.getBytes(keyEncoding));
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    /**
     * 加密
     *
     * @param bytes 加密数据
     * @return
     */
    public static String encrypt(byte[] bytes) {
        byte[] result = toBigEndian(bytes);
        return CommonEncryptUtil.bytesToHexString(result);
    }

    /**
     * 加密
     *
     * @param bytes 加密数据
     * @param key 密钥
     * @return
     */
    public static String encryptWithKey(byte[] bytes, byte[] key) {
        byte[] result = toBigEndianWithKey(bytes, key);
        return CommonEncryptUtil.bytesToHexString(result);
    }

    /**
     * 加密hash
     *
     * @param bytes 加密数据
     * @return
     */
    private static byte[] toBigEndian(byte[] bytes) {
        SM3_DIGEST.update(bytes, 0, bytes.length);
        byte[] result = new byte[SM3_DIGEST.getDigestSize()];
        SM3_DIGEST.doFinal(result, 0);
        return result;
    }

    /**
     * 加密hash，带密钥
     *
     * @param bytes 加密数据
     * @param key 密钥
     * @return
     */
    private static byte[] toBigEndianWithKey(byte[] bytes, byte[] key) {
        KeyParameter keyParameter = new KeyParameter(key);
        HMAC.init(keyParameter);
        HMAC.update(bytes, 0, bytes.length);
        byte[] result = new byte[SM3_DIGEST.getDigestSize()];
        HMAC.doFinal(result, 0);
        return result;
    }


}
