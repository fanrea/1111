package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import javax.security.auth.x500.X500Principal;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class Gemini {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Gemini$do, reason: invalid class name */
    public static class Cdo extends Gemini {
        public KeyGenParameterSpec.Builder a;

        public Cdo(String str, int i) {
            this.a = null;
            this.a = new KeyGenParameterSpec.Builder(str, i);
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Gemini
        public AlgorithmParameterSpec a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
            return this.a.build();
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Gemini
        public Gemini b(String... strArr) {
            this.a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Gemini
        public Gemini a(String... strArr) {
            this.a.setDigests(strArr);
            return this;
        }
    }

    public static Gemini a(String str, int i) {
        return Build.VERSION.SDK_INT >= 23 ? new Cdo(str, i) : new Cif(str, i);
    }

    public abstract Gemini a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException;

    public abstract Gemini b(String... strArr);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Gemini$if, reason: invalid class name */
    public static class Cif extends Gemini {
        public final String a;
        public int b;
        public String[] c;
        public String[] d;

        public Cif(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            }
            this.a = str;
            this.b = i;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Gemini
        public AlgorithmParameterSpec a() throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, java.util.Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Gemini
        public Gemini b(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.d = strArr;
            return this;
        }

        @Override // com.tencent.turingfd.sdk.ams.au.Gemini
        public Gemini a(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.c = strArr;
            return this;
        }
    }
}
