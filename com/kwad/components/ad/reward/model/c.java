package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.c.f;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;
    public final boolean lb = com.kwad.components.ad.reward.a.b.hR();

    public static c a(Intent intent) {
        KsVideoPlayConfig ksVideoPlayConfigB;
        if (e.YT()) {
            ksVideoPlayConfigB = com.kwad.components.core.internal.api.e.b(intent.getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
            if (!(serializableExtra instanceof KsVideoPlayConfig)) {
                com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
                return null;
            }
            ksVideoPlayConfigB = (KsVideoPlayConfig) serializableExtra;
        }
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        try {
            AdResultData adResultDataD = f.ot().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true);
            if (adResultDataD == null) {
                return null;
            }
            return a(adResultDataD, intExtra, ksVideoPlayConfigB);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private static c a(AdResultData adResultData, int i, KsVideoPlayConfig ksVideoPlayConfig) {
        c cVar = new c();
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        if (adTemplateS == null) {
            com.kwad.sdk.core.d.c.e("RewardActivityModel", "data is null:");
            return null;
        }
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplateS);
        if (!c(adTemplateS, adInfoEP)) {
            return null;
        }
        boolean zIsShowLandscape = ksVideoPlayConfig.isShowLandscape();
        adTemplateS.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdResultData = adResultData;
        cVar.mAdTemplate = adTemplateS;
        cVar.mAdInfo = adInfoEP;
        cVar.mScreenOrientation = zIsShowLandscape ? 1 : 0;
        cVar.rewardType = i;
        return cVar;
    }

    private static boolean c(AdTemplate adTemplate, AdInfo adInfo) {
        if (!e.YT() && com.kwad.sdk.core.response.b.e.fb(adTemplate) < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(com.kwad.sdk.core.response.b.a.L(adInfo));
            if (fileDw == null || !fileDw.exists()) {
                return false;
            }
        }
        return true;
    }

    public final boolean iw() {
        return com.kwad.sdk.core.response.b.e.k(getAdTemplate(), com.kwad.components.ad.reward.a.b.k(cZ()));
    }

    public final boolean ix() {
        return com.kwad.sdk.core.response.b.e.P(getAdTemplate());
    }

    public final boolean da() {
        return com.kwad.sdk.core.response.b.e.eX(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final AdResultData iy() {
        return this.mAdResultData;
    }

    public final AdInfo cZ() {
        return this.mAdInfo;
    }

    public final KsVideoPlayConfig iz() {
        return this.mVideoPlayConfig;
    }

    public final int iA() {
        return this.rewardType;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final JSONObject iB() {
        return this.mReportExtData;
    }

    public final AdGlobalConfigInfo iC() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.adGlobalConfigInfo;
        }
        return null;
    }
}
