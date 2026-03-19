package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.empty.EmptyDJXCave;
import com.bytedance.sdk.djx.impl.DJXSdkInstance;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXCave {
    public static String a() {
        return getCaveImpl().a();
    }

    public static void b(Map<String, String> map) {
        getCaveImpl().b(map);
    }

    private static IDJXCave getCaveImpl() {
        IDJXCave iDJXCaveCave = DJXSdkInstance.getInstance().cave();
        return iDJXCaveCave == null ? EmptyDJXCave.getInstance() : iDJXCaveCave;
    }
}
