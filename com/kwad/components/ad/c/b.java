package com.kwad.components.ad.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public boolean dA = false;
    public FrameLayout dt;
    public a du;
    public KsAdVideoPlayConfig dv;
    public List<AdTemplate> dw;
    private KsBannerAd.BannerAdInteractionListener dx;
    private d dy;
    public StyleTemplate dz;
    public AdResultData mAdResultData;
    public SceneImpl mAdScene;
    public Context mContext;

    public interface a {
        void ad();
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    public static boolean b(AdTemplate adTemplate) {
        AdMatrixInfo.AdBannerTKInfo adBannerTKInfoDX;
        return com.kwad.sdk.core.config.e.Yc() && (adBannerTKInfoDX = com.kwad.sdk.core.response.b.b.dX(adTemplate)) != null && !TextUtils.isEmpty(adBannerTKInfoDX.templateId) && adBannerTKInfoDX.renderType == 1;
    }

    public final void a(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.dx = bannerAdInteractionListener;
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.dy = dVar;
    }

    public final void a(a aVar) {
        this.du = aVar;
    }

    public final void aa() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.dx;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShow();
        }
    }

    public final void ab() {
        this.mAdTemplate.converted = true;
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.dx;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClicked();
        }
    }

    public final void ac() {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.dx;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdClose();
        }
    }

    public final void c(int i, String str) {
        KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener = this.dx;
        if (bannerAdInteractionListener != null) {
            bannerAdInteractionListener.onAdShowError(0, str);
        }
    }

    public final void c(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.dy.c(this.mAdTemplate);
    }
}
