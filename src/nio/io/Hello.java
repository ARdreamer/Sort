package nio.io;

import java.io.*;

public class Hello {
    public static void main(String[] args) throws IOException {
        File file = new File("G:\\JavaSource\\SchoolOffer\\src\\nio\\io\\hello.txt");
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
//        randomAccessFile.writeBoolean(true);
//        randomAccessFile.writeInt(123);
//        randomAccessFile.writeDouble(1.232);
//        randomAccessFile.close();
        OutputStream os = new FileOutputStream(file);
        os.write("123".getBytes());
        os.write(666);
        os.close();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    }
}
