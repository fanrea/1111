package com.bytedance.rpc.log;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.bytedance.rpc.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: DefaultErrorFormatter.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a {
    private static a k;
    private static final InterfaceC0259a l = new InterfaceC0259a() { // from class: com.bytedance.rpc.log.a.1
        @Override // com.bytedance.rpc.log.a.InterfaceC0259a
        public boolean a(String str, String str2) {
            return !str2.startsWith("access$");
        }

        @Override // com.bytedance.rpc.log.a.InterfaceC0259a
        public String a(String str, Throwable th, List<StackTraceElement> list, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(th.toString());
            if (com.bytedance.sdk.djx.proguard3.c.d.b(str)) {
                sb.append(String.format("@{%s}", str));
            }
            int size = list == null ? 0 : list.size();
            for (int i = 0; i < size; i++) {
                a(list.get(i), sb, z);
            }
            return sb.toString();
        }

        protected StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb, boolean z) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            int lineNumber = stackTraceElement.getLineNumber();
            if (!z || lineNumber < 0) {
                sb.append(String.format("\n<(%s:%s)", className, methodName));
            } else {
                sb.append(String.format("\n<(%s:%s:%s)", className, methodName, Integer.valueOf(lineNumber)));
            }
            return sb;
        }
    };
    private TreeSet<String> a = null;
    private String[] b = null;
    private InterfaceC0259a c = null;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private boolean g = true;
    private int h;
    private int i;
    private int j;

    /* compiled from: DefaultErrorFormatter.java */
    /* renamed from: com.bytedance.rpc.log.a$a, reason: collision with other inner class name */
    public interface InterfaceC0259a {
        String a(String str, Throwable th, List<StackTraceElement> list, boolean z);

        boolean a(String str, String str2);
    }

    public static a a() {
        if (k == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a(6, 18, 3, new String[0]);
                }
            }
        }
        return k;
    }

    public a(int i, int i2, int i3, String... strArr) {
        this.j = i;
        this.h = i2;
        this.i = i3;
        if (strArr == null || strArr.length <= 1) {
            return;
        }
        a(strArr);
    }

    public a a(String... strArr) {
        this.b = strArr;
        TreeSet<String> treeSet = this.a;
        if (treeSet != null) {
            treeSet.clear();
            this.a = null;
        }
        return this;
    }

    public static HashSet<String> a(Context context, boolean z) {
        String strSubstring;
        int iLastIndexOf;
        HashSet<String> hashSet = new HashSet<>();
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                if (com.bytedance.sdk.djx.proguard3.c.d.b(packageName)) {
                    hashSet.add(packageName);
                    ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                    if (activityInfoArr != null && activityInfoArr.length > 0) {
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (activityInfo != null && com.bytedance.sdk.djx.proguard3.c.d.b(activityInfo.packageName)) {
                                hashSet.add(activityInfo.packageName);
                                if (z) {
                                    String str = activityInfo.name;
                                    int iLastIndexOf2 = str == null ? -1 : str.lastIndexOf(46);
                                    if (iLastIndexOf2 > 0 && (iLastIndexOf = (strSubstring = str.substring(0, iLastIndexOf2)).lastIndexOf(46)) > 0) {
                                        hashSet.add(strSubstring.substring(0, iLastIndexOf));
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return hashSet;
    }

    protected TreeSet<String> b() {
        boolean z;
        if (this.a == null) {
            HashSet<String> hashSetA = a(k.b().a(), this.g);
            String[] strArr = this.b;
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (com.bytedance.sdk.djx.proguard3.c.d.b(str)) {
                        hashSetA.add(str);
                    }
                }
            }
            this.a = new TreeSet<>();
            Iterator<String> it = hashSetA.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.a.isEmpty()) {
                    z = true;
                } else {
                    Iterator<String> it2 = this.a.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        if (next.startsWith(next2)) {
                            z = false;
                            break;
                        }
                        if (next2.startsWith(next)) {
                            it2.remove();
                        }
                    }
                    z = true;
                }
                if (z) {
                    this.a.add(next);
                }
            }
        }
        return this.a;
    }

    public static Throwable a(Throwable th) {
        if (th == null) {
            return null;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    protected int[] a(int i) {
        int[] iArr = new int[3];
        int i2 = this.h;
        if (i2 <= 0) {
            iArr[0] = i;
        } else {
            iArr[0] = Math.min(i2, i);
        }
        int i3 = this.j;
        if (i3 <= 0) {
            iArr[1] = Math.min(iArr[0], 5);
        } else {
            iArr[1] = Math.min(iArr[0], i3);
        }
        int i4 = this.i;
        if (i4 < 0) {
            iArr[2] = Math.min(iArr[1], 1);
        } else {
            iArr[2] = Math.min(iArr[1], i4);
        }
        return iArr;
    }

    protected List<StackTraceElement> a(StackTraceElement[] stackTraceElementArr, InterfaceC0259a interfaceC0259a) {
        int length = stackTraceElementArr.length;
        int[] iArrA = a(length);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int i3 = iArrA[2];
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i4 = 0;
        while (i4 < length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i4];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (com.bytedance.sdk.djx.proguard3.c.d.b(className) && com.bytedance.sdk.djx.proguard3.c.d.b(methodName) && (i4 == 0 || interfaceC0259a == null || interfaceC0259a.a(className, methodName))) {
                i2--;
                i--;
                arrayList.add(stackTraceElement);
                if (i3 > 0) {
                    Iterator<String> it = b().iterator();
                    while (it.hasNext()) {
                        if (className.startsWith(it.next())) {
                            i3--;
                        }
                    }
                }
                if ((i3 <= 0 && i2 <= 0) || i <= 0) {
                    break;
                }
            }
            i4++;
        }
        if (!this.e || i3 <= 0 || i4 >= length - 1) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(length - i4);
        int size = -1;
        for (int i5 = i4 + 1; i5 < length; i5++) {
            StackTraceElement stackTraceElement2 = stackTraceElementArr[i5];
            String className2 = stackTraceElement2.getClassName();
            String methodName2 = stackTraceElement2.getMethodName();
            if (com.bytedance.sdk.djx.proguard3.c.d.b(className2) && com.bytedance.sdk.djx.proguard3.c.d.b(methodName2) && (interfaceC0259a == null || interfaceC0259a.a(className2, methodName2))) {
                arrayList2.add(stackTraceElement2);
                Iterator<String> it2 = b().iterator();
                while (it2.hasNext()) {
                    if (className2.startsWith(it2.next())) {
                        i3--;
                        size = arrayList2.size();
                    }
                }
                if (i3 <= 0) {
                    break;
                }
            }
        }
        if (size == -1) {
            return arrayList;
        }
        int size2 = arrayList.size();
        arrayList.addAll(arrayList2.subList(0, size));
        if (!this.f) {
            return arrayList;
        }
        int size3 = arrayList.size();
        int size4 = (arrayList.size() - size2) + 1;
        return (size4 <= 0 || size4 >= arrayList.size()) ? arrayList : arrayList.subList(size4, size3);
    }

    public String b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        return a(threadCurrentThread == null ? null : threadCurrentThread.getName(), th);
    }

    public String a(String str, Throwable th) {
        String strA;
        Throwable thA = a(th);
        if (thA != null) {
            StackTraceElement[] stackTrace = thA.getStackTrace();
            List<StackTraceElement> listEmptyList = Collections.emptyList();
            InterfaceC0259a interfaceC0259a = this.c;
            if (interfaceC0259a == null) {
                interfaceC0259a = l;
            }
            if (stackTrace != null && stackTrace.length > 0) {
                listEmptyList = a(stackTrace, interfaceC0259a);
                if (listEmptyList.size() == 0 || listEmptyList.get(0) != stackTrace[0]) {
                    listEmptyList.add(0, stackTrace[0]);
                }
            }
            if (str == null) {
                str = "";
            }
            strA = interfaceC0259a.a(str, th, listEmptyList, this.d);
        } else {
            strA = null;
        }
        return strA == null ? "" : strA;
    }
}
