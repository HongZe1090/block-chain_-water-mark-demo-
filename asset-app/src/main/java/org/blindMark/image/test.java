package org.blindMark.image;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.blindMark.image.converter.DctConverter;
import org.blindMark.image.converter.Converter;
import org.blindMark.image.dencoder.Decoder;
import org.blindMark.image.dencoder.Encoder;
import org.blindMark.image.dencoder.ImageEncoder;


public class test {

        private static final String SRC = "img/Clientsendimage/1.jpg";
        private static final String TEXT_WM = "测试test";
        private static final String IMAGE_WM = "img/Clientsendimage/watermark.png";

        static {
            Loader.load(opencv_java.class);
        }


        public static void main(String[] args) throws Exception {
            Converter converter = new DctConverter();
            Encoder encoder = new ImageEncoder(converter);
            Decoder decoder = new Decoder(converter);
            encoder.encode(SRC, IMAGE_WM, "img/Servertempimage/img.jpg");
//        decoder.decode("image/gakki-dct-img-ec.jpg", "image/gakki-dct-img-dc.jpg");
        }
}
