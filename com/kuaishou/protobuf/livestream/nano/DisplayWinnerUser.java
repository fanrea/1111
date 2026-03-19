package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class DisplayWinnerUser extends MessageNano {
    private static volatile DisplayWinnerUser[] _emptyArray;
    public String extraInfo;
    public UserInfos.UserInfo userInfo;
    public int winKsCoin;

    public static DisplayWinnerUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DisplayWinnerUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public DisplayWinnerUser() {
        clear();
    }

    public final DisplayWinnerUser clear() {
        this.winKsCoin = 0;
        this.userInfo = null;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.winKsCoin;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.winKsCoin;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final DisplayWinnerUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.winKsCoin = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                if (this.userInfo == null) {
                    this.userInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.userInfo);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.extraInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static DisplayWinnerUser parseFrom(byte[] bArr) {
        return (DisplayWinnerUser) MessageNano.mergeFrom(new DisplayWinnerUser(), bArr);
    }

    public static DisplayWinnerUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new DisplayWinnerUser().mergeFrom(codedInputByteBufferNano);
    }
}
