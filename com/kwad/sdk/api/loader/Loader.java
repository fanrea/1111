package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Context mContext;
    private IKsAdSDK bsO;
    private m bsP;
    private final AtomicBoolean mHasInit;

    /* synthetic */ Loader(byte b) {
        this();
    }

    static class a {
        private static final Loader bsQ = new Loader(0);
    }

    public static Loader get() {
        return a.bsQ;
    }

    private Loader() {
        this.bsP = null;
        this.mHasInit = new AtomicBoolean(false);
    }

    public IKsAdSDK init(Context context, ClassLoader classLoader) {
        if (this.mHasInit.get()) {
            return this.bsO;
        }
        mContext = context.getApplicationContext();
        bp(context);
        if (bo(context)) {
            this.bsP = m.a(context, classLoader, i.bj(context));
        }
        boolean zBooleanValue = com.kwad.sdk.api.a.brO.booleanValue();
        m mVar = this.bsP;
        if (mVar == null && zBooleanValue) {
            ClassLoader classLoaderInitDex = DexLoader.initDex(context, classLoader);
            if (classLoaderInitDex == null) {
                return null;
            }
            new StringBuilder("IKsAdSDK after dexClassLoader: ").append(classLoaderInitDex);
            this.bsO = a(classLoaderInitDex);
            new StringBuilder("IKsAdSDK after mSDKImpl: ").append(this.bsO);
        } else if (mVar == null) {
            IKsAdSDK iKsAdSDKA = a(getClass().getClassLoader());
            this.bsO = iKsAdSDKA;
            iKsAdSDKA.setIsExternal(false);
        } else {
            IKsAdSDK iKsAdSDKVU = mVar.VU();
            this.bsO = iKsAdSDKVU;
            iKsAdSDKVU.setIsExternal(true);
        }
        com.kwad.sdk.api.b.a(this.bsO);
        if (this.bsP != null) {
            VX();
        }
        this.mHasInit.set(true);
        return this.bsO;
    }

    public void rest() {
        this.mHasInit.set(false);
        mContext = null;
        this.bsO = null;
        this.bsP = null;
    }

    private static void VX() {
        try {
            int iVM = com.kwad.sdk.api.b.VM();
            if (iVM > 0) {
                try {
                    f.bi(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(f.bi(mContext));
                    f.bi(mContext).eb(iVM);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean bo(Context context) {
        try {
            String strBj = i.bj(context);
            String strBk = i.bk(context);
            if (TextUtils.isEmpty(strBj) && TextUtils.isEmpty(strBk)) {
                return false;
            }
            if (!TextUtils.isEmpty(strBk) && i.S(strBk, strBj)) {
                i.z(context, strBk);
                J(context, strBj);
                i.A(context, "");
                strBj = strBk;
            }
            return !TextUtils.isEmpty(strBj);
        } catch (Throwable th) {
            com.kwad.sdk.api.b.r(th);
            return false;
        }
    }

    private static void J(Context context, String str) {
        j.I(context, str);
    }

    private static void bp(Context context) {
        try {
            String strBl = i.bl(context);
            boolean zB = b.b(context, i.bst, false);
            if (TextUtils.isEmpty(strBl) || !strBl.equals(BuildConfig.VERSION_NAME) || zB) {
                String strBj = i.bj(context);
                i.z(context, "");
                i.A(context, "");
                b.a(context, i.bst, false);
                j.j(j.E(context, strBj));
                i.B(context, BuildConfig.VERSION_NAME);
            }
        } catch (Throwable th) {
            com.kwad.sdk.api.b.r(th);
        }
    }

    public boolean isExternalLoaded() {
        return this.bsP != null;
    }

    public Context getContext() {
        return mContext;
    }

    public ClassLoader getRealClassLoader() {
        m mVar = this.bsP;
        if (mVar != null) {
            return mVar.getClassLoader();
        }
        return getClass().getClassLoader();
    }

    public Resources getExternalResource() {
        m mVar = this.bsP;
        if (mVar != null) {
            return mVar.VT();
        }
        return null;
    }

    public ClassLoader getExternalClassLoader() {
        m mVar = this.bsP;
        ClassLoader classLoader = mVar != null ? mVar.getClassLoader() : null;
        if (com.kwad.sdk.api.a.brO.booleanValue()) {
            classLoader = this.bsO.getClass().getClassLoader();
            new StringBuilder("Loader getExternalClassLoader: ").append(classLoader);
        }
        new StringBuilder("Loader result: ").append(classLoader);
        return classLoader;
    }

    static synchronized IKsAdSDK a(ClassLoader classLoader) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                throw new RuntimeException("Can not get sdk form " + classLoader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (IKsAdSDK) objInvoke;
    }

    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.bsO.newComponentProxy(cls, obj);
    }

    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.bsO.newInstance(cls);
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = c.VS();
        }
        KsAdSDK.init(context, SdkConfig.create(b.getString(context, "sdkconfig")));
    }
}
