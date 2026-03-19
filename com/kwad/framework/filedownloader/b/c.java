package com.kwad.framework.filedownloader.b;

import android.database.SQLException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements a {
    private volatile Thread beu;
    private Handler handler;
    private volatile List<Integer> bes = new CopyOnWriteArrayList();
    private AtomicInteger bet = new AtomicInteger();
    private final b bep = new b();
    private final d beq = new d();
    private final long ber = com.kwad.framework.filedownloader.f.e.OX().bhl;

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.beu = null;
        return null;
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.cI("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.beu != null) {
                        LockSupport.unpark(c.this.beu);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.bet.set(i);
                    c.this.dr(i);
                    c.this.bes.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.bet.set(0);
                    if (c.this.beu != null) {
                        LockSupport.unpark(c.this.beu);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(int i) throws SQLException {
        this.beq.b(this.bep.dm(i));
        List<com.kwad.framework.filedownloader.d.a> listDn = this.bep.dn(i);
        this.beq.mo454do(i);
        Iterator<com.kwad.framework.filedownloader.d.a> it = listDn.iterator();
        while (it.hasNext()) {
            this.beq.a(it.next());
        }
    }

    private boolean ds(int i) {
        return !this.bes.contains(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void dl(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.ber);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c dm(int i) {
        return this.bep.dm(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> dn(int i) {
        return this.bep.dn(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    /* renamed from: do */
    public final void mo454do(int i) throws SQLException {
        this.bep.mo454do(i);
        if (ds(i)) {
            return;
        }
        this.beq.mo454do(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) throws SQLException {
        this.bep.a(aVar);
        if (ds(aVar.getId())) {
            return;
        }
        this.beq.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) throws SQLException {
        this.bep.a(i, i2, j);
        if (ds(i)) {
            return;
        }
        this.beq.a(i, i2, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void f(int i, long j) throws SQLException {
        this.bep.f(i, j);
        if (ds(i)) {
            return;
        }
        this.beq.f(i, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void C(int i, int i2) throws SQLException {
        this.bep.C(i, i2);
        if (ds(i)) {
            return;
        }
        this.beq.C(i, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) throws SQLException {
        this.bep.b(cVar);
        if (ds(cVar.getId())) {
            return;
        }
        this.beq.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean dp(int i) {
        this.beq.dp(i);
        return this.bep.dp(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() throws SQLException {
        this.bep.clear();
        this.beq.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) throws SQLException {
        this.bep.a(i, str, j, j2, i2);
        if (ds(i)) {
            return;
        }
        this.beq.a(i, str, j, j2, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) throws SQLException {
        this.bep.a(i, j, str, str2);
        if (ds(i)) {
            return;
        }
        this.beq.a(i, j, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void dq(int i) {
        this.bep.dq(i);
        if (ds(i)) {
            return;
        }
        this.beq.dq(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) throws SQLException {
        this.bep.a(i, th);
        if (ds(i)) {
            return;
        }
        this.beq.a(i, th);
    }

    private void dt(int i) throws SQLException {
        this.handler.removeMessages(i);
        if (this.bet.get() == i) {
            this.beu = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        dr(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) throws SQLException {
        this.bep.a(i, th, j);
        if (ds(i)) {
            dt(i);
        }
        this.beq.a(i, th, j);
        this.bes.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void g(int i, long j) {
        this.bep.g(i, j);
        if (ds(i)) {
            this.handler.removeMessages(i);
            if (this.bet.get() == i) {
                this.beu = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
                this.beq.g(i, j);
            }
        } else {
            this.beq.g(i, j);
        }
        this.bes.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void h(int i, long j) throws SQLException {
        this.bep.h(i, j);
        if (ds(i)) {
            dt(i);
        }
        this.beq.h(i, j);
        this.bes.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0552a Np() {
        return this.beq.a(this.bep.bem, this.bep.ben);
    }
}
