package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAskAnsweringQuestion extends MessageNano {
    private static volatile SCLiveAskAnsweringQuestion[] _emptyArray;
    public Question answeringQuestion;
    public String askId;

    public static SCLiveAskAnsweringQuestion[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAskAnsweringQuestion[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAskAnsweringQuestion() {
        clear();
    }

    public final SCLiveAskAnsweringQuestion clear() {
        this.askId = "";
        this.answeringQuestion = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.askId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.askId);
        }
        Question question = this.answeringQuestion;
        if (question != null) {
            codedOutputByteBufferNano.writeMessage(2, question);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.askId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.askId);
        }
        Question question = this.answeringQuestion;
        return question != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, question) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAskAnsweringQuestion mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.askId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.answeringQuestion == null) {
                    this.answeringQuestion = new Question();
                }
                codedInputByteBufferNano.readMessage(this.answeringQuestion);
            }
        }
    }

    public static SCLiveAskAnsweringQuestion parseFrom(byte[] bArr) {
        return (SCLiveAskAnsweringQuestion) MessageNano.mergeFrom(new SCLiveAskAnsweringQuestion(), bArr);
    }

    public static SCLiveAskAnsweringQuestion parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAskAnsweringQuestion().mergeFrom(codedInputByteBufferNano);
    }
}
