package com.kwad.sdk.live.audience.api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public enum KSLiveRequestPath {
    START_PLAY("/api/thirdParty/live/startPlay"),
    GET_PLAY_URL("/api/thirdParty/live/getNewProviderPlayUrlV2"),
    GET_NEW_PROVIDER("/api/thirdParty/live/getNewProviderPlayUrl"),
    GET_WATCHING_USERS("/api/thirdParty/live/watchingUsers"),
    GET_TOP_USERS("/api/thirdParty/live/topUsers"),
    STOP_LIVE_PLAY("/api/thirdParty/live/stopPlay"),
    GET_END_SUMMARY("/api/thirdParty/live/getEndSummary"),
    FEEDS_LIST("/api/thirdParty/live/feeds/list"),
    FEEDS_MORE("/api/thirdParty/live/feeds/more"),
    GET_NEW_RACE("/api/thirdParty/live/getNewRace");

    private String mPath;

    KSLiveRequestPath(String str) {
        this.mPath = str;
    }

    final String path() {
        return this.mPath;
    }
}
