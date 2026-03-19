package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.bytedance.sdk.djx.utils.UIUtil;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AlignCenterImageSpan extends ImageSpan {
    private WeakReference<Drawable> mDrawableRef;

    public AlignCenterImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - ((cachedDrawable.getBounds().bottom + cachedDrawable.getBounds().top) / 2);
        canvas.save();
        canvas.translate(f, i6);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        drawable2.setBounds(0, 0, UIUtil.dp2px(36.0f), UIUtil.dp2px(14.0f));
        this.mDrawableRef = new WeakReference<>(drawable2);
        return drawable2;
    }
}
