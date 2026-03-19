package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveQuickInteractiveArea {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveQuickInteractiveAreaBizType {
        public static final int LITE_ADMIN_QUICK_COMMENT = 4;
        public static final int LITE_QUICK_COMMENT = 2;
        public static final int LITE_QUICK_GIFT = 1;
        public static final int LITE_QUICK_TEST_DEMO = 3;
        public static final int UNKNOWN_INTERACTIVE_AREA_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveQuickInteractiveAreaScope {
        public static final int DISPLAY_ONLY_LITE = 1;
        public static final int DISPLAY_ONLY_NORMAL = 0;
        public static final int DISPLAY_SCOPE_ALL = 2;
    }

    public static final class SCLiveQuickInteractiveArea extends MessageNano {
        private static volatile SCLiveQuickInteractiveArea[] _emptyArray;
        public String bizId;
        public int bizType;
        public long delayDisplayMs;
        public long displayDurationMs;
        public long displayExpireTimestamp;
        public int displayScope;
        public String extraInfo;
        public String liteCommonGuideSubBiz;
        public boolean needCheckTriggerByClient;
        public long priority;
        public LiveQuickInteractiveAreaTabItem[] tabItem;
        public String targetLiveStreamId;

        public static SCLiveQuickInteractiveArea[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickInteractiveArea[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickInteractiveArea() {
            clear();
        }

        public final SCLiveQuickInteractiveArea clear() {
            this.bizId = "";
            this.bizType = 0;
            this.priority = 0L;
            this.targetLiveStreamId = "";
            this.tabItem = LiveQuickInteractiveAreaTabItem.emptyArray();
            this.displayDurationMs = 0L;
            this.displayExpireTimestamp = 0L;
            this.delayDisplayMs = 0L;
            this.extraInfo = "";
            this.displayScope = 0;
            this.liteCommonGuideSubBiz = "";
            this.needCheckTriggerByClient = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bizId);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            long j = this.priority;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.targetLiveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.targetLiveStreamId);
            }
            LiveQuickInteractiveAreaTabItem[] liveQuickInteractiveAreaTabItemArr = this.tabItem;
            if (liveQuickInteractiveAreaTabItemArr != null && liveQuickInteractiveAreaTabItemArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuickInteractiveAreaTabItem[] liveQuickInteractiveAreaTabItemArr2 = this.tabItem;
                    if (i2 >= liveQuickInteractiveAreaTabItemArr2.length) {
                        break;
                    }
                    LiveQuickInteractiveAreaTabItem liveQuickInteractiveAreaTabItem = liveQuickInteractiveAreaTabItemArr2[i2];
                    if (liveQuickInteractiveAreaTabItem != null) {
                        codedOutputByteBufferNano.writeMessage(5, liveQuickInteractiveAreaTabItem);
                    }
                    i2++;
                }
            }
            long j2 = this.displayDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            long j3 = this.displayExpireTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            long j4 = this.delayDisplayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.extraInfo);
            }
            int i3 = this.displayScope;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(10, i3);
            }
            if (!this.liteCommonGuideSubBiz.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.liteCommonGuideSubBiz);
            }
            boolean z = this.needCheckTriggerByClient;
            if (z) {
                codedOutputByteBufferNano.writeBool(12, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizId);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            long j = this.priority;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.targetLiveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.targetLiveStreamId);
            }
            LiveQuickInteractiveAreaTabItem[] liveQuickInteractiveAreaTabItemArr = this.tabItem;
            if (liveQuickInteractiveAreaTabItemArr != null && liveQuickInteractiveAreaTabItemArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuickInteractiveAreaTabItem[] liveQuickInteractiveAreaTabItemArr2 = this.tabItem;
                    if (i2 >= liveQuickInteractiveAreaTabItemArr2.length) {
                        break;
                    }
                    LiveQuickInteractiveAreaTabItem liveQuickInteractiveAreaTabItem = liveQuickInteractiveAreaTabItemArr2[i2];
                    if (liveQuickInteractiveAreaTabItem != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveQuickInteractiveAreaTabItem);
                    }
                    i2++;
                }
            }
            long j2 = this.displayDurationMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            long j3 = this.displayExpireTimestamp;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            long j4 = this.delayDisplayMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
            }
            if (!this.extraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.extraInfo);
            }
            int i3 = this.displayScope;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i3);
            }
            if (!this.liteCommonGuideSubBiz.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.liteCommonGuideSubBiz);
            }
            boolean z = this.needCheckTriggerByClient;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(12, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickInteractiveArea mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.bizId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                            break;
                        } else {
                            this.bizType = int32;
                            break;
                        }
                        break;
                    case 24:
                        this.priority = codedInputByteBufferNano.readUInt64();
                        break;
                    case 34:
                        this.targetLiveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        LiveQuickInteractiveAreaTabItem[] liveQuickInteractiveAreaTabItemArr = this.tabItem;
                        int length = liveQuickInteractiveAreaTabItemArr == null ? 0 : liveQuickInteractiveAreaTabItemArr.length;
                        LiveQuickInteractiveAreaTabItem[] liveQuickInteractiveAreaTabItemArr2 = new LiveQuickInteractiveAreaTabItem[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.tabItem, 0, liveQuickInteractiveAreaTabItemArr2, 0, length);
                        }
                        while (length < liveQuickInteractiveAreaTabItemArr2.length - 1) {
                            liveQuickInteractiveAreaTabItemArr2[length] = new LiveQuickInteractiveAreaTabItem();
                            codedInputByteBufferNano.readMessage(liveQuickInteractiveAreaTabItemArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveQuickInteractiveAreaTabItemArr2[length] = new LiveQuickInteractiveAreaTabItem();
                        codedInputByteBufferNano.readMessage(liveQuickInteractiveAreaTabItemArr2[length]);
                        this.tabItem = liveQuickInteractiveAreaTabItemArr2;
                        break;
                    case 48:
                        this.displayDurationMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.displayExpireTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.delayDisplayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 74:
                        this.extraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 80:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1 && int322 != 2) {
                            break;
                        } else {
                            this.displayScope = int322;
                            break;
                        }
                    case 90:
                        this.liteCommonGuideSubBiz = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        this.needCheckTriggerByClient = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveQuickInteractiveArea parseFrom(byte[] bArr) {
            return (SCLiveQuickInteractiveArea) MessageNano.mergeFrom(new SCLiveQuickInteractiveArea(), bArr);
        }

        public static SCLiveQuickInteractiveArea parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickInteractiveArea().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuickInteractiveAreaTabItem extends MessageNano {
        private static volatile LiveQuickInteractiveAreaTabItem[] _emptyArray;
        public String actionRouter;
        public String backgroundColor;
        public String displayText;
        public UserInfos.PicUrl[] prefixImageUrl;
        public UserInfos.PicUrl[] suffixImageUrl;
        public String tabExtraInfo;

        public static LiveQuickInteractiveAreaTabItem[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuickInteractiveAreaTabItem[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuickInteractiveAreaTabItem() {
            clear();
        }

        public final LiveQuickInteractiveAreaTabItem clear() {
            this.displayText = "";
            this.actionRouter = "";
            this.backgroundColor = "";
            this.prefixImageUrl = UserInfos.PicUrl.emptyArray();
            this.suffixImageUrl = UserInfos.PicUrl.emptyArray();
            this.tabExtraInfo = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.displayText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.displayText);
            }
            if (!this.actionRouter.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.actionRouter);
            }
            if (!this.backgroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.backgroundColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.prefixImageUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.prefixImageUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.suffixImageUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.suffixImageUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl2);
                    }
                    i++;
                }
            }
            if (!this.tabExtraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.tabExtraInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.displayText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.displayText);
            }
            if (!this.actionRouter.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.actionRouter);
            }
            if (!this.backgroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.backgroundColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.prefixImageUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.prefixImageUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.suffixImageUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.suffixImageUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl2);
                    }
                    i++;
                }
            }
            return !this.tabExtraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.tabExtraInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuickInteractiveAreaTabItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.displayText = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.actionRouter = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.backgroundColor = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.prefixImageUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.prefixImageUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.prefixImageUrl = picUrlArr2;
                } else if (tag == 42) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr3 = this.suffixImageUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.suffixImageUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.suffixImageUrl = picUrlArr4;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.tabExtraInfo = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveQuickInteractiveAreaTabItem parseFrom(byte[] bArr) {
            return (LiveQuickInteractiveAreaTabItem) MessageNano.mergeFrom(new LiveQuickInteractiveAreaTabItem(), bArr);
        }

        public static LiveQuickInteractiveAreaTabItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuickInteractiveAreaTabItem().mergeFrom(codedInputByteBufferNano);
        }
    }
}
