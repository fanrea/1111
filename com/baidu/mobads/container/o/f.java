package com.baidu.mobads.container.o;

import com.baidu.mobads.container.util.bq;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f extends com.baidu.mobads.container.d.a {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            File file = new File(this.a.k);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                this.a.a(fileArrListFiles);
                return null;
            }
            return null;
        } catch (Exception e) {
            bq.a().a("Disk cache initialize failed for " + e.getMessage());
            return null;
        }
    }
}
