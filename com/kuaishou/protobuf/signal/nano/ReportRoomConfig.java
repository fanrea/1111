package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ReportRoomConfig extends MessageNano {
    private static volatile ReportRoomConfig[] _emptyArray;
    public String config;

    public static ReportRoomConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportRoomConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public ReportRoomConfig() {
        clear();
    }

    public final ReportRoomConfig clear() {
        this.config = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.config.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.config);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.config.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.config) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ReportRoomConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.config = codedInputByteBufferNano.readString();
            }
        }
    }

    public static ReportRoomConfig parseFrom(byte[] bArr) {
        return (ReportRoomConfig) MessageNano.mergeFrom(new ReportRoomConfig(), bArr);
    }

    public static ReportRoomConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ReportRoomConfig().mergeFrom(codedInputByteBufferNano);
    }
}
