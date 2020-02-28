package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketHandler implements Runnable {
    private SocketChannel socketChannel;

    SocketHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            int num;
            while ((num = socketChannel.read(byteBuffer)) > 0) {
                // 读取 Buffer 内容之前先 flip 一下
                byteBuffer.flip();

                byte[] bytes = new byte[num];
                byteBuffer.get(bytes);
                String re = new String(bytes, "UTF-8");
                System.out.println("收到请求：" + re);

                // 回应客户端
                ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + re).getBytes());
                socketChannel.write(writeBuffer);

                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
