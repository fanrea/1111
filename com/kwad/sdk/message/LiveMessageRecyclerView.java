package com.kwad.sdk.message;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.live.R;
import com.kwad.sdk.utils.LiveViewUtils;
import com.kwad.sdk.widget.LiveCustomFadeEdgeRecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveMessageRecyclerView extends LiveCustomFadeEdgeRecyclerView {
    private int mCustomFadingEdgeLength;
    private Matrix mCustomFadingEdgeMatrix;
    private Paint mCustomFadingEdgePaint;
    private Shader mCustomFadingEdgeShader;
    private int mCustomFadingEdgeTop;
    private int mMaxHeight;

    public LiveMessageRecyclerView(Context context) {
        this(context, null);
    }

    public LiveMessageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMessageRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mCustomFadingEdgePaint = new Paint();
        this.mCustomFadingEdgeShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, -16777216, 0, Shader.TileMode.CLAMP);
        this.mCustomFadingEdgePaint.setShader(this.mCustomFadingEdgeShader);
        this.mCustomFadingEdgePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.mCustomFadingEdgeMatrix = new Matrix();
        this.mCustomFadingEdgeLength = LiveViewUtils.dip2px(getContext(), 36.0f);
        updateLayerType();
        this.mMaxHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ksad_live_message_default_height);
    }

    public void setMathHeight(int i) {
        this.mMaxHeight = i;
        postInvalidate();
    }

    private void updateLayerType() {
        if (Build.VERSION.SDK_INT >= 21) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setCustomFadingEdgeTop(int i) {
        if (this.mCustomFadingEdgeTop == i || this.mCustomFadingEdgeLength <= 0) {
            return;
        }
        this.mCustomFadingEdgeTop = i;
        postInvalidate();
    }

    public int getCustomFadingEdgeTop() {
        return this.mCustomFadingEdgeTop;
    }

    public void setCustomFadingEdgeLength(int i) {
        this.mCustomFadingEdgeLength = i;
    }

    @Override // android.support.v7.widget.aj, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.mMaxHeight;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.support.v7.widget.aj, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = this.mMaxHeight;
        if (i > 0) {
            int height = i - getHeight();
            int i2 = this.mCustomFadingEdgeLength;
            if (i2 > height) {
                drawCustomFadingEdge(canvas, i2 - height);
                return;
            }
            return;
        }
        int height2 = getHeight();
        int i3 = this.mCustomFadingEdgeLength;
        if (height2 > i3 * 2) {
            drawCustomFadingEdge(canvas, i3);
        }
    }

    private void drawCustomFadingEdge(Canvas canvas, int i) {
        if (i <= 0) {
            return;
        }
        int i2 = this.mCustomFadingEdgeTop;
        int width = getWidth();
        this.mCustomFadingEdgeMatrix.setScale(1.0f, i);
        this.mCustomFadingEdgeMatrix.postTranslate(0.0f, i2);
        this.mCustomFadingEdgeShader.setLocalMatrix(this.mCustomFadingEdgeMatrix);
        this.mCustomFadingEdgePaint.setShader(this.mCustomFadingEdgeShader);
        canvas.drawRect(0.0f, 0.0f, width, i2 + i, this.mCustomFadingEdgePaint);
    }
}
