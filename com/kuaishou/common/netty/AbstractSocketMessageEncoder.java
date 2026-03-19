package com.kuaishou.common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

@ChannelHandler.Sharable
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractSocketMessageEncoder<T> extends MessageToByteEncoder<T> {
    public abstract byte[] toByteArray(T t);

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, T t, ByteBuf byteBuf) {
        SocketMessageEncoderUtil.write(toByteArray(t), byteBuf);
    }
}
