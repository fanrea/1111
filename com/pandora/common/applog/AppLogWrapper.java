package com.pandora.common.applog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.ILogger;
import com.bytedance.applog.InitConfig;
import com.pandora.common.BuildConfig;
import com.pandora.common.Constants;
import com.pandora.common.env.Env;
import com.pandora.common.env.config.Config;
import com.pandora.common.utils.TTVideoLog;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppLogWrapper {
    private static final String BYTE_PLUS_LIVE_APPID = "500808";
    private static final String SECOND_APP_ID_KEY = "second_appid";
    private static final String SECOND_APP_NAME_KEY = "second_appname";
    private static final String SECOND_APP_PREFIX = "second_app_";
    private static final String SECOND_APP_PRODUCT_TYPE_KEY = "product_type";
    private static final String SECOND_APP_SPECIAL_KEY = "params_for_special";
    private static final String SECOND_APP_VALUE = "second_app";
    private static final String TAG = "AppLogWrapper";
    private static final String TTSDK_TOB_CUSTOM = "ttsdk_tob_custom";
    private static Object iDataObserver;
    private static IAppLogInstance mBytePlusAppLogInstance;
    private static IAppLogInstance sAppLogInstance;
    private static final HashMap<String, Object> mLogObject = new HashMap<>();
    private static Object mCustomLogLock = new Object();
    private static JSONObject mCustomLogJsonObject = new JSONObject();

    private static synchronized Object dataObserverInstance() {
        if (iDataObserver == null) {
            iDataObserver = new IDataObserver() { // from class: com.pandora.common.applog.AppLogWrapper.1
                @Override // com.bytedance.applog.IDataObserver
                public void onAbVidsChange(String s, String s1) {
                }

                @Override // com.bytedance.applog.IDataObserver
                public void onRemoteAbConfigGet(boolean b, JSONObject jsonObject) {
                }

                @Override // com.bytedance.applog.IDataObserver
                public void onRemoteConfigGet(boolean b, JSONObject jsonObject) {
                }

                @Override // com.bytedance.applog.IDataObserver
                public void onIdLoaded(String s, String s1, String s2) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                    TTVideoLog.d(AppLogWrapper.TAG, "onIdLoaded");
                    AppLogWrapper.updateDeviceID(AppLogWrapper.getDid());
                }

                @Override // com.bytedance.applog.IDataObserver
                public void onRemoteIdGet(boolean b, String s, String s1, String s2, String s3, String s4, String s5) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                    TTVideoLog.d(AppLogWrapper.TAG, "onRemoteIdGet");
                    AppLogWrapper.updateDeviceID(AppLogWrapper.getDid());
                }
            };
        }
        return iDataObserver;
    }

    public static void start() {
        IAppLogInstance iAppLogInstance = sAppLogInstance;
        if (iAppLogInstance == null) {
            TTVideoLog.e(TAG, "sAppLogInstance is null, call init first!");
        } else {
            iAppLogInstance.start();
        }
    }

    public static void init(Context context, String appid, String appRegion, String channel, boolean securityDeviceId, boolean autoStartAppLog) {
        if (sAppLogInstance != null) {
            TTVideoLog.d(TAG, "already init");
            return;
        }
        sAppLogInstance = createAppLogInstance(context, appid, appRegion, channel, autoStartAppLog, securityDeviceId);
        addVersionInfo();
        uploadCacheLog();
    }

    public static IAppLogInstance createAppLogInstance(Context context, String appId, String appRegion, String channel, boolean autoStartAppLog, boolean securityDeviceId) {
        InitConfig initConfig = new InitConfig(appId, channel);
        initConfig.setUriConfig(AppLogParams.getUriConfig(appRegion));
        initConfig.setAutoStart(autoStartAppLog);
        initConfig.setMacEnable(false);
        initConfig.setGaidEnabled(false);
        if (securityDeviceId) {
            TTVideoLog.d(TAG, "init security deviceId");
            initConfig.setImeiEnable(false);
            initConfig.setAndroidIdEnabled(false);
            initConfig.setOaidEnabled(false);
            initConfig.setIccIdEnabled(false);
            initConfig.setSerialNumberEnable(false);
        }
        initConfig.setLogger(new ILogger() { // from class: com.pandora.common.applog.AppLogWrapper.2
            @Override // com.bytedance.applog.ILogger
            public void log(String s, Throwable throwable) {
                TTVideoLog.d(AppLogWrapper.TAG, "AppLogWrapper,AppLog------->:" + s);
                if (throwable != null) {
                    TTVideoLog.d(throwable);
                }
            }
        });
        IAppLogInstance iAppLogInstanceNewInstance = AppLog.newInstance();
        iAppLogInstanceNewInstance.addDataObserver((IDataObserver) dataObserverInstance());
        if (securityDeviceId) {
            iAppLogInstanceNewInstance.setClipboardEnabled(false);
        }
        iAppLogInstanceNewInstance.init(context, initConfig);
        if (securityDeviceId) {
            iAppLogInstanceNewInstance.setForbidReportPhoneDetailInfo(true);
        }
        return iAppLogInstanceNewInstance;
    }

    public static void setAppLogInstance(IAppLogInstance appLogInstance) {
        TTVideoLog.d(TAG, "setAppLogInstance " + appLogInstance);
        sAppLogInstance = appLogInstance;
        if (appLogInstance != null && TextUtils.isEmpty(appLogInstance.getAppId())) {
            sAppLogInstance.addDataObserver((IDataObserver) dataObserverInstance());
        }
        addVersionInfo();
        uploadCacheLog();
    }

    public static IAppLogInstance getAppLogInstance() {
        return sAppLogInstance;
    }

    private static void addVersionInfo() {
        IAppLogInstance iAppLogInstance = sAppLogInstance;
        if (iAppLogInstance != null) {
            iAppLogInstance.setHeaderInfo("ttsdk_version", BuildConfig.TTSDK_VERSION_NAME);
            Config config = Env.getConfig();
            if (config != null && TextUtils.equals(config.getAppRegion(), Constants.AppRegion.MYA)) {
                sAppLogInstance.setHeaderInfo("log_from_region", "volc-overseas");
            }
        }
        IAppLogInstance iAppLogInstance2 = mBytePlusAppLogInstance;
        if (iAppLogInstance2 != null) {
            iAppLogInstance2.setHeaderInfo("ttsdk_version", BuildConfig.TTSDK_VERSION_NAME);
        }
        TTVideoLog.d(TAG, "ttsdk_version 1.42.3.5");
    }

    private static void uploadCacheLog() {
        if (sAppLogInstance == null) {
            return;
        }
        HashMap<String, Object> map = mLogObject;
        synchronized (map) {
            for (String str : map.keySet()) {
                ArrayList arrayList = (ArrayList) mLogObject.get(str);
                for (int i = 0; i < arrayList.size(); i++) {
                    upload(str, (JSONObject) arrayList.get(i));
                }
            }
            mLogObject.clear();
        }
    }

    private static void addEventCache(String event, JSONObject jsonObject) {
        HashMap<String, Object> map = mLogObject;
        synchronized (map) {
            ArrayList arrayList = (ArrayList) map.get(event);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(jsonObject);
            map.put(event, arrayList);
        }
    }

    public static boolean upload(String event, JSONObject jsonObject) {
        IAppLogInstance iAppLogInstance = sAppLogInstance;
        if (iAppLogInstance == null) {
            addEventCache(event, jsonObject);
            TTVideoLog.e(TAG, "upload but not init");
            return false;
        }
        iAppLogInstance.onMiscEvent(event, jsonObject);
        return true;
    }

    public static boolean onBDUploaderEventV3(String event, JSONObject jsonObject) {
        if (sAppLogInstance == null) {
            TTVideoLog.e(TAG, "onBDUploaderEventV3 but not init");
            return false;
        }
        TTVideoLog.d(TAG, "onBDUploaderEventV3 " + event + " " + jsonObject);
        sAppLogInstance.onEventV3(event, jsonObject);
        return true;
    }

    public static boolean onEventV3(String event, JSONObject jsonObject) throws JSONException {
        if (sAppLogInstance == null) {
            addEventCache(event, jsonObject);
            TTVideoLog.e(TAG, "onEventV3 but not init");
            return false;
        }
        TTVideoLog.d("upload", "onEventV3 " + event + " " + jsonObject);
        onInternalEventV3(event, jsonObject, "159973", "159973", event);
        return true;
    }

    public static void onInternalEventV3(String event, JSONObject params, String secondAppId, String secondAppName, String productType) throws JSONException {
        JSONObject jSONObjectAddCustomLog;
        if (sAppLogInstance == null) {
            return;
        }
        if (TextUtils.isEmpty(secondAppId) && TextUtils.isEmpty(secondAppName)) {
            TTVideoLog.e(TAG, "both second appid and second app name is empty");
        }
        if (params == null) {
            params = new JSONObject();
        }
        String str = SECOND_APP_PREFIX + event;
        synchronized (mCustomLogLock) {
            jSONObjectAddCustomLog = addCustomLog(params);
        }
        try {
            jSONObjectAddCustomLog.put(SECOND_APP_SPECIAL_KEY, SECOND_APP_VALUE);
            jSONObjectAddCustomLog.put(SECOND_APP_ID_KEY, secondAppId);
            jSONObjectAddCustomLog.put(SECOND_APP_NAME_KEY, secondAppName);
            jSONObjectAddCustomLog.put(SECOND_APP_PRODUCT_TYPE_KEY, productType);
        } catch (JSONException e) {
            e.printStackTrace();
            TTVideoLog.e(TAG, e.toString());
        }
        sAppLogInstance.onEventV3(str, jSONObjectAddCustomLog);
        TTVideoLog.d(TAG, "onEventV3：" + str + "，" + jSONObjectAddCustomLog);
    }

    public static String getDid() {
        IAppLogInstance iAppLogInstance = sAppLogInstance;
        return iAppLogInstance == null ? "" : iAppLogInstance.getDid();
    }

    public static String getUserUniqueID() {
        IAppLogInstance iAppLogInstance = sAppLogInstance;
        return iAppLogInstance == null ? "" : iAppLogInstance.getUserUniqueID();
    }

    public static void setAppLogCustomData(JSONObject jsonObject) {
        synchronized (mCustomLogLock) {
            mCustomLogJsonObject = jsonObject;
        }
    }

    private static JSONObject addCustomLog(JSONObject sdkParams) throws JSONException {
        JSONObject jSONObject = mCustomLogJsonObject;
        if (jSONObject != null && jSONObject.length() > 0 && sdkParams != null) {
            try {
                sdkParams.put(TTSDK_TOB_CUSTOM, mCustomLogJsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sdkParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateDeviceID(String deviceID) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        TTVideoLog.d(TAG, "updateDeviceID:" + deviceID);
        if (TextUtils.isEmpty(deviceID)) {
            return;
        }
        try {
            Class<?> cls = Class.forName(Env.VOD_SDK_CLASS_NAME);
            cls.getMethod("updateDeviceID", String.class).invoke(cls, deviceID);
        } catch (Exception e) {
            TTVideoLog.d(TAG, "updateDeviceID " + e);
            e.printStackTrace();
        }
    }
}
