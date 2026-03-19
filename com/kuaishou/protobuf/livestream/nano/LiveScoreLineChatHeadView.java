package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatHeadView extends MessageNano {
    private static volatile LiveScoreLineChatHeadView[] _emptyArray;
    public long displayDurationMs;
    public String displayTarget;
    public String displayTargetUnit;
    public String headViewText;
    public int headViewType;
    public UserInfos.PicUrl[] headerViewPicUrl;
    public int imageHeight;
    public int imageWidth;

    public static LiveScoreLineChatHeadView[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatHeadView[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatHeadView() {
        clear();
    }

    public final LiveScoreLineChatHeadView clear() {
        this.headViewType = 0;
        this.headerViewPicUrl = UserInfos.PicUrl.emptyArray();
        this.displayDurationMs = 0L;
        this.headViewText = "";
        this.displayTarget = "";
        this.displayTargetUnit = "";
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.headViewType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.headerViewPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headerViewPicUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(2, picUrl);
                }
                i2++;
            }
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.headViewText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.headViewText);
        }
        if (!this.displayTarget.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.displayTarget);
        }
        if (!this.displayTargetUnit.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.displayTargetUnit);
        }
        int i3 = this.imageWidth;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        int i4 = this.imageHeight;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i4);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.headViewType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.headerViewPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headerViewPicUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                }
                i2++;
            }
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.headViewText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.headViewText);
        }
        if (!this.displayTarget.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayTarget);
        }
        if (!this.displayTargetUnit.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.displayTargetUnit);
        }
        int i3 = this.imageWidth;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        int i4 = this.imageHeight;
        return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatHeadView mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.headViewType = int32;
                }
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserInfos.PicUrl[] picUrlArr = this.headerViewPicUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.headerViewPicUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.headerViewPicUrl = picUrlArr2;
            } else if (tag == 24) {
                this.displayDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.headViewText = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.displayTarget = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.displayTargetUnit = codedInputByteBufferNano.readString();
            } else if (tag == 56) {
                this.imageWidth = codedInputByteBufferNano.readUInt32();
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.imageHeight = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveScoreLineChatHeadView parseFrom(byte[] bArr) {
        return (LiveScoreLineChatHeadView) MessageNano.mergeFrom(new LiveScoreLineChatHeadView(), bArr);
    }

    public static LiveScoreLineChatHeadView parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatHeadView().mergeFrom(codedInputByteBufferNano);
    }
}
