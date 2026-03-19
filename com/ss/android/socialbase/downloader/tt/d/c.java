package com.ss.android.socialbase.downloader.tt.d;

import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.h.u;
import com.ss.android.socialbase.downloader.tt.tt;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements tt {
    private InputStream an;
    private tt b;
    private boolean c;
    protected final Object d;
    private final List<u> hc;
    private long u;

    public boolean d(int i) {
        return i >= 200 && i < 300;
    }

    public void u() throws InterruptedException {
        synchronized (this.d) {
            if (this.c && this.b == null) {
                this.d.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.tt.tt
    public InputStream d() throws IOException {
        InputStream inputStream = this.an;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.tt.tt
    public void c() {
        tt ttVar = this.b;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.tt.h
    public String d(String str) {
        tt ttVar = this.b;
        if (ttVar != null) {
            return ttVar.d(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.tt.h
    public int hc() throws IOException {
        tt ttVar = this.b;
        if (ttVar != null) {
            return ttVar.hc();
        }
        return 0;
    }

    public List<u> an() {
        return this.hc;
    }

    @Override // com.ss.android.socialbase.downloader.tt.h
    public void b() {
        tt ttVar = this.b;
        if (ttVar != null) {
            ttVar.b();
        }
    }

    public boolean h() {
        try {
            tt ttVar = this.b;
            if (ttVar != null) {
                return d(ttVar.hc());
            }
            return false;
        } catch (IOException e) {
            mq.d(e);
            return false;
        }
    }

    public boolean gb() {
        return System.currentTimeMillis() - this.u < hc.d;
    }
}
