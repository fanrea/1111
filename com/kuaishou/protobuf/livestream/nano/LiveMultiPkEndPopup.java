package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkEndPopup extends MessageNano {
    private static volatile LiveMultiPkEndPopup[] _emptyArray;
    public boolean enableDisplayEndPopup;
    public long popupDisplayMs;

    public static LiveMultiPkEndPopup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkEndPopup[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkEndPopup() {
        clear();
    }

    public final LiveMultiPkEndPopup clear() {
        this.enableDisplayEndPopup = false;
        this.popupDisplayMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.enableDisplayEndPopup;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.popupDisplayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enableDisplayEndPopup;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.popupDisplayMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkEndPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.enableDisplayEndPopup = codedInputByteBufferNano.readBool();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.popupDisplayMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiPkEndPopup parseFrom(byte[] bArr) {
        return (LiveMultiPkEndPopup) MessageNano.mergeFrom(new LiveMultiPkEndPopup(), bArr);
    }

    public static LiveMultiPkEndPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkEndPopup().mergeFrom(codedInputByteBufferNano);
    }
}
