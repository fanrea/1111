package com.just.agentweb;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseIndicatorView extends FrameLayout implements BaseIndicatorSpec, LayoutParamsOffer {
    public BaseIndicatorView(Context context) {
        super(context);
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void hide() {
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void reset() {
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void setProgress(int i) {
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void show() {
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
