package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class co implements Thread.UncaughtExceptionHandler {
    public static String a = "";
    private static final String b = "remote";
    private static final String c = "proxy";
    private static final String d = "third-mtj";
    private static final String e = "third-cpu";
    private static final String f = "third-cpu-cyber";
    private static final String g = "third-novel";
    private static final String h = "third-aigc";
    private static final String i = "third-aigc-virtual";
    private static final String j = "third-aigc-speech";
    private static final String k = "third-aigc-image";
    private static Thread.UncaughtExceptionHandler l = null;
    private static volatile co m = null;
    private static final String p = "key_crash_source";
    private static final String q = "key_crash_trace";
    private static final String r = "key_crash_ad";
    private Context n;
    private a o;

    interface a {
        void a(String str);
    }

    public static co a(Context context) {
        if (m == null) {
            synchronized (co.class) {
                if (m == null) {
                    m = new co(context);
                }
            }
        }
        return m;
    }

    private co(Context context) {
        this.n = context.getApplicationContext();
        l = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void a() {
        be.a().a((j) new cp(this));
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof co) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA = a(th);
            if (strA != null) {
                a(strA, Log.getStackTraceString(th));
                a aVar = this.o;
                if (aVar != null) {
                    aVar.a(strA);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = l;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bu.a().c(e2);
        }
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    public void c() {
        this.o = null;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> listD = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                }
                if (!className.startsWith(z.as) && !className.startsWith(z.at) && !className.startsWith(z.au)) {
                    if (className.startsWith(z.av) || className.startsWith(z.aw) || className.startsWith(z.ax)) {
                        return "proxy";
                    }
                    if (className.startsWith(z.ay)) {
                        return "third-mtj";
                    }
                    if (className.startsWith(z.az)) {
                        return "third-cpu";
                    }
                    if (className.startsWith(z.aA) || className.startsWith(z.aB)) {
                        return "third-cpu-cyber";
                    }
                    if (className.startsWith(z.aJ)) {
                        return "third-aigc-speech";
                    }
                    if (className.startsWith(z.aF) || className.startsWith(z.aG) || className.startsWith(z.aH) || className.startsWith(z.aI)) {
                        return "third-aigc-virtual";
                    }
                    if (className.startsWith(z.aE)) {
                        return "third-aigc";
                    }
                    if (className.startsWith(z.aC) || className.startsWith(z.aD)) {
                        if (cn.g.booleanValue()) {
                            return "third-novel";
                        }
                    } else if (!a(className, listD)) {
                        if (className.startsWith(z.aK)) {
                            return k;
                        }
                    }
                }
                return "remote";
            }
        }
        return null;
    }

    private List<String> d() {
        IXAdContainerFactory iXAdContainerFactoryC;
        ArrayList arrayList = new ArrayList();
        try {
            aa aaVarA = aa.a();
            if (aaVarA != null && (iXAdContainerFactoryC = aaVarA.c()) != null) {
                Object remoteParam = iXAdContainerFactoryC.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private SharedPreferences e() {
        return this.n.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorF = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        editorF.putString(p, str);
        editorF.putString(q, str3 + str2);
        editorF.putString(r, a);
        editorF.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor editorF = f();
        editorF.clear();
        editorF.apply();
    }
}
