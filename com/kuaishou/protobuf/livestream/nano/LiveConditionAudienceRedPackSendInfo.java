package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCustomRedPackSkinMessage;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveConditionAudienceRedPackSendInfo extends MessageNano {
    private static volatile LiveConditionAudienceRedPackSendInfo[] _emptyArray;
    public LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme customRedPackSkinTheme;
    public long displayDeadline;
    public boolean enableGrabLeeeNotice;
    public boolean enableGrabLeeePopup;
    public LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig enhancedUiConfig;
    public String extraInfo;
    public String layoutConfig;
    public String liveStreamId;
    public long lotteryTime;
    public UserInfos.PicUrl[] noticeBgIconUrl;
    public LiveConditionRedPackPreparePageUIConfig preparePageUiConfig;
    public long queryLotteryDeadline;
    public long queryLotteryMaxDelayDuration;
    public int redPackBizType;
    public String redPackId;
    public int redPackType;
    public UserInfos.UserInfo senderInfo;
    public long showResultDeadline;
    public String uiConfig;
    public long[] useMainStateLayoutUserList;

    public static LiveConditionAudienceRedPackSendInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveConditionAudienceRedPackSendInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveConditionAudienceRedPackSendInfo() {
        clear();
    }

    public final LiveConditionAudienceRedPackSendInfo clear() {
        this.liveStreamId = "";
        this.redPackType = 0;
        this.redPackId = "";
        this.lotteryTime = 0L;
        this.senderInfo = null;
        this.displayDeadline = 0L;
        this.queryLotteryDeadline = 0L;
        this.queryLotteryMaxDelayDuration = 0L;
        this.showResultDeadline = 0L;
        this.extraInfo = "";
        this.customRedPackSkinTheme = null;
        this.redPackBizType = 0;
        this.preparePageUiConfig = null;
        this.layoutConfig = "";
        this.useMainStateLayoutUserList = WireFormatNano.EMPTY_LONG_ARRAY;
        this.uiConfig = "";
        this.enableGrabLeeePopup = false;
        this.enableGrabLeeeNotice = false;
        this.enhancedUiConfig = null;
        this.noticeBgIconUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.redPackId);
        }
        long j = this.lotteryTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        UserInfos.UserInfo userInfo = this.senderInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, userInfo);
        }
        long j2 = this.displayDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        long j3 = this.queryLotteryDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        long j4 = this.queryLotteryMaxDelayDuration;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j4);
        }
        long j5 = this.showResultDeadline;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j5);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.extraInfo);
        }
        LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme customRedPackSkinTheme = this.customRedPackSkinTheme;
        if (customRedPackSkinTheme != null) {
            codedOutputByteBufferNano.writeMessage(11, customRedPackSkinTheme);
        }
        int i2 = this.redPackBizType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i2);
        }
        LiveConditionRedPackPreparePageUIConfig liveConditionRedPackPreparePageUIConfig = this.preparePageUiConfig;
        if (liveConditionRedPackPreparePageUIConfig != null) {
            codedOutputByteBufferNano.writeMessage(13, liveConditionRedPackPreparePageUIConfig);
        }
        if (!this.layoutConfig.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.layoutConfig);
        }
        long[] jArr = this.useMainStateLayoutUserList;
        int i3 = 0;
        if (jArr != null && jArr.length > 0) {
            int i4 = 0;
            while (true) {
                long[] jArr2 = this.useMainStateLayoutUserList;
                if (i4 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(15, jArr2[i4]);
                i4++;
            }
        }
        if (!this.uiConfig.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.uiConfig);
        }
        boolean z = this.enableGrabLeeePopup;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        boolean z2 = this.enableGrabLeeeNotice;
        if (z2) {
            codedOutputByteBufferNano.writeBool(18, z2);
        }
        LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig liveLEEEnhancedUiConfig = this.enhancedUiConfig;
        if (liveLEEEnhancedUiConfig != null) {
            codedOutputByteBufferNano.writeMessage(19, liveLEEEnhancedUiConfig);
        }
        UserInfos.PicUrl[] picUrlArr = this.noticeBgIconUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.noticeBgIconUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(20, picUrl);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.redPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.redPackId);
        }
        long j = this.lotteryTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        UserInfos.UserInfo userInfo = this.senderInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, userInfo);
        }
        long j2 = this.displayDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        long j3 = this.queryLotteryDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        long j4 = this.queryLotteryMaxDelayDuration;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
        }
        long j5 = this.showResultDeadline;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j5);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.extraInfo);
        }
        LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme customRedPackSkinTheme = this.customRedPackSkinTheme;
        if (customRedPackSkinTheme != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, customRedPackSkinTheme);
        }
        int i2 = this.redPackBizType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i2);
        }
        LiveConditionRedPackPreparePageUIConfig liveConditionRedPackPreparePageUIConfig = this.preparePageUiConfig;
        if (liveConditionRedPackPreparePageUIConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, liveConditionRedPackPreparePageUIConfig);
        }
        if (!this.layoutConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.layoutConfig);
        }
        long[] jArr2 = this.useMainStateLayoutUserList;
        int i3 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i4 = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.useMainStateLayoutUserList;
                if (i4 >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i4]);
                i4++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        if (!this.uiConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.uiConfig);
        }
        boolean z = this.enableGrabLeeePopup;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        boolean z2 = this.enableGrabLeeeNotice;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, z2);
        }
        LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig liveLEEEnhancedUiConfig = this.enhancedUiConfig;
        if (liveLEEEnhancedUiConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, liveLEEEnhancedUiConfig);
        }
        UserInfos.PicUrl[] picUrlArr = this.noticeBgIconUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.noticeBgIconUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, picUrl);
                }
                i3++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveConditionAudienceRedPackSendInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        switch (int32) {
                        }
                    }
                    this.redPackType = int32;
                    break;
                case 26:
                    this.redPackId = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.lotteryTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    if (this.senderInfo == null) {
                        this.senderInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.senderInfo);
                    break;
                case 48:
                    this.displayDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.queryLotteryDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.queryLotteryMaxDelayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.showResultDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.customRedPackSkinTheme == null) {
                        this.customRedPackSkinTheme = new LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme();
                    }
                    codedInputByteBufferNano.readMessage(this.customRedPackSkinTheme);
                    break;
                case 96:
                    this.redPackBizType = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    if (this.preparePageUiConfig == null) {
                        this.preparePageUiConfig = new LiveConditionRedPackPreparePageUIConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.preparePageUiConfig);
                    break;
                case 114:
                    this.layoutConfig = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 120);
                    long[] jArr = this.useMainStateLayoutUserList;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.useMainStateLayoutUserList, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.useMainStateLayoutUserList = jArr2;
                    break;
                case 122:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.useMainStateLayoutUserList;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.useMainStateLayoutUserList, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.useMainStateLayoutUserList = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                case 130:
                    this.uiConfig = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.enableGrabLeeePopup = codedInputByteBufferNano.readBool();
                    break;
                case 144:
                    this.enableGrabLeeeNotice = codedInputByteBufferNano.readBool();
                    break;
                case 154:
                    if (this.enhancedUiConfig == null) {
                        this.enhancedUiConfig = new LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.enhancedUiConfig);
                    break;
                case 162:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    UserInfos.PicUrl[] picUrlArr = this.noticeBgIconUrl;
                    int length3 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.noticeBgIconUrl, 0, picUrlArr2, 0, length3);
                    }
                    while (length3 < picUrlArr2.length - 1) {
                        picUrlArr2[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr2[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                    this.noticeBgIconUrl = picUrlArr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveConditionAudienceRedPackSendInfo parseFrom(byte[] bArr) {
        return (LiveConditionAudienceRedPackSendInfo) MessageNano.mergeFrom(new LiveConditionAudienceRedPackSendInfo(), bArr);
    }

    public static LiveConditionAudienceRedPackSendInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveConditionAudienceRedPackSendInfo().mergeFrom(codedInputByteBufferNano);
    }
}
