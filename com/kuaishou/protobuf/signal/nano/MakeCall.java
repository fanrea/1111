package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MakeCall extends MessageNano {
    private static volatile MakeCall[] _emptyArray;
    public String context;
    public String idc;
    public boolean isRoomOwner;
    public boolean needRecord;

    public static MakeCall[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MakeCall[0];
                }
            }
        }
        return _emptyArray;
    }

    public MakeCall() {
        clear();
    }

    public final MakeCall clear() {
        this.isRoomOwner = false;
        this.idc = "";
        this.needRecord = false;
        this.context = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isRoomOwner;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        if (!this.idc.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.idc);
        }
        boolean z2 = this.needRecord;
        if (z2) {
            codedOutputByteBufferNano.writeBool(3, z2);
        }
        if (!this.context.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.context);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isRoomOwner;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        if (!this.idc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.idc);
        }
        boolean z2 = this.needRecord;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z2);
        }
        return !this.context.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.context) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MakeCall mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isRoomOwner = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                this.idc = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.needRecord = codedInputByteBufferNano.readBool();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.context = codedInputByteBufferNano.readString();
            }
        }
    }

    public static MakeCall parseFrom(byte[] bArr) {
        return (MakeCall) MessageNano.mergeFrom(new MakeCall(), bArr);
    }

    public static MakeCall parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MakeCall().mergeFrom(codedInputByteBufferNano);
    }
}
