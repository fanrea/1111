package com.kwad.components.ct.detail.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private ImageView Pd;
    private ViewGroup ayy;
    private TextView ayz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ayy = (ViewGroup) findViewById(R.id.ksad_photo_detail_title_bar_container);
        this.ayz = (TextView) findViewById(R.id.ksad_photo_detail_title_bar_title);
        this.Pd = (ImageView) findViewById(R.id.ksad_photo_detail_title_bar_back);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        int pageScene = this.aop.aol.mSceneImpl.getPageScene();
        if (com.kwad.sdk.core.scene.a.fw(pageScene) && !this.aop.aol.mKSTubeParam.hideDetailTitleBar) {
            this.ayz.setText("第" + com.kwad.components.ct.response.a.a.ay(this.aop.mAdTemplate).tubeEpisode.episodeNumber + "集");
            this.ayz.setVisibility(0);
            this.ayy.setVisibility(0);
            Cr();
        } else if (pageScene == 9) {
            this.ayz.setVisibility(8);
            this.ayy.setVisibility(0);
            Cr();
        } else {
            this.ayz.setVisibility(8);
            this.ayy.setVisibility(8);
        }
        this.Pd.setOnClickListener(this);
    }

    private void Cr() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ayy.getLayoutParams();
        if (com.kwad.components.core.u.e.e(getActivity())) {
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            this.ayy.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.ayy.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!com.kwad.sdk.c.a.a.Wl() && view == this.Pd) {
            com.kwad.components.ct.e.b.JK().W(this.aop.mAdTemplate);
            Activity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }
}
