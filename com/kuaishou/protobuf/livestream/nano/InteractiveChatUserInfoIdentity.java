package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatUserInfoIdentity extends MessageNano {
    private static volatile InteractiveChatUserInfoIdentity[] _emptyArray;
    public String liveStreamId;
    public int mediaType;
    public String sessionId;
    public InteractiveChatUserCommonInfo userCommonInfo;
    public String userExtraInfo;
    public UserInfos.UserInfo userInfo;

    public static InteractiveChatUserInfoIdentity[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatUserInfoIdentity[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatUserInfoIdentity() {
        clear();
    }

    public final InteractiveChatUserInfoIdentity clear() {
        this.userInfo = null;
        this.sessionId = "";
        this.mediaType = 0;
        this.userExtraInfo = "";
        this.liveStreamId = "";
        this.userCommonInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.sessionId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.sessionId);
        }
        int i = this.mediaType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        if (!this.userExtraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.userExtraInfo);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.liveStreamId);
        }
        InteractiveChatUserCommonInfo interactiveChatUserCommonInfo = this.userCommonInfo;
        if (interactiveChatUserCommonInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, interactiveChatUserCommonInfo);
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
        if (!this.sessionId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sessionId);
        }
        int i = this.mediaType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        if (!this.userExtraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.userExtraInfo);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.liveStreamId);
        }
        InteractiveChatUserCommonInfo interactiveChatUserCommonInfo = this.userCommonInfo;
        return interactiveChatUserCommonInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, interactiveChatUserCommonInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatUserInfoIdentity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.sessionId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.mediaType = int32;
                }
            } else if (tag == 34) {
                this.userExtraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.userCommonInfo == null) {
                    this.userCommonInfo = new InteractiveChatUserCommonInfo();
                }
                codedInputByteBufferNano.readMessage(this.userCommonInfo);
            }
        }
    }

    public static InteractiveChatUserInfoIdentity parseFrom(byte[] bArr) {
        return (InteractiveChatUserInfoIdentity) MessageNano.mergeFrom(new InteractiveChatUserInfoIdentity(), bArr);
    }

    public static InteractiveChatUserInfoIdentity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatUserInfoIdentity().mergeFrom(codedInputByteBufferNano);
    }
}
