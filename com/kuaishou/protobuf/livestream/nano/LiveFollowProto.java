package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveFollowProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FollowActivityType {
        public static final int NORMAL_FOLLOW_TYPE = 1;
        public static final int QUIZ_FOLLOW_TYPE = 2;
        public static final int UNKNOWN_FOLLOW_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PopupStyle {
        public static final int DEFAULT_POPUP_STYLE = 0;
        public static final int GAME_COMPETITION = 1;
    }

    public static final class PopupMessage extends MessageNano {
        private static volatile PopupMessage[] _emptyArray;
        public String note;
        public String toast;
        public long userId;

        public static PopupMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PopupMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PopupMessage() {
            clear();
        }

        public final PopupMessage clear() {
            this.userId = 0L;
            this.note = "";
            this.toast = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.note.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.note);
            }
            if (!this.toast.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.toast);
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
            if (!this.note.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.note);
            }
            return !this.toast.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.toast) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PopupMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.note = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.toast = codedInputByteBufferNano.readString();
                }
            }
        }

        public static PopupMessage parseFrom(byte[] bArr) {
            return (PopupMessage) MessageNano.mergeFrom(new PopupMessage(), bArr);
        }

        public static PopupMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PopupMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCFollowPopup extends MessageNano {
        private static volatile SCFollowPopup[] _emptyArray;
        public int activityType;
        public long displayDuration;
        public long followRequestMaxDelayMs;
        public long maxWaitAacSignalTimeMs;
        public int popupStyle;
        public long sequenceId;
        public long[] userId;
        public FollowPopupUserInfo[] userInfo;

        public static SCFollowPopup[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCFollowPopup[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCFollowPopup() {
            clear();
        }

        public final SCFollowPopup clear() {
            this.userId = WireFormatNano.EMPTY_LONG_ARRAY;
            this.maxWaitAacSignalTimeMs = 0L;
            this.displayDuration = 0L;
            this.sequenceId = 0L;
            this.followRequestMaxDelayMs = 0L;
            this.popupStyle = 0;
            this.activityType = 0;
            this.userInfo = FollowPopupUserInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long[] jArr = this.userId;
            int i = 0;
            if (jArr != null && jArr.length > 0) {
                int i2 = 0;
                while (true) {
                    long[] jArr2 = this.userId;
                    if (i2 >= jArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt64(1, jArr2[i2]);
                    i2++;
                }
            }
            long j = this.maxWaitAacSignalTimeMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.displayDuration;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            long j3 = this.sequenceId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j3);
            }
            long j4 = this.followRequestMaxDelayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j4);
            }
            int i3 = this.popupStyle;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i3);
            }
            int i4 = this.activityType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i4);
            }
            FollowPopupUserInfo[] followPopupUserInfoArr = this.userInfo;
            if (followPopupUserInfoArr != null && followPopupUserInfoArr.length > 0) {
                while (true) {
                    FollowPopupUserInfo[] followPopupUserInfoArr2 = this.userInfo;
                    if (i >= followPopupUserInfoArr2.length) {
                        break;
                    }
                    FollowPopupUserInfo followPopupUserInfo = followPopupUserInfoArr2[i];
                    if (followPopupUserInfo != null) {
                        codedOutputByteBufferNano.writeMessage(8, followPopupUserInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            long[] jArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            long[] jArr2 = this.userId;
            int i = 0;
            if (jArr2 != null && jArr2.length > 0) {
                int i2 = 0;
                int iComputeUInt64SizeNoTag = 0;
                while (true) {
                    jArr = this.userId;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i2]);
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
            }
            long j = this.maxWaitAacSignalTimeMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.displayDuration;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            long j3 = this.sequenceId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
            }
            long j4 = this.followRequestMaxDelayMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j4);
            }
            int i3 = this.popupStyle;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            int i4 = this.activityType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
            }
            FollowPopupUserInfo[] followPopupUserInfoArr = this.userInfo;
            if (followPopupUserInfoArr != null && followPopupUserInfoArr.length > 0) {
                while (true) {
                    FollowPopupUserInfo[] followPopupUserInfoArr2 = this.userInfo;
                    if (i >= followPopupUserInfoArr2.length) {
                        break;
                    }
                    FollowPopupUserInfo followPopupUserInfo = followPopupUserInfoArr2[i];
                    if (followPopupUserInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, followPopupUserInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCFollowPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    long[] jArr = this.userId;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.userId, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.userId = jArr2;
                } else if (tag == 10) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.userId;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.userId, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.userId = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag == 16) {
                    this.maxWaitAacSignalTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.displayDuration = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.sequenceId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.followRequestMaxDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.popupStyle = int32;
                    }
                } else if (tag == 56) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2) {
                        this.activityType = int322;
                    }
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    FollowPopupUserInfo[] followPopupUserInfoArr = this.userInfo;
                    int length3 = followPopupUserInfoArr == null ? 0 : followPopupUserInfoArr.length;
                    FollowPopupUserInfo[] followPopupUserInfoArr2 = new FollowPopupUserInfo[repeatedFieldArrayLength2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.userInfo, 0, followPopupUserInfoArr2, 0, length3);
                    }
                    while (length3 < followPopupUserInfoArr2.length - 1) {
                        followPopupUserInfoArr2[length3] = new FollowPopupUserInfo();
                        codedInputByteBufferNano.readMessage(followPopupUserInfoArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    followPopupUserInfoArr2[length3] = new FollowPopupUserInfo();
                    codedInputByteBufferNano.readMessage(followPopupUserInfoArr2[length3]);
                    this.userInfo = followPopupUserInfoArr2;
                }
            }
        }

        public static SCFollowPopup parseFrom(byte[] bArr) {
            return (SCFollowPopup) MessageNano.mergeFrom(new SCFollowPopup(), bArr);
        }

        public static SCFollowPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCFollowPopup().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FollowPopupUserInfo extends MessageNano {
        private static volatile FollowPopupUserInfo[] _emptyArray;
        public String note;
        public UserInfos.UserInfo userBaseInfo;

        public static FollowPopupUserInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FollowPopupUserInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FollowPopupUserInfo() {
            clear();
        }

        public final FollowPopupUserInfo clear() {
            this.userBaseInfo = null;
            this.note = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.userBaseInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            if (!this.note.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.note);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.userBaseInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            return !this.note.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.note) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FollowPopupUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.userBaseInfo == null) {
                        this.userBaseInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userBaseInfo);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.note = codedInputByteBufferNano.readString();
                }
            }
        }

        public static FollowPopupUserInfo parseFrom(byte[] bArr) {
            return (FollowPopupUserInfo) MessageNano.mergeFrom(new FollowPopupUserInfo(), bArr);
        }

        public static FollowPopupUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FollowPopupUserInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
