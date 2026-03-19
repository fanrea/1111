package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends a {
    private LinearLayout VE;
    private TextView VF;
    private TextView VG;
    private TextView VH;
    private TextView VI;
    private int VJ;
    private boolean VK = false;
    private boolean VL = false;
    private Runnable VM = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (!c.this.VK) {
                if (c.this.VJ <= 0) {
                    c.this.VF.setText("任务已完成");
                    c.this.VG.setVisibility(8);
                    c.this.VH.setVisibility(8);
                    c.this.VI.setVisibility(8);
                    h hVar = (h) com.kwad.sdk.components.d.g(h.class);
                    if (hVar != null && !c.this.VL) {
                        hVar.notifyRewardVerify();
                    }
                } else {
                    c.this.rv();
                    bx.runOnUiThreadDelay(this, 1000L);
                }
                c.i(c.this);
                return;
            }
            bx.runOnUiThreadDelay(this, 500L);
        }
    };
    private final com.kwad.sdk.core.c.c Cf = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.c.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.VK = false;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.VK = true;
        }
    };

    static /* synthetic */ int i(c cVar) {
        int i = cVar.VJ;
        cVar.VJ = i - 1;
        return i;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.VE = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.VF = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.VG = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.VH = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.VI = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(this.Cf);
        this.VJ = com.kwad.sdk.core.config.e.Yp();
        ru();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.b(this.Cf);
        bx.d(this.VM);
    }

    private void ru() {
        this.VE.setVisibility(0);
        if (this.Vx.mAdTemplate.mRewardVerifyCalled) {
            this.VF.setText("任务已完成");
            this.VG.setVisibility(8);
            this.VH.setVisibility(8);
            this.VI.setVisibility(8);
            return;
        }
        rv();
        bx.runOnUiThreadDelay(this.VM, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        this.VG.setText(rw());
        this.VI.setText(rx());
    }

    private String rw() {
        int i = this.VJ / 60;
        if (i >= 10) {
            return new StringBuilder().append(i).toString();
        }
        return "0" + i;
    }

    private String rx() {
        int i = this.VJ % 60;
        if (i >= 10) {
            return new StringBuilder().append(i).toString();
        }
        return "0" + i;
    }
}
