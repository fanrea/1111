package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class VoicePartyEmojiFeed extends MessageNano {
    private static volatile VoicePartyEmojiFeed[] _emptyArray;
    public long emojiId;
    public int emojiType;
    public UserInfos.PicUrl[] emojiUrl;
    public long fromMicSeatId;
    public int scene;
    public long toMicSeatId;
    public long toUserId;
    public long userId;

    public static VoicePartyEmojiFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VoicePartyEmojiFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public VoicePartyEmojiFeed() {
        clear();
    }

    public final VoicePartyEmojiFeed clear() {
        this.userId = 0L;
        this.emojiId = 0L;
        this.emojiType = 0;
        this.emojiUrl = UserInfos.PicUrl.emptyArray();
        this.fromMicSeatId = 0L;
        this.toMicSeatId = 0L;
        this.scene = 0;
        this.toUserId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.emojiId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        int i = this.emojiType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.emojiUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.emojiUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(4, picUrl);
                }
                i2++;
            }
        }
        long j3 = this.fromMicSeatId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        long j4 = this.toMicSeatId;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j4);
        }
        int i3 = this.scene;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i3);
        }
        long j5 = this.toUserId;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.emojiId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        int i = this.emojiType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.emojiUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.emojiUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                }
                i2++;
            }
        }
        long j3 = this.fromMicSeatId;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        long j4 = this.toMicSeatId;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j4);
        }
        int i3 = this.scene;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i3);
        }
        long j5 = this.toUserId;
        return j5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j5) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final VoicePartyEmojiFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.emojiId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.emojiType = int32;
                }
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.PicUrl[] picUrlArr = this.emojiUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.emojiUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.emojiUrl = picUrlArr2;
            } else if (tag == 40) {
                this.fromMicSeatId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.toMicSeatId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 56) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.scene = int322;
                }
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.toUserId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static VoicePartyEmojiFeed parseFrom(byte[] bArr) {
        return (VoicePartyEmojiFeed) MessageNano.mergeFrom(new VoicePartyEmojiFeed(), bArr);
    }

    public static VoicePartyEmojiFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new VoicePartyEmojiFeed().mergeFrom(codedInputByteBufferNano);
    }
}
