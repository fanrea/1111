package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface RedPackTypeProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface RedPackType {
        public static final int ARROW_CONDITION_RED_PACK = 45;
        public static final int ARROW_RED_PACK = 2;
        public static final int AUDIENCE_GIFT_RED_PACK = 12;
        public static final int BLESSING_RED_PACK = 17;
        public static final int CNY2024_WARMUP_PRAY_LEEE = 50;
        public static final int COMMON_CONDITION_RED_PACK = 39;
        public static final int COMMON_RED_PACK = 1;
        public static final int CONDITION_SHARE_RED_PACK = 15;
        public static final int CONFESSION_RED_PACK = 18;
        public static final int DELAY_MULTI_TYPE_RED_PACK = 40;
        public static final int DELAY_MULTI_TYPE_RED_PACK_BIZ_EXT = 41;
        public static final int FANS_GROUP_RED_PACK = 14;
        public static final int FANS_INCREASE_RED_PACK = 43;
        public static final int GIFT_SENT_RED_PACK = 16;
        public static final int INTELLIGENT_RED_PACK = 26;
        public static final int LIVE_AUTHOR_TASK_RED_PACK = 46;
        public static final int LIVE_DRAW_LOTTERY_RED_PACK = 48;
        public static final int LIVE_LEAGUE_LEEE = 51;
        public static final int LIVE_SECKILL_RED_PACK = 44;
        public static final int LIVE_TASK_LEEE = 49;
        public static final int LOVE_520_RED_PACK = 21;
        public static final int OFFICIAL_OPERATION_RED_PACK = 20;
        public static final int OLYMPICS_RED_PACK = 25;
        public static final int PASSWORD_RED_PACK = 47;
        public static final int PK_BOUNTY_ACTIVITY_RED_PACK = 28;
        public static final int PK_BOUNTY_GAME_RED_PACK = 19;
        public static final int REVENUE_ACTIVITY_RED_PACK_EIGHT = 36;
        public static final int REVENUE_ACTIVITY_RED_PACK_FIVE = 33;
        public static final int REVENUE_ACTIVITY_RED_PACK_FOUR = 32;
        public static final int REVENUE_ACTIVITY_RED_PACK_NINE = 37;
        public static final int REVENUE_ACTIVITY_RED_PACK_ONE = 29;
        public static final int REVENUE_ACTIVITY_RED_PACK_SEVEN = 35;
        public static final int REVENUE_ACTIVITY_RED_PACK_SIX = 34;
        public static final int REVENUE_ACTIVITY_RED_PACK_TEN = 38;
        public static final int REVENUE_ACTIVITY_RED_PACK_THREE = 31;
        public static final int REVENUE_ACTIVITY_RED_PACK_TWO = 30;
        public static final int SHARE_RED_PACK = 11;
        public static final int SPRING_FESTIVAL_INTERACTIVE_GIFT_PLAY_RED_PACK = 42;
        public static final int SUPER_DIVERSION_POSITION = 24;
        public static final int SUPER_DIVERSION_POSITION_GIFT_RED_PACK = 27;
        public static final int SUPER_PK_RED_PACK = 23;
        public static final int TASK_PLATFORM_RED_PACK = 22;
        public static final int TREASURE_BOX_RED_PACK = 13;
        public static final int TYPE_UNKNOWN = 0;
    }

    public static final class LiveRedPackIdentity extends MessageNano {
        private static volatile LiveRedPackIdentity[] _emptyArray;
        public long id;
        public int type;

        public static LiveRedPackIdentity[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRedPackIdentity[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRedPackIdentity() {
            clear();
        }

        public final LiveRedPackIdentity clear() {
            this.id = 0L;
            this.type = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.type;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRedPackIdentity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        switch (int32) {
                        }
                    }
                    this.type = int32;
                }
            }
        }

        public static LiveRedPackIdentity parseFrom(byte[] bArr) {
            return (LiveRedPackIdentity) MessageNano.mergeFrom(new LiveRedPackIdentity(), bArr);
        }

        public static LiveRedPackIdentity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRedPackIdentity().mergeFrom(codedInputByteBufferNano);
        }
    }
}
