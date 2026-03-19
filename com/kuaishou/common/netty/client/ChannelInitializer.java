package com.kuaishou.common.netty.client;

import com.kuaishou.common.netty.NanoSocketMessageDecoder;
import com.kuaishou.common.netty.NanoSocketMessageEncoder;
import com.kuaishou.common.netty.function.Supplier;
import com.kuaishou.socket.nano.SocketMessages;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ChannelInitializer extends io.netty.channel.ChannelInitializer<SocketChannel> {
    private NanoSocketMessageEncoder encoder;
    private Supplier<SimpleChannelInboundHandler<SocketMessages.SocketMessage>> msgHandlerFactory;

    public ChannelInitializer(Supplier<SimpleChannelInboundHandler<SocketMessages.SocketMessage>> supplier) {
        this.encoder = new NanoSocketMessageEncoder();
        this.msgHandlerFactory = supplier;
    }

    public ChannelInitializer() {
        this(new Supplier<SimpleChannelInboundHandler<SocketMessages.SocketMessage>>() { // from class: com.kuaishou.common.netty.client.ChannelInitializer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.kuaishou.common.netty.function.Supplier
            public SimpleChannelInboundHandler<SocketMessages.SocketMessage> get() {
                return new ChannelHandler();
            }
        });
    }

    @Override // io.netty.channel.ChannelInitializer
    public void initChannel(SocketChannel socketChannel) {
        ChannelPipeline channelPipelinePipeline = socketChannel.pipeline();
        channelPipelinePipeline.addLast(new NanoSocketMessageDecoder());
        channelPipelinePipeline.addLast(this.encoder);
        channelPipelinePipeline.addLast(this.msgHandlerFactory.get());
    }
}
