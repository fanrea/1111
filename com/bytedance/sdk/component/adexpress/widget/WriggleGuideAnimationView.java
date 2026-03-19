package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.adexpress.dynamic.b.tc;
import com.bytedance.sdk.component.utils.de;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WriggleGuideAnimationView extends LinearLayout {
    private LinearLayout an;
    private de b;
    private TextView c;
    public int d;
    private tc gb;
    private LottieAnimationView h;
    private TextView hc;
    private boolean tt;
    private d u;

    public interface d {
        void d();
    }

    public WriggleGuideAnimationView(Context context, View view, tc tcVar, boolean z, int i) {
        super(context);
        this.gb = tcVar;
        this.tt = z;
        this.d = i;
        d(context, view);
    }

    private void d(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.an = (LinearLayout) findViewById(2097610722);
        this.hc = (TextView) findViewById(2097610719);
        this.c = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.h = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.h.setImageAssetsFolder("images/");
        this.h.d(true);
    }

    public void setShakeText(String str) {
        this.c.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.an;
    }

    public View getWriggleProgressIv() {
        return this.h;
    }

    public TextView getTopTextView() {
        return this.hc;
    }

    public void setOnShakeViewListener(d dVar) {
        this.u = dVar;
    }

    public void d() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.h.d();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.b == null) {
                this.b = new de(getContext().getApplicationContext(), 2, this.tt);
            }
            this.b.d(new de.d() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.de.d
                public void d(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.u != null) {
                        WriggleGuideAnimationView.this.u.d();
                    }
                }
            });
            if (this.gb != null) {
                this.b.hc(r0.b());
                this.b.an(this.gb.u());
                this.b.d(this.gb.an());
                this.b.hc(this.gb.gb());
            }
            this.b.d(this.d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        de deVar = this.b;
        if (deVar != null) {
            deVar.hc(this.d);
        }
        try {
            LottieAnimationView lottieAnimationView = this.h;
            if (lottieAnimationView != null) {
                lottieAnimationView.an();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        de deVar = this.b;
        if (deVar != null) {
            if (z) {
                deVar.d(this.d);
            } else {
                deVar.hc(this.d);
            }
        }
    }
}
