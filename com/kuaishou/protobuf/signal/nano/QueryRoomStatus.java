package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class QueryRoomStatus extends MessageNano {
    private static volatile QueryRoomStatus[] _emptyArray;

    public static QueryRoomStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryRoomStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public QueryRoomStatus() {
        clear();
    }

    public final QueryRoomStatus clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final QueryRoomStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static QueryRoomStatus parseFrom(byte[] bArr) {
        return (QueryRoomStatus) MessageNano.mergeFrom(new QueryRoomStatus(), bArr);
    }

    public static QueryRoomStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new QueryRoomStatus().mergeFrom(codedInputByteBufferNano);
    }
}
