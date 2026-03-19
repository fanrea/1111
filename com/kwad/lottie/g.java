package com.kwad.lottie;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private final String bkv;
    private Bitmap bkw;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    public g(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.bkv = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Bitmap getBitmap() {
        return this.bkw;
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bkw = bitmap;
    }
}
