package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ChatWishList extends MessageNano {
    private static volatile ChatWishList[] _emptyArray;
    public ChatWishListEntry[] entryList;
    public String wishListId;

    public static ChatWishList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ChatWishList[0];
                }
            }
        }
        return _emptyArray;
    }

    public ChatWishList() {
        clear();
    }

    public final ChatWishList clear() {
        this.wishListId = "";
        this.entryList = ChatWishListEntry.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.wishListId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.wishListId);
        }
        ChatWishListEntry[] chatWishListEntryArr = this.entryList;
        if (chatWishListEntryArr != null && chatWishListEntryArr.length > 0) {
            int i = 0;
            while (true) {
                ChatWishListEntry[] chatWishListEntryArr2 = this.entryList;
                if (i >= chatWishListEntryArr2.length) {
                    break;
                }
                ChatWishListEntry chatWishListEntry = chatWishListEntryArr2[i];
                if (chatWishListEntry != null) {
                    codedOutputByteBufferNano.writeMessage(2, chatWishListEntry);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.wishListId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.wishListId);
        }
        ChatWishListEntry[] chatWishListEntryArr = this.entryList;
        if (chatWishListEntryArr != null && chatWishListEntryArr.length > 0) {
            int i = 0;
            while (true) {
                ChatWishListEntry[] chatWishListEntryArr2 = this.entryList;
                if (i >= chatWishListEntryArr2.length) {
                    break;
                }
                ChatWishListEntry chatWishListEntry = chatWishListEntryArr2[i];
                if (chatWishListEntry != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, chatWishListEntry);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ChatWishList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.wishListId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ChatWishListEntry[] chatWishListEntryArr = this.entryList;
                int length = chatWishListEntryArr == null ? 0 : chatWishListEntryArr.length;
                ChatWishListEntry[] chatWishListEntryArr2 = new ChatWishListEntry[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.entryList, 0, chatWishListEntryArr2, 0, length);
                }
                while (length < chatWishListEntryArr2.length - 1) {
                    chatWishListEntryArr2[length] = new ChatWishListEntry();
                    codedInputByteBufferNano.readMessage(chatWishListEntryArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                chatWishListEntryArr2[length] = new ChatWishListEntry();
                codedInputByteBufferNano.readMessage(chatWishListEntryArr2[length]);
                this.entryList = chatWishListEntryArr2;
            }
        }
    }

    public static ChatWishList parseFrom(byte[] bArr) {
        return (ChatWishList) MessageNano.mergeFrom(new ChatWishList(), bArr);
    }

    public static ChatWishList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ChatWishList().mergeFrom(codedInputByteBufferNano);
    }
}
