package de.daver.alyria.rogue.engine.image;

import java.awt.image.BufferedImage;

public enum ImageType {

    INT_ARGB(BufferedImage.TYPE_INT_ARGB),
    INT_RGB(BufferedImage.TYPE_INT_RGB),
    INT_BGR(BufferedImage.TYPE_INT_BGR),
    USHORT_565_RGB(BufferedImage.TYPE_USHORT_565_RGB),
    USHORT_555_RGB(BufferedImage.TYPE_USHORT_555_RGB),
    BYTE_GRAY(BufferedImage.TYPE_BYTE_GRAY),
    USHORT_GRAY(BufferedImage.TYPE_USHORT_GRAY),
    BYTE_BINARY(BufferedImage.TYPE_BYTE_BINARY),
    BYTE_INDEXED(BufferedImage.TYPE_BYTE_INDEXED);

    private final int code;

    ImageType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
