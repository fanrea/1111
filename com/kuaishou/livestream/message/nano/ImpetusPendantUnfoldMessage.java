package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ImpetusPendantUnfoldMessage extends MessageNano {
    private static volatile ImpetusPendantUnfoldMessage[] _emptyArray;
    public ImpetusPendantContentWithStyle[] countDownText;

    public static ImpetusPendantUnfoldMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ImpetusPendantUnfoldMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public ImpetusPendantUnfoldMessage() {
        clear();
    }

    public final ImpetusPendantUnfoldMessage clear() {
        this.countDownText = ImpetusPendantContentWithStyle.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr = this.countDownText;
        if (impetusPendantContentWithStyleArr != null && impetusPendantContentWithStyleArr.length > 0) {
            int i = 0;
            while (true) {
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr2 = this.countDownText;
                if (i >= impetusPendantContentWithStyleArr2.length) {
                    break;
                }
                ImpetusPendantContentWithStyle impetusPendantContentWithStyle = impetusPendantContentWithStyleArr2[i];
                if (impetusPendantContentWithStyle != null) {
                    codedOutputByteBufferNano.writeMessage(1, impetusPendantContentWithStyle);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr = this.countDownText;
        if (impetusPendantContentWithStyleArr != null && impetusPendantContentWithStyleArr.length > 0) {
            int i = 0;
            while (true) {
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr2 = this.countDownText;
                if (i >= impetusPendantContentWithStyleArr2.length) {
                    break;
                }
                ImpetusPendantContentWithStyle impetusPendantContentWithStyle = impetusPendantContentWithStyleArr2[i];
                if (impetusPendantContentWithStyle != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, impetusPendantContentWithStyle);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ImpetusPendantUnfoldMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr = this.countDownText;
                int length = impetusPendantContentWithStyleArr == null ? 0 : impetusPendantContentWithStyleArr.length;
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr2 = new ImpetusPendantContentWithStyle[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.countDownText, 0, impetusPendantContentWithStyleArr2, 0, length);
                }
                while (length < impetusPendantContentWithStyleArr2.length - 1) {
                    impetusPendantContentWithStyleArr2[length] = new ImpetusPendantContentWithStyle();
                    codedInputByteBufferNano.readMessage(impetusPendantContentWithStyleArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                impetusPendantContentWithStyleArr2[length] = new ImpetusPendantContentWithStyle();
                codedInputByteBufferNano.readMessage(impetusPendantContentWithStyleArr2[length]);
                this.countDownText = impetusPendantContentWithStyleArr2;
            }
        }
    }

    public static ImpetusPendantUnfoldMessage parseFrom(byte[] bArr) {
        return (ImpetusPendantUnfoldMessage) MessageNano.mergeFrom(new ImpetusPendantUnfoldMessage(), bArr);
    }

    public static ImpetusPendantUnfoldMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ImpetusPendantUnfoldMessage().mergeFrom(codedInputByteBufferNano);
    }
}
