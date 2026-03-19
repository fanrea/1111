package com.dhylive.app.data.mine;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VipLevelInfo.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/dhylive/app/data/mine/VipLevelInfo;", "Ljava/io/Serializable;", "level", "", "Lcom/dhylive/app/data/mine/Level;", "(Ljava/util/List;)V", "getLevel", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class VipLevelInfo implements Serializable {
    private final List<Level> level;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VipLevelInfo copy$default(VipLevelInfo vipLevelInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = vipLevelInfo.level;
        }
        return vipLevelInfo.copy(list);
    }

    public final List<Level> component1() {
        return this.level;
    }

    public final VipLevelInfo copy(List<Level> level) {
        return new VipLevelInfo(level);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VipLevelInfo) && Intrinsics.areEqual(this.level, ((VipLevelInfo) other).level);
    }

    public int hashCode() {
        List<Level> list = this.level;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "VipLevelInfo(level=" + this.level + ')';
    }

    public VipLevelInfo(List<Level> list) {
        this.level = list;
    }

    public final List<Level> getLevel() {
        return this.level;
    }
}
