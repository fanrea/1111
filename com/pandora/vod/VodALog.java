package com.pandora.vod;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.vcloud.cacheModule.utils.CmLog;
import com.bytertc.volcbaselog.VolcBaseLogConfig;
import com.bytertc.volcbaselog.VolcBaseLogNative;
import com.pandora.common.applog.AppLogWrapper;
import com.pandora.common.utils.TTVideoLog;
import com.ss.ttvideoengine.setting.SettingsHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineLogListener;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodALog {
    private static final String DEFAULT_LOG_DIR = "VolcVodLog";
    private static final int DEFAULT_LOG_EXPIRE_TIME_S = 604800;
    private static final int DEFAULT_MAX_LOG_SIZE_M = 100;
    private static final int DEFAULT_QUERY_INTERVAL = 120000;
    private static final int DEFAULT_SING_LOG_SIZE_M = 2;
    private static final long HANDLER_INVALID = -1;
    private static final String TAG = "VodALog";
    private static final String VOLC_BASE_LOG_CLASS = "com.bytertc.volcbaselog.VolcBaseLogNative";
    private static Class<?> sALogClass = null;
    private static Context sAppContext = null;
    private static boolean sEnableLogFile = false;
    private static boolean sEnableQuery = false;
    private static long sHandler = -1;
    private static int sLogExpireTimeS;
    private static int sMaxLogSizeM;
    private static int sQueryInterval;
    private static String sQueryUrl;
    private static int sSingLogSizeM;

    static synchronized void init() {
        Context context = sAppContext;
        if (!isALogExist()) {
            TTVideoLog.d(TAG, "init alog not exist");
            return;
        }
        if (context == null) {
            return;
        }
        if (sHandler != -1) {
            return;
        }
        String did = AppLogWrapper.getDid();
        TTVideoLog.d(TAG, "init deviceID:" + did);
        if (TextUtils.isEmpty(did)) {
            return;
        }
        updateSettings();
        if (!sEnableLogFile) {
            TTVideoLog.d(TAG, "init settings disable alog");
            return;
        }
        VolcBaseLogConfig volcBaseLogConfig = new VolcBaseLogConfig();
        volcBaseLogConfig.logPath = context.getFilesDir().getAbsolutePath() + File.separator + DEFAULT_LOG_DIR;
        volcBaseLogConfig.enableStdout = false;
        volcBaseLogConfig.logLevel = 1;
        volcBaseLogConfig.enableLogFile = sEnableLogFile;
        volcBaseLogConfig.enableThreadLoop = sEnableQuery;
        volcBaseLogConfig.query_url = sQueryUrl;
        volcBaseLogConfig.interval = sQueryInterval;
        volcBaseLogConfig.maxLogSize = sMaxLogSizeM;
        volcBaseLogConfig.singleLogSize = sSingLogSizeM;
        volcBaseLogConfig.logExpireTime = sLogExpireTimeS;
        sHandler = VolcBaseLogNative.init(volcBaseLogConfig, 20, did);
        TTVideoLog.d(TAG, "init handler:" + sHandler + ", deviceID:" + did);
        TTVideoEngineLog.setListener(new TTVideoEngineLogListener() { // from class: com.pandora.vod.VodALog.1
            public void consoleLog(final String log) {
                VolcBaseLogNative.writeLogContent(VodALog.sHandler, 1, log);
            }
        });
        CmLog.setAlogCallback(new CmLog.AlogCallback() { // from class: com.pandora.vod.VodALog.2
            public void onLogCallback(CmLog.LogLevel logLevel, String tag, String msg) {
                String str = "cacheModule: tag = " + tag + ";  logLevel = " + logLevel + ";  " + msg;
                if (TTVideoEngineLog.d()) {
                    TTVideoEngineLog.d(tag, msg);
                }
                VolcBaseLogNative.writeLogContent(VodALog.sHandler, 1, str);
            }
        });
    }

    static void setAppContext(final Context appContext) {
        if (appContext == null) {
            return;
        }
        sAppContext = appContext;
    }

    private static void updateSettings() {
        JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("alog_config");
        if (vodJsonObject == null) {
            return;
        }
        sEnableLogFile = vodJsonObject.optInt("enable_log_file", 0) > 0;
        sEnableQuery = vodJsonObject.optInt("enable_query", 0) > 0;
        sQueryInterval = vodJsonObject.optInt("query_interval", DEFAULT_QUERY_INTERVAL);
        sMaxLogSizeM = vodJsonObject.optInt("max_log_size", 100);
        sSingLogSizeM = vodJsonObject.optInt("single_log_file_size", 2);
        sLogExpireTimeS = vodJsonObject.optInt("log_expire_time", DEFAULT_LOG_EXPIRE_TIME_S);
        sQueryUrl = vodJsonObject.optString("query_url", "");
    }

    private static synchronized boolean isALogExist() {
        if (sALogClass != null) {
            return true;
        }
        try {
            Class<?> cls = Class.forName(VOLC_BASE_LOG_CLASS);
            sALogClass = cls;
            return cls != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
