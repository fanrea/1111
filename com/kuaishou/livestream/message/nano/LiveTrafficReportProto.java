package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveTrafficReportProto {

    public static final class LiveTrafficReport extends MessageNano {
        private static volatile LiveTrafficReport[] _emptyArray;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveTrafficReportParamType {
            public static final int LIVE_STREAM_LITE_STAY = 1;
            public static final int UNKNOWN = 0;
        }

        public static LiveTrafficReport[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTrafficReport[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTrafficReport() {
            clear();
        }

        public final LiveTrafficReport clear() {
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTrafficReport mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            int tag;
            do {
                tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
            } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
            return this;
        }

        public static LiveTrafficReport parseFrom(byte[] bArr) {
            return (LiveTrafficReport) MessageNano.mergeFrom(new LiveTrafficReport(), bArr);
        }

        public static LiveTrafficReport parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTrafficReport().mergeFrom(codedInputByteBufferNano);
        }
    }
}
