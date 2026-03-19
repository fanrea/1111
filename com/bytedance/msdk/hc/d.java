package com.bytedance.msdk.hc;

import android.text.TextUtils;
import com.bytedance.msdk.core.tc.tc;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.kwad.sdk.api.model.AdnName;
import io.reactivex.annotations.SchedulerSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    public static String d(int i) {
        return i == 3 ? "gdt" : i == 2 ? "admob" : i == 1 ? "pangle" : i == 4 ? "mintegral" : i == 5 ? "unity" : i == 6 ? AdnName.BAIDU : i == 7 ? "ks" : i == 8 ? "sigmob" : i == 9 ? "klevin" : i == 10 ? "xiaomi" : i == -1 ? SchedulerSupport.CUSTOM : "";
    }

    public static String d(int i, int i2) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                return i2 == 4 ? "Native" : i2 == 5 ? "Draw" : i2 == 3 ? "Banner" : "Native";
            case 6:
            default:
                return null;
            case 7:
                return (i2 != 6 && i2 == 7) ? "FullVideo" : "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                if (i2 == 1) {
                    return ExploreConstants.SCENE_INTERSTITIAL;
                }
                if (i2 == 2) {
                    return "FullVideo";
                }
                return null;
        }
    }

    public static String hc(int i) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                return "Native";
            case 6:
            default:
                return "UnKnow";
            case 7:
                return "RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "Draw";
            case 10:
                return "InterstitialFull";
        }
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase("gdt") ? "gdt" : str.equalsIgnoreCase("admob") ? "admob" : str.equalsIgnoreCase("pangle") ? "pangle" : str.equalsIgnoreCase("mintegral") ? "mintegral" : str.equalsIgnoreCase("unity") ? "unity" : str.equalsIgnoreCase(AdnName.BAIDU) ? AdnName.BAIDU : str.equalsIgnoreCase("ks") ? "ks" : str.equalsIgnoreCase("sigmob") ? "sigmob" : str.equalsIgnoreCase("klevin") ? "klevin" : str.equalsIgnoreCase("xiaomi") ? "xiaomi" : str;
    }

    public static int hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("gdt")) {
            return 3;
        }
        if (str.startsWith("admob")) {
            return 2;
        }
        if (str.equalsIgnoreCase("pangle")) {
            return 1;
        }
        if (str.equalsIgnoreCase("mintegral")) {
            return 4;
        }
        if (str.equalsIgnoreCase("unity")) {
            return 5;
        }
        if (str.equalsIgnoreCase(AdnName.BAIDU)) {
            return 6;
        }
        if (str.equalsIgnoreCase("ks")) {
            return 7;
        }
        if (str.equalsIgnoreCase("sigmob")) {
            return 8;
        }
        if (str.equalsIgnoreCase("klevin")) {
            return 9;
        }
        return str.equalsIgnoreCase("xiaomi") ? 10 : -1;
    }

    public static String d(int i, int i2, tc tcVar) {
        switch (i) {
            case 1:
                return "Banner";
            case 2:
                return ExploreConstants.SCENE_INTERSTITIAL;
            case 3:
            case 4:
                return ExploreConstants.SCENE_SPLASH;
            case 5:
                return i2 == 4 ? (tcVar == null || tcVar.tc() != 1) ? "Native-自渲染" : "Native-模板渲染" : i2 == 5 ? "NativeDraw" : i2 == 3 ? "Banner" : "Native-自渲染";
            case 6:
            default:
                return null;
            case 7:
                return (i2 != 6 && i2 == 7) ? "Reward_FullVideo" : "Reward_RewardVideo";
            case 8:
                return "FullVideo";
            case 9:
                return "NativeDraw";
            case 10:
                if (i2 == 1) {
                    return "InterstitialFull—Interstitial";
                }
                if (i2 == 2) {
                    return "InterstitialFull—FullVideo";
                }
                return null;
        }
    }
}
