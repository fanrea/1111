package io.netty.handler.codec.compression;

import com.ss.ttm.utils.AVLogger;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.xxhash.XXHashFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Lz4FrameDecoder extends ByteToMessageDecoder {
    private int blockType;
    private Checksum checksum;
    private int compressedLength;
    private int currentChecksum;
    private State currentState;
    private int decompressedLength;
    private LZ4FastDecompressor decompressor;

    enum State {
        INIT_BLOCK,
        DECOMPRESS_DATA,
        FINISHED,
        CORRUPTED
    }

    public Lz4FrameDecoder() {
        this(false);
    }

    public Lz4FrameDecoder(boolean z) {
        this(LZ4Factory.fastestInstance(), z);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, boolean z) {
        this(lZ4Factory, z ? XXHashFactory.fastestInstance().newStreamingHash32(-1756908916).asChecksum() : null);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        if (lZ4Factory == null) {
            throw new NullPointerException("factory");
        }
        this.decompressor = lZ4Factory.fastDecompressor();
        this.checksum = checksum;
    }

    /* renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf byteBuf2;
        int i;
        byte[] bArr;
        ByteBuf byteBuf3;
        int i2;
        byte[] bArr2;
        int iArrayOffset;
        ByteBuf byteBuf4;
        try {
            int i3 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[this.currentState.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        throw new IllegalStateException();
                    }
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                }
            } else {
                if (byteBuf.readableBytes() < 21) {
                    return;
                }
                if (byteBuf.readLong() != 5501767354678207339L) {
                    throw new DecompressionException("unexpected block identifier");
                }
                byte b = byteBuf.readByte();
                int i4 = (b & 15) + 10;
                int i5 = b & 240;
                int iReverseBytes = Integer.reverseBytes(byteBuf.readInt());
                if (iReverseBytes < 0 || iReverseBytes > 33554432) {
                    throw new DecompressionException(String.format("invalid compressedLength: %d (expected: 0-%d)", Integer.valueOf(iReverseBytes), Integer.valueOf(AVLogger.LEVEL_LOG_INFO)));
                }
                int iReverseBytes2 = Integer.reverseBytes(byteBuf.readInt());
                int i6 = 1 << i4;
                if (iReverseBytes2 < 0 || iReverseBytes2 > i6) {
                    throw new DecompressionException(String.format("invalid decompressedLength: %d (expected: 0-%d)", Integer.valueOf(iReverseBytes2), Integer.valueOf(i6)));
                }
                if ((iReverseBytes2 == 0 && iReverseBytes != 0) || ((iReverseBytes2 != 0 && iReverseBytes == 0) || (i5 == 16 && iReverseBytes2 != iReverseBytes))) {
                    throw new DecompressionException(String.format("stream corrupted: compressedLength(%d) and decompressedLength(%d) mismatch", Integer.valueOf(iReverseBytes), Integer.valueOf(iReverseBytes2)));
                }
                int iReverseBytes3 = Integer.reverseBytes(byteBuf.readInt());
                if (iReverseBytes2 == 0 && iReverseBytes == 0) {
                    if (iReverseBytes3 != 0) {
                        throw new DecompressionException("stream corrupted: checksum error");
                    }
                    this.currentState = State.FINISHED;
                    this.decompressor = null;
                    this.checksum = null;
                    return;
                }
                this.blockType = i5;
                this.compressedLength = iReverseBytes;
                this.decompressedLength = iReverseBytes2;
                this.currentChecksum = iReverseBytes3;
                this.currentState = State.DECOMPRESS_DATA;
            }
            int i7 = this.blockType;
            int i8 = this.compressedLength;
            int i9 = this.decompressedLength;
            int i10 = this.currentChecksum;
            if (byteBuf.readableBytes() < i8) {
                return;
            }
            int i11 = byteBuf.readerIndex();
            ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(i9, i9);
            byte[] bArrArray = byteBufHeapBuffer.array();
            int iWriterIndex = byteBufHeapBuffer.writerIndex() + byteBufHeapBuffer.arrayOffset();
            try {
                if (i7 == 16) {
                    i = iWriterIndex;
                    bArr = bArrArray;
                    byteBuf3 = byteBufHeapBuffer;
                    i2 = i10;
                    byteBuf.getBytes(i11, bArr, i, i9);
                } else if (i7 == 32) {
                    try {
                        if (byteBuf.hasArray()) {
                            byte[] bArrArray2 = byteBuf.array();
                            iArrayOffset = byteBuf.arrayOffset() + i11;
                            bArr2 = bArrArray2;
                        } else {
                            byte[] bArr3 = new byte[i8];
                            byteBuf.getBytes(i11, bArr3);
                            bArr2 = bArr3;
                            iArrayOffset = 0;
                        }
                        try {
                            i = iWriterIndex;
                            int i12 = iArrayOffset;
                            bArr = bArrArray;
                            byteBuf4 = byteBufHeapBuffer;
                            i2 = i10;
                            try {
                                try {
                                    int iDecompress = this.decompressor.decompress(bArr2, i12, bArrArray, i, i9);
                                    if (i8 != iDecompress) {
                                        throw new DecompressionException(String.format("stream corrupted: compressedLength(%d) and actual length(%d) mismatch", Integer.valueOf(i8), Integer.valueOf(iDecompress)));
                                    }
                                    byteBuf3 = byteBuf4;
                                } catch (Throwable th) {
                                    th = th;
                                    byteBuf2 = byteBuf4;
                                    byteBuf2.release();
                                    throw th;
                                }
                            } catch (LZ4Exception e) {
                                e = e;
                                throw new DecompressionException((Throwable) e);
                            }
                        } catch (LZ4Exception e2) {
                            e = e2;
                            byteBuf4 = byteBufHeapBuffer;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteBuf2 = byteBufHeapBuffer;
                    }
                } else {
                    throw new DecompressionException(String.format("unexpected blockType: %d (expected: %d or %d)", Integer.valueOf(i7), 16, 32));
                }
                Checksum checksum = this.checksum;
                if (checksum != null) {
                    checksum.reset();
                    checksum.update(bArr, i, i9);
                    int value = (int) checksum.getValue();
                    int i13 = i2;
                    if (value != i13) {
                        throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(i13)));
                    }
                }
                byteBuf3.writerIndex(byteBuf3.writerIndex() + i9);
                list.add(byteBuf3);
                byteBuf.skipBytes(i8);
                this.currentState = State.INIT_BLOCK;
            } catch (Throwable th3) {
                th = th3;
                byteBuf2 = iWriterIndex;
            }
        } catch (Exception e3) {
            this.currentState = State.CORRUPTED;
            throw e3;
        }
    }

    public boolean isClosed() {
        return this.currentState == State.FINISHED;
    }
}
