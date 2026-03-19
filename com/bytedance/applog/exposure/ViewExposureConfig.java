package com.bytedance.applog.exposure;

import com.bytedance.bdtracker.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applog/exposure/ViewExposureConfig;", "", "areaRatio", "", "visualDiagnosis", "", "(Ljava/lang/Float;Ljava/lang/Boolean;)V", "getAreaRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getVisualDiagnosis", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Boolean;)Lcom/bytedance/applog/exposure/ViewExposureConfig;", "equals", "other", "hashCode", "", "toString", "", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class ViewExposureConfig {
    public final Float a;
    public final Boolean b;

    public ViewExposureConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewExposureConfig(Float f) {
        Boolean bool = null;
        this(f, bool, 2, bool);
    }

    public ViewExposureConfig(Float f, Boolean bool) {
        this.a = f;
        this.b = bool;
    }

    public /* synthetic */ ViewExposureConfig(Float f, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? false : bool);
    }

    public static /* synthetic */ ViewExposureConfig copy$default(ViewExposureConfig viewExposureConfig, Float f, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            f = viewExposureConfig.a;
        }
        if ((i & 2) != 0) {
            bool = viewExposureConfig.b;
        }
        return viewExposureConfig.copy(f, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final Float getA() {
        return this.a;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getB() {
        return this.b;
    }

    public final ViewExposureConfig copy(Float areaRatio, Boolean visualDiagnosis) {
        return new ViewExposureConfig(areaRatio, visualDiagnosis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewExposureConfig)) {
            return false;
        }
        ViewExposureConfig viewExposureConfig = (ViewExposureConfig) other;
        return Intrinsics.areEqual(this.a, viewExposureConfig.a) && Intrinsics.areEqual(this.b, viewExposureConfig.b);
    }

    public final Float getAreaRatio() {
        return this.a;
    }

    public final Boolean getVisualDiagnosis() {
        return this.b;
    }

    public int hashCode() {
        Float f = this.a;
        int iHashCode = (f != null ? f.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return a.a("ViewExposureConfig(areaRatio=").append(this.a).append(", visualDiagnosis=").append(this.b).append(")").toString();
    }
}
