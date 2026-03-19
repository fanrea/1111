package com.kwai.kanas.interfaces;

import android.util.Log;
import com.kwai.kanas.Kanas;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class KanasLogger {
    public void logEvent(String str, String str2) {
        Log.i(Kanas.c, "key: " + str + ", value: " + str2);
    }

    public void logErrors(Throwable th) {
        Log.e(Kanas.c, "", th);
    }
}
