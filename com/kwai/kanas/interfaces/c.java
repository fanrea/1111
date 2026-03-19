package com.kwai.kanas.interfaces;

import com.alipay.sdk.m.u.i;
import com.kwai.kanas.interfaces.CustomStatEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class c extends CustomStatEvent {
    private final String a;
    private final CommonParams b;
    private final String c;
    private final String d;

    private c(String str, CommonParams commonParams, String str2, String str3) {
        this.a = str;
        this.b = commonParams;
        this.c = str2;
        this.d = str3;
    }

    @Override // com.kwai.kanas.interfaces.CustomStatEvent
    public final String eventId() {
        return this.a;
    }

    @Override // com.kwai.kanas.interfaces.CustomStatEvent
    public final CommonParams commonParams() {
        return this.b;
    }

    @Override // com.kwai.kanas.interfaces.CustomStatEvent
    public final String key() {
        return this.c;
    }

    @Override // com.kwai.kanas.interfaces.CustomStatEvent
    public final String value() {
        return this.d;
    }

    public final String toString() {
        return "CustomStatEvent{eventId=" + this.a + ", commonParams=" + this.b + ", key=" + this.c + ", value=" + this.d + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CustomStatEvent) {
            CustomStatEvent customStatEvent = (CustomStatEvent) obj;
            String str = this.a;
            if (str != null ? str.equals(customStatEvent.eventId()) : customStatEvent.eventId() == null) {
                if (this.b.equals(customStatEvent.commonParams()) && this.c.equals(customStatEvent.key()) && this.d.equals(customStatEvent.value())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return (((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    @Override // com.kwai.kanas.interfaces.CustomStatEvent
    public final CustomStatEvent.Builder toBuilder() {
        return new a(this);
    }

    static final class a extends CustomStatEvent.Builder {
        private String a;
        private CommonParams b;
        private String c;
        private String d;

        a() {
        }

        private a(CustomStatEvent customStatEvent) {
            this.a = customStatEvent.eventId();
            this.b = customStatEvent.commonParams();
            this.c = customStatEvent.key();
            this.d = customStatEvent.value();
        }

        @Override // com.kwai.kanas.interfaces.CustomStatEvent.Builder
        public final CustomStatEvent.Builder eventId(String str) {
            this.a = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomStatEvent.Builder
        public final CustomStatEvent.Builder commonParams(CommonParams commonParams) {
            if (commonParams == null) {
                throw new NullPointerException("Null commonParams");
            }
            this.b = commonParams;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomStatEvent.Builder
        public final CustomStatEvent.Builder key(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.c = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomStatEvent.Builder
        public final CustomStatEvent.Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.d = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CustomStatEvent.Builder
        final CustomStatEvent a() {
            String str = "";
            if (this.b == null) {
                str = " commonParams";
            }
            if (this.c == null) {
                str = str + " key";
            }
            if (this.d == null) {
                str = str + " value";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new c(this.a, this.b, this.c, this.d);
        }
    }
}
