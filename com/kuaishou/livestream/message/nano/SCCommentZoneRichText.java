package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichTextMessage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCCommentZoneRichText extends MessageNano {
    private static volatile SCCommentZoneRichText[] _emptyArray;
    public LiveCommentRichTextMessage.CommentRichTextMessage[] message;

    public static SCCommentZoneRichText[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCCommentZoneRichText[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCCommentZoneRichText() {
        clear();
    }

    public final SCCommentZoneRichText clear() {
        this.message = LiveCommentRichTextMessage.CommentRichTextMessage.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveCommentRichTextMessage.CommentRichTextMessage[] commentRichTextMessageArr = this.message;
        if (commentRichTextMessageArr != null && commentRichTextMessageArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCommentRichTextMessage.CommentRichTextMessage[] commentRichTextMessageArr2 = this.message;
                if (i >= commentRichTextMessageArr2.length) {
                    break;
                }
                LiveCommentRichTextMessage.CommentRichTextMessage commentRichTextMessage = commentRichTextMessageArr2[i];
                if (commentRichTextMessage != null) {
                    codedOutputByteBufferNano.writeMessage(1, commentRichTextMessage);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveCommentRichTextMessage.CommentRichTextMessage[] commentRichTextMessageArr = this.message;
        if (commentRichTextMessageArr != null && commentRichTextMessageArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCommentRichTextMessage.CommentRichTextMessage[] commentRichTextMessageArr2 = this.message;
                if (i >= commentRichTextMessageArr2.length) {
                    break;
                }
                LiveCommentRichTextMessage.CommentRichTextMessage commentRichTextMessage = commentRichTextMessageArr2[i];
                if (commentRichTextMessage != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, commentRichTextMessage);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCCommentZoneRichText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                LiveCommentRichTextMessage.CommentRichTextMessage[] commentRichTextMessageArr = this.message;
                int length = commentRichTextMessageArr == null ? 0 : commentRichTextMessageArr.length;
                LiveCommentRichTextMessage.CommentRichTextMessage[] commentRichTextMessageArr2 = new LiveCommentRichTextMessage.CommentRichTextMessage[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.message, 0, commentRichTextMessageArr2, 0, length);
                }
                while (length < commentRichTextMessageArr2.length - 1) {
                    commentRichTextMessageArr2[length] = new LiveCommentRichTextMessage.CommentRichTextMessage();
                    codedInputByteBufferNano.readMessage(commentRichTextMessageArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                commentRichTextMessageArr2[length] = new LiveCommentRichTextMessage.CommentRichTextMessage();
                codedInputByteBufferNano.readMessage(commentRichTextMessageArr2[length]);
                this.message = commentRichTextMessageArr2;
            }
        }
    }

    public static SCCommentZoneRichText parseFrom(byte[] bArr) {
        return (SCCommentZoneRichText) MessageNano.mergeFrom(new SCCommentZoneRichText(), bArr);
    }

    public static SCCommentZoneRichText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCCommentZoneRichText().mergeFrom(codedInputByteBufferNano);
    }
}
