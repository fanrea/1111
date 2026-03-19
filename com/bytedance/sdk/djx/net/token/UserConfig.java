package com.bytedance.sdk.djx.net.token;

import com.dhylive.app.utils.JumpParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/djx/net/token/UserConfig;", "", JumpParam.USER_ID, "", "userType", "", "userOUID", "loginType", "recommendSwitch", "", "userMeta", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getLoginType", "()Ljava/lang/String;", "getRecommendSwitch", "()Z", "getUserId", "getUserMeta", "getUserOUID", "getUserType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class UserConfig {
    private final String loginType;
    private final boolean recommendSwitch;
    private final String userId;
    private final String userMeta;
    private final String userOUID;
    private final int userType;

    public static /* synthetic */ UserConfig copy$default(UserConfig userConfig, String str, int i, String str2, String str3, boolean z, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userConfig.userId;
        }
        if ((i2 & 2) != 0) {
            i = userConfig.userType;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = userConfig.userOUID;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = userConfig.loginType;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            z = userConfig.recommendSwitch;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            str4 = userConfig.userMeta;
        }
        return userConfig.copy(str, i3, str5, str6, z2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserOUID() {
        return this.userOUID;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLoginType() {
        return this.loginType;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRecommendSwitch() {
        return this.recommendSwitch;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserMeta() {
        return this.userMeta;
    }

    public final UserConfig copy(String userId, int userType, String userOUID, String loginType, boolean recommendSwitch, String userMeta) {
        Intrinsics.checkNotNullParameter(userId, JumpParam.USER_ID);
        Intrinsics.checkNotNullParameter(userOUID, "userOUID");
        Intrinsics.checkNotNullParameter(loginType, "loginType");
        Intrinsics.checkNotNullParameter(userMeta, "userMeta");
        return new UserConfig(userId, userType, userOUID, loginType, recommendSwitch, userMeta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserConfig)) {
            return false;
        }
        UserConfig userConfig = (UserConfig) other;
        return Intrinsics.areEqual(this.userId, userConfig.userId) && this.userType == userConfig.userType && Intrinsics.areEqual(this.userOUID, userConfig.userOUID) && Intrinsics.areEqual(this.loginType, userConfig.loginType) && this.recommendSwitch == userConfig.recommendSwitch && Intrinsics.areEqual(this.userMeta, userConfig.userMeta);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((this.userId.hashCode() * 31) + Integer.hashCode(this.userType)) * 31) + this.userOUID.hashCode()) * 31) + this.loginType.hashCode()) * 31;
        boolean z = this.recommendSwitch;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((iHashCode + i) * 31) + this.userMeta.hashCode();
    }

    public String toString() {
        return "UserConfig(userId=" + this.userId + ", userType=" + this.userType + ", userOUID=" + this.userOUID + ", loginType=" + this.loginType + ", recommendSwitch=" + this.recommendSwitch + ", userMeta=" + this.userMeta + ')';
    }

    public UserConfig(String str, int i, String str2, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(str, JumpParam.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "userOUID");
        Intrinsics.checkNotNullParameter(str3, "loginType");
        Intrinsics.checkNotNullParameter(str4, "userMeta");
        this.userId = str;
        this.userType = i;
        this.userOUID = str2;
        this.loginType = str3;
        this.recommendSwitch = z;
        this.userMeta = str4;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getUserOUID() {
        return this.userOUID;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final boolean getRecommendSwitch() {
        return this.recommendSwitch;
    }

    public final String getUserMeta() {
        return this.userMeta;
    }
}
