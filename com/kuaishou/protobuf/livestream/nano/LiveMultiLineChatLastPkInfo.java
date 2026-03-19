package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiLineChatLastPkInfo extends MessageNano {
    private static volatile LiveMultiLineChatLastPkInfo[] _emptyArray;
    public int lastPkEndInfo;
    public long lastPkId;
    public int lastPkPlayType;
    public int lastPkStartWay;

    public static LiveMultiLineChatLastPkInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiLineChatLastPkInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiLineChatLastPkInfo() {
        clear();
    }

    public final LiveMultiLineChatLastPkInfo clear() {
        this.lastPkEndInfo = 0;
        this.lastPkStartWay = 0;
        this.lastPkPlayType = 0;
        this.lastPkId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.lastPkEndInfo;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.lastPkStartWay;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        int i3 = this.lastPkPlayType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j = this.lastPkId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.lastPkEndInfo;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.lastPkStartWay;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        int i3 = this.lastPkPlayType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j = this.lastPkId;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiLineChatLastPkInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.lastPkEndInfo = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.lastPkStartWay = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                this.lastPkPlayType = codedInputByteBufferNano.readUInt32();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.lastPkId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiLineChatLastPkInfo parseFrom(byte[] bArr) {
        return (LiveMultiLineChatLastPkInfo) MessageNano.mergeFrom(new LiveMultiLineChatLastPkInfo(), bArr);
    }

    public static LiveMultiLineChatLastPkInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiLineChatLastPkInfo().mergeFrom(codedInputByteBufferNano);
    }
}
