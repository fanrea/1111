package com.kwad.components.ct.detail.photo.related.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.photo.related.a.a {
    private View awi;
    private ImageView awj;
    private int awk;
    private int awl;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awi = findViewById(R.id.ksad_related_video_item_root);
        this.awj = (ImageView) findViewById(R.id.ksad_related_video_cover);
        this.awk = ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) - com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_related_video_item_padding)) - (com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_related_video_item_margin) * 2)) / 2;
        this.awl = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_related_video_item_default_height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).cdM;
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        int iH = com.kwad.components.ct.response.a.c.h((PhotoInfo) ctPhotoInfoAy);
        int i = com.kwad.components.ct.response.a.c.i((PhotoInfo) ctPhotoInfoAy);
        ViewGroup.LayoutParams layoutParams = this.awi.getLayoutParams();
        if (iH > 0 && i > 0) {
            layoutParams.height = (int) (((this.awk * i) * 1.0f) / iH);
        } else {
            layoutParams.height = this.awl;
            com.kwad.sdk.core.d.c.d("LookRelatedCoverPresenter", "videoWidth or videoHeight is 0 int position=" + ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).mCurrentPosition);
        }
        this.awi.setLayoutParams(layoutParams);
        String strA = com.kwad.components.ct.response.a.c.a(ctPhotoInfoAy);
        if (bq.isNullString(strA)) {
            strA = com.kwad.components.ct.response.a.c.g((PhotoInfo) ctPhotoInfoAy);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).alG).hh(strA).a(new com.kwad.components.ct.b.a(strA, ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).f(getContext().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).b(this.awj);
    }
}
