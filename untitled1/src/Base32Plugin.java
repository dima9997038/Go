


import org.apache.commons.codec.binary.Base32;
import java.io.*;
import java.util.Arrays;


public class Base32Plugin  {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\Go1\\untitled1\\src\\xml.xml"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("buff.txt"));
        (new Base32Plugin()).encode(in,outputStream);
        outputStream.close();
        BufferedInputStream inp = new BufferedInputStream(new FileInputStream("buff.txt"));
        BufferedOutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream("buff2.txt"));

        (new Base32Plugin()).decode(inp,outputStream2);



    }





    public void encode(InputStream in, OutputStream out) throws IOException {

        byte[] buffer = new byte[1024];
        int len;
        // read bytes from the input stream and store them in buffer
        while ((len = in.read(buffer)) != -1) {
            // write bytes from the buffer into output stream

           // byte[] buff = Arrays.copyOfRange(buffer, 0, len);
            Base32 base32 = new Base32();
            if (len<1024){
                buffer=Arrays.copyOf(buffer,len);
            }
            byte[] buff = base32.encode(buffer);

            out.write(buff, 0, buff.length);



        }
        out.flush();
        out.close();

    }

    public void decode(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1640];
        int len;
        // read bytes from the input stream and store them in buffer
        while ((len = in.read(buffer)) != -1) {
            // write bytes from the buffer into output stream
            //byte[] buff = Arrays.copyOfRange(buffer, 0, len);
//            String s = new String(buff);
//            buff = Base32.decode(s);
            Base32 base32 = new Base32();
            byte[] buff = base32.decode(buffer);
            out.write(buff, 0, buff.length);
        }
        out.close();

    }
}
