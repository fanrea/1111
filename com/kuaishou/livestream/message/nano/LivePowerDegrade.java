package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePowerDegrade extends MessageNano {
    private static volatile LivePowerDegrade[] _emptyArray;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Biz {
        public static final int AI = 8;
        public static final int FLOATING_ANIMATION = 7;
        public static final int FLOATING_ELEMENT = 3;
        public static final int GIFT = 1;
        public static final int INTERACTIVE_BOX = 9;
        public static final int MAGIC_FACE = 2;
        public static final int QUICK_INTERACTION = 12;
        public static final int RTC_ANIMATION = 6;
        public static final int RTC_CAPTURE = 5;
        public static final int RTC_REMOTE_AMPLITUDE = 11;
        public static final int SHOW_LIVE_CAPTURE = 4;
        public static final int STREAM_RENDER = 10;
        public static final int UNKNOWN_POWER_DEGRADE_BIZ = 0;
    }

    public static LivePowerDegrade[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePowerDegrade[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePowerDegrade() {
        clear();
    }

    public final LivePowerDegrade clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePowerDegrade mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static LivePowerDegrade parseFrom(byte[] bArr) {
        return (LivePowerDegrade) MessageNano.mergeFrom(new LivePowerDegrade(), bArr);
    }

    public static LivePowerDegrade parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePowerDegrade().mergeFrom(codedInputByteBufferNano);
    }
}
