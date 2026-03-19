package io.netty.channel.embedded;

import io.netty.channel.ChannelId;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class EmbeddedChannelId implements ChannelId {
    static final ChannelId INSTANCE = new EmbeddedChannelId();
    private static final long serialVersionUID = -251711922203466130L;

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "embedded";
    }

    private EmbeddedChannelId() {
    }

    @Override // io.netty.channel.ChannelId
    public final String asShortText() {
        return toString();
    }

    @Override // io.netty.channel.ChannelId
    public final String asLongText() {
        return toString();
    }

    @Override // java.lang.Comparable
    public final int compareTo(ChannelId channelId) {
        if (channelId instanceof EmbeddedChannelId) {
            return 0;
        }
        return asLongText().compareTo(channelId.asLongText());
    }

    public final boolean equals(Object obj) {
        return obj instanceof EmbeddedChannelId;
    }
}
