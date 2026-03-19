package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftTitleInfo extends MessageNano {
    private static volatile LiveGiftTitleInfo[] _emptyArray;
    public String giftFeedDisplayText;
    public int giftId;
    public UserInfos.UserInfo namingUser;
    public long version;

    public static LiveGiftTitleInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftTitleInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftTitleInfo() {
        clear();
    }

    public final LiveGiftTitleInfo clear() {
        this.giftId = 0;
        this.giftFeedDisplayText = "";
        this.namingUser = null;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.giftFeedDisplayText.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.giftFeedDisplayText);
        }
        UserInfos.UserInfo userInfo = this.namingUser;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo);
        }
        long j = this.version;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
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
        if (!this.giftFeedDisplayText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.giftFeedDisplayText);
        }
        UserInfos.UserInfo userInfo = this.namingUser;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
        }
        long j = this.version;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftTitleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.giftFeedDisplayText = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                if (this.namingUser == null) {
                    this.namingUser = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.namingUser);
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveGiftTitleInfo parseFrom(byte[] bArr) {
        return (LiveGiftTitleInfo) MessageNano.mergeFrom(new LiveGiftTitleInfo(), bArr);
    }

    public static LiveGiftTitleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftTitleInfo().mergeFrom(codedInputByteBufferNano);
    }
}
