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
public interface LiveVoiceCommentConfigProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface VoiceCommentCloseType {
        public static final int AUTHOR_CLOSE_SWITCH = 1;
        public static final int AUTHOR_OPEN_VOICE_PARTY_LIVE = 2;
        public static final int UNKNOWN_VOICE_COMMENT_CLOSE_TYPE = 0;
    }

    public static final class SCVoiceCommentConfig extends MessageNano {
        private static volatile SCVoiceCommentConfig[] _emptyArray;
        public boolean bgmOpened;
        public int closeType;
        public boolean enableVoiceComment;
        public long time;

        public static SCVoiceCommentConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCVoiceCommentConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCVoiceCommentConfig() {
            clear();
        }

        public final SCVoiceCommentConfig clear() {
            this.enableVoiceComment = false;
            this.bgmOpened = false;
            this.time = 0L;
            this.closeType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.enableVoiceComment;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            boolean z2 = this.bgmOpened;
            if (z2) {
                codedOutputByteBufferNano.writeBool(2, z2);
            }
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i = this.closeType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.enableVoiceComment;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            boolean z2 = this.bgmOpened;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
            }
            long j = this.time;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i = this.closeType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCVoiceCommentConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.enableVoiceComment = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.bgmOpened = codedInputByteBufferNano.readBool();
                } else if (tag == 24) {
                    this.time = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.closeType = int32;
                    }
                }
            }
        }

        public static SCVoiceCommentConfig parseFrom(byte[] bArr) {
            return (SCVoiceCommentConfig) MessageNano.mergeFrom(new SCVoiceCommentConfig(), bArr);
        }

        public static SCVoiceCommentConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCVoiceCommentConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
