package com.apm.insight.runtime;

import com.apm.insight.entity.Header;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    private static final f b = new f() { // from class: com.apm.insight.runtime.f.1
        Header a = null;

        @Override // com.apm.insight.runtime.f
        public Object b(String str) {
            if (this.a == null) {
                this.a = Header.b(com.apm.insight.g.f());
            }
            return this.a.g().opt(str);
        }
    };
    private f a;

    f() {
        this(b);
    }

    f(f fVar) {
        this.a = fVar;
    }

    public Object a(String str) {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.a(str);
        }
        return null;
    }

    public Object b(String str) {
        f fVar = this.a;
        if (fVar != null) {
            return fVar.b(str);
        }
        return null;
    }
}
