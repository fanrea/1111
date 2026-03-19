package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveActivityPush extends MessageNano {
    private static volatile SCLiveActivityPush[] _emptyArray;
    public UserInfos.PicUrl[] backgroundPic;
    public String broadcastInfo;
    public long displayDuration;
    public String ksOrderId;
    public String targetLiveStreamId;
    public String title;
    public String titleBackgroundColor;

    public static SCLiveActivityPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveActivityPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveActivityPush() {
        clear();
    }

    public final SCLiveActivityPush clear() {
        this.title = "";
        this.titleBackgroundColor = "";
        this.backgroundPic = UserInfos.PicUrl.emptyArray();
        this.targetLiveStreamId = "";
        this.displayDuration = 0L;
        this.ksOrderId = "";
        this.broadcastInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        if (!this.titleBackgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.titleBackgroundColor);
        }
        UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.backgroundPic;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i++;
            }
        }
        if (!this.targetLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.targetLiveStreamId);
        }
        long j = this.displayDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        if (!this.ksOrderId.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.ksOrderId);
        }
        if (!this.broadcastInfo.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.broadcastInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        if (!this.titleBackgroundColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.titleBackgroundColor);
        }
        UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.backgroundPic;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i++;
            }
        }
        if (!this.targetLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.targetLiveStreamId);
        }
        long j = this.displayDuration;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        if (!this.ksOrderId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.ksOrderId);
        }
        return !this.broadcastInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.broadcastInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveActivityPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.titleBackgroundColor = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.backgroundPic, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.backgroundPic = picUrlArr2;
            } else if (tag == 34) {
                this.targetLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.displayDuration = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                this.ksOrderId = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.broadcastInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveActivityPush parseFrom(byte[] bArr) {
        return (SCLiveActivityPush) MessageNano.mergeFrom(new SCLiveActivityPush(), bArr);
    }

    public static SCLiveActivityPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveActivityPush().mergeFrom(codedInputByteBufferNano);
    }
}
