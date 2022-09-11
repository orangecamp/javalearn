import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class changefile {

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

    public static boolean changefile_test(String tempLocalImagePath, String LocalFilePath) throws IOException {
        // 旧的文件或目录
        File oldName = new File(tempLocalImagePath);
        // 新的文件或目录
        File newName = new File(LocalFilePath);
        if (newName.exists()) {  //  确保新的文件名不存在
            throw new java.io.IOException("file exists");
        }
        if(oldName.renameTo(newName)) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) throws Exception {
        String ImageUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2Ff4%2F6c%2F1c%2Ff46c1c4d5dbee45fade6a85de81edba9.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1665212166&t=a6c7934f3ef732c6ba3a26acdc9a6d9b";
        String tempLocalImagePath = "D:\\000\\";
        String LocalImagePath = "D:\\0000\\";
        changefile.download(ImageUrl, tempLocalImagePath, "BootAdImage.jpg");
        System.out.println("替换结果：" + changefile_test(tempLocalImagePath,LocalImagePath));
    }

}