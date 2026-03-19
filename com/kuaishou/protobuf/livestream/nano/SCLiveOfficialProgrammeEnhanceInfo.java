package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveOfficialProgrammeEnhanceInfo extends MessageNano {
    private static volatile SCLiveOfficialProgrammeEnhanceInfo[] _emptyArray;
    public UserInfos.PicUrl[] backgroundImageUrls;
    public int countDownDurationMs;
    public long countDownEndTimeMs;
    public String kwaiUrl;
    public String liteText;
    public SCLiveOfficialProgrammeEnhanceInfo nextStatusInfo;
    public UserInfos.PicUrl[] programmeIconUrls;
    public String programmeId;
    public UserInfos.PicUrl[] programmeUnfoldUrls;
    public String showTimeDurationStr;
    public String showTimeUnit;
    public UserInfos.UserInfo showingAuthor;
    public UserInfos.PicUrl[] showingLottieUrls;
    public int statusType;
    public String text;

    public static SCLiveOfficialProgrammeEnhanceInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOfficialProgrammeEnhanceInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOfficialProgrammeEnhanceInfo() {
        clear();
    }

    public final SCLiveOfficialProgrammeEnhanceInfo clear() {
        this.statusType = 0;
        this.programmeId = "";
        this.text = "";
        this.showTimeDurationStr = "";
        this.showTimeUnit = "";
        this.countDownEndTimeMs = 0L;
        this.countDownDurationMs = 0;
        this.showingAuthor = null;
        this.kwaiUrl = "";
        this.programmeIconUrls = UserInfos.PicUrl.emptyArray();
        this.showingLottieUrls = UserInfos.PicUrl.emptyArray();
        this.backgroundImageUrls = UserInfos.PicUrl.emptyArray();
        this.programmeUnfoldUrls = UserInfos.PicUrl.emptyArray();
        this.nextStatusInfo = null;
        this.liteText = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.statusType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.programmeId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.programmeId);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.text);
        }
        if (!this.showTimeDurationStr.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.showTimeDurationStr);
        }
        if (!this.showTimeUnit.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.showTimeUnit);
        }
        long j = this.countDownEndTimeMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        int i2 = this.countDownDurationMs;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i2);
        }
        UserInfos.UserInfo userInfo = this.showingAuthor;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(8, userInfo);
        }
        if (!this.kwaiUrl.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.kwaiUrl);
        }
        UserInfos.PicUrl[] picUrlArr = this.programmeIconUrls;
        int i3 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.programmeIconUrls;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(10, picUrl);
                }
                i4++;
            }
        }
        UserInfos.PicUrl[] picUrlArr3 = this.showingLottieUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i5 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.showingLottieUrls;
                if (i5 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i5];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(11, picUrl2);
                }
                i5++;
            }
        }
        UserInfos.PicUrl[] picUrlArr5 = this.backgroundImageUrls;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.backgroundImageUrls;
                if (i6 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i6];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(12, picUrl3);
                }
                i6++;
            }
        }
        UserInfos.PicUrl[] picUrlArr7 = this.programmeUnfoldUrls;
        if (picUrlArr7 != null && picUrlArr7.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr8 = this.programmeUnfoldUrls;
                if (i3 >= picUrlArr8.length) {
                    break;
                }
                UserInfos.PicUrl picUrl4 = picUrlArr8[i3];
                if (picUrl4 != null) {
                    codedOutputByteBufferNano.writeMessage(13, picUrl4);
                }
                i3++;
            }
        }
        SCLiveOfficialProgrammeEnhanceInfo sCLiveOfficialProgrammeEnhanceInfo = this.nextStatusInfo;
        if (sCLiveOfficialProgrammeEnhanceInfo != null) {
            codedOutputByteBufferNano.writeMessage(14, sCLiveOfficialProgrammeEnhanceInfo);
        }
        if (!this.liteText.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.liteText);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.statusType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.programmeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.programmeId);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.text);
        }
        if (!this.showTimeDurationStr.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.showTimeDurationStr);
        }
        if (!this.showTimeUnit.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.showTimeUnit);
        }
        long j = this.countDownEndTimeMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        int i2 = this.countDownDurationMs;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i2);
        }
        UserInfos.UserInfo userInfo = this.showingAuthor;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, userInfo);
        }
        if (!this.kwaiUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.kwaiUrl);
        }
        UserInfos.PicUrl[] picUrlArr = this.programmeIconUrls;
        int i3 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.programmeIconUrls;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(10, picUrl);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        UserInfos.PicUrl[] picUrlArr3 = this.showingLottieUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i5 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.showingLottieUrls;
                if (i5 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i5];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(11, picUrl2);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        UserInfos.PicUrl[] picUrlArr5 = this.backgroundImageUrls;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.backgroundImageUrls;
                if (i6 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i6];
                if (picUrl3 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(12, picUrl3);
                }
                i6++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        UserInfos.PicUrl[] picUrlArr7 = this.programmeUnfoldUrls;
        if (picUrlArr7 != null && picUrlArr7.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr8 = this.programmeUnfoldUrls;
                if (i3 >= picUrlArr8.length) {
                    break;
                }
                UserInfos.PicUrl picUrl4 = picUrlArr8[i3];
                if (picUrl4 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, picUrl4);
                }
                i3++;
            }
        }
        SCLiveOfficialProgrammeEnhanceInfo sCLiveOfficialProgrammeEnhanceInfo = this.nextStatusInfo;
        if (sCLiveOfficialProgrammeEnhanceInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, sCLiveOfficialProgrammeEnhanceInfo);
        }
        return !this.liteText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(15, this.liteText) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOfficialProgrammeEnhanceInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
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
                            this.statusType = int32;
                            break;
                    }
                case 18:
                    this.programmeId = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.text = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.showTimeDurationStr = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.showTimeUnit = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.countDownEndTimeMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.countDownDurationMs = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    if (this.showingAuthor == null) {
                        this.showingAuthor = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.showingAuthor);
                    break;
                case 74:
                    this.kwaiUrl = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    UserInfos.PicUrl[] picUrlArr = this.programmeIconUrls;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.programmeIconUrls, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.programmeIconUrls = picUrlArr2;
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    UserInfos.PicUrl[] picUrlArr3 = this.showingLottieUrls;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.showingLottieUrls, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.showingLottieUrls = picUrlArr4;
                    break;
                case 98:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    UserInfos.PicUrl[] picUrlArr5 = this.backgroundImageUrls;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.backgroundImageUrls, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.backgroundImageUrls = picUrlArr6;
                    break;
                case 106:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    UserInfos.PicUrl[] picUrlArr7 = this.programmeUnfoldUrls;
                    int length4 = picUrlArr7 == null ? 0 : picUrlArr7.length;
                    UserInfos.PicUrl[] picUrlArr8 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.programmeUnfoldUrls, 0, picUrlArr8, 0, length4);
                    }
                    while (length4 < picUrlArr8.length - 1) {
                        picUrlArr8[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr8[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                    this.programmeUnfoldUrls = picUrlArr8;
                    break;
                case 114:
                    if (this.nextStatusInfo == null) {
                        this.nextStatusInfo = new SCLiveOfficialProgrammeEnhanceInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.nextStatusInfo);
                    break;
                case 122:
                    this.liteText = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveOfficialProgrammeEnhanceInfo parseFrom(byte[] bArr) {
        return (SCLiveOfficialProgrammeEnhanceInfo) MessageNano.mergeFrom(new SCLiveOfficialProgrammeEnhanceInfo(), bArr);
    }

    public static SCLiveOfficialProgrammeEnhanceInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOfficialProgrammeEnhanceInfo().mergeFrom(codedInputByteBufferNano);
    }
}
