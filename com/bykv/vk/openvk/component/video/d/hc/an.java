package com.bykv.vk.openvk.component.video.d.hc;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.openvk.component.video.d.hc.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static volatile an c;
    private volatile com.bykv.vk.openvk.component.video.d.hc.d.b an;
    private final AtomicInteger b = new AtomicInteger(0);
    private volatile ServerSocket d;
    private final SparseArray<Set<h>> gb;
    private volatile com.bykv.vk.openvk.component.video.d.hc.d.hc h;
    private volatile int hc;
    private volatile b mk;
    private final Runnable mq;
    private volatile b tc;
    private final h.b tt;
    private volatile com.bykv.vk.openvk.component.video.d.hc.hc.b u;
    private final AtomicBoolean uo;

    static /* synthetic */ void d(String str, String str2) {
    }

    boolean d(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.gb) {
            Set<h> set = this.gb.get(i);
            if (set != null) {
                for (h hVar : set) {
                    if (hVar != null && str.equals(hVar.gb)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static an d() {
        if (c == null) {
            synchronized (an.class) {
                if (c == null) {
                    c = new an();
                }
            }
        }
        return c;
    }

    private an() {
        SparseArray<Set<h>> sparseArray = new SparseArray<>(2);
        this.gb = sparseArray;
        this.tt = new h.b() { // from class: com.bykv.vk.openvk.component.video.d.hc.an.1
            @Override // com.bykv.vk.openvk.component.video.d.hc.h.b
            public void d(h hVar) {
                synchronized (an.this.gb) {
                    Set set = (Set) an.this.gb.get(hVar.an());
                    if (set != null) {
                        set.add(hVar);
                    }
                }
            }

            @Override // com.bykv.vk.openvk.component.video.d.hc.h.b
            public void hc(h hVar) {
                boolean z = u.b;
                int iAn = hVar.an();
                synchronized (an.this.gb) {
                    Set set = (Set) an.this.gb.get(iAn);
                    if (set != null) {
                        set.remove(hVar);
                    }
                }
            }
        };
        this.mq = new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.hc.an.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i = 0;
                    an.this.d = new ServerSocket(0, 50, InetAddress.getByName(an.this.tt()));
                    an anVar = an.this;
                    anVar.hc = anVar.d.getLocalPort();
                    if (an.this.hc != -1) {
                        tc.d(an.this.tt(), an.this.hc);
                        if (an.this.h()) {
                            com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "run:  state = ", an.this.b);
                            if (an.this.b.compareAndSet(0, 1)) {
                                com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "run:  state = ", an.this.b);
                                if (u.b) {
                                    com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "proxy server start!");
                                }
                                while (an.this.b.get() == 1) {
                                    try {
                                        try {
                                            Socket socketAccept = an.this.d.accept();
                                            com.bykv.vk.openvk.component.video.d.hc.hc.b bVar = an.this.u;
                                            if (bVar != null) {
                                                final h hVarD = new h.d().d(bVar).d(socketAccept).d(an.this.tt).d();
                                                com.bytedance.sdk.component.tc.h.d().execute(new com.bytedance.sdk.component.tc.tt("ProxyTask", 10) { // from class: com.bykv.vk.openvk.component.video.d.hc.an.2.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        hVarD.run();
                                                    }
                                                });
                                            } else {
                                                com.bykv.vk.openvk.component.video.d.b.d.d(socketAccept);
                                            }
                                        } catch (IOException e) {
                                            com.bytedance.sdk.component.utils.mq.d(e);
                                            an.d("accept error", Log.getStackTraceString(e));
                                            i++;
                                            if (i > 3) {
                                                break;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        String stackTraceString = Log.getStackTraceString(th);
                                        com.bytedance.sdk.component.utils.mq.c("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                        an.d("error", stackTraceString);
                                    }
                                }
                                if (u.b) {
                                    com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "proxy server closed!");
                                }
                                an.this.u();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    an.d("socket not bound", "");
                    an.this.u();
                } catch (IOException e2) {
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.c("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                    }
                    an.d("create ServerSocket error", Log.getStackTraceString(e2));
                    an.this.u();
                }
            }
        };
        this.uo = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    b hc() {
        return this.tc;
    }

    b b() {
        return this.mk;
    }

    void d(com.bykv.vk.openvk.component.video.d.hc.hc.b bVar) {
        this.u = bVar;
    }

    void d(com.bykv.vk.openvk.component.video.d.hc.d.b bVar) {
        this.an = bVar;
    }

    public String d(boolean z, boolean z2, String str, String... strArr) {
        String str2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return strArr[0];
        }
        if (this.u == null) {
            return strArr[0];
        }
        if ((z ? this.h : this.an) == null) {
            return strArr[0];
        }
        if (this.b.get() != 1) {
            return strArr[0];
        }
        List<String> listD = com.bykv.vk.openvk.component.video.d.b.d.d(strArr);
        if (listD == null) {
            return strArr[0];
        }
        String strD = tt.d(str, z2 ? str : com.bykv.vk.openvk.component.video.api.an.hc.d(str), listD);
        if (strD == null) {
            return strArr[0];
        }
        if (z) {
            str2 = "https://" + tt() + ":" + this.hc + "?f=1&" + strD;
        } else {
            str2 = "https://" + tt() + ":" + this.hc + "?" + strD;
        }
        return str2.replaceFirst("s", "");
    }

    public void c() {
        if (this.uo.compareAndSet(false, true)) {
            com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(this.mq, "r/ProxyServer");
            bVar.setName("csj_proxy_server");
            bVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.b.compareAndSet(1, 2) || this.b.compareAndSet(0, 2)) {
            com.bykv.vk.openvk.component.video.d.b.d.d(this.d);
            an();
        }
    }

    private void an() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.gb) {
            int size = this.gb.size();
            for (int i = 0; i < size; i++) {
                SparseArray<Set<h>> sparseArray = this.gb;
                Set<h> set = sparseArray.get(sparseArray.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean h() {
        com.bytedance.sdk.component.tc.gb gbVar = new com.bytedance.sdk.component.tc.gb(new d(tt(), this.hc), 5, 1);
        com.bytedance.sdk.component.tc.h.d().submit(gbVar);
        gb();
        try {
            if (!((Boolean) gbVar.get()).booleanValue()) {
                com.bytedance.sdk.component.utils.mq.c("ProxyServer", "Ping error");
                u();
                return false;
            }
            com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "pingTest: ");
            if (u.b) {
                com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "Ping OK!");
            }
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            Log.getStackTraceString(th);
            u();
            return false;
        }
    }

    private static final class d implements Callable<Boolean> {
        private final String d;
        private final int hc;

        d(String str, int i) {
            this.d = str;
            this.hc = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            Socket socket;
            Throwable th;
            try {
                socket = new Socket(this.d, this.hc);
            } catch (Throwable th2) {
                socket = null;
                th = th2;
            }
            try {
                socket.setSoTimeout(2000);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Ping\n".getBytes(com.bykv.vk.openvk.component.video.d.b.d.d));
                outputStream.flush();
                if (ca.k.equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                    return Boolean.TRUE;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "call: ", th);
                    an.d("ping error", Log.getStackTraceString(th));
                    com.bykv.vk.openvk.component.video.d.b.d.d(socket);
                    return Boolean.FALSE;
                } finally {
                    com.bykv.vk.openvk.component.video.d.b.d.d(socket);
                }
            }
            com.bykv.vk.openvk.component.video.d.b.d.d(socket);
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r0v6 */
    private void gb() {
        Socket socket;
        ?? Accept = 0;
        Accept = 0;
        try {
            try {
                Accept = this.d.accept();
                Accept.setSoTimeout(2000);
                boolean zEquals = "Ping".equals(new BufferedReader(new InputStreamReader(Accept.getInputStream())).readLine());
                socket = Accept;
                if (zEquals) {
                    OutputStream outputStream = Accept.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bykv.vk.openvk.component.video.d.b.d.d));
                    outputStream.flush();
                    socket = Accept;
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
                Log.getStackTraceString(e);
                socket = Accept;
            }
            com.bykv.vk.openvk.component.video.d.b.d.d(socket);
            Accept = "ProxyServer";
            com.bykv.vk.openvk.component.video.api.an.b.d("ProxyServer", "answerPing: ");
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.d.b.d.d((Socket) Accept);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tt() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }
}
