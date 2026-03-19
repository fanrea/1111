package com.kwad.sdk.glide.webp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public final boolean blendPreviousFrame;
    public final int cax;
    public final int cay;
    public final int caz;
    public final boolean disposeBackgroundColor;
    public final int duration;
    public final int height;
    public final int width;

    c(int i, WebpFrame webpFrame) {
        this.cax = i;
        this.cay = webpFrame.getXOffest();
        this.caz = webpFrame.getYOffest();
        this.width = webpFrame.getWidth();
        this.height = webpFrame.getHeight();
        this.duration = webpFrame.getDurationMs();
        this.blendPreviousFrame = webpFrame.isBlendWithPreviousFrame();
        this.disposeBackgroundColor = webpFrame.shouldDisposeToBackgroundColor();
    }

    public final String toString() {
        return "frameNumber=" + this.cax + ", xOffset=" + this.cay + ", yOffset=" + this.caz + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", blendPreviousFrame=" + this.blendPreviousFrame + ", disposeBackgroundColor=" + this.disposeBackgroundColor;
    }
}
