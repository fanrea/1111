package com.yxcorp.livestream.longconnection;

import com.kuaishou.livestream.message.nano.LiveFansGroupMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveMessageListener {

    public static class SimpleLiveMessageListener implements LiveMessageListener {
        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onAssistantStatusChange(LiveStreamMessages.SCAssistantStatus sCAssistantStatus) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onAuthorPause(LiveStreamMessages.SCAuthorPause sCAuthorPause) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onAuthorResume(LiveStreamMessages.SCAuthorResume sCAuthorResume) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionEstablished() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionHorseRaceFail(long j) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionHorseRaceStart() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionHorseRaceSuccess(String str, long j) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionInterrupt() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onConnectionStart() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onEnterRoomAckReceived(LiveStreamMessages.SCEnterRoomAck sCEnterRoomAck) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFansTopClose(LiveStreamMessages.SCLiveFansTopClosed sCLiveFansTopClosed) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFansTopOpen(LiveStreamMessages.SCLiveFansTopOpened sCLiveFansTopOpened) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onFeedReceived(LiveStreamMessages.SCLiveWatchingList sCLiveWatchingList) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveChatCall(LiveStreamMessages.SCLiveChatCall sCLiveChatCall) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveChatEnded() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveChatReady(LiveStreamMessages.SCLiveChatReady sCLiveChatReady) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveDistrictRankClosed(LiveStreamMessages.SCLiveDistrictRankClosed sCLiveDistrictRankClosed) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveDistrictRankInfoReceived(LiveStreamMessages.SCLiveDistrictRankInfo sCLiveDistrictRankInfo) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onLiveFansGroupStatusChanged(LiveFansGroupMessages.SCLiveFansGroupStatusChanged sCLiveFansGroupStatusChanged) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onRenderingMagicFaceDisable() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onRenderingMagicFaceEnable() {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onSuspectedViolationChange(LiveStreamMessages.SCSuspectedViolation sCSuspectedViolation) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onVoipSignal(LiveStreamMessages.SCVoipSignal sCVoipSignal) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onWishListClosed(LiveStreamMessages.SCWishListClosed sCWishListClosed) {
        }

        @Override // com.yxcorp.livestream.longconnection.LiveMessageListener
        public void onWishListOpened(LiveStreamMessages.SCWishListOpened sCWishListOpened) {
        }
    }

    void onAssistantStatusChange(LiveStreamMessages.SCAssistantStatus sCAssistantStatus);

    void onAuthorPause(LiveStreamMessages.SCAuthorPause sCAuthorPause);

    void onAuthorResume(LiveStreamMessages.SCAuthorResume sCAuthorResume);

    void onConnectionEstablished();

    void onConnectionHorseRaceFail(long j);

    void onConnectionHorseRaceStart();

    void onConnectionHorseRaceSuccess(String str, long j);

    void onConnectionInterrupt();

    void onConnectionStart();

    void onEnterRoomAckReceived(LiveStreamMessages.SCEnterRoomAck sCEnterRoomAck);

    void onFansTopClose(LiveStreamMessages.SCLiveFansTopClosed sCLiveFansTopClosed);

    void onFansTopOpen(LiveStreamMessages.SCLiveFansTopOpened sCLiveFansTopOpened);

    void onFeedReceived(LiveStreamMessages.SCFeedPush sCFeedPush);

    void onFeedReceived(LiveStreamMessages.SCLiveWatchingList sCLiveWatchingList);

    void onLiveChatCall(LiveStreamMessages.SCLiveChatCall sCLiveChatCall);

    void onLiveChatEnded();

    void onLiveChatReady(LiveStreamMessages.SCLiveChatReady sCLiveChatReady);

    void onLiveDistrictRankClosed(LiveStreamMessages.SCLiveDistrictRankClosed sCLiveDistrictRankClosed);

    void onLiveDistrictRankInfoReceived(LiveStreamMessages.SCLiveDistrictRankInfo sCLiveDistrictRankInfo);

    void onLiveFansGroupStatusChanged(LiveFansGroupMessages.SCLiveFansGroupStatusChanged sCLiveFansGroupStatusChanged);

    void onRenderingMagicFaceDisable();

    void onRenderingMagicFaceEnable();

    void onSuspectedViolationChange(LiveStreamMessages.SCSuspectedViolation sCSuspectedViolation);

    void onVoipSignal(LiveStreamMessages.SCVoipSignal sCVoipSignal);

    void onWishListClosed(LiveStreamMessages.SCWishListClosed sCWishListClosed);

    void onWishListOpened(LiveStreamMessages.SCWishListOpened sCWishListOpened);
}
