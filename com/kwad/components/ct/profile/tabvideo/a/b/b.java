package com.kwad.components.ct.profile.tabvideo.a.b;

import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.profile.tabvideo.a.a.a {
    private ImageView awj;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awj = (ImageView) findViewById(R.id.ksad_profile_video_img);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).cdM;
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        String strA = com.kwad.components.ct.response.a.c.a(ctPhotoInfoAy);
        if (bq.isNullString(strA)) {
            strA = com.kwad.components.ct.response.a.c.g((PhotoInfo) ctPhotoInfoAy);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).alG).hh(strA).a(new com.kwad.components.ct.b.a(strA, ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_tube_episode_cover_bg)).f(getContext().getResources().getDrawable(R.drawable.ksad_tube_episode_cover_bg)).b(this.awj);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).alG == null || this.awj == null) {
            return;
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).alG).ac(this.awj);
        com.kwad.sdk.core.d.c.d("ProfileVideoCoverPresenter", "[WEBP]Glide clear(mFirstFrameView);");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.d.c.d("[WEBP]", "onDestroy");
    }
}
