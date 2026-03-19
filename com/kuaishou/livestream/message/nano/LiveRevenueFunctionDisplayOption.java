package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRevenueFunctionDisplayOption {

    public static final class LiveRevenueEffectSwitchConfig extends MessageNano {
        private static volatile LiveRevenueEffectSwitchConfig[] _emptyArray;
        public boolean disable;
        public long[] disableMagicFaceIds;

        public static LiveRevenueEffectSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueEffectSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueEffectSwitchConfig() {
            clear();
        }

        public final LiveRevenueEffectSwitchConfig clear() {
            this.disable = false;
            this.disableMagicFaceIds = WireFormatNano.EMPTY_LONG_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.disable;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long[] jArr = this.disableMagicFaceIds;
            if (jArr != null && jArr.length > 0) {
                int i = 0;
                while (true) {
                    long[] jArr2 = this.disableMagicFaceIds;
                    if (i >= jArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt64(2, jArr2[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.disable;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long[] jArr = this.disableMagicFaceIds;
            if (jArr == null || jArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                long[] jArr2 = this.disableMagicFaceIds;
                if (i < jArr2.length) {
                    iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i]);
                    i++;
                } else {
                    return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
                }
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueEffectSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.disable = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                    long[] jArr = this.disableMagicFaceIds;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.disableMagicFaceIds, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.disableMagicFaceIds = jArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.disableMagicFaceIds;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.disableMagicFaceIds, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.disableMagicFaceIds = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                }
            }
        }

        public static LiveRevenueEffectSwitchConfig parseFrom(byte[] bArr) {
            return (LiveRevenueEffectSwitchConfig) MessageNano.mergeFrom(new LiveRevenueEffectSwitchConfig(), bArr);
        }

        public static LiveRevenueEffectSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueEffectSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRevenueGiftSlotSwitchConfig extends MessageNano {
        private static volatile LiveRevenueGiftSlotSwitchConfig[] _emptyArray;
        public boolean disable;

        public static LiveRevenueGiftSlotSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueGiftSlotSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueGiftSlotSwitchConfig() {
            clear();
        }

        public final LiveRevenueGiftSlotSwitchConfig clear() {
            this.disable = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.disable;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.disable;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueGiftSlotSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.disable = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveRevenueGiftSlotSwitchConfig parseFrom(byte[] bArr) {
            return (LiveRevenueGiftSlotSwitchConfig) MessageNano.mergeFrom(new LiveRevenueGiftSlotSwitchConfig(), bArr);
        }

        public static LiveRevenueGiftSlotSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueGiftSlotSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRevenueGiftBoxSwitchConfig extends MessageNano {
        private static volatile LiveRevenueGiftBoxSwitchConfig[] _emptyArray;
        public boolean disable;

        public static LiveRevenueGiftBoxSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueGiftBoxSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueGiftBoxSwitchConfig() {
            clear();
        }

        public final LiveRevenueGiftBoxSwitchConfig clear() {
            this.disable = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.disable;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.disable;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueGiftBoxSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.disable = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveRevenueGiftBoxSwitchConfig parseFrom(byte[] bArr) {
            return (LiveRevenueGiftBoxSwitchConfig) MessageNano.mergeFrom(new LiveRevenueGiftBoxSwitchConfig(), bArr);
        }

        public static LiveRevenueGiftBoxSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueGiftBoxSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRevenueAttachGiftSwitchConfig extends MessageNano {
        private static volatile LiveRevenueAttachGiftSwitchConfig[] _emptyArray;
        public boolean disable;

        public static LiveRevenueAttachGiftSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueAttachGiftSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueAttachGiftSwitchConfig() {
            clear();
        }

        public final LiveRevenueAttachGiftSwitchConfig clear() {
            this.disable = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.disable;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.disable;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueAttachGiftSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.disable = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveRevenueAttachGiftSwitchConfig parseFrom(byte[] bArr) {
            return (LiveRevenueAttachGiftSwitchConfig) MessageNano.mergeFrom(new LiveRevenueAttachGiftSwitchConfig(), bArr);
        }

        public static LiveRevenueAttachGiftSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueAttachGiftSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRevenueWishListPendantSwitchConfig extends MessageNano {
        private static volatile LiveRevenueWishListPendantSwitchConfig[] _emptyArray;
        public boolean disable;

        public static LiveRevenueWishListPendantSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueWishListPendantSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueWishListPendantSwitchConfig() {
            clear();
        }

        public final LiveRevenueWishListPendantSwitchConfig clear() {
            this.disable = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.disable;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.disable;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueWishListPendantSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.disable = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveRevenueWishListPendantSwitchConfig parseFrom(byte[] bArr) {
            return (LiveRevenueWishListPendantSwitchConfig) MessageNano.mergeFrom(new LiveRevenueWishListPendantSwitchConfig(), bArr);
        }

        public static LiveRevenueWishListPendantSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueWishListPendantSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRevenueOptionSwitchConfig extends MessageNano {
        private static volatile LiveRevenueOptionSwitchConfig[] _emptyArray;
        public LiveRevenueAttachGiftSwitchConfig attachGift;
        public LiveRevenueEffectSwitchConfig effect;
        public LiveRevenueGiftBoxSwitchConfig giftBox;
        public LiveRevenueGiftSlotSwitchConfig giftSlot;
        public LiveRevenueWishListPendantSwitchConfig wishListPendant;

        public static LiveRevenueOptionSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueOptionSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueOptionSwitchConfig() {
            clear();
        }

        public final LiveRevenueOptionSwitchConfig clear() {
            this.effect = null;
            this.giftSlot = null;
            this.giftBox = null;
            this.attachGift = null;
            this.wishListPendant = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveRevenueEffectSwitchConfig liveRevenueEffectSwitchConfig = this.effect;
            if (liveRevenueEffectSwitchConfig != null) {
                codedOutputByteBufferNano.writeMessage(1, liveRevenueEffectSwitchConfig);
            }
            LiveRevenueGiftSlotSwitchConfig liveRevenueGiftSlotSwitchConfig = this.giftSlot;
            if (liveRevenueGiftSlotSwitchConfig != null) {
                codedOutputByteBufferNano.writeMessage(2, liveRevenueGiftSlotSwitchConfig);
            }
            LiveRevenueGiftBoxSwitchConfig liveRevenueGiftBoxSwitchConfig = this.giftBox;
            if (liveRevenueGiftBoxSwitchConfig != null) {
                codedOutputByteBufferNano.writeMessage(3, liveRevenueGiftBoxSwitchConfig);
            }
            LiveRevenueAttachGiftSwitchConfig liveRevenueAttachGiftSwitchConfig = this.attachGift;
            if (liveRevenueAttachGiftSwitchConfig != null) {
                codedOutputByteBufferNano.writeMessage(4, liveRevenueAttachGiftSwitchConfig);
            }
            LiveRevenueWishListPendantSwitchConfig liveRevenueWishListPendantSwitchConfig = this.wishListPendant;
            if (liveRevenueWishListPendantSwitchConfig != null) {
                codedOutputByteBufferNano.writeMessage(5, liveRevenueWishListPendantSwitchConfig);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveRevenueEffectSwitchConfig liveRevenueEffectSwitchConfig = this.effect;
            if (liveRevenueEffectSwitchConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveRevenueEffectSwitchConfig);
            }
            LiveRevenueGiftSlotSwitchConfig liveRevenueGiftSlotSwitchConfig = this.giftSlot;
            if (liveRevenueGiftSlotSwitchConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveRevenueGiftSlotSwitchConfig);
            }
            LiveRevenueGiftBoxSwitchConfig liveRevenueGiftBoxSwitchConfig = this.giftBox;
            if (liveRevenueGiftBoxSwitchConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveRevenueGiftBoxSwitchConfig);
            }
            LiveRevenueAttachGiftSwitchConfig liveRevenueAttachGiftSwitchConfig = this.attachGift;
            if (liveRevenueAttachGiftSwitchConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveRevenueAttachGiftSwitchConfig);
            }
            LiveRevenueWishListPendantSwitchConfig liveRevenueWishListPendantSwitchConfig = this.wishListPendant;
            return liveRevenueWishListPendantSwitchConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, liveRevenueWishListPendantSwitchConfig) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueOptionSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.effect == null) {
                        this.effect = new LiveRevenueEffectSwitchConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.effect);
                } else if (tag == 18) {
                    if (this.giftSlot == null) {
                        this.giftSlot = new LiveRevenueGiftSlotSwitchConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.giftSlot);
                } else if (tag == 26) {
                    if (this.giftBox == null) {
                        this.giftBox = new LiveRevenueGiftBoxSwitchConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.giftBox);
                } else if (tag == 34) {
                    if (this.attachGift == null) {
                        this.attachGift = new LiveRevenueAttachGiftSwitchConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.attachGift);
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.wishListPendant == null) {
                        this.wishListPendant = new LiveRevenueWishListPendantSwitchConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.wishListPendant);
                }
            }
        }

        public static LiveRevenueOptionSwitchConfig parseFrom(byte[] bArr) {
            return (LiveRevenueOptionSwitchConfig) MessageNano.mergeFrom(new LiveRevenueOptionSwitchConfig(), bArr);
        }

        public static LiveRevenueOptionSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueOptionSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ScLiveRevenueFunctionSwitchConfig extends MessageNano {
        private static volatile ScLiveRevenueFunctionSwitchConfig[] _emptyArray;
        public LiveRevenueOptionSwitchConfig config;
        public String liveStreamId;
        public long version;

        public static ScLiveRevenueFunctionSwitchConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScLiveRevenueFunctionSwitchConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ScLiveRevenueFunctionSwitchConfig() {
            clear();
        }

        public final ScLiveRevenueFunctionSwitchConfig clear() {
            this.config = null;
            this.version = 0L;
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveRevenueOptionSwitchConfig liveRevenueOptionSwitchConfig = this.config;
            if (liveRevenueOptionSwitchConfig != null) {
                codedOutputByteBufferNano.writeMessage(1, liveRevenueOptionSwitchConfig);
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveRevenueOptionSwitchConfig liveRevenueOptionSwitchConfig = this.config;
            if (liveRevenueOptionSwitchConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveRevenueOptionSwitchConfig);
            }
            long j = this.version;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ScLiveRevenueFunctionSwitchConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.config == null) {
                        this.config = new LiveRevenueOptionSwitchConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.config);
                } else if (tag == 16) {
                    this.version = codedInputByteBufferNano.readUInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ScLiveRevenueFunctionSwitchConfig parseFrom(byte[] bArr) {
            return (ScLiveRevenueFunctionSwitchConfig) MessageNano.mergeFrom(new ScLiveRevenueFunctionSwitchConfig(), bArr);
        }

        public static ScLiveRevenueFunctionSwitchConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ScLiveRevenueFunctionSwitchConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
