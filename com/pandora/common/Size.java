package com.pandora.common;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Size {
    private int height;
    private int width;

    public int getWidth() {
        return this.width;
    }

    public Size setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public Size setHeight(int height) {
        this.height = height;
        return this;
    }

    public Size(int w, int h) {
        this.width = w;
        this.height = h;
    }
}
