package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KtvMusicOrderInfo extends MessageNano {
    private static volatile KtvMusicOrderInfo[] _emptyArray;
    public long endTimeOffset;
    public KtvMusicInfo musicInfo;
    public String musicOrderId;
    public boolean singerVideoStatus;
    public long startTimeOffset;
    public UserInfos.UserInfo user;
    public long userId;

    public static KtvMusicOrderInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new KtvMusicOrderInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public KtvMusicOrderInfo() {
        clear();
    }

    public final KtvMusicOrderInfo clear() {
        this.musicOrderId = "";
        this.userId = 0L;
        this.startTimeOffset = 0L;
        this.endTimeOffset = 0L;
        this.user = null;
        this.musicInfo = null;
        this.singerVideoStatus = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.musicOrderId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.musicOrderId);
        }
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.startTimeOffset;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        long j3 = this.endTimeOffset;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, userInfo);
        }
        KtvMusicInfo ktvMusicInfo = this.musicInfo;
        if (ktvMusicInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, ktvMusicInfo);
        }
        boolean z = this.singerVideoStatus;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.musicOrderId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.musicOrderId);
        }
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.startTimeOffset;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        long j3 = this.endTimeOffset;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, userInfo);
        }
        KtvMusicInfo ktvMusicInfo = this.musicInfo;
        if (ktvMusicInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, ktvMusicInfo);
        }
        boolean z = this.singerVideoStatus;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final KtvMusicOrderInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.musicOrderId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.startTimeOffset = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.endTimeOffset = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 50) {
                if (this.musicInfo == null) {
                    this.musicInfo = new KtvMusicInfo();
                }
                codedInputByteBufferNano.readMessage(this.musicInfo);
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.singerVideoStatus = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static KtvMusicOrderInfo parseFrom(byte[] bArr) {
        return (KtvMusicOrderInfo) MessageNano.mergeFrom(new KtvMusicOrderInfo(), bArr);
    }

    public static KtvMusicOrderInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new KtvMusicOrderInfo().mergeFrom(codedInputByteBufferNano);
    }
}
