package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.cny2023.message.nano.CnyCdnDegradeProto;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024Battle {

    public static final class SCRedBlueBattleState extends MessageNano {
        private static volatile SCRedBlueBattleState[] _emptyArray;
        public String activityId;
        public String barTitle;
        public String battleId;
        public MainButtonBubble battleStartButtonBubble;
        public String displayTotalPoolAmount;
        public String displayTotalPoolAmountNum;
        public String displayTotalPoolAmountUnit;
        public String infoBar;
        public RedBlueBattleInfoBarModel infoBarModel;
        public RedBlueBattleMainButton[] mainButton;
        public MainButtonBubble showStartButtonBubble;
        public RedBlueBattleSkinInfo skinInfo;
        public int stateType;
        public SCRedBlueBattleStatistic statistic;
        public long timestamp;
        public long version;
        public int winTeamId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface BattleStateType {
            public static final int BATTLE_END_IDLE = 11;
            public static final int BLUE_SHOW = 6;
            public static final int BLUE_SHOW_IDLE = 7;
            public static final int COOLING_OFF = 12;
            public static final int NOT_IN_BATTLE = 1;
            public static final int PK_END_IDLE = 10;
            public static final int PK_VOTE_END = 9;
            public static final int PREVIEW = 3;
            public static final int RED_BLUE_PK = 8;
            public static final int RED_SHOW = 4;
            public static final int RED_SHOW_IDLE = 5;
            public static final int TRANSITION = 2;
            public static final int UNKNOWN_STATE = 0;
        }

        public static SCRedBlueBattleState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCRedBlueBattleState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCRedBlueBattleState() {
            clear();
        }

        public final SCRedBlueBattleState clear() {
            this.stateType = 0;
            this.timestamp = 0L;
            this.version = 0L;
            this.battleId = "";
            this.infoBar = "";
            this.statistic = null;
            this.skinInfo = null;
            this.mainButton = RedBlueBattleMainButton.emptyArray();
            this.activityId = "";
            this.battleStartButtonBubble = null;
            this.showStartButtonBubble = null;
            this.winTeamId = 0;
            this.infoBarModel = null;
            this.barTitle = "";
            this.displayTotalPoolAmount = "";
            this.displayTotalPoolAmountNum = "";
            this.displayTotalPoolAmountUnit = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.stateType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.version;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.battleId);
            }
            if (!this.infoBar.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.infoBar);
            }
            SCRedBlueBattleStatistic sCRedBlueBattleStatistic = this.statistic;
            if (sCRedBlueBattleStatistic != null) {
                codedOutputByteBufferNano.writeMessage(6, sCRedBlueBattleStatistic);
            }
            RedBlueBattleSkinInfo redBlueBattleSkinInfo = this.skinInfo;
            if (redBlueBattleSkinInfo != null) {
                codedOutputByteBufferNano.writeMessage(7, redBlueBattleSkinInfo);
            }
            RedBlueBattleMainButton[] redBlueBattleMainButtonArr = this.mainButton;
            if (redBlueBattleMainButtonArr != null && redBlueBattleMainButtonArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RedBlueBattleMainButton[] redBlueBattleMainButtonArr2 = this.mainButton;
                    if (i2 >= redBlueBattleMainButtonArr2.length) {
                        break;
                    }
                    RedBlueBattleMainButton redBlueBattleMainButton = redBlueBattleMainButtonArr2[i2];
                    if (redBlueBattleMainButton != null) {
                        codedOutputByteBufferNano.writeMessage(8, redBlueBattleMainButton);
                    }
                    i2++;
                }
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.activityId);
            }
            MainButtonBubble mainButtonBubble = this.battleStartButtonBubble;
            if (mainButtonBubble != null) {
                codedOutputByteBufferNano.writeMessage(10, mainButtonBubble);
            }
            MainButtonBubble mainButtonBubble2 = this.showStartButtonBubble;
            if (mainButtonBubble2 != null) {
                codedOutputByteBufferNano.writeMessage(11, mainButtonBubble2);
            }
            int i3 = this.winTeamId;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(12, i3);
            }
            RedBlueBattleInfoBarModel redBlueBattleInfoBarModel = this.infoBarModel;
            if (redBlueBattleInfoBarModel != null) {
                codedOutputByteBufferNano.writeMessage(13, redBlueBattleInfoBarModel);
            }
            if (!this.barTitle.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.barTitle);
            }
            if (!this.displayTotalPoolAmount.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.displayTotalPoolAmount);
            }
            if (!this.displayTotalPoolAmountNum.equals("")) {
                codedOutputByteBufferNano.writeString(16, this.displayTotalPoolAmountNum);
            }
            if (!this.displayTotalPoolAmountUnit.equals("")) {
                codedOutputByteBufferNano.writeString(17, this.displayTotalPoolAmountUnit);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.stateType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.version;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            if (!this.battleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.battleId);
            }
            if (!this.infoBar.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.infoBar);
            }
            SCRedBlueBattleStatistic sCRedBlueBattleStatistic = this.statistic;
            if (sCRedBlueBattleStatistic != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, sCRedBlueBattleStatistic);
            }
            RedBlueBattleSkinInfo redBlueBattleSkinInfo = this.skinInfo;
            if (redBlueBattleSkinInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, redBlueBattleSkinInfo);
            }
            RedBlueBattleMainButton[] redBlueBattleMainButtonArr = this.mainButton;
            if (redBlueBattleMainButtonArr != null && redBlueBattleMainButtonArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RedBlueBattleMainButton[] redBlueBattleMainButtonArr2 = this.mainButton;
                    if (i2 >= redBlueBattleMainButtonArr2.length) {
                        break;
                    }
                    RedBlueBattleMainButton redBlueBattleMainButton = redBlueBattleMainButtonArr2[i2];
                    if (redBlueBattleMainButton != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, redBlueBattleMainButton);
                    }
                    i2++;
                }
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.activityId);
            }
            MainButtonBubble mainButtonBubble = this.battleStartButtonBubble;
            if (mainButtonBubble != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, mainButtonBubble);
            }
            MainButtonBubble mainButtonBubble2 = this.showStartButtonBubble;
            if (mainButtonBubble2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, mainButtonBubble2);
            }
            int i3 = this.winTeamId;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i3);
            }
            RedBlueBattleInfoBarModel redBlueBattleInfoBarModel = this.infoBarModel;
            if (redBlueBattleInfoBarModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, redBlueBattleInfoBarModel);
            }
            if (!this.barTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.barTitle);
            }
            if (!this.displayTotalPoolAmount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.displayTotalPoolAmount);
            }
            if (!this.displayTotalPoolAmountNum.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.displayTotalPoolAmountNum);
            }
            return !this.displayTotalPoolAmountUnit.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.displayTotalPoolAmountUnit) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCRedBlueBattleState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        int int32 = codedInputByteBufferNano.readInt32();
                        switch (int32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                this.stateType = int32;
                                break;
                        }
                    case 16:
                        this.timestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 24:
                        this.version = codedInputByteBufferNano.readUInt64();
                        break;
                    case 34:
                        this.battleId = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.infoBar = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        if (this.statistic == null) {
                            this.statistic = new SCRedBlueBattleStatistic();
                        }
                        codedInputByteBufferNano.readMessage(this.statistic);
                        break;
                    case 58:
                        if (this.skinInfo == null) {
                            this.skinInfo = new RedBlueBattleSkinInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.skinInfo);
                        break;
                    case 66:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        RedBlueBattleMainButton[] redBlueBattleMainButtonArr = this.mainButton;
                        int length = redBlueBattleMainButtonArr == null ? 0 : redBlueBattleMainButtonArr.length;
                        RedBlueBattleMainButton[] redBlueBattleMainButtonArr2 = new RedBlueBattleMainButton[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.mainButton, 0, redBlueBattleMainButtonArr2, 0, length);
                        }
                        while (length < redBlueBattleMainButtonArr2.length - 1) {
                            redBlueBattleMainButtonArr2[length] = new RedBlueBattleMainButton();
                            codedInputByteBufferNano.readMessage(redBlueBattleMainButtonArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        redBlueBattleMainButtonArr2[length] = new RedBlueBattleMainButton();
                        codedInputByteBufferNano.readMessage(redBlueBattleMainButtonArr2[length]);
                        this.mainButton = redBlueBattleMainButtonArr2;
                        break;
                    case 74:
                        this.activityId = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        if (this.battleStartButtonBubble == null) {
                            this.battleStartButtonBubble = new MainButtonBubble();
                        }
                        codedInputByteBufferNano.readMessage(this.battleStartButtonBubble);
                        break;
                    case 90:
                        if (this.showStartButtonBubble == null) {
                            this.showStartButtonBubble = new MainButtonBubble();
                        }
                        codedInputByteBufferNano.readMessage(this.showStartButtonBubble);
                        break;
                    case 96:
                        this.winTeamId = codedInputByteBufferNano.readUInt32();
                        break;
                    case 106:
                        if (this.infoBarModel == null) {
                            this.infoBarModel = new RedBlueBattleInfoBarModel();
                        }
                        codedInputByteBufferNano.readMessage(this.infoBarModel);
                        break;
                    case 114:
                        this.barTitle = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        this.displayTotalPoolAmount = codedInputByteBufferNano.readString();
                        break;
                    case 130:
                        this.displayTotalPoolAmountNum = codedInputByteBufferNano.readString();
                        break;
                    case 138:
                        this.displayTotalPoolAmountUnit = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCRedBlueBattleState parseFrom(byte[] bArr) {
            return (SCRedBlueBattleState) MessageNano.mergeFrom(new SCRedBlueBattleState(), bArr);
        }

        public static SCRedBlueBattleState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCRedBlueBattleState().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MainButtonBubble extends MessageNano {
        private static volatile MainButtonBubble[] _emptyArray;
        public String msgId;
        public String popupText;

        public static MainButtonBubble[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MainButtonBubble[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MainButtonBubble() {
            clear();
        }

        public final MainButtonBubble clear() {
            this.msgId = "";
            this.popupText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.msgId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.msgId);
            }
            if (!this.popupText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.popupText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.msgId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.msgId);
            }
            return !this.popupText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.popupText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MainButtonBubble mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.msgId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.popupText = codedInputByteBufferNano.readString();
                }
            }
        }

        public static MainButtonBubble parseFrom(byte[] bArr) {
            return (MainButtonBubble) MessageNano.mergeFrom(new MainButtonBubble(), bArr);
        }

        public static MainButtonBubble parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MainButtonBubble().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleInfoBarModel extends MessageNano {
        private static volatile RedBlueBattleInfoBarModel[] _emptyArray;
        public String infoBar;
        public long timestamp;

        public static RedBlueBattleInfoBarModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleInfoBarModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleInfoBarModel() {
            clear();
        }

        public final RedBlueBattleInfoBarModel clear() {
            this.infoBar = "";
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.infoBar.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.infoBar);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.infoBar.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.infoBar);
            }
            long j = this.timestamp;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleInfoBarModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.infoBar = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static RedBlueBattleInfoBarModel parseFrom(byte[] bArr) {
            return (RedBlueBattleInfoBarModel) MessageNano.mergeFrom(new RedBlueBattleInfoBarModel(), bArr);
        }

        public static RedBlueBattleInfoBarModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleInfoBarModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleInfoBar extends MessageNano {
        private static volatile RedBlueBattleInfoBar[] _emptyArray;
        public String barTitle;
        public String battleId;
        public RedBlueBattleTeamInfo[] teamInfo;
        public long totalPoolAmount;
        public int winTeamId;

        public static RedBlueBattleInfoBar[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleInfoBar[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleInfoBar() {
            clear();
        }

        public final RedBlueBattleInfoBar clear() {
            this.barTitle = "";
            this.totalPoolAmount = 0L;
            this.teamInfo = RedBlueBattleTeamInfo.emptyArray();
            this.winTeamId = 0;
            this.battleId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.barTitle.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.barTitle);
            }
            long j = this.totalPoolAmount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            RedBlueBattleTeamInfo[] redBlueBattleTeamInfoArr = this.teamInfo;
            if (redBlueBattleTeamInfoArr != null && redBlueBattleTeamInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleTeamInfo[] redBlueBattleTeamInfoArr2 = this.teamInfo;
                    if (i >= redBlueBattleTeamInfoArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamInfo redBlueBattleTeamInfo = redBlueBattleTeamInfoArr2[i];
                    if (redBlueBattleTeamInfo != null) {
                        codedOutputByteBufferNano.writeMessage(3, redBlueBattleTeamInfo);
                    }
                    i++;
                }
            }
            int i2 = this.winTeamId;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.battleId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.barTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.barTitle);
            }
            long j = this.totalPoolAmount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            RedBlueBattleTeamInfo[] redBlueBattleTeamInfoArr = this.teamInfo;
            if (redBlueBattleTeamInfoArr != null && redBlueBattleTeamInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleTeamInfo[] redBlueBattleTeamInfoArr2 = this.teamInfo;
                    if (i >= redBlueBattleTeamInfoArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamInfo redBlueBattleTeamInfo = redBlueBattleTeamInfoArr2[i];
                    if (redBlueBattleTeamInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, redBlueBattleTeamInfo);
                    }
                    i++;
                }
            }
            int i2 = this.winTeamId;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            return !this.battleId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.battleId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleInfoBar mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.barTitle = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.totalPoolAmount = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    RedBlueBattleTeamInfo[] redBlueBattleTeamInfoArr = this.teamInfo;
                    int length = redBlueBattleTeamInfoArr == null ? 0 : redBlueBattleTeamInfoArr.length;
                    RedBlueBattleTeamInfo[] redBlueBattleTeamInfoArr2 = new RedBlueBattleTeamInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.teamInfo, 0, redBlueBattleTeamInfoArr2, 0, length);
                    }
                    while (length < redBlueBattleTeamInfoArr2.length - 1) {
                        redBlueBattleTeamInfoArr2[length] = new RedBlueBattleTeamInfo();
                        codedInputByteBufferNano.readMessage(redBlueBattleTeamInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    redBlueBattleTeamInfoArr2[length] = new RedBlueBattleTeamInfo();
                    codedInputByteBufferNano.readMessage(redBlueBattleTeamInfoArr2[length]);
                    this.teamInfo = redBlueBattleTeamInfoArr2;
                } else if (tag == 32) {
                    this.winTeamId = codedInputByteBufferNano.readUInt32();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.battleId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedBlueBattleInfoBar parseFrom(byte[] bArr) {
            return (RedBlueBattleInfoBar) MessageNano.mergeFrom(new RedBlueBattleInfoBar(), bArr);
        }

        public static RedBlueBattleInfoBar parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleInfoBar().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleTeamInfo extends MessageNano {
        private static volatile RedBlueBattleTeamInfo[] _emptyArray;
        public String programName;
        public int teamId;
        public RedBlueBattleTeamMember[] teamMember;
        public String teamName;

        public static RedBlueBattleTeamInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleTeamInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleTeamInfo() {
            clear();
        }

        public final RedBlueBattleTeamInfo clear() {
            this.teamId = 0;
            this.teamName = "";
            this.teamMember = RedBlueBattleTeamMember.emptyArray();
            this.programName = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.teamId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.teamName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.teamName);
            }
            RedBlueBattleTeamMember[] redBlueBattleTeamMemberArr = this.teamMember;
            if (redBlueBattleTeamMemberArr != null && redBlueBattleTeamMemberArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RedBlueBattleTeamMember[] redBlueBattleTeamMemberArr2 = this.teamMember;
                    if (i2 >= redBlueBattleTeamMemberArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamMember redBlueBattleTeamMember = redBlueBattleTeamMemberArr2[i2];
                    if (redBlueBattleTeamMember != null) {
                        codedOutputByteBufferNano.writeMessage(3, redBlueBattleTeamMember);
                    }
                    i2++;
                }
            }
            if (!this.programName.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.programName);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.teamId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.teamName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.teamName);
            }
            RedBlueBattleTeamMember[] redBlueBattleTeamMemberArr = this.teamMember;
            if (redBlueBattleTeamMemberArr != null && redBlueBattleTeamMemberArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RedBlueBattleTeamMember[] redBlueBattleTeamMemberArr2 = this.teamMember;
                    if (i2 >= redBlueBattleTeamMemberArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamMember redBlueBattleTeamMember = redBlueBattleTeamMemberArr2[i2];
                    if (redBlueBattleTeamMember != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, redBlueBattleTeamMember);
                    }
                    i2++;
                }
            }
            return !this.programName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.programName) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleTeamInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.teamId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.teamName = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    RedBlueBattleTeamMember[] redBlueBattleTeamMemberArr = this.teamMember;
                    int length = redBlueBattleTeamMemberArr == null ? 0 : redBlueBattleTeamMemberArr.length;
                    RedBlueBattleTeamMember[] redBlueBattleTeamMemberArr2 = new RedBlueBattleTeamMember[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.teamMember, 0, redBlueBattleTeamMemberArr2, 0, length);
                    }
                    while (length < redBlueBattleTeamMemberArr2.length - 1) {
                        redBlueBattleTeamMemberArr2[length] = new RedBlueBattleTeamMember();
                        codedInputByteBufferNano.readMessage(redBlueBattleTeamMemberArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    redBlueBattleTeamMemberArr2[length] = new RedBlueBattleTeamMember();
                    codedInputByteBufferNano.readMessage(redBlueBattleTeamMemberArr2[length]);
                    this.teamMember = redBlueBattleTeamMemberArr2;
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.programName = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedBlueBattleTeamInfo parseFrom(byte[] bArr) {
            return (RedBlueBattleTeamInfo) MessageNano.mergeFrom(new RedBlueBattleTeamInfo(), bArr);
        }

        public static RedBlueBattleTeamInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleTeamInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleTeamMember extends MessageNano {
        private static volatile RedBlueBattleTeamMember[] _emptyArray;
        public CnyCdnDegradeProto.DegradablePicUrl userHead;
        public long userId;
        public String userName;

        public static RedBlueBattleTeamMember[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleTeamMember[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleTeamMember() {
            clear();
        }

        public final RedBlueBattleTeamMember clear() {
            this.userId = 0L;
            this.userName = "";
            this.userHead = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.userName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.userName);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.userHead;
            if (degradablePicUrl != null) {
                codedOutputByteBufferNano.writeMessage(3, degradablePicUrl);
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
            if (!this.userName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.userName);
            }
            CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.userHead;
            return degradablePicUrl != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, degradablePicUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleTeamMember mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.userName = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.userHead == null) {
                        this.userHead = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.userHead);
                }
            }
        }

        public static RedBlueBattleTeamMember parseFrom(byte[] bArr) {
            return (RedBlueBattleTeamMember) MessageNano.mergeFrom(new RedBlueBattleTeamMember(), bArr);
        }

        public static RedBlueBattleTeamMember parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleTeamMember().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleMainButton extends MessageNano {
        private static volatile RedBlueBattleMainButton[] _emptyArray;
        public int buttonType;
        public String[] giftId;
        public String logParams;
        public String subTitle;
        public int teamId;
        public String title;

        @Retention(RetentionPolicy.SOURCE)
        public @interface MainButtonType {
            public static final int BLUE_SHOW = 3;
            public static final int GRAB_LEE = 4;
            public static final int NORMAL = 1;
            public static final int RED_SHOW = 2;
            public static final int UNKNOWN = 0;
        }

        public static RedBlueBattleMainButton[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleMainButton[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleMainButton() {
            clear();
        }

        public final RedBlueBattleMainButton clear() {
            this.buttonType = 0;
            this.title = "";
            this.subTitle = "";
            this.teamId = 0;
            this.giftId = WireFormatNano.EMPTY_STRING_ARRAY;
            this.logParams = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.buttonType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.subTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.subTitle);
            }
            int i2 = this.teamId;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            String[] strArr = this.giftId;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.giftId;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(5, str);
                    }
                    i3++;
                }
            }
            if (!this.logParams.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.logParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.buttonType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.subTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.subTitle);
            }
            int i2 = this.teamId;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            String[] strArr = this.giftId;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                int iComputeStringSizeNoTag = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.giftId;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        i4++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
            }
            return !this.logParams.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.logParams) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleMainButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                        this.buttonType = int32;
                    }
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.subTitle = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.teamId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr = this.giftId;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.giftId, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.giftId = strArr2;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.logParams = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedBlueBattleMainButton parseFrom(byte[] bArr) {
            return (RedBlueBattleMainButton) MessageNano.mergeFrom(new RedBlueBattleMainButton(), bArr);
        }

        public static RedBlueBattleMainButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleMainButton().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleSkinInfo extends MessageNano {
        private static volatile RedBlueBattleSkinInfo[] _emptyArray;
        public RedBlueBattleTeamSkin[] teamSkin;

        public static RedBlueBattleSkinInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleSkinInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleSkinInfo() {
            clear();
        }

        public final RedBlueBattleSkinInfo clear() {
            this.teamSkin = RedBlueBattleTeamSkin.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RedBlueBattleTeamSkin[] redBlueBattleTeamSkinArr = this.teamSkin;
            if (redBlueBattleTeamSkinArr != null && redBlueBattleTeamSkinArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleTeamSkin[] redBlueBattleTeamSkinArr2 = this.teamSkin;
                    if (i >= redBlueBattleTeamSkinArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamSkin redBlueBattleTeamSkin = redBlueBattleTeamSkinArr2[i];
                    if (redBlueBattleTeamSkin != null) {
                        codedOutputByteBufferNano.writeMessage(1, redBlueBattleTeamSkin);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RedBlueBattleTeamSkin[] redBlueBattleTeamSkinArr = this.teamSkin;
            if (redBlueBattleTeamSkinArr != null && redBlueBattleTeamSkinArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleTeamSkin[] redBlueBattleTeamSkinArr2 = this.teamSkin;
                    if (i >= redBlueBattleTeamSkinArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamSkin redBlueBattleTeamSkin = redBlueBattleTeamSkinArr2[i];
                    if (redBlueBattleTeamSkin != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, redBlueBattleTeamSkin);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleSkinInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    RedBlueBattleTeamSkin[] redBlueBattleTeamSkinArr = this.teamSkin;
                    int length = redBlueBattleTeamSkinArr == null ? 0 : redBlueBattleTeamSkinArr.length;
                    RedBlueBattleTeamSkin[] redBlueBattleTeamSkinArr2 = new RedBlueBattleTeamSkin[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.teamSkin, 0, redBlueBattleTeamSkinArr2, 0, length);
                    }
                    while (length < redBlueBattleTeamSkinArr2.length - 1) {
                        redBlueBattleTeamSkinArr2[length] = new RedBlueBattleTeamSkin();
                        codedInputByteBufferNano.readMessage(redBlueBattleTeamSkinArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    redBlueBattleTeamSkinArr2[length] = new RedBlueBattleTeamSkin();
                    codedInputByteBufferNano.readMessage(redBlueBattleTeamSkinArr2[length]);
                    this.teamSkin = redBlueBattleTeamSkinArr2;
                }
            }
        }

        public static RedBlueBattleSkinInfo parseFrom(byte[] bArr) {
            return (RedBlueBattleSkinInfo) MessageNano.mergeFrom(new RedBlueBattleSkinInfo(), bArr);
        }

        public static RedBlueBattleSkinInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleSkinInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleTeamSkin extends MessageNano {
        private static volatile RedBlueBattleTeamSkin[] _emptyArray;
        public String leftColor;
        public String rightColor;
        public int teamId;

        public static RedBlueBattleTeamSkin[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleTeamSkin[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleTeamSkin() {
            clear();
        }

        public final RedBlueBattleTeamSkin clear() {
            this.teamId = 0;
            this.rightColor = "";
            this.leftColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.teamId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.rightColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.rightColor);
            }
            if (!this.leftColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.leftColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.teamId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.rightColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.rightColor);
            }
            return !this.leftColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.leftColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleTeamSkin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.teamId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.rightColor = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.leftColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedBlueBattleTeamSkin parseFrom(byte[] bArr) {
            return (RedBlueBattleTeamSkin) MessageNano.mergeFrom(new RedBlueBattleTeamSkin(), bArr);
        }

        public static RedBlueBattleTeamSkin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleTeamSkin().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCRedBlueBattleAddPool extends MessageNano {
        private static volatile SCRedBlueBattleAddPool[] _emptyArray;
        public String activityId;
        public RedBlueBattleTeamAddPoolInfo[] addPoolInfo;
        public String barTitle;
        public String battleId;
        public String infoBar;
        public RedBlueBattleInfoBarModel infoBarModel;
        public long timestamp;
        public long totalAmount;

        public static SCRedBlueBattleAddPool[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCRedBlueBattleAddPool[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCRedBlueBattleAddPool() {
            clear();
        }

        public final SCRedBlueBattleAddPool clear() {
            this.battleId = "";
            this.timestamp = 0L;
            this.addPoolInfo = RedBlueBattleTeamAddPoolInfo.emptyArray();
            this.totalAmount = 0L;
            this.barTitle = "";
            this.activityId = "";
            this.infoBar = "";
            this.infoBarModel = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.battleId);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            RedBlueBattleTeamAddPoolInfo[] redBlueBattleTeamAddPoolInfoArr = this.addPoolInfo;
            if (redBlueBattleTeamAddPoolInfoArr != null && redBlueBattleTeamAddPoolInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleTeamAddPoolInfo[] redBlueBattleTeamAddPoolInfoArr2 = this.addPoolInfo;
                    if (i >= redBlueBattleTeamAddPoolInfoArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamAddPoolInfo redBlueBattleTeamAddPoolInfo = redBlueBattleTeamAddPoolInfoArr2[i];
                    if (redBlueBattleTeamAddPoolInfo != null) {
                        codedOutputByteBufferNano.writeMessage(3, redBlueBattleTeamAddPoolInfo);
                    }
                    i++;
                }
            }
            long j2 = this.totalAmount;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.barTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.barTitle);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.activityId);
            }
            if (!this.infoBar.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.infoBar);
            }
            RedBlueBattleInfoBarModel redBlueBattleInfoBarModel = this.infoBarModel;
            if (redBlueBattleInfoBarModel != null) {
                codedOutputByteBufferNano.writeMessage(8, redBlueBattleInfoBarModel);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.battleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.battleId);
            }
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            RedBlueBattleTeamAddPoolInfo[] redBlueBattleTeamAddPoolInfoArr = this.addPoolInfo;
            if (redBlueBattleTeamAddPoolInfoArr != null && redBlueBattleTeamAddPoolInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleTeamAddPoolInfo[] redBlueBattleTeamAddPoolInfoArr2 = this.addPoolInfo;
                    if (i >= redBlueBattleTeamAddPoolInfoArr2.length) {
                        break;
                    }
                    RedBlueBattleTeamAddPoolInfo redBlueBattleTeamAddPoolInfo = redBlueBattleTeamAddPoolInfoArr2[i];
                    if (redBlueBattleTeamAddPoolInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, redBlueBattleTeamAddPoolInfo);
                    }
                    i++;
                }
            }
            long j2 = this.totalAmount;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            if (!this.barTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.barTitle);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.activityId);
            }
            if (!this.infoBar.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.infoBar);
            }
            RedBlueBattleInfoBarModel redBlueBattleInfoBarModel = this.infoBarModel;
            return redBlueBattleInfoBarModel != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, redBlueBattleInfoBarModel) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCRedBlueBattleAddPool mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.battleId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    RedBlueBattleTeamAddPoolInfo[] redBlueBattleTeamAddPoolInfoArr = this.addPoolInfo;
                    int length = redBlueBattleTeamAddPoolInfoArr == null ? 0 : redBlueBattleTeamAddPoolInfoArr.length;
                    RedBlueBattleTeamAddPoolInfo[] redBlueBattleTeamAddPoolInfoArr2 = new RedBlueBattleTeamAddPoolInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.addPoolInfo, 0, redBlueBattleTeamAddPoolInfoArr2, 0, length);
                    }
                    while (length < redBlueBattleTeamAddPoolInfoArr2.length - 1) {
                        redBlueBattleTeamAddPoolInfoArr2[length] = new RedBlueBattleTeamAddPoolInfo();
                        codedInputByteBufferNano.readMessage(redBlueBattleTeamAddPoolInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    redBlueBattleTeamAddPoolInfoArr2[length] = new RedBlueBattleTeamAddPoolInfo();
                    codedInputByteBufferNano.readMessage(redBlueBattleTeamAddPoolInfoArr2[length]);
                    this.addPoolInfo = redBlueBattleTeamAddPoolInfoArr2;
                } else if (tag == 32) {
                    this.totalAmount = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.barTitle = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag == 58) {
                    this.infoBar = codedInputByteBufferNano.readString();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.infoBarModel == null) {
                        this.infoBarModel = new RedBlueBattleInfoBarModel();
                    }
                    codedInputByteBufferNano.readMessage(this.infoBarModel);
                }
            }
        }

        public static SCRedBlueBattleAddPool parseFrom(byte[] bArr) {
            return (SCRedBlueBattleAddPool) MessageNano.mergeFrom(new SCRedBlueBattleAddPool(), bArr);
        }

        public static SCRedBlueBattleAddPool parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCRedBlueBattleAddPool().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleTeamAddPoolInfo extends MessageNano {
        private static volatile RedBlueBattleTeamAddPoolInfo[] _emptyArray;
        public long addPoolAmount;
        public String displayAddPoolAmount;
        public String displayAddPoolAmountNum;
        public String displayAddPoolAmountUnit;
        public long displayDurationMs;
        public String leeTitle;
        public String stableSubTitle;
        public String subTitle;
        public int teamId;

        public static RedBlueBattleTeamAddPoolInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleTeamAddPoolInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleTeamAddPoolInfo() {
            clear();
        }

        public final RedBlueBattleTeamAddPoolInfo clear() {
            this.teamId = 0;
            this.addPoolAmount = 0L;
            this.displayAddPoolAmount = "";
            this.displayAddPoolAmountNum = "";
            this.displayAddPoolAmountUnit = "";
            this.leeTitle = "";
            this.subTitle = "";
            this.displayDurationMs = 0L;
            this.stableSubTitle = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.teamId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.addPoolAmount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.displayAddPoolAmount.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.displayAddPoolAmount);
            }
            if (!this.displayAddPoolAmountNum.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.displayAddPoolAmountNum);
            }
            if (!this.displayAddPoolAmountUnit.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.displayAddPoolAmountUnit);
            }
            if (!this.leeTitle.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.leeTitle);
            }
            if (!this.subTitle.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.subTitle);
            }
            long j2 = this.displayDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            if (!this.stableSubTitle.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.stableSubTitle);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.teamId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.addPoolAmount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.displayAddPoolAmount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayAddPoolAmount);
            }
            if (!this.displayAddPoolAmountNum.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayAddPoolAmountNum);
            }
            if (!this.displayAddPoolAmountUnit.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayAddPoolAmountUnit);
            }
            if (!this.leeTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.leeTitle);
            }
            if (!this.subTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.subTitle);
            }
            long j2 = this.displayDurationMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
            }
            return !this.stableSubTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.stableSubTitle) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleTeamAddPoolInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.teamId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.addPoolAmount = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.displayAddPoolAmount = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.displayAddPoolAmountNum = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.displayAddPoolAmountUnit = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.leeTitle = codedInputByteBufferNano.readString();
                } else if (tag == 58) {
                    this.subTitle = codedInputByteBufferNano.readString();
                } else if (tag == 64) {
                    this.displayDurationMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.stableSubTitle = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedBlueBattleTeamAddPoolInfo parseFrom(byte[] bArr) {
            return (RedBlueBattleTeamAddPoolInfo) MessageNano.mergeFrom(new RedBlueBattleTeamAddPoolInfo(), bArr);
        }

        public static RedBlueBattleTeamAddPoolInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleTeamAddPoolInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCRedBlueBattleStatistic extends MessageNano {
        private static volatile SCRedBlueBattleStatistic[] _emptyArray;
        public String activityId;
        public String battleId;
        public RedBlueBattleScoreInfo[] scoreInfo;
        public long timestamp;

        public static SCRedBlueBattleStatistic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCRedBlueBattleStatistic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCRedBlueBattleStatistic() {
            clear();
        }

        public final SCRedBlueBattleStatistic clear() {
            this.battleId = "";
            this.timestamp = 0L;
            this.activityId = "";
            this.scoreInfo = RedBlueBattleScoreInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.battleId);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.activityId);
            }
            RedBlueBattleScoreInfo[] redBlueBattleScoreInfoArr = this.scoreInfo;
            if (redBlueBattleScoreInfoArr != null && redBlueBattleScoreInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleScoreInfo[] redBlueBattleScoreInfoArr2 = this.scoreInfo;
                    if (i >= redBlueBattleScoreInfoArr2.length) {
                        break;
                    }
                    RedBlueBattleScoreInfo redBlueBattleScoreInfo = redBlueBattleScoreInfoArr2[i];
                    if (redBlueBattleScoreInfo != null) {
                        codedOutputByteBufferNano.writeMessage(4, redBlueBattleScoreInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.battleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.battleId);
            }
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.activityId);
            }
            RedBlueBattleScoreInfo[] redBlueBattleScoreInfoArr = this.scoreInfo;
            if (redBlueBattleScoreInfoArr != null && redBlueBattleScoreInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    RedBlueBattleScoreInfo[] redBlueBattleScoreInfoArr2 = this.scoreInfo;
                    if (i >= redBlueBattleScoreInfoArr2.length) {
                        break;
                    }
                    RedBlueBattleScoreInfo redBlueBattleScoreInfo = redBlueBattleScoreInfoArr2[i];
                    if (redBlueBattleScoreInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, redBlueBattleScoreInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCRedBlueBattleStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.battleId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    RedBlueBattleScoreInfo[] redBlueBattleScoreInfoArr = this.scoreInfo;
                    int length = redBlueBattleScoreInfoArr == null ? 0 : redBlueBattleScoreInfoArr.length;
                    RedBlueBattleScoreInfo[] redBlueBattleScoreInfoArr2 = new RedBlueBattleScoreInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.scoreInfo, 0, redBlueBattleScoreInfoArr2, 0, length);
                    }
                    while (length < redBlueBattleScoreInfoArr2.length - 1) {
                        redBlueBattleScoreInfoArr2[length] = new RedBlueBattleScoreInfo();
                        codedInputByteBufferNano.readMessage(redBlueBattleScoreInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    redBlueBattleScoreInfoArr2[length] = new RedBlueBattleScoreInfo();
                    codedInputByteBufferNano.readMessage(redBlueBattleScoreInfoArr2[length]);
                    this.scoreInfo = redBlueBattleScoreInfoArr2;
                }
            }
        }

        public static SCRedBlueBattleStatistic parseFrom(byte[] bArr) {
            return (SCRedBlueBattleStatistic) MessageNano.mergeFrom(new SCRedBlueBattleStatistic(), bArr);
        }

        public static SCRedBlueBattleStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCRedBlueBattleStatistic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedBlueBattleScoreInfo extends MessageNano {
        private static volatile RedBlueBattleScoreInfo[] _emptyArray;
        public String comingSoonText;
        public String displayTeamScore;
        public String displayTeamScoreNum;
        public String displayTeamScoreUnit;
        public int teamId;
        public long teamScore;

        public static RedBlueBattleScoreInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedBlueBattleScoreInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedBlueBattleScoreInfo() {
            clear();
        }

        public final RedBlueBattleScoreInfo clear() {
            this.teamId = 0;
            this.teamScore = 0L;
            this.displayTeamScore = "";
            this.displayTeamScoreNum = "";
            this.displayTeamScoreUnit = "";
            this.comingSoonText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.teamId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.teamScore;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.displayTeamScore.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.displayTeamScore);
            }
            if (!this.displayTeamScoreNum.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.displayTeamScoreNum);
            }
            if (!this.displayTeamScoreUnit.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.displayTeamScoreUnit);
            }
            if (!this.comingSoonText.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.comingSoonText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.teamId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.teamScore;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.displayTeamScore.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayTeamScore);
            }
            if (!this.displayTeamScoreNum.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayTeamScoreNum);
            }
            if (!this.displayTeamScoreUnit.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayTeamScoreUnit);
            }
            return !this.comingSoonText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.comingSoonText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedBlueBattleScoreInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.teamId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.teamScore = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.displayTeamScore = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.displayTeamScoreNum = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.displayTeamScoreUnit = codedInputByteBufferNano.readString();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.comingSoonText = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedBlueBattleScoreInfo parseFrom(byte[] bArr) {
            return (RedBlueBattleScoreInfo) MessageNano.mergeFrom(new RedBlueBattleScoreInfo(), bArr);
        }

        public static RedBlueBattleScoreInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedBlueBattleScoreInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCRedBlueBattleVideoMerge extends MessageNano {
        private static volatile SCRedBlueBattleVideoMerge[] _emptyArray;
        public String activityId;
        public String battleId;
        public long timestamp;
        public long version;

        public static SCRedBlueBattleVideoMerge[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCRedBlueBattleVideoMerge[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCRedBlueBattleVideoMerge() {
            clear();
        }

        public final SCRedBlueBattleVideoMerge clear() {
            this.battleId = "";
            this.timestamp = 0L;
            this.version = 0L;
            this.activityId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.battleId);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.version;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.activityId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.battleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.battleId);
            }
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.version;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            return !this.activityId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.activityId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCRedBlueBattleVideoMerge mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.battleId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.version = codedInputByteBufferNano.readUInt64();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.activityId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCRedBlueBattleVideoMerge parseFrom(byte[] bArr) {
            return (SCRedBlueBattleVideoMerge) MessageNano.mergeFrom(new SCRedBlueBattleVideoMerge(), bArr);
        }

        public static SCRedBlueBattleVideoMerge parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCRedBlueBattleVideoMerge().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRedBlueBattleTokenReady extends MessageNano {
        private static volatile SCLiveRedBlueBattleTokenReady[] _emptyArray;
        public String battleId;
        public long maxRequestIntervalMillis;
        public int maxRetryCount;
        public long minRequestIntervalMillis;
        public long requestIntervalMillis;
        public String sfLeeId;

        public static SCLiveRedBlueBattleTokenReady[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRedBlueBattleTokenReady[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRedBlueBattleTokenReady() {
            clear();
        }

        public final SCLiveRedBlueBattleTokenReady clear() {
            this.sfLeeId = "";
            this.battleId = "";
            this.requestIntervalMillis = 0L;
            this.maxRetryCount = 0;
            this.minRequestIntervalMillis = 0L;
            this.maxRequestIntervalMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.sfLeeId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.sfLeeId);
            }
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.battleId);
            }
            long j = this.requestIntervalMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i = this.maxRetryCount;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            long j2 = this.minRequestIntervalMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.maxRequestIntervalMillis;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.sfLeeId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.sfLeeId);
            }
            if (!this.battleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.battleId);
            }
            long j = this.requestIntervalMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i = this.maxRetryCount;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            long j2 = this.minRequestIntervalMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.maxRequestIntervalMillis;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRedBlueBattleTokenReady mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.sfLeeId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.battleId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.requestIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.maxRetryCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 40) {
                    this.minRequestIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxRequestIntervalMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveRedBlueBattleTokenReady parseFrom(byte[] bArr) {
            return (SCLiveRedBlueBattleTokenReady) MessageNano.mergeFrom(new SCLiveRedBlueBattleTokenReady(), bArr);
        }

        public static SCLiveRedBlueBattleTokenReady parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRedBlueBattleTokenReady().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRedBlueBattleShow extends MessageNano {
        private static volatile SCLiveRedBlueBattleShow[] _emptyArray;
        public String battleId;
        public String defaultKwaiUrl;
        public long executeDeadlineTimestamp;
        public long maxRequestIntervalMillis;
        public int maxRetryCount;
        public long minRequestIntervalMillis;
        public long requestIntervalMillis;
        public String sfLeeId;

        public static SCLiveRedBlueBattleShow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRedBlueBattleShow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRedBlueBattleShow() {
            clear();
        }

        public final SCLiveRedBlueBattleShow clear() {
            this.sfLeeId = "";
            this.battleId = "";
            this.requestIntervalMillis = 0L;
            this.maxRetryCount = 0;
            this.minRequestIntervalMillis = 0L;
            this.maxRequestIntervalMillis = 0L;
            this.executeDeadlineTimestamp = 0L;
            this.defaultKwaiUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.sfLeeId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.sfLeeId);
            }
            if (!this.battleId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.battleId);
            }
            long j = this.requestIntervalMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i = this.maxRetryCount;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            long j2 = this.minRequestIntervalMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.maxRequestIntervalMillis;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            long j4 = this.executeDeadlineTimestamp;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j4);
            }
            if (!this.defaultKwaiUrl.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.defaultKwaiUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.sfLeeId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.sfLeeId);
            }
            if (!this.battleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.battleId);
            }
            long j = this.requestIntervalMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i = this.maxRetryCount;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            long j2 = this.minRequestIntervalMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.maxRequestIntervalMillis;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            long j4 = this.executeDeadlineTimestamp;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
            }
            return !this.defaultKwaiUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.defaultKwaiUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRedBlueBattleShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.sfLeeId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.battleId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.requestIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.maxRetryCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 40) {
                    this.minRequestIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    this.maxRequestIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 56) {
                    this.executeDeadlineTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.defaultKwaiUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveRedBlueBattleShow parseFrom(byte[] bArr) {
            return (SCLiveRedBlueBattleShow) MessageNano.mergeFrom(new SCLiveRedBlueBattleShow(), bArr);
        }

        public static SCLiveRedBlueBattleShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRedBlueBattleShow().mergeFrom(codedInputByteBufferNano);
        }
    }
}
