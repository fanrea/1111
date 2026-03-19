package com.dhylive.app.net;

import com.kuaishou.android.live.network.ApiStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NetError.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/dhylive/app/net/NetError;", "", "code", "", "msg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "UNKNOWN", "NET_ERROR", "CONVERT_ERROR", "DATA_NULL", "TIMEOUT_ERROR", "NET_CONNECT_ERROR", "HTTP_ERROR", "SSL_ERROR", "CANCEL", "NET_NOT_CONNECTED", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class NetError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetError[] $VALUES;
    private final int code;
    private final String msg;
    public static final NetError UNKNOWN = new NetError("UNKNOWN", 0, -1, "未知错误");
    public static final NetError NET_ERROR = new NetError("NET_ERROR", 1, -100, "网络异常");
    public static final NetError CONVERT_ERROR = new NetError("CONVERT_ERROR", 2, aegon.chrome.net.NetError.ERR_CONNECTION_RESET, "数据转换异常");
    public static final NetError DATA_NULL = new NetError("DATA_NULL", 3, -201, "数据为空");
    public static final NetError TIMEOUT_ERROR = new NetError("TIMEOUT_ERROR", 4, aegon.chrome.net.NetError.ERR_CONNECTION_REFUSED, "请求超时");
    public static final NetError NET_CONNECT_ERROR = new NetError("NET_CONNECT_ERROR", 5, -103, "网络连接异常");
    public static final NetError HTTP_ERROR = new NetError("HTTP_ERROR", 6, -104, "HTTP Code:");
    public static final NetError SSL_ERROR = new NetError("SSL_ERROR", 7, -105, "证书出错");
    public static final NetError CANCEL = new NetError("CANCEL", 8, -106, "请求取消");
    public static final NetError NET_NOT_CONNECTED = new NetError("NET_NOT_CONNECTED", 9, ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "网络未连接");

    private static final /* synthetic */ NetError[] $values() {
        return new NetError[]{UNKNOWN, NET_ERROR, CONVERT_ERROR, DATA_NULL, TIMEOUT_ERROR, NET_CONNECT_ERROR, HTTP_ERROR, SSL_ERROR, CANCEL, NET_NOT_CONNECTED};
    }

    public static EnumEntries<NetError> getEntries() {
        return $ENTRIES;
    }

    public static NetError valueOf(String str) {
        return (NetError) Enum.valueOf(NetError.class, str);
    }

    public static NetError[] values() {
        return (NetError[]) $VALUES.clone();
    }

    private NetError(String str, int i, int i2, String str2) {
        this.code = i2;
        this.msg = str2;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    static {
        NetError[] netErrorArr$values = $values();
        $VALUES = netErrorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(netErrorArr$values);
    }
}
