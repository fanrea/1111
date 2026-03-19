package com.qq.e.comm.plugin;

import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qe implements mo {
    private final File a;
    private String b;

    @Override // com.qq.e.comm.plugin.mo
    public synchronized jv a() throws IOException {
        return new se(this.a, this.b);
    }

    public qe(File file, String str) {
        this.a = file;
        this.b = str;
    }
}
