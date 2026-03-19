package com.kwad.components.ct.horizontal.video.b.c;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.horizontal.video.c;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.lib.widget.a.d;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.horizontal.video.b.b.a {
    private d aFW;
    private c aOE = new c() { // from class: com.kwad.components.ct.horizontal.video.b.c.a.1
        @Override // com.kwad.components.ct.horizontal.video.c
        public final void A(CtAdTemplate ctAdTemplate) {
            a.this.I(ctAdTemplate);
        }
    };
    private View aPh;
    private View aPi;
    private TextView aPj;
    private TextView aPk;
    private ImageView aPl;

    @Override // com.kwad.components.ct.horizontal.video.b.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aFW = ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aFW;
        if (((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD != null) {
            ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD.a(this.aOE);
        }
        I(((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD != null) {
            ((com.kwad.components.ct.horizontal.video.b.b.b) this.cck).aLD.b(this.aOE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(CtAdTemplate ctAdTemplate) {
        if (this.aPh == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.ksad_horizontal_detail_related_header_layout, (ViewGroup) null);
            this.aPh = viewInflate;
            this.aPj = (TextView) viewInflate.findViewById(R.id.ksad_horizontal_detail_video_related_header_desc);
            this.aPi = this.aPh.findViewById(R.id.ksad_horizontal_detail_video_related_header_desc_layout);
            this.aPk = (TextView) this.aPh.findViewById(R.id.ksad_horizontal_detail_video_related_header_date);
            this.aPl = (ImageView) this.aPh.findViewById(R.id.ksad_horizontal_detail_video_related_header_arrow);
        }
        if (!this.aFW.ae(this.aPh)) {
            this.aFW.addHeaderView(this.aPh);
        }
        if (ctAdTemplate == null) {
            return;
        }
        J(ctAdTemplate);
        a(this.aPh, ctAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(final CtAdTemplate ctAdTemplate) {
        this.aPj.setMaxLines(100);
        final String strAN = com.kwad.components.ct.response.a.a.aN(ctAdTemplate);
        if (TextUtils.isEmpty(strAN)) {
            this.aPi.setVisibility(8);
        } else {
            this.aPi.setVisibility(0);
        }
        this.aPj.setText(com.kwad.components.ct.response.a.a.aN(ctAdTemplate));
        this.aPj.post(new bh() { // from class: com.kwad.components.ct.horizontal.video.b.c.a.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                int lineCount = a.this.aPj.getLineCount();
                if (lineCount == 0 && !TextUtils.isEmpty(strAN)) {
                    a.this.aPj.postDelayed(new Runnable() { // from class: com.kwad.components.ct.horizontal.video.b.c.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.J(ctAdTemplate);
                        }
                    }, 100L);
                    return;
                }
                if (lineCount > 1) {
                    a.this.aPj.setMaxLines(1);
                    a.this.aPl.setRotation(180.0f);
                    a.this.aPl.setVisibility(0);
                    a.this.aPj.setText(com.kwad.components.ct.response.a.a.aN(ctAdTemplate));
                    a.this.aPi.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.b.c.a.2.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            if (a.this.aPj.getLineCount() > 1) {
                                com.kwad.components.ct.e.b.JK().ah(ctAdTemplate);
                                a.this.aPj.setMaxLines(1);
                                a.this.aPl.setRotation(180.0f);
                            } else {
                                com.kwad.components.ct.e.b.JK().ag(ctAdTemplate);
                                a.this.aPj.setMaxLines(100);
                                a.this.aPl.setRotation(0.0f);
                            }
                            a.this.aPj.setText(com.kwad.components.ct.response.a.a.aN(ctAdTemplate));
                        }
                    });
                    return;
                }
                a.this.aPl.setRotation(0.0f);
                a.this.aPl.setVisibility(4);
                a.this.aPi.setOnClickListener(null);
            }
        });
        this.aPk.setText(bq.bJ(com.kwad.components.ct.response.a.c.p((PhotoInfo) ctAdTemplate.photoInfo)) + "发布");
    }

    private void a(View view, final CtAdTemplate ctAdTemplate) {
        if (e.XN()) {
            View viewFindViewById = view.findViewById(R.id.ksad_photo_debug_view);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ct.horizontal.video.b.c.a.3
                int aPo;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        int i = this.aPo + 1;
                        this.aPo = i;
                        if (i > 10) {
                            String str = "did:" + be.getDeviceId();
                            CtAdTemplate ctAdTemplate2 = ctAdTemplate;
                            if (ctAdTemplate2 != null) {
                                str = str + "\r\nphotoId:" + com.kwad.components.ct.response.a.c.j((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate2));
                            }
                            o.a(a.this.getContext(), "ksad_debug_deviceId_and_gid", str + "\r\negid:" + ag.aoE());
                            ac.ae(a.this.getContext(), "hello");
                            this.aPo = 0;
                        }
                    }
                    return false;
                }
            });
        }
    }
}
