package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveActivityPushV2 extends MessageNano {
    private static volatile SCLiveActivityPushV2[] _emptyArray;
    public String activityId;
    public int bizType;
    public String buttonText;
    public long displayDurationMillis;
    public String displayOnlineCount;
    public boolean enableSkipLimit;
    public String extraInfo;
    public boolean isShowOnlineCount;
    public String ksOrderId;
    public String messageId;
    public int messageType;
    public String reasonTagJson;
    public String subTitle;
    public UserInfos.UserInfo targetAuthorInfo;
    public String targetLiveStreamId;
    public String title;

    public static SCLiveActivityPushV2[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveActivityPushV2[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveActivityPushV2() {
        clear();
    }

    public final SCLiveActivityPushV2 clear() {
        this.activityId = "";
        this.title = "";
        this.targetLiveStreamId = "";
        this.targetAuthorInfo = null;
        this.displayOnlineCount = "";
        this.isShowOnlineCount = false;
        this.ksOrderId = "";
        this.displayDurationMillis = 0L;
        this.bizType = 0;
        this.subTitle = "";
        this.messageId = "";
        this.messageType = 0;
        this.reasonTagJson = "";
        this.buttonText = "";
        this.enableSkipLimit = false;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.activityId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.activityId);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.title);
        }
        if (!this.targetLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.targetLiveStreamId);
        }
        UserInfos.UserInfo userInfo = this.targetAuthorInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo);
        }
        if (!this.displayOnlineCount.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.displayOnlineCount);
        }
        boolean z = this.isShowOnlineCount;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        if (!this.ksOrderId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.ksOrderId);
        }
        long j = this.displayDurationMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j);
        }
        int i = this.bizType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(9, i);
        }
        if (!this.subTitle.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.subTitle);
        }
        if (!this.messageId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.messageId);
        }
        int i2 = this.messageType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i2);
        }
        if (!this.reasonTagJson.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.reasonTagJson);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.buttonText);
        }
        boolean z2 = this.enableSkipLimit;
        if (z2) {
            codedOutputByteBufferNano.writeBool(15, z2);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.activityId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activityId);
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
        }
        if (!this.targetLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.targetLiveStreamId);
        }
        UserInfos.UserInfo userInfo = this.targetAuthorInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
        }
        if (!this.displayOnlineCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayOnlineCount);
        }
        boolean z = this.isShowOnlineCount;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        if (!this.ksOrderId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.ksOrderId);
        }
        long j = this.displayDurationMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j);
        }
        int i = this.bizType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i);
        }
        if (!this.subTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.subTitle);
        }
        if (!this.messageId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.messageId);
        }
        int i2 = this.messageType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i2);
        }
        if (!this.reasonTagJson.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.reasonTagJson);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.buttonText);
        }
        boolean z2 = this.enableSkipLimit;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z2);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(16, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveActivityPushV2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.activityId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.targetLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.targetAuthorInfo == null) {
                        this.targetAuthorInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.targetAuthorInfo);
                    break;
                case 42:
                    this.displayOnlineCount = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.isShowOnlineCount = codedInputByteBufferNano.readBool();
                    break;
                case 58:
                    this.ksOrderId = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.displayDurationMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
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
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            this.bizType = int32;
                            break;
                    }
                case 82:
                    this.subTitle = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.messageId = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3) {
                        break;
                    } else {
                        this.messageType = int322;
                        break;
                    }
                case 106:
                    this.reasonTagJson = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.buttonText = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.enableSkipLimit = codedInputByteBufferNano.readBool();
                    break;
                case 130:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveActivityPushV2 parseFrom(byte[] bArr) {
        return (SCLiveActivityPushV2) MessageNano.mergeFrom(new SCLiveActivityPushV2(), bArr);
    }

    public static SCLiveActivityPushV2 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveActivityPushV2().mergeFrom(codedInputByteBufferNano);
    }
}
