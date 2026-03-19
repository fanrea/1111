package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u extends com.sigmob.sdk.base.common.i {
    private RelativeLayout f;
    private LinearLayout g;
    private TextView h;
    private BaseAdUnit i;
    private String j;

    public u(Activity context, BaseAdUnit baseAdUnit, Bundle intentExtras, Bundle savedInstanceState, String broadcastIdentifier, com.sigmob.sdk.base.common.j baseAdViewControllerListener) {
        super(context, broadcastIdentifier, baseAdViewControllerListener);
        this.j = "此广告由 Sigmob 提供，为了在应用程序上向您推荐展示出更加个性和实用的广告，对您可能会接收到的一部分广告进行更具相关性的定制，从而使您在应用程序上有更好的用户体验。Sigmob 非常重视数据安全，将努力采取合理的安全措施（包括技术方面和管理方面）来保护数据安全，防止数据信息被不正当使用或未经授权的情况下被访问。";
        this.i = baseAdUnit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void e() {
        this.c.removeAllViews();
        this.c.setBackgroundColor(-1);
        this.d.onSetContentView(this.c);
        LinearLayout linearLayout = new LinearLayout(l());
        linearLayout.setOrientation(1);
        this.c.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(l());
        this.f = relativeLayout;
        linearLayout.addView(relativeLayout, new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(50.0f, l())));
        View view = new View(l());
        view.setBackgroundColor(Color.parseColor("#E0E6EC"));
        linearLayout.addView(view, new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(1.0f, l())));
        int iDipsToIntPixels = Dips.dipsToIntPixels(10.0f, l());
        ImageView imageView = new ImageView(l());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.nativead.u$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.a(view2);
            }
        });
        imageView.setImageResource(ResourceUtil.getDrawableId(l(), "sig_image_video_back_left_black"));
        int i = iDipsToIntPixels * 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.setMargins(iDipsToIntPixels, 0, iDipsToIntPixels, 0);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.f.addView(imageView, layoutParams);
        TextView textView = new TextView(l());
        textView.setText("为什么看到此广告");
        textView.setTextColor(-16777216);
        textView.setTextSize(1, 20.0f);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f.addView(textView, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(l());
        this.g = linearLayout2;
        linearLayout.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView2 = new TextView(l());
        this.h = textView2;
        textView2.setText(this.j);
        this.h.setTextColor(-16777216);
        this.h.setTextSize(1, 15.0f);
        this.h.setLineSpacing(2.0f, 1.2f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(13);
        int i2 = iDipsToIntPixels / 2;
        layoutParams3.setMargins(i2, i2, i2, i2);
        this.g.addView(this.h, layoutParams3);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public boolean j() {
        if (this.d == null) {
            return false;
        }
        this.d.a();
        return false;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
    }
}
