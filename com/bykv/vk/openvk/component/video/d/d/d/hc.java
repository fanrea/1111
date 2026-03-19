package com.bykv.vk.openvk.component.video.d.d.d;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements b {
    private static final HashMap<String, hc> d = new HashMap<>();
    private long an;
    private File c;
    private volatile long hc;
    private final c mk;
    private hc mq;
    private RandomAccessFile tc;
    private File u;
    private final Object b = new Object();
    private volatile long h = -1;
    private volatile boolean gb = false;
    private volatile boolean tt = false;

    public hc(Context context, c cVar) {
        this.hc = -2147483648L;
        this.an = 0L;
        this.tc = null;
        this.mk = cVar;
        try {
            this.c = com.bykv.vk.openvk.component.video.d.u.b.hc(cVar.u(), cVar.w());
            this.u = com.bykv.vk.openvk.component.video.d.u.b.b(cVar.u(), cVar.w());
            if (gb()) {
                this.tc = new RandomAccessFile(this.u, t.k);
            } else {
                this.tc = new RandomAccessFile(this.c, "rw");
            }
            if (gb()) {
                return;
            }
            this.an = this.c.length();
            if (!u()) {
                com.bykv.vk.openvk.component.video.api.an.b.hc("CSJ_MediaDLPlay", "no process lock, no download " + an());
                return;
            }
            synchronized (hc.class) {
                if (h()) {
                    hc();
                } else {
                    hc hcVar = this.mq;
                    if (hcVar != null) {
                        this.hc = hcVar.d();
                    }
                }
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.an.b.hc("CSJ_MediaDLPlay", "Error using file ", cVar.cb(), " as disc cache");
        }
    }

    private boolean u() throws IOException {
        RandomAccessFile randomAccessFile = this.tc;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            if (fileLockTryLock == null) {
                if (fileLockTryLock != null) {
                    try {
                        fileLockTryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            if (fileLockTryLock == null) {
                return true;
            }
            try {
                fileLockTryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    private String an() {
        c cVar = this.mk;
        return cVar == null ? "" : cVar.w();
    }

    private boolean h() {
        String strAn = an();
        synchronized (hc.class) {
            HashMap<String, hc> map = d;
            hc hcVar = map.get(strAn);
            this.mq = hcVar;
            if (hcVar != null) {
                return false;
            }
            map.put(strAn, this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        String strAn = an();
        synchronized (hc.class) {
            if (z) {
                d.remove(strAn);
            } else {
                HashMap<String, hc> map = d;
                if (map.get(strAn) == this) {
                    map.remove(strAn);
                }
            }
        }
    }

    public long d() {
        return this.hc;
    }

    private boolean gb() {
        return this.u.exists() && this.u.length() > 0;
    }

    public void hc() {
        mq.d dVar;
        if (com.bykv.vk.openvk.component.video.api.b.b() != null) {
            dVar = com.bykv.vk.openvk.component.video.api.b.b().hc();
        } else {
            dVar = new mq.d("v_cache");
        }
        dVar.d(this.mk.rf(), TimeUnit.MILLISECONDS).hc(this.mk.jh(), TimeUnit.MILLISECONDS).b(this.mk.sy(), TimeUnit.MILLISECONDS);
        mq mqVarD = dVar.d();
        Object[] objArr = new Object[4];
        Long.valueOf(this.an);
        this.mk.w();
        mqVarD.d(new k.d().d("RANGE", "bytes=" + this.an + "-").d(this.mk.cb()).d().hc()).d(new com.bytedance.sdk.component.hc.d.b() { // from class: com.bykv.vk.openvk.component.video.d.d.d.hc.1
            @Override // com.bytedance.sdk.component.hc.d.b
            public void onFailure(com.bytedance.sdk.component.hc.d.hc hcVar, IOException iOException) {
                hc.this.tt = false;
                hc.this.hc = -1L;
                hc.this.d(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:100:0x01bf, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:101:0x01c2, code lost:
            
                if (r21 == null) goto L103;
             */
            /* JADX WARN: Code restructure failed: missing block: B:102:0x01c4, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:103:0x01c7, code lost:
            
                r2 = r19.d.c.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x01d7, code lost:
            
                if (r19.d.tt == false) goto L246;
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x01e1, code lost:
            
                if (r2 != r19.d.hc) goto L247;
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x01e5, code lost:
            
                if (r2 <= r5) goto L248;
             */
            /* JADX WARN: Code restructure failed: missing block: B:109:0x01e7, code lost:
            
                r0 = r19.d;
                r0.d(r0.hc);
             */
            /* JADX WARN: Code restructure failed: missing block: B:110:0x01f0, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x01f1, code lost:
            
                com.bykv.vk.openvk.component.video.api.an.b.hc("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:112:0x01f8, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x0203, code lost:
            
                if (com.bykv.vk.openvk.component.video.d.u.b.d(r19.d.tc, r0, r8, r12) == false) goto L235;
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x0205, code lost:
            
                r8 = r8 + r12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0207, code lost:
            
                monitor-exit(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x020e, code lost:
            
                com.bytedance.sdk.component.utils.mq.hc("CSJ_MediaDLPlay", "append error, try again：" + r8 + "  offset = " + r12 + " key= " + r19.d.mk.w() + " fb: " + r11.valid() + " channel " + r10.isOpen());
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x025c, code lost:
            
                monitor-exit(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x025d, code lost:
            
                if (r16 == null) goto L124;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x025f, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x0263, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0265, code lost:
            
                if (r7 == null) goto L126;
             */
            /* JADX WARN: Code restructure failed: missing block: B:125:0x0267, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:126:0x026a, code lost:
            
                if (r21 == null) goto L128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:0x026c, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x026f, code lost:
            
                r2 = r19.d.c.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x027f, code lost:
            
                if (r19.d.tt == false) goto L249;
             */
            /* JADX WARN: Code restructure failed: missing block: B:131:0x0289, code lost:
            
                if (r2 != r19.d.hc) goto L250;
             */
            /* JADX WARN: Code restructure failed: missing block: B:133:0x028f, code lost:
            
                if (r2 <= 0) goto L251;
             */
            /* JADX WARN: Code restructure failed: missing block: B:134:0x0291, code lost:
            
                r0 = r19.d;
                r0.d(r0.hc);
             */
            /* JADX WARN: Code restructure failed: missing block: B:135:0x029a, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:136:0x029b, code lost:
            
                com.bykv.vk.openvk.component.video.api.an.b.hc("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:137:0x02a2, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:246:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:247:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:248:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:249:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:250:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:251:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:89:0x0187, code lost:
            
                r3 = r19.d.b;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x018d, code lost:
            
                monitor-enter(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x0194, code lost:
            
                if (r19.d.gb == false) goto L113;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x0196, code lost:
            
                com.bykv.vk.openvk.component.video.api.an.b.hc("CSJ_MediaDLPlay", "close stream " + r19.d.mk.w());
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x01b4, code lost:
            
                monitor-exit(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x01b5, code lost:
            
                if (r16 == null) goto L99;
             */
            /* JADX WARN: Code restructure failed: missing block: B:96:0x01b7, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x01bb, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:99:0x01bd, code lost:
            
                if (r7 == null) goto L101;
             */
            @Override // com.bytedance.sdk.component.hc.d.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.hc.d.hc r20, com.bytedance.sdk.component.hc.d.cb r21) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 1018
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.d.d.hc.AnonymousClass1.onResponse(com.bytedance.sdk.component.hc.d.hc, com.bytedance.sdk.component.hc.d.cb):void");
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.d.d.d.b
    public int d(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.hc) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.gb) {
                synchronized (this.b) {
                    long jTt = tt();
                    if (j < jTt) {
                        this.tc.seek(j);
                        i4 = this.tc.read(bArr, i, i2);
                    } else {
                        Object[] objArr = new Object[4];
                        Long.valueOf(j);
                        Long.valueOf(jTt);
                        i3 += 33;
                        this.b.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 10000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    @Override // com.bykv.vk.openvk.component.video.d.d.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r4.gb     // Catch: java.lang.Throwable -> L21
            if (r1 != 0) goto La
            java.io.RandomAccessFile r1 = r4.tc     // Catch: java.lang.Throwable -> L21
            r1.close()     // Catch: java.lang.Throwable -> L21
        La:
            java.io.File r1 = r4.c     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L15
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L21
            r1.setLastModified(r2)     // Catch: java.lang.Throwable -> L21
        L15:
            java.io.File r1 = r4.u     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L29
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L21
            r1.setLastModified(r2)     // Catch: java.lang.Throwable -> L21
            goto L29
        L21:
            r1 = move-exception
            java.lang.String r2 = "CSJ_MediaDLPlay"
            java.lang.String r3 = "close error"
            com.bykv.vk.openvk.component.video.api.an.b.hc(r2, r3, r1)     // Catch: java.lang.Throwable -> L37
        L29:
            r4.d(r0)
            java.lang.Object r1 = r4.b
            monitor-enter(r1)
            r0 = 1
            r4.gb = r0     // Catch: java.lang.Throwable -> L34
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            return
        L34:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L34
            throw r0
        L37:
            r1 = move-exception
            r4.d(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.d.d.hc.b():void");
    }

    private long tt() {
        if (gb()) {
            return this.u.length();
        }
        return this.c.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j) throws IOException {
        synchronized (this.b) {
            if (this.u.exists() && this.u.length() >= j) {
                Object[] objArr = new Object[3];
                this.mk.cb();
                this.mk.w();
                return;
            }
            try {
            } finally {
            }
            if (!this.c.renameTo(this.u)) {
                throw new IOException("Error renaming file " + this.c + " to " + this.u + " for completion!");
            }
            RandomAccessFile randomAccessFile = this.tc;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (!this.gb) {
                this.tc = new RandomAccessFile(this.u, "rw");
            }
            Object[] objArr2 = new Object[3];
            this.mk.w();
            this.mk.cb();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.d.d.b
    public long c() throws IOException {
        if (gb()) {
            this.hc = this.u.length();
        } else {
            synchronized (this.b) {
                int i = 0;
                do {
                    if (this.hc == -2147483648L) {
                        try {
                            hc hcVar = this.mq;
                            if (hcVar != null) {
                                this.hc = hcVar.d();
                            }
                            i += 15;
                            this.b.wait(5L);
                        } catch (InterruptedException e) {
                            com.bytedance.sdk.component.utils.mq.d(e);
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        com.bykv.vk.openvk.component.video.api.an.b.d("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.hc));
        return this.hc;
    }
}
