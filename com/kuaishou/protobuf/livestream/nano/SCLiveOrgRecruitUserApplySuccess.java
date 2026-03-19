package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveOrgRecruitUserApplySuccess extends MessageNano {
    private static volatile SCLiveOrgRecruitUserApplySuccess[] _emptyArray;
    public boolean applySuccess;

    public static SCLiveOrgRecruitUserApplySuccess[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOrgRecruitUserApplySuccess[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOrgRecruitUserApplySuccess() {
        clear();
    }

    public final SCLiveOrgRecruitUserApplySuccess clear() {
        this.applySuccess = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.applySuccess;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.applySuccess;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOrgRecruitUserApplySuccess mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.applySuccess = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCLiveOrgRecruitUserApplySuccess parseFrom(byte[] bArr) {
        return (SCLiveOrgRecruitUserApplySuccess) MessageNano.mergeFrom(new SCLiveOrgRecruitUserApplySuccess(), bArr);
    }

    public static SCLiveOrgRecruitUserApplySuccess parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOrgRecruitUserApplySuccess().mergeFrom(codedInputByteBufferNano);
    }
}
