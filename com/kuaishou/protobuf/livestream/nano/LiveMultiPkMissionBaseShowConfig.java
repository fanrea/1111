package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkMissionBaseShowConfig extends MessageNano {
    private static volatile LiveMultiPkMissionBaseShowConfig[] _emptyArray;
    public long easterMomentPublishDuration;
    public int pkMissionType;
    public UserInfos.PicUrl[] processWebp;
    public String tipClickContent;
    public int toastLimitTimes;

    public static LiveMultiPkMissionBaseShowConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkMissionBaseShowConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkMissionBaseShowConfig() {
        clear();
    }

    public final LiveMultiPkMissionBaseShowConfig clear() {
        this.pkMissionType = 0;
        this.tipClickContent = "";
        this.processWebp = UserInfos.PicUrl.emptyArray();
        this.toastLimitTimes = 0;
        this.easterMomentPublishDuration = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.pkMissionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.tipClickContent.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.tipClickContent);
        }
        UserInfos.PicUrl[] picUrlArr = this.processWebp;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.processWebp;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i2++;
            }
        }
        int i3 = this.toastLimitTimes;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        long j = this.easterMomentPublishDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.pkMissionType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.tipClickContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.tipClickContent);
        }
        UserInfos.PicUrl[] picUrlArr = this.processWebp;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.processWebp;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i2++;
            }
        }
        int i3 = this.toastLimitTimes;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        long j = this.easterMomentPublishDuration;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkMissionBaseShowConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.pkMissionType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.tipClickContent = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.processWebp;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.processWebp, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.processWebp = picUrlArr2;
            } else if (tag == 32) {
                this.toastLimitTimes = codedInputByteBufferNano.readUInt32();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.easterMomentPublishDuration = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiPkMissionBaseShowConfig parseFrom(byte[] bArr) {
        return (LiveMultiPkMissionBaseShowConfig) MessageNano.mergeFrom(new LiveMultiPkMissionBaseShowConfig(), bArr);
    }

    public static LiveMultiPkMissionBaseShowConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkMissionBaseShowConfig().mergeFrom(codedInputByteBufferNano);
    }
}
