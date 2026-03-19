package com.bytedance.sdk.djx.core.init;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.commonsdk.api.IGetNewTokenApiConfigCallback;
import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService;
import com.bytedance.sdk.commonsdk.api.utils.AppLogDidUtils;
import com.bytedance.sdk.commonsdk.api.utils.CommonSdkUtils;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IBaseStartListener;
import com.bytedance.sdk.djx.StartError;
import com.bytedance.sdk.djx.base.APMHelper;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.base.dynamic.DynamicModel;
import com.bytedance.sdk.djx.base.dynamic.OnDynamicUpdateListener;
import com.bytedance.sdk.djx.base.dynamic.api.DynamicRsp;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.act.DJXGlobalReceiver;
import com.bytedance.sdk.djx.core.init.helper.DJXABHelper;
import com.bytedance.sdk.djx.core.init.helper.MiniappHelper;
import com.bytedance.sdk.djx.core.init.helper.NetInjectImpl;
import com.bytedance.sdk.djx.core.init.helper.OAIDHelper;
import com.bytedance.sdk.djx.core.init.helper.PLTHelper;
import com.bytedance.sdk.djx.core.init.pay.PayInitHelper;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.DJXSdkLazyReporter;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.PluginChecker;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.AntiFraudManager;
import com.bytedance.sdk.djx.core.util.AppLogSdkVersionCheckerUtil;
import com.bytedance.sdk.djx.core.util.DJXCrash;
import com.bytedance.sdk.djx.core.util.DidDegradeUtil;
import com.bytedance.sdk.djx.core.util.MainTask;
import com.bytedance.sdk.djx.impl.DJXSdkInstance;
import com.bytedance.sdk.djx.impl.DJXSdkStartHelper;
import com.bytedance.sdk.djx.log.DJXApiLazyReporter;
import com.bytedance.sdk.djx.log.ILazyReporter;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.ev.BEBDDidCome;
import com.bytedance.sdk.djx.model.ev.BEDJXSdkInit;
import com.bytedance.sdk.djx.model.ev.BESyncHistory;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;
import com.bytedance.sdk.djx.net.req.k.ABConfigInterceptor;
import com.bytedance.sdk.djx.net.req.k.EncryptInterceptor;
import com.bytedance.sdk.djx.net.token.OnTokenResultListener;
import com.bytedance.sdk.djx.net.token.TokenApiConfigUtils;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.setting.SettingsHelper;
import com.bytedance.sdk.djx.settings.DJXGlobalSettings;
import com.bytedance.sdk.djx.utils.ActivityLifecycleHelper;
import com.bytedance.sdk.djx.utils.AdCLogHelper;
import com.bytedance.sdk.djx.utils.AppLogManager;
import com.bytedance.sdk.djx.utils.AssertHelper;
import com.bytedance.sdk.djx.utils.CommonConvertDjxUtils;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.DJXThread;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.Encrypt;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.PluginCrashHandler;
import com.bytedance.sdk.djx.utils.StackTraceInfoHelper;
import com.bytedance.sdk.djx.utils.Utils;
import com.bytedance.sdk.djx.utils.VerifierSp;
import com.bytedance.sdk.djx.utils.ZeusUtils;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.hangman.verifier.Verifier;
import com.pangrowth.adclog.AdCLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class InitTaskPool {
    private static final String NAME_START_TASK = "StartTask";
    private static final String TAG = "InitTaskPool";
    public final InitTask getDidTask;
    public final InitTask initAdcLog;
    private final InitTask initAppLogTask;
    public final InitTask initComponentTask;
    private final InitTask initCrashTask;
    public final InitTask initDramaHistory;
    public final InitTask initMiniapp;
    private final InitTask initParamsTask;
    public final InitTask initPayTask;
    public final InitTask initPlayerTask;
    public final InitTask initResultTask;
    private final InitTask initSdkConfigTask;
    public final InitTask initSettingsTask;
    public final InitTask initTokenTask;
    private DJXSdkConfig mConfig;
    private Context mContext;
    private final List<InitTask> mInitTaskList;
    private String mJsonName;
    private IBaseStartListener mStartListener;
    private volatile STATE mState = STATE.IDLE;
    private final SdkTInitLog mTLog = new SdkTInitLog();
    private CommonError mTokenErr;
    private final InitTask pluginVersionCheckTask;
    private final InitTask resourceCheckTask;
    public final InitTask sendLogTask;
    private final MainTask.Trigger startInit;
    public final InitTask updateNetTask;
    public final InitTask verifyCloseTask;

    public enum STATE {
        IDLE,
        INITIALIZING,
        FAILED,
        SUCCESS
    }

    public InitTaskPool() {
        MainTask.Trigger trigger = new MainTask.Trigger();
        this.startInit = trigger;
        boolean z = true;
        InitTask initTask = new InitTask("InitCrash", z, trigger) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.1
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                InnerManager.setContext(InitTaskPool.this.mContext);
                DebugInfo.init();
                CommonSdkUtils.init(InitTaskPool.this.mContext, DevInfo.sIsDebug || DebugInfo.Bridge.isDebug(), InitTaskPool.this.mConfig.isDebug());
                DevInfo.sPrivacyController = InitTaskPool.this.mConfig.getPrivacyController();
                if (DJXSdkUtils.isRunningPlugin()) {
                    PluginCrashHandler.notifyLaunched();
                }
                APMHelper.init(InitTaskPool.this.mConfig);
                DJXCrash.register();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ABConfigInterceptor());
                arrayList.add(EncryptInterceptor.build(DevInfo.sPartner));
                NetClient.getInstance().init(arrayList, new NetInjectImpl());
                AppLogSdkVersionCheckerUtil.checkAppLogSdkVersion();
                return true;
            }
        };
        this.initCrashTask = initTask;
        InitTask initTask2 = new InitTask("PluginVersionCheck", z, initTask) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.2
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                if (!PluginChecker.checkVersion()) {
                    LG.d(InitTaskPool.TAG, "plugin init failed, plugin version in block list");
                    try {
                        ZeusUtils.unInstallPlugin(DJXSdkUtils.getPluginPackageName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!Utils.IS_P) {
                        cancel();
                        DJXSdkInstance.getInstance().reStartFallback();
                        return null;
                    }
                }
                return true;
            }
        };
        this.pluginVersionCheckTask = initTask2;
        InitTask initTask3 = new InitTask("InitParams", z, initTask2) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.3
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() throws NumberFormatException {
                if (!TextUtils.isEmpty(InitTaskPool.this.mJsonName)) {
                    DynamicManager.getInstance().init(InitTaskPool.this.mContext, InitTaskPool.this.mJsonName);
                    DynamicModel dynamicModel = DynamicManager.getInstance().getDynamicModel();
                    try {
                        AssertHelper.throwNull(dynamicModel, "config file must not be null, please check your config file!");
                        AssertHelper.throwEmpty(dynamicModel.mInitSiteId, "site_id must not be null, please check your config file!");
                        AssertHelper.throwEmpty(dynamicModel.mInitPartner, "partner must not be null, please check your config file!");
                        AssertHelper.throwEmpty(dynamicModel.mInitSecureKey, "secure_key must not be null, please check your config file!");
                        String str = dynamicModel.mInitAppId;
                        DJXGlobalSettings.getInstance().saveSiteId(dynamicModel.mInitSiteId);
                        AssertHelper.throwEmpty(str, "app_id not must be null, please check your config file!");
                        try {
                            Long.parseLong(str);
                            LG.d(InitTaskPool.TAG, "config file parser success: " + dynamicModel);
                        } catch (NumberFormatException unused) {
                            throw new IllegalArgumentException("InitHelperBase: AppId parsing failed, AppId = " + str + "\n" + StackTraceInfoHelper.getStackTraceInfo());
                        }
                    } catch (IllegalArgumentException e) {
                        this.mErrorCode = StartError.code("sdk配置文件解析失败");
                        this.mErrorMsg = e.getMessage();
                        throw e;
                    }
                } else {
                    AssertHelper.throwNow("config file must not be null");
                }
                return true;
            }
        };
        this.initParamsTask = initTask3;
        InitTask initTask4 = new InitTask("InitSdkConfig", z, initTask3) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.4
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                DevInfo.sPartner = DynamicManager.getInstance().getInitPartner();
                DevInfo.sSecureKey = DynamicManager.getInstance().getInitSecureKey();
                DevInfo.sOldSecureKey = DynamicManager.getInstance().getInitOldSecureKey();
                DevInfo.sAppId = DynamicManager.getInstance().getInitAppId();
                DevInfo.sSiteId = DynamicManager.getInstance().getInitSiteId();
                DevInfo.sIsDebug = InitTaskPool.this.mConfig.isDebug();
                DevInfo.sPrivacyController = InitTaskPool.this.mConfig.getPrivacyController();
                DevInfo.sImageCacheSize = InitTaskPool.this.mConfig.getImageCacheSize();
                DevInfo.sToastController = InitTaskPool.this.mConfig.getToastController();
                DevInfo.sRouter = InitTaskPool.this.mConfig.getRouter();
                DevInfo.sDisableABTest = InitTaskPool.this.mConfig.isDisableABTest();
                DevInfo.sIsNewUser = InitTaskPool.this.mConfig.isNewUser();
                DevInfo.sAliveSeconds = InitTaskPool.this.mConfig.getAliveSeconds();
                DevInfo.sInterestType = InitTaskPool.this.mConfig.getInterestType();
                DevInfo.sDisableTTPlayer = InitTaskPool.this.mConfig.isDisableTTPlayer();
                if (DevInfo.sInterestType < 1 || DevInfo.sInterestType > 29 || DevInfo.sInterestType == 15 || DevInfo.sInterestType == 18) {
                    LG.e(InitTaskPool.TAG, "interest type invalid, type value = " + DevInfo.sInterestType);
                }
                Encrypt.setSecureKey(DevInfo.sSecureKey);
                com.bytedance.sdk.djx.net.img.Utils.setMemoryCacheSize(DevInfo.sImageCacheSize);
                return true;
            }
        };
        this.initSdkConfigTask = initTask4;
        InitTask initTask5 = new InitTask("InitAppLog", initTask4) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.5
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                CommonSdkUtils.initApplog(DJXSdkStartHelper.getInstance().getDJXSdkClassLoader(), InnerManager.getContext(), TokenApiConfigUtils.buildTokenApiConfig(), DevInfo.getPrivacyController(), DJXSdkUtils.isEnableMigrate4Applog(InitTaskPool.this.mConfig), new IGetNewTokenApiConfigCallback() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool$5$$ExternalSyntheticLambda0
                    @Override // com.bytedance.sdk.commonsdk.api.IGetNewTokenApiConfigCallback
                    public final TokenApiConfig getNewTokenApiConfig() {
                        return TokenApiConfigUtils.buildTokenApiConfig();
                    }
                });
                OAIDHelper.init();
                return true;
            }
        };
        this.initAppLogTask = initTask5;
        boolean z2 = true;
        InitTask initTask6 = new InitTask("ResourceCheck", z2, TTExecutor.sDefaultThreadPool, initTask2) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.6
            /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:
            
                com.bytedance.sdk.djx.internal.utils.DJXLogger.e(com.bytedance.sdk.djx.impl.DJXSdkInstance.TAG, r8[0] + " " + r8[1] + " not found ! Please check your resource keep whiteList");
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x008e, code lost:
            
                r0 = false;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v14 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable[]] */
            /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.StringBuilder] */
            /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable[]] */
            /* JADX WARN: Type inference failed for: r2v12, types: [java.io.Closeable[]] */
            /* JADX WARN: Type inference failed for: r4v0 */
            /* JADX WARN: Type inference failed for: r4v1 */
            /* JADX WARN: Type inference failed for: r4v2 */
            /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
            /* JADX WARN: Type inference failed for: r4v4 */
            /* JADX WARN: Type inference failed for: r4v5 */
            /* JADX WARN: Type inference failed for: r4v6 */
            /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r6v1, types: [org.xmlpull.v1.XmlPullParser] */
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected java.lang.Boolean run() throws java.lang.Throwable {
                /*
                    r11 = this;
                    java.lang.String r0 = "@"
                    java.lang.String r1 = "DJXSdkInstance"
                    java.lang.String r2 = "start checking resources "
                    com.bytedance.sdk.djx.utils.LG.d(r1, r2)
                    r2 = 0
                    r3 = 1
                    r4 = 0
                    com.bytedance.sdk.djx.core.init.InitTaskPool r5 = com.bytedance.sdk.djx.core.init.InitTaskPool.this     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
                    android.content.Context r5 = com.bytedance.sdk.djx.core.init.InitTaskPool.access$000(r5)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
                    android.content.res.Resources r5 = r5.getResources()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
                    int r6 = com.pangle.cn.pangrowth.base.R.raw.zeus_keep_res_djxsdk     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
                    java.io.InputStream r5 = r5.openRawResource(r6)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
                    org.xmlpull.v1.XmlPullParser r6 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r6.setInput(r5, r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r6.nextTag()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r7 = 2
                    java.lang.String r8 = "resources"
                    r6.require(r7, r2, r8)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r2 = "tools"
                    java.lang.String r2 = r6.getNamespace(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r7 = "keep"
                    java.lang.String r2 = r6.getAttributeValue(r2, r7)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r6 = ","
                    java.lang.String[] r2 = r2.split(r6)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    int r6 = r2.length     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r7 = r4
                L40:
                    if (r7 >= r6) goto L93
                    r8 = r2[r7]     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    if (r9 != 0) goto L90
                    boolean r9 = r8.contains(r0)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    if (r9 == 0) goto L90
                    java.lang.String r9 = ""
                    java.lang.String r8 = r8.replace(r0, r9)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r8 = r8.trim()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r9 = "/"
                    java.lang.String[] r8 = r8.split(r9)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r9 = r8[r4]     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r10 = r8[r3]     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    boolean r9 = com.bytedance.sdk.djx.utils.ResourceUtil.checkRes(r9, r10)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    if (r9 != 0) goto L90
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r0.<init>()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r2 = r8[r4]     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r2 = " "
                    java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r2 = r8[r3]     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r2 = " not found ! Please check your resource keep whiteList"
                    java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    com.bytedance.sdk.djx.internal.utils.DJXLogger.e(r1, r0)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La0
                    r0 = r4
                    goto L94
                L90:
                    int r7 = r7 + 1
                    goto L40
                L93:
                    r0 = r3
                L94:
                    java.io.Closeable[] r2 = new java.io.Closeable[r3]
                    r2[r4] = r5
                    com.bytedance.sdk.djx.utils.IOUtil.closeIOQuietly(r2)
                    r4 = r0
                    goto Lb0
                L9d:
                    r0 = move-exception
                    r2 = r5
                    goto Lcb
                La0:
                    r0 = move-exception
                    r2 = r5
                    goto La6
                La3:
                    r0 = move-exception
                    goto Lcb
                La5:
                    r0 = move-exception
                La6:
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> La3
                    java.io.Closeable[] r0 = new java.io.Closeable[r3]
                    r0[r4] = r2
                    com.bytedance.sdk.djx.utils.IOUtil.closeIOQuietly(r0)
                Lb0:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "resources checking done, result = "
                    java.lang.StringBuilder r0 = r0.append(r2)
                    java.lang.StringBuilder r0 = r0.append(r4)
                    java.lang.String r0 = r0.toString()
                    com.bytedance.sdk.djx.utils.LG.d(r1, r0)
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
                    return r0
                Lcb:
                    java.io.Closeable[] r1 = new java.io.Closeable[r3]
                    r1[r4] = r2
                    com.bytedance.sdk.djx.utils.IOUtil.closeIOQuietly(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.init.InitTaskPool.AnonymousClass6.run():java.lang.Boolean");
            }

            @Override // com.bytedance.sdk.djx.core.init.InitTask, com.bytedance.sdk.djx.core.util.MainTask
            public void onTaskDone() {
                super.onTaskDone();
                Boolean.FALSE.equals(this.result);
            }
        };
        this.resourceCheckTask = initTask6;
        InitTask initTask7 = new InitTask("InitPlayer", z2, TTExecutor.sDefaultThreadPool, initTask4) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.7
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                PLTHelper.getInstance().initVod();
                return true;
            }
        };
        this.initPlayerTask = initTask7;
        InitTask initTask8 = new InitTask("InitDramaPreload", true, TTExecutor.sDefaultThreadPool, initTask4) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.8
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                PLTHelper.getInstance().initHistory();
                return true;
            }
        };
        this.initDramaHistory = initTask8;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9("GetDidTask", initTask5);
        this.getDidTask = anonymousClass9;
        this.mTokenErr = null;
        InitTask initTask9 = new InitTask("InitToken", initTask5, anonymousClass9) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.10
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                TokenHelper.getInstance().init(new OnTokenResultListener() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.10.1
                    @Override // com.bytedance.sdk.djx.net.token.OnTokenResultListener
                    public void onTokenResult(boolean z3, CommonError commonError) {
                        InitTaskPool.this.mTokenErr = commonError;
                        if (z3) {
                            InitTaskPool.this.mTokenErr = null;
                        }
                        if (InitTaskPool.getTokenService().isHasSyncMark()) {
                            BESyncHistory.build().sendOnThread();
                        }
                        markTaskDone(z3, true);
                    }
                });
                return null;
            }

            @Override // com.bytedance.sdk.djx.core.init.InitTask
            protected void sendTaskMonitor() {
                HashMap map = new HashMap();
                map.put(ILogConst.Keys.KEY_IS_REQUEST_TOKEN, Integer.valueOf(InitTaskPool.getTokenService().isGetTokenFromServer() ? 1 : 0));
                this.mTLog.setParams(map);
                super.sendTaskMonitor();
            }
        };
        this.initTokenTask = initTask9;
        InitTask initTask10 = new InitTask("InitResult", initTask9, initTask6, initTask8, initTask7) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.11
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            public void onPredecessorTaskDone(MainTask mainTask) {
                super.onPredecessorTaskDone(mainTask);
                if (Boolean.FALSE.equals(mainTask.result)) {
                    if (mainTask != InitTaskPool.this.initTokenTask) {
                        if (mainTask == InitTaskPool.this.resourceCheckTask) {
                            InitTaskPool.this.onInitResult(false, "资源校验失败，请先将keep_res.txt中的资源全部加入白名单中", DJXError.build(StartError.code("资源校验失败，请先将keep_res.txt中的资源全部加入白名单中"), "资源校验失败，请先将keep_res.txt中的资源全部加入白名单中"));
                        }
                    } else if (InitTaskPool.this.getDidTask.result.booleanValue()) {
                        InitTaskPool initTaskPool = InitTaskPool.this;
                        initTaskPool.onInitResult(false, initTaskPool.mTokenErr != null ? InitTaskPool.this.mTokenErr.msg : "获取token失败，请检查网络，并提供抓包信息给技术支持", InitTaskPool.this.mTokenErr != null ? CommonConvertDjxUtils.commonErrorConvertDJXError(InitTaskPool.this.mTokenErr) : DJXError.build(StartError.code("获取token失败，请检查网络，并提供抓包信息给技术支持"), "获取token失败，请检查网络，并提供抓包信息给技术支持"));
                    } else {
                        InitTaskPool.this.onInitResult(false, "获取token失败2，请检查网络，并提供抓包信息给技术支持", DJXError.build(StartError.code("获取token失败2，请检查网络，并提供抓包信息给技术支持"), "获取token失败2，请检查网络，并提供抓包信息给技术支持"));
                    }
                }
            }

            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                InitTaskPool.this.onInitResult(true, "sdk启动成功", null);
                return true;
            }
        };
        this.initResultTask = initTask10;
        AnonymousClass12 anonymousClass12 = new AnonymousClass12("UpdateNet", initTask10);
        this.updateNetTask = anonymousClass12;
        InitTask initTask11 = new InitTask("InitSettingsTask", true, TTExecutor.sDefaultThreadPool, initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.13
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                DJXABHelper.init();
                SettingData.getInstance();
                return true;
            }
        };
        this.initSettingsTask = initTask11;
        InitTask initTask12 = new InitTask("initPayTask", true, TTExecutor.sDefaultThreadPool, initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.14
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                PayInitHelper.init(InitTaskPool.this.mContext, InitTaskPool.this.mConfig);
                return true;
            }
        };
        this.initPayTask = initTask12;
        InitTask initTask13 = new InitTask("VerifyClose", initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.15
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                boolean zEnableClassVerify;
                if (VerifierSp.isVerifierDisabled()) {
                    try {
                        zEnableClassVerify = Verifier.enableClassVerify();
                    } catch (Throwable th) {
                        VerifierSp.markCrash();
                        LG.e(InitTaskPool.TAG, "verifier: enable class verifier error, msg = [" + th.getMessage() + "]");
                        zEnableClassVerify = false;
                    }
                    if (zEnableClassVerify) {
                        LG.d(InitTaskPool.TAG, "verifier: enable success.");
                        VerifierSp.setVerifierDisabled(false);
                    } else {
                        LG.d(InitTaskPool.TAG, "verifier: enable failed.");
                    }
                }
                return true;
            }
        };
        this.verifyCloseTask = initTask13;
        InitTask initTask14 = new InitTask("InitComponent", initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.16
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                DJXGlobalReceiver.register();
                AntiFraudManager.getInstance().init();
                return true;
            }
        };
        this.initComponentTask = initTask14;
        InitTask initTask15 = new InitTask("SendLog", initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.17
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                sendLazyLog(true, DJXApiLazyReporter.EVENT_REGISTER_FINISH);
                sendLazyLog(true, DJXApiLazyReporter.EVENT_REGISTER_START);
                sendLazyLog(true, DJXApiLazyReporter.EVENT_SDK_START_LAUNCH_MONITOR);
                sendLazyLog(true, DJXApiLazyReporter.EVENT_SDK_SYN_LAUNCH_DURATION);
                sendLazyLog(true, "sdk_launch_monitor");
                sendLazyLog(false, ILogConst.EVENT_SDK_LAUNCH_TASK_MONITOR);
                addActivityLifecycleListener();
                return true;
            }

            private void sendLazyLog(boolean z3, String str) {
                ILazyReporter iLazyReporter = z3 ? DJXApiLazyReporter.INSTANCE : DJXSdkLazyReporter.INSTANCE;
                try {
                    JSONArray eventParams = iLazyReporter.getEventParams(str);
                    for (int i = 0; i < eventParams.length(); i++) {
                        BLogAgent.build(null, str, null).putAll(new JSONObject(eventParams.optString(i))).send();
                    }
                } catch (JSONException unused) {
                } catch (Throwable th) {
                    iLazyReporter.clear(str);
                    throw th;
                }
                iLazyReporter.clear(str);
            }

            private void addActivityLifecycleListener() {
                final ActivityLifecycleHelper activityLifecycleHelper = ActivityLifecycleHelper.getInstance();
                activityLifecycleHelper.registerCallback(new ActivityLifecycleHelper.DefaultActivityLifecycleCallback() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.17.1
                    public void onActivityStopped(Activity activity) {
                        LG.i(InitTaskPool.TAG, "activity -> " + activity + " onStopped, isForeground = " + activityLifecycleHelper.isForeground());
                    }

                    public void onActivityStarted(Activity activity) {
                        LG.i(InitTaskPool.TAG, "activity -> " + activity + " onStarted, isForeground = " + activityLifecycleHelper.isForeground());
                    }
                });
            }
        };
        this.sendLogTask = initTask15;
        InitTask initTask16 = new InitTask("InitAdcLog", anonymousClass9, initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.18
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() throws Throwable {
                if (AdCLogHelper.isAdCLogExists()) {
                    try {
                        AdCLog.initAdCLog(InitTaskPool.this.mContext);
                        AdCLog.initCloudMessage(InitTaskPool.this.mContext, AppLogManager.getAppLogInstance().getDid());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        };
        this.initAdcLog = initTask16;
        InitTask initTask17 = new InitTask("InitMiniapp", initTask10) { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.19
            @Override // com.bytedance.sdk.djx.core.util.MainTask
            protected Boolean run() {
                if (InitTaskPool.this.mConfig.isAutoStartMiniapp()) {
                    MiniappHelper.INSTANCE.initAndStart(InitTaskPool.this.mContext, InitTaskPool.this.mJsonName, new Function1<Boolean, Unit>() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.19.1
                        public Unit invoke(Boolean bool) {
                            markTaskDone(bool.booleanValue(), true);
                            return Unit.INSTANCE;
                        }
                    });
                    return null;
                }
                return true;
            }
        };
        this.initMiniapp = initTask17;
        this.mInitTaskList = Arrays.asList(initTask, initTask2, initTask3, initTask5, initTask4, initTask6, initTask7, initTask8, anonymousClass9, initTask9, initTask10, initTask12, initTask16, anonymousClass12, initTask11, initTask14, initTask13, initTask15, initTask17);
    }

    /* renamed from: com.bytedance.sdk.djx.core.init.InitTaskPool$9, reason: invalid class name */
    class AnonymousClass9 extends InitTask {
        AnonymousClass9(String str, MainTask... mainTaskArr) {
            super(str, mainTaskArr);
        }

        @Override // com.bytedance.sdk.djx.core.util.MainTask
        protected Boolean run() {
            AppLogDidUtils appLogDidUtils = AppLogDidUtils.getInstance(DevInfo.sAppId);
            if (appLogDidUtils != null) {
                appLogDidUtils.addDidListener(new AppLogDidUtils.Callback() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool$9$$ExternalSyntheticLambda0
                    @Override // com.bytedance.sdk.commonsdk.api.utils.AppLogDidUtils.Callback
                    public final void onDidResult(boolean z) {
                        this.f$0.m361lambda$run$0$combytedancesdkdjxcoreinitInitTaskPool$9(z);
                    }
                });
            }
            return DidDegradeUtil.isDegrade() ? null : true;
        }

        /* renamed from: lambda$run$0$com-bytedance-sdk-djx-core-init-InitTaskPool$9, reason: not valid java name */
        /* synthetic */ void m361lambda$run$0$combytedancesdkdjxcoreinitInitTaskPool$9(boolean z) {
            if (z) {
                DeviceUtils.setDid(AppLogManager.getAppLogInstance().getDid());
            }
            new BEBDDidCome().send();
            if (DidDegradeUtil.isDegrade()) {
                markTaskDone(z, true);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.djx.core.init.InitTaskPool$12, reason: invalid class name */
    class AnonymousClass12 extends InitTask {
        AnonymousClass12(String str, MainTask... mainTaskArr) {
            super(str, mainTaskArr);
        }

        @Override // com.bytedance.sdk.djx.core.util.MainTask
        protected Boolean run() {
            PLTHelper.getInstance().syncHuoShan();
            SettingsHelper.loadSettings();
            DynamicManager.getInstance().registerListener(new OnDynamicUpdateListener() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool$12$$ExternalSyntheticLambda0
                @Override // com.bytedance.sdk.djx.base.dynamic.OnDynamicUpdateListener
                public final void onDynamicUpdate(DynamicRsp dynamicRsp) {
                    PLTHelper.getInstance().initVod();
                }
            });
            DynamicManager.getInstance().update();
            PLTHelper.getInstance().refreshPreload2();
            PLTHelper.getInstance().preload();
            return true;
        }
    }

    public void initialize(Context context, String str, DJXSdkConfig dJXSdkConfig, IBaseStartListener iBaseStartListener) {
        this.mContext = context;
        this.mJsonName = str;
        this.mConfig = dJXSdkConfig;
        this.mStartListener = iBaseStartListener;
        int i = AnonymousClass21.$SwitchMap$com$bytedance$sdk$djx$core$init$InitTaskPool$STATE[this.mState.ordinal()];
        if (i == 1) {
            LG.d(TAG, "sdk is initializing");
            return;
        }
        if (i == 2) {
            this.mStartListener.onStartComplete(true, "sdk启动成功", null);
        }
        logStartTaskLog();
        this.mState = STATE.INITIALIZING;
        resetAllTasks();
        this.startInit.reset();
        this.mTLog.sendSdkInitBegin();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.startInit.start();
        } else {
            DJXThread.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.djx.core.init.InitTaskPool.20
                @Override // java.lang.Runnable
                public void run() {
                    InitTaskPool.this.startInit.start();
                }
            });
        }
    }

    /* renamed from: com.bytedance.sdk.djx.core.init.InitTaskPool$21, reason: invalid class name */
    static /* synthetic */ class AnonymousClass21 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$core$init$InitTaskPool$STATE;

        static {
            int[] iArr = new int[STATE.values().length];
            $SwitchMap$com$bytedance$sdk$djx$core$init$InitTaskPool$STATE = iArr;
            try {
                iArr[STATE.INITIALIZING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$init$InitTaskPool$STATE[STATE.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$init$InitTaskPool$STATE[STATE.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$init$InitTaskPool$STATE[STATE.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void onInitResult(boolean z, String str, DJXError dJXError) {
        if (z) {
            this.mState = STATE.SUCCESS;
        } else {
            this.mState = STATE.FAILED;
        }
        this.mStartListener.onStartComplete(z, str, dJXError);
        sendInitEndEvent(z, str);
    }

    private void resetAllTasks() {
        Iterator<InitTask> it = this.mInitTaskList.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    protected void logStartTaskLog() {
        long jElapsedRealtime = DJXSdkStartHelper.sStartTime > 0 ? SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime : -1L;
        DJXSdkLazyReporter.logEventSdkLaunchTaskMonitor(NAME_START_TASK, true, false, jElapsedRealtime, null, null);
        LG.d(TAG, "StartTask cost = " + jElapsedRealtime);
    }

    private void sendInitEndEvent(boolean z, String str) {
        new BEDJXSdkInit(z).send();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - DJXSdkStartHelper.sStartTime;
        int i = !DJXGlobalSettings.getInstance().getHasInitSuccess() ? 1 : 0;
        int i2 = !getTokenService().isGetTokenFromServer() ? 1 : 0;
        this.mTLog.sendSdkInitEnd(z, str, jElapsedRealtime, i, i2);
        this.mTLog.sendSdkLaunchMonitor(z, jElapsedRealtime, i, Integer.valueOf(StartError.code(str)), str);
        LG.i(TAG, "Init result: cost = " + jElapsedRealtime + ", is_activate = " + i + ", is_request_token = " + i2);
        DJXSdkStartHelper.sStartTime = -1L;
        if (z) {
            DJXGlobalSettings.getInstance().saveInitSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ICommonSdkTokenService getTokenService() {
        return CommonSdkUtils.getTokenService(DJXSdkStartHelper.getInstance().getDJXSdkClassLoader());
    }

    public static InitTaskPool getInstance() {
        return InnerHolder.instance;
    }

    private static class InnerHolder {
        private static final InitTaskPool instance = new InitTaskPool();

        private InnerHolder() {
        }
    }
}
