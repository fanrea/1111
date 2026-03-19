package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePuzzleLineChatResourceInfo extends MessageNano {
    private static volatile LivePuzzleLineChatResourceInfo[] _emptyArray;
    public String versionResourcePath;

    public static LivePuzzleLineChatResourceInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePuzzleLineChatResourceInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePuzzleLineChatResourceInfo() {
        clear();
    }

    public final LivePuzzleLineChatResourceInfo clear() {
        this.versionResourcePath = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.versionResourcePath.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.versionResourcePath);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.versionResourcePath.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.versionResourcePath) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePuzzleLineChatResourceInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.versionResourcePath = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LivePuzzleLineChatResourceInfo parseFrom(byte[] bArr) {
        return (LivePuzzleLineChatResourceInfo) MessageNano.mergeFrom(new LivePuzzleLineChatResourceInfo(), bArr);
    }

    public static LivePuzzleLineChatResourceInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePuzzleLineChatResourceInfo().mergeFrom(codedInputByteBufferNano);
    }
}
