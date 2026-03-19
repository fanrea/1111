package com.kwai.middleware.azeroth.logger;

import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.logger.AutoValueCustomProtoEvent;
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
        return new AutoValueCustomProtoEvent.Builder();
    }

    public static abstract class Builder {
        abstract CustomProtoEvent autoBuild();

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
            CustomProtoEvent customProtoEventAutoBuild = autoBuild();
            Utils.checkNotNullOrEmpty(customProtoEventAutoBuild.type());
            Utils.checkNotNullOrEmpty(customProtoEventAutoBuild.payload());
            return customProtoEventAutoBuild;
        }
    }
}
