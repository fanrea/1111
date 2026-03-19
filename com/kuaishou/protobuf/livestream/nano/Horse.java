package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Horse extends MessageNano {
    private static volatile Horse[] _emptyArray;
    public boolean chosen;
    public long cost;
    public String errorDescription;
    public String hostAndPort;
    public long startTime;
    public boolean success;
    public String tag;

    public static Horse[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Horse[0];
                }
            }
        }
        return _emptyArray;
    }

    public Horse() {
        clear();
    }

    public final Horse clear() {
        this.hostAndPort = "";
        this.tag = "";
        this.success = false;
        this.chosen = false;
        this.startTime = 0L;
        this.cost = 0L;
        this.errorDescription = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.hostAndPort.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.hostAndPort);
        }
        if (!this.tag.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.tag);
        }
        boolean z = this.success;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        boolean z2 = this.chosen;
        if (z2) {
            codedOutputByteBufferNano.writeBool(7, z2);
        }
        long j = this.startTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j);
        }
        long j2 = this.cost;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j2);
        }
        if (!this.errorDescription.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.errorDescription);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.hostAndPort.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.hostAndPort);
        }
        if (!this.tag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.tag);
        }
        boolean z = this.success;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        boolean z2 = this.chosen;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z2);
        }
        long j = this.startTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j);
        }
        long j2 = this.cost;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j2);
        }
        return !this.errorDescription.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.errorDescription) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Horse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.hostAndPort = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.tag = codedInputByteBufferNano.readString();
            } else if (tag == 48) {
                this.success = codedInputByteBufferNano.readBool();
            } else if (tag == 56) {
                this.chosen = codedInputByteBufferNano.readBool();
            } else if (tag == 64) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 72) {
                this.cost = codedInputByteBufferNano.readUInt64();
            } else if (tag != 82) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.errorDescription = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Horse parseFrom(byte[] bArr) {
        return (Horse) MessageNano.mergeFrom(new Horse(), bArr);
    }

    public static Horse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Horse().mergeFrom(codedInputByteBufferNano);
    }
}
