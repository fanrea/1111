package com.kwad.components.core.page.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends a {
    private View VO;
    private TextView VP;
    private int VQ;
    private Runnable VR = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (!com.kwad.components.core.s.a.sX().ta()) {
                if (d.this.VQ > 0) {
                    d.this.VP.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.VQ)));
                    d.c(d.this);
                    com.kwad.components.core.s.a.sX().be(d.this.VQ);
                    bx.runOnUiThreadDelay(this, 1000L);
                    return;
                }
                d.this.VP.setText("已获得权益");
                bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.VO.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.s.a.sX().aP(true);
                return;
            }
            bx.runOnUiThreadDelay(this, 500L);
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i = dVar.VQ;
        dVar.VQ = i - 1;
        return i;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.VO = findViewById(R.id.ksad_web_reward_task_layout);
        this.VP = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.VQ = com.kwad.sdk.core.response.b.a.aQ(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate));
        com.kwad.components.core.s.a.sX().be(this.VQ);
        ry();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bx.d(this.VR);
    }

    private void ry() {
        TextView textView;
        if (this.VO == null || (textView = this.VP) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.VQ)));
        this.VO.setVisibility(0);
        bx.runOnUiThreadDelay(this.VR, 1000L);
    }
}
