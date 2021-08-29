package org.blindMark.image.dencoder;

import org.blindMark.image.converter.Converter;
import org.blindMark.image.util.Utils;
import org.opencv.core.Mat;

import static org.opencv.core.CvType.CV_8U;

/**
 * @author ww23
 */
public class ImageEncoder extends Encoder {

    public ImageEncoder(Converter converter) {
        super(converter);
    }

    @Override
    public void addWatermark(Mat com, String watermark) {
        this.converter.addImageWatermark(com, Utils.read(watermark, CV_8U));
    }
}
