package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCMultiPKPlayFashionSignal extends MessageNano {
    private static volatile SCMultiPKPlayFashionSignal[] _emptyArray;
    public MultiPKSignalCommonInfo commonInfo;
    public MultiPKPlayFashionInfo playFashionInfo;

    public static SCMultiPKPlayFashionSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMultiPKPlayFashionSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMultiPKPlayFashionSignal() {
        clear();
    }

    public final SCMultiPKPlayFashionSignal clear() {
        this.commonInfo = null;
        this.playFashionInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        MultiPKSignalCommonInfo multiPKSignalCommonInfo = this.commonInfo;
        if (multiPKSignalCommonInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, multiPKSignalCommonInfo);
        }
        MultiPKPlayFashionInfo multiPKPlayFashionInfo = this.playFashionInfo;
        if (multiPKPlayFashionInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, multiPKPlayFashionInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        MultiPKSignalCommonInfo multiPKSignalCommonInfo = this.commonInfo;
        if (multiPKSignalCommonInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, multiPKSignalCommonInfo);
        }
        MultiPKPlayFashionInfo multiPKPlayFashionInfo = this.playFashionInfo;
        return multiPKPlayFashionInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, multiPKPlayFashionInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMultiPKPlayFashionSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.commonInfo == null) {
                    this.commonInfo = new MultiPKSignalCommonInfo();
                }
                codedInputByteBufferNano.readMessage(this.commonInfo);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.playFashionInfo == null) {
                    this.playFashionInfo = new MultiPKPlayFashionInfo();
                }
                codedInputByteBufferNano.readMessage(this.playFashionInfo);
            }
        }
    }

    public static SCMultiPKPlayFashionSignal parseFrom(byte[] bArr) {
        return (SCMultiPKPlayFashionSignal) MessageNano.mergeFrom(new SCMultiPKPlayFashionSignal(), bArr);
    }

    public static SCMultiPKPlayFashionSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMultiPKPlayFashionSignal().mergeFrom(codedInputByteBufferNano);
    }
}
