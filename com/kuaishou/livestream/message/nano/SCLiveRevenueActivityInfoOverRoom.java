package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRevenueActivityInfoOverRoom extends MessageNano {
    private static volatile SCLiveRevenueActivityInfoOverRoom[] _emptyArray;
    public String activityId;
    public boolean enable;
    public long maxDelayMs;

    public static SCLiveRevenueActivityInfoOverRoom[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRevenueActivityInfoOverRoom[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRevenueActivityInfoOverRoom() {
        clear();
    }

    public final SCLiveRevenueActivityInfoOverRoom clear() {
        this.activityId = "";
        this.enable = false;
        this.maxDelayMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.activityId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.activityId);
        }
        boolean z = this.enable;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        long j = this.maxDelayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.activityId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activityId);
        }
        boolean z = this.enable;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        long j = this.maxDelayMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRevenueActivityInfoOverRoom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.activityId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.enable = codedInputByteBufferNano.readBool();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.maxDelayMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveRevenueActivityInfoOverRoom parseFrom(byte[] bArr) {
        return (SCLiveRevenueActivityInfoOverRoom) MessageNano.mergeFrom(new SCLiveRevenueActivityInfoOverRoom(), bArr);
    }

    public static SCLiveRevenueActivityInfoOverRoom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRevenueActivityInfoOverRoom().mergeFrom(codedInputByteBufferNano);
    }
}
