package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveConditionLEEEFailPageUIConfig extends MessageNano {
    private static volatile LiveConditionLEEEFailPageUIConfig[] _emptyArray;
    public String avatarDesc;
    public String emptyViewDesc;
    public String emptyViewDescMainState;

    public static LiveConditionLEEEFailPageUIConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveConditionLEEEFailPageUIConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveConditionLEEEFailPageUIConfig() {
        clear();
    }

    public final LiveConditionLEEEFailPageUIConfig clear() {
        this.avatarDesc = "";
        this.emptyViewDesc = "";
        this.emptyViewDescMainState = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.avatarDesc.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.avatarDesc);
        }
        if (!this.emptyViewDesc.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.emptyViewDesc);
        }
        if (!this.emptyViewDescMainState.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.emptyViewDescMainState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.avatarDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.avatarDesc);
        }
        if (!this.emptyViewDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.emptyViewDesc);
        }
        return !this.emptyViewDescMainState.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.emptyViewDescMainState) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveConditionLEEEFailPageUIConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.avatarDesc = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.emptyViewDesc = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.emptyViewDescMainState = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveConditionLEEEFailPageUIConfig parseFrom(byte[] bArr) {
        return (LiveConditionLEEEFailPageUIConfig) MessageNano.mergeFrom(new LiveConditionLEEEFailPageUIConfig(), bArr);
    }

    public static LiveConditionLEEEFailPageUIConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveConditionLEEEFailPageUIConfig().mergeFrom(codedInputByteBufferNano);
    }
}
