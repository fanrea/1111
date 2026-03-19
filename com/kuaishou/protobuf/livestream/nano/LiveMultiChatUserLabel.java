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
public final class LiveMultiChatUserLabel extends MessageNano {
    private static volatile LiveMultiChatUserLabel[] _emptyArray;
    public String backgroundColor;
    public String editText;
    public String label;
    public int labelType;
    public String text;
    public String textColor;
    public long userId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelType {
        public static final int TEXT = 1;
        public static final int UNKNOWN = 0;
    }

    public static LiveMultiChatUserLabel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiChatUserLabel[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiChatUserLabel() {
        clear();
    }

    public final LiveMultiChatUserLabel clear() {
        this.userId = 0L;
        this.labelType = 0;
        this.text = "";
        this.backgroundColor = "";
        this.textColor = "";
        this.editText = "";
        this.label = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.labelType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.text);
        }
        if (!this.backgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.backgroundColor);
        }
        if (!this.textColor.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.textColor);
        }
        if (!this.editText.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.editText);
        }
        if (!this.label.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.label);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.labelType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.text);
        }
        if (!this.backgroundColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.backgroundColor);
        }
        if (!this.textColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.textColor);
        }
        if (!this.editText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.editText);
        }
        return !this.label.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.label) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiChatUserLabel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.labelType = int32;
                }
            } else if (tag == 26) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.backgroundColor = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.textColor = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.editText = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.label = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveMultiChatUserLabel parseFrom(byte[] bArr) {
        return (LiveMultiChatUserLabel) MessageNano.mergeFrom(new LiveMultiChatUserLabel(), bArr);
    }

    public static LiveMultiChatUserLabel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiChatUserLabel().mergeFrom(codedInputByteBufferNano);
    }
}
