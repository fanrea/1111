package com.kwad.components.ct.profile.home.c;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.CustomReboundBehavior;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.profile.home.b.a {
    private com.kwad.components.ct.profile.home.a.a aRB = new com.kwad.components.ct.profile.home.a.a() { // from class: com.kwad.components.ct.profile.home.c.d.1
        @Override // com.kwad.components.ct.profile.home.a.a
        public final void d(UserProfile userProfile) {
            d.this.aRm.post(d.this.aRD);
        }
    };
    private Runnable aRD = new Runnable() { // from class: com.kwad.components.ct.profile.home.c.d.2
        @Override // java.lang.Runnable
        public final void run() {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) d.this.aRm.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomReboundBehavior) {
                ((CustomReboundBehavior) behavior).setScrollableSize((d.this.aRm.getHeight() + d.this.aRi.getHeight()) - ((ViewGroup) d.this.aRm.getParent()).getHeight());
            }
        }
    };
    private ViewPager aRi;
    private KSAppBarLayout aRm;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aRm = (KSAppBarLayout) findViewById(R.id.ksad_profile_appbar);
    }

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aRi = this.aRf.aRi;
        this.aRf.aRj.add(this.aRB);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aRm.removeCallbacks(this.aRD);
        this.aRf.aRj.remove(this.aRB);
    }
}
