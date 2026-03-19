package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveSpecialTagUpdate extends MessageNano {
    private static volatile SCLiveSpecialTagUpdate[] _emptyArray;
    public String clickAction;
    public String liveStreamId;
    public UserInfos.PicUrl[] refreshingIcon;
    public long strongStyleDuration;
    public UserInfos.PicUrl[] strongStyleIcon;
    public long tagExpireTime;
    public UserInfos.PicUrl[] tagIcon;
    public long tagId;
    public String tagName;
    public UserInfos.PicUrl[] weakStyleIcon;

    public static SCLiveSpecialTagUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveSpecialTagUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveSpecialTagUpdate() {
        clear();
    }

    public final SCLiveSpecialTagUpdate clear() {
        this.tagId = 0L;
        this.tagName = "";
        this.liveStreamId = "";
        this.tagIcon = UserInfos.PicUrl.emptyArray();
        this.tagExpireTime = 0L;
        this.clickAction = "";
        this.strongStyleIcon = UserInfos.PicUrl.emptyArray();
        this.weakStyleIcon = UserInfos.PicUrl.emptyArray();
        this.strongStyleDuration = 0L;
        this.refreshingIcon = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.tagId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.tagName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.tagName);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveStreamId);
        }
        UserInfos.PicUrl[] picUrlArr = this.tagIcon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.tagIcon;
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
        long j2 = this.tagExpireTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        if (!this.clickAction.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.clickAction);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.strongStyleIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.strongStyleIcon;
                if (i3 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl2);
                }
                i3++;
            }
        }
        UserInfos.PicUrl[] picUrlArr5 = this.weakStyleIcon;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.weakStyleIcon;
                if (i4 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i4];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(8, picUrl3);
                }
                i4++;
            }
        }
        long j3 = this.strongStyleDuration;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        UserInfos.PicUrl[] picUrlArr7 = this.refreshingIcon;
        if (picUrlArr7 != null && picUrlArr7.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr8 = this.refreshingIcon;
                if (i >= picUrlArr8.length) {
                    break;
                }
                UserInfos.PicUrl picUrl4 = picUrlArr8[i];
                if (picUrl4 != null) {
                    codedOutputByteBufferNano.writeMessage(10, picUrl4);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.tagId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.tagName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.tagName);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
        }
        UserInfos.PicUrl[] picUrlArr = this.tagIcon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.tagIcon;
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
        long j2 = this.tagExpireTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        if (!this.clickAction.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.clickAction);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.strongStyleIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.strongStyleIcon;
                if (i3 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(7, picUrl2);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        UserInfos.PicUrl[] picUrlArr5 = this.weakStyleIcon;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.weakStyleIcon;
                if (i4 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i4];
                if (picUrl3 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(8, picUrl3);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        long j3 = this.strongStyleDuration;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        UserInfos.PicUrl[] picUrlArr7 = this.refreshingIcon;
        if (picUrlArr7 != null && picUrlArr7.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr8 = this.refreshingIcon;
                if (i >= picUrlArr8.length) {
                    break;
                }
                UserInfos.PicUrl picUrl4 = picUrlArr8[i];
                if (picUrl4 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, picUrl4);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveSpecialTagUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.tagId = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.tagName = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.tagIcon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.tagIcon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.tagIcon = picUrlArr2;
                    break;
                case 40:
                    this.tagExpireTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.clickAction = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr3 = this.strongStyleIcon;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.strongStyleIcon, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.strongStyleIcon = picUrlArr4;
                    break;
                case 66:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    UserInfos.PicUrl[] picUrlArr5 = this.weakStyleIcon;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.weakStyleIcon, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.weakStyleIcon = picUrlArr6;
                    break;
                case 72:
                    this.strongStyleDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    UserInfos.PicUrl[] picUrlArr7 = this.refreshingIcon;
                    int length4 = picUrlArr7 == null ? 0 : picUrlArr7.length;
                    UserInfos.PicUrl[] picUrlArr8 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.refreshingIcon, 0, picUrlArr8, 0, length4);
                    }
                    while (length4 < picUrlArr8.length - 1) {
                        picUrlArr8[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr8[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                    this.refreshingIcon = picUrlArr8;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveSpecialTagUpdate parseFrom(byte[] bArr) {
        return (SCLiveSpecialTagUpdate) MessageNano.mergeFrom(new SCLiveSpecialTagUpdate(), bArr);
    }

    public static SCLiveSpecialTagUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveSpecialTagUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
