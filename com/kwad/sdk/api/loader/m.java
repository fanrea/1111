package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.g;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class m {
    private final String bsI;
    private final String bsJ;
    private final String bsK;
    private Resources bsL;
    private ClassLoader bsM;
    private IKsAdSDK bsN;

    public final String toString() {
        return "ExternalPackage{mApk='" + this.bsI + "', mDexDir='" + this.bsJ + "', mNativeLibDir='" + this.bsK + "', mResource=" + this.bsL + ", mClassLoader=" + this.bsM + ", mKsSdk=" + this.bsN + '}';
    }

    final Resources VT() {
        return this.bsL;
    }

    final ClassLoader getClassLoader() {
        return this.bsM;
    }

    final IKsAdSDK VU() {
        return this.bsN;
    }

    private m(String str, String str2, String str3) {
        this.bsI = str;
        this.bsJ = str2;
        this.bsK = str3;
    }

    static synchronized m a(Context context, ClassLoader classLoader, String str) {
        try {
        } catch (Throwable th) {
            com.kwad.sdk.api.b.r(th);
            return null;
        }
        return b(context, classLoader, j.F(context, str), j.G(context, str), j.H(context, str));
    }

    static m b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setReadOnly();
            }
        } catch (Throwable unused) {
        }
        m mVar = new m(str, str2, str3);
        mVar.a(context, classLoader);
        return mVar;
    }

    private void a(Context context, ClassLoader classLoader) {
        VV();
        Resources resourcesA = w.a(context, context.getResources(), this.bsI);
        ClassLoader classLoaderA = g.a(context, classLoader, this.bsI, this.bsJ, this.bsK);
        IKsAdSDK iKsAdSDKA = Loader.a(classLoaderA);
        this.bsL = resourcesA;
        this.bsM = classLoaderA;
        this.bsN = iKsAdSDKA;
        if (!(iKsAdSDKA.getClass().getClassLoader() instanceof g.a)) {
            throw new RuntimeException("classLoader is not expect dynamic classloader:");
        }
        int sDKType = iKsAdSDKA.getSDKType();
        if (sDKType != 2) {
            throw new RuntimeException("sdkType error apiType: 2 , sdkType:" + sDKType);
        }
    }

    private void VV() {
        if (TextUtils.isEmpty(this.bsI)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.bsI);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }
}
