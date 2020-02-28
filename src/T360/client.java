package T360;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 4000);
        System.out.println("客户端启动");

        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        System.out.println(br.readLine());

        OutputStream os = socket.getOutputStream();
        System.out.println("请输入要下载的文件序号:");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        os.write(i);
        scan.close();

        BufferedReader br2 = new BufferedReader(new InputStreamReader(in));

        byte[] buf = new byte[1024];
        int len = 0;
        OutputStream out = new FileOutputStream("D:/Tests/本地下载目录/" + br2.readLine());
        while ((len = in.read(buf)) != 0) {
            out.write(buf, 0, len);
        }
        socket.close();
        out.close();
    }
}
