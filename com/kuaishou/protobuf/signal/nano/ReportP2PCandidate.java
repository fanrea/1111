package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ReportP2PCandidate extends MessageNano {
    private static volatile ReportP2PCandidate[] _emptyArray;
    public P2PCandidate[] candidate;

    public static ReportP2PCandidate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportP2PCandidate[0];
                }
            }
        }
        return _emptyArray;
    }

    public ReportP2PCandidate() {
        clear();
    }

    public final ReportP2PCandidate clear() {
        this.candidate = P2PCandidate.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        P2PCandidate[] p2PCandidateArr = this.candidate;
        if (p2PCandidateArr != null && p2PCandidateArr.length > 0) {
            int i = 0;
            while (true) {
                P2PCandidate[] p2PCandidateArr2 = this.candidate;
                if (i >= p2PCandidateArr2.length) {
                    break;
                }
                P2PCandidate p2PCandidate = p2PCandidateArr2[i];
                if (p2PCandidate != null) {
                    codedOutputByteBufferNano.writeMessage(1, p2PCandidate);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        P2PCandidate[] p2PCandidateArr = this.candidate;
        if (p2PCandidateArr != null && p2PCandidateArr.length > 0) {
            int i = 0;
            while (true) {
                P2PCandidate[] p2PCandidateArr2 = this.candidate;
                if (i >= p2PCandidateArr2.length) {
                    break;
                }
                P2PCandidate p2PCandidate = p2PCandidateArr2[i];
                if (p2PCandidate != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, p2PCandidate);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ReportP2PCandidate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                P2PCandidate[] p2PCandidateArr = this.candidate;
                int length = p2PCandidateArr == null ? 0 : p2PCandidateArr.length;
                P2PCandidate[] p2PCandidateArr2 = new P2PCandidate[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.candidate, 0, p2PCandidateArr2, 0, length);
                }
                while (length < p2PCandidateArr2.length - 1) {
                    p2PCandidateArr2[length] = new P2PCandidate();
                    codedInputByteBufferNano.readMessage(p2PCandidateArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                p2PCandidateArr2[length] = new P2PCandidate();
                codedInputByteBufferNano.readMessage(p2PCandidateArr2[length]);
                this.candidate = p2PCandidateArr2;
            }
        }
    }

    public static ReportP2PCandidate parseFrom(byte[] bArr) {
        return (ReportP2PCandidate) MessageNano.mergeFrom(new ReportP2PCandidate(), bArr);
    }

    public static ReportP2PCandidate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ReportP2PCandidate().mergeFrom(codedInputByteBufferNano);
    }
}
