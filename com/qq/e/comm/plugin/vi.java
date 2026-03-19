package com.qq.e.comm.plugin;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class vi extends si {
    vi(pe peVar, String str) {
        super(peVar, str);
    }

    @Override // com.qq.e.comm.plugin.uu
    protected void c() throws InterruptedException, vu {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new vu("Error waiting cache", e);
        }
    }

    @Override // com.qq.e.comm.plugin.uu
    protected void a() throws vu {
        if (this.f.g()) {
            throw new vu("download error when checkDownloadError", new Throwable("HttpRangeResultProxyCache"));
        }
    }

    @Override // com.qq.e.comm.plugin.si, com.qq.e.comm.plugin.uu
    protected void a(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }
}
