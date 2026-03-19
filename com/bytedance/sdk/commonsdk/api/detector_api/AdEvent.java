package com.bytedance.sdk.commonsdk.api.detector_api;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdEvent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/AdEvent;", "", "eventType", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdEventType;", "adType", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdType;", "extra", "Landroid/os/Bundle;", "(Lcom/bytedance/sdk/commonsdk/api/detector_api/AdEventType;Lcom/bytedance/sdk/commonsdk/api/detector_api/AdType;Landroid/os/Bundle;)V", "getAdType", "()Lcom/bytedance/sdk/commonsdk/api/detector_api/AdType;", "getEventType", "()Lcom/bytedance/sdk/commonsdk/api/detector_api/AdEventType;", "getExtra", "()Landroid/os/Bundle;", "Companion", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AdEvent {
    public static final String EXTRA_KEY_ACTIVITY_NAME = "activity_name";
    public static final String EXTRA_KEY_DURATION = "duration";
    private final AdType adType;
    private final AdEventType eventType;
    private final Bundle extra;

    public AdEvent(AdEventType adEventType, AdType adType, Bundle bundle) {
        Intrinsics.checkNotNullParameter(adEventType, "eventType");
        Intrinsics.checkNotNullParameter(adType, "adType");
        this.eventType = adEventType;
        this.adType = adType;
        this.extra = bundle;
    }

    public /* synthetic */ AdEvent(AdEventType adEventType, AdType adType, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adEventType, adType, (i & 4) != 0 ? null : bundle);
    }

    public final AdType getAdType() {
        return this.adType;
    }

    public final AdEventType getEventType() {
        return this.eventType;
    }

    public final Bundle getExtra() {
        return this.extra;
    }
}
