package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePullRequestProto {

    public static final class SCLivePullRequest extends MessageNano {
        private static volatile SCLivePullRequest[] _emptyArray;
        public String bizInfo;
        public String requestDomainName;
        public long requestLatestTimestamp;
        public String requestUri;

        public static SCLivePullRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLivePullRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLivePullRequest() {
            clear();
        }

        public final SCLivePullRequest clear() {
            this.requestLatestTimestamp = 0L;
            this.bizInfo = "";
            this.requestUri = "";
            this.requestDomainName = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.requestLatestTimestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.bizInfo.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bizInfo);
            }
            if (!this.requestUri.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.requestUri);
            }
            if (!this.requestDomainName.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.requestDomainName);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.requestLatestTimestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.bizInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizInfo);
            }
            if (!this.requestUri.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.requestUri);
            }
            return !this.requestDomainName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.requestDomainName) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLivePullRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.requestLatestTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.bizInfo = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.requestUri = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.requestDomainName = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLivePullRequest parseFrom(byte[] bArr) {
            return (SCLivePullRequest) MessageNano.mergeFrom(new SCLivePullRequest(), bArr);
        }

        public static SCLivePullRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLivePullRequest().mergeFrom(codedInputByteBufferNano);
        }
    }
}
