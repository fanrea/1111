package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkColorInfo extends MessageNano {
    private static volatile LiveMultiPkColorInfo[] _emptyArray;
    public String endColor;
    public String startColor;

    public static LiveMultiPkColorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkColorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkColorInfo() {
        clear();
    }

    public final LiveMultiPkColorInfo clear() {
        this.startColor = "";
        this.endColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.startColor.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.startColor);
        }
        if (!this.endColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.endColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.startColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.startColor);
        }
        return !this.endColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.endColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkColorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.startColor = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.endColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveMultiPkColorInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkColorInfo) MessageNano.mergeFrom(new LiveMultiPkColorInfo(), bArr);
    }

    public static LiveMultiPkColorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkColorInfo().mergeFrom(codedInputByteBufferNano);
    }
}
