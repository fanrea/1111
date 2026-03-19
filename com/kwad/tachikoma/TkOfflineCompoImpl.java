package com.kwad.tachikoma;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kuaishou.tk.api.TachikomaApi;
import com.kuaishou.tk.api.exception.ContainerInfo;
import com.kuaishou.tk.api.exception.ITKExceptionHandler;
import com.kuaishou.tk.api.exception.TKException;
import com.kuaishou.tk.api.exception.TKJSCompilationException;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ICrashCustomKeyValue;
import com.kwad.components.offline.api.core.api.ICrashOccurListener;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.ITkOfflineCompoInitConfig;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.TemplateConfig;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.tk.core.a.r;
import com.tk.core.a.s;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TkOfflineCompoImpl implements ITkOfflineCompo {
    private static final String BUNDLE_SOURCE_REMOTE = "ODR";
    private static final String CUSTOM_STAT_KEY_JS = "tk_js_exception";
    private static final String KEY_STYLE_TEMPLATES = "styleTemplates";
    private static final String KEY_STYLE_TEMPLATES_CONFIG = "styleTemplatesConfig";
    public static final String SO_FB = "kwad-fb";
    public static final String SO_SHARED = "c++_shared";
    public static final String SO_TK_RUNTIME = "tk_runtime_v0_0_161";
    public static final String SO_TK_RUNTIME_LITE = "tk_runtime_lite_v0_0_161";
    private static final String SO_TK_RUNTIME_VER = "_v0_0_161";
    public static final String SO_TK_V8 = "kwai-v8";
    public static final String SO_TK_V8_LITE = "kwai-v8-lite";
    public static final String SO_YOGA = "kwad-yoga";
    private static final String TAG = "TkInitModule/CompoImpl";
    private static final int V8_SO_TYPE_ALL = 2;
    private static final int V8_SO_TYPE_OTHER = 1;
    private static volatile boolean mHasInit;
    private static int mLoadTimes;
    private static int sCurrentDetailReportCount;
    private static volatile boolean sHasSetupCrashInfo;
    private long loadTimeStart;
    private InitCallBack mInitCallBack;
    private boolean useTkSoAll;
    private static final AtomicBoolean sIsTkSoLoaded = new AtomicBoolean(false);
    private static final AtomicBoolean sIsTkSoFromNet = new AtomicBoolean(false);

    private long checkLoadTime(long j) {
        if (j < 0 || j > 60000) {
            return 0L;
        }
        return j;
    }

    @Override // com.kwad.components.offline.api.IOfflineCompo
    public int priority() {
        return 100;
    }

    static /* synthetic */ int access$504() {
        int i = sCurrentDetailReportCount + 1;
        sCurrentDetailReportCount = i;
        return i;
    }

    @Override // com.kwad.components.offline.api.IOfflineCompo
    public void init(Context context, ITkOfflineCompoInitConfig iTkOfflineCompoInitConfig, InitCallBack initCallBack) {
        if (mHasInit) {
            return;
        }
        mHasInit = true;
        this.mInitCallBack = initCallBack;
        e.hP().a(iTkOfflineCompoInitConfig);
        SharedPreferences sharedPreferences = context.getSharedPreferences(iTkOfflineCompoInitConfig.getSpNameSoLoadTimes(), 0);
        mLoadTimes = sharedPreferences.getInt(iTkOfflineCompoInitConfig.getSpKeyTkSoLoadTimes(), 0) + 1;
        this.useTkSoAll = iTkOfflineCompoInitConfig.useTkSoAll();
        sharedPreferences.edit().putInt(iTkOfflineCompoInitConfig.getSpKeyTkSoLoadTimes(), mLoadTimes).commit();
        loadSo(context);
    }

    private void loadSo(final Context context) {
        this.loadTimeStart = SystemClock.elapsedRealtime();
        TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setLoadingTimes(mLoadTimes).toJson());
        e.hP().hQ().soLoader().loadSo(context, new SoLoadListener() { // from class: com.kwad.tachikoma.TkOfflineCompoImpl.1
            @Override // com.kwad.components.offline.api.core.soloader.SoLoadListener
            public final void onLoaded() {
                boolean zUseTkLite = e.hP().hQ().useTkLite();
                try {
                    System.loadLibrary("c++_shared");
                    e.log().d(TkOfflineCompoImpl.TAG, "loadSo useTkLite: " + zUseTkLite);
                    String str = zUseTkLite ? TkOfflineCompoImpl.SO_TK_V8_LITE : TkOfflineCompoImpl.SO_TK_V8;
                    try {
                        System.loadLibrary(str);
                        String str2 = zUseTkLite ? TkOfflineCompoImpl.SO_TK_RUNTIME_LITE : TkOfflineCompoImpl.SO_TK_RUNTIME;
                        try {
                            System.loadLibrary(str2);
                            try {
                                System.loadLibrary(TkOfflineCompoImpl.SO_FB);
                                try {
                                    System.loadLibrary(TkOfflineCompoImpl.SO_YOGA);
                                    try {
                                        new com.tk.core.p.a.a(context);
                                    } catch (Throwable th) {
                                        e.log().printStackTrace(th);
                                    }
                                    TkOfflineCompoImpl.sIsTkSoLoaded.set(true);
                                    e.log().d(TkOfflineCompoImpl.TAG, "loadSo success");
                                    TkOfflineCompoImpl.this.initTachikoma(context);
                                    TkOfflineCompoImpl.this.mInitCallBack.onSuccess(TkOfflineCompoImpl.sIsTkSoFromNet.get());
                                } catch (Throwable th2) {
                                    e.log().d(TkOfflineCompoImpl.TAG, "loadSo fail:kwad-yoga" + th2.getMessage());
                                    TkOfflineCompoImpl.this.reportTKSOLoadError(TkOfflineCompoImpl.SO_YOGA, th2);
                                }
                            } catch (Throwable th3) {
                                e.log().d(TkOfflineCompoImpl.TAG, "loadSo fail:kwad-fb" + th3.getMessage());
                                TkOfflineCompoImpl.this.reportTKSOLoadError(TkOfflineCompoImpl.SO_FB, th3);
                            }
                        } catch (Throwable th4) {
                            e.log().d(TkOfflineCompoImpl.TAG, "loadSo fail:" + str2 + th4.getMessage());
                            TkOfflineCompoImpl.this.reportTKSOLoadError(str2, th4);
                        }
                    } catch (Throwable th5) {
                        e.log().d(TkOfflineCompoImpl.TAG, "loadSo fail:" + str + th5.getMessage());
                        TkOfflineCompoImpl.this.reportTKSOLoadError(str, th5);
                    }
                } catch (Throwable th6) {
                    e.log().d(TkOfflineCompoImpl.TAG, "loadSo fail:c++_shared" + th6.getMessage());
                    TkOfflineCompoImpl.this.reportTKSOLoadError("c++_shared", th6);
                }
            }

            @Override // com.kwad.components.offline.api.core.soloader.SoLoadListener
            public final void onPreUpdate() {
                TkOfflineCompoImpl.sIsTkSoFromNet.set(true);
            }

            @Override // com.kwad.components.offline.api.core.soloader.SoLoadListener
            public final void onFailed(int i, Throwable th) {
                TkOfflineCompoImpl.sIsTkSoLoaded.set(false);
                TkOfflineCompoImpl.this.mInitCallBack.onError(i);
                TkOfflineCompoImpl.this.reportTKSOLoadError(String.valueOf(i), th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTachikoma(final Context context) {
        final Application applicationWrapGetApplication = e.hP().hQ().wrapper().wrapGetApplication(context);
        TachikomaApi.registerExtraLib("com.kwad.framework.tachikoma.gen");
        TachikomaApi.getInstance().injectProps();
        TachikomaApi.getInstance().setLoggerDelegate(new com.kwad.tachikoma.k.a());
        TachikomaApi.getInstance().init(applicationWrapGetApplication, new s() { // from class: com.kwad.tachikoma.TkOfflineCompoImpl.2
            @Override // com.tk.core.a.s
            public final r getCommonParams() {
                return new h(applicationWrapGetApplication);
            }
        }, false);
        TachikomaApi.getInstance().setInitResult(true);
        TachikomaApi.getInstance().setWebImageHandler(new com.kwad.tachikoma.j.a());
        TachikomaApi.getInstance().setExceptionHandler(new ITKExceptionHandler() { // from class: com.kwad.tachikoma.TkOfflineCompoImpl.3
            @Override // com.kuaishou.tk.api.exception.ITKExceptionHandler
            public final void handleReportException(Throwable th, ContainerInfo containerInfo) {
            }

            @Override // com.kuaishou.tk.api.exception.ITKExceptionHandler
            public final void handleException(Throwable th, TkBundleInfo tkBundleInfo, String str) throws Throwable {
                a.a(str, th);
                StringBuilder sb = new StringBuilder();
                if (tkBundleInfo != null) {
                    sb.append("bundle(");
                    sb.append("id:");
                    sb.append(tkBundleInfo.mBundleId);
                    sb.append(";version:");
                    sb.append(tkBundleInfo.mVersionCode);
                    sb.append(";source:");
                    sb.append(tkBundleInfo.mBundleSource);
                    sb.append(")");
                } else {
                    sb.append("bundle is null");
                }
                sb.append(" sessionId:");
                sb.append(str);
                if (th != null) {
                    sb.append(" detail:");
                    sb.append(th.getMessage());
                }
                if (th instanceof TKJSCompilationException) {
                    StyleTemplate styleTemplate = new StyleTemplate();
                    styleTemplate.templateId = tkBundleInfo.mBundleId;
                    styleTemplate.templateVersionCode = tkBundleInfo.mVersionCode;
                    String strN = i.n(str);
                    if (strN != null) {
                        if (TkOfflineCompoImpl.access$504() <= OfflineHostProvider.getApi().getTKErrorDetailCount()) {
                            sb.append(" originJsCode:\n");
                            sb.append(strN);
                        }
                        sb.append(" jsMd5:" + OfflineHostProvider.getApi().encrypt().getMD5(strN));
                    }
                    File fileA = com.kwad.tachikoma.t.h.a(context, styleTemplate.templateId, styleTemplate.getTKConfigFileName());
                    if (fileA == null || !fileA.exists()) {
                        sb.append(" config:null");
                    } else {
                        TemplateConfig templateConfigD = com.kwad.tachikoma.g.a.ik().d(context, styleTemplate);
                        sb.append(" configMd5:");
                        if (templateConfigD == null) {
                            sb.append(ILogConst.CACHE_PLAY_REASON_NULL);
                        } else {
                            sb.append(templateConfigD.md5);
                        }
                    }
                }
                TKException tKException = new TKException(sb.toString(), th);
                e.log().printStackTraceOnly(tKException);
                OfflineHostProvider.getApi().crash().gatherException(tKException);
                TkOfflineCompoImpl.this.uploadToKds(th, tkBundleInfo, str);
            }
        });
        com.tk.core.a.oP().a(new f(context));
        com.tk.core.a.oP().a(new g());
        TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(1).setDownloadTime(checkLoadTime(SystemClock.elapsedRealtime() - this.loadTimeStart)).setLoadingTimes(mLoadTimes).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadToKds(Throwable th, TkBundleInfo tkBundleInfo, String str) {
        try {
            TKExceptionUploadParams tKExceptionUploadParams = new TKExceptionUploadParams();
            tKExceptionUploadParams.error = Log.getStackTraceString(th).replaceAll("\\n    at", "#at").replaceAll("\\n\\tat", "#at").replaceAll("\\n", "#");
            if (this.useTkSoAll) {
                tKExceptionUploadParams.v8SoType = 2;
            } else {
                tKExceptionUploadParams.v8SoType = 1;
            }
            tKExceptionUploadParams.bundleType = tkBundleInfo.mBundleSource;
            tKExceptionUploadParams.bundleSource = BUNDLE_SOURCE_REMOTE;
            tKExceptionUploadParams.bundleId = tkBundleInfo.mBundleId;
            tKExceptionUploadParams.bundleVersionCode = String.valueOf(tkBundleInfo.mVersionCode);
            tKExceptionUploadParams.businessName = tkBundleInfo.mBundleId;
            tKExceptionUploadParams.sessionId = str;
            tKExceptionUploadParams.templateId = tKExceptionUploadParams.bundleId;
            tKExceptionUploadParams.bizExtraInfo = "";
            tKExceptionUploadParams.containerType = 1;
            tKExceptionUploadParams.errorType = "2";
            tKExceptionUploadParams.key = CUSTOM_STAT_KEY_JS;
            OfflineHostProvider.getApi().crash().gatherException(tKExceptionUploadParams);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public ITkOfflineCompo.TKState getState() {
        if (sIsTkSoLoaded.get() && TachikomaApi.getInstance().isInitSuccess()) {
            return ITkOfflineCompo.TKState.READY;
        }
        return ITkOfflineCompo.TKState.SO_FAIL;
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public IOfflineCompoTachikomaContext getContext(Context context, String str, int i, int i2, boolean z) {
        i iVar = new i(e.hP().hQ().wrapper().wrapContextIfNeed(context), z);
        iVar.l(str);
        iVar.bN(i);
        iVar.bO(i2);
        addCrashCustomMessage();
        return iVar;
    }

    private void addCrashCustomMessage() {
        if (sHasSetupCrashInfo || !OfflineHostProvider.getApi().env().isTKCrashCollectEnable()) {
            return;
        }
        sHasSetupCrashInfo = true;
        OfflineHostProvider.getApi().crash().addCustomKeyValue(new ICrashCustomKeyValue() { // from class: com.kwad.tachikoma.TkOfflineCompoImpl.4
            @Override // com.kwad.components.offline.api.core.api.ICrashCustomKeyValue
            public final String getKey() {
                return "mTKInfo";
            }

            @Override // com.kwad.components.offline.api.core.api.ICrashCustomKeyValue
            public final JSONObject getValue() {
                return a.hM();
            }
        });
        OfflineHostProvider.getApi().crash().addOnCrashListener(new ICrashOccurListener() { // from class: com.kwad.tachikoma.TkOfflineCompoImpl.5
            @Override // com.kwad.components.offline.api.core.api.ICrashOccurListener
            public final void onCrashOccur(int i, String str) {
                b bVarHN = a.hN();
                if (bVarHN == null || bVarHN.templateId == null || str == null) {
                    return;
                }
                String[] strArrSplit = str.split("##");
                if (strArrSplit.length > 0) {
                    str = strArrSplit[0];
                }
                OfflineHostProvider.getApi().log().e(TkOfflineCompoImpl.TAG, "report tk exception:" + bVarHN.templateId + ":" + str);
                TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(3).setErrorReason(str).setTemplateId(bVarHN.templateId).setVersionCode(String.valueOf(bVarHN.versionCode)).toJson());
            }
        });
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public String getJsBaseDir(Context context, String str) {
        return e.hP().hQ().getTkJsFileDir(context, str);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public String getTKVersion() {
        return e.hP().hQ().getTkVersion();
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public void onConfigRefresh(Context context, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(KEY_STYLE_TEMPLATES_CONFIG);
        ArrayList arrayList = null;
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optJSONArray(KEY_STYLE_TEMPLATES);
        if (jSONArrayOptJSONArray != null) {
            arrayList = new ArrayList(jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                arrayList.add(styleTemplate);
            }
        }
        com.kwad.tachikoma.g.a.ik().a(context, arrayList);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        StyleTemplate styleTemplate = new StyleTemplate();
        styleTemplate.templateId = str;
        styleTemplate.templateMd5 = str2;
        styleTemplate.templateUrl = str3;
        styleTemplate.templateVersionCode = i;
        return com.kwad.tachikoma.g.a.ik().a(context, styleTemplate);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) throws Throwable {
        StyleTemplate styleTemplate = new StyleTemplate();
        styleTemplate.templateId = str;
        styleTemplate.templateMd5 = str2;
        styleTemplate.templateUrl = str3;
        styleTemplate.templateVersionCode = i;
        com.kwad.tachikoma.g.a.ik().a(context, styleTemplate, tKDownloadListener);
    }

    @Override // com.kwad.components.offline.api.tk.ITkOfflineCompo
    public void onDestroy() {
        com.kwad.tachikoma.g.a.ik().ij();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTKSOLoadError(String str, Throwable th) {
        TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setErrorReason(str).setDownloadState(2).setErrorDetail(th.getMessage()).setLoadingTimes(mLoadTimes).toJson());
    }

    @Override // com.kwad.components.offline.api.IOfflineCompo
    public Class<?> getComponentsType() {
        return TkOfflineCompoImpl.class;
    }
}
