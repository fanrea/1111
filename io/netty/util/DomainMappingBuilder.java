package io.netty.util;

import com.alipay.sdk.m.n.a;
import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class DomainMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    public DomainMappingBuilder(V v) {
        this(4, v);
    }

    public DomainMappingBuilder(int i, V v) {
        this.defaultValue = (V) ObjectUtil.checkNotNull(v, "defaultValue");
        this.map = new LinkedHashMap(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DomainMappingBuilder<V> add(String str, V v) {
        this.map.put(ObjectUtil.checkNotNull(str, "hostname"), ObjectUtil.checkNotNull(v, "output"));
        return this;
    }

    public final DomainNameMapping<V> build() {
        return new ImmutableDomainNameMapping(this.defaultValue, this.map);
    }

    static final class ImmutableDomainNameMapping<V> extends DomainNameMapping<V> {
        private static final int REPR_CONST_PART_LENGTH = 46;
        private static final String REPR_HEADER = "ImmutableDomainNameMapping(default: ";
        private static final String REPR_MAP_CLOSING = "})";
        private static final String REPR_MAP_OPENING = ", map: {";
        private final String[] domainNamePatterns;
        private final V[] values;

        private ImmutableDomainNameMapping(V v, Map<String, V> map) {
            super((Map) null, v);
            Set<Map.Entry<String, V>> setEntrySet = map.entrySet();
            int size = setEntrySet.size();
            this.domainNamePatterns = new String[size];
            this.values = (V[]) new Object[size];
            int i = 0;
            for (Map.Entry<String, V> entry : setEntrySet) {
                this.domainNamePatterns[i] = normalizeHostname(entry.getKey());
                this.values[i] = entry.getValue();
                i++;
            }
        }

        @Override // io.netty.util.DomainNameMapping
        @Deprecated
        public final DomainNameMapping<V> add(String str, V v) {
            throw new UnsupportedOperationException("Immutable DomainNameMapping does not support modification after initial creation");
        }

        @Override // io.netty.util.DomainNameMapping, io.netty.util.Mapping
        public final V map(String str) {
            if (str != null) {
                String strNormalizeHostname = normalizeHostname(str);
                int length = this.domainNamePatterns.length;
                for (int i = 0; i < length; i++) {
                    if (matches(this.domainNamePatterns[i], strNormalizeHostname)) {
                        return this.values[i];
                    }
                }
            }
            return this.defaultValue;
        }

        @Override // io.netty.util.DomainNameMapping
        public final String toString() {
            String string = this.defaultValue.toString();
            String[] strArr = this.domainNamePatterns;
            int length = strArr.length;
            if (length == 0) {
                return REPR_HEADER + string + ", map: {})";
            }
            String str = strArr[0];
            String string2 = this.values[0].toString();
            StringBuilder sb = new StringBuilder(estimateBufferSize(string.length(), length, str.length() + string2.length() + 3));
            sb.append(REPR_HEADER);
            sb.append(string);
            sb.append(REPR_MAP_OPENING);
            appendMapping(sb, str, string2);
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                appendMapping(sb, i);
            }
            sb.append(REPR_MAP_CLOSING);
            return sb.toString();
        }

        private static int estimateBufferSize(int i, int i2, int i3) {
            int i4 = REPR_CONST_PART_LENGTH + i;
            double d = i3 * i2;
            Double.isNaN(d);
            return i4 + ((int) (d * 1.1d));
        }

        private StringBuilder appendMapping(StringBuilder sb, int i) {
            return appendMapping(sb, this.domainNamePatterns[i], this.values[i].toString());
        }

        private static StringBuilder appendMapping(StringBuilder sb, String str, String str2) {
            sb.append(str);
            sb.append(a.h);
            sb.append(str2);
            return sb;
        }
    }
}
