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
public interface LiveQuickInteractiveGiftMessages {

    public static final class SCLiveQuickInteractGiftTrigger extends MessageNano {
        private static volatile SCLiveQuickInteractGiftTrigger[] _emptyArray;
        public long expireTimestamp;
        public long triggerTime;
        public int triggerType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface TriggerType {
            public static final int COMMENT = 3;
            public static final int FOLLOW = 2;
            public static final int LIKE = 6;
            public static final int PK_CRIT_MOMENT = 4;
            public static final int PK_STEAL_TOWER_MOMENT = 5;
            public static final int UNKNOWN_TRIGGER_TYPE = 0;
            public static final int WATCH_DURATION = 1;
        }

        public static SCLiveQuickInteractGiftTrigger[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickInteractGiftTrigger[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickInteractGiftTrigger() {
            clear();
        }

        public final SCLiveQuickInteractGiftTrigger clear() {
            this.triggerType = 0;
            this.triggerTime = 0L;
            this.expireTimestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.triggerType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.triggerTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.expireTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.triggerType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.triggerTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.expireTimestamp;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickInteractGiftTrigger mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                            this.triggerType = int32;
                            break;
                    }
                } else if (tag == 16) {
                    this.triggerTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.expireTimestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveQuickInteractGiftTrigger parseFrom(byte[] bArr) {
            return (SCLiveQuickInteractGiftTrigger) MessageNano.mergeFrom(new SCLiveQuickInteractGiftTrigger(), bArr);
        }

        public static SCLiveQuickInteractGiftTrigger parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickInteractGiftTrigger().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuickInteractGiftArea extends MessageNano {
        private static volatile SCLiveQuickInteractGiftArea[] _emptyArray;
        public int bizType;
        public int displayType;
        public UserInfos.PicUrl[] icon;
        public String jumpUrl;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AreaBizType {
            public static final int ALIPAY_PENNY_BUY = 2;
            public static final int FIRST_RECHARGE = 1;
            public static final int UNKNOWN_BIZ_TYPE = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface AreaDisplayType {
            public static final int HIDE = 2;
            public static final int SHOW = 1;
            public static final int UNKNOWN_DISPLAY_TYPE = 0;
        }

        public static SCLiveQuickInteractGiftArea[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickInteractGiftArea[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickInteractGiftArea() {
            clear();
        }

        public final SCLiveQuickInteractGiftArea clear() {
            this.bizType = 0;
            this.icon = UserInfos.PicUrl.emptyArray();
            this.jumpUrl = "";
            this.displayType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.icon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.icon;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.jumpUrl);
            }
            int i3 = this.displayType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.icon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.icon;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
            }
            int i3 = this.displayType;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickInteractGiftArea mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.bizType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr = this.icon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.icon = picUrlArr2;
                } else if (tag == 26) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
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

        public static SCLiveQuickInteractGiftArea parseFrom(byte[] bArr) {
            return (SCLiveQuickInteractGiftArea) MessageNano.mergeFrom(new SCLiveQuickInteractGiftArea(), bArr);
        }

        public static SCLiveQuickInteractGiftArea parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickInteractGiftArea().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuickInteractGiftMessage extends MessageNano {
        private static volatile SCLiveQuickInteractGiftMessage[] _emptyArray;
        public long authorId;
        public int bizType;
        public int giftId;
        public String giftToken;
        public String liveStreamId;
        public boolean openStatus;
        public String[] sendGiftMsgKeys;
        public long timestamp;

        public static SCLiveQuickInteractGiftMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickInteractGiftMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickInteractGiftMessage() {
            clear();
        }

        public final SCLiveQuickInteractGiftMessage clear() {
            this.liveStreamId = "";
            this.authorId = 0L;
            this.giftId = 0;
            this.giftToken = "";
            this.timestamp = 0L;
            this.bizType = 0;
            this.openStatus = false;
            this.sendGiftMsgKeys = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.authorId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            if (!this.giftToken.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.giftToken);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i2);
            }
            boolean z = this.openStatus;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            String[] strArr = this.sendGiftMsgKeys;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.sendGiftMsgKeys;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(8, str);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.authorId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            if (!this.giftToken.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.giftToken);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
            }
            boolean z = this.openStatus;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            String[] strArr = this.sendGiftMsgKeys;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.sendGiftMsgKeys;
                if (i3 >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
                }
                String str = strArr2[i3];
                if (str != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickInteractGiftMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.authorId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 34) {
                    this.giftToken = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0) {
                        switch (int32) {
                            case 1001:
                            case 1002:
                            case 1003:
                            case 1004:
                            case 1005:
                            case 1006:
                            case 1007:
                            case 1008:
                            case 1009:
                            case 1010:
                            case 1011:
                            case 1012:
                            case 1013:
                            case 1014:
                            case 1015:
                            case 1016:
                            case 1017:
                            case 1018:
                            case 1019:
                            case 1020:
                            case 1021:
                            case 1022:
                            case 1023:
                            case 1024:
                            case 1025:
                            case 1026:
                            case 1027:
                            case 1028:
                            case 1029:
                            case 1030:
                            case 1031:
                            case 1032:
                            case 1033:
                            case 1034:
                            case 1035:
                            case 1036:
                            case 1037:
                            case 1038:
                            case 1039:
                            case 1040:
                            case 1041:
                            case 1042:
                            case 1043:
                            case 1044:
                            case 1045:
                            case 1046:
                            case 1047:
                            case 1048:
                            case 1049:
                            case 1050:
                            case 1051:
                            case 1052:
                            case 1053:
                                break;
                            default:
                                switch (int32) {
                                    case 2001:
                                    case 2002:
                                    case 2003:
                                    case 2004:
                                    case 2005:
                                    case 2006:
                                        break;
                                    default:
                                        switch (int32) {
                                            case 3001:
                                            case 3002:
                                            case 3003:
                                                break;
                                            default:
                                                switch (int32) {
                                                }
                                        }
                                }
                        }
                    }
                    this.bizType = int32;
                } else if (tag == 56) {
                    this.openStatus = codedInputByteBufferNano.readBool();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    String[] strArr = this.sendGiftMsgKeys;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.sendGiftMsgKeys, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.sendGiftMsgKeys = strArr2;
                }
            }
        }

        public static SCLiveQuickInteractGiftMessage parseFrom(byte[] bArr) {
            return (SCLiveQuickInteractGiftMessage) MessageNano.mergeFrom(new SCLiveQuickInteractGiftMessage(), bArr);
        }

        public static SCLiveQuickInteractGiftMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickInteractGiftMessage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
