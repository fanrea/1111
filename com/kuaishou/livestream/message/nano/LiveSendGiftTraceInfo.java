package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveSendGiftTraceInfo extends MessageNano {
    private static volatile LiveSendGiftTraceInfo[] _emptyArray;
    public long fromUserId;
    public int giftId;
    public long toUserId;
    public String traceId;

    public static LiveSendGiftTraceInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveSendGiftTraceInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveSendGiftTraceInfo() {
        clear();
    }

    public final LiveSendGiftTraceInfo clear() {
        this.traceId = "";
        this.fromUserId = 0L;
        this.toUserId = 0L;
        this.giftId = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.traceId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.traceId);
        }
        long j = this.fromUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.toUserId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.traceId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.traceId);
        }
        long j = this.fromUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.toUserId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        int i = this.giftId;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveSendGiftTraceInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.traceId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.fromUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.toUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.giftId = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveSendGiftTraceInfo parseFrom(byte[] bArr) {
        return (LiveSendGiftTraceInfo) MessageNano.mergeFrom(new LiveSendGiftTraceInfo(), bArr);
    }

    public static LiveSendGiftTraceInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveSendGiftTraceInfo().mergeFrom(codedInputByteBufferNano);
    }
}
