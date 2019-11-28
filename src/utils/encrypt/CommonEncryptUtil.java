package utils.encrypt;

/**
 * 处理加密解密过程中的通用工具
 * @author Tea0b0001
 * 2019/11/28
 */
public class CommonEncryptUtil {
    /**
     * 字节数据转HexString
     *
     * @param bytes 加密数据
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for(byte b : bytes){
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static byte[] hexStringToBytes(String hexString) {
        int hexlen = hexString.length();
        byte[] result;
        if (hexlen % 2 == 1){
            hexlen++;
            result = new byte[(hexlen / 2)];
            hexString = "0"+hexString;
        }else {
            result = new byte[(hexlen / 2)];
        }
        int j=0;
        for (int i = 0; i < hexlen; i += 2){
            result[j] = (byte)Integer.parseInt(hexString.substring(i, i + 2),16);
            j++;
        }
        return result;
    }
}
