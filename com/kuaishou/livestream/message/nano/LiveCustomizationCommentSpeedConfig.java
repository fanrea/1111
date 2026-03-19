package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCustomizationCommentSpeedConfig extends MessageNano {
    private static volatile LiveCustomizationCommentSpeedConfig[] _emptyArray;
    public long autoScrollToBottomDelayTimeMs;
    public long cachedCommonMaxNum;
    public long changeScrollSpeedLimitNum;
    public long fastScrollSpeedDelayMs;
    public long fastScrollSpeedDp;
    public long fastScrollSpeedNum;
    public long foldContinueMaxNum;
    public long showFoldBatchNum;
    public long slowScrollSpeedDelayMs;
    public long slowScrollSpeedDp;
    public long slowScrollSpeedNum;
    public long updateFoldIntervalMs;
    public int version;

    public static LiveCustomizationCommentSpeedConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCustomizationCommentSpeedConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCustomizationCommentSpeedConfig() {
        clear();
    }

    public final LiveCustomizationCommentSpeedConfig clear() {
        this.version = 0;
        this.autoScrollToBottomDelayTimeMs = 0L;
        this.cachedCommonMaxNum = 0L;
        this.changeScrollSpeedLimitNum = 0L;
        this.foldContinueMaxNum = 0L;
        this.showFoldBatchNum = 0L;
        this.updateFoldIntervalMs = 0L;
        this.fastScrollSpeedDp = 0L;
        this.fastScrollSpeedNum = 0L;
        this.fastScrollSpeedDelayMs = 0L;
        this.slowScrollSpeedDp = 0L;
        this.slowScrollSpeedNum = 0L;
        this.slowScrollSpeedDelayMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.version;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.autoScrollToBottomDelayTimeMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        long j2 = this.cachedCommonMaxNum;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j2);
        }
        long j3 = this.changeScrollSpeedLimitNum;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        long j4 = this.foldContinueMaxNum;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j4);
        }
        long j5 = this.showFoldBatchNum;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j5);
        }
        long j6 = this.updateFoldIntervalMs;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j6);
        }
        long j7 = this.fastScrollSpeedDp;
        if (j7 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j7);
        }
        long j8 = this.fastScrollSpeedNum;
        if (j8 != 0) {
            codedOutputByteBufferNano.writeInt64(9, j8);
        }
        long j9 = this.fastScrollSpeedDelayMs;
        if (j9 != 0) {
            codedOutputByteBufferNano.writeInt64(10, j9);
        }
        long j10 = this.slowScrollSpeedDp;
        if (j10 != 0) {
            codedOutputByteBufferNano.writeInt64(11, j10);
        }
        long j11 = this.slowScrollSpeedNum;
        if (j11 != 0) {
            codedOutputByteBufferNano.writeInt64(12, j11);
        }
        long j12 = this.slowScrollSpeedDelayMs;
        if (j12 != 0) {
            codedOutputByteBufferNano.writeInt64(13, j12);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.version;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.autoScrollToBottomDelayTimeMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        long j2 = this.cachedCommonMaxNum;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j2);
        }
        long j3 = this.changeScrollSpeedLimitNum;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j3);
        }
        long j4 = this.foldContinueMaxNum;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j4);
        }
        long j5 = this.showFoldBatchNum;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j5);
        }
        long j6 = this.updateFoldIntervalMs;
        if (j6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j6);
        }
        long j7 = this.fastScrollSpeedDp;
        if (j7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j7);
        }
        long j8 = this.fastScrollSpeedNum;
        if (j8 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(9, j8);
        }
        long j9 = this.fastScrollSpeedDelayMs;
        if (j9 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(10, j9);
        }
        long j10 = this.slowScrollSpeedDp;
        if (j10 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(11, j10);
        }
        long j11 = this.slowScrollSpeedNum;
        if (j11 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(12, j11);
        }
        long j12 = this.slowScrollSpeedDelayMs;
        return j12 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(13, j12) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCustomizationCommentSpeedConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.version = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.autoScrollToBottomDelayTimeMs = codedInputByteBufferNano.readInt64();
                    break;
                case 24:
                    this.cachedCommonMaxNum = codedInputByteBufferNano.readInt64();
                    break;
                case 32:
                    this.changeScrollSpeedLimitNum = codedInputByteBufferNano.readInt64();
                    break;
                case 40:
                    this.foldContinueMaxNum = codedInputByteBufferNano.readInt64();
                    break;
                case 48:
                    this.showFoldBatchNum = codedInputByteBufferNano.readInt64();
                    break;
                case 56:
                    this.updateFoldIntervalMs = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    this.fastScrollSpeedDp = codedInputByteBufferNano.readInt64();
                    break;
                case 72:
                    this.fastScrollSpeedNum = codedInputByteBufferNano.readInt64();
                    break;
                case 80:
                    this.fastScrollSpeedDelayMs = codedInputByteBufferNano.readInt64();
                    break;
                case 88:
                    this.slowScrollSpeedDp = codedInputByteBufferNano.readInt64();
                    break;
                case 96:
                    this.slowScrollSpeedNum = codedInputByteBufferNano.readInt64();
                    break;
                case 104:
                    this.slowScrollSpeedDelayMs = codedInputByteBufferNano.readInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveCustomizationCommentSpeedConfig parseFrom(byte[] bArr) {
        return (LiveCustomizationCommentSpeedConfig) MessageNano.mergeFrom(new LiveCustomizationCommentSpeedConfig(), bArr);
    }

    public static LiveCustomizationCommentSpeedConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCustomizationCommentSpeedConfig().mergeFrom(codedInputByteBufferNano);
    }
}
