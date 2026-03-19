package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRecordState extends MessageNano {
    private static volatile SCLiveRecordState[] _emptyArray;
    public boolean enableRecord;
    public long maxRecordDurationMs;
    public long minRecordDurationMs;
    public String tips;

    public static SCLiveRecordState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRecordState[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRecordState() {
        clear();
    }

    public final SCLiveRecordState clear() {
        this.enableRecord = false;
        this.minRecordDurationMs = 0L;
        this.maxRecordDurationMs = 0L;
        this.tips = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.enableRecord;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.minRecordDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.maxRecordDurationMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        if (!this.tips.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.tips);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enableRecord;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.minRecordDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.maxRecordDurationMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        return !this.tips.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.tips) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRecordState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.enableRecord = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.minRecordDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.maxRecordDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.tips = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveRecordState parseFrom(byte[] bArr) {
        return (SCLiveRecordState) MessageNano.mergeFrom(new SCLiveRecordState(), bArr);
    }

    public static SCLiveRecordState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRecordState().mergeFrom(codedInputByteBufferNano);
    }
}
