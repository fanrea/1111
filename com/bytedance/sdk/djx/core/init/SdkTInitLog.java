package com.bytedance.sdk.djx.core.init;

import android.content.Context;
import com.baidu.mobads.container.util.cm;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.Utils;
import com.bytedance.sdk.djx.utils.VerifierSp;
import com.sigmob.sdk.base.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkTInitLog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\u0007\u001a\u00020\bJ0\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J;\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015JC\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\b2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/sdk/djx/core/init/SdkTInitLog;", "", "()V", "commonParams", "", "", "getPackageName", "sendSdkInitBegin", "", "sendSdkInitEnd", "isSuccess", "", cm.V, "cost", "", "isActivate", "", "isRequestToken", "sendSdkLaunchMonitor", "errorCode", "errorMsg", "(ZJILjava/lang/Integer;Ljava/lang/String;)V", "sendSdkLaunchTaskMonitor", "taskName", "isAsync", "(Ljava/lang/String;ZZJLjava/lang/Integer;Ljava/lang/String;)V", "setParams", "Companion", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SdkTInitLog {
    private static final String TAG = "SdkTInitLog";
    private Map<String, ? extends Object> commonParams;

    public final void setParams(Map<String, ? extends Object> commonParams) {
        this.commonParams = commonParams;
    }

    public final void sendSdkLaunchTaskMonitor(String taskName, boolean isSuccess, boolean isAsync, long cost, Integer errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        BLogAgent.build(null, ILogConst.EVENT_SDK_LAUNCH_TASK_MONITOR, this.commonParams).putString(ILogConst.Keys.KEY_PKG_NAME, getPackageName()).putString(ILogConst.Keys.KEY_TASK_NAME, taskName).putLong(ILogConst.Keys.KEY_TASK_LAUNCH_DURATION, cost).putInt(ILogConst.Keys.KEY_IS_INIT_SUCCESS, isSuccess ? 1 : 0).putInt(ILogConst.Keys.KEY_IS_ASYNC, isAsync ? 1 : 0).putInt("error_code", errorCode == null ? -1 : errorCode.intValue()).putString("error_msg", errorMsg).send();
    }

    public final void sendSdkInitBegin() {
        BLogAgent.build(null, ILogConst.EVENT_SDK_INIT_BEGIN, this.commonParams).putString(n.p, getPackageName()).putInt(ILogConst.Keys.KEY_IS_REQUEST_TOKEN, TokenHelper.getInstance().isGetTokenFromServer() ? 1 : 0).putInt("is_plugin", Utils.IS_P ? 1 : 0).putString("verifier_disabled", VerifierSp.isVerifierDisabled() ? "1" : "0").send();
        LG.i(TAG, Intrinsics.stringPlus("Init is beginning, is_request_token = ", Boolean.valueOf(TokenHelper.getInstance().isGetTokenFromServer())));
    }

    public final void sendSdkInitEnd(boolean isSuccess, String message, long cost, int isActivate, int isRequestToken) {
        BLogAgent.build(null, ILogConst.EVENT_SDK_INIT_END, null).putString("success", isSuccess ? "1" : "0").putLong("duration", cost).putInt("error_code", DJXError.build().code).putString("error_msg", message).putString(n.p, getPackageName()).putInt("is_activate", isActivate).putInt(ILogConst.Keys.KEY_IS_REQUEST_TOKEN, isRequestToken).putInt("is_plugin", Utils.IS_P ? 1 : 0).putString("verifier_disabled", VerifierSp.isVerifierDisabled() ? "1" : "0").send();
    }

    public final void sendSdkLaunchMonitor(boolean isSuccess, long cost, int isActivate, Integer errorCode, String errorMsg) {
        BLogAgent.build(null, "sdk_launch_monitor", this.commonParams).putString(ILogConst.Keys.KEY_PKG_NAME, getPackageName()).putInt(ILogConst.Keys.KEY_SDK_IS_FIRST_INIT, isActivate).putLong(ILogConst.Keys.KEY_SDK_ASYNC_LAUNCH_DURATION, cost).putInt(ILogConst.Keys.KEY_SDK_IS_PLUGIN, Utils.IS_P ? 1 : 0).putInt(ILogConst.Keys.KEY_SDK_IS_INTI_SUCCESS, isSuccess ? 1 : 0).putInt("error_code", errorCode == null ? -1 : errorCode.intValue()).putString("error_msg", errorMsg).send();
    }

    private final String getPackageName() {
        Context context = InnerManager.getContext();
        if (context == null) {
            return "";
        }
        String packageName = context.getApplicationContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.applicationContext.packageName");
        return packageName;
    }
}
