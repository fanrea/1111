package com.kwad.sdk.commercial;

import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public double btV = 0.01d;
    public double btW = 1.0d;
    public double btX = 0.001d;
    public BusinessType btY = BusinessType.OTHER;
    public SubBusinessType btZ = SubBusinessType.OTHER;
    public com.kwai.adclient.kscommerciallogger.model.d bua;
    public String category;
    public String eventId;
    public JSONObject msg;
    public String primaryKey;
    public String tag;

    private c() {
    }

    public static c Wz() {
        return new c();
    }

    public final c l(double d) {
        this.btV = d;
        return this;
    }

    public final c m(double d) {
        this.btW = d;
        return this;
    }

    public final c n(double d) {
        this.btX = 0.001d;
        return this;
    }

    public final c dW(String str) {
        this.category = str;
        return this;
    }

    public final c V(String str, String str2) {
        this.eventId = str;
        this.primaryKey = str2;
        return this;
    }

    public final c b(BusinessType businessType) {
        this.btY = businessType;
        return this;
    }

    public final c a(SubBusinessType subBusinessType) {
        this.btZ = subBusinessType;
        return this;
    }

    public final c dX(String str) {
        this.tag = str;
        return this;
    }

    @Deprecated
    public final c l(JSONObject jSONObject) {
        this.msg = jSONObject;
        return this;
    }

    public final c w(com.kwad.sdk.commercial.c.a aVar) {
        this.msg = aVar.toJson();
        return this;
    }

    public final c a(com.kwai.adclient.kscommerciallogger.model.d dVar) {
        this.bua = dVar;
        return this;
    }

    public final String toString() {
        return "ReportItem{category='" + this.category + "', eventId='" + this.eventId + "', bizType='" + this.btY + "', primaryKey='" + this.primaryKey + "', msg=" + this.msg + '}';
    }
}
