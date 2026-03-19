package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.default, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Cdefault {
    public static final AtomicReference<String> a = new AtomicReference<>();

    public static String a() {
        AtomicReference<String> atomicReference = a;
        String str = atomicReference.get();
        if (str == null) {
            synchronized (atomicReference) {
                str = atomicReference.get();
                if (str == null) {
                    str = Build.MODEL;
                    atomicReference.set(str);
                }
            }
        }
        return str;
    }

    public static int b() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
