package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRePushStopPushPopup extends MessageNano {
    private static volatile SCLiveRePushStopPushPopup[] _emptyArray;
    public long countdownMs;
    public String newDeviceId;
    public String text;

    public static SCLiveRePushStopPushPopup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRePushStopPushPopup[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRePushStopPushPopup() {
        clear();
    }

    public final SCLiveRePushStopPushPopup clear() {
        this.newDeviceId = "";
        this.countdownMs = 0L;
        this.text = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.newDeviceId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.newDeviceId);
        }
        long j = this.countdownMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.text);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.newDeviceId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.newDeviceId);
        }
        long j = this.countdownMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        return !this.text.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.text) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRePushStopPushPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.newDeviceId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.countdownMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.text = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveRePushStopPushPopup parseFrom(byte[] bArr) {
        return (SCLiveRePushStopPushPopup) MessageNano.mergeFrom(new SCLiveRePushStopPushPopup(), bArr);
    }

    public static SCLiveRePushStopPushPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRePushStopPushPopup().mergeFrom(codedInputByteBufferNano);
    }
}
