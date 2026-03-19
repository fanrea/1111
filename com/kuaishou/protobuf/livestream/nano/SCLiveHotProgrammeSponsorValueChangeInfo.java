package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveHotProgrammeSponsorValueChangeInfo extends MessageNano {
    private static volatile SCLiveHotProgrammeSponsorValueChangeInfo[] _emptyArray;
    public long itemId;
    public long programmeId;
    public long sponsorValue;
    public long timestamp;

    public static SCLiveHotProgrammeSponsorValueChangeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveHotProgrammeSponsorValueChangeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveHotProgrammeSponsorValueChangeInfo() {
        clear();
    }

    public final SCLiveHotProgrammeSponsorValueChangeInfo clear() {
        this.programmeId = 0L;
        this.itemId = 0L;
        this.sponsorValue = 0L;
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.programmeId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.itemId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.sponsorValue;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j4 = this.timestamp;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j4);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.programmeId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.itemId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.sponsorValue;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j4 = this.timestamp;
        return j4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveHotProgrammeSponsorValueChangeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.programmeId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.itemId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.sponsorValue = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveHotProgrammeSponsorValueChangeInfo parseFrom(byte[] bArr) {
        return (SCLiveHotProgrammeSponsorValueChangeInfo) MessageNano.mergeFrom(new SCLiveHotProgrammeSponsorValueChangeInfo(), bArr);
    }

    public static SCLiveHotProgrammeSponsorValueChangeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveHotProgrammeSponsorValueChangeInfo().mergeFrom(codedInputByteBufferNano);
    }
}
