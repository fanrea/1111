package com.kuaishou.protobuf.livestream.nano;

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
public final class BountyGameResultInfo extends MessageNano {
    private static volatile BountyGameResultInfo[] _emptyArray;
    public String bountyScoreDelta;
    public String defeatMessage;
    public String defeatShortMessage;
    public String drawMessage;
    public String drawShortMessage;
    public UserHead[] firstStageKillUserHead;
    public String firstStageVictoryMessage;
    public String firstStageVictoryShortMessage;
    public String jumpUrl;
    public int result;
    public UserHead[] secondStageKillUserHead;
    public String secondStageVictoryMessage;
    public String secondStageVictoryShortMessage;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BountyGameResult {
        public static final int DEFEAT = 2;
        public static final int DRAW = 3;
        public static final int UNKNOWN_TYPE = 0;
        public static final int VICTORY = 1;
    }

    public static final class UserHead extends MessageNano {
        private static volatile UserHead[] _emptyArray;
        public UserInfos.PicUrl[] headUrl;

        public static UserHead[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserHead[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UserHead() {
            clear();
        }

        public final UserHead clear() {
            this.headUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.headUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.headUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.headUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.headUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UserHead mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.headUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.headUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.headUrl = picUrlArr2;
                }
            }
        }

        public static UserHead parseFrom(byte[] bArr) {
            return (UserHead) MessageNano.mergeFrom(new UserHead(), bArr);
        }

        public static UserHead parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UserHead().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static BountyGameResultInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BountyGameResultInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public BountyGameResultInfo() {
        clear();
    }

    public final BountyGameResultInfo clear() {
        this.result = 0;
        this.bountyScoreDelta = "";
        this.firstStageVictoryMessage = "";
        this.firstStageVictoryShortMessage = "";
        this.firstStageKillUserHead = UserHead.emptyArray();
        this.secondStageVictoryMessage = "";
        this.secondStageVictoryShortMessage = "";
        this.secondStageKillUserHead = UserHead.emptyArray();
        this.defeatMessage = "";
        this.defeatShortMessage = "";
        this.drawMessage = "";
        this.drawShortMessage = "";
        this.jumpUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.result;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.bountyScoreDelta.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.bountyScoreDelta);
        }
        if (!this.firstStageVictoryMessage.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.firstStageVictoryMessage);
        }
        if (!this.firstStageVictoryShortMessage.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.firstStageVictoryShortMessage);
        }
        UserHead[] userHeadArr = this.firstStageKillUserHead;
        int i2 = 0;
        if (userHeadArr != null && userHeadArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserHead[] userHeadArr2 = this.firstStageKillUserHead;
                if (i3 >= userHeadArr2.length) {
                    break;
                }
                UserHead userHead = userHeadArr2[i3];
                if (userHead != null) {
                    codedOutputByteBufferNano.writeMessage(5, userHead);
                }
                i3++;
            }
        }
        if (!this.secondStageVictoryMessage.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.secondStageVictoryMessage);
        }
        if (!this.secondStageVictoryShortMessage.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.secondStageVictoryShortMessage);
        }
        UserHead[] userHeadArr3 = this.secondStageKillUserHead;
        if (userHeadArr3 != null && userHeadArr3.length > 0) {
            while (true) {
                UserHead[] userHeadArr4 = this.secondStageKillUserHead;
                if (i2 >= userHeadArr4.length) {
                    break;
                }
                UserHead userHead2 = userHeadArr4[i2];
                if (userHead2 != null) {
                    codedOutputByteBufferNano.writeMessage(8, userHead2);
                }
                i2++;
            }
        }
        if (!this.defeatMessage.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.defeatMessage);
        }
        if (!this.defeatShortMessage.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.defeatShortMessage);
        }
        if (!this.drawMessage.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.drawMessage);
        }
        if (!this.drawShortMessage.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.drawShortMessage);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.jumpUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.result;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.bountyScoreDelta.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bountyScoreDelta);
        }
        if (!this.firstStageVictoryMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.firstStageVictoryMessage);
        }
        if (!this.firstStageVictoryShortMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.firstStageVictoryShortMessage);
        }
        UserHead[] userHeadArr = this.firstStageKillUserHead;
        int i2 = 0;
        if (userHeadArr != null && userHeadArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserHead[] userHeadArr2 = this.firstStageKillUserHead;
                if (i3 >= userHeadArr2.length) {
                    break;
                }
                UserHead userHead = userHeadArr2[i3];
                if (userHead != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, userHead);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.secondStageVictoryMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.secondStageVictoryMessage);
        }
        if (!this.secondStageVictoryShortMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.secondStageVictoryShortMessage);
        }
        UserHead[] userHeadArr3 = this.secondStageKillUserHead;
        if (userHeadArr3 != null && userHeadArr3.length > 0) {
            while (true) {
                UserHead[] userHeadArr4 = this.secondStageKillUserHead;
                if (i2 >= userHeadArr4.length) {
                    break;
                }
                UserHead userHead2 = userHeadArr4[i2];
                if (userHead2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, userHead2);
                }
                i2++;
            }
        }
        if (!this.defeatMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.defeatMessage);
        }
        if (!this.defeatShortMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.defeatShortMessage);
        }
        if (!this.drawMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.drawMessage);
        }
        if (!this.drawShortMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.drawShortMessage);
        }
        return !this.jumpUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(13, this.jumpUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BountyGameResultInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.result = int32;
                        break;
                    }
                case 18:
                    this.bountyScoreDelta = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.firstStageVictoryMessage = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.firstStageVictoryShortMessage = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserHead[] userHeadArr = this.firstStageKillUserHead;
                    int length = userHeadArr == null ? 0 : userHeadArr.length;
                    UserHead[] userHeadArr2 = new UserHead[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.firstStageKillUserHead, 0, userHeadArr2, 0, length);
                    }
                    while (length < userHeadArr2.length - 1) {
                        userHeadArr2[length] = new UserHead();
                        codedInputByteBufferNano.readMessage(userHeadArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    userHeadArr2[length] = new UserHead();
                    codedInputByteBufferNano.readMessage(userHeadArr2[length]);
                    this.firstStageKillUserHead = userHeadArr2;
                    break;
                case 50:
                    this.secondStageVictoryMessage = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.secondStageVictoryShortMessage = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    UserHead[] userHeadArr3 = this.secondStageKillUserHead;
                    int length2 = userHeadArr3 == null ? 0 : userHeadArr3.length;
                    UserHead[] userHeadArr4 = new UserHead[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.secondStageKillUserHead, 0, userHeadArr4, 0, length2);
                    }
                    while (length2 < userHeadArr4.length - 1) {
                        userHeadArr4[length2] = new UserHead();
                        codedInputByteBufferNano.readMessage(userHeadArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    userHeadArr4[length2] = new UserHead();
                    codedInputByteBufferNano.readMessage(userHeadArr4[length2]);
                    this.secondStageKillUserHead = userHeadArr4;
                    break;
                case 74:
                    this.defeatMessage = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.defeatShortMessage = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.drawMessage = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.drawShortMessage = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.jumpUrl = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static BountyGameResultInfo parseFrom(byte[] bArr) {
        return (BountyGameResultInfo) MessageNano.mergeFrom(new BountyGameResultInfo(), bArr);
    }

    public static BountyGameResultInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BountyGameResultInfo().mergeFrom(codedInputByteBufferNano);
    }
}
