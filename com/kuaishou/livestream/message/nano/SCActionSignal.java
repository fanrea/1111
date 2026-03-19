package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveActivitySignalMessage;
import com.kuaishou.livestream.message.nano.LiveAuthorReinforceInfoProto;
import com.kuaishou.livestream.message.nano.LiveCommonNoticeMessages;
import com.kuaishou.livestream.message.nano.LiveExtraMessages;
import com.kuaishou.livestream.message.nano.LiveShopMessages;
import com.kuaishou.livestream.message.nano.LiveStreamRichTextFeed;
import com.kuaishou.merchant.message.nano.CommodityCardMessage;
import com.kuaishou.merchant.message.nano.LiveRoomSignalMessage;
import com.kuaishou.protobuf.livestream.nano.LiveGuardNotice;
import com.kuaishou.protobuf.livestream.nano.LiveGuideFollowAuthorCardInfo;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCActionSignal extends MessageNano {
    private static volatile SCActionSignal[] _emptyArray;
    public LiveActivitySignalMessage.LiveActivityPopUpInfo[] activityPopUpInfo;
    public LiveActivityPopup[] activityPopup;
    public LiveExtraMessages.LiveCommonActionSignal[] commerceCommonFeed;
    public CommodityCardMessage.CommodityCardChange[] commodityCardChange;
    public CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChange;
    public LiveCommonEffectInfo[] effectInfo;
    public FansGroupJoinFeed[] fansGroupJoinFeed;
    public LiveFansTopBoostFollowFeed[] fansTopBoostFollowFeed;
    public LiveFansTopOrderHelpBuyFeed[] fansTopOrderHelpBuy;
    public GzoneAuthorCommonNotice[] gzoneAuthorCommonNotice;
    public GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNotice;
    public GzoneCommentLotteryFeed[] gzoneCommentLotteryFeed;
    public GzoneCommonFeed[] gzoneCommonFeed;
    public GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNotice;
    public GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeed;
    public GzoneLiveRedDotFeed[] gzoneLiveRedDotFeed;
    public HighFrequencyActionGuide[] highFrequencyActionGuide;
    public WealthHighGradeBulletComment[] highGradeBulletComment;
    public KtvMusicOrderFeed[] ktvMusicOrderFeed;
    public LiveActivityEnterRoomTip[] liveActivityEnterRoomTip;
    public LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] liveAskOnItem;
    public LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] liveAuthorReinforceInfo;
    public LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] liveBuyingNoticeSignal;
    public LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfo;
    public LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopup;
    public LiveCommonRoute[] liveCommonRoute;
    public LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoom;
    public LiveFollowGuide[] liveFollowGuide;
    public LiveGamePopupFeed[] liveGamePopupFeed;
    public LiveGuardNotice[] liveGuardNotice;
    public LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] liveGuideFollowCardInfo;
    public LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNotice;
    public LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfo;
    public LivePetUpgradeFeed[] livePetUpgradeFeed;
    public LivePkFirstBlood[] livePkFirstBlood;
    public LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNotice;
    public LiveUserClipLightGuide[] liveUserClipLightGuide;
    public LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffect;
    public LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeed;
    public LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveAction;
    public PkBountyActivityResultInfo[] pkBountyActivityResultInfo;
    public LivePkGuideBubbleTip[] pkGuideBubbleTip;
    public RainbowCommentFeed[] rainbowCommentFeed;
    public LiveRedPackGrabInfo[] redPackGrabInfo;
    public LiveRedPackSendInfo[] redPackSendInfo;
    public LiveStreamRichTextFeed.RichTextFeed[] richTextFeed;
    public SendGiftNotifyAnimation[] sendGiftNotifyAnimation;
    public LiveShopMessages.LiveShopAction[] shopAction;
    public LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] shopLiveActivityPendant;
    public LiveRoomSignalMessage.SCKwaishopLivePendant[] shopLivePendant;
    public TeamPkFightMotion[] teamPkFightMotion;
    public TestActionSignalFeed[] testFeed;
    public LiveCommonNoticeMessages.LiteTextNotice[] textNotice;
    public TopBannerNoticeFeed[] topBannerNoticeFeed;
    public TopDistrictRank[] topDistrictRank;
    public ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoom;
    public VoicePartyEmojiFeed[] voicePartyEmojiFeed;
    public LiveVoicePartyToastFeed[] voicePartyToastFeed;
    public WealthHighGradeEnterRoom[] wealthHighGradeEnterRoom;

    public static SCActionSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCActionSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCActionSignal() {
        clear();
    }

    public final SCActionSignal clear() {
        this.ktvMusicOrderFeed = KtvMusicOrderFeed.emptyArray();
        this.fansGroupJoinFeed = FansGroupJoinFeed.emptyArray();
        this.topBannerNoticeFeed = TopBannerNoticeFeed.emptyArray();
        this.voicePartyToastFeed = LiveVoicePartyToastFeed.emptyArray();
        this.livePetUpgradeFeed = LivePetUpgradeFeed.emptyArray();
        this.topDistrictRank = TopDistrictRank.emptyArray();
        this.liveFollowGuide = LiveFollowGuide.emptyArray();
        this.voicePartyEmojiFeed = VoicePartyEmojiFeed.emptyArray();
        this.shopAction = LiveShopMessages.LiveShopAction.emptyArray();
        this.liveUserClipLightGuide = LiveUserClipLightGuide.emptyArray();
        this.liveGamePopupFeed = LiveGamePopupFeed.emptyArray();
        this.rainbowCommentFeed = RainbowCommentFeed.emptyArray();
        this.commerceCommonFeed = LiveExtraMessages.LiveCommonActionSignal.emptyArray();
        this.gzoneCommentLotteryFeed = GzoneCommentLotteryFeed.emptyArray();
        this.gzoneLiveRedDotFeed = GzoneLiveRedDotFeed.emptyArray();
        this.teamPkFightMotion = TeamPkFightMotion.emptyArray();
        this.wealthHighGradeEnterRoom = WealthHighGradeEnterRoom.emptyArray();
        this.fansTopOrderHelpBuy = LiveFansTopOrderHelpBuyFeed.emptyArray();
        this.highGradeBulletComment = WealthHighGradeBulletComment.emptyArray();
        this.gzoneLiveBuffCardFeed = GzoneLiveBuffCardFeed.emptyArray();
        this.activityPopup = LiveActivityPopup.emptyArray();
        this.valentineHighScoreEnterRoom = ValentineHighScoreEnterRoom.emptyArray();
        this.livePkFirstBlood = LivePkFirstBlood.emptyArray();
        this.liveDragonBoatEnterRoom = LiveDragonBoatEnterRoom.emptyArray();
        this.redPackSendInfo = LiveRedPackSendInfo.emptyArray();
        this.redPackGrabInfo = LiveRedPackGrabInfo.emptyArray();
        this.liveActivityEnterRoomTip = LiveActivityEnterRoomTip.emptyArray();
        this.pkGuideBubbleTip = LivePkGuideBubbleTip.emptyArray();
        this.activityPopUpInfo = LiveActivitySignalMessage.LiveActivityPopUpInfo.emptyArray();
        this.fansTopBoostFollowFeed = LiveFansTopBoostFollowFeed.emptyArray();
        this.effectInfo = LiveCommonEffectInfo.emptyArray();
        this.liveGuardNotice = LiveGuardNotice.emptyArray();
        this.gzoneInteractiveCommentNotice = GzoneInteractiveCommentNotice.emptyArray();
        this.richTextFeed = LiveStreamRichTextFeed.RichTextFeed.emptyArray();
        this.gzoneAuthorTaskProgressNotice = GzoneAuthorTaskProgressNotice.emptyArray();
        this.gzoneAuthorCommonNotice = GzoneAuthorCommonNotice.emptyArray();
        this.liveHappyPlayOpenResultNotice = LiveHappyPlayOpenResultNotice.emptyArray();
        this.liveCommonRoute = LiveCommonRoute.emptyArray();
        this.liveWatchingListChangeNoticeFeed = LiveWatchingListChangeNoticeFeed.emptyArray();
        this.gzoneCommonFeed = GzoneCommonFeed.emptyArray();
        this.liveCommonPopup = LiveCommonNoticeMessages.LiveCommonPopup.emptyArray();
        this.commodityCardComponentChange = CommodityCardMessage.CommodityCardComponentChange.emptyArray();
        this.commodityCardChange = CommodityCardMessage.CommodityCardChange.emptyArray();
        this.textNotice = LiveCommonNoticeMessages.LiteTextNotice.emptyArray();
        this.shopLivePendant = LiveRoomSignalMessage.SCKwaishopLivePendant.emptyArray();
        this.marketingPushLiveAction = LiveRoomSignalMessage.MarketingPushLiveAction.emptyArray();
        this.liveRefreshAuthorStatusNotice = LiveRefreshAuthorStatusNotice.emptyArray();
        this.shopLiveActivityPendant = LiveRoomSignalMessage.SCKwaishopLiveActivityPendant.emptyArray();
        this.liveBuyingNoticeSignal = LiveRoomSignalMessage.SCLiveBuyingNoticeSignal.emptyArray();
        this.pkBountyActivityResultInfo = PkBountyActivityResultInfo.emptyArray();
        this.sendGiftNotifyAnimation = SendGiftNotifyAnimation.emptyArray();
        this.highFrequencyActionGuide = HighFrequencyActionGuide.emptyArray();
        this.liveCommonEffectRouteInfo = LiveCommonEffectRouteInfo.emptyArray();
        this.liveAskOnItem = LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal.emptyArray();
        this.liveMultiMagicEffectInfo = LiveMultiMagicEffectInfo.emptyArray();
        this.liveGuideFollowCardInfo = LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo.emptyArray();
        this.liveVoicePartyMicSeatUserLevelUpEffect = LiveVoicePartyMicSeatUserLevelUpEffects.emptyArray();
        this.liveAuthorReinforceInfo = LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo.emptyArray();
        this.testFeed = TestActionSignalFeed.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        KtvMusicOrderFeed[] ktvMusicOrderFeedArr = this.ktvMusicOrderFeed;
        int i = 0;
        if (ktvMusicOrderFeedArr != null && ktvMusicOrderFeedArr.length > 0) {
            int i2 = 0;
            while (true) {
                KtvMusicOrderFeed[] ktvMusicOrderFeedArr2 = this.ktvMusicOrderFeed;
                if (i2 >= ktvMusicOrderFeedArr2.length) {
                    break;
                }
                KtvMusicOrderFeed ktvMusicOrderFeed = ktvMusicOrderFeedArr2[i2];
                if (ktvMusicOrderFeed != null) {
                    codedOutputByteBufferNano.writeMessage(1, ktvMusicOrderFeed);
                }
                i2++;
            }
        }
        FansGroupJoinFeed[] fansGroupJoinFeedArr = this.fansGroupJoinFeed;
        if (fansGroupJoinFeedArr != null && fansGroupJoinFeedArr.length > 0) {
            int i3 = 0;
            while (true) {
                FansGroupJoinFeed[] fansGroupJoinFeedArr2 = this.fansGroupJoinFeed;
                if (i3 >= fansGroupJoinFeedArr2.length) {
                    break;
                }
                FansGroupJoinFeed fansGroupJoinFeed = fansGroupJoinFeedArr2[i3];
                if (fansGroupJoinFeed != null) {
                    codedOutputByteBufferNano.writeMessage(2, fansGroupJoinFeed);
                }
                i3++;
            }
        }
        TopBannerNoticeFeed[] topBannerNoticeFeedArr = this.topBannerNoticeFeed;
        if (topBannerNoticeFeedArr != null && topBannerNoticeFeedArr.length > 0) {
            int i4 = 0;
            while (true) {
                TopBannerNoticeFeed[] topBannerNoticeFeedArr2 = this.topBannerNoticeFeed;
                if (i4 >= topBannerNoticeFeedArr2.length) {
                    break;
                }
                TopBannerNoticeFeed topBannerNoticeFeed = topBannerNoticeFeedArr2[i4];
                if (topBannerNoticeFeed != null) {
                    codedOutputByteBufferNano.writeMessage(3, topBannerNoticeFeed);
                }
                i4++;
            }
        }
        LiveVoicePartyToastFeed[] liveVoicePartyToastFeedArr = this.voicePartyToastFeed;
        if (liveVoicePartyToastFeedArr != null && liveVoicePartyToastFeedArr.length > 0) {
            int i5 = 0;
            while (true) {
                LiveVoicePartyToastFeed[] liveVoicePartyToastFeedArr2 = this.voicePartyToastFeed;
                if (i5 >= liveVoicePartyToastFeedArr2.length) {
                    break;
                }
                LiveVoicePartyToastFeed liveVoicePartyToastFeed = liveVoicePartyToastFeedArr2[i5];
                if (liveVoicePartyToastFeed != null) {
                    codedOutputByteBufferNano.writeMessage(4, liveVoicePartyToastFeed);
                }
                i5++;
            }
        }
        LivePetUpgradeFeed[] livePetUpgradeFeedArr = this.livePetUpgradeFeed;
        if (livePetUpgradeFeedArr != null && livePetUpgradeFeedArr.length > 0) {
            int i6 = 0;
            while (true) {
                LivePetUpgradeFeed[] livePetUpgradeFeedArr2 = this.livePetUpgradeFeed;
                if (i6 >= livePetUpgradeFeedArr2.length) {
                    break;
                }
                LivePetUpgradeFeed livePetUpgradeFeed = livePetUpgradeFeedArr2[i6];
                if (livePetUpgradeFeed != null) {
                    codedOutputByteBufferNano.writeMessage(5, livePetUpgradeFeed);
                }
                i6++;
            }
        }
        TopDistrictRank[] topDistrictRankArr = this.topDistrictRank;
        if (topDistrictRankArr != null && topDistrictRankArr.length > 0) {
            int i7 = 0;
            while (true) {
                TopDistrictRank[] topDistrictRankArr2 = this.topDistrictRank;
                if (i7 >= topDistrictRankArr2.length) {
                    break;
                }
                TopDistrictRank topDistrictRank = topDistrictRankArr2[i7];
                if (topDistrictRank != null) {
                    codedOutputByteBufferNano.writeMessage(6, topDistrictRank);
                }
                i7++;
            }
        }
        LiveFollowGuide[] liveFollowGuideArr = this.liveFollowGuide;
        if (liveFollowGuideArr != null && liveFollowGuideArr.length > 0) {
            int i8 = 0;
            while (true) {
                LiveFollowGuide[] liveFollowGuideArr2 = this.liveFollowGuide;
                if (i8 >= liveFollowGuideArr2.length) {
                    break;
                }
                LiveFollowGuide liveFollowGuide = liveFollowGuideArr2[i8];
                if (liveFollowGuide != null) {
                    codedOutputByteBufferNano.writeMessage(7, liveFollowGuide);
                }
                i8++;
            }
        }
        VoicePartyEmojiFeed[] voicePartyEmojiFeedArr = this.voicePartyEmojiFeed;
        if (voicePartyEmojiFeedArr != null && voicePartyEmojiFeedArr.length > 0) {
            int i9 = 0;
            while (true) {
                VoicePartyEmojiFeed[] voicePartyEmojiFeedArr2 = this.voicePartyEmojiFeed;
                if (i9 >= voicePartyEmojiFeedArr2.length) {
                    break;
                }
                VoicePartyEmojiFeed voicePartyEmojiFeed = voicePartyEmojiFeedArr2[i9];
                if (voicePartyEmojiFeed != null) {
                    codedOutputByteBufferNano.writeMessage(8, voicePartyEmojiFeed);
                }
                i9++;
            }
        }
        LiveShopMessages.LiveShopAction[] liveShopActionArr = this.shopAction;
        if (liveShopActionArr != null && liveShopActionArr.length > 0) {
            int i10 = 0;
            while (true) {
                LiveShopMessages.LiveShopAction[] liveShopActionArr2 = this.shopAction;
                if (i10 >= liveShopActionArr2.length) {
                    break;
                }
                LiveShopMessages.LiveShopAction liveShopAction = liveShopActionArr2[i10];
                if (liveShopAction != null) {
                    codedOutputByteBufferNano.writeMessage(9, liveShopAction);
                }
                i10++;
            }
        }
        LiveUserClipLightGuide[] liveUserClipLightGuideArr = this.liveUserClipLightGuide;
        if (liveUserClipLightGuideArr != null && liveUserClipLightGuideArr.length > 0) {
            int i11 = 0;
            while (true) {
                LiveUserClipLightGuide[] liveUserClipLightGuideArr2 = this.liveUserClipLightGuide;
                if (i11 >= liveUserClipLightGuideArr2.length) {
                    break;
                }
                LiveUserClipLightGuide liveUserClipLightGuide = liveUserClipLightGuideArr2[i11];
                if (liveUserClipLightGuide != null) {
                    codedOutputByteBufferNano.writeMessage(11, liveUserClipLightGuide);
                }
                i11++;
            }
        }
        LiveGamePopupFeed[] liveGamePopupFeedArr = this.liveGamePopupFeed;
        if (liveGamePopupFeedArr != null && liveGamePopupFeedArr.length > 0) {
            int i12 = 0;
            while (true) {
                LiveGamePopupFeed[] liveGamePopupFeedArr2 = this.liveGamePopupFeed;
                if (i12 >= liveGamePopupFeedArr2.length) {
                    break;
                }
                LiveGamePopupFeed liveGamePopupFeed = liveGamePopupFeedArr2[i12];
                if (liveGamePopupFeed != null) {
                    codedOutputByteBufferNano.writeMessage(12, liveGamePopupFeed);
                }
                i12++;
            }
        }
        RainbowCommentFeed[] rainbowCommentFeedArr = this.rainbowCommentFeed;
        if (rainbowCommentFeedArr != null && rainbowCommentFeedArr.length > 0) {
            int i13 = 0;
            while (true) {
                RainbowCommentFeed[] rainbowCommentFeedArr2 = this.rainbowCommentFeed;
                if (i13 >= rainbowCommentFeedArr2.length) {
                    break;
                }
                RainbowCommentFeed rainbowCommentFeed = rainbowCommentFeedArr2[i13];
                if (rainbowCommentFeed != null) {
                    codedOutputByteBufferNano.writeMessage(13, rainbowCommentFeed);
                }
                i13++;
            }
        }
        LiveExtraMessages.LiveCommonActionSignal[] liveCommonActionSignalArr = this.commerceCommonFeed;
        if (liveCommonActionSignalArr != null && liveCommonActionSignalArr.length > 0) {
            int i14 = 0;
            while (true) {
                LiveExtraMessages.LiveCommonActionSignal[] liveCommonActionSignalArr2 = this.commerceCommonFeed;
                if (i14 >= liveCommonActionSignalArr2.length) {
                    break;
                }
                LiveExtraMessages.LiveCommonActionSignal liveCommonActionSignal = liveCommonActionSignalArr2[i14];
                if (liveCommonActionSignal != null) {
                    codedOutputByteBufferNano.writeMessage(14, liveCommonActionSignal);
                }
                i14++;
            }
        }
        GzoneCommentLotteryFeed[] gzoneCommentLotteryFeedArr = this.gzoneCommentLotteryFeed;
        if (gzoneCommentLotteryFeedArr != null && gzoneCommentLotteryFeedArr.length > 0) {
            int i15 = 0;
            while (true) {
                GzoneCommentLotteryFeed[] gzoneCommentLotteryFeedArr2 = this.gzoneCommentLotteryFeed;
                if (i15 >= gzoneCommentLotteryFeedArr2.length) {
                    break;
                }
                GzoneCommentLotteryFeed gzoneCommentLotteryFeed = gzoneCommentLotteryFeedArr2[i15];
                if (gzoneCommentLotteryFeed != null) {
                    codedOutputByteBufferNano.writeMessage(15, gzoneCommentLotteryFeed);
                }
                i15++;
            }
        }
        GzoneLiveRedDotFeed[] gzoneLiveRedDotFeedArr = this.gzoneLiveRedDotFeed;
        if (gzoneLiveRedDotFeedArr != null && gzoneLiveRedDotFeedArr.length > 0) {
            int i16 = 0;
            while (true) {
                GzoneLiveRedDotFeed[] gzoneLiveRedDotFeedArr2 = this.gzoneLiveRedDotFeed;
                if (i16 >= gzoneLiveRedDotFeedArr2.length) {
                    break;
                }
                GzoneLiveRedDotFeed gzoneLiveRedDotFeed = gzoneLiveRedDotFeedArr2[i16];
                if (gzoneLiveRedDotFeed != null) {
                    codedOutputByteBufferNano.writeMessage(16, gzoneLiveRedDotFeed);
                }
                i16++;
            }
        }
        TeamPkFightMotion[] teamPkFightMotionArr = this.teamPkFightMotion;
        if (teamPkFightMotionArr != null && teamPkFightMotionArr.length > 0) {
            int i17 = 0;
            while (true) {
                TeamPkFightMotion[] teamPkFightMotionArr2 = this.teamPkFightMotion;
                if (i17 >= teamPkFightMotionArr2.length) {
                    break;
                }
                TeamPkFightMotion teamPkFightMotion = teamPkFightMotionArr2[i17];
                if (teamPkFightMotion != null) {
                    codedOutputByteBufferNano.writeMessage(17, teamPkFightMotion);
                }
                i17++;
            }
        }
        WealthHighGradeEnterRoom[] wealthHighGradeEnterRoomArr = this.wealthHighGradeEnterRoom;
        if (wealthHighGradeEnterRoomArr != null && wealthHighGradeEnterRoomArr.length > 0) {
            int i18 = 0;
            while (true) {
                WealthHighGradeEnterRoom[] wealthHighGradeEnterRoomArr2 = this.wealthHighGradeEnterRoom;
                if (i18 >= wealthHighGradeEnterRoomArr2.length) {
                    break;
                }
                WealthHighGradeEnterRoom wealthHighGradeEnterRoom = wealthHighGradeEnterRoomArr2[i18];
                if (wealthHighGradeEnterRoom != null) {
                    codedOutputByteBufferNano.writeMessage(18, wealthHighGradeEnterRoom);
                }
                i18++;
            }
        }
        LiveFansTopOrderHelpBuyFeed[] liveFansTopOrderHelpBuyFeedArr = this.fansTopOrderHelpBuy;
        if (liveFansTopOrderHelpBuyFeedArr != null && liveFansTopOrderHelpBuyFeedArr.length > 0) {
            int i19 = 0;
            while (true) {
                LiveFansTopOrderHelpBuyFeed[] liveFansTopOrderHelpBuyFeedArr2 = this.fansTopOrderHelpBuy;
                if (i19 >= liveFansTopOrderHelpBuyFeedArr2.length) {
                    break;
                }
                LiveFansTopOrderHelpBuyFeed liveFansTopOrderHelpBuyFeed = liveFansTopOrderHelpBuyFeedArr2[i19];
                if (liveFansTopOrderHelpBuyFeed != null) {
                    codedOutputByteBufferNano.writeMessage(19, liveFansTopOrderHelpBuyFeed);
                }
                i19++;
            }
        }
        WealthHighGradeBulletComment[] wealthHighGradeBulletCommentArr = this.highGradeBulletComment;
        if (wealthHighGradeBulletCommentArr != null && wealthHighGradeBulletCommentArr.length > 0) {
            int i20 = 0;
            while (true) {
                WealthHighGradeBulletComment[] wealthHighGradeBulletCommentArr2 = this.highGradeBulletComment;
                if (i20 >= wealthHighGradeBulletCommentArr2.length) {
                    break;
                }
                WealthHighGradeBulletComment wealthHighGradeBulletComment = wealthHighGradeBulletCommentArr2[i20];
                if (wealthHighGradeBulletComment != null) {
                    codedOutputByteBufferNano.writeMessage(20, wealthHighGradeBulletComment);
                }
                i20++;
            }
        }
        GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeedArr = this.gzoneLiveBuffCardFeed;
        if (gzoneLiveBuffCardFeedArr != null && gzoneLiveBuffCardFeedArr.length > 0) {
            int i21 = 0;
            while (true) {
                GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeedArr2 = this.gzoneLiveBuffCardFeed;
                if (i21 >= gzoneLiveBuffCardFeedArr2.length) {
                    break;
                }
                GzoneLiveBuffCardFeed gzoneLiveBuffCardFeed = gzoneLiveBuffCardFeedArr2[i21];
                if (gzoneLiveBuffCardFeed != null) {
                    codedOutputByteBufferNano.writeMessage(21, gzoneLiveBuffCardFeed);
                }
                i21++;
            }
        }
        LiveActivityPopup[] liveActivityPopupArr = this.activityPopup;
        if (liveActivityPopupArr != null && liveActivityPopupArr.length > 0) {
            int i22 = 0;
            while (true) {
                LiveActivityPopup[] liveActivityPopupArr2 = this.activityPopup;
                if (i22 >= liveActivityPopupArr2.length) {
                    break;
                }
                LiveActivityPopup liveActivityPopup = liveActivityPopupArr2[i22];
                if (liveActivityPopup != null) {
                    codedOutputByteBufferNano.writeMessage(22, liveActivityPopup);
                }
                i22++;
            }
        }
        ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoomArr = this.valentineHighScoreEnterRoom;
        if (valentineHighScoreEnterRoomArr != null && valentineHighScoreEnterRoomArr.length > 0) {
            int i23 = 0;
            while (true) {
                ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoomArr2 = this.valentineHighScoreEnterRoom;
                if (i23 >= valentineHighScoreEnterRoomArr2.length) {
                    break;
                }
                ValentineHighScoreEnterRoom valentineHighScoreEnterRoom = valentineHighScoreEnterRoomArr2[i23];
                if (valentineHighScoreEnterRoom != null) {
                    codedOutputByteBufferNano.writeMessage(23, valentineHighScoreEnterRoom);
                }
                i23++;
            }
        }
        LivePkFirstBlood[] livePkFirstBloodArr = this.livePkFirstBlood;
        if (livePkFirstBloodArr != null && livePkFirstBloodArr.length > 0) {
            int i24 = 0;
            while (true) {
                LivePkFirstBlood[] livePkFirstBloodArr2 = this.livePkFirstBlood;
                if (i24 >= livePkFirstBloodArr2.length) {
                    break;
                }
                LivePkFirstBlood livePkFirstBlood = livePkFirstBloodArr2[i24];
                if (livePkFirstBlood != null) {
                    codedOutputByteBufferNano.writeMessage(24, livePkFirstBlood);
                }
                i24++;
            }
        }
        LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoomArr = this.liveDragonBoatEnterRoom;
        if (liveDragonBoatEnterRoomArr != null && liveDragonBoatEnterRoomArr.length > 0) {
            int i25 = 0;
            while (true) {
                LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoomArr2 = this.liveDragonBoatEnterRoom;
                if (i25 >= liveDragonBoatEnterRoomArr2.length) {
                    break;
                }
                LiveDragonBoatEnterRoom liveDragonBoatEnterRoom = liveDragonBoatEnterRoomArr2[i25];
                if (liveDragonBoatEnterRoom != null) {
                    codedOutputByteBufferNano.writeMessage(25, liveDragonBoatEnterRoom);
                }
                i25++;
            }
        }
        LiveRedPackSendInfo[] liveRedPackSendInfoArr = this.redPackSendInfo;
        if (liveRedPackSendInfoArr != null && liveRedPackSendInfoArr.length > 0) {
            int i26 = 0;
            while (true) {
                LiveRedPackSendInfo[] liveRedPackSendInfoArr2 = this.redPackSendInfo;
                if (i26 >= liveRedPackSendInfoArr2.length) {
                    break;
                }
                LiveRedPackSendInfo liveRedPackSendInfo = liveRedPackSendInfoArr2[i26];
                if (liveRedPackSendInfo != null) {
                    codedOutputByteBufferNano.writeMessage(26, liveRedPackSendInfo);
                }
                i26++;
            }
        }
        LiveRedPackGrabInfo[] liveRedPackGrabInfoArr = this.redPackGrabInfo;
        if (liveRedPackGrabInfoArr != null && liveRedPackGrabInfoArr.length > 0) {
            int i27 = 0;
            while (true) {
                LiveRedPackGrabInfo[] liveRedPackGrabInfoArr2 = this.redPackGrabInfo;
                if (i27 >= liveRedPackGrabInfoArr2.length) {
                    break;
                }
                LiveRedPackGrabInfo liveRedPackGrabInfo = liveRedPackGrabInfoArr2[i27];
                if (liveRedPackGrabInfo != null) {
                    codedOutputByteBufferNano.writeMessage(27, liveRedPackGrabInfo);
                }
                i27++;
            }
        }
        LiveActivityEnterRoomTip[] liveActivityEnterRoomTipArr = this.liveActivityEnterRoomTip;
        if (liveActivityEnterRoomTipArr != null && liveActivityEnterRoomTipArr.length > 0) {
            int i28 = 0;
            while (true) {
                LiveActivityEnterRoomTip[] liveActivityEnterRoomTipArr2 = this.liveActivityEnterRoomTip;
                if (i28 >= liveActivityEnterRoomTipArr2.length) {
                    break;
                }
                LiveActivityEnterRoomTip liveActivityEnterRoomTip = liveActivityEnterRoomTipArr2[i28];
                if (liveActivityEnterRoomTip != null) {
                    codedOutputByteBufferNano.writeMessage(28, liveActivityEnterRoomTip);
                }
                i28++;
            }
        }
        LivePkGuideBubbleTip[] livePkGuideBubbleTipArr = this.pkGuideBubbleTip;
        if (livePkGuideBubbleTipArr != null && livePkGuideBubbleTipArr.length > 0) {
            int i29 = 0;
            while (true) {
                LivePkGuideBubbleTip[] livePkGuideBubbleTipArr2 = this.pkGuideBubbleTip;
                if (i29 >= livePkGuideBubbleTipArr2.length) {
                    break;
                }
                LivePkGuideBubbleTip livePkGuideBubbleTip = livePkGuideBubbleTipArr2[i29];
                if (livePkGuideBubbleTip != null) {
                    codedOutputByteBufferNano.writeMessage(29, livePkGuideBubbleTip);
                }
                i29++;
            }
        }
        LiveActivitySignalMessage.LiveActivityPopUpInfo[] liveActivityPopUpInfoArr = this.activityPopUpInfo;
        if (liveActivityPopUpInfoArr != null && liveActivityPopUpInfoArr.length > 0) {
            int i30 = 0;
            while (true) {
                LiveActivitySignalMessage.LiveActivityPopUpInfo[] liveActivityPopUpInfoArr2 = this.activityPopUpInfo;
                if (i30 >= liveActivityPopUpInfoArr2.length) {
                    break;
                }
                LiveActivitySignalMessage.LiveActivityPopUpInfo liveActivityPopUpInfo = liveActivityPopUpInfoArr2[i30];
                if (liveActivityPopUpInfo != null) {
                    codedOutputByteBufferNano.writeMessage(30, liveActivityPopUpInfo);
                }
                i30++;
            }
        }
        LiveFansTopBoostFollowFeed[] liveFansTopBoostFollowFeedArr = this.fansTopBoostFollowFeed;
        if (liveFansTopBoostFollowFeedArr != null && liveFansTopBoostFollowFeedArr.length > 0) {
            int i31 = 0;
            while (true) {
                LiveFansTopBoostFollowFeed[] liveFansTopBoostFollowFeedArr2 = this.fansTopBoostFollowFeed;
                if (i31 >= liveFansTopBoostFollowFeedArr2.length) {
                    break;
                }
                LiveFansTopBoostFollowFeed liveFansTopBoostFollowFeed = liveFansTopBoostFollowFeedArr2[i31];
                if (liveFansTopBoostFollowFeed != null) {
                    codedOutputByteBufferNano.writeMessage(31, liveFansTopBoostFollowFeed);
                }
                i31++;
            }
        }
        LiveCommonEffectInfo[] liveCommonEffectInfoArr = this.effectInfo;
        if (liveCommonEffectInfoArr != null && liveCommonEffectInfoArr.length > 0) {
            int i32 = 0;
            while (true) {
                LiveCommonEffectInfo[] liveCommonEffectInfoArr2 = this.effectInfo;
                if (i32 >= liveCommonEffectInfoArr2.length) {
                    break;
                }
                LiveCommonEffectInfo liveCommonEffectInfo = liveCommonEffectInfoArr2[i32];
                if (liveCommonEffectInfo != null) {
                    codedOutputByteBufferNano.writeMessage(32, liveCommonEffectInfo);
                }
                i32++;
            }
        }
        LiveGuardNotice[] liveGuardNoticeArr = this.liveGuardNotice;
        if (liveGuardNoticeArr != null && liveGuardNoticeArr.length > 0) {
            int i33 = 0;
            while (true) {
                LiveGuardNotice[] liveGuardNoticeArr2 = this.liveGuardNotice;
                if (i33 >= liveGuardNoticeArr2.length) {
                    break;
                }
                LiveGuardNotice liveGuardNotice = liveGuardNoticeArr2[i33];
                if (liveGuardNotice != null) {
                    codedOutputByteBufferNano.writeMessage(33, liveGuardNotice);
                }
                i33++;
            }
        }
        GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNoticeArr = this.gzoneInteractiveCommentNotice;
        if (gzoneInteractiveCommentNoticeArr != null && gzoneInteractiveCommentNoticeArr.length > 0) {
            int i34 = 0;
            while (true) {
                GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNoticeArr2 = this.gzoneInteractiveCommentNotice;
                if (i34 >= gzoneInteractiveCommentNoticeArr2.length) {
                    break;
                }
                GzoneInteractiveCommentNotice gzoneInteractiveCommentNotice = gzoneInteractiveCommentNoticeArr2[i34];
                if (gzoneInteractiveCommentNotice != null) {
                    codedOutputByteBufferNano.writeMessage(34, gzoneInteractiveCommentNotice);
                }
                i34++;
            }
        }
        LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeed;
        if (richTextFeedArr != null && richTextFeedArr.length > 0) {
            int i35 = 0;
            while (true) {
                LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = this.richTextFeed;
                if (i35 >= richTextFeedArr2.length) {
                    break;
                }
                LiveStreamRichTextFeed.RichTextFeed richTextFeed = richTextFeedArr2[i35];
                if (richTextFeed != null) {
                    codedOutputByteBufferNano.writeMessage(35, richTextFeed);
                }
                i35++;
            }
        }
        GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNoticeArr = this.gzoneAuthorTaskProgressNotice;
        if (gzoneAuthorTaskProgressNoticeArr != null && gzoneAuthorTaskProgressNoticeArr.length > 0) {
            int i36 = 0;
            while (true) {
                GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNoticeArr2 = this.gzoneAuthorTaskProgressNotice;
                if (i36 >= gzoneAuthorTaskProgressNoticeArr2.length) {
                    break;
                }
                GzoneAuthorTaskProgressNotice gzoneAuthorTaskProgressNotice = gzoneAuthorTaskProgressNoticeArr2[i36];
                if (gzoneAuthorTaskProgressNotice != null) {
                    codedOutputByteBufferNano.writeMessage(36, gzoneAuthorTaskProgressNotice);
                }
                i36++;
            }
        }
        GzoneAuthorCommonNotice[] gzoneAuthorCommonNoticeArr = this.gzoneAuthorCommonNotice;
        if (gzoneAuthorCommonNoticeArr != null && gzoneAuthorCommonNoticeArr.length > 0) {
            int i37 = 0;
            while (true) {
                GzoneAuthorCommonNotice[] gzoneAuthorCommonNoticeArr2 = this.gzoneAuthorCommonNotice;
                if (i37 >= gzoneAuthorCommonNoticeArr2.length) {
                    break;
                }
                GzoneAuthorCommonNotice gzoneAuthorCommonNotice = gzoneAuthorCommonNoticeArr2[i37];
                if (gzoneAuthorCommonNotice != null) {
                    codedOutputByteBufferNano.writeMessage(37, gzoneAuthorCommonNotice);
                }
                i37++;
            }
        }
        LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNoticeArr = this.liveHappyPlayOpenResultNotice;
        if (liveHappyPlayOpenResultNoticeArr != null && liveHappyPlayOpenResultNoticeArr.length > 0) {
            int i38 = 0;
            while (true) {
                LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNoticeArr2 = this.liveHappyPlayOpenResultNotice;
                if (i38 >= liveHappyPlayOpenResultNoticeArr2.length) {
                    break;
                }
                LiveHappyPlayOpenResultNotice liveHappyPlayOpenResultNotice = liveHappyPlayOpenResultNoticeArr2[i38];
                if (liveHappyPlayOpenResultNotice != null) {
                    codedOutputByteBufferNano.writeMessage(38, liveHappyPlayOpenResultNotice);
                }
                i38++;
            }
        }
        LiveCommonRoute[] liveCommonRouteArr = this.liveCommonRoute;
        if (liveCommonRouteArr != null && liveCommonRouteArr.length > 0) {
            int i39 = 0;
            while (true) {
                LiveCommonRoute[] liveCommonRouteArr2 = this.liveCommonRoute;
                if (i39 >= liveCommonRouteArr2.length) {
                    break;
                }
                LiveCommonRoute liveCommonRoute = liveCommonRouteArr2[i39];
                if (liveCommonRoute != null) {
                    codedOutputByteBufferNano.writeMessage(39, liveCommonRoute);
                }
                i39++;
            }
        }
        LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeedArr = this.liveWatchingListChangeNoticeFeed;
        if (liveWatchingListChangeNoticeFeedArr != null && liveWatchingListChangeNoticeFeedArr.length > 0) {
            int i40 = 0;
            while (true) {
                LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeedArr2 = this.liveWatchingListChangeNoticeFeed;
                if (i40 >= liveWatchingListChangeNoticeFeedArr2.length) {
                    break;
                }
                LiveWatchingListChangeNoticeFeed liveWatchingListChangeNoticeFeed = liveWatchingListChangeNoticeFeedArr2[i40];
                if (liveWatchingListChangeNoticeFeed != null) {
                    codedOutputByteBufferNano.writeMessage(40, liveWatchingListChangeNoticeFeed);
                }
                i40++;
            }
        }
        GzoneCommonFeed[] gzoneCommonFeedArr = this.gzoneCommonFeed;
        if (gzoneCommonFeedArr != null && gzoneCommonFeedArr.length > 0) {
            int i41 = 0;
            while (true) {
                GzoneCommonFeed[] gzoneCommonFeedArr2 = this.gzoneCommonFeed;
                if (i41 >= gzoneCommonFeedArr2.length) {
                    break;
                }
                GzoneCommonFeed gzoneCommonFeed = gzoneCommonFeedArr2[i41];
                if (gzoneCommonFeed != null) {
                    codedOutputByteBufferNano.writeMessage(41, gzoneCommonFeed);
                }
                i41++;
            }
        }
        LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopupArr = this.liveCommonPopup;
        if (liveCommonPopupArr != null && liveCommonPopupArr.length > 0) {
            int i42 = 0;
            while (true) {
                LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopupArr2 = this.liveCommonPopup;
                if (i42 >= liveCommonPopupArr2.length) {
                    break;
                }
                LiveCommonNoticeMessages.LiveCommonPopup liveCommonPopup = liveCommonPopupArr2[i42];
                if (liveCommonPopup != null) {
                    codedOutputByteBufferNano.writeMessage(42, liveCommonPopup);
                }
                i42++;
            }
        }
        CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChangeArr = this.commodityCardComponentChange;
        if (commodityCardComponentChangeArr != null && commodityCardComponentChangeArr.length > 0) {
            int i43 = 0;
            while (true) {
                CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChangeArr2 = this.commodityCardComponentChange;
                if (i43 >= commodityCardComponentChangeArr2.length) {
                    break;
                }
                CommodityCardMessage.CommodityCardComponentChange commodityCardComponentChange = commodityCardComponentChangeArr2[i43];
                if (commodityCardComponentChange != null) {
                    codedOutputByteBufferNano.writeMessage(43, commodityCardComponentChange);
                }
                i43++;
            }
        }
        CommodityCardMessage.CommodityCardChange[] commodityCardChangeArr = this.commodityCardChange;
        if (commodityCardChangeArr != null && commodityCardChangeArr.length > 0) {
            int i44 = 0;
            while (true) {
                CommodityCardMessage.CommodityCardChange[] commodityCardChangeArr2 = this.commodityCardChange;
                if (i44 >= commodityCardChangeArr2.length) {
                    break;
                }
                CommodityCardMessage.CommodityCardChange commodityCardChange = commodityCardChangeArr2[i44];
                if (commodityCardChange != null) {
                    codedOutputByteBufferNano.writeMessage(44, commodityCardChange);
                }
                i44++;
            }
        }
        LiveCommonNoticeMessages.LiteTextNotice[] liteTextNoticeArr = this.textNotice;
        if (liteTextNoticeArr != null && liteTextNoticeArr.length > 0) {
            int i45 = 0;
            while (true) {
                LiveCommonNoticeMessages.LiteTextNotice[] liteTextNoticeArr2 = this.textNotice;
                if (i45 >= liteTextNoticeArr2.length) {
                    break;
                }
                LiveCommonNoticeMessages.LiteTextNotice liteTextNotice = liteTextNoticeArr2[i45];
                if (liteTextNotice != null) {
                    codedOutputByteBufferNano.writeMessage(45, liteTextNotice);
                }
                i45++;
            }
        }
        LiveRoomSignalMessage.SCKwaishopLivePendant[] sCKwaishopLivePendantArr = this.shopLivePendant;
        if (sCKwaishopLivePendantArr != null && sCKwaishopLivePendantArr.length > 0) {
            int i46 = 0;
            while (true) {
                LiveRoomSignalMessage.SCKwaishopLivePendant[] sCKwaishopLivePendantArr2 = this.shopLivePendant;
                if (i46 >= sCKwaishopLivePendantArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.SCKwaishopLivePendant sCKwaishopLivePendant = sCKwaishopLivePendantArr2[i46];
                if (sCKwaishopLivePendant != null) {
                    codedOutputByteBufferNano.writeMessage(46, sCKwaishopLivePendant);
                }
                i46++;
            }
        }
        LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveActionArr = this.marketingPushLiveAction;
        if (marketingPushLiveActionArr != null && marketingPushLiveActionArr.length > 0) {
            int i47 = 0;
            while (true) {
                LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveActionArr2 = this.marketingPushLiveAction;
                if (i47 >= marketingPushLiveActionArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.MarketingPushLiveAction marketingPushLiveAction = marketingPushLiveActionArr2[i47];
                if (marketingPushLiveAction != null) {
                    codedOutputByteBufferNano.writeMessage(47, marketingPushLiveAction);
                }
                i47++;
            }
        }
        LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNoticeArr = this.liveRefreshAuthorStatusNotice;
        if (liveRefreshAuthorStatusNoticeArr != null && liveRefreshAuthorStatusNoticeArr.length > 0) {
            int i48 = 0;
            while (true) {
                LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNoticeArr2 = this.liveRefreshAuthorStatusNotice;
                if (i48 >= liveRefreshAuthorStatusNoticeArr2.length) {
                    break;
                }
                LiveRefreshAuthorStatusNotice liveRefreshAuthorStatusNotice = liveRefreshAuthorStatusNoticeArr2[i48];
                if (liveRefreshAuthorStatusNotice != null) {
                    codedOutputByteBufferNano.writeMessage(48, liveRefreshAuthorStatusNotice);
                }
                i48++;
            }
        }
        LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] sCKwaishopLiveActivityPendantArr = this.shopLiveActivityPendant;
        if (sCKwaishopLiveActivityPendantArr != null && sCKwaishopLiveActivityPendantArr.length > 0) {
            int i49 = 0;
            while (true) {
                LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] sCKwaishopLiveActivityPendantArr2 = this.shopLiveActivityPendant;
                if (i49 >= sCKwaishopLiveActivityPendantArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.SCKwaishopLiveActivityPendant sCKwaishopLiveActivityPendant = sCKwaishopLiveActivityPendantArr2[i49];
                if (sCKwaishopLiveActivityPendant != null) {
                    codedOutputByteBufferNano.writeMessage(49, sCKwaishopLiveActivityPendant);
                }
                i49++;
            }
        }
        LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] sCLiveBuyingNoticeSignalArr = this.liveBuyingNoticeSignal;
        if (sCLiveBuyingNoticeSignalArr != null && sCLiveBuyingNoticeSignalArr.length > 0) {
            int i50 = 0;
            while (true) {
                LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] sCLiveBuyingNoticeSignalArr2 = this.liveBuyingNoticeSignal;
                if (i50 >= sCLiveBuyingNoticeSignalArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.SCLiveBuyingNoticeSignal sCLiveBuyingNoticeSignal = sCLiveBuyingNoticeSignalArr2[i50];
                if (sCLiveBuyingNoticeSignal != null) {
                    codedOutputByteBufferNano.writeMessage(50, sCLiveBuyingNoticeSignal);
                }
                i50++;
            }
        }
        PkBountyActivityResultInfo[] pkBountyActivityResultInfoArr = this.pkBountyActivityResultInfo;
        if (pkBountyActivityResultInfoArr != null && pkBountyActivityResultInfoArr.length > 0) {
            int i51 = 0;
            while (true) {
                PkBountyActivityResultInfo[] pkBountyActivityResultInfoArr2 = this.pkBountyActivityResultInfo;
                if (i51 >= pkBountyActivityResultInfoArr2.length) {
                    break;
                }
                PkBountyActivityResultInfo pkBountyActivityResultInfo = pkBountyActivityResultInfoArr2[i51];
                if (pkBountyActivityResultInfo != null) {
                    codedOutputByteBufferNano.writeMessage(51, pkBountyActivityResultInfo);
                }
                i51++;
            }
        }
        SendGiftNotifyAnimation[] sendGiftNotifyAnimationArr = this.sendGiftNotifyAnimation;
        if (sendGiftNotifyAnimationArr != null && sendGiftNotifyAnimationArr.length > 0) {
            int i52 = 0;
            while (true) {
                SendGiftNotifyAnimation[] sendGiftNotifyAnimationArr2 = this.sendGiftNotifyAnimation;
                if (i52 >= sendGiftNotifyAnimationArr2.length) {
                    break;
                }
                SendGiftNotifyAnimation sendGiftNotifyAnimation = sendGiftNotifyAnimationArr2[i52];
                if (sendGiftNotifyAnimation != null) {
                    codedOutputByteBufferNano.writeMessage(52, sendGiftNotifyAnimation);
                }
                i52++;
            }
        }
        HighFrequencyActionGuide[] highFrequencyActionGuideArr = this.highFrequencyActionGuide;
        if (highFrequencyActionGuideArr != null && highFrequencyActionGuideArr.length > 0) {
            int i53 = 0;
            while (true) {
                HighFrequencyActionGuide[] highFrequencyActionGuideArr2 = this.highFrequencyActionGuide;
                if (i53 >= highFrequencyActionGuideArr2.length) {
                    break;
                }
                HighFrequencyActionGuide highFrequencyActionGuide = highFrequencyActionGuideArr2[i53];
                if (highFrequencyActionGuide != null) {
                    codedOutputByteBufferNano.writeMessage(53, highFrequencyActionGuide);
                }
                i53++;
            }
        }
        LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfoArr = this.liveCommonEffectRouteInfo;
        if (liveCommonEffectRouteInfoArr != null && liveCommonEffectRouteInfoArr.length > 0) {
            int i54 = 0;
            while (true) {
                LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfoArr2 = this.liveCommonEffectRouteInfo;
                if (i54 >= liveCommonEffectRouteInfoArr2.length) {
                    break;
                }
                LiveCommonEffectRouteInfo liveCommonEffectRouteInfo = liveCommonEffectRouteInfoArr2[i54];
                if (liveCommonEffectRouteInfo != null) {
                    codedOutputByteBufferNano.writeMessage(54, liveCommonEffectRouteInfo);
                }
                i54++;
            }
        }
        LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] kwaishopLiveAskOnItemSignalArr = this.liveAskOnItem;
        if (kwaishopLiveAskOnItemSignalArr != null && kwaishopLiveAskOnItemSignalArr.length > 0) {
            int i55 = 0;
            while (true) {
                LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] kwaishopLiveAskOnItemSignalArr2 = this.liveAskOnItem;
                if (i55 >= kwaishopLiveAskOnItemSignalArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal kwaishopLiveAskOnItemSignal = kwaishopLiveAskOnItemSignalArr2[i55];
                if (kwaishopLiveAskOnItemSignal != null) {
                    codedOutputByteBufferNano.writeMessage(55, kwaishopLiveAskOnItemSignal);
                }
                i55++;
            }
        }
        LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfoArr = this.liveMultiMagicEffectInfo;
        if (liveMultiMagicEffectInfoArr != null && liveMultiMagicEffectInfoArr.length > 0) {
            int i56 = 0;
            while (true) {
                LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfoArr2 = this.liveMultiMagicEffectInfo;
                if (i56 >= liveMultiMagicEffectInfoArr2.length) {
                    break;
                }
                LiveMultiMagicEffectInfo liveMultiMagicEffectInfo = liveMultiMagicEffectInfoArr2[i56];
                if (liveMultiMagicEffectInfo != null) {
                    codedOutputByteBufferNano.writeMessage(56, liveMultiMagicEffectInfo);
                }
                i56++;
            }
        }
        LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] sCLiveGuideFollowAuthorCardInfoArr = this.liveGuideFollowCardInfo;
        if (sCLiveGuideFollowAuthorCardInfoArr != null && sCLiveGuideFollowAuthorCardInfoArr.length > 0) {
            int i57 = 0;
            while (true) {
                LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] sCLiveGuideFollowAuthorCardInfoArr2 = this.liveGuideFollowCardInfo;
                if (i57 >= sCLiveGuideFollowAuthorCardInfoArr2.length) {
                    break;
                }
                LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo sCLiveGuideFollowAuthorCardInfo = sCLiveGuideFollowAuthorCardInfoArr2[i57];
                if (sCLiveGuideFollowAuthorCardInfo != null) {
                    codedOutputByteBufferNano.writeMessage(57, sCLiveGuideFollowAuthorCardInfo);
                }
                i57++;
            }
        }
        LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffectsArr = this.liveVoicePartyMicSeatUserLevelUpEffect;
        if (liveVoicePartyMicSeatUserLevelUpEffectsArr != null && liveVoicePartyMicSeatUserLevelUpEffectsArr.length > 0) {
            int i58 = 0;
            while (true) {
                LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffectsArr2 = this.liveVoicePartyMicSeatUserLevelUpEffect;
                if (i58 >= liveVoicePartyMicSeatUserLevelUpEffectsArr2.length) {
                    break;
                }
                LiveVoicePartyMicSeatUserLevelUpEffects liveVoicePartyMicSeatUserLevelUpEffects = liveVoicePartyMicSeatUserLevelUpEffectsArr2[i58];
                if (liveVoicePartyMicSeatUserLevelUpEffects != null) {
                    codedOutputByteBufferNano.writeMessage(58, liveVoicePartyMicSeatUserLevelUpEffects);
                }
                i58++;
            }
        }
        LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] sCLiveAuthorReinforceInfoArr = this.liveAuthorReinforceInfo;
        if (sCLiveAuthorReinforceInfoArr != null && sCLiveAuthorReinforceInfoArr.length > 0) {
            int i59 = 0;
            while (true) {
                LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] sCLiveAuthorReinforceInfoArr2 = this.liveAuthorReinforceInfo;
                if (i59 >= sCLiveAuthorReinforceInfoArr2.length) {
                    break;
                }
                LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo sCLiveAuthorReinforceInfo = sCLiveAuthorReinforceInfoArr2[i59];
                if (sCLiveAuthorReinforceInfo != null) {
                    codedOutputByteBufferNano.writeMessage(59, sCLiveAuthorReinforceInfo);
                }
                i59++;
            }
        }
        TestActionSignalFeed[] testActionSignalFeedArr = this.testFeed;
        if (testActionSignalFeedArr != null && testActionSignalFeedArr.length > 0) {
            while (true) {
                TestActionSignalFeed[] testActionSignalFeedArr2 = this.testFeed;
                if (i >= testActionSignalFeedArr2.length) {
                    break;
                }
                TestActionSignalFeed testActionSignalFeed = testActionSignalFeedArr2[i];
                if (testActionSignalFeed != null) {
                    codedOutputByteBufferNano.writeMessage(100, testActionSignalFeed);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        KtvMusicOrderFeed[] ktvMusicOrderFeedArr = this.ktvMusicOrderFeed;
        int i = 0;
        if (ktvMusicOrderFeedArr != null && ktvMusicOrderFeedArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                KtvMusicOrderFeed[] ktvMusicOrderFeedArr2 = this.ktvMusicOrderFeed;
                if (i2 >= ktvMusicOrderFeedArr2.length) {
                    break;
                }
                KtvMusicOrderFeed ktvMusicOrderFeed = ktvMusicOrderFeedArr2[i2];
                if (ktvMusicOrderFeed != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, ktvMusicOrderFeed);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        FansGroupJoinFeed[] fansGroupJoinFeedArr = this.fansGroupJoinFeed;
        if (fansGroupJoinFeedArr != null && fansGroupJoinFeedArr.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                FansGroupJoinFeed[] fansGroupJoinFeedArr2 = this.fansGroupJoinFeed;
                if (i3 >= fansGroupJoinFeedArr2.length) {
                    break;
                }
                FansGroupJoinFeed fansGroupJoinFeed = fansGroupJoinFeedArr2[i3];
                if (fansGroupJoinFeed != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, fansGroupJoinFeed);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        TopBannerNoticeFeed[] topBannerNoticeFeedArr = this.topBannerNoticeFeed;
        if (topBannerNoticeFeedArr != null && topBannerNoticeFeedArr.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                TopBannerNoticeFeed[] topBannerNoticeFeedArr2 = this.topBannerNoticeFeed;
                if (i4 >= topBannerNoticeFeedArr2.length) {
                    break;
                }
                TopBannerNoticeFeed topBannerNoticeFeed = topBannerNoticeFeedArr2[i4];
                if (topBannerNoticeFeed != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(3, topBannerNoticeFeed);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        LiveVoicePartyToastFeed[] liveVoicePartyToastFeedArr = this.voicePartyToastFeed;
        if (liveVoicePartyToastFeedArr != null && liveVoicePartyToastFeedArr.length > 0) {
            int iComputeMessageSize4 = iComputeSerializedSize;
            int i5 = 0;
            while (true) {
                LiveVoicePartyToastFeed[] liveVoicePartyToastFeedArr2 = this.voicePartyToastFeed;
                if (i5 >= liveVoicePartyToastFeedArr2.length) {
                    break;
                }
                LiveVoicePartyToastFeed liveVoicePartyToastFeed = liveVoicePartyToastFeedArr2[i5];
                if (liveVoicePartyToastFeed != null) {
                    iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(4, liveVoicePartyToastFeed);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeMessageSize4;
        }
        LivePetUpgradeFeed[] livePetUpgradeFeedArr = this.livePetUpgradeFeed;
        if (livePetUpgradeFeedArr != null && livePetUpgradeFeedArr.length > 0) {
            int iComputeMessageSize5 = iComputeSerializedSize;
            int i6 = 0;
            while (true) {
                LivePetUpgradeFeed[] livePetUpgradeFeedArr2 = this.livePetUpgradeFeed;
                if (i6 >= livePetUpgradeFeedArr2.length) {
                    break;
                }
                LivePetUpgradeFeed livePetUpgradeFeed = livePetUpgradeFeedArr2[i6];
                if (livePetUpgradeFeed != null) {
                    iComputeMessageSize5 += CodedOutputByteBufferNano.computeMessageSize(5, livePetUpgradeFeed);
                }
                i6++;
            }
            iComputeSerializedSize = iComputeMessageSize5;
        }
        TopDistrictRank[] topDistrictRankArr = this.topDistrictRank;
        if (topDistrictRankArr != null && topDistrictRankArr.length > 0) {
            int iComputeMessageSize6 = iComputeSerializedSize;
            int i7 = 0;
            while (true) {
                TopDistrictRank[] topDistrictRankArr2 = this.topDistrictRank;
                if (i7 >= topDistrictRankArr2.length) {
                    break;
                }
                TopDistrictRank topDistrictRank = topDistrictRankArr2[i7];
                if (topDistrictRank != null) {
                    iComputeMessageSize6 += CodedOutputByteBufferNano.computeMessageSize(6, topDistrictRank);
                }
                i7++;
            }
            iComputeSerializedSize = iComputeMessageSize6;
        }
        LiveFollowGuide[] liveFollowGuideArr = this.liveFollowGuide;
        if (liveFollowGuideArr != null && liveFollowGuideArr.length > 0) {
            int iComputeMessageSize7 = iComputeSerializedSize;
            int i8 = 0;
            while (true) {
                LiveFollowGuide[] liveFollowGuideArr2 = this.liveFollowGuide;
                if (i8 >= liveFollowGuideArr2.length) {
                    break;
                }
                LiveFollowGuide liveFollowGuide = liveFollowGuideArr2[i8];
                if (liveFollowGuide != null) {
                    iComputeMessageSize7 += CodedOutputByteBufferNano.computeMessageSize(7, liveFollowGuide);
                }
                i8++;
            }
            iComputeSerializedSize = iComputeMessageSize7;
        }
        VoicePartyEmojiFeed[] voicePartyEmojiFeedArr = this.voicePartyEmojiFeed;
        if (voicePartyEmojiFeedArr != null && voicePartyEmojiFeedArr.length > 0) {
            int iComputeMessageSize8 = iComputeSerializedSize;
            int i9 = 0;
            while (true) {
                VoicePartyEmojiFeed[] voicePartyEmojiFeedArr2 = this.voicePartyEmojiFeed;
                if (i9 >= voicePartyEmojiFeedArr2.length) {
                    break;
                }
                VoicePartyEmojiFeed voicePartyEmojiFeed = voicePartyEmojiFeedArr2[i9];
                if (voicePartyEmojiFeed != null) {
                    iComputeMessageSize8 += CodedOutputByteBufferNano.computeMessageSize(8, voicePartyEmojiFeed);
                }
                i9++;
            }
            iComputeSerializedSize = iComputeMessageSize8;
        }
        LiveShopMessages.LiveShopAction[] liveShopActionArr = this.shopAction;
        if (liveShopActionArr != null && liveShopActionArr.length > 0) {
            int iComputeMessageSize9 = iComputeSerializedSize;
            int i10 = 0;
            while (true) {
                LiveShopMessages.LiveShopAction[] liveShopActionArr2 = this.shopAction;
                if (i10 >= liveShopActionArr2.length) {
                    break;
                }
                LiveShopMessages.LiveShopAction liveShopAction = liveShopActionArr2[i10];
                if (liveShopAction != null) {
                    iComputeMessageSize9 += CodedOutputByteBufferNano.computeMessageSize(9, liveShopAction);
                }
                i10++;
            }
            iComputeSerializedSize = iComputeMessageSize9;
        }
        LiveUserClipLightGuide[] liveUserClipLightGuideArr = this.liveUserClipLightGuide;
        if (liveUserClipLightGuideArr != null && liveUserClipLightGuideArr.length > 0) {
            int iComputeMessageSize10 = iComputeSerializedSize;
            int i11 = 0;
            while (true) {
                LiveUserClipLightGuide[] liveUserClipLightGuideArr2 = this.liveUserClipLightGuide;
                if (i11 >= liveUserClipLightGuideArr2.length) {
                    break;
                }
                LiveUserClipLightGuide liveUserClipLightGuide = liveUserClipLightGuideArr2[i11];
                if (liveUserClipLightGuide != null) {
                    iComputeMessageSize10 += CodedOutputByteBufferNano.computeMessageSize(11, liveUserClipLightGuide);
                }
                i11++;
            }
            iComputeSerializedSize = iComputeMessageSize10;
        }
        LiveGamePopupFeed[] liveGamePopupFeedArr = this.liveGamePopupFeed;
        if (liveGamePopupFeedArr != null && liveGamePopupFeedArr.length > 0) {
            int iComputeMessageSize11 = iComputeSerializedSize;
            int i12 = 0;
            while (true) {
                LiveGamePopupFeed[] liveGamePopupFeedArr2 = this.liveGamePopupFeed;
                if (i12 >= liveGamePopupFeedArr2.length) {
                    break;
                }
                LiveGamePopupFeed liveGamePopupFeed = liveGamePopupFeedArr2[i12];
                if (liveGamePopupFeed != null) {
                    iComputeMessageSize11 += CodedOutputByteBufferNano.computeMessageSize(12, liveGamePopupFeed);
                }
                i12++;
            }
            iComputeSerializedSize = iComputeMessageSize11;
        }
        RainbowCommentFeed[] rainbowCommentFeedArr = this.rainbowCommentFeed;
        if (rainbowCommentFeedArr != null && rainbowCommentFeedArr.length > 0) {
            int iComputeMessageSize12 = iComputeSerializedSize;
            int i13 = 0;
            while (true) {
                RainbowCommentFeed[] rainbowCommentFeedArr2 = this.rainbowCommentFeed;
                if (i13 >= rainbowCommentFeedArr2.length) {
                    break;
                }
                RainbowCommentFeed rainbowCommentFeed = rainbowCommentFeedArr2[i13];
                if (rainbowCommentFeed != null) {
                    iComputeMessageSize12 += CodedOutputByteBufferNano.computeMessageSize(13, rainbowCommentFeed);
                }
                i13++;
            }
            iComputeSerializedSize = iComputeMessageSize12;
        }
        LiveExtraMessages.LiveCommonActionSignal[] liveCommonActionSignalArr = this.commerceCommonFeed;
        if (liveCommonActionSignalArr != null && liveCommonActionSignalArr.length > 0) {
            int iComputeMessageSize13 = iComputeSerializedSize;
            int i14 = 0;
            while (true) {
                LiveExtraMessages.LiveCommonActionSignal[] liveCommonActionSignalArr2 = this.commerceCommonFeed;
                if (i14 >= liveCommonActionSignalArr2.length) {
                    break;
                }
                LiveExtraMessages.LiveCommonActionSignal liveCommonActionSignal = liveCommonActionSignalArr2[i14];
                if (liveCommonActionSignal != null) {
                    iComputeMessageSize13 += CodedOutputByteBufferNano.computeMessageSize(14, liveCommonActionSignal);
                }
                i14++;
            }
            iComputeSerializedSize = iComputeMessageSize13;
        }
        GzoneCommentLotteryFeed[] gzoneCommentLotteryFeedArr = this.gzoneCommentLotteryFeed;
        if (gzoneCommentLotteryFeedArr != null && gzoneCommentLotteryFeedArr.length > 0) {
            int iComputeMessageSize14 = iComputeSerializedSize;
            int i15 = 0;
            while (true) {
                GzoneCommentLotteryFeed[] gzoneCommentLotteryFeedArr2 = this.gzoneCommentLotteryFeed;
                if (i15 >= gzoneCommentLotteryFeedArr2.length) {
                    break;
                }
                GzoneCommentLotteryFeed gzoneCommentLotteryFeed = gzoneCommentLotteryFeedArr2[i15];
                if (gzoneCommentLotteryFeed != null) {
                    iComputeMessageSize14 += CodedOutputByteBufferNano.computeMessageSize(15, gzoneCommentLotteryFeed);
                }
                i15++;
            }
            iComputeSerializedSize = iComputeMessageSize14;
        }
        GzoneLiveRedDotFeed[] gzoneLiveRedDotFeedArr = this.gzoneLiveRedDotFeed;
        if (gzoneLiveRedDotFeedArr != null && gzoneLiveRedDotFeedArr.length > 0) {
            int iComputeMessageSize15 = iComputeSerializedSize;
            int i16 = 0;
            while (true) {
                GzoneLiveRedDotFeed[] gzoneLiveRedDotFeedArr2 = this.gzoneLiveRedDotFeed;
                if (i16 >= gzoneLiveRedDotFeedArr2.length) {
                    break;
                }
                GzoneLiveRedDotFeed gzoneLiveRedDotFeed = gzoneLiveRedDotFeedArr2[i16];
                if (gzoneLiveRedDotFeed != null) {
                    iComputeMessageSize15 += CodedOutputByteBufferNano.computeMessageSize(16, gzoneLiveRedDotFeed);
                }
                i16++;
            }
            iComputeSerializedSize = iComputeMessageSize15;
        }
        TeamPkFightMotion[] teamPkFightMotionArr = this.teamPkFightMotion;
        if (teamPkFightMotionArr != null && teamPkFightMotionArr.length > 0) {
            int iComputeMessageSize16 = iComputeSerializedSize;
            int i17 = 0;
            while (true) {
                TeamPkFightMotion[] teamPkFightMotionArr2 = this.teamPkFightMotion;
                if (i17 >= teamPkFightMotionArr2.length) {
                    break;
                }
                TeamPkFightMotion teamPkFightMotion = teamPkFightMotionArr2[i17];
                if (teamPkFightMotion != null) {
                    iComputeMessageSize16 += CodedOutputByteBufferNano.computeMessageSize(17, teamPkFightMotion);
                }
                i17++;
            }
            iComputeSerializedSize = iComputeMessageSize16;
        }
        WealthHighGradeEnterRoom[] wealthHighGradeEnterRoomArr = this.wealthHighGradeEnterRoom;
        if (wealthHighGradeEnterRoomArr != null && wealthHighGradeEnterRoomArr.length > 0) {
            int iComputeMessageSize17 = iComputeSerializedSize;
            int i18 = 0;
            while (true) {
                WealthHighGradeEnterRoom[] wealthHighGradeEnterRoomArr2 = this.wealthHighGradeEnterRoom;
                if (i18 >= wealthHighGradeEnterRoomArr2.length) {
                    break;
                }
                WealthHighGradeEnterRoom wealthHighGradeEnterRoom = wealthHighGradeEnterRoomArr2[i18];
                if (wealthHighGradeEnterRoom != null) {
                    iComputeMessageSize17 += CodedOutputByteBufferNano.computeMessageSize(18, wealthHighGradeEnterRoom);
                }
                i18++;
            }
            iComputeSerializedSize = iComputeMessageSize17;
        }
        LiveFansTopOrderHelpBuyFeed[] liveFansTopOrderHelpBuyFeedArr = this.fansTopOrderHelpBuy;
        if (liveFansTopOrderHelpBuyFeedArr != null && liveFansTopOrderHelpBuyFeedArr.length > 0) {
            int iComputeMessageSize18 = iComputeSerializedSize;
            int i19 = 0;
            while (true) {
                LiveFansTopOrderHelpBuyFeed[] liveFansTopOrderHelpBuyFeedArr2 = this.fansTopOrderHelpBuy;
                if (i19 >= liveFansTopOrderHelpBuyFeedArr2.length) {
                    break;
                }
                LiveFansTopOrderHelpBuyFeed liveFansTopOrderHelpBuyFeed = liveFansTopOrderHelpBuyFeedArr2[i19];
                if (liveFansTopOrderHelpBuyFeed != null) {
                    iComputeMessageSize18 += CodedOutputByteBufferNano.computeMessageSize(19, liveFansTopOrderHelpBuyFeed);
                }
                i19++;
            }
            iComputeSerializedSize = iComputeMessageSize18;
        }
        WealthHighGradeBulletComment[] wealthHighGradeBulletCommentArr = this.highGradeBulletComment;
        if (wealthHighGradeBulletCommentArr != null && wealthHighGradeBulletCommentArr.length > 0) {
            int iComputeMessageSize19 = iComputeSerializedSize;
            int i20 = 0;
            while (true) {
                WealthHighGradeBulletComment[] wealthHighGradeBulletCommentArr2 = this.highGradeBulletComment;
                if (i20 >= wealthHighGradeBulletCommentArr2.length) {
                    break;
                }
                WealthHighGradeBulletComment wealthHighGradeBulletComment = wealthHighGradeBulletCommentArr2[i20];
                if (wealthHighGradeBulletComment != null) {
                    iComputeMessageSize19 += CodedOutputByteBufferNano.computeMessageSize(20, wealthHighGradeBulletComment);
                }
                i20++;
            }
            iComputeSerializedSize = iComputeMessageSize19;
        }
        GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeedArr = this.gzoneLiveBuffCardFeed;
        if (gzoneLiveBuffCardFeedArr != null && gzoneLiveBuffCardFeedArr.length > 0) {
            int iComputeMessageSize20 = iComputeSerializedSize;
            int i21 = 0;
            while (true) {
                GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeedArr2 = this.gzoneLiveBuffCardFeed;
                if (i21 >= gzoneLiveBuffCardFeedArr2.length) {
                    break;
                }
                GzoneLiveBuffCardFeed gzoneLiveBuffCardFeed = gzoneLiveBuffCardFeedArr2[i21];
                if (gzoneLiveBuffCardFeed != null) {
                    iComputeMessageSize20 += CodedOutputByteBufferNano.computeMessageSize(21, gzoneLiveBuffCardFeed);
                }
                i21++;
            }
            iComputeSerializedSize = iComputeMessageSize20;
        }
        LiveActivityPopup[] liveActivityPopupArr = this.activityPopup;
        if (liveActivityPopupArr != null && liveActivityPopupArr.length > 0) {
            int iComputeMessageSize21 = iComputeSerializedSize;
            int i22 = 0;
            while (true) {
                LiveActivityPopup[] liveActivityPopupArr2 = this.activityPopup;
                if (i22 >= liveActivityPopupArr2.length) {
                    break;
                }
                LiveActivityPopup liveActivityPopup = liveActivityPopupArr2[i22];
                if (liveActivityPopup != null) {
                    iComputeMessageSize21 += CodedOutputByteBufferNano.computeMessageSize(22, liveActivityPopup);
                }
                i22++;
            }
            iComputeSerializedSize = iComputeMessageSize21;
        }
        ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoomArr = this.valentineHighScoreEnterRoom;
        if (valentineHighScoreEnterRoomArr != null && valentineHighScoreEnterRoomArr.length > 0) {
            int iComputeMessageSize22 = iComputeSerializedSize;
            int i23 = 0;
            while (true) {
                ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoomArr2 = this.valentineHighScoreEnterRoom;
                if (i23 >= valentineHighScoreEnterRoomArr2.length) {
                    break;
                }
                ValentineHighScoreEnterRoom valentineHighScoreEnterRoom = valentineHighScoreEnterRoomArr2[i23];
                if (valentineHighScoreEnterRoom != null) {
                    iComputeMessageSize22 += CodedOutputByteBufferNano.computeMessageSize(23, valentineHighScoreEnterRoom);
                }
                i23++;
            }
            iComputeSerializedSize = iComputeMessageSize22;
        }
        LivePkFirstBlood[] livePkFirstBloodArr = this.livePkFirstBlood;
        if (livePkFirstBloodArr != null && livePkFirstBloodArr.length > 0) {
            int iComputeMessageSize23 = iComputeSerializedSize;
            int i24 = 0;
            while (true) {
                LivePkFirstBlood[] livePkFirstBloodArr2 = this.livePkFirstBlood;
                if (i24 >= livePkFirstBloodArr2.length) {
                    break;
                }
                LivePkFirstBlood livePkFirstBlood = livePkFirstBloodArr2[i24];
                if (livePkFirstBlood != null) {
                    iComputeMessageSize23 += CodedOutputByteBufferNano.computeMessageSize(24, livePkFirstBlood);
                }
                i24++;
            }
            iComputeSerializedSize = iComputeMessageSize23;
        }
        LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoomArr = this.liveDragonBoatEnterRoom;
        if (liveDragonBoatEnterRoomArr != null && liveDragonBoatEnterRoomArr.length > 0) {
            int iComputeMessageSize24 = iComputeSerializedSize;
            int i25 = 0;
            while (true) {
                LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoomArr2 = this.liveDragonBoatEnterRoom;
                if (i25 >= liveDragonBoatEnterRoomArr2.length) {
                    break;
                }
                LiveDragonBoatEnterRoom liveDragonBoatEnterRoom = liveDragonBoatEnterRoomArr2[i25];
                if (liveDragonBoatEnterRoom != null) {
                    iComputeMessageSize24 += CodedOutputByteBufferNano.computeMessageSize(25, liveDragonBoatEnterRoom);
                }
                i25++;
            }
            iComputeSerializedSize = iComputeMessageSize24;
        }
        LiveRedPackSendInfo[] liveRedPackSendInfoArr = this.redPackSendInfo;
        if (liveRedPackSendInfoArr != null && liveRedPackSendInfoArr.length > 0) {
            int iComputeMessageSize25 = iComputeSerializedSize;
            int i26 = 0;
            while (true) {
                LiveRedPackSendInfo[] liveRedPackSendInfoArr2 = this.redPackSendInfo;
                if (i26 >= liveRedPackSendInfoArr2.length) {
                    break;
                }
                LiveRedPackSendInfo liveRedPackSendInfo = liveRedPackSendInfoArr2[i26];
                if (liveRedPackSendInfo != null) {
                    iComputeMessageSize25 += CodedOutputByteBufferNano.computeMessageSize(26, liveRedPackSendInfo);
                }
                i26++;
            }
            iComputeSerializedSize = iComputeMessageSize25;
        }
        LiveRedPackGrabInfo[] liveRedPackGrabInfoArr = this.redPackGrabInfo;
        if (liveRedPackGrabInfoArr != null && liveRedPackGrabInfoArr.length > 0) {
            int iComputeMessageSize26 = iComputeSerializedSize;
            int i27 = 0;
            while (true) {
                LiveRedPackGrabInfo[] liveRedPackGrabInfoArr2 = this.redPackGrabInfo;
                if (i27 >= liveRedPackGrabInfoArr2.length) {
                    break;
                }
                LiveRedPackGrabInfo liveRedPackGrabInfo = liveRedPackGrabInfoArr2[i27];
                if (liveRedPackGrabInfo != null) {
                    iComputeMessageSize26 += CodedOutputByteBufferNano.computeMessageSize(27, liveRedPackGrabInfo);
                }
                i27++;
            }
            iComputeSerializedSize = iComputeMessageSize26;
        }
        LiveActivityEnterRoomTip[] liveActivityEnterRoomTipArr = this.liveActivityEnterRoomTip;
        if (liveActivityEnterRoomTipArr != null && liveActivityEnterRoomTipArr.length > 0) {
            int iComputeMessageSize27 = iComputeSerializedSize;
            int i28 = 0;
            while (true) {
                LiveActivityEnterRoomTip[] liveActivityEnterRoomTipArr2 = this.liveActivityEnterRoomTip;
                if (i28 >= liveActivityEnterRoomTipArr2.length) {
                    break;
                }
                LiveActivityEnterRoomTip liveActivityEnterRoomTip = liveActivityEnterRoomTipArr2[i28];
                if (liveActivityEnterRoomTip != null) {
                    iComputeMessageSize27 += CodedOutputByteBufferNano.computeMessageSize(28, liveActivityEnterRoomTip);
                }
                i28++;
            }
            iComputeSerializedSize = iComputeMessageSize27;
        }
        LivePkGuideBubbleTip[] livePkGuideBubbleTipArr = this.pkGuideBubbleTip;
        if (livePkGuideBubbleTipArr != null && livePkGuideBubbleTipArr.length > 0) {
            int iComputeMessageSize28 = iComputeSerializedSize;
            int i29 = 0;
            while (true) {
                LivePkGuideBubbleTip[] livePkGuideBubbleTipArr2 = this.pkGuideBubbleTip;
                if (i29 >= livePkGuideBubbleTipArr2.length) {
                    break;
                }
                LivePkGuideBubbleTip livePkGuideBubbleTip = livePkGuideBubbleTipArr2[i29];
                if (livePkGuideBubbleTip != null) {
                    iComputeMessageSize28 += CodedOutputByteBufferNano.computeMessageSize(29, livePkGuideBubbleTip);
                }
                i29++;
            }
            iComputeSerializedSize = iComputeMessageSize28;
        }
        LiveActivitySignalMessage.LiveActivityPopUpInfo[] liveActivityPopUpInfoArr = this.activityPopUpInfo;
        if (liveActivityPopUpInfoArr != null && liveActivityPopUpInfoArr.length > 0) {
            int iComputeMessageSize29 = iComputeSerializedSize;
            int i30 = 0;
            while (true) {
                LiveActivitySignalMessage.LiveActivityPopUpInfo[] liveActivityPopUpInfoArr2 = this.activityPopUpInfo;
                if (i30 >= liveActivityPopUpInfoArr2.length) {
                    break;
                }
                LiveActivitySignalMessage.LiveActivityPopUpInfo liveActivityPopUpInfo = liveActivityPopUpInfoArr2[i30];
                if (liveActivityPopUpInfo != null) {
                    iComputeMessageSize29 += CodedOutputByteBufferNano.computeMessageSize(30, liveActivityPopUpInfo);
                }
                i30++;
            }
            iComputeSerializedSize = iComputeMessageSize29;
        }
        LiveFansTopBoostFollowFeed[] liveFansTopBoostFollowFeedArr = this.fansTopBoostFollowFeed;
        if (liveFansTopBoostFollowFeedArr != null && liveFansTopBoostFollowFeedArr.length > 0) {
            int iComputeMessageSize30 = iComputeSerializedSize;
            int i31 = 0;
            while (true) {
                LiveFansTopBoostFollowFeed[] liveFansTopBoostFollowFeedArr2 = this.fansTopBoostFollowFeed;
                if (i31 >= liveFansTopBoostFollowFeedArr2.length) {
                    break;
                }
                LiveFansTopBoostFollowFeed liveFansTopBoostFollowFeed = liveFansTopBoostFollowFeedArr2[i31];
                if (liveFansTopBoostFollowFeed != null) {
                    iComputeMessageSize30 += CodedOutputByteBufferNano.computeMessageSize(31, liveFansTopBoostFollowFeed);
                }
                i31++;
            }
            iComputeSerializedSize = iComputeMessageSize30;
        }
        LiveCommonEffectInfo[] liveCommonEffectInfoArr = this.effectInfo;
        if (liveCommonEffectInfoArr != null && liveCommonEffectInfoArr.length > 0) {
            int iComputeMessageSize31 = iComputeSerializedSize;
            int i32 = 0;
            while (true) {
                LiveCommonEffectInfo[] liveCommonEffectInfoArr2 = this.effectInfo;
                if (i32 >= liveCommonEffectInfoArr2.length) {
                    break;
                }
                LiveCommonEffectInfo liveCommonEffectInfo = liveCommonEffectInfoArr2[i32];
                if (liveCommonEffectInfo != null) {
                    iComputeMessageSize31 += CodedOutputByteBufferNano.computeMessageSize(32, liveCommonEffectInfo);
                }
                i32++;
            }
            iComputeSerializedSize = iComputeMessageSize31;
        }
        LiveGuardNotice[] liveGuardNoticeArr = this.liveGuardNotice;
        if (liveGuardNoticeArr != null && liveGuardNoticeArr.length > 0) {
            int iComputeMessageSize32 = iComputeSerializedSize;
            int i33 = 0;
            while (true) {
                LiveGuardNotice[] liveGuardNoticeArr2 = this.liveGuardNotice;
                if (i33 >= liveGuardNoticeArr2.length) {
                    break;
                }
                LiveGuardNotice liveGuardNotice = liveGuardNoticeArr2[i33];
                if (liveGuardNotice != null) {
                    iComputeMessageSize32 += CodedOutputByteBufferNano.computeMessageSize(33, liveGuardNotice);
                }
                i33++;
            }
            iComputeSerializedSize = iComputeMessageSize32;
        }
        GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNoticeArr = this.gzoneInteractiveCommentNotice;
        if (gzoneInteractiveCommentNoticeArr != null && gzoneInteractiveCommentNoticeArr.length > 0) {
            int iComputeMessageSize33 = iComputeSerializedSize;
            int i34 = 0;
            while (true) {
                GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNoticeArr2 = this.gzoneInteractiveCommentNotice;
                if (i34 >= gzoneInteractiveCommentNoticeArr2.length) {
                    break;
                }
                GzoneInteractiveCommentNotice gzoneInteractiveCommentNotice = gzoneInteractiveCommentNoticeArr2[i34];
                if (gzoneInteractiveCommentNotice != null) {
                    iComputeMessageSize33 += CodedOutputByteBufferNano.computeMessageSize(34, gzoneInteractiveCommentNotice);
                }
                i34++;
            }
            iComputeSerializedSize = iComputeMessageSize33;
        }
        LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeed;
        if (richTextFeedArr != null && richTextFeedArr.length > 0) {
            int iComputeMessageSize34 = iComputeSerializedSize;
            int i35 = 0;
            while (true) {
                LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = this.richTextFeed;
                if (i35 >= richTextFeedArr2.length) {
                    break;
                }
                LiveStreamRichTextFeed.RichTextFeed richTextFeed = richTextFeedArr2[i35];
                if (richTextFeed != null) {
                    iComputeMessageSize34 += CodedOutputByteBufferNano.computeMessageSize(35, richTextFeed);
                }
                i35++;
            }
            iComputeSerializedSize = iComputeMessageSize34;
        }
        GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNoticeArr = this.gzoneAuthorTaskProgressNotice;
        if (gzoneAuthorTaskProgressNoticeArr != null && gzoneAuthorTaskProgressNoticeArr.length > 0) {
            int iComputeMessageSize35 = iComputeSerializedSize;
            int i36 = 0;
            while (true) {
                GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNoticeArr2 = this.gzoneAuthorTaskProgressNotice;
                if (i36 >= gzoneAuthorTaskProgressNoticeArr2.length) {
                    break;
                }
                GzoneAuthorTaskProgressNotice gzoneAuthorTaskProgressNotice = gzoneAuthorTaskProgressNoticeArr2[i36];
                if (gzoneAuthorTaskProgressNotice != null) {
                    iComputeMessageSize35 += CodedOutputByteBufferNano.computeMessageSize(36, gzoneAuthorTaskProgressNotice);
                }
                i36++;
            }
            iComputeSerializedSize = iComputeMessageSize35;
        }
        GzoneAuthorCommonNotice[] gzoneAuthorCommonNoticeArr = this.gzoneAuthorCommonNotice;
        if (gzoneAuthorCommonNoticeArr != null && gzoneAuthorCommonNoticeArr.length > 0) {
            int iComputeMessageSize36 = iComputeSerializedSize;
            int i37 = 0;
            while (true) {
                GzoneAuthorCommonNotice[] gzoneAuthorCommonNoticeArr2 = this.gzoneAuthorCommonNotice;
                if (i37 >= gzoneAuthorCommonNoticeArr2.length) {
                    break;
                }
                GzoneAuthorCommonNotice gzoneAuthorCommonNotice = gzoneAuthorCommonNoticeArr2[i37];
                if (gzoneAuthorCommonNotice != null) {
                    iComputeMessageSize36 += CodedOutputByteBufferNano.computeMessageSize(37, gzoneAuthorCommonNotice);
                }
                i37++;
            }
            iComputeSerializedSize = iComputeMessageSize36;
        }
        LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNoticeArr = this.liveHappyPlayOpenResultNotice;
        if (liveHappyPlayOpenResultNoticeArr != null && liveHappyPlayOpenResultNoticeArr.length > 0) {
            int iComputeMessageSize37 = iComputeSerializedSize;
            int i38 = 0;
            while (true) {
                LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNoticeArr2 = this.liveHappyPlayOpenResultNotice;
                if (i38 >= liveHappyPlayOpenResultNoticeArr2.length) {
                    break;
                }
                LiveHappyPlayOpenResultNotice liveHappyPlayOpenResultNotice = liveHappyPlayOpenResultNoticeArr2[i38];
                if (liveHappyPlayOpenResultNotice != null) {
                    iComputeMessageSize37 += CodedOutputByteBufferNano.computeMessageSize(38, liveHappyPlayOpenResultNotice);
                }
                i38++;
            }
            iComputeSerializedSize = iComputeMessageSize37;
        }
        LiveCommonRoute[] liveCommonRouteArr = this.liveCommonRoute;
        if (liveCommonRouteArr != null && liveCommonRouteArr.length > 0) {
            int iComputeMessageSize38 = iComputeSerializedSize;
            int i39 = 0;
            while (true) {
                LiveCommonRoute[] liveCommonRouteArr2 = this.liveCommonRoute;
                if (i39 >= liveCommonRouteArr2.length) {
                    break;
                }
                LiveCommonRoute liveCommonRoute = liveCommonRouteArr2[i39];
                if (liveCommonRoute != null) {
                    iComputeMessageSize38 += CodedOutputByteBufferNano.computeMessageSize(39, liveCommonRoute);
                }
                i39++;
            }
            iComputeSerializedSize = iComputeMessageSize38;
        }
        LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeedArr = this.liveWatchingListChangeNoticeFeed;
        if (liveWatchingListChangeNoticeFeedArr != null && liveWatchingListChangeNoticeFeedArr.length > 0) {
            int iComputeMessageSize39 = iComputeSerializedSize;
            int i40 = 0;
            while (true) {
                LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeedArr2 = this.liveWatchingListChangeNoticeFeed;
                if (i40 >= liveWatchingListChangeNoticeFeedArr2.length) {
                    break;
                }
                LiveWatchingListChangeNoticeFeed liveWatchingListChangeNoticeFeed = liveWatchingListChangeNoticeFeedArr2[i40];
                if (liveWatchingListChangeNoticeFeed != null) {
                    iComputeMessageSize39 += CodedOutputByteBufferNano.computeMessageSize(40, liveWatchingListChangeNoticeFeed);
                }
                i40++;
            }
            iComputeSerializedSize = iComputeMessageSize39;
        }
        GzoneCommonFeed[] gzoneCommonFeedArr = this.gzoneCommonFeed;
        if (gzoneCommonFeedArr != null && gzoneCommonFeedArr.length > 0) {
            int iComputeMessageSize40 = iComputeSerializedSize;
            int i41 = 0;
            while (true) {
                GzoneCommonFeed[] gzoneCommonFeedArr2 = this.gzoneCommonFeed;
                if (i41 >= gzoneCommonFeedArr2.length) {
                    break;
                }
                GzoneCommonFeed gzoneCommonFeed = gzoneCommonFeedArr2[i41];
                if (gzoneCommonFeed != null) {
                    iComputeMessageSize40 += CodedOutputByteBufferNano.computeMessageSize(41, gzoneCommonFeed);
                }
                i41++;
            }
            iComputeSerializedSize = iComputeMessageSize40;
        }
        LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopupArr = this.liveCommonPopup;
        if (liveCommonPopupArr != null && liveCommonPopupArr.length > 0) {
            int iComputeMessageSize41 = iComputeSerializedSize;
            int i42 = 0;
            while (true) {
                LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopupArr2 = this.liveCommonPopup;
                if (i42 >= liveCommonPopupArr2.length) {
                    break;
                }
                LiveCommonNoticeMessages.LiveCommonPopup liveCommonPopup = liveCommonPopupArr2[i42];
                if (liveCommonPopup != null) {
                    iComputeMessageSize41 += CodedOutputByteBufferNano.computeMessageSize(42, liveCommonPopup);
                }
                i42++;
            }
            iComputeSerializedSize = iComputeMessageSize41;
        }
        CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChangeArr = this.commodityCardComponentChange;
        if (commodityCardComponentChangeArr != null && commodityCardComponentChangeArr.length > 0) {
            int iComputeMessageSize42 = iComputeSerializedSize;
            int i43 = 0;
            while (true) {
                CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChangeArr2 = this.commodityCardComponentChange;
                if (i43 >= commodityCardComponentChangeArr2.length) {
                    break;
                }
                CommodityCardMessage.CommodityCardComponentChange commodityCardComponentChange = commodityCardComponentChangeArr2[i43];
                if (commodityCardComponentChange != null) {
                    iComputeMessageSize42 += CodedOutputByteBufferNano.computeMessageSize(43, commodityCardComponentChange);
                }
                i43++;
            }
            iComputeSerializedSize = iComputeMessageSize42;
        }
        CommodityCardMessage.CommodityCardChange[] commodityCardChangeArr = this.commodityCardChange;
        if (commodityCardChangeArr != null && commodityCardChangeArr.length > 0) {
            int iComputeMessageSize43 = iComputeSerializedSize;
            int i44 = 0;
            while (true) {
                CommodityCardMessage.CommodityCardChange[] commodityCardChangeArr2 = this.commodityCardChange;
                if (i44 >= commodityCardChangeArr2.length) {
                    break;
                }
                CommodityCardMessage.CommodityCardChange commodityCardChange = commodityCardChangeArr2[i44];
                if (commodityCardChange != null) {
                    iComputeMessageSize43 += CodedOutputByteBufferNano.computeMessageSize(44, commodityCardChange);
                }
                i44++;
            }
            iComputeSerializedSize = iComputeMessageSize43;
        }
        LiveCommonNoticeMessages.LiteTextNotice[] liteTextNoticeArr = this.textNotice;
        if (liteTextNoticeArr != null && liteTextNoticeArr.length > 0) {
            int iComputeMessageSize44 = iComputeSerializedSize;
            int i45 = 0;
            while (true) {
                LiveCommonNoticeMessages.LiteTextNotice[] liteTextNoticeArr2 = this.textNotice;
                if (i45 >= liteTextNoticeArr2.length) {
                    break;
                }
                LiveCommonNoticeMessages.LiteTextNotice liteTextNotice = liteTextNoticeArr2[i45];
                if (liteTextNotice != null) {
                    iComputeMessageSize44 += CodedOutputByteBufferNano.computeMessageSize(45, liteTextNotice);
                }
                i45++;
            }
            iComputeSerializedSize = iComputeMessageSize44;
        }
        LiveRoomSignalMessage.SCKwaishopLivePendant[] sCKwaishopLivePendantArr = this.shopLivePendant;
        if (sCKwaishopLivePendantArr != null && sCKwaishopLivePendantArr.length > 0) {
            int iComputeMessageSize45 = iComputeSerializedSize;
            int i46 = 0;
            while (true) {
                LiveRoomSignalMessage.SCKwaishopLivePendant[] sCKwaishopLivePendantArr2 = this.shopLivePendant;
                if (i46 >= sCKwaishopLivePendantArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.SCKwaishopLivePendant sCKwaishopLivePendant = sCKwaishopLivePendantArr2[i46];
                if (sCKwaishopLivePendant != null) {
                    iComputeMessageSize45 += CodedOutputByteBufferNano.computeMessageSize(46, sCKwaishopLivePendant);
                }
                i46++;
            }
            iComputeSerializedSize = iComputeMessageSize45;
        }
        LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveActionArr = this.marketingPushLiveAction;
        if (marketingPushLiveActionArr != null && marketingPushLiveActionArr.length > 0) {
            int iComputeMessageSize46 = iComputeSerializedSize;
            int i47 = 0;
            while (true) {
                LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveActionArr2 = this.marketingPushLiveAction;
                if (i47 >= marketingPushLiveActionArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.MarketingPushLiveAction marketingPushLiveAction = marketingPushLiveActionArr2[i47];
                if (marketingPushLiveAction != null) {
                    iComputeMessageSize46 += CodedOutputByteBufferNano.computeMessageSize(47, marketingPushLiveAction);
                }
                i47++;
            }
            iComputeSerializedSize = iComputeMessageSize46;
        }
        LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNoticeArr = this.liveRefreshAuthorStatusNotice;
        if (liveRefreshAuthorStatusNoticeArr != null && liveRefreshAuthorStatusNoticeArr.length > 0) {
            int iComputeMessageSize47 = iComputeSerializedSize;
            int i48 = 0;
            while (true) {
                LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNoticeArr2 = this.liveRefreshAuthorStatusNotice;
                if (i48 >= liveRefreshAuthorStatusNoticeArr2.length) {
                    break;
                }
                LiveRefreshAuthorStatusNotice liveRefreshAuthorStatusNotice = liveRefreshAuthorStatusNoticeArr2[i48];
                if (liveRefreshAuthorStatusNotice != null) {
                    iComputeMessageSize47 += CodedOutputByteBufferNano.computeMessageSize(48, liveRefreshAuthorStatusNotice);
                }
                i48++;
            }
            iComputeSerializedSize = iComputeMessageSize47;
        }
        LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] sCKwaishopLiveActivityPendantArr = this.shopLiveActivityPendant;
        if (sCKwaishopLiveActivityPendantArr != null && sCKwaishopLiveActivityPendantArr.length > 0) {
            int iComputeMessageSize48 = iComputeSerializedSize;
            int i49 = 0;
            while (true) {
                LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] sCKwaishopLiveActivityPendantArr2 = this.shopLiveActivityPendant;
                if (i49 >= sCKwaishopLiveActivityPendantArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.SCKwaishopLiveActivityPendant sCKwaishopLiveActivityPendant = sCKwaishopLiveActivityPendantArr2[i49];
                if (sCKwaishopLiveActivityPendant != null) {
                    iComputeMessageSize48 += CodedOutputByteBufferNano.computeMessageSize(49, sCKwaishopLiveActivityPendant);
                }
                i49++;
            }
            iComputeSerializedSize = iComputeMessageSize48;
        }
        LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] sCLiveBuyingNoticeSignalArr = this.liveBuyingNoticeSignal;
        if (sCLiveBuyingNoticeSignalArr != null && sCLiveBuyingNoticeSignalArr.length > 0) {
            int iComputeMessageSize49 = iComputeSerializedSize;
            int i50 = 0;
            while (true) {
                LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] sCLiveBuyingNoticeSignalArr2 = this.liveBuyingNoticeSignal;
                if (i50 >= sCLiveBuyingNoticeSignalArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.SCLiveBuyingNoticeSignal sCLiveBuyingNoticeSignal = sCLiveBuyingNoticeSignalArr2[i50];
                if (sCLiveBuyingNoticeSignal != null) {
                    iComputeMessageSize49 += CodedOutputByteBufferNano.computeMessageSize(50, sCLiveBuyingNoticeSignal);
                }
                i50++;
            }
            iComputeSerializedSize = iComputeMessageSize49;
        }
        PkBountyActivityResultInfo[] pkBountyActivityResultInfoArr = this.pkBountyActivityResultInfo;
        if (pkBountyActivityResultInfoArr != null && pkBountyActivityResultInfoArr.length > 0) {
            int iComputeMessageSize50 = iComputeSerializedSize;
            int i51 = 0;
            while (true) {
                PkBountyActivityResultInfo[] pkBountyActivityResultInfoArr2 = this.pkBountyActivityResultInfo;
                if (i51 >= pkBountyActivityResultInfoArr2.length) {
                    break;
                }
                PkBountyActivityResultInfo pkBountyActivityResultInfo = pkBountyActivityResultInfoArr2[i51];
                if (pkBountyActivityResultInfo != null) {
                    iComputeMessageSize50 += CodedOutputByteBufferNano.computeMessageSize(51, pkBountyActivityResultInfo);
                }
                i51++;
            }
            iComputeSerializedSize = iComputeMessageSize50;
        }
        SendGiftNotifyAnimation[] sendGiftNotifyAnimationArr = this.sendGiftNotifyAnimation;
        if (sendGiftNotifyAnimationArr != null && sendGiftNotifyAnimationArr.length > 0) {
            int iComputeMessageSize51 = iComputeSerializedSize;
            int i52 = 0;
            while (true) {
                SendGiftNotifyAnimation[] sendGiftNotifyAnimationArr2 = this.sendGiftNotifyAnimation;
                if (i52 >= sendGiftNotifyAnimationArr2.length) {
                    break;
                }
                SendGiftNotifyAnimation sendGiftNotifyAnimation = sendGiftNotifyAnimationArr2[i52];
                if (sendGiftNotifyAnimation != null) {
                    iComputeMessageSize51 += CodedOutputByteBufferNano.computeMessageSize(52, sendGiftNotifyAnimation);
                }
                i52++;
            }
            iComputeSerializedSize = iComputeMessageSize51;
        }
        HighFrequencyActionGuide[] highFrequencyActionGuideArr = this.highFrequencyActionGuide;
        if (highFrequencyActionGuideArr != null && highFrequencyActionGuideArr.length > 0) {
            int iComputeMessageSize52 = iComputeSerializedSize;
            int i53 = 0;
            while (true) {
                HighFrequencyActionGuide[] highFrequencyActionGuideArr2 = this.highFrequencyActionGuide;
                if (i53 >= highFrequencyActionGuideArr2.length) {
                    break;
                }
                HighFrequencyActionGuide highFrequencyActionGuide = highFrequencyActionGuideArr2[i53];
                if (highFrequencyActionGuide != null) {
                    iComputeMessageSize52 += CodedOutputByteBufferNano.computeMessageSize(53, highFrequencyActionGuide);
                }
                i53++;
            }
            iComputeSerializedSize = iComputeMessageSize52;
        }
        LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfoArr = this.liveCommonEffectRouteInfo;
        if (liveCommonEffectRouteInfoArr != null && liveCommonEffectRouteInfoArr.length > 0) {
            int iComputeMessageSize53 = iComputeSerializedSize;
            int i54 = 0;
            while (true) {
                LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfoArr2 = this.liveCommonEffectRouteInfo;
                if (i54 >= liveCommonEffectRouteInfoArr2.length) {
                    break;
                }
                LiveCommonEffectRouteInfo liveCommonEffectRouteInfo = liveCommonEffectRouteInfoArr2[i54];
                if (liveCommonEffectRouteInfo != null) {
                    iComputeMessageSize53 += CodedOutputByteBufferNano.computeMessageSize(54, liveCommonEffectRouteInfo);
                }
                i54++;
            }
            iComputeSerializedSize = iComputeMessageSize53;
        }
        LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] kwaishopLiveAskOnItemSignalArr = this.liveAskOnItem;
        if (kwaishopLiveAskOnItemSignalArr != null && kwaishopLiveAskOnItemSignalArr.length > 0) {
            int iComputeMessageSize54 = iComputeSerializedSize;
            int i55 = 0;
            while (true) {
                LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] kwaishopLiveAskOnItemSignalArr2 = this.liveAskOnItem;
                if (i55 >= kwaishopLiveAskOnItemSignalArr2.length) {
                    break;
                }
                LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal kwaishopLiveAskOnItemSignal = kwaishopLiveAskOnItemSignalArr2[i55];
                if (kwaishopLiveAskOnItemSignal != null) {
                    iComputeMessageSize54 += CodedOutputByteBufferNano.computeMessageSize(55, kwaishopLiveAskOnItemSignal);
                }
                i55++;
            }
            iComputeSerializedSize = iComputeMessageSize54;
        }
        LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfoArr = this.liveMultiMagicEffectInfo;
        if (liveMultiMagicEffectInfoArr != null && liveMultiMagicEffectInfoArr.length > 0) {
            int iComputeMessageSize55 = iComputeSerializedSize;
            int i56 = 0;
            while (true) {
                LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfoArr2 = this.liveMultiMagicEffectInfo;
                if (i56 >= liveMultiMagicEffectInfoArr2.length) {
                    break;
                }
                LiveMultiMagicEffectInfo liveMultiMagicEffectInfo = liveMultiMagicEffectInfoArr2[i56];
                if (liveMultiMagicEffectInfo != null) {
                    iComputeMessageSize55 += CodedOutputByteBufferNano.computeMessageSize(56, liveMultiMagicEffectInfo);
                }
                i56++;
            }
            iComputeSerializedSize = iComputeMessageSize55;
        }
        LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] sCLiveGuideFollowAuthorCardInfoArr = this.liveGuideFollowCardInfo;
        if (sCLiveGuideFollowAuthorCardInfoArr != null && sCLiveGuideFollowAuthorCardInfoArr.length > 0) {
            int iComputeMessageSize56 = iComputeSerializedSize;
            int i57 = 0;
            while (true) {
                LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] sCLiveGuideFollowAuthorCardInfoArr2 = this.liveGuideFollowCardInfo;
                if (i57 >= sCLiveGuideFollowAuthorCardInfoArr2.length) {
                    break;
                }
                LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo sCLiveGuideFollowAuthorCardInfo = sCLiveGuideFollowAuthorCardInfoArr2[i57];
                if (sCLiveGuideFollowAuthorCardInfo != null) {
                    iComputeMessageSize56 += CodedOutputByteBufferNano.computeMessageSize(57, sCLiveGuideFollowAuthorCardInfo);
                }
                i57++;
            }
            iComputeSerializedSize = iComputeMessageSize56;
        }
        LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffectsArr = this.liveVoicePartyMicSeatUserLevelUpEffect;
        if (liveVoicePartyMicSeatUserLevelUpEffectsArr != null && liveVoicePartyMicSeatUserLevelUpEffectsArr.length > 0) {
            int iComputeMessageSize57 = iComputeSerializedSize;
            int i58 = 0;
            while (true) {
                LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffectsArr2 = this.liveVoicePartyMicSeatUserLevelUpEffect;
                if (i58 >= liveVoicePartyMicSeatUserLevelUpEffectsArr2.length) {
                    break;
                }
                LiveVoicePartyMicSeatUserLevelUpEffects liveVoicePartyMicSeatUserLevelUpEffects = liveVoicePartyMicSeatUserLevelUpEffectsArr2[i58];
                if (liveVoicePartyMicSeatUserLevelUpEffects != null) {
                    iComputeMessageSize57 += CodedOutputByteBufferNano.computeMessageSize(58, liveVoicePartyMicSeatUserLevelUpEffects);
                }
                i58++;
            }
            iComputeSerializedSize = iComputeMessageSize57;
        }
        LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] sCLiveAuthorReinforceInfoArr = this.liveAuthorReinforceInfo;
        if (sCLiveAuthorReinforceInfoArr != null && sCLiveAuthorReinforceInfoArr.length > 0) {
            int iComputeMessageSize58 = iComputeSerializedSize;
            int i59 = 0;
            while (true) {
                LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] sCLiveAuthorReinforceInfoArr2 = this.liveAuthorReinforceInfo;
                if (i59 >= sCLiveAuthorReinforceInfoArr2.length) {
                    break;
                }
                LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo sCLiveAuthorReinforceInfo = sCLiveAuthorReinforceInfoArr2[i59];
                if (sCLiveAuthorReinforceInfo != null) {
                    iComputeMessageSize58 += CodedOutputByteBufferNano.computeMessageSize(59, sCLiveAuthorReinforceInfo);
                }
                i59++;
            }
            iComputeSerializedSize = iComputeMessageSize58;
        }
        TestActionSignalFeed[] testActionSignalFeedArr = this.testFeed;
        if (testActionSignalFeedArr != null && testActionSignalFeedArr.length > 0) {
            while (true) {
                TestActionSignalFeed[] testActionSignalFeedArr2 = this.testFeed;
                if (i >= testActionSignalFeedArr2.length) {
                    break;
                }
                TestActionSignalFeed testActionSignalFeed = testActionSignalFeedArr2[i];
                if (testActionSignalFeed != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(100, testActionSignalFeed);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCActionSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    KtvMusicOrderFeed[] ktvMusicOrderFeedArr = this.ktvMusicOrderFeed;
                    int length = ktvMusicOrderFeedArr == null ? 0 : ktvMusicOrderFeedArr.length;
                    KtvMusicOrderFeed[] ktvMusicOrderFeedArr2 = new KtvMusicOrderFeed[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.ktvMusicOrderFeed, 0, ktvMusicOrderFeedArr2, 0, length);
                    }
                    while (length < ktvMusicOrderFeedArr2.length - 1) {
                        ktvMusicOrderFeedArr2[length] = new KtvMusicOrderFeed();
                        codedInputByteBufferNano.readMessage(ktvMusicOrderFeedArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ktvMusicOrderFeedArr2[length] = new KtvMusicOrderFeed();
                    codedInputByteBufferNano.readMessage(ktvMusicOrderFeedArr2[length]);
                    this.ktvMusicOrderFeed = ktvMusicOrderFeedArr2;
                    break;
                case 18:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    FansGroupJoinFeed[] fansGroupJoinFeedArr = this.fansGroupJoinFeed;
                    int length2 = fansGroupJoinFeedArr == null ? 0 : fansGroupJoinFeedArr.length;
                    FansGroupJoinFeed[] fansGroupJoinFeedArr2 = new FansGroupJoinFeed[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.fansGroupJoinFeed, 0, fansGroupJoinFeedArr2, 0, length2);
                    }
                    while (length2 < fansGroupJoinFeedArr2.length - 1) {
                        fansGroupJoinFeedArr2[length2] = new FansGroupJoinFeed();
                        codedInputByteBufferNano.readMessage(fansGroupJoinFeedArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    fansGroupJoinFeedArr2[length2] = new FansGroupJoinFeed();
                    codedInputByteBufferNano.readMessage(fansGroupJoinFeedArr2[length2]);
                    this.fansGroupJoinFeed = fansGroupJoinFeedArr2;
                    break;
                case 26:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    TopBannerNoticeFeed[] topBannerNoticeFeedArr = this.topBannerNoticeFeed;
                    int length3 = topBannerNoticeFeedArr == null ? 0 : topBannerNoticeFeedArr.length;
                    TopBannerNoticeFeed[] topBannerNoticeFeedArr2 = new TopBannerNoticeFeed[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.topBannerNoticeFeed, 0, topBannerNoticeFeedArr2, 0, length3);
                    }
                    while (length3 < topBannerNoticeFeedArr2.length - 1) {
                        topBannerNoticeFeedArr2[length3] = new TopBannerNoticeFeed();
                        codedInputByteBufferNano.readMessage(topBannerNoticeFeedArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    topBannerNoticeFeedArr2[length3] = new TopBannerNoticeFeed();
                    codedInputByteBufferNano.readMessage(topBannerNoticeFeedArr2[length3]);
                    this.topBannerNoticeFeed = topBannerNoticeFeedArr2;
                    break;
                case 34:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    LiveVoicePartyToastFeed[] liveVoicePartyToastFeedArr = this.voicePartyToastFeed;
                    int length4 = liveVoicePartyToastFeedArr == null ? 0 : liveVoicePartyToastFeedArr.length;
                    LiveVoicePartyToastFeed[] liveVoicePartyToastFeedArr2 = new LiveVoicePartyToastFeed[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.voicePartyToastFeed, 0, liveVoicePartyToastFeedArr2, 0, length4);
                    }
                    while (length4 < liveVoicePartyToastFeedArr2.length - 1) {
                        liveVoicePartyToastFeedArr2[length4] = new LiveVoicePartyToastFeed();
                        codedInputByteBufferNano.readMessage(liveVoicePartyToastFeedArr2[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    liveVoicePartyToastFeedArr2[length4] = new LiveVoicePartyToastFeed();
                    codedInputByteBufferNano.readMessage(liveVoicePartyToastFeedArr2[length4]);
                    this.voicePartyToastFeed = liveVoicePartyToastFeedArr2;
                    break;
                case 42:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LivePetUpgradeFeed[] livePetUpgradeFeedArr = this.livePetUpgradeFeed;
                    int length5 = livePetUpgradeFeedArr == null ? 0 : livePetUpgradeFeedArr.length;
                    LivePetUpgradeFeed[] livePetUpgradeFeedArr2 = new LivePetUpgradeFeed[repeatedFieldArrayLength5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.livePetUpgradeFeed, 0, livePetUpgradeFeedArr2, 0, length5);
                    }
                    while (length5 < livePetUpgradeFeedArr2.length - 1) {
                        livePetUpgradeFeedArr2[length5] = new LivePetUpgradeFeed();
                        codedInputByteBufferNano.readMessage(livePetUpgradeFeedArr2[length5]);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    livePetUpgradeFeedArr2[length5] = new LivePetUpgradeFeed();
                    codedInputByteBufferNano.readMessage(livePetUpgradeFeedArr2[length5]);
                    this.livePetUpgradeFeed = livePetUpgradeFeedArr2;
                    break;
                case 50:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    TopDistrictRank[] topDistrictRankArr = this.topDistrictRank;
                    int length6 = topDistrictRankArr == null ? 0 : topDistrictRankArr.length;
                    TopDistrictRank[] topDistrictRankArr2 = new TopDistrictRank[repeatedFieldArrayLength6 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.topDistrictRank, 0, topDistrictRankArr2, 0, length6);
                    }
                    while (length6 < topDistrictRankArr2.length - 1) {
                        topDistrictRankArr2[length6] = new TopDistrictRank();
                        codedInputByteBufferNano.readMessage(topDistrictRankArr2[length6]);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    topDistrictRankArr2[length6] = new TopDistrictRank();
                    codedInputByteBufferNano.readMessage(topDistrictRankArr2[length6]);
                    this.topDistrictRank = topDistrictRankArr2;
                    break;
                case 58:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    LiveFollowGuide[] liveFollowGuideArr = this.liveFollowGuide;
                    int length7 = liveFollowGuideArr == null ? 0 : liveFollowGuideArr.length;
                    LiveFollowGuide[] liveFollowGuideArr2 = new LiveFollowGuide[repeatedFieldArrayLength7 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.liveFollowGuide, 0, liveFollowGuideArr2, 0, length7);
                    }
                    while (length7 < liveFollowGuideArr2.length - 1) {
                        liveFollowGuideArr2[length7] = new LiveFollowGuide();
                        codedInputByteBufferNano.readMessage(liveFollowGuideArr2[length7]);
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    liveFollowGuideArr2[length7] = new LiveFollowGuide();
                    codedInputByteBufferNano.readMessage(liveFollowGuideArr2[length7]);
                    this.liveFollowGuide = liveFollowGuideArr2;
                    break;
                case 66:
                    int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    VoicePartyEmojiFeed[] voicePartyEmojiFeedArr = this.voicePartyEmojiFeed;
                    int length8 = voicePartyEmojiFeedArr == null ? 0 : voicePartyEmojiFeedArr.length;
                    VoicePartyEmojiFeed[] voicePartyEmojiFeedArr2 = new VoicePartyEmojiFeed[repeatedFieldArrayLength8 + length8];
                    if (length8 != 0) {
                        System.arraycopy(this.voicePartyEmojiFeed, 0, voicePartyEmojiFeedArr2, 0, length8);
                    }
                    while (length8 < voicePartyEmojiFeedArr2.length - 1) {
                        voicePartyEmojiFeedArr2[length8] = new VoicePartyEmojiFeed();
                        codedInputByteBufferNano.readMessage(voicePartyEmojiFeedArr2[length8]);
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    voicePartyEmojiFeedArr2[length8] = new VoicePartyEmojiFeed();
                    codedInputByteBufferNano.readMessage(voicePartyEmojiFeedArr2[length8]);
                    this.voicePartyEmojiFeed = voicePartyEmojiFeedArr2;
                    break;
                case 74:
                    int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    LiveShopMessages.LiveShopAction[] liveShopActionArr = this.shopAction;
                    int length9 = liveShopActionArr == null ? 0 : liveShopActionArr.length;
                    LiveShopMessages.LiveShopAction[] liveShopActionArr2 = new LiveShopMessages.LiveShopAction[repeatedFieldArrayLength9 + length9];
                    if (length9 != 0) {
                        System.arraycopy(this.shopAction, 0, liveShopActionArr2, 0, length9);
                    }
                    while (length9 < liveShopActionArr2.length - 1) {
                        liveShopActionArr2[length9] = new LiveShopMessages.LiveShopAction();
                        codedInputByteBufferNano.readMessage(liveShopActionArr2[length9]);
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    liveShopActionArr2[length9] = new LiveShopMessages.LiveShopAction();
                    codedInputByteBufferNano.readMessage(liveShopActionArr2[length9]);
                    this.shopAction = liveShopActionArr2;
                    break;
                case 90:
                    int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    LiveUserClipLightGuide[] liveUserClipLightGuideArr = this.liveUserClipLightGuide;
                    int length10 = liveUserClipLightGuideArr == null ? 0 : liveUserClipLightGuideArr.length;
                    LiveUserClipLightGuide[] liveUserClipLightGuideArr2 = new LiveUserClipLightGuide[repeatedFieldArrayLength10 + length10];
                    if (length10 != 0) {
                        System.arraycopy(this.liveUserClipLightGuide, 0, liveUserClipLightGuideArr2, 0, length10);
                    }
                    while (length10 < liveUserClipLightGuideArr2.length - 1) {
                        liveUserClipLightGuideArr2[length10] = new LiveUserClipLightGuide();
                        codedInputByteBufferNano.readMessage(liveUserClipLightGuideArr2[length10]);
                        codedInputByteBufferNano.readTag();
                        length10++;
                    }
                    liveUserClipLightGuideArr2[length10] = new LiveUserClipLightGuide();
                    codedInputByteBufferNano.readMessage(liveUserClipLightGuideArr2[length10]);
                    this.liveUserClipLightGuide = liveUserClipLightGuideArr2;
                    break;
                case 98:
                    int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    LiveGamePopupFeed[] liveGamePopupFeedArr = this.liveGamePopupFeed;
                    int length11 = liveGamePopupFeedArr == null ? 0 : liveGamePopupFeedArr.length;
                    LiveGamePopupFeed[] liveGamePopupFeedArr2 = new LiveGamePopupFeed[repeatedFieldArrayLength11 + length11];
                    if (length11 != 0) {
                        System.arraycopy(this.liveGamePopupFeed, 0, liveGamePopupFeedArr2, 0, length11);
                    }
                    while (length11 < liveGamePopupFeedArr2.length - 1) {
                        liveGamePopupFeedArr2[length11] = new LiveGamePopupFeed();
                        codedInputByteBufferNano.readMessage(liveGamePopupFeedArr2[length11]);
                        codedInputByteBufferNano.readTag();
                        length11++;
                    }
                    liveGamePopupFeedArr2[length11] = new LiveGamePopupFeed();
                    codedInputByteBufferNano.readMessage(liveGamePopupFeedArr2[length11]);
                    this.liveGamePopupFeed = liveGamePopupFeedArr2;
                    break;
                case 106:
                    int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    RainbowCommentFeed[] rainbowCommentFeedArr = this.rainbowCommentFeed;
                    int length12 = rainbowCommentFeedArr == null ? 0 : rainbowCommentFeedArr.length;
                    RainbowCommentFeed[] rainbowCommentFeedArr2 = new RainbowCommentFeed[repeatedFieldArrayLength12 + length12];
                    if (length12 != 0) {
                        System.arraycopy(this.rainbowCommentFeed, 0, rainbowCommentFeedArr2, 0, length12);
                    }
                    while (length12 < rainbowCommentFeedArr2.length - 1) {
                        rainbowCommentFeedArr2[length12] = new RainbowCommentFeed();
                        codedInputByteBufferNano.readMessage(rainbowCommentFeedArr2[length12]);
                        codedInputByteBufferNano.readTag();
                        length12++;
                    }
                    rainbowCommentFeedArr2[length12] = new RainbowCommentFeed();
                    codedInputByteBufferNano.readMessage(rainbowCommentFeedArr2[length12]);
                    this.rainbowCommentFeed = rainbowCommentFeedArr2;
                    break;
                case 114:
                    int repeatedFieldArrayLength13 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    LiveExtraMessages.LiveCommonActionSignal[] liveCommonActionSignalArr = this.commerceCommonFeed;
                    int length13 = liveCommonActionSignalArr == null ? 0 : liveCommonActionSignalArr.length;
                    LiveExtraMessages.LiveCommonActionSignal[] liveCommonActionSignalArr2 = new LiveExtraMessages.LiveCommonActionSignal[repeatedFieldArrayLength13 + length13];
                    if (length13 != 0) {
                        System.arraycopy(this.commerceCommonFeed, 0, liveCommonActionSignalArr2, 0, length13);
                    }
                    while (length13 < liveCommonActionSignalArr2.length - 1) {
                        liveCommonActionSignalArr2[length13] = new LiveExtraMessages.LiveCommonActionSignal();
                        codedInputByteBufferNano.readMessage(liveCommonActionSignalArr2[length13]);
                        codedInputByteBufferNano.readTag();
                        length13++;
                    }
                    liveCommonActionSignalArr2[length13] = new LiveExtraMessages.LiveCommonActionSignal();
                    codedInputByteBufferNano.readMessage(liveCommonActionSignalArr2[length13]);
                    this.commerceCommonFeed = liveCommonActionSignalArr2;
                    break;
                case 122:
                    int repeatedFieldArrayLength14 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    GzoneCommentLotteryFeed[] gzoneCommentLotteryFeedArr = this.gzoneCommentLotteryFeed;
                    int length14 = gzoneCommentLotteryFeedArr == null ? 0 : gzoneCommentLotteryFeedArr.length;
                    GzoneCommentLotteryFeed[] gzoneCommentLotteryFeedArr2 = new GzoneCommentLotteryFeed[repeatedFieldArrayLength14 + length14];
                    if (length14 != 0) {
                        System.arraycopy(this.gzoneCommentLotteryFeed, 0, gzoneCommentLotteryFeedArr2, 0, length14);
                    }
                    while (length14 < gzoneCommentLotteryFeedArr2.length - 1) {
                        gzoneCommentLotteryFeedArr2[length14] = new GzoneCommentLotteryFeed();
                        codedInputByteBufferNano.readMessage(gzoneCommentLotteryFeedArr2[length14]);
                        codedInputByteBufferNano.readTag();
                        length14++;
                    }
                    gzoneCommentLotteryFeedArr2[length14] = new GzoneCommentLotteryFeed();
                    codedInputByteBufferNano.readMessage(gzoneCommentLotteryFeedArr2[length14]);
                    this.gzoneCommentLotteryFeed = gzoneCommentLotteryFeedArr2;
                    break;
                case 130:
                    int repeatedFieldArrayLength15 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    GzoneLiveRedDotFeed[] gzoneLiveRedDotFeedArr = this.gzoneLiveRedDotFeed;
                    int length15 = gzoneLiveRedDotFeedArr == null ? 0 : gzoneLiveRedDotFeedArr.length;
                    GzoneLiveRedDotFeed[] gzoneLiveRedDotFeedArr2 = new GzoneLiveRedDotFeed[repeatedFieldArrayLength15 + length15];
                    if (length15 != 0) {
                        System.arraycopy(this.gzoneLiveRedDotFeed, 0, gzoneLiveRedDotFeedArr2, 0, length15);
                    }
                    while (length15 < gzoneLiveRedDotFeedArr2.length - 1) {
                        gzoneLiveRedDotFeedArr2[length15] = new GzoneLiveRedDotFeed();
                        codedInputByteBufferNano.readMessage(gzoneLiveRedDotFeedArr2[length15]);
                        codedInputByteBufferNano.readTag();
                        length15++;
                    }
                    gzoneLiveRedDotFeedArr2[length15] = new GzoneLiveRedDotFeed();
                    codedInputByteBufferNano.readMessage(gzoneLiveRedDotFeedArr2[length15]);
                    this.gzoneLiveRedDotFeed = gzoneLiveRedDotFeedArr2;
                    break;
                case 138:
                    int repeatedFieldArrayLength16 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                    TeamPkFightMotion[] teamPkFightMotionArr = this.teamPkFightMotion;
                    int length16 = teamPkFightMotionArr == null ? 0 : teamPkFightMotionArr.length;
                    TeamPkFightMotion[] teamPkFightMotionArr2 = new TeamPkFightMotion[repeatedFieldArrayLength16 + length16];
                    if (length16 != 0) {
                        System.arraycopy(this.teamPkFightMotion, 0, teamPkFightMotionArr2, 0, length16);
                    }
                    while (length16 < teamPkFightMotionArr2.length - 1) {
                        teamPkFightMotionArr2[length16] = new TeamPkFightMotion();
                        codedInputByteBufferNano.readMessage(teamPkFightMotionArr2[length16]);
                        codedInputByteBufferNano.readTag();
                        length16++;
                    }
                    teamPkFightMotionArr2[length16] = new TeamPkFightMotion();
                    codedInputByteBufferNano.readMessage(teamPkFightMotionArr2[length16]);
                    this.teamPkFightMotion = teamPkFightMotionArr2;
                    break;
                case 146:
                    int repeatedFieldArrayLength17 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                    WealthHighGradeEnterRoom[] wealthHighGradeEnterRoomArr = this.wealthHighGradeEnterRoom;
                    int length17 = wealthHighGradeEnterRoomArr == null ? 0 : wealthHighGradeEnterRoomArr.length;
                    WealthHighGradeEnterRoom[] wealthHighGradeEnterRoomArr2 = new WealthHighGradeEnterRoom[repeatedFieldArrayLength17 + length17];
                    if (length17 != 0) {
                        System.arraycopy(this.wealthHighGradeEnterRoom, 0, wealthHighGradeEnterRoomArr2, 0, length17);
                    }
                    while (length17 < wealthHighGradeEnterRoomArr2.length - 1) {
                        wealthHighGradeEnterRoomArr2[length17] = new WealthHighGradeEnterRoom();
                        codedInputByteBufferNano.readMessage(wealthHighGradeEnterRoomArr2[length17]);
                        codedInputByteBufferNano.readTag();
                        length17++;
                    }
                    wealthHighGradeEnterRoomArr2[length17] = new WealthHighGradeEnterRoom();
                    codedInputByteBufferNano.readMessage(wealthHighGradeEnterRoomArr2[length17]);
                    this.wealthHighGradeEnterRoom = wealthHighGradeEnterRoomArr2;
                    break;
                case 154:
                    int repeatedFieldArrayLength18 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    LiveFansTopOrderHelpBuyFeed[] liveFansTopOrderHelpBuyFeedArr = this.fansTopOrderHelpBuy;
                    int length18 = liveFansTopOrderHelpBuyFeedArr == null ? 0 : liveFansTopOrderHelpBuyFeedArr.length;
                    LiveFansTopOrderHelpBuyFeed[] liveFansTopOrderHelpBuyFeedArr2 = new LiveFansTopOrderHelpBuyFeed[repeatedFieldArrayLength18 + length18];
                    if (length18 != 0) {
                        System.arraycopy(this.fansTopOrderHelpBuy, 0, liveFansTopOrderHelpBuyFeedArr2, 0, length18);
                    }
                    while (length18 < liveFansTopOrderHelpBuyFeedArr2.length - 1) {
                        liveFansTopOrderHelpBuyFeedArr2[length18] = new LiveFansTopOrderHelpBuyFeed();
                        codedInputByteBufferNano.readMessage(liveFansTopOrderHelpBuyFeedArr2[length18]);
                        codedInputByteBufferNano.readTag();
                        length18++;
                    }
                    liveFansTopOrderHelpBuyFeedArr2[length18] = new LiveFansTopOrderHelpBuyFeed();
                    codedInputByteBufferNano.readMessage(liveFansTopOrderHelpBuyFeedArr2[length18]);
                    this.fansTopOrderHelpBuy = liveFansTopOrderHelpBuyFeedArr2;
                    break;
                case 162:
                    int repeatedFieldArrayLength19 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    WealthHighGradeBulletComment[] wealthHighGradeBulletCommentArr = this.highGradeBulletComment;
                    int length19 = wealthHighGradeBulletCommentArr == null ? 0 : wealthHighGradeBulletCommentArr.length;
                    WealthHighGradeBulletComment[] wealthHighGradeBulletCommentArr2 = new WealthHighGradeBulletComment[repeatedFieldArrayLength19 + length19];
                    if (length19 != 0) {
                        System.arraycopy(this.highGradeBulletComment, 0, wealthHighGradeBulletCommentArr2, 0, length19);
                    }
                    while (length19 < wealthHighGradeBulletCommentArr2.length - 1) {
                        wealthHighGradeBulletCommentArr2[length19] = new WealthHighGradeBulletComment();
                        codedInputByteBufferNano.readMessage(wealthHighGradeBulletCommentArr2[length19]);
                        codedInputByteBufferNano.readTag();
                        length19++;
                    }
                    wealthHighGradeBulletCommentArr2[length19] = new WealthHighGradeBulletComment();
                    codedInputByteBufferNano.readMessage(wealthHighGradeBulletCommentArr2[length19]);
                    this.highGradeBulletComment = wealthHighGradeBulletCommentArr2;
                    break;
                case 170:
                    int repeatedFieldArrayLength20 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeedArr = this.gzoneLiveBuffCardFeed;
                    int length20 = gzoneLiveBuffCardFeedArr == null ? 0 : gzoneLiveBuffCardFeedArr.length;
                    GzoneLiveBuffCardFeed[] gzoneLiveBuffCardFeedArr2 = new GzoneLiveBuffCardFeed[repeatedFieldArrayLength20 + length20];
                    if (length20 != 0) {
                        System.arraycopy(this.gzoneLiveBuffCardFeed, 0, gzoneLiveBuffCardFeedArr2, 0, length20);
                    }
                    while (length20 < gzoneLiveBuffCardFeedArr2.length - 1) {
                        gzoneLiveBuffCardFeedArr2[length20] = new GzoneLiveBuffCardFeed();
                        codedInputByteBufferNano.readMessage(gzoneLiveBuffCardFeedArr2[length20]);
                        codedInputByteBufferNano.readTag();
                        length20++;
                    }
                    gzoneLiveBuffCardFeedArr2[length20] = new GzoneLiveBuffCardFeed();
                    codedInputByteBufferNano.readMessage(gzoneLiveBuffCardFeedArr2[length20]);
                    this.gzoneLiveBuffCardFeed = gzoneLiveBuffCardFeedArr2;
                    break;
                case 178:
                    int repeatedFieldArrayLength21 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                    LiveActivityPopup[] liveActivityPopupArr = this.activityPopup;
                    int length21 = liveActivityPopupArr == null ? 0 : liveActivityPopupArr.length;
                    LiveActivityPopup[] liveActivityPopupArr2 = new LiveActivityPopup[repeatedFieldArrayLength21 + length21];
                    if (length21 != 0) {
                        System.arraycopy(this.activityPopup, 0, liveActivityPopupArr2, 0, length21);
                    }
                    while (length21 < liveActivityPopupArr2.length - 1) {
                        liveActivityPopupArr2[length21] = new LiveActivityPopup();
                        codedInputByteBufferNano.readMessage(liveActivityPopupArr2[length21]);
                        codedInputByteBufferNano.readTag();
                        length21++;
                    }
                    liveActivityPopupArr2[length21] = new LiveActivityPopup();
                    codedInputByteBufferNano.readMessage(liveActivityPopupArr2[length21]);
                    this.activityPopup = liveActivityPopupArr2;
                    break;
                case 186:
                    int repeatedFieldArrayLength22 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoomArr = this.valentineHighScoreEnterRoom;
                    int length22 = valentineHighScoreEnterRoomArr == null ? 0 : valentineHighScoreEnterRoomArr.length;
                    ValentineHighScoreEnterRoom[] valentineHighScoreEnterRoomArr2 = new ValentineHighScoreEnterRoom[repeatedFieldArrayLength22 + length22];
                    if (length22 != 0) {
                        System.arraycopy(this.valentineHighScoreEnterRoom, 0, valentineHighScoreEnterRoomArr2, 0, length22);
                    }
                    while (length22 < valentineHighScoreEnterRoomArr2.length - 1) {
                        valentineHighScoreEnterRoomArr2[length22] = new ValentineHighScoreEnterRoom();
                        codedInputByteBufferNano.readMessage(valentineHighScoreEnterRoomArr2[length22]);
                        codedInputByteBufferNano.readTag();
                        length22++;
                    }
                    valentineHighScoreEnterRoomArr2[length22] = new ValentineHighScoreEnterRoom();
                    codedInputByteBufferNano.readMessage(valentineHighScoreEnterRoomArr2[length22]);
                    this.valentineHighScoreEnterRoom = valentineHighScoreEnterRoomArr2;
                    break;
                case 194:
                    int repeatedFieldArrayLength23 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 194);
                    LivePkFirstBlood[] livePkFirstBloodArr = this.livePkFirstBlood;
                    int length23 = livePkFirstBloodArr == null ? 0 : livePkFirstBloodArr.length;
                    LivePkFirstBlood[] livePkFirstBloodArr2 = new LivePkFirstBlood[repeatedFieldArrayLength23 + length23];
                    if (length23 != 0) {
                        System.arraycopy(this.livePkFirstBlood, 0, livePkFirstBloodArr2, 0, length23);
                    }
                    while (length23 < livePkFirstBloodArr2.length - 1) {
                        livePkFirstBloodArr2[length23] = new LivePkFirstBlood();
                        codedInputByteBufferNano.readMessage(livePkFirstBloodArr2[length23]);
                        codedInputByteBufferNano.readTag();
                        length23++;
                    }
                    livePkFirstBloodArr2[length23] = new LivePkFirstBlood();
                    codedInputByteBufferNano.readMessage(livePkFirstBloodArr2[length23]);
                    this.livePkFirstBlood = livePkFirstBloodArr2;
                    break;
                case 202:
                    int repeatedFieldArrayLength24 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 202);
                    LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoomArr = this.liveDragonBoatEnterRoom;
                    int length24 = liveDragonBoatEnterRoomArr == null ? 0 : liveDragonBoatEnterRoomArr.length;
                    LiveDragonBoatEnterRoom[] liveDragonBoatEnterRoomArr2 = new LiveDragonBoatEnterRoom[repeatedFieldArrayLength24 + length24];
                    if (length24 != 0) {
                        System.arraycopy(this.liveDragonBoatEnterRoom, 0, liveDragonBoatEnterRoomArr2, 0, length24);
                    }
                    while (length24 < liveDragonBoatEnterRoomArr2.length - 1) {
                        liveDragonBoatEnterRoomArr2[length24] = new LiveDragonBoatEnterRoom();
                        codedInputByteBufferNano.readMessage(liveDragonBoatEnterRoomArr2[length24]);
                        codedInputByteBufferNano.readTag();
                        length24++;
                    }
                    liveDragonBoatEnterRoomArr2[length24] = new LiveDragonBoatEnterRoom();
                    codedInputByteBufferNano.readMessage(liveDragonBoatEnterRoomArr2[length24]);
                    this.liveDragonBoatEnterRoom = liveDragonBoatEnterRoomArr2;
                    break;
                case 210:
                    int repeatedFieldArrayLength25 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 210);
                    LiveRedPackSendInfo[] liveRedPackSendInfoArr = this.redPackSendInfo;
                    int length25 = liveRedPackSendInfoArr == null ? 0 : liveRedPackSendInfoArr.length;
                    LiveRedPackSendInfo[] liveRedPackSendInfoArr2 = new LiveRedPackSendInfo[repeatedFieldArrayLength25 + length25];
                    if (length25 != 0) {
                        System.arraycopy(this.redPackSendInfo, 0, liveRedPackSendInfoArr2, 0, length25);
                    }
                    while (length25 < liveRedPackSendInfoArr2.length - 1) {
                        liveRedPackSendInfoArr2[length25] = new LiveRedPackSendInfo();
                        codedInputByteBufferNano.readMessage(liveRedPackSendInfoArr2[length25]);
                        codedInputByteBufferNano.readTag();
                        length25++;
                    }
                    liveRedPackSendInfoArr2[length25] = new LiveRedPackSendInfo();
                    codedInputByteBufferNano.readMessage(liveRedPackSendInfoArr2[length25]);
                    this.redPackSendInfo = liveRedPackSendInfoArr2;
                    break;
                case 218:
                    int repeatedFieldArrayLength26 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 218);
                    LiveRedPackGrabInfo[] liveRedPackGrabInfoArr = this.redPackGrabInfo;
                    int length26 = liveRedPackGrabInfoArr == null ? 0 : liveRedPackGrabInfoArr.length;
                    LiveRedPackGrabInfo[] liveRedPackGrabInfoArr2 = new LiveRedPackGrabInfo[repeatedFieldArrayLength26 + length26];
                    if (length26 != 0) {
                        System.arraycopy(this.redPackGrabInfo, 0, liveRedPackGrabInfoArr2, 0, length26);
                    }
                    while (length26 < liveRedPackGrabInfoArr2.length - 1) {
                        liveRedPackGrabInfoArr2[length26] = new LiveRedPackGrabInfo();
                        codedInputByteBufferNano.readMessage(liveRedPackGrabInfoArr2[length26]);
                        codedInputByteBufferNano.readTag();
                        length26++;
                    }
                    liveRedPackGrabInfoArr2[length26] = new LiveRedPackGrabInfo();
                    codedInputByteBufferNano.readMessage(liveRedPackGrabInfoArr2[length26]);
                    this.redPackGrabInfo = liveRedPackGrabInfoArr2;
                    break;
                case 226:
                    int repeatedFieldArrayLength27 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 226);
                    LiveActivityEnterRoomTip[] liveActivityEnterRoomTipArr = this.liveActivityEnterRoomTip;
                    int length27 = liveActivityEnterRoomTipArr == null ? 0 : liveActivityEnterRoomTipArr.length;
                    LiveActivityEnterRoomTip[] liveActivityEnterRoomTipArr2 = new LiveActivityEnterRoomTip[repeatedFieldArrayLength27 + length27];
                    if (length27 != 0) {
                        System.arraycopy(this.liveActivityEnterRoomTip, 0, liveActivityEnterRoomTipArr2, 0, length27);
                    }
                    while (length27 < liveActivityEnterRoomTipArr2.length - 1) {
                        liveActivityEnterRoomTipArr2[length27] = new LiveActivityEnterRoomTip();
                        codedInputByteBufferNano.readMessage(liveActivityEnterRoomTipArr2[length27]);
                        codedInputByteBufferNano.readTag();
                        length27++;
                    }
                    liveActivityEnterRoomTipArr2[length27] = new LiveActivityEnterRoomTip();
                    codedInputByteBufferNano.readMessage(liveActivityEnterRoomTipArr2[length27]);
                    this.liveActivityEnterRoomTip = liveActivityEnterRoomTipArr2;
                    break;
                case 234:
                    int repeatedFieldArrayLength28 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 234);
                    LivePkGuideBubbleTip[] livePkGuideBubbleTipArr = this.pkGuideBubbleTip;
                    int length28 = livePkGuideBubbleTipArr == null ? 0 : livePkGuideBubbleTipArr.length;
                    LivePkGuideBubbleTip[] livePkGuideBubbleTipArr2 = new LivePkGuideBubbleTip[repeatedFieldArrayLength28 + length28];
                    if (length28 != 0) {
                        System.arraycopy(this.pkGuideBubbleTip, 0, livePkGuideBubbleTipArr2, 0, length28);
                    }
                    while (length28 < livePkGuideBubbleTipArr2.length - 1) {
                        livePkGuideBubbleTipArr2[length28] = new LivePkGuideBubbleTip();
                        codedInputByteBufferNano.readMessage(livePkGuideBubbleTipArr2[length28]);
                        codedInputByteBufferNano.readTag();
                        length28++;
                    }
                    livePkGuideBubbleTipArr2[length28] = new LivePkGuideBubbleTip();
                    codedInputByteBufferNano.readMessage(livePkGuideBubbleTipArr2[length28]);
                    this.pkGuideBubbleTip = livePkGuideBubbleTipArr2;
                    break;
                case 242:
                    int repeatedFieldArrayLength29 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 242);
                    LiveActivitySignalMessage.LiveActivityPopUpInfo[] liveActivityPopUpInfoArr = this.activityPopUpInfo;
                    int length29 = liveActivityPopUpInfoArr == null ? 0 : liveActivityPopUpInfoArr.length;
                    LiveActivitySignalMessage.LiveActivityPopUpInfo[] liveActivityPopUpInfoArr2 = new LiveActivitySignalMessage.LiveActivityPopUpInfo[repeatedFieldArrayLength29 + length29];
                    if (length29 != 0) {
                        System.arraycopy(this.activityPopUpInfo, 0, liveActivityPopUpInfoArr2, 0, length29);
                    }
                    while (length29 < liveActivityPopUpInfoArr2.length - 1) {
                        liveActivityPopUpInfoArr2[length29] = new LiveActivitySignalMessage.LiveActivityPopUpInfo();
                        codedInputByteBufferNano.readMessage(liveActivityPopUpInfoArr2[length29]);
                        codedInputByteBufferNano.readTag();
                        length29++;
                    }
                    liveActivityPopUpInfoArr2[length29] = new LiveActivitySignalMessage.LiveActivityPopUpInfo();
                    codedInputByteBufferNano.readMessage(liveActivityPopUpInfoArr2[length29]);
                    this.activityPopUpInfo = liveActivityPopUpInfoArr2;
                    break;
                case 250:
                    int repeatedFieldArrayLength30 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 250);
                    LiveFansTopBoostFollowFeed[] liveFansTopBoostFollowFeedArr = this.fansTopBoostFollowFeed;
                    int length30 = liveFansTopBoostFollowFeedArr == null ? 0 : liveFansTopBoostFollowFeedArr.length;
                    LiveFansTopBoostFollowFeed[] liveFansTopBoostFollowFeedArr2 = new LiveFansTopBoostFollowFeed[repeatedFieldArrayLength30 + length30];
                    if (length30 != 0) {
                        System.arraycopy(this.fansTopBoostFollowFeed, 0, liveFansTopBoostFollowFeedArr2, 0, length30);
                    }
                    while (length30 < liveFansTopBoostFollowFeedArr2.length - 1) {
                        liveFansTopBoostFollowFeedArr2[length30] = new LiveFansTopBoostFollowFeed();
                        codedInputByteBufferNano.readMessage(liveFansTopBoostFollowFeedArr2[length30]);
                        codedInputByteBufferNano.readTag();
                        length30++;
                    }
                    liveFansTopBoostFollowFeedArr2[length30] = new LiveFansTopBoostFollowFeed();
                    codedInputByteBufferNano.readMessage(liveFansTopBoostFollowFeedArr2[length30]);
                    this.fansTopBoostFollowFeed = liveFansTopBoostFollowFeedArr2;
                    break;
                case 258:
                    int repeatedFieldArrayLength31 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 258);
                    LiveCommonEffectInfo[] liveCommonEffectInfoArr = this.effectInfo;
                    int length31 = liveCommonEffectInfoArr == null ? 0 : liveCommonEffectInfoArr.length;
                    LiveCommonEffectInfo[] liveCommonEffectInfoArr2 = new LiveCommonEffectInfo[repeatedFieldArrayLength31 + length31];
                    if (length31 != 0) {
                        System.arraycopy(this.effectInfo, 0, liveCommonEffectInfoArr2, 0, length31);
                    }
                    while (length31 < liveCommonEffectInfoArr2.length - 1) {
                        liveCommonEffectInfoArr2[length31] = new LiveCommonEffectInfo();
                        codedInputByteBufferNano.readMessage(liveCommonEffectInfoArr2[length31]);
                        codedInputByteBufferNano.readTag();
                        length31++;
                    }
                    liveCommonEffectInfoArr2[length31] = new LiveCommonEffectInfo();
                    codedInputByteBufferNano.readMessage(liveCommonEffectInfoArr2[length31]);
                    this.effectInfo = liveCommonEffectInfoArr2;
                    break;
                case 266:
                    int repeatedFieldArrayLength32 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 266);
                    LiveGuardNotice[] liveGuardNoticeArr = this.liveGuardNotice;
                    int length32 = liveGuardNoticeArr == null ? 0 : liveGuardNoticeArr.length;
                    LiveGuardNotice[] liveGuardNoticeArr2 = new LiveGuardNotice[repeatedFieldArrayLength32 + length32];
                    if (length32 != 0) {
                        System.arraycopy(this.liveGuardNotice, 0, liveGuardNoticeArr2, 0, length32);
                    }
                    while (length32 < liveGuardNoticeArr2.length - 1) {
                        liveGuardNoticeArr2[length32] = new LiveGuardNotice();
                        codedInputByteBufferNano.readMessage(liveGuardNoticeArr2[length32]);
                        codedInputByteBufferNano.readTag();
                        length32++;
                    }
                    liveGuardNoticeArr2[length32] = new LiveGuardNotice();
                    codedInputByteBufferNano.readMessage(liveGuardNoticeArr2[length32]);
                    this.liveGuardNotice = liveGuardNoticeArr2;
                    break;
                case 274:
                    int repeatedFieldArrayLength33 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 274);
                    GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNoticeArr = this.gzoneInteractiveCommentNotice;
                    int length33 = gzoneInteractiveCommentNoticeArr == null ? 0 : gzoneInteractiveCommentNoticeArr.length;
                    GzoneInteractiveCommentNotice[] gzoneInteractiveCommentNoticeArr2 = new GzoneInteractiveCommentNotice[repeatedFieldArrayLength33 + length33];
                    if (length33 != 0) {
                        System.arraycopy(this.gzoneInteractiveCommentNotice, 0, gzoneInteractiveCommentNoticeArr2, 0, length33);
                    }
                    while (length33 < gzoneInteractiveCommentNoticeArr2.length - 1) {
                        gzoneInteractiveCommentNoticeArr2[length33] = new GzoneInteractiveCommentNotice();
                        codedInputByteBufferNano.readMessage(gzoneInteractiveCommentNoticeArr2[length33]);
                        codedInputByteBufferNano.readTag();
                        length33++;
                    }
                    gzoneInteractiveCommentNoticeArr2[length33] = new GzoneInteractiveCommentNotice();
                    codedInputByteBufferNano.readMessage(gzoneInteractiveCommentNoticeArr2[length33]);
                    this.gzoneInteractiveCommentNotice = gzoneInteractiveCommentNoticeArr2;
                    break;
                case 282:
                    int repeatedFieldArrayLength34 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 282);
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr = this.richTextFeed;
                    int length34 = richTextFeedArr == null ? 0 : richTextFeedArr.length;
                    LiveStreamRichTextFeed.RichTextFeed[] richTextFeedArr2 = new LiveStreamRichTextFeed.RichTextFeed[repeatedFieldArrayLength34 + length34];
                    if (length34 != 0) {
                        System.arraycopy(this.richTextFeed, 0, richTextFeedArr2, 0, length34);
                    }
                    while (length34 < richTextFeedArr2.length - 1) {
                        richTextFeedArr2[length34] = new LiveStreamRichTextFeed.RichTextFeed();
                        codedInputByteBufferNano.readMessage(richTextFeedArr2[length34]);
                        codedInputByteBufferNano.readTag();
                        length34++;
                    }
                    richTextFeedArr2[length34] = new LiveStreamRichTextFeed.RichTextFeed();
                    codedInputByteBufferNano.readMessage(richTextFeedArr2[length34]);
                    this.richTextFeed = richTextFeedArr2;
                    break;
                case 290:
                    int repeatedFieldArrayLength35 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 290);
                    GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNoticeArr = this.gzoneAuthorTaskProgressNotice;
                    int length35 = gzoneAuthorTaskProgressNoticeArr == null ? 0 : gzoneAuthorTaskProgressNoticeArr.length;
                    GzoneAuthorTaskProgressNotice[] gzoneAuthorTaskProgressNoticeArr2 = new GzoneAuthorTaskProgressNotice[repeatedFieldArrayLength35 + length35];
                    if (length35 != 0) {
                        System.arraycopy(this.gzoneAuthorTaskProgressNotice, 0, gzoneAuthorTaskProgressNoticeArr2, 0, length35);
                    }
                    while (length35 < gzoneAuthorTaskProgressNoticeArr2.length - 1) {
                        gzoneAuthorTaskProgressNoticeArr2[length35] = new GzoneAuthorTaskProgressNotice();
                        codedInputByteBufferNano.readMessage(gzoneAuthorTaskProgressNoticeArr2[length35]);
                        codedInputByteBufferNano.readTag();
                        length35++;
                    }
                    gzoneAuthorTaskProgressNoticeArr2[length35] = new GzoneAuthorTaskProgressNotice();
                    codedInputByteBufferNano.readMessage(gzoneAuthorTaskProgressNoticeArr2[length35]);
                    this.gzoneAuthorTaskProgressNotice = gzoneAuthorTaskProgressNoticeArr2;
                    break;
                case 298:
                    int repeatedFieldArrayLength36 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 298);
                    GzoneAuthorCommonNotice[] gzoneAuthorCommonNoticeArr = this.gzoneAuthorCommonNotice;
                    int length36 = gzoneAuthorCommonNoticeArr == null ? 0 : gzoneAuthorCommonNoticeArr.length;
                    GzoneAuthorCommonNotice[] gzoneAuthorCommonNoticeArr2 = new GzoneAuthorCommonNotice[repeatedFieldArrayLength36 + length36];
                    if (length36 != 0) {
                        System.arraycopy(this.gzoneAuthorCommonNotice, 0, gzoneAuthorCommonNoticeArr2, 0, length36);
                    }
                    while (length36 < gzoneAuthorCommonNoticeArr2.length - 1) {
                        gzoneAuthorCommonNoticeArr2[length36] = new GzoneAuthorCommonNotice();
                        codedInputByteBufferNano.readMessage(gzoneAuthorCommonNoticeArr2[length36]);
                        codedInputByteBufferNano.readTag();
                        length36++;
                    }
                    gzoneAuthorCommonNoticeArr2[length36] = new GzoneAuthorCommonNotice();
                    codedInputByteBufferNano.readMessage(gzoneAuthorCommonNoticeArr2[length36]);
                    this.gzoneAuthorCommonNotice = gzoneAuthorCommonNoticeArr2;
                    break;
                case 306:
                    int repeatedFieldArrayLength37 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 306);
                    LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNoticeArr = this.liveHappyPlayOpenResultNotice;
                    int length37 = liveHappyPlayOpenResultNoticeArr == null ? 0 : liveHappyPlayOpenResultNoticeArr.length;
                    LiveHappyPlayOpenResultNotice[] liveHappyPlayOpenResultNoticeArr2 = new LiveHappyPlayOpenResultNotice[repeatedFieldArrayLength37 + length37];
                    if (length37 != 0) {
                        System.arraycopy(this.liveHappyPlayOpenResultNotice, 0, liveHappyPlayOpenResultNoticeArr2, 0, length37);
                    }
                    while (length37 < liveHappyPlayOpenResultNoticeArr2.length - 1) {
                        liveHappyPlayOpenResultNoticeArr2[length37] = new LiveHappyPlayOpenResultNotice();
                        codedInputByteBufferNano.readMessage(liveHappyPlayOpenResultNoticeArr2[length37]);
                        codedInputByteBufferNano.readTag();
                        length37++;
                    }
                    liveHappyPlayOpenResultNoticeArr2[length37] = new LiveHappyPlayOpenResultNotice();
                    codedInputByteBufferNano.readMessage(liveHappyPlayOpenResultNoticeArr2[length37]);
                    this.liveHappyPlayOpenResultNotice = liveHappyPlayOpenResultNoticeArr2;
                    break;
                case 314:
                    int repeatedFieldArrayLength38 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 314);
                    LiveCommonRoute[] liveCommonRouteArr = this.liveCommonRoute;
                    int length38 = liveCommonRouteArr == null ? 0 : liveCommonRouteArr.length;
                    LiveCommonRoute[] liveCommonRouteArr2 = new LiveCommonRoute[repeatedFieldArrayLength38 + length38];
                    if (length38 != 0) {
                        System.arraycopy(this.liveCommonRoute, 0, liveCommonRouteArr2, 0, length38);
                    }
                    while (length38 < liveCommonRouteArr2.length - 1) {
                        liveCommonRouteArr2[length38] = new LiveCommonRoute();
                        codedInputByteBufferNano.readMessage(liveCommonRouteArr2[length38]);
                        codedInputByteBufferNano.readTag();
                        length38++;
                    }
                    liveCommonRouteArr2[length38] = new LiveCommonRoute();
                    codedInputByteBufferNano.readMessage(liveCommonRouteArr2[length38]);
                    this.liveCommonRoute = liveCommonRouteArr2;
                    break;
                case 322:
                    int repeatedFieldArrayLength39 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 322);
                    LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeedArr = this.liveWatchingListChangeNoticeFeed;
                    int length39 = liveWatchingListChangeNoticeFeedArr == null ? 0 : liveWatchingListChangeNoticeFeedArr.length;
                    LiveWatchingListChangeNoticeFeed[] liveWatchingListChangeNoticeFeedArr2 = new LiveWatchingListChangeNoticeFeed[repeatedFieldArrayLength39 + length39];
                    if (length39 != 0) {
                        System.arraycopy(this.liveWatchingListChangeNoticeFeed, 0, liveWatchingListChangeNoticeFeedArr2, 0, length39);
                    }
                    while (length39 < liveWatchingListChangeNoticeFeedArr2.length - 1) {
                        liveWatchingListChangeNoticeFeedArr2[length39] = new LiveWatchingListChangeNoticeFeed();
                        codedInputByteBufferNano.readMessage(liveWatchingListChangeNoticeFeedArr2[length39]);
                        codedInputByteBufferNano.readTag();
                        length39++;
                    }
                    liveWatchingListChangeNoticeFeedArr2[length39] = new LiveWatchingListChangeNoticeFeed();
                    codedInputByteBufferNano.readMessage(liveWatchingListChangeNoticeFeedArr2[length39]);
                    this.liveWatchingListChangeNoticeFeed = liveWatchingListChangeNoticeFeedArr2;
                    break;
                case 330:
                    int repeatedFieldArrayLength40 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 330);
                    GzoneCommonFeed[] gzoneCommonFeedArr = this.gzoneCommonFeed;
                    int length40 = gzoneCommonFeedArr == null ? 0 : gzoneCommonFeedArr.length;
                    GzoneCommonFeed[] gzoneCommonFeedArr2 = new GzoneCommonFeed[repeatedFieldArrayLength40 + length40];
                    if (length40 != 0) {
                        System.arraycopy(this.gzoneCommonFeed, 0, gzoneCommonFeedArr2, 0, length40);
                    }
                    while (length40 < gzoneCommonFeedArr2.length - 1) {
                        gzoneCommonFeedArr2[length40] = new GzoneCommonFeed();
                        codedInputByteBufferNano.readMessage(gzoneCommonFeedArr2[length40]);
                        codedInputByteBufferNano.readTag();
                        length40++;
                    }
                    gzoneCommonFeedArr2[length40] = new GzoneCommonFeed();
                    codedInputByteBufferNano.readMessage(gzoneCommonFeedArr2[length40]);
                    this.gzoneCommonFeed = gzoneCommonFeedArr2;
                    break;
                case 338:
                    int repeatedFieldArrayLength41 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 338);
                    LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopupArr = this.liveCommonPopup;
                    int length41 = liveCommonPopupArr == null ? 0 : liveCommonPopupArr.length;
                    LiveCommonNoticeMessages.LiveCommonPopup[] liveCommonPopupArr2 = new LiveCommonNoticeMessages.LiveCommonPopup[repeatedFieldArrayLength41 + length41];
                    if (length41 != 0) {
                        System.arraycopy(this.liveCommonPopup, 0, liveCommonPopupArr2, 0, length41);
                    }
                    while (length41 < liveCommonPopupArr2.length - 1) {
                        liveCommonPopupArr2[length41] = new LiveCommonNoticeMessages.LiveCommonPopup();
                        codedInputByteBufferNano.readMessage(liveCommonPopupArr2[length41]);
                        codedInputByteBufferNano.readTag();
                        length41++;
                    }
                    liveCommonPopupArr2[length41] = new LiveCommonNoticeMessages.LiveCommonPopup();
                    codedInputByteBufferNano.readMessage(liveCommonPopupArr2[length41]);
                    this.liveCommonPopup = liveCommonPopupArr2;
                    break;
                case 346:
                    int repeatedFieldArrayLength42 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 346);
                    CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChangeArr = this.commodityCardComponentChange;
                    int length42 = commodityCardComponentChangeArr == null ? 0 : commodityCardComponentChangeArr.length;
                    CommodityCardMessage.CommodityCardComponentChange[] commodityCardComponentChangeArr2 = new CommodityCardMessage.CommodityCardComponentChange[repeatedFieldArrayLength42 + length42];
                    if (length42 != 0) {
                        System.arraycopy(this.commodityCardComponentChange, 0, commodityCardComponentChangeArr2, 0, length42);
                    }
                    while (length42 < commodityCardComponentChangeArr2.length - 1) {
                        commodityCardComponentChangeArr2[length42] = new CommodityCardMessage.CommodityCardComponentChange();
                        codedInputByteBufferNano.readMessage(commodityCardComponentChangeArr2[length42]);
                        codedInputByteBufferNano.readTag();
                        length42++;
                    }
                    commodityCardComponentChangeArr2[length42] = new CommodityCardMessage.CommodityCardComponentChange();
                    codedInputByteBufferNano.readMessage(commodityCardComponentChangeArr2[length42]);
                    this.commodityCardComponentChange = commodityCardComponentChangeArr2;
                    break;
                case 354:
                    int repeatedFieldArrayLength43 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 354);
                    CommodityCardMessage.CommodityCardChange[] commodityCardChangeArr = this.commodityCardChange;
                    int length43 = commodityCardChangeArr == null ? 0 : commodityCardChangeArr.length;
                    CommodityCardMessage.CommodityCardChange[] commodityCardChangeArr2 = new CommodityCardMessage.CommodityCardChange[repeatedFieldArrayLength43 + length43];
                    if (length43 != 0) {
                        System.arraycopy(this.commodityCardChange, 0, commodityCardChangeArr2, 0, length43);
                    }
                    while (length43 < commodityCardChangeArr2.length - 1) {
                        commodityCardChangeArr2[length43] = new CommodityCardMessage.CommodityCardChange();
                        codedInputByteBufferNano.readMessage(commodityCardChangeArr2[length43]);
                        codedInputByteBufferNano.readTag();
                        length43++;
                    }
                    commodityCardChangeArr2[length43] = new CommodityCardMessage.CommodityCardChange();
                    codedInputByteBufferNano.readMessage(commodityCardChangeArr2[length43]);
                    this.commodityCardChange = commodityCardChangeArr2;
                    break;
                case 362:
                    int repeatedFieldArrayLength44 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 362);
                    LiveCommonNoticeMessages.LiteTextNotice[] liteTextNoticeArr = this.textNotice;
                    int length44 = liteTextNoticeArr == null ? 0 : liteTextNoticeArr.length;
                    LiveCommonNoticeMessages.LiteTextNotice[] liteTextNoticeArr2 = new LiveCommonNoticeMessages.LiteTextNotice[repeatedFieldArrayLength44 + length44];
                    if (length44 != 0) {
                        System.arraycopy(this.textNotice, 0, liteTextNoticeArr2, 0, length44);
                    }
                    while (length44 < liteTextNoticeArr2.length - 1) {
                        liteTextNoticeArr2[length44] = new LiveCommonNoticeMessages.LiteTextNotice();
                        codedInputByteBufferNano.readMessage(liteTextNoticeArr2[length44]);
                        codedInputByteBufferNano.readTag();
                        length44++;
                    }
                    liteTextNoticeArr2[length44] = new LiveCommonNoticeMessages.LiteTextNotice();
                    codedInputByteBufferNano.readMessage(liteTextNoticeArr2[length44]);
                    this.textNotice = liteTextNoticeArr2;
                    break;
                case 370:
                    int repeatedFieldArrayLength45 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 370);
                    LiveRoomSignalMessage.SCKwaishopLivePendant[] sCKwaishopLivePendantArr = this.shopLivePendant;
                    int length45 = sCKwaishopLivePendantArr == null ? 0 : sCKwaishopLivePendantArr.length;
                    LiveRoomSignalMessage.SCKwaishopLivePendant[] sCKwaishopLivePendantArr2 = new LiveRoomSignalMessage.SCKwaishopLivePendant[repeatedFieldArrayLength45 + length45];
                    if (length45 != 0) {
                        System.arraycopy(this.shopLivePendant, 0, sCKwaishopLivePendantArr2, 0, length45);
                    }
                    while (length45 < sCKwaishopLivePendantArr2.length - 1) {
                        sCKwaishopLivePendantArr2[length45] = new LiveRoomSignalMessage.SCKwaishopLivePendant();
                        codedInputByteBufferNano.readMessage(sCKwaishopLivePendantArr2[length45]);
                        codedInputByteBufferNano.readTag();
                        length45++;
                    }
                    sCKwaishopLivePendantArr2[length45] = new LiveRoomSignalMessage.SCKwaishopLivePendant();
                    codedInputByteBufferNano.readMessage(sCKwaishopLivePendantArr2[length45]);
                    this.shopLivePendant = sCKwaishopLivePendantArr2;
                    break;
                case 378:
                    int repeatedFieldArrayLength46 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 378);
                    LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveActionArr = this.marketingPushLiveAction;
                    int length46 = marketingPushLiveActionArr == null ? 0 : marketingPushLiveActionArr.length;
                    LiveRoomSignalMessage.MarketingPushLiveAction[] marketingPushLiveActionArr2 = new LiveRoomSignalMessage.MarketingPushLiveAction[repeatedFieldArrayLength46 + length46];
                    if (length46 != 0) {
                        System.arraycopy(this.marketingPushLiveAction, 0, marketingPushLiveActionArr2, 0, length46);
                    }
                    while (length46 < marketingPushLiveActionArr2.length - 1) {
                        marketingPushLiveActionArr2[length46] = new LiveRoomSignalMessage.MarketingPushLiveAction();
                        codedInputByteBufferNano.readMessage(marketingPushLiveActionArr2[length46]);
                        codedInputByteBufferNano.readTag();
                        length46++;
                    }
                    marketingPushLiveActionArr2[length46] = new LiveRoomSignalMessage.MarketingPushLiveAction();
                    codedInputByteBufferNano.readMessage(marketingPushLiveActionArr2[length46]);
                    this.marketingPushLiveAction = marketingPushLiveActionArr2;
                    break;
                case 386:
                    int repeatedFieldArrayLength47 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 386);
                    LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNoticeArr = this.liveRefreshAuthorStatusNotice;
                    int length47 = liveRefreshAuthorStatusNoticeArr == null ? 0 : liveRefreshAuthorStatusNoticeArr.length;
                    LiveRefreshAuthorStatusNotice[] liveRefreshAuthorStatusNoticeArr2 = new LiveRefreshAuthorStatusNotice[repeatedFieldArrayLength47 + length47];
                    if (length47 != 0) {
                        System.arraycopy(this.liveRefreshAuthorStatusNotice, 0, liveRefreshAuthorStatusNoticeArr2, 0, length47);
                    }
                    while (length47 < liveRefreshAuthorStatusNoticeArr2.length - 1) {
                        liveRefreshAuthorStatusNoticeArr2[length47] = new LiveRefreshAuthorStatusNotice();
                        codedInputByteBufferNano.readMessage(liveRefreshAuthorStatusNoticeArr2[length47]);
                        codedInputByteBufferNano.readTag();
                        length47++;
                    }
                    liveRefreshAuthorStatusNoticeArr2[length47] = new LiveRefreshAuthorStatusNotice();
                    codedInputByteBufferNano.readMessage(liveRefreshAuthorStatusNoticeArr2[length47]);
                    this.liveRefreshAuthorStatusNotice = liveRefreshAuthorStatusNoticeArr2;
                    break;
                case 394:
                    int repeatedFieldArrayLength48 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 394);
                    LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] sCKwaishopLiveActivityPendantArr = this.shopLiveActivityPendant;
                    int length48 = sCKwaishopLiveActivityPendantArr == null ? 0 : sCKwaishopLiveActivityPendantArr.length;
                    LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[] sCKwaishopLiveActivityPendantArr2 = new LiveRoomSignalMessage.SCKwaishopLiveActivityPendant[repeatedFieldArrayLength48 + length48];
                    if (length48 != 0) {
                        System.arraycopy(this.shopLiveActivityPendant, 0, sCKwaishopLiveActivityPendantArr2, 0, length48);
                    }
                    while (length48 < sCKwaishopLiveActivityPendantArr2.length - 1) {
                        sCKwaishopLiveActivityPendantArr2[length48] = new LiveRoomSignalMessage.SCKwaishopLiveActivityPendant();
                        codedInputByteBufferNano.readMessage(sCKwaishopLiveActivityPendantArr2[length48]);
                        codedInputByteBufferNano.readTag();
                        length48++;
                    }
                    sCKwaishopLiveActivityPendantArr2[length48] = new LiveRoomSignalMessage.SCKwaishopLiveActivityPendant();
                    codedInputByteBufferNano.readMessage(sCKwaishopLiveActivityPendantArr2[length48]);
                    this.shopLiveActivityPendant = sCKwaishopLiveActivityPendantArr2;
                    break;
                case 402:
                    int repeatedFieldArrayLength49 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 402);
                    LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] sCLiveBuyingNoticeSignalArr = this.liveBuyingNoticeSignal;
                    int length49 = sCLiveBuyingNoticeSignalArr == null ? 0 : sCLiveBuyingNoticeSignalArr.length;
                    LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[] sCLiveBuyingNoticeSignalArr2 = new LiveRoomSignalMessage.SCLiveBuyingNoticeSignal[repeatedFieldArrayLength49 + length49];
                    if (length49 != 0) {
                        System.arraycopy(this.liveBuyingNoticeSignal, 0, sCLiveBuyingNoticeSignalArr2, 0, length49);
                    }
                    while (length49 < sCLiveBuyingNoticeSignalArr2.length - 1) {
                        sCLiveBuyingNoticeSignalArr2[length49] = new LiveRoomSignalMessage.SCLiveBuyingNoticeSignal();
                        codedInputByteBufferNano.readMessage(sCLiveBuyingNoticeSignalArr2[length49]);
                        codedInputByteBufferNano.readTag();
                        length49++;
                    }
                    sCLiveBuyingNoticeSignalArr2[length49] = new LiveRoomSignalMessage.SCLiveBuyingNoticeSignal();
                    codedInputByteBufferNano.readMessage(sCLiveBuyingNoticeSignalArr2[length49]);
                    this.liveBuyingNoticeSignal = sCLiveBuyingNoticeSignalArr2;
                    break;
                case SocketMessages.PayloadType.SC_WISH_LIST_OPENED /* 410 */:
                    int repeatedFieldArrayLength50 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, SocketMessages.PayloadType.SC_WISH_LIST_OPENED);
                    PkBountyActivityResultInfo[] pkBountyActivityResultInfoArr = this.pkBountyActivityResultInfo;
                    int length50 = pkBountyActivityResultInfoArr == null ? 0 : pkBountyActivityResultInfoArr.length;
                    PkBountyActivityResultInfo[] pkBountyActivityResultInfoArr2 = new PkBountyActivityResultInfo[repeatedFieldArrayLength50 + length50];
                    if (length50 != 0) {
                        System.arraycopy(this.pkBountyActivityResultInfo, 0, pkBountyActivityResultInfoArr2, 0, length50);
                    }
                    while (length50 < pkBountyActivityResultInfoArr2.length - 1) {
                        pkBountyActivityResultInfoArr2[length50] = new PkBountyActivityResultInfo();
                        codedInputByteBufferNano.readMessage(pkBountyActivityResultInfoArr2[length50]);
                        codedInputByteBufferNano.readTag();
                        length50++;
                    }
                    pkBountyActivityResultInfoArr2[length50] = new PkBountyActivityResultInfo();
                    codedInputByteBufferNano.readMessage(pkBountyActivityResultInfoArr2[length50]);
                    this.pkBountyActivityResultInfo = pkBountyActivityResultInfoArr2;
                    break;
                case 418:
                    int repeatedFieldArrayLength51 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 418);
                    SendGiftNotifyAnimation[] sendGiftNotifyAnimationArr = this.sendGiftNotifyAnimation;
                    int length51 = sendGiftNotifyAnimationArr == null ? 0 : sendGiftNotifyAnimationArr.length;
                    SendGiftNotifyAnimation[] sendGiftNotifyAnimationArr2 = new SendGiftNotifyAnimation[repeatedFieldArrayLength51 + length51];
                    if (length51 != 0) {
                        System.arraycopy(this.sendGiftNotifyAnimation, 0, sendGiftNotifyAnimationArr2, 0, length51);
                    }
                    while (length51 < sendGiftNotifyAnimationArr2.length - 1) {
                        sendGiftNotifyAnimationArr2[length51] = new SendGiftNotifyAnimation();
                        codedInputByteBufferNano.readMessage(sendGiftNotifyAnimationArr2[length51]);
                        codedInputByteBufferNano.readTag();
                        length51++;
                    }
                    sendGiftNotifyAnimationArr2[length51] = new SendGiftNotifyAnimation();
                    codedInputByteBufferNano.readMessage(sendGiftNotifyAnimationArr2[length51]);
                    this.sendGiftNotifyAnimation = sendGiftNotifyAnimationArr2;
                    break;
                case 426:
                    int repeatedFieldArrayLength52 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 426);
                    HighFrequencyActionGuide[] highFrequencyActionGuideArr = this.highFrequencyActionGuide;
                    int length52 = highFrequencyActionGuideArr == null ? 0 : highFrequencyActionGuideArr.length;
                    HighFrequencyActionGuide[] highFrequencyActionGuideArr2 = new HighFrequencyActionGuide[repeatedFieldArrayLength52 + length52];
                    if (length52 != 0) {
                        System.arraycopy(this.highFrequencyActionGuide, 0, highFrequencyActionGuideArr2, 0, length52);
                    }
                    while (length52 < highFrequencyActionGuideArr2.length - 1) {
                        highFrequencyActionGuideArr2[length52] = new HighFrequencyActionGuide();
                        codedInputByteBufferNano.readMessage(highFrequencyActionGuideArr2[length52]);
                        codedInputByteBufferNano.readTag();
                        length52++;
                    }
                    highFrequencyActionGuideArr2[length52] = new HighFrequencyActionGuide();
                    codedInputByteBufferNano.readMessage(highFrequencyActionGuideArr2[length52]);
                    this.highFrequencyActionGuide = highFrequencyActionGuideArr2;
                    break;
                case SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION /* 434 */:
                    int repeatedFieldArrayLength53 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION);
                    LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfoArr = this.liveCommonEffectRouteInfo;
                    int length53 = liveCommonEffectRouteInfoArr == null ? 0 : liveCommonEffectRouteInfoArr.length;
                    LiveCommonEffectRouteInfo[] liveCommonEffectRouteInfoArr2 = new LiveCommonEffectRouteInfo[repeatedFieldArrayLength53 + length53];
                    if (length53 != 0) {
                        System.arraycopy(this.liveCommonEffectRouteInfo, 0, liveCommonEffectRouteInfoArr2, 0, length53);
                    }
                    while (length53 < liveCommonEffectRouteInfoArr2.length - 1) {
                        liveCommonEffectRouteInfoArr2[length53] = new LiveCommonEffectRouteInfo();
                        codedInputByteBufferNano.readMessage(liveCommonEffectRouteInfoArr2[length53]);
                        codedInputByteBufferNano.readTag();
                        length53++;
                    }
                    liveCommonEffectRouteInfoArr2[length53] = new LiveCommonEffectRouteInfo();
                    codedInputByteBufferNano.readMessage(liveCommonEffectRouteInfoArr2[length53]);
                    this.liveCommonEffectRouteInfo = liveCommonEffectRouteInfoArr2;
                    break;
                case SocketMessages.PayloadType.SC_BET_CLOSED /* 442 */:
                    int repeatedFieldArrayLength54 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, SocketMessages.PayloadType.SC_BET_CLOSED);
                    LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] kwaishopLiveAskOnItemSignalArr = this.liveAskOnItem;
                    int length54 = kwaishopLiveAskOnItemSignalArr == null ? 0 : kwaishopLiveAskOnItemSignalArr.length;
                    LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[] kwaishopLiveAskOnItemSignalArr2 = new LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal[repeatedFieldArrayLength54 + length54];
                    if (length54 != 0) {
                        System.arraycopy(this.liveAskOnItem, 0, kwaishopLiveAskOnItemSignalArr2, 0, length54);
                    }
                    while (length54 < kwaishopLiveAskOnItemSignalArr2.length - 1) {
                        kwaishopLiveAskOnItemSignalArr2[length54] = new LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal();
                        codedInputByteBufferNano.readMessage(kwaishopLiveAskOnItemSignalArr2[length54]);
                        codedInputByteBufferNano.readTag();
                        length54++;
                    }
                    kwaishopLiveAskOnItemSignalArr2[length54] = new LiveRoomSignalMessage.KwaishopLiveAskOnItemSignal();
                    codedInputByteBufferNano.readMessage(kwaishopLiveAskOnItemSignalArr2[length54]);
                    this.liveAskOnItem = kwaishopLiveAskOnItemSignalArr2;
                    break;
                case 450:
                    int repeatedFieldArrayLength55 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 450);
                    LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfoArr = this.liveMultiMagicEffectInfo;
                    int length55 = liveMultiMagicEffectInfoArr == null ? 0 : liveMultiMagicEffectInfoArr.length;
                    LiveMultiMagicEffectInfo[] liveMultiMagicEffectInfoArr2 = new LiveMultiMagicEffectInfo[repeatedFieldArrayLength55 + length55];
                    if (length55 != 0) {
                        System.arraycopy(this.liveMultiMagicEffectInfo, 0, liveMultiMagicEffectInfoArr2, 0, length55);
                    }
                    while (length55 < liveMultiMagicEffectInfoArr2.length - 1) {
                        liveMultiMagicEffectInfoArr2[length55] = new LiveMultiMagicEffectInfo();
                        codedInputByteBufferNano.readMessage(liveMultiMagicEffectInfoArr2[length55]);
                        codedInputByteBufferNano.readTag();
                        length55++;
                    }
                    liveMultiMagicEffectInfoArr2[length55] = new LiveMultiMagicEffectInfo();
                    codedInputByteBufferNano.readMessage(liveMultiMagicEffectInfoArr2[length55]);
                    this.liveMultiMagicEffectInfo = liveMultiMagicEffectInfoArr2;
                    break;
                case 458:
                    int repeatedFieldArrayLength56 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 458);
                    LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] sCLiveGuideFollowAuthorCardInfoArr = this.liveGuideFollowCardInfo;
                    int length56 = sCLiveGuideFollowAuthorCardInfoArr == null ? 0 : sCLiveGuideFollowAuthorCardInfoArr.length;
                    LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[] sCLiveGuideFollowAuthorCardInfoArr2 = new LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo[repeatedFieldArrayLength56 + length56];
                    if (length56 != 0) {
                        System.arraycopy(this.liveGuideFollowCardInfo, 0, sCLiveGuideFollowAuthorCardInfoArr2, 0, length56);
                    }
                    while (length56 < sCLiveGuideFollowAuthorCardInfoArr2.length - 1) {
                        sCLiveGuideFollowAuthorCardInfoArr2[length56] = new LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo();
                        codedInputByteBufferNano.readMessage(sCLiveGuideFollowAuthorCardInfoArr2[length56]);
                        codedInputByteBufferNano.readTag();
                        length56++;
                    }
                    sCLiveGuideFollowAuthorCardInfoArr2[length56] = new LiveGuideFollowAuthorCardInfo.SCLiveGuideFollowAuthorCardInfo();
                    codedInputByteBufferNano.readMessage(sCLiveGuideFollowAuthorCardInfoArr2[length56]);
                    this.liveGuideFollowCardInfo = sCLiveGuideFollowAuthorCardInfoArr2;
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE /* 466 */:
                    int repeatedFieldArrayLength57 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE);
                    LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffectsArr = this.liveVoicePartyMicSeatUserLevelUpEffect;
                    int length57 = liveVoicePartyMicSeatUserLevelUpEffectsArr == null ? 0 : liveVoicePartyMicSeatUserLevelUpEffectsArr.length;
                    LiveVoicePartyMicSeatUserLevelUpEffects[] liveVoicePartyMicSeatUserLevelUpEffectsArr2 = new LiveVoicePartyMicSeatUserLevelUpEffects[repeatedFieldArrayLength57 + length57];
                    if (length57 != 0) {
                        System.arraycopy(this.liveVoicePartyMicSeatUserLevelUpEffect, 0, liveVoicePartyMicSeatUserLevelUpEffectsArr2, 0, length57);
                    }
                    while (length57 < liveVoicePartyMicSeatUserLevelUpEffectsArr2.length - 1) {
                        liveVoicePartyMicSeatUserLevelUpEffectsArr2[length57] = new LiveVoicePartyMicSeatUserLevelUpEffects();
                        codedInputByteBufferNano.readMessage(liveVoicePartyMicSeatUserLevelUpEffectsArr2[length57]);
                        codedInputByteBufferNano.readTag();
                        length57++;
                    }
                    liveVoicePartyMicSeatUserLevelUpEffectsArr2[length57] = new LiveVoicePartyMicSeatUserLevelUpEffects();
                    codedInputByteBufferNano.readMessage(liveVoicePartyMicSeatUserLevelUpEffectsArr2[length57]);
                    this.liveVoicePartyMicSeatUserLevelUpEffect = liveVoicePartyMicSeatUserLevelUpEffectsArr2;
                    break;
                case 474:
                    int repeatedFieldArrayLength58 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 474);
                    LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] sCLiveAuthorReinforceInfoArr = this.liveAuthorReinforceInfo;
                    int length58 = sCLiveAuthorReinforceInfoArr == null ? 0 : sCLiveAuthorReinforceInfoArr.length;
                    LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[] sCLiveAuthorReinforceInfoArr2 = new LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo[repeatedFieldArrayLength58 + length58];
                    if (length58 != 0) {
                        System.arraycopy(this.liveAuthorReinforceInfo, 0, sCLiveAuthorReinforceInfoArr2, 0, length58);
                    }
                    while (length58 < sCLiveAuthorReinforceInfoArr2.length - 1) {
                        sCLiveAuthorReinforceInfoArr2[length58] = new LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo();
                        codedInputByteBufferNano.readMessage(sCLiveAuthorReinforceInfoArr2[length58]);
                        codedInputByteBufferNano.readTag();
                        length58++;
                    }
                    sCLiveAuthorReinforceInfoArr2[length58] = new LiveAuthorReinforceInfoProto.SCLiveAuthorReinforceInfo();
                    codedInputByteBufferNano.readMessage(sCLiveAuthorReinforceInfoArr2[length58]);
                    this.liveAuthorReinforceInfo = sCLiveAuthorReinforceInfoArr2;
                    break;
                case 802:
                    int repeatedFieldArrayLength59 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 802);
                    TestActionSignalFeed[] testActionSignalFeedArr = this.testFeed;
                    int length59 = testActionSignalFeedArr == null ? 0 : testActionSignalFeedArr.length;
                    TestActionSignalFeed[] testActionSignalFeedArr2 = new TestActionSignalFeed[repeatedFieldArrayLength59 + length59];
                    if (length59 != 0) {
                        System.arraycopy(this.testFeed, 0, testActionSignalFeedArr2, 0, length59);
                    }
                    while (length59 < testActionSignalFeedArr2.length - 1) {
                        testActionSignalFeedArr2[length59] = new TestActionSignalFeed();
                        codedInputByteBufferNano.readMessage(testActionSignalFeedArr2[length59]);
                        codedInputByteBufferNano.readTag();
                        length59++;
                    }
                    testActionSignalFeedArr2[length59] = new TestActionSignalFeed();
                    codedInputByteBufferNano.readMessage(testActionSignalFeedArr2[length59]);
                    this.testFeed = testActionSignalFeedArr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCActionSignal parseFrom(byte[] bArr) {
        return (SCActionSignal) MessageNano.mergeFrom(new SCActionSignal(), bArr);
    }

    public static SCActionSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCActionSignal().mergeFrom(codedInputByteBufferNano);
    }
}
