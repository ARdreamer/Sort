package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Write {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "Some bytes".getBytes();
        FileOutputStream os = new FileOutputStream("G:\\JavaSource\\SchoolOffer\\src\\nio\\a.txt");
        FileChannel channel = os.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for (byte b : bytes) {
            buffer.put(b);
        }
        buffer.flip();
        channel.write(buffer);
        channel.close();
        os.close();
    }
}
