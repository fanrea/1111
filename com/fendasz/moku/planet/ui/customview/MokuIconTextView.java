package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuIconTextView extends AppCompatTextView {
    public MokuIconTextView(Context context) {
        super(context);
        init(context);
    }

    public MokuIconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MokuIconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setVisibility(4);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "moku_iconfont.ttf"));
    }
}
