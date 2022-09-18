import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {
    // 获取md5加密算法对象
    private final static MessageDigest md;
    private final static char[] cs = { '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    static {
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getmd5(byte[] data) {
        byte[] bs = md.digest(data);
        StringBuilder sb = new StringBuilder();
        for (byte b : bs) {
            sb.append(cs[(b >> 4) & 0x0f]);
            sb.append(cs[b & 0x0f]);
        }
        return sb.toString();

    }

    public static boolean checkFileMD5_test(String tempLocalFilePath, String FileMD5) throws IOException {

        FileInputStream fis = new FileInputStream(tempLocalFilePath);
        byte [] buff;
        buff = fis.readAllBytes();

        String md5 = getmd5(buff);
        System.out.println(md5);
        if (md5.equalsIgnoreCase(FileMD5)) {
            return true;
        }
        return false;
    }

    //测试
    public static void main(String[] args) throws IOException {
        String FileMD5 = "4BCF2FFC1961E8A30AF6C8376E7D8BE4";
        String tempLocalFilePath = "C:\\\\Users\\\\lenovo\\\\Downloads\\\\test.bin\\";

        System.out.println("校验结果：" + checkFileMD5_test(tempLocalFilePath, FileMD5));

    }
}

