package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024Koi {

    public static final class SCLiveCny2024Koi extends MessageNano {
        private static volatile SCLiveCny2024Koi[] _emptyArray;
        public String activityId;
        public String audienceJumpKwailink;
        public String audienceWidgetTitle;
        public String authorJumpKwailink;
        public String authorWidgetTitle;
        public UserInfos.PicUrl[] backgroundPic;
        public String countDownAudienceWidgetTitle;
        public String countDownAuthorWidgetTitle;
        public long countDownEndTimestamp;
        public long displayEndTimestamp;
        public String koiLiveId;
        public boolean openReady;
        public long openTimestamp;
        public int pendantStatus;
        public long queryResultMaxDelayMillis;
        public long queryStatusEndTimestamp;
        public int round;

        public static SCLiveCny2024Koi[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024Koi[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024Koi() {
            clear();
        }

        public final SCLiveCny2024Koi clear() {
            this.koiLiveId = "";
            this.activityId = "";
            this.round = 0;
            this.displayEndTimestamp = 0L;
            this.openTimestamp = 0L;
            this.countDownEndTimestamp = 0L;
            this.queryStatusEndTimestamp = 0L;
            this.openReady = false;
            this.audienceWidgetTitle = "";
            this.authorWidgetTitle = "";
            this.countDownAudienceWidgetTitle = "";
            this.countDownAuthorWidgetTitle = "";
            this.audienceJumpKwailink = "";
            this.authorJumpKwailink = "";
            this.backgroundPic = UserInfos.PicUrl.emptyArray();
            this.queryResultMaxDelayMillis = 0L;
            this.pendantStatus = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.koiLiveId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.koiLiveId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            int i = this.round;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j = this.displayEndTimestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.openTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.countDownEndTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            long j4 = this.queryStatusEndTimestamp;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j4);
            }
            boolean z = this.openReady;
            if (z) {
                codedOutputByteBufferNano.writeBool(8, z);
            }
            if (!this.audienceWidgetTitle.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.audienceWidgetTitle);
            }
            if (!this.authorWidgetTitle.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.authorWidgetTitle);
            }
            if (!this.countDownAudienceWidgetTitle.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.countDownAudienceWidgetTitle);
            }
            if (!this.countDownAuthorWidgetTitle.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.countDownAuthorWidgetTitle);
            }
            if (!this.audienceJumpKwailink.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.audienceJumpKwailink);
            }
            if (!this.authorJumpKwailink.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.authorJumpKwailink);
            }
            UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPic;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(15, picUrl);
                    }
                    i2++;
                }
            }
            long j5 = this.queryResultMaxDelayMillis;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(16, j5);
            }
            int i3 = this.pendantStatus;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(17, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.koiLiveId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.koiLiveId);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            int i = this.round;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j = this.displayEndTimestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.openTimestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.countDownEndTimestamp;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            long j4 = this.queryStatusEndTimestamp;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
            }
            boolean z = this.openReady;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
            }
            if (!this.audienceWidgetTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.audienceWidgetTitle);
            }
            if (!this.authorWidgetTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.authorWidgetTitle);
            }
            if (!this.countDownAudienceWidgetTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.countDownAudienceWidgetTitle);
            }
            if (!this.countDownAuthorWidgetTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.countDownAuthorWidgetTitle);
            }
            if (!this.audienceJumpKwailink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.audienceJumpKwailink);
            }
            if (!this.authorJumpKwailink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.authorJumpKwailink);
            }
            UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPic;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, picUrl);
                    }
                    i2++;
                }
            }
            long j5 = this.queryResultMaxDelayMillis;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j5);
            }
            int i3 = this.pendantStatus;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(17, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024Koi mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.koiLiveId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.activityId = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.round = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.displayEndTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.openTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
                        this.countDownEndTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.queryStatusEndTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.openReady = codedInputByteBufferNano.readBool();
                        break;
                    case 74:
                        this.audienceWidgetTitle = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.authorWidgetTitle = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.countDownAudienceWidgetTitle = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.countDownAuthorWidgetTitle = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        this.audienceJumpKwailink = codedInputByteBufferNano.readString();
                        break;
                    case 114:
                        this.authorJumpKwailink = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                        UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.backgroundPic, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.backgroundPic = picUrlArr2;
                        break;
                    case 128:
                        this.queryResultMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 136:
                        this.pendantStatus = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveCny2024Koi parseFrom(byte[] bArr) {
            return (SCLiveCny2024Koi) MessageNano.mergeFrom(new SCLiveCny2024Koi(), bArr);
        }

        public static SCLiveCny2024Koi parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024Koi().mergeFrom(codedInputByteBufferNano);
        }
    }
}
