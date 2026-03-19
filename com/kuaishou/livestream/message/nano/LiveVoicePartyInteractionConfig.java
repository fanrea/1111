package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyInteractionConfig extends MessageNano {
    private static volatile LiveVoicePartyInteractionConfig[] _emptyArray;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayType {
        public static final int CROSS_ROOM_TEAM_PK = 6;
        public static final int GRID_CHAT = 7;
        public static final int KTV = 2;
        public static final int NORMAL_PLAY_TPYE = 1;
        public static final int TEAM_PK = 4;
        public static final int THEATER = 3;
        public static final int UNKNOWN_PLAY_TYPE = 0;
        public static final int VIDEO_TYPE = 5;
    }

    public static LiveVoicePartyInteractionConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyInteractionConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyInteractionConfig() {
        clear();
    }

    public final LiveVoicePartyInteractionConfig clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyInteractionConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static LiveVoicePartyInteractionConfig parseFrom(byte[] bArr) {
        return (LiveVoicePartyInteractionConfig) MessageNano.mergeFrom(new LiveVoicePartyInteractionConfig(), bArr);
    }

    public static LiveVoicePartyInteractionConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyInteractionConfig().mergeFrom(codedInputByteBufferNano);
    }
}
