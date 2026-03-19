package com.dhylive.app.data.mine;

import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: ConfigurationInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006("}, d2 = {"Lcom/dhylive/app/data/mine/InterstitialAdShow;", "Ljava/io/Serializable;", "mine", "", FeedReqParams.REQ_TYPE_OPEN, "pass", "sign_in", "stay", "task", "team", "ad", "withdraw", "(IIIIIIIII)V", "getAd", "()I", "getMine", "getOpen", "getPass", "getSign_in", "getStay", "getTask", "getTeam", "getWithdraw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class InterstitialAdShow implements Serializable {
    private final int ad;
    private final int mine;
    private final int open;
    private final int pass;
    private final int sign_in;
    private final int stay;
    private final int task;
    private final int team;
    private final int withdraw;

    /* renamed from: component1, reason: from getter */
    public final int getMine() {
        return this.mine;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOpen() {
        return this.open;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPass() {
        return this.pass;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSign_in() {
        return this.sign_in;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStay() {
        return this.stay;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTask() {
        return this.task;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTeam() {
        return this.team;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAd() {
        return this.ad;
    }

    /* renamed from: component9, reason: from getter */
    public final int getWithdraw() {
        return this.withdraw;
    }

    public final InterstitialAdShow copy(int mine, int open, int pass, int sign_in, int stay, int task, int team, int ad, int withdraw) {
        return new InterstitialAdShow(mine, open, pass, sign_in, stay, task, team, ad, withdraw);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InterstitialAdShow)) {
            return false;
        }
        InterstitialAdShow interstitialAdShow = (InterstitialAdShow) other;
        return this.mine == interstitialAdShow.mine && this.open == interstitialAdShow.open && this.pass == interstitialAdShow.pass && this.sign_in == interstitialAdShow.sign_in && this.stay == interstitialAdShow.stay && this.task == interstitialAdShow.task && this.team == interstitialAdShow.team && this.ad == interstitialAdShow.ad && this.withdraw == interstitialAdShow.withdraw;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.mine) * 31) + Integer.hashCode(this.open)) * 31) + Integer.hashCode(this.pass)) * 31) + Integer.hashCode(this.sign_in)) * 31) + Integer.hashCode(this.stay)) * 31) + Integer.hashCode(this.task)) * 31) + Integer.hashCode(this.team)) * 31) + Integer.hashCode(this.ad)) * 31) + Integer.hashCode(this.withdraw);
    }

    public String toString() {
        return "InterstitialAdShow(mine=" + this.mine + ", open=" + this.open + ", pass=" + this.pass + ", sign_in=" + this.sign_in + ", stay=" + this.stay + ", task=" + this.task + ", team=" + this.team + ", ad=" + this.ad + ", withdraw=" + this.withdraw + ')';
    }

    public InterstitialAdShow(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mine = i;
        this.open = i2;
        this.pass = i3;
        this.sign_in = i4;
        this.stay = i5;
        this.task = i6;
        this.team = i7;
        this.ad = i8;
        this.withdraw = i9;
    }

    public final int getMine() {
        return this.mine;
    }

    public final int getOpen() {
        return this.open;
    }

    public final int getPass() {
        return this.pass;
    }

    public final int getSign_in() {
        return this.sign_in;
    }

    public final int getStay() {
        return this.stay;
    }

    public final int getTask() {
        return this.task;
    }

    public final int getTeam() {
        return this.team;
    }

    public final int getAd() {
        return this.ad;
    }

    public final int getWithdraw() {
        return this.withdraw;
    }
}
