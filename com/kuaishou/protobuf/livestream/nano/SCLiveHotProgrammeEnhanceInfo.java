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
public final class SCLiveHotProgrammeEnhanceInfo extends MessageNano {
    private static volatile SCLiveHotProgrammeEnhanceInfo[] _emptyArray;
    public SCLiveHotProgrammeEnhanceInfo attachInfo;
    public SCLiveHotProgrammeEnhanceInfo attachInfoV2;
    public LiveHotProgrammeButton button;
    public String kwaiUrl;
    public SCLiveHotProgrammeEnhanceInfo nextStatusInfo;
    public String notPickupText;
    public String pickupText;
    public long programmeId;
    public LiveHotProgrammeInfo[] programmeInfos;
    public LiveHotProgrammeLed programmeLed;
    public int scrollNum;
    public int showDurationMs;
    public LiveHotProgrammeShowingInfo showingInfo;
    public int statusType;
    public long timestamp;
    public LiveHotProgrammeTopBarInfo topBar;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HotProgrammeStatusType {
        public static final int CLOSE_PROGRAMME = 7;
        public static final int EXPERT_SHOW = 10;
        public static final int GRADS_PROGRAMME = 9;
        public static final int GUIDE_PROGRAMME = 1;
        public static final int NOT_SPONSOR_PROGRAMME = 6;
        public static final int ON_RANK_SHOW = 11;
        public static final int OPEN_PROGRAMME = 2;
        public static final int RANK_PROGRAMME = 8;
        public static final int SHOW_PROGRAMME = 3;
        public static final int SPONSOR_PROGRAMME = 5;
        public static final int SUPPORT_PROGRAMME = 4;
        public static final int UNKNOWN_STATUS = 0;
    }

    public static SCLiveHotProgrammeEnhanceInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveHotProgrammeEnhanceInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveHotProgrammeEnhanceInfo() {
        clear();
    }

