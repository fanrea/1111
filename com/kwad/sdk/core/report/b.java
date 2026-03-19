package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService bEo;
    private static volatile Handler mHandler;
    private T bEr;
    private Context mContext;
    private volatile long aay = 120000;
    protected l bEn = new m();
    private AtomicInteger bEp = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int bEq = 5;

    protected abstract R aj(List<T> list);

    protected b() {
        if (bEo == null) {
            bEo = GlobalThreadPools.acf();
        }
    }

    public synchronized void m(Context context, int i) {
        this.mContext = context;
        if (mHandler == null) {
            mHandler = com.kwad.sdk.core.threads.a.abY();
        }
    }

    protected final void a(l lVar) {
        this.bEn = lVar;
    }

    public final void a(final k<T> kVar) {
        bEo.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.mHandler != null && !b.mHandler.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.be(bVar.aay);
                }
                e eVarAbf = kVar.abf();
                if (eVarAbf != null) {
                    b.this.bEn.q(eVarAbf);
                }
                if (b.this.aba()) {
                    b.this.abb();
                }
            }
        });
    }

    protected final boolean aba() {
        int i = this.mRetryCount.get();
        if (i > 16) {
            i = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.bEn.size() >= (sVar != null ? (long) (sVar.TM() << i) : 20L);
    }

    public final void abb() {
        be(0L);
    }

    protected final void bd(long j) {
        if (j < 60) {
            this.aay = 60000L;
        } else {
            this.aay = j * 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void be(long j) {
        if (mHandler == null) {
            return;
        }
        mHandler.removeMessages(R.attr.childDivider);
        Message messageObtain = Message.obtain(mHandler, a(this.mContext, this.bEn, this.bEp));
        messageObtain.what = R.attr.childDivider;
        mHandler.sendMessageDelayed(messageObtain, j);
    }

    protected Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean, final u.a aVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.bEp.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return fK(str);
            }

            private static BatchReportResult fK(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.bEo;
            }

            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                return (R) b.this.aj(list);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }

            private void a(BatchReportResult batchReportResult) {
                b.this.bEn.ak(list);
                u.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.abz();
                }
                if (b.this.bEp.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.abd();
                }
                b.this.bd(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.be(bVar.aay);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.bEp.decrementAndGet() == 0) {
                    b.this.abd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abd() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.bEq) {
            if (andIncrement > 0) {
                this.aay *= 2;
            }
            be(this.aay);
        }
    }

    public final void b(k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    private void c(final k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return fK(str);
            }

            private static BatchReportResult fK(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                e eVarAbf = kVar.abf();
                b.this.bEr = eVarAbf;
                return (R) b.this.a((b) eVarAbf);
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.bEo;
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }

            private void a(BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.bEr + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(R r, int i, String str) {
                com.kwad.sdk.core.d.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i + " errorMsg:" + str + "\naction=" + b.this.bEr);
                b.this.a((k) new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.k
                    public final T abf() {
                        return (T) b.this.bEr;
                    }
                });
            }
        });
    }

    protected R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return (R) aj(arrayList);
    }
}
