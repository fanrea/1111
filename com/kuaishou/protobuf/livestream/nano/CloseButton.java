package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CloseButton extends MessageNano {
    private static volatile CloseButton[] _emptyArray;
    public String buttonBackGroundColor;
    public String buttonJumpUrl;
    public String buttonText;
    public String buttonTextColor;
    public CdnNodeView[] buttonUrl;

    public static CloseButton[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CloseButton[0];
                }
            }
        }
        return _emptyArray;
    }

    public CloseButton() {
        clear();
    }

    public final CloseButton clear() {
        this.buttonText = "";
        this.buttonTextColor = "";
        this.buttonUrl = CdnNodeView.emptyArray();
        this.buttonJumpUrl = "";
        this.buttonBackGroundColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.buttonText);
        }
        if (!this.buttonTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.buttonTextColor);
        }
        CdnNodeView[] cdnNodeViewArr = this.buttonUrl;
        if (cdnNodeViewArr != null && cdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                CdnNodeView[] cdnNodeViewArr2 = this.buttonUrl;
                if (i >= cdnNodeViewArr2.length) {
                    break;
                }
                CdnNodeView cdnNodeView = cdnNodeViewArr2[i];
                if (cdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(3, cdnNodeView);
                }
                i++;
            }
        }
        if (!this.buttonJumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.buttonJumpUrl);
        }
        if (!this.buttonBackGroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.buttonBackGroundColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.buttonText);
        }
        if (!this.buttonTextColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.buttonTextColor);
        }
        CdnNodeView[] cdnNodeViewArr = this.buttonUrl;
        if (cdnNodeViewArr != null && cdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                CdnNodeView[] cdnNodeViewArr2 = this.buttonUrl;
                if (i >= cdnNodeViewArr2.length) {
                    break;
                }
                CdnNodeView cdnNodeView = cdnNodeViewArr2[i];
                if (cdnNodeView != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cdnNodeView);
                }
                i++;
            }
        }
        if (!this.buttonJumpUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonJumpUrl);
        }
        return !this.buttonBackGroundColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.buttonBackGroundColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final CloseButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.buttonText = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.buttonTextColor = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                CdnNodeView[] cdnNodeViewArr = this.buttonUrl;
                int length = cdnNodeViewArr == null ? 0 : cdnNodeViewArr.length;
                CdnNodeView[] cdnNodeViewArr2 = new CdnNodeView[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.buttonUrl, 0, cdnNodeViewArr2, 0, length);
                }
                while (length < cdnNodeViewArr2.length - 1) {
                    cdnNodeViewArr2[length] = new CdnNodeView();
                    codedInputByteBufferNano.readMessage(cdnNodeViewArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                cdnNodeViewArr2[length] = new CdnNodeView();
                codedInputByteBufferNano.readMessage(cdnNodeViewArr2[length]);
                this.buttonUrl = cdnNodeViewArr2;
            } else if (tag == 34) {
                this.buttonJumpUrl = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.buttonBackGroundColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static CloseButton parseFrom(byte[] bArr) {
        return (CloseButton) MessageNano.mergeFrom(new CloseButton(), bArr);
    }

    public static CloseButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new CloseButton().mergeFrom(codedInputByteBufferNano);
    }
}
