package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MigrateRoom extends MessageNano {
    private static volatile MigrateRoom[] _emptyArray;
    public String message;

    public static MigrateRoom[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MigrateRoom[0];
                }
            }
        }
        return _emptyArray;
    }

    public MigrateRoom() {
        clear();
    }

    public final MigrateRoom clear() {
        this.message = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.message.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.message);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.message.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.message) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MigrateRoom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.message = codedInputByteBufferNano.readString();
            }
        }
    }

    public static MigrateRoom parseFrom(byte[] bArr) {
        return (MigrateRoom) MessageNano.mergeFrom(new MigrateRoom(), bArr);
    }

    public static MigrateRoom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MigrateRoom().mergeFrom(codedInputByteBufferNano);
    }
}
