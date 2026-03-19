package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g extends RelativeLayout {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private Button e;
    private ImageView f;
    private SigAdPrivacyInfoView g;
    private w h;
    private View i;

    public g(Context context) {
        super(context);
        a(context);
    }

    public g(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public g(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    private void a(Context context) {
        View viewInflate = inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_endcard_layout"), this);
        this.i = viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_close"));
        ImageView imageView = (ImageView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.a = imageView;
        if (n.b(imageView)) {
            this.a.setImageBitmap(s.CLOSE_OLD.a());
        }
        this.b = (ImageView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_app_icon"));
        this.c = (TextView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_title"));
        this.d = (TextView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_desc"));
        this.e = (Button) viewInflate.findViewById(ResourceUtil.getId(context, "sig_cta_button"));
        this.f = (ImageView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_endCard_image"));
        this.g = (SigAdPrivacyInfoView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_privacy_info"));
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.h == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.h = wVar;
            wVar.setText("反馈");
            this.h.setOnClickListener(onClickListener);
            this.h.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.i.getId());
            layoutParams.addRule(8, this.i.getId());
            ViewParent parent = this.i.getParent();
            if (parent == null) {
                return;
            }
            ((ViewGroup) parent).addView(this.h, layoutParams);
        }
    }

    public void a(String iconUrl, String imageUrl, String title, String description, String ctaTitle) {
        if (m.b(iconUrl)) {
            com.sigmob.sdk.base.common.g.a().load(iconUrl).into(this.b);
        }
        if (m.b(imageUrl) || m.b(iconUrl)) {
            if (!m.a((CharSequence) imageUrl)) {
                iconUrl = imageUrl;
            }
            com.sigmob.sdk.base.common.g.a().getBitmap(iconUrl, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.newInterstitial.g.1
                public void onBitmapLoadFailed() {
                }

                public void onBitmapLoaded(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    com.sigmob.sdk.base.blurkit.a.a(g.this.getContext());
                    Bitmap bitmapA = com.sigmob.sdk.base.blurkit.a.a().a(bitmap.copy(bitmap.getConfig(), true), 25);
                    if (bitmapA == null) {
                        return;
                    }
                    g.this.f.setImageBitmap(bitmapA);
                }
            });
        }
        if (m.b(title)) {
            this.c.setText(title);
        }
        if (m.b(description)) {
            this.d.setText(description);
        }
        if (m.b(ctaTitle)) {
            this.e.setText(ctaTitle);
        }
    }

    public SigAdPrivacyInfoView getAdPrivacyInfo() {
        return this.g;
    }

    public Button getCTAButton() {
        return this.e;
    }

    public View getCloseButton() {
        return this.a;
    }
}
