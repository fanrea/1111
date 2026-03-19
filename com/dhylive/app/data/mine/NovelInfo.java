package com.dhylive.app.data.mine;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NovelInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006$"}, d2 = {"Lcom/dhylive/app/data/mine/NovelInfo;", "Ljava/io/Serializable;", "novel_status", "", "novel_num", "novel_reward_ad_id", "", "novel_unlock_num", "novel_unlock_status", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNovel_num", "()I", "setNovel_num", "(I)V", "getNovel_reward_ad_id", "()Ljava/lang/String;", "setNovel_reward_ad_id", "(Ljava/lang/String;)V", "getNovel_status", "setNovel_status", "getNovel_unlock_num", "setNovel_unlock_num", "getNovel_unlock_status", "setNovel_unlock_status", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class NovelInfo implements Serializable {
    private int novel_num;
    private String novel_reward_ad_id;
    private int novel_status;
    private String novel_unlock_num;
    private String novel_unlock_status;

    public static /* synthetic */ NovelInfo copy$default(NovelInfo novelInfo, int i, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = novelInfo.novel_status;
        }
        if ((i3 & 2) != 0) {
            i2 = novelInfo.novel_num;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = novelInfo.novel_reward_ad_id;
        }
        String str4 = str;
        if ((i3 & 8) != 0) {
            str2 = novelInfo.novel_unlock_num;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = novelInfo.novel_unlock_status;
        }
        return novelInfo.copy(i, i4, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNovel_status() {
        return this.novel_status;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNovel_num() {
        return this.novel_num;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNovel_reward_ad_id() {
        return this.novel_reward_ad_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNovel_unlock_num() {
        return this.novel_unlock_num;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNovel_unlock_status() {
        return this.novel_unlock_status;
    }

    public final NovelInfo copy(int novel_status, int novel_num, String novel_reward_ad_id, String novel_unlock_num, String novel_unlock_status) {
        Intrinsics.checkNotNullParameter(novel_reward_ad_id, "novel_reward_ad_id");
        Intrinsics.checkNotNullParameter(novel_unlock_num, "novel_unlock_num");
        Intrinsics.checkNotNullParameter(novel_unlock_status, "novel_unlock_status");
        return new NovelInfo(novel_status, novel_num, novel_reward_ad_id, novel_unlock_num, novel_unlock_status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NovelInfo)) {
            return false;
        }
        NovelInfo novelInfo = (NovelInfo) other;
        return this.novel_status == novelInfo.novel_status && this.novel_num == novelInfo.novel_num && Intrinsics.areEqual(this.novel_reward_ad_id, novelInfo.novel_reward_ad_id) && Intrinsics.areEqual(this.novel_unlock_num, novelInfo.novel_unlock_num) && Intrinsics.areEqual(this.novel_unlock_status, novelInfo.novel_unlock_status);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.novel_status) * 31) + Integer.hashCode(this.novel_num)) * 31) + this.novel_reward_ad_id.hashCode()) * 31) + this.novel_unlock_num.hashCode()) * 31) + this.novel_unlock_status.hashCode();
    }

    public String toString() {
        return "NovelInfo(novel_status=" + this.novel_status + ", novel_num=" + this.novel_num + ", novel_reward_ad_id=" + this.novel_reward_ad_id + ", novel_unlock_num=" + this.novel_unlock_num + ", novel_unlock_status=" + this.novel_unlock_status + ')';
    }

    public NovelInfo(int i, int i2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "novel_reward_ad_id");
        Intrinsics.checkNotNullParameter(str2, "novel_unlock_num");
        Intrinsics.checkNotNullParameter(str3, "novel_unlock_status");
        this.novel_status = i;
        this.novel_num = i2;
        this.novel_reward_ad_id = str;
        this.novel_unlock_num = str2;
        this.novel_unlock_status = str3;
    }

    public final int getNovel_status() {
        return this.novel_status;
    }

    public final void setNovel_status(int i) {
        this.novel_status = i;
    }

    public final int getNovel_num() {
        return this.novel_num;
    }

    public final void setNovel_num(int i) {
        this.novel_num = i;
    }

    public final String getNovel_reward_ad_id() {
        return this.novel_reward_ad_id;
    }

    public final void setNovel_reward_ad_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.novel_reward_ad_id = str;
    }

    public final String getNovel_unlock_num() {
        return this.novel_unlock_num;
    }

    public final void setNovel_unlock_num(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.novel_unlock_num = str;
    }

    public final String getNovel_unlock_status() {
        return this.novel_unlock_status;
    }

    public final void setNovel_unlock_status(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.novel_unlock_status = str;
    }
}
