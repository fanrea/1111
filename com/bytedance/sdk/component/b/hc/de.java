package com.bytedance.sdk.component.b.hc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class de extends vv {
    private final sy mk;
    private final List<hc> mq;
    private final sy tc;
    private final com.bytedance.sdk.component.b.d.an tt;
    private long uo = -1;
    public static final sy d = sy.d("multipart/mixed");
    public static final sy hc = sy.d("multipart/alternative");
    public static final sy b = sy.d("multipart/digest");
    public static final sy c = sy.d("multipart/parallel");
    public static final sy u = sy.d("multipart/form-data");
    private static final byte[] an = {58, 32};
    private static final byte[] h = {13, 10};
    private static final byte[] gb = {45, 45};

    de(com.bytedance.sdk.component.b.d.an anVar, sy syVar, List<hc> list) {
        this.tt = anVar;
        this.tc = syVar;
        this.mk = sy.d(syVar + "; boundary=" + anVar.d());
        this.mq = com.bytedance.sdk.component.b.hc.d.b.d(list);
    }

    @Override // com.bytedance.sdk.component.b.hc.vv
    public sy d() {
        return this.mk;
    }

    @Override // com.bytedance.sdk.component.b.hc.vv
    public long hc() throws IOException {
        long j = this.uo;
        if (j != -1) {
            return j;
        }
        long jD = d((com.bytedance.sdk.component.b.d.c) null, true);
        this.uo = jD;
        return jD;
    }

    @Override // com.bytedance.sdk.component.b.hc.vv
    public void d(com.bytedance.sdk.component.b.d.c cVar) throws IOException {
        d(cVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long d(com.bytedance.sdk.component.b.d.c cVar, boolean z) throws IOException {
        com.bytedance.sdk.component.b.d.b bVar;
        if (z) {
            cVar = new com.bytedance.sdk.component.b.d.b();
            bVar = cVar;
        } else {
            bVar = 0;
        }
        int size = this.mq.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            hc hcVar = this.mq.get(i);
            yo yoVar = hcVar.d;
            vv vvVar = hcVar.hc;
            cVar.b(gb);
            cVar.hc(this.tt);
            cVar.b(h);
            if (yoVar != null) {
                int iD = yoVar.d();
                for (int i2 = 0; i2 < iD; i2++) {
                    cVar.hc(yoVar.d(i2)).b(an).hc(yoVar.hc(i2)).b(h);
                }
            }
            sy syVarD = vvVar.d();
            if (syVarD != null) {
                cVar.hc("Content-Type: ").hc(syVarD.toString()).b(h);
            }
            long jHc = vvVar.hc();
            if (jHc != -1) {
                cVar.hc("Content-Length: ").mq(jHc).b(h);
            } else if (z) {
                bVar.yo();
                return -1L;
            }
            byte[] bArr = h;
            cVar.b(bArr);
            if (z) {
                j += jHc;
            } else {
                vvVar.d(cVar);
            }
            cVar.b(bArr);
        }
        byte[] bArr2 = gb;
        cVar.b(bArr2);
        cVar.hc(this.tt);
        cVar.b(bArr2);
        cVar.b(h);
        if (!z) {
            return j;
        }
        long jHc2 = j + bVar.hc();
        bVar.yo();
        return jHc2;
    }

    static StringBuilder d(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
        return sb;
    }

    public static final class hc {
        final yo d;
        final vv hc;

        public static hc d(yo yoVar, vv vvVar) {
            if (vvVar == null) {
                throw new NullPointerException("body == null");
            }
            if (yoVar != null && yoVar.d("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (yoVar != null && yoVar.d("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new hc(yoVar, vvVar);
        }

        public static hc d(String str, String str2, vv vvVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            de.d(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                de.d(sb, str2);
            }
            return d(yo.d("Content-Disposition", sb.toString()), vvVar);
        }

        private hc(yo yoVar, vv vvVar) {
            this.d = yoVar;
            this.hc = vvVar;
        }
    }

    public static final class d {
        private final List<hc> b;
        private final com.bytedance.sdk.component.b.d.an d;
        private sy hc;

        public d() {
            this(UUID.randomUUID().toString());
        }

        public d(String str) {
            this.hc = de.d;
            this.b = new ArrayList();
            this.d = com.bytedance.sdk.component.b.d.an.d(str);
        }

        public d d(sy syVar) {
            if (syVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!syVar.d().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(syVar)));
            }
            this.hc = syVar;
            return this;
        }

        public d d(String str, String str2, vv vvVar) {
            return d(hc.d(str, str2, vvVar));
        }

        public d d(hc hcVar) {
            if (hcVar == null) {
                throw new NullPointerException("part == null");
            }
            this.b.add(hcVar);
            return this;
        }

        public de d() {
            if (this.b.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new de(this.d, this.hc, this.b);
        }
    }
}
