package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class JdkZlibDecoder extends ZlibDecoder {
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final CRC32 crc;
    private boolean decideZlibOrNone;
    private final byte[] dictionary;
    private volatile boolean finished;
    private int flags;
    private GzipState gzipState;
    private Inflater inflater;
    private int xlen;

    enum GzipState {
        HEADER_START,
        HEADER_END,
        FLG_READ,
        XLEN_READ,
        SKIP_FNAME,
        SKIP_COMMENT,
        PROCESS_FHCRC,
        FOOTER_START
    }

    public JdkZlibDecoder() {
        this(ZlibWrapper.ZLIB, null);
    }

    public JdkZlibDecoder(byte[] bArr) {
        this(ZlibWrapper.ZLIB, bArr);
    }

    public JdkZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, null);
    }

    private JdkZlibDecoder(ZlibWrapper zlibWrapper, byte[] bArr) {
        this.gzipState = GzipState.HEADER_START;
        this.flags = -1;
        this.xlen = -1;
        if (zlibWrapper == null) {
            throw new NullPointerException("wrapper");
        }
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i == 1) {
            this.inflater = new Inflater(true);
            this.crc = new CRC32();
        } else if (i == 2) {
            this.inflater = new Inflater(true);
            this.crc = null;
        } else if (i == 3) {
            this.inflater = new Inflater();
            this.crc = null;
        } else if (i == 4) {
            this.decideZlibOrNone = true;
            this.crc = null;
        } else {
            throw new IllegalArgumentException("Only GZIP or ZLIB is supported, but you used " + zlibWrapper);
        }
        this.dictionary = bArr;
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int i = byteBuf.readableBytes();
        if (i == 0) {
            return;
        }
        boolean z = false;
        if (this.decideZlibOrNone) {
            if (i < 2) {
                return;
            }
            this.inflater = new Inflater(!looksLikeZlib(byteBuf.getShort(byteBuf.readerIndex())));
            this.decideZlibOrNone = false;
        }
        if (this.crc != null) {
            if (AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[this.gzipState.ordinal()] == 1) {
                if (readGZIPFooter(byteBuf)) {
                    this.finished = true;
                    return;
                }
                return;
            } else if (this.gzipState != GzipState.HEADER_END && !readGZIPHeader(byteBuf)) {
                return;
            } else {
                i = byteBuf.readableBytes();
            }
        }
        if (byteBuf.hasArray()) {
            this.inflater.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), i);
        } else {
            byte[] bArr = new byte[i];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            this.inflater.setInput(bArr);
        }
        int remaining = this.inflater.getRemaining() << 1;
        ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(remaining);
        try {
            try {
                byte[] bArrArray = byteBufHeapBuffer.array();
                while (true) {
                    if (this.inflater.needsInput()) {
                        break;
                    }
                    int iWriterIndex = byteBufHeapBuffer.writerIndex();
                    int iArrayOffset = byteBufHeapBuffer.arrayOffset() + iWriterIndex;
                    int iWritableBytes = byteBufHeapBuffer.writableBytes();
                    if (iWritableBytes == 0) {
                        list.add(byteBufHeapBuffer);
                        byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(remaining);
                        bArrArray = byteBufHeapBuffer.array();
                    } else {
                        int iInflate = this.inflater.inflate(bArrArray, iArrayOffset, iWritableBytes);
                        if (iInflate > 0) {
                            byteBufHeapBuffer.writerIndex(iWriterIndex + iInflate);
                            if (this.crc != null) {
                                this.crc.update(bArrArray, iArrayOffset, iInflate);
                            }
                        } else if (this.inflater.needsDictionary()) {
                            if (this.dictionary == null) {
                                throw new DecompressionException("decompression failure, unable to set dictionary as non was specified");
                            }
                            this.inflater.setDictionary(this.dictionary);
                        }
                        if (this.inflater.finished()) {
                            if (this.crc == null) {
                                this.finished = true;
                            } else {
                                z = true;
                            }
                        }
                    }
                }
                byteBuf.skipBytes(i - this.inflater.getRemaining());
                if (z) {
                    this.gzipState = GzipState.FOOTER_START;
                    if (readGZIPFooter(byteBuf)) {
                        this.finished = true;
                    }
                }
            } catch (DataFormatException e) {
                throw new DecompressionException("decompression failure", e);
            }
        } finally {
            if (byteBufHeapBuffer.isReadable()) {
                list.add(byteBufHeapBuffer);
            } else {
                byteBufHeapBuffer.release();
            }
        }
    }

    /* renamed from: io.netty.handler.codec.compression.JdkZlibDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.FOOTER_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.FLG_READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.XLEN_READ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_FNAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.SKIP_COMMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.PROCESS_FHCRC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$JdkZlibDecoder$GzipState[GzipState.HEADER_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = new int[ZlibWrapper.values().length];
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.GZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
        super.handlerRemoved0(channelHandlerContext);
        Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
        }
    }

    private boolean readGZIPHeader(ByteBuf byteBuf) {
        switch (this.gzipState) {
            case HEADER_START:
                if (byteBuf.readableBytes() < 10) {
                    return false;
                }
                byte b = byteBuf.readByte();
                byte b2 = byteBuf.readByte();
                if (b != 31) {
                    throw new DecompressionException("Input is not in the GZIP format");
                }
                this.crc.update(b);
                this.crc.update(b2);
                short unsignedByte = byteBuf.readUnsignedByte();
                if (unsignedByte != 8) {
                    throw new DecompressionException("Unsupported compression method " + ((int) unsignedByte) + " in the GZIP header");
                }
                this.crc.update(unsignedByte);
                this.flags = byteBuf.readUnsignedByte();
                this.crc.update(this.flags);
                if ((this.flags & 224) != 0) {
                    throw new DecompressionException("Reserved flags are set in the GZIP header");
                }
                this.crc.update(byteBuf.readByte());
                this.crc.update(byteBuf.readByte());
                this.crc.update(byteBuf.readByte());
                this.crc.update(byteBuf.readByte());
                this.crc.update(byteBuf.readUnsignedByte());
                this.crc.update(byteBuf.readUnsignedByte());
                this.gzipState = GzipState.FLG_READ;
            case FLG_READ:
                if ((this.flags & 4) != 0) {
                    if (byteBuf.readableBytes() < 2) {
                        return false;
                    }
                    short unsignedByte2 = byteBuf.readUnsignedByte();
                    short unsignedByte3 = byteBuf.readUnsignedByte();
                    this.crc.update(unsignedByte2);
                    this.crc.update(unsignedByte3);
                    this.xlen = (unsignedByte2 << 8) | unsignedByte3 | this.xlen;
                }
                this.gzipState = GzipState.XLEN_READ;
            case XLEN_READ:
                if (this.xlen != -1) {
                    int i = byteBuf.readableBytes();
                    int i2 = this.xlen;
                    if (i < i2) {
                        return false;
                    }
                    byte[] bArr = new byte[i2];
                    byteBuf.readBytes(bArr);
                    this.crc.update(bArr);
                }
                this.gzipState = GzipState.SKIP_FNAME;
            case SKIP_FNAME:
                if ((this.flags & 8) != 0) {
                    if (!byteBuf.isReadable()) {
                        return false;
                    }
                    do {
                        short unsignedByte4 = byteBuf.readUnsignedByte();
                        this.crc.update(unsignedByte4);
                        if (unsignedByte4 != 0) {
                        }
                    } while (byteBuf.isReadable());
                }
                this.gzipState = GzipState.SKIP_COMMENT;
            case SKIP_COMMENT:
                if ((this.flags & 16) != 0) {
                    if (!byteBuf.isReadable()) {
                        return false;
                    }
                    do {
                        short unsignedByte5 = byteBuf.readUnsignedByte();
                        this.crc.update(unsignedByte5);
                        if (unsignedByte5 != 0) {
                        }
                    } while (byteBuf.isReadable());
                }
                this.gzipState = GzipState.PROCESS_FHCRC;
            case PROCESS_FHCRC:
                if ((this.flags & 2) != 0) {
                    if (byteBuf.readableBytes() < 4) {
                        return false;
                    }
                    verifyCrc(byteBuf);
                }
                this.crc.reset();
                this.gzipState = GzipState.HEADER_END;
                return true;
            case HEADER_END:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private boolean readGZIPFooter(ByteBuf byteBuf) {
        if (byteBuf.readableBytes() < 8) {
            return false;
        }
        verifyCrc(byteBuf);
        int unsignedByte = 0;
        for (int i = 0; i < 4; i++) {
            unsignedByte |= byteBuf.readUnsignedByte() << (i * 8);
        }
        int totalOut = this.inflater.getTotalOut();
        if (unsignedByte == totalOut) {
            return true;
        }
        throw new DecompressionException("Number of bytes mismatch. Expected: " + unsignedByte + ", Got: " + totalOut);
    }

    private void verifyCrc(ByteBuf byteBuf) {
        long unsignedByte = 0;
        for (int i = 0; i < 4; i++) {
            unsignedByte |= byteBuf.readUnsignedByte() << (i * 8);
        }
        long value = this.crc.getValue();
        if (unsignedByte == value) {
            return;
        }
        throw new DecompressionException("CRC value missmatch. Expected: " + unsignedByte + ", Got: " + value);
    }

    private static boolean looksLikeZlib(short s) {
        return (s & 30720) == 30720 && s % 31 == 0;
    }
}
