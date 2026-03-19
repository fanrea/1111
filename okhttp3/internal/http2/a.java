package okhttp3.internal.http2;

import com.baidu.mobads.container.util.bu;
import okio.ByteString;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    public static final ByteString Bm = ByteString.encodeUtf8(":");
    public static final ByteString Bn = ByteString.encodeUtf8(Header.RESPONSE_STATUS_UTF8);
    public static final ByteString Bo = ByteString.encodeUtf8(Header.TARGET_METHOD_UTF8);
    public static final ByteString Bp = ByteString.encodeUtf8(Header.TARGET_PATH_UTF8);
    public static final ByteString Bq = ByteString.encodeUtf8(Header.TARGET_SCHEME_UTF8);
    public static final ByteString Br = ByteString.encodeUtf8(Header.TARGET_AUTHORITY_UTF8);
    public final ByteString Bs;
    public final ByteString Bt;
    final int Bu;

    public a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.Bs = byteString;
        this.Bt = byteString2;
        this.Bu = byteString.size() + 32 + byteString2.size();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.Bs.equals(aVar.Bs) && this.Bt.equals(aVar.Bt)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.Bs.hashCode() + bu.g) * 31) + this.Bt.hashCode();
    }

    public final String toString() {
        return okhttp3.internal.c.format("%s: %s", this.Bs.utf8(), this.Bt.utf8());
    }
}
