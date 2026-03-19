package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.sdk.base.models.WindAdMetaData;
import com.sigmob.sdk.base.models.rtb.ResponseNativeAd;
import com.sigmob.windad.natives.AdAppInfo;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ae implements WindNativeAdData {
    private final String a;
    private final String b;
    private final String c;
    private final List<SigImage> d;
    private final SigVideo e;
    private int f;
    private final z g;
    private final AdAppInfo h;

    public ae(BaseAdUnit adUnit) {
        this.a = adUnit.getTitle();
        this.b = adUnit.getDesc();
        this.c = adUnit.getIconUrl();
        this.d = adUnit.getImageUrlList();
        ResponseNativeAd nativeAd = adUnit.getNativeAd();
        if (com.sigmob.sdk.base.utils.n.b(nativeAd)) {
            this.f = nativeAd.type.intValue();
        }
        this.h = adUnit.getAdAppInfo();
        this.e = adUnit.getNativeVideo();
        z zVar = new z();
        this.g = zVar;
        zVar.a(adUnit, this);
    }

    public String a() {
        return "sigmob";
    }

    public double b() {
        z zVar = this.g;
        if (zVar == null) {
            return 0.0d;
        }
        return zVar.s();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindImageViews(List<ImageView> imageViews, int defaultImageRes) {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.a(imageViews, defaultImageRes);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaView(ViewGroup mediaLayout, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.b(mediaLayout, nativeADMediaListener);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaViewWithoutAppInfo(ViewGroup mediaLayout, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.a(mediaLayout, nativeADMediaListener);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindViewForInteraction(View view, List<View> clickableViews, List<View> creativeViewList, View disLikeView, NativeADEventListener nativeAdEventListener) {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.a(view, clickableViews, creativeViewList, disLikeView, nativeAdEventListener);
    }

    public double c() {
        z zVar = this.g;
        if (zVar == null) {
            return 0.0d;
        }
        return zVar.t();
    }

    public int d() {
        z zVar = this.g;
        if (zVar == null) {
            return 0;
        }
        return zVar.p();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void destroy() {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.w();
    }

    public int e() {
        z zVar = this.g;
        if (zVar == null) {
            return 0;
        }
        return zVar.u();
    }

    public int f() {
        return this.f;
    }

    public void g() {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.v();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public AdAppInfo getAdAppInfo() {
        return this.h;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public Bitmap getAdLogo() {
        z zVar = this.g;
        if (zVar == null) {
            return null;
        }
        return zVar.B();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getAdPatternType() {
        return this.f;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public View getAdView() {
        z zVar = this.g;
        if (zVar == null) {
            return null;
        }
        return zVar.q();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getCTAText() {
        z zVar = this.g;
        return zVar == null ? "" : zVar.A();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getDesc() {
        return this.b;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getEcpm() {
        z zVar = this.g;
        return zVar == null ? "" : zVar.H();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getIconUrl() {
        return this.c;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public List<SigImage> getImageList() {
        return this.d;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getInteractionType() {
        z zVar = this.g;
        if (zVar == null) {
            return 0;
        }
        return zVar.z();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getTitle() {
        return this.a;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getVideoCoverImageUrl() {
        z zVar = this.g;
        if (zVar == null) {
            return null;
        }
        return zVar.I();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoHeight() {
        SigVideo sigVideo = this.e;
        if (sigVideo == null) {
            return 0;
        }
        return sigVideo.getHeight();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoWidth() {
        SigVideo sigVideo = this.e;
        if (sigVideo == null) {
            return 0;
        }
        return sigVideo.getWidth();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public WindAdMetaData getWindAdMetaData() {
        z zVar = this.g;
        if (zVar == null) {
            return null;
        }
        return zVar.J();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void pauseVideo() {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.D();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void resumeVideo() {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.F();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void setDislikeInteractionCallback(Activity activity, WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.a(dislikeInteractionCallback);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void startVideo() {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.C();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void stopVideo() {
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.G();
    }
}
