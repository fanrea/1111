package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private static com.kwad.sdk.core.g.d iQ;
    private static com.kwad.sdk.core.g.c iR;
    private static Vibrator iS;
    private static List<c> iT = new CopyOnWriteArrayList();
    private static List<a> iU = new CopyOnWriteArrayList();
    private static long iV;

    public interface b {
        boolean s(String str);
    }

    /* renamed from: com.kwad.components.ad.feed.d$d, reason: collision with other inner class name */
    public interface InterfaceC0409d {
        boolean e(double d);
    }

    public static class c {
        private InterfaceC0409d iZ;
        private Context mContext;

        public c(InterfaceC0409d interfaceC0409d, Context context) {
            this.iZ = interfaceC0409d;
            this.mContext = context;
        }
    }

    public static class a {
        private b iY;
        private Context mContext;

        public a(b bVar, Context context) {
            this.iY = bVar;
            this.mContext = context;
        }
    }

    public static void a(float f, Context context, InterfaceC0409d interfaceC0409d) {
        if (iQ == null) {
            a(f, context);
        }
        iT.add(new c(interfaceC0409d, context));
    }

    public static void a(InterfaceC0409d interfaceC0409d) {
        for (c cVar : iT) {
            if (cVar != null && cVar.iZ == interfaceC0409d) {
                iT.remove(cVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sShakeItems size " + iT.size());
    }

    private static void a(float f, Context context) {
        iQ = new com.kwad.sdk.core.g.d(f);
        iT = new CopyOnWriteArrayList();
        iQ.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.g.b
            public final void ci() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void d(double d) {
                if (d.iT != null) {
                    Iterator it = d.iT.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c cVar = (c) it.next();
                        if (cVar != null && cVar.iZ != null && cVar.iZ.e(d)) {
                            bx.a(cVar.mContext, d.F(cVar.mContext));
                            break;
                        }
                    }
                    bx.a(new bh() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                            if (d.iQ != null) {
                                d.iQ.abR();
                            }
                        }
                    }, null, 500L);
                }
            }
        });
        iQ.K(f);
        iQ.bW(context);
    }

    public static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, b bVar) {
        com.kwad.sdk.core.g.c cVar = iR;
        if (cVar == null) {
            a(rotateInfo, context);
        } else {
            cVar.a(rotateInfo);
        }
        iU.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : iU) {
            if (aVar != null && aVar.iY == bVar) {
                iU.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sRotateItems size " + iU.size());
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.g.c cVar = new com.kwad.sdk.core.g.c(rotateInfo);
        iR = cVar;
        cVar.a(new com.kwad.sdk.core.g.a() { // from class: com.kwad.components.ad.feed.d.2
            @Override // com.kwad.sdk.core.g.a
            public final void cj() {
            }

            @Override // com.kwad.sdk.core.g.a
            public final void r(String str) {
                a aVar;
                if (d.iU != null) {
                    Iterator it = d.iU.iterator();
                    while (it.hasNext() && ((aVar = (a) it.next()) == null || aVar.iY == null || !aVar.iY.s(str))) {
                    }
                    bx.a(new bh() { // from class: com.kwad.components.ad.feed.d.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onRotateEvent openGate2");
                            if (d.iR != null) {
                                d.iR.abR();
                            }
                        }
                    }, null, 1000L);
                }
            }
        });
        iR.bW(context);
    }

    public static void D(Context context) {
        try {
            com.kwad.sdk.core.g.c cVar = iR;
            if (cVar != null) {
                cVar.bX(context);
                iR = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void E(Context context) {
        try {
            com.kwad.sdk.core.g.d dVar = iQ;
            if (dVar != null) {
                dVar.bX(context);
                iQ = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator F(Context context) {
        if (iS == null) {
            iS = (Vibrator) context.getSystemService("vibrator");
        }
        return iS;
    }

    public static synchronized boolean cd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!(jElapsedRealtime - iV > 500)) {
            return false;
        }
        iV = jElapsedRealtime;
        return true;
    }
}
