package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.ky;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class my extends u0 {
    public my(HttpURLConnection httpURLConnection) throws IOException {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.u0
    public byte[] d() throws IllegalStateException, IOException {
        try {
            return ky.c(super.d());
        } catch (ky.b e) {
            e.printStackTrace();
            return null;
        }
    }
}
