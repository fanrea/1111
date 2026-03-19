package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveScoreLineChatStatistic extends MessageNano {
    private static volatile SCLiveScoreLineChatStatistic[] _emptyArray;
    public int giftId;
    public String scoreLineChatId;
    public int scoreType;
    public LiveScoreLineChatTeam[] team;
    public long time;
    public long version;

    public static SCLiveScoreLineChatStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveScoreLineChatStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveScoreLineChatStatistic() {
        clear();
    }

    public final SCLiveScoreLineChatStatistic clear() {
        this.scoreLineChatId = "";
        this.scoreType = 0;
        this.time = 0L;
        this.team = LiveScoreLineChatTeam.emptyArray();
        this.giftId = 0;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.scoreLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.scoreLineChatId);
        }
        int i = this.scoreType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        LiveScoreLineChatTeam[] liveScoreLineChatTeamArr = this.team;
        if (liveScoreLineChatTeamArr != null && liveScoreLineChatTeamArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveScoreLineChatTeam[] liveScoreLineChatTeamArr2 = this.team;
                if (i2 >= liveScoreLineChatTeamArr2.length) {
                    break;
                }
                LiveScoreLineChatTeam liveScoreLineChatTeam = liveScoreLineChatTeamArr2[i2];
                if (liveScoreLineChatTeam != null) {
                    codedOutputByteBufferNano.writeMessage(4, liveScoreLineChatTeam);
                }
                i2++;
            }
        }
        int i3 = this.giftId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        long j2 = this.version;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.scoreLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.scoreLineChatId);
        }
        int i = this.scoreType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        LiveScoreLineChatTeam[] liveScoreLineChatTeamArr = this.team;
        if (liveScoreLineChatTeamArr != null && liveScoreLineChatTeamArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveScoreLineChatTeam[] liveScoreLineChatTeamArr2 = this.team;
                if (i2 >= liveScoreLineChatTeamArr2.length) {
                    break;
                }
                LiveScoreLineChatTeam liveScoreLineChatTeam = liveScoreLineChatTeamArr2[i2];
                if (liveScoreLineChatTeam != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveScoreLineChatTeam);
                }
                i2++;
            }
        }
        int i3 = this.giftId;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        long j2 = this.version;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveScoreLineChatStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.scoreLineChatId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.scoreType = int32;
                }
            } else if (tag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                LiveScoreLineChatTeam[] liveScoreLineChatTeamArr = this.team;
                int length = liveScoreLineChatTeamArr == null ? 0 : liveScoreLineChatTeamArr.length;
                LiveScoreLineChatTeam[] liveScoreLineChatTeamArr2 = new LiveScoreLineChatTeam[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.team, 0, liveScoreLineChatTeamArr2, 0, length);
                }
                while (length < liveScoreLineChatTeamArr2.length - 1) {
                    liveScoreLineChatTeamArr2[length] = new LiveScoreLineChatTeam();
                    codedInputByteBufferNano.readMessage(liveScoreLineChatTeamArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveScoreLineChatTeamArr2[length] = new LiveScoreLineChatTeam();
                codedInputByteBufferNano.readMessage(liveScoreLineChatTeamArr2[length]);
                this.team = liveScoreLineChatTeamArr2;
            } else if (tag == 40) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveScoreLineChatStatistic parseFrom(byte[] bArr) {
        return (SCLiveScoreLineChatStatistic) MessageNano.mergeFrom(new SCLiveScoreLineChatStatistic(), bArr);
    }

    public static SCLiveScoreLineChatStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveScoreLineChatStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
