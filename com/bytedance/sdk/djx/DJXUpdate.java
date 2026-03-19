package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.empty.EmptyDJXUpdate;
import com.bytedance.sdk.djx.impl.DJXSdkInstance;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXUpdate {
    public static void setPersonalRec(boolean z, IDJXRecSwitchCallback iDJXRecSwitchCallback) {
        getUpdateImpl().setPersonalRec(z, iDJXRecSwitchCallback);
    }

    public static boolean getPersonRec() {
        return getUpdateImpl().getPersonRec();
    }

    public static String getToken() {
        return getUpdateImpl().getToken();
    }

    private static IDJXUpdate getUpdateImpl() {
        IDJXUpdate iDJXUpdateUpdate = DJXSdkInstance.getInstance().update();
        return iDJXUpdateUpdate == null ? EmptyDJXUpdate.getInstance() : iDJXUpdateUpdate;
    }
}
