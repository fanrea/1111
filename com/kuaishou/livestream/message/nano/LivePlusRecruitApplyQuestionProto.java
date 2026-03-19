package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePlusRecruitApplyQuestionProto {

    public static final class RecruitQuestionMessageConfig extends MessageNano {
        private static volatile RecruitQuestionMessageConfig[] _emptyArray;
        public RecruitQuestionFeed[] feeds;
        public String frequencyBizId;
        public int interval;

        public static RecruitQuestionMessageConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecruitQuestionMessageConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RecruitQuestionMessageConfig() {
            clear();
        }

        public final RecruitQuestionMessageConfig clear() {
            this.interval = 0;
            this.frequencyBizId = "";
            this.feeds = RecruitQuestionFeed.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.interval;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.frequencyBizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.frequencyBizId);
            }
            RecruitQuestionFeed[] recruitQuestionFeedArr = this.feeds;
            if (recruitQuestionFeedArr != null && recruitQuestionFeedArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RecruitQuestionFeed[] recruitQuestionFeedArr2 = this.feeds;
                    if (i2 >= recruitQuestionFeedArr2.length) {
                        break;
                    }
                    RecruitQuestionFeed recruitQuestionFeed = recruitQuestionFeedArr2[i2];
                    if (recruitQuestionFeed != null) {
                        codedOutputByteBufferNano.writeMessage(3, recruitQuestionFeed);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.interval;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.frequencyBizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.frequencyBizId);
            }
            RecruitQuestionFeed[] recruitQuestionFeedArr = this.feeds;
            if (recruitQuestionFeedArr != null && recruitQuestionFeedArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RecruitQuestionFeed[] recruitQuestionFeedArr2 = this.feeds;
                    if (i2 >= recruitQuestionFeedArr2.length) {
                        break;
                    }
                    RecruitQuestionFeed recruitQuestionFeed = recruitQuestionFeedArr2[i2];
                    if (recruitQuestionFeed != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, recruitQuestionFeed);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RecruitQuestionMessageConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.interval = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.frequencyBizId = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    RecruitQuestionFeed[] recruitQuestionFeedArr = this.feeds;
                    int length = recruitQuestionFeedArr == null ? 0 : recruitQuestionFeedArr.length;
                    RecruitQuestionFeed[] recruitQuestionFeedArr2 = new RecruitQuestionFeed[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.feeds, 0, recruitQuestionFeedArr2, 0, length);
                    }
                    while (length < recruitQuestionFeedArr2.length - 1) {
                        recruitQuestionFeedArr2[length] = new RecruitQuestionFeed();
                        codedInputByteBufferNano.readMessage(recruitQuestionFeedArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    recruitQuestionFeedArr2[length] = new RecruitQuestionFeed();
                    codedInputByteBufferNano.readMessage(recruitQuestionFeedArr2[length]);
                    this.feeds = recruitQuestionFeedArr2;
                }
            }
        }

        public static RecruitQuestionMessageConfig parseFrom(byte[] bArr) {
            return (RecruitQuestionMessageConfig) MessageNano.mergeFrom(new RecruitQuestionMessageConfig(), bArr);
        }

        public static RecruitQuestionMessageConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RecruitQuestionMessageConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RecruitQuestionFeed extends MessageNano {
        private static volatile RecruitQuestionFeed[] _emptyArray;
        public String buttonContent;
        public String buttonRouter;
        public String content;
        public String prefix;

        public static RecruitQuestionFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecruitQuestionFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RecruitQuestionFeed() {
            clear();
        }

        public final RecruitQuestionFeed clear() {
            this.prefix = "";
            this.content = "";
            this.buttonContent = "";
            this.buttonRouter = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.prefix.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.prefix);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.content);
            }
            if (!this.buttonContent.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.buttonContent);
            }
            if (!this.buttonRouter.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.buttonRouter);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.prefix.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.prefix);
            }
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.content);
            }
            if (!this.buttonContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.buttonContent);
            }
            return !this.buttonRouter.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.buttonRouter) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RecruitQuestionFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.prefix = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.content = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.buttonContent = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.buttonRouter = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RecruitQuestionFeed parseFrom(byte[] bArr) {
            return (RecruitQuestionFeed) MessageNano.mergeFrom(new RecruitQuestionFeed(), bArr);
        }

        public static RecruitQuestionFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RecruitQuestionFeed().mergeFrom(codedInputByteBufferNano);
        }
    }
}
