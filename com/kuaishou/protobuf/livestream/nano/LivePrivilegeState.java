package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePrivilegeState extends MessageNano {
    private static volatile LivePrivilegeState[] _emptyArray;
    public UserInfos.PicUrl[] avatarFrame;
    public UserInfos.PicUrl[] avatarFrameAnimation;
    public String bulletCommentBackgroundKey;
    public String bulletCommentColor;

    public static LivePrivilegeState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePrivilegeState[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePrivilegeState() {
        clear();
    }

    public final LivePrivilegeState clear() {
        this.avatarFrame = UserInfos.PicUrl.emptyArray();
        this.bulletCommentBackgroundKey = "";
        this.avatarFrameAnimation = UserInfos.PicUrl.emptyArray();
        this.bulletCommentColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.avatarFrame;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.avatarFrame;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i2++;
            }
        }
        if (!this.bulletCommentBackgroundKey.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.bulletCommentBackgroundKey);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.avatarFrameAnimation;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.avatarFrameAnimation;
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
        if (!this.bulletCommentColor.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.bulletCommentColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.avatarFrame;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.avatarFrame;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.bulletCommentBackgroundKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bulletCommentBackgroundKey);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.avatarFrameAnimation;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.avatarFrameAnimation;
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
        return !this.bulletCommentColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.bulletCommentColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePrivilegeState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.avatarFrame;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.avatarFrame, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.avatarFrame = picUrlArr2;
            } else if (tag == 34) {
                this.bulletCommentBackgroundKey = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                UserInfos.PicUrl[] picUrlArr3 = this.avatarFrameAnimation;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.avatarFrameAnimation, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.avatarFrameAnimation = picUrlArr4;
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bulletCommentColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LivePrivilegeState parseFrom(byte[] bArr) {
        return (LivePrivilegeState) MessageNano.mergeFrom(new LivePrivilegeState(), bArr);
    }

    public static LivePrivilegeState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePrivilegeState().mergeFrom(codedInputByteBufferNano);
    }
}
