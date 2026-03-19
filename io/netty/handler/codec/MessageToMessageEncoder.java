package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class MessageToMessageEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i, List<Object> list);

    protected MessageToMessageEncoder() {
        this.matcher = TypeParameterMatcher.find(this, MessageToMessageEncoder.class, "I");
    }

    protected MessageToMessageEncoder(Class<? extends I> cls) {
        this.matcher = TypeParameterMatcher.get(cls);
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.matcher.match(obj);
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        boolean z;
        RecyclableArrayList recyclableArrayList = null;
        int i = 0;
        try {
            try {
                if (acceptOutboundMessage(obj)) {
                    try {
                        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance();
                        try {
                            encode(channelHandlerContext, obj, recyclableArrayListNewInstance);
                            ReferenceCountUtil.release(obj);
                            if (recyclableArrayListNewInstance.isEmpty()) {
                                recyclableArrayListNewInstance.recycle();
                                throw new EncoderException(StringUtil.simpleClassName(this) + " must produce at least one message.");
                            }
                            recyclableArrayList = recyclableArrayListNewInstance;
                        } catch (Throwable th) {
                            ReferenceCountUtil.release(obj);
                            throw th;
                        }
                    } catch (EncoderException e) {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        throw new EncoderException(th);
                    }
                } else {
                    channelHandlerContext.write(obj, channelPromise);
                }
                if (recyclableArrayList != null) {
                    int size = recyclableArrayList.size() - 1;
                    if (size == 0) {
                        channelHandlerContext.write(recyclableArrayList.get(0), channelPromise);
                    } else if (size > 0) {
                        ChannelPromise channelPromiseVoidPromise = channelHandlerContext.voidPromise();
                        z = channelPromise == channelPromiseVoidPromise;
                        while (i < size) {
                            channelHandlerContext.write(recyclableArrayList.get(i), z ? channelPromiseVoidPromise : channelHandlerContext.newPromise());
                            i++;
                        }
                        channelHandlerContext.write(recyclableArrayList.get(size), channelPromise);
                    }
                    recyclableArrayList.recycle();
                }
            } catch (EncoderException e2) {
                throw e2;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            if (0 != 0) {
                int size2 = recyclableArrayList.size() - 1;
                if (size2 == 0) {
                    channelHandlerContext.write(recyclableArrayList.get(0), channelPromise);
                } else if (size2 > 0) {
                    ChannelPromise channelPromiseVoidPromise2 = channelHandlerContext.voidPromise();
                    z = channelPromise == channelPromiseVoidPromise2;
                    while (i < size2) {
                        channelHandlerContext.write(recyclableArrayList.get(i), z ? channelPromiseVoidPromise2 : channelHandlerContext.newPromise());
                        i++;
                    }
                    channelHandlerContext.write(recyclableArrayList.get(size2), channelPromise);
                }
                recyclableArrayList.recycle();
            }
            throw th4;
        }
    }
}
