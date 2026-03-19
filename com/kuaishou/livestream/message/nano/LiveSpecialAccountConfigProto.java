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
public interface LiveSpecialAccountConfigProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConfigSwitchType {
        public static final int HIDE_BARRAGE = 1;
        public static final int HIDE_SPECIAL_EFFECT = 2;
        public static final int UNKNOWN_CONFIG_SWITCH_TYPE = 0;
    }

    public static final class ConfigSwitchItem extends MessageNano {
        private static volatile ConfigSwitchItem[] _emptyArray;
        public int configSwitchType;
        public boolean value;

        public static ConfigSwitchItem[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ConfigSwitchItem[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ConfigSwitchItem() {
            clear();
        }

        public final ConfigSwitchItem clear() {
            this.configSwitchType = 0;
            this.value = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.configSwitchType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            boolean z = this.value;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.configSwitchType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            boolean z = this.value;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ConfigSwitchItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.configSwitchType = int32;
                    }
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.value = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static ConfigSwitchItem parseFrom(byte[] bArr) {
            return (ConfigSwitchItem) MessageNano.mergeFrom(new ConfigSwitchItem(), bArr);
        }

        public static ConfigSwitchItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ConfigSwitchItem().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveSpecialAccountConfigState extends MessageNano {
        private static volatile SCLiveSpecialAccountConfigState[] _emptyArray;
        public ConfigSwitchItem[] configSwitchItem;
        public long timestamp;

        public static SCLiveSpecialAccountConfigState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveSpecialAccountConfigState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveSpecialAccountConfigState() {
            clear();
        }

        public final SCLiveSpecialAccountConfigState clear() {
            this.configSwitchItem = ConfigSwitchItem.emptyArray();
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ConfigSwitchItem[] configSwitchItemArr = this.configSwitchItem;
            if (configSwitchItemArr != null && configSwitchItemArr.length > 0) {
                int i = 0;
                while (true) {
                    ConfigSwitchItem[] configSwitchItemArr2 = this.configSwitchItem;
                    if (i >= configSwitchItemArr2.length) {
                        break;
                    }
                    ConfigSwitchItem configSwitchItem = configSwitchItemArr2[i];
                    if (configSwitchItem != null) {
                        codedOutputByteBufferNano.writeMessage(1, configSwitchItem);
                    }
                    i++;
                }
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ConfigSwitchItem[] configSwitchItemArr = this.configSwitchItem;
            if (configSwitchItemArr != null && configSwitchItemArr.length > 0) {
                int i = 0;
                while (true) {
                    ConfigSwitchItem[] configSwitchItemArr2 = this.configSwitchItem;
                    if (i >= configSwitchItemArr2.length) {
                        break;
                    }
                    ConfigSwitchItem configSwitchItem = configSwitchItemArr2[i];
                    if (configSwitchItem != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, configSwitchItem);
                    }
                    i++;
                }
            }
            long j = this.timestamp;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveSpecialAccountConfigState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    ConfigSwitchItem[] configSwitchItemArr = this.configSwitchItem;
                    int length = configSwitchItemArr == null ? 0 : configSwitchItemArr.length;
                    ConfigSwitchItem[] configSwitchItemArr2 = new ConfigSwitchItem[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.configSwitchItem, 0, configSwitchItemArr2, 0, length);
                    }
                    while (length < configSwitchItemArr2.length - 1) {
                        configSwitchItemArr2[length] = new ConfigSwitchItem();
                        codedInputByteBufferNano.readMessage(configSwitchItemArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    configSwitchItemArr2[length] = new ConfigSwitchItem();
                    codedInputByteBufferNano.readMessage(configSwitchItemArr2[length]);
                    this.configSwitchItem = configSwitchItemArr2;
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveSpecialAccountConfigState parseFrom(byte[] bArr) {
            return (SCLiveSpecialAccountConfigState) MessageNano.mergeFrom(new SCLiveSpecialAccountConfigState(), bArr);
        }

        public static SCLiveSpecialAccountConfigState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveSpecialAccountConfigState().mergeFrom(codedInputByteBufferNano);
        }
    }
}
