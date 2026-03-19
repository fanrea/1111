package android.support.v4.b;

import android.support.v4.d.j;
import android.util.Base64;
import com.alipay.sdk.m.u.i;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    private final String aM;
    private final String aN;
    private final List<List<byte[]>> aO;
    private final int aP = 0;
    private final String aQ;
    private final String mQuery;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.aM = (String) j.checkNotNull(str);
        this.aN = (String) j.checkNotNull(str2);
        this.mQuery = (String) j.checkNotNull(str3);
        this.aO = (List) j.checkNotNull(list);
        this.aQ = this.aM + "-" + this.aN + "-" + this.mQuery;
    }

    public final String getProviderAuthority() {
        return this.aM;
    }

    public final String getProviderPackage() {
        return this.aN;
    }

    public final String getQuery() {
        return this.mQuery;
    }

    public final List<List<byte[]>> getCertificates() {
        return this.aO;
    }

    public final int E() {
        return this.aP;
    }

    public final String getIdentifier() {
        return this.aQ;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.aM + ", mProviderPackage: " + this.aN + ", mQuery: " + this.mQuery + ", mCertificates:");
        for (int i = 0; i < this.aO.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.aO.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append(i.d);
        sb.append("mCertificatesArray: " + this.aP);
        return sb.toString();
    }
}
