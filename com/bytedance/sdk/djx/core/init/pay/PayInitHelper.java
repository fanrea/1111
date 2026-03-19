package com.bytedance.sdk.djx.core.init.pay;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOrder;
import com.bytedance.sdk.djx.model.DJXRenewal;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class PayInitHelper {
    private static final String CLS_PAY = "com.pangrowth.empay.EMPaySdk";
    private static final String TAG = "PayInitHelper";

    public static void init(Context context, DJXSdkConfig dJXSdkConfig) {
        if (!hasPaySdk()) {
            LG.d(TAG, "pay module not exist");
        } else {
            PayProxy.init(context, dJXSdkConfig);
        }
    }

    public static void pay(String str, IDJXService.IDJXCallback<DJXOrder> iDJXCallback) {
        if (!hasPaySdk()) {
            LG.d(TAG, "pay module not exist");
            iDJXCallback.onError(DJXError.build(-6, ErrCode.msg(-6)));
        } else {
            PayProxy.pay(str, iDJXCallback);
        }
    }

    public static void cancelRenewal(long j, long j2, IDJXService.IDJXCallback<DJXRenewal> iDJXCallback) {
        if (!hasPaySdk()) {
            LG.d(TAG, "pay module not exist");
            iDJXCallback.onError(DJXError.build(-6, ErrCode.msg(-6)));
        } else {
            PayProxy.cancelRenewal(j, j2, iDJXCallback);
        }
    }

    private static boolean hasPaySdk() {
        return isExist(CLS_PAY);
    }

    private static boolean isExist(String str) throws ClassNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
