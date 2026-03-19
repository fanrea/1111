package com.kwad.components.ct.home.d.b;

import android.view.View;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.home.d.a.a implements View.OnClickListener {
    private View aKR;
    private com.kwad.components.ct.home.d.b aKS;
    private View aKU;
    private View aKV;
    private View aKW;
    private CtAdTemplate aKX;
    private com.kwad.components.ct.home.d.a aKY = new com.kwad.components.ct.home.d.a() { // from class: com.kwad.components.ct.home.d.b.c.1
        @Override // com.kwad.components.ct.home.d.a
        public final void cu(int i) {
            if (c.this.mCurrentPosition == i) {
                c.this.aKV.setSelected(true);
                if (c.this.aKS.GY() == null) {
                    c.this.aKW.setVisibility(8);
                    return;
                } else {
                    c.this.aKW.setSelected(!r3.isPlaying());
                    return;
                }
            }
            c.this.aKV.setSelected(false);
            c.this.aKW.setVisibility(8);
        }

        @Override // com.kwad.components.ct.home.d.a
        public final void a(int i, View view, boolean z) {
            c.this.aKR = view;
            if (c.this.mCurrentPosition == i) {
                c.this.aKW.setSelected(!z);
                c.this.aKW.setVisibility(0);
            } else {
                c.this.aKW.setVisibility(8);
            }
        }
    };
    private SlidePlayViewPager aok;
    private int mCurrentPosition;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aKU = findViewById(R.id.ksad_slide_profile_container);
        this.aKV = findViewById(R.id.ksad_slide_profile_selected);
        this.aKW = findViewById(R.id.ksad_slide_profile_video_play_btn);
        this.aKU.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = ((com.kwad.components.ct.home.d.a.b) this.cdN).aok;
        this.aKR = ((com.kwad.components.ct.home.d.a.b) this.cdN).aKR;
        this.mCurrentPosition = ((com.kwad.components.ct.home.d.a.b) this.cdN).mCurrentPosition;
        this.aKX = (CtAdTemplate) ((com.kwad.components.ct.home.d.a.b) this.cdN).cdM;
        com.kwad.components.ct.home.d.b bVar = ((com.kwad.components.ct.home.d.a.b) this.cdN).aKS;
        this.aKS = bVar;
        if (this.aKX == bVar.GX()) {
            this.aKV.setSelected(true);
            if (this.aKS.GY() == null) {
                this.aKW.setVisibility(8);
            } else {
                this.aKW.setSelected(!r0.isPlaying());
                this.aKW.setVisibility(0);
            }
        } else {
            this.aKV.setSelected(false);
            this.aKW.setVisibility(8);
        }
        this.aKS.GZ().add(this.aKY);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aKS.GZ().remove(this.aKY);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.aKU) {
            if (this.aKX != this.aKS.GX()) {
                this.aok.i(this.aKX);
            } else {
                View view2 = this.aKR;
                if (view2 != null) {
                    view2.performClick();
                }
            }
            By();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void By() {
        com.kwad.components.ct.e.b.JK().d((CtAdTemplate) ((com.kwad.components.ct.home.d.a.b) this.cdN).cdM, 1);
    }
}
