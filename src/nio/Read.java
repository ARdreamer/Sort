package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Read {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("G:\\JavaSource\\SchoolOffer\\src\\nio\\a.txt");
        FileChannel channel = inputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int tmp = 0;
        while ((tmp = channel.read(buffer)) != -1) {
            System.out.println(new String(buffer.array()));
        }
        channel.close();
        inputStream.close();

    }
}
