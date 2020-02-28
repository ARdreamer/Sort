package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelDemo {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
    }
}
