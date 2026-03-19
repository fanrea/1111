package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.b {
    private Runnable LH;
    private a Lv;
    private final b Nk;
    private View Nl;
    private TextView Nm;
    private TextView Nn;
    private int No;
    private boolean so;
    private boolean xO;

    public interface a {
        void am(int i);

        void mi();

        void mj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i) {
        a aVar = this.Lv;
        if (aVar != null) {
            aVar.am(i);
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.Nk = new b((byte) 0);
        this.No = -1;
        this.so = false;
        this.xO = true;
        this.LH = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.so) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Nk);
                SkipView skipView2 = SkipView.this;
                skipView2.al(skipView2.Nk.Ns - SkipView.this.Nk.LC);
                if (SkipView.this.Nk.nG()) {
                    if (SkipView.this.Lv != null) {
                        SkipView.this.Lv.mj();
                    }
                } else {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.Nk);
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
        m.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.Nm = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.Nn = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.Nl = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.Lv != null) {
                    SkipView.this.Lv.mi();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.Nm != null) {
            if (bVar.Nq != null) {
                this.Nm.setText(bVar.Nq);
            }
            this.Nm.setVisibility(this.Nk.Nt ? 0 : 8);
        }
        String strNF = bVar.nF();
        TextView textView = this.Nn;
        if (textView != null) {
            if (strNF != null) {
                textView.setText(strNF);
            }
            this.Nn.setVisibility(this.Nk.Nu ? 0 : 8);
        }
        if (this.Nl != null) {
            boolean zNH = this.Nk.nH();
            this.Nl.setVisibility(zNH ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!zNH) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.No;
                if (i > 0) {
                    layoutParams.width = i;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bi(adInfo)) {
            return;
        }
        fU();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        if (this.xO) {
            nE();
        }
        if (com.kwad.sdk.core.response.b.a.bi(adInfo)) {
            return;
        }
        fV();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ao(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(a aVar) {
        this.Lv = aVar;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.xO = com.kwad.sdk.core.response.b.a.cR(adInfo);
        setTimerPrefixText(e.a(com.kwad.components.ad.splashscreen.b.a.HF));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bi(adInfo)) {
            az();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.cG(adInfo));
        setVisibility(8);
        C(adInfo);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void cv() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cS(adInfo));
    }

    public void setSkipBtnVisible(boolean z) {
        this.Nk.Nt = z;
        a(this.Nk);
    }

    public void setTimerBtnVisible(boolean z) {
        this.Nk.Nu = z;
        a(this.Nk);
    }

    public void setTimerPrefixText(String str) {
        this.Nk.Nr = str;
        a(this.Nk);
    }

    public void setTimerSecond(int i) {
        this.Nk.ar(i);
        a(this.Nk);
    }

    public void setSkipText(String str) {
        this.Nk.Nq = str;
        a(this.Nk);
    }

    public final void ae(String str) {
        if (str == null) {
            return;
        }
        this.Nk.ae(str);
        a(this.Nk);
    }

    private void az() {
        a(this.Nk);
        post(this.LH);
    }

    private void nE() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    private void fU() {
        this.so = true;
    }

    private void fV() {
        this.so = false;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.No = layoutParams.width;
    }

    static class b {
        private int LC;
        private String Nq;
        private String Nr;
        private int Ns;
        private boolean Nt;
        private boolean Nu;

        private b() {
            this.Nq = "跳过";
            this.Nr = "";
            this.Ns = 5;
            this.LC = 5;
            this.Nt = true;
            this.Nu = true;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        static /* synthetic */ int d(b bVar) {
            int i = bVar.LC;
            bVar.LC = i - 1;
            return i;
        }

        public final String nF() {
            int i = this.LC;
            if (i < 0) {
                return this.Nr;
            }
            if (i == 0) {
                return this.Nr + 1;
            }
            return this.Nr + this.LC;
        }

        public final boolean nG() {
            return this.LC <= 0;
        }

        public final void ar(int i) {
            this.Ns = i;
            this.LC = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean nH() {
            return this.Nt && this.Nu;
        }

        public final void ae(String str) {
            this.LC = -1;
            this.Nr = str;
        }
    }
}
