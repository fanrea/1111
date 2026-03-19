package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveMultiInteractiveMessages {

    public static final class SCLiveMultiInteractiveInfo extends MessageNano {
        private static volatile SCLiveMultiInteractiveInfo[] _emptyArray;
        public LiveMultiInteractiveEffectInfo[] effectInfo;
        public String id;
        public String[] otherParticipantId;

        public static SCLiveMultiInteractiveInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveMultiInteractiveInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveMultiInteractiveInfo() {
            clear();
        }

        public final SCLiveMultiInteractiveInfo clear() {
            this.effectInfo = LiveMultiInteractiveEffectInfo.emptyArray();
            this.id = "";
            this.otherParticipantId = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveMultiInteractiveEffectInfo[] liveMultiInteractiveEffectInfoArr = this.effectInfo;
            int i = 0;
            if (liveMultiInteractiveEffectInfoArr != null && liveMultiInteractiveEffectInfoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveMultiInteractiveEffectInfo[] liveMultiInteractiveEffectInfoArr2 = this.effectInfo;
                    if (i2 >= liveMultiInteractiveEffectInfoArr2.length) {
                        break;
                    }
                    LiveMultiInteractiveEffectInfo liveMultiInteractiveEffectInfo = liveMultiInteractiveEffectInfoArr2[i2];
                    if (liveMultiInteractiveEffectInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveMultiInteractiveEffectInfo);
                    }
                    i2++;
                }
            }
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.id);
            }
            String[] strArr = this.otherParticipantId;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.otherParticipantId;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(3, str);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveMultiInteractiveEffectInfo[] liveMultiInteractiveEffectInfoArr = this.effectInfo;
            int i = 0;
            if (liveMultiInteractiveEffectInfoArr != null && liveMultiInteractiveEffectInfoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    LiveMultiInteractiveEffectInfo[] liveMultiInteractiveEffectInfoArr2 = this.effectInfo;
                    if (i2 >= liveMultiInteractiveEffectInfoArr2.length) {
                        break;
                    }
                    LiveMultiInteractiveEffectInfo liveMultiInteractiveEffectInfo = liveMultiInteractiveEffectInfoArr2[i2];
                    if (liveMultiInteractiveEffectInfo != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, liveMultiInteractiveEffectInfo);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.id);
            }
            String[] strArr = this.otherParticipantId;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.otherParticipantId;
                if (i >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
                }
                String str = strArr2[i];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveMultiInteractiveInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveMultiInteractiveEffectInfo[] liveMultiInteractiveEffectInfoArr = this.effectInfo;
                    int length = liveMultiInteractiveEffectInfoArr == null ? 0 : liveMultiInteractiveEffectInfoArr.length;
                    LiveMultiInteractiveEffectInfo[] liveMultiInteractiveEffectInfoArr2 = new LiveMultiInteractiveEffectInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.effectInfo, 0, liveMultiInteractiveEffectInfoArr2, 0, length);
                    }
                    while (length < liveMultiInteractiveEffectInfoArr2.length - 1) {
                        liveMultiInteractiveEffectInfoArr2[length] = new LiveMultiInteractiveEffectInfo();
                        codedInputByteBufferNano.readMessage(liveMultiInteractiveEffectInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveMultiInteractiveEffectInfoArr2[length] = new LiveMultiInteractiveEffectInfo();
                    codedInputByteBufferNano.readMessage(liveMultiInteractiveEffectInfoArr2[length]);
                    this.effectInfo = liveMultiInteractiveEffectInfoArr2;
                } else if (tag == 18) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.otherParticipantId;
                    int length2 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.otherParticipantId, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    this.otherParticipantId = strArr2;
                }
            }
        }

        public static SCLiveMultiInteractiveInfo parseFrom(byte[] bArr) {
            return (SCLiveMultiInteractiveInfo) MessageNano.mergeFrom(new SCLiveMultiInteractiveInfo(), bArr);
        }

        public static SCLiveMultiInteractiveInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveMultiInteractiveInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveMultiInteractiveEffectInfo extends MessageNano {
        private static volatile LiveMultiInteractiveEffectInfo[] _emptyArray;
        public LiveCommonEffectInfo effect;
        public LiveMultiInteractiveEffectControl effectControl;

        public static LiveMultiInteractiveEffectInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveMultiInteractiveEffectInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveMultiInteractiveEffectInfo() {
            clear();
        }

        public final LiveMultiInteractiveEffectInfo clear() {
            this.effect = null;
            this.effectControl = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCommonEffectInfo liveCommonEffectInfo = this.effect;
            if (liveCommonEffectInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonEffectInfo);
            }
            LiveMultiInteractiveEffectControl liveMultiInteractiveEffectControl = this.effectControl;
            if (liveMultiInteractiveEffectControl != null) {
                codedOutputByteBufferNano.writeMessage(2, liveMultiInteractiveEffectControl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCommonEffectInfo liveCommonEffectInfo = this.effect;
            if (liveCommonEffectInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCommonEffectInfo);
            }
            LiveMultiInteractiveEffectControl liveMultiInteractiveEffectControl = this.effectControl;
            return liveMultiInteractiveEffectControl != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, liveMultiInteractiveEffectControl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveMultiInteractiveEffectInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.effect == null) {
                        this.effect = new LiveCommonEffectInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.effect);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.effectControl == null) {
                        this.effectControl = new LiveMultiInteractiveEffectControl();
                    }
                    codedInputByteBufferNano.readMessage(this.effectControl);
                }
            }
        }

        public static LiveMultiInteractiveEffectInfo parseFrom(byte[] bArr) {
            return (LiveMultiInteractiveEffectInfo) MessageNano.mergeFrom(new LiveMultiInteractiveEffectInfo(), bArr);
        }

        public static LiveMultiInteractiveEffectInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveMultiInteractiveEffectInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveMultiInteractiveEffectControl extends MessageNano {
        private static volatile LiveMultiInteractiveEffectControl[] _emptyArray;
        public String interactiveSceneId;
        public int interactiveType;
        public String oldMultiLineChatId;
        public int userType;
        public String[] whiteUser;

        @Retention(RetentionPolicy.SOURCE)
        public @interface InteractiveEffectUserType {
            public static final int PARTICIPATE = 2;
            public static final int RECEIVE_GIFT_AUTHOR = 1;
            public static final int RECEIVE_GIFT_LIVE_STREAM_AUDIENCE = 3;
            public static final int UNKNOWN_USER_TYPE = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface InteractiveType {
            public static final int LINE_CHAT = 2;
            public static final int MULTI_LINE_CHAT = 3;
            public static final int MULTI_PK = 4;
            public static final int PK = 1;
            public static final int UNKNOWN_INTERACTIVE_TYPE = 0;
        }

        public static LiveMultiInteractiveEffectControl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveMultiInteractiveEffectControl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveMultiInteractiveEffectControl() {
            clear();
        }

        public final LiveMultiInteractiveEffectControl clear() {
            this.userType = 0;
            this.whiteUser = WireFormatNano.EMPTY_STRING_ARRAY;
            this.interactiveType = 0;
            this.interactiveSceneId = "";
            this.oldMultiLineChatId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.userType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            String[] strArr = this.whiteUser;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.whiteUser;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(2, str);
                    }
                    i2++;
                }
            }
            int i3 = this.interactiveType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i3);
            }
            if (!this.interactiveSceneId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.interactiveSceneId);
            }
            if (!this.oldMultiLineChatId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.oldMultiLineChatId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.userType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            String[] strArr = this.whiteUser;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.whiteUser;
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
            int i4 = this.interactiveType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i4);
            }
            if (!this.interactiveSceneId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.interactiveSceneId);
            }
            return !this.oldMultiLineChatId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.oldMultiLineChatId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveMultiInteractiveEffectControl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.userType = int32;
                    }
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    String[] strArr = this.whiteUser;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.whiteUser, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.whiteUser = strArr2;
                } else if (tag == 24) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3 || int322 == 4) {
                        this.interactiveType = int322;
                    }
                } else if (tag == 34) {
                    this.interactiveSceneId = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.oldMultiLineChatId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveMultiInteractiveEffectControl parseFrom(byte[] bArr) {
            return (LiveMultiInteractiveEffectControl) MessageNano.mergeFrom(new LiveMultiInteractiveEffectControl(), bArr);
        }

        public static LiveMultiInteractiveEffectControl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveMultiInteractiveEffectControl().mergeFrom(codedInputByteBufferNano);
        }
    }
}
