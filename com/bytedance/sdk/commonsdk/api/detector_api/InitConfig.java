package com.bytedance.sdk.commonsdk.api.detector_api;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/InitConfig;", "", "context", "Landroid/content/Context;", "siteId", "", "bizName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "adActInfos", "", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdActInfo;", "getBizName", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getSiteId", "getAdActInfos", "setAdActInfos", "", "infos", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class InitConfig {
    private List<AdActInfo> adActInfos;
    private final String bizName;
    private final Context context;
    private final String siteId;

    public InitConfig(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "siteId");
        Intrinsics.checkNotNullParameter(str2, "bizName");
        this.context = context;
        this.siteId = str;
        this.bizName = str2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final List<AdActInfo> getAdActInfos() {
        return this.adActInfos;
    }

    public final void setAdActInfos(List<AdActInfo> infos) {
        this.adActInfos = infos;
    }
}
