package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRevenueRechargeOptimizationProto {

    public static final class SCLiveRevenueGiftPanelRechargeEntrance extends MessageNano {
        private static volatile SCLiveRevenueGiftPanelRechargeEntrance[] _emptyArray;
        public String bizId;
        public long bizPriority;
        public String logParams;
        public long serverTimestamp;
        public long showDeadline;
        public String text;
        public String textColor;

        public static SCLiveRevenueGiftPanelRechargeEntrance[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRevenueGiftPanelRechargeEntrance[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRevenueGiftPanelRechargeEntrance() {
            clear();
        }

        public final SCLiveRevenueGiftPanelRechargeEntrance clear() {
            this.bizId = "";
            this.bizPriority = 0L;
            this.text = "";
            this.textColor = "";
            this.showDeadline = 0L;
            this.serverTimestamp = 0L;
            this.logParams = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bizId);
            }
            long j = this.bizPriority;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.text);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.textColor);
            }
            long j2 = this.showDeadline;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.serverTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            if (!this.logParams.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.logParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizId);
            }
            long j = this.bizPriority;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.text);
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.textColor);
            }
            long j2 = this.showDeadline;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.serverTimestamp;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            return !this.logParams.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.logParams) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRevenueGiftPanelRechargeEntrance mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.bizPriority = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.textColor = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    this.showDeadline = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    this.serverTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.logParams = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveRevenueGiftPanelRechargeEntrance parseFrom(byte[] bArr) {
            return (SCLiveRevenueGiftPanelRechargeEntrance) MessageNano.mergeFrom(new SCLiveRevenueGiftPanelRechargeEntrance(), bArr);
        }

        public static SCLiveRevenueGiftPanelRechargeEntrance parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRevenueGiftPanelRechargeEntrance().mergeFrom(codedInputByteBufferNano);
        }
    }
}
