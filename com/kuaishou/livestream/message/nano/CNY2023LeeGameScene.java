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
public final class CNY2023LeeGameScene extends MessageNano {
    private static volatile CNY2023LeeGameScene[] _emptyArray;
    public int actionType;
    public long afterX;
    public long beforeX;
    public long endTime;
    public int gameType;
    public PopUpInfo popupInfo;
    public long random;
    public int sessionId;
    public DrawMillionStarUser[] starUser;
    public long startTime;
    public Widget widget;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CNY2023GameActionType {
        public static final int ACTION_DELETE = 1;
        public static final int ACTION_UPDATE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CNY2023GameType {
        public static final int CHALLENGE_GAME = 2;
        public static final int NUMBER_GAME = 1;
        public static final int TASK_GAME = 3;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CNY2023LiveTimeLimitType {
        public static final int INVITE_WIDGET = 0;
        public static final int RANK_WIDGET = 1;
    }

    public static final class PopUpInfo extends MessageNano {
        private static volatile PopUpInfo[] _emptyArray;
        public String fixContent;
        public long rankSize;
        public long rankTotalAward;
        public String routeUrl;
        public long singleRedPacketAssists;
        public long singleRedPacketAward;
        public int taskType;

        public static PopUpInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PopUpInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PopUpInfo() {
            clear();
        }

        public final PopUpInfo clear() {
            this.routeUrl = "";
            this.rankSize = 0L;
            this.rankTotalAward = 0L;
            this.fixContent = "";
            this.singleRedPacketAssists = 0L;
            this.singleRedPacketAward = 0L;
            this.taskType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.routeUrl.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.routeUrl);
            }
            long j = this.rankSize;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            long j2 = this.rankTotalAward;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(3, j2);
            }
            if (!this.fixContent.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.fixContent);
            }
            long j3 = this.singleRedPacketAssists;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeInt64(5, j3);
            }
            long j4 = this.singleRedPacketAward;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeInt64(6, j4);
            }
            int i = this.taskType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(7, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.routeUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.routeUrl);
            }
            long j = this.rankSize;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            long j2 = this.rankTotalAward;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j2);
            }
            if (!this.fixContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.fixContent);
            }
            long j3 = this.singleRedPacketAssists;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
            }
            long j4 = this.singleRedPacketAward;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j4);
            }
            int i = this.taskType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PopUpInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.routeUrl = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.rankSize = codedInputByteBufferNano.readInt64();
                } else if (tag == 24) {
                    this.rankTotalAward = codedInputByteBufferNano.readInt64();
                } else if (tag == 34) {
                    this.fixContent = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    this.singleRedPacketAssists = codedInputByteBufferNano.readInt64();
                } else if (tag == 48) {
                    this.singleRedPacketAward = codedInputByteBufferNano.readInt64();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.taskType = int32;
                    }
                }
            }
        }

        public static PopUpInfo parseFrom(byte[] bArr) {
            return (PopUpInfo) MessageNano.mergeFrom(new PopUpInfo(), bArr);
        }

        public static PopUpInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PopUpInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static CNY2023LeeGameScene[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CNY2023LeeGameScene[0];
                }
            }
        }
        return _emptyArray;
    }

    public CNY2023LeeGameScene() {
        clear();
    }

    public final CNY2023LeeGameScene clear() {
        this.actionType = 0;
        this.gameType = 0;
        this.sessionId = 0;
        this.startTime = 0L;
        this.endTime = 0L;
        this.random = 0L;
        this.beforeX = 0L;
        this.afterX = 0L;
        this.starUser = DrawMillionStarUser.emptyArray();
        this.widget = null;
        this.popupInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.actionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.gameType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        int i3 = this.sessionId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j = this.startTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.endTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.random;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        long j4 = this.beforeX;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j4);
        }
        long j5 = this.afterX;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j5);
        }
        DrawMillionStarUser[] drawMillionStarUserArr = this.starUser;
        if (drawMillionStarUserArr != null && drawMillionStarUserArr.length > 0) {
            int i4 = 0;
            while (true) {
                DrawMillionStarUser[] drawMillionStarUserArr2 = this.starUser;
                if (i4 >= drawMillionStarUserArr2.length) {
                    break;
                }
                DrawMillionStarUser drawMillionStarUser = drawMillionStarUserArr2[i4];
                if (drawMillionStarUser != null) {
                    codedOutputByteBufferNano.writeMessage(9, drawMillionStarUser);
                }
                i4++;
            }
        }
        Widget widget = this.widget;
        if (widget != null) {
            codedOutputByteBufferNano.writeMessage(10, widget);
        }
        PopUpInfo popUpInfo = this.popupInfo;
        if (popUpInfo != null) {
            codedOutputByteBufferNano.writeMessage(11, popUpInfo);
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
        int i2 = this.gameType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        int i3 = this.sessionId;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j = this.startTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.endTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.random;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        long j4 = this.beforeX;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
        }
        long j5 = this.afterX;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j5);
        }
        DrawMillionStarUser[] drawMillionStarUserArr = this.starUser;
        if (drawMillionStarUserArr != null && drawMillionStarUserArr.length > 0) {
            int i4 = 0;
            while (true) {
                DrawMillionStarUser[] drawMillionStarUserArr2 = this.starUser;
                if (i4 >= drawMillionStarUserArr2.length) {
                    break;
                }
                DrawMillionStarUser drawMillionStarUser = drawMillionStarUserArr2[i4];
                if (drawMillionStarUser != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, drawMillionStarUser);
                }
                i4++;
            }
        }
        Widget widget = this.widget;
        if (widget != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, widget);
        }
        PopUpInfo popUpInfo = this.popupInfo;
        return popUpInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, popUpInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final CNY2023LeeGameScene mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1) {
                        break;
                    } else {
                        this.actionType = int32;
                        break;
                    }
                    break;
                case 16:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3) {
                        break;
                    } else {
                        this.gameType = int322;
                        break;
                    }
                    break;
                case 24:
                    this.sessionId = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.startTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.endTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.random = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.beforeX = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.afterX = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    DrawMillionStarUser[] drawMillionStarUserArr = this.starUser;
                    int length = drawMillionStarUserArr == null ? 0 : drawMillionStarUserArr.length;
                    DrawMillionStarUser[] drawMillionStarUserArr2 = new DrawMillionStarUser[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.starUser, 0, drawMillionStarUserArr2, 0, length);
                    }
                    while (length < drawMillionStarUserArr2.length - 1) {
                        drawMillionStarUserArr2[length] = new DrawMillionStarUser();
                        codedInputByteBufferNano.readMessage(drawMillionStarUserArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    drawMillionStarUserArr2[length] = new DrawMillionStarUser();
                    codedInputByteBufferNano.readMessage(drawMillionStarUserArr2[length]);
                    this.starUser = drawMillionStarUserArr2;
                    break;
                case 82:
                    if (this.widget == null) {
                        this.widget = new Widget();
                    }
                    codedInputByteBufferNano.readMessage(this.widget);
                    break;
                case 90:
                    if (this.popupInfo == null) {
                        this.popupInfo = new PopUpInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.popupInfo);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static CNY2023LeeGameScene parseFrom(byte[] bArr) {
        return (CNY2023LeeGameScene) MessageNano.mergeFrom(new CNY2023LeeGameScene(), bArr);
    }

    public static CNY2023LeeGameScene parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new CNY2023LeeGameScene().mergeFrom(codedInputByteBufferNano);
    }
}
