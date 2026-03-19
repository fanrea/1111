package com.alliance.ssp.ad.q;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.http.HttpException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ActionProcessor.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a<RT> {
    public static final Handler d = new d(Looper.getMainLooper());
    public a<RT>.b a;
    public com.alliance.ssp.ad.q.b<RT> b;
    public final AtomicBoolean c = new AtomicBoolean();

    /* compiled from: ActionProcessor.java */
    /* renamed from: com.alliance.ssp.ad.q.a$a, reason: collision with other inner class name */
    public class CallableC0095a implements Callable<RT> {
        public final /* synthetic */ com.alliance.ssp.ad.q.b a;

        public CallableC0095a(a aVar, com.alliance.ssp.ad.q.b bVar) {
            this.a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0181  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public RT call() throws java.lang.Exception {
            /*
                Method dump skipped, instructions count: 448
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.q.a.CallableC0095a.call():java.lang.Object");
        }
    }

    /* compiled from: ActionProcessor.java */
    public class b extends FutureTask<RT> {
        public b(Callable<RT> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            super.done();
            try {
                try {
                    a.d.obtainMessage(1, new c(a.this, get())).sendToTarget();
                } catch (InterruptedException e) {
                    a.d.obtainMessage(4, new c(a.this, (Exception) e)).sendToTarget();
                    e.printStackTrace();
                } catch (Exception e2) {
                    a.d.obtainMessage(4, new c(a.this, e2)).sendToTarget();
                    e2.printStackTrace();
                }
            } catch (CancellationException e3) {
                a.d.obtainMessage(3, new c(a.this, (Exception) e3)).sendToTarget();
                e3.printStackTrace();
            } catch (ExecutionException e4) {
                a.d.obtainMessage(4, new c(a.this, (Exception) e4)).sendToTarget();
                e4.printStackTrace();
            }
        }
    }

    /* compiled from: ActionProcessor.java */
    public static class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = (c) message.obj;
            int i = message.what;
            if (i == 1) {
                a aVar = cVar.b;
                RT rt = cVar.a;
                if (aVar.a()) {
                    aVar.b.a(new HttpException(801));
                    return;
                } else {
                    if (aVar.a()) {
                        return;
                    }
                    aVar.b.a((com.alliance.ssp.ad.q.b<RT>) rt);
                    return;
                }
            }
            if (i == 2) {
                cVar.b.a();
                return;
            }
            if (i == 3) {
                cVar.b.b.a(new HttpException(801));
                return;
            }
            if (i != 4) {
                return;
            }
            a aVar2 = cVar.b;
            Exception exc = cVar.c;
            if (aVar2.a()) {
                return;
            }
            aVar2.b.a(exc instanceof HttpException ? (HttpException) exc : (exc.getCause() == null || !(exc.getCause() instanceof HttpException)) ? new HttpException(501, exc) : (HttpException) exc.getCause());
        }
    }

    public a(com.alliance.ssp.ad.q.b<RT> bVar) {
        this.a = new b(new CallableC0095a(this, bVar));
        this.b = bVar;
    }

    public final boolean a() {
        return this.a.isCancelled() || this.c.get();
    }

    /* compiled from: ActionProcessor.java */
    public static class c<RT> {
        public RT a;
        public final a b;
        public Exception c;

        public c(a aVar, Exception exc) {
            this.b = aVar;
            this.c = exc;
        }

        public c(a aVar, RT rt) {
            this.b = aVar;
            this.a = rt;
        }
    }
}
