package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGuideNotice extends MessageNano {
    private static volatile LiveGuideNotice[] _emptyArray;
    public int bottomBarFeatureType;
    public String buttonKwaiLink;
    public String buttonText;
    public int commentUIType;
    public String desc;
    public int displayDurationMs;
    public int guideNoticeType;

    public static LiveGuideNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGuideNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGuideNotice() {
        clear();
    }

    public final LiveGuideNotice clear() {
        this.guideNoticeType = 0;
        this.displayDurationMs = 0;
        this.commentUIType = 0;
        this.desc = "";
        this.buttonText = "";
        this.buttonKwaiLink = "";
        this.bottomBarFeatureType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.guideNoticeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.displayDurationMs;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        int i3 = this.commentUIType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.desc);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.buttonText);
        }
        if (!this.buttonKwaiLink.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.buttonKwaiLink);
        }
        int i4 = this.bottomBarFeatureType;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i4);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.guideNoticeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.displayDurationMs;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        int i3 = this.commentUIType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.desc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.desc);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.buttonText);
        }
        if (!this.buttonKwaiLink.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.buttonKwaiLink);
        }
        int i4 = this.bottomBarFeatureType;
        return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGuideNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.guideNoticeType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.displayDurationMs = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                this.commentUIType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 34) {
                this.desc = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.buttonText = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.buttonKwaiLink = codedInputByteBufferNano.readString();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bottomBarFeatureType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveGuideNotice parseFrom(byte[] bArr) {
        return (LiveGuideNotice) MessageNano.mergeFrom(new LiveGuideNotice(), bArr);
    }

    public static LiveGuideNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGuideNotice().mergeFrom(codedInputByteBufferNano);
    }
}
