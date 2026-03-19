package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TeamStatisticInfo extends MessageNano {
    private static volatile TeamStatisticInfo[] _emptyArray;
    public long score;
    public int team;
    public TeamPkTopUser[] topUser;

    public static TeamStatisticInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TeamStatisticInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public TeamStatisticInfo() {
        clear();
    }

    public final TeamStatisticInfo clear() {
        this.team = 0;
        this.score = 0L;
        this.topUser = TeamPkTopUser.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.team;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.score;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        TeamPkTopUser[] teamPkTopUserArr = this.topUser;
        if (teamPkTopUserArr != null && teamPkTopUserArr.length > 0) {
            int i2 = 0;
            while (true) {
                TeamPkTopUser[] teamPkTopUserArr2 = this.topUser;
                if (i2 >= teamPkTopUserArr2.length) {
                    break;
                }
                TeamPkTopUser teamPkTopUser = teamPkTopUserArr2[i2];
                if (teamPkTopUser != null) {
                    codedOutputByteBufferNano.writeMessage(3, teamPkTopUser);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.team;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.score;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        TeamPkTopUser[] teamPkTopUserArr = this.topUser;
        if (teamPkTopUserArr != null && teamPkTopUserArr.length > 0) {
            int i2 = 0;
            while (true) {
                TeamPkTopUser[] teamPkTopUserArr2 = this.topUser;
                if (i2 >= teamPkTopUserArr2.length) {
                    break;
                }
                TeamPkTopUser teamPkTopUser = teamPkTopUserArr2[i2];
                if (teamPkTopUser != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, teamPkTopUser);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TeamStatisticInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.team = int32;
                }
            } else if (tag == 16) {
                this.score = codedInputByteBufferNano.readUInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                TeamPkTopUser[] teamPkTopUserArr = this.topUser;
                int length = teamPkTopUserArr == null ? 0 : teamPkTopUserArr.length;
                TeamPkTopUser[] teamPkTopUserArr2 = new TeamPkTopUser[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.topUser, 0, teamPkTopUserArr2, 0, length);
                }
                while (length < teamPkTopUserArr2.length - 1) {
                    teamPkTopUserArr2[length] = new TeamPkTopUser();
                    codedInputByteBufferNano.readMessage(teamPkTopUserArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                teamPkTopUserArr2[length] = new TeamPkTopUser();
                codedInputByteBufferNano.readMessage(teamPkTopUserArr2[length]);
                this.topUser = teamPkTopUserArr2;
            }
        }
    }

    public static TeamStatisticInfo parseFrom(byte[] bArr) {
        return (TeamStatisticInfo) MessageNano.mergeFrom(new TeamStatisticInfo(), bArr);
    }

    public static TeamStatisticInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TeamStatisticInfo().mergeFrom(codedInputByteBufferNano);
    }
}
