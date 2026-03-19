package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCMicSeatsOpenVideoAuthority extends MessageNano {
    private static volatile SCMicSeatsOpenVideoAuthority[] _emptyArray;
    public int authorizedUser;
    public String liveStreamId;
    public String voicePartyId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserRelation {
        public static final int ALL_USER = 1;
        public static final int FANS = 2;
        public static final int FRIEND = 3;
        public static final int NO_USER = 4;
        public static final int UNKNOWN = 0;
    }

    public static SCMicSeatsOpenVideoAuthority[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMicSeatsOpenVideoAuthority[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMicSeatsOpenVideoAuthority() {
        clear();
    }

    public final SCMicSeatsOpenVideoAuthority clear() {
        this.authorizedUser = 0;
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.authorizedUser;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.voicePartyId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.authorizedUser;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        return !this.voicePartyId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.voicePartyId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMicSeatsOpenVideoAuthority mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.authorizedUser = int32;
                }
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.voicePartyId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCMicSeatsOpenVideoAuthority parseFrom(byte[] bArr) {
        return (SCMicSeatsOpenVideoAuthority) MessageNano.mergeFrom(new SCMicSeatsOpenVideoAuthority(), bArr);
    }

    public static SCMicSeatsOpenVideoAuthority parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMicSeatsOpenVideoAuthority().mergeFrom(codedInputByteBufferNano);
    }
}
