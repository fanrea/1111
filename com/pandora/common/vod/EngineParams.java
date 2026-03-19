package com.pandora.common.vod;

import android.text.TextUtils;
import android.util.Log;
import com.pandora.common.Constants;
import com.pandora.common.env.Env;
import com.pandora.common.env.config.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EngineParams {
    public static String getDefaultAppRegion() {
        return "china";
    }

    public static String getDefaultSmartHost() {
        return "vod-api-smart-strategy-lite.volcvod.com";
    }

    public static String getDefaultVodTopHost() {
        return Constants.APPLog.DEFAULT_VOD_TOP_HOST;
    }

    public static String getDefaultVodTopHostV2() {
        Config config = Env.getConfig();
        if (config != null) {
            return TextUtils.equals(config.getAppRegion(), Constants.AppRegion.MYA) ? "vod.ap-southeast-1.volcengineapi.com" : "vod.volcengineapi.com";
        }
        Log.e("TTSDK", "Call Env.init first!", new NullPointerException("TTSDK init config is null!"));
        return null;
    }

    public static String getSettingHost() {
        Config config = Env.getConfig();
        if (config != null) {
            return TextUtils.equals(config.getAppRegion(), Constants.AppRegion.MYA) ? "vod-settings.ap-southeast-1.volcvod.com" : "vod-settings.volcvod.com";
        }
        Log.e("TTSDK", "Call Env.init first!", new NullPointerException("TTSDK init config is null!"));
        return null;
    }
}
