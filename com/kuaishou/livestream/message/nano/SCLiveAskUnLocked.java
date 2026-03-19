package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAskUnLocked extends MessageNano {
    private static volatile SCLiveAskUnLocked[] _emptyArray;
    public String askId;

    public static SCLiveAskUnLocked[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAskUnLocked[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAskUnLocked() {
        clear();
    }

    public final SCLiveAskUnLocked clear() {
        this.askId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.askId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.askId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.askId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.askId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAskUnLocked mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.askId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveAskUnLocked parseFrom(byte[] bArr) {
        return (SCLiveAskUnLocked) MessageNano.mergeFrom(new SCLiveAskUnLocked(), bArr);
    }

    public static SCLiveAskUnLocked parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAskUnLocked().mergeFrom(codedInputByteBufferNano);
    }
}
