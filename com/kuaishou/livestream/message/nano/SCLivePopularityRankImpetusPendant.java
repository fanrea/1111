package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePopularityRankImpetusPendant extends MessageNano {
    private static volatile SCLivePopularityRankImpetusPendant[] _emptyArray;
    public int actionCode;
    public boolean clickClose;
    public String extraClientLog;
    public UserInfos.PicUrl[] foldArrowUrl;
    public boolean foldDisable;
    public UserInfos.PicUrl[] frameFoldBackgroundPicUrl;
    public LivePopularityRankImpetusPendantFrameInfo[] frameInfo;
    public long frameIntervalMs;
    public UserInfos.PicUrl[] frameUnfoldBackgroundPicUrl;
    public int initFoldStatus;
    public boolean lastPendantDelete;
    public long pendantEndTs;
    public PopularityRankImpetusPendantFold pendantFold;
    public PopularityRankImpetusPendantUnfold pendantUnfold;
    public long unfoldDurationMs;
    public String waitCountDownColor;
    public long waitCountEndTs;

    public static SCLivePopularityRankImpetusPendant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePopularityRankImpetusPendant[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePopularityRankImpetusPendant() {
        clear();
    }

    public final SCLivePopularityRankImpetusPendant clear() {
        this.actionCode = 0;
        this.pendantEndTs = 0L;
        this.initFoldStatus = 0;
        this.pendantFold = null;
        this.pendantUnfold = null;
        this.foldArrowUrl = UserInfos.PicUrl.emptyArray();
        this.unfoldDurationMs = 0L;
        this.waitCountEndTs = 0L;
        this.waitCountDownColor = "";
        this.extraClientLog = "";
        this.frameInfo = LivePopularityRankImpetusPendantFrameInfo.emptyArray();
        this.frameIntervalMs = 0L;
        this.foldDisable = false;
        this.clickClose = false;
        this.frameFoldBackgroundPicUrl = UserInfos.PicUrl.emptyArray();
        this.frameUnfoldBackgroundPicUrl = UserInfos.PicUrl.emptyArray();
        this.lastPendantDelete = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.actionCode;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.pendantEndTs;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        int i2 = this.initFoldStatus;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        PopularityRankImpetusPendantFold popularityRankImpetusPendantFold = this.pendantFold;
        if (popularityRankImpetusPendantFold != null) {
            codedOutputByteBufferNano.writeMessage(4, popularityRankImpetusPendantFold);
        }
        PopularityRankImpetusPendantUnfold popularityRankImpetusPendantUnfold = this.pendantUnfold;
        if (popularityRankImpetusPendantUnfold != null) {
            codedOutputByteBufferNano.writeMessage(5, popularityRankImpetusPendantUnfold);
        }
        UserInfos.PicUrl[] picUrlArr = this.foldArrowUrl;
        int i3 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.foldArrowUrl;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(6, picUrl);
                }
                i4++;
            }
        }
        long j2 = this.unfoldDurationMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j2);
        }
        long j3 = this.waitCountEndTs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j3);
        }
        if (!this.waitCountDownColor.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.waitCountDownColor);
        }
        if (!this.extraClientLog.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.extraClientLog);
        }
        LivePopularityRankImpetusPendantFrameInfo[] livePopularityRankImpetusPendantFrameInfoArr = this.frameInfo;
        if (livePopularityRankImpetusPendantFrameInfoArr != null && livePopularityRankImpetusPendantFrameInfoArr.length > 0) {
            int i5 = 0;
            while (true) {
                LivePopularityRankImpetusPendantFrameInfo[] livePopularityRankImpetusPendantFrameInfoArr2 = this.frameInfo;
                if (i5 >= livePopularityRankImpetusPendantFrameInfoArr2.length) {
                    break;
                }
                LivePopularityRankImpetusPendantFrameInfo livePopularityRankImpetusPendantFrameInfo = livePopularityRankImpetusPendantFrameInfoArr2[i5];
                if (livePopularityRankImpetusPendantFrameInfo != null) {
                    codedOutputByteBufferNano.writeMessage(11, livePopularityRankImpetusPendantFrameInfo);
                }
                i5++;
            }
        }
        long j4 = this.frameIntervalMs;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeInt64(12, j4);
        }
        boolean z = this.foldDisable;
        if (z) {
            codedOutputByteBufferNano.writeBool(13, z);
        }
        boolean z2 = this.clickClose;
        if (z2) {
            codedOutputByteBufferNano.writeBool(14, z2);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.frameFoldBackgroundPicUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.frameFoldBackgroundPicUrl;
                if (i6 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i6];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(15, picUrl2);
                }
                i6++;
            }
        }
        UserInfos.PicUrl[] picUrlArr5 = this.frameUnfoldBackgroundPicUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.frameUnfoldBackgroundPicUrl;
                if (i3 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i3];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(16, picUrl3);
                }
                i3++;
            }
        }
        boolean z3 = this.lastPendantDelete;
        if (z3) {
            codedOutputByteBufferNano.writeBool(17, z3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.actionCode;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.pendantEndTs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        int i2 = this.initFoldStatus;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        PopularityRankImpetusPendantFold popularityRankImpetusPendantFold = this.pendantFold;
        if (popularityRankImpetusPendantFold != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, popularityRankImpetusPendantFold);
        }
        PopularityRankImpetusPendantUnfold popularityRankImpetusPendantUnfold = this.pendantUnfold;
        if (popularityRankImpetusPendantUnfold != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, popularityRankImpetusPendantUnfold);
        }
        UserInfos.PicUrl[] picUrlArr = this.foldArrowUrl;
        int i3 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.foldArrowUrl;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        long j2 = this.unfoldDurationMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j2);
        }
        long j3 = this.waitCountEndTs;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j3);
        }
        if (!this.waitCountDownColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.waitCountDownColor);
        }
        if (!this.extraClientLog.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.extraClientLog);
        }
        LivePopularityRankImpetusPendantFrameInfo[] livePopularityRankImpetusPendantFrameInfoArr = this.frameInfo;
        if (livePopularityRankImpetusPendantFrameInfoArr != null && livePopularityRankImpetusPendantFrameInfoArr.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i5 = 0;
            while (true) {
                LivePopularityRankImpetusPendantFrameInfo[] livePopularityRankImpetusPendantFrameInfoArr2 = this.frameInfo;
                if (i5 >= livePopularityRankImpetusPendantFrameInfoArr2.length) {
                    break;
                }
                LivePopularityRankImpetusPendantFrameInfo livePopularityRankImpetusPendantFrameInfo = livePopularityRankImpetusPendantFrameInfoArr2[i5];
                if (livePopularityRankImpetusPendantFrameInfo != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(11, livePopularityRankImpetusPendantFrameInfo);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        long j4 = this.frameIntervalMs;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(12, j4);
        }
        boolean z = this.foldDisable;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z);
        }
        boolean z2 = this.clickClose;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z2);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.frameFoldBackgroundPicUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.frameFoldBackgroundPicUrl;
                if (i6 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i6];
                if (picUrl2 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(15, picUrl2);
                }
                i6++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        UserInfos.PicUrl[] picUrlArr5 = this.frameUnfoldBackgroundPicUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.frameUnfoldBackgroundPicUrl;
                if (i3 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i3];
                if (picUrl3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, picUrl3);
                }
                i3++;
            }
        }
        boolean z3 = this.lastPendantDelete;
        return z3 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(17, z3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePopularityRankImpetusPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.actionCode = codedInputByteBufferNano.readInt32();
                    break;
                case 16:
                    this.pendantEndTs = codedInputByteBufferNano.readInt64();
                    break;
                case 24:
                    this.initFoldStatus = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    if (this.pendantFold == null) {
                        this.pendantFold = new PopularityRankImpetusPendantFold();
                    }
                    codedInputByteBufferNano.readMessage(this.pendantFold);
                    break;
                case 42:
                    if (this.pendantUnfold == null) {
                        this.pendantUnfold = new PopularityRankImpetusPendantUnfold();
                    }
                    codedInputByteBufferNano.readMessage(this.pendantUnfold);
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr = this.foldArrowUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.foldArrowUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.foldArrowUrl = picUrlArr2;
                    break;
                case 56:
                    this.unfoldDurationMs = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    this.waitCountEndTs = codedInputByteBufferNano.readInt64();
                    break;
                case 74:
                    this.waitCountDownColor = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.extraClientLog = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    LivePopularityRankImpetusPendantFrameInfo[] livePopularityRankImpetusPendantFrameInfoArr = this.frameInfo;
                    int length2 = livePopularityRankImpetusPendantFrameInfoArr == null ? 0 : livePopularityRankImpetusPendantFrameInfoArr.length;
                    LivePopularityRankImpetusPendantFrameInfo[] livePopularityRankImpetusPendantFrameInfoArr2 = new LivePopularityRankImpetusPendantFrameInfo[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.frameInfo, 0, livePopularityRankImpetusPendantFrameInfoArr2, 0, length2);
                    }
                    while (length2 < livePopularityRankImpetusPendantFrameInfoArr2.length - 1) {
                        livePopularityRankImpetusPendantFrameInfoArr2[length2] = new LivePopularityRankImpetusPendantFrameInfo();
                        codedInputByteBufferNano.readMessage(livePopularityRankImpetusPendantFrameInfoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    livePopularityRankImpetusPendantFrameInfoArr2[length2] = new LivePopularityRankImpetusPendantFrameInfo();
                    codedInputByteBufferNano.readMessage(livePopularityRankImpetusPendantFrameInfoArr2[length2]);
                    this.frameInfo = livePopularityRankImpetusPendantFrameInfoArr2;
                    break;
                case 96:
                    this.frameIntervalMs = codedInputByteBufferNano.readInt64();
                    break;
                case 104:
                    this.foldDisable = codedInputByteBufferNano.readBool();
                    break;
                case 112:
                    this.clickClose = codedInputByteBufferNano.readBool();
                    break;
                case 122:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    UserInfos.PicUrl[] picUrlArr3 = this.frameFoldBackgroundPicUrl;
                    int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.frameFoldBackgroundPicUrl, 0, picUrlArr4, 0, length3);
                    }
                    while (length3 < picUrlArr4.length - 1) {
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr4[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                    this.frameFoldBackgroundPicUrl = picUrlArr4;
                    break;
                case 130:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    UserInfos.PicUrl[] picUrlArr5 = this.frameUnfoldBackgroundPicUrl;
                    int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.frameUnfoldBackgroundPicUrl, 0, picUrlArr6, 0, length4);
                    }
                    while (length4 < picUrlArr6.length - 1) {
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr6[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                    this.frameUnfoldBackgroundPicUrl = picUrlArr6;
                    break;
                case 136:
                    this.lastPendantDelete = codedInputByteBufferNano.readBool();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLivePopularityRankImpetusPendant parseFrom(byte[] bArr) {
        return (SCLivePopularityRankImpetusPendant) MessageNano.mergeFrom(new SCLivePopularityRankImpetusPendant(), bArr);
    }

    public static SCLivePopularityRankImpetusPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePopularityRankImpetusPendant().mergeFrom(codedInputByteBufferNano);
    }
}
