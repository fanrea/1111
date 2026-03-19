package com.ss.android.downloadlib.b;

import com.ss.android.d.d.hc.e;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.c.k;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b implements k {
    @Override // com.ss.android.socialbase.downloader.c.k
    public void d(com.ss.android.socialbase.downloader.h.b bVar) throws com.ss.android.socialbase.downloader.u.d {
        e eVarMk = mq.mk();
        if (bVar == null || eVarMk == null) {
            return;
        }
        File fileD = d(bVar.us(), bVar.k());
        com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
        if (hcVarD != null) {
            uo.d(hcVarD.h());
        }
        bVar.tc("application/vnd.android.package-archive");
        bVar.an(fileD.getName());
        bVar.mk((String) null);
    }

    @Override // com.ss.android.socialbase.downloader.c.k
    public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar != null) {
            return com.ss.android.d.d.an.hc.d(com.ss.android.socialbase.downloader.uo.d.d(bVar.h()), bVar.hg());
        }
        return false;
    }

    private File d(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
