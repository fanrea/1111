package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatMatched extends MessageNano {
    private static volatile SCInteractiveChatMatched[] _emptyArray;
    public String aryaConfig;
    public long aryaConfigVersion;
    public InteractiveChatBizIdentity bizIdentity;
    public String extraInfo;
    public String matchId;
    public String sessionId;

    public static SCInteractiveChatMatched[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatMatched[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatMatched() {
        clear();
    }

    public final SCInteractiveChatMatched clear() {
        this.bizIdentity = null;
        this.aryaConfig = "";
        this.sessionId = "";
        this.extraInfo = "";
        this.matchId = "";
        this.aryaConfigVersion = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        if (!this.aryaConfig.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.aryaConfig);
        }
        if (!this.sessionId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.sessionId);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extraInfo);
        }
        if (!this.matchId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.matchId);
        }
        long j = this.aryaConfigVersion;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
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
        if (!this.aryaConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.aryaConfig);
        }
        if (!this.sessionId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.sessionId);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
        }
        if (!this.matchId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.matchId);
        }
        long j = this.aryaConfigVersion;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatMatched mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.aryaConfig = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.sessionId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.matchId = codedInputByteBufferNano.readString();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.aryaConfigVersion = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCInteractiveChatMatched parseFrom(byte[] bArr) {
        return (SCInteractiveChatMatched) MessageNano.mergeFrom(new SCInteractiveChatMatched(), bArr);
    }

    public static SCInteractiveChatMatched parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatMatched().mergeFrom(codedInputByteBufferNano);
    }
}
