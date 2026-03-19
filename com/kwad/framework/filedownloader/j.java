package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j {
    static int bdF = 10;
    static int bdG = 5;
    private final Executor bdB;
    private final LinkedBlockingQueue<t> bdC;
    private final Object bdD;
    private final ArrayList<t> bdE;
    private final Handler handler;

    /* synthetic */ j(byte b2) {
        this();
    }

    static final class a {
        private static final j bdJ = new j(0);
    }

    public static j MO() {
        return a.bdJ;
    }

    private j() {
        this.bdB = com.kwad.framework.filedownloader.f.b.G(5, "BlockCompleted");
        this.bdD = new Object();
        this.bdE = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.bdC = new LinkedBlockingQueue<>();
    }

    final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z) {
        if (tVar.MT()) {
            tVar.MS();
            return;
        }
        if (tVar.MU()) {
            this.bdB.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.MS();
                }
            });
            return;
        }
        if (!MP() && !this.bdC.isEmpty()) {
            synchronized (this.bdD) {
                if (!this.bdC.isEmpty()) {
                    Iterator<t> it = this.bdC.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                }
                this.bdC.clear();
            }
        }
        if (!MP()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.bdD) {
            this.bdC.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.bdD) {
            if (this.bdE.isEmpty()) {
                if (this.bdC.isEmpty()) {
                    return;
                }
                int i = 0;
                if (!MP()) {
                    this.bdC.drainTo(this.bdE);
                } else {
                    int i2 = bdF;
                    int iMin = Math.min(this.bdC.size(), bdG);
                    while (i < iMin) {
                        this.bdE.add(this.bdC.remove());
                        i++;
                    }
                    i = i2;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.bdE), i);
            }
        }
    }

    static class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((t) message.obj).MS();
            } else if (message.what == 2) {
                a((ArrayList) message.obj);
                j.MO().push();
            }
            return true;
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null) {
                    next.MS();
                }
            }
            arrayList.clear();
        }
    }

    private static boolean MP() {
        return bdF > 0;
    }
}
