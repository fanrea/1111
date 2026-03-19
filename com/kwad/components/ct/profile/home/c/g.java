package com.kwad.components.ct.profile.home.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.d.f;
import com.kwad.components.ct.detail.photo.d.h;
import com.kwad.components.ct.detail.photo.d.i;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.sdk.R;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.profile.home.b.a implements View.OnClickListener {
    private com.kwad.components.ct.profile.home.a.a aRB = new com.kwad.components.ct.profile.home.a.a() { // from class: com.kwad.components.ct.profile.home.c.g.1
        @Override // com.kwad.components.ct.profile.home.a.a
        public final void d(UserProfile userProfile) {
            g.this.aRK.setText(userProfile.authorName);
            if (com.kwad.components.ct.detail.a.b.zg()) {
                g.this.aRL.setVisibility(0);
            }
        }
    };
    private ViewGroup aRI;
    private View aRJ;
    private TextView aRK;
    private View aRL;
    private h aRM;
    private i awN;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aRI = (ViewGroup) findViewById(R.id.ksad_profile_title_bar);
        this.aRJ = findViewById(R.id.ksad_profile_left_back);
        this.aRL = findViewById(R.id.ksad_profile_right_more);
        this.aRK = (TextView) findViewById(R.id.ksad_profile_title);
    }

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aRJ.setOnClickListener(this);
        this.aRL.setOnClickListener(this);
        Jl();
        this.aRf.aRj.add(this.aRB);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aRf.aRj.remove(this.aRB);
    }

    private void Jl() {
        Activity activity = getActivity();
        if (activity != null && com.kwad.components.core.u.e.e(activity)) {
            int statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            ViewGroup.LayoutParams layoutParams = this.aRI.getLayoutParams();
            layoutParams.height += statusBarHeight;
            this.aRI.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.aRI;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), statusBarHeight, this.aRI.getPaddingRight(), this.aRI.getPaddingBottom());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.aRJ) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                com.kwad.components.ct.e.b.JK().h(this.aRf.mSceneImpl);
                return;
            }
            return;
        }
        if (view == this.aRL) {
            BN();
            com.kwad.components.ct.e.b.JK().L(this.aRf.aRb.mAdTemplate);
        }
    }

    private void BN() {
        if (this.aRM == null) {
            this.aRM = new h.a().f(this.aRf.aRb.mAdTemplate).bx(true).bu(false).bv(false).bw(false).bt(true).Ak();
        }
        i iVar = this.awN;
        if (iVar == null || !iVar.isShowing()) {
            i iVar2 = new i(getContext(), this.aRM);
            this.awN = iVar2;
            iVar2.c(new f.a() { // from class: com.kwad.components.ct.profile.home.c.g.2
                @Override // com.kwad.components.ct.detail.photo.d.f.a
                public final void onCancel() {
                }

                @Override // com.kwad.components.ct.detail.photo.d.f.a
                public final void b(com.kwad.components.ct.detail.photo.e.d dVar) {
                    if (dVar instanceof com.kwad.components.ct.detail.photo.d.b) {
                        Iterator<com.kwad.components.ct.profile.home.a.b> it = g.this.aRf.aRk.iterator();
                        while (it.hasNext()) {
                            it.next().Ji();
                        }
                    }
                }
            });
            this.awN.show();
        }
    }
}
