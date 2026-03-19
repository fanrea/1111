package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCommonEffectInfo;
import com.kuaishou.protobuf.livestage.nano.LiveStageProto;
import com.kuaishou.protobuf.livestream.nano.LiveAllDayBvrpSf2023Proto;
import com.kuaishou.protobuf.livestream.nano.LiveQuizSf2023Proto;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveFlvStream {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveFlvStreamMessageType {
        public static final int FLV_MESSAGE_UNKNOWN = 0;
        public static final int SYNC_BATTLE_LEE_SHOW = 32;
        public static final int SYNC_BATTLE_STATE = 31;
        public static final int SYNC_LIVE_ALL_DAY_BVRP_SF2023 = 27;
        public static final int SYNC_LIVE_ANCHOR_QOS_INFO = 10;
        public static final int SYNC_LIVE_CAMERA_FACE_INFO = 18;
        public static final int SYNC_LIVE_CHAT_STATUS = 11;
        public static final int SYNC_LIVE_CHAT_VIEW_POSITION = 12;
        public static final int SYNC_LIVE_COMMON_EFFECT_INFO = 21;
        public static final int SYNC_LIVE_FACE_AREAS = 13;
        public static final int SYNC_LIVE_FACE_TRANS_DATA = 16;
        public static final int SYNC_LIVE_FOLLOW_POPUP = 6;
        public static final int SYNC_LIVE_LINE_CHAT = 14;
        public static final int SYNC_LIVE_MAGIC_FACE_EFFECT = 8;
        public static final int SYNC_LIVE_MERCHANT_WAKEUP_INFO = 20;
        public static final int SYNC_LIVE_MULTI_CHAT_VIEW_POSITION = 17;
        public static final int SYNC_LIVE_PK_GAME_INFO = 9;
        public static final int SYNC_LIVE_QUIZ2 = 5;
        public static final int SYNC_LIVE_QUIZ3 = 30;
        public static final int SYNC_LIVE_QUIZ3_ROUND_LEE = 33;
        public static final int SYNC_LIVE_QUIZ_SF2023 = 26;
        public static final int SYNC_LIVE_SHADE_AUDIT = 28;
        public static final int SYNC_LIVE_SHADE_BACKSTAGE = 29;
        public static final int SYNC_LIVE_SPEAKERS = 15;
        public static final int SYNC_LIVE_STAGE_AUDIO_STATUS = 24;
        public static final int SYNC_LIVE_THEATER = 7;
        public static final int SYNC_LIVE_VOICE_PARTY_AUDIO_CHAT_INFO = 25;
        public static final int SYNC_LIVE_VOICE_PARTY_GRID_CHAT_LAYOUT_INFO = 22;
        public static final int SYNC_LIVE_VOICE_PARTY_VIDEO_LAYOUT_INFO = 19;
        public static final int SYNC_LYRICS = 2;
        public static final int SYNC_LYRICS_STOP = 3;
        public static final int SYNC_PET_ACTION = 4;
        public static final int VOICE_PARTY_SPEAK_STATUS = 1;
    }

    public static final class LiveFlvStreamMessage extends MessageNano {
        private static volatile LiveFlvStreamMessage[] _emptyArray;
        public LiveAnchorQosInfoSyncMessage anchorQosInfoSync;
        public LiveCameraFaceDataMessage cameraFaceInfo;
        public LiveCentaurLayoutConfigMessage centaurLayoutConfig;
        public LiveChatSyncMessage chatStatusSync;
        public LiveChatViewPostionMessage chatViewPosition;
        public LiveCommonEffectInfo commonEffectInfo;
        public LiveFaceAreasMessage faceAreaInfo;
        public LiveFaceTransDataMessage facePointInfo;
        public LiveFollowPopupSyncMessage followPopupSync;
        public LiveLineChatMessage lineChatInfo;
        public LiveAllDayBvrpSf2023Proto.LiveAllDayBvrpSf2023 liveAllDayBvrpSf2023;
        public LiveRedBlueBattleLeeShowSyncMessage liveBattleLeeShow;
        public LiveRedBlueBattleStateSyncMessage liveBattleStateSync;
        public LiveQuiz3PublishRoundWinnerMessage liveQuiz3PublishRoundWinner;
        public LiveQuizSf2023Proto.LiveQuizAacSyncSf2023 liveQuizAacSyncSf2023;
        public LiveStageProto.AudioStatus liveStageAudioStatus;
        public LiveStageLayoutConfigChecksum liveStageLayoutConfigChecksum;
        public LiveStageLayoutConfigHashMessage liveStageLayoutConfigHash;
        public LiveMagicFaceEffectSyncMessage magicFaceEffectSync;
        public LiveMerchantWakeupMessage merchantWakeupInfo;
        public int messageType;
        public LiveChatViewPostionMessage[] participantViewPosition;
        public LivePKGameInfoSyncMessage pkGameInfoSync;
        public LiveQuiz2SyncMessage quiz2Sync;
        public LiveQuiz3SyncMessage quiz3Sync;
        public LiveShadeAuditMessage shadeAuditMessage;
        public LiveShadeBackstageMessage shadeBackstageMessage;
        public LiveActiveSpeakersMessage speakersInfo;
        public LiveFlvSyncLyricsMessage syncLyrics;
        public LiveFlvSyncLyricsStopMessage syncLyricsStop;
        public LiveFlvSyncPetMessage syncPetAction;
        public LiveFlvVoicePartyMessage voiceParty;
        public LiveFlvSyncTheaterCommandMessage voicePartyTheater;
        public LiveVoicePartyVideoLayoutMessage voicePartyVideoLayoutInfo;

        public static LiveFlvStreamMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFlvStreamMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFlvStreamMessage() {
            clear();
        }

        public final LiveFlvStreamMessage clear() {
            this.messageType = 0;
            this.voiceParty = null;
            this.syncLyrics = null;
            this.syncLyricsStop = null;
            this.syncPetAction = null;
            this.quiz2Sync = null;
            this.followPopupSync = null;
            this.voicePartyTheater = null;
            this.magicFaceEffectSync = null;
            this.pkGameInfoSync = null;
            this.anchorQosInfoSync = null;
            this.chatStatusSync = null;
            this.chatViewPosition = null;
            this.faceAreaInfo = null;
            this.lineChatInfo = null;
            this.speakersInfo = null;
            this.facePointInfo = null;
            this.participantViewPosition = LiveChatViewPostionMessage.emptyArray();
            this.cameraFaceInfo = null;
            this.voicePartyVideoLayoutInfo = null;
            this.merchantWakeupInfo = null;
            this.commonEffectInfo = null;
            this.centaurLayoutConfig = null;
            this.liveStageAudioStatus = null;
            this.liveQuizAacSyncSf2023 = null;
            this.liveAllDayBvrpSf2023 = null;
            this.liveStageLayoutConfigChecksum = null;
            this.liveStageLayoutConfigHash = null;
            this.shadeAuditMessage = null;
            this.shadeBackstageMessage = null;
            this.quiz3Sync = null;
            this.liveBattleStateSync = null;
            this.liveBattleLeeShow = null;
            this.liveQuiz3PublishRoundWinner = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.messageType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            LiveFlvVoicePartyMessage liveFlvVoicePartyMessage = this.voiceParty;
            if (liveFlvVoicePartyMessage != null) {
                codedOutputByteBufferNano.writeMessage(2, liveFlvVoicePartyMessage);
            }
            LiveFlvSyncLyricsMessage liveFlvSyncLyricsMessage = this.syncLyrics;
            if (liveFlvSyncLyricsMessage != null) {
                codedOutputByteBufferNano.writeMessage(3, liveFlvSyncLyricsMessage);
            }
            LiveFlvSyncLyricsStopMessage liveFlvSyncLyricsStopMessage = this.syncLyricsStop;
            if (liveFlvSyncLyricsStopMessage != null) {
                codedOutputByteBufferNano.writeMessage(4, liveFlvSyncLyricsStopMessage);
            }
            LiveFlvSyncPetMessage liveFlvSyncPetMessage = this.syncPetAction;
            if (liveFlvSyncPetMessage != null) {
                codedOutputByteBufferNano.writeMessage(5, liveFlvSyncPetMessage);
            }
            LiveQuiz2SyncMessage liveQuiz2SyncMessage = this.quiz2Sync;
            if (liveQuiz2SyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(6, liveQuiz2SyncMessage);
            }
            LiveFollowPopupSyncMessage liveFollowPopupSyncMessage = this.followPopupSync;
            if (liveFollowPopupSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(7, liveFollowPopupSyncMessage);
            }
            LiveFlvSyncTheaterCommandMessage liveFlvSyncTheaterCommandMessage = this.voicePartyTheater;
            if (liveFlvSyncTheaterCommandMessage != null) {
                codedOutputByteBufferNano.writeMessage(8, liveFlvSyncTheaterCommandMessage);
            }
            LiveMagicFaceEffectSyncMessage liveMagicFaceEffectSyncMessage = this.magicFaceEffectSync;
            if (liveMagicFaceEffectSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(9, liveMagicFaceEffectSyncMessage);
            }
            LivePKGameInfoSyncMessage livePKGameInfoSyncMessage = this.pkGameInfoSync;
            if (livePKGameInfoSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(10, livePKGameInfoSyncMessage);
            }
            LiveAnchorQosInfoSyncMessage liveAnchorQosInfoSyncMessage = this.anchorQosInfoSync;
            if (liveAnchorQosInfoSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(11, liveAnchorQosInfoSyncMessage);
            }
            LiveChatSyncMessage liveChatSyncMessage = this.chatStatusSync;
            if (liveChatSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(12, liveChatSyncMessage);
            }
            LiveChatViewPostionMessage liveChatViewPostionMessage = this.chatViewPosition;
            if (liveChatViewPostionMessage != null) {
                codedOutputByteBufferNano.writeMessage(13, liveChatViewPostionMessage);
            }
            LiveFaceAreasMessage liveFaceAreasMessage = this.faceAreaInfo;
            if (liveFaceAreasMessage != null) {
                codedOutputByteBufferNano.writeMessage(14, liveFaceAreasMessage);
            }
            LiveLineChatMessage liveLineChatMessage = this.lineChatInfo;
            if (liveLineChatMessage != null) {
                codedOutputByteBufferNano.writeMessage(15, liveLineChatMessage);
            }
            LiveActiveSpeakersMessage liveActiveSpeakersMessage = this.speakersInfo;
            if (liveActiveSpeakersMessage != null) {
                codedOutputByteBufferNano.writeMessage(16, liveActiveSpeakersMessage);
            }
            LiveFaceTransDataMessage liveFaceTransDataMessage = this.facePointInfo;
            if (liveFaceTransDataMessage != null) {
                codedOutputByteBufferNano.writeMessage(17, liveFaceTransDataMessage);
            }
            LiveChatViewPostionMessage[] liveChatViewPostionMessageArr = this.participantViewPosition;
            if (liveChatViewPostionMessageArr != null && liveChatViewPostionMessageArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveChatViewPostionMessage[] liveChatViewPostionMessageArr2 = this.participantViewPosition;
                    if (i2 >= liveChatViewPostionMessageArr2.length) {
                        break;
                    }
                    LiveChatViewPostionMessage liveChatViewPostionMessage2 = liveChatViewPostionMessageArr2[i2];
                    if (liveChatViewPostionMessage2 != null) {
                        codedOutputByteBufferNano.writeMessage(18, liveChatViewPostionMessage2);
                    }
                    i2++;
                }
            }
            LiveCameraFaceDataMessage liveCameraFaceDataMessage = this.cameraFaceInfo;
            if (liveCameraFaceDataMessage != null) {
                codedOutputByteBufferNano.writeMessage(19, liveCameraFaceDataMessage);
            }
            LiveVoicePartyVideoLayoutMessage liveVoicePartyVideoLayoutMessage = this.voicePartyVideoLayoutInfo;
            if (liveVoicePartyVideoLayoutMessage != null) {
                codedOutputByteBufferNano.writeMessage(20, liveVoicePartyVideoLayoutMessage);
            }
            LiveMerchantWakeupMessage liveMerchantWakeupMessage = this.merchantWakeupInfo;
            if (liveMerchantWakeupMessage != null) {
                codedOutputByteBufferNano.writeMessage(21, liveMerchantWakeupMessage);
            }
            LiveCommonEffectInfo liveCommonEffectInfo = this.commonEffectInfo;
            if (liveCommonEffectInfo != null) {
                codedOutputByteBufferNano.writeMessage(22, liveCommonEffectInfo);
            }
            LiveCentaurLayoutConfigMessage liveCentaurLayoutConfigMessage = this.centaurLayoutConfig;
            if (liveCentaurLayoutConfigMessage != null) {
                codedOutputByteBufferNano.writeMessage(23, liveCentaurLayoutConfigMessage);
            }
            LiveStageProto.AudioStatus audioStatus = this.liveStageAudioStatus;
            if (audioStatus != null) {
                codedOutputByteBufferNano.writeMessage(24, audioStatus);
            }
            LiveQuizSf2023Proto.LiveQuizAacSyncSf2023 liveQuizAacSyncSf2023 = this.liveQuizAacSyncSf2023;
            if (liveQuizAacSyncSf2023 != null) {
                codedOutputByteBufferNano.writeMessage(25, liveQuizAacSyncSf2023);
            }
            LiveAllDayBvrpSf2023Proto.LiveAllDayBvrpSf2023 liveAllDayBvrpSf2023 = this.liveAllDayBvrpSf2023;
            if (liveAllDayBvrpSf2023 != null) {
                codedOutputByteBufferNano.writeMessage(26, liveAllDayBvrpSf2023);
            }
            LiveStageLayoutConfigChecksum liveStageLayoutConfigChecksum = this.liveStageLayoutConfigChecksum;
            if (liveStageLayoutConfigChecksum != null) {
                codedOutputByteBufferNano.writeMessage(27, liveStageLayoutConfigChecksum);
            }
            LiveStageLayoutConfigHashMessage liveStageLayoutConfigHashMessage = this.liveStageLayoutConfigHash;
            if (liveStageLayoutConfigHashMessage != null) {
                codedOutputByteBufferNano.writeMessage(28, liveStageLayoutConfigHashMessage);
            }
            LiveShadeAuditMessage liveShadeAuditMessage = this.shadeAuditMessage;
            if (liveShadeAuditMessage != null) {
                codedOutputByteBufferNano.writeMessage(29, liveShadeAuditMessage);
            }
            LiveShadeBackstageMessage liveShadeBackstageMessage = this.shadeBackstageMessage;
            if (liveShadeBackstageMessage != null) {
                codedOutputByteBufferNano.writeMessage(30, liveShadeBackstageMessage);
            }
            LiveQuiz3SyncMessage liveQuiz3SyncMessage = this.quiz3Sync;
            if (liveQuiz3SyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(31, liveQuiz3SyncMessage);
            }
            LiveRedBlueBattleStateSyncMessage liveRedBlueBattleStateSyncMessage = this.liveBattleStateSync;
            if (liveRedBlueBattleStateSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(32, liveRedBlueBattleStateSyncMessage);
            }
            LiveRedBlueBattleLeeShowSyncMessage liveRedBlueBattleLeeShowSyncMessage = this.liveBattleLeeShow;
            if (liveRedBlueBattleLeeShowSyncMessage != null) {
                codedOutputByteBufferNano.writeMessage(33, liveRedBlueBattleLeeShowSyncMessage);
            }
            LiveQuiz3PublishRoundWinnerMessage liveQuiz3PublishRoundWinnerMessage = this.liveQuiz3PublishRoundWinner;
            if (liveQuiz3PublishRoundWinnerMessage != null) {
                codedOutputByteBufferNano.writeMessage(34, liveQuiz3PublishRoundWinnerMessage);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.messageType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            LiveFlvVoicePartyMessage liveFlvVoicePartyMessage = this.voiceParty;
            if (liveFlvVoicePartyMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveFlvVoicePartyMessage);
            }
            LiveFlvSyncLyricsMessage liveFlvSyncLyricsMessage = this.syncLyrics;
            if (liveFlvSyncLyricsMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveFlvSyncLyricsMessage);
            }
            LiveFlvSyncLyricsStopMessage liveFlvSyncLyricsStopMessage = this.syncLyricsStop;
            if (liveFlvSyncLyricsStopMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveFlvSyncLyricsStopMessage);
            }
            LiveFlvSyncPetMessage liveFlvSyncPetMessage = this.syncPetAction;
            if (liveFlvSyncPetMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveFlvSyncPetMessage);
            }
            LiveQuiz2SyncMessage liveQuiz2SyncMessage = this.quiz2Sync;
            if (liveQuiz2SyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveQuiz2SyncMessage);
            }
            LiveFollowPopupSyncMessage liveFollowPopupSyncMessage = this.followPopupSync;
            if (liveFollowPopupSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveFollowPopupSyncMessage);
            }
            LiveFlvSyncTheaterCommandMessage liveFlvSyncTheaterCommandMessage = this.voicePartyTheater;
            if (liveFlvSyncTheaterCommandMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveFlvSyncTheaterCommandMessage);
            }
            LiveMagicFaceEffectSyncMessage liveMagicFaceEffectSyncMessage = this.magicFaceEffectSync;
            if (liveMagicFaceEffectSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveMagicFaceEffectSyncMessage);
            }
            LivePKGameInfoSyncMessage livePKGameInfoSyncMessage = this.pkGameInfoSync;
            if (livePKGameInfoSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, livePKGameInfoSyncMessage);
            }
            LiveAnchorQosInfoSyncMessage liveAnchorQosInfoSyncMessage = this.anchorQosInfoSync;
            if (liveAnchorQosInfoSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, liveAnchorQosInfoSyncMessage);
            }
            LiveChatSyncMessage liveChatSyncMessage = this.chatStatusSync;
            if (liveChatSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, liveChatSyncMessage);
            }
            LiveChatViewPostionMessage liveChatViewPostionMessage = this.chatViewPosition;
            if (liveChatViewPostionMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, liveChatViewPostionMessage);
            }
            LiveFaceAreasMessage liveFaceAreasMessage = this.faceAreaInfo;
            if (liveFaceAreasMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, liveFaceAreasMessage);
            }
            LiveLineChatMessage liveLineChatMessage = this.lineChatInfo;
            if (liveLineChatMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, liveLineChatMessage);
            }
            LiveActiveSpeakersMessage liveActiveSpeakersMessage = this.speakersInfo;
            if (liveActiveSpeakersMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, liveActiveSpeakersMessage);
            }
            LiveFaceTransDataMessage liveFaceTransDataMessage = this.facePointInfo;
            if (liveFaceTransDataMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, liveFaceTransDataMessage);
            }
            LiveChatViewPostionMessage[] liveChatViewPostionMessageArr = this.participantViewPosition;
            if (liveChatViewPostionMessageArr != null && liveChatViewPostionMessageArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveChatViewPostionMessage[] liveChatViewPostionMessageArr2 = this.participantViewPosition;
                    if (i2 >= liveChatViewPostionMessageArr2.length) {
                        break;
                    }
                    LiveChatViewPostionMessage liveChatViewPostionMessage2 = liveChatViewPostionMessageArr2[i2];
                    if (liveChatViewPostionMessage2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, liveChatViewPostionMessage2);
                    }
                    i2++;
                }
            }
            LiveCameraFaceDataMessage liveCameraFaceDataMessage = this.cameraFaceInfo;
            if (liveCameraFaceDataMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, liveCameraFaceDataMessage);
            }
            LiveVoicePartyVideoLayoutMessage liveVoicePartyVideoLayoutMessage = this.voicePartyVideoLayoutInfo;
            if (liveVoicePartyVideoLayoutMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, liveVoicePartyVideoLayoutMessage);
            }
            LiveMerchantWakeupMessage liveMerchantWakeupMessage = this.merchantWakeupInfo;
            if (liveMerchantWakeupMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, liveMerchantWakeupMessage);
            }
            LiveCommonEffectInfo liveCommonEffectInfo = this.commonEffectInfo;
            if (liveCommonEffectInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, liveCommonEffectInfo);
            }
            LiveCentaurLayoutConfigMessage liveCentaurLayoutConfigMessage = this.centaurLayoutConfig;
            if (liveCentaurLayoutConfigMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, liveCentaurLayoutConfigMessage);
            }
            LiveStageProto.AudioStatus audioStatus = this.liveStageAudioStatus;
            if (audioStatus != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, audioStatus);
            }
            LiveQuizSf2023Proto.LiveQuizAacSyncSf2023 liveQuizAacSyncSf2023 = this.liveQuizAacSyncSf2023;
            if (liveQuizAacSyncSf2023 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, liveQuizAacSyncSf2023);
            }
            LiveAllDayBvrpSf2023Proto.LiveAllDayBvrpSf2023 liveAllDayBvrpSf2023 = this.liveAllDayBvrpSf2023;
            if (liveAllDayBvrpSf2023 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, liveAllDayBvrpSf2023);
            }
            LiveStageLayoutConfigChecksum liveStageLayoutConfigChecksum = this.liveStageLayoutConfigChecksum;
            if (liveStageLayoutConfigChecksum != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, liveStageLayoutConfigChecksum);
            }
            LiveStageLayoutConfigHashMessage liveStageLayoutConfigHashMessage = this.liveStageLayoutConfigHash;
            if (liveStageLayoutConfigHashMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(28, liveStageLayoutConfigHashMessage);
            }
            LiveShadeAuditMessage liveShadeAuditMessage = this.shadeAuditMessage;
            if (liveShadeAuditMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(29, liveShadeAuditMessage);
            }
            LiveShadeBackstageMessage liveShadeBackstageMessage = this.shadeBackstageMessage;
            if (liveShadeBackstageMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, liveShadeBackstageMessage);
            }
            LiveQuiz3SyncMessage liveQuiz3SyncMessage = this.quiz3Sync;
            if (liveQuiz3SyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(31, liveQuiz3SyncMessage);
            }
            LiveRedBlueBattleStateSyncMessage liveRedBlueBattleStateSyncMessage = this.liveBattleStateSync;
            if (liveRedBlueBattleStateSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(32, liveRedBlueBattleStateSyncMessage);
            }
            LiveRedBlueBattleLeeShowSyncMessage liveRedBlueBattleLeeShowSyncMessage = this.liveBattleLeeShow;
            if (liveRedBlueBattleLeeShowSyncMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(33, liveRedBlueBattleLeeShowSyncMessage);
            }
            LiveQuiz3PublishRoundWinnerMessage liveQuiz3PublishRoundWinnerMessage = this.liveQuiz3PublishRoundWinner;
            return liveQuiz3PublishRoundWinnerMessage != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(34, liveQuiz3PublishRoundWinnerMessage) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFlvStreamMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                                this.messageType = int32;
                                break;
                        }
                    case 18:
                        if (this.voiceParty == null) {
                            this.voiceParty = new LiveFlvVoicePartyMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.voiceParty);
                        break;
                    case 26:
                        if (this.syncLyrics == null) {
                            this.syncLyrics = new LiveFlvSyncLyricsMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.syncLyrics);
                        break;
                    case 34:
                        if (this.syncLyricsStop == null) {
                            this.syncLyricsStop = new LiveFlvSyncLyricsStopMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.syncLyricsStop);
                        break;
                    case 42:
                        if (this.syncPetAction == null) {
                            this.syncPetAction = new LiveFlvSyncPetMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.syncPetAction);
                        break;
                    case 50:
                        if (this.quiz2Sync == null) {
                            this.quiz2Sync = new LiveQuiz2SyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.quiz2Sync);
                        break;
                    case 58:
                        if (this.followPopupSync == null) {
                            this.followPopupSync = new LiveFollowPopupSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.followPopupSync);
                        break;
                    case 66:
                        if (this.voicePartyTheater == null) {
                            this.voicePartyTheater = new LiveFlvSyncTheaterCommandMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.voicePartyTheater);
                        break;
                    case 74:
                        if (this.magicFaceEffectSync == null) {
                            this.magicFaceEffectSync = new LiveMagicFaceEffectSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.magicFaceEffectSync);
                        break;
                    case 82:
                        if (this.pkGameInfoSync == null) {
                            this.pkGameInfoSync = new LivePKGameInfoSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.pkGameInfoSync);
                        break;
                    case 90:
                        if (this.anchorQosInfoSync == null) {
                            this.anchorQosInfoSync = new LiveAnchorQosInfoSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.anchorQosInfoSync);
                        break;
                    case 98:
                        if (this.chatStatusSync == null) {
                            this.chatStatusSync = new LiveChatSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.chatStatusSync);
                        break;
                    case 106:
                        if (this.chatViewPosition == null) {
                            this.chatViewPosition = new LiveChatViewPostionMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.chatViewPosition);
                        break;
                    case 114:
                        if (this.faceAreaInfo == null) {
                            this.faceAreaInfo = new LiveFaceAreasMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.faceAreaInfo);
                        break;
                    case 122:
                        if (this.lineChatInfo == null) {
                            this.lineChatInfo = new LiveLineChatMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.lineChatInfo);
                        break;
                    case 130:
                        if (this.speakersInfo == null) {
                            this.speakersInfo = new LiveActiveSpeakersMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.speakersInfo);
                        break;
                    case 138:
                        if (this.facePointInfo == null) {
                            this.facePointInfo = new LiveFaceTransDataMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.facePointInfo);
                        break;
                    case 146:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                        LiveChatViewPostionMessage[] liveChatViewPostionMessageArr = this.participantViewPosition;
                        int length = liveChatViewPostionMessageArr == null ? 0 : liveChatViewPostionMessageArr.length;
                        LiveChatViewPostionMessage[] liveChatViewPostionMessageArr2 = new LiveChatViewPostionMessage[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.participantViewPosition, 0, liveChatViewPostionMessageArr2, 0, length);
                        }
                        while (length < liveChatViewPostionMessageArr2.length - 1) {
                            liveChatViewPostionMessageArr2[length] = new LiveChatViewPostionMessage();
                            codedInputByteBufferNano.readMessage(liveChatViewPostionMessageArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveChatViewPostionMessageArr2[length] = new LiveChatViewPostionMessage();
                        codedInputByteBufferNano.readMessage(liveChatViewPostionMessageArr2[length]);
                        this.participantViewPosition = liveChatViewPostionMessageArr2;
                        break;
                    case 154:
                        if (this.cameraFaceInfo == null) {
                            this.cameraFaceInfo = new LiveCameraFaceDataMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.cameraFaceInfo);
                        break;
                    case 162:
                        if (this.voicePartyVideoLayoutInfo == null) {
                            this.voicePartyVideoLayoutInfo = new LiveVoicePartyVideoLayoutMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.voicePartyVideoLayoutInfo);
                        break;
                    case 170:
                        if (this.merchantWakeupInfo == null) {
                            this.merchantWakeupInfo = new LiveMerchantWakeupMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.merchantWakeupInfo);
                        break;
                    case 178:
                        if (this.commonEffectInfo == null) {
                            this.commonEffectInfo = new LiveCommonEffectInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.commonEffectInfo);
                        break;
                    case 186:
                        if (this.centaurLayoutConfig == null) {
                            this.centaurLayoutConfig = new LiveCentaurLayoutConfigMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.centaurLayoutConfig);
                        break;
                    case 194:
                        if (this.liveStageAudioStatus == null) {
                            this.liveStageAudioStatus = new LiveStageProto.AudioStatus();
                        }
                        codedInputByteBufferNano.readMessage(this.liveStageAudioStatus);
                        break;
                    case 202:
                        if (this.liveQuizAacSyncSf2023 == null) {
                            this.liveQuizAacSyncSf2023 = new LiveQuizSf2023Proto.LiveQuizAacSyncSf2023();
                        }
                        codedInputByteBufferNano.readMessage(this.liveQuizAacSyncSf2023);
                        break;
                    case 210:
                        if (this.liveAllDayBvrpSf2023 == null) {
                            this.liveAllDayBvrpSf2023 = new LiveAllDayBvrpSf2023Proto.LiveAllDayBvrpSf2023();
                        }
                        codedInputByteBufferNano.readMessage(this.liveAllDayBvrpSf2023);
                        break;
                    case 218:
                        if (this.liveStageLayoutConfigChecksum == null) {
                            this.liveStageLayoutConfigChecksum = new LiveStageLayoutConfigChecksum();
                        }
                        codedInputByteBufferNano.readMessage(this.liveStageLayoutConfigChecksum);
                        break;
                    case 226:
                        if (this.liveStageLayoutConfigHash == null) {
                            this.liveStageLayoutConfigHash = new LiveStageLayoutConfigHashMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.liveStageLayoutConfigHash);
                        break;
                    case 234:
                        if (this.shadeAuditMessage == null) {
                            this.shadeAuditMessage = new LiveShadeAuditMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.shadeAuditMessage);
                        break;
                    case 242:
                        if (this.shadeBackstageMessage == null) {
                            this.shadeBackstageMessage = new LiveShadeBackstageMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.shadeBackstageMessage);
                        break;
                    case 250:
                        if (this.quiz3Sync == null) {
                            this.quiz3Sync = new LiveQuiz3SyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.quiz3Sync);
                        break;
                    case 258:
                        if (this.liveBattleStateSync == null) {
                            this.liveBattleStateSync = new LiveRedBlueBattleStateSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.liveBattleStateSync);
                        break;
                    case 266:
                        if (this.liveBattleLeeShow == null) {
                            this.liveBattleLeeShow = new LiveRedBlueBattleLeeShowSyncMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.liveBattleLeeShow);
                        break;
                    case 274:
                        if (this.liveQuiz3PublishRoundWinner == null) {
                            this.liveQuiz3PublishRoundWinner = new LiveQuiz3PublishRoundWinnerMessage();
                        }
                        codedInputByteBufferNano.readMessage(this.liveQuiz3PublishRoundWinner);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveFlvStreamMessage parseFrom(byte[] bArr) {
            return (LiveFlvStreamMessage) MessageNano.mergeFrom(new LiveFlvStreamMessage(), bArr);
        }

        public static LiveFlvStreamMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFlvStreamMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFlvVoicePartyMessage extends MessageNano {
        private static volatile LiveFlvVoicePartyMessage[] _emptyArray;
        public String[] activeSpeakers;

        public static LiveFlvVoicePartyMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFlvVoicePartyMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFlvVoicePartyMessage() {
            clear();
        }

        public final LiveFlvVoicePartyMessage clear() {
            this.activeSpeakers = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            String[] strArr = this.activeSpeakers;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.activeSpeakers;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(1, str);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String[] strArr = this.activeSpeakers;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeStringSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.activeSpeakers;
                if (i >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFlvVoicePartyMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    String[] strArr = this.activeSpeakers;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.activeSpeakers, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.activeSpeakers = strArr2;
                }
            }
        }

        public static LiveFlvVoicePartyMessage parseFrom(byte[] bArr) {
            return (LiveFlvVoicePartyMessage) MessageNano.mergeFrom(new LiveFlvVoicePartyMessage(), bArr);
        }

        public static LiveFlvVoicePartyMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFlvVoicePartyMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFlvSyncLyricsMessage extends MessageNano {
        private static volatile LiveFlvSyncLyricsMessage[] _emptyArray;
        public long lyricsOffset;
        public String orderId;
        public int syncLyricsType;
        public int syncState;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveFlvSyncLyricsMessageType {
            public static final int ANCHOR_MUSIC_SYNC_LYRICS = 2;
            public static final int KTV_SYNC_LYRICS = 1;
            public static final int LYRICS_MESSAGE_UNKNOWN = 0;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SyncLyricsState {
            public static final int LYRICS_STATE_PAUSE = 2;
            public static final int LYRICS_STATE_PLAY = 1;
            public static final int LYRICS_STATE_STOP = 3;
            public static final int LYRICS_STATE_UNKNOWN = 0;
        }

        public static LiveFlvSyncLyricsMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFlvSyncLyricsMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFlvSyncLyricsMessage() {
            clear();
        }

        public final LiveFlvSyncLyricsMessage clear() {
            this.syncLyricsType = 0;
            this.lyricsOffset = 0L;
            this.orderId = "";
            this.syncState = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.syncLyricsType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.lyricsOffset;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.orderId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.orderId);
            }
            int i2 = this.syncState;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.syncLyricsType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.lyricsOffset;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.orderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.orderId);
            }
            int i2 = this.syncState;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFlvSyncLyricsMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.syncLyricsType = int32;
                    }
                } else if (tag == 16) {
                    this.lyricsOffset = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.orderId = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3) {
                        this.syncState = int322;
                    }
                }
            }
        }

        public static LiveFlvSyncLyricsMessage parseFrom(byte[] bArr) {
            return (LiveFlvSyncLyricsMessage) MessageNano.mergeFrom(new LiveFlvSyncLyricsMessage(), bArr);
        }

        public static LiveFlvSyncLyricsMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFlvSyncLyricsMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFlvSyncPetMessage extends MessageNano {
        private static volatile LiveFlvSyncPetMessage[] _emptyArray;
        public int actionId;
        public int messageType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveFlvSyncPetMessageType {
            public static final int PET_MESSAGE_UNKNOWN = 0;
            public static final int SYNC_ACTION = 1;
        }

        public static LiveFlvSyncPetMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFlvSyncPetMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFlvSyncPetMessage() {
            clear();
        }

        public final LiveFlvSyncPetMessage clear() {
            this.actionId = 0;
            this.messageType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.actionId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.messageType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.actionId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.messageType;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFlvSyncPetMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.actionId = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.messageType = int32;
                    }
                }
            }
        }

        public static LiveFlvSyncPetMessage parseFrom(byte[] bArr) {
            return (LiveFlvSyncPetMessage) MessageNano.mergeFrom(new LiveFlvSyncPetMessage(), bArr);
        }

        public static LiveFlvSyncPetMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFlvSyncPetMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFlvSyncLyricsStopMessage extends MessageNano {
        private static volatile LiveFlvSyncLyricsStopMessage[] _emptyArray;
        public String orderId;

        public static LiveFlvSyncLyricsStopMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFlvSyncLyricsStopMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFlvSyncLyricsStopMessage() {
            clear();
        }

        public final LiveFlvSyncLyricsStopMessage clear() {
            this.orderId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.orderId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.orderId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.orderId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.orderId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFlvSyncLyricsStopMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.orderId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveFlvSyncLyricsStopMessage parseFrom(byte[] bArr) {
            return (LiveFlvSyncLyricsStopMessage) MessageNano.mergeFrom(new LiveFlvSyncLyricsStopMessage(), bArr);
        }

        public static LiveFlvSyncLyricsStopMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFlvSyncLyricsStopMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz2SyncMessage extends MessageNano {
        private static volatile LiveQuiz2SyncMessage[] _emptyArray;
        public int questionNumber;
        public String quizId;
        public int syncMessageType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveQuiz2SyncMessageType {
            public static final int MESSAGE_UNKNOWN = 0;
            public static final int SHOW_ANSWER = 2;
            public static final int SHOW_QUESTION = 1;
        }

        public static LiveQuiz2SyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz2SyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz2SyncMessage() {
            clear();
        }

        public final LiveQuiz2SyncMessage clear() {
            this.syncMessageType = 0;
            this.quizId = "";
            this.questionNumber = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.syncMessageType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.quizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.quizId);
            }
            int i2 = this.questionNumber;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.syncMessageType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.quizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.quizId);
            }
            int i2 = this.questionNumber;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz2SyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.syncMessageType = int32;
                    }
                } else if (tag == 18) {
                    this.quizId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.questionNumber = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveQuiz2SyncMessage parseFrom(byte[] bArr) {
            return (LiveQuiz2SyncMessage) MessageNano.mergeFrom(new LiveQuiz2SyncMessage(), bArr);
        }

        public static LiveQuiz2SyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz2SyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFollowPopupSyncMessage extends MessageNano {
        private static volatile LiveFollowPopupSyncMessage[] _emptyArray;
        public long sequenceId;

        public static LiveFollowPopupSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFollowPopupSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFollowPopupSyncMessage() {
            clear();
        }

        public final LiveFollowPopupSyncMessage clear() {
            this.sequenceId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.sequenceId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.sequenceId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFollowPopupSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.sequenceId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveFollowPopupSyncMessage parseFrom(byte[] bArr) {
            return (LiveFollowPopupSyncMessage) MessageNano.mergeFrom(new LiveFollowPopupSyncMessage(), bArr);
        }

        public static LiveFollowPopupSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFollowPopupSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFlvSyncTheaterCommandMessage extends MessageNano {
        private static volatile LiveFlvSyncTheaterCommandMessage[] _emptyArray;
        public long currentPosition;
        public String episodeOrderId;
        public boolean hasPlayVolume;
        public float playVolume;
        public int theaterCommandType;
        public String theaterId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveFlvSyncTheaterCommandType {
            public static final int COMMAND_PAUSE = 2;
            public static final int COMMAND_PLAY = 1;
            public static final int COMMAND_SEEK = 3;
            public static final int COMMAND_UNKNOWN = 0;
        }

        public static LiveFlvSyncTheaterCommandMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFlvSyncTheaterCommandMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFlvSyncTheaterCommandMessage() {
            clear();
        }

        public final LiveFlvSyncTheaterCommandMessage clear() {
            this.theaterId = "";
            this.episodeOrderId = "";
            this.theaterCommandType = 0;
            this.currentPosition = 0L;
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
            if (Float.floatToIntBits(this.playVolume) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(5, this.playVolume);
            }
            boolean z = this.hasPlayVolume;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
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
            if (Float.floatToIntBits(this.playVolume) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.playVolume);
            }
            boolean z = this.hasPlayVolume;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFlvSyncTheaterCommandMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.playVolume = codedInputByteBufferNano.readFloat();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.hasPlayVolume = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveFlvSyncTheaterCommandMessage parseFrom(byte[] bArr) {
            return (LiveFlvSyncTheaterCommandMessage) MessageNano.mergeFrom(new LiveFlvSyncTheaterCommandMessage(), bArr);
        }

        public static LiveFlvSyncTheaterCommandMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFlvSyncTheaterCommandMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveMagicFaceEffectSyncMessage extends MessageNano {
        private static volatile LiveMagicFaceEffectSyncMessage[] _emptyArray;
        public boolean cleanEffectsImmediately;
        public long magicFaceId;
        public long playCount;
        public long time;

        public static LiveMagicFaceEffectSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveMagicFaceEffectSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveMagicFaceEffectSyncMessage() {
            clear();
        }

        public final LiveMagicFaceEffectSyncMessage clear() {
            this.cleanEffectsImmediately = false;
            this.magicFaceId = 0L;
            this.playCount = 0L;
            this.time = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.cleanEffectsImmediately;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long j = this.magicFaceId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.playCount;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            long j3 = this.time;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.cleanEffectsImmediately;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long j = this.magicFaceId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.playCount;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            long j3 = this.time;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveMagicFaceEffectSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.cleanEffectsImmediately = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.magicFaceId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.playCount = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.time = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveMagicFaceEffectSyncMessage parseFrom(byte[] bArr) {
            return (LiveMagicFaceEffectSyncMessage) MessageNano.mergeFrom(new LiveMagicFaceEffectSyncMessage(), bArr);
        }

        public static LiveMagicFaceEffectSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveMagicFaceEffectSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LivePKGameInfoSyncMessage extends MessageNano {
        private static volatile LivePKGameInfoSyncMessage[] _emptyArray;
        public String anchorScore;
        public String otherAnchorScore;
        public String pkGameId;
        public int pkGameState;
        public String pkId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveFlvSyncPKGameState {
            public static final int NORMAL = 1;
            public static final int RECORD_ERROR = 2;
            public static final int UNKNOWN = 0;
        }

        public static LivePKGameInfoSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePKGameInfoSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePKGameInfoSyncMessage() {
            clear();
        }

        public final LivePKGameInfoSyncMessage clear() {
            this.pkGameState = 0;
            this.pkId = "";
            this.pkGameId = "";
            this.anchorScore = "";
            this.otherAnchorScore = "";
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
            if (!this.anchorScore.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.anchorScore);
            }
            if (!this.otherAnchorScore.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.otherAnchorScore);
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
            if (!this.anchorScore.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.anchorScore);
            }
            return !this.otherAnchorScore.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.otherAnchorScore) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePKGameInfoSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                } else if (tag == 34) {
                    this.anchorScore = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.otherAnchorScore = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LivePKGameInfoSyncMessage parseFrom(byte[] bArr) {
            return (LivePKGameInfoSyncMessage) MessageNano.mergeFrom(new LivePKGameInfoSyncMessage(), bArr);
        }

        public static LivePKGameInfoSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePKGameInfoSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAnchorQosInfoSyncMessage extends MessageNano {
        private static volatile LiveAnchorQosInfoSyncMessage[] _emptyArray;
        public int atxFrDly;
        public int ktpSrtt;
        public int maxQ;
        public int pushStreamType;
        public int version;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveAnchorPushStreamType {
            public static final int CDN = 1;
            public static final int MCU = 2;
            public static final int UNKNOWN = 0;
        }

        public static LiveAnchorQosInfoSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAnchorQosInfoSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAnchorQosInfoSyncMessage() {
            clear();
        }

        public final LiveAnchorQosInfoSyncMessage clear() {
            this.version = 0;
            this.pushStreamType = 0;
            this.maxQ = 0;
            this.ktpSrtt = 0;
            this.atxFrDly = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.version;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.pushStreamType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            int i3 = this.maxQ;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.ktpSrtt;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            int i5 = this.atxFrDly;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i5);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.version;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.pushStreamType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            int i3 = this.maxQ;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.ktpSrtt;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
            }
            int i5 = this.atxFrDly;
            return i5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i5) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAnchorQosInfoSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.version = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.pushStreamType = int32;
                    }
                } else if (tag == 24) {
                    this.maxQ = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.ktpSrtt = codedInputByteBufferNano.readUInt32();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.atxFrDly = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveAnchorQosInfoSyncMessage parseFrom(byte[] bArr) {
            return (LiveAnchorQosInfoSyncMessage) MessageNano.mergeFrom(new LiveAnchorQosInfoSyncMessage(), bArr);
        }

        public static LiveAnchorQosInfoSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAnchorQosInfoSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveChatSyncMessage extends MessageNano {
        private static volatile LiveChatSyncMessage[] _emptyArray;
        public String guestId;
        public boolean isConnected;
        public int liveChatRoomId;

        public static LiveChatSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveChatSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveChatSyncMessage() {
            clear();
        }

        public final LiveChatSyncMessage clear() {
            this.guestId = "";
            this.isConnected = false;
            this.liveChatRoomId = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.guestId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.guestId);
            }
            boolean z = this.isConnected;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            int i = this.liveChatRoomId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.guestId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.guestId);
            }
            boolean z = this.isConnected;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            int i = this.liveChatRoomId;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveChatSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.guestId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.isConnected = codedInputByteBufferNano.readBool();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveChatRoomId = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveChatSyncMessage parseFrom(byte[] bArr) {
            return (LiveChatSyncMessage) MessageNano.mergeFrom(new LiveChatSyncMessage(), bArr);
        }

        public static LiveChatSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveChatSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveChatViewPostionMessage extends MessageNano {
        private static volatile LiveChatViewPostionMessage[] _emptyArray;
        public String chatGuestId;
        public float chatViewPositionHeight;
        public float chatViewPositionLeft;
        public float chatViewPositionTop;
        public float chatViewPositionWidth;

        public static LiveChatViewPostionMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveChatViewPostionMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveChatViewPostionMessage() {
            clear();
        }

        public final LiveChatViewPostionMessage clear() {
            this.chatViewPositionTop = 0.0f;
            this.chatViewPositionLeft = 0.0f;
            this.chatViewPositionWidth = 0.0f;
            this.chatViewPositionHeight = 0.0f;
            this.chatGuestId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (Float.floatToIntBits(this.chatViewPositionTop) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(1, this.chatViewPositionTop);
            }
            if (Float.floatToIntBits(this.chatViewPositionLeft) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(2, this.chatViewPositionLeft);
            }
            if (Float.floatToIntBits(this.chatViewPositionWidth) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(3, this.chatViewPositionWidth);
            }
            if (Float.floatToIntBits(this.chatViewPositionHeight) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(4, this.chatViewPositionHeight);
            }
            if (!this.chatGuestId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.chatGuestId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (Float.floatToIntBits(this.chatViewPositionTop) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.chatViewPositionTop);
            }
            if (Float.floatToIntBits(this.chatViewPositionLeft) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.chatViewPositionLeft);
            }
            if (Float.floatToIntBits(this.chatViewPositionWidth) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.chatViewPositionWidth);
            }
            if (Float.floatToIntBits(this.chatViewPositionHeight) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.chatViewPositionHeight);
            }
            return !this.chatGuestId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.chatGuestId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveChatViewPostionMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 13) {
                    this.chatViewPositionTop = codedInputByteBufferNano.readFloat();
                } else if (tag == 21) {
                    this.chatViewPositionLeft = codedInputByteBufferNano.readFloat();
                } else if (tag == 29) {
                    this.chatViewPositionWidth = codedInputByteBufferNano.readFloat();
                } else if (tag == 37) {
                    this.chatViewPositionHeight = codedInputByteBufferNano.readFloat();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.chatGuestId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveChatViewPostionMessage parseFrom(byte[] bArr) {
            return (LiveChatViewPostionMessage) MessageNano.mergeFrom(new LiveChatViewPostionMessage(), bArr);
        }

        public static LiveChatViewPostionMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveChatViewPostionMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFaceAreasMessage extends MessageNano {
        private static volatile LiveFaceAreasMessage[] _emptyArray;
        public LiveFaceArea[] faceAreasArray;

        public static final class LiveFaceArea extends MessageNano {
            private static volatile LiveFaceArea[] _emptyArray;
            public float bottom;
            public float left;
            public float right;
            public float top;

            public static LiveFaceArea[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new LiveFaceArea[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public LiveFaceArea() {
                clear();
            }

            public final LiveFaceArea clear() {
                this.left = 0.0f;
                this.top = 0.0f;
                this.bottom = 0.0f;
                this.right = 0.0f;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                if (Float.floatToIntBits(this.left) != Float.floatToIntBits(0.0f)) {
                    codedOutputByteBufferNano.writeFloat(1, this.left);
                }
                if (Float.floatToIntBits(this.top) != Float.floatToIntBits(0.0f)) {
                    codedOutputByteBufferNano.writeFloat(2, this.top);
                }
                if (Float.floatToIntBits(this.bottom) != Float.floatToIntBits(0.0f)) {
                    codedOutputByteBufferNano.writeFloat(3, this.bottom);
                }
                if (Float.floatToIntBits(this.right) != Float.floatToIntBits(0.0f)) {
                    codedOutputByteBufferNano.writeFloat(4, this.right);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                if (Float.floatToIntBits(this.left) != Float.floatToIntBits(0.0f)) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.left);
                }
                if (Float.floatToIntBits(this.top) != Float.floatToIntBits(0.0f)) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.top);
                }
                if (Float.floatToIntBits(this.bottom) != Float.floatToIntBits(0.0f)) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.bottom);
                }
                return Float.floatToIntBits(this.right) != Float.floatToIntBits(0.0f) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.right) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final LiveFaceArea mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 13) {
                        this.left = codedInputByteBufferNano.readFloat();
                    } else if (tag == 21) {
                        this.top = codedInputByteBufferNano.readFloat();
                    } else if (tag == 29) {
                        this.bottom = codedInputByteBufferNano.readFloat();
                    } else if (tag != 37) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.right = codedInputByteBufferNano.readFloat();
                    }
                }
            }

            public static LiveFaceArea parseFrom(byte[] bArr) {
                return (LiveFaceArea) MessageNano.mergeFrom(new LiveFaceArea(), bArr);
            }

            public static LiveFaceArea parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new LiveFaceArea().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static LiveFaceAreasMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFaceAreasMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFaceAreasMessage() {
            clear();
        }

        public final LiveFaceAreasMessage clear() {
            this.faceAreasArray = LiveFaceArea.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveFaceArea[] liveFaceAreaArr = this.faceAreasArray;
            if (liveFaceAreaArr != null && liveFaceAreaArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveFaceArea[] liveFaceAreaArr2 = this.faceAreasArray;
                    if (i >= liveFaceAreaArr2.length) {
                        break;
                    }
                    LiveFaceArea liveFaceArea = liveFaceAreaArr2[i];
                    if (liveFaceArea != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveFaceArea);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveFaceArea[] liveFaceAreaArr = this.faceAreasArray;
            if (liveFaceAreaArr != null && liveFaceAreaArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveFaceArea[] liveFaceAreaArr2 = this.faceAreasArray;
                    if (i >= liveFaceAreaArr2.length) {
                        break;
                    }
                    LiveFaceArea liveFaceArea = liveFaceAreaArr2[i];
                    if (liveFaceArea != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveFaceArea);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFaceAreasMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveFaceArea[] liveFaceAreaArr = this.faceAreasArray;
                    int length = liveFaceAreaArr == null ? 0 : liveFaceAreaArr.length;
                    LiveFaceArea[] liveFaceAreaArr2 = new LiveFaceArea[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.faceAreasArray, 0, liveFaceAreaArr2, 0, length);
                    }
                    while (length < liveFaceAreaArr2.length - 1) {
                        liveFaceAreaArr2[length] = new LiveFaceArea();
                        codedInputByteBufferNano.readMessage(liveFaceAreaArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveFaceAreaArr2[length] = new LiveFaceArea();
                    codedInputByteBufferNano.readMessage(liveFaceAreaArr2[length]);
                    this.faceAreasArray = liveFaceAreaArr2;
                }
            }
        }

        public static LiveFaceAreasMessage parseFrom(byte[] bArr) {
            return (LiveFaceAreasMessage) MessageNano.mergeFrom(new LiveFaceAreasMessage(), bArr);
        }

        public static LiveFaceAreasMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFaceAreasMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveLineChatMessage extends MessageNano {
        private static volatile LiveLineChatMessage[] _emptyArray;
        public String lineChatId;

        public static LiveLineChatMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveLineChatMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveLineChatMessage() {
            clear();
        }

        public final LiveLineChatMessage clear() {
            this.lineChatId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.lineChatId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.lineChatId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.lineChatId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.lineChatId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveLineChatMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.lineChatId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveLineChatMessage parseFrom(byte[] bArr) {
            return (LiveLineChatMessage) MessageNano.mergeFrom(new LiveLineChatMessage(), bArr);
        }

        public static LiveLineChatMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveLineChatMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActiveSpeakersMessage extends MessageNano {
        private static volatile LiveActiveSpeakersMessage[] _emptyArray;
        public String[] activeSpeakers;

        public static LiveActiveSpeakersMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActiveSpeakersMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActiveSpeakersMessage() {
            clear();
        }

        public final LiveActiveSpeakersMessage clear() {
            this.activeSpeakers = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            String[] strArr = this.activeSpeakers;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.activeSpeakers;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(1, str);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String[] strArr = this.activeSpeakers;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeStringSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.activeSpeakers;
                if (i >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActiveSpeakersMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    String[] strArr = this.activeSpeakers;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.activeSpeakers, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.activeSpeakers = strArr2;
                }
            }
        }

        public static LiveActiveSpeakersMessage parseFrom(byte[] bArr) {
            return (LiveActiveSpeakersMessage) MessageNano.mergeFrom(new LiveActiveSpeakersMessage(), bArr);
        }

        public static LiveActiveSpeakersMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActiveSpeakersMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFaceTransDataMessage extends MessageNano {
        private static volatile LiveFaceTransDataMessage[] _emptyArray;
        public LiveFacePoint[] facePointArray;
        public LiveFacePoint[] facePointArrayMulti;
        public boolean isMirror;

        public static final class LiveFacePoint extends MessageNano {
            private static volatile LiveFacePoint[] _emptyArray;
            public int index;
            public float x;
            public float y;

            public static LiveFacePoint[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new LiveFacePoint[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public LiveFacePoint() {
                clear();
            }

            public final LiveFacePoint clear() {
                this.index = 0;
                this.x = 0.0f;
                this.y = 0.0f;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                int i = this.index;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(1, i);
                }
                if (Float.floatToIntBits(this.x) != Float.floatToIntBits(0.0f)) {
                    codedOutputByteBufferNano.writeFloat(2, this.x);
                }
                if (Float.floatToIntBits(this.y) != Float.floatToIntBits(0.0f)) {
                    codedOutputByteBufferNano.writeFloat(3, this.y);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int i = this.index;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
                }
                if (Float.floatToIntBits(this.x) != Float.floatToIntBits(0.0f)) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.x);
                }
                return Float.floatToIntBits(this.y) != Float.floatToIntBits(0.0f) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, this.y) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final LiveFacePoint mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.index = codedInputByteBufferNano.readUInt32();
                    } else if (tag == 21) {
                        this.x = codedInputByteBufferNano.readFloat();
                    } else if (tag != 29) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.y = codedInputByteBufferNano.readFloat();
                    }
                }
            }

            public static LiveFacePoint parseFrom(byte[] bArr) {
                return (LiveFacePoint) MessageNano.mergeFrom(new LiveFacePoint(), bArr);
            }

            public static LiveFacePoint parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new LiveFacePoint().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static LiveFaceTransDataMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFaceTransDataMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFaceTransDataMessage() {
            clear();
        }

        public final LiveFaceTransDataMessage clear() {
            this.facePointArray = LiveFacePoint.emptyArray();
            this.isMirror = false;
            this.facePointArrayMulti = LiveFacePoint.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveFacePoint[] liveFacePointArr = this.facePointArray;
            int i = 0;
            if (liveFacePointArr != null && liveFacePointArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveFacePoint[] liveFacePointArr2 = this.facePointArray;
                    if (i2 >= liveFacePointArr2.length) {
                        break;
                    }
                    LiveFacePoint liveFacePoint = liveFacePointArr2[i2];
                    if (liveFacePoint != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveFacePoint);
                    }
                    i2++;
                }
            }
            boolean z = this.isMirror;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            LiveFacePoint[] liveFacePointArr3 = this.facePointArrayMulti;
            if (liveFacePointArr3 != null && liveFacePointArr3.length > 0) {
                while (true) {
                    LiveFacePoint[] liveFacePointArr4 = this.facePointArrayMulti;
                    if (i >= liveFacePointArr4.length) {
                        break;
                    }
                    LiveFacePoint liveFacePoint2 = liveFacePointArr4[i];
                    if (liveFacePoint2 != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveFacePoint2);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveFacePoint[] liveFacePointArr = this.facePointArray;
            int i = 0;
            if (liveFacePointArr != null && liveFacePointArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    LiveFacePoint[] liveFacePointArr2 = this.facePointArray;
                    if (i2 >= liveFacePointArr2.length) {
                        break;
                    }
                    LiveFacePoint liveFacePoint = liveFacePointArr2[i2];
                    if (liveFacePoint != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, liveFacePoint);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            boolean z = this.isMirror;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            LiveFacePoint[] liveFacePointArr3 = this.facePointArrayMulti;
            if (liveFacePointArr3 != null && liveFacePointArr3.length > 0) {
                while (true) {
                    LiveFacePoint[] liveFacePointArr4 = this.facePointArrayMulti;
                    if (i >= liveFacePointArr4.length) {
                        break;
                    }
                    LiveFacePoint liveFacePoint2 = liveFacePointArr4[i];
                    if (liveFacePoint2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveFacePoint2);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFaceTransDataMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveFacePoint[] liveFacePointArr = this.facePointArray;
                    int length = liveFacePointArr == null ? 0 : liveFacePointArr.length;
                    LiveFacePoint[] liveFacePointArr2 = new LiveFacePoint[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.facePointArray, 0, liveFacePointArr2, 0, length);
                    }
                    while (length < liveFacePointArr2.length - 1) {
                        liveFacePointArr2[length] = new LiveFacePoint();
                        codedInputByteBufferNano.readMessage(liveFacePointArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveFacePointArr2[length] = new LiveFacePoint();
                    codedInputByteBufferNano.readMessage(liveFacePointArr2[length]);
                    this.facePointArray = liveFacePointArr2;
                } else if (tag == 16) {
                    this.isMirror = codedInputByteBufferNano.readBool();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveFacePoint[] liveFacePointArr3 = this.facePointArrayMulti;
                    int length2 = liveFacePointArr3 == null ? 0 : liveFacePointArr3.length;
                    LiveFacePoint[] liveFacePointArr4 = new LiveFacePoint[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.facePointArrayMulti, 0, liveFacePointArr4, 0, length2);
                    }
                    while (length2 < liveFacePointArr4.length - 1) {
                        liveFacePointArr4[length2] = new LiveFacePoint();
                        codedInputByteBufferNano.readMessage(liveFacePointArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    liveFacePointArr4[length2] = new LiveFacePoint();
                    codedInputByteBufferNano.readMessage(liveFacePointArr4[length2]);
                    this.facePointArrayMulti = liveFacePointArr4;
                }
            }
        }

        public static LiveFaceTransDataMessage parseFrom(byte[] bArr) {
            return (LiveFaceTransDataMessage) MessageNano.mergeFrom(new LiveFaceTransDataMessage(), bArr);
        }

        public static LiveFaceTransDataMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFaceTransDataMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCameraFaceDataMessage extends MessageNano {
        private static volatile LiveCameraFaceDataMessage[] _emptyArray;
        public float facePositionBottom;
        public float facePositionLeft;
        public float facePositionRight;
        public float facePositionTop;
        public float faceScore;
        public boolean showFace;
        public int type;

        public static LiveCameraFaceDataMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCameraFaceDataMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCameraFaceDataMessage() {
            clear();
        }

        public final LiveCameraFaceDataMessage clear() {
            this.showFace = false;
            this.faceScore = 0.0f;
            this.facePositionLeft = 0.0f;
            this.facePositionTop = 0.0f;
            this.facePositionBottom = 0.0f;
            this.facePositionRight = 0.0f;
            this.type = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.showFace;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            if (Float.floatToIntBits(this.faceScore) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(2, this.faceScore);
            }
            if (Float.floatToIntBits(this.facePositionLeft) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(3, this.facePositionLeft);
            }
            if (Float.floatToIntBits(this.facePositionTop) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(4, this.facePositionTop);
            }
            if (Float.floatToIntBits(this.facePositionBottom) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(5, this.facePositionBottom);
            }
            if (Float.floatToIntBits(this.facePositionRight) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(6, this.facePositionRight);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.showFace;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            if (Float.floatToIntBits(this.faceScore) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.faceScore);
            }
            if (Float.floatToIntBits(this.facePositionLeft) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.facePositionLeft);
            }
            if (Float.floatToIntBits(this.facePositionTop) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.facePositionTop);
            }
            if (Float.floatToIntBits(this.facePositionBottom) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.facePositionBottom);
            }
            if (Float.floatToIntBits(this.facePositionRight) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, this.facePositionRight);
            }
            int i = this.type;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCameraFaceDataMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.showFace = codedInputByteBufferNano.readBool();
                } else if (tag == 21) {
                    this.faceScore = codedInputByteBufferNano.readFloat();
                } else if (tag == 29) {
                    this.facePositionLeft = codedInputByteBufferNano.readFloat();
                } else if (tag == 37) {
                    this.facePositionTop = codedInputByteBufferNano.readFloat();
                } else if (tag == 45) {
                    this.facePositionBottom = codedInputByteBufferNano.readFloat();
                } else if (tag == 53) {
                    this.facePositionRight = codedInputByteBufferNano.readFloat();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.type = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveCameraFaceDataMessage parseFrom(byte[] bArr) {
            return (LiveCameraFaceDataMessage) MessageNano.mergeFrom(new LiveCameraFaceDataMessage(), bArr);
        }

        public static LiveCameraFaceDataMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCameraFaceDataMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveVoicePartyVideoLayoutMessage extends MessageNano {
        private static volatile LiveVoicePartyVideoLayoutMessage[] _emptyArray;
        public float dividerInVideoWidthPercent;
        public float guestFrameAspectRatio;
        public float liveVideoAspectRatio;
        public LiveChatViewPostionMessage[] videoViewPosition;

        public static LiveVoicePartyVideoLayoutMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveVoicePartyVideoLayoutMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveVoicePartyVideoLayoutMessage() {
            clear();
        }

        public final LiveVoicePartyVideoLayoutMessage clear() {
            this.liveVideoAspectRatio = 0.0f;
            this.guestFrameAspectRatio = 0.0f;
            this.dividerInVideoWidthPercent = 0.0f;
            this.videoViewPosition = LiveChatViewPostionMessage.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (Float.floatToIntBits(this.liveVideoAspectRatio) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(1, this.liveVideoAspectRatio);
            }
            if (Float.floatToIntBits(this.guestFrameAspectRatio) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(2, this.guestFrameAspectRatio);
            }
            if (Float.floatToIntBits(this.dividerInVideoWidthPercent) != Float.floatToIntBits(0.0f)) {
                codedOutputByteBufferNano.writeFloat(3, this.dividerInVideoWidthPercent);
            }
            LiveChatViewPostionMessage[] liveChatViewPostionMessageArr = this.videoViewPosition;
            if (liveChatViewPostionMessageArr != null && liveChatViewPostionMessageArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveChatViewPostionMessage[] liveChatViewPostionMessageArr2 = this.videoViewPosition;
                    if (i >= liveChatViewPostionMessageArr2.length) {
                        break;
                    }
                    LiveChatViewPostionMessage liveChatViewPostionMessage = liveChatViewPostionMessageArr2[i];
                    if (liveChatViewPostionMessage != null) {
                        codedOutputByteBufferNano.writeMessage(4, liveChatViewPostionMessage);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (Float.floatToIntBits(this.liveVideoAspectRatio) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.liveVideoAspectRatio);
            }
            if (Float.floatToIntBits(this.guestFrameAspectRatio) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.guestFrameAspectRatio);
            }
            if (Float.floatToIntBits(this.dividerInVideoWidthPercent) != Float.floatToIntBits(0.0f)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.dividerInVideoWidthPercent);
            }
            LiveChatViewPostionMessage[] liveChatViewPostionMessageArr = this.videoViewPosition;
            if (liveChatViewPostionMessageArr != null && liveChatViewPostionMessageArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveChatViewPostionMessage[] liveChatViewPostionMessageArr2 = this.videoViewPosition;
                    if (i >= liveChatViewPostionMessageArr2.length) {
                        break;
                    }
                    LiveChatViewPostionMessage liveChatViewPostionMessage = liveChatViewPostionMessageArr2[i];
                    if (liveChatViewPostionMessage != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveChatViewPostionMessage);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveVoicePartyVideoLayoutMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 13) {
                    this.liveVideoAspectRatio = codedInputByteBufferNano.readFloat();
                } else if (tag == 21) {
                    this.guestFrameAspectRatio = codedInputByteBufferNano.readFloat();
                } else if (tag == 29) {
                    this.dividerInVideoWidthPercent = codedInputByteBufferNano.readFloat();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    LiveChatViewPostionMessage[] liveChatViewPostionMessageArr = this.videoViewPosition;
                    int length = liveChatViewPostionMessageArr == null ? 0 : liveChatViewPostionMessageArr.length;
                    LiveChatViewPostionMessage[] liveChatViewPostionMessageArr2 = new LiveChatViewPostionMessage[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.videoViewPosition, 0, liveChatViewPostionMessageArr2, 0, length);
                    }
                    while (length < liveChatViewPostionMessageArr2.length - 1) {
                        liveChatViewPostionMessageArr2[length] = new LiveChatViewPostionMessage();
                        codedInputByteBufferNano.readMessage(liveChatViewPostionMessageArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveChatViewPostionMessageArr2[length] = new LiveChatViewPostionMessage();
                    codedInputByteBufferNano.readMessage(liveChatViewPostionMessageArr2[length]);
                    this.videoViewPosition = liveChatViewPostionMessageArr2;
                }
            }
        }

        public static LiveVoicePartyVideoLayoutMessage parseFrom(byte[] bArr) {
            return (LiveVoicePartyVideoLayoutMessage) MessageNano.mergeFrom(new LiveVoicePartyVideoLayoutMessage(), bArr);
        }

        public static LiveVoicePartyVideoLayoutMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveVoicePartyVideoLayoutMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveMerchantWakeupMessage extends MessageNano {
        private static volatile LiveMerchantWakeupMessage[] _emptyArray;
        public boolean isTrueWakeup;
        public String liveStreamId;
        public String sessionId;

        public static LiveMerchantWakeupMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveMerchantWakeupMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveMerchantWakeupMessage() {
            clear();
        }

        public final LiveMerchantWakeupMessage clear() {
            this.liveStreamId = "";
            this.sessionId = "";
            this.isTrueWakeup = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.sessionId);
            }
            boolean z = this.isTrueWakeup;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sessionId);
            }
            boolean z = this.isTrueWakeup;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveMerchantWakeupMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.sessionId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.isTrueWakeup = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveMerchantWakeupMessage parseFrom(byte[] bArr) {
            return (LiveMerchantWakeupMessage) MessageNano.mergeFrom(new LiveMerchantWakeupMessage(), bArr);
        }

        public static LiveMerchantWakeupMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveMerchantWakeupMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCentaurLayoutConfigMessage extends MessageNano {
        private static volatile LiveCentaurLayoutConfigMessage[] _emptyArray;
        public int bizType;
        public InteractiveChatCanvasSize canvasSize;
        public boolean hasSeiMessage;
        public UserInfo[] userInfo;
        public InteractiveChatWindow[] windowInfo;

        public static final class UserInfo extends MessageNano {
            private static volatile UserInfo[] _emptyArray;
            public int mediaType;
            public long userId;

            public static UserInfo[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new UserInfo[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public UserInfo() {
                clear();
            }

            public final UserInfo clear() {
                this.userId = 0L;
                this.mediaType = 0;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                long j = this.userId;
                if (j != 0) {
                    codedOutputByteBufferNano.writeUInt64(1, j);
                }
                int i = this.mediaType;
                if (i != 0) {
                    codedOutputByteBufferNano.writeInt32(2, i);
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
                int i = this.mediaType;
                return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final UserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.userId = codedInputByteBufferNano.readUInt64();
                    } else if (tag != 16) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 0 || int32 == 1 || int32 == 2) {
                            this.mediaType = int32;
                        }
                    }
                }
            }

            public static UserInfo parseFrom(byte[] bArr) {
                return (UserInfo) MessageNano.mergeFrom(new UserInfo(), bArr);
            }

            public static UserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new UserInfo().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static LiveCentaurLayoutConfigMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCentaurLayoutConfigMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCentaurLayoutConfigMessage() {
            clear();
        }

        public final LiveCentaurLayoutConfigMessage clear() {
            this.bizType = 0;
            this.canvasSize = null;
            this.windowInfo = InteractiveChatWindow.emptyArray();
            this.userInfo = UserInfo.emptyArray();
            this.hasSeiMessage = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            InteractiveChatCanvasSize interactiveChatCanvasSize = this.canvasSize;
            if (interactiveChatCanvasSize != null) {
                codedOutputByteBufferNano.writeMessage(2, interactiveChatCanvasSize);
            }
            InteractiveChatWindow[] interactiveChatWindowArr = this.windowInfo;
            int i2 = 0;
            if (interactiveChatWindowArr != null && interactiveChatWindowArr.length > 0) {
                int i3 = 0;
                while (true) {
                    InteractiveChatWindow[] interactiveChatWindowArr2 = this.windowInfo;
                    if (i3 >= interactiveChatWindowArr2.length) {
                        break;
                    }
                    InteractiveChatWindow interactiveChatWindow = interactiveChatWindowArr2[i3];
                    if (interactiveChatWindow != null) {
                        codedOutputByteBufferNano.writeMessage(3, interactiveChatWindow);
                    }
                    i3++;
                }
            }
            UserInfo[] userInfoArr = this.userInfo;
            if (userInfoArr != null && userInfoArr.length > 0) {
                while (true) {
                    UserInfo[] userInfoArr2 = this.userInfo;
                    if (i2 >= userInfoArr2.length) {
                        break;
                    }
                    UserInfo userInfo = userInfoArr2[i2];
                    if (userInfo != null) {
                        codedOutputByteBufferNano.writeMessage(4, userInfo);
                    }
                    i2++;
                }
            }
            boolean z = this.hasSeiMessage;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            InteractiveChatCanvasSize interactiveChatCanvasSize = this.canvasSize;
            if (interactiveChatCanvasSize != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatCanvasSize);
            }
            InteractiveChatWindow[] interactiveChatWindowArr = this.windowInfo;
            int i2 = 0;
            if (interactiveChatWindowArr != null && interactiveChatWindowArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    InteractiveChatWindow[] interactiveChatWindowArr2 = this.windowInfo;
                    if (i3 >= interactiveChatWindowArr2.length) {
                        break;
                    }
                    InteractiveChatWindow interactiveChatWindow = interactiveChatWindowArr2[i3];
                    if (interactiveChatWindow != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, interactiveChatWindow);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfo[] userInfoArr = this.userInfo;
            if (userInfoArr != null && userInfoArr.length > 0) {
                while (true) {
                    UserInfo[] userInfoArr2 = this.userInfo;
                    if (i2 >= userInfoArr2.length) {
                        break;
                    }
                    UserInfo userInfo = userInfoArr2[i2];
                    if (userInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
                    }
                    i2++;
                }
            }
            boolean z = this.hasSeiMessage;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCentaurLayoutConfigMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                        case 16:
                            this.bizType = int32;
                            break;
                    }
                } else if (tag == 18) {
                    if (this.canvasSize == null) {
                        this.canvasSize = new InteractiveChatCanvasSize();
                    }
                    codedInputByteBufferNano.readMessage(this.canvasSize);
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    InteractiveChatWindow[] interactiveChatWindowArr = this.windowInfo;
                    int length = interactiveChatWindowArr == null ? 0 : interactiveChatWindowArr.length;
                    InteractiveChatWindow[] interactiveChatWindowArr2 = new InteractiveChatWindow[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.windowInfo, 0, interactiveChatWindowArr2, 0, length);
                    }
                    while (length < interactiveChatWindowArr2.length - 1) {
                        interactiveChatWindowArr2[length] = new InteractiveChatWindow();
                        codedInputByteBufferNano.readMessage(interactiveChatWindowArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    interactiveChatWindowArr2[length] = new InteractiveChatWindow();
                    codedInputByteBufferNano.readMessage(interactiveChatWindowArr2[length]);
                    this.windowInfo = interactiveChatWindowArr2;
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfo[] userInfoArr = this.userInfo;
                    int length2 = userInfoArr == null ? 0 : userInfoArr.length;
                    UserInfo[] userInfoArr2 = new UserInfo[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.userInfo, 0, userInfoArr2, 0, length2);
                    }
                    while (length2 < userInfoArr2.length - 1) {
                        userInfoArr2[length2] = new UserInfo();
                        codedInputByteBufferNano.readMessage(userInfoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    userInfoArr2[length2] = new UserInfo();
                    codedInputByteBufferNano.readMessage(userInfoArr2[length2]);
                    this.userInfo = userInfoArr2;
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.hasSeiMessage = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveCentaurLayoutConfigMessage parseFrom(byte[] bArr) {
            return (LiveCentaurLayoutConfigMessage) MessageNano.mergeFrom(new LiveCentaurLayoutConfigMessage(), bArr);
        }

        public static LiveCentaurLayoutConfigMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCentaurLayoutConfigMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveStageLayoutConfigChecksum extends MessageNano {
        private static volatile LiveStageLayoutConfigChecksum[] _emptyArray;
        public long checksum;
        public int version;

        public static LiveStageLayoutConfigChecksum[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveStageLayoutConfigChecksum[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveStageLayoutConfigChecksum() {
            clear();
        }

        public final LiveStageLayoutConfigChecksum clear() {
            this.version = 0;
            this.checksum = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.version;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.checksum;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.version;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.checksum;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveStageLayoutConfigChecksum mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.version = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.checksum = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveStageLayoutConfigChecksum parseFrom(byte[] bArr) {
            return (LiveStageLayoutConfigChecksum) MessageNano.mergeFrom(new LiveStageLayoutConfigChecksum(), bArr);
        }

        public static LiveStageLayoutConfigChecksum parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveStageLayoutConfigChecksum().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveStageLayoutConfigHashMessage extends MessageNano {
        private static volatile LiveStageLayoutConfigHashMessage[] _emptyArray;
        public int bizType;
        public long layoutConfigHash;

        public static LiveStageLayoutConfigHashMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveStageLayoutConfigHashMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveStageLayoutConfigHashMessage() {
            clear();
        }

        public final LiveStageLayoutConfigHashMessage clear() {
            this.bizType = 0;
            this.layoutConfigHash = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.layoutConfigHash;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.layoutConfigHash;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveStageLayoutConfigHashMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                        case 16:
                            this.bizType = int32;
                            break;
                    }
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.layoutConfigHash = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveStageLayoutConfigHashMessage parseFrom(byte[] bArr) {
            return (LiveStageLayoutConfigHashMessage) MessageNano.mergeFrom(new LiveStageLayoutConfigHashMessage(), bArr);
        }

        public static LiveStageLayoutConfigHashMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveStageLayoutConfigHashMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShadeAuditMessage extends MessageNano {
        private static volatile LiveShadeAuditMessage[] _emptyArray;
        public String detail;
        public boolean enableShade;
        public LiveCdnNodeView[] iconCdnNodeView;
        public String title;

        public static LiveShadeAuditMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShadeAuditMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShadeAuditMessage() {
            clear();
        }

        public final LiveShadeAuditMessage clear() {
            this.enableShade = false;
            this.title = "";
            this.detail = "";
            this.iconCdnNodeView = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.enableShade;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.detail.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.detail);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(4, liveCdnNodeView);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.enableShade;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.detail.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.detail);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveCdnNodeView);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShadeAuditMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.enableShade = codedInputByteBufferNano.readBool();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.detail = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.iconCdnNodeView = liveCdnNodeViewArr2;
                }
            }
        }

        public static LiveShadeAuditMessage parseFrom(byte[] bArr) {
            return (LiveShadeAuditMessage) MessageNano.mergeFrom(new LiveShadeAuditMessage(), bArr);
        }

        public static LiveShadeAuditMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShadeAuditMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShadeBackstageMessage extends MessageNano {
        private static volatile LiveShadeBackstageMessage[] _emptyArray;
        public boolean enableShade;

        public static LiveShadeBackstageMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShadeBackstageMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShadeBackstageMessage() {
            clear();
        }

        public final LiveShadeBackstageMessage clear() {
            this.enableShade = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.enableShade;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.enableShade;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShadeBackstageMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enableShade = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveShadeBackstageMessage parseFrom(byte[] bArr) {
            return (LiveShadeBackstageMessage) MessageNano.mergeFrom(new LiveShadeBackstageMessage(), bArr);
        }

        public static LiveShadeBackstageMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShadeBackstageMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz3SyncMessage extends MessageNano {
        private static volatile LiveQuiz3SyncMessage[] _emptyArray;
        public long activityId;
        public long loadQuestionMaxDelayTimeMs;
        public int loadQuestionRetryTimes;
        public int questionIndex;
        public int quizStatus;

        public static LiveQuiz3SyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz3SyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz3SyncMessage() {
            clear();
        }

        public final LiveQuiz3SyncMessage clear() {
            this.quizStatus = 0;
            this.activityId = 0L;
            this.questionIndex = 0;
            this.loadQuestionMaxDelayTimeMs = 0L;
            this.loadQuestionRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.quizStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.activityId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i2 = this.questionIndex;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            long j2 = this.loadQuestionMaxDelayTimeMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            int i3 = this.loadQuestionRetryTimes;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.quizStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.activityId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i2 = this.questionIndex;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            long j2 = this.loadQuestionMaxDelayTimeMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            int i3 = this.loadQuestionRetryTimes;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz3SyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                            this.quizStatus = int32;
                            break;
                    }
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.questionIndex = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.loadQuestionMaxDelayTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.loadQuestionRetryTimes = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveQuiz3SyncMessage parseFrom(byte[] bArr) {
            return (LiveQuiz3SyncMessage) MessageNano.mergeFrom(new LiveQuiz3SyncMessage(), bArr);
        }

        public static LiveQuiz3SyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz3SyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuiz3PublishRoundWinnerMessage extends MessageNano {
        private static volatile LiveQuiz3PublishRoundWinnerMessage[] _emptyArray;
        public long activityId;
        public long queryAfterWinnerReleasedDelayTime;
        public int queryAfterWinnerReleasedRetryTimes;
        public long roundId;

        public static LiveQuiz3PublishRoundWinnerMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuiz3PublishRoundWinnerMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuiz3PublishRoundWinnerMessage() {
            clear();
        }

        public final LiveQuiz3PublishRoundWinnerMessage clear() {
            this.activityId = 0L;
            this.roundId = 0L;
            this.queryAfterWinnerReleasedDelayTime = 0L;
            this.queryAfterWinnerReleasedRetryTimes = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.activityId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.roundId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.queryAfterWinnerReleasedDelayTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            int i = this.queryAfterWinnerReleasedRetryTimes;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.activityId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.roundId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.queryAfterWinnerReleasedDelayTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            int i = this.queryAfterWinnerReleasedRetryTimes;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuiz3PublishRoundWinnerMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.roundId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.queryAfterWinnerReleasedDelayTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.queryAfterWinnerReleasedRetryTimes = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveQuiz3PublishRoundWinnerMessage parseFrom(byte[] bArr) {
            return (LiveQuiz3PublishRoundWinnerMessage) MessageNano.mergeFrom(new LiveQuiz3PublishRoundWinnerMessage(), bArr);
        }

        public static LiveQuiz3PublishRoundWinnerMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuiz3PublishRoundWinnerMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRedBlueBattleStateSyncMessage extends MessageNano {
        private static volatile LiveRedBlueBattleStateSyncMessage[] _emptyArray;
        public int maxRetryCount;
        public long requestIntervalMillis;
        public int stateType;
        public long version;

        public static LiveRedBlueBattleStateSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRedBlueBattleStateSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRedBlueBattleStateSyncMessage() {
            clear();
        }

        public final LiveRedBlueBattleStateSyncMessage clear() {
            this.stateType = 0;
            this.version = 0L;
            this.requestIntervalMillis = 0L;
            this.maxRetryCount = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.stateType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.requestIntervalMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i2 = this.maxRetryCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.stateType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.version;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.requestIntervalMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i2 = this.maxRetryCount;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRedBlueBattleStateSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.stateType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.version = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.requestIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxRetryCount = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveRedBlueBattleStateSyncMessage parseFrom(byte[] bArr) {
            return (LiveRedBlueBattleStateSyncMessage) MessageNano.mergeFrom(new LiveRedBlueBattleStateSyncMessage(), bArr);
        }

        public static LiveRedBlueBattleStateSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRedBlueBattleStateSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRedBlueBattleLeeShowSyncMessage extends MessageNano {
        private static volatile LiveRedBlueBattleLeeShowSyncMessage[] _emptyArray;
        public String battleId;
        public String defaultKwaiUrl;
        public long executeDeadlineTimestamp;
        public long maxRequestIntervalMillis;
        public int maxRetryCount;
        public long minRequestIntervalMillis;
        public long requestIntervalMillis;
        public String sfLeeId;

        public static LiveRedBlueBattleLeeShowSyncMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRedBlueBattleLeeShowSyncMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRedBlueBattleLeeShowSyncMessage() {
            clear();
        }

        public final LiveRedBlueBattleLeeShowSyncMessage clear() {
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
        public final LiveRedBlueBattleLeeShowSyncMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

        public static LiveRedBlueBattleLeeShowSyncMessage parseFrom(byte[] bArr) {
            return (LiveRedBlueBattleLeeShowSyncMessage) MessageNano.mergeFrom(new LiveRedBlueBattleLeeShowSyncMessage(), bArr);
        }

        public static LiveRedBlueBattleLeeShowSyncMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRedBlueBattleLeeShowSyncMessage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
