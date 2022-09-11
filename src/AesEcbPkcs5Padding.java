import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesEcbPkcs5Padding {
    public static final String KEY_ALGORITHM = "AES";
//    public static final String CIPHER_ALGORITHM_CBC = "AES/CBC/NoPadding";
    private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        String resource1 = "wmZRpUQHB5JcaY7EefKzWg==";
        String resource2 = "2eImCLyK/GxaJkQs2xD+cg==";
        decryptAESString_test(resource1);
        decryptAESString_test(resource2);
    }

    public static boolean decryptAESString_test(String ori_encryped_str) throws Exception {
        String key = "3SmxQZf44wDdXrKSEzgkyQAvNpp824og";

        System.out.println("解密前：" + ori_encryped_str);
        String result = decryptData(ori_encryped_str, key.getBytes("utf-8"));
//        //此处添加解密操作
//        String result2 = aesCBCDecrypt(result);
        System.out.println("解密后：" + result);
        return true;
    }
    public static String decryptData(String base64Data, byte[] key) throws Exception{
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, KEY_ALGORITHM));
        final Base64 base64 = new Base64();
        return new String(cipher.doFinal(base64.decode(base64Data.getBytes("utf-8"))));
    }

}