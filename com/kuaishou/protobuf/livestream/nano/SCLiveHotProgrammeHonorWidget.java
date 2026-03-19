package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveHotProgrammeHonorWidget extends MessageNano {
    private static volatile SCLiveHotProgrammeHonorWidget[] _emptyArray;
    public long activityId;
    public long carouselIntervalMs;
    public boolean hide;
    public UserInfos.PicUrl[] iconUrl;
    public String kwaiUrl;
    public int rankId;
    public int tabType;
    public String[] text;
    public long version;

    public static SCLiveHotProgrammeHonorWidget[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveHotProgrammeHonorWidget[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveHotProgrammeHonorWidget() {
        clear();
    }

    public final SCLiveHotProgrammeHonorWidget clear() {
        this.text = WireFormatNano.EMPTY_STRING_ARRAY;
        this.carouselIntervalMs = 0L;
        this.kwaiUrl = "";
        this.activityId = 0L;
        this.tabType = 0;
        this.rankId = 0;
        this.hide = false;
        this.iconUrl = UserInfos.PicUrl.emptyArray();
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        String[] strArr = this.text;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.text;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i2++;
            }
        }
        long j = this.carouselIntervalMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.kwaiUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.kwaiUrl);
        }
        long j2 = this.activityId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        int i3 = this.tabType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i4 = this.rankId;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i4);
        }
        boolean z = this.hide;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(8, picUrl);
                }
                i++;
            }
        }
        long j3 = this.version;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.text;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.text;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
        }
        long j = this.carouselIntervalMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.kwaiUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.kwaiUrl);
        }
        long j2 = this.activityId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        int i4 = this.tabType;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
        }
        int i5 = this.rankId;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
        }
        boolean z = this.hide;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, picUrl);
                }
                i++;
            }
        }
        long j3 = this.version;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveHotProgrammeHonorWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.text;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.text, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.text = strArr2;
            } else if (tag == 16) {
                this.carouselIntervalMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.kwaiUrl = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.activityId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.tabType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 48) {
                this.rankId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 56) {
                this.hide = codedInputByteBufferNano.readBool();
            } else if (tag == 66) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length2);
                }
                while (length2 < picUrlArr2.length - 1) {
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr2[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                this.iconUrl = picUrlArr2;
            } else if (tag != 72) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveHotProgrammeHonorWidget parseFrom(byte[] bArr) {
        return (SCLiveHotProgrammeHonorWidget) MessageNano.mergeFrom(new SCLiveHotProgrammeHonorWidget(), bArr);
    }

    public static SCLiveHotProgrammeHonorWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveHotProgrammeHonorWidget().mergeFrom(codedInputByteBufferNano);
    }
}
