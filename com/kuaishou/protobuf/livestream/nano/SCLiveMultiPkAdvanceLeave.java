package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkAdvanceLeave extends MessageNano {
    private static volatile SCLiveMultiPkAdvanceLeave[] _emptyArray;
    public String pkId;
    public LiveMultiPkTeamUpdateInfo[] teamUpdateInfo;
    public long teamVersion;

    public static SCLiveMultiPkAdvanceLeave[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkAdvanceLeave[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkAdvanceLeave() {
        clear();
    }

    public final SCLiveMultiPkAdvanceLeave clear() {
        this.pkId = "";
        this.teamUpdateInfo = LiveMultiPkTeamUpdateInfo.emptyArray();
        this.teamVersion = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        LiveMultiPkTeamUpdateInfo[] liveMultiPkTeamUpdateInfoArr = this.teamUpdateInfo;
        if (liveMultiPkTeamUpdateInfoArr != null && liveMultiPkTeamUpdateInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveMultiPkTeamUpdateInfo[] liveMultiPkTeamUpdateInfoArr2 = this.teamUpdateInfo;
                if (i >= liveMultiPkTeamUpdateInfoArr2.length) {
                    break;
                }
                LiveMultiPkTeamUpdateInfo liveMultiPkTeamUpdateInfo = liveMultiPkTeamUpdateInfoArr2[i];
                if (liveMultiPkTeamUpdateInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, liveMultiPkTeamUpdateInfo);
                }
                i++;
            }
        }
        long j = this.teamVersion;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        LiveMultiPkTeamUpdateInfo[] liveMultiPkTeamUpdateInfoArr = this.teamUpdateInfo;
        if (liveMultiPkTeamUpdateInfoArr != null && liveMultiPkTeamUpdateInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveMultiPkTeamUpdateInfo[] liveMultiPkTeamUpdateInfoArr2 = this.teamUpdateInfo;
                if (i >= liveMultiPkTeamUpdateInfoArr2.length) {
                    break;
                }
                LiveMultiPkTeamUpdateInfo liveMultiPkTeamUpdateInfo = liveMultiPkTeamUpdateInfoArr2[i];
                if (liveMultiPkTeamUpdateInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveMultiPkTeamUpdateInfo);
                }
                i++;
            }
        }
        long j = this.teamVersion;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkAdvanceLeave mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LiveMultiPkTeamUpdateInfo[] liveMultiPkTeamUpdateInfoArr = this.teamUpdateInfo;
                int length = liveMultiPkTeamUpdateInfoArr == null ? 0 : liveMultiPkTeamUpdateInfoArr.length;
                LiveMultiPkTeamUpdateInfo[] liveMultiPkTeamUpdateInfoArr2 = new LiveMultiPkTeamUpdateInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.teamUpdateInfo, 0, liveMultiPkTeamUpdateInfoArr2, 0, length);
                }
                while (length < liveMultiPkTeamUpdateInfoArr2.length - 1) {
                    liveMultiPkTeamUpdateInfoArr2[length] = new LiveMultiPkTeamUpdateInfo();
                    codedInputByteBufferNano.readMessage(liveMultiPkTeamUpdateInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveMultiPkTeamUpdateInfoArr2[length] = new LiveMultiPkTeamUpdateInfo();
                codedInputByteBufferNano.readMessage(liveMultiPkTeamUpdateInfoArr2[length]);
                this.teamUpdateInfo = liveMultiPkTeamUpdateInfoArr2;
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.teamVersion = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveMultiPkAdvanceLeave parseFrom(byte[] bArr) {
        return (SCLiveMultiPkAdvanceLeave) MessageNano.mergeFrom(new SCLiveMultiPkAdvanceLeave(), bArr);
    }

    public static SCLiveMultiPkAdvanceLeave parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkAdvanceLeave().mergeFrom(codedInputByteBufferNano);
    }
}
