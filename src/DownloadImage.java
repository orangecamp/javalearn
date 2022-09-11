import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {

    public static void main(String[] args) throws Exception {
        String ImageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Ff4%2F6c%2F1c%2Ff46c1c4d5dbee45fade6a85de81edba9.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665212166&t=a6c7934f3ef732c6ba3a26acdc9a6d9b";
        String tempLocalImagePath = "D:\\000\\";
        DownloadImage.download(ImageUrl, tempLocalImagePath, "BootAdImage.jpg");
        System.out.println("下载结果：" + downloadBootAdImage_test(ImageUrl, tempLocalImagePath));
    }

    public static boolean downloadBootAdImage_test(String ImageUrl, String tempLocalImagePath) throws Exception {
        if (DownloadImage.download(ImageUrl, tempLocalImagePath, "BootAdImage.jpg")) {
            return true;
        }
        return false;
    }

    public static boolean download(String Url, String tempLocalImagePath, String filename) {
        try {
            // 构造URL
            URL url = new URL(Url);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(tempLocalImagePath);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

