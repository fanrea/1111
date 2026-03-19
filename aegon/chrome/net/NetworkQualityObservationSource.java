package aegon.chrome.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public @interface NetworkQualityObservationSource {
    public static final int DEFAULT_HTTP_FROM_PLATFORM = 4;
    public static final int DEFAULT_TRANSPORT_FROM_PLATFORM = 7;
    public static final int DEPRECATED_HTTP_EXTERNAL_ESTIMATE = 5;
    public static final int H2_PINGS = 8;
    public static final int HTTP = 0;
    public static final int HTTP_CACHED_ESTIMATE = 3;
    public static final int MAX = 9;
    public static final int QUIC = 2;
    public static final int TCP = 1;
    public static final int TRANSPORT_CACHED_ESTIMATE = 6;
}
