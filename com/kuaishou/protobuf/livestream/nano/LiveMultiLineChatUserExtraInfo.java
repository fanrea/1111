package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiLineChatUserExtraInfo extends MessageNano {
    private static volatile LiveMultiLineChatUserExtraInfo[] _emptyArray;
    public int matchType;

    public static LiveMultiLineChatUserExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiLineChatUserExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiLineChatUserExtraInfo() {
        clear();
    }

    public final LiveMultiLineChatUserExtraInfo clear() {
        this.matchType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.matchType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.matchType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiLineChatUserExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.matchType = int32;
                        break;
                }
            }
        }
    }

    public static LiveMultiLineChatUserExtraInfo parseFrom(byte[] bArr) {
        return (LiveMultiLineChatUserExtraInfo) MessageNano.mergeFrom(new LiveMultiLineChatUserExtraInfo(), bArr);
    }

    public static LiveMultiLineChatUserExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiLineChatUserExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
