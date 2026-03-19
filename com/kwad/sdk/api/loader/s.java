package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.h;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class s {

    public interface c<T> {
        void o(T t);
    }

    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    static f<Boolean> VZ() {
        return new e(new g(new d(new h(new b()))));
    }

    static abstract class a<T> implements c<T> {
        c<T> bsR;

        a(c<T> cVar) {
            this.bsR = cVar;
        }
    }

    static class e implements f<Boolean> {
        f<a.C0569a> bsV;

        e(f<a.C0569a> fVar) {
            this.bsV = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.bsV.a(abVar, new c<a.C0569a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void o(a.C0569a c0569a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0569a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), getClass().getClassLoader(), c0569a.brS.getPath(), c0569a.sdkVersion)) {
                            a(c0569a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.A(abVar.getContext(), c0569a.sdkVersion);
                        j.j(c0569a.brS);
                        l.b(c0569a, System.currentTimeMillis() - jCurrentTimeMillis);
                        cVar.o(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0569a, 2, th);
                    }
                }

                private void a(a.C0569a c0569a, int i, Throwable th) {
                    j.j(c0569a.brS);
                    l.b(c0569a, i, Log.getStackTraceString(th));
                }
            });
        }
    }

    static class g implements f<a.C0569a> {
        f<a.C0569a> bsV;

        g(f<a.C0569a> fVar) {
            this.bsV = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<a.C0569a> cVar) {
            this.bsV.a(abVar, new a<a.C0569a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void o(a.C0569a c0569a) {
                    try {
                        File file = c0569a.brS;
                        if (!x.k(file)) {
                            a(c0569a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!x.b(file, c0569a.md5)) {
                            a(c0569a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.o(c0569a);
                        }
                    } catch (Throwable th) {
                        a(c0569a, 3, th);
                    }
                }

                private void a(a.C0569a c0569a, int i, Throwable th) {
                    j.j(c0569a.brS);
                    l.a(c0569a, i, th.getMessage());
                }
            });
        }
    }

    static class d implements f<a.C0569a> {
        f<a.C0569a> bsV;

        d(f<a.C0569a> fVar) {
            this.bsV = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0569a> cVar) {
            this.bsV.a(abVar, new a<a.C0569a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void o(a.C0569a c0569a) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    File fileC = null;
                    try {
                        l.a(c0569a);
                        fileC = j.C(abVar.getContext(), c0569a.sdkVersion);
                        k.c(c0569a.brR, fileC);
                        l.a(c0569a, System.currentTimeMillis() - jCurrentTimeMillis);
                        c0569a.brS = fileC;
                        cVar.o(c0569a);
                    } catch (Throwable th) {
                        l.a(c0569a, System.currentTimeMillis() - jCurrentTimeMillis, Log.getStackTraceString(th));
                        j.j(fileC);
                    }
                }
            });
        }
    }

    static class h implements f<a.C0569a> {
        f<a.C0569a> bsV;

        h(f<a.C0569a> fVar) {
            this.bsV = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0569a> cVar) {
            this.bsV.a(abVar, new c<a.C0569a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void o(a.C0569a c0569a) {
                    String strBj = i.bj(abVar.getContext());
                    if (TextUtils.isEmpty(strBj)) {
                        strBj = com.kwad.sdk.api.b.VK().getSDKVersion();
                    }
                    new StringBuilder("UpgradeProducer curVersion:").append(strBj).append("-newVersion").append(c0569a.sdkVersion);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), MetricsSQLiteCacheKt.METRICS_INTERVAL, c0569a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0569a.VQ()) {
                        aa.bq(abVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + strBj);
                    } else if (i.S(c0569a.sdkVersion, strBj) && c0569a.VP()) {
                        cVar.o(c0569a);
                    } else {
                        new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0569a.sdkVersion + " currentDynamicVersion:" + strBj + " dynamicType:" + c0569a.brQ);
                    }
                }
            });
        }
    }

    static class b implements f<a.C0569a> {
        b() {
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0569a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    public final void a(a.b bVar) {
                        new StringBuilder("ConfigProducer onSuccess data:").append(bVar);
                        if (bVar.isLegal()) {
                            cVar.o(bVar.brT);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.bi(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
