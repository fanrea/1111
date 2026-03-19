package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAuthorBuyPushClosed extends MessageNano {
    private static volatile SCLiveAuthorBuyPushClosed[] _emptyArray;

    public static SCLiveAuthorBuyPushClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAuthorBuyPushClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAuthorBuyPushClosed() {
        clear();
    }

    public final SCLiveAuthorBuyPushClosed clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAuthorBuyPushClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static SCLiveAuthorBuyPushClosed parseFrom(byte[] bArr) {
        return (SCLiveAuthorBuyPushClosed) MessageNano.mergeFrom(new SCLiveAuthorBuyPushClosed(), bArr);
    }

    public static SCLiveAuthorBuyPushClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAuthorBuyPushClosed().mergeFrom(codedInputByteBufferNano);
    }
}
