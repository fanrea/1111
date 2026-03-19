package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UploadRoomConfig extends MessageNano {
    private static volatile UploadRoomConfig[] _emptyArray;

    public static UploadRoomConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UploadRoomConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public UploadRoomConfig() {
        clear();
    }

    public final UploadRoomConfig clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UploadRoomConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static UploadRoomConfig parseFrom(byte[] bArr) {
        return (UploadRoomConfig) MessageNano.mergeFrom(new UploadRoomConfig(), bArr);
    }

    public static UploadRoomConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UploadRoomConfig().mergeFrom(codedInputByteBufferNano);
    }
}
