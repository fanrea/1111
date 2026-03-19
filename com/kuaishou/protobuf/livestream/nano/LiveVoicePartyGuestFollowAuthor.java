package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveVoicePartyGuestFollowAuthor {

    public static final class SCLiveVoicePartyGuestFollowAuthor extends MessageNano {
        private static volatile SCLiveVoicePartyGuestFollowAuthor[] _emptyArray;
        public long fromUserId;
        public long serverTimestamp;
        public long toUserId;

        public static SCLiveVoicePartyGuestFollowAuthor[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveVoicePartyGuestFollowAuthor[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveVoicePartyGuestFollowAuthor() {
            clear();
        }

        public final SCLiveVoicePartyGuestFollowAuthor clear() {
            this.fromUserId = 0L;
            this.toUserId = 0L;
            this.serverTimestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.fromUserId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.toUserId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.serverTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.fromUserId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.toUserId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.serverTimestamp;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveVoicePartyGuestFollowAuthor mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.fromUserId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.toUserId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverTimestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveVoicePartyGuestFollowAuthor parseFrom(byte[] bArr) {
            return (SCLiveVoicePartyGuestFollowAuthor) MessageNano.mergeFrom(new SCLiveVoicePartyGuestFollowAuthor(), bArr);
        }

        public static SCLiveVoicePartyGuestFollowAuthor parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveVoicePartyGuestFollowAuthor().mergeFrom(codedInputByteBufferNano);
        }
    }
}
