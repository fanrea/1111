package com.kwad.components.ct.related;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends i implements View.OnClickListener {
    private ImageView Pd;
    private RelatedVideoDetailParam aJq;
    private FrameLayout aTs;
    private a aTt;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "RelatedVideoSlideActivityImpl";
    }

    public static void init() {
        c.g(BaseFragmentActivity.FragmentActivity4.class, b.class);
    }

    public static void a(KsFragment ksFragment, int i, RelatedVideoDetailParam relatedVideoDetailParam) {
        if (ksFragment == null) {
            return;
        }
        Intent intent = new Intent(ksFragment.getContext(), (Class<?>) BaseFragmentActivity.FragmentActivity4.class);
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_PARAM", relatedVideoDetailParam);
        ksFragment.startActivityForResult(intent, 1000);
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
                initView();
                EP();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.ksad_related_title);
        textView.setVisibility(0);
        if (TextUtils.isEmpty(com.kwad.components.ct.detail.a.b.ze())) {
            return;
        }
        textView.setText(com.kwad.components.ct.detail.a.b.ze());
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_RELATED_VIDEO_DETAIL_PARAM");
        if (serializableExtra instanceof RelatedVideoDetailParam) {
            this.aJq = (RelatedVideoDetailParam) serializableExtra;
        }
        RelatedVideoDetailParam relatedVideoDetailParam = this.aJq;
        return (relatedVideoDetailParam == null || relatedVideoDetailParam.mEntryScene == 0) ? false : true;
    }

    private void rC() {
        this.Pd = (ImageView) findViewById(R.id.ksad_back_btn);
        this.aTs = (FrameLayout) findViewById(R.id.ksad_title_bar);
        if (e.e(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aTs.getLayoutParams();
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
            this.aTs.setLayoutParams(marginLayoutParams);
        }
        this.Pd.setOnClickListener(this);
    }

    private void EP() {
        a aVarA = a.a(new KsScene.Builder(this.aJq.mEntryScene).build(), this.aJq);
        this.aTt = aVarA;
        aVarA.getArguments().putSerializable("KEY_HOME_ACTIONBAR_HEIGHT", Integer.valueOf(com.kwad.sdk.c.a.a.j(this.aTs.getContext(), R.dimen.ksad_action_bar_height)));
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, this.aTt).commitAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Pd == view) {
            onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        JJ();
        super.onBackPressed();
        if (this.aTt != null) {
            com.kwad.components.ct.e.b.JK().h(this.aTt.getScene());
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

    private void JJ() {
        a aVar;
        SlidePlayViewPager slidePlayViewPagerFn;
        Activity activity = getActivity();
        if (activity == null || (aVar = this.aTt) == null || (slidePlayViewPagerFn = aVar.Fn()) == null) {
            return;
        }
        com.kwad.components.ct.detail.photo.related.a.Bg().x(slidePlayViewPagerFn.getData());
        Intent intent = new Intent();
        intent.putExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", slidePlayViewPagerFn.getRealPosition());
        activity.setResult(-1, intent);
    }
}
