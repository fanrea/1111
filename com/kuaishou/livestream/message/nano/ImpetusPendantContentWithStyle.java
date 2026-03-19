package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ImpetusPendantContentWithStyle extends MessageNano {
    private static volatile ImpetusPendantContentWithStyle[] _emptyArray;
    public int align;
    public boolean bold;
    public String color;
    public String content;
    public UserInfos.PicUrl[] cornerPicUrl;
    public int size;

    public static ImpetusPendantContentWithStyle[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ImpetusPendantContentWithStyle[0];
                }
            }
        }
        return _emptyArray;
    }

    public ImpetusPendantContentWithStyle() {
        clear();
    }

    public final ImpetusPendantContentWithStyle clear() {
        this.content = "";
        this.color = "";
        this.bold = false;
        this.align = 0;
        this.size = 0;
        this.cornerPicUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.content);
        }
        if (!this.color.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.color);
        }
        boolean z = this.bold;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        int i = this.align;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        int i2 = this.size;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i2);
        }
        UserInfos.PicUrl[] picUrlArr = this.cornerPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.cornerPicUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(6, picUrl);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
        }
        if (!this.color.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.color);
        }
        boolean z = this.bold;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        int i = this.align;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        int i2 = this.size;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
        }
        UserInfos.PicUrl[] picUrlArr = this.cornerPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.cornerPicUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl);
                }
                i3++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ImpetusPendantContentWithStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.color = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.bold = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.align = int32;
                }
            } else if (tag == 40) {
                this.size = codedInputByteBufferNano.readInt32();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                UserInfos.PicUrl[] picUrlArr = this.cornerPicUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.cornerPicUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.cornerPicUrl = picUrlArr2;
            }
        }
    }

    public static ImpetusPendantContentWithStyle parseFrom(byte[] bArr) {
        return (ImpetusPendantContentWithStyle) MessageNano.mergeFrom(new ImpetusPendantContentWithStyle(), bArr);
    }

    public static ImpetusPendantContentWithStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ImpetusPendantContentWithStyle().mergeFrom(codedInputByteBufferNano);
    }
}
