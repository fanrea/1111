package com.kwad.components.ct.detail.photo.related.b;

import android.view.View;
import com.kwad.components.ct.related.RelatedVideoDetailParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.n;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.photo.related.a.a implements View.OnClickListener {
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        getRootView().setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        Bx();
        By();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Bx() {
        SceneImpl sceneImpl = ((CtAdTemplate) ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).cdM).mAdScene;
        if (sceneImpl == null) {
            return;
        }
        List<CtAdTemplate> items = ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).avY.getItems();
        n.b(com.kwad.components.ct.response.a.a.O(items), ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).mEntryAdTemplate);
        com.kwad.components.ct.detail.photo.related.a.Bg().w(items);
        RelatedVideoDetailParam relatedVideoDetailParam = new RelatedVideoDetailParam();
        relatedVideoDetailParam.mEntryScene = sceneImpl.entryScene;
        relatedVideoDetailParam.mSelectedPosition = ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).mCurrentPosition;
        relatedVideoDetailParam.mSourcePhotoId = String.valueOf(com.kwad.components.ct.response.a.a.bg(((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).mEntryAdTemplate));
        com.kwad.components.ct.related.b.a(((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).alG, 1000, relatedVideoDetailParam);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void By() {
        com.kwad.components.ct.e.b.JK().a((CtAdTemplate) ((com.kwad.components.ct.detail.photo.related.a.b) this.cdN).cdM, 1, "related_video_list");
    }
}
