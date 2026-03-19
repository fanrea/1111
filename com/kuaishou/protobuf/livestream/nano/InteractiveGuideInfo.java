package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveGuideInfo extends MessageNano {
    private static volatile InteractiveGuideInfo[] _emptyArray;
    public InteractiveGuideButton button;
    public String[] subTitles;
    public String title;

    public static InteractiveGuideInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveGuideInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveGuideInfo() {
        clear();
    }

    public final InteractiveGuideInfo clear() {
        this.title = "";
        this.subTitles = WireFormatNano.EMPTY_STRING_ARRAY;
        this.button = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        String[] strArr = this.subTitles;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.subTitles;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i++;
            }
        }
        InteractiveGuideButton interactiveGuideButton = this.button;
        if (interactiveGuideButton != null) {
            codedOutputByteBufferNano.writeMessage(3, interactiveGuideButton);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        String[] strArr = this.subTitles;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            int iComputeStringSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.subTitles;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
        }
        InteractiveGuideButton interactiveGuideButton = this.button;
        return interactiveGuideButton != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, interactiveGuideButton) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveGuideInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.subTitles;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.subTitles, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.subTitles = strArr2;
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.button == null) {
                    this.button = new InteractiveGuideButton();
                }
                codedInputByteBufferNano.readMessage(this.button);
            }
        }
    }

    public static InteractiveGuideInfo parseFrom(byte[] bArr) {
        return (InteractiveGuideInfo) MessageNano.mergeFrom(new InteractiveGuideInfo(), bArr);
    }

    public static InteractiveGuideInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveGuideInfo().mergeFrom(codedInputByteBufferNano);
    }
}
