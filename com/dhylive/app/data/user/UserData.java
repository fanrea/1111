package com.dhylive.app.data.user;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.utils.AVLogger;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\bL\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010$J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0006HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u001cHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\u0006HÆ\u0003J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0006HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003JÃ\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\u001cHÖ\u0001J\t\u0010m\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010)\"\u0004\b,\u0010-R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010&R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0016\u0010 \u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0016\u0010\u001b\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010!\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0016\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u0010)R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010&R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010&R\u0016\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010)¨\u0006n"}, d2 = {"Lcom/dhylive/app/data/user/UserData;", "Ljava/io/Serializable;", "agentAdmin", "", "agentLevel", ILogConst.AD_CLICK_AVATAR, "", "balance", "bindStatus", "bindType", "coin", "exchange", "expectReward", "inviteCode", "inviteUrl", "isVerifier", "joinVerifier", "level", "nickname", "personalCoin", "personalWithdrawPrice", RemoteRewardActivity.JSON_BANNER_SCORE_ID, "teamCoin", "teamWithdrawPrice", Config.CUSTOM_USER_ID, "username", "user_email", "movieLevel", "", "verifierStatus", "withdrawLevel", "withdrawPrice", "levelEndTime", "movieLevelName", "alipayAccount", "alipayAccountName", "(JJLjava/lang/String;Ljava/lang/String;JJJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;JLjava/lang/String;JJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgentAdmin", "()J", "getAgentLevel", "getAlipayAccount", "()Ljava/lang/String;", "getAlipayAccountName", "getAvatar", "setAvatar", "(Ljava/lang/String;)V", "getBalance", "getBindStatus", "getBindType", "getCoin", "getExchange", "getExpectReward", "getInviteCode", "getInviteUrl", "getJoinVerifier", "getLevel", "getLevelEndTime", "getMovieLevel", "()I", "getMovieLevelName", "getNickname", "getPersonalCoin", "getPersonalWithdrawPrice", "getScore", "getTeamCoin", "getTeamWithdrawPrice", "getUid", "getUser_email", "getUsername", "getVerifierStatus", "getWithdrawLevel", "getWithdrawPrice", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class UserData implements Serializable {

    @SerializedName("agent_admin")
    private final long agentAdmin;

    @SerializedName("agent_level")
    private final long agentLevel;

    @SerializedName("account")
    private final String alipayAccount;

    @SerializedName("account_name")
    private final String alipayAccountName;
    private String avatar;
    private final String balance;

    @SerializedName("bind_status")
    private final long bindStatus;

    @SerializedName("bind_type")
    private final long bindType;
    private final long coin;
    private final String exchange;

    @SerializedName("expect_reward")
    private final long expectReward;

    @SerializedName("invite_code")
    private final String inviteCode;

    @SerializedName("invite_url")
    private final String inviteUrl;

    @SerializedName("is_verifier")
    private final long isVerifier;

    @SerializedName("join_verifier")
    private final long joinVerifier;
    private final String level;

    @SerializedName("level_end_time")
    private final String levelEndTime;

    @SerializedName("movie_level")
    private final int movieLevel;

    @SerializedName("movie_level_name")
    private final String movieLevelName;
    private final String nickname;

    @SerializedName("personal_coin")
    private final long personalCoin;

    @SerializedName("personal_withdraw_price")
    private final String personalWithdrawPrice;
    private final long score;

    @SerializedName("team_coin")
    private final long teamCoin;

    @SerializedName("team_withdraw_price")
    private final String teamWithdrawPrice;
    private final long uid;
    private final String user_email;
    private final String username;

    @SerializedName("verifier_status")
    private final long verifierStatus;

    @SerializedName("withdraw_level")
    private final long withdrawLevel;

    @SerializedName("withdraw_price")
    private final String withdrawPrice;

    public static /* synthetic */ UserData copy$default(UserData userData, long j, long j2, String str, String str2, long j3, long j4, long j5, String str3, long j6, String str4, String str5, long j7, long j8, String str6, String str7, long j9, String str8, long j10, long j11, String str9, long j12, String str10, String str11, int i, long j13, long j14, String str12, String str13, String str14, String str15, String str16, int i2, Object obj) {
        long j15 = (i2 & 1) != 0 ? userData.agentAdmin : j;
        long j16 = (i2 & 2) != 0 ? userData.agentLevel : j2;
        String str17 = (i2 & 4) != 0 ? userData.avatar : str;
        String str18 = (i2 & 8) != 0 ? userData.balance : str2;
        long j17 = (i2 & 16) != 0 ? userData.bindStatus : j3;
        long j18 = (i2 & 32) != 0 ? userData.bindType : j4;
        long j19 = (i2 & 64) != 0 ? userData.coin : j5;
        String str19 = (i2 & 128) != 0 ? userData.exchange : str3;
        long j20 = (i2 & 256) != 0 ? userData.expectReward : j6;
        String str20 = (i2 & 512) != 0 ? userData.inviteCode : str4;
        return userData.copy(j15, j16, str17, str18, j17, j18, j19, str19, j20, str20, (i2 & 1024) != 0 ? userData.inviteUrl : str5, (i2 & 2048) != 0 ? userData.isVerifier : j7, (i2 & 4096) != 0 ? userData.joinVerifier : j8, (i2 & 8192) != 0 ? userData.level : str6, (i2 & 16384) != 0 ? userData.nickname : str7, (i2 & 32768) != 0 ? userData.personalCoin : j9, (i2 & 65536) != 0 ? userData.personalWithdrawPrice : str8, (131072 & i2) != 0 ? userData.score : j10, (i2 & 262144) != 0 ? userData.teamCoin : j11, (i2 & 524288) != 0 ? userData.teamWithdrawPrice : str9, (1048576 & i2) != 0 ? userData.uid : j12, (i2 & 2097152) != 0 ? userData.username : str10, (4194304 & i2) != 0 ? userData.user_email : str11, (i2 & 8388608) != 0 ? userData.movieLevel : i, (i2 & 16777216) != 0 ? userData.verifierStatus : j13, (i2 & AVLogger.LEVEL_LOG_INFO) != 0 ? userData.withdrawLevel : j14, (i2 & 67108864) != 0 ? userData.withdrawPrice : str12, (134217728 & i2) != 0 ? userData.levelEndTime : str13, (i2 & 268435456) != 0 ? userData.movieLevelName : str14, (i2 & 536870912) != 0 ? userData.alipayAccount : str15, (i2 & 1073741824) != 0 ? userData.alipayAccountName : str16);
    }

    /* renamed from: component1, reason: from getter */
    public final long getAgentAdmin() {
        return this.agentAdmin;
    }

    /* renamed from: component10, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: component11, reason: from getter */
    public final String getInviteUrl() {
        return this.inviteUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final long getIsVerifier() {
        return this.isVerifier;
    }

    /* renamed from: component13, reason: from getter */
    public final long getJoinVerifier() {
        return this.joinVerifier;
    }

    /* renamed from: component14, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* renamed from: component15, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component16, reason: from getter */
    public final long getPersonalCoin() {
        return this.personalCoin;
    }

    /* renamed from: component17, reason: from getter */
    public final String getPersonalWithdrawPrice() {
        return this.personalWithdrawPrice;
    }

    /* renamed from: component18, reason: from getter */
    public final long getScore() {
        return this.score;
    }

    /* renamed from: component19, reason: from getter */
    public final long getTeamCoin() {
        return this.teamCoin;
    }

    /* renamed from: component2, reason: from getter */
    public final long getAgentLevel() {
        return this.agentLevel;
    }

    /* renamed from: component20, reason: from getter */
    public final String getTeamWithdrawPrice() {
        return this.teamWithdrawPrice;
    }

    /* renamed from: component21, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* renamed from: component22, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component23, reason: from getter */
    public final String getUser_email() {
        return this.user_email;
    }

    /* renamed from: component24, reason: from getter */
    public final int getMovieLevel() {
        return this.movieLevel;
    }

    /* renamed from: component25, reason: from getter */
    public final long getVerifierStatus() {
        return this.verifierStatus;
    }

    /* renamed from: component26, reason: from getter */
    public final long getWithdrawLevel() {
        return this.withdrawLevel;
    }

    /* renamed from: component27, reason: from getter */
    public final String getWithdrawPrice() {
        return this.withdrawPrice;
    }

    /* renamed from: component28, reason: from getter */
    public final String getLevelEndTime() {
        return this.levelEndTime;
    }

    /* renamed from: component29, reason: from getter */
    public final String getMovieLevelName() {
        return this.movieLevelName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component30, reason: from getter */
    public final String getAlipayAccount() {
        return this.alipayAccount;
    }

    /* renamed from: component31, reason: from getter */
    public final String getAlipayAccountName() {
        return this.alipayAccountName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBindStatus() {
        return this.bindStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final long getBindType() {
        return this.bindType;
    }

    /* renamed from: component7, reason: from getter */
    public final long getCoin() {
        return this.coin;
    }

    /* renamed from: component8, reason: from getter */
    public final String getExchange() {
        return this.exchange;
    }

    /* renamed from: component9, reason: from getter */
    public final long getExpectReward() {
        return this.expectReward;
    }

    public final UserData copy(long agentAdmin, long agentLevel, String avatar, String balance, long bindStatus, long bindType, long coin, String exchange, long expectReward, String inviteCode, String inviteUrl, long isVerifier, long joinVerifier, String level, String nickname, long personalCoin, String personalWithdrawPrice, long score, long teamCoin, String teamWithdrawPrice, long uid, String username, String user_email, int movieLevel, long verifierStatus, long withdrawLevel, String withdrawPrice, String levelEndTime, String movieLevelName, String alipayAccount, String alipayAccountName) {
        Intrinsics.checkNotNullParameter(avatar, ILogConst.AD_CLICK_AVATAR);
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics.checkNotNullParameter(inviteUrl, "inviteUrl");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(personalWithdrawPrice, "personalWithdrawPrice");
        Intrinsics.checkNotNullParameter(teamWithdrawPrice, "teamWithdrawPrice");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(user_email, "user_email");
        Intrinsics.checkNotNullParameter(withdrawPrice, "withdrawPrice");
        Intrinsics.checkNotNullParameter(levelEndTime, "levelEndTime");
        Intrinsics.checkNotNullParameter(movieLevelName, "movieLevelName");
        return new UserData(agentAdmin, agentLevel, avatar, balance, bindStatus, bindType, coin, exchange, expectReward, inviteCode, inviteUrl, isVerifier, joinVerifier, level, nickname, personalCoin, personalWithdrawPrice, score, teamCoin, teamWithdrawPrice, uid, username, user_email, movieLevel, verifierStatus, withdrawLevel, withdrawPrice, levelEndTime, movieLevelName, alipayAccount, alipayAccountName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserData)) {
            return false;
        }
        UserData userData = (UserData) other;
        return this.agentAdmin == userData.agentAdmin && this.agentLevel == userData.agentLevel && Intrinsics.areEqual(this.avatar, userData.avatar) && Intrinsics.areEqual(this.balance, userData.balance) && this.bindStatus == userData.bindStatus && this.bindType == userData.bindType && this.coin == userData.coin && Intrinsics.areEqual(this.exchange, userData.exchange) && this.expectReward == userData.expectReward && Intrinsics.areEqual(this.inviteCode, userData.inviteCode) && Intrinsics.areEqual(this.inviteUrl, userData.inviteUrl) && this.isVerifier == userData.isVerifier && this.joinVerifier == userData.joinVerifier && Intrinsics.areEqual(this.level, userData.level) && Intrinsics.areEqual(this.nickname, userData.nickname) && this.personalCoin == userData.personalCoin && Intrinsics.areEqual(this.personalWithdrawPrice, userData.personalWithdrawPrice) && this.score == userData.score && this.teamCoin == userData.teamCoin && Intrinsics.areEqual(this.teamWithdrawPrice, userData.teamWithdrawPrice) && this.uid == userData.uid && Intrinsics.areEqual(this.username, userData.username) && Intrinsics.areEqual(this.user_email, userData.user_email) && this.movieLevel == userData.movieLevel && this.verifierStatus == userData.verifierStatus && this.withdrawLevel == userData.withdrawLevel && Intrinsics.areEqual(this.withdrawPrice, userData.withdrawPrice) && Intrinsics.areEqual(this.levelEndTime, userData.levelEndTime) && Intrinsics.areEqual(this.movieLevelName, userData.movieLevelName) && Intrinsics.areEqual(this.alipayAccount, userData.alipayAccount) && Intrinsics.areEqual(this.alipayAccountName, userData.alipayAccountName);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((Long.hashCode(this.agentAdmin) * 31) + Long.hashCode(this.agentLevel)) * 31) + this.avatar.hashCode()) * 31) + this.balance.hashCode()) * 31) + Long.hashCode(this.bindStatus)) * 31) + Long.hashCode(this.bindType)) * 31) + Long.hashCode(this.coin)) * 31) + this.exchange.hashCode()) * 31) + Long.hashCode(this.expectReward)) * 31) + this.inviteCode.hashCode()) * 31) + this.inviteUrl.hashCode()) * 31) + Long.hashCode(this.isVerifier)) * 31) + Long.hashCode(this.joinVerifier)) * 31) + this.level.hashCode()) * 31) + this.nickname.hashCode()) * 31) + Long.hashCode(this.personalCoin)) * 31) + this.personalWithdrawPrice.hashCode()) * 31) + Long.hashCode(this.score)) * 31) + Long.hashCode(this.teamCoin)) * 31) + this.teamWithdrawPrice.hashCode()) * 31) + Long.hashCode(this.uid)) * 31) + this.username.hashCode()) * 31) + this.user_email.hashCode()) * 31) + Integer.hashCode(this.movieLevel)) * 31) + Long.hashCode(this.verifierStatus)) * 31) + Long.hashCode(this.withdrawLevel)) * 31) + this.withdrawPrice.hashCode()) * 31) + this.levelEndTime.hashCode()) * 31) + this.movieLevelName.hashCode()) * 31;
        String str = this.alipayAccount;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.alipayAccountName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserData(agentAdmin=").append(this.agentAdmin).append(", agentLevel=").append(this.agentLevel).append(", avatar=").append(this.avatar).append(", balance=").append(this.balance).append(", bindStatus=").append(this.bindStatus).append(", bindType=").append(this.bindType).append(", coin=").append(this.coin).append(", exchange=").append(this.exchange).append(", expectReward=").append(this.expectReward).append(", inviteCode=").append(this.inviteCode).append(", inviteUrl=").append(this.inviteUrl).append(", isVerifier=");
        sb.append(this.isVerifier).append(", joinVerifier=").append(this.joinVerifier).append(", level=").append(this.level).append(", nickname=").append(this.nickname).append(", personalCoin=").append(this.personalCoin).append(", personalWithdrawPrice=").append(this.personalWithdrawPrice).append(", score=").append(this.score).append(", teamCoin=").append(this.teamCoin).append(", teamWithdrawPrice=").append(this.teamWithdrawPrice).append(", uid=").append(this.uid).append(", username=").append(this.username).append(", user_email=").append(this.user_email);
        sb.append(", movieLevel=").append(this.movieLevel).append(", verifierStatus=").append(this.verifierStatus).append(", withdrawLevel=").append(this.withdrawLevel).append(", withdrawPrice=").append(this.withdrawPrice).append(", levelEndTime=").append(this.levelEndTime).append(", movieLevelName=").append(this.movieLevelName).append(", alipayAccount=").append(this.alipayAccount).append(", alipayAccountName=").append(this.alipayAccountName).append(')');
        return sb.toString();
    }

    public UserData(long j, long j2, String str, String str2, long j3, long j4, long j5, String str3, long j6, String str4, String str5, long j7, long j8, String str6, String str7, long j9, String str8, long j10, long j11, String str9, long j12, String str10, String str11, int i, long j13, long j14, String str12, String str13, String str14, String str15, String str16) {
        Intrinsics.checkNotNullParameter(str, ILogConst.AD_CLICK_AVATAR);
        Intrinsics.checkNotNullParameter(str2, "balance");
        Intrinsics.checkNotNullParameter(str3, "exchange");
        Intrinsics.checkNotNullParameter(str4, "inviteCode");
        Intrinsics.checkNotNullParameter(str5, "inviteUrl");
        Intrinsics.checkNotNullParameter(str6, "level");
        Intrinsics.checkNotNullParameter(str7, "nickname");
        Intrinsics.checkNotNullParameter(str8, "personalWithdrawPrice");
        Intrinsics.checkNotNullParameter(str9, "teamWithdrawPrice");
        Intrinsics.checkNotNullParameter(str10, "username");
        Intrinsics.checkNotNullParameter(str11, "user_email");
        Intrinsics.checkNotNullParameter(str12, "withdrawPrice");
        Intrinsics.checkNotNullParameter(str13, "levelEndTime");
        Intrinsics.checkNotNullParameter(str14, "movieLevelName");
        this.agentAdmin = j;
        this.agentLevel = j2;
        this.avatar = str;
        this.balance = str2;
        this.bindStatus = j3;
        this.bindType = j4;
        this.coin = j5;
        this.exchange = str3;
        this.expectReward = j6;
        this.inviteCode = str4;
        this.inviteUrl = str5;
        this.isVerifier = j7;
        this.joinVerifier = j8;
        this.level = str6;
        this.nickname = str7;
        this.personalCoin = j9;
        this.personalWithdrawPrice = str8;
        this.score = j10;
        this.teamCoin = j11;
        this.teamWithdrawPrice = str9;
        this.uid = j12;
        this.username = str10;
        this.user_email = str11;
        this.movieLevel = i;
        this.verifierStatus = j13;
        this.withdrawLevel = j14;
        this.withdrawPrice = str12;
        this.levelEndTime = str13;
        this.movieLevelName = str14;
        this.alipayAccount = str15;
        this.alipayAccountName = str16;
    }

    public final long getAgentAdmin() {
        return this.agentAdmin;
    }

    public final long getAgentLevel() {
        return this.agentLevel;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final long getBindStatus() {
        return this.bindStatus;
    }

    public final long getBindType() {
        return this.bindType;
    }

    public final long getCoin() {
        return this.coin;
    }

    public final String getExchange() {
        return this.exchange;
    }

    public final long getExpectReward() {
        return this.expectReward;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final String getInviteUrl() {
        return this.inviteUrl;
    }

    public final long isVerifier() {
        return this.isVerifier;
    }

    public final long getJoinVerifier() {
        return this.joinVerifier;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final long getPersonalCoin() {
        return this.personalCoin;
    }

    public final String getPersonalWithdrawPrice() {
        return this.personalWithdrawPrice;
    }

    public final long getScore() {
        return this.score;
    }

    public final long getTeamCoin() {
        return this.teamCoin;
    }

    public final String getTeamWithdrawPrice() {
        return this.teamWithdrawPrice;
    }

    public final long getUid() {
        return this.uid;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getUser_email() {
        return this.user_email;
    }

    public final int getMovieLevel() {
        return this.movieLevel;
    }

    public final long getVerifierStatus() {
        return this.verifierStatus;
    }

    public final long getWithdrawLevel() {
        return this.withdrawLevel;
    }

    public final String getWithdrawPrice() {
        return this.withdrawPrice;
    }

    public final String getLevelEndTime() {
        return this.levelEndTime;
    }

    public final String getMovieLevelName() {
        return this.movieLevelName;
    }

    public final String getAlipayAccount() {
        return this.alipayAccount;
    }

    public final String getAlipayAccountName() {
        return this.alipayAccountName;
    }
}
