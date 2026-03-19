package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkApplyContinueInvitePopup extends MessageNano {
    private static volatile SCLiveMultiPkApplyContinueInvitePopup[] _emptyArray;
    public MultiPKSignalCommonInfo commonInfo;
    public String noticeSubtitle;
    public String noticeTitle;
    public LiveMultiPkContinueInviteUserInfo[] userInfo;

    public static SCLiveMultiPkApplyContinueInvitePopup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkApplyContinueInvitePopup[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkApplyContinueInvitePopup() {
        clear();
    }

    public final SCLiveMultiPkApplyContinueInvitePopup clear() {
        this.commonInfo = null;
        this.userInfo = LiveMultiPkContinueInviteUserInfo.emptyArray();
        this.noticeTitle = "";
        this.noticeSubtitle = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        MultiPKSignalCommonInfo multiPKSignalCommonInfo = this.commonInfo;
        if (multiPKSignalCommonInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, multiPKSignalCommonInfo);
        }
        LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr = this.userInfo;
        if (liveMultiPkContinueInviteUserInfoArr != null && liveMultiPkContinueInviteUserInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr2 = this.userInfo;
                if (i >= liveMultiPkContinueInviteUserInfoArr2.length) {
                    break;
                }
                LiveMultiPkContinueInviteUserInfo liveMultiPkContinueInviteUserInfo = liveMultiPkContinueInviteUserInfoArr2[i];
                if (liveMultiPkContinueInviteUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, liveMultiPkContinueInviteUserInfo);
                }
                i++;
            }
        }
        if (!this.noticeTitle.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.noticeTitle);
        }
        if (!this.noticeSubtitle.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.noticeSubtitle);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        MultiPKSignalCommonInfo multiPKSignalCommonInfo = this.commonInfo;
        if (multiPKSignalCommonInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, multiPKSignalCommonInfo);
        }
        LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr = this.userInfo;
        if (liveMultiPkContinueInviteUserInfoArr != null && liveMultiPkContinueInviteUserInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveMultiPkContinueInviteUserInfo[] liveMultiPkContinueInviteUserInfoArr2 = this.userInfo;
                if (i >= liveMultiPkContinueInviteUserInfoArr2.length) {
                    break;
                }
                LiveMultiPkContinueInviteUserInfo liveMultiPkContinueInviteUserInfo = liveMultiPkContinueInviteUserInfoArr2[i];
                if (liveMultiPkContinueInviteUserInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveMultiPkContinueInviteUserInfo);
                }
                i++;
            }
        }
        if (!this.noticeTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.noticeTitle);
        }
        return !this.noticeSubtitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.noticeSubtitle) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkApplyContinueInvitePopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.commonInfo == null) {
                    this.commonInfo = new MultiPKSignalCommonInfo();
                }
                codedInputByteBufferNano.readMessage(this.commonInfo);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
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
            } else if (tag == 26) {
                this.noticeTitle = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.noticeSubtitle = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveMultiPkApplyContinueInvitePopup parseFrom(byte[] bArr) {
        return (SCLiveMultiPkApplyContinueInvitePopup) MessageNano.mergeFrom(new SCLiveMultiPkApplyContinueInvitePopup(), bArr);
    }

    public static SCLiveMultiPkApplyContinueInvitePopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkApplyContinueInvitePopup().mergeFrom(codedInputByteBufferNano);
    }
}
