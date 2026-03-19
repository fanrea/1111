package com.kwad.sdk.glide.load.a.a;

import android.net.Uri;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static boolean Q(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    private static boolean b(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean c(Uri uri) {
        return a(uri) && b(uri);
    }

    public static boolean d(Uri uri) {
        return a(uri) && !b(uri);
    }
}
