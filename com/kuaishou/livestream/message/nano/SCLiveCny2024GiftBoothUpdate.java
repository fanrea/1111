package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024GiftBoothUpdate extends MessageNano {
    private static volatile SCLiveCny2024GiftBoothUpdate[] _emptyArray;
    public long displayRandomDelayMs;
    public String liveStreamId;
    public long timestamp;

    public static SCLiveCny2024GiftBoothUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024GiftBoothUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024GiftBoothUpdate() {
        clear();
    }

    public final SCLiveCny2024GiftBoothUpdate clear() {
        this.liveStreamId = "";
        this.timestamp = 0L;
        this.displayRandomDelayMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.displayRandomDelayMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.displayRandomDelayMs;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024GiftBoothUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayRandomDelayMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveCny2024GiftBoothUpdate parseFrom(byte[] bArr) {
        return (SCLiveCny2024GiftBoothUpdate) MessageNano.mergeFrom(new SCLiveCny2024GiftBoothUpdate(), bArr);
    }

    public static SCLiveCny2024GiftBoothUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024GiftBoothUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
