package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkContinueInviteUserInfo extends MessageNano {
    private static volatile LiveMultiPkContinueInviteUserInfo[] _emptyArray;
    public BountyGameTag bountyGameTag;
    public String onlineUserCount;
    public UserInfos.UserInfo userInfo;

    public static LiveMultiPkContinueInviteUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkContinueInviteUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkContinueInviteUserInfo() {
        clear();
    }

    public final LiveMultiPkContinueInviteUserInfo clear() {
        this.userInfo = null;
        this.onlineUserCount = "";
        this.bountyGameTag = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.onlineUserCount.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.onlineUserCount);
        }
        BountyGameTag bountyGameTag = this.bountyGameTag;
        if (bountyGameTag != null) {
            codedOutputByteBufferNano.writeMessage(3, bountyGameTag);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.onlineUserCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.onlineUserCount);
        }
        BountyGameTag bountyGameTag = this.bountyGameTag;
        return bountyGameTag != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, bountyGameTag) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkContinueInviteUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.userInfo == null) {
                    this.userInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.userInfo);
            } else if (tag == 18) {
                this.onlineUserCount = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.bountyGameTag == null) {
                    this.bountyGameTag = new BountyGameTag();
                }
                codedInputByteBufferNano.readMessage(this.bountyGameTag);
            }
        }
    }

    public static LiveMultiPkContinueInviteUserInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkContinueInviteUserInfo) MessageNano.mergeFrom(new LiveMultiPkContinueInviteUserInfo(), bArr);
    }

    public static LiveMultiPkContinueInviteUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkContinueInviteUserInfo().mergeFrom(codedInputByteBufferNano);
    }
}
