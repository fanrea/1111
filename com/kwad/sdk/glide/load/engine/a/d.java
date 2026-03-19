package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements a.InterfaceC0610a {
    private final long bVm;
    private final a bVn;

    public interface a {
        File ahf();
    }

    public d(a aVar, long j) {
        this.bVm = j;
        this.bVn = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC0610a
    public final com.kwad.sdk.glide.load.engine.a.a ahd() {
        File fileAhf = this.bVn.ahf();
        if (fileAhf == null) {
            return null;
        }
        if (fileAhf.mkdirs() || (fileAhf.exists() && fileAhf.isDirectory())) {
            return e.a(fileAhf, this.bVm);
        }
        return null;
    }
}
