package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCommonNoticeMessages;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveActivityPopup extends MessageNano {
    private static volatile SCLiveActivityPopup[] _emptyArray;
    public LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo animationPicInfo;
    public UserInfos.PicUrl[] displayPict;
    public String link;
    public int linkType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkType {
        public static final int ROUTER = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveActivityPopup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveActivityPopup[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveActivityPopup() {
        clear();
    }

    public final SCLiveActivityPopup clear() {
        this.displayPict = UserInfos.PicUrl.emptyArray();
        this.animationPicInfo = null;
        this.linkType = 0;
        this.link = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.displayPict;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.displayPict;
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
        LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo liveActivityPopAnimationPicInfo = this.animationPicInfo;
        if (liveActivityPopAnimationPicInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, liveActivityPopAnimationPicInfo);
        }
        int i2 = this.linkType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        if (!this.link.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.link);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.displayPict;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.displayPict;
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
        LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo liveActivityPopAnimationPicInfo = this.animationPicInfo;
        if (liveActivityPopAnimationPicInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveActivityPopAnimationPicInfo);
        }
        int i2 = this.linkType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        return !this.link.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.link) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveActivityPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserInfos.PicUrl[] picUrlArr = this.displayPict;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.displayPict, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.displayPict = picUrlArr2;
            } else if (tag == 18) {
                if (this.animationPicInfo == null) {
                    this.animationPicInfo = new LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo();
                }
                codedInputByteBufferNano.readMessage(this.animationPicInfo);
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.linkType = int32;
                }
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.link = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveActivityPopup parseFrom(byte[] bArr) {
        return (SCLiveActivityPopup) MessageNano.mergeFrom(new SCLiveActivityPopup(), bArr);
    }

    public static SCLiveActivityPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveActivityPopup().mergeFrom(codedInputByteBufferNano);
    }
}
