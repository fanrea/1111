package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l extends TextureView {
    protected static final String a = "ResizeTextureView";
    public int b;
    public int c;

    public l(Context context) {
        super(context);
        this.b = 0;
        this.c = 0;
    }

    public l(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.b = 0;
        this.c = 0;
    }

    public void a(int currentVideoWidth, int currentVideoHeight) {
        if (this.b == currentVideoWidth && this.c == currentVideoHeight) {
            return;
        }
        this.b = currentVideoWidth;
        this.c = currentVideoHeight;
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f5, code lost:
    
        if (r2 > r12) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f7, code lost:
    
        r2 = (r12 * r4) / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010a, code lost:
    
        if (r2 > r12) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0148  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoplayer.l.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float rotation) {
        if (rotation != getRotation()) {
            super.setRotation(rotation);
            requestLayout();
        }
    }
}
