package com.tencent.gatherer.core.internal.util;

import android.util.Log;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d {
    private static String a = "Gatherer";
    private static e b = new a();

    /* compiled from: A */
    class a implements e {
        a() {
        }

        @Override // com.tencent.gatherer.core.internal.util.e
        public void a(String str, String str2) {
        }

        @Override // com.tencent.gatherer.core.internal.util.e
        public void a(String str, String str2, Throwable th) {
        }

        @Override // com.tencent.gatherer.core.internal.util.e
        public void b(String str, String str2) {
        }
    }

    public static void a(String str) {
        e eVar = b;
        if (eVar != null) {
            eVar.b(a, str);
        } else {
            Log.d(a, str);
        }
    }

    public static void b(String str) {
        e eVar = b;
        if (eVar != null) {
            eVar.a(a, str);
        } else {
            Log.e(a, str);
        }
    }

    public static void a(String str, Throwable th) {
        e eVar = b;
        if (eVar != null) {
            eVar.a(a, str, th);
        } else {
            Log.e(a, str, th);
        }
    }
}
