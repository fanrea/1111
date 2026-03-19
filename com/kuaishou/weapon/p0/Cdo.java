package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.do, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class Cdo {
    public static synchronized void a(ClassLoader classLoader, File file) {
        if (file != null) {
            if (file.exists()) {
                if ((Build.VERSION.SDK_INT != 25 || Build.VERSION.PREVIEW_SDK_INT == 0) && Build.VERSION.SDK_INT <= 25) {
                    if (Build.VERSION.SDK_INT != 24) {
                        if (Build.VERSION.SDK_INT < 23) {
                            if (Build.VERSION.SDK_INT < 14) {
                                e.b(classLoader, file);
                            } else {
                                a.b(classLoader, file);
                                return;
                            }
                        } else {
                            try {
                                b.b(classLoader, file);
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                    try {
                        c.b(classLoader, file);
                        return;
                    } finally {
                    }
                } else {
                    try {
                        d.b(classLoader, file);
                        return;
                    } catch (Throwable unused) {
                        b.b(classLoader, file);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$e */
    static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            String path = file.getPath();
            Field fieldA = dq.a(classLoader, "libPath");
            String strValueOf = String.valueOf(fieldA.get(classLoader));
            fieldA.set(classLoader, !TextUtils.isEmpty(strValueOf) ? strValueOf + ":" + path : path);
            Field fieldA2 = dq.a(classLoader, "libraryPathElements");
            List list = (List) fieldA2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    return;
                }
            }
            list.add(path);
            fieldA2.set(classLoader, list);
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$a */
    static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            Field fieldA = dq.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) fieldA.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            fieldA.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$b */
    static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            Field fieldA = dq.a(obj, "nativeLibraryDirectories");
            Collection arrayList = (List) fieldA.get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList2.add(file);
            fieldA.set(obj, arrayList2);
            if (fieldA.get(obj) != arrayList2) {
                dq.b(obj, "nativeLibraryDirectories").set(obj, arrayList2);
            }
            List arrayList3 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList(2);
            }
            ArrayList arrayList4 = new ArrayList(arrayList2.size() + arrayList3.size() + 1);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            Object obj2 = (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList4, null, new ArrayList());
            Field fieldA2 = dq.a(obj, "nativeLibraryPathElements");
            fieldA2.set(obj, obj2);
            if (fieldA2.get(obj) != obj2) {
                dq.b(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$c */
    static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, IllegalArgumentException {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList3, null, new ArrayList()));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$d */
    static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) throws IllegalAccessException, IllegalArgumentException {
            Object obj = dq.a(classLoader, "pathList").get(classLoader);
            List arrayList = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    return;
                }
            }
            arrayList.add(file);
            List arrayList2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList(2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size() + 1);
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class).invoke(obj, arrayList3));
        }
    }
}
