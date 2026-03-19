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
public final class LiveServerSignalBlockConfigMessage extends MessageNano {
    private static volatile LiveServerSignalBlockConfigMessage[] _emptyArray;
    public String[] blockBizIds;
    public int scene;
    public int signalBlockType;
    public String[] whiteBizIds;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SignalBlockType {
        public static final int BLOCK_ALL_BIZ = 1;
        public static final int UNKNOWN = 0;
        public static final int USE_BLOCK_BIZ = 2;
        public static final int USE_WHITE_BIZ = 3;
    }

    public static LiveServerSignalBlockConfigMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveServerSignalBlockConfigMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveServerSignalBlockConfigMessage() {
        clear();
    }

    public final LiveServerSignalBlockConfigMessage clear() {
        this.scene = 0;
        this.signalBlockType = 0;
        this.blockBizIds = WireFormatNano.EMPTY_STRING_ARRAY;
        this.whiteBizIds = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.scene;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.signalBlockType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        String[] strArr = this.blockBizIds;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.blockBizIds;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i4++;
            }
        }
        String[] strArr3 = this.whiteBizIds;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.whiteBizIds;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.scene;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.signalBlockType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        String[] strArr = this.blockBizIds;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int iComputeStringSizeNoTag = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.blockBizIds;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    i5++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i5 * 1);
        }
        String[] strArr3 = this.whiteBizIds;
        if (strArr3 == null || strArr3.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag2 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr4 = this.whiteBizIds;
            if (i3 >= strArr4.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag2 + (i6 * 1);
            }
            String str2 = strArr4[i3];
            if (str2 != null) {
                i6++;
                iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
            }
            i3++;
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveServerSignalBlockConfigMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                    this.scene = int32;
                }
            } else if (tag == 16) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3) {
                    this.signalBlockType = int322;
                }
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                String[] strArr = this.blockBizIds;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.blockBizIds, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.blockBizIds = strArr2;
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                String[] strArr3 = this.whiteBizIds;
                int length2 = strArr3 == null ? 0 : strArr3.length;
                String[] strArr4 = new String[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.whiteBizIds, 0, strArr4, 0, length2);
                }
                while (length2 < strArr4.length - 1) {
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr4[length2] = codedInputByteBufferNano.readString();
                this.whiteBizIds = strArr4;
            }
        }
    }

    public static LiveServerSignalBlockConfigMessage parseFrom(byte[] bArr) {
        return (LiveServerSignalBlockConfigMessage) MessageNano.mergeFrom(new LiveServerSignalBlockConfigMessage(), bArr);
    }

    public static LiveServerSignalBlockConfigMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveServerSignalBlockConfigMessage().mergeFrom(codedInputByteBufferNano);
    }
}
