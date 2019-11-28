package utils.encrypt;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密
 * @author Tea0b0001
 * 2019/11/28
 */
public class MD5EncryptUtil {

    /**
     * 加密，
     *
     * @param str 加密数据
     * @param salt 盐
     * @return
     */
    public static String encrypt(String str, String salt) {
        return DigestUtils.md5Hex(str + salt);
    }

    /**
     * 加密
     *
     * @param str 加密数据
     * @return
     */
    public static String encrypt(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * 加密
     *
     * @param bytes 加密数据
     * @return
     */
    public static String encrypt(byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }
}
