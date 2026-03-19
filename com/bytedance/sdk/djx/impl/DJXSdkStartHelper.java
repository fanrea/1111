package com.bytedance.sdk.djx.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.m.k.b;
import com.bytedance.sdk.djx.ad.AdManagerAdpater;
import com.bytedance.sdk.djx.ad.AdSdkAdapter;
import com.bytedance.sdk.djx.ad.IPluginListener;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.internal.IDJXSdkInternal;
import com.bytedance.sdk.djx.internal.utils.DJXLogger;
import com.bytedance.sdk.djx.internal.utils.MetaDataUtils;
import com.bytedance.sdk.djx.log.DJXApiLazyReporter;
import com.bytedance.sdk.djx.settings.DJXGlobalSettings;
import com.bytedance.sdk.djx.utils.AdSdkUtils;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.DJXThread;
import com.bytedance.sdk.djx.utils.DPFixHelper;
import com.bytedance.sdk.djx.utils.HostContext;
import com.bytedance.sdk.djx.utils.Utils;
import com.bytedance.sdk.djx.utils.ZeusUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXSdkStartHelper {
    public static final String DJXSDK_IMPL_CLASS_NAME = "com.bytedance.sdk.djx.core.DJXSdkImpl";
    private static final String TAG = "DJXSdkStartHelper";
    public static volatile Boolean isRunningPlugin = null;
    public static long sStartTime = -1;
    private String mConfigName;
    private Context mContext;
    private DJXSdkPrepareListener mPrepareListener;
    private boolean mInstalled = false;
    private boolean mPluginLoaded = false;
    private volatile boolean isPrepared = false;

    public interface DJXSdkPrepareListener {
        void onPrepared(IDJXSdkInternal iDJXSdkInternal);
    }

    public void prepare(Context context, String str, DJXSdkPrepareListener dJXSdkPrepareListener) {
        this.mContext = context;
        this.mConfigName = str;
        if (this.isPrepared) {
            if (dJXSdkPrepareListener != null) {
                dJXSdkPrepareListener.onPrepared(getDJXSdkImpl());
                return;
            }
            return;
        }
        this.mPrepareListener = dJXSdkPrepareListener;
        boolean pluginMode = DJXGlobalSettings.getInstance().getPluginMode();
        this.mInstalled = ZeusUtils.isPluginInstalled(DJXSdkUtils.getPluginPackageName());
        boolean zCheckAdSdkVersion = DJXGlobalSettings.getInstance().checkAdSdkVersion();
        DJXLogger.d(TAG, "plugin mode:" + pluginMode + ", " + DJXSdkUtils.getPluginPackageName() + " plugin isInstalled:" + this.mInstalled + ", isAdVersionOk: " + zCheckAdSdkVersion);
        if (Utils.IS_P) {
            DJXLogger.d(TAG, "start loading plugin");
            isRunningPlugin = true;
            fetchAndLoadPlugin();
        } else {
            if (pluginMode && zCheckAdSdkVersion) {
                if (this.mInstalled) {
                    DJXLogger.d(TAG, "start loading plugin");
                    fetchAndLoadPlugin();
                    return;
                } else {
                    isRunningPlugin = false;
                    DJXLogger.d(TAG, "start running aar, meanwhile loading plugin");
                    onPrepared();
                    fetchAndLoadPlugin();
                    return;
                }
            }
            DJXLogger.d(TAG, "start running aar");
            isRunningPlugin = false;
            onPrepared();
        }
    }

    public void rePrepare(DJXSdkPrepareListener dJXSdkPrepareListener) {
        DJXLogger.d(TAG, "rePrepare: ");
        this.mPrepareListener = dJXSdkPrepareListener;
        isRunningPlugin = false;
        onPrepared();
    }

    private void fetchAndLoadPlugin() {
        AdManagerAdpater adManager = AdSdkAdapter.getAdManager();
        if (adManager != null) {
            DJXApiLazyReporter.logEventRegisterStart(this.mInstalled, "2.9.0.2");
            adManager.register(new DJXSdkPluginListener());
            return;
        }
        throw new RuntimeException("TTAdSdk has not been initialized, please initialize DJXSdk after that");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepared() {
        this.isPrepared = true;
        this.mPrepareListener.onPrepared(getDJXSdkImpl());
        fixDPVideoLicense();
    }

    private void fixDPVideoLicense() {
        if (isRunningPlugin != null && isRunningPlugin.booleanValue() && this.mPluginLoaded) {
            DPFixHelper.fix(this.mContext, this.mConfigName);
        }
    }

    private IDJXSdkInternal getDJXSdkImpl() {
        try {
            return (IDJXSdkInternal) getDJXSdkClassLoader().loadClass(DJXSDK_IMPL_CLASS_NAME).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            DJXLogger.d(TAG, "DJXSdkImpl class load failed");
            e.printStackTrace();
            return null;
        }
    }

    public ClassLoader getDJXSdkClassLoader() {
        if (isRunningPlugin != null && isRunningPlugin.booleanValue() && this.mPluginLoaded) {
            ClassLoader pluginClassLoader = ZeusUtils.getPluginClassLoader(DJXSdkUtils.getPluginPackageName());
            DJXLogger.d(TAG, "Current Running Code: PLUGIN");
            return pluginClassLoader;
        }
        ClassLoader classLoader = DJXSdkInstance.getInstance().getClass().getClassLoader();
        DJXLogger.d(TAG, "Current Running Code: AAR");
        return classLoader;
    }

    public class DJXSdkPluginListener implements IPluginListener {
        public DJXSdkPluginListener() {
        }

        @Override // com.bytedance.sdk.djx.ad.IPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, final Bundle bundle) {
            if (AdSdkUtils.isPluginSdk()) {
                if (i == 1000 && classLoader != null) {
                    DJXThread.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.djx.impl.DJXSdkStartHelper.DJXSdkPluginListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int pluginVersion;
                            if (!DJXSdkStartHelper.this.mPluginLoaded && (pluginVersion = ZeusUtils.getPluginVersion(DJXSdkPluginListener.this.packageName())) >= 0) {
                                DJXApiLazyReporter.logEventRegisterFinish(DJXSdkStartHelper.this.mInstalled, "2.9.0.2", 1, 0, String.valueOf(pluginVersion), SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime);
                                DJXSdkStartHelper.this.mPluginLoaded = true;
                                DJXLogger.d(DJXSdkStartHelper.TAG, "DJXSdk plugin load success, plugin version = " + pluginVersion);
                                if (!DJXSdkStartHelper.this.isPrepared) {
                                    if (DJXLogger.DEBUG) {
                                        Toast.makeText(DJXSdkStartHelper.this.mContext, "短剧插件加载成功" + pluginVersion, 0).show();
                                    }
                                    DJXSdkStartHelper.isRunningPlugin = true;
                                    DJXSdkStartHelper.this.onPrepared();
                                    DJXLogger.d(DJXSdkStartHelper.TAG, "DJXSdk has not been prepared, need to load plugin");
                                    return;
                                }
                                DJXLogger.d(DJXSdkStartHelper.TAG, "DJXSdk has been prepared, no need to load plugin");
                            }
                        }
                    });
                    return;
                }
                if (i == 1001) {
                    DJXLogger.e(DJXSdkStartHelper.TAG, "plugin fetch and load failed");
                    DJXThread.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.djx.impl.DJXSdkStartHelper.DJXSdkPluginListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DJXSdkStartHelper.this.mPluginLoaded = false;
                            Bundle bundle2 = bundle;
                            DJXApiLazyReporter.logEventRegisterFinish(DJXSdkStartHelper.this.mInstalled, "2.9.0.2", 0, bundle2 != null ? bundle2.getInt("code", -1) : -1, "", SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime);
                            if (!DJXSdkStartHelper.this.isPrepared) {
                                DJXLogger.d(DJXSdkStartHelper.TAG, "DJXSdk has been prepared, need to process plugin failed event");
                                if (Utils.IS_P) {
                                    DJXLogger.d(DJXSdkStartHelper.TAG, "IS_P = true, prepare failed");
                                    DJXSdkStartHelper.this.onPrepared();
                                    return;
                                } else {
                                    DJXLogger.d(DJXSdkStartHelper.TAG, "turn into loading aar");
                                    DJXSdkStartHelper.isRunningPlugin = false;
                                    DJXSdkStartHelper.this.onPrepared();
                                    return;
                                }
                            }
                            DJXLogger.d(DJXSdkStartHelper.TAG, "DJXSdk has been prepared, no need to process plugin failed event");
                        }
                    });
                } else if (i == 1) {
                    DJXLogger.d(DJXSdkStartHelper.TAG, "plugin is loading...");
                }
            }
        }

        @Override // com.bytedance.sdk.djx.ad.IPluginListener
        public String packageName() {
            return DJXSdkUtils.getPluginPackageName();
        }

        @Override // com.bytedance.sdk.djx.ad.IPluginListener
        public Bundle config() {
            return DJXSdkStartHelper.getPluginConfig();
        }
    }

    public static Bundle getPluginConfig() {
        Bundle bundle = new Bundle();
        String str = (String) MetaDataUtils.getMetaDataInApp(HostContext.getContext(), DJXSdkUtils.getMetaDataName());
        if (str != null) {
            try {
                bundle.putString("sdk_version", TextUtils.join(".", new JSONObject(str).optString("apiVersionCode").split("(?!^)")));
                bundle.putString(ILogConst.Keys.KEY_PLUGIN_VERSION, "0.0.0.0");
                if (TextUtils.isEmpty(DJXGlobalSettings.getInstance().getSiteId())) {
                    DJXGlobalSettings.getInstance().initSiteId(getInstance().mContext, getInstance().mConfigName);
                }
                bundle.putString(b.D0, DJXGlobalSettings.getInstance().getSiteId());
                DJXLogger.d(TAG, "bundle = " + bundle);
            } catch (JSONException unused) {
            }
        }
        return bundle;
    }

    public static DJXSdkStartHelper getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final DJXSdkStartHelper instance = new DJXSdkStartHelper();

        private InnerHolder() {
        }
    }
}
