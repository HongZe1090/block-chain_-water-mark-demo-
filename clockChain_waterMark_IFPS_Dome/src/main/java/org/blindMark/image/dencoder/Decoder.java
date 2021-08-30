package org.blindMark.image.dencoder;

import org.blindMark.image.converter.Converter;
import org.blindMark.image.util.Utils;

import static org.opencv.core.CvType.CV_8U;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;

/**
 * @author ww23
 */
public class Decoder {

    private Converter converter;

    public Decoder(Converter converter) {
        this.converter = converter;
    }

    public Converter getConverter() {
        return converter;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    public void decode(String image, String output) {
        imwrite(output, this.converter.showWatermark(this.converter.start(Utils.read(image, CV_8U))));
    }
}
