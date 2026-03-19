package com.kwad.components.ct.profile.tabvideo.a.b;

import android.view.View;
import com.kwad.components.ct.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.m;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.profile.tabvideo.a.a.a implements View.OnClickListener {
    private KSFrameLayout awm;
    private final m awn = new m() { // from class: com.kwad.components.ct.profile.tabvideo.a.b.a.1
        @Override // com.kwad.sdk.widget.m
        public final void E(View view) {
            a.this.Bz();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.awm = (KSFrameLayout) findViewById(R.id.ksad_profile_item_root);
    }

    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.awm.setOnClickListener(this);
        this.awm.setViewVisibleListener(this.awn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.awm.setViewVisibleListener(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ct.profile.tabvideo.detail.a.Jn();
        com.kwad.components.ct.profile.tabvideo.detail.a.wZ();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        Jp();
        By();
    }

    private void Jp() {
        List items = ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).avY.getItems();
        n.d(com.kwad.components.ct.response.a.a.O(items), ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).mCurrentPosition);
        com.kwad.components.ct.profile.tabvideo.detail.a.Jn();
        com.kwad.components.ct.profile.tabvideo.detail.a.L(items);
        ProfileVideoDetailParam profileVideoDetailParam = new ProfileVideoDetailParam();
        profileVideoDetailParam.mEnterScene = ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).aRU.mEntryScene;
        profileVideoDetailParam.mAuthorId = ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).aRU.mAuthorId;
        profileVideoDetailParam.mTabId = ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).aRU.mTabId;
        profileVideoDetailParam.mSelectedPosition = ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).mCurrentPosition;
        com.kwad.components.ct.profile.tabvideo.detail.c.a(getContext(), profileVideoDetailParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Bz() {
        com.kwad.components.ct.e.b.JK().K((CtAdTemplate) ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).cdM);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void By() {
        com.kwad.components.ct.e.b.JK().d((CtAdTemplate) ((com.kwad.components.ct.profile.tabvideo.a.a.b) this.cdN).cdM, 1);
    }
}
