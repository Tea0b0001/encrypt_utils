package utils.encrypt;

import java.io.IOException;
import java.util.Base64;

/**
 * Base64加解密工具类
 * @author Tea0b0001
 * 2019/11/28
 */
public class Base64EncryptUtil {

    private static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();
    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();

    /**
     * 编码
     * @param str
     * @return
     */
    public static String encoder(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str cannot be bull");
        }

        return encoder(str.getBytes());
    }

    /**
     * 编码
     * @param src
     * @return
     */
    public static String encoder(byte[] src) {
        if (src == null) {
            throw new IllegalArgumentException("bytes cannot be bull");
        }

        return BASE64_ENCODER.encodeToString(src);
    }

    /**
     * 解码
     * @param code
     * @return
     * @throws IOException
     */
    public static String decoder(String code) throws IOException {
        return new String(BASE64_DECODER.decode(code));
    }

    /**
     * 解码
     * @param src
     * @return
     * @throws IOException
     */
    public static String decoder(byte[] src) throws IOException {
        return new String(BASE64_DECODER.decode(src));
    }
}
