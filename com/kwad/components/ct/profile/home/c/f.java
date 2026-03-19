package com.kwad.components.ct.profile.home.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.components.ct.profile.tabvideo.ProfileTabVideoParam;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.profile.home.b.a {
    private ProfileHomeParam aRG;
    private com.kwad.components.ct.profile.home.c aRh;
    private ViewPager aRi;
    private CtPhotoInfo.AuthorInfo aRn;
    private com.kwad.components.ct.profile.home.a.a aRB = new com.kwad.components.ct.profile.home.a.a() { // from class: com.kwad.components.ct.profile.home.c.f.1
        @Override // com.kwad.components.ct.profile.home.a.a
        public final void d(UserProfile userProfile) {
            f.this.f(userProfile);
        }
    };
    private com.kwad.components.ct.profile.home.a.b aRq = new com.kwad.components.ct.profile.home.a.b() { // from class: com.kwad.components.ct.profile.home.c.f.2
        @Override // com.kwad.components.ct.profile.home.a.b
        public final void Ji() {
            View viewFindViewById = f.this.findViewById(R.id.ksad_tab_strip);
            if (f.this.aRn.isJoinedBlacklist) {
                viewFindViewById.setVisibility(8);
                f.this.aRi.setVisibility(8);
            } else {
                viewFindViewById.setVisibility(0);
            }
        }
    };

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aRh = this.aRf.aRh;
        this.aRi = this.aRf.aRi;
        ProfileHomeParam profileHomeParam = this.aRf.aRb;
        this.aRG = profileHomeParam;
        this.aRn = profileHomeParam.mAdTemplate.photoInfo.authorInfo;
        this.aRf.aRj.add(this.aRB);
        this.aRf.aRk.add(this.aRq);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aRf.aRj.remove(this.aRB);
        this.aRf.aRk.remove(this.aRq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(UserProfile userProfile) {
        List<UserProfile.TabInfo> list;
        UserProfile.TabInfo tabInfo;
        Context context = getContext();
        if (context == null || this.aRn.isJoinedBlacklist || (list = userProfile.tabList) == null || list.isEmpty() || (tabInfo = list.get(0)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        PagerSlidingTabStrip.c cVarZ = z(String.valueOf(tabInfo.tabId), tabInfo.tabName);
        cVarZ.a(context, 0, this.aRi);
        Bundle bundle = new Bundle();
        ProfileTabVideoParam profileTabVideoParam = new ProfileTabVideoParam();
        profileTabVideoParam.mEntryScene = this.aRG.mEntryScene;
        profileTabVideoParam.mURLPackage = this.aRf.mSceneImpl.getUrlPackage();
        profileTabVideoParam.mCurrentPhotoId = this.aRG.mCurrentPhotoId;
        profileTabVideoParam.mAuthorId = com.kwad.components.ct.response.a.c.e(this.aRG.mAdTemplate.photoInfo);
        profileTabVideoParam.mTabId = tabInfo.tabId;
        profileTabVideoParam.mTabName = tabInfo.tabName;
        bundle.putSerializable("KEY_PROFILE_TAB_VIDEO_PARAM", profileTabVideoParam);
        arrayList.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(cVarZ, com.kwad.components.ct.profile.tabvideo.b.class, bundle));
        this.aRh.aA(arrayList);
        bX(tabInfo.tabName);
    }

    private static PagerSlidingTabStrip.c z(String str, String str2) {
        return new PagerSlidingTabStrip.c(str, str2);
    }

    private void bX(String str) {
        com.kwad.components.ct.e.b.JK().c(this.aRf.mSceneImpl, str);
    }
}
