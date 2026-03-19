package com.kwai.middleware.azeroth.logger;

import com.alipay.sdk.m.u.i;
import com.kwai.middleware.azeroth.logger.CustomStatEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValueCustomStatEvent extends CustomStatEvent {
    private final CommonParams commonParams;
    private final String eventId;
    private final String key;
    private final String value;

    private AutoValueCustomStatEvent(String str, CommonParams commonParams, String str2, String str3) {
        this.eventId = str;
        this.commonParams = commonParams;
        this.key = str2;
        this.value = str3;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent
    public final String eventId() {
        return this.eventId;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent
    public final CommonParams commonParams() {
        return this.commonParams;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent
    public final String key() {
        return this.key;
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent
    public final String value() {
        return this.value;
    }

    public final String toString() {
        return "CustomStatEvent{eventId=" + this.eventId + ", commonParams=" + this.commonParams + ", key=" + this.key + ", value=" + this.value + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CustomStatEvent) {
            CustomStatEvent customStatEvent = (CustomStatEvent) obj;
            String str = this.eventId;
            if (str != null ? str.equals(customStatEvent.eventId()) : customStatEvent.eventId() == null) {
                if (this.commonParams.equals(customStatEvent.commonParams()) && this.key.equals(customStatEvent.key()) && this.value.equals(customStatEvent.value())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.eventId;
        return (((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.commonParams.hashCode()) * 1000003) ^ this.key.hashCode()) * 1000003) ^ this.value.hashCode();
    }

    @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent
    public final CustomStatEvent.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CustomStatEvent.Builder {
        private CommonParams commonParams;
        private String eventId;
        private String key;
        private String value;

        Builder() {
        }

        private Builder(CustomStatEvent customStatEvent) {
            this.eventId = customStatEvent.eventId();
            this.commonParams = customStatEvent.commonParams();
            this.key = customStatEvent.key();
            this.value = customStatEvent.value();
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent.Builder
        public final CustomStatEvent.Builder eventId(String str) {
            this.eventId = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent.Builder
        public final CustomStatEvent.Builder commonParams(CommonParams commonParams) {
            if (commonParams == null) {
                throw new NullPointerException("Null commonParams");
            }
            this.commonParams = commonParams;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent.Builder
        public final CustomStatEvent.Builder key(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.key = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent.Builder
        public final CustomStatEvent.Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.value = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CustomStatEvent.Builder
        final CustomStatEvent autoBuild() {
            String str = "";
            if (this.commonParams == null) {
                str = " commonParams";
            }
            if (this.key == null) {
                str = str + " key";
            }
            if (this.value == null) {
                str = str + " value";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValueCustomStatEvent(this.eventId, this.commonParams, this.key, this.value);
        }
    }
}
