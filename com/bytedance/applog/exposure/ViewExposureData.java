package com.bytedance.applog.exposure;

import com.bytedance.bdtracker.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/applog/exposure/ViewExposureData;", "", "eventName", "", "properties", "Lorg/json/JSONObject;", "config", "Lcom/bytedance/applog/exposure/ViewExposureConfig;", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/applog/exposure/ViewExposureConfig;)V", "getConfig", "()Lcom/bytedance/applog/exposure/ViewExposureConfig;", "setConfig", "(Lcom/bytedance/applog/exposure/ViewExposureConfig;)V", "getEventName", "()Ljava/lang/String;", "getProperties", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class ViewExposureData {
    public final String a;
    public final JSONObject b;
    public ViewExposureConfig c;

    public ViewExposureData() {
        this(null, null, null, 7, null);
    }

    public ViewExposureData(String str, JSONObject jSONObject, ViewExposureConfig viewExposureConfig) {
        this.a = str;
        this.b = jSONObject;
        this.c = viewExposureConfig;
    }

    public /* synthetic */ ViewExposureData(String str, JSONObject jSONObject, ViewExposureConfig viewExposureConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : jSONObject, (i & 4) != 0 ? null : viewExposureConfig);
    }

    public static /* synthetic */ ViewExposureData copy$default(ViewExposureData viewExposureData, String str, JSONObject jSONObject, ViewExposureConfig viewExposureConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = viewExposureData.a;
        }
        if ((i & 2) != 0) {
            jSONObject = viewExposureData.b;
        }
        if ((i & 4) != 0) {
            viewExposureConfig = viewExposureData.c;
        }
        return viewExposureData.copy(str, jSONObject, viewExposureConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getB() {
        return this.b;
    }

    /* renamed from: component3, reason: from getter */
    public final ViewExposureConfig getC() {
        return this.c;
    }

    public final ViewExposureData copy(String eventName, JSONObject properties, ViewExposureConfig config) {
        return new ViewExposureData(eventName, properties, config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewExposureData)) {
            return false;
        }
        ViewExposureData viewExposureData = (ViewExposureData) other;
        return Intrinsics.areEqual(this.a, viewExposureData.a) && Intrinsics.areEqual(this.b, viewExposureData.b) && Intrinsics.areEqual(this.c, viewExposureData.c);
    }

    public final ViewExposureConfig getConfig() {
        return this.c;
    }

    public final String getEventName() {
        return this.a;
    }

    public final JSONObject getProperties() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        JSONObject jSONObject = this.b;
        int iHashCode2 = (iHashCode + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        ViewExposureConfig viewExposureConfig = this.c;
        return iHashCode2 + (viewExposureConfig != null ? viewExposureConfig.hashCode() : 0);
    }

    public final void setConfig(ViewExposureConfig viewExposureConfig) {
        this.c = viewExposureConfig;
    }

    public String toString() {
        return a.a("ViewExposureData(eventName=").append(this.a).append(", properties=").append(this.b).append(", config=").append(this.c).append(")").toString();
    }
}
