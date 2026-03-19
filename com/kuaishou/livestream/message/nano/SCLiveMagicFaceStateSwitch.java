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
public final class SCLiveMagicFaceStateSwitch extends MessageNano {
    private static volatile SCLiveMagicFaceStateSwitch[] _emptyArray;
    public long magicFaceId;
    public String magicFaceName;
    public int magicFaceState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MagicFaceState {
        public static final int DISABLE = 2;
        public static final int ENABLE = 1;
        public static final int UNKNOWN_STATE = 0;
    }

    public static SCLiveMagicFaceStateSwitch[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMagicFaceStateSwitch[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMagicFaceStateSwitch() {
        clear();
    }

    public final SCLiveMagicFaceStateSwitch clear() {
        this.magicFaceState = 0;
        this.magicFaceId = 0L;
        this.magicFaceName = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.magicFaceState;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.magicFaceId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.magicFaceName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.magicFaceName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.magicFaceState;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.magicFaceId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        return !this.magicFaceName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.magicFaceName) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMagicFaceStateSwitch mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.magicFaceState = int32;
                }
            } else if (tag == 16) {
                this.magicFaceId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.magicFaceName = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveMagicFaceStateSwitch parseFrom(byte[] bArr) {
        return (SCLiveMagicFaceStateSwitch) MessageNano.mergeFrom(new SCLiveMagicFaceStateSwitch(), bArr);
    }

    public static SCLiveMagicFaceStateSwitch parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMagicFaceStateSwitch().mergeFrom(codedInputByteBufferNano);
    }
}
