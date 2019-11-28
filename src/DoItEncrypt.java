import utils.encrypt.CommonEncryptUtil;

public class DoItEncrypt {

    public static void main(String... args) {
        String str = CommonEncryptUtil.bytesToHexString("jiovdava".getBytes());
        System.out.println(str);
        byte[] bytes = CommonEncryptUtil.hexStringToBytes(str);
        System.out.println(new String(bytes));
    }
}
