package com.sigmob.sdk.newInterstitial;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.r;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import io.netty.util.internal.StringUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements r {
    public static final String a = "InterstitialAdViewAbilitySession";

    private void a(BaseAdUnit adUnit, String event, String sub, final HashMap<String, String> options) {
        ac.a(event, sub, adUnit, new ac.a() { // from class: com.sigmob.sdk.newInterstitial.b$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                b.a(options, obj);
            }
        });
    }

    private void a(BaseAdUnit adUnit, String adVideoLink, boolean isMulti, String videoLink) throws UnsupportedEncodingException {
        SigMacroCommon macroCommon = adUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(adUnit.getVideoCommon().video_time));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(adUnit.getVideoCommon().begin_time));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(adUnit.getVideoCommon().end_time));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(adUnit.getVideoCommon().is_first));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(adUnit.getVideoCommon().is_last));
        macroCommon.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(adUnit.getVideoCommon().scene));
        macroCommon.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(adUnit.getVideoCommon().type));
        macroCommon.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(adUnit.getVideoCommon().is_auto_play));
        macroCommon.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(adUnit.getVideoCommon().status));
        com.sigmob.sdk.base.network.g.a(adUnit, adVideoLink, isMulti);
        HashMap<String, String> map = new HashMap<>();
        map.put("video_time", String.valueOf(adUnit.getVideoCommon().video_time));
        map.put("begin_time", String.valueOf(adUnit.getVideoCommon().begin_time));
        map.put(MetricsSQLiteCacheKt.METRICS_END_TIME, String.valueOf(adUnit.getVideoCommon().end_time));
        map.put("is_first", String.valueOf(adUnit.getVideoCommon().is_first));
        map.put("scene", String.valueOf(adUnit.getVideoCommon().scene));
        map.put("type", String.valueOf(adUnit.getVideoCommon().type));
        map.put("is_auto_play", String.valueOf(adUnit.getVideoCommon().is_auto_play));
        map.put("status", String.valueOf(adUnit.getVideoCommon().status));
        a(adUnit, videoLink, (String) null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(HashMap map, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (com.sigmob.sdk.base.utils.e.b(map)) {
                pointEntitySigmob.getOptions().putAll(map);
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, int duration, int endTime) {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, String event, int currentPosition) {
        String str;
        char c;
        String str2;
        char c2;
        b bVar;
        BaseAdUnit baseAdUnit;
        String str3;
        BaseAdUnit baseAdUnit2;
        String str4;
        try {
            try {
                switch (event.hashCode()) {
                    case -2050793311:
                        str = "play_quarter";
                        if (!event.equals(str)) {
                            str2 = "complete";
                            c = 65535;
                            break;
                        } else {
                            c = 11;
                            str2 = "complete";
                            break;
                        }
                    case -1903355519:
                        if (event.equals("show_skip")) {
                            c2 = 4;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -1618089666:
                        if (event.equals("video_link")) {
                            c2 = 7;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -1361632588:
                        if (event.equals("charge")) {
                            c2 = 3;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -1170756021:
                        if (event.equals("video_restart")) {
                            c2 = '\b';
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -1152604194:
                        if (event.equals("ad_hide")) {
                            c2 = 2;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -981662273:
                        if (event.equals(com.sigmob.sdk.base.common.a.f)) {
                            c2 = 16;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -599445191:
                        if (event.equals("complete")) {
                            c2 = 14;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -381416586:
                        if (event.equals(com.sigmob.sdk.base.common.a.g)) {
                            c2 = 17;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case -236894925:
                        if (event.equals("play_three_quarters")) {
                            c2 = StringUtil.CARRIAGE_RETURN;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 3532159:
                        if (event.equals("skip")) {
                            c2 = 5;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 94750088:
                        if (event.equals("click")) {
                            c2 = 15;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 109757538:
                        if (event.equals("start")) {
                            str2 = "complete";
                            str = "play_quarter";
                            c = 0;
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 471706373:
                        if (event.equals("play_two_quarters")) {
                            c2 = '\f';
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 844450526:
                        if (event.equals(com.sigmob.sdk.base.common.a.z)) {
                            str2 = "complete";
                            str = "play_quarter";
                            c = 1;
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 1110780470:
                        if (event.equals("show_close")) {
                            c2 = 6;
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 1382290738:
                        if (event.equals("video_pause")) {
                            c2 = '\n';
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    case 1385608094:
                        if (event.equals("video_start")) {
                            c2 = '\t';
                            str2 = "complete";
                            c = c2;
                            str = "play_quarter";
                            break;
                        }
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                    default:
                        str = "play_quarter";
                        str2 = "complete";
                        c = 65535;
                        break;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            switch (c) {
                case 0:
                    com.sigmob.sdk.base.network.g.a(adUnit, event);
                    a(adUnit, "start", (String) null, (HashMap<String, String>) null);
                    break;
                case 1:
                    bVar = this;
                    bVar.a(adUnit, PointCategory.VCLOSE, (String) null, (HashMap<String, String>) null);
                    break;
                case 2:
                    bVar = this;
                    com.sigmob.sdk.base.network.g.a(adUnit, event);
                    bVar.a(adUnit, "ad_hide", (String) null, (HashMap<String, String>) null);
                    break;
                case 3:
                    bVar = this;
                    com.sigmob.sdk.base.network.g.a(adUnit, event);
                    bVar.a(adUnit, "charge", (String) null, (HashMap<String, String>) null);
                    break;
                case 4:
                    bVar = this;
                    com.sigmob.sdk.base.network.g.a(adUnit, event);
                    bVar.a(adUnit, "show_skip", (String) null, (HashMap<String, String>) null);
                    break;
                case 5:
                    bVar = this;
                    com.sigmob.sdk.base.network.g.a(adUnit, event);
                    bVar.a(adUnit, "skip", (String) null, (HashMap<String, String>) null);
                    break;
                case 6:
                    bVar = this;
                    com.sigmob.sdk.base.network.g.a(adUnit, event);
                    bVar.a(adUnit, "show_close", (String) null, (HashMap<String, String>) null);
                    break;
                case 7:
                    bVar = this;
                    bVar.a(adUnit, "video_link", true, "video_link");
                    break;
                case '\b':
                    bVar = this;
                    SigMacroCommon macroCommon = adUnit.getMacroCommon();
                    macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(adUnit.getVideoCommon().video_time));
                    macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(adUnit.getVideoCommon().begin_time));
                    macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(adUnit.getVideoCommon().end_time));
                    macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(adUnit.getVideoCommon().is_first));
                    macroCommon.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(adUnit.getVideoCommon().is_last));
                    macroCommon.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(adUnit.getVideoCommon().scene));
                    macroCommon.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(adUnit.getVideoCommon().type));
                    macroCommon.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(adUnit.getVideoCommon().is_auto_play));
                    macroCommon.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(adUnit.getVideoCommon().status));
                    com.sigmob.sdk.base.network.g.a(adUnit, "video_restart");
                    HashMap<String, String> map = new HashMap<>();
                    map.put("video_time", String.valueOf(adUnit.getVideoCommon().video_time));
                    map.put("begin_time", String.valueOf(adUnit.getVideoCommon().begin_time));
                    map.put(MetricsSQLiteCacheKt.METRICS_END_TIME, String.valueOf(adUnit.getVideoCommon().end_time));
                    map.put("is_first", String.valueOf(adUnit.getVideoCommon().is_first));
                    map.put("scene", String.valueOf(adUnit.getVideoCommon().scene));
                    map.put("type", String.valueOf(adUnit.getVideoCommon().type));
                    map.put("is_auto_play", String.valueOf(adUnit.getVideoCommon().is_auto_play));
                    map.put("status", String.valueOf(adUnit.getVideoCommon().status));
                    bVar.a(adUnit, "video_restart", (String) null, map);
                    break;
                case '\t':
                    bVar = this;
                    bVar.a(adUnit, "video_start", false, "video_start");
                    break;
                case '\n':
                    bVar = this;
                    bVar.a(adUnit, "video_pause", true, "video_pause");
                    break;
                case 11:
                    bVar = this;
                    baseAdUnit = adUnit;
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, str);
                    str3 = "0.25";
                    bVar.a(baseAdUnit, "play", str3, (HashMap<String, String>) null);
                    break;
                case '\f':
                    bVar = this;
                    baseAdUnit = adUnit;
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_two_quarters");
                    str3 = "0.50";
                    bVar.a(baseAdUnit, "play", str3, (HashMap<String, String>) null);
                    break;
                case '\r':
                    bVar = this;
                    baseAdUnit = adUnit;
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "play_three_quarters");
                    str3 = "0.75";
                    bVar.a(baseAdUnit, "play", str3, (HashMap<String, String>) null);
                    break;
                case 14:
                    bVar = this;
                    String str5 = str2;
                    bVar.a(adUnit, str5, true, str5);
                    break;
                case 15:
                    bVar = this;
                    String str6 = adUnit.getClickCommon().is_final_click ? "1" : "0";
                    SigMacroCommon macroCommon2 = adUnit.getMacroCommon();
                    macroCommon2.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(adUnit.getTemplateId()));
                    macroCommon2.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(adUnit.getClickCommon().click_area));
                    macroCommon2.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(adUnit.getClickCommon().click_scene));
                    macroCommon2.addMarcoKey(SigMacroCommon._FINALCLICK_, str6);
                    com.sigmob.sdk.base.network.g.a(adUnit, "click");
                    HashMap<String, String> map2 = new HashMap<>();
                    map2.put("click_area", adUnit.getClickCommon().click_area);
                    map2.put("click_scene", adUnit.getClickCommon().click_scene);
                    map2.put("template_id", String.valueOf(adUnit.getTemplateId()));
                    map2.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                    map2.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                    map2.put("is_final_click", str6);
                    map2.put("coordinate", macroCommon2.getCoordinate());
                    bVar.a(adUnit, adUnit.getClickCommon().click_scene, "click", map2);
                    break;
                case 16:
                    bVar = this;
                    baseAdUnit2 = adUnit;
                    str4 = "show";
                    bVar.a(baseAdUnit2, PointCategory.FOURELEMENTS, str4, (HashMap<String, String>) null);
                    break;
                case 17:
                    str4 = "close";
                    bVar = this;
                    baseAdUnit2 = adUnit;
                    bVar.a(baseAdUnit2, PointCategory.FOURELEMENTS, str4, (HashMap<String, String>) null);
                    break;
            }
        } catch (Throwable th3) {
            th = th3;
            SigmobLog.e("InterstitialAdViewAbilitySessionrecordDisplayEvent: error = " + th.getMessage());
            return true;
        }
        return true;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, boolean isForceShow, int playheadMillis) {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean b(BaseAdUnit adUnit) {
        com.sigmob.sdk.base.network.g.a(adUnit, "ad_close");
        a(adUnit, "ad_close", (String) null, (HashMap<String, String>) null);
        return true;
    }
}
