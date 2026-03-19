package com.fendasz.moku.planet.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.internal.view.SupportMenu;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TagSearchImageView extends View {
    private static final String TAG = "TagSearchImageView==>";
    private Rect leftRect;
    private int lineHeight;
    private Paint mPaint;
    private Rect rightRect;
    private Rect topRect;

    public TagSearchImageView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(SupportMenu.CATEGORY_MASK);
        initView();
    }

    public TagSearchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(SupportMenu.CATEGORY_MASK);
        initView();
    }

    private void initView() {
        this.lineHeight = (int) ((((int) Resources.getSystem().getDisplayMetrics().density) * 5) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect(0, 0, getWidth(), this.lineHeight);
        this.topRect = rect;
        canvas.drawRect(rect, this.mPaint);
        int i = this.lineHeight;
        Rect rect2 = new Rect(0, i, i, i + 5);
        this.leftRect = rect2;
        canvas.drawRect(rect2, this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Log.d(TAG, "---minimumHeight = " + getSuggestedMinimumHeight() + "");
    }
}
