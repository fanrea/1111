package com.kuaishou.kwaishop.link.protobuf.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KwaishopResourcePush extends MessageNano {
    private static volatile KwaishopResourcePush[] _emptyArray;
    public Map<String, String> data;
    public int type;

    public static KwaishopResourcePush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new KwaishopResourcePush[0];
                }
            }
        }
        return _emptyArray;
    }

    public KwaishopResourcePush() {
        clear();
    }

    public final KwaishopResourcePush clear() {
        this.type = 0;
        this.data = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        Map<String, String> map = this.data;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        Map<String, String> map = this.data;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 2, 9, 9) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final KwaishopResourcePush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.data = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.data, mapFactory, 9, 9, null, 10, 18);
            }
        }
    }

    public static KwaishopResourcePush parseFrom(byte[] bArr) {
        return (KwaishopResourcePush) MessageNano.mergeFrom(new KwaishopResourcePush(), bArr);
    }

    public static KwaishopResourcePush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new KwaishopResourcePush().mergeFrom(codedInputByteBufferNano);
    }
}
