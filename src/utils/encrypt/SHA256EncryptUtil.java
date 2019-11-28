package utils.encrypt;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * SHA256加密工具类
 * @author Tea0b0001
 * 2019/11/28
 */
public class SHA256EncryptUtil {

    /**
     * 加密，加盐
     * @param str 加密数据
     * @param salt 盐
     * @return
     */
    public static String encrypt(String str, String salt) {
        return DigestUtils.sha256Hex(str + salt);
    }

    /**
     * 加密
     * @param str 加密数据
     * @return
     */
    public static String encrypt(String str) {
        return DigestUtils.sha256Hex(str);
    }

    /**
     * 加密
     * @param bytes 加密数据
     * @return
     */
    public static String encrypt(byte[] bytes) {
        return DigestUtils.sha256Hex(bytes);
    }
}
