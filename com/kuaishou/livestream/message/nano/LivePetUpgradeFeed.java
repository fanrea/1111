package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePetUpgradeFeed extends MessageNano {
    private static volatile LivePetUpgradeFeed[] _emptyArray;
    public int level;
    public String petId;
    public int size;
    public String tips;

    public static LivePetUpgradeFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePetUpgradeFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePetUpgradeFeed() {
        clear();
    }

    public final LivePetUpgradeFeed clear() {
        this.petId = "";
        this.level = 0;
        this.tips = "";
        this.size = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.petId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.petId);
        }
        int i = this.level;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        if (!this.tips.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.tips);
        }
        int i2 = this.size;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.petId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.petId);
        }
        int i = this.level;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        if (!this.tips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.tips);
        }
        int i2 = this.size;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePetUpgradeFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.petId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.level = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                this.tips = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.size = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LivePetUpgradeFeed parseFrom(byte[] bArr) {
        return (LivePetUpgradeFeed) MessageNano.mergeFrom(new LivePetUpgradeFeed(), bArr);
    }

    public static LivePetUpgradeFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePetUpgradeFeed().mergeFrom(codedInputByteBufferNano);
    }
}
