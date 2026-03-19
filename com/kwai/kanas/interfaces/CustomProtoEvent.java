package com.kwai.kanas.interfaces;

import com.kwai.kanas.interfaces.b;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class CustomProtoEvent {
    public abstract CommonParams commonParams();

    public abstract String eventId();

    public abstract JSONObject payload();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new b.a().commonParams(CommonParams.builder().build());
    }

    public static abstract class Builder {
        abstract CustomProtoEvent a();

        public abstract Builder commonParams(CommonParams commonParams);

        public abstract Builder eventId(String str);

        public abstract Builder payload(JSONObject jSONObject);

        public abstract Builder type(String str);

        public Builder payload(String str) {
            try {
                return payload(new JSONObject(str));
            } catch (JSONException e) {
                if (Azeroth.get().isDebugMode()) {
                    throw new IllegalArgumentException(e);
                }
                return payload(new JSONObject());
            }
        }

        public CustomProtoEvent build() {
            CustomProtoEvent customProtoEventA = a();
            Utils.checkNotNullOrEmpty(customProtoEventA.type());
            Utils.checkNotNullOrEmpty(customProtoEventA.payload());
            return customProtoEventA;
        }
    }
}
