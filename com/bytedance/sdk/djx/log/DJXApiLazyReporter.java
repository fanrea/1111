package com.bytedance.sdk.djx.log;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.TTVfSdk;
import com.bytedance.sdk.djx.settings.DJXGlobalSettings;
import com.bytedance.sdk.djx.utils.AdSdkUtils;
import com.bytedance.sdk.djx.utils.HostContext;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.SPUtils;
import com.bytedance.sdk.djx.utils.Utils;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.nativekv.NativeKV;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DJXApiLazyReporter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010%\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0002J<\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00062\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u000201H\u0007J\u001a\u00102\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0007J5\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u00107J\b\u00108\u001a\u00020$H\u0007J\u0010\u00109\u001a\u00020$2\u0006\u0010:\u001a\u000201H\u0007J\u0018\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0016J\f\u0010>\u001a\u00020?*\u00020?H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/sdk/djx/log/DJXApiLazyReporter;", "Lcom/bytedance/sdk/djx/log/ILazyReporter;", "()V", "DATA_NUM_LIMIT", "", "EVENT_REGISTER_FINISH", "", "EVENT_REGISTER_START", "EVENT_SDK_LAUNCH_MONITOR", "EVENT_SDK_START_LAUNCH_MONITOR", "EVENT_SDK_SYN_LAUNCH_DURATION", "KEY_DURATION", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_IS_INSTALLED", "KEY_PANGLE_VERSION", "KEY_PKG_NAME", "KEY_PLUGIN_VERSION", "KEY_REAL_MACHINE_TIME_STAMP", "KEY_REPORT_TIME", "KEY_SDK_ASYNC_LAUNCH_DURATION", "KEY_SDK_IS_FIRST_INIT", "KEY_SDK_IS_INTI_SUCCESS", "KEY_SDK_IS_PLUGIN", "KEY_SDK_SYNC_LAUNCH_DURATION", "KEY_SDK_VERSION", "KEY_STATUS", "SP_API_REPORTER", "VALUE_STATUS_FAIL", "VALUE_STATUS_SUCCESS", "nativeKVDir", "getNativeKVDir", "()Ljava/lang/String;", "sp", "Lcom/bytedance/sdk/djx/utils/SPUtils;", "clear", "", NotificationCompat.CATEGORY_EVENT, "getEventParams", "Lorg/json/JSONArray;", "getPackageName", "logEventRegisterFinish", "isInstalled", "", "sdkVersion", "status", "errorCode", "pluginVersion", "durationMills", "", "logEventRegisterStart", "logEventSdkLaunchMonitor", "isSuccess", "cost", "errorMsg", "(ZJLjava/lang/Integer;Ljava/lang/String;)V", "logEventSdkStartLaunchMonitor", "logEventSdkSynLaunchMonitor", "syncCost", "saveLocalData", "key", "data", "injectCommonParams", "Lorg/json/JSONObject;", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXApiLazyReporter implements ILazyReporter {
    private static final int DATA_NUM_LIMIT = 50;
    public static final String EVENT_REGISTER_FINISH = "video_plugin_register_finish";
    public static final String EVENT_REGISTER_START = "video_plugin_register_start";
    public static final String EVENT_SDK_LAUNCH_MONITOR = "sdk_launch_monitor";
    public static final String EVENT_SDK_START_LAUNCH_MONITOR = "sdk_start_launch_monitor";
    public static final String EVENT_SDK_SYN_LAUNCH_DURATION = "sdk_syn_launch_duration";
    public static final DJXApiLazyReporter INSTANCE = new DJXApiLazyReporter();
    private static final String KEY_DURATION = "duration";
    private static final String KEY_ERROR_CODE = "error_code";
    private static final String KEY_ERROR_MSG = "error_msg";
    private static final String KEY_IS_INSTALLED = "is_installed";
    private static final String KEY_PANGLE_VERSION = "pangle_version";
    private static final String KEY_PKG_NAME = "pkg_name";
    private static final String KEY_PLUGIN_VERSION = "plugin_version";
    private static final String KEY_REAL_MACHINE_TIME_STAMP = "real_machine_time_stamp";
    private static final String KEY_REPORT_TIME = "report_time";
    private static final String KEY_SDK_ASYNC_LAUNCH_DURATION = "sdk_asyn_launch_duration";
    private static final String KEY_SDK_IS_FIRST_INIT = "sdk_is_first_init";
    private static final String KEY_SDK_IS_INTI_SUCCESS = "sdk_is_inti_success";
    private static final String KEY_SDK_IS_PLUGIN = "sdk_is_plugin";
    private static final String KEY_SDK_SYNC_LAUNCH_DURATION = "sdk_sync_launch_duration";
    private static final String KEY_SDK_VERSION = "sdk_version";
    private static final String KEY_STATUS = "status";
    private static final String SP_API_REPORTER = "djxsdk_api_reporter";
    public static final int VALUE_STATUS_FAIL = 0;
    public static final int VALUE_STATUS_SUCCESS = 1;
    private static final String nativeKVDir;
    private static final SPUtils sp;

    private DJXApiLazyReporter() {
    }

    public final String getNativeKVDir() {
        return nativeKVDir;
    }

    static {
        Context context = HostContext.getContext();
        if (NativeKV.getRootDir() == null) {
            NativeKV.initialize(context);
        }
        SPUtils sPUtils = SPUtils.getInstance(SP_API_REPORTER);
        Intrinsics.checkNotNullExpressionValue(sPUtils, "getInstance(SP_API_REPORTER)");
        sp = sPUtils;
        String rootDir = NativeKV.getRootDir();
        Intrinsics.checkNotNullExpressionValue(rootDir, "getRootDir()");
        nativeKVDir = rootDir;
    }

    @JvmStatic
    public static final void logEventRegisterStart(boolean isInstalled, String sdkVersion) {
        DJXApiLazyReporter dJXApiLazyReporter = INSTANCE;
        JSONObject jSONObjectInjectCommonParams = dJXApiLazyReporter.injectCommonParams(new JSONObject());
        JSON.putObject(jSONObjectInjectCommonParams, "is_installed", Integer.valueOf(isInstalled ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_version", sdkVersion);
        if (AdSdkUtils.isAdSdkExist()) {
            if (AdSdkUtils.isOppo()) {
                JSON.putObject(jSONObjectInjectCommonParams, "pangle_version", TTVfSdk.getVfManager().getSDKVersion());
            } else {
                JSON.putObject(jSONObjectInjectCommonParams, "pangle_version", TTAdSdk.getAdManager().getSDKVersion());
            }
        }
        JSON.putObject(jSONObjectInjectCommonParams, "report_time", Long.valueOf(System.currentTimeMillis()));
        String string = jSONObjectInjectCommonParams.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        dJXApiLazyReporter.saveLocalData(EVENT_REGISTER_START, string);
    }

    @JvmStatic
    public static final void logEventRegisterFinish(boolean isInstalled, String sdkVersion, int status, int errorCode, String pluginVersion, long durationMills) {
        DJXApiLazyReporter dJXApiLazyReporter = INSTANCE;
        JSONObject jSONObjectInjectCommonParams = dJXApiLazyReporter.injectCommonParams(new JSONObject());
        JSON.putObject(jSONObjectInjectCommonParams, "is_installed", Integer.valueOf(isInstalled ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_version", sdkVersion);
        JSON.putObject(jSONObjectInjectCommonParams, "status", Integer.valueOf(status));
        JSON.putObject(jSONObjectInjectCommonParams, "error_code", Integer.valueOf(errorCode));
        JSON.putObject(jSONObjectInjectCommonParams, "plugin_version", pluginVersion);
        JSON.putObject(jSONObjectInjectCommonParams, "duration", Integer.valueOf((int) durationMills));
        if (AdSdkUtils.isAdSdkExist()) {
            if (AdSdkUtils.isOppo()) {
                JSON.putObject(jSONObjectInjectCommonParams, "pangle_version", TTVfSdk.getVfManager().getSDKVersion());
            } else {
                JSON.putObject(jSONObjectInjectCommonParams, "pangle_version", TTAdSdk.getAdManager().getSDKVersion());
            }
        }
        JSON.putObject(jSONObjectInjectCommonParams, "report_time", Long.valueOf(System.currentTimeMillis()));
        String string = jSONObjectInjectCommonParams.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        dJXApiLazyReporter.saveLocalData(EVENT_REGISTER_FINISH, string);
    }

    @JvmStatic
    public static final void logEventSdkStartLaunchMonitor() {
        DJXApiLazyReporter dJXApiLazyReporter = INSTANCE;
        JSONObject jSONObjectInjectCommonParams = dJXApiLazyReporter.injectCommonParams(new JSONObject());
        JSON.putObject(jSONObjectInjectCommonParams, "pkg_name", dJXApiLazyReporter.getPackageName());
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_is_first_init", Integer.valueOf(!DJXGlobalSettings.getInstance().getHasInitSuccess() ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_is_plugin", Integer.valueOf(Utils.IS_P ? 1 : 0));
        String string = jSONObjectInjectCommonParams.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        dJXApiLazyReporter.saveLocalData(EVENT_SDK_START_LAUNCH_MONITOR, string);
    }

    @JvmStatic
    public static final void logEventSdkSynLaunchMonitor(long syncCost) {
        DJXApiLazyReporter dJXApiLazyReporter = INSTANCE;
        JSONObject jSONObjectInjectCommonParams = dJXApiLazyReporter.injectCommonParams(new JSONObject());
        JSON.putObject(jSONObjectInjectCommonParams, "pkg_name", dJXApiLazyReporter.getPackageName());
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_sync_launch_duration", Long.valueOf(syncCost));
        String string = jSONObjectInjectCommonParams.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        dJXApiLazyReporter.saveLocalData(EVENT_SDK_SYN_LAUNCH_DURATION, string);
    }

    public static /* synthetic */ void logEventSdkLaunchMonitor$default(boolean z, long j, Integer num, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        logEventSdkLaunchMonitor(z, j, num, str);
    }

    @JvmStatic
    public static final void logEventSdkLaunchMonitor(boolean isSuccess, long cost, Integer errorCode, String errorMsg) {
        DJXApiLazyReporter dJXApiLazyReporter = INSTANCE;
        JSONObject jSONObjectInjectCommonParams = dJXApiLazyReporter.injectCommonParams(new JSONObject());
        JSON.putObject(jSONObjectInjectCommonParams, "pkg_name", dJXApiLazyReporter.getPackageName());
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_is_first_init", Integer.valueOf(!DJXGlobalSettings.getInstance().getHasInitSuccess() ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_asyn_launch_duration", Long.valueOf(cost));
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_is_plugin", Integer.valueOf(Utils.IS_P ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "sdk_is_inti_success", Integer.valueOf(isSuccess ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "error_code", errorCode);
        JSON.putObject(jSONObjectInjectCommonParams, "error_msg", errorMsg);
        String string = jSONObjectInjectCommonParams.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        dJXApiLazyReporter.saveLocalData("sdk_launch_monitor", string);
    }

    @Override // com.bytedance.sdk.djx.log.ILazyReporter
    public void saveLocalData(String key, String data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            SPUtils sPUtils = sp;
            String string = sPUtils.getString(key, (String) null);
            JSONArray jSONArray = new JSONArray();
            if (string != null) {
                jSONArray = new JSONArray(string);
            }
            if (jSONArray.length() >= 50) {
                jSONArray.remove(0);
            }
            jSONArray.put(data);
            sPUtils.put(key, jSONArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.djx.log.ILazyReporter
    public JSONArray getEventParams(String event) {
        String string = event != null ? sp.getString(event, (String) null) : null;
        JSONArray jSONArray = new JSONArray();
        if (string == null) {
            return jSONArray;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            return jSONArray;
        }
    }

    @Override // com.bytedance.sdk.djx.log.ILazyReporter
    public void clear(String event) {
        if (event == null) {
            return;
        }
        sp.remove(event);
    }

    private final String getPackageName() {
        Context context = HostContext.getContext();
        if (context == null) {
            return "";
        }
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.applicationContext.packageName");
        return packageName;
    }

    private final JSONObject injectCommonParams(JSONObject jSONObject) {
        JSON.putObject(jSONObject, "real_machine_time_stamp", Long.valueOf(System.currentTimeMillis()));
        return jSONObject;
    }
}
