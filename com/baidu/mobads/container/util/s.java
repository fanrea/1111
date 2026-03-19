package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class s {
    public static int a() {
        try {
            Class.forName(u.b("mvqVQhF4IANbmy4Wui4VTvwoQh7bmgKYugc8mh7GuZR8fh7GuZNKuA7sIANzfvq8uh-MIgF9IA-EUBfb"));
            return 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return TextUtils.equals(context.getApplicationContext().getClass().getName(), u.b("mvqVQhF4IANbmy4Wui4smy4MUAR8ILF9TZK-TB4fUZNMpy4KTZK_pyP9IA-EU-IzmgKsugcb")) ? 1 : 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static int b() {
        try {
            Class.forName(u.b("mvqVQh78XgwCpy4oQhPEThR8mgKGQb7RRYwQ"));
            return 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static int c() {
        try {
            Class.forName("androidx.recyclerview.widget.RecyclerView");
            return 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static int d() {
        try {
            Class.forName("android.support.v7.widget.RecyclerView");
            return 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static int e() {
        try {
            Class.forName("androidx.media3.exoplayer.ExoPlayer");
            return 1;
        } catch (Throwable th) {
            return 0;
        }
    }
}
