package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.aw;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cu extends t0 {
    @Override // com.qq.e.comm.plugin.aw
    public hw a(HttpURLConnection httpURLConnection) throws IOException {
        return new du(httpURLConnection);
    }

    public cu(String str, aw.a aVar) {
        super(str, aVar, (byte[]) null);
    }

    public cu(String str, aw.a aVar, byte[] bArr) {
        super(str, aVar, bArr);
    }

    public cu(String str, Map<String, String> map, aw.a aVar) {
        super(str, map, aVar);
    }
}
