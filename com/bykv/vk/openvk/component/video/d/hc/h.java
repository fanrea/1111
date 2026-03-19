package com.bykv.vk.openvk.component.video.d.hc;

import android.util.Log;
import com.bykv.vk.openvk.component.video.d.hc.gb;
import com.bykv.vk.openvk.component.video.d.hc.hc;
import com.bykv.vk.openvk.component.video.d.hc.mq;
import com.bykv.vk.openvk.component.video.d.hc.tt;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class h extends com.bykv.vk.openvk.component.video.d.hc.d {
    private volatile com.bykv.vk.openvk.component.video.d.hc.hc cb;
    private final c e;
    private final b k;
    private final Socket uo;
    private volatile boolean w;

    public interface b {
        void d(h hVar);

        void hc(h hVar);
    }

    h(d dVar) {
        super(dVar.d, dVar.hc);
        this.w = true;
        this.uo = dVar.b;
        this.k = dVar.c;
        this.e = c.b();
    }

    private hc gb() throws IOException {
        try {
            this.tt = tt.d(this.uo.getInputStream());
            OutputStream outputStream = this.uo.getOutputStream();
            com.bykv.vk.openvk.component.video.d.hc.d.d dVar = this.tt.b.d == 1 ? u.d : u.hc;
            if (dVar == null) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.d = dVar;
            this.h = this.tt.b.hc;
            this.gb = this.tt.b.b;
            this.tc = new mq(this.tt.b.h);
            this.an = this.tt.hc;
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.tt.toString());
            }
            return new hc(outputStream, this.tt.b.c);
        } catch (tt.c e) {
            com.bykv.vk.openvk.component.video.d.b.d.d(this.uo);
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            if (this.d != null) {
                Boolean.valueOf(h());
            }
            String str = this.h;
            return null;
        } catch (IOException e2) {
            com.bykv.vk.openvk.component.video.d.b.d.d(this.uo);
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            if (this.d != null) {
                Boolean.valueOf(h());
            }
            String str2 = this.h;
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.component.video.d.hc.hc.d dVarQuery;
        hc hcVarGb = gb();
        if (hcVarGb == null) {
            return;
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.d(this);
        }
        this.d.d(this.gb);
        if (u.gb != 0 && ((dVarQuery = this.hc.query(this.gb, this.tt.b.d)) == null || this.d.b(this.gb).length() < dVarQuery.b)) {
            this.e.d(h(), this.gb);
        }
        try {
            d(hcVarGb);
        } catch (com.bykv.vk.openvk.component.video.d.hc.b.d e) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
        } catch (Throwable th) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.d.hc(this.gb);
        this.e.d(h(), null);
        d();
        com.bykv.vk.openvk.component.video.d.b.d.d(this.uo);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.hc(this);
        }
    }

    private boolean d(hc hcVar) throws Throwable {
        while (this.tc.d()) {
            u();
            mq.d dVarHc = this.tc.hc();
            try {
                d(hcVar, dVarHc);
                return true;
            } catch (com.bykv.vk.openvk.component.video.d.hc.b.b unused) {
                dVarHc.d();
                Boolean.valueOf(h());
                String str = this.h;
            } catch (com.bykv.vk.openvk.component.video.d.hc.b.c e) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
                return true;
            } catch (com.bykv.vk.openvk.component.video.d.hc.b.hc e2) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (gb.d e3) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                this.w = false;
                Boolean.valueOf(h());
                String str2 = this.h;
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    dVarHc.hc();
                }
                if (hc()) {
                    if (u.b) {
                        if ("Canceled".equalsIgnoreCase(e4.getMessage())) {
                            com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                        }
                    }
                } else {
                    Boolean.valueOf(h());
                    String str3 = this.h;
                }
            } catch (Exception e5) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
            }
        }
        return false;
    }

    private void d(hc hcVar, mq.d dVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.tt.d.d)) {
            hc(hcVar, dVar);
        } else {
            b(hcVar, dVar);
        }
    }

    private void hc(hc hcVar, mq.d dVar) throws com.bykv.vk.openvk.component.video.d.hc.b.c, IOException {
        byte[] bArrD = d(this.hc.query(this.gb, this.tt.b.d), hcVar, dVar);
        if (bArrD == null) {
            return;
        }
        hcVar.d(bArrD, 0, bArrD.length);
    }

    private void b(hc hcVar, mq.d dVar) throws Throwable {
        if (this.w) {
            File fileB = this.d.b(this.gb);
            long length = fileB.length();
            com.bykv.vk.openvk.component.video.d.hc.hc.d dVarQuery = this.hc.query(this.gb, this.tt.b.d);
            int iHc = hcVar.hc();
            if (length > hcVar.hc()) {
                if (u.b) {
                    com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - iHc));
                }
                d(dVarQuery, fileB, hcVar, dVar);
                return;
            }
        }
        c(hcVar, dVar);
    }

    private byte[] d(com.bykv.vk.openvk.component.video.d.hc.hc.d dVar, hc hcVar, mq.d dVar2) throws IOException {
        if (dVar != null) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.d.b.d.d(dVar, hcVar.hc()).getBytes(com.bykv.vk.openvk.component.video.d.b.d.d);
        }
        com.bykv.vk.openvk.component.video.d.hc.u.d dVarD = d(dVar2, 0, -1, "HEAD");
        if (dVarD == null) {
            return null;
        }
        try {
            String strD = com.bykv.vk.openvk.component.video.d.b.d.d(dVarD, false, false);
            if (strD != null) {
                throw new com.bykv.vk.openvk.component.video.d.hc.b.b(strD + ", rawKey: " + this.h + ", url: " + dVar2);
            }
            com.bykv.vk.openvk.component.video.d.hc.hc.d dVarD2 = com.bykv.vk.openvk.component.video.d.b.d.d(dVarD, this.hc, this.gb, this.tt.b.d);
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.hc("TAG_PROXY_ProxyTask", "get header from network");
            }
            return com.bykv.vk.openvk.component.video.d.b.d.d(dVarD2, hcVar.hc()).getBytes(com.bykv.vk.openvk.component.video.d.b.d.d);
        } finally {
            com.bykv.vk.openvk.component.video.d.b.d.d(dVarD.c());
        }
    }

    private void d(com.bykv.vk.openvk.component.video.d.hc.hc.d dVar, File file, hc hcVar, mq.d dVar2) throws Throwable {
        final com.bytedance.sdk.component.tc.gb gbVar;
        gb gbVar2;
        com.bykv.vk.openvk.component.video.d.hc.hc hcVar2;
        if (!hcVar.d()) {
            byte[] bArrD = d(dVar, hcVar, dVar2);
            u();
            if (bArrD == null) {
                return;
            } else {
                hcVar.d(bArrD, 0, bArrD.length);
            }
        }
        gb gbVar3 = null;
        if (dVar == null && (dVar = this.hc.query(this.gb, this.tt.b.d)) == null) {
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            d(null, hcVar, dVar2);
            dVar = this.hc.query(this.gb, this.tt.b.d);
            if (dVar == null) {
                throw new com.bykv.vk.openvk.component.video.d.hc.b.b("failed to get header, rawKey: " + this.h + ", url: " + dVar2);
            }
        }
        if (file.length() >= dVar.b || !((hcVar2 = this.cb) == null || hcVar2.hc() || hcVar2.c())) {
            gbVar = null;
        } else {
            com.bykv.vk.openvk.component.video.d.hc.hc hcVarD = new hc.d().d(this.d).d(this.hc).d(this.h).hc(this.gb).d(new mq(dVar2.d)).d(this.an).d(this.tt).d(new hc.InterfaceC0164hc() { // from class: com.bykv.vk.openvk.component.video.d.hc.h.1
                @Override // com.bykv.vk.openvk.component.video.d.hc.hc.InterfaceC0164hc
                public void d(com.bykv.vk.openvk.component.video.d.hc.hc hcVar3) {
                    h.this.b.addAndGet(hcVar3.b.get());
                    h.this.c.addAndGet(hcVar3.c.get());
                    synchronized (hcVar3.uo) {
                        hcVar3.uo.notifyAll();
                    }
                    if (hcVar3.c()) {
                        h.this.e.d(h.this.h(), null);
                    }
                }
            }).d();
            this.cb = hcVarD;
            gbVar = new com.bytedance.sdk.component.tc.gb(hcVarD, null, 10, 1);
            com.bytedance.sdk.component.tc.h.hc(new com.bytedance.sdk.component.tc.tt("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.component.video.d.hc.h.2
                @Override // java.lang.Runnable
                public void run() {
                    gbVar.run();
                }
            });
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            gbVar2 = new gb(file, t.k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gbVar2.d(hcVar.hc());
            int iMin = this.tt.b.u > 0 ? Math.min(dVar.b, this.tt.b.u) : dVar.b;
            while (hcVar.hc() < iMin) {
                u();
                int iD = gbVar2.d(bArr);
                if (iD <= 0) {
                    com.bykv.vk.openvk.component.video.d.hc.hc hcVar3 = this.cb;
                    if (hcVar3 != null) {
                        com.bykv.vk.openvk.component.video.d.hc.b.hc hcVarTt = hcVar3.tt();
                        if (hcVarTt != null) {
                            throw hcVarTt;
                        }
                        gb.d dVarGb = hcVar3.gb();
                        if (dVarGb != null) {
                            throw dVarGb;
                        }
                    }
                    if (hcVar3 != null && !hcVar3.hc() && !hcVar3.c()) {
                        u();
                        synchronized (hcVar3.uo) {
                            try {
                                hcVar3.uo.wait(1000L);
                            } catch (InterruptedException e) {
                                com.bytedance.sdk.component.utils.mq.d(e);
                            }
                        }
                    }
                    if (u.b) {
                        com.bytedance.sdk.component.utils.mq.c("TAG_PROXY_ProxyTask", "download task has finished!!!");
                    }
                    throw new com.bykv.vk.openvk.component.video.d.hc.b.b("illegal state download task has finished, rawKey: " + this.h + ", url: " + dVar2);
                }
                hcVar.hc(bArr, 0, iD);
                u();
            }
            if (u.b) {
                com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_ProxyTask", "read cache file complete: " + hcVar.hc() + ", " + iMin);
            }
            b();
            gbVar2.d();
            if (gbVar != null) {
                try {
                    gbVar.get();
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.mq.d(th2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            gbVar3 = gbVar2;
            if (gbVar3 != null) {
                gbVar3.d();
            }
            if (gbVar != null) {
                try {
                    gbVar.get();
                } catch (Throwable th4) {
                    com.bytedance.sdk.component.utils.mq.d(th4);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01b3 A[EDGE_INSN: B:104:0x01b3->B:70:0x01b3 BREAK  A[LOOP:0: B:99:0x0171->B:69:0x01af], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010c A[Catch: all -> 0x01df, TRY_LEAVE, TryCatch #6 {all -> 0x01df, blocks: (B:30:0x00f7, B:37:0x0108, B:39:0x010c, B:45:0x0156, B:49:0x0168, B:48:0x0166, B:36:0x0104), top: B:101:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0166 A[Catch: all -> 0x01df, TryCatch #6 {all -> 0x01df, blocks: (B:30:0x00f7, B:37:0x0108, B:39:0x010c, B:45:0x0156, B:49:0x0168, B:48:0x0166, B:36:0x0104), top: B:101:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0177 A[Catch: all -> 0x01db, TryCatch #4 {all -> 0x01db, blocks: (B:51:0x0171, B:53:0x0177, B:55:0x017c, B:68:0x01a8, B:61:0x0187, B:69:0x01af, B:70:0x01b3, B:72:0x01b7, B:73:0x01bc, B:58:0x0182), top: B:99:0x0171, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b7 A[Catch: all -> 0x01db, TryCatch #4 {all -> 0x01db, blocks: (B:51:0x0171, B:53:0x0177, B:55:0x017c, B:68:0x01a8, B:61:0x0187, B:69:0x01af, B:70:0x01b3, B:72:0x01b7, B:73:0x01bc, B:58:0x0182), top: B:99:0x0171, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.bykv.vk.openvk.component.video.d.hc.h.hc r13, com.bykv.vk.openvk.component.video.d.hc.mq.d r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.hc.h.c(com.bykv.vk.openvk.component.video.d.hc.h$hc, com.bykv.vk.openvk.component.video.d.hc.mq$d):void");
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d
    public void d() {
        super.d();
        tt();
    }

    private void tt() {
        com.bykv.vk.openvk.component.video.d.hc.hc hcVar = this.cb;
        this.cb = null;
        if (hcVar != null) {
            hcVar.d();
        }
    }

    private static class hc {
        private boolean b;
        private final OutputStream d;
        private int hc;

        hc(OutputStream outputStream, int i) {
            this.d = outputStream;
            this.hc = i;
        }

        boolean d() {
            return this.b;
        }

        void d(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.component.video.d.hc.b.c, IOException {
            if (this.b) {
                return;
            }
            try {
                this.d.write(bArr, i, i2);
                this.b = true;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.d.hc.b.c(e);
            }
        }

        void hc(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.component.video.d.hc.b.c, IOException {
            try {
                this.d.write(bArr, i, i2);
                this.hc += i2;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.d.hc.b.c(e);
            }
        }

        int hc() {
            return this.hc;
        }
    }

    static final class d {
        Socket b;
        b c;
        com.bykv.vk.openvk.component.video.d.hc.d.d d;
        com.bykv.vk.openvk.component.video.d.hc.hc.b hc;

        d() {
        }

        d d(com.bykv.vk.openvk.component.video.d.hc.hc.b bVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.hc = bVar;
            return this;
        }

        d d(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.b = socket;
            return this;
        }

        d d(b bVar) {
            this.c = bVar;
            return this;
        }

        h d() {
            if (this.hc == null || this.b == null) {
                throw new IllegalArgumentException();
            }
            return new h(this);
        }
    }
}
