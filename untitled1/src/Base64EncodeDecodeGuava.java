import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.io.BaseEncoding;
import org.apache.commons.codec.binary.Base32OutputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
@Beta
@GwtCompatible(emulated=true)
public class Base64EncodeDecodeGuava {

    private static String sampleText = "Do, or do Not. There is no try.";
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static void main(String[] args) {
 //       encodingDecodingGuava();
 //       encodingDecodingGuavaUTF();
    }
    @GwtIncompatible(value="Writer,OutputStream")
    public static void encXML(){
        try {
            InputStream in1= new FileInputStream("E:\\Go1\\untitled1\\src\\xml.xml");


       //    BaseEncoding.base32().encodingStream(new FileOutputStream("1.txt"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void encodingDecodingGuava() {
        // --- Encode Data---
        String encodedText = BaseEncoding.base64()
                .encode(sampleText.getBytes());

        // ---Decode Data---
        byte[] decoded =  BaseEncoding.base64().decode(encodedText);
        String decodedText =  new String(decoded);

        System.out.println("Base64 Encoding/Decoding - Guava");
        System.out.println("--------------------------------");
        System.out.println("SampleText......: " + sampleText);
        System.out.println("EncodedText.....: " + encodedText);
        System.out.println("DecodedText.....: " + decodedText);
        System.out.println();
    }

    public static void encodingDecodingGuavaUTF() {
        // --- Encode Data---
        String encodedText = BaseEncoding.base64()
                .encode(sampleText.getBytes(UTF_8));

        // ---Decode Data---
        byte[] decoded =  BaseEncoding.base64().decode(encodedText);
        String decodedText =  new String(decoded, UTF_8);

        System.out.println("Base64 Encoding/Decoding - Guava (UTF-8)");
        System.out.println("----------------------------------------");
        System.out.println("SampleText......: " + sampleText);
        System.out.println("EncodedText.....: " + encodedText);
        System.out.println("DecodedText.....: " + decodedText);
        System.out.println();
    }
}