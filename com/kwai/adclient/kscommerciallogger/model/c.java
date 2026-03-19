package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private final BusinessType biz;
    private final d bua;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.category = aVar.crC;
        this.biz = aVar.crD;
        this.subBiz = aVar.crE;
        this.tag = aVar.mTag;
        this.bua = aVar.crF;
        this.extraParam = aVar.crG;
        this.eventId = aVar.crH;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }

    public final String ars() {
        return this.category;
    }

    public final SubBusinessType art() {
        return this.subBiz;
    }

    public final d aru() {
        return this.bua;
    }

    public final JSONObject arv() {
        return this.msg;
    }

    public final JSONObject arw() {
        return this.extraParam;
    }

    public final String arx() {
        return this.eventId;
    }

    public final String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put(com.alipay.sdk.m.k.b.l, businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.bua;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static class a {
        private final String crC;
        private BusinessType crD;
        private SubBusinessType crE;
        private d crF;
        private JSONObject crG;
        private String crH;
        private String mTag;
        private JSONObject msg;

        private a(String str) {
            this.crC = str;
        }

        public static a ary() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a arz() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a c(BusinessType businessType) {
            this.crD = businessType;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.crE = subBusinessType;
            return this;
        }

        public final a ji(String str) {
            this.mTag = str;
            return this;
        }

        public final a b(d dVar) {
            this.crF = dVar;
            return this;
        }

        public final a jj(String str) {
            this.crH = str;
            return this;
        }

        public final a t(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c arA() {
            if (com.kwai.adclient.kscommerciallogger.a.arp().isDebug()) {
                if (TextUtils.isEmpty(this.crC) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.crH)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.arp().arr() && !com.kwai.adclient.kscommerciallogger.b.jh(this.crH)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.crC) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.crH)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.arp().arr() && !com.kwai.adclient.kscommerciallogger.b.jh(this.crH)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.arp().arq() != null) {
                this.crG = com.kwai.adclient.kscommerciallogger.a.arp().arq();
            }
            return new c(this, (byte) 0);
        }
    }
}
