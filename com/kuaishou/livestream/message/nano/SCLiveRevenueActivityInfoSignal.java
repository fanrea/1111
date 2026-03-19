package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRevenueActivityInfoSignal extends MessageNano {
    private static volatile SCLiveRevenueActivityInfoSignal[] _emptyArray;
    public SCLiveRevenueActivityInfoOverRoom overRoom;
    public SCLiveRevenueActivityInfoShakeActivity shakeActivity;

    public static SCLiveRevenueActivityInfoSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRevenueActivityInfoSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRevenueActivityInfoSignal() {
        clear();
    }

    public final SCLiveRevenueActivityInfoSignal clear() {
        this.overRoom = null;
        this.shakeActivity = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        SCLiveRevenueActivityInfoOverRoom sCLiveRevenueActivityInfoOverRoom = this.overRoom;
        if (sCLiveRevenueActivityInfoOverRoom != null) {
            codedOutputByteBufferNano.writeMessage(1, sCLiveRevenueActivityInfoOverRoom);
        }
        SCLiveRevenueActivityInfoShakeActivity sCLiveRevenueActivityInfoShakeActivity = this.shakeActivity;
        if (sCLiveRevenueActivityInfoShakeActivity != null) {
            codedOutputByteBufferNano.writeMessage(2, sCLiveRevenueActivityInfoShakeActivity);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        SCLiveRevenueActivityInfoOverRoom sCLiveRevenueActivityInfoOverRoom = this.overRoom;
        if (sCLiveRevenueActivityInfoOverRoom != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sCLiveRevenueActivityInfoOverRoom);
        }
        SCLiveRevenueActivityInfoShakeActivity sCLiveRevenueActivityInfoShakeActivity = this.shakeActivity;
        return sCLiveRevenueActivityInfoShakeActivity != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, sCLiveRevenueActivityInfoShakeActivity) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRevenueActivityInfoSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.overRoom == null) {
                    this.overRoom = new SCLiveRevenueActivityInfoOverRoom();
                }
                codedInputByteBufferNano.readMessage(this.overRoom);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.shakeActivity == null) {
                    this.shakeActivity = new SCLiveRevenueActivityInfoShakeActivity();
                }
                codedInputByteBufferNano.readMessage(this.shakeActivity);
            }
        }
    }

    public static SCLiveRevenueActivityInfoSignal parseFrom(byte[] bArr) {
        return (SCLiveRevenueActivityInfoSignal) MessageNano.mergeFrom(new SCLiveRevenueActivityInfoSignal(), bArr);
    }

    public static SCLiveRevenueActivityInfoSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRevenueActivityInfoSignal().mergeFrom(codedInputByteBufferNano);
    }
}