    public final SCLiveHotProgrammeEnhanceInfo clear() {
        this.programmeId = 0L;
        this.statusType = 0;
        this.programmeInfos = LiveHotProgrammeInfo.emptyArray();
        this.showDurationMs = 0;
        this.pickupText = "";
        this.notPickupText = "";
        this.programmeLed = null;
        this.scrollNum = 0;
        this.kwaiUrl = "";
        this.button = null;
        this.attachInfo = null;
        this.nextStatusInfo = null;
        this.timestamp = 0L;
        this.showingInfo = null;
        this.attachInfoV2 = null;
        this.topBar = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.programmeId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.statusType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        LiveHotProgrammeInfo[] liveHotProgrammeInfoArr = this.programmeInfos;
        if (liveHotProgrammeInfoArr != null && liveHotProgrammeInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveHotProgrammeInfo[] liveHotProgrammeInfoArr2 = this.programmeInfos;
                if (i2 >= liveHotProgrammeInfoArr2.length) {
                    break;
                }
                LiveHotProgrammeInfo liveHotProgrammeInfo = liveHotProgrammeInfoArr2[i2];
                if (liveHotProgrammeInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveHotProgrammeInfo);
                }
                i2++;
            }
        }
        int i3 = this.showDurationMs;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.pickupText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.pickupText);
        }
        if (!this.notPickupText.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.notPickupText);
        }
        LiveHotProgrammeLed liveHotProgrammeLed = this.programmeLed;
        if (liveHotProgrammeLed != null) {
            codedOutputByteBufferNano.writeMessage(7, liveHotProgrammeLed);
        }
        int i4 = this.scrollNum;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i4);
        }
        if (!this.kwaiUrl.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.kwaiUrl);
        }
        LiveHotProgrammeButton liveHotProgrammeButton = this.button;
        if (liveHotProgrammeButton != null) {
            codedOutputByteBufferNano.writeMessage(10, liveHotProgrammeButton);
        }
        SCLiveHotProgrammeEnhanceInfo sCLiveHotProgrammeEnhanceInfo = this.attachInfo;
        if (sCLiveHotProgrammeEnhanceInfo != null) {
            codedOutputByteBufferNano.writeMessage(11, sCLiveHotProgrammeEnhanceInfo);
        }
        SCLiveHotProgrammeEnhanceInfo sCLiveHotProgrammeEnhanceInfo2 = this.nextStatusInfo;
        if (sCLiveHotProgrammeEnhanceInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(12, sCLiveHotProgrammeEnhanceInfo2);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j2);
        }
        LiveHotProgrammeShowingInfo liveHotProgrammeShowingInfo = this.showingInfo;
        if (liveHotProgrammeShowingInfo != null) {
            codedOutputByteBufferNano.writeMessage(14, liveHotProgrammeShowingInfo);
        }
        SCLiveHotProgrammeEnhanceInfo sCLiveHotProgrammeEnhanceInfo3 = this.attachInfoV2;
        if (sCLiveHotProgrammeEnhanceInfo3 != null) {
            codedOutputByteBufferNano.writeMessage(15, sCLiveHotProgrammeEnhanceInfo3);
        }
        LiveHotProgrammeTopBarInfo liveHotProgrammeTopBarInfo = this.topBar;
        if (liveHotProgrammeTopBarInfo != null) {
            codedOutputByteBufferNano.writeMessage(16, liveHotProgrammeTopBarInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.programmeId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.statusType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        LiveHotProgrammeInfo[] liveHotProgrammeInfoArr = this.programmeInfos;
        if (liveHotProgrammeInfoArr != null && liveHotProgrammeInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveHotProgrammeInfo[] liveHotProgrammeInfoArr2 = this.programmeInfos;
                if (i2 >= liveHotProgrammeInfoArr2.length) {
                    break;
                }
                LiveHotProgrammeInfo liveHotProgrammeInfo = liveHotProgrammeInfoArr2[i2];
                if (liveHotProgrammeInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveHotProgrammeInfo);
                }
                i2++;
            }
        }
        int i3 = this.showDurationMs;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.pickupText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.pickupText);
        }
        if (!this.notPickupText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.notPickupText);
        }
        LiveHotProgrammeLed liveHotProgrammeLed = this.programmeLed;
        if (liveHotProgrammeLed != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveHotProgrammeLed);
        }
        int i4 = this.scrollNum;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i4);
        }
        if (!this.kwaiUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.kwaiUrl);
        }
        LiveHotProgrammeButton liveHotProgrammeButton = this.button;
        if (liveHotProgrammeButton != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, liveHotProgrammeButton);
        }
        SCLiveHotProgrammeEnhanceInfo sCLiveHotProgrammeEnhanceInfo = this.attachInfo;
        if (sCLiveHotProgrammeEnhanceInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, sCLiveHotProgrammeEnhanceInfo);
        }
        SCLiveHotProgrammeEnhanceInfo sCLiveHotProgrammeEnhanceInfo2 = this.nextStatusInfo;
        if (sCLiveHotProgrammeEnhanceInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, sCLiveHotProgrammeEnhanceInfo2);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j2);
        }
        LiveHotProgrammeShowingInfo liveHotProgrammeShowingInfo = this.showingInfo;
        if (liveHotProgrammeShowingInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, liveHotProgrammeShowingInfo);
        }
        SCLiveHotProgrammeEnhanceInfo sCLiveHotProgrammeEnhanceInfo3 = this.attachInfoV2;
        if (sCLiveHotProgrammeEnhanceInfo3 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, sCLiveHotProgrammeEnhanceInfo3);
        }
        LiveHotProgrammeTopBarInfo liveHotProgrammeTopBarInfo = this.topBar;
        return liveHotProgrammeTopBarInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(16, liveHotProgrammeTopBarInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveHotProgrammeEnhanceInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.programmeId = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
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
                            this.statusType = int32;
                            break;
                    }
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveHotProgrammeInfo[] liveHotProgrammeInfoArr = this.programmeInfos;
                    int length = liveHotProgrammeInfoArr == null ? 0 : liveHotProgrammeInfoArr.length;
                    LiveHotProgrammeInfo[] liveHotProgrammeInfoArr2 = new LiveHotProgrammeInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.programmeInfos, 0, liveHotProgrammeInfoArr2, 0, length);
                    }
                    while (length < liveHotProgrammeInfoArr2.length - 1) {
                        liveHotProgrammeInfoArr2[length] = new LiveHotProgrammeInfo();
                        codedInputByteBufferNano.readMessage(liveHotProgrammeInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveHotProgrammeInfoArr2[length] = new LiveHotProgrammeInfo();
                    codedInputByteBufferNano.readMessage(liveHotProgrammeInfoArr2[length]);
                    this.programmeInfos = liveHotProgrammeInfoArr2;
                    break;
                case 32:
                    this.showDurationMs = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.pickupText = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.notPickupText = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    if (this.programmeLed == null) {
                        this.programmeLed = new LiveHotProgrammeLed();
                    }
                    codedInputByteBufferNano.readMessage(this.programmeLed);
                    break;
                case 64:
                    this.scrollNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.kwaiUrl = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.button == null) {
                        this.button = new LiveHotProgrammeButton();
                    }
                    codedInputByteBufferNano.readMessage(this.button);
                    break;
                case 90:
                    if (this.attachInfo == null) {
                        this.attachInfo = new SCLiveHotProgrammeEnhanceInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.attachInfo);
                    break;
                case 98:
                    if (this.nextStatusInfo == null) {
                        this.nextStatusInfo = new SCLiveHotProgrammeEnhanceInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.nextStatusInfo);
                    break;
                case 104:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 114:
                    if (this.showingInfo == null) {
                        this.showingInfo = new LiveHotProgrammeShowingInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.showingInfo);
                    break;
                case 122:
                    if (this.attachInfoV2 == null) {
                        this.attachInfoV2 = new SCLiveHotProgrammeEnhanceInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.attachInfoV2);
                    break;
                case 130:
                    if (this.topBar == null) {
                        this.topBar = new LiveHotProgrammeTopBarInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.topBar);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveHotProgrammeEnhanceInfo parseFrom(byte[] bArr) {
        return (SCLiveHotProgrammeEnhanceInfo) MessageNano.mergeFrom(new SCLiveHotProgrammeEnhanceInfo(), bArr);
    }

    public static SCLiveHotProgrammeEnhanceInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveHotProgrammeEnhanceInfo().mergeFrom(codedInputByteBufferNano);
    }
}
