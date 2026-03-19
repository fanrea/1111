package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAskOpened extends MessageNano {
    private static volatile SCLiveAskOpened[] _emptyArray;
    public String askId;
    public boolean enableDeleteConfirm;
    public boolean enableLockAsk;

    public static SCLiveAskOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAskOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAskOpened() {
        clear();
    }

    public final SCLiveAskOpened clear() {
        this.askId = "";
        this.enableLockAsk = false;
        this.enableDeleteConfirm = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.askId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.askId);
        }
        boolean z = this.enableLockAsk;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        boolean z2 = this.enableDeleteConfirm;
        if (z2) {
            codedOutputByteBufferNano.writeBool(3, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.askId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.askId);
        }
        boolean z = this.enableLockAsk;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        boolean z2 = this.enableDeleteConfirm;
        return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAskOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.askId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.enableLockAsk = codedInputByteBufferNano.readBool();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableDeleteConfirm = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCLiveAskOpened parseFrom(byte[] bArr) {
        return (SCLiveAskOpened) MessageNano.mergeFrom(new SCLiveAskOpened(), bArr);
    }

    public static SCLiveAskOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAskOpened().mergeFrom(codedInputByteBufferNano);
    }
}
