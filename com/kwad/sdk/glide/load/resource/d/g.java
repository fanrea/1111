package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.sdk.utils.ax;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class g {
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    final com.kwad.sdk.glide.g bQg;
    private com.kwad.sdk.glide.load.i<Bitmap> bUr;
    private final com.kwad.sdk.glide.gifdecoder.a bYi;
    private final List<b> bYj;
    private boolean bYk;
    private boolean bYl;
    private com.kwad.sdk.glide.f<Bitmap> bYm;
    private a bYn;
    private boolean bYo;
    private a bYp;
    private Bitmap bYq;
    private a bYr;
    private final Handler handler;
    private boolean isRunning;

    public interface b {
        void aig();
    }

    g(com.kwad.sdk.glide.c cVar, com.kwad.sdk.glide.gifdecoder.a aVar, int i, int i2, com.kwad.sdk.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this(cVar.aeZ(), com.kwad.sdk.glide.c.cy(cVar.getContext()), aVar, null, a(com.kwad.sdk.glide.c.cy(cVar.getContext()), i, i2), iVar, bitmap);
    }

    private g(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, com.kwad.sdk.glide.gifdecoder.a aVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.bYj = new ArrayList();
        this.bQg = gVar;
        Handler handler2 = new Handler(Looper.getMainLooper(), new c());
        this.bPy = eVar;
        this.handler = handler2;
        this.bYm = fVar;
        this.bYi = aVar;
        a(iVar, bitmap);
    }

    final void a(com.kwad.sdk.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.bUr = (com.kwad.sdk.glide.load.i) ax.checkNotNull(iVar);
        this.bYq = (Bitmap) ax.checkNotNull(bitmap);
        this.bYm = this.bYm.a(new com.kwad.sdk.glide.request.i().a(iVar));
    }

    final Bitmap ahZ() {
        return this.bYq;
    }

    final void a(b bVar) {
        if (this.bYo) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.bYj.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.bYj.isEmpty();
        this.bYj.add(bVar);
        if (zIsEmpty) {
            start();
        }
    }

    final void b(b bVar) {
        this.bYj.remove(bVar);
        if (this.bYj.isEmpty()) {
            stop();
        }
    }

    final int getWidth() {
        return aij().getWidth();
    }

    final int getHeight() {
        return aij().getHeight();
    }

    final int getSize() {
        return this.bYi.getByteSize() + aii();
    }

    final int getCurrentIndex() {
        a aVar = this.bYn;
        if (aVar != null) {
            return aVar.index;
        }
        return -1;
    }

    private int aii() {
        return com.kwad.sdk.glide.e.j.i(aij().getWidth(), aij().getHeight(), aij().getConfig());
    }

    final ByteBuffer getBuffer() {
        return this.bYi.getData().asReadOnlyBuffer();
    }

    final int getFrameCount() {
        return this.bYi.getFrameCount();
    }

    private void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.bYo = false;
        aik();
    }

    private void stop() {
        this.isRunning = false;
    }

    final void clear() {
        this.bYj.clear();
        ail();
        stop();
        a aVar = this.bYn;
        if (aVar != null) {
            this.bQg.c(aVar);
            this.bYn = null;
        }
        a aVar2 = this.bYp;
        if (aVar2 != null) {
            this.bQg.c(aVar2);
            this.bYp = null;
        }
        a aVar3 = this.bYr;
        if (aVar3 != null) {
            this.bQg.c(aVar3);
            this.bYr = null;
        }
        this.bYi.clear();
        this.bYo = true;
    }

    final Bitmap aij() {
        a aVar = this.bYn;
        return aVar != null ? aVar.ain() : this.bYq;
    }

    private void aik() {
        if (!this.isRunning || this.bYk) {
            return;
        }
        if (this.bYl) {
            ax.checkArgument(this.bYr == null, "Pending target must be null when starting from the first frame");
            this.bYi.afz();
            this.bYl = false;
        }
        a aVar = this.bYr;
        if (aVar != null) {
            this.bYr = null;
            a(aVar);
            return;
        }
        this.bYk = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.bYi.afx();
        this.bYi.advance();
        this.bYp = new a(this.handler, this.bYi.afy(), jUptimeMillis);
        this.bYm.a(com.kwad.sdk.glide.request.i.j(aim())).u(this.bYi).b((com.kwad.sdk.glide.f<Bitmap>) this.bYp);
    }

    private void ail() {
        Bitmap bitmap = this.bYq;
        if (bitmap != null) {
            this.bPy.e(bitmap);
            this.bYq = null;
        }
    }

    final void a(a aVar) {
        this.bYk = false;
        if (this.bYo) {
            this.handler.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.isRunning) {
            this.bYr = aVar;
            return;
        }
        if (aVar.ain() != null) {
            ail();
            a aVar2 = this.bYn;
            this.bYn = aVar;
            for (int size = this.bYj.size() - 1; size >= 0; size--) {
                this.bYj.get(size).aig();
            }
            if (aVar2 != null) {
                this.handler.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        aik();
    }

    class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (message.what != 2) {
                return false;
            }
            g.this.bQg.c((a) message.obj);
            return false;
        }
    }

    static class a extends com.kwad.sdk.glide.request.a.h<Bitmap> {
        private final long bYs;
        private Bitmap bYt;
        private final Handler handler;
        final int index;

        @Override // com.kwad.sdk.glide.request.a.j
        public final /* synthetic */ void onResourceReady(Object obj, com.kwad.sdk.glide.request.b.b bVar) {
            a((Bitmap) obj);
        }

        a(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.bYs = j;
        }

        final Bitmap ain() {
            return this.bYt;
        }

        private void a(Bitmap bitmap) {
            this.bYt = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.bYs);
        }
    }

    private static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.afq().a(com.kwad.sdk.glide.request.i.b(com.kwad.sdk.glide.load.engine.h.bTq).cS(true).cU(true).U(i, i2));
    }

    private static com.kwad.sdk.glide.load.c aim() {
        return new com.kwad.sdk.glide.d.b(Double.valueOf(Math.random()));
    }
}
