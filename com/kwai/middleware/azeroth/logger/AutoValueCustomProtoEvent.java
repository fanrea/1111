package com.kwai.middleware.azeroth.logger;

import com.alipay.sdk.m.u.i;
import com.kwai.middleware.azeroth.logger.CustomProtoEvent;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValueCustomProtoEvent extends CustomProtoEvent {
    private final CommonParams commonParams;
    private final String eventId;
    private final JSONObject payload;
    private final String type;

    private AutoValueCustomProtoEvent(String str, CommonParams commonParams, String str2, JSONObject jSONObject) {
        this.eventId = str;
        this.commonParams = commonParams;
        this.type = str2;
        this.payload = jSONObject;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent
    public final String eventId() {
        return this.eventId;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent
    public final CommonParams commonParams() {
        return this.commonParams;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent
    public final String type() {
        return this.type;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent
    public final JSONObject payload() {
        return this.payload;
    }

    public final String toString() {
        return "CustomProtoEvent{eventId=" + this.eventId + ", commonParams=" + this.commonParams + ", type=" + this.type + ", payload=" + this.payload + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CustomProtoEvent) {
            CustomProtoEvent customProtoEvent = (CustomProtoEvent) obj;
            String str = this.eventId;
            if (str != null ? str.equals(customProtoEvent.eventId()) : customProtoEvent.eventId() == null) {
                if (this.commonParams.equals(customProtoEvent.commonParams()) && this.type.equals(customProtoEvent.type()) && this.payload.toString().equals(customProtoEvent.payload().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.eventId;
        return (((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.commonParams.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.payload.toString().hashCode();
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent
    public final CustomProtoEvent.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CustomProtoEvent.Builder {
        private CommonParams commonParams;
        private String eventId;
        private JSONObject payload;
        private String type;

        Builder() {
        }

        private Builder(CustomProtoEvent customProtoEvent) {
            this.eventId = customProtoEvent.eventId();
            this.commonParams = customProtoEvent.commonParams();
            this.type = customProtoEvent.type();
            this.payload = customProtoEvent.payload();
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder eventId(String str) {
            this.eventId = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder commonParams(CommonParams commonParams) {
            if (commonParams == null) {
                throw new NullPointerException("Null commonParams");
            }
            this.commonParams = commonParams;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder type(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.type = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent.Builder
        public final CustomProtoEvent.Builder payload(JSONObject jSONObject) {
            if (jSONObject == null) {
                throw new NullPointerException("Null payload");
            }
            this.payload = jSONObject;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomProtoEvent.Builder
        final CustomProtoEvent autoBuild() {
            String str = "";
            if (this.commonParams == null) {
                str = " commonParams";
            }
            if (this.type == null) {
                str = str + " type";
            }
            if (this.payload == null) {
                str = str + " payload";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValueCustomProtoEvent(this.eventId, this.commonParams, this.type, this.payload);
        }
    }
}
