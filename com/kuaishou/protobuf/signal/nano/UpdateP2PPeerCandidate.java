package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UpdateP2PPeerCandidate extends MessageNano {
    private static volatile UpdateP2PPeerCandidate[] _emptyArray;
    public int[] p2PSessionId;
    public P2PCandidate[] targetCandidate;
    public JoinRoomParticipant targetParticipant;

    public static UpdateP2PPeerCandidate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdateP2PPeerCandidate[0];
                }
            }
        }
        return _emptyArray;
    }

    public UpdateP2PPeerCandidate() {
        clear();
    }

    public final UpdateP2PPeerCandidate clear() {
        this.targetCandidate = P2PCandidate.emptyArray();
        this.targetParticipant = null;
        this.p2PSessionId = WireFormatNano.EMPTY_INT_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        P2PCandidate[] p2PCandidateArr = this.targetCandidate;
        int i = 0;
        if (p2PCandidateArr != null && p2PCandidateArr.length > 0) {
            int i2 = 0;
            while (true) {
                P2PCandidate[] p2PCandidateArr2 = this.targetCandidate;
                if (i2 >= p2PCandidateArr2.length) {
                    break;
                }
                P2PCandidate p2PCandidate = p2PCandidateArr2[i2];
                if (p2PCandidate != null) {
                    codedOutputByteBufferNano.writeMessage(1, p2PCandidate);
                }
                i2++;
            }
        }
        JoinRoomParticipant joinRoomParticipant = this.targetParticipant;
        if (joinRoomParticipant != null) {
            codedOutputByteBufferNano.writeMessage(2, joinRoomParticipant);
        }
        int[] iArr = this.p2PSessionId;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.p2PSessionId;
                if (i >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr2[i]);
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        P2PCandidate[] p2PCandidateArr = this.targetCandidate;
        int i = 0;
        if (p2PCandidateArr != null && p2PCandidateArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                P2PCandidate[] p2PCandidateArr2 = this.targetCandidate;
                if (i2 >= p2PCandidateArr2.length) {
                    break;
                }
                P2PCandidate p2PCandidate = p2PCandidateArr2[i2];
                if (p2PCandidate != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, p2PCandidate);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        JoinRoomParticipant joinRoomParticipant = this.targetParticipant;
        if (joinRoomParticipant != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, joinRoomParticipant);
        }
        int[] iArr = this.p2PSessionId;
        if (iArr == null || iArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeUInt32SizeNoTag = 0;
        while (true) {
            int[] iArr2 = this.p2PSessionId;
            if (i < iArr2.length) {
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i]);
                i++;
            } else {
                return iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UpdateP2PPeerCandidate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                P2PCandidate[] p2PCandidateArr = this.targetCandidate;
                int length = p2PCandidateArr == null ? 0 : p2PCandidateArr.length;
                P2PCandidate[] p2PCandidateArr2 = new P2PCandidate[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.targetCandidate, 0, p2PCandidateArr2, 0, length);
                }
                while (length < p2PCandidateArr2.length - 1) {
                    p2PCandidateArr2[length] = new P2PCandidate();
                    codedInputByteBufferNano.readMessage(p2PCandidateArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                p2PCandidateArr2[length] = new P2PCandidate();
                codedInputByteBufferNano.readMessage(p2PCandidateArr2[length]);
                this.targetCandidate = p2PCandidateArr2;
            } else if (tag == 18) {
                if (this.targetParticipant == null) {
                    this.targetParticipant = new JoinRoomParticipant();
                }
                codedInputByteBufferNano.readMessage(this.targetParticipant);
            } else if (tag == 24) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                int[] iArr = this.p2PSessionId;
                int length2 = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.p2PSessionId, 0, iArr2, 0, length2);
                }
                while (length2 < iArr2.length - 1) {
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                iArr2[length2] = codedInputByteBufferNano.readUInt32();
                this.p2PSessionId = iArr2;
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.p2PSessionId;
                int length3 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length3];
                if (length3 != 0) {
                    System.arraycopy(this.p2PSessionId, 0, iArr4, 0, length3);
                }
                while (length3 < iArr4.length) {
                    iArr4[length3] = codedInputByteBufferNano.readUInt32();
                    length3++;
                }
                this.p2PSessionId = iArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            }
        }
    }

    public static UpdateP2PPeerCandidate parseFrom(byte[] bArr) {
        return (UpdateP2PPeerCandidate) MessageNano.mergeFrom(new UpdateP2PPeerCandidate(), bArr);
    }

    public static UpdateP2PPeerCandidate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UpdateP2PPeerCandidate().mergeFrom(codedInputByteBufferNano);
    }
}
