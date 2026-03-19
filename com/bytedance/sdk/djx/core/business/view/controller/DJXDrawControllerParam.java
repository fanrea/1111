package com.bytedance.sdk.djx.core.business.view.controller;

import com.bytedance.sdk.djx.params.DJXWidgetParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DJXDrawControllerParam.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/view/controller/DJXDrawControllerParam;", "Lcom/bytedance/sdk/djx/params/DJXWidgetParam;", "hideLikeBtn", "", "hideFavorBtn", "(ZZ)V", "getHideFavorBtn", "()Z", "getHideLikeBtn", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DJXDrawControllerParam extends DJXWidgetParam {
    private final boolean hideFavorBtn;
    private final boolean hideLikeBtn;

    /* JADX WARN: Illegal instructions before constructor call */
    public DJXDrawControllerParam() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ DJXDrawControllerParam copy$default(DJXDrawControllerParam dJXDrawControllerParam, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dJXDrawControllerParam.hideLikeBtn;
        }
        if ((i & 2) != 0) {
            z2 = dJXDrawControllerParam.hideFavorBtn;
        }
        return dJXDrawControllerParam.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHideLikeBtn() {
        return this.hideLikeBtn;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHideFavorBtn() {
        return this.hideFavorBtn;
    }

    public final DJXDrawControllerParam copy(boolean hideLikeBtn, boolean hideFavorBtn) {
        return new DJXDrawControllerParam(hideLikeBtn, hideFavorBtn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DJXDrawControllerParam)) {
            return false;
        }
        DJXDrawControllerParam dJXDrawControllerParam = (DJXDrawControllerParam) other;
        return this.hideLikeBtn == dJXDrawControllerParam.hideLikeBtn && this.hideFavorBtn == dJXDrawControllerParam.hideFavorBtn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.hideLikeBtn;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.hideFavorBtn;
        return i + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "DJXDrawControllerParam(hideLikeBtn=" + this.hideLikeBtn + ", hideFavorBtn=" + this.hideFavorBtn + ')';
    }

    public /* synthetic */ DJXDrawControllerParam(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public final boolean getHideLikeBtn() {
        return this.hideLikeBtn;
    }

    public final boolean getHideFavorBtn() {
        return this.hideFavorBtn;
    }

    public DJXDrawControllerParam(boolean z, boolean z2) {
        this.hideLikeBtn = z;
        this.hideFavorBtn = z2;
    }
}
