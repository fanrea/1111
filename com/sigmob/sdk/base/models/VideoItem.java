package com.sigmob.sdk.base.models;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VideoItem {
    public final int height;
    public final String url;
    public final int width;

    public VideoItem(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return "\"video\":{\"url\"=\"" + this.url + "\", \"width\"=" + this.width + ", \"height\"=" + this.height + '}';
    }
}
