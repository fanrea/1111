package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TargetGiftTabInfo extends MessageNano {
    private static volatile TargetGiftTabInfo[] _emptyArray;
    public String liteTargetGiftTab;
    public String targetGiftTab;

    public static TargetGiftTabInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TargetGiftTabInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public TargetGiftTabInfo() {
        clear();
    }

    public final TargetGiftTabInfo clear() {
        this.targetGiftTab = "";
        this.liteTargetGiftTab = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.targetGiftTab.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.targetGiftTab);
        }
        if (!this.liteTargetGiftTab.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liteTargetGiftTab);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.targetGiftTab.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.targetGiftTab);
        }
        return !this.liteTargetGiftTab.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.liteTargetGiftTab) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TargetGiftTabInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.targetGiftTab = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.liteTargetGiftTab = codedInputByteBufferNano.readString();
            }
        }
    }

    public static TargetGiftTabInfo parseFrom(byte[] bArr) {
        return (TargetGiftTabInfo) MessageNano.mergeFrom(new TargetGiftTabInfo(), bArr);
    }

    public static TargetGiftTabInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TargetGiftTabInfo().mergeFrom(codedInputByteBufferNano);
    }
}
