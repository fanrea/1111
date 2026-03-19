package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CloseCountDownView extends LinearLayout {
    private a Ki;
    private String LB;
    private int LC;
    private TextView LD;
    private TextView LE;
    private ImageView LF;
    private com.kwad.components.ad.splashscreen.widget.a LG;
    private Runnable LH;
    private boolean so;

    public interface a {
        void em();

        void mj();
    }

    static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i = closeCountDownView.LC;
        closeCountDownView.LC = i - 1;
        return i;
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.LB = "%ss";
        this.LC = 5;
        this.so = false;
        this.LH = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.so) {
                    if (CloseCountDownView.this.LC <= 0) {
                        if (CloseCountDownView.this.Ki != null) {
                            CloseCountDownView.this.Ki.mj();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.LC);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LB = "%ss";
        this.LC = 5;
        this.so = false;
        this.LH = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.so) {
                    if (CloseCountDownView.this.LC <= 0) {
                        if (CloseCountDownView.this.Ki != null) {
                            CloseCountDownView.this.Ki.mj();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.LC);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LB = "%ss";
        this.LC = 5;
        this.so = false;
        this.LH = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.so) {
                    if (CloseCountDownView.this.LC <= 0) {
                        if (CloseCountDownView.this.Ki != null) {
                            CloseCountDownView.this.Ki.mj();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.LC);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.LB = "%ss";
        this.LC = 5;
        this.so = false;
        this.LH = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.so) {
                    if (CloseCountDownView.this.LC <= 0) {
                        if (CloseCountDownView.this.Ki != null) {
                            CloseCountDownView.this.Ki.mj();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.LC);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    private void ah(Context context) {
        setOrientation(0);
        m.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.LD = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.LE = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.LF = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.Ki != null) {
                    CloseCountDownView.this.Ki.em();
                }
            }
        });
    }

    public final void bz() {
        fU();
    }

    public final void by() {
        fV();
    }

    public void setOnViewClickListener(a aVar) {
        this.Ki = aVar;
    }

    public final void a(AdInfo adInfo, float f) {
        com.kwad.components.ad.splashscreen.widget.a aVarAi;
        boolean zDB = com.kwad.sdk.core.response.b.a.dB(adInfo);
        if (zDB) {
            aVarAi = com.kwad.components.ad.splashscreen.widget.a.aj(getContext());
        } else {
            aVarAi = com.kwad.components.ad.splashscreen.widget.a.ai(getContext());
        }
        this.LG = aVarAi;
        aVarAi.setScale(f);
        boolean zCJ = com.kwad.sdk.core.response.b.a.cJ(adInfo);
        this.LC = com.kwad.sdk.core.response.b.a.cI(adInfo);
        if (zDB) {
            nr();
        }
        if (zCJ) {
            this.LD.setVisibility(0);
            this.LE.setVisibility(0);
            ap(this.LC);
            float fNt = this.LG.nt();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), fNt), 0, com.kwad.sdk.c.a.a.a(getContext(), fNt), 0);
        } else {
            float fNs = this.LG.ns();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), fNs), 0, com.kwad.sdk.c.a.a.a(getContext(), fNs), 0);
        }
        az();
    }

    private void nr() {
        ak.a(this, this.LG.mV());
        ak.a(this.LE, this.LG.nu());
        ak.a(this.LF, this.LG.nx());
        this.LD.setTextSize(0, this.LG.nv());
        this.LE.setTextSize(0, this.LG.nv());
        Drawable background = getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(this.LG.nw());
        }
    }

    public final void cv() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i) {
        this.LD.setText(String.format(this.LB, Integer.valueOf(i)));
    }

    private void az() {
        post(this.LH);
    }

    private void fU() {
        this.so = true;
    }

    private void fV() {
        this.so = false;
    }
}
