package com.kwad.components.ad.interstitial.f;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ad.interstitial.f.b {
    private static int ph = 4;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c oa;
    private a pf = new a();
    private b pg = new b();

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) amf();
        this.oa = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.oa.mAdTemplate);
        this.pf.pi = (ImageView) this.oa.ob.findViewById(R.id.ksad_app_icon);
        this.pf.pj = (TextView) this.oa.ob.findViewById(R.id.ksad_app_title);
        this.pf.pk = (TextView) this.oa.ob.findViewById(R.id.ksad_app_desc);
        this.pf.pl = (KsPriceView) this.oa.ob.findViewById(R.id.ksad_product_price);
        d(this.mAdInfo);
        a(this.pf, this.pg, this.mAdInfo, this.mAdTemplate);
    }

    private void a(a aVar, b bVar, AdInfo adInfo, AdTemplate adTemplate) {
        ImageView imageView = aVar.pi;
        if (!TextUtils.isEmpty(bVar.getAppIconUrl())) {
            imageView.setVisibility(0);
            if (com.kwad.sdk.core.response.b.a.cr(adInfo) == 2) {
                KSImageLoader.loadCircleIcon(imageView, bVar.getAppIconUrl(), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            } else {
                imageView.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(imageView, bVar.getAppIconUrl(), adTemplate, ph);
            }
        } else {
            imageView.setVisibility(8);
        }
        aVar.pj.setText(bVar.eE());
        if (!com.kwad.components.ad.interstitial.b.b.dS() || com.kwad.sdk.core.response.b.a.cr(adInfo) != 3) {
            aVar.pk.setText(bVar.eF());
        } else {
            aVar.pl.d(bVar.getPrice(), bVar.eG(), true);
            aVar.pl.setVisibility(0);
            aVar.pk.setVisibility(8);
            eD();
        }
        this.oa.ob.f(bVar.eH(), 0);
    }

    private void d(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cr(adInfo) == 2) {
            this.pg.y(com.kwad.sdk.core.response.b.a.dc(adInfo));
            this.pg.z(com.kwad.sdk.core.response.b.a.cB(adInfo));
            CharSequence charSequenceC = com.kwad.sdk.core.response.b.a.c(adInfo, com.kwad.components.core.widget.f.alx);
            if (TextUtils.isEmpty(charSequenceC)) {
                charSequenceC = com.kwad.sdk.core.response.b.a.db(adInfo);
            }
            this.pg.a(charSequenceC);
            if (com.kwad.sdk.core.response.b.a.cY(adInfo)) {
                this.pg.B(com.kwad.components.ad.e.b.aH());
                return;
            } else {
                this.pg.B(com.kwad.components.ad.e.b.aK());
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dS() && com.kwad.sdk.core.response.b.a.cr(adInfo) == 3) {
            AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfo);
            this.pg.y(adProductInfoDj.icon);
            this.pg.z(adProductInfoDj.name);
            this.pg.A(adProductInfoDj.originPrice);
            this.pg.setPrice(adProductInfoDj.price);
            this.pg.B(com.kwad.components.ad.e.b.aI());
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
            this.pg.y(com.kwad.sdk.core.response.b.a.cC(adInfo));
            if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.ay(adInfo))) {
                this.pg.z(com.kwad.sdk.core.response.b.a.ay(adInfo));
            } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
                this.pg.z(adInfo.advertiserInfo.adAuthorText);
            } else {
                this.pg.z(getContext().getString(R.string.ksad_ad_default_username_normal));
            }
            this.pg.a(com.kwad.sdk.core.response.b.a.aw(adInfo));
            this.pg.B(com.kwad.sdk.core.response.b.a.aH(adInfo));
            return;
        }
        this.pg.y(com.kwad.sdk.core.response.b.a.cC(adInfo));
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aA(adInfo))) {
            this.pg.z(com.kwad.sdk.core.response.b.a.aA(adInfo));
        } else if (!TextUtils.isEmpty(adInfo.advertiserInfo.adAuthorText)) {
            this.pg.z(adInfo.advertiserInfo.adAuthorText);
        } else {
            this.pg.z(getContext().getString(R.string.ksad_ad_default_username_normal));
        }
        this.pg.a(com.kwad.sdk.core.response.b.a.aw(adInfo));
        this.pg.B(com.kwad.sdk.core.response.b.a.aH(adInfo));
    }

    private void eD() {
        View viewFindViewById = this.oa.ob.findViewById(R.id.ksad_ad_desc_layout);
        View viewFindViewById2 = this.oa.ob.findViewById(R.id.ksad_space);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.weight = 2.68f;
        viewFindViewById.setLayoutParams(layoutParams);
        viewFindViewById2.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    static class a {
        private ImageView pi;
        private TextView pj;
        private TextView pk;
        private KsPriceView pl;

        a() {
        }
    }

    static class b {
        private String appIconUrl;
        private String pm;
        private CharSequence pn;
        private String po;
        private String pp;
        private String price;

        b() {
        }

        public final String getAppIconUrl() {
            return this.appIconUrl;
        }

        public final void y(String str) {
            this.appIconUrl = str;
        }

        public final String eE() {
            return this.pm;
        }

        public final void z(String str) {
            this.pm = str;
        }

        public final CharSequence eF() {
            return this.pn;
        }

        public final void a(CharSequence charSequence) {
            this.pn = charSequence;
        }

        public final String eG() {
            return this.po;
        }

        public final void A(String str) {
            this.po = str;
        }

        public final String getPrice() {
            return this.price;
        }

        public final void setPrice(String str) {
            this.price = str;
        }

        public final String eH() {
            return this.pp;
        }

        public final void B(String str) {
            this.pp = str;
        }
    }
}
