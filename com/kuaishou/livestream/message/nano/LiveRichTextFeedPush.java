package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveStreamRichTextFeed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRichTextFeedPush {

    public static final class SCLiveRichTextFeedPush extends MessageNano {
        private static volatile SCLiveRichTextFeedPush[] _emptyArray;
        public LiveStreamRichTextFeed.RichTextFeed[] richTextFeed;

        public static SCLiveRichTextFeedPush[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRichTextFeedPush[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRichTextFeedPush() {
            clear();
        }

        public final SCLiveRichTextFeedPush clear() {
            this.richTextFeed = LiveStreamRichTextFeed.RichTextFeed.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeed;
            if (richTextFeedArr != null && richTextFeedArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = this.richTextFeed;
                    if (i >= richTextFeedArr2.length) {
                        break;
                    }
                    LiveStreamRichTextFeed.RichTextFeed richTextFeed = richTextFeedArr2[i];
                    if (richTextFeed != null) {
                        codedOutputByteBufferNano.writeMessage(1, richTextFeed);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeed;
            if (richTextFeedArr != null && richTextFeedArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = this.richTextFeed;
                    if (i >= richTextFeedArr2.length) {
                        break;
                    }
                    LiveStreamRichTextFeed.RichTextFeed richTextFeed = richTextFeedArr2[i];
                    if (richTextFeed != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, richTextFeed);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRichTextFeedPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeed;
                    int length = richTextFeedArr == null ? 0 : richTextFeedArr.length;
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = new LiveStreamRichTextFeed.RichTextFeed[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.richTextFeed, 0, richTextFeedArr2, 0, length);
                    }
                    while (length < richTextFeedArr2.length - 1) {
                        richTextFeedArr2[length] = new LiveStreamRichTextFeed.RichTextFeed();
                        codedInputByteBufferNano.readMessage(richTextFeedArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    richTextFeedArr2[length] = new LiveStreamRichTextFeed.RichTextFeed();
                    codedInputByteBufferNano.readMessage(richTextFeedArr2[length]);
                    this.richTextFeed = richTextFeedArr2;
                }
            }
        }

        public static SCLiveRichTextFeedPush parseFrom(byte[] bArr) {
            return (SCLiveRichTextFeedPush) MessageNano.mergeFrom(new SCLiveRichTextFeedPush(), bArr);
        }

        public static SCLiveRichTextFeedPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRichTextFeedPush().mergeFrom(codedInputByteBufferNano);
        }
    }
}
