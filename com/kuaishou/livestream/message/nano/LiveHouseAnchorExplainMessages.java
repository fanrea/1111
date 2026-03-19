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
public interface LiveHouseAnchorExplainMessages {

    public static final class SCLiveHouseAnchorExplainCardSignal extends MessageNano {
        private static volatile SCLiveHouseAnchorExplainCardSignal[] _emptyArray;
        public int signalType;
        public String templateData;
        public String templateId;
        public int templateVersionCode;
        public String viewKey;

        @Retention(RetentionPolicy.SOURCE)
        public @interface SignalType {
            public static final int DELETE = 0;
            public static final int SHOW = 1;
        }

        public static SCLiveHouseAnchorExplainCardSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveHouseAnchorExplainCardSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveHouseAnchorExplainCardSignal() {
            clear();
        }

        public final SCLiveHouseAnchorExplainCardSignal clear() {
            this.signalType = 0;
            this.templateId = "";
            this.templateVersionCode = 0;
            this.viewKey = "";
            this.templateData = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.signalType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.templateId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.templateId);
            }
            int i2 = this.templateVersionCode;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i2);
            }
            if (!this.viewKey.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.viewKey);
            }
            if (!this.templateData.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.templateData);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.signalType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.templateId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.templateId);
            }
            int i2 = this.templateVersionCode;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
            }
            if (!this.viewKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.viewKey);
            }
            return !this.templateData.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.templateData) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveHouseAnchorExplainCardSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.signalType = int32;
                    }
                } else if (tag == 18) {
                    this.templateId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.templateVersionCode = codedInputByteBufferNano.readInt32();
                } else if (tag == 34) {
                    this.viewKey = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.templateData = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveHouseAnchorExplainCardSignal parseFrom(byte[] bArr) {
            return (SCLiveHouseAnchorExplainCardSignal) MessageNano.mergeFrom(new SCLiveHouseAnchorExplainCardSignal(), bArr);
        }

        public static SCLiveHouseAnchorExplainCardSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveHouseAnchorExplainCardSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
