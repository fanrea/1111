package com.kuaishou.protobuf.livestream.mmu.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveMMU {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BizType {
        public static final int LIVE_ROBOT = 1;
        public static final int LIVE_SHOP = 5;
        public static final int LIVE_TTS = 2;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RobotReqType {
        public static final int REQ_TYPE_ACTION_RESULT = 4;
        public static final int REQ_TYPE_ASR = 0;
        public static final int REQ_TYPE_CLOSE = 3;
        public static final int REQ_TYPE_NLU = 1;
        public static final int REQ_TYPE_TTS = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RtSpeechRecognitionResultCode {
        public static final int BAIDU_AUDIO_SERVICE_ERROR = 4;
        public static final int BLOB_STORE_ERROR = 11;
        public static final int ERROR = 3;
        public static final int FAILED = 10;
        public static final int ILLEGAL = 12;
        public static final int ILLEGAL_FACE_DETECTED = 9;
        public static final int INPUT_EMPTY = 2;
        public static final int NO_FACE_DETECTED = 7;
        public static final int NO_FACE_MATCHED = 8;
        public static final int OUTPUT_EMPTY = 5;
        public static final int OVER_RATE_LIMIT = 13;
        public static final int PARTAL_SUCCESS = 6;
        public static final int REJECT = 14;
        public static final int SUCESS = 1;
        public static final int UNKOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RtSpeechRecognitionType {
        public static final int APPEND = 1;
        public static final int CLOSE = 2;
        public static final int NEW = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionStatus {
        public static final int SESSION_CLOSE_JUMP = 2;
        public static final int SESSION_CLOSE_SINGLE = 1;
        public static final int SESSION_CLOSE_SLOTS_OVER = 4;
        public static final int SESSION_CLOSE_TOO_MUCH_TURN = 3;
        public static final int SESSION_CONTINUE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpeechResultType {
        public static final int DOMAIN_NO_SUPPORT = 2;
        public static final int RESULT_NOT_UNDERSTAND = 0;
        public static final int RESULT_NO_RESOURCE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpeechRobotActionType {
        public static final int ACTION_CHAT_CHAT_PLAY = 8001;
        public static final int ACTION_COMMENT = 15001;
        public static final int ACTION_COMMENT_FULL = 15002;
        public static final int ACTION_COMMENT_VOICE = 15003;
        public static final int ACTION_CONNECTION_FRIEND = 30000;
        public static final int ACTION_FOLLOW = 12001;
        public static final int ACTION_FOREGROUND_BACK = 13001;
        public static final int ACTION_FUNCTION_EXIT_PLAY = 7007;
        public static final int ACTION_FUNCTION_FUNCTION_CLOSE = 7002;
        public static final int ACTION_FUNCTION_FUNCTION_OPEN = 7001;
        public static final int ACTION_FUNCTION_MAX_VOLUME = 7008;
        public static final int ACTION_FUNCTION_MIN_VOLUME = 7009;
        public static final int ACTION_FUNCTION_PLAY_ON = 7004;
        public static final int ACTION_FUNCTION_PLAY_STOP = 7003;
        public static final int ACTION_FUNCTION_SET_OPTION = 7010;
        public static final int ACTION_FUNCTION_VOLUME_DOWN = 7006;
        public static final int ACTION_FUNCTION_VOLUME_UP = 7005;
        public static final int ACTION_GRAB_PACKET = 14001;
        public static final int ACTION_JOKE_JOKE_PLAY = 3001;
        public static final int ACTION_MAGIC_MAGIC_CHANGE = 6003;
        public static final int ACTION_MAGIC_MAGIC_CLOSE = 6002;
        public static final int ACTION_MAGIC_MAGIC_DETAIL_CHANGE = 6004;
        public static final int ACTION_MAGIC_MAGIC_OPEN = 6001;
        public static final int ACTION_MICRO_USER = 31000;
        public static final int ACTION_MUSIC_CHANGE_SONG = 1015;
        public static final int ACTION_MUSIC_LAST_SONG = 1013;
        public static final int ACTION_MUSIC_LIKE = 1008;
        public static final int ACTION_MUSIC_NEXT_SONG = 1014;
        public static final int ACTION_MUSIC_PLAY = 1005;
        public static final int ACTION_MUSIC_PLAY_SINGER = 1002;
        public static final int ACTION_MUSIC_PLAY_SINGER_SONG = 1004;
        public static final int ACTION_MUSIC_PLAY_SONG = 1001;
        public static final int ACTION_MUSIC_PLAY_STYLE = 1003;
        public static final int ACTION_MUSIC_UNLIKE = 1009;
        public static final int ACTION_PACKET_PACKET_OPEN = 5001;
        public static final int ACTION_PET_ACTION_OPEN = 10001;
        public static final int ACTION_PK_CASUAL_PK = 2001;
        public static final int ACTION_PK_CITY_PK = 2002;
        public static final int ACTION_PK_FRIEND_DETAIL_PK = 2005;
        public static final int ACTION_PK_FRIEND_PK = 2003;
        public static final int ACTION_PK_TALENT_PK = 2004;
        public static final int ACTION_REPORT_BLACK_LIST = 9001;
        public static final int ACTION_REWARD = 16001;
        public static final int ACTION_REWARD_AGAIN = 16007;
        public static final int ACTION_REWARD_CANCEL = 16006;
        public static final int ACTION_REWARD_CONFIRM = 16005;
        public static final int ACTION_REWARD_COUNT = 16003;
        public static final int ACTION_REWARD_FULL = 16004;
        public static final int ACTION_REWARD_NAME = 16002;
        public static final int ACTION_REWARD_NOT_FOUND = 16009;
        public static final int ACTION_REWARD_OTHER = 16008;
        public static final int ACTION_REWARD_SILENT = 16010;
        public static final int ACTION_STORY_STORY_LAY = 4001;
        public static final int ACTION_THUMP_UP = 11001;
        public static final int ACTION_UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpeechRobotInfoStatus {
        public static final int FINISH = 3;
        public static final int RESULT_NOT_CLEAR = 6;
        public static final int ROBOT_ERROR = 0;
        public static final int SEND_CONTINUE = 1;
        public static final int SEND_STOP = 2;
        public static final int UNEXPECTED_RESULT = 7;
        public static final int WAKEUP_FALSE = 5;
        public static final int WAKEUP_TRUE = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SpeechRobotSkillType {
        public static final int SKILL_CHAT = 8;
        public static final int SKILL_COMMENT = 15;
        public static final int SKILL_CONNECTION = 30;
        public static final int SKILL_FOLLOW = 12;
        public static final int SKILL_FOREGROUND = 13;
        public static final int SKILL_FUNCTION = 7;
        public static final int SKILL_GRAB_PACKER = 14;
        public static final int SKILL_JOKE = 3;
        public static final int SKILL_MAGIC = 6;
        public static final int SKILL_MICRO = 31;
        public static final int SKILL_MUSIC = 1;
        public static final int SKILL_PACKET = 5;
        public static final int SKILL_PET = 10;
        public static final int SKILL_PK = 2;
        public static final int SKILL_REPORT = 9;
        public static final int SKILL_REWARD = 16;
        public static final int SKILL_STORY = 4;
        public static final int SKILL_THUMP_UP = 11;
        public static final int SKILL_UNKNOWN = 0;
    }

    public static final class RtSpeechRecognitionRequest extends MessageNano {
        private static volatile RtSpeechRecognitionRequest[] _emptyArray;
        public byte[] audioData;
        public int channel;
        public int disableDigit;
        public int disablePunctuation;
        public String format;
        public String[] hotWord;
        public String model;
        public String reqId;
        public int sampleRate;
        public long serialNo;
        public int type;
        public String userId;

        public static RtSpeechRecognitionRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RtSpeechRecognitionRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RtSpeechRecognitionRequest() {
            clear();
        }

        public final RtSpeechRecognitionRequest clear() {
            this.reqId = "";
            this.type = 0;
            this.serialNo = 0L;
            this.audioData = WireFormatNano.EMPTY_BYTES;
            this.userId = "";
            this.model = "";
            this.format = "";
            this.channel = 0;
            this.sampleRate = 0;
            this.disablePunctuation = 0;
            this.disableDigit = 0;
            this.hotWord = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.reqId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.reqId);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            long j = this.serialNo;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            if (!Arrays.equals(this.audioData, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(4, this.audioData);
            }
            if (!this.userId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.userId);
            }
            if (!this.model.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.model);
            }
            if (!this.format.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.format);
            }
            int i2 = this.channel;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i2);
            }
            int i3 = this.sampleRate;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(9, i3);
            }
            int i4 = this.disablePunctuation;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(10, i4);
            }
            int i5 = this.disableDigit;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(11, i5);
            }
            String[] strArr = this.hotWord;
            if (strArr != null && strArr.length > 0) {
                int i6 = 0;
                while (true) {
                    String[] strArr2 = this.hotWord;
                    if (i6 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i6];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(12, str);
                    }
                    i6++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.reqId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.reqId);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            long j = this.serialNo;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
            }
            if (!Arrays.equals(this.audioData, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.audioData);
            }
            if (!this.userId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.userId);
            }
            if (!this.model.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.model);
            }
            if (!this.format.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.format);
            }
            int i2 = this.channel;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i2);
            }
            int i3 = this.sampleRate;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i3);
            }
            int i4 = this.disablePunctuation;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i4);
            }
            int i5 = this.disableDigit;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i5);
            }
            String[] strArr = this.hotWord;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i6 = 0;
            int iComputeStringSizeNoTag = 0;
            int i7 = 0;
            while (true) {
                String[] strArr2 = this.hotWord;
                if (i6 >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i7 * 1);
                }
                String str = strArr2[i6];
                if (str != null) {
                    i7++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i6++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RtSpeechRecognitionRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.reqId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            break;
                        } else {
                            this.type = int32;
                            break;
                        }
                    case 24:
                        this.serialNo = codedInputByteBufferNano.readInt64();
                        break;
                    case 34:
                        this.audioData = codedInputByteBufferNano.readBytes();
                        break;
                    case 42:
                        this.userId = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.model = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.format = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.channel = codedInputByteBufferNano.readInt32();
                        break;
                    case 72:
                        this.sampleRate = codedInputByteBufferNano.readInt32();
                        break;
                    case 80:
                        this.disablePunctuation = codedInputByteBufferNano.readInt32();
                        break;
                    case 88:
                        this.disableDigit = codedInputByteBufferNano.readInt32();
                        break;
                    case 98:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        String[] strArr = this.hotWord;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.hotWord, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.hotWord = strArr2;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static RtSpeechRecognitionRequest parseFrom(byte[] bArr) {
            return (RtSpeechRecognitionRequest) MessageNano.mergeFrom(new RtSpeechRecognitionRequest(), bArr);
        }

        public static RtSpeechRecognitionRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RtSpeechRecognitionRequest().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SpeechRobotInfo extends MessageNano {
        private static volatile SpeechRobotInfo[] _emptyArray;
        public int status;
        public int unexpectedResult;

        public static SpeechRobotInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SpeechRobotInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SpeechRobotInfo() {
            clear();
        }

        public final SpeechRobotInfo clear() {
            this.status = 0;
            this.unexpectedResult = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.unexpectedResult;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.unexpectedResult;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SpeechRobotInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
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
                            this.status = int32;
                            break;
                    }
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2) {
                        this.unexpectedResult = int322;
                    }
                }
            }
        }

        public static SpeechRobotInfo parseFrom(byte[] bArr) {
            return (SpeechRobotInfo) MessageNano.mergeFrom(new SpeechRobotInfo(), bArr);
        }

        public static SpeechRobotInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SpeechRobotInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RtSpeechRecognitionResponse extends MessageNano {
        private static volatile RtSpeechRecognitionResponse[] _emptyArray;
        public String dynamicResult;
        public String recognitionResult;
        public String reqId;
        public RtSpeechRecognitionResultDetail[] resultDetail;
        public SpeechRobotInfo robotInfo;
        public long serialNo;
        public int status;

        public static RtSpeechRecognitionResponse[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RtSpeechRecognitionResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RtSpeechRecognitionResponse() {
            clear();
        }

        public final RtSpeechRecognitionResponse clear() {
            this.resultDetail = RtSpeechRecognitionResultDetail.emptyArray();
            this.dynamicResult = "";
            this.status = 0;
            this.serialNo = 0L;
            this.recognitionResult = "";
            this.robotInfo = null;
            this.reqId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RtSpeechRecognitionResultDetail[] rtSpeechRecognitionResultDetailArr = this.resultDetail;
            if (rtSpeechRecognitionResultDetailArr != null && rtSpeechRecognitionResultDetailArr.length > 0) {
                int i = 0;
                while (true) {
                    RtSpeechRecognitionResultDetail[] rtSpeechRecognitionResultDetailArr2 = this.resultDetail;
                    if (i >= rtSpeechRecognitionResultDetailArr2.length) {
                        break;
                    }
                    RtSpeechRecognitionResultDetail rtSpeechRecognitionResultDetail = rtSpeechRecognitionResultDetailArr2[i];
                    if (rtSpeechRecognitionResultDetail != null) {
                        codedOutputByteBufferNano.writeMessage(1, rtSpeechRecognitionResultDetail);
                    }
                    i++;
                }
            }
            if (!this.dynamicResult.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.dynamicResult);
            }
            int i2 = this.status;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i2);
            }
            long j = this.serialNo;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(4, j);
            }
            if (!this.recognitionResult.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.recognitionResult);
            }
            SpeechRobotInfo speechRobotInfo = this.robotInfo;
            if (speechRobotInfo != null) {
                codedOutputByteBufferNano.writeMessage(6, speechRobotInfo);
            }
            if (!this.reqId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.reqId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RtSpeechRecognitionResultDetail[] rtSpeechRecognitionResultDetailArr = this.resultDetail;
            if (rtSpeechRecognitionResultDetailArr != null && rtSpeechRecognitionResultDetailArr.length > 0) {
                int i = 0;
                while (true) {
                    RtSpeechRecognitionResultDetail[] rtSpeechRecognitionResultDetailArr2 = this.resultDetail;
                    if (i >= rtSpeechRecognitionResultDetailArr2.length) {
                        break;
                    }
                    RtSpeechRecognitionResultDetail rtSpeechRecognitionResultDetail = rtSpeechRecognitionResultDetailArr2[i];
                    if (rtSpeechRecognitionResultDetail != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rtSpeechRecognitionResultDetail);
                    }
                    i++;
                }
            }
            if (!this.dynamicResult.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.dynamicResult);
            }
            int i2 = this.status;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
            }
            long j = this.serialNo;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j);
            }
            if (!this.recognitionResult.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.recognitionResult);
            }
            SpeechRobotInfo speechRobotInfo = this.robotInfo;
            if (speechRobotInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, speechRobotInfo);
            }
            return !this.reqId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.reqId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RtSpeechRecognitionResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    RtSpeechRecognitionResultDetail[] rtSpeechRecognitionResultDetailArr = this.resultDetail;
                    int length = rtSpeechRecognitionResultDetailArr == null ? 0 : rtSpeechRecognitionResultDetailArr.length;
                    RtSpeechRecognitionResultDetail[] rtSpeechRecognitionResultDetailArr2 = new RtSpeechRecognitionResultDetail[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.resultDetail, 0, rtSpeechRecognitionResultDetailArr2, 0, length);
                    }
                    while (length < rtSpeechRecognitionResultDetailArr2.length - 1) {
                        rtSpeechRecognitionResultDetailArr2[length] = new RtSpeechRecognitionResultDetail();
                        codedInputByteBufferNano.readMessage(rtSpeechRecognitionResultDetailArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    rtSpeechRecognitionResultDetailArr2[length] = new RtSpeechRecognitionResultDetail();
                    codedInputByteBufferNano.readMessage(rtSpeechRecognitionResultDetailArr2[length]);
                    this.resultDetail = rtSpeechRecognitionResultDetailArr2;
                } else if (tag == 18) {
                    this.dynamicResult = codedInputByteBufferNano.readString();
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
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            this.status = int32;
                            break;
                    }
                } else if (tag == 32) {
                    this.serialNo = codedInputByteBufferNano.readInt64();
                } else if (tag == 42) {
                    this.recognitionResult = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    if (this.robotInfo == null) {
                        this.robotInfo = new SpeechRobotInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.robotInfo);
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.reqId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RtSpeechRecognitionResponse parseFrom(byte[] bArr) {
            return (RtSpeechRecognitionResponse) MessageNano.mergeFrom(new RtSpeechRecognitionResponse(), bArr);
        }

        public static RtSpeechRecognitionResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RtSpeechRecognitionResponse().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RtNLUResponse extends MessageNano {
        private static volatile RtNLUResponse[] _emptyArray;
        public Instruction instruction;

        public static RtNLUResponse[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RtNLUResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RtNLUResponse() {
            clear();
        }

        public final RtNLUResponse clear() {
            this.instruction = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Instruction instruction = this.instruction;
            if (instruction != null) {
                codedOutputByteBufferNano.writeMessage(1, instruction);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Instruction instruction = this.instruction;
            return instruction != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, instruction) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RtNLUResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.instruction == null) {
                        this.instruction = new Instruction();
                    }
                    codedInputByteBufferNano.readMessage(this.instruction);
                }
            }
        }

        public static RtNLUResponse parseFrom(byte[] bArr) {
            return (RtNLUResponse) MessageNano.mergeFrom(new RtNLUResponse(), bArr);
        }

        public static RtNLUResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RtNLUResponse().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RtSpeechRecognitionResultDetail extends MessageNano {
        private static volatile RtSpeechRecognitionResultDetail[] _emptyArray;
        public float endTime;
        public String fixedResult;
        public float startTime;

        public static RtSpeechRecognitionResultDetail[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RtSpeechRecognitionResultDetail[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RtSpeechRecognitionResultDetail() {
            clear();
        }

        public final RtSpeechRecognitionResultDetail clear() {
            this.fixedResult = "";
            this.startTime = 0.0f;
            this.endTime = 0.0f;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.fixedResult.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.fixedResult);
            }
            if (Float.floatToIntBits(this.startTime) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(2, this.startTime);
            }
            if (Float.floatToIntBits(this.endTime) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(3, this.endTime);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.fixedResult.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.fixedResult);
            }
            if (Float.floatToIntBits(this.startTime) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.startTime);
            }
            return Float.floatToIntBits(this.endTime) != Float.floatToIntBits(0.0f) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, this.endTime) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RtSpeechRecognitionResultDetail mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.fixedResult = codedInputByteBufferNano.readString();
                } else if (tag == 21) {
                    this.startTime = codedInputByteBufferNano.readFloat();
                } else if (tag != 29) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.endTime = codedInputByteBufferNano.readFloat();
                }
            }
        }

        public static RtSpeechRecognitionResultDetail parseFrom(byte[] bArr) {
            return (RtSpeechRecognitionResultDetail) MessageNano.mergeFrom(new RtSpeechRecognitionResultDetail(), bArr);
        }

        public static RtSpeechRecognitionResultDetail parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RtSpeechRecognitionResultDetail().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Instruction extends MessageNano {
        private static volatile Instruction[] _emptyArray;
        public int action;
        public int actionResult;
        public int multiTurn;
        public int sessionStatus;
        public int skill;
        public String slots;
        public int turnCount;

        public static Instruction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Instruction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Instruction() {
            clear();
        }

        public final Instruction clear() {
            this.skill = 0;
            this.action = 0;
            this.slots = "";
            this.multiTurn = 0;
            this.turnCount = 0;
            this.sessionStatus = 0;
            this.actionResult = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.skill;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.action;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            if (!this.slots.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.slots);
            }
            int i3 = this.multiTurn;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i3);
            }
            int i4 = this.turnCount;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(5, i4);
            }
            int i5 = this.sessionStatus;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i5);
            }
            int i6 = this.actionResult;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i6);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.skill;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.action;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            if (!this.slots.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.slots);
            }
            int i3 = this.multiTurn;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
            }
            int i4 = this.turnCount;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i4);
            }
            int i5 = this.sessionStatus;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i5);
            }
            int i6 = this.actionResult;
            return i6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i6) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Instruction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 30 && int32 != 31) {
                        switch (int32) {
                        }
                    }
                    this.skill = int32;
                } else if (tag == 16) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1008 && int322 != 1009) {
                        switch (int322) {
                            case 0:
                            case 3001:
                            case 4001:
                            case 5001:
                            case 8001:
                            case 9001:
                            case 10001:
                            case 11001:
                            case 12001:
                            case SpeechRobotActionType.ACTION_FOREGROUND_BACK /* 13001 */:
                            case 14001:
                            case 30000:
                            case SpeechRobotActionType.ACTION_MICRO_USER /* 31000 */:
                                break;
                            default:
                                switch (int322) {
                                    case 1001:
                                    case 1002:
                                    case 1003:
                                    case 1004:
                                    case 1005:
                                        break;
                                    default:
                                        switch (int322) {
                                            case 1013:
                                            case 1014:
                                            case 1015:
                                                break;
                                            default:
                                                switch (int322) {
                                                    case 2001:
                                                    case 2002:
                                                    case 2003:
                                                    case 2004:
                                                    case 2005:
                                                        break;
                                                    default:
                                                        switch (int322) {
                                                            case 6001:
                                                            case 6002:
                                                            case SpeechRobotActionType.ACTION_MAGIC_MAGIC_CHANGE /* 6003 */:
                                                            case 6004:
                                                                break;
                                                            default:
                                                                switch (int322) {
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_FUNCTION_OPEN /* 7001 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_FUNCTION_CLOSE /* 7002 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_PLAY_STOP /* 7003 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_PLAY_ON /* 7004 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_VOLUME_UP /* 7005 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_VOLUME_DOWN /* 7006 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_EXIT_PLAY /* 7007 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_MAX_VOLUME /* 7008 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_MIN_VOLUME /* 7009 */:
                                                                    case SpeechRobotActionType.ACTION_FUNCTION_SET_OPTION /* 7010 */:
                                                                        break;
                                                                    default:
                                                                        switch (int322) {
                                                                            case SpeechRobotActionType.ACTION_COMMENT /* 15001 */:
                                                                            case SpeechRobotActionType.ACTION_COMMENT_FULL /* 15002 */:
                                                                            case SpeechRobotActionType.ACTION_COMMENT_VOICE /* 15003 */:
                                                                                break;
                                                                            default:
                                                                                switch (int322) {
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                    this.action = int322;
                } else if (tag == 26) {
                    this.slots = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.multiTurn = codedInputByteBufferNano.readInt32();
                } else if (tag == 40) {
                    this.turnCount = codedInputByteBufferNano.readInt32();
                } else if (tag == 48) {
                    int int323 = codedInputByteBufferNano.readInt32();
                    if (int323 == 0 || int323 == 1 || int323 == 2 || int323 == 3 || int323 == 4) {
                        this.sessionStatus = int323;
                    }
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.actionResult = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static Instruction parseFrom(byte[] bArr) {
            return (Instruction) MessageNano.mergeFrom(new Instruction(), bArr);
        }

        public static Instruction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Instruction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RtTextToSpeechRequest extends MessageNano {
        private static volatile RtTextToSpeechRequest[] _emptyArray;
        public String reqId;
        public long serialNo;
        public String speechText;

        public static RtTextToSpeechRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RtTextToSpeechRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RtTextToSpeechRequest() {
            clear();
        }

        public final RtTextToSpeechRequest clear() {
            this.reqId = "";
            this.speechText = "";
            this.serialNo = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.reqId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.reqId);
            }
            if (!this.speechText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.speechText);
            }
            long j = this.serialNo;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.reqId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.reqId);
            }
            if (!this.speechText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.speechText);
            }
            long j = this.serialNo;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RtTextToSpeechRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.reqId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.speechText = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serialNo = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static RtTextToSpeechRequest parseFrom(byte[] bArr) {
            return (RtTextToSpeechRequest) MessageNano.mergeFrom(new RtTextToSpeechRequest(), bArr);
        }

        public static RtTextToSpeechRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RtTextToSpeechRequest().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RtTextToSpeechResponse extends MessageNano {
        private static volatile RtTextToSpeechResponse[] _emptyArray;
        public String reqId;
        public boolean requestContinue;
        public long serialNo;
        public byte[] speech;
        public String speechText;
        public int status;

        public static RtTextToSpeechResponse[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RtTextToSpeechResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RtTextToSpeechResponse() {
            clear();
        }

        public final RtTextToSpeechResponse clear() {
            this.status = 0;
            this.speechText = "";
            this.reqId = "";
            this.serialNo = 0L;
            this.speech = WireFormatNano.EMPTY_BYTES;
            this.requestContinue = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.speechText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.speechText);
            }
            if (!this.reqId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.reqId);
            }
            long j = this.serialNo;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(4, j);
            }
            if (!Arrays.equals(this.speech, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(5, this.speech);
            }
            boolean z = this.requestContinue;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.speechText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.speechText);
            }
            if (!this.reqId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.reqId);
            }
            long j = this.serialNo;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j);
            }
            if (!Arrays.equals(this.speech, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.speech);
            }
            boolean z = this.requestContinue;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RtTextToSpeechResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
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
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            this.status = int32;
                            break;
                    }
                } else if (tag == 18) {
                    this.speechText = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.reqId = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.serialNo = codedInputByteBufferNano.readInt64();
                } else if (tag == 42) {
                    this.speech = codedInputByteBufferNano.readBytes();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.requestContinue = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static RtTextToSpeechResponse parseFrom(byte[] bArr) {
            return (RtTextToSpeechResponse) MessageNano.mergeFrom(new RtTextToSpeechResponse(), bArr);
        }

        public static RtTextToSpeechResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RtTextToSpeechResponse().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RobotClientStatus extends MessageNano {
        private static volatile RobotClientStatus[] _emptyArray;
        public int skill;
        public String slots;
        public int status;

        public static RobotClientStatus[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RobotClientStatus[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RobotClientStatus() {
            clear();
        }

        public final RobotClientStatus clear() {
            this.skill = 0;
            this.status = 0;
            this.slots = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.skill;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.status;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            if (!this.slots.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.slots);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.skill;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.status;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            return !this.slots.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.slots) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RobotClientStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.skill = codedInputByteBufferNano.readInt32();
                } else if (tag == 16) {
                    this.status = codedInputByteBufferNano.readInt32();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.slots = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RobotClientStatus parseFrom(byte[] bArr) {
            return (RobotClientStatus) MessageNano.mergeFrom(new RobotClientStatus(), bArr);
        }

        public static RobotClientStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RobotClientStatus().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RobotClientIdentity extends MessageNano {
        private static volatile RobotClientIdentity[] _emptyArray;
        public int appid;
        public long uid;

        public static RobotClientIdentity[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RobotClientIdentity[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RobotClientIdentity() {
            clear();
        }

        public final RobotClientIdentity clear() {
            this.appid = 0;
            this.uid = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.appid;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.uid;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.appid;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.uid;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RobotClientIdentity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.appid = codedInputByteBufferNano.readInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.uid = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static RobotClientIdentity parseFrom(byte[] bArr) {
            return (RobotClientIdentity) MessageNano.mergeFrom(new RobotClientIdentity(), bArr);
        }

        public static RobotClientIdentity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RobotClientIdentity().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RobotClientInfo extends MessageNano {
        private static volatile RobotClientInfo[] _emptyArray;
        public RobotClientIdentity clientIdentity;
        public RobotClientStatus[] clientStatus;

        public static RobotClientInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RobotClientInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RobotClientInfo() {
            clear();
        }

        public final RobotClientInfo clear() {
            this.clientStatus = RobotClientStatus.emptyArray();
            this.clientIdentity = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RobotClientStatus[] robotClientStatusArr = this.clientStatus;
            if (robotClientStatusArr != null && robotClientStatusArr.length > 0) {
                int i = 0;
                while (true) {
                    RobotClientStatus[] robotClientStatusArr2 = this.clientStatus;
                    if (i >= robotClientStatusArr2.length) {
                        break;
                    }
                    RobotClientStatus robotClientStatus = robotClientStatusArr2[i];
                    if (robotClientStatus != null) {
                        codedOutputByteBufferNano.writeMessage(1, robotClientStatus);
                    }
                    i++;
                }
            }
            RobotClientIdentity robotClientIdentity = this.clientIdentity;
            if (robotClientIdentity != null) {
                codedOutputByteBufferNano.writeMessage(2, robotClientIdentity);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RobotClientStatus[] robotClientStatusArr = this.clientStatus;
            if (robotClientStatusArr != null && robotClientStatusArr.length > 0) {
                int i = 0;
                while (true) {
                    RobotClientStatus[] robotClientStatusArr2 = this.clientStatus;
                    if (i >= robotClientStatusArr2.length) {
                        break;
                    }
                    RobotClientStatus robotClientStatus = robotClientStatusArr2[i];
                    if (robotClientStatus != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, robotClientStatus);
                    }
                    i++;
                }
            }
            RobotClientIdentity robotClientIdentity = this.clientIdentity;
            return robotClientIdentity != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, robotClientIdentity) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RobotClientInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    RobotClientStatus[] robotClientStatusArr = this.clientStatus;
                    int length = robotClientStatusArr == null ? 0 : robotClientStatusArr.length;
                    RobotClientStatus[] robotClientStatusArr2 = new RobotClientStatus[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.clientStatus, 0, robotClientStatusArr2, 0, length);
                    }
                    while (length < robotClientStatusArr2.length - 1) {
                        robotClientStatusArr2[length] = new RobotClientStatus();
                        codedInputByteBufferNano.readMessage(robotClientStatusArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    robotClientStatusArr2[length] = new RobotClientStatus();
                    codedInputByteBufferNano.readMessage(robotClientStatusArr2[length]);
                    this.clientStatus = robotClientStatusArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.clientIdentity == null) {
                        this.clientIdentity = new RobotClientIdentity();
                    }
                    codedInputByteBufferNano.readMessage(this.clientIdentity);
                }
            }
        }

        public static RobotClientInfo parseFrom(byte[] bArr) {
            return (RobotClientInfo) MessageNano.mergeFrom(new RobotClientInfo(), bArr);
        }

        public static RobotClientInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RobotClientInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SpeechRobotRequest extends MessageNano {
        private static volatile SpeechRobotRequest[] _emptyArray;
        public RtSpeechRecognitionRequest asrRequest;
        public String bizId;
        public int bizType;
        public RobotClientInfo clientInfo;
        public Instruction instruction;
        public String recognitionResult;
        public String reqId;
        public int reqType;
        public String ttsId;
        public RtTextToSpeechRequest ttsRequest;

        public static SpeechRobotRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SpeechRobotRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SpeechRobotRequest() {
            clear();
        }

        public final SpeechRobotRequest clear() {
            this.asrRequest = null;
            this.reqId = "";
            this.bizType = 0;
            this.bizId = "";
            this.reqType = 0;
            this.recognitionResult = "";
            this.ttsRequest = null;
            this.clientInfo = null;
            this.instruction = null;
            this.ttsId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RtSpeechRecognitionRequest rtSpeechRecognitionRequest = this.asrRequest;
            if (rtSpeechRecognitionRequest != null) {
                codedOutputByteBufferNano.writeMessage(1, rtSpeechRecognitionRequest);
            }
            if (!this.reqId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.reqId);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bizId);
            }
            int i2 = this.reqType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(5, i2);
            }
            if (!this.recognitionResult.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.recognitionResult);
            }
            RtTextToSpeechRequest rtTextToSpeechRequest = this.ttsRequest;
            if (rtTextToSpeechRequest != null) {
                codedOutputByteBufferNano.writeMessage(7, rtTextToSpeechRequest);
            }
            RobotClientInfo robotClientInfo = this.clientInfo;
            if (robotClientInfo != null) {
                codedOutputByteBufferNano.writeMessage(8, robotClientInfo);
            }
            Instruction instruction = this.instruction;
            if (instruction != null) {
                codedOutputByteBufferNano.writeMessage(9, instruction);
            }
            if (!this.ttsId.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.ttsId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RtSpeechRecognitionRequest rtSpeechRecognitionRequest = this.asrRequest;
            if (rtSpeechRecognitionRequest != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rtSpeechRecognitionRequest);
            }
            if (!this.reqId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.reqId);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bizId);
            }
            int i2 = this.reqType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
            }
            if (!this.recognitionResult.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.recognitionResult);
            }
            RtTextToSpeechRequest rtTextToSpeechRequest = this.ttsRequest;
            if (rtTextToSpeechRequest != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, rtTextToSpeechRequest);
            }
            RobotClientInfo robotClientInfo = this.clientInfo;
            if (robotClientInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, robotClientInfo);
            }
            Instruction instruction = this.instruction;
            if (instruction != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, instruction);
            }
            return !this.ttsId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.ttsId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SpeechRobotRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.asrRequest == null) {
                            this.asrRequest = new RtSpeechRecognitionRequest();
                        }
                        codedInputByteBufferNano.readMessage(this.asrRequest);
                        break;
                    case 18:
                        this.reqId = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 5) {
                            break;
                        } else {
                            this.bizType = int32;
                            break;
                        }
                        break;
                    case 34:
                        this.bizId = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3 && int322 != 4) {
                            break;
                        } else {
                            this.reqType = int322;
                            break;
                        }
                        break;
                    case 50:
                        this.recognitionResult = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        if (this.ttsRequest == null) {
                            this.ttsRequest = new RtTextToSpeechRequest();
                        }
                        codedInputByteBufferNano.readMessage(this.ttsRequest);
                        break;
                    case 66:
                        if (this.clientInfo == null) {
                            this.clientInfo = new RobotClientInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.clientInfo);
                        break;
                    case 74:
                        if (this.instruction == null) {
                            this.instruction = new Instruction();
                        }
                        codedInputByteBufferNano.readMessage(this.instruction);
                        break;
                    case 82:
                        this.ttsId = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SpeechRobotRequest parseFrom(byte[] bArr) {
            return (SpeechRobotRequest) MessageNano.mergeFrom(new SpeechRobotRequest(), bArr);
        }

        public static SpeechRobotRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SpeechRobotRequest().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SpeechRobotResponse extends MessageNano {
        private static volatile SpeechRobotResponse[] _emptyArray;
        public RtSpeechRecognitionResponse asrResponse;
        public String bizId;
        public int bizType;
        public RtNLUResponse nluResponse;
        public String reqId;
        public String ttsId;
        public RtTextToSpeechResponse ttsResponse;

        public static SpeechRobotResponse[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SpeechRobotResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SpeechRobotResponse() {
            clear();
        }

        public final SpeechRobotResponse clear() {
            this.asrResponse = null;
            this.reqId = "";
            this.bizType = 0;
            this.bizId = "";
            this.nluResponse = null;
            this.ttsResponse = null;
            this.ttsId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RtSpeechRecognitionResponse rtSpeechRecognitionResponse = this.asrResponse;
            if (rtSpeechRecognitionResponse != null) {
                codedOutputByteBufferNano.writeMessage(1, rtSpeechRecognitionResponse);
            }
            if (!this.reqId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.reqId);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bizId);
            }
            RtNLUResponse rtNLUResponse = this.nluResponse;
            if (rtNLUResponse != null) {
                codedOutputByteBufferNano.writeMessage(5, rtNLUResponse);
            }
            RtTextToSpeechResponse rtTextToSpeechResponse = this.ttsResponse;
            if (rtTextToSpeechResponse != null) {
                codedOutputByteBufferNano.writeMessage(6, rtTextToSpeechResponse);
            }
            if (!this.ttsId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.ttsId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RtSpeechRecognitionResponse rtSpeechRecognitionResponse = this.asrResponse;
            if (rtSpeechRecognitionResponse != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rtSpeechRecognitionResponse);
            }
            if (!this.reqId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.reqId);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bizId);
            }
            RtNLUResponse rtNLUResponse = this.nluResponse;
            if (rtNLUResponse != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, rtNLUResponse);
            }
            RtTextToSpeechResponse rtTextToSpeechResponse = this.ttsResponse;
            if (rtTextToSpeechResponse != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, rtTextToSpeechResponse);
            }
            return !this.ttsId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.ttsId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SpeechRobotResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.asrResponse == null) {
                        this.asrResponse = new RtSpeechRecognitionResponse();
                    }
                    codedInputByteBufferNano.readMessage(this.asrResponse);
                } else if (tag == 18) {
                    this.reqId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 5) {
                        this.bizType = int32;
                    }
                } else if (tag == 34) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    if (this.nluResponse == null) {
                        this.nluResponse = new RtNLUResponse();
                    }
                    codedInputByteBufferNano.readMessage(this.nluResponse);
                } else if (tag == 50) {
                    if (this.ttsResponse == null) {
                        this.ttsResponse = new RtTextToSpeechResponse();
                    }
                    codedInputByteBufferNano.readMessage(this.ttsResponse);
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.ttsId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SpeechRobotResponse parseFrom(byte[] bArr) {
            return (SpeechRobotResponse) MessageNano.mergeFrom(new SpeechRobotResponse(), bArr);
        }

        public static SpeechRobotResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SpeechRobotResponse().mergeFrom(codedInputByteBufferNano);
        }
    }
}
