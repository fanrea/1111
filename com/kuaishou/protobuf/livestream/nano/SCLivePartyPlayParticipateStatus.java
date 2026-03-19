package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePartyPlayParticipateStatus extends MessageNano {
    private static volatile SCLivePartyPlayParticipateStatus[] _emptyArray;
    public int status;
    public long version;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ParticipateStatus {
        public static final int ENTER = 1;
        public static final int EXIT = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLivePartyPlayParticipateStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePartyPlayParticipateStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePartyPlayParticipateStatus() {
        clear();
    }

    public final SCLivePartyPlayParticipateStatus clear() {
        this.status = 0;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.version;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.version;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePartyPlayParticipateStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.status = int32;
                }
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLivePartyPlayParticipateStatus parseFrom(byte[] bArr) {
        return (SCLivePartyPlayParticipateStatus) MessageNano.mergeFrom(new SCLivePartyPlayParticipateStatus(), bArr);
    }

    public static SCLivePartyPlayParticipateStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePartyPlayParticipateStatus().mergeFrom(codedInputByteBufferNano);
    }
}
