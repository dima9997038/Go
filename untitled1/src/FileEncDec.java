import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Base64;

public class FileEncDec
{
    public static void main(String[] args)
    {


        try (FileInputStream fis = new FileInputStream("E:\\Go1\\untitled1\\src\\xml.xml"))
        {
            String s="";
            byte[] buff = new byte[1024];
            fis.read(buff);
            s = Base58.encode(buff);
            System.out.println(s);

            Base64.Encoder enc1 = Base64.getEncoder();

            OutputStream os1 = enc1.wrap(new FileOutputStream("1.txt"));

            int _byte;
            while ((_byte = fis.read()) != -1)
            {
                os1.write(_byte);


            }
            os1.close();

        }
        catch (IOException ioe)
        {
            System.err.printf("I/O error: %s%n", ioe.getMessage());
        }
        try (FileOutputStream fos1 = new FileOutputStream("2.xml" );
             )
        {
            Base64.Decoder dec1 = Base64.getDecoder();

            InputStream is1 = dec1.wrap(new FileInputStream("1.txt"));

            int _byte;
            while ((_byte = is1.read()) != -1)
                fos1.write(_byte);

            is1.close();

        }
        catch (IOException ioe)
        {
            System.err.printf("I/O error: %s%n", ioe.getMessage());
        }
    }
}