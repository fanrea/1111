package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiChatMediaTypeSwitchApply extends MessageNano {
    private static volatile SCLiveMultiChatMediaTypeSwitchApply[] _emptyArray;
    public UserInfos.UserInfo applier;
    public long countdownMs;
    public String liveStreamId;
    public int targetMediaType;
    public long timestamp;

    public static SCLiveMultiChatMediaTypeSwitchApply[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiChatMediaTypeSwitchApply[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiChatMediaTypeSwitchApply() {
        clear();
    }

    public final SCLiveMultiChatMediaTypeSwitchApply clear() {
        this.liveStreamId = "";
        this.applier = null;
        this.targetMediaType = 0;
        this.countdownMs = 0L;
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        UserInfos.UserInfo userInfo = this.applier;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        int i = this.targetMediaType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        long j = this.countdownMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        UserInfos.UserInfo userInfo = this.applier;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        int i = this.targetMediaType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        long j = this.countdownMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.timestamp;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiChatMediaTypeSwitchApply mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                if (this.applier == null) {
                    this.applier = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.applier);
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.targetMediaType = int32;
                }
            } else if (tag == 32) {
                this.countdownMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveMultiChatMediaTypeSwitchApply parseFrom(byte[] bArr) {
        return (SCLiveMultiChatMediaTypeSwitchApply) MessageNano.mergeFrom(new SCLiveMultiChatMediaTypeSwitchApply(), bArr);
    }

    public static SCLiveMultiChatMediaTypeSwitchApply parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiChatMediaTypeSwitchApply().mergeFrom(codedInputByteBufferNano);
    }
}
