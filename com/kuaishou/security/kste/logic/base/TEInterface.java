package com.kuaishou.security.kste.logic.base;

import android.content.Context;
import com.kuaishou.security.kste.logic.report.KVGuardPerf;
import com.kuaishou.security.kste.logic.util.Utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class TEInterface {
    public static String[] initVM(Context context, String str) {
        return TENative.a(context, str);
    }

    public static byte[] invokeFunction(String str, byte[] bArr, int i) {
        return TENative.b(str, bArr, i);
    }

    public static int[] vmBCSupportFormats() {
        try {
            return TENative.c();
        } catch (Throwable unused) {
            int[] iArrC = TENative.c();
            if (iArrC.length != 0) {
                return iArrC;
            }
            KVGuardPerf.error(KVGuardPerf.RType.ALL, "maps:[" + Utils.processMaps() + "]", 212);
            return iArrC;
        }
    }
}
