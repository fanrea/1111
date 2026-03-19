package com.kuaishou.protobuf.livestream.sei.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveStreamSEI {

    @Retention(RetentionPolicy.SOURCE)
    public @interface MetaDataType {
        public static final int INVALID = 0;
        public static final int LIVE_GZONE_VIDEO_LAYOUT_CONFIG = 3;
        public static final int LIVE_REDBLUE_BATTLE_LAYOUT_CONFIG = 4;
        public static final int LIVE_STAGE_BIZ_DATA = 2;
        public static final int LIVE_STAGE_LAYOUT_CONFIG = 1;
    }

    public static final class MetaDataContainer extends MessageNano {
        public static final int STATE_FIELD_NUMBER = 1;
        private static volatile MetaDataContainer[] _emptyArray;
        private int dataCase_ = 0;
        private Object data_;

        public static final class StateData extends MessageNano {
            private static volatile StateData[] _emptyArray;
            public Map<Integer, byte[]> state;

            public static StateData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new StateData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public StateData() {
                clear();
            }

            public final StateData clear() {
                this.state = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Map<Integer, byte[]> map = this.state;
                if (map != null) {
                    InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 13, 12);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                Map<Integer, byte[]> map = this.state;
                return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 1, 13, 12) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final StateData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
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
                        this.state = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.state, mapFactory, 13, 12, null, 8, 18);
                    }
                }
            }

            public static StateData parseFrom(byte[] bArr) {
                return (StateData) MessageNano.mergeFrom(new StateData(), bArr);
            }

            public static StateData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new StateData().mergeFrom(codedInputByteBufferNano);
            }
        }

        public final int getDataCase() {
            return this.dataCase_;
        }

        public final MetaDataContainer clearData() {
            this.dataCase_ = 0;
            this.data_ = null;
            return this;
        }

        public static MetaDataContainer[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MetaDataContainer[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasState() {
            return this.dataCase_ == 1;
        }

        public final StateData getState() {
            if (this.dataCase_ == 1) {
                return (StateData) this.data_;
            }
            return null;
        }

        public final MetaDataContainer setState(StateData stateData) {
            if (stateData == null) {
                throw new NullPointerException();
            }
            this.dataCase_ = 1;
            this.data_ = stateData;
            return this;
        }

        public MetaDataContainer() {
            clear();
        }

        public final MetaDataContainer clear() {
            clearData();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.dataCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.data_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return this.dataCase_ == 1 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.data_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MetaDataContainer mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.dataCase_ != 1) {
                        this.data_ = new StateData();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.data_);
                    this.dataCase_ = 1;
                }
            }
        }

        public static MetaDataContainer parseFrom(byte[] bArr) {
            return (MetaDataContainer) MessageNano.mergeFrom(new MetaDataContainer(), bArr);
        }

        public static MetaDataContainer parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MetaDataContainer().mergeFrom(codedInputByteBufferNano);
        }
    }
}
