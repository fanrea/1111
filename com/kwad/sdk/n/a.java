package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.p;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    public static final String TAG = "Ranger_a";
    private List<com.kwad.sdk.n.a.a> cjI;

    /* renamed from: com.kwad.sdk.n.a$a, reason: collision with other inner class name */
    static class C0628a {
        private static final a cjM = new a();
    }

    public static a ani() {
        return C0628a.cjM;
    }

    public final void ib(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GlobalThreadPools.acd().execute(new Runnable() { // from class: com.kwad.sdk.n.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (a.this.cjI != null && !a.this.cjI.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : a.this.cjI) {
                            if (a.b(str, aVar.cjV)) {
                                a.hn(aVar.cjS);
                            }
                        }
                    }
                } catch (Exception e) {
                    c.w(a.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public final void c(final StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        GlobalThreadPools.acd().execute(new Runnable() { // from class: com.kwad.sdk.n.a.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (a.this.cjI != null && !a.this.cjI.isEmpty()) {
                        for (com.kwad.sdk.n.a.a aVar : a.this.cjI) {
                            if (a.a(stackTraceElementArr, aVar.cjW)) {
                                a.ho(aVar.cjS);
                            }
                        }
                    }
                } catch (Exception e) {
                    c.w(a.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(StackTraceElement[] stackTraceElementArr, List<String> list) {
        boolean z;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        do {
            z = true;
            if (!it.hasNext()) {
                return true;
            }
            String next = it.next();
            int length = stackTraceElementArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (p.a(stackTraceElementArr[i]).contains(next)) {
                    break;
                }
                i++;
            }
        } while (z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static void hn(int i) {
        String str = Config.replace + i;
        ag.b("ksadsdk_perf_ranger_v2", "crash_times" + str, ag.c("ksadsdk_perf_ranger_v2", "crash_times" + str, -1) + 1);
    }

    public static void ho(int i) {
        String str = Config.replace + i;
        ag.b("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, ag.c("ksadsdk_perf_ranger_v2", "call_ks_union_times" + str, -1) + 1);
    }
}
