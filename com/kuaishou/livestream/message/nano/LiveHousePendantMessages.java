package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveHousePendantMessages {

    public static final class SCLiveHousePendant extends MessageNano {
        private static volatile SCLiveHousePendant[] _emptyArray;
        public String actionUrl;
        public String backgroundUrl;
        public boolean enableShow;
        public long endTimeMs;
        public String refreshBackGroundUrl;
        public long serverTime;
        public String title;

        public static SCLiveHousePendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveHousePendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveHousePendant() {
            clear();
        }

        public final SCLiveHousePendant clear() {
            this.title = "";
            this.backgroundUrl = "";
            this.enableShow = false;
            this.endTimeMs = 0L;
            this.actionUrl = "";
            this.serverTime = 0L;
            this.refreshBackGroundUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.title);
            }
            if (!this.backgroundUrl.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.backgroundUrl);
            }
            boolean z = this.enableShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            long j = this.endTimeMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.actionUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.actionUrl);
            }
            long j2 = this.serverTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            if (!this.refreshBackGroundUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.refreshBackGroundUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
            }
            if (!this.backgroundUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.backgroundUrl);
            }
            boolean z = this.enableShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            long j = this.endTimeMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.actionUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.actionUrl);
            }
            long j2 = this.serverTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            return !this.refreshBackGroundUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.refreshBackGroundUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveHousePendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.backgroundUrl = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.enableShow = codedInputByteBufferNano.readBool();
                } else if (tag == 32) {
                    this.endTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.actionUrl = codedInputByteBufferNano.readString();
                } else if (tag == 48) {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.refreshBackGroundUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveHousePendant parseFrom(byte[] bArr) {
            return (SCLiveHousePendant) MessageNano.mergeFrom(new SCLiveHousePendant(), bArr);
        }

        public static SCLiveHousePendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveHousePendant().mergeFrom(codedInputByteBufferNano);
        }
    }
}
