package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCMultiLineChatWishList extends MessageNano {
    private static volatile SCMultiLineChatWishList[] _emptyArray;
    public String chatId;
    public String multiLineChatId;
    public boolean open;
    public String sessionId;
    public long version;
    public Map<Long, ChatWishList> wishListMap;

    public static SCMultiLineChatWishList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMultiLineChatWishList[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMultiLineChatWishList() {
        clear();
    }

    public final SCMultiLineChatWishList clear() {
        this.wishListMap = null;
        this.multiLineChatId = "";
        this.chatId = "";
        this.open = false;
        this.version = 0L;
        this.sessionId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Long, ChatWishList> map = this.wishListMap;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 4, 11);
        }
        if (!this.multiLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.multiLineChatId);
        }
        if (!this.chatId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.chatId);
        }
        boolean z = this.open;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        long j = this.version;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        if (!this.sessionId.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.sessionId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Map<Long, ChatWishList> map = this.wishListMap;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 4, 11);
        }
        if (!this.multiLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.multiLineChatId);
        }
        if (!this.chatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.chatId);
        }
        boolean z = this.open;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        long j = this.version;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        return !this.sessionId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.sessionId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMultiLineChatWishList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.wishListMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.wishListMap, mapFactory, 4, 11, new ChatWishList(), 8, 18);
            } else if (tag == 18) {
                this.multiLineChatId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.chatId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.open = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.version = codedInputByteBufferNano.readUInt64();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.sessionId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCMultiLineChatWishList parseFrom(byte[] bArr) {
        return (SCMultiLineChatWishList) MessageNano.mergeFrom(new SCMultiLineChatWishList(), bArr);
    }

    public static SCMultiLineChatWishList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMultiLineChatWishList().mergeFrom(codedInputByteBufferNano);
    }
}
