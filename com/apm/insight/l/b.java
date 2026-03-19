package com.apm.insight.l;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.MonitorCrash;
import com.apm.insight.entity.Header;
import com.apm.insight.f;
import com.apm.insight.g;
import com.apm.insight.n.e;
import com.apm.insight.o.s;
import com.apm.insight.o.v;
import com.apm.insight.runtime.a.c;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    private static final String[] a = {"onCreate", "onStart", "onResume", "onPause"};
    private static final AtomicInteger b = new AtomicInteger(1);
    private final a c;

    public interface a {
        List<com.apm.insight.l.a> a();

        void a(Throwable th, Thread thread, com.apm.insight.l.a aVar, String str, String str2);

        long b();
    }

    /* renamed from: com.apm.insight.l.b$b, reason: collision with other inner class name */
    private static class C0109b {
        public static final b a = new b();
    }

    private b() {
        this.c = new a() { // from class: com.apm.insight.l.b.1
            @Override // com.apm.insight.l.b.a
            public List<com.apm.insight.l.a> a() {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArrayM = com.apm.insight.runtime.a.m();
                if (jSONArrayM != null) {
                    for (int i = 0; i < jSONArrayM.length(); i++) {
                        try {
                            JSONObject jSONObjectOptJSONObject = jSONArrayM.optJSONObject(i);
                            com.apm.insight.l.a aVar = new com.apm.insight.l.a();
                            String strOptString = jSONObjectOptJSONObject.optString("clazzName");
                            if (TextUtils.equals("-", strOptString)) {
                                aVar.c = "";
                            } else {
                                aVar.c = strOptString;
                            }
                            aVar.a = jSONObjectOptJSONObject.optString("rule_id");
                            aVar.h = jSONObjectOptJSONObject.optString("throwableClassName");
                            String strOptString2 = jSONObjectOptJSONObject.optString("methodName");
                            if (TextUtils.equals("-", strOptString2)) {
                                aVar.d = "";
                            } else {
                                aVar.d = strOptString2;
                            }
                            aVar.e = jSONObjectOptJSONObject.optString("threadName");
                            aVar.b = jSONObjectOptJSONObject.optString("processName");
                            aVar.g = jSONObjectOptJSONObject.optString("detailMessage");
                            arrayList.add(aVar);
                        } catch (Throwable unused) {
                        }
                    }
                }
                return arrayList;
            }

            @Override // com.apm.insight.l.b.a
            public void a(Throwable th, Thread thread, com.apm.insight.l.a aVar, String str, String str2) throws JSONException {
                com.apm.insight.entity.a aVarB = b.b(th, thread, aVar);
                Header headerA = Header.a(g.g());
                headerA.d();
                headerA.e();
                headerA.c();
                Header.a(headerA);
                Header.b(headerA);
                s.a(aVarB, headerA, CrashType.PORTRAIT);
                JSONObject jSONObject = new JSONObject();
                try {
                    aVarB.a(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, (Object) "crash_defend");
                    aVarB.a("crash_md5", (Object) str);
                    aVarB.a("crash_uuid", (Object) str2);
                    com.apm.insight.o.a.a(g.f(), aVarB.h());
                    jSONObject.put("data", aVarB.h());
                    jSONObject.put("header", headerA.g());
                } catch (Throwable unused) {
                }
                e.a().c(jSONObject);
                MonitorCrash monitorCrashH = f.h();
                if (monitorCrashH != null) {
                    monitorCrashH.addTags("crash_after_portrait", "true");
                }
            }

            @Override // com.apm.insight.l.b.a
            public long b() {
                return f.g();
            }
        };
    }

    private com.apm.insight.l.a a(Throwable th, long j, int i, String str, String str2, Set<String> set, List<com.apm.insight.l.a> list) {
        for (com.apm.insight.l.a aVar : list) {
            if (aVar.f <= 0 || aVar.f == j) {
                if (TextUtils.isEmpty(aVar.e) || aVar.e.equals(str)) {
                    if (TextUtils.isEmpty(aVar.b) || aVar.b.equals(str2)) {
                        String message = th.getMessage();
                        if (!TextUtils.isEmpty(message) || TextUtils.isEmpty(aVar.g)) {
                            if (TextUtils.isEmpty(message) || TextUtils.isEmpty(aVar.g) || message.contains(aVar.g)) {
                                if (!TextUtils.isEmpty(aVar.h) && aVar.h.equals(th.getClass().getName())) {
                                    if (TextUtils.isEmpty(aVar.c) && TextUtils.isEmpty(aVar.d)) {
                                        if (Looper.myLooper() != Looper.getMainLooper()) {
                                            return aVar;
                                        }
                                    } else if (!TextUtils.isEmpty(aVar.c) && !TextUtils.isEmpty(aVar.d) && set.contains(aVar.c + "." + aVar.d)) {
                                        return aVar;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static b a() {
        return C0109b.a;
    }

    private boolean a(Throwable th, Set<String> set) {
        HashSet hashSet = new HashSet();
        while (true) {
            if (th == null) {
                break;
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                hashSet.add(stackTraceElement.getMethodName());
                set.add(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
            }
            th = th.getCause();
        }
        for (String str : a) {
            if (hashSet.contains(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.apm.insight.entity.a b(final Throwable th, final Thread thread, final com.apm.insight.l.a aVar) {
        return com.apm.insight.runtime.a.f.a().a(CrashType.PORTRAIT, null, new c.a() { // from class: com.apm.insight.l.b.2
            @Override // com.apm.insight.runtime.a.c.a
            public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar2) {
                if (i == 0) {
                    aVar2.a("rule_id", (Object) aVar.a);
                    aVar2.a("stack", (Object) v.a(th));
                    aVar2.a("crash_time", Long.valueOf(System.currentTimeMillis()));
                    aVar2.a("launch_mode", Integer.valueOf(com.apm.insight.runtime.a.b.b()));
                    aVar2.a("launch_time", Long.valueOf(com.apm.insight.runtime.a.b.c()));
                } else if (i == 1) {
                    Thread thread2 = thread;
                    aVar2.a("crash_thread_name", (Object) (thread2 != null ? thread2.getName() : ""));
                    aVar2.a("tid", Integer.valueOf(Process.myTid()));
                    aVar2.b("portrait_count", String.valueOf(b.b.get()));
                    aVar2.b("rule_id", aVar.a);
                    aVar2.a("rule_id", aVar.a);
                }
                return aVar2;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar2, boolean z) {
                return aVar2;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public void a(Throwable th2) {
            }
        }, true);
    }

    public boolean a(Throwable th, Thread thread, String str, String str2) {
        if (b.get() > com.apm.insight.runtime.a.n() || this.c == null) {
            return false;
        }
        synchronized (b.class) {
            List<com.apm.insight.l.a> listA = this.c.a();
            if (listA != null && !listA.isEmpty()) {
                long jB = this.c.b();
                int i = Build.VERSION.SDK_INT;
                String name = thread.getName();
                String strC = com.apm.insight.o.a.c(g.f());
                HashSet hashSet = new HashSet();
                if (!a(th, hashSet)) {
                    return false;
                }
                Throwable cause = th;
                while (cause != null) {
                    HashSet hashSet2 = hashSet;
                    com.apm.insight.l.a aVarA = a(cause, jB, i, name, strC, hashSet, listA);
                    if (aVarA != null) {
                        this.c.a(cause, thread, aVarA, str, str2);
                        return true;
                    }
                    cause = cause.getCause();
                    hashSet = hashSet2;
                }
                return false;
            }
            return false;
        }
    }

    public void b() {
        b.incrementAndGet();
    }
}
