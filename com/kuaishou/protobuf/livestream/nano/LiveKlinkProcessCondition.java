package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveKlinkProcessCondition extends MessageNano {
    private static volatile LiveKlinkProcessCondition[] _emptyArray;
    public String enableProcessLiveStreamId;

    public static LiveKlinkProcessCondition[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveKlinkProcessCondition[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveKlinkProcessCondition() {
        clear();
    }

    public final LiveKlinkProcessCondition clear() {
        this.enableProcessLiveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.enableProcessLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.enableProcessLiveStreamId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.enableProcessLiveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.enableProcessLiveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveKlinkProcessCondition mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableProcessLiveStreamId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveKlinkProcessCondition parseFrom(byte[] bArr) {
        return (LiveKlinkProcessCondition) MessageNano.mergeFrom(new LiveKlinkProcessCondition(), bArr);
    }

    public static LiveKlinkProcessCondition parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveKlinkProcessCondition().mergeFrom(codedInputByteBufferNano);
    }
}
