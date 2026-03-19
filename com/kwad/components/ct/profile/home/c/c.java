package com.kwad.components.ct.profile.home.c;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.profile.home.b.a {
    private ImageView EZ;
    private TextView Fa;
    private View aRA;
    private com.kwad.components.ct.profile.home.a.a aRB = new com.kwad.components.ct.profile.home.a.a() { // from class: com.kwad.components.ct.profile.home.c.c.2
        @Override // com.kwad.components.ct.profile.home.a.a
        public final void d(UserProfile userProfile) {
            c.this.e(userProfile);
        }
    };
    private TextView aRx;
    private TextView aRy;
    private TextView aRz;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.EZ = (ImageView) findViewById(R.id.ksad_profile_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_profile_author_name);
        this.aRx = (TextView) findViewById(R.id.ksad_profile_author_area);
        this.aRA = findViewById(R.id.ksad_profile_author_desc_layout);
        this.aRy = (TextView) findViewById(R.id.ksad_profile_fans_count);
        this.aRz = (TextView) findViewById(R.id.ksad_profile_follow_count);
    }

    @Override // com.kwad.components.ct.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aRf.aRj.add(this.aRB);
        KSImageLoader.loadCircleIcon(this.EZ, this.aRf.aRb.mAdTemplate.photoInfo.authorInfo.authorIcon, getContext().getResources().getDrawable(R.drawable.ksad_profile_author_icon));
        ImageView imageView = (ImageView) findViewById(R.id.ksad_profile_header_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1081180, -2135706957});
        final String strFu = com.kwad.sdk.core.network.idc.a.aaw().fu("https://js-ad.a.yximgs.com/kos/nlav10933/ksad_profile_header_bg.png");
        com.kwad.sdk.glide.c.h(this.aRf.aRh).hh(strFu).f(gradientDrawable).b(new com.kwad.sdk.glide.request.a<Drawable>() { // from class: com.kwad.components.ct.profile.home.c.c.1
            @Override // com.kwad.sdk.glide.request.a, com.kwad.sdk.glide.request.h
            public final boolean a(GlideException glideException) {
                com.kwad.sdk.core.network.idc.a.aaw().a(strFu, "cdn", com.kwad.components.core.e.a.f(com.kwad.sdk.glide.request.a.c(glideException)));
                return false;
            }
        }).b(imageView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aRf.aRj.remove(this.aRB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(UserProfile userProfile) {
        this.aRy.setText(bq.bD(userProfile.ownerCount.fansCount));
        this.aRz.setText(bq.bD(userProfile.ownerCount.followCount));
        this.Fa.setText(TextUtils.isEmpty(userProfile.authorName) ? "-" : userProfile.authorName);
        String str = userProfile.authorArea;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Fa.getLayoutParams();
        marginLayoutParams.topMargin = 0;
        this.Fa.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.aRA.getLayoutParams();
        marginLayoutParams2.bottomMargin = 0;
        this.aRA.setLayoutParams(marginLayoutParams2);
        this.aRx.setText("IP归属地: " + str);
        this.aRx.setVisibility(0);
    }
}
