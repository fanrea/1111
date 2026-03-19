package com.kuaishou.common.netty.handler;

import com.google.protobuf.nano.MessageNano;
import io.netty.channel.ChannelHandlerContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface NanoPayloadHandler<T extends MessageNano> {
    void handle(ChannelHandlerContext channelHandlerContext, T t);
}
