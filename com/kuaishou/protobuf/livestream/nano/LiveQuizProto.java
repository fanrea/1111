package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveQuizProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveQuizEndType {
        public static final int FINAL_QUESTION_SPLIT_PRIZE = 1;
        public static final int FIRST_QUESTION_ALL_FAILED = 3;
        public static final int PREVIOUS_QUESTION_SPLIT_PRIZE = 2;
        public static final int UNKNOWN_END_TYPE = 0;
    }

    public static final class LiveQuizModel extends MessageNano {
        private static volatile LiveQuizModel[] _emptyArray;
        public String liveQuizId;
        public int prizeType;
        public long totalKsCoin;
        public int totalQuestions;

        @Retention(RetentionPolicy.SOURCE)
        public @interface PrizeType {
            public static final int STAGE_BONUS = 2;
            public static final int UNKNOWN = 0;
            public static final int WINNER_TAKE_ALL = 1;
        }

        public static LiveQuizModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuizModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuizModel() {
            clear();
        }

        public final LiveQuizModel clear() {
            this.liveQuizId = "";
            this.prizeType = 0;
            this.totalQuestions = 0;
            this.totalKsCoin = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveQuizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveQuizId);
            }
            int i = this.prizeType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            int i2 = this.totalQuestions;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            long j = this.totalKsCoin;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveQuizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveQuizId);
            }
            int i = this.prizeType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            int i2 = this.totalQuestions;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            long j = this.totalKsCoin;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuizModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveQuizId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.prizeType = int32;
                    }
                } else if (tag == 24) {
                    this.totalQuestions = codedInputByteBufferNano.readUInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.totalKsCoin = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveQuizModel parseFrom(byte[] bArr) {
            return (LiveQuizModel) MessageNano.mergeFrom(new LiveQuizModel(), bArr);
        }

        public static LiveQuizModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuizModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuizQuestionAsked extends MessageNano {
        private static volatile SCLiveQuizQuestionAsked[] _emptyArray;
        public boolean ignoreSubmitWaitEnd;
        public LiveQuizModel liveQuiz;
        public OptionModel[] option;
        public long questionEndTime;
        public int questionNumber;
        public long questionStartTime;
        public long submitMaxDelayMillis;
        public long syncMaxDelayMillis;
        public long time;
        public String title;
        public long waitEndSubmitMaxDelayMillis;

        public static SCLiveQuizQuestionAsked[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuizQuestionAsked[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuizQuestionAsked() {
            clear();
        }

        public final SCLiveQuizQuestionAsked clear() {
            this.time = 0L;
            this.liveQuiz = null;
            this.questionNumber = 0;
            this.questionStartTime = 0L;
            this.questionEndTime = 0L;
            this.title = "";
            this.option = OptionModel.emptyArray();
            this.submitMaxDelayMillis = 0L;
            this.syncMaxDelayMillis = 0L;
            this.ignoreSubmitWaitEnd = false;
            this.waitEndSubmitMaxDelayMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            LiveQuizModel liveQuizModel = this.liveQuiz;
            if (liveQuizModel != null) {
                codedOutputByteBufferNano.writeMessage(2, liveQuizModel);
            }
            int i = this.questionNumber;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j2 = this.questionStartTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            long j3 = this.questionEndTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j3);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.title);
            }
            OptionModel[] optionModelArr = this.option;
            if (optionModelArr != null && optionModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    OptionModel[] optionModelArr2 = this.option;
                    if (i2 >= optionModelArr2.length) {
                        break;
                    }
                    OptionModel optionModel = optionModelArr2[i2];
                    if (optionModel != null) {
                        codedOutputByteBufferNano.writeMessage(7, optionModel);
                    }
                    i2++;
                }
            }
            long j4 = this.submitMaxDelayMillis;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            long j5 = this.syncMaxDelayMillis;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j5);
            }
            boolean z = this.ignoreSubmitWaitEnd;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            long j6 = this.waitEndSubmitMaxDelayMillis;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j6);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.time;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            LiveQuizModel liveQuizModel = this.liveQuiz;
            if (liveQuizModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveQuizModel);
            }
            int i = this.questionNumber;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j2 = this.questionStartTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            long j3 = this.questionEndTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.title);
            }
            OptionModel[] optionModelArr = this.option;
            if (optionModelArr != null && optionModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    OptionModel[] optionModelArr2 = this.option;
                    if (i2 >= optionModelArr2.length) {
                        break;
                    }
                    OptionModel optionModel = optionModelArr2[i2];
                    if (optionModel != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, optionModel);
                    }
                    i2++;
                }
            }
            long j4 = this.submitMaxDelayMillis;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
            }
            long j5 = this.syncMaxDelayMillis;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j5);
            }
            boolean z = this.ignoreSubmitWaitEnd;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            long j6 = this.waitEndSubmitMaxDelayMillis;
            return j6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j6) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuizQuestionAsked mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.time = codedInputByteBufferNano.readUInt64();
                        break;
                    case 18:
                        if (this.liveQuiz == null) {
                            this.liveQuiz = new LiveQuizModel();
                        }
                        codedInputByteBufferNano.readMessage(this.liveQuiz);
                        break;
                    case 24:
                        this.questionNumber = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.questionStartTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.questionEndTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 50:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        OptionModel[] optionModelArr = this.option;
                        int length = optionModelArr == null ? 0 : optionModelArr.length;
                        OptionModel[] optionModelArr2 = new OptionModel[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.option, 0, optionModelArr2, 0, length);
                        }
                        while (length < optionModelArr2.length - 1) {
                            optionModelArr2[length] = new OptionModel();
                            codedInputByteBufferNano.readMessage(optionModelArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        optionModelArr2[length] = new OptionModel();
                        codedInputByteBufferNano.readMessage(optionModelArr2[length]);
                        this.option = optionModelArr2;
                        break;
                    case 64:
                        this.submitMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 72:
                        this.syncMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 80:
                        this.ignoreSubmitWaitEnd = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.waitEndSubmitMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveQuizQuestionAsked parseFrom(byte[] bArr) {
            return (SCLiveQuizQuestionAsked) MessageNano.mergeFrom(new SCLiveQuizQuestionAsked(), bArr);
        }

        public static SCLiveQuizQuestionAsked parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuizQuestionAsked().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class OptionModel extends MessageNano {
        private static volatile OptionModel[] _emptyArray;
        public String body;
        public String id;

        public static OptionModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OptionModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public OptionModel() {
            clear();
        }

        public final OptionModel clear() {
            this.id = "";
            this.body = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            if (!this.body.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.body);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            return !this.body.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.body) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final OptionModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.body = codedInputByteBufferNano.readString();
                }
            }
        }

        public static OptionModel parseFrom(byte[] bArr) {
            return (OptionModel) MessageNano.mergeFrom(new OptionModel(), bArr);
        }

        public static OptionModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new OptionModel().mergeFrom(codedInputByteBufferNano);
        }
    }
}
