package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBullyScreenPkOpen extends MessageNano {
    private static volatile SCLiveBullyScreenPkOpen[] _emptyArray;
    public int bloodHintLimitPercent;
    public long bullyScreenOpenTimestamp;
    public boolean compressedToAudio;
    public int fitMode;
    public boolean forceDisableAudioWhenVoteEnd;
    public String multiPkId;
    public long openAnimationDeadline;
    public Map<Integer, Integer> playerCount2VideoLimitPercent;
    public LivePunishAnimationInfoSource punishAnimationSource;
    public int videoLimitPercent;
    public long windowAnimationDurationMs;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BullyScreenFitMode {
        public static final int DEFAULT_FIT_MODE = 1;
        public static final int MIN_FIT_MODE = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveBullyScreenPkOpen[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBullyScreenPkOpen[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBullyScreenPkOpen() {
        clear();
    }

    public final SCLiveBullyScreenPkOpen clear() {
        this.multiPkId = "";
        this.punishAnimationSource = null;
        this.bullyScreenOpenTimestamp = 0L;
        this.openAnimationDeadline = 0L;
        this.compressedToAudio = false;
        this.bloodHintLimitPercent = 0;
        this.videoLimitPercent = 0;
        this.windowAnimationDurationMs = 0L;
        this.fitMode = 0;
        this.forceDisableAudioWhenVoteEnd = false;
        this.playerCount2VideoLimitPercent = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.multiPkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.multiPkId);
        }
        LivePunishAnimationInfoSource livePunishAnimationInfoSource = this.punishAnimationSource;
        if (livePunishAnimationInfoSource != null) {
            codedOutputByteBufferNano.writeMessage(2, livePunishAnimationInfoSource);
        }
        long j = this.bullyScreenOpenTimestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.openAnimationDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        boolean z = this.compressedToAudio;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i = this.bloodHintLimitPercent;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i);
        }
        int i2 = this.videoLimitPercent;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i2);
        }
        long j3 = this.windowAnimationDurationMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j3);
        }
        int i3 = this.fitMode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i3);
        }
        boolean z2 = this.forceDisableAudioWhenVoteEnd;
        if (z2) {
            codedOutputByteBufferNano.writeBool(10, z2);
        }
        Map<Integer, Integer> map = this.playerCount2VideoLimitPercent;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 11, 13, 13);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.multiPkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.multiPkId);
        }
        LivePunishAnimationInfoSource livePunishAnimationInfoSource = this.punishAnimationSource;
        if (livePunishAnimationInfoSource != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, livePunishAnimationInfoSource);
        }
        long j = this.bullyScreenOpenTimestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.openAnimationDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        boolean z = this.compressedToAudio;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i = this.bloodHintLimitPercent;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i);
        }
        int i2 = this.videoLimitPercent;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i2);
        }
        long j3 = this.windowAnimationDurationMs;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j3);
        }
        int i3 = this.fitMode;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i3);
        }
        boolean z2 = this.forceDisableAudioWhenVoteEnd;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z2);
        }
        Map<Integer, Integer> map = this.playerCount2VideoLimitPercent;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 11, 13, 13) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBullyScreenPkOpen mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.multiPkId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.punishAnimationSource == null) {
                        this.punishAnimationSource = new LivePunishAnimationInfoSource();
                    }
                    codedInputByteBufferNano.readMessage(this.punishAnimationSource);
                    break;
                case 24:
                    this.bullyScreenOpenTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.openAnimationDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.compressedToAudio = codedInputByteBufferNano.readBool();
                    break;
                case 48:
                    this.bloodHintLimitPercent = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.videoLimitPercent = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.windowAnimationDurationMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.fitMode = int32;
                        break;
                    }
                case 80:
                    this.forceDisableAudioWhenVoteEnd = codedInputByteBufferNano.readBool();
                    break;
                case 90:
                    this.playerCount2VideoLimitPercent = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.playerCount2VideoLimitPercent, mapFactory, 13, 13, null, 8, 16);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveBullyScreenPkOpen parseFrom(byte[] bArr) {
        return (SCLiveBullyScreenPkOpen) MessageNano.mergeFrom(new SCLiveBullyScreenPkOpen(), bArr);
    }

    public static SCLiveBullyScreenPkOpen parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBullyScreenPkOpen().mergeFrom(codedInputByteBufferNano);
    }
}
