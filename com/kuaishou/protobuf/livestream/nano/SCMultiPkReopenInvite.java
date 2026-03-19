package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCMultiPkReopenInvite extends MessageNano {
    private static volatile SCMultiPkReopenInvite[] _emptyArray;
    public String acceptButtonText;
    public String chatId;
    public String noticeSubtitle;
    public String noticeTitle;
    public String pkId;
    public int reopenSource;
    public int reopenType;
    public long timeoutMillis;
    public LiveMultiPkContinueInviteUserInfo[] userInfo;
    public long waitSwitchBizTimeoutMillis;

    public static SCMultiPkReopenInvite[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMultiPkReopenInvite[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMultiPkReopenInvite() {
        clear();
    }

    public final SCMultiPkReopenInvite clear() {
        this.pkId = "";
        this.reopenSource = 0;
        this.timeoutMillis = 0L;
        this.chatId = "";
        this.noticeTitle = "";
        this.noticeSubtitle = "";
        this.acceptButtonText = "";
        this.reopenType = 0;
        this.waitSwitchBizTimeoutMillis = 0L;
        this.userInfo = LiveMultiPkContinueInviteUserInfo.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        int i = this.reopenSource;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        long j = this.timeoutMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.chatId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.chatId);
        }
        if (!this.noticeTitle.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.noticeTitle);
        }
        if (!this.noticeSubtitle.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.noticeSubtitle);
        }
        if (!this.acceptButtonText.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.acceptButtonText);
        }
        int i2 = this.reopenType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i2);
        }
        long j2 = this.waitSwitchBizTimeoutMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j2);
        }
        LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr = this.userInfo;
        if (liveMultiPkContinueInviteUserInfoArr != null && liveMultiPkContinueInviteUserInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr2 = this.userInfo;
                if (i3 >= liveMultiPkContinueInviteUserInfoArr2.length) {
                    break;
                }
                LiveMultiPkContinueInviteUserInfo liveMultiPkContinueInviteUserInfo = liveMultiPkContinueInviteUserInfoArr2[i3];
                if (liveMultiPkContinueInviteUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(10, liveMultiPkContinueInviteUserInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        int i = this.reopenSource;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        long j = this.timeoutMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.chatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.chatId);
        }
        if (!this.noticeTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.noticeTitle);
        }
        if (!this.noticeSubtitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.noticeSubtitle);
        }
        if (!this.acceptButtonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.acceptButtonText);
        }
        int i2 = this.reopenType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i2);
        }
        long j2 = this.waitSwitchBizTimeoutMillis;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j2);
        }
        LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr = this.userInfo;
        if (liveMultiPkContinueInviteUserInfoArr != null && liveMultiPkContinueInviteUserInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr2 = this.userInfo;
                if (i3 >= liveMultiPkContinueInviteUserInfoArr2.length) {
                    break;
                }
                LiveMultiPkContinueInviteUserInfo liveMultiPkContinueInviteUserInfo = liveMultiPkContinueInviteUserInfoArr2[i3];
                if (liveMultiPkContinueInviteUserInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, liveMultiPkContinueInviteUserInfo);
                }
                i3++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMultiPkReopenInvite mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.pkId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.reopenSource = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.timeoutMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.chatId = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.noticeTitle = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.noticeSubtitle = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.acceptButtonText = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.reopenType = int32;
                        break;
                    }
                    break;
                case 72:
                    this.waitSwitchBizTimeoutMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr = this.userInfo;
                    int length = liveMultiPkContinueInviteUserInfoArr == null ? 0 : liveMultiPkContinueInviteUserInfoArr.length;
                    LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr2 = new LiveMultiPkContinueInviteUserInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.userInfo, 0, liveMultiPkContinueInviteUserInfoArr2, 0, length);
                    }
                    while (length < liveMultiPkContinueInviteUserInfoArr2.length - 1) {
                        liveMultiPkContinueInviteUserInfoArr2[length] = new LiveMultiPkContinueInviteUserInfo();
                        codedInputByteBufferNano.readMessage(liveMultiPkContinueInviteUserInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveMultiPkContinueInviteUserInfoArr2[length] = new LiveMultiPkContinueInviteUserInfo();
                    codedInputByteBufferNano.readMessage(liveMultiPkContinueInviteUserInfoArr2[length]);
                    this.userInfo = liveMultiPkContinueInviteUserInfoArr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCMultiPkReopenInvite parseFrom(byte[] bArr) {
        return (SCMultiPkReopenInvite) MessageNano.mergeFrom(new SCMultiPkReopenInvite(), bArr);
    }

    public static SCMultiPkReopenInvite parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMultiPkReopenInvite().mergeFrom(codedInputByteBufferNano);
    }
}
