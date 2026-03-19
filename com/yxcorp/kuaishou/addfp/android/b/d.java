package com.yxcorp.kuaishou.addfp.android.b;

import com.kwad.sdk.datacollection.KsSafetyPrivateDataController;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class d {
    public static String a(boolean z) {
        return new c(KsSafetyPrivateDataController.getInstance().getAndroidID()).a(z);
    }

    public static String b(boolean z) {
        return new c(KsSafetyPrivateDataController.getInstance().getIMEI()).a(z);
    }

    public static String c(boolean z) {
        return new c(KsSafetyPrivateDataController.getInstance().getMac()).a(z);
    }

    public static String d(boolean z) {
        return new c(KsSafetyPrivateDataController.getInstance().getOaid()).a(z);
    }

    public static String e(boolean z) {
        return new c(KsSafetyPrivateDataController.getInstance().getIccId()).a(z);
    }
}
