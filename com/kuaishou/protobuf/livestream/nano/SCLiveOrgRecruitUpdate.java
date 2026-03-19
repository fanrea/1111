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
public final class SCLiveOrgRecruitUpdate extends MessageNano {
    private static volatile SCLiveOrgRecruitUpdate[] _emptyArray;
    public String applyCountDisplay;
    public int status;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveOrgRecruitStatus {
        public static final int CLOSE = 2;
        public static final int DEFAULT = 0;
        public static final int OPEN = 1;
    }

    public static SCLiveOrgRecruitUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOrgRecruitUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOrgRecruitUpdate() {
        clear();
    }

    public final SCLiveOrgRecruitUpdate clear() {
        this.status = 0;
        this.applyCountDisplay = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.applyCountDisplay.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.applyCountDisplay);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        return !this.applyCountDisplay.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.applyCountDisplay) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOrgRecruitUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.status = int32;
                }
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.applyCountDisplay = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveOrgRecruitUpdate parseFrom(byte[] bArr) {
        return (SCLiveOrgRecruitUpdate) MessageNano.mergeFrom(new SCLiveOrgRecruitUpdate(), bArr);
    }

    public static SCLiveOrgRecruitUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOrgRecruitUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
