package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftTabRefresh extends MessageNano {
    private static volatile SCLiveGiftTabRefresh[] _emptyArray;
    public long endTime;
    public String extraInfo;
    public long startTime;

    public static SCLiveGiftTabRefresh[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftTabRefresh[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftTabRefresh() {
        clear();
    }

    public final SCLiveGiftTabRefresh clear() {
        this.extraInfo = "";
        this.startTime = 0L;
        this.endTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.extraInfo);
        }
        long j = this.startTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.endTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.extraInfo);
        }
        long j = this.startTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.endTime;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftTabRefresh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.endTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveGiftTabRefresh parseFrom(byte[] bArr) {
        return (SCLiveGiftTabRefresh) MessageNano.mergeFrom(new SCLiveGiftTabRefresh(), bArr);
    }

    public static SCLiveGiftTabRefresh parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftTabRefresh().mergeFrom(codedInputByteBufferNano);
    }
}
