package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveGuideReportInfoLogExtra extends MessageNano {
    private static volatile InteractiveGuideReportInfoLogExtra[] _emptyArray;
    public String encryptInviteeLiveStreamId;
    public long inviteeAuthorId;
    public long inviteeLiveStreamId;
    public long llsid;

    public static InteractiveGuideReportInfoLogExtra[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveGuideReportInfoLogExtra[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveGuideReportInfoLogExtra() {
        clear();
    }

    public final InteractiveGuideReportInfoLogExtra clear() {
        this.llsid = 0L;
        this.inviteeAuthorId = 0L;
        this.encryptInviteeLiveStreamId = "";
        this.inviteeLiveStreamId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.llsid;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.inviteeAuthorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        if (!this.encryptInviteeLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.encryptInviteeLiveStreamId);
        }
        long j3 = this.inviteeLiveStreamId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.llsid;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.inviteeAuthorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        if (!this.encryptInviteeLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.encryptInviteeLiveStreamId);
        }
        long j3 = this.inviteeLiveStreamId;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveGuideReportInfoLogExtra mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.llsid = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.inviteeAuthorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.encryptInviteeLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.inviteeLiveStreamId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static InteractiveGuideReportInfoLogExtra parseFrom(byte[] bArr) {
        return (InteractiveGuideReportInfoLogExtra) MessageNano.mergeFrom(new InteractiveGuideReportInfoLogExtra(), bArr);
    }

    public static InteractiveGuideReportInfoLogExtra parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveGuideReportInfoLogExtra().mergeFrom(codedInputByteBufferNano);
    }
}
