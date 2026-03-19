package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAdSocialMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ExceptionHandleStrategy {
        public static final int HIDE_TASK_ENTRANCE = 1;
        public static final int SHOW_TASK_ENTRANCE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveAdSocialConversionTypeEnum {
        public static final int APP_DOWNLOAD_TYPE = 2;
        public static final int BRAND_TYPE = 3;
        public static final int FORM_COLLECTION_TYPE = 1;
        public static final int LANDING_PAGE_TYPE = 5;
        public static final int MINI_APP_TYPE = 6;
        public static final int UNKNOWN_CONVERSION_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowType {
        public static final int SHOW_TO_ANCHOR = 1;
        public static final int SHOW_TO_AUDIENCE = 2;
        public static final int SHOW_TO_BOTH = 3;
        public static final int UNKNOWN_SHOW_TYPE = 0;
    }

    public static final class LiveAdSocialConversionState extends MessageNano {
        private static volatile LiveAdSocialConversionState[] _emptyArray;
        public LiveAdSocialAuthorStatus authorStatus;
        public LiveAdSocialConversionTask conversionTask;
        public LiveAdSocialNoticeCard noticeCard;
        public String popMsg;

        public static LiveAdSocialConversionState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAdSocialConversionState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAdSocialConversionState() {
            clear();
        }

        public final LiveAdSocialConversionState clear() {
            this.popMsg = "";
            this.conversionTask = null;
            this.noticeCard = null;
            this.authorStatus = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.popMsg.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.popMsg);
            }
            LiveAdSocialConversionTask liveAdSocialConversionTask = this.conversionTask;
            if (liveAdSocialConversionTask != null) {
                codedOutputByteBufferNano.writeMessage(3, liveAdSocialConversionTask);
            }
            LiveAdSocialNoticeCard liveAdSocialNoticeCard = this.noticeCard;
            if (liveAdSocialNoticeCard != null) {
                codedOutputByteBufferNano.writeMessage(4, liveAdSocialNoticeCard);
            }
            LiveAdSocialAuthorStatus liveAdSocialAuthorStatus = this.authorStatus;
            if (liveAdSocialAuthorStatus != null) {
                codedOutputByteBufferNano.writeMessage(5, liveAdSocialAuthorStatus);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.popMsg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.popMsg);
            }
            LiveAdSocialConversionTask liveAdSocialConversionTask = this.conversionTask;
            if (liveAdSocialConversionTask != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveAdSocialConversionTask);
            }
            LiveAdSocialNoticeCard liveAdSocialNoticeCard = this.noticeCard;
            if (liveAdSocialNoticeCard != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveAdSocialNoticeCard);
            }
            LiveAdSocialAuthorStatus liveAdSocialAuthorStatus = this.authorStatus;
            return liveAdSocialAuthorStatus != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, liveAdSocialAuthorStatus) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAdSocialConversionState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 18) {
                    this.popMsg = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    if (this.conversionTask == null) {
                        this.conversionTask = new LiveAdSocialConversionTask();
                    }
                    codedInputByteBufferNano.readMessage(this.conversionTask);
                } else if (tag == 34) {
                    if (this.noticeCard == null) {
                        this.noticeCard = new LiveAdSocialNoticeCard();
                    }
                    codedInputByteBufferNano.readMessage(this.noticeCard);
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.authorStatus == null) {
                        this.authorStatus = new LiveAdSocialAuthorStatus();
                    }
                    codedInputByteBufferNano.readMessage(this.authorStatus);
                }
            }
        }

        public static LiveAdSocialConversionState parseFrom(byte[] bArr) {
            return (LiveAdSocialConversionState) MessageNano.mergeFrom(new LiveAdSocialConversionState(), bArr);
        }

        public static LiveAdSocialConversionState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAdSocialConversionState().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAdSocialConversionFeed extends MessageNano {
        private static volatile LiveAdSocialConversionFeed[] _emptyArray;
        public LiveAdSocialConversionTask conversionTask;
        public LinkMsg linkMsg;
        public NormalMsg normalMsg;
        public String popMsg;

        public static LiveAdSocialConversionFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAdSocialConversionFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAdSocialConversionFeed() {
            clear();
        }

        public final LiveAdSocialConversionFeed clear() {
            this.normalMsg = null;
            this.linkMsg = null;
            this.conversionTask = null;
            this.popMsg = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            NormalMsg normalMsg = this.normalMsg;
            if (normalMsg != null) {
                codedOutputByteBufferNano.writeMessage(1, normalMsg);
            }
            LinkMsg linkMsg = this.linkMsg;
            if (linkMsg != null) {
                codedOutputByteBufferNano.writeMessage(2, linkMsg);
            }
            LiveAdSocialConversionTask liveAdSocialConversionTask = this.conversionTask;
            if (liveAdSocialConversionTask != null) {
                codedOutputByteBufferNano.writeMessage(3, liveAdSocialConversionTask);
            }
            if (!this.popMsg.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.popMsg);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            NormalMsg normalMsg = this.normalMsg;
            if (normalMsg != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, normalMsg);
            }
            LinkMsg linkMsg = this.linkMsg;
            if (linkMsg != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, linkMsg);
            }
            LiveAdSocialConversionTask liveAdSocialConversionTask = this.conversionTask;
            if (liveAdSocialConversionTask != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveAdSocialConversionTask);
            }
            return !this.popMsg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.popMsg) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAdSocialConversionFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.normalMsg == null) {
                        this.normalMsg = new NormalMsg();
                    }
                    codedInputByteBufferNano.readMessage(this.normalMsg);
                } else if (tag == 18) {
                    if (this.linkMsg == null) {
                        this.linkMsg = new LinkMsg();
                    }
                    codedInputByteBufferNano.readMessage(this.linkMsg);
                } else if (tag == 26) {
                    if (this.conversionTask == null) {
                        this.conversionTask = new LiveAdSocialConversionTask();
                    }
                    codedInputByteBufferNano.readMessage(this.conversionTask);
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.popMsg = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveAdSocialConversionFeed parseFrom(byte[] bArr) {
            return (LiveAdSocialConversionFeed) MessageNano.mergeFrom(new LiveAdSocialConversionFeed(), bArr);
        }

        public static LiveAdSocialConversionFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAdSocialConversionFeed().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAdSocialConversionNotice extends MessageNano {
        private static volatile LiveAdSocialConversionNotice[] _emptyArray;
        public String content;
        public long displayDuration;
        public int displayType;
        public String id;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DisplayType {
            public static final int ALERT = 1;
            public static final int TOAST = 2;
            public static final int UNKNOWN = 0;
        }

        public static LiveAdSocialConversionNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAdSocialConversionNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAdSocialConversionNotice() {
            clear();
        }

        public final LiveAdSocialConversionNotice clear() {
            this.id = "";
            this.content = "";
            this.displayDuration = 0L;
            this.displayType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.content);
            }
            long j = this.displayDuration;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i = this.displayType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.content);
            }
            long j = this.displayDuration;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i = this.displayType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAdSocialConversionNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.content = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.displayDuration = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.displayType = int32;
                    }
                }
            }
        }

        public static LiveAdSocialConversionNotice parseFrom(byte[] bArr) {
            return (LiveAdSocialConversionNotice) MessageNano.mergeFrom(new LiveAdSocialConversionNotice(), bArr);
        }

        public static LiveAdSocialConversionNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAdSocialConversionNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAdSocialConversionTask extends MessageNano {
        private static volatile LiveAdSocialConversionTask[] _emptyArray;
        public boolean conversionEnabled;
        public long conversionId;
        public long conversionLaunchedOnTime;
        public int conversionType;
        public long conversionTypeInt;
        public String entranceInfo;
        public int exceptionHandleStrategy;
        public long longMaxDelayMs;
        public long maxDelayMs;
        public long sceneId;
        public int sourceType;
        public String url;
        public long version;

        public static LiveAdSocialConversionTask[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAdSocialConversionTask[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAdSocialConversionTask() {
            clear();
        }

        public final LiveAdSocialConversionTask clear() {
            this.conversionEnabled = false;
            this.conversionId = 0L;
            this.version = 0L;
            this.conversionType = 0;
            this.url = "";
            this.sourceType = 0;
            this.sceneId = 0L;
            this.exceptionHandleStrategy = 0;
            this.maxDelayMs = 0L;
            this.conversionTypeInt = 0L;
            this.entranceInfo = "";
            this.longMaxDelayMs = 0L;
            this.conversionLaunchedOnTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.conversionEnabled;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long j = this.conversionId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.version;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i = this.conversionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.url);
            }
            int i2 = this.sourceType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i2);
            }
            long j3 = this.sceneId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            int i3 = this.exceptionHandleStrategy;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i3);
            }
            long j4 = this.maxDelayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j4);
            }
            long j5 = this.conversionTypeInt;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(10, j5);
            }
            if (!this.entranceInfo.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.entranceInfo);
            }
            long j6 = this.longMaxDelayMs;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(12, j6);
            }
            long j7 = this.conversionLaunchedOnTime;
            if (j7 != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j7);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.conversionEnabled;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long j = this.conversionId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.version;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i = this.conversionType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
            }
            if (!this.url.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.url);
            }
            int i2 = this.sourceType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
            }
            long j3 = this.sceneId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            int i3 = this.exceptionHandleStrategy;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i3);
            }
            long j4 = this.maxDelayMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j4);
            }
            long j5 = this.conversionTypeInt;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j5);
            }
            if (!this.entranceInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.entranceInfo);
            }
            long j6 = this.longMaxDelayMs;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j6);
            }
            long j7 = this.conversionLaunchedOnTime;
            return j7 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(13, j7) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAdSocialConversionTask mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.conversionEnabled = codedInputByteBufferNano.readBool();
                        break;
                    case 16:
                        this.conversionId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 24:
                        this.version = codedInputByteBufferNano.readUInt64();
                        break;
                    case 32:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 5 && int32 != 6) {
                            break;
                        } else {
                            this.conversionType = int32;
                            break;
                        }
                        break;
                    case 42:
                        this.url = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        int int322 = codedInputByteBufferNano.readInt32();
                        switch (int322) {
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
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 43:
                            case 44:
                                this.sourceType = int322;
                                break;
                        }
                    case 56:
                        this.sceneId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        int int323 = codedInputByteBufferNano.readInt32();
                        if (int323 != 0 && int323 != 1) {
                            break;
                        } else {
                            this.exceptionHandleStrategy = int323;
                            break;
                        }
                    case 72:
                        this.maxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 80:
                        this.conversionTypeInt = codedInputByteBufferNano.readUInt64();
                        break;
                    case 90:
                        this.entranceInfo = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        this.longMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 104:
                        this.conversionLaunchedOnTime = codedInputByteBufferNano.readUInt64();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveAdSocialConversionTask parseFrom(byte[] bArr) {
            return (LiveAdSocialConversionTask) MessageNano.mergeFrom(new LiveAdSocialConversionTask(), bArr);
        }

        public static LiveAdSocialConversionTask parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAdSocialConversionTask().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class NormalMsg extends MessageNano {
        private static volatile NormalMsg[] _emptyArray;
        public String desc;
        public int showType;

        public static NormalMsg[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new NormalMsg[0];
                    }
                }
            }
            return _emptyArray;
        }

        public NormalMsg() {
            clear();
        }

        public final NormalMsg clear() {
            this.desc = "";
            this.showType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.desc);
            }
            int i = this.showType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.desc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.desc);
            }
            int i = this.showType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final NormalMsg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.desc = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.showType = int32;
                    }
                }
            }
        }

        public static NormalMsg parseFrom(byte[] bArr) {
            return (NormalMsg) MessageNano.mergeFrom(new NormalMsg(), bArr);
        }

        public static NormalMsg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new NormalMsg().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LinkMsg extends MessageNano {
        private static volatile LinkMsg[] _emptyArray;
        public String desc;
        public int showType;

        public static LinkMsg[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LinkMsg[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LinkMsg() {
            clear();
        }

        public final LinkMsg clear() {
            this.desc = "";
            this.showType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.desc);
            }
            int i = this.showType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.desc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.desc);
            }
            int i = this.showType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LinkMsg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.desc = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.showType = int32;
                    }
                }
            }
        }

        public static LinkMsg parseFrom(byte[] bArr) {
            return (LinkMsg) MessageNano.mergeFrom(new LinkMsg(), bArr);
        }

        public static LinkMsg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LinkMsg().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAdSocialNoticeCard extends MessageNano {
        private static volatile LiveAdSocialNoticeCard[] _emptyArray;
        public String button;
        public boolean clickable;
        public long delayTime;
        public boolean displayCard;
        public int displayModel;
        public long displayStartTime;
        public long displayThreshold;
        public long duration;
        public String image;
        public boolean permanentDisplay;
        public String subTitle;
        public String title;

        public static LiveAdSocialNoticeCard[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAdSocialNoticeCard[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAdSocialNoticeCard() {
            clear();
        }

        public final LiveAdSocialNoticeCard clear() {
            this.title = "";
            this.subTitle = "";
            this.image = "";
            this.button = "";
            this.displayCard = false;
            this.displayModel = 0;
            this.displayStartTime = 0L;
            this.displayThreshold = 0L;
            this.duration = 0L;
            this.delayTime = 0L;
            this.permanentDisplay = false;
            this.clickable = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.title);
            }
            if (!this.subTitle.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.subTitle);
            }
            if (!this.image.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.image);
            }
            if (!this.button.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.button);
            }
            boolean z = this.displayCard;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            int i = this.displayModel;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i);
            }
            long j = this.displayStartTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j);
            }
            long j2 = this.displayThreshold;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            long j3 = this.duration;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j3);
            }
            long j4 = this.delayTime;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(10, j4);
            }
            boolean z2 = this.permanentDisplay;
            if (z2) {
                codedOutputByteBufferNano.writeBool(11, z2);
            }
            boolean z3 = this.clickable;
            if (z3) {
                codedOutputByteBufferNano.writeBool(12, z3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
            }
            if (!this.subTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.subTitle);
            }
            if (!this.image.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.image);
            }
            if (!this.button.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.button);
            }
            boolean z = this.displayCard;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            int i = this.displayModel;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i);
            }
            long j = this.displayStartTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j);
            }
            long j2 = this.displayThreshold;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
            }
            long j3 = this.duration;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
            }
            long j4 = this.delayTime;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j4);
            }
            boolean z2 = this.permanentDisplay;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z2);
            }
            boolean z3 = this.clickable;
            return z3 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(12, z3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAdSocialNoticeCard mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.subTitle = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.image = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.button = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.displayCard = codedInputByteBufferNano.readBool();
                        break;
                    case 48:
                        this.displayModel = codedInputByteBufferNano.readUInt32();
                        break;
                    case 56:
                        this.displayStartTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.displayThreshold = codedInputByteBufferNano.readUInt64();
                        break;
                    case 72:
                        this.duration = codedInputByteBufferNano.readUInt64();
                        break;
                    case 80:
                        this.delayTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 88:
                        this.permanentDisplay = codedInputByteBufferNano.readBool();
                        break;
                    case 96:
                        this.clickable = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveAdSocialNoticeCard parseFrom(byte[] bArr) {
            return (LiveAdSocialNoticeCard) MessageNano.mergeFrom(new LiveAdSocialNoticeCard(), bArr);
        }

        public static LiveAdSocialNoticeCard parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAdSocialNoticeCard().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAdSocialAuthorStatus extends MessageNano {
        private static volatile LiveAdSocialAuthorStatus[] _emptyArray;
        public LiveAdSocialNoticeCard authorNoticeCard;
        public String entrancePopMsg;
        public int oralBroadcastStatus;

        public static LiveAdSocialAuthorStatus[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAdSocialAuthorStatus[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAdSocialAuthorStatus() {
            clear();
        }

        public final LiveAdSocialAuthorStatus clear() {
            this.oralBroadcastStatus = 0;
            this.entrancePopMsg = "";
            this.authorNoticeCard = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.oralBroadcastStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.entrancePopMsg.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.entrancePopMsg);
            }
            LiveAdSocialNoticeCard liveAdSocialNoticeCard = this.authorNoticeCard;
            if (liveAdSocialNoticeCard != null) {
                codedOutputByteBufferNano.writeMessage(3, liveAdSocialNoticeCard);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.oralBroadcastStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.entrancePopMsg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.entrancePopMsg);
            }
            LiveAdSocialNoticeCard liveAdSocialNoticeCard = this.authorNoticeCard;
            return liveAdSocialNoticeCard != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveAdSocialNoticeCard) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAdSocialAuthorStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.oralBroadcastStatus = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.entrancePopMsg = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.authorNoticeCard == null) {
                        this.authorNoticeCard = new LiveAdSocialNoticeCard();
                    }
                    codedInputByteBufferNano.readMessage(this.authorNoticeCard);
                }
            }
        }

        public static LiveAdSocialAuthorStatus parseFrom(byte[] bArr) {
            return (LiveAdSocialAuthorStatus) MessageNano.mergeFrom(new LiveAdSocialAuthorStatus(), bArr);
        }

        public static LiveAdSocialAuthorStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAdSocialAuthorStatus().mergeFrom(codedInputByteBufferNano);
        }
    }
}
