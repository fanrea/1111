package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveFansTopBoostFollowFeed extends MessageNano {
    private static volatile LiveFansTopBoostFollowFeed[] _emptyArray;
    public int giftId;
    public String id;
    public String textContent;

    public static LiveFansTopBoostFollowFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveFansTopBoostFollowFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveFansTopBoostFollowFeed() {
        clear();
    }

    public final LiveFansTopBoostFollowFeed clear() {
        this.giftId = 0;
        this.textContent = "";
        this.id = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.textContent.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.textContent);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.id);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.textContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textContent);
        }
        return !this.id.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.id) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveFansTopBoostFollowFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.textContent = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.id = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveFansTopBoostFollowFeed parseFrom(byte[] bArr) {
        return (LiveFansTopBoostFollowFeed) MessageNano.mergeFrom(new LiveFansTopBoostFollowFeed(), bArr);
    }

    public static LiveFansTopBoostFollowFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveFansTopBoostFollowFeed().mergeFrom(codedInputByteBufferNano);
    }
}
