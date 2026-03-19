package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {

    /* renamed from: com.alipay.sdk.m.k.a$a, reason: collision with other inner class name */
    public static final class C0048a {
        public static final String a = "RecordPref";
        public static final String b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            com.alipay.sdk.m.u.e.b(a, "stat append " + str2 + " , " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                C0049a c0049aA = a(context);
                if (c0049aA.a.size() > 20) {
                    c0049aA.a.clear();
                }
                c0049aA.a.put(str2, str);
                a(context, c0049aA);
                return str2;
            }
            return null;
        }

        public static synchronized String b(Context context) {
            com.alipay.sdk.m.u.e.b(a, "stat peek");
            if (context == null) {
                return null;
            }
            C0049a c0049aA = a(context);
            if (c0049aA.a.isEmpty()) {
                return null;
            }
            try {
                return c0049aA.a.entrySet().iterator().next().getValue();
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                return null;
            }
        }

        /* renamed from: com.alipay.sdk.m.k.a$a$a, reason: collision with other inner class name */
        public static final class C0049a {
            public final LinkedHashMap<String, String> a = new LinkedHashMap<>();

            public C0049a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new JSONArray().toString();
                }
            }

            public C0049a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        this.a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            com.alipay.sdk.m.u.e.b(a, "stat remove " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                C0049a c0049aA = a(context);
                if (c0049aA.a.isEmpty()) {
                    return 0;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : c0049aA.a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c0049aA.a.remove((String) it.next());
                    }
                    a(context, c0049aA);
                    return arrayList.size();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    int size = c0049aA.a.size();
                    a(context, new C0049a());
                    return size;
                }
            }
            return 0;
        }

        public static synchronized C0049a a(Context context) {
            try {
                String strA = j.a(null, context, b, null);
                if (TextUtils.isEmpty(strA)) {
                    return new C0049a();
                }
                return new C0049a(strA);
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                return new C0049a();
            }
        }

        public static synchronized void a(Context context, C0049a c0049a) {
            if (c0049a == null) {
                try {
                    c0049a = new C0049a();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }
            j.b(null, context, b, c0049a.a());
        }
    }

    public static final class b {

        /* renamed from: com.alipay.sdk.m.k.a$b$a, reason: collision with other inner class name */
        public static class RunnableC0050a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ Context b;

            public RunnableC0050a(String str, Context context) {
                this.a = str;
                this.b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.a) || b.b(this.b, this.a)) {
                    for (int i = 0; i < 4; i++) {
                        String strB = C0048a.b(this.b);
                        if (TextUtils.isEmpty(strB) || !b.b(this.b, strB)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "stat sub " + str);
            try {
                if ((com.alipay.sdk.m.m.a.z().e() ? new com.alipay.sdk.m.q.d() : new com.alipay.sdk.m.q.e()).a((com.alipay.sdk.m.s.a) null, context, str) == null) {
                    return false;
                }
                C0048a.a(context, str);
                return true;
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                return false;
            }
        }

        public static synchronized void a(Context context, com.alipay.sdk.m.k.b bVar, String str, String str2) {
            if (context == null || bVar == null || str == null) {
                return;
            }
            a(context, bVar.a(str), str2);
        }

        public static synchronized void a(Context context) {
            a(context, null, null);
        }

        public static synchronized void a(Context context, String str, String str2) {
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                C0048a.a(context, str, str2);
            }
            new Thread(new RunnableC0050a(str, context)).start();
        }
    }

    public static final class c {
        public static final String a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            return d.a(context, a);
        }
    }

    public static final class d {
        public static synchronized long a(Context context, String str) {
            long j;
            String strA;
            try {
                strA = j.a(null, context, str, null);
            } catch (Throwable unused) {
            }
            j = (!TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L) + 1;
            try {
                j.b(null, context, str, Long.toString(j));
            } catch (Throwable unused2) {
            }
            return j;
        }
    }

    public static final class e {
        public static final String a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            return d.a(context, a);
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (context == null || aVar == null) {
            return;
        }
        try {
            C0048a.a(context, aVar.l.a(str), str2);
        } catch (Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (context == null || aVar == null) {
            return;
        }
        b.a(context, aVar.l, str, str2);
    }

    public static void b(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.b(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        b.a(context);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, Throwable th) {
        if (aVar == null || th == null || th.getClass() == null) {
            return;
        }
        aVar.l.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2);
    }
}
