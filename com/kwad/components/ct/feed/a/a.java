package com.kwad.components.ct.feed.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.components.ct.api.h;
import com.kwad.components.ct.api.model.feed.FeedSlideParam;
import com.kwad.components.ct.api.model.wallpaper.WallpaperParam;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i implements View.OnClickListener {
    private ImageView Pd;
    private FeedSlideParam aFm;
    private View aFn;
    private com.kwad.components.ct.home.i aFo;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "FeedSlideActivityImpl";
    }

    public static void init() {
        c.g(BaseFragmentActivity.FragmentActivity5.class, a.class);
    }

    public static void a(KsFragment ksFragment, FeedSlideParam feedSlideParam) {
        if (ksFragment == null) {
            return;
        }
        Intent intent = new Intent(ksFragment.getContext(), (Class<?>) BaseFragmentActivity.FragmentActivity5.class);
        intent.putExtra(FeedSlideParam.KEY_FEED_SLIDE_PARAM, feedSlideParam);
        ksFragment.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (xn()) {
                getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_activity_slide_related_video);
                e.a(getActivity(), 0, false);
                rC();
                EP();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra(FeedSlideParam.KEY_FEED_SLIDE_PARAM);
        if (serializableExtra instanceof FeedSlideParam) {
            this.aFm = (FeedSlideParam) serializableExtra;
        }
        FeedSlideParam feedSlideParam = this.aFm;
        return (feedSlideParam == null || feedSlideParam.mEntryScene == 0) ? false : true;
    }

    private void rC() {
        this.Pd = (ImageView) findViewById(R.id.ksad_back_btn);
        this.aFn = findViewById(R.id.ksad_title_bar);
        if (e.e(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aFn.getLayoutParams();
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getActivity(), 11.0f);
            this.aFn.setLayoutParams(marginLayoutParams);
        }
        this.Pd.setOnClickListener(this);
    }

    private void EP() {
        KsScene ksSceneBuild = new KsScene.Builder(this.aFm.mEntryScene).build();
        h hVar = (h) d.g(h.class);
        if (this.aFm.mIsWallpaperPage && hVar != null) {
            WallpaperParam wallpaperParam = new WallpaperParam();
            wallpaperParam.mWallpaperSourceType = 0;
            wallpaperParam.mSelectedPosition = this.aFm.mSelectedPosition;
            this.aFo = (com.kwad.components.ct.home.i) hVar.a(ksSceneBuild, wallpaperParam);
        } else {
            this.aFo = b.a(ksSceneBuild, this.aFm);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.aFo).commitAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Pd == view) {
            onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ct.home.i iVar = this.aFo;
        if (iVar == null || !iVar.onBackPressed()) {
            super.onBackPressed();
            EQ();
            if (this.aFo != null) {
                com.kwad.components.ct.e.b.JK().h(this.aFo.getScene());
            }
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            com.kwad.components.ct.detail.photo.related.a.Bg().Bi();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void EQ() {
        com.kwad.components.ct.home.i iVar;
        SlidePlayViewPager slidePlayViewPagerFn;
        if (getActivity() == null || (iVar = this.aFo) == null || (slidePlayViewPagerFn = iVar.Fn()) == null) {
            return;
        }
        com.kwad.components.ct.feed.b.EL().C(slidePlayViewPagerFn.getData());
        com.kwad.components.ct.feed.b.EL().cj(slidePlayViewPagerFn.getRealPosition());
    }
}
