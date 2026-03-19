package com.kwad.components.ct.detail.photo.newui.c;

import android.view.MotionEvent;
import android.view.View;
import com.kwad.components.ct.response.a.c;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.newui.c.a.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            a.a(a.this, 0);
        }
    };
    private View aui;
    private int auj;

    static /* synthetic */ int a(a aVar) {
        int i = aVar.auj;
        aVar.auj = i + 1;
        return i;
    }

    static /* synthetic */ int a(a aVar, int i) {
        aVar.auj = 0;
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewFindViewById = findViewById(R.id.ksad_photo_debug_view);
        this.aui = viewFindViewById;
        viewFindViewById.setVisibility(0);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoq.add(this.aoQ);
        this.aui.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ct.detail.photo.newui.c.a.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.a(a.this);
                    if (a.this.auj > 10) {
                        String str = "did:" + be.getDeviceId();
                        if (a.this.aop.mAdTemplate != null) {
                            str = str + "\r\nphotoId:" + c.j((PhotoInfo) com.kwad.components.ct.response.a.a.ay(a.this.aop.mAdTemplate));
                        }
                        o.a(a.this.getContext(), "ksad_debug_deviceId_and_gid", str + "\r\negid:" + ag.aoE());
                        ac.ae(a.this.getContext(), "hello");
                        a.a(a.this, 0);
                    }
                }
                return false;
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
    }
}
