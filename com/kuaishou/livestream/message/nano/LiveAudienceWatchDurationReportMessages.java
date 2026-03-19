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
public interface LiveAudienceWatchDurationReportMessages {

    public static final class SCLiveAudienceWatchDurationReport extends MessageNano {
        private static volatile SCLiveAudienceWatchDurationReport[] _emptyArray;
        public int reportType;
        public boolean supportBackGroundTime;
        public long timerIntervalMs;
        public long timerMaxDurationMs;
        public String watchDurationBiz;
        public String watchDurationToken;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AudienceWatchReportBizToken {
            public static final int LIVE_APS_REPORT_BIZ = 1;
            public static final int LIVE_APS_REPORT_TOKEN = 2;
            public static final int UNKNOWN_BIZ_TOKEN = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface AudienceWatchReportType {
            public static final int END = 2;
            public static final int START = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveAudienceWatchDurationReport[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveAudienceWatchDurationReport[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveAudienceWatchDurationReport() {
            clear();
        }

        public final SCLiveAudienceWatchDurationReport clear() {
            this.watchDurationBiz = "";
            this.watchDurationToken = "";
            this.timerIntervalMs = 0L;
            this.timerMaxDurationMs = 0L;
            this.supportBackGroundTime = false;
            this.reportType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.watchDurationBiz.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.watchDurationBiz);
            }
            if (!this.watchDurationToken.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.watchDurationToken);
            }
            long j = this.timerIntervalMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.timerMaxDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            boolean z = this.supportBackGroundTime;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            int i = this.reportType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(6, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.watchDurationBiz.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.watchDurationBiz);
            }
            if (!this.watchDurationToken.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.watchDurationToken);
            }
            long j = this.timerIntervalMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.timerMaxDurationMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            boolean z = this.supportBackGroundTime;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            int i = this.reportType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveAudienceWatchDurationReport mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.watchDurationBiz = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.watchDurationToken = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.timerIntervalMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.timerMaxDurationMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.supportBackGroundTime = codedInputByteBufferNano.readBool();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.reportType = int32;
                    }
                }
            }
        }

        public static SCLiveAudienceWatchDurationReport parseFrom(byte[] bArr) {
            return (SCLiveAudienceWatchDurationReport) MessageNano.mergeFrom(new SCLiveAudienceWatchDurationReport(), bArr);
        }

        public static SCLiveAudienceWatchDurationReport parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveAudienceWatchDurationReport().mergeFrom(codedInputByteBufferNano);
        }
    }
}
