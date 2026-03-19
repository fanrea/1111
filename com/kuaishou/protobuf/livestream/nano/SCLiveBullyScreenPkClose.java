package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBullyScreenPkClose extends MessageNano {
    private static volatile SCLiveBullyScreenPkClose[] _emptyArray;
    public String closeToastInfo;
    public String multiPkId;
    public long timestamp;

    public static SCLiveBullyScreenPkClose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBullyScreenPkClose[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBullyScreenPkClose() {
        clear();
    }

    public final SCLiveBullyScreenPkClose clear() {
        this.multiPkId = "";
        this.closeToastInfo = "";
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.multiPkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.multiPkId);
        }
        if (!this.closeToastInfo.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.closeToastInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.multiPkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.multiPkId);
        }
        if (!this.closeToastInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.closeToastInfo);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBullyScreenPkClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.multiPkId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.closeToastInfo = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveBullyScreenPkClose parseFrom(byte[] bArr) {
        return (SCLiveBullyScreenPkClose) MessageNano.mergeFrom(new SCLiveBullyScreenPkClose(), bArr);
    }

    public static SCLiveBullyScreenPkClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBullyScreenPkClose().mergeFrom(codedInputByteBufferNano);
    }
}
