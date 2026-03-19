package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSLinearLayout extends LinearLayout implements m {
    private final aj.a aDV;
    private m aNH;
    private k cpz;
    private final AtomicBoolean dD;
    private float mRatio;
    private l mViewRCHelper;

    private static float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public KSLinearLayout(Context context) {
        super(context);
        this.dD = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aDV = new aj.a();
        init(context, null);
    }

    public KSLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dD = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aDV = new aj.a();
        init(context, attributeSet);
    }

    public KSLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dD = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aDV = new aj.a();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = typedArrayObtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        k kVar = new k(this, this);
        this.cpz = kVar;
        kVar.dL(true);
        l lVar = new l();
        this.mViewRCHelper = lVar;
        lVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        wz();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        wz();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        wA();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        wA();
    }

    private void wz() {
        if (this.dD.getAndSet(false)) {
            ae();
        }
    }

    private void wA() {
        if (this.dD.getAndSet(true)) {
            return;
        }
        af();
    }

    protected void ae() {
        this.cpz.onAttachedToWindow();
    }

    protected void af() {
        this.cpz.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.cpz.f(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.cpz.aqS();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    public void setVisiblePercent(float f) {
        this.cpz.setVisiblePercent(f);
    }

    public void setViewVisibleListener(m mVar) {
        this.aNH = mVar;
    }

    public float getVisiblePercent() {
        return this.cpz.getVisiblePercent();
    }

    public final void aqP() {
        this.cpz.aqP();
    }

    public void E(View view) {
        m mVar = this.aNH;
        if (mVar != null) {
            mVar.E(view);
        }
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mViewRCHelper.setRadius(getRadius(f, f2, 0.0f, 0.0f));
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.aDV.ac(getWidth(), getHeight());
            this.aDV.p(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aDV.q(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public aj.a getTouchCoords() {
        return this.aDV;
    }
}
