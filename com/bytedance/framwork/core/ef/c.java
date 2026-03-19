package com.bytedance.framwork.core.ef;

import android.content.Context;
import java.io.UnsupportedEncodingException;

/* compiled from: LogLib.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    private static b a = new a();
    private static boolean b;

    /* compiled from: LogLib.java */
    public static class a implements b {
        @Override // com.bytedance.framwork.core.ef.c.b
        public boolean a(Context context) {
            return false;
        }
    }

    /* compiled from: LogLib.java */
    public interface b {
        boolean a(Context context);
    }

    public static void a(b bVar) {
        if (b) {
            return;
        }
        if (bVar != null) {
            a = bVar;
        }
        b = true;
    }

    static boolean a(Context context) {
        return a.a(context);
    }

    public static byte[] a(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return str.getBytes("UTF-8");
                }
            } catch (UnsupportedEncodingException unused) {
                return str.getBytes();
            }
        }
        return null;
    }
}
