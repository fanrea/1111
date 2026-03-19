package io.netty.handler.codec.json;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class JsonObjectDecoder extends ByteToMessageDecoder {
    private static final int ST_CORRUPTED = -1;
    private static final int ST_DECODING_ARRAY_STREAM = 2;
    private static final int ST_DECODING_NORMAL = 1;
    private static final int ST_INIT = 0;
    private int idx;
    private boolean insideString;
    private final int maxObjectLength;
    private int openBraces;
    private int state;
    private final boolean streamArrayElements;

    public JsonObjectDecoder() {
        this(1048576);
    }

    public JsonObjectDecoder(int i) {
        this(i, false);
    }

    public JsonObjectDecoder(boolean z) {
        this(1048576, z);
    }

    public JsonObjectDecoder(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxObjectLength must be a positive int");
        }
        this.maxObjectLength = i;
        this.streamArrayElements = z;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (this.state == -1) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int i = this.idx;
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex > this.maxObjectLength) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            reset();
            throw new TooLongFrameException("object length exceeds " + this.maxObjectLength + ": " + iWriterIndex + " bytes discarded");
        }
        while (i < iWriterIndex) {
            byte b = byteBuf.getByte(i);
            int i2 = this.state;
            if (i2 == 1) {
                decodeByte(b, byteBuf, i);
                if (this.openBraces == 0) {
                    int i3 = i + 1;
                    ByteBuf byteBufExtractObject = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), i3 - byteBuf.readerIndex());
                    if (byteBufExtractObject != null) {
                        list.add(byteBufExtractObject);
                    }
                    byteBuf.readerIndex(i3);
                    reset();
                }
            } else if (i2 == 2) {
                decodeByte(b, byteBuf, i);
                if (!this.insideString && ((this.openBraces == 1 && b == 44) || (this.openBraces == 0 && b == 93))) {
                    for (int i4 = byteBuf.readerIndex(); Character.isWhitespace(byteBuf.getByte(i4)); i4++) {
                        byteBuf.skipBytes(1);
                    }
                    int i5 = i - 1;
                    while (i5 >= byteBuf.readerIndex() && Character.isWhitespace(byteBuf.getByte(i5))) {
                        i5--;
                    }
                    ByteBuf byteBufExtractObject2 = extractObject(channelHandlerContext, byteBuf, byteBuf.readerIndex(), (i5 + 1) - byteBuf.readerIndex());
                    if (byteBufExtractObject2 != null) {
                        list.add(byteBufExtractObject2);
                    }
                    byteBuf.readerIndex(i + 1);
                    if (b == 93) {
                        reset();
                    }
                }
            } else if (b == 123 || b == 91) {
                initDecoding(b);
                if (this.state == 2) {
                    byteBuf.skipBytes(1);
                }
            } else if (Character.isWhitespace(b)) {
                byteBuf.skipBytes(1);
            } else {
                this.state = -1;
                throw new CorruptedFrameException("invalid JSON received at byte position " + i + ": " + ByteBufUtil.hexDump(byteBuf));
            }
            i++;
        }
        if (byteBuf.readableBytes() == 0) {
            this.idx = 0;
        } else {
            this.idx = i;
        }
    }

    protected ByteBuf extractObject(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.slice(i, i2).retain();
    }

    private void decodeByte(byte b, ByteBuf byteBuf, int i) {
        if ((b == 123 || b == 91) && !this.insideString) {
            this.openBraces++;
            return;
        }
        if ((b == 125 || b == 93) && !this.insideString) {
            this.openBraces--;
            return;
        }
        if (b == 34) {
            if (!this.insideString) {
                this.insideString = true;
            } else if (byteBuf.getByte(i - 1) != 92) {
                this.insideString = false;
            }
        }
    }

    private void initDecoding(byte b) {
        this.openBraces = 1;
        if (b == 91 && this.streamArrayElements) {
            this.state = 2;
        } else {
            this.state = 1;
        }
    }

    private void reset() {
        this.insideString = false;
        this.state = 0;
        this.openBraces = 0;
    }
}
