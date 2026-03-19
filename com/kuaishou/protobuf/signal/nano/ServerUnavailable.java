package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ServerUnavailable extends MessageNano {
    private static volatile ServerUnavailable[] _emptyArray;

    public static ServerUnavailable[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ServerUnavailable[0];
                }
            }
        }
        return _emptyArray;
    }

    public ServerUnavailable() {
        clear();
    }

    public final ServerUnavailable clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ServerUnavailable mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static ServerUnavailable parseFrom(byte[] bArr) {
        return (ServerUnavailable) MessageNano.mergeFrom(new ServerUnavailable(), bArr);
    }

    public static ServerUnavailable parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ServerUnavailable().mergeFrom(codedInputByteBufferNano);
    }
}
