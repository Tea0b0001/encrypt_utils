import utils.encrypt.MD5EncryptUtil;

public class DoItEncrypt {

    public static void main(String... args) {
        System.out.println(MD5EncryptUtil.encrypt("hello", "world"));
    }
}
