package com.apm.insight.n;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class n extends b {
    private final ByteArrayOutputStream f;
    private final String g;
    private final Map<String, String> h;

    public n(String str, String str2, Map<String, String> map, boolean z) {
        super(str, str2, map, z);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        this.f = byteArrayOutputStream;
        HashMap map2 = new HashMap();
        this.h = map2;
        this.g = str;
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        map2.put("Content-Type", "multipart/form-data; boundary=" + this.a);
        if (!z) {
            this.d = new g(byteArrayOutputStream);
        } else {
            this.e = new r(byteArrayOutputStream);
            map2.put("Content-Encoding", "gzip");
        }
    }

    @Override // com.apm.insight.n.b, com.apm.insight.n.j
    public String a() throws IOException {
        super.a();
        try {
            String str = new String(com.apm.insight.g.p().post(this.g, this.f.toByteArray(), this.h).getResponseBytes());
            com.apm.insight.o.l.a(this.f);
            return str;
        } catch (Throwable unused) {
            com.apm.insight.o.l.a(this.f);
            return "error";
        }
    }
}
