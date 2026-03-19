package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyPkTeamStatistic extends MessageNano {
    private static volatile LiveVoicePartyPkTeamStatistic[] _emptyArray;
    public UserInfos.UserInfo author;
    public String liveStreamId;
    public long score;
    public int teamType;
    public LiveVoicePartyPkTopContributor[] topContributor;
    public LiveVoicePartyPkUserStatistic[] userStatisticInfo;

    public static LiveVoicePartyPkTeamStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyPkTeamStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyPkTeamStatistic() {
        clear();
    }

    public final LiveVoicePartyPkTeamStatistic clear() {
        this.author = null;
        this.liveStreamId = "";
        this.teamType = 0;
        this.score = 0L;
        this.topContributor = LiveVoicePartyPkTopContributor.emptyArray();
        this.userStatisticInfo = LiveVoicePartyPkUserStatistic.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.author;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        int i = this.teamType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        long j = this.score;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        LiveVoicePartyPkTopContributor[] liveVoicePartyPkTopContributorArr = this.topContributor;
        int i2 = 0;
        if (liveVoicePartyPkTopContributorArr != null && liveVoicePartyPkTopContributorArr.length > 0) {
            int i3 = 0;
            while (true) {
                LiveVoicePartyPkTopContributor[] liveVoicePartyPkTopContributorArr2 = this.topContributor;
                if (i3 >= liveVoicePartyPkTopContributorArr2.length) {
                    break;
                }
                LiveVoicePartyPkTopContributor liveVoicePartyPkTopContributor = liveVoicePartyPkTopContributorArr2[i3];
                if (liveVoicePartyPkTopContributor != null) {
                    codedOutputByteBufferNano.writeMessage(5, liveVoicePartyPkTopContributor);
                }
                i3++;
            }
        }
        LiveVoicePartyPkUserStatistic[] liveVoicePartyPkUserStatisticArr = this.userStatisticInfo;
        if (liveVoicePartyPkUserStatisticArr != null && liveVoicePartyPkUserStatisticArr.length > 0) {
            while (true) {
                LiveVoicePartyPkUserStatistic[] liveVoicePartyPkUserStatisticArr2 = this.userStatisticInfo;
                if (i2 >= liveVoicePartyPkUserStatisticArr2.length) {
                    break;
                }
                LiveVoicePartyPkUserStatistic liveVoicePartyPkUserStatistic = liveVoicePartyPkUserStatisticArr2[i2];
                if (liveVoicePartyPkUserStatistic != null) {
                    codedOutputByteBufferNano.writeMessage(6, liveVoicePartyPkUserStatistic);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.author;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        int i = this.teamType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        long j = this.score;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        LiveVoicePartyPkTopContributor[] liveVoicePartyPkTopContributorArr = this.topContributor;
        int i2 = 0;
        if (liveVoicePartyPkTopContributorArr != null && liveVoicePartyPkTopContributorArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                LiveVoicePartyPkTopContributor[] liveVoicePartyPkTopContributorArr2 = this.topContributor;
                if (i3 >= liveVoicePartyPkTopContributorArr2.length) {
                    break;
                }
                LiveVoicePartyPkTopContributor liveVoicePartyPkTopContributor = liveVoicePartyPkTopContributorArr2[i3];
                if (liveVoicePartyPkTopContributor != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, liveVoicePartyPkTopContributor);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveVoicePartyPkUserStatistic[] liveVoicePartyPkUserStatisticArr = this.userStatisticInfo;
        if (liveVoicePartyPkUserStatisticArr != null && liveVoicePartyPkUserStatisticArr.length > 0) {
            while (true) {
                LiveVoicePartyPkUserStatistic[] liveVoicePartyPkUserStatisticArr2 = this.userStatisticInfo;
                if (i2 >= liveVoicePartyPkUserStatisticArr2.length) {
                    break;
                }
                LiveVoicePartyPkUserStatistic liveVoicePartyPkUserStatistic = liveVoicePartyPkUserStatisticArr2[i2];
                if (liveVoicePartyPkUserStatistic != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveVoicePartyPkUserStatistic);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyPkTeamStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.author == null) {
                    this.author = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.author);
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.teamType = int32;
                }
            } else if (tag == 32) {
                this.score = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                LiveVoicePartyPkTopContributor[] liveVoicePartyPkTopContributorArr = this.topContributor;
                int length = liveVoicePartyPkTopContributorArr == null ? 0 : liveVoicePartyPkTopContributorArr.length;
                LiveVoicePartyPkTopContributor[] liveVoicePartyPkTopContributorArr2 = new LiveVoicePartyPkTopContributor[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.topContributor, 0, liveVoicePartyPkTopContributorArr2, 0, length);
                }
                while (length < liveVoicePartyPkTopContributorArr2.length - 1) {
                    liveVoicePartyPkTopContributorArr2[length] = new LiveVoicePartyPkTopContributor();
                    codedInputByteBufferNano.readMessage(liveVoicePartyPkTopContributorArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveVoicePartyPkTopContributorArr2[length] = new LiveVoicePartyPkTopContributor();
                codedInputByteBufferNano.readMessage(liveVoicePartyPkTopContributorArr2[length]);
                this.topContributor = liveVoicePartyPkTopContributorArr2;
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                LiveVoicePartyPkUserStatistic[] liveVoicePartyPkUserStatisticArr = this.userStatisticInfo;
                int length2 = liveVoicePartyPkUserStatisticArr == null ? 0 : liveVoicePartyPkUserStatisticArr.length;
                LiveVoicePartyPkUserStatistic[] liveVoicePartyPkUserStatisticArr2 = new LiveVoicePartyPkUserStatistic[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.userStatisticInfo, 0, liveVoicePartyPkUserStatisticArr2, 0, length2);
                }
                while (length2 < liveVoicePartyPkUserStatisticArr2.length - 1) {
                    liveVoicePartyPkUserStatisticArr2[length2] = new LiveVoicePartyPkUserStatistic();
                    codedInputByteBufferNano.readMessage(liveVoicePartyPkUserStatisticArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                liveVoicePartyPkUserStatisticArr2[length2] = new LiveVoicePartyPkUserStatistic();
                codedInputByteBufferNano.readMessage(liveVoicePartyPkUserStatisticArr2[length2]);
                this.userStatisticInfo = liveVoicePartyPkUserStatisticArr2;
            }
        }
    }

    public static LiveVoicePartyPkTeamStatistic parseFrom(byte[] bArr) {
        return (LiveVoicePartyPkTeamStatistic) MessageNano.mergeFrom(new LiveVoicePartyPkTeamStatistic(), bArr);
    }

    public static LiveVoicePartyPkTeamStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyPkTeamStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
