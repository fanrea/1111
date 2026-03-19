package com.ss.texturerender.math;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ColorConversion {
    public float[] matrix;
    public float[] offset;
    public static float[] matrix_Rec601_yuv_to_rgb_full = {1.0f, -0.0f, 1.402f, 1.0f, -0.344136f, -0.714136f, 1.0f, 1.772f, 0.0f};
    public static float[] matrix_Rec601_yuv_to_rgb_limit = {1.164384f, -0.0f, 1.596027f, 1.164384f, -0.391762f, -0.812968f, 1.164384f, 2.017232f, 0.0f};
    public static float[] matrix_Rec709_yuv_to_rgb_full = {1.0f, -0.0f, 1.5748f, 1.0f, -0.187324f, -0.468124f, 1.0f, 1.8556f, -0.0f};
    public static float[] matrix_Rec709_yuv_to_rgb_limit = {1.164384f, -0.0f, 1.792741f, 1.164384f, -0.213249f, -0.532909f, 1.164384f, 2.112402f, -0.0f};
    public static float[] matrix_BT2020_8bit_yuv_to_rgb_full = {1.0f, -0.0f, 1.4746f, 1.0f, -0.164553f, -0.571353f, 1.0f, 1.8814f, -0.0f};
    public static float[] matrix_BT2020_8bit_yuv_to_rgb_limite = {1.164384f, -0.0f, 1.678674f, 1.164384f, -0.187326f, -0.650424f, 1.164384f, 2.141772f, -0.0f};
    public static float[] matrix_BT2020_10bit_yuv_to_rgb_full = {1.0f, -0.0f, 1.4746f, 1.0f, -0.164553f, -0.571353f, 1.0f, 1.8814f, -0.0f};
    public static float[] matrix_BT2020_10bit_yuv_to_rgb_limite = {1.167808f, -0.0f, 1.683611f, 1.167808f, -0.187877f, -0.652337f, 1.167808f, 2.148072f, -0.0f};
    public static float[] offset_limite_8bit = {-0.062745f, -0.5f, -0.5f};
    public static float[] offset_limite_10bit = {-0.06256109f, -0.5f, -0.5f};
    public static float[] offset_full = {0.0f, -0.5f, -0.5f};

    public ColorConversion(float[] fArr, float[] fArr2) {
        this.matrix = fArr;
        this.offset = fArr2;
    }

    public static ColorConversion getFromDataspace(int i, int i2) {
        float[] fArr;
        int i3 = i & 3;
        int i4 = (i >> 2) & 63;
        if (i3 == 0 || i4 == 2 || i4 == 0) {
            return null;
        }
        ColorConversion colorConversion = new ColorConversion(null, null);
        if (i3 == 2) {
            colorConversion.offset = offset_full;
        } else {
            colorConversion.offset = i2 == 8 ? offset_limite_8bit : offset_limite_10bit;
        }
        if (i4 == 5 || i4 == 6) {
            colorConversion.matrix = i3 == 2 ? matrix_Rec601_yuv_to_rgb_full : matrix_Rec601_yuv_to_rgb_limit;
        } else if (i4 == 9 || i4 == 10) {
            if (i3 == 2) {
                fArr = i2 == 8 ? matrix_BT2020_8bit_yuv_to_rgb_full : matrix_BT2020_10bit_yuv_to_rgb_full;
            } else {
                fArr = i2 == 8 ? matrix_BT2020_8bit_yuv_to_rgb_limite : matrix_BT2020_10bit_yuv_to_rgb_limite;
            }
            colorConversion.matrix = fArr;
        } else {
            colorConversion.matrix = i3 == 2 ? matrix_Rec709_yuv_to_rgb_full : matrix_Rec709_yuv_to_rgb_limit;
        }
        return colorConversion;
    }
}
