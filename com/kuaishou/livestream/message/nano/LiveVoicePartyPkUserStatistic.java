package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyPkUserStatistic extends MessageNano {
    private static volatile LiveVoicePartyPkUserStatistic[] _emptyArray;
    public String displayScore;
    public long score;
    public UserInfos.UserInfo userInfo;

    public static LiveVoicePartyPkUserStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyPkUserStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyPkUserStatistic() {
        clear();
    }

    public final LiveVoicePartyPkUserStatistic clear() {
        this.userInfo = null;
        this.score = 0L;
        this.displayScore = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        long j = this.score;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.displayScore.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.displayScore);
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
        long j = this.score;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        return !this.displayScore.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.displayScore) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyPkUserStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 16) {
                this.score = codedInputByteBufferNano.readUInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayScore = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveVoicePartyPkUserStatistic parseFrom(byte[] bArr) {
        return (LiveVoicePartyPkUserStatistic) MessageNano.mergeFrom(new LiveVoicePartyPkUserStatistic(), bArr);
    }

    public static LiveVoicePartyPkUserStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyPkUserStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
