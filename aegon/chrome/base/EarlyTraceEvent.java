package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class EarlyTraceEvent {
    private static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
    static final int STATE_DISABLED = 0;
    static final int STATE_ENABLED = 1;
    static final int STATE_FINISHED = 3;
    static final int STATE_FINISHING = 2;
    private static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    static List<AsyncEvent> sAsyncEvents;
    private static boolean sCachedBackgroundStartupTracingFlag;
    static List<Event> sCompletedEvents;
    private static final Object sLock = new Object();
    static List<String> sPendingAsyncEvents;
    static Map<String, Event> sPendingEventByKey;
    static volatile int sState;

    private static native void nativeRecordEarlyEvent(String str, long j, long j2, int i, long j3);

    private static native void nativeRecordEarlyFinishAsyncEvent(String str, long j, long j2);

    private static native void nativeRecordEarlyStartAsyncEvent(String str, long j, long j2);

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class Event {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        long mEndThreadTimeMillis;
        long mEndTimeNanos;
        final String mName;
        final int mThreadId = Process.myTid();
        final long mBeginTimeNanos = elapsedRealtimeNanos();
        final long mBeginThreadTimeMillis = SystemClock.currentThreadTimeMillis();

        Event(String str) {
            this.mName = str;
        }

        final void end() {
            this.mEndTimeNanos = elapsedRealtimeNanos();
            this.mEndThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        }

        static long elapsedRealtimeNanos() {
            if (Build.VERSION.SDK_INT >= 17) {
                return SystemClock.elapsedRealtimeNanos();
            }
            return SystemClock.elapsedRealtime() * 1000000;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class AsyncEvent {
        final long mId;
        final boolean mIsStart;
        final String mName;
        final long mTimestampNanos = Event.elapsedRealtimeNanos();

        AsyncEvent(String str, long j, boolean z) {
            this.mName = str;
            this.mId = j;
            this.mIsStart = z;
        }
    }

    static void maybeEnable() {
        boolean zExists;
        ThreadUtils.assertOnUiThread();
        if (sState != 0) {
            return;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            boolean z = true;
            if (CommandLine.getInstance().hasSwitch("trace-startup")) {
                zExists = true;
            } else {
                try {
                    zExists = new File(TRACE_CONFIG_FILENAME).exists();
                } catch (SecurityException unused) {
                    zExists = false;
                }
            }
            if (!ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false)) {
                z = zExists;
            } else if (zExists) {
                setBackgroundStartupTracingFlag(false);
                sCachedBackgroundStartupTracingFlag = false;
                z = zExists;
            } else {
                sCachedBackgroundStartupTracingFlag = true;
            }
            if (z) {
                enable();
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static void enable() {
        synchronized (sLock) {
            if (sState != 0) {
                return;
            }
            sCompletedEvents = new ArrayList();
            sPendingEventByKey = new HashMap();
            sAsyncEvents = new ArrayList();
            sPendingAsyncEvents = new ArrayList();
            sState = 1;
        }
    }

    static void disable() {
        synchronized (sLock) {
            if (enabled()) {
                sState = 2;
                maybeFinishLocked();
            }
        }
    }

    static boolean isActive() {
        int i = sState;
        return i == 1 || i == 2;
    }

    static boolean enabled() {
        return sState == 1;
    }

    static void setBackgroundStartupTracingFlag(boolean z) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, z).apply();
    }

    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    public static void begin(String str) {
        if (enabled()) {
            Event event = new Event(str);
            synchronized (sLock) {
                if (enabled()) {
                    Event eventPut = sPendingEventByKey.put(makeEventKeyForCurrentThread(str), event);
                    if (eventPut != null) {
                        throw new IllegalArgumentException("Multiple pending trace events can't have the same name: " + str);
                    }
                }
            }
        }
    }

    public static void end(String str) {
        if (isActive()) {
            synchronized (sLock) {
                if (isActive()) {
                    Event eventRemove = sPendingEventByKey.remove(makeEventKeyForCurrentThread(str));
                    if (eventRemove == null) {
                        return;
                    }
                    eventRemove.end();
                    sCompletedEvents.add(eventRemove);
                    if (sState == 2) {
                        maybeFinishLocked();
                    }
                }
            }
        }
    }

    public static void startAsync(String str, long j) {
        if (enabled()) {
            AsyncEvent asyncEvent = new AsyncEvent(str, j, true);
            synchronized (sLock) {
                if (enabled()) {
                    sAsyncEvents.add(asyncEvent);
                    sPendingAsyncEvents.add(str);
                }
            }
        }
    }

    public static void finishAsync(String str, long j) {
        if (isActive()) {
            AsyncEvent asyncEvent = new AsyncEvent(str, j, false);
            synchronized (sLock) {
                if (isActive()) {
                    if (sPendingAsyncEvents.remove(str)) {
                        sAsyncEvents.add(asyncEvent);
                        if (sState == 2) {
                            maybeFinishLocked();
                        }
                    }
                }
            }
        }
    }

    static void resetForTesting() {
        synchronized (sLock) {
            sState = 0;
            sCompletedEvents = null;
            sPendingEventByKey = null;
            sAsyncEvents = null;
            sPendingAsyncEvents = null;
        }
    }

    private static void maybeFinishLocked() {
        if (!sCompletedEvents.isEmpty()) {
            dumpEvents(sCompletedEvents);
            sCompletedEvents.clear();
        }
        if (!sAsyncEvents.isEmpty()) {
            dumpAsyncEvents(sAsyncEvents);
            sAsyncEvents.clear();
        }
        if (sPendingEventByKey.isEmpty() && sPendingAsyncEvents.isEmpty()) {
            sState = 3;
            sPendingEventByKey = null;
            sCompletedEvents = null;
            sPendingAsyncEvents = null;
            sAsyncEvents = null;
        }
    }

    private static void dumpEvents(List<Event> list) {
        long offsetNanos = getOffsetNanos();
        for (Event event : list) {
            nativeRecordEarlyEvent(event.mName, event.mBeginTimeNanos + offsetNanos, event.mEndTimeNanos + offsetNanos, event.mThreadId, event.mEndThreadTimeMillis - event.mBeginThreadTimeMillis);
        }
    }

    private static void dumpAsyncEvents(List<AsyncEvent> list) {
        long offsetNanos = getOffsetNanos();
        for (AsyncEvent asyncEvent : list) {
            if (asyncEvent.mIsStart) {
                nativeRecordEarlyStartAsyncEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimestampNanos + offsetNanos);
            } else {
                nativeRecordEarlyFinishAsyncEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimestampNanos + offsetNanos);
            }
        }
    }

    private static long getOffsetNanos() {
        return (TimeUtils.nativeGetTimeTicksNowUs() * 1000) - Event.elapsedRealtimeNanos();
    }

    static String makeEventKeyForCurrentThread(String str) {
        return str + "@" + Process.myTid();
    }
}
