package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.aw;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nx extends t0 {
    @Override // com.qq.e.comm.plugin.aw
    public hw a(HttpURLConnection httpURLConnection) throws IOException {
        return new ox(httpURLConnection);
    }

    public nx(String str, byte[] bArr) {
        super(str, aw.a.POST, bArr);
    }

    @Override // com.qq.e.comm.plugin.t0, com.qq.e.comm.plugin.aw
    public byte[] c() throws Exception {
        return lx.c(super.c());
    }
}
