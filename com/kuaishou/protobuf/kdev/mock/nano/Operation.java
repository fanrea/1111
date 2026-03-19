package com.kuaishou.protobuf.kdev.mock.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Operation extends MessageNano {
    private static volatile Operation[] _emptyArray;
    public String createUser;
    public String extraInfo;
    public String operation;
    public long replayId;
    public String textContent;

    public static Operation[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Operation[0];
                }
            }
        }
        return _emptyArray;
    }

    public Operation() {
        clear();
    }

    public final Operation clear() {
        this.replayId = 0L;
        this.createUser = "";
        this.textContent = "";
        this.operation = "";
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.replayId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.createUser.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.createUser);
        }
        if (!this.textContent.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.textContent);
        }
        if (!this.operation.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.operation);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.replayId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.createUser.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.createUser);
        }
        if (!this.textContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.textContent);
        }
        if (!this.operation.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.operation);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Operation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.replayId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.createUser = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.textContent = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.operation = codedInputByteBufferNano.readString();
            } else if (tag != 82) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.extraInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Operation parseFrom(byte[] bArr) {
        return (Operation) MessageNano.mergeFrom(new Operation(), bArr);
    }

    public static Operation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Operation().mergeFrom(codedInputByteBufferNano);
    }
}
