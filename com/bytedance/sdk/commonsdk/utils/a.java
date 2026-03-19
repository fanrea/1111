package com.bytedance.sdk.commonsdk.utils;

import android.content.Context;
import java.io.File;

/* compiled from: PluginUtils.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class a {
    public static File a(Context context) {
        try {
            return context.getCacheDir();
        } catch (Exception unused) {
            return null;
        }
    }

    public static File b(Context context) {
        try {
            return context.getExternalCacheDir();
        } catch (Exception unused) {
            return null;
        }
    }
}
