package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.UnlockSignature;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class UnlockSignatureImpl extends SignatureImpl implements UnlockSignature {
    private Class parameterType;

    public UnlockSignatureImpl(Class cls) {
        super(8, "unlock", cls);
        this.parameterType = cls;
    }

    public UnlockSignatureImpl(String str) {
        super(str);
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        return new StringBuffer().append("unlock(").append(stringMaker.makeTypeName(this.parameterType)).append(")").toString();
    }

    public Class getParameterType() {
        if (this.parameterType == null) {
            this.parameterType = extractType(3);
        }
        return this.parameterType;
    }
}
