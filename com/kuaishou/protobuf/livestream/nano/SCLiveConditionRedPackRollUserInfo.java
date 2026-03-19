package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveConditionRedPackRollUserInfo extends MessageNano {
    private static volatile SCLiveConditionRedPackRollUserInfo[] _emptyArray;
    public String liveStreamId;
    public long minRollTime;
    public int redPackBizType;
    public String redPackId;
    public int redPackType;
    public UserInfos.UserInfo[] rollUser;

    public static SCLiveConditionRedPackRollUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveConditionRedPackRollUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveConditionRedPackRollUserInfo() {
        clear();
    }

    public final SCLiveConditionRedPackRollUserInfo clear() {
        this.liveStreamId = "";
        this.redPackType = 0;
        this.redPackId = "";
        this.rollUser = UserInfos.UserInfo.emptyArray();
        this.minRollTime = 0L;
        this.redPackBizType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.redPackId);
        }
        UserInfos.UserInfo[] userInfoArr = this.rollUser;
        if (userInfoArr != null && userInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr2 = this.rollUser;
                if (i2 >= userInfoArr2.length) {
                    break;
                }
                UserInfos.UserInfo userInfo = userInfoArr2[i2];
                if (userInfo != null) {
                    codedOutputByteBufferNano.writeMessage(4, userInfo);
                }
                i2++;
            }
        }
        long j = this.minRollTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        int i3 = this.redPackBizType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.redPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.redPackId);
        }
        UserInfos.UserInfo[] userInfoArr = this.rollUser;
        if (userInfoArr != null && userInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr2 = this.rollUser;
                if (i2 >= userInfoArr2.length) {
                    break;
                }
                UserInfos.UserInfo userInfo = userInfoArr2[i2];
                if (userInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
                }
                i2++;
            }
        }
        long j = this.minRollTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        int i3 = this.redPackBizType;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveConditionRedPackRollUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 != 0 && int32 != 1 && int32 != 2) {
                    switch (int32) {
                    }
                }
                this.redPackType = int32;
            } else if (tag == 26) {
                this.redPackId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.UserInfo[] userInfoArr = this.rollUser;
                int length = userInfoArr == null ? 0 : userInfoArr.length;
                UserInfos.UserInfo[] userInfoArr2 = new UserInfos.UserInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.rollUser, 0, userInfoArr2, 0, length);
                }
                while (length < userInfoArr2.length - 1) {
                    userInfoArr2[length] = new UserInfos.UserInfo();
                    codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                userInfoArr2[length] = new UserInfos.UserInfo();
                codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                this.rollUser = userInfoArr2;
            } else if (tag == 40) {
                this.minRollTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.redPackBizType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveConditionRedPackRollUserInfo parseFrom(byte[] bArr) {
        return (SCLiveConditionRedPackRollUserInfo) MessageNano.mergeFrom(new SCLiveConditionRedPackRollUserInfo(), bArr);
    }

    public static SCLiveConditionRedPackRollUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveConditionRedPackRollUserInfo().mergeFrom(codedInputByteBufferNano);
    }
}
