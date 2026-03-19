package com.bykv.vk.openvk.component.video.d.d.hc;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.b.c;
import com.bykv.vk.openvk.component.video.api.u.d;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private File c;
    private Context d;
    private c hc;
    private File u;
    private volatile boolean b = false;
    private final List<d.InterfaceC0159d> an = new ArrayList();
    private volatile boolean h = false;

    public hc(Context context, c cVar) {
        this.c = null;
        this.u = null;
        this.d = context;
        this.hc = cVar;
        this.c = com.bykv.vk.openvk.component.video.d.u.b.hc(cVar.u(), cVar.w());
        this.u = com.bykv.vk.openvk.component.video.d.u.b.b(cVar.u(), cVar.w());
    }

    public void d(d.InterfaceC0159d interfaceC0159d) {
        if (this.h) {
            synchronized (d.InterfaceC0159d.class) {
                this.an.add(interfaceC0159d);
            }
            return;
        }
        this.an.add(interfaceC0159d);
        if (hc()) {
            com.bykv.vk.openvk.component.video.api.an.b.d("VideoPreload", "Cache file is exist");
            this.hc.tt(1);
            d(this.hc, 200);
            b.d(this.hc);
            return;
        }
        this.h = true;
        this.hc.tt(0);
        b();
    }

    private boolean hc() {
        if (this.u.exists()) {
            return true;
        }
        if (!this.hc.uo()) {
            if (this.c.length() >= this.hc.an()) {
                return true;
            }
            if (this.hc.hc() > 0 && this.c.length() >= this.hc.hc()) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        mq.d dVar;
        if (com.bykv.vk.openvk.component.video.api.b.b() != null) {
            dVar = com.bykv.vk.openvk.component.video.api.b.b().hc();
        } else {
            dVar = new mq.d("v_preload");
        }
        dVar.d(this.hc.rf(), TimeUnit.MILLISECONDS).hc(this.hc.jh(), TimeUnit.MILLISECONDS).b(this.hc.sy(), TimeUnit.MILLISECONDS);
        mq mqVarD = dVar.d();
        k.d dVar2 = new k.d();
        final long length = this.c.length();
        int iAn = this.hc.an();
        boolean zUo = this.hc.uo();
        int iHc = this.hc.hc();
        if (iHc > 0) {
            if (iHc >= this.hc.mq()) {
                zUo = true;
            } else {
                iAn = iHc;
            }
        }
        if (zUo) {
            dVar2.d("RANGE", "bytes=" + length + "-").d(this.hc.cb()).d().hc();
        } else {
            dVar2.d("RANGE", "bytes=" + length + "-" + iAn).d(this.hc.cb()).d().hc();
        }
        mqVarD.d(dVar2.hc()).d(new com.bytedance.sdk.component.hc.d.b() { // from class: com.bykv.vk.openvk.component.video.d.d.hc.hc.1
            @Override // com.bytedance.sdk.component.hc.d.b
            public void onFailure(com.bytedance.sdk.component.hc.d.hc hcVar, IOException iOException) {
                hc hcVar2 = hc.this;
                hcVar2.d(hcVar2.hc, 601, iOException.getMessage());
                b.d(hc.this.hc);
            }

            /* JADX WARN: Code restructure failed: missing block: B:36:0x0113, code lost:
            
                r0 = r22.hc;
                r0.hc(r0.hc, r24.b());
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x0120, code lost:
            
                r22.hc.d(r6);
                r22.hc.d(r5);
                r22.hc.d(r15);
                r22.hc.d(r24);
                r0 = new java.lang.Object[4];
                r0[r14] = "Pre finally ";
                r0[1] = r22.hc.hc.cb();
                r0[2] = " Preload size=";
                r0[3] = java.lang.Integer.valueOf(r22.hc.hc.an());
                com.bykv.vk.openvk.component.video.api.an.b.d("VideoPreload", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x0188, code lost:
            
                r12 = r15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x0193, code lost:
            
                if (r22.hc.hc.uo() == false) goto L56;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x01a1, code lost:
            
                if (r18 != r22.hc.c.length()) goto L56;
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x01a3, code lost:
            
                r22.hc.u();
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x01a8, code lost:
            
                r0 = r22.hc;
                r0.d(r0.hc, r24.b());
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x01b5, code lost:
            
                r13 = r6;
             */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0237 A[Catch: all -> 0x0281, TryCatch #1 {all -> 0x0281, blocks: (B:81:0x0227, B:83:0x0237, B:84:0x023b), top: B:91:0x0227 }] */
            @Override // com.bytedance.sdk.component.hc.d.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.hc.d.hc r23, com.bytedance.sdk.component.hc.d.cb r24) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 713
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.d.hc.hc.AnonymousClass1.onResponse(com.bytedance.sdk.component.hc.d.hc, com.bytedance.sdk.component.hc.d.cb):void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public c d() {
        return this.hc;
    }

    public void d(boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar, int i) {
        synchronized (d.InterfaceC0159d.class) {
            for (d.InterfaceC0159d interfaceC0159d : this.an) {
                if (interfaceC0159d != null) {
                    interfaceC0159d.d(cVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(c cVar, int i, String str) {
        synchronized (d.InterfaceC0159d.class) {
            for (d.InterfaceC0159d interfaceC0159d : this.an) {
                if (interfaceC0159d != null) {
                    interfaceC0159d.d(cVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(c cVar, int i) {
        synchronized (d.InterfaceC0159d.class) {
            for (d.InterfaceC0159d interfaceC0159d : this.an) {
                if (interfaceC0159d != null) {
                    interfaceC0159d.hc(cVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            this.u.delete();
            this.c.delete();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (this.c.renameTo(this.u)) {
            } else {
                throw new IOException("Error renaming file " + this.c + " to " + this.u + " for completion!");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            com.bykv.vk.openvk.component.video.api.an.b.d("VideoPreload", th.getMessage());
        }
    }
}
