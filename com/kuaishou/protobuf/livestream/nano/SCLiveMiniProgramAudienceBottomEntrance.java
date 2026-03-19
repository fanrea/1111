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
public final class SCLiveMiniProgramAudienceBottomEntrance extends MessageNano {
    private static volatile SCLiveMiniProgramAudienceBottomEntrance[] _emptyArray;
    public int entranceStatus;

    @Retention(RetentionPolicy.SOURCE)
    public @interface STATUS {
        public static final int CLOSE = 2;
        public static final int OPEN = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveMiniProgramAudienceBottomEntrance[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMiniProgramAudienceBottomEntrance[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMiniProgramAudienceBottomEntrance() {
        clear();
    }

    public final SCLiveMiniProgramAudienceBottomEntrance clear() {
        this.entranceStatus = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.entranceStatus;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.entranceStatus;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMiniProgramAudienceBottomEntrance mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.entranceStatus = int32;
                }
            }
        }
    }

    public static SCLiveMiniProgramAudienceBottomEntrance parseFrom(byte[] bArr) {
        return (SCLiveMiniProgramAudienceBottomEntrance) MessageNano.mergeFrom(new SCLiveMiniProgramAudienceBottomEntrance(), bArr);
    }

    public static SCLiveMiniProgramAudienceBottomEntrance parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMiniProgramAudienceBottomEntrance().mergeFrom(codedInputByteBufferNano);
    }
}
