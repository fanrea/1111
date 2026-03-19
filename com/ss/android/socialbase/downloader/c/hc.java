package com.ss.android.socialbase.downloader.c;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class hc implements np {
    private boolean d = false;

    @Override // com.ss.android.socialbase.downloader.c.np
    public void d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.d = true;
    }

    @Override // com.ss.android.socialbase.downloader.c.np
    public boolean d() {
        return this.d;
    }
}
