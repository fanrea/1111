package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePkFirstBlood extends MessageNano {
    private static volatile LivePkFirstBlood[] _emptyArray;
    public UserInfos.UserInfo firstBloodUser;
    public String pkId;

    public static LivePkFirstBlood[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePkFirstBlood[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePkFirstBlood() {
        clear();
    }

    public final LivePkFirstBlood clear() {
        this.pkId = "";
        this.firstBloodUser = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        UserInfos.UserInfo userInfo = this.firstBloodUser;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        UserInfos.UserInfo userInfo = this.firstBloodUser;
        return userInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, userInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePkFirstBlood mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.firstBloodUser == null) {
                    this.firstBloodUser = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.firstBloodUser);
            }
        }
    }

    public static LivePkFirstBlood parseFrom(byte[] bArr) {
        return (LivePkFirstBlood) MessageNano.mergeFrom(new LivePkFirstBlood(), bArr);
    }

    public static LivePkFirstBlood parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePkFirstBlood().mergeFrom(codedInputByteBufferNano);
    }
}
