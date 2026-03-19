package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAskQuestionStatusChange extends MessageNano {
    private static volatile SCLiveAskQuestionStatusChange[] _emptyArray;
    public String askId;
    public String audienceToast;
    public String authorToast;
    public int changeType;
    public String questionId;

    public static SCLiveAskQuestionStatusChange[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAskQuestionStatusChange[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAskQuestionStatusChange() {
        clear();
    }

    public final SCLiveAskQuestionStatusChange clear() {
        this.askId = "";
        this.questionId = "";
        this.changeType = 0;
        this.authorToast = "";
        this.audienceToast = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.askId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.askId);
        }
        if (!this.questionId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.questionId);
        }
        int i = this.changeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        if (!this.authorToast.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.authorToast);
        }
        if (!this.audienceToast.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.audienceToast);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.askId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.askId);
        }
        if (!this.questionId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.questionId);
        }
        int i = this.changeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        if (!this.authorToast.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.authorToast);
        }
        return !this.audienceToast.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.audienceToast) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAskQuestionStatusChange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.askId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.questionId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.changeType = int32;
                }
            } else if (tag == 34) {
                this.authorToast = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.audienceToast = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveAskQuestionStatusChange parseFrom(byte[] bArr) {
        return (SCLiveAskQuestionStatusChange) MessageNano.mergeFrom(new SCLiveAskQuestionStatusChange(), bArr);
    }

    public static SCLiveAskQuestionStatusChange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAskQuestionStatusChange().mergeFrom(codedInputByteBufferNano);
    }
}
