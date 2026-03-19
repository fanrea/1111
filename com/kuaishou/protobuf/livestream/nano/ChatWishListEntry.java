package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ChatWishListEntry extends MessageNano {
    private static volatile ChatWishListEntry[] _emptyArray;
    public String color;
    public long currentCount;
    public String displayCurrentCount;
    public String displayExpectCount;
    public long expectCount;
    public int giftId;
    public String wishId;

    public static ChatWishListEntry[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ChatWishListEntry[0];
                }
            }
        }
        return _emptyArray;
    }

    public ChatWishListEntry() {
        clear();
    }

    public final ChatWishListEntry clear() {
        this.wishId = "";
        this.giftId = 0;
        this.expectCount = 0L;
        this.currentCount = 0L;
        this.displayExpectCount = "";
        this.displayCurrentCount = "";
        this.color = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.wishId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.wishId);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        long j = this.expectCount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.currentCount;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        if (!this.displayExpectCount.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.displayExpectCount);
        }
        if (!this.displayCurrentCount.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.displayCurrentCount);
        }
        if (!this.color.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.color);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.wishId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.wishId);
        }
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        long j = this.expectCount;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.currentCount;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        if (!this.displayExpectCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayExpectCount);
        }
        if (!this.displayCurrentCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.displayCurrentCount);
        }
        return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.color) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ChatWishListEntry mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.wishId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                this.expectCount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.currentCount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                this.displayExpectCount = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.displayCurrentCount = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.color = codedInputByteBufferNano.readString();
            }
        }
    }

    public static ChatWishListEntry parseFrom(byte[] bArr) {
        return (ChatWishListEntry) MessageNano.mergeFrom(new ChatWishListEntry(), bArr);
    }

    public static ChatWishListEntry parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ChatWishListEntry().mergeFrom(codedInputByteBufferNano);
    }
}
