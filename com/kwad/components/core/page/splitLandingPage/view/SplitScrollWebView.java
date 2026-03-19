package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.u.e;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int WL;
    private boolean Xj;
    private a Xk;
    private float Xl;
    private boolean Xm;

    public interface a {
        void f(float f);

        boolean rY();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Xj = false;
        rS();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xj = false;
        rS();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xj = false;
        rS();
    }

    public void setDisableAnimation(boolean z) {
        this.Xj = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Xk = aVar;
    }

    private void rS() {
        this.WL = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.WL != 0) {
            int statusBarHeight = e.tv() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.p((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.WL, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (this.Xj) {
            return super.onTouchEvent(motionEventObtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.Xl = y;
            this.Xm = false;
            return super.onTouchEvent(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float f = this.Xl;
                float f2 = f - y;
                a aVar = this.Xk;
                if (aVar != null && y <= f) {
                    this.Xm = true;
                    aVar.f(f2);
                }
                return super.onTouchEvent(motionEventObtain);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        a aVar2 = this.Xk;
        if (aVar2 == null) {
            return false;
        }
        if ((this.Xl - y < 0.0f && !this.Xm) || !aVar2.rY()) {
            return false;
        }
        this.Xj = true;
        return false;
    }
}
