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
public interface LiveTreasureChestMessage {

    public static final class SCLiveInteractiveMagicEffectEvent extends MessageNano {
        private static volatile SCLiveInteractiveMagicEffectEvent[] _emptyArray;
        public String bizId;
        public String data;
        public int effectEventType;
        public long serverTime;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EffectEventType {
            public static final int EFFECT_OFF = 1;
            public static final int EFFECT_UPDATE = 2;
            public static final int UNKNOWN_EFFECT_TYPE = 0;
        }

        public static SCLiveInteractiveMagicEffectEvent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveInteractiveMagicEffectEvent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveInteractiveMagicEffectEvent() {
            clear();
        }

        public final SCLiveInteractiveMagicEffectEvent clear() {
            this.bizId = "";
            this.effectEventType = 0;
            this.data = "";
            this.serverTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bizId);
            }
            int i = this.effectEventType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            if (!this.data.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.data);
            }
            long j = this.serverTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizId);
            }
            int i = this.effectEventType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            if (!this.data.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.data);
            }
            long j = this.serverTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveInteractiveMagicEffectEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.effectEventType = int32;
                    }
                } else if (tag == 26) {
                    this.data = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveInteractiveMagicEffectEvent parseFrom(byte[] bArr) {
            return (SCLiveInteractiveMagicEffectEvent) MessageNano.mergeFrom(new SCLiveInteractiveMagicEffectEvent(), bArr);
        }

        public static SCLiveInteractiveMagicEffectEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveInteractiveMagicEffectEvent().mergeFrom(codedInputByteBufferNano);
        }
    }
}
