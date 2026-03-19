package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePlutusFloatingLayerProto {

    public static final class SCLiveFloatingLayerRnOpen extends MessageNano {
        private static volatile SCLiveFloatingLayerRnOpen[] _emptyArray;
        public String bizData;
        public String extraData;
        public String livePlayBizId;

        public static SCLiveFloatingLayerRnOpen[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveFloatingLayerRnOpen[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveFloatingLayerRnOpen() {
            clear();
        }

        public final SCLiveFloatingLayerRnOpen clear() {
            this.livePlayBizId = "";
            this.bizData = "";
            this.extraData = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.livePlayBizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.livePlayBizId);
            }
            if (!this.bizData.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bizData);
            }
            if (!this.extraData.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.extraData);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.livePlayBizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.livePlayBizId);
            }
            if (!this.bizData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizData);
            }
            return !this.extraData.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.extraData) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveFloatingLayerRnOpen mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.livePlayBizId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.bizData = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraData = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveFloatingLayerRnOpen parseFrom(byte[] bArr) {
            return (SCLiveFloatingLayerRnOpen) MessageNano.mergeFrom(new SCLiveFloatingLayerRnOpen(), bArr);
        }

        public static SCLiveFloatingLayerRnOpen parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveFloatingLayerRnOpen().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveActivityAtmosphereSignal extends MessageNano {
        private static volatile SCLiveActivityAtmosphereSignal[] _emptyArray;
        public long atmosphereId;
        public LiveCdnNodeView[] atmosphereUrl;
        public int operationType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface OperationType {
            public static final int CLOSE_ATMOSPHERE = 2;
            public static final int OPEN_ATMOSPHERE = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveActivityAtmosphereSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveActivityAtmosphereSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveActivityAtmosphereSignal() {
            clear();
        }

        public final SCLiveActivityAtmosphereSignal clear() {
            this.atmosphereId = 0L;
            this.operationType = 0;
            this.atmosphereUrl = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.atmosphereId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.operationType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.atmosphereUrl;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.atmosphereUrl;
                    if (i2 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i2];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveCdnNodeView);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.atmosphereId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.operationType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.atmosphereUrl;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.atmosphereUrl;
                    if (i2 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i2];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveCdnNodeView);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveActivityAtmosphereSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.atmosphereId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.operationType = int32;
                    }
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.atmosphereUrl;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.atmosphereUrl, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.atmosphereUrl = liveCdnNodeViewArr2;
                }
            }
        }

        public static SCLiveActivityAtmosphereSignal parseFrom(byte[] bArr) {
            return (SCLiveActivityAtmosphereSignal) MessageNano.mergeFrom(new SCLiveActivityAtmosphereSignal(), bArr);
        }

        public static SCLiveActivityAtmosphereSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveActivityAtmosphereSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
