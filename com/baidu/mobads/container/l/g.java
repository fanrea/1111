package com.baidu.mobads.container.l;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    private static final a[] b = new a[0];
    private static final Map<String, a> c = new HashMap();
    static volatile a[] a = b;
    private static final a d = new h();

    public static void a(String str) {
        d.a(str);
    }

    public static void b(String str) {
        d.b(str);
    }

    public static void a(Object... objArr) {
        d.a(objArr);
    }

    public static void a(Throwable th, String str) {
        d.a(th, str);
    }

    public static void a(Throwable th) {
        d.a(th);
    }

    public static void c(String str) {
        d.c(str);
    }

    public static void b(Object... objArr) {
        d.b(objArr);
    }

    public static void a(Object obj) {
        d.a(obj);
    }

    public static void b(Throwable th, String str) {
        d.b(th, str);
    }

    public static void b(Throwable th) {
        d.b(th);
    }

    public static void d(String str) {
        d.d(str);
    }

    public static void c(Throwable th, String str) {
        d.c(th, str);
    }

    public static void c(Object... objArr) {
        d.c(objArr);
    }

    public static void c(Throwable th) {
        d.c(th);
    }

    public static void e(String str) {
        d.e(str);
    }

    public static void d(Throwable th, String str) {
        d.d(th, str);
    }

    public static void d(Object... objArr) {
        d.d(objArr);
    }

    public static void d(Throwable th) {
        d.d(th);
    }

    public static void f(String str) {
        d.f(str);
    }

    public static void e(Object... objArr) {
        d.e(objArr);
    }

    public static void e(Throwable th, String str) {
        d.e(th, str);
    }

    public static void e(Throwable th) {
        d.e(th);
    }

    public static void g(String str) {
        d.g(str);
    }

    public static void f(Object... objArr) {
        d.f(objArr);
    }

    public static void f(Throwable th, String str) {
        d.f(th, str);
    }

    public static void f(Throwable th) {
        d.f(th);
    }

    public static void a(int i, String str) {
        d.a(i, str);
    }

    public static void a(int i, Throwable th, String str) {
        d.a(i, th, str);
    }

    public static void a(int i, Object... objArr) {
        d.a(i, objArr);
    }

    public static void a(int i, Throwable th) {
        d.a(i, th);
    }

    public static a a() {
        return d;
    }

    public static a h(String str) {
        for (a aVar : a) {
            aVar.a.set(str);
        }
        return d;
    }

    public static a b() {
        for (a aVar : a) {
            aVar.a.set("bqt_ad_tag");
        }
        return d;
    }

    public static void a(a aVar) {
        if (aVar == null || aVar == d) {
            return;
        }
        synchronized (c) {
            c.put(aVar.a(), aVar);
            a = (a[]) c.values().toArray(new a[0]);
        }
    }

    public static void b(a aVar) {
        i(aVar.a());
    }

    public static void i(String str) {
        synchronized (c) {
            if (c.remove(str) == null) {
                return;
            }
            a = (a[]) c.values().toArray(new a[0]);
        }
    }

    public static void c() {
        synchronized (c) {
            c.clear();
            a = b;
        }
    }

    public static List<a> d() {
        List<a> listUnmodifiableList;
        synchronized (c) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(c.values()));
        }
        return listUnmodifiableList;
    }

    public static int e() {
        int size;
        synchronized (c) {
            size = c.size();
        }
        return size;
    }

    public static abstract class a {
        private final ThreadLocal<String> a = new ThreadLocal<>();

        abstract String a();

        protected abstract void a(int i, String str, String str2, Throwable th);

        String b() {
            String str = this.a.get();
            if (str != null) {
                this.a.remove();
            }
            return str;
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                String strTrim = str.trim();
                if (strTrim.startsWith("{")) {
                    b(3, null, new JSONObject(strTrim).toString(2));
                } else if (strTrim.startsWith("[")) {
                    b(3, null, new JSONArray(strTrim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (Exception e) {
                f("Invalid Json");
            }
        }

        private String g(Object[] objArr) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj).append(' ');
            }
            return sb.toString();
        }

        protected String b(Object obj) {
            if (obj == null) {
                return ILogConst.CACHE_PLAY_REASON_NULL;
            }
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            return "Couldn't find a correct type for the object";
        }

        public void b(String str) {
            b(2, null, str);
        }

        public void a(Object... objArr) {
            b(2, null, g(objArr));
        }

        public void a(Throwable th, String str) {
            b(2, th, str);
        }

        public void a(Throwable th) {
            b(2, th, null);
        }

        public void c(String str) {
            b(3, null, str);
        }

        public void b(Throwable th, String str) {
            b(3, th, str);
        }

        public void a(Object obj) {
            b(3, null, b(obj));
        }

        public void b(Object... objArr) {
            b(3, null, g(objArr));
        }

        public void b(Throwable th) {
            b(3, th, null);
        }

        public void d(String str) {
            b(4, null, str);
        }

        public void c(Object... objArr) {
            b(4, null, g(objArr));
        }

        public void c(Throwable th, String str) {
            b(4, th, str);
        }

        public void c(Throwable th) {
            b(4, th, null);
        }

        public void e(String str) {
            b(5, null, str);
        }

        public void d(Throwable th, String str) {
            b(5, th, str);
        }

        public void d(Throwable th) {
            b(5, th, null);
        }

        public void d(Object... objArr) {
            b(5, null, g(objArr));
        }

        public void f(String str) {
            b(6, null, str);
        }

        public void e(Object... objArr) {
            b(6, null, g(objArr));
        }

        public void e(Throwable th, String str) {
            b(6, th, str);
        }

        public void e(Throwable th) {
            b(6, th, null);
        }

        public void g(String str) {
            b(7, null, str);
        }

        public void f(Object... objArr) {
            b(7, null, g(objArr));
        }

        public void f(Throwable th, String str) {
            b(7, th, str);
        }

        public void f(Throwable th) {
            b(7, th, null);
        }

        public void a(int i, String str) {
            b(i, null, str);
        }

        public void a(int i, Object... objArr) {
            b(i, null, g(objArr));
        }

        public void a(int i, Throwable th, String str) {
            b(i, th, str);
        }

        public void a(int i, Throwable th) {
            b(i, th, null);
        }

        protected boolean a(int i) {
            return true;
        }

        protected boolean a(String str, int i) {
            return a(i);
        }

        private void b(int i, Throwable th, String str) {
            String strB = b();
            if (!a(strB, i)) {
                return;
            }
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str == null) {
                if (th == null) {
                    return;
                } else {
                    str = g(th);
                }
            } else if (th != null) {
                str = str + "\n" + g(th);
            }
            a(i, strB, str, th);
        }

        protected String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        private String g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }
}
