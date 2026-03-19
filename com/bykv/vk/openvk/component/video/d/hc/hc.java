package com.bykv.vk.openvk.component.video.d.hc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.d.hc.gb;
import com.bykv.vk.openvk.component.video.d.hc.mq;
import com.bykv.vk.openvk.component.video.d.hc.tt;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class hc extends com.bykv.vk.openvk.component.video.d.hc.d {
    private final InterfaceC0164hc cb;
    private final int e;
    final Object k;
    final Object uo;
    private volatile gb.d w;
    private volatile com.bykv.vk.openvk.component.video.d.hc.b.hc yo;

    /* renamed from: com.bykv.vk.openvk.component.video.d.hc.hc$hc, reason: collision with other inner class name */
    public interface InterfaceC0164hc {
        void d(hc hcVar);
    }

    hc(d dVar) {
        super(dVar.c, dVar.u);
        this.e = dVar.h;
        this.cb = dVar.tt;
        this.uo = this;
        this.h = dVar.d;
        this.gb = dVar.hc;
        this.an = dVar.an;
        this.tc = dVar.b;
        this.tt = dVar.gb;
        this.k = dVar.tc;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.d(this.gb);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            tc();
        } catch (Throwable unused) {
        }
        this.c.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.d.hc(this.gb);
        InterfaceC0164hc interfaceC0164hc = this.cb;
        if (interfaceC0164hc != null) {
            interfaceC0164hc.d(this);
        }
    }

    gb.d gb() {
        return this.w;
    }

    com.bykv.vk.openvk.component.video.d.hc.b.hc tt() {
        return this.yo;
    }

    private boolean tc() throws com.bykv.vk.openvk.component.video.d.hc.b.d {
        while (this.tc.d()) {
            u();
            mq.d dVarHc = this.tc.hc();
            try {
                d(dVarHc);
                return true;
            } catch (com.bykv.vk.openvk.component.video.d.hc.b.b unused) {
                dVarHc.d();
                Boolean.valueOf(h());
                String str = this.h;
            } catch (com.bykv.vk.openvk.component.video.d.hc.b.hc e) {
                this.yo = e;
                return false;
            } catch (gb.d e2) {
                this.w = e2;
                Boolean.valueOf(h());
                String str2 = this.h;
                return false;
            } catch (IOException e3) {
                if (e3 instanceof SocketTimeoutException) {
                    dVarHc.hc();
                }
                if (!hc()) {
                    Boolean.valueOf(h());
                    String str3 = this.h;
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
    
        b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ce, code lost:
    
        if (com.bykv.vk.openvk.component.video.d.hc.u.b == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d0, code lost:
    
        com.bytedance.sdk.component.utils.mq.d("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d7, code lost:
    
        com.bykv.vk.openvk.component.video.d.b.d.d(r6.c());
        r4.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.bykv.vk.openvk.component.video.d.hc.mq.d r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.hc.hc.d(com.bykv.vk.openvk.component.video.d.hc.mq$d):void");
    }

    static final class d {
        List<tt.hc> an;
        mq b;
        com.bykv.vk.openvk.component.video.d.hc.d.d c;
        String d;
        tt gb;
        int h;
        String hc;
        Object tc;
        InterfaceC0164hc tt;
        com.bykv.vk.openvk.component.video.d.hc.hc.b u;

        d() {
        }

        d d(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.d = str;
            return this;
        }

        d hc(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.hc = str;
            return this;
        }

        d d(mq mqVar) {
            if (mqVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.b = mqVar;
            return this;
        }

        d d(com.bykv.vk.openvk.component.video.d.hc.d.d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.c = dVar;
            return this;
        }

        d d(com.bykv.vk.openvk.component.video.d.hc.hc.b bVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.u = bVar;
            return this;
        }

        d d(List<tt.hc> list) {
            this.an = list;
            return this;
        }

        d d(int i) {
            this.h = i;
            return this;
        }

        d d(InterfaceC0164hc interfaceC0164hc) {
            this.tt = interfaceC0164hc;
            return this;
        }

        d d(tt ttVar) {
            this.gb = ttVar;
            return this;
        }

        d d(Object obj) {
            this.tc = obj;
            return this;
        }

        hc d() {
            if (this.c == null || this.u == null || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.hc) || this.b == null) {
                throw new IllegalArgumentException();
            }
            return new hc(this);
        }
    }
}
