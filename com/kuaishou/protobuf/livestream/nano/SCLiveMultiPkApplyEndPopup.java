package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkApplyEndPopup extends MessageNano {
    private static volatile SCLiveMultiPkApplyEndPopup[] _emptyArray;
    public String pkId;
    public long timestamp;
    public UserInfos.UserInfo[] userInfo;

    public static SCLiveMultiPkApplyEndPopup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkApplyEndPopup[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkApplyEndPopup() {
        clear();
    }

    public final SCLiveMultiPkApplyEndPopup clear() {
        this.pkId = "";
        this.userInfo = UserInfos.UserInfo.emptyArray();
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        UserInfos.UserInfo[] userInfoArr = this.userInfo;
        if (userInfoArr != null && userInfoArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr2 = this.userInfo;
                if (i >= userInfoArr2.length) {
                    break;
                }
                UserInfos.UserInfo userInfo = userInfoArr2[i];
                if (userInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, userInfo);
                }
                i++;
            }
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        UserInfos.UserInfo[] userInfoArr = this.userInfo;
        if (userInfoArr != null && userInfoArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr2 = this.userInfo;
                if (i >= userInfoArr2.length) {
                    break;
                }
                UserInfos.UserInfo userInfo = userInfoArr2[i];
                if (userInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
                }
                i++;
            }
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkApplyEndPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserInfos.UserInfo[] userInfoArr = this.userInfo;
                int length = userInfoArr == null ? 0 : userInfoArr.length;
                UserInfos.UserInfo[] userInfoArr2 = new UserInfos.UserInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userInfo, 0, userInfoArr2, 0, length);
                }
                while (length < userInfoArr2.length - 1) {
                    userInfoArr2[length] = new UserInfos.UserInfo();
                    codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                userInfoArr2[length] = new UserInfos.UserInfo();
                codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                this.userInfo = userInfoArr2;
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveMultiPkApplyEndPopup parseFrom(byte[] bArr) {
        return (SCLiveMultiPkApplyEndPopup) MessageNano.mergeFrom(new SCLiveMultiPkApplyEndPopup(), bArr);
    }

    public static SCLiveMultiPkApplyEndPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkApplyEndPopup().mergeFrom(codedInputByteBufferNano);
    }
}
