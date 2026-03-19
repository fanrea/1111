package com.dhylive.app.data.mine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WithdrawSettingInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/dhylive/app/data/mine/Alipay;", "", "account", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccount", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class Alipay {
    private final String account;
    private final String name;

    public static /* synthetic */ Alipay copy$default(Alipay alipay, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alipay.account;
        }
        if ((i & 2) != 0) {
            str2 = alipay.name;
        }
        return alipay.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccount() {
        return this.account;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Alipay copy(String account, String name) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(name, "name");
        return new Alipay(account, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Alipay)) {
            return false;
        }
        Alipay alipay = (Alipay) other;
        return Intrinsics.areEqual(this.account, alipay.account) && Intrinsics.areEqual(this.name, alipay.name);
    }

    public int hashCode() {
        return (this.account.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "Alipay(account=" + this.account + ", name=" + this.name + ')';
    }

    public Alipay(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "account");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.account = str;
        this.name = str2;
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getName() {
        return this.name;
    }
}
