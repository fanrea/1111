package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class CompatibleObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final AttributeKey<ObjectOutputStream> OOS = AttributeKey.valueOf(CompatibleObjectEncoder.class, "OOS");
    private final int resetInterval;
    private int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    public CompatibleObjectEncoder(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("resetInterval: " + i);
        }
        this.resetInterval = i;
    }

    protected ObjectOutputStream newObjectOutputStream(OutputStream outputStream) {
        return new ObjectOutputStream(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Serializable serializable, ByteBuf byteBuf) {
        Attribute attributeAttr = channelHandlerContext.attr(OOS);
        ObjectOutputStream objectOutputStreamNewObjectOutputStream = (ObjectOutputStream) attributeAttr.get();
        if (objectOutputStreamNewObjectOutputStream == null) {
            objectOutputStreamNewObjectOutputStream = newObjectOutputStream(new ByteBufOutputStream(byteBuf));
            ObjectOutputStream objectOutputStream = (ObjectOutputStream) attributeAttr.setIfAbsent(objectOutputStreamNewObjectOutputStream);
            if (objectOutputStream != null) {
                objectOutputStreamNewObjectOutputStream = objectOutputStream;
            }
        }
        synchronized (objectOutputStreamNewObjectOutputStream) {
            if (this.resetInterval != 0) {
                this.writtenObjects++;
                if (this.writtenObjects % this.resetInterval == 0) {
                    objectOutputStreamNewObjectOutputStream.reset();
                }
            }
            objectOutputStreamNewObjectOutputStream.writeObject(serializable);
            objectOutputStreamNewObjectOutputStream.flush();
        }
    }
}
