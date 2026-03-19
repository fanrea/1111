package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BulletPlayChatWindow extends MessageNano {
    private static volatile BulletPlayChatWindow[] _emptyArray;
    public int height;
    public boolean isPlaceholder;
    public UserInfos.PicUrl[] placeholderUrl;
    public long userId;
    public int width;
    public int windowId;
    public int x;
    public int y;

    public static BulletPlayChatWindow[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BulletPlayChatWindow[0];
                }
            }
        }
        return _emptyArray;
    }

    public BulletPlayChatWindow() {
        clear();
    }

    public final BulletPlayChatWindow clear() {
        this.windowId = 0;
        this.userId = 0L;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.isPlaceholder = false;
        this.placeholderUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.windowId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        int i2 = this.x;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i2);
        }
        int i3 = this.y;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i4 = this.width;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i4);
        }
        int i5 = this.height;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i5);
        }
        boolean z = this.isPlaceholder;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.placeholderUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.placeholderUrl;
                if (i6 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i6];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(8, picUrl);
                }
                i6++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.windowId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        int i2 = this.x;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
        }
        int i3 = this.y;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i4 = this.width;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
        }
        int i5 = this.height;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
        }
        boolean z = this.isPlaceholder;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.placeholderUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.placeholderUrl;
                if (i6 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i6];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, picUrl);
                }
                i6++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BulletPlayChatWindow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.windowId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.x = codedInputByteBufferNano.readUInt32();
            } else if (tag == 32) {
                this.y = codedInputByteBufferNano.readUInt32();
            } else if (tag == 40) {
                this.width = codedInputByteBufferNano.readUInt32();
            } else if (tag == 48) {
                this.height = codedInputByteBufferNano.readUInt32();
            } else if (tag == 56) {
                this.isPlaceholder = codedInputByteBufferNano.readBool();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                UserInfos.PicUrl[] picUrlArr = this.placeholderUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.placeholderUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.placeholderUrl = picUrlArr2;
            }
        }
    }

    public static BulletPlayChatWindow parseFrom(byte[] bArr) {
        return (BulletPlayChatWindow) MessageNano.mergeFrom(new BulletPlayChatWindow(), bArr);
    }

    public static BulletPlayChatWindow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BulletPlayChatWindow().mergeFrom(codedInputByteBufferNano);
    }
}
