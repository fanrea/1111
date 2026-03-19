package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.lx;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ox extends u0 {
    public ox(HttpURLConnection httpURLConnection) throws IOException {
        super(httpURLConnection);
    }

    @Override // com.qq.e.comm.plugin.u0
    public byte[] d() throws IllegalStateException, IOException {
        try {
            return lx.d(super.d());
        } catch (lx.d e) {
            e.printStackTrace();
            return null;
        }
    }
}
