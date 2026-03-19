package aegon.chrome.net.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public @interface UrlRequestError {
    public static final int ADDRESS_UNREACHABLE = 9;
    public static final int CONNECTION_CLOSED = 5;
    public static final int CONNECTION_REFUSED = 7;
    public static final int CONNECTION_RESET = 8;
    public static final int CONNECTION_TIMED_OUT = 6;
    public static final int HOSTNAME_NOT_RESOLVED = 1;
    public static final int INTERNET_DISCONNECTED = 2;
    public static final int LISTENER_EXCEPTION_THROWN = 0;
    public static final int NETWORK_CHANGED = 3;
    public static final int OTHER = 11;
    public static final int QUIC_PROTOCOL_FAILED = 10;
    public static final int TIMED_OUT = 4;
}
