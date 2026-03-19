package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class TraceEvent implements AutoCloseable {
    private static volatile boolean sATraceEnabled;
    private static volatile boolean sEnabled;
    private final String mName;

    private static native void nativeBegin(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeBeginToplevel(String str);

    private static native void nativeEnd(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeEndToplevel(String str);

    private static native void nativeFinishAsync(String str, long j);

    private static native void nativeInstant(String str, String str2);

    private static native void nativeRegisterEnabledObserver();

    private static native void nativeStartATrace();

    private static native void nativeStartAsync(String str, long j);

    private static native void nativeStopATrace();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class BasicLooperMonitor implements Printer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        private static final int SHORTEST_LOG_PREFIX_LENGTH = 18;
        private String mCurrentTarget;

        private BasicLooperMonitor() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                beginHandling(str);
            } else {
                endHandling(str);
            }
        }

        void beginHandling(String str) {
            boolean zIsActive = EarlyTraceEvent.isActive();
            if (TraceEvent.sEnabled || zIsActive) {
                this.mCurrentTarget = getTraceEventName(str);
                if (TraceEvent.sEnabled) {
                    TraceEvent.nativeBeginToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.begin(this.mCurrentTarget);
                }
            }
        }

        void endHandling(String str) {
            boolean zIsActive = EarlyTraceEvent.isActive();
            if ((TraceEvent.sEnabled || zIsActive) && this.mCurrentTarget != null) {
                if (TraceEvent.sEnabled) {
                    TraceEvent.nativeEndToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.end(this.mCurrentTarget);
                }
            }
            this.mCurrentTarget = null;
        }

        private static String getTraceEventName(String str) {
            return LOOPER_TASK_PREFIX + getTarget(str) + "(" + getTargetName(str) + ")";
        }

        private static String getTarget(String str) {
            int iIndexOf = str.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            int iIndexOf2 = iIndexOf == -1 ? -1 : str.indexOf(41, iIndexOf);
            return iIndexOf2 != -1 ? str.substring(iIndexOf + 1, iIndexOf2) : "";
        }

        private static String getTargetName(String str) {
            int iIndexOf = str.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            int iIndexOf2 = iIndexOf == -1 ? -1 : str.indexOf(58, iIndexOf);
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.length();
            }
            return iIndexOf != -1 ? str.substring(iIndexOf + 2, iIndexOf2) : "";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        private static final long FRAME_DURATION_MILLIS = 16;
        private static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        private static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        private static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        private static final String TAG = "TraceEvent.LooperMonitor";
        private boolean mIdleMonitorAttached;
        private long mLastIdleStartedAt;
        private long mLastWorkStartedAt;
        private int mNumIdlesSeen;
        private int mNumTasksSeen;
        private int mNumTasksSinceLastIdle;

        private IdleTracingLooperMonitor() {
            super();
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.sEnabled && !this.mIdleMonitorAttached) {
                this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
                Looper.myQueue().addIdleHandler(this);
                this.mIdleMonitorAttached = true;
                android.util.Log.v(TAG, "attached idle handler");
                return;
            }
            if (!this.mIdleMonitorAttached || TraceEvent.sEnabled) {
                return;
            }
            Looper.myQueue().removeIdleHandler(this);
            this.mIdleMonitorAttached = false;
            android.util.Log.v(TAG, "detached idle handler");
        }

        @Override // aegon.chrome.base.TraceEvent.BasicLooperMonitor
        final void beginHandling(String str) {
            if (this.mNumTasksSinceLastIdle == 0) {
                TraceEvent.end(IDLE_EVENT_NAME);
            }
            this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
            syncIdleMonitoring();
            super.beginHandling(str);
        }

        @Override // aegon.chrome.base.TraceEvent.BasicLooperMonitor
        final void endHandling(String str) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
            if (jElapsedRealtime > 16) {
                traceAndLog(5, "observed a task that took " + jElapsedRealtime + "ms: " + str);
            }
            super.endHandling(str);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        private static void traceAndLog(int i, String str) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", str);
            android.util.Log.println(i, TAG, str);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mLastIdleStartedAt == 0) {
                this.mLastIdleStartedAt = jElapsedRealtime;
            }
            long j = jElapsedRealtime - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (j > MIN_INTERESTING_BURST_DURATION_MILLIS) {
                traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + j + "ms elapsed since last idle");
            }
            this.mLastIdleStartedAt = jElapsedRealtime;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static final class LooperMonitorHolder {
        private static final BasicLooperMonitor sInstance;

        private LooperMonitorHolder() {
        }

        static {
            sInstance = CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING) ? new IdleTracingLooperMonitor() : new BasicLooperMonitor();
        }
    }

    private TraceEvent(String str, String str2) {
        this.mName = str;
        begin(str, str2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static TraceEvent scoped(String str, String str2) {
        if (EarlyTraceEvent.enabled() || enabled()) {
            return new TraceEvent(str, str2);
        }
        return null;
    }

    public static TraceEvent scoped(String str) {
        return scoped(str, null);
    }

    public static void registerNativeEnabledObserver() {
        nativeRegisterEnabledObserver();
    }

    public static void setEnabled(boolean z) {
        if (z) {
            EarlyTraceEvent.disable();
        }
        if (sEnabled != z) {
            sEnabled = z;
            if (sATraceEnabled) {
                return;
            }
            ThreadUtils.getUiThreadLooper().setMessageLogging(z ? LooperMonitorHolder.sInstance : null);
        }
    }

    public static void maybeEnableEarlyTracing() {
        EarlyTraceEvent.maybeEnable();
        if (EarlyTraceEvent.isActive()) {
            ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.sInstance);
        }
    }

    public static void setATraceEnabled(boolean z) {
        if (sATraceEnabled == z) {
            return;
        }
        sATraceEnabled = z;
        if (z) {
            nativeStartATrace();
        } else {
            nativeStopATrace();
        }
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void instant(String str) {
        if (sEnabled) {
            nativeInstant(str, null);
        }
    }

    public static void instant(String str, String str2) {
        if (sEnabled) {
            nativeInstant(str, str2);
        }
    }

    public static void startAsync(String str, long j) {
        EarlyTraceEvent.startAsync(str, j);
        if (sEnabled) {
            nativeStartAsync(str, j);
        }
    }

    public static void finishAsync(String str, long j) {
        EarlyTraceEvent.finishAsync(str, j);
        if (sEnabled) {
            nativeFinishAsync(str, j);
        }
    }

    public static void begin(String str) {
        begin(str, null);
    }

    public static void begin(String str, String str2) {
        EarlyTraceEvent.begin(str);
        if (sEnabled) {
            nativeBegin(str, str2);
        }
    }

    public static void end(String str) {
        end(str, null);
    }

    public static void end(String str, String str2) {
        EarlyTraceEvent.end(str);
        if (sEnabled) {
            nativeEnd(str, str2);
        }
    }
}
