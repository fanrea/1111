package io.netty.buffer;

import io.netty.util.ReferenceCounted;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface ByteBufHolder extends ReferenceCounted {
    ByteBuf content();

    ByteBufHolder copy();

    ByteBufHolder duplicate();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder retain();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder retain(int i);

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder touch();

    @Override // io.netty.util.ReferenceCounted
    ByteBufHolder touch(Object obj);
}
