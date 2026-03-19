package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkTeamMemberUpdateInfo extends MessageNano {
    private static volatile LiveMultiPkTeamMemberUpdateInfo[] _emptyArray;
    public BountyGameInfo bountyGameInfo;
    public String liveStreamId;
    public UserInfos.UserInfo player;

    public static LiveMultiPkTeamMemberUpdateInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkTeamMemberUpdateInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkTeamMemberUpdateInfo() {
        clear();
    }

    public final LiveMultiPkTeamMemberUpdateInfo clear() {
        this.player = null;
        this.liveStreamId = "";
        this.bountyGameInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.player;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        BountyGameInfo bountyGameInfo = this.bountyGameInfo;
        if (bountyGameInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, bountyGameInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.player;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        BountyGameInfo bountyGameInfo = this.bountyGameInfo;
        return bountyGameInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, bountyGameInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkTeamMemberUpdateInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.player == null) {
                    this.player = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.player);
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.bountyGameInfo == null) {
                    this.bountyGameInfo = new BountyGameInfo();
                }
                codedInputByteBufferNano.readMessage(this.bountyGameInfo);
            }
        }
    }

    public static LiveMultiPkTeamMemberUpdateInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkTeamMemberUpdateInfo) MessageNano.mergeFrom(new LiveMultiPkTeamMemberUpdateInfo(), bArr);
    }

    public static LiveMultiPkTeamMemberUpdateInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkTeamMemberUpdateInfo().mergeFrom(codedInputByteBufferNano);
    }
}
