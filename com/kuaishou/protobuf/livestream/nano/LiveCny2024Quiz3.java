package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.cny2023.message.nano.CnyCdnDegradeProto;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024Quiz3 {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Quiz3Status {
        public static final int ANSWER_PUBLISHED = 5;
        public static final int EMERGENCY_OFFLINE = 10;
        public static final int QUESTION_PUBLISH = 4;
        public static final int ROUND_START = 3;
        public static final int ROUND_WAITING_RELEASE = 6;
        public static final int ROUND_WINNER_RELEASED = 7;
        public static final int SEGMENT_END = 8;
        public static final int SEGMENT_PREHEAT = 1;
        public static final int SEGMENT_START = 2;
        public static final int TIMEOUT_CLOSED = 9;
        public static final int UNKNOWN_QUIZ_STATUS = 0;
    }

    public static final class SCLiveQuiz3Question extends MessageNano {
        private static volatile SCLiveQuiz3Question[] _emptyArray;
        public int correctOptionId;
        public long queryStatusMaxDelayMs;
        public LiveQuiz3QuestionModel question;
        public CnyCdnDegradeProto.DegradablePicUrl questionCardTitle;
        public long questionCloseDelayMs;
        public long questionLatestDelayShowTimeMs;
        public long questionShowDurationMs;
        public long questionShowMinRestMs;
        public LiveQuiz3Activity quizActivity;
        public LiveQuiz3ReviveCardInfo reviveCardInfo;
        public String revivedDisplayText;
        public CnyCdnDegradeProto.DegradablePicUrl simpleWinAnimation;
        public int submitAnswerRetryTimes;
        public long submitMaxDelayMs;
        public CnyCdnDegradeProto.DegradablePicUrl timeOutAnimation;
        public CnyCdnDegradeProto.DegradablePicUrl winAnimation;

        public static SCLiveQuiz3Question[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3Question[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3Question() {
            clear();
        }

        public final SCLiveQuiz3Question clear() {
            this.quizActivity = null;
            this.question = null;
            this.reviveCardInfo = null;
            this.questionLatestDelayShowTimeMs = 0L;
            this.questionShowDurationMs = 0L;
            this.questionCloseDelayMs = 0L;
            this.queryStatusMaxDelayMs = 0L;
            this.submitMaxDelayMs = 0L;
            this.questionShowMinRestMs = 0L;
            this.timeOutAnimation = null;
            this.correctOptionId = 0;
            this.revivedDisplayText = "";
            this.winAnimation = null;
            this.questionCardTitle = null;
            this.simpleWinAnimation = null;
            this.submitAnswerRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz3Activity liveQuiz3Activity = this.quizActivity;
            if (liveQuiz3Activity != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz3Activity);
            }
            LiveQuiz3QuestionModel liveQuiz3QuestionModel = this.question;
            if (liveQuiz3QuestionModel != null) {
                codedOutputByteBufferNano.writeMessage(2, liveQuiz3QuestionModel);
            }
            LiveQuiz3ReviveCardInfo liveQuiz3ReviveCardInfo = this.reviveCardInfo;
            if (liveQuiz3ReviveCardInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, liveQuiz3ReviveCardInfo);
            }
            long j = this.questionLatestDelayShowTimeMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.questionShowDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.questionCloseDelayMs;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            long j4 = this.queryStatusMaxDelayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j4);
            }
            long j5 = this.submitMaxDelayMs;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j5);
            }
            long j6 = this.questionShowMinRestMs;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j6);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.timeOutAnimation;
            if (degradablePicUrl != null) {
                codedOutputByteBufferNano.writeMessage(10, degradablePicUrl);
            }
            int i = this.correctOptionId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(11, i);
            }
            if (!this.revivedDisplayText.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.revivedDisplayText);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl2 = this.winAnimation;
            if (degradablePicUrl2 != null) {
                codedOutputByteBufferNano.writeMessage(13, degradablePicUrl2);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl3 = this.questionCardTitle;
            if (degradablePicUrl3 != null) {
                codedOutputByteBufferNano.writeMessage(14, degradablePicUrl3);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl4 = this.simpleWinAnimation;
            if (degradablePicUrl4 != null) {
                codedOutputByteBufferNano.writeMessage(15, degradablePicUrl4);
            }
            int i2 = this.submitAnswerRetryTimes;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(16, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz3Activity liveQuiz3Activity = this.quizActivity;
            if (liveQuiz3Activity != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz3Activity);
            }
            LiveQuiz3QuestionModel liveQuiz3QuestionModel = this.question;
            if (liveQuiz3QuestionModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveQuiz3QuestionModel);
            }
            LiveQuiz3ReviveCardInfo liveQuiz3ReviveCardInfo = this.reviveCardInfo;
            if (liveQuiz3ReviveCardInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveQuiz3ReviveCardInfo);
            }
            long j = this.questionLatestDelayShowTimeMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.questionShowDurationMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.questionCloseDelayMs;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            long j4 = this.queryStatusMaxDelayMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
            }
            long j5 = this.submitMaxDelayMs;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j5);
            }
            long j6 = this.questionShowMinRestMs;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j6);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.timeOutAnimation;
            if (degradablePicUrl != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, degradablePicUrl);
            }
            int i = this.correctOptionId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i);
            }
            if (!this.revivedDisplayText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.revivedDisplayText);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl2 = this.winAnimation;
            if (degradablePicUrl2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, degradablePicUrl2);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl3 = this.questionCardTitle;
            if (degradablePicUrl3 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, degradablePicUrl3);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl4 = this.simpleWinAnimation;
            if (degradablePicUrl4 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, degradablePicUrl4);
            }
            int i2 = this.submitAnswerRetryTimes;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(16, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3Question mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.quizActivity == null) {
                            this.quizActivity = new LiveQuiz3Activity();
                        }
                        codedInputByteBufferNano.readMessage(this.quizActivity);
                        break;
                    case 18:
                        if (this.question == null) {
                            this.question = new LiveQuiz3QuestionModel();
                        }
                        codedInputByteBufferNano.readMessage(this.question);
                        break;
                    case 26:
                        if (this.reviveCardInfo == null) {
                            this.reviveCardInfo = new LiveQuiz3ReviveCardInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.reviveCardInfo);
                        break;
                    case 32:
                        this.questionLatestDelayShowTimeMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.questionShowDurationMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
                        this.questionCloseDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.queryStatusMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.submitMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 72:
                        this.questionShowMinRestMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 82:
                        if (this.timeOutAnimation == null) {
                            this.timeOutAnimation = new CnyCdnDegradeProto.DegradablePicUrl();
                        }
                        codedInputByteBufferNano.readMessage(this.timeOutAnimation);
                        break;
                    case 88:
                        this.correctOptionId = codedInputByteBufferNano.readUInt32();
                        break;
                    case 98:
                        this.revivedDisplayText = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        if (this.winAnimation == null) {
                            this.winAnimation = new CnyCdnDegradeProto.DegradablePicUrl();
                        }
                        codedInputByteBufferNano.readMessage(this.winAnimation);
                        break;
                    case 114:
                        if (this.questionCardTitle == null) {
                            this.questionCardTitle = new CnyCdnDegradeProto.DegradablePicUrl();
                        }
                        codedInputByteBufferNano.readMessage(this.questionCardTitle);
                        break;
                    case 122:
                        if (this.simpleWinAnimation == null) {
                            this.simpleWinAnimation = new CnyCdnDegradeProto.DegradablePicUrl();
                        }
                        codedInputByteBufferNano.readMessage(this.simpleWinAnimation);
                        break;
                    case 128:
                        this.submitAnswerRetryTimes = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveQuiz3Question parseFrom(byte[] bArr) {
            return (SCLiveQuiz3Question) MessageNano.mergeFrom(new SCLiveQuiz3Question(), bArr);
        }

        public static SCLiveQuiz3Question parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3Question().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3Sync extends MessageNano {
        private static volatile SCLiveQuiz3Sync[] _emptyArray;
        public long getAwardTokenMaxDelayMs;
        public long queryStatusMaxDelayMs;
        public int queryStatusRetryTimes;
        public LiveQuiz3Activity quizActivity;

        public static SCLiveQuiz3Sync[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3Sync[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3Sync() {
            clear();
        }

        public final SCLiveQuiz3Sync clear() {
            this.quizActivity = null;
            this.queryStatusMaxDelayMs = 0L;
            this.getAwardTokenMaxDelayMs = 0L;
            this.queryStatusRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz3Activity liveQuiz3Activity = this.quizActivity;
            if (liveQuiz3Activity != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz3Activity);
            }
            long j = this.queryStatusMaxDelayMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.getAwardTokenMaxDelayMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i = this.queryStatusRetryTimes;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz3Activity liveQuiz3Activity = this.quizActivity;
            if (liveQuiz3Activity != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz3Activity);
            }
            long j = this.queryStatusMaxDelayMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.getAwardTokenMaxDelayMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i = this.queryStatusRetryTimes;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3Sync mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.quizActivity == null) {
                        this.quizActivity = new LiveQuiz3Activity();
                    }
                    codedInputByteBufferNano.readMessage(this.quizActivity);
                } else if (tag == 16) {
                    this.queryStatusMaxDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.getAwardTokenMaxDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.queryStatusRetryTimes = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCLiveQuiz3Sync parseFrom(byte[] bArr) {
            return (SCLiveQuiz3Sync) MessageNano.mergeFrom(new SCLiveQuiz3Sync(), bArr);
        }

        public static SCLiveQuiz3Sync parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3Sync().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3EmergencyEnded extends MessageNano {
        private static volatile SCLiveQuiz3EmergencyEnded[] _emptyArray;
        public int questionIndex;
        public LiveQuiz3Activity quizActivity;

        public static SCLiveQuiz3EmergencyEnded[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3EmergencyEnded[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3EmergencyEnded() {
            clear();
        }

        public final SCLiveQuiz3EmergencyEnded clear() {
            this.quizActivity = null;
            this.questionIndex = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveQuiz3Activity liveQuiz3Activity = this.quizActivity;
            if (liveQuiz3Activity != null) {
                codedOutputByteBufferNano.writeMessage(1, liveQuiz3Activity);
            }
            int i = this.questionIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveQuiz3Activity liveQuiz3Activity = this.quizActivity;
            if (liveQuiz3Activity != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveQuiz3Activity);
            }
            int i = this.questionIndex;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3EmergencyEnded mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.quizActivity == null) {
                        this.quizActivity = new LiveQuiz3Activity();
                    }
                    codedInputByteBufferNano.readMessage(this.quizActivity);
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.questionIndex = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCLiveQuiz3EmergencyEnded parseFrom(byte[] bArr) {
            return (SCLiveQuiz3EmergencyEnded) MessageNano.mergeFrom(new SCLiveQuiz3EmergencyEnded(), bArr);
        }

        public static SCLiveQuiz3EmergencyEnded parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3EmergencyEnded().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3ReviveCardSync extends MessageNano {
        private static volatile SCLiveQuiz3ReviveCardSync[] _emptyArray;
        public long activityId;
        public long latestReviveCardUpdateTime;
        public int quizAvailableReviveCard;

        public static SCLiveQuiz3ReviveCardSync[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3ReviveCardSync[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3ReviveCardSync() {
            clear();
        }

        public final SCLiveQuiz3ReviveCardSync clear() {
            this.quizAvailableReviveCard = 0;
            this.activityId = 0L;
            this.latestReviveCardUpdateTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.quizAvailableReviveCard;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.activityId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.latestReviveCardUpdateTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.quizAvailableReviveCard;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.activityId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.latestReviveCardUpdateTime;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3ReviveCardSync mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.quizAvailableReviveCard = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.latestReviveCardUpdateTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveQuiz3ReviveCardSync parseFrom(byte[] bArr) {
            return (SCLiveQuiz3ReviveCardSync) MessageNano.mergeFrom(new SCLiveQuiz3ReviveCardSync(), bArr);
        }

        public static SCLiveQuiz3ReviveCardSync parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3ReviveCardSync().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz3Activity extends MessageNano {
        private static volatile LiveQuiz3Activity[] _emptyArray;
        public long currentRoundId;
        public long currentSegmentId;
        public long id;
        public long startTime;
        public int status;

        public static LiveQuiz3Activity[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz3Activity[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz3Activity() {
            clear();
        }

        public final LiveQuiz3Activity clear() {
            this.id = 0L;
            this.startTime = 0L;
            this.status = 0;
            this.currentSegmentId = 0L;
            this.currentRoundId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            long j3 = this.currentSegmentId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j3);
            }
            long j4 = this.currentRoundId;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            long j3 = this.currentSegmentId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
            }
            long j4 = this.currentRoundId;
            return j4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz3Activity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
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
                        case 8:
                        case 9:
                        case 10:
                            this.status = int32;
                            break;
                    }
                } else if (tag == 32) {
                    this.currentSegmentId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.currentRoundId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveQuiz3Activity parseFrom(byte[] bArr) {
            return (LiveQuiz3Activity) MessageNano.mergeFrom(new LiveQuiz3Activity(), bArr);
        }

        public static LiveQuiz3Activity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz3Activity().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz3QuestionModel extends MessageNano {
        private static volatile LiveQuiz3QuestionModel[] _emptyArray;
        public CnyCdnDegradeProto.DegradablePicUrl logoPicUrl;
        public LiveQuiz3OptionModel[] options;
        public long questionId;
        public int questionIndex;
        public boolean shuffleOptions;
        public String title;

        public static LiveQuiz3QuestionModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz3QuestionModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz3QuestionModel() {
            clear();
        }

        public final LiveQuiz3QuestionModel clear() {
            this.questionIndex = 0;
            this.title = "";
            this.options = LiveQuiz3OptionModel.emptyArray();
            this.logoPicUrl = null;
            this.shuffleOptions = false;
            this.questionId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.questionIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            LiveQuiz3OptionModel[] liveQuiz3OptionModelArr = this.options;
            if (liveQuiz3OptionModelArr != null && liveQuiz3OptionModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuiz3OptionModel[] liveQuiz3OptionModelArr2 = this.options;
                    if (i2 >= liveQuiz3OptionModelArr2.length) {
                        break;
                    }
                    LiveQuiz3OptionModel liveQuiz3OptionModel = liveQuiz3OptionModelArr2[i2];
                    if (liveQuiz3OptionModel != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveQuiz3OptionModel);
                    }
                    i2++;
                }
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.logoPicUrl;
            if (degradablePicUrl != null) {
                codedOutputByteBufferNano.writeMessage(4, degradablePicUrl);
            }
            boolean z = this.shuffleOptions;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            long j = this.questionId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.questionIndex;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            LiveQuiz3OptionModel[] liveQuiz3OptionModelArr = this.options;
            if (liveQuiz3OptionModelArr != null && liveQuiz3OptionModelArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuiz3OptionModel[] liveQuiz3OptionModelArr2 = this.options;
                    if (i2 >= liveQuiz3OptionModelArr2.length) {
                        break;
                    }
                    LiveQuiz3OptionModel liveQuiz3OptionModel = liveQuiz3OptionModelArr2[i2];
                    if (liveQuiz3OptionModel != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveQuiz3OptionModel);
                    }
                    i2++;
                }
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.logoPicUrl;
            if (degradablePicUrl != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, degradablePicUrl);
            }
            boolean z = this.shuffleOptions;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            long j = this.questionId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz3QuestionModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.questionIndex = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveQuiz3OptionModel[] liveQuiz3OptionModelArr = this.options;
                    int length = liveQuiz3OptionModelArr == null ? 0 : liveQuiz3OptionModelArr.length;
                    LiveQuiz3OptionModel[] liveQuiz3OptionModelArr2 = new LiveQuiz3OptionModel[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.options, 0, liveQuiz3OptionModelArr2, 0, length);
                    }
                    while (length < liveQuiz3OptionModelArr2.length - 1) {
                        liveQuiz3OptionModelArr2[length] = new LiveQuiz3OptionModel();
                        codedInputByteBufferNano.readMessage(liveQuiz3OptionModelArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveQuiz3OptionModelArr2[length] = new LiveQuiz3OptionModel();
                    codedInputByteBufferNano.readMessage(liveQuiz3OptionModelArr2[length]);
                    this.options = liveQuiz3OptionModelArr2;
                } else if (tag == 34) {
                    if (this.logoPicUrl == null) {
                        this.logoPicUrl = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.logoPicUrl);
                } else if (tag == 40) {
                    this.shuffleOptions = codedInputByteBufferNano.readBool();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.questionId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveQuiz3QuestionModel parseFrom(byte[] bArr) {
            return (LiveQuiz3QuestionModel) MessageNano.mergeFrom(new LiveQuiz3QuestionModel(), bArr);
        }

        public static LiveQuiz3QuestionModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz3QuestionModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz3OptionModel extends MessageNano {
        private static volatile LiveQuiz3OptionModel[] _emptyArray;
        public String body;
        public int id;
        public float voteRate;
        public String voteRateView;

        public static LiveQuiz3OptionModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz3OptionModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz3OptionModel() {
            clear();
        }

        public final LiveQuiz3OptionModel clear() {
            this.id = 0;
            this.body = "";
            this.voteRate = 0.0f;
            this.voteRateView = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.id;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.body.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.body);
            }
            if (Float.floatToIntBits(this.voteRate) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(3, this.voteRate);
            }
            if (!this.voteRateView.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.voteRateView);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.id;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.body.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.body);
            }
            if (Float.floatToIntBits(this.voteRate) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.voteRate);
            }
            return !this.voteRateView.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.voteRateView) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz3OptionModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.body = codedInputByteBufferNano.readString();
                } else if (tag == 29) {
                    this.voteRate = codedInputByteBufferNano.readFloat();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.voteRateView = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveQuiz3OptionModel parseFrom(byte[] bArr) {
            return (LiveQuiz3OptionModel) MessageNano.mergeFrom(new LiveQuiz3OptionModel(), bArr);
        }

        public static LiveQuiz3OptionModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz3OptionModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz3ReviveCardInfo extends MessageNano {
        private static volatile LiveQuiz3ReviveCardInfo[] _emptyArray;
        public CnyCdnDegradeProto.DegradablePicUrl animation;
        public CnyCdnDegradeProto.DegradablePicUrl icon;
        public String title;

        public static LiveQuiz3ReviveCardInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz3ReviveCardInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz3ReviveCardInfo() {
            clear();
        }

        public final LiveQuiz3ReviveCardInfo clear() {
            this.icon = null;
            this.animation = null;
            this.title = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.icon;
            if (degradablePicUrl != null) {
                codedOutputByteBufferNano.writeMessage(1, degradablePicUrl);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl2 = this.animation;
            if (degradablePicUrl2 != null) {
                codedOutputByteBufferNano.writeMessage(2, degradablePicUrl2);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.title);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.icon;
            if (degradablePicUrl != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, degradablePicUrl);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl2 = this.animation;
            if (degradablePicUrl2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, degradablePicUrl2);
            }
            return !this.title.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.title) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz3ReviveCardInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.icon == null) {
                        this.icon = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.icon);
                } else if (tag == 18) {
                    if (this.animation == null) {
                        this.animation = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.animation);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.title = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveQuiz3ReviveCardInfo parseFrom(byte[] bArr) {
            return (LiveQuiz3ReviveCardInfo) MessageNano.mergeFrom(new LiveQuiz3ReviveCardInfo(), bArr);
        }

        public static LiveQuiz3ReviveCardInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz3ReviveCardInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3ParticipateWinnerCalculation extends MessageNano {
        private static volatile SCLiveQuiz3ParticipateWinnerCalculation[] _emptyArray;
        public long activityId;
        public long roundId;
        public long winnerSignUpDelayTime;
        public int winnerSignUpRetryTimes;

        public static SCLiveQuiz3ParticipateWinnerCalculation[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3ParticipateWinnerCalculation[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3ParticipateWinnerCalculation() {
            clear();
        }

        public final SCLiveQuiz3ParticipateWinnerCalculation clear() {
            this.winnerSignUpDelayTime = 0L;
            this.activityId = 0L;
            this.roundId = 0L;
            this.winnerSignUpRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.winnerSignUpDelayTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.activityId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.roundId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            int i = this.winnerSignUpRetryTimes;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.winnerSignUpDelayTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.activityId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.roundId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            int i = this.winnerSignUpRetryTimes;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3ParticipateWinnerCalculation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.winnerSignUpDelayTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.roundId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.winnerSignUpRetryTimes = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCLiveQuiz3ParticipateWinnerCalculation parseFrom(byte[] bArr) {
            return (SCLiveQuiz3ParticipateWinnerCalculation) MessageNano.mergeFrom(new SCLiveQuiz3ParticipateWinnerCalculation(), bArr);
        }

        public static SCLiveQuiz3ParticipateWinnerCalculation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3ParticipateWinnerCalculation().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3EndWinnerCalculation extends MessageNano {
        private static volatile SCLiveQuiz3EndWinnerCalculation[] _emptyArray;
        public long activityId;
        public long queryAfterWinnerReleasedDelayTime;
        public int queryAfterWinnerReleasedRetryTimes;
        public long roundId;

        public static SCLiveQuiz3EndWinnerCalculation[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3EndWinnerCalculation[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3EndWinnerCalculation() {
            clear();
        }

        public final SCLiveQuiz3EndWinnerCalculation clear() {
            this.queryAfterWinnerReleasedDelayTime = 0L;
            this.activityId = 0L;
            this.roundId = 0L;
            this.queryAfterWinnerReleasedRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.queryAfterWinnerReleasedDelayTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.activityId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.roundId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            int i = this.queryAfterWinnerReleasedRetryTimes;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.queryAfterWinnerReleasedDelayTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.activityId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.roundId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            int i = this.queryAfterWinnerReleasedRetryTimes;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3EndWinnerCalculation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.queryAfterWinnerReleasedDelayTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.roundId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.queryAfterWinnerReleasedRetryTimes = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCLiveQuiz3EndWinnerCalculation parseFrom(byte[] bArr) {
            return (SCLiveQuiz3EndWinnerCalculation) MessageNano.mergeFrom(new SCLiveQuiz3EndWinnerCalculation(), bArr);
        }

        public static SCLiveQuiz3EndWinnerCalculation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3EndWinnerCalculation().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3StartPublishRoundWinner extends MessageNano {
        private static volatile SCLiveQuiz3StartPublishRoundWinner[] _emptyArray;
        public long activityId;
        public long latestAfterReleasedWinnerShowTimestamp;
        public long queryAfterWinnerReleasedDelayTime;
        public int queryAfterWinnerReleasedRetryTimes;
        public long roundId;

        public static SCLiveQuiz3StartPublishRoundWinner[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3StartPublishRoundWinner[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3StartPublishRoundWinner() {
            clear();
        }

        public final SCLiveQuiz3StartPublishRoundWinner clear() {
            this.queryAfterWinnerReleasedDelayTime = 0L;
            this.activityId = 0L;
            this.roundId = 0L;
            this.latestAfterReleasedWinnerShowTimestamp = 0L;
            this.queryAfterWinnerReleasedRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.queryAfterWinnerReleasedDelayTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.activityId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.roundId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            long j4 = this.latestAfterReleasedWinnerShowTimestamp;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j4);
            }
            int i = this.queryAfterWinnerReleasedRetryTimes;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.queryAfterWinnerReleasedDelayTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.activityId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.roundId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            long j4 = this.latestAfterReleasedWinnerShowTimestamp;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
            }
            int i = this.queryAfterWinnerReleasedRetryTimes;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3StartPublishRoundWinner mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.queryAfterWinnerReleasedDelayTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.roundId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.latestAfterReleasedWinnerShowTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.queryAfterWinnerReleasedRetryTimes = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCLiveQuiz3StartPublishRoundWinner parseFrom(byte[] bArr) {
            return (SCLiveQuiz3StartPublishRoundWinner) MessageNano.mergeFrom(new SCLiveQuiz3StartPublishRoundWinner(), bArr);
        }

        public static SCLiveQuiz3StartPublishRoundWinner parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3StartPublishRoundWinner().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuiz3PublishStageWinner extends MessageNano {
        private static volatile SCLiveQuiz3PublishStageWinner[] _emptyArray;
        public long activityId;
        public boolean enableDelayShow;
        public long publishStageWinnerDelayMillis;
        public int questionIndex;
        public String resultKwaiLink;

        public static SCLiveQuiz3PublishStageWinner[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuiz3PublishStageWinner[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuiz3PublishStageWinner() {
            clear();
        }

        public final SCLiveQuiz3PublishStageWinner clear() {
            this.resultKwaiLink = "";
            this.activityId = 0L;
            this.questionIndex = 0;
            this.enableDelayShow = false;
            this.publishStageWinnerDelayMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.resultKwaiLink.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.resultKwaiLink);
            }
            long j = this.activityId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i = this.questionIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            boolean z = this.enableDelayShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            long j2 = this.publishStageWinnerDelayMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.resultKwaiLink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.resultKwaiLink);
            }
            long j = this.activityId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i = this.questionIndex;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            boolean z = this.enableDelayShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
            }
            long j2 = this.publishStageWinnerDelayMillis;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuiz3PublishStageWinner mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.resultKwaiLink = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.questionIndex = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.enableDelayShow = codedInputByteBufferNano.readBool();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.publishStageWinnerDelayMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveQuiz3PublishStageWinner parseFrom(byte[] bArr) {
            return (SCLiveQuiz3PublishStageWinner) MessageNano.mergeFrom(new SCLiveQuiz3PublishStageWinner(), bArr);
        }

        public static SCLiveQuiz3PublishStageWinner parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuiz3PublishStageWinner().mergeFrom(codedInputByteBufferNano);
        }
    }
}
