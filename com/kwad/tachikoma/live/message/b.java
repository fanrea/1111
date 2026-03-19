package com.kwad.tachikoma.live.message;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class b extends al {
    private boolean CX;
    private boolean CY;
    private boolean CZ;
    private boolean Da;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (Build.MANUFACTURER.toLowerCase(Locale.US).contains("meitu")) {
            return;
        }
        setVerticalFadingEdgeEnabled(this.CX || this.CY);
        setHorizontalFadingEdgeEnabled(this.CZ || this.Da);
    }

    public void setEnableRightFadingEdge(boolean z) {
        this.Da = z;
    }

    public void setEnableTopFadingEdge(boolean z) {
        this.CX = z;
    }

    public void setEnableBottomFadingEdge(boolean z) {
        this.CY = z;
    }

    public void setEnableLeftFadingEdge(boolean z) {
        this.CZ = z;
    }

    protected float getTopFadingEdgeStrength() {
        if (this.CX) {
            return super.getTopFadingEdgeStrength();
        }
        return 0.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (this.CY) {
            return super.getBottomFadingEdgeStrength();
        }
        return 0.0f;
    }

    protected float getLeftFadingEdgeStrength() {
        if (this.CZ) {
            return super.getLeftFadingEdgeStrength();
        }
        return 0.0f;
    }

    protected float getRightFadingEdgeStrength() {
        if (this.Da) {
            return super.getRightFadingEdgeStrength();
        }
        return 0.0f;
    }
}
