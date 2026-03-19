package com.qq.e.comm.plugin;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.GDTFileProvider;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class re {
    private static Class a;
    private static Class b;
    private static Class c;

    static {
        try {
            a = Class.forName("androidx.core.content.FileProvider");
        } catch (ClassNotFoundException unused) {
            a = null;
        }
        try {
            b = Class.forName("android.support.v4.content.FileProvider");
        } catch (ClassNotFoundException unused2) {
            b = null;
        }
        try {
            c = Class.forName("com.qq.e.comm.GDTFileProvider");
        } catch (ClassNotFoundException unused3) {
            c = null;
        }
    }

    public static Uri a(Context context, File file) {
        int i = Build.VERSION.SDK_INT;
        if (i < 29 && (i < 24 || context.getApplicationInfo().targetSdkVersion < 24)) {
            return Uri.fromFile(file);
        }
        String packageName = context.getPackageName();
        Uri uriA = a(context, packageName + ".fileprovider", file);
        if (uriA == null || TextUtils.isEmpty(uriA.getPath())) {
            uriA = a(context, packageName + ".gdt.fileprovider", file);
        }
        if (uriA != null && (!TextUtils.isEmpty(uriA.getPath()) || c == null)) {
            return uriA;
        }
        return GDTFileProvider.getUriForFile(context, packageName + ".gdt.fileprovider", file);
    }

    private static Uri a(Context context, String str, File file) {
        Method method;
        Uri uri = Uri.EMPTY;
        try {
            Class cls = a;
            if (cls != null) {
                method = cls.getMethod("getUriForFile", Context.class, String.class, File.class);
            } else {
                Class cls2 = b;
                method = cls2 != null ? cls2.getMethod("getUriForFile", Context.class, String.class, File.class) : null;
            }
            return method != null ? (Uri) method.invoke(null, context, str, file) : uri;
        } catch (Throwable th) {
            th.getMessage();
            return uri;
        }
    }
}
