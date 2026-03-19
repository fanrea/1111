package com.bytedance.sdk.commonsdk.api.detector_api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAPSdkEvent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/IAPSdkEvent;", "", "eventType", "", "extra", "", "", "(ILjava/util/Map;)V", "getEventType", "()I", "getExtra", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "IAPSdk", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class IAPSdkEvent {
    public static final int IAP_EVENT_TYPE_SDK_EXIST = 2001;
    public static final int IAP_EVENT_TYPE_SDK_NOT_EXIST = 2002;
    public static final String IAP_EXTRA_KEY_SDK_LIST = "sdk_list";
    private final int eventType;
    private final Map<String, Object> extra;

    /* compiled from: IAPSdkEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/IAPSdkEvent$IAPSdk;", "", "(Ljava/lang/String;I)V", "IAP_SDK_ALIPAY", "IAP_SDK_WX", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum IAPSdk {
        IAP_SDK_ALIPAY,
        IAP_SDK_WX
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IAPSdkEvent copy$default(IAPSdkEvent iAPSdkEvent, int i, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iAPSdkEvent.eventType;
        }
        if ((i2 & 2) != 0) {
            map = iAPSdkEvent.extra;
        }
        return iAPSdkEvent.copy(i, map);
    }

    /* renamed from: component1, reason: from getter */
    public final int getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> component2() {
        return this.extra;
    }

    public final IAPSdkEvent copy(int eventType, Map<String, ? extends Object> extra) {
        return new IAPSdkEvent(eventType, extra);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IAPSdkEvent)) {
            return false;
        }
        IAPSdkEvent iAPSdkEvent = (IAPSdkEvent) other;
        return this.eventType == iAPSdkEvent.eventType && Intrinsics.areEqual(this.extra, iAPSdkEvent.extra);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.eventType) * 31;
        Map<String, Object> map = this.extra;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "IAPSdkEvent(eventType=" + this.eventType + ", extra=" + this.extra + ')';
    }

    public IAPSdkEvent(int i, Map<String, ? extends Object> map) {
        this.eventType = i;
        this.extra = map;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }
}
