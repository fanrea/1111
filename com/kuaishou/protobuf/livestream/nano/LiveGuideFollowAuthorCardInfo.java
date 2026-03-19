package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveGuideFollowAuthorCardInfo {

    public static final class SCLiveGuideFollowAuthorCardInfo extends MessageNano {
        private static volatile SCLiveGuideFollowAuthorCardInfo[] _emptyArray;
        public String bizId;
        public int bizType;
        public long randomDelayMillis;
        public int source;
        public String toFollowUserId;

        public static SCLiveGuideFollowAuthorCardInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveGuideFollowAuthorCardInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveGuideFollowAuthorCardInfo() {
            clear();
        }

        public final SCLiveGuideFollowAuthorCardInfo clear() {
            this.toFollowUserId = "";
            this.source = 0;
            this.randomDelayMillis = 0L;
            this.bizType = 0;
            this.bizId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.toFollowUserId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.toFollowUserId);
            }
            int i = this.source;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j = this.randomDelayMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bizId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.toFollowUserId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.toFollowUserId);
            }
            int i = this.source;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j = this.randomDelayMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            return !this.bizId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveGuideFollowAuthorCardInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.toFollowUserId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.source = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.randomDelayMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.bizType = codedInputByteBufferNano.readUInt32();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bizId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveGuideFollowAuthorCardInfo parseFrom(byte[] bArr) {
            return (SCLiveGuideFollowAuthorCardInfo) MessageNano.mergeFrom(new SCLiveGuideFollowAuthorCardInfo(), bArr);
        }

        public static SCLiveGuideFollowAuthorCardInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveGuideFollowAuthorCardInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
