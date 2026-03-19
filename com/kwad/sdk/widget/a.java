package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends TextView {
    public a(Context context) {
        super(context);
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 3 && (drawable = compoundDrawables[2]) != null) {
            float fMeasureText = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
            int width = (int) (getWidth() - fMeasureText);
            if (getPaddingRight() != width) {
                setPadding(0, 0, width, 0);
            }
            canvas.translate((getWidth() - fMeasureText) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}
