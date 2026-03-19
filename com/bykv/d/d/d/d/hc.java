package com.bykv.d.d.d.d;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private boolean d = false;
    private int hc = -1;
    private String b = null;
    private ValueSet c = null;

    private hc() {
    }

    public static final hc d() {
        return new hc();
    }

    public hc d(boolean z) {
        this.d = z;
        return this;
    }

    public hc d(int i) {
        this.hc = i;
        return this;
    }

    public hc d(String str) {
        this.b = str;
        return this;
    }

    public hc d(ValueSet valueSet) {
        this.c = valueSet;
        return this;
    }

    public Result hc() {
        boolean z = this.d;
        int i = this.hc;
        String str = this.b;
        ValueSet valueSetHc = this.c;
        if (valueSetHc == null) {
            valueSetHc = b.d().hc();
        }
        return new d(z, i, str, valueSetHc);
    }

    private static final class d implements Result {
        private final String b;
        private final ValueSet c;
        private final boolean d;
        private final int hc;

        private d(boolean z, int i, String str, ValueSet valueSet) {
            this.d = z;
            this.hc = i;
            this.b = str;
            this.c = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.d;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.hc;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.c;
        }
    }
}
