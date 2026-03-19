package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TopBannerNoticeFeed extends MessageNano {
    private static volatile TopBannerNoticeFeed[] _emptyArray;
    public String backgroundColor;
    public String backgroundColorBegin;
    public String backgroundColorEnd;
    public String textColor;
    public String textContent;
    public int type;

    public static TopBannerNoticeFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TopBannerNoticeFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public TopBannerNoticeFeed() {
        clear();
    }

    public final TopBannerNoticeFeed clear() {
        this.textColor = "";
        this.textContent = "";
        this.type = 0;
        this.backgroundColor = "";
        this.backgroundColorBegin = "";
        this.backgroundColorEnd = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.textColor.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.textColor);
        }
        if (!this.textContent.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.textContent);
        }
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!this.backgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.backgroundColor);
        }
        if (!this.backgroundColorBegin.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.backgroundColorBegin);
        }
        if (!this.backgroundColorEnd.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.backgroundColorEnd);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.textColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textColor);
        }
        if (!this.textContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textContent);
        }
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        if (!this.backgroundColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.backgroundColor);
        }
        if (!this.backgroundColorBegin.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.backgroundColorBegin);
        }
        return !this.backgroundColorEnd.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.backgroundColorEnd) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TopBannerNoticeFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.textColor = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.textContent = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (tag == 34) {
                this.backgroundColor = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.backgroundColorBegin = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.backgroundColorEnd = codedInputByteBufferNano.readString();
            }
        }
    }

    public static TopBannerNoticeFeed parseFrom(byte[] bArr) {
        return (TopBannerNoticeFeed) MessageNano.mergeFrom(new TopBannerNoticeFeed(), bArr);
    }

    public static TopBannerNoticeFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TopBannerNoticeFeed().mergeFrom(codedInputByteBufferNano);
    }
}
