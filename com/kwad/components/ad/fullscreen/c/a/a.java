package com.kwad.components.ad.fullscreen.c.a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.cb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements cb.a {
    private cb dC;
    private TextView lM;
    private View lN;
    private boolean lO;
    private long lP;
    private o lv = new o() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.j
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.lO) {
                return;
            }
            a.this.dC.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (!a.this.vb.tu.la()) {
                a.this.a(j, j2);
                a.this.lP = j2;
            } else if (j2 > 800) {
                a.this.lP = j2;
                if (a.this.lP > j) {
                    a.this.lM.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.lN.getLayoutParams();
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(a.this.getContext(), 0.0f);
                    a.this.lN.setLayoutParams(marginLayoutParams);
                }
                a.this.a(j, j2);
                a.a(a.this, true);
            }
        }
    };
    private AdInfo mAdInfo;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.lO = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lM = (TextView) findViewById(R.id.ksad_video_count_down);
        this.lN = findViewById(R.id.ksad_video_sound_switch);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.dC = new cb(this);
        dr();
        if (this.vb.tu.la()) {
            G(30);
        }
    }

    private void dr() {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        this.mAdInfo = adInfoEP;
        this.lM.setText(String.valueOf(com.kwad.sdk.core.response.b.a.M(adInfoEP)));
        this.lM.setVisibility(0);
        this.vb.tu.a(this.lv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lv);
        this.lO = false;
        this.dC.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        int i = (int) (((j - j2) / 1000.0f) + 0.5f);
        if (i <= 0) {
            i = 1;
        }
        G(i);
    }

    private void G(int i) {
        this.lM.setText(String.valueOf(i));
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.vb.gZ() || this.vb.gY()) {
                this.dC.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            long j = this.lP + 500;
            this.lP = j;
            if (j > 30000) {
                this.lM.setVisibility(8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lN.getLayoutParams();
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 0.0f);
                this.lN.setLayoutParams(marginLayoutParams);
                return;
            }
            a(30000L, j);
            this.dC.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
