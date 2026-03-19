package com.kuaishou.aegon;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
class AegonLoggingDispatcher {
    private static d a;

    AegonLoggingDispatcher() {
    }

    static void a(d dVar) {
        a = dVar;
    }

    static void a(int i, String str, String str2) {
        d dVar = a;
        if (dVar != null) {
            dVar.a(i, str, str2);
            return;
        }
        if (i == 0) {
            Log.d(str, str2);
            return;
        }
        if (i == 1) {
            Log.i(str, str2);
        } else if (i == 2) {
            Log.w(str, str2);
        } else {
            if (i != 3) {
                return;
            }
            Log.e(str, str2);
        }
    }

    static void Log(int i, String str, String str2) {
        a(i, str, str2);
    }
}
