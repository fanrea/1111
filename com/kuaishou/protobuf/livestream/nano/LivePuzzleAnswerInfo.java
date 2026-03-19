package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePuzzleAnswerInfo extends MessageNano {
    private static volatile LivePuzzleAnswerInfo[] _emptyArray;
    public int answerId;
    public String answerName;
    public boolean isDefault;

    public static LivePuzzleAnswerInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePuzzleAnswerInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePuzzleAnswerInfo() {
        clear();
    }

    public final LivePuzzleAnswerInfo clear() {
        this.answerId = 0;
        this.isDefault = false;
        this.answerName = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.answerId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        boolean z = this.isDefault;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        if (!this.answerName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.answerName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.answerId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        boolean z = this.isDefault;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        return !this.answerName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.answerName) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePuzzleAnswerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.answerId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.isDefault = codedInputByteBufferNano.readBool();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.answerName = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LivePuzzleAnswerInfo parseFrom(byte[] bArr) {
        return (LivePuzzleAnswerInfo) MessageNano.mergeFrom(new LivePuzzleAnswerInfo(), bArr);
    }

    public static LivePuzzleAnswerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePuzzleAnswerInfo().mergeFrom(codedInputByteBufferNano);
    }
}
