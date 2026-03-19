package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class q {
    private final b bdU = new b();

    q() {
    }

    static class a {
        private static final q bdV = new q();

        static {
            com.kwad.framework.filedownloader.message.e.Op().a(new aa());
        }
    }

    public static q Nc() {
        return a.bdV;
    }

    final synchronized void a(x.b bVar) {
        this.bdU.c(bVar);
    }

    final synchronized void b(x.b bVar) {
        this.bdU.b(bVar);
    }

    static class b {
        private ThreadPoolExecutor bdW;
        private LinkedBlockingQueue<Runnable> bdX;

        b() {
            init();
        }

        public final void c(x.b bVar) {
            this.bdW.execute(new c(bVar));
        }

        public final void b(x.b bVar) {
            this.bdX.remove(bVar);
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.bdX = linkedBlockingQueue;
            this.bdW = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }
    }

    static class c implements Runnable {
        private final x.b bdY;
        private boolean bdZ = false;

        c(x.b bVar) {
            this.bdY = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.bdZ) {
                return;
            }
            this.bdY.start();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.bdY;
        }
    }
}
