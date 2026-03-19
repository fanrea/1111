package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PkBountyActivityResultInfo extends MessageNano {
    private static volatile PkBountyActivityResultInfo[] _emptyArray;
    public String bountyChangeText;
    public String leftBottomText;
    public String[] middleBottomTextArray;
    public long originBounty;
    public String pkId;
    public String rightBottomText;
    public long settleBounty;
    public String textAfterAnimation;
    public String textBeforeAnimation;
    public long totalBounty;
    public int winLossStatus;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PkBountyActivityWinLossStatus {
        public static final int LOSS = 2;
        public static final int TIE = 3;
        public static final int UNKNOWN = 0;
        public static final int WIN = 1;
    }

    public static PkBountyActivityResultInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkBountyActivityResultInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public PkBountyActivityResultInfo() {
        clear();
    }

    public final PkBountyActivityResultInfo clear() {
        this.pkId = "";
        this.winLossStatus = 0;
        this.textBeforeAnimation = "";
        this.originBounty = 0L;
        this.settleBounty = 0L;
        this.totalBounty = 0L;
        this.leftBottomText = "";
        this.rightBottomText = "";
        this.middleBottomTextArray = WireFormatNano.EMPTY_STRING_ARRAY;
        this.textAfterAnimation = "";
        this.bountyChangeText = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        int i = this.winLossStatus;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.textBeforeAnimation.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.textBeforeAnimation);
        }
        long j = this.originBounty;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.settleBounty;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.totalBounty;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.leftBottomText.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.leftBottomText);
        }
        if (!this.rightBottomText.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.rightBottomText);
        }
        String[] strArr = this.middleBottomTextArray;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.middleBottomTextArray;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(9, str);
                }
                i2++;
            }
        }
        if (!this.textAfterAnimation.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.textAfterAnimation);
        }
        if (!this.bountyChangeText.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.bountyChangeText);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        int i = this.winLossStatus;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.textBeforeAnimation.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.textBeforeAnimation);
        }
        long j = this.originBounty;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.settleBounty;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.totalBounty;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        if (!this.leftBottomText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.leftBottomText);
        }
        if (!this.rightBottomText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.rightBottomText);
        }
        String[] strArr = this.middleBottomTextArray;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.middleBottomTextArray;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
        }
        if (!this.textAfterAnimation.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.textAfterAnimation);
        }
        return !this.bountyChangeText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.bountyChangeText) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final PkBountyActivityResultInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.pkId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.winLossStatus = int32;
                        break;
                    }
                case 26:
                    this.textBeforeAnimation = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.originBounty = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.settleBounty = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.totalBounty = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    this.leftBottomText = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.rightBottomText = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    String[] strArr = this.middleBottomTextArray;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.middleBottomTextArray, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.middleBottomTextArray = strArr2;
                    break;
                case 82:
                    this.textAfterAnimation = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.bountyChangeText = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static PkBountyActivityResultInfo parseFrom(byte[] bArr) {
        return (PkBountyActivityResultInfo) MessageNano.mergeFrom(new PkBountyActivityResultInfo(), bArr);
    }

    public static PkBountyActivityResultInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new PkBountyActivityResultInfo().mergeFrom(codedInputByteBufferNano);
    }
}
