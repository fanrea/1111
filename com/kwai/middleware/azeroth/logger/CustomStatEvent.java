package com.kwai.middleware.azeroth.logger;

import com.kwai.middleware.azeroth.logger.AutoValueCustomStatEvent;
import com.kwai.middleware.azeroth.utils.Utils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class CustomStatEvent {
    public abstract CommonParams commonParams();

    public abstract String eventId();

    public abstract String key();

    public abstract Builder toBuilder();

    public abstract String value();

    public static Builder builder() {
        return new AutoValueCustomStatEvent.Builder();
    }

    public static abstract class Builder {
        abstract CustomStatEvent autoBuild();

        public abstract Builder commonParams(CommonParams commonParams);

        public abstract Builder eventId(String str);

        public abstract Builder key(String str);

        public abstract Builder value(String str);

        public Builder value(JSONObject jSONObject) {
            return value(jSONObject.toString());
        }

        public Builder value(Map<String, String> map) {
            return value(new JSONObject(map));
        }

        public CustomStatEvent build() {
            CustomStatEvent customStatEventAutoBuild = autoBuild();
            Utils.checkNotNullOrEmpty(customStatEventAutoBuild.key());
            return customStatEventAutoBuild;
        }
    }
}
