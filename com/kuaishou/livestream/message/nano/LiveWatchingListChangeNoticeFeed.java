package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveWatchingListChangeNoticeFeed extends MessageNano {
    private static volatile LiveWatchingListChangeNoticeFeed[] _emptyArray;
    public String displayUserName;
    public String id;
    public boolean needFold;
    public String noticeText;

    public static LiveWatchingListChangeNoticeFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveWatchingListChangeNoticeFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveWatchingListChangeNoticeFeed() {
        clear();
    }

    public final LiveWatchingListChangeNoticeFeed clear() {
        this.noticeText = "";
        this.needFold = false;
        this.id = "";
        this.displayUserName = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.noticeText.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.noticeText);
        }
        boolean z = this.needFold;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.id);
        }
        if (!this.displayUserName.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayUserName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.noticeText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.noticeText);
        }
        boolean z = this.needFold;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.id);
        }
        return !this.displayUserName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.displayUserName) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveWatchingListChangeNoticeFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.noticeText = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.needFold = codedInputByteBufferNano.readBool();
            } else if (tag == 26) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayUserName = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveWatchingListChangeNoticeFeed parseFrom(byte[] bArr) {
        return (LiveWatchingListChangeNoticeFeed) MessageNano.mergeFrom(new LiveWatchingListChangeNoticeFeed(), bArr);
    }

    public static LiveWatchingListChangeNoticeFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveWatchingListChangeNoticeFeed().mergeFrom(codedInputByteBufferNano);
    }
}
