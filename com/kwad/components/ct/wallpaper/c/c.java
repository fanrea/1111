package com.kwad.components.ct.wallpaper.c;

import android.content.res.Resources;
import com.kwad.components.ct.detail.photo.view.WaterMarkView;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b {
    private WaterMarkView avK;
    private boolean avL;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.avK = (WaterMarkView) findViewById(R.id.ksad_video_water_mark);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.aop.mAdTemplate);
        boolean z = ctPhotoInfoAy.baseInfo.waterMarkPosition != 0;
        this.avL = z;
        if (z) {
            this.avK.setAuthorInfo(ctPhotoInfoAy.authorInfo);
            this.avK.setVisibility(0);
        } else {
            this.avK.setVisibility(4);
        }
    }
}
