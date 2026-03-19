package ca.da.ca.ja;

import java.util.UUID;

/* compiled from: RequestIdGenerator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class o {
    public static ca.da.ca.ja.a<String> a = new a();

    /* compiled from: RequestIdGenerator.java */
    public static class a extends ca.da.ca.ja.a<String> {
        @Override // ca.da.ca.ja.a
        public String a(Object[] objArr) {
            return UUID.randomUUID().toString();
        }
    }
}
