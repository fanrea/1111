package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Reward extends MessageNano {
    private static volatile Reward[] _emptyArray;
    public CdnNodeView[] backgroundImageUrl;
    public CdnNodeView[] rewardImageUrl;
    public String subTitle;
    public String title;

    public static Reward[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Reward[0];
                }
            }
        }
        return _emptyArray;
    }

    public Reward() {
        clear();
    }

    public final Reward clear() {
        this.backgroundImageUrl = CdnNodeView.emptyArray();
        this.rewardImageUrl = CdnNodeView.emptyArray();
        this.title = "";
        this.subTitle = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        CdnNodeView[] cdnNodeViewArr = this.backgroundImageUrl;
        int i = 0;
        if (cdnNodeViewArr != null && cdnNodeViewArr.length > 0) {
            int i2 = 0;
            while (true) {
                CdnNodeView[] cdnNodeViewArr2 = this.backgroundImageUrl;
                if (i2 >= cdnNodeViewArr2.length) {
                    break;
                }
                CdnNodeView cdnNodeView = cdnNodeViewArr2[i2];
                if (cdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(1, cdnNodeView);
                }
                i2++;
            }
        }
        CdnNodeView[] cdnNodeViewArr3 = this.rewardImageUrl;
        if (cdnNodeViewArr3 != null && cdnNodeViewArr3.length > 0) {
            while (true) {
                CdnNodeView[] cdnNodeViewArr4 = this.rewardImageUrl;
                if (i >= cdnNodeViewArr4.length) {
                    break;
                }
                CdnNodeView cdnNodeView2 = cdnNodeViewArr4[i];
                if (cdnNodeView2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, cdnNodeView2);
                }
                i++;
            }
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.title);
        }
        if (!this.subTitle.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.subTitle);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        CdnNodeView[] cdnNodeViewArr = this.backgroundImageUrl;
        int i = 0;
        if (cdnNodeViewArr != null && cdnNodeViewArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                CdnNodeView[] cdnNodeViewArr2 = this.backgroundImageUrl;
                if (i2 >= cdnNodeViewArr2.length) {
                    break;
                }
                CdnNodeView cdnNodeView = cdnNodeViewArr2[i2];
                if (cdnNodeView != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, cdnNodeView);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        CdnNodeView[] cdnNodeViewArr3 = this.rewardImageUrl;
        if (cdnNodeViewArr3 != null && cdnNodeViewArr3.length > 0) {
            while (true) {
                CdnNodeView[] cdnNodeViewArr4 = this.rewardImageUrl;
                if (i >= cdnNodeViewArr4.length) {
                    break;
                }
                CdnNodeView cdnNodeView2 = cdnNodeViewArr4[i];
                if (cdnNodeView2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cdnNodeView2);
                }
                i++;
            }
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.title);
        }
        return !this.subTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.subTitle) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Reward mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                CdnNodeView[] cdnNodeViewArr = this.backgroundImageUrl;
                int length = cdnNodeViewArr == null ? 0 : cdnNodeViewArr.length;
                CdnNodeView[] cdnNodeViewArr2 = new CdnNodeView[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.backgroundImageUrl, 0, cdnNodeViewArr2, 0, length);
                }
                while (length < cdnNodeViewArr2.length - 1) {
                    cdnNodeViewArr2[length] = new CdnNodeView();
                    codedInputByteBufferNano.readMessage(cdnNodeViewArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                cdnNodeViewArr2[length] = new CdnNodeView();
                codedInputByteBufferNano.readMessage(cdnNodeViewArr2[length]);
                this.backgroundImageUrl = cdnNodeViewArr2;
            } else if (tag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                CdnNodeView[] cdnNodeViewArr3 = this.rewardImageUrl;
                int length2 = cdnNodeViewArr3 == null ? 0 : cdnNodeViewArr3.length;
                CdnNodeView[] cdnNodeViewArr4 = new CdnNodeView[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.rewardImageUrl, 0, cdnNodeViewArr4, 0, length2);
                }
                while (length2 < cdnNodeViewArr4.length - 1) {
                    cdnNodeViewArr4[length2] = new CdnNodeView();
                    codedInputByteBufferNano.readMessage(cdnNodeViewArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                cdnNodeViewArr4[length2] = new CdnNodeView();
                codedInputByteBufferNano.readMessage(cdnNodeViewArr4[length2]);
                this.rewardImageUrl = cdnNodeViewArr4;
            } else if (tag == 26) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.subTitle = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Reward parseFrom(byte[] bArr) {
        return (Reward) MessageNano.mergeFrom(new Reward(), bArr);
    }

    public static Reward parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Reward().mergeFrom(codedInputByteBufferNano);
    }
}
