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
public final class SCLiveLocalLifeExplainCardPromotionStageInfo extends MessageNano {
    private static volatile SCLiveLocalLifeExplainCardPromotionStageInfo[] _emptyArray;
    public long promotionStageTime;
    public int promotionStatus;
    public String rightText;
    public String text;
    public int topLeftTextType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TLTextType {
        public static final int DEFAULT = 0;
        public static final int TIMER = 1;
    }

    public static SCLiveLocalLifeExplainCardPromotionStageInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveLocalLifeExplainCardPromotionStageInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveLocalLifeExplainCardPromotionStageInfo() {
        clear();
    }

    public final SCLiveLocalLifeExplainCardPromotionStageInfo clear() {
        this.topLeftTextType = 0;
        this.promotionStageTime = 0L;
        this.text = "";
        this.rightText = "";
        this.promotionStatus = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.topLeftTextType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.promotionStageTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.text);
        }
        if (!this.rightText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.rightText);
        }
        int i2 = this.promotionStatus;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.topLeftTextType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.promotionStageTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.text);
        }
        if (!this.rightText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.rightText);
        }
        int i2 = this.promotionStatus;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveLocalLifeExplainCardPromotionStageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.topLeftTextType = int32;
                }
            } else if (tag == 16) {
                this.promotionStageTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.rightText = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3) {
                    this.promotionStatus = int322;
                }
            }
        }
    }

    public static SCLiveLocalLifeExplainCardPromotionStageInfo parseFrom(byte[] bArr) {
        return (SCLiveLocalLifeExplainCardPromotionStageInfo) MessageNano.mergeFrom(new SCLiveLocalLifeExplainCardPromotionStageInfo(), bArr);
    }

    public static SCLiveLocalLifeExplainCardPromotionStageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveLocalLifeExplainCardPromotionStageInfo().mergeFrom(codedInputByteBufferNano);
    }
}
