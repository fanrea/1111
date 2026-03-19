package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private TextView lR;
    private long lT;
    private o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            b.this.k(j2);
        }
    };
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(R.id.ksad_detail_call_btn);
        this.lR = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        this.mApkDownloadHelper = this.vb.mApkDownloadHelper;
        this.lT = com.kwad.sdk.core.response.b.d.eA(this.mAdTemplate);
        this.vb.tu.a(this.lv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lv);
        this.lR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        if (j >= this.lT) {
            ds();
        }
    }

    private void ds() {
        if (this.lR.getVisibility() == 0) {
            return;
        }
        this.lR.setText(com.kwad.sdk.core.response.b.d.eB(this.mAdTemplate));
        this.lR.setVisibility(0);
        this.lR.setOnClickListener(this);
        this.lR.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                b.this.dt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt() {
        this.vb.F("native_id");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.lR) {
            this.vb.a(1, view.getContext(), 40, 1, this.vb.tu.getPlayDuration());
        }
    }
}
