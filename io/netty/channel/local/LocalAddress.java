package io.netty.channel.local;

import com.kwai.video.player.KsMediaMeta;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import io.netty.channel.Channel;
import java.net.SocketAddress;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;
    private final String id;
    private final String strVal;

    LocalAddress(Channel channel) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("local:E");
        sb.append(Long.toHexString((channel.hashCode() & C00oOOo.f362O8oO888) | KsMediaMeta.AV_CH_WIDE_RIGHT));
        sb.setCharAt(7, ':');
        this.id = sb.substring(6);
        this.strVal = sb.toString();
    }

    public LocalAddress(String str) {
        if (str == null) {
            throw new NullPointerException("id");
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.isEmpty()) {
            throw new IllegalArgumentException("empty id");
        }
        this.id = lowerCase;
        this.strVal = "local:" + lowerCase;
    }

    public final String id() {
        return this.id;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.id.equals(((LocalAddress) obj).id);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalAddress localAddress) {
        return this.id.compareTo(localAddress.id);
    }

    public final String toString() {
        return this.strVal;
    }
}
