package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHappyPlayOpenResultNotice extends MessageNano {
    private static volatile LiveHappyPlayOpenResultNotice[] _emptyArray;
    public String buttonText;
    public int giftId;
    public String noticeText;
    public LiveAudienceState senderState;
    public UserInfos.UserInfo user;

    public static LiveHappyPlayOpenResultNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHappyPlayOpenResultNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHappyPlayOpenResultNotice() {
        clear();
    }

    public final LiveHappyPlayOpenResultNotice clear() {
        this.user = null;
        this.noticeText = "";
        this.giftId = 0;
        this.buttonText = "";
        this.senderState = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.noticeText.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.noticeText);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.buttonText);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(5, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.noticeText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.noticeText);
        }
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonText);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        return liveAudienceState != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, liveAudienceState) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHappyPlayOpenResultNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 18) {
                this.noticeText = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 34) {
                this.buttonText = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            }
        }
    }

    public static LiveHappyPlayOpenResultNotice parseFrom(byte[] bArr) {
        return (LiveHappyPlayOpenResultNotice) MessageNano.mergeFrom(new LiveHappyPlayOpenResultNotice(), bArr);
    }

    public static LiveHappyPlayOpenResultNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHappyPlayOpenResultNotice().mergeFrom(codedInputByteBufferNano);
    }
}
