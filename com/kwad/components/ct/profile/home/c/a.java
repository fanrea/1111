package com.kwad.components.ct.profile.home.c;

import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.components.ct.profile.widget.KSProfileShieldingView;
import com.kwad.components.ct.request.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.widget.viewpager.NestedScrollViewPager;
import com.kwad.sdk.utils.ac;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.profile.home.b.a {
    private KSProfileShieldingView aRl;
    private KSAppBarLayout aRm;
    private CtPhotoInfo.AuthorInfo aRn;
    private KSProfileShieldingView.a aRo = new KSProfileShieldingView.a() { // from class: com.kwad.components.ct.profile.home.c.a.1
        @Override // com.kwad.components.ct.profile.widget.KSProfileShieldingView.a
        public final void Jj() {
            a.this.asP.a(String.valueOf(a.this.aRn.authorId), 2, new b.a() { // from class: com.kwad.components.ct.profile.home.c.a.1.1
                @Override // com.kwad.components.ct.request.b.a
                public final void zH() {
                    ac.ae(a.this.getContext(), a.this.getContext().getString(R.string.ksad_operation_failed_tips));
                }

                @Override // com.kwad.components.ct.request.b.a
                public final void Ah() {
                    a.this.aRn.isJoinedBlacklist = false;
                    ac.ae(a.this.getContext(), a.this.getContext().getString(R.string.ksad_has_removed_blacklist));
                    Iterator<com.kwad.components.ct.profile.home.a.b> it = a.this.aRf.aRk.iterator();
                    while (it.hasNext()) {
                        it.next().Ji();
                    }
                    com.kwad.components.ct.e.b.JK().d(a.this.mAdTemplate, a.this.aRn.isJoinedBlacklist);
                }
            });
        }
    };
    private com.kwad.components.ct.profile.home.a.a aRp = new com.kwad.components.ct.profile.home.a.a() { // from class: com.kwad.components.ct.profile.home.c.a.2
        @Override // com.kwad.components.ct.profile.home.a.a
        public final void d(UserProfile userProfile) {
            if (a.this.aRn.isJoinedBlacklist) {
                a.this.aRl.setVisibility(0);
            } else {
                a.this.aRl.setVisibility(8);
            }
        }
    };
    private com.kwad.components.ct.profile.home.a.b aRq = new com.kwad.components.ct.profile.home.a.b() { // from class: com.kwad.components.ct.profile.home.c.a.3
        @Override // com.kwad.components.ct.profile.home.a.b
        public final void Ji() {
            if (a.this.aRn.isJoinedBlacklist) {
                if (a.this.aRf.aRi instanceof NestedScrollViewPager) {
                    ((NestedScrollViewPager) a.this.aRf.aRi).ale();
                }
                a.this.aRm.setExpanded(true, true);
                a.this.aRl.setVisibility(0);
                return;
            }
            a.this.aRl.setVisibility(8);
        }
    };
    private com.kwad.components.ct.request.b asP;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aRl = (KSProfileShieldingView) findViewById(R.id.ksad_page_shielding);
        this.aRm = (KSAppBarLayout) findViewById(R.id.ksad_profile_appbar);
    }

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = this.aRf.aRb.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        this.aRn = ctAdTemplate.photoInfo.authorInfo;
        this.aRl.setShieldReliefClickListener(this.aRo);
        this.aRf.aRj.add(this.aRp);
        this.aRf.aRk.add(this.aRq);
        this.asP = new com.kwad.components.ct.request.b();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.asP.release();
        this.aRf.aRj.remove(this.aRp);
        this.aRf.aRk.remove(this.aRq);
    }
}
