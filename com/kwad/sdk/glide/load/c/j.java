package com.kwad.sdk.glide.load.c;

import android.text.TextUtils;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j implements h {
    private final Map<String, List<i>> bWr;
    private volatile Map<String, String> bWs;

    j(Map<String, List<i>> map) {
        this.bWr = Collections.unmodifiableMap(map);
    }

    @Override // com.kwad.sdk.glide.load.c.h
    public final Map<String, String> getHeaders() {
        if (this.bWs == null) {
            synchronized (this) {
                if (this.bWs == null) {
                    this.bWs = Collections.unmodifiableMap(ahB());
                }
            }
        }
        return this.bWs;
    }

    private Map<String, String> ahB() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.bWr.entrySet()) {
            String strAv = av(entry.getValue());
            if (!TextUtils.isEmpty(strAv)) {
                map.put(entry.getKey(), strAv);
            }
        }
        return map;
    }

    private static String av(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strAhA = list.get(i).ahA();
            if (!TextUtils.isEmpty(strAhA)) {
                sb.append(strAhA);
                if (i != list.size() - 1) {
                    sb.append(StringUtil.COMMA);
                }
            }
        }
        return sb.toString();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.bWr + '}';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.bWr.equals(((j) obj).bWr);
        }
        return false;
    }

    public final int hashCode() {
        return this.bWr.hashCode();
    }

    public static final class a {
        private static final String bWt;
        private static final Map<String, List<i>> bWu;
        private boolean bWv = true;
        private Map<String, List<i>> bWr = bWu;
        private boolean bWw = true;

        static {
            String strAhD = ahD();
            bWt = strAhD;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strAhD)) {
                map.put("User-Agent", Collections.singletonList(new b(strAhD)));
            }
            bWu = Collections.unmodifiableMap(map);
        }

        public final j ahC() {
            this.bWv = true;
            return new j(this.bWr);
        }

        private static String ahD() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    static final class b implements i {
        private final String value;

        b(String str) {
            this.value = str;
        }

        @Override // com.kwad.sdk.glide.load.c.i
        public final String ahA() {
            return this.value;
        }

        public final String toString() {
            return "StringHeaderFactory{value='" + this.value + "'}";
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.value.equals(((b) obj).value);
            }
            return false;
        }

        public final int hashCode() {
            return this.value.hashCode();
        }
    }
}
