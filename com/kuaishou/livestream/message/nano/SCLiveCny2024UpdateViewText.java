package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024UpdateViewText extends MessageNano {
    private static volatile SCLiveCny2024UpdateViewText[] _emptyArray;
    public String bizType;
    public String color;
    public long displayDurationMillis;
    public String redirectUrl;
    public String text;

    public static SCLiveCny2024UpdateViewText[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024UpdateViewText[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024UpdateViewText() {
        clear();
    }

    public final SCLiveCny2024UpdateViewText clear() {
        this.text = "";
        this.displayDurationMillis = 0L;
        this.redirectUrl = "";
        this.color = "";
        this.bizType = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        long j = this.displayDurationMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        if (!this.redirectUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.redirectUrl);
        }
        if (!this.color.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.color);
        }
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.bizType);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        long j = this.displayDurationMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        if (!this.redirectUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.redirectUrl);
        }
        if (!this.color.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.color);
        }
        return !this.bizType.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizType) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024UpdateViewText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.displayDurationMillis = codedInputByteBufferNano.readInt64();
            } else if (tag == 26) {
                this.redirectUrl = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.color = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizType = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveCny2024UpdateViewText parseFrom(byte[] bArr) {
        return (SCLiveCny2024UpdateViewText) MessageNano.mergeFrom(new SCLiveCny2024UpdateViewText(), bArr);
    }

    public static SCLiveCny2024UpdateViewText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024UpdateViewText().mergeFrom(codedInputByteBufferNano);
    }
}
