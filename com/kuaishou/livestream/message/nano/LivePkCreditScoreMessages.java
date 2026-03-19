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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePkCreditScoreMessages {

    public static final class LivePkPanelNoticeTipV2 extends MessageNano {
        private static volatile LivePkPanelNoticeTipV2[] _emptyArray;
        public NoticeDiffModel appDiffModel;
        public Map<String, String> extraInfo;
        public long noticeShowMills;
        public String noticeText;
        public String noticeTextColor;
        public int noticeType;
        public NoticeDiffModel pcDiffModel;
        public LivePkPanelNoticeTipPlaceHolder[] placeHolder;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LivePkPanelNoticeTipType {
            public static final int INFERIOR_AUTHOR = 1;
            public static final int MAGIC_FACE = 2;
            public static final int PARALLEL_INVITE_NOTICE = 5;
            public static final int PK_CREDIT_SCORE_UPDATE = 4;
            public static final int PK_NEW_RESERVATION_NOTICE = 6;
            public static final int POLICY_NOTICE = 3;
            public static final int UNKNOWN = 0;
        }

        public static final class LivePkPanelNoticeTipPlaceHolder extends MessageNano {
            private static volatile LivePkPanelNoticeTipPlaceHolder[] _emptyArray;
            public String placeHolderKey;
            public String placeHolderText;
            public String placeHolderTextColor;

            public static LivePkPanelNoticeTipPlaceHolder[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new LivePkPanelNoticeTipPlaceHolder[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public LivePkPanelNoticeTipPlaceHolder() {
                clear();
            }

            public final LivePkPanelNoticeTipPlaceHolder clear() {
                this.placeHolderKey = "";
                this.placeHolderText = "";
                this.placeHolderTextColor = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                if (!this.placeHolderKey.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.placeHolderKey);
                }
                if (!this.placeHolderText.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.placeHolderText);
                }
                if (!this.placeHolderTextColor.equals("")) {
                    codedOutputByteBufferNano.writeString(3, this.placeHolderTextColor);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                if (!this.placeHolderKey.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.placeHolderKey);
                }
                if (!this.placeHolderText.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.placeHolderText);
                }
                return !this.placeHolderTextColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.placeHolderTextColor) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final LivePkPanelNoticeTipPlaceHolder mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        this.placeHolderKey = codedInputByteBufferNano.readString();
                    } else if (tag == 18) {
                        this.placeHolderText = codedInputByteBufferNano.readString();
                    } else if (tag != 26) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.placeHolderTextColor = codedInputByteBufferNano.readString();
                    }
                }
            }

            public static LivePkPanelNoticeTipPlaceHolder parseFrom(byte[] bArr) {
                return (LivePkPanelNoticeTipPlaceHolder) MessageNano.mergeFrom(new LivePkPanelNoticeTipPlaceHolder(), bArr);
            }

            public static LivePkPanelNoticeTipPlaceHolder parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new LivePkPanelNoticeTipPlaceHolder().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static final class NoticeDiffModel extends MessageNano {
            private static volatile NoticeDiffModel[] _emptyArray;
            public UserInfos.PicUrl[] backgroundUrl;
            public String clickActionUrl;

            public static NoticeDiffModel[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new NoticeDiffModel[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public NoticeDiffModel() {
                clear();
            }

            public final NoticeDiffModel clear() {
                this.backgroundUrl = UserInfos.PicUrl.emptyArray();
                this.clickActionUrl = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                UserInfos.PicUrl[] picUrlArr = this.backgroundUrl;
                if (picUrlArr != null && picUrlArr.length > 0) {
                    int i = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr2 = this.backgroundUrl;
                        if (i >= picUrlArr2.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl = picUrlArr2[i];
                        if (picUrl != null) {
                            codedOutputByteBufferNano.writeMessage(1, picUrl);
                        }
                        i++;
                    }
                }
                if (!this.clickActionUrl.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.clickActionUrl);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                UserInfos.PicUrl[] picUrlArr = this.backgroundUrl;
                if (picUrlArr != null && picUrlArr.length > 0) {
                    int i = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr2 = this.backgroundUrl;
                        if (i >= picUrlArr2.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl = picUrlArr2[i];
                        if (picUrl != null) {
                            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                        }
                        i++;
                    }
                }
                return !this.clickActionUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.clickActionUrl) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final NoticeDiffModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        UserInfos.PicUrl[] picUrlArr = this.backgroundUrl;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.backgroundUrl, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.backgroundUrl = picUrlArr2;
                    } else if (tag != 18) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.clickActionUrl = codedInputByteBufferNano.readString();
                    }
                }
            }

            public static NoticeDiffModel parseFrom(byte[] bArr) {
                return (NoticeDiffModel) MessageNano.mergeFrom(new NoticeDiffModel(), bArr);
            }

            public static NoticeDiffModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new NoticeDiffModel().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static LivePkPanelNoticeTipV2[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePkPanelNoticeTipV2[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePkPanelNoticeTipV2() {
            clear();
        }

        public final LivePkPanelNoticeTipV2 clear() {
            this.noticeType = 0;
            this.noticeText = "";
            this.noticeTextColor = "";
            this.noticeShowMills = 0L;
            this.placeHolder = LivePkPanelNoticeTipPlaceHolder.emptyArray();
            this.extraInfo = null;
            this.pcDiffModel = null;
            this.appDiffModel = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i = this.noticeType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.noticeText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.noticeText);
            }
            if (!this.noticeTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.noticeTextColor);
            }
            long j = this.noticeShowMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            LivePkPanelNoticeTipPlaceHolder[] livePkPanelNoticeTipPlaceHolderArr = this.placeHolder;
            if (livePkPanelNoticeTipPlaceHolderArr != null && livePkPanelNoticeTipPlaceHolderArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LivePkPanelNoticeTipPlaceHolder[] livePkPanelNoticeTipPlaceHolderArr2 = this.placeHolder;
                    if (i2 >= livePkPanelNoticeTipPlaceHolderArr2.length) {
                        break;
                    }
                    LivePkPanelNoticeTipPlaceHolder livePkPanelNoticeTipPlaceHolder = livePkPanelNoticeTipPlaceHolderArr2[i2];
                    if (livePkPanelNoticeTipPlaceHolder != null) {
                        codedOutputByteBufferNano.writeMessage(5, livePkPanelNoticeTipPlaceHolder);
                    }
                    i2++;
                }
            }
            Map<String, String> map = this.extraInfo;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 6, 9, 9);
            }
            NoticeDiffModel noticeDiffModel = this.pcDiffModel;
            if (noticeDiffModel != null) {
                codedOutputByteBufferNano.writeMessage(7, noticeDiffModel);
            }
            NoticeDiffModel noticeDiffModel2 = this.appDiffModel;
            if (noticeDiffModel2 != null) {
                codedOutputByteBufferNano.writeMessage(8, noticeDiffModel2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.noticeType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.noticeText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.noticeText);
            }
            if (!this.noticeTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.noticeTextColor);
            }
            long j = this.noticeShowMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            LivePkPanelNoticeTipPlaceHolder[] livePkPanelNoticeTipPlaceHolderArr = this.placeHolder;
            if (livePkPanelNoticeTipPlaceHolderArr != null && livePkPanelNoticeTipPlaceHolderArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LivePkPanelNoticeTipPlaceHolder[] livePkPanelNoticeTipPlaceHolderArr2 = this.placeHolder;
                    if (i2 >= livePkPanelNoticeTipPlaceHolderArr2.length) {
                        break;
                    }
                    LivePkPanelNoticeTipPlaceHolder livePkPanelNoticeTipPlaceHolder = livePkPanelNoticeTipPlaceHolderArr2[i2];
                    if (livePkPanelNoticeTipPlaceHolder != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, livePkPanelNoticeTipPlaceHolder);
                    }
                    i2++;
                }
            }
            Map<String, String> map = this.extraInfo;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 6, 9, 9);
            }
            NoticeDiffModel noticeDiffModel = this.pcDiffModel;
            if (noticeDiffModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, noticeDiffModel);
            }
            NoticeDiffModel noticeDiffModel2 = this.appDiffModel;
            return noticeDiffModel2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, noticeDiffModel2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePkPanelNoticeTipV2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.noticeType = int32;
                            break;
                    }
                } else if (tag == 18) {
                    this.noticeText = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.noticeTextColor = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.noticeShowMills = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LivePkPanelNoticeTipPlaceHolder[] livePkPanelNoticeTipPlaceHolderArr = this.placeHolder;
                    int length = livePkPanelNoticeTipPlaceHolderArr == null ? 0 : livePkPanelNoticeTipPlaceHolderArr.length;
                    LivePkPanelNoticeTipPlaceHolder[] livePkPanelNoticeTipPlaceHolderArr2 = new LivePkPanelNoticeTipPlaceHolder[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.placeHolder, 0, livePkPanelNoticeTipPlaceHolderArr2, 0, length);
                    }
                    while (length < livePkPanelNoticeTipPlaceHolderArr2.length - 1) {
                        livePkPanelNoticeTipPlaceHolderArr2[length] = new LivePkPanelNoticeTipPlaceHolder();
                        codedInputByteBufferNano.readMessage(livePkPanelNoticeTipPlaceHolderArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    livePkPanelNoticeTipPlaceHolderArr2[length] = new LivePkPanelNoticeTipPlaceHolder();
                    codedInputByteBufferNano.readMessage(livePkPanelNoticeTipPlaceHolderArr2[length]);
                    this.placeHolder = livePkPanelNoticeTipPlaceHolderArr2;
                } else if (tag == 50) {
                    this.extraInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraInfo, mapFactory, 9, 9, null, 10, 18);
                } else if (tag == 58) {
                    if (this.pcDiffModel == null) {
                        this.pcDiffModel = new NoticeDiffModel();
                    }
                    codedInputByteBufferNano.readMessage(this.pcDiffModel);
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.appDiffModel == null) {
                        this.appDiffModel = new NoticeDiffModel();
                    }
                    codedInputByteBufferNano.readMessage(this.appDiffModel);
                }
            }
        }

        public static LivePkPanelNoticeTipV2 parseFrom(byte[] bArr) {
            return (LivePkPanelNoticeTipV2) MessageNano.mergeFrom(new LivePkPanelNoticeTipV2(), bArr);
        }

        public static LivePkPanelNoticeTipV2 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePkPanelNoticeTipV2().mergeFrom(codedInputByteBufferNano);
        }
    }
}
