package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveNobleForbiddenProtectNotice extends MessageNano {
    private static volatile SCLiveNobleForbiddenProtectNotice[] _emptyArray;
    public long authorId;
    public String liveStreamId;
    public String protectText;
    public int protectType;
    public String userId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectType {
        public static final int COMMENT = 1;
        public static final int KICK = 2;
        public static final int UNKNOWN_PROTECT_TYPE = 0;
    }

    public static SCLiveNobleForbiddenProtectNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveNobleForbiddenProtectNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveNobleForbiddenProtectNotice() {
        clear();
    }

    public final SCLiveNobleForbiddenProtectNotice clear() {
        this.protectType = 0;
        this.protectText = "";
        this.authorId = 0L;
        this.liveStreamId = "";
        this.userId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.protectType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.protectText.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.protectText);
        }
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.liveStreamId);
        }
        if (!this.userId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.userId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.protectType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.protectText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.protectText);
        }
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
        }
        return !this.userId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.userId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveNobleForbiddenProtectNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.protectType = int32;
                }
            } else if (tag == 18) {
                this.protectText = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.userId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveNobleForbiddenProtectNotice parseFrom(byte[] bArr) {
        return (SCLiveNobleForbiddenProtectNotice) MessageNano.mergeFrom(new SCLiveNobleForbiddenProtectNotice(), bArr);
    }

    public static SCLiveNobleForbiddenProtectNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveNobleForbiddenProtectNotice().mergeFrom(codedInputByteBufferNano);
    }
}
