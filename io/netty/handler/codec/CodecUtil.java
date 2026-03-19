package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerAdapter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class CodecUtil {
    static void ensureNotSharable(ChannelHandlerAdapter channelHandlerAdapter) {
        if (channelHandlerAdapter.isSharable()) {
            throw new IllegalStateException("@Sharable annotation is not allowed");
        }
    }

    private CodecUtil() {
    }
}
