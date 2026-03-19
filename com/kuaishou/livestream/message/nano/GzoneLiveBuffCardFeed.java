package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GzoneLiveBuffCardFeed extends MessageNano {
    private static volatile GzoneLiveBuffCardFeed[] _emptyArray;
    public String color;
    public String leftIconUrl;
    public String leftText;
    public String rightIconUrl;
    public String rightText;

    public static GzoneLiveBuffCardFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneLiveBuffCardFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneLiveBuffCardFeed() {
        clear();
    }

    public final GzoneLiveBuffCardFeed clear() {
        this.leftIconUrl = "";
        this.rightIconUrl = "";
        this.leftText = "";
        this.rightText = "";
        this.color = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.leftIconUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.leftIconUrl);
        }
        if (!this.rightIconUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.rightIconUrl);
        }
        if (!this.leftText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.leftText);
        }
        if (!this.rightText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.rightText);
        }
        if (!this.color.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.color);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.leftIconUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.leftIconUrl);
        }
        if (!this.rightIconUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.rightIconUrl);
        }
        if (!this.leftText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.leftText);
        }
        if (!this.rightText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.rightText);
        }
        return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.color) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneLiveBuffCardFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.leftIconUrl = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.rightIconUrl = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.leftText = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.rightText = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.color = codedInputByteBufferNano.readString();
            }
        }
    }

    public static GzoneLiveBuffCardFeed parseFrom(byte[] bArr) {
        return (GzoneLiveBuffCardFeed) MessageNano.mergeFrom(new GzoneLiveBuffCardFeed(), bArr);
    }

    public static GzoneLiveBuffCardFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneLiveBuffCardFeed().mergeFrom(codedInputByteBufferNano);
    }
}
