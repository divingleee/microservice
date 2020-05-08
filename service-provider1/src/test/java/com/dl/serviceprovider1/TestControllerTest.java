package com.dl.serviceprovider1;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TestControllerTest {

    @Test
    public void test1() throws Exception {
        String data = "7CJw7+Vjwwftfbu6qJpcyw0fjo/YtFWLPD0fSeUEMV7WeHV+5oS+QPxJlOwFDNE+b02qh4X90HGNNvbAyAd1MSexer+qTtLgorU3kPPpl6zJxCrJu5WkO8ZuDI5nLvg6tRijv/4lknqgE6UN62UvckNKozG7GbTVHPnLWWQnlfH9/qjf7awG1u19Wr4TrfbCIcMp6jjNRKuBdIF6DkH3ew==";
        String iv = "njhp+4P7glPvN8wZNwu1gA==";
        String key = "dEUsEwkJFLzTreaS8N1/fg==";

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] a = decoder.decode(data);
        byte[] b = decoder.decode(iv);
        byte[] c = decoder.decode(key);
        SecretKeySpec keySpec = new SecretKeySpec(c, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(b);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
        byte[] bytes = cipher.doFinal(a);
        String s = new String(bytes, "utf-8");
        System.out.println(s);

    }
}
