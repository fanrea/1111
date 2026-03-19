package com.kwad.components.ct.detail.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.ct.detail.b.g;
import com.kwad.components.ct.detail.photo.newui.c.b;
import com.kwad.components.ct.detail.photo.presenter.d;
import com.kwad.components.ct.detail.photo.presenter.e;
import com.kwad.components.ct.detail.photo.presenter.f;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.a {
    private int abR;
    private CtAdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.components.ct.detail.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            c.e("DetailPhotoFragment", "bundle is null");
            return;
        }
        this.abR = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
        Serializable serializable = getArguments().getSerializable("key_template");
        if (!(serializable instanceof CtAdTemplate)) {
            c.e("DetailPhotoFragment", "data is not instanceof CtAdTemplate:" + serializable);
            return;
        }
        CtAdTemplate ctAdTemplate = (CtAdTemplate) serializable;
        this.mAdTemplate = ctAdTemplate;
        ctAdTemplate.mIsFromContent = true;
        DetailVideoView detailVideoView = (DetailVideoView) this.pQ.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setVideoInfo(this.mAdTemplate.photoInfo.videoInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.c
    /* renamed from: yl, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.detail.c ap() {
        com.kwad.components.ct.detail.c cVar = new com.kwad.components.ct.detail.c();
        cVar.aoy = this;
        cVar.aol = this.aol;
        cVar.aok = this.aok;
        cVar.mAdTemplate = this.mAdTemplate;
        cVar.abR = this.abR;
        com.kwad.components.ct.detail.e.a aVar = new com.kwad.components.ct.detail.e.a(this, this.aok, this.mDetailVideoView, this.mAdTemplate, this.aol);
        cVar.aoq.add(aVar);
        cVar.aor.add(aVar.CH());
        cVar.aoz = aVar;
        return cVar;
    }

    @Override // com.kwad.components.ct.detail.a, com.kwad.components.core.n.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.components.core.n.c
    public final Presenter onCreatePresenter() {
        b bVar;
        int pageScene;
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.detail.b.c());
        presenter.d(new com.kwad.components.ct.detail.photo.c.a());
        presenter.d(new com.kwad.components.ct.detail.photo.presenter.c());
        presenter.d(new com.kwad.components.ct.detail.b.a());
        presenter.d(new f());
        presenter.d(new e());
        presenter.d(new com.kwad.components.ct.detail.photo.presenter.a());
        presenter.d(new g());
        presenter.d(new com.kwad.components.ct.detail.b.b.a());
        presenter.d(new com.kwad.components.ct.detail.b.e());
        if (com.kwad.components.ct.response.a.a.aV(this.mAdTemplate)) {
            presenter.d(new com.kwad.components.ct.detail.photo.a.g());
        } else {
            presenter.d(new d());
        }
        com.kwad.components.ct.api.g gVar = (com.kwad.components.ct.api.g) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.g.class);
        if (gVar != null && com.kwad.components.ct.response.a.a.aW(this.mAdTemplate)) {
            gVar.a(presenter);
        }
        if (com.kwad.components.ct.a.b.xe()) {
            bVar = new b(this.aol != null && this.aol.aHg);
            presenter.d(bVar);
        } else {
            bVar = null;
        }
        presenter.d(new com.kwad.components.ct.detail.photo.a.f(bVar != null ? bVar.Au() : null));
        if (this.aol != null && this.aol.aGJ) {
            presenter.d(new com.kwad.components.ct.detail.photo.a.c());
            presenter.d(new com.kwad.components.ct.detail.b.b());
            presenter.d(new com.kwad.components.ct.detail.b.d());
        }
        if (com.kwad.sdk.core.config.e.XN()) {
            presenter.d(new com.kwad.components.ct.detail.photo.newui.c.a());
        }
        if (this.aol != null && ((pageScene = this.aol.mSceneImpl.getPageScene()) == 1 || pageScene == 12)) {
            if (com.kwad.components.ct.detail.a.b.yY()) {
                if (this.aol.aGJ && ag.dC(this.mContext)) {
                    presenter.d(new com.kwad.components.ct.detail.photo.b.a());
                }
            } else if (com.kwad.components.ct.detail.a.b.yZ()) {
                if (ag.dE(this.mContext)) {
                    presenter.d(new com.kwad.components.ct.detail.photo.b.b());
                }
                if (this.aol.aGJ && ag.dC(this.mContext)) {
                    presenter.d(new com.kwad.components.ct.detail.photo.b.a());
                }
            }
        }
        return presenter;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_content_alliance_detail_photo_2;
    }

    @Override // com.kwad.components.ct.detail.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            this.mAdTemplate.photoInfo.authorInfo.isJoinedBlacklist = intent.getBooleanExtra("key_shield_state", false);
        }
    }
}
