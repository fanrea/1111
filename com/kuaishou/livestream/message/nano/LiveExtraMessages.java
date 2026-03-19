package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveExtraMessages {

    public static final class LiveCommonAbstractSignal extends MessageNano {
        private static volatile LiveCommonAbstractSignal[] _emptyArray;
        public String liveStreamId;
        public byte[] payload;
        public String payloadType;

        public static LiveCommonAbstractSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonAbstractSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonAbstractSignal() {
            clear();
        }

        public final LiveCommonAbstractSignal clear() {
            this.liveStreamId = "";
            this.payloadType = "";
            this.payload = WireFormatNano.EMPTY_BYTES;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.payloadType.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.payloadType);
            }
            if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(3, this.payload);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.payloadType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.payloadType);
            }
            return !Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.payload) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonAbstractSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.payloadType = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.payload = codedInputByteBufferNano.readBytes();
                }
            }
        }

        public static LiveCommonAbstractSignal parseFrom(byte[] bArr) {
            return (LiveCommonAbstractSignal) MessageNano.mergeFrom(new LiveCommonAbstractSignal(), bArr);
        }

        public static LiveCommonAbstractSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonAbstractSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCommonStateSignal extends MessageNano {
        private static volatile SCLiveCommonStateSignal[] _emptyArray;
        public LiveCommonAbstractSignal state;

        public static SCLiveCommonStateSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCommonStateSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCommonStateSignal() {
            clear();
        }

        public final SCLiveCommonStateSignal clear() {
            this.state = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCommonAbstractSignal liveCommonAbstractSignal = this.state;
            if (liveCommonAbstractSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonAbstractSignal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCommonAbstractSignal liveCommonAbstractSignal = this.state;
            return liveCommonAbstractSignal != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonAbstractSignal) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCommonStateSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.state == null) {
                        this.state = new LiveCommonAbstractSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.state);
                }
            }
        }

        public static SCLiveCommonStateSignal parseFrom(byte[] bArr) {
            return (SCLiveCommonStateSignal) MessageNano.mergeFrom(new SCLiveCommonStateSignal(), bArr);
        }

        public static SCLiveCommonStateSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCommonStateSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCommonPreciseControlSignal extends MessageNano {
        private static volatile SCLiveCommonPreciseControlSignal[] _emptyArray;
        public LiveCommonAbstractSignal action;

        public static SCLiveCommonPreciseControlSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCommonPreciseControlSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCommonPreciseControlSignal() {
            clear();
        }

        public final SCLiveCommonPreciseControlSignal clear() {
            this.action = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            if (liveCommonAbstractSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonAbstractSignal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            return liveCommonAbstractSignal != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonAbstractSignal) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCommonPreciseControlSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.action == null) {
                        this.action = new LiveCommonAbstractSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.action);
                }
            }
        }

        public static SCLiveCommonPreciseControlSignal parseFrom(byte[] bArr) {
            return (SCLiveCommonPreciseControlSignal) MessageNano.mergeFrom(new SCLiveCommonPreciseControlSignal(), bArr);
        }

        public static SCLiveCommonPreciseControlSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCommonPreciseControlSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCommonActionSignal extends MessageNano {
        private static volatile LiveCommonActionSignal[] _emptyArray;
        public LiveCommonAbstractSignal action;

        public static LiveCommonActionSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonActionSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonActionSignal() {
            clear();
        }

        public final LiveCommonActionSignal clear() {
            this.action = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            if (liveCommonAbstractSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonAbstractSignal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            return liveCommonAbstractSignal != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonAbstractSignal) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonActionSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.action == null) {
                        this.action = new LiveCommonAbstractSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.action);
                }
            }
        }

        public static LiveCommonActionSignal parseFrom(byte[] bArr) {
            return (LiveCommonActionSignal) MessageNano.mergeFrom(new LiveCommonActionSignal(), bArr);
        }

        public static LiveCommonActionSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonActionSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
