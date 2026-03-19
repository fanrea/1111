package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyPkTopContributor extends MessageNano {
    private static volatile LiveVoicePartyPkTopContributor[] _emptyArray;
    public UserInfos.UserInfo user;

    public static LiveVoicePartyPkTopContributor[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyPkTopContributor[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyPkTopContributor() {
        clear();
    }

    public final LiveVoicePartyPkTopContributor clear() {
        this.user = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.user;
        return userInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, userInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyPkTopContributor mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            }
        }
    }

    public static LiveVoicePartyPkTopContributor parseFrom(byte[] bArr) {
        return (LiveVoicePartyPkTopContributor) MessageNano.mergeFrom(new LiveVoicePartyPkTopContributor(), bArr);
    }

    public static LiveVoicePartyPkTopContributor parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyPkTopContributor().mergeFrom(codedInputByteBufferNano);
    }
}
