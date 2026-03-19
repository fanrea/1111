package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public static final WeakHashMap<String, Integer> bBv = new WeakHashMap<>();
    private static final Map<String, Integer> bBw = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> bBx = new LruHashMap(10);
    private final com.kwad.sdk.app.a bBy;
    private final WeakHashMap<d, AdTemplate> buT;
    private final Map<d, AdTemplate> buU;
    private volatile boolean mHasInit;

    static final class a {
        static final c bBF = new c(0);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        WeakHashMap<d, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.buT = weakHashMap;
        this.buU = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.bBy = new com.kwad.sdk.app.a() { // from class: com.kwad.sdk.core.download.c.6
            @Override // com.kwad.sdk.app.a
            public final void W(String str) {
                c.this.fk(str);
            }

            @Override // com.kwad.sdk.app.a
            public final void X(String str) {
                c.this.dM(str);
            }
        };
    }

    public static c ZJ() {
        return a.bBF;
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.SL().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.c.1
                public final void c(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.qr.booleanValue()) {
                            com.kwad.sdk.core.d.c.d("DownloadStatusManager", "onDownloadStart(), id=" + k(downloadTask));
                        }
                        c.this.fe(k(downloadTask));
                    }
                }

                public final void b(DownloadTask downloadTask, int i, int i2) {
                    c.this.a(k(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
                }

                public final void b(DownloadTask downloadTask) {
                    c.this.W(k(downloadTask), downloadTask.getTargetFilePath());
                }

                public final void a(DownloadTask downloadTask, int i, int i2) {
                    c.this.ff(k(downloadTask));
                }

                public final void a(DownloadTask downloadTask, Throwable th) {
                    c.this.c(k(downloadTask), 0, (th == null || th.getStackTrace().length <= 0) ? "" : th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber());
                }

                public final void a(DownloadTask downloadTask) {
                    c.this.fh(k(downloadTask));
                }

                public final void d(DownloadTask downloadTask) {
                    String strK = k(downloadTask);
                    if (downloadTask.downloadType != 0) {
                        c.bBv.put(strK, Integer.valueOf(downloadTask.downloadType));
                    }
                    c.this.fg(strK);
                }

                public final void e(DownloadTask downloadTask) {
                    c.this.fj(k(downloadTask));
                }

                private static String k(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) c.bBx.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String strMd5 = al.md5(downloadTask.getUrl());
                    c.bBx.put(url, strMd5);
                    return strMd5;
                }
            });
            com.kwad.sdk.app.b.Wd().a(this.bBy);
            this.mHasInit = true;
        }
    }

    public final synchronized void bL(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.app.b.Wd().b(this.bBy);
            this.buU.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void a(d dVar, AdTemplate adTemplate) {
        this.buU.put(dVar, adTemplate);
    }

    public final void a(d dVar) {
        this.buU.remove(dVar);
    }

    public static int fd(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = bBw.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void fe(final String str) {
        bBw.put(str, 1);
        final f fVar = new f();
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, fVar);
            }
        });
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        bBw.put(str, 2);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, i, i2, i3);
            }
        });
    }

    public final void W(final String str, final String str2) {
        final f fVar = new f();
        bBw.put(str, 8);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, str2, fVar);
            }
        });
    }

    public final void c(final String str, int i, final String str2) {
        bBw.put(str, 7);
        final f fVar = new f();
        final int i2 = 0;
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, i2, str2, fVar);
            }
        });
    }

    public final void ff(final String str) {
        final f fVar = new f();
        bBw.put(str, 4);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.b(str, fVar);
            }
        });
    }

    public final void fg(final String str) {
        final f fVar = new f();
        bBw.put(str, 1);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.c(str, fVar);
            }
        });
    }

    public final void fh(final String str) {
        final f fVar = new f();
        bBw.put(str, 5);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.d(str, fVar);
            }
        });
    }

    public final void fi(final String str) {
        final f fVar = new f();
        bBw.put(str, 9);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.e(str, fVar);
            }
        });
    }

    private void W(final String str) {
        final f fVar = new f();
        b(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                String strPL = dVar.pL();
                c.bBw.put(strPL, 12);
                dVar.b(strPL, str, fVar);
            }
        });
    }

    private void X(final String str) {
        final f fVar = new f();
        b(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                String strPL = dVar.pL();
                c.bBw.put(strPL, 0);
                dVar.f(strPL, fVar);
            }
        });
    }

    public final void g(final String str, final Throwable th) {
        final f fVar = new f();
        bBw.put(str, 11);
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.a(str, th, fVar);
            }
        });
    }

    public final void fj(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.g.a<d>() { // from class: com.kwad.sdk.core.download.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(d dVar) {
                dVar.g(str, fVar);
            }
        });
    }

    private void a(String str, com.kwad.sdk.g.a<d> aVar) {
        Set<d> setKeySet = this.buU.keySet();
        synchronized (this.buU) {
            for (d dVar : setKeySet) {
                if (dVar != null && TextUtils.equals(dVar.pL(), str)) {
                    try {
                        aVar.accept(dVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    private void b(String str, com.kwad.sdk.g.a<d> aVar) {
        Set<d> setKeySet = this.buU.keySet();
        synchronized (this.buU) {
            for (d dVar : setKeySet) {
                if (dVar != null && TextUtils.equals(str, dVar.pM())) {
                    try {
                        aVar.accept(dVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    public final List<AdTemplate> TW() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.buU) {
            for (AdTemplate adTemplate : this.buU.values()) {
                if (adTemplate != null) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        W(str);
        com.kwad.sdk.d dVarSN = com.kwad.sdk.c.SL().SN();
        if (dVarSN != null) {
            dVarSN.du(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        X(str);
    }
}
