package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TOOLBAR_CALLBACK_INTERNAL_WRAPPER_CLASS = "androidx.appcompat.internal.app.ToolbarActionBar$ToolbarCallbackWrapper";
    private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
    private static final String WINDOW_PROFILER_CALLBACK = "com.android.tools.profiler.support.event.WindowProfilerCallback";
    private static Activity sActivity;
    private static ApplicationStateListener sNativeApplicationStateListener;
    private static final Map<Activity, ActivityInfo> sActivityInfo = Collections.synchronizedMap(new HashMap());
    private static int sCurrentApplicationState = 0;
    private static final ObserverList<ActivityStateListener> sGeneralActivityStateListeners = new ObserverList<>();
    private static final ObserverList<ApplicationStateListener> sApplicationStateListeners = new ObserverList<>();
    private static final ObserverList<WindowFocusChangedListener> sWindowFocusListeners = new ObserverList<>();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface ActivityStateListener {
        void onActivityStateChange(Activity activity, int i);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface ApplicationStateListener {
        void onApplicationStateChange(int i);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity activity, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class ActivityInfo {
        private ObserverList<ActivityStateListener> mListeners;
        private int mStatus;

        private ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }
    }

    private ApplicationStatus() {
    }

    public static void registerWindowFocusChangedListener(WindowFocusChangedListener windowFocusChangedListener) {
        sWindowFocusListeners.addObserver(windowFocusChangedListener);
    }

    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener windowFocusChangedListener) {
        sWindowFocusListeners.removeObserver(windowFocusChangedListener);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class WindowCallbackProxy implements InvocationHandler {
        private final Activity mActivity;
        private final Window.Callback mCallback;

        public WindowCallbackProxy(Activity activity, Window.Callback callback) {
            this.mCallback = callback;
            this.mActivity = activity;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("onWindowFocusChanged") && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Boolean) {
                    onWindowFocusChanged(((Boolean) obj2).booleanValue());
                    return null;
                }
            }
            try {
                return method.invoke(this.mCallback, objArr);
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof AbstractMethodError) {
                    throw e.getCause();
                }
                throw e;
            }
        }

        public void onWindowFocusChanged(boolean z) {
            this.mCallback.onWindowFocusChanged(z);
            Iterator it = ApplicationStatus.sWindowFocusListeners.iterator();
            while (it.hasNext()) {
                ((WindowFocusChangedListener) it.next()).onWindowFocusChanged(this.mActivity, z);
            }
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (sActivityInfo) {
            z = sCurrentApplicationState != 0;
        }
        return z;
    }

    public static void initialize(Application application) {
        synchronized (sActivityInfo) {
            sCurrentApplicationState = 4;
        }
        registerWindowFocusChangedListener(new WindowFocusChangedListener() { // from class: aegon.chrome.base.ApplicationStatus.1
            @Override // aegon.chrome.base.ApplicationStatus.WindowFocusChangedListener
            public void onWindowFocusChanged(Activity activity, boolean z) {
                int stateForActivity;
                if (!z || activity == ApplicationStatus.sActivity || (stateForActivity = ApplicationStatus.getStateForActivity(activity)) == 6 || stateForActivity == 5) {
                    return;
                }
                Activity unused = ApplicationStatus.sActivity = activity;
            }
        });
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: aegon.chrome.base.ApplicationStatus.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ApplicationStatus.onStateChange(activity, 1);
                activity.getWindow().setCallback((Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(activity, activity.getWindow().getCallback())));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ApplicationStatus.onStateChange(activity, 6);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ApplicationStatus.onStateChange(activity, 4);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ApplicationStatus.onStateChange(activity, 3);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ApplicationStatus.onStateChange(activity, 2);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ApplicationStatus.onStateChange(activity, 5);
                checkCallback(activity);
            }

            private void checkCallback(Activity activity) {
                if (BuildConfig.DCHECK_IS_ON) {
                    activity.getWindow().getCallback().getClass();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[Catch: all -> 0x008a, TryCatch #0 {, blocks: (B:15:0x001b, B:16:0x0023, B:18:0x002f, B:20:0x0036, B:21:0x0038, B:22:0x003e), top: B:43:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void onStateChange(android.app.Activity r5, int r6) {
        /*
            if (r5 == 0) goto L8d
            android.app.Activity r0 = aegon.chrome.base.ApplicationStatus.sActivity
            r1 = 1
            if (r0 == 0) goto Lf
            if (r6 == r1) goto Lf
            r0 = 3
            if (r6 == r0) goto Lf
            r0 = 2
            if (r6 != r0) goto L11
        Lf:
            aegon.chrome.base.ApplicationStatus.sActivity = r5
        L11:
            int r0 = getStateForApplication()
            java.util.Map<android.app.Activity, aegon.chrome.base.ApplicationStatus$ActivityInfo> r2 = aegon.chrome.base.ApplicationStatus.sActivityInfo
            monitor-enter(r2)
            r3 = 0
            if (r6 != r1) goto L23
            aegon.chrome.base.ApplicationStatus$ActivityInfo r1 = new aegon.chrome.base.ApplicationStatus$ActivityInfo     // Catch: java.lang.Throwable -> L8a
            r1.<init>()     // Catch: java.lang.Throwable -> L8a
            r2.put(r5, r1)     // Catch: java.lang.Throwable -> L8a
        L23:
            java.lang.Object r1 = r2.get(r5)     // Catch: java.lang.Throwable -> L8a
            aegon.chrome.base.ApplicationStatus$ActivityInfo r1 = (aegon.chrome.base.ApplicationStatus.ActivityInfo) r1     // Catch: java.lang.Throwable -> L8a
            r1.setStatus(r6)     // Catch: java.lang.Throwable -> L8a
            r4 = 6
            if (r6 != r4) goto L38
            r2.remove(r5)     // Catch: java.lang.Throwable -> L8a
            android.app.Activity r4 = aegon.chrome.base.ApplicationStatus.sActivity     // Catch: java.lang.Throwable -> L8a
            if (r5 != r4) goto L38
            aegon.chrome.base.ApplicationStatus.sActivity = r3     // Catch: java.lang.Throwable -> L8a
        L38:
            int r3 = determineApplicationStateLocked()     // Catch: java.lang.Throwable -> L8a
            aegon.chrome.base.ApplicationStatus.sCurrentApplicationState = r3     // Catch: java.lang.Throwable -> L8a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8a
            aegon.chrome.base.ObserverList r1 = r1.getListeners()
            java.util.Iterator r1 = r1.iterator()
        L47:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L57
            java.lang.Object r2 = r1.next()
            aegon.chrome.base.ApplicationStatus$ActivityStateListener r2 = (aegon.chrome.base.ApplicationStatus.ActivityStateListener) r2
            r2.onActivityStateChange(r5, r6)
            goto L47
        L57:
            aegon.chrome.base.ObserverList<aegon.chrome.base.ApplicationStatus$ActivityStateListener> r1 = aegon.chrome.base.ApplicationStatus.sGeneralActivityStateListeners
            java.util.Iterator r1 = r1.iterator()
        L5d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L6d
            java.lang.Object r2 = r1.next()
            aegon.chrome.base.ApplicationStatus$ActivityStateListener r2 = (aegon.chrome.base.ApplicationStatus.ActivityStateListener) r2
            r2.onActivityStateChange(r5, r6)
            goto L5d
        L6d:
            int r5 = getStateForApplication()
            if (r5 == r0) goto L89
            aegon.chrome.base.ObserverList<aegon.chrome.base.ApplicationStatus$ApplicationStateListener> r6 = aegon.chrome.base.ApplicationStatus.sApplicationStateListeners
            java.util.Iterator r6 = r6.iterator()
        L79:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L89
            java.lang.Object r0 = r6.next()
            aegon.chrome.base.ApplicationStatus$ApplicationStateListener r0 = (aegon.chrome.base.ApplicationStatus.ApplicationStateListener) r0
            r0.onApplicationStateChange(r5)
            goto L79
        L89:
            return
        L8a:
            r5 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L8a
            throw r5
        L8d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "null activity is not supported"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aegon.chrome.base.ApplicationStatus.onStateChange(android.app.Activity, int):void");
    }

    public static void onStateChangeForTesting(Activity activity, int i) {
        onStateChange(activity, i);
    }

    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    public static List<Activity> getRunningActivities() {
        ArrayList arrayList;
        Map<Activity, ActivityInfo> map = sActivityInfo;
        synchronized (map) {
            arrayList = new ArrayList(map.keySet());
        }
        return arrayList;
    }

    public static int getStateForActivity(Activity activity) {
        ActivityInfo activityInfo;
        if (activity == null || (activityInfo = sActivityInfo.get(activity)) == null) {
            return 6;
        }
        return activityInfo.getStatus();
    }

    public static int getStateForApplication() {
        int i;
        synchronized (sActivityInfo) {
            i = sCurrentApplicationState;
        }
        return i;
    }

    public static boolean hasVisibleActivities() {
        int stateForApplication = getStateForApplication();
        return stateForApplication == 1 || stateForApplication == 2;
    }

    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static void registerStateListenerForAllActivities(ActivityStateListener activityStateListener) {
        sGeneralActivityStateListeners.addObserver(activityStateListener);
    }

    public static void registerStateListenerForActivity(ActivityStateListener activityStateListener, Activity activity) {
        sActivityInfo.get(activity).getListeners().addObserver(activityStateListener);
    }

    public static void unregisterActivityStateListener(ActivityStateListener activityStateListener) {
        sGeneralActivityStateListeners.removeObserver(activityStateListener);
        Map<Activity, ActivityInfo> map = sActivityInfo;
        synchronized (map) {
            Iterator<ActivityInfo> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().getListeners().removeObserver(activityStateListener);
            }
        }
    }

    public static void registerApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.addObserver(applicationStateListener);
    }

    public static void unregisterApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.removeObserver(applicationStateListener);
    }

    public static void destroyForJUnitTests() {
        Map<Activity, ActivityInfo> map = sActivityInfo;
        synchronized (map) {
            sApplicationStateListeners.clear();
            sGeneralActivityStateListeners.clear();
            map.clear();
            sWindowFocusListeners.clear();
            sCurrentApplicationState = 0;
            sActivity = null;
            sNativeApplicationStateListener = null;
        }
    }

    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: aegon.chrome.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.sNativeApplicationStateListener != null) {
                    return;
                }
                ApplicationStateListener unused = ApplicationStatus.sNativeApplicationStateListener = new ApplicationStateListener() { // from class: aegon.chrome.base.ApplicationStatus.3.1
                    @Override // aegon.chrome.base.ApplicationStatus.ApplicationStateListener
                    public void onApplicationStateChange(int i) {
                        ApplicationStatus.nativeOnApplicationStateChange(i);
                    }
                };
                ApplicationStatus.registerApplicationStateListener(ApplicationStatus.sNativeApplicationStateListener);
            }
        });
    }

    private static int determineApplicationStateLocked() {
        Iterator<ActivityInfo> it = sActivityInfo.values().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            int status = it.next().getStatus();
            if (status != 4 && status != 5 && status != 6) {
                return 1;
            }
            if (status == 4) {
                z = true;
            } else if (status == 5) {
                z2 = true;
            }
        }
        if (z) {
            return 2;
        }
        return z2 ? 3 : 4;
    }
}
