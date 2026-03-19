package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d implements Handler.Callback {
    private final com.kwad.framework.filedownloader.d.c beZ;
    private volatile Thread beu;
    private final a bfH;
    private final int bfI;
    private final int bfJ;
    private final int bfK;
    private long bfL;
    private HandlerThread bfM;
    private volatile boolean bfP;
    private Handler handler;
    private volatile boolean bfN = false;
    private volatile long bft = 0;
    private final AtomicLong bfO = new AtomicLong();
    private boolean bfQ = true;
    private final com.kwad.framework.filedownloader.b.a beU = b.Ny().NA();

    d(com.kwad.framework.filedownloader.d.c cVar, int i, int i2, int i3) {
        this.beZ = cVar;
        this.bfJ = i2 < 5 ? 5 : i2;
        this.bfK = i3;
        this.bfH = new a();
        this.bfI = i;
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.bfM;
        return handlerThread != null && handlerThread.isAlive();
    }

    final void NQ() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.bfM.quit();
            this.beu = Thread.currentThread();
            while (this.bfN) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.beu = null;
        }
    }

    public final void NR() {
        this.beZ.d((byte) 1);
        this.beU.dq(this.beZ.getId());
        c((byte) 1);
    }

    final void NS() {
        this.beZ.d((byte) 6);
        c((byte) 6);
        this.beU.dl(this.beZ.getId());
    }

    final void a(boolean z, long j, String str, String str2) {
        String strOw = this.beZ.Ow();
        if (strOw != null && !strOw.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, strOw));
        }
        this.bfH.cj(z);
        this.beZ.d((byte) 2);
        this.beZ.az(j);
        this.beZ.cz(str);
        this.beZ.cB(str2);
        this.beU.a(this.beZ.getId(), j, str, str2);
        c((byte) 2);
        this.bfL = q(j, this.bfK);
        this.bfP = true;
    }

    final void NT() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.bfM = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.bfM.getLooper(), this);
    }

    final void onProgress(long j) {
        this.bfO.addAndGet(j);
        this.beZ.ay(j);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zAu = au(jElapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(jElapsedRealtime, zAu);
        } else if (zAu) {
            b(handler.obtainMessage(3));
        }
    }

    final void a(Exception exc, int i, long j) {
        this.bfO.set(0L);
        this.beZ.ay(-j);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i);
        } else {
            b(handler.obtainMessage(5, i, 0, exc));
        }
    }

    final void NU() {
        NZ();
    }

    final void c(Exception exc) {
        e(exc);
    }

    final void NV() {
        if (NY()) {
            return;
        }
        NX();
    }

    private synchronized void b(Message message) {
        if (!this.bfM.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (!this.bfM.isAlive()) {
                if (com.kwad.framework.filedownloader.f.d.bhj) {
                    com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    return;
                }
                return;
            }
            throw e;
        }
    }

    private static long q(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    private Exception d(Exception exc) {
        long length;
        String strNN = this.beZ.NN();
        if ((!this.beZ.isChunked() && !com.kwad.framework.filedownloader.f.e.OX().bhp) || !(exc instanceof IOException) || !new File(strNN).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(strNN);
        if (availableBytes > 4096) {
            return exc;
        }
        File file = new File(strNN);
        if (!file.exists()) {
            com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        } else {
            length = file.length();
        }
        if (Build.VERSION.SDK_INT >= 9) {
            return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
        }
        return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.beZ.getId();
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.beZ.cA(sQLiteFullException.toString());
        this.beZ.d((byte) -1);
        this.beU.dp(id);
        this.beU.mo454do(id);
    }

    private void NW() {
        String strNN = this.beZ.NN();
        String targetFilePath = this.beZ.getTargetFilePath();
        File file = new File(strNN);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't rename the  temp downloaded file(%s) to the target file(%s)", strNN, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", strNN);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", strNN);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[DONT_GENERATE] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            r0 = 1
            r4.bfN = r0
            int r1 = r5.what
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L17
            r2 = 5
            if (r1 == r2) goto Ld
            goto L1e
        Ld:
            java.lang.Object r1 = r5.obj     // Catch: java.lang.Throwable -> L2a
            java.lang.Exception r1 = (java.lang.Exception) r1     // Catch: java.lang.Throwable -> L2a
            int r5 = r5.arg1     // Catch: java.lang.Throwable -> L2a
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L1e
        L17:
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L2a
            r4.b(r1, r0)     // Catch: java.lang.Throwable -> L2a
        L1e:
            r4.bfN = r3
            java.lang.Thread r5 = r4.beu
            if (r5 == 0) goto L29
            java.lang.Thread r5 = r4.beu
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L29:
            return r0
        L2a:
            r5 = move-exception
            r4.bfN = r3
            java.lang.Thread r0 = r4.beu
            if (r0 == 0) goto L36
            java.lang.Thread r0 = r4.beu
            java.util.concurrent.locks.LockSupport.unpark(r0)
        L36:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.d.handleMessage(android.os.Message):boolean");
    }

    private void b(long j, boolean z) {
        if (this.beZ.Ov() == this.beZ.getTotal()) {
            this.beU.f(this.beZ.getId(), this.beZ.Ov());
            return;
        }
        if (this.bfP) {
            this.bfP = false;
            this.beZ.d((byte) 3);
        }
        if (z) {
            this.bft = j;
            c((byte) 3);
            this.bfO.set(0L);
        }
    }

    private void NX() {
        NW();
        this.beZ.d((byte) -3);
        this.beU.g(this.beZ.getId(), this.beZ.getTotal());
        this.beU.mo454do(this.beZ.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.OX().bhq) {
            com.kwad.framework.filedownloader.services.f.f(this.beZ);
        }
    }

    private boolean NY() {
        if (this.beZ.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.beZ;
            cVar.az(cVar.Ov());
        } else if (this.beZ.Ov() != this.beZ.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("sofar[%d] not equal total[%d]", Long.valueOf(this.beZ.Ov()), Long.valueOf(this.beZ.getTotal()))));
            return true;
        }
        return false;
    }

    private void a(Exception exc, int i) {
        Exception excD = d(exc);
        this.bfH.f(excD);
        this.bfH.dw(this.bfI - i);
        this.beZ.d((byte) 5);
        this.beZ.cA(excD.toString());
        this.beU.a(this.beZ.getId(), excD);
        c((byte) 5);
    }

    private void NZ() {
        this.beZ.d((byte) -2);
        this.beU.h(this.beZ.getId(), this.beZ.Ov());
        c((byte) -2);
    }

    private void e(Exception exc) {
        Exception exc2;
        Exception excD = d(exc);
        if (excD instanceof SQLiteFullException) {
            a((SQLiteFullException) excD);
            exc2 = excD;
        } else {
            try {
                this.beZ.d((byte) -1);
                this.beZ.cA(exc.toString());
                this.beU.a(this.beZ.getId(), excD, this.beZ.Ov());
                exc2 = excD;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException = e;
                a(sQLiteFullException);
                exc2 = sQLiteFullException;
            }
        }
        this.bfH.f(exc2);
        c((byte) -1);
    }

    private boolean au(long j) {
        if (!this.bfQ) {
            return this.bfL != -1 && this.bfO.get() >= this.bfL && j - this.bft >= ((long) this.bfJ);
        }
        this.bfQ = false;
        return true;
    }

    private void c(byte b) {
        if (b == -2) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.beZ.getId()));
                return;
            }
            return;
        }
        com.kwad.framework.filedownloader.message.e.Op().s(com.kwad.framework.filedownloader.message.f.a(b, this.beZ, this.bfH));
    }

    public static class a {
        private boolean bfR;
        private int bfS;
        private Exception exception;

        final void cj(boolean z) {
            this.bfR = z;
        }

        public final boolean Oa() {
            return this.bfR;
        }

        final void f(Exception exc) {
            this.exception = exc;
        }

        final void dw(int i) {
            this.bfS = i;
        }

        public final Exception getException() {
            return this.exception;
        }

        public final int Mk() {
            return this.bfS;
        }
    }
}
