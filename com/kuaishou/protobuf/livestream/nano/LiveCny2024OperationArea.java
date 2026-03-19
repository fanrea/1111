package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024OperationArea {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Cny2024PendantActionType {
        public static final int BUBBLE = 4;
        public static final int HIGHLIGHT = 5;
        public static final int OFFLINE_CNY2024_PENDANT = 2;
        public static final int ONLINE_CNY2024_PENDANT = 1;
        public static final int UNKNOWN_CNY2024_ACTION_TYPE = 0;
        public static final int UPDATE_CNY2024_PENDANT = 3;
    }

    public static final class Cny2024BasicPendant extends MessageNano {
        private static volatile Cny2024BasicPendant[] _emptyArray;
        public String icon;
        public String jumpUrl;
        public String pendantBgImg;
        public String pendantBiz;
        public String pendantId;
        public String title;
        public String titleBgImg;

        public static Cny2024BasicPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Cny2024BasicPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Cny2024BasicPendant() {
            clear();
        }

        public final Cny2024BasicPendant clear() {
            this.pendantId = "";
            this.icon = "";
            this.title = "";
            this.jumpUrl = "";
            this.pendantBiz = "";
            this.pendantBgImg = "";
            this.titleBgImg = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pendantId);
            }
            if (!this.icon.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.icon);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.title);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.jumpUrl);
            }
            if (!this.pendantBiz.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.pendantBiz);
            }
            if (!this.pendantBgImg.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.pendantBgImg);
            }
            if (!this.titleBgImg.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.titleBgImg);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.pendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pendantId);
            }
            if (!this.icon.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.icon);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.title);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.jumpUrl);
            }
            if (!this.pendantBiz.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.pendantBiz);
            }
            if (!this.pendantBgImg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.pendantBgImg);
            }
            return !this.titleBgImg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.titleBgImg) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Cny2024BasicPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pendantId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.icon = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.pendantBiz = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.pendantBgImg = codedInputByteBufferNano.readString();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.titleBgImg = codedInputByteBufferNano.readString();
                }
            }
        }

        public static Cny2024BasicPendant parseFrom(byte[] bArr) {
            return (Cny2024BasicPendant) MessageNano.mergeFrom(new Cny2024BasicPendant(), bArr);
        }

        public static Cny2024BasicPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Cny2024BasicPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Cny2024PendantLottieInfo extends MessageNano {
        private static volatile Cny2024PendantLottieInfo[] _emptyArray;
        public String ani;
        public long aniCount;
        public String lowAni;

        public static Cny2024PendantLottieInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Cny2024PendantLottieInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Cny2024PendantLottieInfo() {
            clear();
        }

        public final Cny2024PendantLottieInfo clear() {
            this.ani = "";
            this.aniCount = 0L;
            this.lowAni = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.ani.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.ani);
            }
            long j = this.aniCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            if (!this.lowAni.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.lowAni);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.ani.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.ani);
            }
            long j = this.aniCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            return !this.lowAni.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.lowAni) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Cny2024PendantLottieInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.ani = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.aniCount = codedInputByteBufferNano.readInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.lowAni = codedInputByteBufferNano.readString();
                }
            }
        }

        public static Cny2024PendantLottieInfo parseFrom(byte[] bArr) {
            return (Cny2024PendantLottieInfo) MessageNano.mergeFrom(new Cny2024PendantLottieInfo(), bArr);
        }

        public static Cny2024PendantLottieInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Cny2024PendantLottieInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Cny2024Bubble extends MessageNano {
        private static volatile Cny2024Bubble[] _emptyArray;
        public long durationMs;
        public String msgId;
        public String popupText;
        public String subBizType;

        public static Cny2024Bubble[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Cny2024Bubble[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Cny2024Bubble() {
            clear();
        }

        public final Cny2024Bubble clear() {
            this.popupText = "";
            this.durationMs = 0L;
            this.subBizType = "";
            this.msgId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.popupText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.popupText);
            }
            long j = this.durationMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            if (!this.subBizType.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.subBizType);
            }
            if (!this.msgId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.msgId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.popupText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.popupText);
            }
            long j = this.durationMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            if (!this.subBizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.subBizType);
            }
            return !this.msgId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.msgId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Cny2024Bubble mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.popupText = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.durationMs = codedInputByteBufferNano.readInt64();
                } else if (tag == 26) {
                    this.subBizType = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.msgId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static Cny2024Bubble parseFrom(byte[] bArr) {
            return (Cny2024Bubble) MessageNano.mergeFrom(new Cny2024Bubble(), bArr);
        }

        public static Cny2024Bubble parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Cny2024Bubble().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Cny2024PendantHighlight extends MessageNano {
        private static volatile Cny2024PendantHighlight[] _emptyArray;
        public long cnt;
        public Cny2024PendantLottieInfo lottieInfo;
        public String msgId;
        public String subBizType;
        public int type;

        @Retention(RetentionPolicy.SOURCE)
        public @interface HighLightType {
            public static final int CNY2024_LOTTIE = 1;
            public static final int SHAKE = 2;
            public static final int UNKNOWN_CNY2024_HIGHLIGHT_TYPE = 0;
        }

        public static Cny2024PendantHighlight[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Cny2024PendantHighlight[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Cny2024PendantHighlight() {
            clear();
        }

        public final Cny2024PendantHighlight clear() {
            this.type = 0;
            this.lottieInfo = null;
            this.cnt = 0L;
            this.subBizType = "";
            this.msgId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            Cny2024PendantLottieInfo cny2024PendantLottieInfo = this.lottieInfo;
            if (cny2024PendantLottieInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, cny2024PendantLottieInfo);
            }
            long j = this.cnt;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            if (!this.subBizType.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.subBizType);
            }
            if (!this.msgId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.msgId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            Cny2024PendantLottieInfo cny2024PendantLottieInfo = this.lottieInfo;
            if (cny2024PendantLottieInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cny2024PendantLottieInfo);
            }
            long j = this.cnt;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
            }
            if (!this.subBizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.subBizType);
            }
            return !this.msgId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.msgId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Cny2024PendantHighlight mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.type = int32;
                    }
                } else if (tag == 18) {
                    if (this.lottieInfo == null) {
                        this.lottieInfo = new Cny2024PendantLottieInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.lottieInfo);
                } else if (tag == 24) {
                    this.cnt = codedInputByteBufferNano.readInt64();
                } else if (tag == 34) {
                    this.subBizType = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.msgId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static Cny2024PendantHighlight parseFrom(byte[] bArr) {
            return (Cny2024PendantHighlight) MessageNano.mergeFrom(new Cny2024PendantHighlight(), bArr);
        }

        public static Cny2024PendantHighlight parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Cny2024PendantHighlight().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Cny2024RightBottomPendant extends MessageNano {
        private static volatile Cny2024RightBottomPendant[] _emptyArray;
        public Cny2024BasicPendant basicPendantProperty;
        public String placeHolderId;
        public int priority;

        public static Cny2024RightBottomPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Cny2024RightBottomPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Cny2024RightBottomPendant() {
            clear();
        }

        public final Cny2024RightBottomPendant clear() {
            this.basicPendantProperty = null;
            this.placeHolderId = "";
            this.priority = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Cny2024BasicPendant cny2024BasicPendant = this.basicPendantProperty;
            if (cny2024BasicPendant != null) {
                codedOutputByteBufferNano.writeMessage(1, cny2024BasicPendant);
            }
            if (!this.placeHolderId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.placeHolderId);
            }
            int i = this.priority;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Cny2024BasicPendant cny2024BasicPendant = this.basicPendantProperty;
            if (cny2024BasicPendant != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cny2024BasicPendant);
            }
            if (!this.placeHolderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.placeHolderId);
            }
            int i = this.priority;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Cny2024RightBottomPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.basicPendantProperty == null) {
                        this.basicPendantProperty = new Cny2024BasicPendant();
                    }
                    codedInputByteBufferNano.readMessage(this.basicPendantProperty);
                } else if (tag == 18) {
                    this.placeHolderId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.priority = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static Cny2024RightBottomPendant parseFrom(byte[] bArr) {
            return (Cny2024RightBottomPendant) MessageNano.mergeFrom(new Cny2024RightBottomPendant(), bArr);
        }

        public static Cny2024RightBottomPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Cny2024RightBottomPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024RightBottomPendantAction extends MessageNano {
        public static final int BUBBLE_INFO_FIELD_NUMBER = 4;
        public static final int HIGH_LIGHT_INFO_FIELD_NUMBER = 3;
        public static final int NEW_PENDENT_INFO_FIELD_NUMBER = 5;
        private static volatile SCLiveCny2024RightBottomPendantAction[] _emptyArray;
        private int actionInfoCase_ = 0;
        private Object actionInfo_;
        public int actionType;
        public String pendantId;
        public long version;

        public final int getActionInfoCase() {
            return this.actionInfoCase_;
        }

        public final SCLiveCny2024RightBottomPendantAction clearActionInfo() {
            this.actionInfoCase_ = 0;
            this.actionInfo_ = null;
            return this;
        }

        public static SCLiveCny2024RightBottomPendantAction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024RightBottomPendantAction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasHighLightInfo() {
            return this.actionInfoCase_ == 3;
        }

        public final Cny2024PendantHighlight getHighLightInfo() {
            if (this.actionInfoCase_ == 3) {
                return (Cny2024PendantHighlight) this.actionInfo_;
            }
            return null;
        }

        public final SCLiveCny2024RightBottomPendantAction setHighLightInfo(Cny2024PendantHighlight cny2024PendantHighlight) {
            if (cny2024PendantHighlight == null) {
                throw new NullPointerException();
            }
            this.actionInfoCase_ = 3;
            this.actionInfo_ = cny2024PendantHighlight;
            return this;
        }

        public final boolean hasBubbleInfo() {
            return this.actionInfoCase_ == 4;
        }

        public final Cny2024Bubble getBubbleInfo() {
            if (this.actionInfoCase_ == 4) {
                return (Cny2024Bubble) this.actionInfo_;
            }
            return null;
        }

        public final SCLiveCny2024RightBottomPendantAction setBubbleInfo(Cny2024Bubble cny2024Bubble) {
            if (cny2024Bubble == null) {
                throw new NullPointerException();
            }
            this.actionInfoCase_ = 4;
            this.actionInfo_ = cny2024Bubble;
            return this;
        }

        public final boolean hasNewPendentInfo() {
            return this.actionInfoCase_ == 5;
        }

        public final Cny2024RightBottomPendant getNewPendentInfo() {
            if (this.actionInfoCase_ == 5) {
                return (Cny2024RightBottomPendant) this.actionInfo_;
            }
            return null;
        }

        public final SCLiveCny2024RightBottomPendantAction setNewPendentInfo(Cny2024RightBottomPendant cny2024RightBottomPendant) {
            if (cny2024RightBottomPendant == null) {
                throw new NullPointerException();
            }
            this.actionInfoCase_ = 5;
            this.actionInfo_ = cny2024RightBottomPendant;
            return this;
        }

        public SCLiveCny2024RightBottomPendantAction() {
            clear();
        }

        public final SCLiveCny2024RightBottomPendantAction clear() {
            this.actionType = 0;
            this.pendantId = "";
            this.version = 0L;
            clearActionInfo();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.actionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.pendantId);
            }
            if (this.actionInfoCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.actionInfo_);
            }
            if (this.actionInfoCase_ == 4) {
                codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.actionInfo_);
            }
            if (this.actionInfoCase_ == 5) {
                codedOutputByteBufferNano.writeMessage(5, (MessageNano) this.actionInfo_);
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(6, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.actionType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.pendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.pendantId);
            }
            if (this.actionInfoCase_ == 3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.actionInfo_);
            }
            if (this.actionInfoCase_ == 4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.actionInfo_);
            }
            if (this.actionInfoCase_ == 5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano) this.actionInfo_);
            }
            long j = this.version;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(6, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024RightBottomPendantAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                        this.actionType = int32;
                    }
                } else if (tag == 18) {
                    this.pendantId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    if (this.actionInfoCase_ != 3) {
                        this.actionInfo_ = new Cny2024PendantHighlight();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.actionInfo_);
                    this.actionInfoCase_ = 3;
                } else if (tag == 34) {
                    if (this.actionInfoCase_ != 4) {
                        this.actionInfo_ = new Cny2024Bubble();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.actionInfo_);
                    this.actionInfoCase_ = 4;
                } else if (tag == 42) {
                    if (this.actionInfoCase_ != 5) {
                        this.actionInfo_ = new Cny2024RightBottomPendant();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.actionInfo_);
                    this.actionInfoCase_ = 5;
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.version = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static SCLiveCny2024RightBottomPendantAction parseFrom(byte[] bArr) {
            return (SCLiveCny2024RightBottomPendantAction) MessageNano.mergeFrom(new SCLiveCny2024RightBottomPendantAction(), bArr);
        }

        public static SCLiveCny2024RightBottomPendantAction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024RightBottomPendantAction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024CoreOperationPendantAction extends MessageNano {
        public static final int BUBBLE_INFO_FIELD_NUMBER = 4;
        public static final int HIGH_LIGHT_INFO_FIELD_NUMBER = 3;
        private static volatile SCLiveCny2024CoreOperationPendantAction[] _emptyArray;
        private int actionInfoCase_ = 0;
        private Object actionInfo_;
        public int actionType;
        public String pendantId;

        public final int getActionInfoCase() {
            return this.actionInfoCase_;
        }

        public final SCLiveCny2024CoreOperationPendantAction clearActionInfo() {
            this.actionInfoCase_ = 0;
            this.actionInfo_ = null;
            return this;
        }

        public static SCLiveCny2024CoreOperationPendantAction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024CoreOperationPendantAction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasHighLightInfo() {
            return this.actionInfoCase_ == 3;
        }

        public final Cny2024PendantHighlight getHighLightInfo() {
            if (this.actionInfoCase_ == 3) {
                return (Cny2024PendantHighlight) this.actionInfo_;
            }
            return null;
        }

        public final SCLiveCny2024CoreOperationPendantAction setHighLightInfo(Cny2024PendantHighlight cny2024PendantHighlight) {
            if (cny2024PendantHighlight == null) {
                throw new NullPointerException();
            }
            this.actionInfoCase_ = 3;
            this.actionInfo_ = cny2024PendantHighlight;
            return this;
        }

        public final boolean hasBubbleInfo() {
            return this.actionInfoCase_ == 4;
        }

        public final Cny2024Bubble getBubbleInfo() {
            if (this.actionInfoCase_ == 4) {
                return (Cny2024Bubble) this.actionInfo_;
            }
            return null;
        }

        public final SCLiveCny2024CoreOperationPendantAction setBubbleInfo(Cny2024Bubble cny2024Bubble) {
            if (cny2024Bubble == null) {
                throw new NullPointerException();
            }
            this.actionInfoCase_ = 4;
            this.actionInfo_ = cny2024Bubble;
            return this;
        }

        public SCLiveCny2024CoreOperationPendantAction() {
            clear();
        }

        public final SCLiveCny2024CoreOperationPendantAction clear() {
            this.actionType = 0;
            this.pendantId = "";
            clearActionInfo();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.actionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.pendantId);
            }
            if (this.actionInfoCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.actionInfo_);
            }
            if (this.actionInfoCase_ == 4) {
                codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.actionInfo_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.actionType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.pendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.pendantId);
            }
            if (this.actionInfoCase_ == 3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.actionInfo_);
            }
            return this.actionInfoCase_ == 4 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.actionInfo_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024CoreOperationPendantAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                        this.actionType = int32;
                    }
                } else if (tag == 18) {
                    this.pendantId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    if (this.actionInfoCase_ != 3) {
                        this.actionInfo_ = new Cny2024PendantHighlight();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.actionInfo_);
                    this.actionInfoCase_ = 3;
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.actionInfoCase_ != 4) {
                        this.actionInfo_ = new Cny2024Bubble();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.actionInfo_);
                    this.actionInfoCase_ = 4;
                }
            }
        }

        public static SCLiveCny2024CoreOperationPendantAction parseFrom(byte[] bArr) {
            return (SCLiveCny2024CoreOperationPendantAction) MessageNano.mergeFrom(new SCLiveCny2024CoreOperationPendantAction(), bArr);
        }

        public static SCLiveCny2024CoreOperationPendantAction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024CoreOperationPendantAction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024CoreOperationPendantRefresh extends MessageNano {
        private static volatile SCLiveCny2024CoreOperationPendantRefresh[] _emptyArray;
        public Cny2024BasicPendant leftConfig;
        public Cny2024BasicPendant rightConfig;
        public long version;

        public static SCLiveCny2024CoreOperationPendantRefresh[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024CoreOperationPendantRefresh[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024CoreOperationPendantRefresh() {
            clear();
        }

        public final SCLiveCny2024CoreOperationPendantRefresh clear() {
            this.leftConfig = null;
            this.rightConfig = null;
            this.version = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Cny2024BasicPendant cny2024BasicPendant = this.leftConfig;
            if (cny2024BasicPendant != null) {
                codedOutputByteBufferNano.writeMessage(1, cny2024BasicPendant);
            }
            Cny2024BasicPendant cny2024BasicPendant2 = this.rightConfig;
            if (cny2024BasicPendant2 != null) {
                codedOutputByteBufferNano.writeMessage(2, cny2024BasicPendant2);
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Cny2024BasicPendant cny2024BasicPendant = this.leftConfig;
            if (cny2024BasicPendant != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cny2024BasicPendant);
            }
            Cny2024BasicPendant cny2024BasicPendant2 = this.rightConfig;
            if (cny2024BasicPendant2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cny2024BasicPendant2);
            }
            long j = this.version;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024CoreOperationPendantRefresh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.leftConfig == null) {
                        this.leftConfig = new Cny2024BasicPendant();
                    }
                    codedInputByteBufferNano.readMessage(this.leftConfig);
                } else if (tag == 18) {
                    if (this.rightConfig == null) {
                        this.rightConfig = new Cny2024BasicPendant();
                    }
                    codedInputByteBufferNano.readMessage(this.rightConfig);
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.version = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static SCLiveCny2024CoreOperationPendantRefresh parseFrom(byte[] bArr) {
            return (SCLiveCny2024CoreOperationPendantRefresh) MessageNano.mergeFrom(new SCLiveCny2024CoreOperationPendantRefresh(), bArr);
        }

        public static SCLiveCny2024CoreOperationPendantRefresh parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024CoreOperationPendantRefresh().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Cny2024BasicOperationPendant extends MessageNano {
        private static volatile Cny2024BasicOperationPendant[] _emptyArray;
        public Cny2024BasicPendant basicPendantProperty;
        public String bgAnimationImg;
        public String bgColor;
        public String bgImg;
        public String bizParams;
        public boolean degradeA;
        public boolean degradeI;
        public String fontColor;
        public long fontSize;
        public int opType;
        public int style;

        @Retention(RetentionPolicy.SOURCE)
        public @interface BasicOperationPendantOpType {
            public static final int NORMAL = 1;
            public static final int QUICK_GIFT = 2;
            public static final int UNKNOWN = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface BasicOperationPendantStyle {
            public static final int HIGHLIGHT_STYLE = 2;
            public static final int NORMAL_STYLE = 1;
            public static final int UNKNOWN_STYLE = 0;
        }

        public static Cny2024BasicOperationPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Cny2024BasicOperationPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Cny2024BasicOperationPendant() {
            clear();
        }

        public final Cny2024BasicOperationPendant clear() {
            this.basicPendantProperty = null;
            this.opType = 0;
            this.fontSize = 0L;
            this.fontColor = "";
            this.bgImg = "";
            this.bgAnimationImg = "";
            this.bizParams = "";
            this.style = 0;
            this.bgColor = "";
            this.degradeI = false;
            this.degradeA = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Cny2024BasicPendant cny2024BasicPendant = this.basicPendantProperty;
            if (cny2024BasicPendant != null) {
                codedOutputByteBufferNano.writeMessage(1, cny2024BasicPendant);
            }
            int i = this.opType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            long j = this.fontSize;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            if (!this.fontColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.fontColor);
            }
            if (!this.bgImg.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bgImg);
            }
            if (!this.bgAnimationImg.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.bgAnimationImg);
            }
            if (!this.bizParams.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.bizParams);
            }
            int i2 = this.style;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i2);
            }
            if (!this.bgColor.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.bgColor);
            }
            boolean z = this.degradeI;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            boolean z2 = this.degradeA;
            if (z2) {
                codedOutputByteBufferNano.writeBool(11, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Cny2024BasicPendant cny2024BasicPendant = this.basicPendantProperty;
            if (cny2024BasicPendant != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cny2024BasicPendant);
            }
            int i = this.opType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            long j = this.fontSize;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
            }
            if (!this.fontColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.fontColor);
            }
            if (!this.bgImg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.bgImg);
            }
            if (!this.bgAnimationImg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.bgAnimationImg);
            }
            if (!this.bizParams.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.bizParams);
            }
            int i2 = this.style;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i2);
            }
            if (!this.bgColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.bgColor);
            }
            boolean z = this.degradeI;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            boolean z2 = this.degradeA;
            return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(11, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Cny2024BasicOperationPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.basicPendantProperty == null) {
                            this.basicPendantProperty = new Cny2024BasicPendant();
                        }
                        codedInputByteBufferNano.readMessage(this.basicPendantProperty);
                        break;
                    case 16:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            break;
                        } else {
                            this.opType = int32;
                            break;
                        }
                        break;
                    case 24:
                        this.fontSize = codedInputByteBufferNano.readInt64();
                        break;
                    case 34:
                        this.fontColor = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.bgImg = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.bgAnimationImg = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.bizParams = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1 && int322 != 2) {
                            break;
                        } else {
                            this.style = int322;
                            break;
                        }
                    case 74:
                        this.bgColor = codedInputByteBufferNano.readString();
                        break;
                    case 80:
                        this.degradeI = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.degradeA = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static Cny2024BasicOperationPendant parseFrom(byte[] bArr) {
            return (Cny2024BasicOperationPendant) MessageNano.mergeFrom(new Cny2024BasicOperationPendant(), bArr);
        }

        public static Cny2024BasicOperationPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Cny2024BasicOperationPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024BasicOperationPendantRefresh extends MessageNano {
        private static volatile SCLiveCny2024BasicOperationPendantRefresh[] _emptyArray;
        public Cny2024BasicOperationPendant[] allPendantInfo;
        public SCLiveCny2024BasicOperationPendantHighlight[] highlightPendantInfo;
        public long version;

        public static SCLiveCny2024BasicOperationPendantRefresh[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024BasicOperationPendantRefresh[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024BasicOperationPendantRefresh() {
            clear();
        }

        public final SCLiveCny2024BasicOperationPendantRefresh clear() {
            this.allPendantInfo = Cny2024BasicOperationPendant.emptyArray();
            this.version = 0L;
            this.highlightPendantInfo = SCLiveCny2024BasicOperationPendantHighlight.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Cny2024BasicOperationPendant[] cny2024BasicOperationPendantArr = this.allPendantInfo;
            int i = 0;
            if (cny2024BasicOperationPendantArr != null && cny2024BasicOperationPendantArr.length > 0) {
                int i2 = 0;
                while (true) {
                    Cny2024BasicOperationPendant[] cny2024BasicOperationPendantArr2 = this.allPendantInfo;
                    if (i2 >= cny2024BasicOperationPendantArr2.length) {
                        break;
                    }
                    Cny2024BasicOperationPendant cny2024BasicOperationPendant = cny2024BasicOperationPendantArr2[i2];
                    if (cny2024BasicOperationPendant != null) {
                        codedOutputByteBufferNano.writeMessage(1, cny2024BasicOperationPendant);
                    }
                    i2++;
                }
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            SCLiveCny2024BasicOperationPendantHighlight[] sCLiveCny2024BasicOperationPendantHighlightArr = this.highlightPendantInfo;
            if (sCLiveCny2024BasicOperationPendantHighlightArr != null && sCLiveCny2024BasicOperationPendantHighlightArr.length > 0) {
                while (true) {
                    SCLiveCny2024BasicOperationPendantHighlight[] sCLiveCny2024BasicOperationPendantHighlightArr2 = this.highlightPendantInfo;
                    if (i >= sCLiveCny2024BasicOperationPendantHighlightArr2.length) {
                        break;
                    }
                    SCLiveCny2024BasicOperationPendantHighlight sCLiveCny2024BasicOperationPendantHighlight = sCLiveCny2024BasicOperationPendantHighlightArr2[i];
                    if (sCLiveCny2024BasicOperationPendantHighlight != null) {
                        codedOutputByteBufferNano.writeMessage(3, sCLiveCny2024BasicOperationPendantHighlight);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Cny2024BasicOperationPendant[] cny2024BasicOperationPendantArr = this.allPendantInfo;
            int i = 0;
            if (cny2024BasicOperationPendantArr != null && cny2024BasicOperationPendantArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    Cny2024BasicOperationPendant[] cny2024BasicOperationPendantArr2 = this.allPendantInfo;
                    if (i2 >= cny2024BasicOperationPendantArr2.length) {
                        break;
                    }
                    Cny2024BasicOperationPendant cny2024BasicOperationPendant = cny2024BasicOperationPendantArr2[i2];
                    if (cny2024BasicOperationPendant != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, cny2024BasicOperationPendant);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            long j = this.version;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            SCLiveCny2024BasicOperationPendantHighlight[] sCLiveCny2024BasicOperationPendantHighlightArr = this.highlightPendantInfo;
            if (sCLiveCny2024BasicOperationPendantHighlightArr != null && sCLiveCny2024BasicOperationPendantHighlightArr.length > 0) {
                while (true) {
                    SCLiveCny2024BasicOperationPendantHighlight[] sCLiveCny2024BasicOperationPendantHighlightArr2 = this.highlightPendantInfo;
                    if (i >= sCLiveCny2024BasicOperationPendantHighlightArr2.length) {
                        break;
                    }
                    SCLiveCny2024BasicOperationPendantHighlight sCLiveCny2024BasicOperationPendantHighlight = sCLiveCny2024BasicOperationPendantHighlightArr2[i];
                    if (sCLiveCny2024BasicOperationPendantHighlight != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sCLiveCny2024BasicOperationPendantHighlight);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024BasicOperationPendantRefresh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Cny2024BasicOperationPendant[] cny2024BasicOperationPendantArr = this.allPendantInfo;
                    int length = cny2024BasicOperationPendantArr == null ? 0 : cny2024BasicOperationPendantArr.length;
                    Cny2024BasicOperationPendant[] cny2024BasicOperationPendantArr2 = new Cny2024BasicOperationPendant[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.allPendantInfo, 0, cny2024BasicOperationPendantArr2, 0, length);
                    }
                    while (length < cny2024BasicOperationPendantArr2.length - 1) {
                        cny2024BasicOperationPendantArr2[length] = new Cny2024BasicOperationPendant();
                        codedInputByteBufferNano.readMessage(cny2024BasicOperationPendantArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    cny2024BasicOperationPendantArr2[length] = new Cny2024BasicOperationPendant();
                    codedInputByteBufferNano.readMessage(cny2024BasicOperationPendantArr2[length]);
                    this.allPendantInfo = cny2024BasicOperationPendantArr2;
                } else if (tag == 16) {
                    this.version = codedInputByteBufferNano.readInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    SCLiveCny2024BasicOperationPendantHighlight[] sCLiveCny2024BasicOperationPendantHighlightArr = this.highlightPendantInfo;
                    int length2 = sCLiveCny2024BasicOperationPendantHighlightArr == null ? 0 : sCLiveCny2024BasicOperationPendantHighlightArr.length;
                    SCLiveCny2024BasicOperationPendantHighlight[] sCLiveCny2024BasicOperationPendantHighlightArr2 = new SCLiveCny2024BasicOperationPendantHighlight[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.highlightPendantInfo, 0, sCLiveCny2024BasicOperationPendantHighlightArr2, 0, length2);
                    }
                    while (length2 < sCLiveCny2024BasicOperationPendantHighlightArr2.length - 1) {
                        sCLiveCny2024BasicOperationPendantHighlightArr2[length2] = new SCLiveCny2024BasicOperationPendantHighlight();
                        codedInputByteBufferNano.readMessage(sCLiveCny2024BasicOperationPendantHighlightArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    sCLiveCny2024BasicOperationPendantHighlightArr2[length2] = new SCLiveCny2024BasicOperationPendantHighlight();
                    codedInputByteBufferNano.readMessage(sCLiveCny2024BasicOperationPendantHighlightArr2[length2]);
                    this.highlightPendantInfo = sCLiveCny2024BasicOperationPendantHighlightArr2;
                }
            }
        }

        public static SCLiveCny2024BasicOperationPendantRefresh parseFrom(byte[] bArr) {
            return (SCLiveCny2024BasicOperationPendantRefresh) MessageNano.mergeFrom(new SCLiveCny2024BasicOperationPendantRefresh(), bArr);
        }

        public static SCLiveCny2024BasicOperationPendantRefresh parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024BasicOperationPendantRefresh().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024BasicOperationPendantHighlight extends MessageNano {
        private static volatile SCLiveCny2024BasicOperationPendantHighlight[] _emptyArray;
        public long durationMs;
        public String msgId;
        public Cny2024BasicOperationPendant newPendantInfo;
        public String pendantId;
        public String subBizType;

        public static SCLiveCny2024BasicOperationPendantHighlight[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024BasicOperationPendantHighlight[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024BasicOperationPendantHighlight() {
            clear();
        }

        public final SCLiveCny2024BasicOperationPendantHighlight clear() {
            this.pendantId = "";
            this.durationMs = 0L;
            this.newPendantInfo = null;
            this.subBizType = "";
            this.msgId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pendantId);
            }
            long j = this.durationMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            Cny2024BasicOperationPendant cny2024BasicOperationPendant = this.newPendantInfo;
            if (cny2024BasicOperationPendant != null) {
                codedOutputByteBufferNano.writeMessage(3, cny2024BasicOperationPendant);
            }
            if (!this.subBizType.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.subBizType);
            }
            if (!this.msgId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.msgId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.pendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pendantId);
            }
            long j = this.durationMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            Cny2024BasicOperationPendant cny2024BasicOperationPendant = this.newPendantInfo;
            if (cny2024BasicOperationPendant != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cny2024BasicOperationPendant);
            }
            if (!this.subBizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.subBizType);
            }
            return !this.msgId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.msgId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024BasicOperationPendantHighlight mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pendantId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.durationMs = codedInputByteBufferNano.readInt64();
                } else if (tag == 26) {
                    if (this.newPendantInfo == null) {
                        this.newPendantInfo = new Cny2024BasicOperationPendant();
                    }
                    codedInputByteBufferNano.readMessage(this.newPendantInfo);
                } else if (tag == 34) {
                    this.subBizType = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.msgId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCny2024BasicOperationPendantHighlight parseFrom(byte[] bArr) {
            return (SCLiveCny2024BasicOperationPendantHighlight) MessageNano.mergeFrom(new SCLiveCny2024BasicOperationPendantHighlight(), bArr);
        }

        public static SCLiveCny2024BasicOperationPendantHighlight parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024BasicOperationPendantHighlight().mergeFrom(codedInputByteBufferNano);
        }
    }
}
