package com.kuaishou.common.netty.client;

import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.common.netty.client.handler.ClientNanoPayloadHandlers;
import com.kuaishou.common.netty.handler.NanoPayloadHandler;
import com.kuaishou.socket.nano.SocketMessages;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ChannelHandler extends SimpleChannelInboundHandler<SocketMessages.SocketMessage> {
    private volatile Channel channel;
    private InactiveListener inactiveListener;
    private ChannelErrorListener mChannelErrorListener;
    private ClientNanoPayloadHandlers mPayloadHandlers;

    public interface ChannelErrorListener {
        void onChannelError(Throwable th);
    }

    public interface InactiveListener {
        void onChannelInactive(ChannelHandlerContext channelHandlerContext);
    }

    public ChannelHandler() {
        super(false);
        this.mPayloadHandlers = new ClientNanoPayloadHandlers();
    }

    public ChannelFuture sendMessage(MessageNano messageNano) {
        return this.channel.writeAndFlush(messageNano);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        this.channel = channelHandlerContext.channel();
    }

    @Override // io.netty.channel.SimpleChannelInboundHandler
    public void channelRead0(ChannelHandlerContext channelHandlerContext, SocketMessages.SocketMessage socketMessage) {
        NanoPayloadHandler<MessageNano> handler = this.mPayloadHandlers.getHandler(Integer.valueOf(socketMessage.payloadType));
        if (handler != null) {
            handler.handle(channelHandlerContext, NanoSocketMessageUtil.unpack(socketMessage));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        super.channelInactive(channelHandlerContext);
        channelHandlerContext.close();
        InactiveListener inactiveListener = this.inactiveListener;
        if (inactiveListener != null) {
            inactiveListener.onChannelInactive(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.close();
        ChannelErrorListener channelErrorListener = this.mChannelErrorListener;
        if (channelErrorListener != null) {
            channelErrorListener.onChannelError(th);
        }
    }

    public void setChannelErrorListener(ChannelErrorListener channelErrorListener) {
        this.mChannelErrorListener = channelErrorListener;
    }

    public ChannelErrorListener getChannelErrorListener() {
        return this.mChannelErrorListener;
    }

    public InactiveListener getInactiveListener() {
        return this.inactiveListener;
    }

    public ChannelHandler setInactiveListener(InactiveListener inactiveListener) {
        this.inactiveListener = inactiveListener;
        return this;
    }

    public ClientNanoPayloadHandlers getPayloadHandlers() {
        return this.mPayloadHandlers;
    }
}
