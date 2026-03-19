package com.kwad.components.ct.profile.tabvideo.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.u.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends i implements View.OnClickListener {
    private ImageView Pd;
    private ProfileVideoDetailParam aRT;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "ProfileVideoDetailActivityImpl";
    }

    public static void init() {
        com.kwad.sdk.service.c.g(BaseFragmentActivity.ProfileVideoDetailActivity.class, c.class);
    }

    public static void a(Context context, ProfileVideoDetailParam profileVideoDetailParam) {
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.ProfileVideoDetailActivity.class);
        intent.putExtra("KEY_PROFILE_VIDEO_DETAIL_PARAM", profileVideoDetailParam);
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (xn()) {
                getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_activity_profile_video_detail);
                e.a(getActivity(), 0, false);
                rC();
                EP();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_PROFILE_VIDEO_DETAIL_PARAM");
        if (serializableExtra instanceof ProfileVideoDetailParam) {
            this.aRT = (ProfileVideoDetailParam) serializableExtra;
        }
        ProfileVideoDetailParam profileVideoDetailParam = this.aRT;
        return (profileVideoDetailParam == null || profileVideoDetailParam.mEnterScene == 0) ? false : true;
    }

    private void rC() {
        this.Pd = (ImageView) findViewById(R.id.ksad_profile_back);
        if (e.e(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Pd.getLayoutParams();
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
            this.Pd.setLayoutParams(marginLayoutParams);
        }
        this.Pd.setOnClickListener(this);
    }

    private void EP() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ksad_fragment_container, b.a(new KsScene.Builder(this.aRT.mEnterScene).build(), this.aRT)).commitAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Pd == view) {
            onBackPressed();
        }
    }
}
