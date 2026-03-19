package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatClosed extends MessageNano {
    private static volatile SCInteractiveChatClosed[] _emptyArray;
    public InteractiveChatBizIdentity bizIdentity;
    public InteractiveChatSwitchBizExtraInfo endExtraInfoPb;
    public String extraInfo;
    public long timestamp;
    public String toast;
    public UserInfos.UserInfo userInfo;

    public static SCInteractiveChatClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatClosed() {
        clear();
    }

    public final SCInteractiveChatClosed clear() {
        this.bizIdentity = null;
        this.userInfo = null;
        this.extraInfo = "";
        this.timestamp = 0L;
        this.toast = "";
        this.endExtraInfoPb = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        if (!this.toast.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.toast);
        }
        InteractiveChatSwitchBizExtraInfo interactiveChatSwitchBizExtraInfo = this.endExtraInfoPb;
        if (interactiveChatSwitchBizExtraInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, interactiveChatSwitchBizExtraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatBizIdentity);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        if (!this.toast.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.toast);
        }
        InteractiveChatSwitchBizExtraInfo interactiveChatSwitchBizExtraInfo = this.endExtraInfoPb;
        return interactiveChatSwitchBizExtraInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, interactiveChatSwitchBizExtraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.bizIdentity == null) {
                    this.bizIdentity = new InteractiveChatBizIdentity();
                }
                codedInputByteBufferNano.readMessage(this.bizIdentity);
            } else if (tag == 18) {
                if (this.userInfo == null) {
                    this.userInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.userInfo);
            } else if (tag == 26) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                this.toast = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.endExtraInfoPb == null) {
                    this.endExtraInfoPb = new InteractiveChatSwitchBizExtraInfo();
                }
                codedInputByteBufferNano.readMessage(this.endExtraInfoPb);
            }
        }
    }

    public static SCInteractiveChatClosed parseFrom(byte[] bArr) {
        return (SCInteractiveChatClosed) MessageNano.mergeFrom(new SCInteractiveChatClosed(), bArr);
    }

    public static SCInteractiveChatClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatClosed().mergeFrom(codedInputByteBufferNano);
    }
}
