package com.sigmob.sdk.nativead;

import android.content.Context;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends com.sigmob.sdk.base.common.h {
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private Boolean s;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, int i2, int i3, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map options = pointEntitySigmob.getOptions();
            options.put("video_time", String.valueOf(i));
            options.put("begin_time", String.valueOf(i2));
            options.put(MetricsSQLiteCacheKt.METRICS_END_TIME, String.valueOf(i3));
            options.put("is_first", String.valueOf(i2 == 0 ? 1 : 0));
            options.put("is_last", String.valueOf(i3 < i + (-1000) ? 0 : 1));
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, int i2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map options = pointEntitySigmob.getOptions();
            options.put("video_time", String.valueOf(i));
            options.put("begin_time", String.valueOf(i2));
            pointEntitySigmob.setOptions(options);
        }
    }

    public static d f(BaseAdUnit adUnit) {
        d dVar = new d();
        dVar.b(adUnit);
        return dVar;
    }

    @Override // com.sigmob.sdk.base.common.h
    public void a(Context context, TouchLocation down, TouchLocation up, com.sigmob.sdk.base.a clickUIType, BaseAdUnit adUnit) throws UnsupportedEncodingException {
        String coordinate;
        SigMacroCommon macroCommon = adUnit.getMacroCommon();
        if (macroCommon != null) {
            macroCommon.updateClickMarco(down, up);
            coordinate = macroCommon.getCoordinate();
        } else {
            coordinate = "";
        }
        a(clickUIType, coordinate, true);
    }

    public void a(BaseAdUnit adUnit, final int currentPosition, final int duration) throws UnsupportedEncodingException {
        com.sigmob.sdk.base.common.ac.a("video_start", (String) null, adUnit, new ac.a() { // from class: com.sigmob.sdk.nativead.d$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                d.a(currentPosition, duration, obj);
            }
        });
        SigMacroCommon macroCommon = adUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(duration));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(currentPosition));
        com.sigmob.sdk.base.network.g.a(adUnit, "video_start");
    }

    public void a(BaseAdUnit adUnit, final int endTime, final int currentPosition, final int duration) throws UnsupportedEncodingException {
        com.sigmob.sdk.base.common.ac.a("video_pause", (String) null, adUnit, new ac.a() { // from class: com.sigmob.sdk.nativead.d$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                d.a(duration, currentPosition, endTime, obj);
            }
        });
        SigMacroCommon macroCommon = adUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(duration));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(currentPosition));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(endTime));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(currentPosition == 0 ? 1 : 0));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(endTime));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(endTime));
        com.sigmob.sdk.base.network.g.a(adUnit, "video_pause");
    }

    public void a(boolean isMute) {
        this.s = Boolean.valueOf(isMute);
    }

    @Override // com.sigmob.sdk.base.common.h
    public void b(BaseAdUnit adUnit) {
        super.b(adUnit);
        NativeAdSetting nativeAdSetting = adUnit.getNativeAdSetting();
        SingleNativeAdSetting singleNativeSetting = adUnit.getSingleNativeSetting();
        if (singleNativeSetting != null) {
            this.r = singleNativeSetting.use_na_video_component.booleanValue();
        }
        if (nativeAdSetting != null) {
            this.m = nativeAdSetting.preview_page_video_mute.intValue();
            this.n = nativeAdSetting.detail_page_video_mute.intValue();
            this.o = nativeAdSetting.impression_percent.intValue();
            this.p = nativeAdSetting.impression_time.intValue();
            this.l = nativeAdSetting.video_auto_play.intValue();
            this.q = nativeAdSetting.end_impression_time.intValue();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.d("play_quarter", 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.d("play_two_quarters", 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.d("play_three_quarters", 0.75f));
        a((List<com.sigmob.sdk.videoAd.d>) arrayList);
    }

    public void c(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.base.common.ac.a(PointCategory.TEMPLATE_SHOW, (String) null, adUnit);
    }

    public void d(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.base.common.ac.a(PointCategory.TEMPLATE_CLOSE, (String) null, adUnit);
    }

    public void e(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.base.common.ac.b("ad_show", null, adUnit);
        com.sigmob.sdk.base.network.g.a(adUnit, "ad_show");
    }

    public void f(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.base.common.ac.b("feed_click", null, adUnit);
        com.sigmob.sdk.base.network.g.a(adUnit, "feed_click");
    }

    public boolean l() {
        return this.r;
    }

    public int m() {
        return this.l;
    }

    public boolean n() {
        Boolean bool = this.s;
        return bool != null ? bool.booleanValue() : this.m == 0;
    }

    public boolean o() {
        return this.n != 0;
    }

    public int p() {
        return this.o;
    }

    public int q() {
        return this.p;
    }

    public int r() {
        return this.q;
    }

    public int s() {
        int i = this.o;
        if (i >= 0) {
            return i;
        }
        return 50;
    }

    public int t() {
        int i = this.p;
        if (i >= 0) {
            return i;
        }
        return 1;
    }

    public boolean u() {
        if (m() != 0) {
            return m() == 1 && ClientMetadata.getInstance().getActiveNetworkType() == 100;
        }
        return true;
    }
}
