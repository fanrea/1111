package com.hangman.verifier;

import android.content.Context;
import android.os.Build;
import com.hangman.verifier.core.ClassVerifier;
import com.hangman.verifier.utils.DeviceInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class Verifier {
    public static volatile InfoListener infoListener;
    public static List<InfoListener> infoListenerList;
    public static boolean sDebug;
    public static AtomicBoolean sHasInit = new AtomicBoolean(false);

    public class a implements InfoListener {
        @Override // com.hangman.verifier.InfoListener
        public void onDebugInfo(String str) {
            if (!Verifier.sDebug || Verifier.infoListenerList == null || Verifier.infoListenerList.isEmpty()) {
                return;
            }
            Iterator it = Verifier.infoListenerList.iterator();
            while (it.hasNext()) {
                ((InfoListener) it.next()).onDebugInfo(str);
            }
        }

        @Override // com.hangman.verifier.InfoListener
        public void onErrorInfo(String str, Throwable th) {
            if (!Verifier.sDebug || Verifier.infoListenerList == null || Verifier.infoListenerList.isEmpty()) {
                return;
            }
            Iterator it = Verifier.infoListenerList.iterator();
            while (it.hasNext()) {
                ((InfoListener) it.next()).onErrorInfo(str, th);
            }
        }
    }

    public static synchronized boolean disableClassVerify() {
        int iNativeDvmDisableClassVerify;
        if (!sHasInit.get()) {
            getInfoListener().onErrorInfo("Disable class verification failed", new IllegalStateException("not init"));
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            iNativeDvmDisableClassVerify = ClassVerifier.c.get() ? ClassVerifier.nativeDisableClassVerify(ClassVerifier.b, ClassVerifier.a) : -1000;
            if (iNativeDvmDisableClassVerify != 0) {
                getInfoListener().onErrorInfo("Disable class verification failed", new IllegalStateException("result: " + iNativeDvmDisableClassVerify));
                return false;
            }
        } else {
            if (i != 19 || DeviceInfoUtils.a()) {
                getInfoListener().onDebugInfo("Disable class verification failed, because Android OS version not support");
                return false;
            }
            iNativeDvmDisableClassVerify = ClassVerifier.c.get() ? ClassVerifier.nativeDvmDisableClassVerify() : -1000;
            if (iNativeDvmDisableClassVerify != 0) {
                getInfoListener().onErrorInfo("Disable class verification failed", new IllegalStateException("result: " + iNativeDvmDisableClassVerify));
                return false;
            }
        }
        return true;
    }

    public static synchronized boolean enableClassVerify() {
        int iNativeDvmEnableClassVerify;
        if (!sHasInit.get()) {
            getInfoListener().onErrorInfo("Disable class verification failed", new IllegalStateException("not init"));
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            iNativeDvmEnableClassVerify = ClassVerifier.c.get() ? ClassVerifier.nativeEnableClassVerify() : -1000;
            if (iNativeDvmEnableClassVerify != 0) {
                getInfoListener().onErrorInfo("Disable class verification failed", new IllegalStateException("result: " + iNativeDvmEnableClassVerify));
                return false;
            }
        } else {
            if (i != 19 || DeviceInfoUtils.a()) {
                getInfoListener().onDebugInfo("Disable class verification failed, because Android OS version not support");
                return false;
            }
            iNativeDvmEnableClassVerify = ClassVerifier.c.get() ? ClassVerifier.nativeDvmEnableClassVerify() : -1000;
            if (iNativeDvmEnableClassVerify != 0) {
                getInfoListener().onErrorInfo("Disable class verification failed", new IllegalStateException("result: " + iNativeDvmEnableClassVerify));
                return false;
            }
        }
        return true;
    }

    public static synchronized InfoListener getInfoListener() {
        if (infoListener == null) {
            infoListener = new a();
        }
        return infoListener;
    }

    public static void init(Context context, boolean z, InfoListener infoListener2) {
        if (sHasInit.compareAndSet(false, true)) {
            sDebug = z;
            infoListener = infoListener2;
            if (infoListenerList == null) {
                infoListenerList = new ArrayList();
            }
            infoListenerList.add(infoListener2);
            ClassVerifier.a(context);
        }
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
