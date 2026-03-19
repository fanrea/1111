package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.sdk.utils.ax;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o {
    public static final com.kwad.sdk.glide.load.e<WebpFrameCacheStrategy> caY = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.caT);
    public static final com.kwad.sdk.glide.load.e<p> caZ = com.kwad.sdk.glide.load.e.c("com.kwad.sdk.glide.webp.decoder.WebpFrameLoader.WebpFrameSampleSize", p.cbh);
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bPy;
    final com.kwad.sdk.glide.g bQg;
    private com.kwad.sdk.glide.load.i<Bitmap> bUr;
    private final List<b> bYj;
    private boolean bYk;
    private boolean bYl;
    private com.kwad.sdk.glide.f<Bitmap> bYm;
    private boolean bYo;
    private Bitmap bYq;
    private final i cba;
    private a cbb;
    private a cbc;
    private a cbd;
    private int cbe;
    private final Handler handler;
    private int height;
    private boolean isRunning;
    private int width;

    public interface b {
        void aig();
    }

    public o(com.kwad.sdk.glide.c cVar, i iVar, int i, int i2, com.kwad.sdk.glide.load.i<Bitmap> iVar2, Bitmap bitmap) {
        this(cVar.aeZ(), com.kwad.sdk.glide.c.cy(cVar.getContext()), iVar, null, a(com.kwad.sdk.glide.c.cy(cVar.getContext()), i, i2), iVar2, bitmap);
    }

    private o(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.g gVar, i iVar, Handler handler, com.kwad.sdk.glide.f<Bitmap> fVar, com.kwad.sdk.glide.load.i<Bitmap> iVar2, Bitmap bitmap) {
        this.bYj = new ArrayList();
        this.isRunning = false;
        this.bYk = false;
        this.bYl = false;
        this.bQg = gVar;
        Handler handler2 = new Handler(Looper.getMainLooper(), new c());
        this.bPy = eVar;
        this.handler = handler2;
        this.bYm = fVar;
        this.cba = iVar;
        a(iVar2, bitmap);
    }

    final void a(com.kwad.sdk.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this.bUr = (com.kwad.sdk.glide.load.i) ax.checkNotNull(iVar);
        this.bYq = (Bitmap) ax.checkNotNull(bitmap);
        this.bYm = this.bYm.a(new com.kwad.sdk.glide.request.i().a(iVar));
        this.cbe = com.kwad.sdk.glide.e.j.m(bitmap);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
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
        return this.width;
    }

    final int getHeight() {
        return this.height;
    }

    final int getSize() {
        return this.cba.getByteSize() + this.cbe;
    }

    final int getCurrentIndex() {
        a aVar = this.cbb;
        if (aVar != null) {
            return aVar.index;
        }
        return -1;
    }

    final ByteBuffer getBuffer() {
        return this.cba.getData().asReadOnlyBuffer();
    }

    final int getFrameCount() {
        return this.cba.getFrameCount();
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
        a aVar = this.cbb;
        if (aVar != null) {
            this.bQg.c(aVar);
            this.cbb = null;
        }
        a aVar2 = this.cbc;
        if (aVar2 != null) {
            this.bQg.c(aVar2);
            this.cbc = null;
        }
        a aVar3 = this.cbd;
        if (aVar3 != null) {
            this.bQg.c(aVar3);
            this.cbd = null;
        }
        this.cba.clear();
        this.bYo = true;
    }

    final Bitmap aij() {
        a aVar = this.cbb;
        return aVar != null ? aVar.ain() : this.bYq;
    }

    private void aik() {
        if (!this.isRunning || this.bYk) {
            return;
        }
        if (this.bYl) {
            ax.checkArgument(this.cbd == null, "Pending target must be null when starting from the first frame");
            this.cba.afz();
            this.bYl = false;
        }
        a aVar = this.cbd;
        if (aVar != null) {
            this.cbd = null;
            a(aVar);
            return;
        }
        this.bYk = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.cba.afx();
        this.cba.advance();
        int iAfy = this.cba.afy();
        this.cbc = new a(this.handler, iAfy, jUptimeMillis);
        this.bYm.a(com.kwad.sdk.glide.request.i.j(gw(iAfy)).cU(this.cba.ajM().noCache())).u(this.cba).b((com.kwad.sdk.glide.f<Bitmap>) this.cbc);
    }

    private void ail() {
        Bitmap bitmap = this.bYq;
        if (bitmap != null) {
            this.bPy.e(bitmap);
            this.bYq = null;
        }
    }

    final void a(a aVar) {
        System.currentTimeMillis();
        this.bYk = false;
        if (this.bYo) {
            this.handler.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.isRunning) {
            if (this.bYl) {
                this.handler.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.cbd = aVar;
                return;
            }
        }
        if (aVar.ain() != null) {
            ail();
            a aVar2 = this.cbb;
            this.cbb = aVar;
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
                o.this.a((a) message.obj);
                return true;
            }
            if (message.what != 2) {
                return false;
            }
            o.this.bQg.c((a) message.obj);
            return false;
        }
    }

    static class a extends com.kwad.sdk.glide.request.a.c<Bitmap> {
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
            Message messageObtainMessage = this.handler.obtainMessage(1, this);
            this.handler.removeMessages(1);
            this.handler.sendMessageAtTime(messageObtainMessage, this.bYs);
        }

        @Override // com.kwad.sdk.glide.request.a.j
        public final void onLoadCleared(Drawable drawable) {
            this.bYt = null;
        }
    }

    private static com.kwad.sdk.glide.f<Bitmap> a(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return gVar.afq().a(com.kwad.sdk.glide.request.i.b(com.kwad.sdk.glide.load.engine.h.bTq).cS(true).cU(true).U(i, i2));
    }

    private com.kwad.sdk.glide.load.c gw(int i) {
        return new d(new com.kwad.sdk.glide.d.b(this.cba), i);
    }

    static class d implements com.kwad.sdk.glide.load.c {
        private final com.kwad.sdk.glide.load.c bSq;
        private final int cbg;

        d(com.kwad.sdk.glide.load.c cVar, int i) {
            this.bSq = cVar;
            this.cbg = i;
        }

        @Override // com.kwad.sdk.glide.load.c
        public final boolean equals(Object obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.bSq.equals(dVar.bSq) && this.cbg == dVar.cbg) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.sdk.glide.load.c
        public final int hashCode() {
            return (this.bSq.hashCode() * 31) + this.cbg;
        }

        @Override // com.kwad.sdk.glide.load.c
        public final void updateDiskCacheKey(MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.cbg).array());
            this.bSq.updateDiskCacheKey(messageDigest);
        }
    }
}
