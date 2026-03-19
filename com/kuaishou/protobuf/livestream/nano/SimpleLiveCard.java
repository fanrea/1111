package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SimpleLiveCard extends MessageNano {
    private static volatile SimpleLiveCard[] _emptyArray;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SimpleLiveCardType {
        public static final int AD_COMMON_CARD = 101;
        public static final int COMMON_CARD = 100;
        public static final int COUPON_CARD = 1;
        public static final int FOLLOWING_CARD = 5;
        public static final int GAME_CARD = 6;
        public static final int GAME_SPREAD_GOLD_CARD = 10;
        public static final int LIVE_AD_CUSTOM_HOT_SHOP_CARD = 113;
        public static final int LIVE_COMMERCIAL_FELLOW_CARD = 9;
        public static final int LIVE_JOIN_CHAT_CARD = 115;
        public static final int LIVE_LOCAL_LIFE_COMMON_CARD = 102;
        public static final int LIVE_LOCAL_LIFE_COUPON_CARD = 103;
        public static final int LIVE_MERCHANT_CUSTOM_CARD = 15;
        public static final int LIVE_MERCHANT_CUSTOM_DYNAMIC_CARD = 112;
        public static final int LIVE_MERCHANT_RADAR_CARD = 109;
        public static final int LIVE_NON_COMMERCIAL_FELLOW_CARD = 11;
        public static final int LIVE_QUESTIONNAIRE_CARD = 111;
        public static final int LIVE_QUICK_COMMENT_CARD = 114;
        public static final int LIVE_SEARCH_MERCHANT_CARD = 110;
        public static final int LIVE_TO_CONSUL_CARD = 14;
        public static final int LIVE_TO_DOWNLOAD_CARD = 13;
        public static final int LIVE_TO_PHOTO_CARD = 7;
        public static final int LIVE_TO_PRODUCT_CARD = 8;
        public static final int PREVIEW_CARD = 3;
        public static final int PRODUCT_CARD = 2;
        public static final int TIME_LIMITED_CARD = 4;
        public static final int UNKNOWN_CARD_TYPE = 0;
    }

    public static SimpleLiveCard[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SimpleLiveCard[0];
                }
            }
        }
        return _emptyArray;
    }

    public SimpleLiveCard() {
        clear();
    }

    public final SimpleLiveCard clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SimpleLiveCard mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static SimpleLiveCard parseFrom(byte[] bArr) {
        return (SimpleLiveCard) MessageNano.mergeFrom(new SimpleLiveCard(), bArr);
    }

    public static SimpleLiveCard parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SimpleLiveCard().mergeFrom(codedInputByteBufferNano);
    }
}
