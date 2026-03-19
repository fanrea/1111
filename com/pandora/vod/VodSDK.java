package com.pandora.vod;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.vcloud.cacheModule.utils.CmLog;
import com.bytedance.vodsetting.SettingsListener;
import com.google.android.exoplayer2.util.Log;
import com.pandora.common.Constants;
import com.pandora.common.env.config.Config;
import com.pandora.common.env.config.VodConfig;
import com.pandora.common.utils.TTVideoLog;
import com.pandora.ttlicense2.LicenseManager;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.ttvideoengine.EngineAdapter;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodSDK {
    private static final String TAG = "VodSDK";

    public static void init(Config config) {
        EngineAdapter.setsDeviceIdListener(new EngineAdapter.DeviceIdListener() { // from class: com.pandora.vod.VodSDK.1
            public void onDeviceIdUpdate(final String deviceId) {
                VodALog.init();
            }
        });
        HashMap map = new HashMap();
        map.put("appname", config.getAppName());
        map.put("appid", config.getAppID());
        map.put(Constants.APPLog.APP_CHANNEL, config.getAppChannel());
        map.put(Constants.APPLog.APP_REGION, config.getAppRegion());
        map.put(Constants.APPLog.APP_VERSION, config.getAppVersion());
        TTVideoEngine.setAppInfo(config.getApplicationContext(), map);
        initMDL(config);
        VodALog.init();
    }

    private static void initMDL(final Config config) {
        Context applicationContext = config.getApplicationContext();
        VodConfig vodConfig = config.getVodConfig();
        int maxCacheSize = vodConfig.getMaxCacheSize();
        String cacheDirPath = vodConfig.getCacheDirPath();
        int loaderType = vodConfig.getLoaderType();
        TTVideoEngine.setStringValue(0, cacheDirPath);
        TTVideoEngine.setIntValue(1, maxCacheSize);
        TTVideoEngine.setIntValue(9008, 1);
        TTVideoEngine.setIntValue(5, loaderType);
        try {
            TTVideoEngine.startDataLoader(applicationContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initLog(final Context context, String deviceID) {
        VodALog.setAppContext(context.getApplicationContext());
        SettingsHelper.helper().addListener(new SettingsListener() { // from class: com.pandora.vod.VodSDK.2
            public void onNotify(String module, int i) {
                if (TextUtils.equals("vod", module)) {
                    VodALog.init();
                }
            }
        });
        VodALog.init();
    }

    public static void updateDeviceID(String deviceID) {
        EngineAdapter.updateDeviceId();
        VodALog.init();
    }

    public static void openAllVodLog() {
        TTVideoLog.turnOn(1, 1);
        TTVideoEngineLog.turnOn(1, 1);
        TTVideoEngine.setPlayerOutputLog(1);
        AVMDLLog.turnOn(1, 1);
        try {
            LicenseManager.turnOnLogcat(true);
        } catch (Exception e) {
            TTVideoEngineLog.d(TAG, "open LicenseLog e:" + e);
        }
        try {
            CmLog.turnLogLevel(CmLog.LogLevel.V, true);
        } catch (Exception e2) {
            TTVideoEngineLog.d(TAG, "open CacheModule e:" + e2);
        }
        try {
            Log.setLogcatOutPut(true);
        } catch (Throwable th) {
            TTVideoEngineLog.d(TAG, "open exo log e:" + th);
        }
    }
}
