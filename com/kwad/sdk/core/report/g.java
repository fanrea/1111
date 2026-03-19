package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.service.ServiceProvider;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g extends b<n, f> {
    private static volatile boolean bED = false;
    private static volatile g bEE;
    private static r<n, f> bEF;

    private g() {
    }

    public static g abi() {
        if (bEE == null) {
            synchronized (g.class) {
                if (bEE == null) {
                    bEE = new g();
                }
            }
        }
        bEE.abj();
        return bEE;
    }

    public static void a(n nVar) {
        a(nVar, false);
    }

    public static void a(n nVar, boolean z) {
        abi().b(nVar, z);
    }

    private void b(final n nVar, boolean z) {
        if (nVar == null || !bED) {
            return;
        }
        if (z || aG(nVar.actionType)) {
            bEE.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: abk, reason: merged with bridge method [inline-methods] */
                public n abf() {
                    return nVar.JU();
                }
            });
        } else {
            bEE.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* renamed from: abk, reason: merged with bridge method [inline-methods] */
                public n abf() {
                    return nVar.JU();
                }
            });
        }
    }

    private static boolean aG(long j) {
        s sVar = (s) ServiceProvider.get(s.class);
        return sVar != null && sVar.aG(j);
    }

    private synchronized void abj() {
        if (bED) {
            return;
        }
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            return;
        }
        int iBa = hVar.ba(context);
        m(context, iBa);
        t.init(context);
        t.abr();
        com.kwad.sdk.core.d.c.d("BatchReporter", "cache type = " + iBa);
        if (iBa == 2) {
            a(q.bS(context));
        }
        bR(context);
        bED = true;
    }

    @ForInvoker(methodId = "initForInvoker")
    private static void bR(Context context) {
        com.kwad.components.ct.e.a.aK(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(n nVar) {
        r<n, f> rVar = bEF;
        if (rVar != null) {
            return (f) rVar.abp();
        }
        return (f) super.a((g) nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: al, reason: merged with bridge method [inline-methods] */
    public f aj(List<n> list) {
        r<n, f> rVar = bEF;
        if (rVar != null) {
            return (f) rVar.abq();
        }
        String strAm = am(list);
        if (!TextUtils.isEmpty(strAm)) {
            return new f(strAm);
        }
        return new f(list);
    }

    private static String am(List<n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).bFS)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(",\"actionList\":[");
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().bFS).append(StringUtil.COMMA);
        }
        int length = sb.length();
        sb.replace(length - 1, length, "]");
        return sb.toString();
    }

    @Override // com.kwad.sdk.core.report.b
    protected final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        Runnable runnableAbo;
        r<n, f> rVar = bEF;
        return (rVar == null || (runnableAbo = rVar.abo()) == null) ? super.a(context, lVar, atomicInteger) : runnableAbo;
    }
}
