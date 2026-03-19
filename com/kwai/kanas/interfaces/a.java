package com.kwai.kanas.interfaces;

import com.alipay.sdk.m.u.i;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwai.kanas.interfaces.CommonParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class a extends CommonParams {
    private final String a;
    private final String b;
    private final boolean c;
    private final String d;
    private final float e;

    private a(String str, String str2, boolean z, String str3, float f) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = f;
    }

    @Override // com.kwai.kanas.interfaces.CommonParams
    public final String sdkName() {
        return this.a;
    }

    @Override // com.kwai.kanas.interfaces.CommonParams
    public final String subBiz() {
        return this.b;
    }

    @Override // com.kwai.kanas.interfaces.CommonParams
    public final boolean realtime() {
        return this.c;
    }

    @Override // com.kwai.kanas.interfaces.CommonParams
    public final String container() {
        return this.d;
    }

    @Override // com.kwai.kanas.interfaces.CommonParams
    public final float sampleRatio() {
        return this.e;
    }

    public final String toString() {
        return "CommonParams{sdkName=" + this.a + ", subBiz=" + this.b + ", realtime=" + this.c + ", container=" + this.d + ", sampleRatio=" + this.e + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommonParams) {
            CommonParams commonParams = (CommonParams) obj;
            String str = this.a;
            if (str != null ? str.equals(commonParams.sdkName()) : commonParams.sdkName() == null) {
                String str2 = this.b;
                if (str2 != null ? str2.equals(commonParams.subBiz()) : commonParams.subBiz() == null) {
                    if (this.c == commonParams.realtime() && this.d.equals(commonParams.container()) && Float.floatToIntBits(this.e) == Float.floatToIntBits(commonParams.sampleRatio())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.b;
        return ((((((iHashCode ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ (this.c ? SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION : SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO)) * 1000003) ^ this.d.hashCode()) * 1000003) ^ Float.floatToIntBits(this.e);
    }

    @Override // com.kwai.kanas.interfaces.CommonParams
    public final CommonParams.Builder toBuilder() {
        return new C0650a(this);
    }

    /* renamed from: com.kwai.kanas.interfaces.a$a, reason: collision with other inner class name */
    static final class C0650a extends CommonParams.Builder {
        private String a;
        private String b;
        private Boolean c;
        private String d;
        private Float e;

        C0650a() {
        }

        private C0650a(CommonParams commonParams) {
            this.a = commonParams.sdkName();
            this.b = commonParams.subBiz();
            this.c = Boolean.valueOf(commonParams.realtime());
            this.d = commonParams.container();
            this.e = Float.valueOf(commonParams.sampleRatio());
        }

        @Override // com.kwai.kanas.interfaces.CommonParams.Builder
        public final CommonParams.Builder sdkName(String str) {
            this.a = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CommonParams.Builder
        public final CommonParams.Builder subBiz(String str) {
            this.b = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CommonParams.Builder
        public final CommonParams.Builder realtime(boolean z) {
            this.c = Boolean.valueOf(z);
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CommonParams.Builder
        public final CommonParams.Builder container(String str) {
            if (str == null) {
                throw new NullPointerException("Null container");
            }
            this.d = str;
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CommonParams.Builder
        public final CommonParams.Builder sampleRatio(float f) {
            this.e = Float.valueOf(f);
            return this;
        }

        @Override // com.kwai.kanas.interfaces.CommonParams.Builder
        final CommonParams a() {
            String str = "";
            if (this.c == null) {
                str = " realtime";
            }
            if (this.d == null) {
                str = str + " container";
            }
            if (this.e == null) {
                str = str + " sampleRatio";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new a(this.a, this.b, this.c.booleanValue(), this.d, this.e.floatValue());
        }
    }
}
