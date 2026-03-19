package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkRoomInfoExtraInfo extends MessageNano {
    private static volatile LiveMultiPkRoomInfoExtraInfo[] _emptyArray;
    public SCLiveMultiPkStatistic multiPkStatistic;
    public long roomOwnerId;

    public static LiveMultiPkRoomInfoExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkRoomInfoExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkRoomInfoExtraInfo() {
        clear();
    }

    public final LiveMultiPkRoomInfoExtraInfo clear() {
        this.multiPkStatistic = null;
        this.roomOwnerId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        SCLiveMultiPkStatistic sCLiveMultiPkStatistic = this.multiPkStatistic;
        if (sCLiveMultiPkStatistic != null) {
            codedOutputByteBufferNano.writeMessage(1, sCLiveMultiPkStatistic);
        }
        long j = this.roomOwnerId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        SCLiveMultiPkStatistic sCLiveMultiPkStatistic = this.multiPkStatistic;
        if (sCLiveMultiPkStatistic != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sCLiveMultiPkStatistic);
        }
        long j = this.roomOwnerId;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkRoomInfoExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.multiPkStatistic == null) {
                    this.multiPkStatistic = new SCLiveMultiPkStatistic();
                }
                codedInputByteBufferNano.readMessage(this.multiPkStatistic);
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.roomOwnerId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiPkRoomInfoExtraInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkRoomInfoExtraInfo) MessageNano.mergeFrom(new LiveMultiPkRoomInfoExtraInfo(), bArr);
    }

    public static LiveMultiPkRoomInfoExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkRoomInfoExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
