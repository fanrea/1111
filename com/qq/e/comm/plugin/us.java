package com.qq.e.comm.plugin;

import android.text.TextUtils;
import dalvik.system.DexClassLoader;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class us extends DexClassLoader {
    private final String[] a;
    private final String[] b;

    public us(String str, String str2, String str3, ClassLoader classLoader, String[] strArr) {
        super(str, str2, str3, classLoader);
        this.a = new String[]{"androidx.annotation", "androidx.collection", "androidx.concurrent.futures", "androidx.exifinterface.media", "androidx.media3", "com.google.common", "com.google.thirdparty.publicsuffix"};
        this.b = strArr;
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (!TextUtils.isEmpty(str) && (a(str, this.a) || a(str, this.b))) {
            return a(str);
        }
        return super.loadClass(str);
    }

    private boolean a(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : this.a) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Class<?> a(String str) throws ClassNotFoundException {
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        try {
            clsFindLoadedClass = findClass(str);
        } catch (ClassNotFoundException unused) {
        }
        return clsFindLoadedClass == null ? super.loadClass(str) : clsFindLoadedClass;
    }
}
