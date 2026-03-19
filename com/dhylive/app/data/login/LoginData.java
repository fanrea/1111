package com.dhylive.app.data.login;

import com.google.gson.annotations.SerializedName;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/dhylive/app/data/login/LoginData;", "Ljava/io/Serializable;", NetworkDefine.PARAM_TOKEN, "", "shopToken", "nickname", "mobile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMobile", "()Ljava/lang/String;", "getNickname", "getShopToken", "getToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class LoginData implements Serializable {
    private final String mobile;
    private final String nickname;

    @SerializedName("shop_token")
    private final String shopToken;
    private final String token;

    public static /* synthetic */ LoginData copy$default(LoginData loginData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginData.token;
        }
        if ((i & 2) != 0) {
            str2 = loginData.shopToken;
        }
        if ((i & 4) != 0) {
            str3 = loginData.nickname;
        }
        if ((i & 8) != 0) {
            str4 = loginData.mobile;
        }
        return loginData.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final String getShopToken() {
        return this.shopToken;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMobile() {
        return this.mobile;
    }

    public final LoginData copy(String token, String shopToken, String nickname, String mobile) {
        Intrinsics.checkNotNullParameter(token, NetworkDefine.PARAM_TOKEN);
        Intrinsics.checkNotNullParameter(shopToken, "shopToken");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        return new LoginData(token, shopToken, nickname, mobile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginData)) {
            return false;
        }
        LoginData loginData = (LoginData) other;
        return Intrinsics.areEqual(this.token, loginData.token) && Intrinsics.areEqual(this.shopToken, loginData.shopToken) && Intrinsics.areEqual(this.nickname, loginData.nickname) && Intrinsics.areEqual(this.mobile, loginData.mobile);
    }

    public int hashCode() {
        return (((((this.token.hashCode() * 31) + this.shopToken.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.mobile.hashCode();
    }

    public String toString() {
        return "LoginData(token=" + this.token + ", shopToken=" + this.shopToken + ", nickname=" + this.nickname + ", mobile=" + this.mobile + ')';
    }

    public LoginData(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, NetworkDefine.PARAM_TOKEN);
        Intrinsics.checkNotNullParameter(str2, "shopToken");
        Intrinsics.checkNotNullParameter(str3, "nickname");
        Intrinsics.checkNotNullParameter(str4, "mobile");
        this.token = str;
        this.shopToken = str2;
        this.nickname = str3;
        this.mobile = str4;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getShopToken() {
        return this.shopToken;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getMobile() {
        return this.mobile;
    }
}
