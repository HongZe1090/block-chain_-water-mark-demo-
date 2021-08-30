package org.blindMark.image.converter;

import org.opencv.core.Mat;

public interface Converter {
    Mat start(Mat src);
    void inverse(Mat com);
    void addTextWatermark(Mat com, String watermark);
    void addImageWatermark(Mat com, Mat watermark);
    Mat showWatermark(Mat src);
}
