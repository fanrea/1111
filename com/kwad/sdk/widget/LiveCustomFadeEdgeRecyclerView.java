package com.kwad.sdk.widget;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveCustomFadeEdgeRecyclerView extends aj {
    private boolean mEnableBottomFadingEdge;
    private boolean mEnableLeftFadingEdge;
    private boolean mEnableRightFadingEdge;
    private boolean mEnableTopFadingEdge;

    public LiveCustomFadeEdgeRecyclerView(Context context) {
        this(context, null);
    }

    public LiveCustomFadeEdgeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveCustomFadeEdgeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (Build.MANUFACTURER.toLowerCase(Locale.US).contains("meitu")) {
            return;
        }
        setVerticalFadingEdgeEnabled(this.mEnableTopFadingEdge || this.mEnableBottomFadingEdge);
        setHorizontalFadingEdgeEnabled(this.mEnableLeftFadingEdge || this.mEnableRightFadingEdge);
    }

    public void setEnableRightFadingEdge(boolean z) {
        this.mEnableRightFadingEdge = z;
    }

    public void setEnableTopFadingEdge(boolean z) {
        this.mEnableTopFadingEdge = z;
    }

    public void setEnableBottomFadingEdge(boolean z) {
        this.mEnableBottomFadingEdge = z;
    }

    public void setEnableLeftFadingEdge(boolean z) {
        this.mEnableLeftFadingEdge = z;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (this.mEnableTopFadingEdge) {
            return super.getTopFadingEdgeStrength();
        }
        return 0.0f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (this.mEnableBottomFadingEdge) {
            return super.getBottomFadingEdgeStrength();
        }
        return 0.0f;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        if (this.mEnableLeftFadingEdge) {
            return super.getLeftFadingEdgeStrength();
        }
        return 0.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        if (this.mEnableRightFadingEdge) {
            return super.getRightFadingEdgeStrength();
        }
        return 0.0f;
    }
}
