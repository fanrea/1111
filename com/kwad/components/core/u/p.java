package com.kwad.components.core.u;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class p {
    public static final String TAG = "p";
    private static final String aaS = "com.kwad.components.core.u.p";
    private static volatile p aaT;
    private boolean aaU = false;
    private q.a aaV;

    private p() {
    }

    public static p tH() {
        if (aaT == null) {
            synchronized (p.class) {
                if (aaT == null) {
                    aaT = new p();
                }
            }
        }
        return aaT;
    }

    public final void init() {
        q.a aVar = (q.a) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.bxJ);
        this.aaV = aVar;
        if (aVar != null) {
            tI();
        }
    }

    public final boolean b(SceneImpl sceneImpl, String str) {
        boolean zA = this.aaU ? a(this.aaV.bAF, this.aaV.bAG) : false;
        com.kwad.components.core.q.a.ss().a(sceneImpl, zA, str);
        return zA;
    }

    private void tI() {
        q.a aVar = this.aaV;
        if (aVar == null) {
            return;
        }
        if (!this.aaU && aVar.bAH.size() > 0) {
            Iterator<String> it = this.aaV.bAH.iterator();
            while (it.hasNext()) {
                boolean zAP = aP(it.next());
                this.aaU = zAP;
                if (zAP) {
                    break;
                }
            }
        }
        if (this.aaU) {
            ArrayList arrayList = new ArrayList();
            if (this.aaV.bAE.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.aaV.bAE.entrySet()) {
                    if (aP(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.components.core.q.a.ss().a(a(this.aaV.bAF, this.aaV.bAG), arrayList);
        }
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        com.kwad.sdk.n.a.ani().c(stackTrace);
        return a(list2, stackTrace);
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d(TAG, "checkBySuper begin:" + jElapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aN(className) && aO(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            O(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains(com.baidu.mobads.container.o.j.a) && a(list, Class.forName(className.substring(0, className.lastIndexOf(com.baidu.mobads.container.o.j.a))).getSuperclass())) {
                            O(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            O(jElapsedRealtime);
        }
        return false;
    }

    private static void O(long j) {
        com.kwad.sdk.core.d.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    private static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }

    private static boolean aN(String str) {
        return (str.startsWith("android") || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(aaS) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aO(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Class.forName(str) != null;
    }
}
