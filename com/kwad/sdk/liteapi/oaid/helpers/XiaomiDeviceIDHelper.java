package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class XiaomiDeviceIDHelper {
    private static final String TAG = "XiaomiDeviceIDHelper";
    private Context mContext;

    public XiaomiDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String str;
        Exception e;
        try {
            str = (String) OaidJavaCalls.callMethod(OaidJavaCalls.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
        } catch (Exception e2) {
            str = "";
            e = e2;
        }
        try {
            LiteApiLogger.i(TAG, "getOAID oaid:" + str);
        } catch (Exception e3) {
            e = e3;
            LiteApiLogger.i(TAG, "getOAID fail");
            LiteApiLogger.printStackTraceOnly(e);
            return str;
        }
        return str;
    }
}
