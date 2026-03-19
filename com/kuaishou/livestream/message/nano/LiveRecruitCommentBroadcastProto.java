package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRecruitCommentBroadcastProto {

    public static final class LiveRecruitCommentBroadcast extends MessageNano {
        private static volatile LiveRecruitCommentBroadcast[] _emptyArray;
        public UserInfos.PicUrl[] backgroundUrl;
        public String bizType;
        public int count;
        public String[] disableUserIds;
        public Map<String, Integer> hometownUserCount;
        public UserInfos.PicUrl[] iconUrl;
        public String jobId;
        public String nickName;
        public UserInfos.PicUrl[] refreshIconUrl;
        public long serverTimeStamp;
        public String text;

        public static LiveRecruitCommentBroadcast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRecruitCommentBroadcast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRecruitCommentBroadcast() {
            clear();
        }

        public final LiveRecruitCommentBroadcast clear() {
            this.nickName = "";
            this.text = "";
            this.count = 0;
            this.iconUrl = UserInfos.PicUrl.emptyArray();
            this.backgroundUrl = UserInfos.PicUrl.emptyArray();
            this.serverTimeStamp = 0L;
            this.bizType = "";
            this.jobId = "";
            this.hometownUserCount = null;
            this.disableUserIds = WireFormatNano.EMPTY_STRING_ARRAY;
            this.refreshIconUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.nickName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.nickName);
            }
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.text);
            }
            int i = this.count;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.backgroundUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.backgroundUrl;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl2);
                    }
                    i4++;
                }
            }
            long j = this.serverTimeStamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            if (!this.bizType.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.bizType);
            }
            if (!this.jobId.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.jobId);
            }
            Map<String, Integer> map = this.hometownUserCount;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 9, 9, 13);
            }
            String[] strArr = this.disableUserIds;
            if (strArr != null && strArr.length > 0) {
                int i5 = 0;
                while (true) {
                    String[] strArr2 = this.disableUserIds;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i5];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(10, str);
                    }
                    i5++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.refreshIconUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.refreshIconUrl;
                    if (i2 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(11, picUrl3);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.nickName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.nickName);
            }
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
            }
            int i = this.count;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.backgroundUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.backgroundUrl;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(5, picUrl2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            long j = this.serverTimeStamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            if (!this.bizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.bizType);
            }
            if (!this.jobId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.jobId);
            }
            Map<String, Integer> map = this.hometownUserCount;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 9, 9, 13);
            }
            String[] strArr = this.disableUserIds;
            if (strArr != null && strArr.length > 0) {
                int i5 = 0;
                int iComputeStringSizeNoTag = 0;
                int i6 = 0;
                while (true) {
                    String[] strArr2 = this.disableUserIds;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i5];
                    if (str != null) {
                        i6++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i6 * 1);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.refreshIconUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.refreshIconUrl;
                    if (i2 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, picUrl3);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRecruitCommentBroadcast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.nickName = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.text = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.count = codedInputByteBufferNano.readUInt32();
                        break;
                    case 34:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.iconUrl = picUrlArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        UserInfos.PicUrl[] picUrlArr3 = this.backgroundUrl;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.backgroundUrl, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.backgroundUrl = picUrlArr4;
                        break;
                    case 48:
                        this.serverTimeStamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 58:
                        this.bizType = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.jobId = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.hometownUserCount = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.hometownUserCount, mapFactory, 9, 13, null, 10, 16);
                        break;
                    case 82:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        String[] strArr = this.disableUserIds;
                        int length3 = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.disableUserIds, 0, strArr2, 0, length3);
                        }
                        while (length3 < strArr2.length - 1) {
                            strArr2[length3] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        strArr2[length3] = codedInputByteBufferNano.readString();
                        this.disableUserIds = strArr2;
                        break;
                    case 90:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UserInfos.PicUrl[] picUrlArr5 = this.refreshIconUrl;
                        int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.refreshIconUrl, 0, picUrlArr6, 0, length4);
                        }
                        while (length4 < picUrlArr6.length - 1) {
                            picUrlArr6[length4] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        this.refreshIconUrl = picUrlArr6;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveRecruitCommentBroadcast parseFrom(byte[] bArr) {
            return (LiveRecruitCommentBroadcast) MessageNano.mergeFrom(new LiveRecruitCommentBroadcast(), bArr);
        }

        public static LiveRecruitCommentBroadcast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRecruitCommentBroadcast().mergeFrom(codedInputByteBufferNano);
        }
    }
}
