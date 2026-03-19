package com.kwad.components.ct.detail.photo.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.components.ct.request.n;
import com.kwad.components.ct.response.model.home.PhotoShareInfo;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends a<LinearLayout> {
    private com.kwad.components.ct.detail.photo.e.c asO;
    public h asW;
    private boolean asX = false;
    private String asY = null;

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.asX = false;
        return false;
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.asW = this.asK.ati;
        this.asO = this.asK.asO;
        com.kwad.components.ct.e.b.JK().ao(this.asW.mAdTemplate);
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.asO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.e.d
    /* renamed from: Ae, reason: merged with bridge method [inline-methods] */
    public LinearLayout Ag() {
        return Ai();
    }

    private com.kwad.components.ct.detail.photo.newui.b.a Ai() {
        String strZc;
        final com.kwad.components.ct.detail.photo.newui.b.a aVar = new com.kwad.components.ct.detail.photo.newui.b.a(getContext());
        if (com.kwad.components.ct.f.d.Kb().wR() == 1) {
            strZc = com.kwad.components.ct.detail.a.b.zd();
        } else {
            strZc = com.kwad.components.ct.detail.a.b.zc();
        }
        int i = ((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj().aqA;
        if (!TextUtils.isEmpty(strZc)) {
            com.kwad.sdk.glide.c.cy(getContext()).afq().hh(strZc).d(getContext().getResources().getDrawable(i)).f(getContext().getResources().getDrawable(i)).b((com.kwad.sdk.glide.f) new com.kwad.sdk.glide.request.a.h<Bitmap>() { // from class: com.kwad.components.ct.detail.photo.d.e.1
                @Override // com.kwad.sdk.glide.request.a.j
                public final /* synthetic */ void onResourceReady(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
                    a((Bitmap) obj);
                }

                private void a(Bitmap bitmap) {
                    aVar.setButtonImageDrawable(new BitmapDrawable(bitmap));
                }
            });
        } else {
            aVar.setButtonImageResource(i);
        }
        aVar.setButtonText(com.kwad.components.ct.detail.a.b.zb());
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.asW == null) {
            return;
        }
        if (this.asX) {
            com.kwad.sdk.core.d.c.d("MediaShareButtonPresenter", "mIsRequesting=true");
        } else {
            this.asX = true;
            new com.kwad.components.ct.request.n().a(com.kwad.components.ct.response.a.a.bg(this.asW.mAdTemplate), 1, new n.a() { // from class: com.kwad.components.ct.detail.photo.d.e.2
                @Override // com.kwad.components.ct.request.n.a
                public final void onError(int i, String str) {
                    com.kwad.sdk.core.d.c.d("MediaShareButtonPresenter", "onError() code=" + i + " msg=" + str);
                    ac.ae(e.this.getContext(), "数据获取失败，请稍后重试");
                    if (e.this.asO != null) {
                        e.this.asO.b(e.this);
                    }
                    com.kwad.components.ct.e.b.JK().e(e.this.asW.mAdTemplate, false);
                    e.a(e.this, false);
                }

                @Override // com.kwad.components.ct.request.n.a
                public final void a(PhotoShareInfo photoShareInfo) {
                    com.kwad.sdk.core.d.c.d("MediaShareButtonPresenter", "onLoad() mediaShareItem=" + photoShareInfo.getMediaShareItem());
                    e.this.asY = photoShareInfo.getMediaShareItem();
                    if (e.this.asO != null) {
                        e.this.asO.b(e.this);
                    }
                    com.kwad.components.ct.e.b.JK().e(e.this.asW.mAdTemplate, true);
                    e.a(e.this, false);
                }
            });
        }
    }

    @Override // com.kwad.components.ct.detail.photo.d.a, com.kwad.components.ct.detail.photo.e.d
    public final Object getData() {
        return this.asY;
    }
}
