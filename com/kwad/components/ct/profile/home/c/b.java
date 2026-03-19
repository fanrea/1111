package com.kwad.components.ct.profile.home.c;

import android.view.View;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.profile.home.b;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.components.ct.profile.widget.KSProfilePageLoadingView;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.profile.home.b.a {
    private Set<com.kwad.components.ct.profile.home.a.a> aRj;
    private View aRt;
    private KSProfilePageLoadingView aRu;
    private com.kwad.components.ct.profile.home.b aRv;
    private KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.profile.home.c.b.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (b.this.aRv != null) {
                b.this.aRv.startRequest();
            }
        }
    };
    private b.a aRc = new b.a() { // from class: com.kwad.components.ct.profile.home.c.b.2
        @Override // com.kwad.components.ct.profile.home.b.a
        public final void onStartLoading() {
            b.this.aRu.Fi();
        }

        @Override // com.kwad.components.ct.profile.home.b.a
        public final void by(int i) {
            b.this.aRu.hide();
            if (com.kwad.sdk.core.network.e.bCw.errorCode == i) {
                b.this.aRu.Jt();
            } else {
                b.this.aRu.Ju();
            }
        }

        @Override // com.kwad.components.ct.profile.home.b.a
        public final void c(UserProfile userProfile) {
            b.this.aRu.hide();
            b.this.aRt.setVisibility(0);
            Iterator it = b.this.aRj.iterator();
            while (it.hasNext()) {
                ((com.kwad.components.ct.profile.home.a.a) it.next()).d(userProfile);
            }
        }
    };
    private com.kwad.components.ct.profile.home.a.b aRq = new com.kwad.components.ct.profile.home.a.b() { // from class: com.kwad.components.ct.profile.home.c.b.3
        @Override // com.kwad.components.ct.profile.home.a.b
        public final void Ji() {
            if (b.this.aRf.aRb.mAdTemplate.photoInfo.authorInfo.isJoinedBlacklist) {
                return;
            }
            b.this.Jk();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aRt = findViewById(R.id.ksad_profile_view_pager);
        this.aRu = (KSProfilePageLoadingView) findViewById(R.id.ksad_page_loading);
    }

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aRj = this.aRf.aRj;
        ProfileHomeParam profileHomeParam = this.aRf.aRb;
        ImpInfo impInfo = new ImpInfo(this.aRf.mSceneImpl);
        impInfo.pageScene = r1.getPageScene();
        this.aRv = new com.kwad.components.ct.profile.home.b(impInfo, com.kwad.components.ct.response.a.c.e(profileHomeParam.mAdTemplate.photoInfo), this.aRc);
        Jk();
        this.aRu.setRetryClickListener(this.asf);
        this.aRf.aRk.add(this.aRq);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aRv.release();
        this.aRu.setRetryClickListener(null);
        this.aRf.aRk.remove(this.aRq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        this.aRv.startRequest();
    }
}
