package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveMultiInteractiveMessages;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAryaBroadcastProto {

    public static final class LiveAryaBroadcastMessage extends MessageNano {
        private static volatile LiveAryaBroadcastMessage[] _emptyArray;
        public String bizId;
        public LiveAryaBroadcastInteractiveMagicFaceMessage interactiveMagicFaceInfo;
        public LiveMultiInteractiveMessages.SCLiveMultiInteractiveInfo multiInteractiveInfo;
        public LiveAryaBroadcastPKGameInfoMessage pkGameInfo;
        public String senderId;
        public long senderTimestamp;
        public int type;
        public boolean videoStatus;
        public LiveAryaBroadcastTheaterCommandMessage voicePartyTheater;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveBroadcastType {
            public static final int INTERACTIVE_MAGIC_FACE_CHANNEL = 15;
            public static final int KTV_ANCHOR_NOTIFY_PLAY = 1;
            public static final int KTV_GUEST_ENTER_ROOM = 7;
            public static final int KTV_MUTE_ALL = 8;
            public static final int KTV_SINGER_CHANGE_ACC = 10;
            public static final int KTV_SINGER_CHANGE_ORI = 9;
            public static final int KTV_SINGER_PAUSE = 3;
            public static final int KTV_SINGER_READY = 5;
            public static final int KTV_SINGER_RESUME = 4;
            public static final int KTV_SINGER_START_PLAY = 2;
            public static final int KTV_SINGER_STOP_PLAY = 6;
            public static final int KTV_SINGER_VIDEO_STATUS = 13;
            public static final int MULTI_INTERACTIVE_EFFECT_END_STAGE = 14;
            public static final int PK_GAME_INFO = 12;
            public static final int THEATER_COMMAND = 11;
            public static final int UNKNOWN = 0;
        }

        public static LiveAryaBroadcastMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAryaBroadcastMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAryaBroadcastMessage() {
            clear();
        }

        public final LiveAryaBroadcastMessage clear() {
            this.type = 0;
            this.senderId = "";
            this.bizId = "";
            this.senderTimestamp = 0L;
            this.voicePartyTheater = null;
            this.pkGameInfo = null;
            this.videoStatus = false;
            this.multiInteractiveInfo = null;
            this.interactiveMagicFaceInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.senderId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.senderId);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.bizId);
            }
            long j = this.senderTimestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            LiveAryaBroadcastTheaterCommandMessage liveAryaBroadcastTheaterCommandMessage = this.voicePartyTheater;
            if (liveAryaBroadcastTheaterCommandMessage != null) {
                codedOutputByteBufferNano.writeMessage(5, liveAryaBroadcastTheaterCommandMessage);
            }
            LiveAryaBroadcastPKGameInfoMessage liveAryaBroadcastPKGameInfoMessage = this.pkGameInfo;
            if (liveAryaBroadcastPKGameInfoMessage != null) {
                codedOutputByteBufferNano.writeMessage(6, liveAryaBroadcastPKGameInfoMessage);
            }
            boolean z = this.videoStatus;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            LiveMultiInteractiveMessages.SCLiveMultiInteractiveInfo sCLiveMultiInteractiveInfo = this.multiInteractiveInfo;
            if (sCLiveMultiInteractiveInfo != null) {
                codedOutputByteBufferNano.writeMessage(8, sCLiveMultiInteractiveInfo);
            }
            LiveAryaBroadcastInteractiveMagicFaceMessage liveAryaBroadcastInteractiveMagicFaceMessage = this.interactiveMagicFaceInfo;
            if (liveAryaBroadcastInteractiveMagicFaceMessage != null) {
                codedOutputByteBufferNano.writeMessage(9, liveAryaBroadcastInteractiveMagicFaceMessage);
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
            if (!this.senderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.senderId);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.bizId);
            }
            long j = this.senderTimestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            LiveAryaBroadcastTheaterCommandMessage liveAryaBroadcastTheaterCommandMessage = this.voicePartyTheater;
            if (liveAryaBroadcastTheaterCommandMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveAryaBroadcastTheaterCommandMessage);
            }
            LiveAryaBroadcastPKGameInfoMessage liveAryaBroadcastPKGameInfoMessage = this.pkGameInfo;
            if (liveAryaBroadcastPKGameInfoMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveAryaBroadcastPKGameInfoMessage);
            }
            boolean z = this.videoStatus;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            LiveMultiInteractiveMessages.SCLiveMultiInteractiveInfo sCLiveMultiInteractiveInfo = this.multiInteractiveInfo;
            if (sCLiveMultiInteractiveInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, sCLiveMultiInteractiveInfo);
            }
            LiveAryaBroadcastInteractiveMagicFaceMessage liveAryaBroadcastInteractiveMagicFaceMessage = this.interactiveMagicFaceInfo;
            return liveAryaBroadcastInteractiveMagicFaceMessage != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, liveAryaBroadcastInteractiveMagicFaceMessage) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAryaBroadcastMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            this.type = int32;
                            break;
                    }
                } else if (tag == 18) {
                    this.senderId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.senderTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    if (this.voicePartyTheater == null) {
                        this.voicePartyTheater = new LiveAryaBroadcastTheaterCommandMessage();
                    }
                    codedInputByteBufferNano.readMessage(this.voicePartyTheater);
                } else if (tag == 50) {
                    if (this.pkGameInfo == null) {
                        this.pkGameInfo = new LiveAryaBroadcastPKGameInfoMessage();
                    }
                    codedInputByteBufferNano.readMessage(this.pkGameInfo);
                } else if (tag == 56) {
                    this.videoStatus = codedInputByteBufferNano.readBool();
                } else if (tag == 66) {
                    if (this.multiInteractiveInfo == null) {
                        this.multiInteractiveInfo = new LiveMultiInteractiveMessages.SCLiveMultiInteractiveInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.multiInteractiveInfo);
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.interactiveMagicFaceInfo == null) {
                        this.interactiveMagicFaceInfo = new LiveAryaBroadcastInteractiveMagicFaceMessage();
                    }
                    codedInputByteBufferNano.readMessage(this.interactiveMagicFaceInfo);
                }
            }
        }

        public static LiveAryaBroadcastMessage parseFrom(byte[] bArr) {
            return (LiveAryaBroadcastMessage) MessageNano.mergeFrom(new LiveAryaBroadcastMessage(), bArr);
        }

        public static LiveAryaBroadcastMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAryaBroadcastMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAryaBroadcastInteractiveMagicFaceMessage extends MessageNano {
        private static volatile LiveAryaBroadcastInteractiveMagicFaceMessage[] _emptyArray;
        public String bizId;
        public String data;

        public static LiveAryaBroadcastInteractiveMagicFaceMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAryaBroadcastInteractiveMagicFaceMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAryaBroadcastInteractiveMagicFaceMessage() {
            clear();
        }

        public final LiveAryaBroadcastInteractiveMagicFaceMessage clear() {
            this.bizId = "";
            this.data = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bizId);
            }
            if (!this.data.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.data);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizId);
            }
            return !this.data.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.data) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAryaBroadcastInteractiveMagicFaceMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.data = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveAryaBroadcastInteractiveMagicFaceMessage parseFrom(byte[] bArr) {
            return (LiveAryaBroadcastInteractiveMagicFaceMessage) MessageNano.mergeFrom(new LiveAryaBroadcastInteractiveMagicFaceMessage(), bArr);
        }

        public static LiveAryaBroadcastInteractiveMagicFaceMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAryaBroadcastInteractiveMagicFaceMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAryaBroadcastTheaterCommandMessage extends MessageNano {
        private static volatile LiveAryaBroadcastTheaterCommandMessage[] _emptyArray;
        public float captureVolume;
        public long currentPosition;
        public String episodeOrderId;
        public boolean hasCaptureVolume;
        public boolean hasPlayVolume;
        public float playVolume;
        public int theaterCommandType;
        public String theaterId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveAryaBroadcastTheaterCommandType {
            public static final int COMMAND_PAUSE = 2;
            public static final int COMMAND_PLAY = 1;
            public static final int COMMAND_SEEK = 3;
            public static final int COMMAND_UNKNOWN = 0;
        }

        public static LiveAryaBroadcastTheaterCommandMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAryaBroadcastTheaterCommandMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAryaBroadcastTheaterCommandMessage() {
            clear();
        }

        public final LiveAryaBroadcastTheaterCommandMessage clear() {
            this.theaterId = "";
            this.episodeOrderId = "";
            this.theaterCommandType = 0;
            this.currentPosition = 0L;
            this.captureVolume = 0.0f;
            this.hasCaptureVolume = false;
            this.playVolume = 0.0f;
            this.hasPlayVolume = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.theaterCommandType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.theaterId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.theaterId);
            }
            if (!this.episodeOrderId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.episodeOrderId);
            }
            long j = this.currentPosition;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (Float.floatToIntBits(this.captureVolume) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(5, this.captureVolume);
            }
            boolean z = this.hasCaptureVolume;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            if (Float.floatToIntBits(this.playVolume) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(7, this.playVolume);
            }
            boolean z2 = this.hasPlayVolume;
            if (z2) {
                codedOutputByteBufferNano.writeBool(8, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.theaterCommandType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.theaterId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.theaterId);
            }
            if (!this.episodeOrderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.episodeOrderId);
            }
            long j = this.currentPosition;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (Float.floatToIntBits(this.captureVolume) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.captureVolume);
            }
            boolean z = this.hasCaptureVolume;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
            }
            if (Float.floatToIntBits(this.playVolume) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(7, this.playVolume);
            }
            boolean z2 = this.hasPlayVolume;
            return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(8, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAryaBroadcastTheaterCommandMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.theaterCommandType = int32;
                    }
                } else if (tag == 18) {
                    this.theaterId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.episodeOrderId = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.currentPosition = codedInputByteBufferNano.readUInt64();
                } else if (tag == 45) {
                    this.captureVolume = codedInputByteBufferNano.readFloat();
                } else if (tag == 48) {
                    this.hasCaptureVolume = codedInputByteBufferNano.readBool();
                } else if (tag == 61) {
                    this.playVolume = codedInputByteBufferNano.readFloat();
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.hasPlayVolume = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveAryaBroadcastTheaterCommandMessage parseFrom(byte[] bArr) {
            return (LiveAryaBroadcastTheaterCommandMessage) MessageNano.mergeFrom(new LiveAryaBroadcastTheaterCommandMessage(), bArr);
        }

        public static LiveAryaBroadcastTheaterCommandMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAryaBroadcastTheaterCommandMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAryaBroadcastPKGameInfoMessage extends MessageNano {
        private static volatile LiveAryaBroadcastPKGameInfoMessage[] _emptyArray;
        public String pkGameId;
        public int pkGameState;
        public String pkId;
        public String score;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveAryaBroadcastPKGameState {
            public static final int NORMAL = 1;
            public static final int RECORD_ERROR = 2;
            public static final int UNKNOWN = 0;
        }

        public static LiveAryaBroadcastPKGameInfoMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAryaBroadcastPKGameInfoMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAryaBroadcastPKGameInfoMessage() {
            clear();
        }

        public final LiveAryaBroadcastPKGameInfoMessage clear() {
            this.pkGameState = 0;
            this.pkId = "";
            this.pkGameId = "";
            this.score = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.pkGameState;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.pkId);
            }
            if (!this.pkGameId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.pkGameId);
            }
            if (!this.score.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.score);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.pkGameState;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.pkId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.pkId);
            }
            if (!this.pkGameId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.pkGameId);
            }
            return !this.score.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.score) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAryaBroadcastPKGameInfoMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.pkGameState = int32;
                    }
                } else if (tag == 18) {
                    this.pkId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.pkGameId = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.score = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveAryaBroadcastPKGameInfoMessage parseFrom(byte[] bArr) {
            return (LiveAryaBroadcastPKGameInfoMessage) MessageNano.mergeFrom(new LiveAryaBroadcastPKGameInfoMessage(), bArr);
        }

        public static LiveAryaBroadcastPKGameInfoMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAryaBroadcastPKGameInfoMessage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
