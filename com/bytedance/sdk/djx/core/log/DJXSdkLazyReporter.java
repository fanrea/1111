package com.bytedance.sdk.djx.core.log;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.log.ILazyReporter;
import com.bytedance.sdk.djx.utils.HostContext;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.SPUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DJXSdkLazyReporter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0002JE\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/djx/core/log/DJXSdkLazyReporter;", "Lcom/bytedance/sdk/djx/log/ILazyReporter;", "()V", "DATA_NUM_LIMIT", "", "SP_LAZY_REPORTER", "", "sp", "Lcom/bytedance/sdk/djx/utils/SPUtils;", "clear", "", NotificationCompat.CATEGORY_EVENT, "getEventParams", "Lorg/json/JSONArray;", "getPackageName", "logEventSdkLaunchTaskMonitor", "taskName", "isSuccess", "", "isAsync", "cost", "", "errorCode", "errorMsg", "(Ljava/lang/String;ZZJLjava/lang/Integer;Ljava/lang/String;)V", "saveLocalData", "key", "data", "injectCommonParams", "Lorg/json/JSONObject;", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXSdkLazyReporter implements ILazyReporter {
    private static final int DATA_NUM_LIMIT = 50;
    public static final DJXSdkLazyReporter INSTANCE = new DJXSdkLazyReporter();
    private static final String SP_LAZY_REPORTER = "djxsdk_lazy_reporter";
    private static final SPUtils sp;

    private DJXSdkLazyReporter() {
    }

    static {
        SPUtils sPUtils = SPUtils.getInstance(SP_LAZY_REPORTER);
        Intrinsics.checkNotNullExpressionValue(sPUtils, "getInstance(SP_LAZY_REPORTER)");
        sp = sPUtils;
    }

    @JvmStatic
    public static final void logEventSdkLaunchTaskMonitor(String taskName, boolean isSuccess, boolean isAsync, long cost, Integer errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        DJXSdkLazyReporter dJXSdkLazyReporter = INSTANCE;
        JSONObject jSONObjectInjectCommonParams = dJXSdkLazyReporter.injectCommonParams(new JSONObject());
        JSON.putObject(jSONObjectInjectCommonParams, ILogConst.Keys.KEY_PKG_NAME, dJXSdkLazyReporter.getPackageName());
        JSON.putObject(jSONObjectInjectCommonParams, ILogConst.Keys.KEY_TASK_NAME, taskName);
        JSON.putObject(jSONObjectInjectCommonParams, ILogConst.Keys.KEY_TASK_LAUNCH_DURATION, Long.valueOf(cost));
        JSON.putObject(jSONObjectInjectCommonParams, ILogConst.Keys.KEY_IS_INIT_SUCCESS, Integer.valueOf(isSuccess ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, ILogConst.Keys.KEY_IS_ASYNC, Integer.valueOf(isAsync ? 1 : 0));
        JSON.putObject(jSONObjectInjectCommonParams, "error_code", errorCode);
        JSON.putObject(jSONObjectInjectCommonParams, "error_msg", errorMsg);
        String string = jSONObjectInjectCommonParams.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        dJXSdkLazyReporter.saveLocalData(ILogConst.EVENT_SDK_LAUNCH_TASK_MONITOR, string);
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
        JSON.putObject(jSONObject, ILogConst.Keys.KEY_REAL_MACHINE_TIME_STAMP, Long.valueOf(System.currentTimeMillis()));
        return jSONObject;
    }
}
