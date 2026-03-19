package lkxssdk.n;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class j {
    public final String a;
    public Map<k, Object> b;

    public j(String str, byte[] bArr, int i, l[] lVarArr, a aVar, long j) {
        this.a = str;
        this.b = null;
    }

    public j(String str, byte[] bArr, l[] lVarArr, a aVar, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, lVarArr, aVar, j);
    }

    public void a(k kVar, Object obj) {
        if (this.b == null) {
            this.b = new EnumMap(k.class);
        }
        this.b.put(kVar, obj);
    }

    public String toString() {
        return this.a;
    }
}
