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
public interface LiveQuiz2Proto {

    public static final class LiveQuiz2Model extends MessageNano {
        private static volatile LiveQuiz2Model[] _emptyArray;
        public int currencyType;
        public int groupUsageType;
        public String liveQuizId;
        public int optionShuffleType;
        public int prizeDistributeStrategy;
        public int quizFailType;
        public int reviveCardUsageType;
        public long totalAwardCurrency;
        public int totalQuestions;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CurrencyType {
            public static final int CASH = 1;
            public static final int KSCOIN = 2;
            public static final int UNKNOWN_CURRENCY_TYPE = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface GroupUsageType {
            public static final int GROUP_ALLOWED = 1;
            public static final int GROUP_FORBIDDEN = 2;
            public static final int UNKNOWN_GROUP_USAGE_TYPE = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface OptionShuffleType {
            public static final int CLIENT_RANDOM_SHUFFLE = 2;
            public static final int NO_SHUFFLE = 1;
            public static final int UNKNOWN_OPTION_SHUFFLE_TYPE = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface PrizeDistributeStrategy {
            public static final int AWARD_AFTER_FIXED_CORRECT_COUNT = 2;
            public static final int UNKNOWN_PRIZE_DISTRIBUTE_STRATEGY = 0;
            public static final int WINNER_TAKE_ALL = 1;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface QuizFailType {
            public static final int ELIMINATE_AFTER_WRONG = 1;
            public static final int NEVER_ELIMINATE = 2;
            public static final int UNKNOWN_QUIZ_FAIL_TYPE = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface ReviveCardUsageType {
            public static final int ALLOWED = 1;
            public static final int FORBIDDEN = 2;
            public static final int UNKNOWN_REVIVE_CARD_USAGE_TYPE = 0;
        }

        public static LiveQuiz2Model[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz2Model[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz2Model() {
            clear();
        }

        public final LiveQuiz2Model clear() {
            this.liveQuizId = "";
            this.totalQuestions = 0;
            this.totalAwardCurrency = 0L;
            this.quizFailType = 0;
            this.reviveCardUsageType = 0;
            this.prizeDistributeStrategy = 0;
            this.optionShuffleType = 0;
            this.currencyType = 0;
            this.groupUsageType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveQuizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveQuizId);
            }
            int i = this.totalQuestions;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j = this.totalAwardCurrency;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            int i2 = this.quizFailType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(5, i2);
            }
            int i3 = this.reviveCardUsageType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i3);
            }
            int i4 = this.prizeDistributeStrategy;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i4);
            }
            int i5 = this.optionShuffleType;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i5);
            }
            int i6 = this.currencyType;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeInt32(9, i6);
            }
            int i7 = this.groupUsageType;
            if (i7 != 0) {
                codedOutputByteBufferNano.writeInt32(10, i7);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveQuizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveQuizId);
            }
            int i = this.totalQuestions;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j = this.totalAwardCurrency;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            int i2 = this.quizFailType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
            }
            int i3 = this.reviveCardUsageType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            int i4 = this.prizeDistributeStrategy;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
            }
            int i5 = this.optionShuffleType;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i5);
            }
            int i6 = this.currencyType;
            if (i6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i6);
            }
            int i7 = this.groupUsageType;
            return i7 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, i7) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz2Model mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveQuizId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.totalQuestions = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.totalAwardCurrency = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.quizFailType = int32;
                    }
                } else if (tag == 48) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2) {
                        this.reviveCardUsageType = int322;
                    }
                } else if (tag == 56) {
                    int int323 = codedInputByteBufferNano.readInt32();
                    if (int323 == 0 || int323 == 1 || int323 == 2) {
                        this.prizeDistributeStrategy = int323;
                    }
                } else if (tag == 64) {
                    int int324 = codedInputByteBufferNano.readInt32();
                    if (int324 == 0 || int324 == 1 || int324 == 2) {
                        this.optionShuffleType = int324;
                    }
                } else if (tag == 72) {
                    int int325 = codedInputByteBufferNano.readInt32();
                    if (int325 == 0 || int325 == 1 || int325 == 2) {
                        this.currencyType = int325;
                    }
                } else if (tag != 80) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int326 = codedInputByteBufferNano.readInt32();
                    if (int326 == 0 || int326 == 1 || int326 == 2) {
                        this.groupUsageType = int326;
                    }
                }
            }
        }

        public static LiveQuiz2Model parseFrom(byte[] bArr) {
            return (LiveQuiz2Model) MessageNano.mergeFrom(new LiveQuiz2Model(), bArr);
        }

        public static LiveQuiz2Model parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz2Model().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz2OptionModel extends MessageNano {
        private static volatile LiveQuiz2OptionModel[] _emptyArray;
        public String body;
        public String id;

        public static LiveQuiz2OptionModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz2OptionModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz2OptionModel() {
            clear();
        }

        public final LiveQuiz2OptionModel clear() {
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
        public final LiveQuiz2OptionModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

        public static LiveQuiz2OptionModel parseFrom(byte[] bArr) {
            return (LiveQuiz2OptionModel) MessageNano.mergeFrom(new LiveQuiz2OptionModel(), bArr);
        }

        public static LiveQuiz2OptionModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz2OptionModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz2Ended extends MessageNano {
        private static volatile LiveQuiz2Ended[] _emptyArray;
        public int endType;
        public long maxWaitAwardReviewSignalDurationMs;
        public long toastAwardMaxDelayMs;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveQuizEndType {
            public static final int END_IN_ADVANCE_NO_WINNER = 2;
            public static final int FINAL_QUESTION_SHARE_PRIZE = 1;
            public static final int UNKNOWN_END_TYPE = 0;
        }

        public static LiveQuiz2Ended[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz2Ended[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz2Ended() {
            clear();
        }

        public final LiveQuiz2Ended clear() {
            this.endType = 0;
            this.toastAwardMaxDelayMs = 0L;
            this.maxWaitAwardReviewSignalDurationMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.endType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.toastAwardMaxDelayMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.maxWaitAwardReviewSignalDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.endType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.toastAwardMaxDelayMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.maxWaitAwardReviewSignalDurationMs;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz2Ended mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.endType = int32;
                    }
                } else if (tag == 16) {
                    this.toastAwardMaxDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxWaitAwardReviewSignalDurationMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveQuiz2Ended parseFrom(byte[] bArr) {
            return (LiveQuiz2Ended) MessageNano.mergeFrom(new LiveQuiz2Ended(), bArr);
        }

        public static LiveQuiz2Ended parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz2Ended().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz2RevivedCountInfo extends MessageNano {
        private static volatile LiveQuiz2RevivedCountInfo[] _emptyArray;
        public String revivedCount;
        public float revivedRate;

        public static LiveQuiz2RevivedCountInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz2RevivedCountInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz2RevivedCountInfo() {
            clear();
        }

        public final LiveQuiz2RevivedCountInfo clear() {
            this.revivedRate = 0.0f;
            this.revivedCount = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (Float.floatToIntBits(this.revivedRate) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(1, this.revivedRate);
            }
            if (!this.revivedCount.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.revivedCount);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (Float.floatToIntBits(this.revivedRate) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.revivedRate);
            }
            return !this.revivedCount.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.revivedCount) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz2RevivedCountInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 13) {
                    this.revivedRate = codedInputByteBufferNano.readFloat();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.revivedCount = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveQuiz2RevivedCountInfo parseFrom(byte[] bArr) {
            return (LiveQuiz2RevivedCountInfo) MessageNano.mergeFrom(new LiveQuiz2RevivedCountInfo(), bArr);
        }

        public static LiveQuiz2RevivedCountInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz2RevivedCountInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz2OptionWithStat extends MessageNano {
        private static volatile LiveQuiz2OptionWithStat[] _emptyArray;
        public LiveQuiz2OptionModel option;
        public String voteCount;
        public float voteRate;

        public static LiveQuiz2OptionWithStat[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz2OptionWithStat[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz2OptionWithStat() {
            clear();
        }

        public final LiveQuiz2OptionWithStat clear() {
            this.option = null;
            this.voteRate = 0.0f;
            this.voteCount = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz2OptionModel liveQuiz2OptionModel = this.option;
            if (liveQuiz2OptionModel != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz2OptionModel);
            }
            if (Float.floatToIntBits(this.voteRate) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(2, this.voteRate);
            }
            if (!this.voteCount.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.voteCount);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz2OptionModel liveQuiz2OptionModel = this.option;
            if (liveQuiz2OptionModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz2OptionModel);
            }
            if (Float.floatToIntBits(this.voteRate) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.voteRate);
            }
            return !this.voteCount.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.voteCount) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz2OptionWithStat mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.option == null) {
                        this.option = new LiveQuiz2OptionModel();
                    }
                    codedInputByteBufferNano.readMessage(this.option);
                } else if (tag == 21) {
                    this.voteRate = codedInputByteBufferNano.readFloat();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.voteCount = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveQuiz2OptionWithStat parseFrom(byte[] bArr) {
            return (LiveQuiz2OptionWithStat) MessageNano.mergeFrom(new LiveQuiz2OptionWithStat(), bArr);
        }

        public static LiveQuiz2OptionWithStat parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz2OptionWithStat().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz2Sync extends MessageNano {
        private static volatile SCLiveQuiz2Sync[] _emptyArray;
        public LiveQuiz2Model liveQuiz;
        public long maxDelayMs;
        public int syncType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface SyncType {
            public static final int SYNC_AVAILABLE_REVIVE_CARD = 2;
            public static final int SYNC_QUIZ_STATUS = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveQuiz2Sync[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz2Sync[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz2Sync() {
            clear();
        }

        public final SCLiveQuiz2Sync clear() {
            this.syncType = 0;
            this.liveQuiz = null;
            this.maxDelayMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.syncType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                codedOutputByteBufferNano.writeMessage(2, liveQuiz2Model);
            }
            long j = this.maxDelayMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.syncType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveQuiz2Model);
            }
            long j = this.maxDelayMs;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz2Sync mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.syncType = int32;
                    }
                } else if (tag == 18) {
                    if (this.liveQuiz == null) {
                        this.liveQuiz = new LiveQuiz2Model();
                    }
                    codedInputByteBufferNano.readMessage(this.liveQuiz);
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxDelayMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveQuiz2Sync parseFrom(byte[] bArr) {
            return (SCLiveQuiz2Sync) MessageNano.mergeFrom(new SCLiveQuiz2Sync(), bArr);
        }

        public static SCLiveQuiz2Sync parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz2Sync().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz2QuestionAsked extends MessageNano {
        private static volatile SCLiveQuiz2QuestionAsked[] _emptyArray;
        public String eraserErrorAnswer;
        public LiveQuiz2Model liveQuiz;
        public String logoPicUrl;
        public LiveQuiz2OptionModel[] option;
        public long questionEndTimeMs;
        public int questionNumber;
        public long questionStartTimeMs;
        public long submitMaxDelayMs;
        public long syncMaxDelayMs;
        public String title;

        public static SCLiveQuiz2QuestionAsked[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz2QuestionAsked[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz2QuestionAsked() {
            clear();
        }

        public final SCLiveQuiz2QuestionAsked clear() {
            this.liveQuiz = null;
            this.questionNumber = 0;
            this.questionStartTimeMs = 0L;
            this.questionEndTimeMs = 0L;
            this.title = "";
            this.option = LiveQuiz2OptionModel.emptyArray();
            this.submitMaxDelayMs = 0L;
            this.syncMaxDelayMs = 0L;
            this.logoPicUrl = "";
            this.eraserErrorAnswer = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz2Model);
            }
            int i = this.questionNumber;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j = this.questionStartTimeMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.questionEndTimeMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.title);
            }
            LiveQuiz2OptionModel[] liveQuiz2OptionModelArr = this.option;
            if (liveQuiz2OptionModelArr != null && liveQuiz2OptionModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuiz2OptionModel[] liveQuiz2OptionModelArr2 = this.option;
                    if (i2 >= liveQuiz2OptionModelArr2.length) {
                        break;
                    }
                    LiveQuiz2OptionModel liveQuiz2OptionModel = liveQuiz2OptionModelArr2[i2];
                    if (liveQuiz2OptionModel != null) {
                        codedOutputByteBufferNano.writeMessage(6, liveQuiz2OptionModel);
                    }
                    i2++;
                }
            }
            long j3 = this.submitMaxDelayMs;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            long j4 = this.syncMaxDelayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            if (!this.logoPicUrl.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.logoPicUrl);
            }
            if (!this.eraserErrorAnswer.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.eraserErrorAnswer);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz2Model);
            }
            int i = this.questionNumber;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j = this.questionStartTimeMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.questionEndTimeMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.title);
            }
            LiveQuiz2OptionModel[] liveQuiz2OptionModelArr = this.option;
            if (liveQuiz2OptionModelArr != null && liveQuiz2OptionModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuiz2OptionModel[] liveQuiz2OptionModelArr2 = this.option;
                    if (i2 >= liveQuiz2OptionModelArr2.length) {
                        break;
                    }
                    LiveQuiz2OptionModel liveQuiz2OptionModel = liveQuiz2OptionModelArr2[i2];
                    if (liveQuiz2OptionModel != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveQuiz2OptionModel);
                    }
                    i2++;
                }
            }
            long j3 = this.submitMaxDelayMs;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            long j4 = this.syncMaxDelayMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
            }
            if (!this.logoPicUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.logoPicUrl);
            }
            return !this.eraserErrorAnswer.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.eraserErrorAnswer) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz2QuestionAsked mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.liveQuiz == null) {
                            this.liveQuiz = new LiveQuiz2Model();
                        }
                        codedInputByteBufferNano.readMessage(this.liveQuiz);
                        break;
                    case 16:
                        this.questionNumber = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        this.questionStartTimeMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 32:
                        this.questionEndTimeMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 42:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        LiveQuiz2OptionModel[] liveQuiz2OptionModelArr = this.option;
                        int length = liveQuiz2OptionModelArr == null ? 0 : liveQuiz2OptionModelArr.length;
                        LiveQuiz2OptionModel[] liveQuiz2OptionModelArr2 = new LiveQuiz2OptionModel[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.option, 0, liveQuiz2OptionModelArr2, 0, length);
                        }
                        while (length < liveQuiz2OptionModelArr2.length - 1) {
                            liveQuiz2OptionModelArr2[length] = new LiveQuiz2OptionModel();
                            codedInputByteBufferNano.readMessage(liveQuiz2OptionModelArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveQuiz2OptionModelArr2[length] = new LiveQuiz2OptionModel();
                        codedInputByteBufferNano.readMessage(liveQuiz2OptionModelArr2[length]);
                        this.option = liveQuiz2OptionModelArr2;
                        break;
                    case 56:
                        this.submitMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.syncMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 74:
                        this.logoPicUrl = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.eraserErrorAnswer = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveQuiz2QuestionAsked parseFrom(byte[] bArr) {
            return (SCLiveQuiz2QuestionAsked) MessageNano.mergeFrom(new SCLiveQuiz2QuestionAsked(), bArr);
        }

        public static SCLiveQuiz2QuestionAsked parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz2QuestionAsked().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz2QuestionReviewed extends MessageNano {
        private static volatile SCLiveQuiz2QuestionReviewed[] _emptyArray;
        public String correctOptionId;
        public LiveQuiz2Ended ended;
        public String eraserErrorAnswer;
        public LiveQuiz2Model liveQuiz;
        public String logoPicUrl;
        public LiveQuiz2OptionWithStat[] optionWithStat;
        public long queryGiftMaxDelayMs;
        public int questionNumber;
        public long requestAfterAnswerMaxDelayMs;
        public long requestAfterAnswerMinDelayMs;
        public long reviewEndTime;
        public long reviewStartTime;
        public LiveQuiz2RevivedCountInfo revivedCountInfo;
        public long syncMaxDelayMs;
        public String title;

        public static SCLiveQuiz2QuestionReviewed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz2QuestionReviewed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz2QuestionReviewed() {
            clear();
        }

        public final SCLiveQuiz2QuestionReviewed clear() {
            this.liveQuiz = null;
            this.questionNumber = 0;
            this.reviewStartTime = 0L;
            this.reviewEndTime = 0L;
            this.title = "";
            this.optionWithStat = LiveQuiz2OptionWithStat.emptyArray();
            this.correctOptionId = "";
            this.ended = null;
            this.syncMaxDelayMs = 0L;
            this.revivedCountInfo = null;
            this.logoPicUrl = "";
            this.queryGiftMaxDelayMs = 0L;
            this.requestAfterAnswerMaxDelayMs = 0L;
            this.requestAfterAnswerMinDelayMs = 0L;
            this.eraserErrorAnswer = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz2Model);
            }
            int i = this.questionNumber;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j = this.reviewStartTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.reviewEndTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.title);
            }
            LiveQuiz2OptionWithStat[] liveQuiz2OptionWithStatArr = this.optionWithStat;
            if (liveQuiz2OptionWithStatArr != null && liveQuiz2OptionWithStatArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuiz2OptionWithStat[] liveQuiz2OptionWithStatArr2 = this.optionWithStat;
                    if (i2 >= liveQuiz2OptionWithStatArr2.length) {
                        break;
                    }
                    LiveQuiz2OptionWithStat liveQuiz2OptionWithStat = liveQuiz2OptionWithStatArr2[i2];
                    if (liveQuiz2OptionWithStat != null) {
                        codedOutputByteBufferNano.writeMessage(6, liveQuiz2OptionWithStat);
                    }
                    i2++;
                }
            }
            if (!this.correctOptionId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.correctOptionId);
            }
            LiveQuiz2Ended liveQuiz2Ended = this.ended;
            if (liveQuiz2Ended != null) {
                codedOutputByteBufferNano.writeMessage(8, liveQuiz2Ended);
            }
            long j3 = this.syncMaxDelayMs;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j3);
            }
            LiveQuiz2RevivedCountInfo liveQuiz2RevivedCountInfo = this.revivedCountInfo;
            if (liveQuiz2RevivedCountInfo != null) {
                codedOutputByteBufferNano.writeMessage(10, liveQuiz2RevivedCountInfo);
            }
            if (!this.logoPicUrl.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.logoPicUrl);
            }
            long j4 = this.queryGiftMaxDelayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(12, j4);
            }
            long j5 = this.requestAfterAnswerMaxDelayMs;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j5);
            }
            long j6 = this.requestAfterAnswerMinDelayMs;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(14, j6);
            }
            if (!this.eraserErrorAnswer.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.eraserErrorAnswer);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz2Model);
            }
            int i = this.questionNumber;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j = this.reviewStartTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.reviewEndTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.title);
            }
            LiveQuiz2OptionWithStat[] liveQuiz2OptionWithStatArr = this.optionWithStat;
            if (liveQuiz2OptionWithStatArr != null && liveQuiz2OptionWithStatArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuiz2OptionWithStat[] liveQuiz2OptionWithStatArr2 = this.optionWithStat;
                    if (i2 >= liveQuiz2OptionWithStatArr2.length) {
                        break;
                    }
                    LiveQuiz2OptionWithStat liveQuiz2OptionWithStat = liveQuiz2OptionWithStatArr2[i2];
                    if (liveQuiz2OptionWithStat != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveQuiz2OptionWithStat);
                    }
                    i2++;
                }
            }
            if (!this.correctOptionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.correctOptionId);
            }
            LiveQuiz2Ended liveQuiz2Ended = this.ended;
            if (liveQuiz2Ended != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveQuiz2Ended);
            }
            long j3 = this.syncMaxDelayMs;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
            }
            LiveQuiz2RevivedCountInfo liveQuiz2RevivedCountInfo = this.revivedCountInfo;
            if (liveQuiz2RevivedCountInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, liveQuiz2RevivedCountInfo);
            }
            if (!this.logoPicUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.logoPicUrl);
            }
            long j4 = this.queryGiftMaxDelayMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j4);
            }
            long j5 = this.requestAfterAnswerMaxDelayMs;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j5);
            }
            long j6 = this.requestAfterAnswerMinDelayMs;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j6);
            }
            return !this.eraserErrorAnswer.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(15, this.eraserErrorAnswer) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz2QuestionReviewed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.liveQuiz == null) {
                            this.liveQuiz = new LiveQuiz2Model();
                        }
                        codedInputByteBufferNano.readMessage(this.liveQuiz);
                        break;
                    case 16:
                        this.questionNumber = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        this.reviewStartTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 32:
                        this.reviewEndTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 42:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        LiveQuiz2OptionWithStat[] liveQuiz2OptionWithStatArr = this.optionWithStat;
                        int length = liveQuiz2OptionWithStatArr == null ? 0 : liveQuiz2OptionWithStatArr.length;
                        LiveQuiz2OptionWithStat[] liveQuiz2OptionWithStatArr2 = new LiveQuiz2OptionWithStat[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.optionWithStat, 0, liveQuiz2OptionWithStatArr2, 0, length);
                        }
                        while (length < liveQuiz2OptionWithStatArr2.length - 1) {
                            liveQuiz2OptionWithStatArr2[length] = new LiveQuiz2OptionWithStat();
                            codedInputByteBufferNano.readMessage(liveQuiz2OptionWithStatArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveQuiz2OptionWithStatArr2[length] = new LiveQuiz2OptionWithStat();
                        codedInputByteBufferNano.readMessage(liveQuiz2OptionWithStatArr2[length]);
                        this.optionWithStat = liveQuiz2OptionWithStatArr2;
                        break;
                    case 58:
                        this.correctOptionId = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        if (this.ended == null) {
                            this.ended = new LiveQuiz2Ended();
                        }
                        codedInputByteBufferNano.readMessage(this.ended);
                        break;
                    case 72:
                        this.syncMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 82:
                        if (this.revivedCountInfo == null) {
                            this.revivedCountInfo = new LiveQuiz2RevivedCountInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.revivedCountInfo);
                        break;
                    case 90:
                        this.logoPicUrl = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        this.queryGiftMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 104:
                        this.requestAfterAnswerMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 112:
                        this.requestAfterAnswerMinDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 122:
                        this.eraserErrorAnswer = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveQuiz2QuestionReviewed parseFrom(byte[] bArr) {
            return (SCLiveQuiz2QuestionReviewed) MessageNano.mergeFrom(new SCLiveQuiz2QuestionReviewed(), bArr);
        }

        public static SCLiveQuiz2QuestionReviewed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz2QuestionReviewed().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz2InitConfig extends MessageNano {
        private static volatile SCLiveQuiz2InitConfig[] _emptyArray;
        public String enterRoomNoticeDesc;
        public LiveQuiz2Model liveQuiz;

        public static SCLiveQuiz2InitConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz2InitConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz2InitConfig() {
            clear();
        }

        public final SCLiveQuiz2InitConfig clear() {
            this.liveQuiz = null;
            this.enterRoomNoticeDesc = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz2Model);
            }
            if (!this.enterRoomNoticeDesc.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.enterRoomNoticeDesc);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz2Model);
            }
            return !this.enterRoomNoticeDesc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.enterRoomNoticeDesc) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz2InitConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.liveQuiz == null) {
                        this.liveQuiz = new LiveQuiz2Model();
                    }
                    codedInputByteBufferNano.readMessage(this.liveQuiz);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enterRoomNoticeDesc = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveQuiz2InitConfig parseFrom(byte[] bArr) {
            return (SCLiveQuiz2InitConfig) MessageNano.mergeFrom(new SCLiveQuiz2InitConfig(), bArr);
        }

        public static SCLiveQuiz2InitConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz2InitConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz2CloseConfig extends MessageNano {
        private static volatile SCLiveQuiz2CloseConfig[] _emptyArray;
        public LiveQuiz2Model liveQuiz;

        public static SCLiveQuiz2CloseConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz2CloseConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz2CloseConfig() {
            clear();
        }

        public final SCLiveQuiz2CloseConfig clear() {
            this.liveQuiz = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz2Model);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            return liveQuiz2Model != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz2Model) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz2CloseConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.liveQuiz == null) {
                        this.liveQuiz = new LiveQuiz2Model();
                    }
                    codedInputByteBufferNano.readMessage(this.liveQuiz);
                }
            }
        }

        public static SCLiveQuiz2CloseConfig parseFrom(byte[] bArr) {
            return (SCLiveQuiz2CloseConfig) MessageNano.mergeFrom(new SCLiveQuiz2CloseConfig(), bArr);
        }

        public static SCLiveQuiz2CloseConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz2CloseConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz2EmergencyEnded extends MessageNano {
        private static volatile SCLiveQuiz2EmergencyEnded[] _emptyArray;
        public LiveQuiz2Model liveQuiz;

        public static SCLiveQuiz2EmergencyEnded[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz2EmergencyEnded[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz2EmergencyEnded() {
            clear();
        }

        public final SCLiveQuiz2EmergencyEnded clear() {
            this.liveQuiz = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            if (liveQuiz2Model != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz2Model);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz2Model liveQuiz2Model = this.liveQuiz;
            return liveQuiz2Model != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz2Model) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz2EmergencyEnded mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.liveQuiz == null) {
                        this.liveQuiz = new LiveQuiz2Model();
                    }
                    codedInputByteBufferNano.readMessage(this.liveQuiz);
                }
            }
        }

        public static SCLiveQuiz2EmergencyEnded parseFrom(byte[] bArr) {
            return (SCLiveQuiz2EmergencyEnded) MessageNano.mergeFrom(new SCLiveQuiz2EmergencyEnded(), bArr);
        }

        public static SCLiveQuiz2EmergencyEnded parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz2EmergencyEnded().mergeFrom(codedInputByteBufferNano);
        }
    }
}
