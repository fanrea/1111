package com.tachikoma.lottie;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h {
    private final String HG;
    private final String HH;
    private Bitmap HI;
    private final String fileName;
    private final int height;
    private final int width;

    public h(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.HG = str;
        this.fileName = str2;
        this.HH = str3;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.HG;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String jL() {
        return this.HH;
    }

    public final Bitmap getBitmap() {
        return this.HI;
    }

    public final void setBitmap(Bitmap bitmap) {
        this.HI = bitmap;
    }
}
