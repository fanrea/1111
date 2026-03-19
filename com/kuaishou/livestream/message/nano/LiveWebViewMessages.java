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
public interface LiveWebViewMessages {

    public static final class SCLiveWebViewDisplay extends MessageNano {
        private static volatile SCLiveWebViewDisplay[] _emptyArray;
        public long autoCloseDuration;
        public boolean disableManualClose;
        public long height;
        public float heightRatio;
        public String id;
        public String liveStreamId;
        public String url;
        public int webViewType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveWebViewType {
            public static final int QUIZ = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveWebViewDisplay[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveWebViewDisplay[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveWebViewDisplay() {
            clear();
        }

        public final SCLiveWebViewDisplay clear() {
            this.id = "";
            this.liveStreamId = "";
            this.url = "";
            this.height = 0L;
            this.autoCloseDuration = 0L;
            this.webViewType = 0;
            this.disableManualClose = false;
            this.heightRatio = 0.0f;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.liveStreamId);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.url);
            }
            long j = this.height;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.autoCloseDuration;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            int i = this.webViewType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(6, i);
            }
            boolean z = this.disableManualClose;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            if (Float.floatToIntBits(this.heightRatio) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(8, this.heightRatio);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
            }
            if (!this.url.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.url);
            }
            long j = this.height;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.autoCloseDuration;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            int i = this.webViewType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i);
            }
            boolean z = this.disableManualClose;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            return Float.floatToIntBits(this.heightRatio) != Float.floatToIntBits(0.0f) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(8, this.heightRatio) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveWebViewDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.url = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.height = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.autoCloseDuration = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.webViewType = int32;
                    }
                } else if (tag == 56) {
                    this.disableManualClose = codedInputByteBufferNano.readBool();
                } else if (tag != 69) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.heightRatio = codedInputByteBufferNano.readFloat();
                }
            }
        }

        public static SCLiveWebViewDisplay parseFrom(byte[] bArr) {
            return (SCLiveWebViewDisplay) MessageNano.mergeFrom(new SCLiveWebViewDisplay(), bArr);
        }

        public static SCLiveWebViewDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveWebViewDisplay().mergeFrom(codedInputByteBufferNano);
        }
    }
}
