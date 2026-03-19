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
public final class RainbowCommentFeed extends MessageNano {
    private static volatile RainbowCommentFeed[] _emptyArray;
    public String comment;
    public long commentId;
    public String hintText;
    public long randomTime;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RainbowCommentType {
        public static final int NORMAL = 1;
        public static final int RANDOM = 2;
        public static final int UNKNOWN = 0;
    }

    public static RainbowCommentFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RainbowCommentFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public RainbowCommentFeed() {
        clear();
    }

    public final RainbowCommentFeed clear() {
        this.type = 0;
        this.commentId = 0L;
        this.comment = "";
        this.hintText = "";
        this.randomTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.commentId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.comment.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.comment);
        }
        if (!this.hintText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.hintText);
        }
        long j2 = this.randomTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.commentId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.comment.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.comment);
        }
        if (!this.hintText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.hintText);
        }
        long j2 = this.randomTime;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final RainbowCommentFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.type = int32;
                }
            } else if (tag == 16) {
                this.commentId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.comment = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.hintText = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.randomTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static RainbowCommentFeed parseFrom(byte[] bArr) {
        return (RainbowCommentFeed) MessageNano.mergeFrom(new RainbowCommentFeed(), bArr);
    }

    public static RainbowCommentFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new RainbowCommentFeed().mergeFrom(codedInputByteBufferNano);
    }
}
