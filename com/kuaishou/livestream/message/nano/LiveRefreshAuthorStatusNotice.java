package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveRefreshAuthorStatusNotice extends MessageNano {
    private static volatile LiveRefreshAuthorStatusNotice[] _emptyArray;
    public long authorId;
    public boolean expired;
    public LiveCdnNodeView[] headWidgetCdnNodeView;
    public String uniqueKey;

    public static LiveRefreshAuthorStatusNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveRefreshAuthorStatusNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveRefreshAuthorStatusNotice() {
        clear();
    }

    public final LiveRefreshAuthorStatusNotice clear() {
        this.authorId = 0L;
        this.headWidgetCdnNodeView = LiveCdnNodeView.emptyArray();
        this.uniqueKey = "";
        this.expired = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.headWidgetCdnNodeView;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.headWidgetCdnNodeView;
                if (i >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                if (liveCdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(2, liveCdnNodeView);
                }
                i++;
            }
        }
        if (!this.uniqueKey.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.uniqueKey);
        }
        boolean z = this.expired;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.headWidgetCdnNodeView;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.headWidgetCdnNodeView;
                if (i >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                if (liveCdnNodeView != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveCdnNodeView);
                }
                i++;
            }
        }
        if (!this.uniqueKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.uniqueKey);
        }
        boolean z = this.expired;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveRefreshAuthorStatusNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LiveCdnNodeView[] liveCdnNodeViewArr = this.headWidgetCdnNodeView;
                int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.headWidgetCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                }
                while (length < liveCdnNodeViewArr2.length - 1) {
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                this.headWidgetCdnNodeView = liveCdnNodeViewArr2;
            } else if (tag == 26) {
                this.uniqueKey = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.expired = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveRefreshAuthorStatusNotice parseFrom(byte[] bArr) {
        return (LiveRefreshAuthorStatusNotice) MessageNano.mergeFrom(new LiveRefreshAuthorStatusNotice(), bArr);
    }

    public static LiveRefreshAuthorStatusNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveRefreshAuthorStatusNotice().mergeFrom(codedInputByteBufferNano);
    }
}
