package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatVoteEnd extends MessageNano {
    private static volatile LiveScoreLineChatVoteEnd[] _emptyArray;
    public long achieveTargetAuthorId;
    public Map<Long, Integer> authorIdToRankState;
    public String penaltyText;
    public UserInfos.PicUrl[] voteEndPicUrl;
    public int voteEndReason;
    public String voteEndText;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RankState {
        public static final int LOSE = 2;
        public static final int TIE = 3;
        public static final int UNKNOWN_RANK = 0;
        public static final int WIN = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VoteEndReason {
        public static final int AUTHOR_ACHIEVE_TARGET = 1;
        public static final int NORMAL_END = 2;
        public static final int UNKNOWN = 0;
    }

    public static LiveScoreLineChatVoteEnd[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatVoteEnd[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatVoteEnd() {
        clear();
    }

    public final LiveScoreLineChatVoteEnd clear() {
        this.penaltyText = "";
        this.voteEndReason = 0;
        this.achieveTargetAuthorId = 0L;
        this.authorIdToRankState = null;
        this.voteEndText = "";
        this.voteEndPicUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.penaltyText.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.penaltyText);
        }
        int i = this.voteEndReason;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        long j = this.achieveTargetAuthorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        Map<Long, Integer> map = this.authorIdToRankState;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 4, 14);
        }
        if (!this.voteEndText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.voteEndText);
        }
        UserInfos.PicUrl[] picUrlArr = this.voteEndPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.voteEndPicUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(6, picUrl);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.penaltyText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.penaltyText);
        }
        int i = this.voteEndReason;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        long j = this.achieveTargetAuthorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        Map<Long, Integer> map = this.authorIdToRankState;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 4, 4, 14);
        }
        if (!this.voteEndText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.voteEndText);
        }
        UserInfos.PicUrl[] picUrlArr = this.voteEndPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.voteEndPicUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatVoteEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.penaltyText = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.voteEndReason = int32;
                }
            } else if (tag == 24) {
                this.achieveTargetAuthorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.authorIdToRankState = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.authorIdToRankState, mapFactory, 4, 14, null, 8, 16);
            } else if (tag == 42) {
                this.voteEndText = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                UserInfos.PicUrl[] picUrlArr = this.voteEndPicUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.voteEndPicUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.voteEndPicUrl = picUrlArr2;
            }
        }
    }

    public static LiveScoreLineChatVoteEnd parseFrom(byte[] bArr) {
        return (LiveScoreLineChatVoteEnd) MessageNano.mergeFrom(new LiveScoreLineChatVoteEnd(), bArr);
    }

    public static LiveScoreLineChatVoteEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatVoteEnd().mergeFrom(codedInputByteBufferNano);
    }
}
