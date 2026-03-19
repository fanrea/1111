package com.kwai.kanas.interfaces;

import com.alipay.sdk.m.u.i;
import com.kwai.kanas.interfaces.CustomProtoEvent;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class b extends CustomProtoEvent {
    private final String a;
    private final CommonParams b;
    private final String c;
    private final JSONObject d;

    private b(String str, CommonParams commonParams, String str2, JSONObject jSONObject) {
        this.a = str;
        this.b = commonParams;
        this.c = str2;
        this.d = jSONObject;
    }

    @Override // com.kwai.kanas.interfaces.CustomProtoEvent
    public final String eventId() {
        return this.a;
    }

    @Override // com.kwai.kanas.interfaces.CustomProtoEvent
    public final CommonParams commonParams() {
        return this.b;
    }

    @Override // com.kwai.kanas.interfaces.CustomProtoEvent
    public final String type() {
        return this.c;
    }

    @Override // com.kwai.kanas.interfaces.CustomProtoEvent
    public final JSONObject payload() {
        return this.d;
    }

    public final String toString() {
        return "CustomProtoEvent{eventId=" + this.a + ", commonParams=" + this.b + ", type=" + this.c + ", payload=" + this.d + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CustomProtoEvent) {
            CustomProtoEvent customProtoEvent = (CustomProtoEvent) obj;
            String str = this.a;
            if (str != null ? str.equals(customProtoEvent.eventId()) : customProtoEvent.eventId() == null) {
                if (this.b.equals(customProtoEvent.commonParams()) && this.c.equals(customProtoEvent.type()) && this.d.toString().equals(this.d.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return (((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.toString().hashCode();
    }

    @Override // com.kwai.kanas.interfaces.CustomProtoEvent
    public final CustomProtoEvent.Builder toBuilder() {
        return new a(this);
    }

    static final class a extends CustomProtoEvent.Builder {
        private String a;
        private CommonParams b;
        private String c;
        private JSONObject d;

        a() {
        }

        private a(CustomProtoEvent customProtoEvent) {
            this.a = customProtoEvent.eventId();
            this.b = customProtoEvent.commonParams();
            this.c = customProtoEvent.type();
            this.d = customProtoEvent.payload();
        }

        @Override // com.kwai.kanas.interfaces.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder eventId(String str) {
            this.a = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder commonParams(CommonParams commonParams) {
            if (commonParams == null) {
                throw new NullPointerException("Null commonParams");
            }
            this.b = commonParams;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder type(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.c = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder payload(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new NullPointerException("Null payload");
            }
            this.d = jSONObject;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomProtoEvent.Builder
        final CustomProtoEvent a() {
            String str = "";
            if (this.b == null) {
                str = " commonParams";
            }
            if (this.c == null) {
                str = str + " type";
            }
            if (this.d == null) {
                str = str + " payload";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new b(this.a, this.b, this.c, this.d);
        }
    }
}
