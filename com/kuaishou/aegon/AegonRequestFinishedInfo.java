package com.kuaishou.aegon;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AegonRequestFinishedInfo {
    public String aegonVersion;
    public long bodyRecvCostMs;
    public boolean cached;
    public int clientHellos;
    public long connectionCostMs;
    public String consumer;
    public String contentEncoding;
    public long dnsCostMs;
    public int errCode;
    public String extraInfo;
    public long headerRecvCostMs;
    public int httpCode;
    public boolean ipv6Reachable;
    public String method;
    public int netType;
    public String protocol;
    public int quicBroken;
    public int quicBrokenError;
    public long receivedBytes;
    public long redirectCostMs;
    public long requestSendCostMs;
    public long sentBytes;
    public boolean socketReused;
    public long sslCostMs;
    public int sslHandshakeType;
    public long tcpCostMs;
    public long totalCostMs;
    public String url;
    public boolean viaIpv6;
    public boolean viaProxy;
    public long waitingCostMs;

    public AegonRequestFinishedInfo(int i, String str, String str2, int i2, boolean z, String str3, String str4, boolean z2, int i3, String str5, long j, long j2, boolean z3, String str6, boolean z4, boolean z5, int i4, int i5, int i6, int i7, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, String str7) {
        this.errCode = i;
        this.url = str;
        this.method = str2;
        this.netType = i2;
        this.ipv6Reachable = z;
        this.consumer = str3;
        this.aegonVersion = str4;
        this.cached = z2;
        this.httpCode = i3;
        this.protocol = str5;
        this.receivedBytes = j;
        this.sentBytes = j2;
        this.viaProxy = z3;
        this.contentEncoding = str6;
        this.viaIpv6 = z4;
        this.socketReused = z5;
        this.sslHandshakeType = i4;
        this.quicBroken = i5;
        this.quicBrokenError = i6;
        this.clientHellos = i7;
        this.dnsCostMs = j3;
        this.tcpCostMs = j4;
        this.sslCostMs = j5;
        this.connectionCostMs = j6;
        this.requestSendCostMs = j7;
        this.waitingCostMs = j8;
        this.headerRecvCostMs = j9;
        this.redirectCostMs = j10;
        this.bodyRecvCostMs = j11;
        this.totalCostMs = j12;
        this.extraInfo = str7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("errCode : ").append(this.errCode).append("\n");
        sb.append("url : ").append(this.url).append("\n");
        sb.append("method : ").append(this.method).append("\n");
        sb.append("netType : ").append(this.netType).append("\n");
        sb.append("ipv6Reachable : ").append(this.ipv6Reachable).append("\n");
        sb.append("consumer : ").append(this.consumer).append("\n");
        sb.append("aegonVersion : ").append(this.aegonVersion).append("\n");
        sb.append("cached : ").append(this.cached).append("\n");
        sb.append("httpCode : ").append(this.httpCode).append("\n");
        sb.append("protocol : ").append(this.protocol).append("\n");
        sb.append("receivedBytes : ").append(this.receivedBytes).append("\n");
        sb.append("sentBytes : ").append(this.sentBytes).append("\n");
        sb.append("viaProxy : ").append(this.viaProxy).append("\n");
        sb.append("contentEncoding : ").append(this.contentEncoding).append("\n");
        sb.append("viaIpv6 : ").append(this.viaIpv6).append("\n");
        sb.append("socketReused : ").append(this.socketReused).append("\n");
        sb.append("sslHandshakeType : ").append(this.sslHandshakeType).append("\n");
        sb.append("quicBroken : ").append(this.quicBroken).append("\n");
        sb.append("quicBrokenError : ").append(this.quicBrokenError).append("\n");
        sb.append("clientHellos : ").append(this.clientHellos).append("\n");
        sb.append("dnsCostMs : ").append(this.dnsCostMs).append("\n");
        sb.append("tcpCostMs : ").append(this.tcpCostMs).append("\n");
        sb.append("sslCostMs : ").append(this.sslCostMs).append("\n");
        sb.append("connectionCostMs : ").append(this.connectionCostMs).append("\n");
        sb.append("requestSendCostMs : ").append(this.requestSendCostMs).append("\n");
        sb.append("waitingCostMs : ").append(this.waitingCostMs).append("\n");
        sb.append("headerRecvCostMs : ").append(this.headerRecvCostMs).append("\n");
        sb.append("redirectCostMs : ").append(this.redirectCostMs).append("\n");
        sb.append("bodyRecvCostMs : ").append(this.bodyRecvCostMs).append("\n");
        sb.append("totalCostMs : ").append(this.totalCostMs).append("\n");
        sb.append("extraInfo : ").append(this.extraInfo).append("}\n");
        return sb.toString();
    }
}
