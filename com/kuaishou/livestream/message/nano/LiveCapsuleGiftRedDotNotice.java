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
public final class LiveCapsuleGiftRedDotNotice extends MessageNano {
    private static volatile LiveCapsuleGiftRedDotNotice[] _emptyArray;
    public int noticeType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveCapsuleGiftRedDotNoticeType {
        public static final int RED_DOT_CLEAR = 2;
        public static final int RED_DOT_SHOW = 1;
        public static final int UNKNOWN_RED_DOT_OP = 0;
    }

    public static LiveCapsuleGiftRedDotNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCapsuleGiftRedDotNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCapsuleGiftRedDotNotice() {
        clear();
    }

    public final LiveCapsuleGiftRedDotNotice clear() {
        this.noticeType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.noticeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.noticeType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCapsuleGiftRedDotNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.noticeType = int32;
                }
            }
        }
    }

    public static LiveCapsuleGiftRedDotNotice parseFrom(byte[] bArr) {
        return (LiveCapsuleGiftRedDotNotice) MessageNano.mergeFrom(new LiveCapsuleGiftRedDotNotice(), bArr);
    }

    public static LiveCapsuleGiftRedDotNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCapsuleGiftRedDotNotice().mergeFrom(codedInputByteBufferNano);
    }
}
