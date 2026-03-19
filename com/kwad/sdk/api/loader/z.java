package com.kwad.sdk.api.loader;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class z {
    public static Field c(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static synchronized String b(ClassLoader classLoader) {
        String strC;
        if ((Build.VERSION.SDK_INT != 25 || Build.VERSION.PREVIEW_SDK_INT == 0) && Build.VERSION.SDK_INT <= 25) {
            if (Build.VERSION.SDK_INT != 24) {
                if (Build.VERSION.SDK_INT < 23) {
                    strC = Build.VERSION.SDK_INT >= 14 ? a.c(classLoader) : e.c(classLoader);
                } else {
                    try {
                        strC = b.c(classLoader);
                    } finally {
                        strC = a.c(classLoader);
                    }
                }
            } else {
                try {
                    strC = c.c(classLoader);
                } finally {
                    strC = a.c(classLoader);
                }
            }
        } else {
            try {
                strC = d.g(classLoader);
            } catch (Throwable th) {
                Log.e("ShareLibraryGetter", String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
                strC = b.c(classLoader);
            }
        }
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ad(List<File> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getAbsolutePath());
            if (i < list.size() - 1) {
                sb.append(File.pathSeparator);
            }
        }
        return sb.toString();
    }

    static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) {
            return String.valueOf(z.c(classLoader, "libPath").get(classLoader));
        }
    }

    static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) throws IllegalAccessException, IllegalArgumentException {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.ad(Arrays.asList((File[]) z.c(obj, "nativeLibraryDirectories").get(obj)));
        }
    }

    static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) throws IllegalAccessException, IllegalArgumentException {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.ad((List) z.c(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) throws IllegalAccessException, IllegalArgumentException {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.ad((List) z.c(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static String g(ClassLoader classLoader) throws IllegalAccessException, IllegalArgumentException {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.ad((List) z.c(obj, "nativeLibraryDirectories").get(obj));
        }
    }
}
