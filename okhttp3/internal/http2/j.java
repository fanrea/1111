package okhttp3.internal.http2;

import java.util.concurrent.CountDownLatch;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class j {
    private final CountDownLatch Dh = new CountDownLatch(1);
    private long Di = -1;
    private long Dj = -1;

    j() {
    }

    final void send() {
        if (this.Di != -1) {
            throw new IllegalStateException();
        }
        this.Di = System.nanoTime();
    }

    final void hf() {
        if (this.Dj != -1 || this.Di == -1) {
            throw new IllegalStateException();
        }
        this.Dj = System.nanoTime();
        this.Dh.countDown();
    }

    final void cancel() {
        if (this.Dj == -1) {
            long j = this.Di;
            if (j != -1) {
                this.Dj = j - 1;
                this.Dh.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
