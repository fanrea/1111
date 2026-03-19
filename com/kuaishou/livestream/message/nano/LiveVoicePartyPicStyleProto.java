package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyPicStyleProto extends MessageNano {
    private static volatile LiveVoicePartyPicStyleProto[] _emptyArray;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VoicePartyPicStyle {
        public static final int AVATAR = 1;
        public static final int THEATER = 2;
        public static final int UNKNOWN = 0;
    }

    public static LiveVoicePartyPicStyleProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyPicStyleProto[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyPicStyleProto() {
        clear();
    }

    public final LiveVoicePartyPicStyleProto clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyPicStyleProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static LiveVoicePartyPicStyleProto parseFrom(byte[] bArr) {
        return (LiveVoicePartyPicStyleProto) MessageNano.mergeFrom(new LiveVoicePartyPicStyleProto(), bArr);
    }

    public static LiveVoicePartyPicStyleProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyPicStyleProto().mergeFrom(codedInputByteBufferNano);
    }
}
