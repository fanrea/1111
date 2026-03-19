package com.luck.picture.lib.entity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MediaExtraInfo {
    private long duration;
    private int height;
    private String orientation;
    private String videoThumbnail;
    private int width;

    public String getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public void setVideoThumbnail(String str) {
        this.videoThumbnail = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public String toString() {
        return "MediaExtraInfo{videoThumbnail='" + this.videoThumbnail + "', width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", orientation='" + this.orientation + "'}";
    }
}
