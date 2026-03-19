package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class g {
    private final c bJn;
    private final AtomicInteger bJr = new AtomicInteger(0);
    private volatile e bJs;
    private final b bJt;
    private final List<b> bmg;
    private final String url;

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.bmg = copyOnWriteArrayList;
        this.url = ax.iA(str);
        this.bJn = (c) ax.checkNotNull(cVar);
        this.bJt = new a(str, copyOnWriteArrayList);
    }

    public final void a(d dVar, Socket socket) {
        acZ();
        try {
            this.bJr.incrementAndGet();
            this.bJs.a(dVar, socket);
        } finally {
            ada();
        }
    }

    private synchronized void acZ() {
        if (this.bJn.bIY == 1 && isOkHttpSupported()) {
            this.bJs = this.bJs == null ? adc() : this.bJs;
        } else {
            this.bJs = this.bJs == null ? adb() : this.bJs;
        }
    }

    private static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void ada() {
        if (this.bJr.decrementAndGet() <= 0) {
            this.bJs.shutdown();
            this.bJs = null;
        }
    }

    public final void shutdown() {
        this.bmg.clear();
        e eVar = this.bJs;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.bJs = null;
        this.bJr.set(0);
    }

    public final int acW() {
        return this.bJr.get();
    }

    private e adb() {
        e eVar = new e(new h(this.url, this.bJn.bIW, this.bJn.bIX), new com.kwad.sdk.core.videocache.a.b(this.bJn.fX(this.url), this.bJn.bIV));
        eVar.a(this.bJt);
        return eVar;
    }

    private e adc() {
        e eVar = new e(new j(this.url, this.bJn.bIW, this.bJn.bIX), new com.kwad.sdk.core.videocache.a.b(this.bJn.fX(this.url), this.bJn.bIV));
        eVar.a(this.bJt);
        return eVar;
    }

    static final class a extends Handler implements b {
        private final List<b> bmg;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.bmg = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.bmg.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }
    }
}
