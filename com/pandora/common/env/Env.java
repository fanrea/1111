package com.pandora.common.env;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.IDataObserver;
import com.pandora.common.BuildConfig;
import com.pandora.common.applog.AppLogWrapper;
import com.pandora.common.applog.IAppLogEngine;
import com.pandora.common.env.config.Config;
import com.pandora.common.env.config.LogConfig;
import com.pandora.common.utils.AppLogUtils;
import com.pandora.common.utils.TTVideoLog;
import com.pandora.ttlicense2.LicenseManager;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Env {
    public static final String STRATEGY_SDK_CLASS_NAME = "com.pandora.ttlivestrategy.TTLiveStrategySDK";
    private static final String TAG = "Env";
    public static final String VELIVEPLAYER_SDK_CLASS_NAME = "com.pandora.live.player.TTVeLivePlayerSDK";
    public static final String VELIVEPUSHER_SDK_CLASS_NAME = "com.pandora.live.TTVeLivePusherSDK";
    public static final String VOD_SDK_CLASS_NAME = "com.pandora.vod.VodSDK";
    private static IAppLogEngine mAppLogClient = null;
    private static boolean mShouldInitApplog = true;
    private static Config sConfig = null;
    private static Env sEnv = null;
    private static boolean sSecurityDeviceId = true;
    private SdkContextEnv mSdkContextEnv;

    @Deprecated
    public interface SdkContextEnv {
        String getAppID();

        String getAppName();

        String getAppRegion();

        Context getApplicationContext();

        Thread.UncaughtExceptionHandler getUncaughtExceptionHandler();
    }

    public static String getBuildType() {
        return "release";
    }

    public static String getVersion() {
        return BuildConfig.TTSDK_VERSION_NAME;
    }

    public static int getVersionCode() {
        return 1803;
    }

    private Env() {
    }

    @Deprecated
    public static Env get() {
        synchronized (Env.class) {
            if (sEnv == null) {
                sEnv = new Env();
            }
        }
        return sEnv;
    }

    @Deprecated
    public static Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return get().mSdkContextEnv.getUncaughtExceptionHandler();
    }

    public static void openAppLog(boolean isOpenAppLog) {
        mShouldInitApplog = isOpenAppLog;
    }

    public static void setUseSecurityDeviceId(boolean securityDeviceId) {
        TTVideoLog.d(TAG, "setUseSecurityDeviceId " + securityDeviceId);
        sSecurityDeviceId = securityDeviceId;
    }

    public static boolean isSecurityDeviceId() {
        return sSecurityDeviceId;
    }

    @Deprecated
    public static void setupSDKEnv(SdkContextEnv sdkContextEnv) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        get().mSdkContextEnv = sdkContextEnv;
        Config configBuild = new Config.Builder().setApplicationContext(sdkContextEnv.getApplicationContext()).setAppID(sdkContextEnv.getAppID()).setAppName(sdkContextEnv.getAppName()).setAppRegion(sdkContextEnv.getAppRegion()).setAppChannel(sdkContextEnv.getAppName()).build();
        TTVideoLog.d(TAG, "setup TTSDK Version " + getVersion() + " " + configBuild);
        initAppLog(configBuild);
        initVodLog(configBuild);
    }

    public static void start(Config config) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        setConfig(config);
        TTVideoLog.d(TAG, "start TTSDK Version " + getVersion() + " " + config);
        initLicense(config);
        initVodSDK(config);
        initLiveSDK();
    }

    public static void init(Config config) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        setConfig(config);
        TTVideoLog.d(TAG, "init TTSDK Version " + getVersion() + " " + config);
        initLicense(config);
        initAppLog(config);
        initVodSDK(config);
        initLiveSDK();
    }

    private static synchronized void setConfig(Config config) {
        sConfig = config;
    }

    public static synchronized Config getConfig() {
        return sConfig;
    }

    public static void startAppLog() {
        TTVideoLog.d(TAG, "startAppLog");
        AppLogUtils.startAppLog();
    }

    private static void initLiveSDK() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (TextUtils.isEmpty(getDeviceID()) && AppLogUtils.isAppLogExist()) {
            return;
        }
        initLiveStrategy();
        initVeLivePlayerLog();
        initVeLivePusherLog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initLiveStrategy() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(STRATEGY_SDK_CLASS_NAME);
            cls.getMethod(PointCategory.INIT, LogConfig.class).invoke(cls, getConfig().getLogConfig());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initVeLivePlayerLog() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(VELIVEPLAYER_SDK_CLASS_NAME);
            cls.getMethod("setLogConfig", LogConfig.class).invoke(cls, getConfig().getLogConfig());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initVeLivePusherLog() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(VELIVEPUSHER_SDK_CLASS_NAME);
            cls.getMethod("setLogConfig", LogConfig.class).invoke(cls, getConfig().getLogConfig());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    private static String getDeviceID() {
        if (!AppLogUtils.isAppLogExist() || AppLogWrapper.getAppLogInstance() == null) {
            return "";
        }
        String did = AppLogWrapper.getDid();
        if (!TextUtils.isEmpty(did)) {
            return did;
        }
        AppLogWrapper.getAppLogInstance().addDataObserver(new IDataObserver() { // from class: com.pandora.common.env.Env.1
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
                TTVideoLog.i(Env.TAG, "getDeviceID addDataObserver,onIdLoaded:" + s + ",s1:" + s1 + ",s2:" + s2);
                Env.initLiveStrategy();
                Env.initVeLivePlayerLog();
                Env.initVeLivePusherLog();
            }

            @Override // com.bytedance.applog.IDataObserver
            public void onRemoteIdGet(boolean b, String s, String s1, String s2, String s3, String s4, String s5) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                TTVideoLog.i(Env.TAG, "getDeviceID addDataObserver,onRemoteIdGet:" + s + ",s1:" + s1 + ",s2:" + s2);
                Env.initLiveStrategy();
                Env.initVeLivePlayerLog();
                Env.initVeLivePusherLog();
            }
        });
        return did;
    }

    private static void initLicense(Config config) {
        Context applicationContext = config.getApplicationContext();
        String licenseUri = config.getLicenseUri();
        if (applicationContext == null) {
            return;
        }
        try {
            LicenseManager.init(applicationContext);
            if (TextUtils.isEmpty(licenseUri)) {
                return;
            }
            LicenseManager.getInstance().addLicense(licenseUri, config.getLicenseCallback());
        } catch (Exception e) {
            TTVideoLog.d(TAG, "initLicense exception:" + e);
        }
    }

    private static void initVodSDK(Config config) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        initVodLog(config);
        try {
            Class<?> cls = Class.forName(VOD_SDK_CLASS_NAME);
            cls.getMethod(PointCategory.INIT, Config.class).invoke(cls, config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initVodLog(Config config) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(VOD_SDK_CLASS_NAME);
            cls.getMethod("initLog", Context.class, String.class).invoke(cls, config.getApplicationContext(), "");
        } catch (Exception e) {
            TTVideoLog.d(TAG, "initVodLog " + e);
            e.printStackTrace();
        }
    }

    public static void initAppLog(Config config) {
        sSecurityDeviceId = sSecurityDeviceId || config.isSecurityDeviceId();
        if (mShouldInitApplog && AppLogUtils.isAppLogExist() && config != null) {
            AppLogUtils.init(config.getApplicationContext(), config.getAppID(), config.getAppRegion(), config.getAppChannel(), sSecurityDeviceId, config.isAutoStartAppLog());
        }
    }

    public static void setAppLogCustomData(JSONObject jsonObject) {
        AppLogWrapper.setAppLogCustomData(jsonObject);
    }

    public static void setAppLogClient(IAppLogEngine logClient) {
        mAppLogClient = logClient;
    }

    public static IAppLogEngine getAppLogClient() {
        return mAppLogClient;
    }

    public static void openDebugLog(boolean z) {
        TTVideoLog.turnOn(1, z ? 1 : 0);
    }

    public static Context getApplicationContext() {
        return getConfig().getApplicationContext();
    }

    private static Object getTTSDKFieldValue(String fieldName) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("com.pandora.ttsdk.BuildConfig");
            return cls.getField(fieldName).get(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public static String getFlavor() {
        String str = (String) getTTSDKFieldValue("FLAVOR");
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    public static String getAppID() {
        return getConfig().getAppID();
    }

    public static String getAppName() {
        return getConfig().getAppName();
    }

    public static String getAppRegion() {
        return getConfig().getAppRegion();
    }

    @Deprecated
    public static SdkContextEnv getEnv() {
        return get().mSdkContextEnv;
    }
}
