package com.baidu.mobads.container.annotation;

import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class SchemeEntity {
    private ConstructMinMethod constructMinMethod = new ConstructMinMethod();
    private HashSet<ExecuteFun> executeFunHashSet = new HashSet<>();
    private String mQualifiedName;

    public ConstructMinMethod getContructMethod() {
        return this.constructMinMethod;
    }

    public void setContructMethod(ConstructMinMethod constructMinMethod) {
        this.constructMinMethod = constructMinMethod;
    }

    public HashSet<ExecuteFun> getExecuteFunHashSet() {
        return this.executeFunHashSet;
    }

    public void setExecuteFunHashSet(HashSet<ExecuteFun> hashSet) {
        this.executeFunHashSet = hashSet;
    }

    public String getQualifiedName() {
        return this.mQualifiedName;
    }

    public void setQualifiedName(String str) {
        this.mQualifiedName = str;
    }
}
