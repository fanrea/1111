package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPlayTypeSwitchInfo extends MessageNano {
    private static volatile SCLiveVoicePartyPlayTypeSwitchInfo[] _emptyArray;
    public int sourcePlayType;
    public int targetPlayType;

    public static SCLiveVoicePartyPlayTypeSwitchInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPlayTypeSwitchInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPlayTypeSwitchInfo() {
        clear();
    }

    public final SCLiveVoicePartyPlayTypeSwitchInfo clear() {
        this.sourcePlayType = 0;
        this.targetPlayType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.sourcePlayType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.targetPlayType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.sourcePlayType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.targetPlayType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPlayTypeSwitchInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.sourcePlayType = codedInputByteBufferNano.readUInt32();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.targetPlayType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveVoicePartyPlayTypeSwitchInfo parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPlayTypeSwitchInfo) MessageNano.mergeFrom(new SCLiveVoicePartyPlayTypeSwitchInfo(), bArr);
    }

    public static SCLiveVoicePartyPlayTypeSwitchInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPlayTypeSwitchInfo().mergeFrom(codedInputByteBufferNano);
    }
}
