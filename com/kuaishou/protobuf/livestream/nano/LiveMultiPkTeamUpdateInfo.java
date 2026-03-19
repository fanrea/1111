package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkTeamUpdateInfo extends MessageNano {
    private static volatile LiveMultiPkTeamUpdateInfo[] _emptyArray;
    public int teamId;
    public LiveMultiPkTeamMemberUpdateInfo[] teamMemberUpdateInfo;

    public static LiveMultiPkTeamUpdateInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkTeamUpdateInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkTeamUpdateInfo() {
        clear();
    }

    public final LiveMultiPkTeamUpdateInfo clear() {
        this.teamId = 0;
        this.teamMemberUpdateInfo = LiveMultiPkTeamMemberUpdateInfo.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.teamId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        LiveMultiPkTeamMemberUpdateInfo[] liveMultiPkTeamMemberUpdateInfoArr = this.teamMemberUpdateInfo;
        if (liveMultiPkTeamMemberUpdateInfoArr != null && liveMultiPkTeamMemberUpdateInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeamMemberUpdateInfo[] liveMultiPkTeamMemberUpdateInfoArr2 = this.teamMemberUpdateInfo;
                if (i2 >= liveMultiPkTeamMemberUpdateInfoArr2.length) {
                    break;
                }
                LiveMultiPkTeamMemberUpdateInfo liveMultiPkTeamMemberUpdateInfo = liveMultiPkTeamMemberUpdateInfoArr2[i2];
                if (liveMultiPkTeamMemberUpdateInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, liveMultiPkTeamMemberUpdateInfo);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.teamId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        LiveMultiPkTeamMemberUpdateInfo[] liveMultiPkTeamMemberUpdateInfoArr = this.teamMemberUpdateInfo;
        if (liveMultiPkTeamMemberUpdateInfoArr != null && liveMultiPkTeamMemberUpdateInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeamMemberUpdateInfo[] liveMultiPkTeamMemberUpdateInfoArr2 = this.teamMemberUpdateInfo;
                if (i2 >= liveMultiPkTeamMemberUpdateInfoArr2.length) {
                    break;
                }
                LiveMultiPkTeamMemberUpdateInfo liveMultiPkTeamMemberUpdateInfo = liveMultiPkTeamMemberUpdateInfoArr2[i2];
                if (liveMultiPkTeamMemberUpdateInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveMultiPkTeamMemberUpdateInfo);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkTeamUpdateInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.teamId = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LiveMultiPkTeamMemberUpdateInfo[] liveMultiPkTeamMemberUpdateInfoArr = this.teamMemberUpdateInfo;
                int length = liveMultiPkTeamMemberUpdateInfoArr == null ? 0 : liveMultiPkTeamMemberUpdateInfoArr.length;
                LiveMultiPkTeamMemberUpdateInfo[] liveMultiPkTeamMemberUpdateInfoArr2 = new LiveMultiPkTeamMemberUpdateInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.teamMemberUpdateInfo, 0, liveMultiPkTeamMemberUpdateInfoArr2, 0, length);
                }
                while (length < liveMultiPkTeamMemberUpdateInfoArr2.length - 1) {
                    liveMultiPkTeamMemberUpdateInfoArr2[length] = new LiveMultiPkTeamMemberUpdateInfo();
                    codedInputByteBufferNano.readMessage(liveMultiPkTeamMemberUpdateInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveMultiPkTeamMemberUpdateInfoArr2[length] = new LiveMultiPkTeamMemberUpdateInfo();
                codedInputByteBufferNano.readMessage(liveMultiPkTeamMemberUpdateInfoArr2[length]);
                this.teamMemberUpdateInfo = liveMultiPkTeamMemberUpdateInfoArr2;
            }
        }
    }

    public static LiveMultiPkTeamUpdateInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkTeamUpdateInfo) MessageNano.mergeFrom(new LiveMultiPkTeamUpdateInfo(), bArr);
    }

    public static LiveMultiPkTeamUpdateInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkTeamUpdateInfo().mergeFrom(codedInputByteBufferNano);
    }
}
