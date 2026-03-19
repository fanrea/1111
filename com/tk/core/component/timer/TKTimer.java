package com.tk.core.component.timer;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKTimer implements Handler.Callback {
    private static final long DURATION_REPORTER = 3600000;
    private static final int MSG_TIME_ADD = 1000;
    private static final int MSG_TIME_CALLBACK = 1002;
    private static final int MSG_TIME_CLEAR = 1001;
    private static final int MSG_TIME_DESTROY = 1003;
    private static final int MSG_TIME_REMOVE_PENDING_TIMER_ACTION = 1004;
    private static Boolean sEnableOptSetInterval;
    private static long sId;
    private final HashMap<Integer, b> mTimerInfo = new HashMap<>();
    private long mLastReportTime = 0;
    private final Handler mHandler = new Handler(com.tk.core.manager.a.rV().rW().getLooper(), this);
    private final Map<Long, a> mPendingTimerAction = new HashMap();

    public static class a {
        public long ahn;
        public String aho;
        public long ahp;
        public boolean ahq;
        public String bundleId;
        public long id;
        public int key;
    }

    public int setInterval(V8Function v8Function, long j, String str, String str2) {
        return addTimer(v8Function, j, str, true, str2);
    }

    public void clearInterval(int i) {
        clearTimer(i);
    }

    public int setTimeout(V8Function v8Function, long j, String str, String str2) {
        return addTimer(v8Function, j, str, false, str2);
    }

    public void clearTimeout(int i) {
        clearTimer(i);
    }

    public void destroy(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1003, str));
    }

    private int addTimer(V8Function v8Function, long j, String str, boolean z, String str2) {
        if (v8Function == null) {
            return 0;
        }
        b bVar = new b(j, z, ad.retainJsValue(v8Function, null), str, str2);
        int iHashCode = bVar.hashCode();
        bVar.dX(iHashCode);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1000, bVar));
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1002, bVar), j);
        return iHashCode;
    }

    private void clearTimer(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1001, Integer.valueOf(i)));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                handAddTimer((b) message.obj);
                break;
            case 1001:
                handleClearTimer(((Integer) message.obj).intValue());
                break;
            case 1002:
                handlerTimerCallback((b) message.obj);
                break;
            case 1003:
                handleDestroyTimer((String) message.obj);
                break;
            case 1004:
                handlerRemovePendingTimerAction(((Long) message.obj).longValue());
                break;
        }
        return false;
    }

    private void handAddTimer(b bVar) {
        this.mTimerInfo.put(Integer.valueOf(bVar.ahr), bVar);
    }

    private void handleClearTimer(int i) {
        final b bVarRemove = this.mTimerInfo.remove(Integer.valueOf(i));
        if (bVarRemove == null) {
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.timer.TKTimer.1
            @Override // java.lang.Runnable
            public final void run() {
                ad.unRetainJsValue(bVarRemove.mV8FunctionRef);
            }
        });
    }

    private void handleDestroyTimer(String str) {
        b value;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<Map.Entry<Integer, b>> it = this.mTimerInfo.entrySet().iterator();
        while (it.hasNext()) {
            try {
                Map.Entry<Integer, b> next = it.next();
                if (next != null && (value = next.getValue()) != null && str.equals(value.YM)) {
                    this.mHandler.removeCallbacksAndMessages(value);
                    it.remove();
                }
            } catch (Throwable th) {
                com.tk.core.exception.a.a((com.tk.core.bridge.b) null, th);
                return;
            }
        }
    }

    private void handlerTimerCallback(final b bVar) {
        if (bVar == null || !this.mTimerInfo.containsValue(bVar)) {
            return;
        }
        final long j = sId + 1;
        sId = j;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a aVar = new a();
        aVar.id = j;
        aVar.ahn = jElapsedRealtime;
        aVar.aho = bVar.YM;
        aVar.bundleId = bVar.mBundleId;
        aVar.key = bVar.ahr;
        aVar.ahp = bVar.Qv;
        aVar.ahq = bVar.aht;
        boolean zIsEnableOptSetInterval = isEnableOptSetInterval();
        if (!zIsEnableOptSetInterval) {
            com.tk.core.i.a.z("TKTimer", "isEnableOptSetInterval: false");
        }
        if (!(bVar.aht && bVar.ahs && zIsEnableOptSetInterval)) {
            if (bVar.aht) {
                bVar.ahs = true;
            }
            this.mPendingTimerAction.put(Long.valueOf(j), aVar);
            if (this.mPendingTimerAction.size() > 15 && jElapsedRealtime - this.mLastReportTime > 3600000) {
                this.mLastReportTime = jElapsedRealtime;
                com.tk.core.n.a.p(new ArrayList(this.mPendingTimerAction.values()));
            }
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.timer.TKTimer.2
                @Override // java.lang.Runnable
                public final void run() {
                    bVar.ahs = false;
                    TKTimer.this.mHandler.sendMessage(TKTimer.this.mHandler.obtainMessage(1004, Long.valueOf(j)));
                    if (bVar.mV8FunctionRef == null) {
                        return;
                    }
                    V8Function v8Function = bVar.mV8FunctionRef.get();
                    try {
                        if (ad.isV8Valid(v8Function)) {
                            v8Function.call(null, new Object[0]);
                        }
                        if (bVar.aht) {
                            return;
                        }
                        ad.unRetainJsValue(bVar.mV8FunctionRef);
                    } catch (Throwable th) {
                        com.tk.core.exception.a.a(bVar.mBundleId, th, (String) null);
                    }
                }
            });
        }
        if (!bVar.aht) {
            this.mTimerInfo.remove(Integer.valueOf(bVar.ahr));
        } else {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1002, bVar), bVar.Qv);
        }
    }

    private void handlerRemovePendingTimerAction(long j) {
        this.mPendingTimerAction.remove(Long.valueOf(j));
    }

    private boolean isEnableOptSetInterval() {
        if (sEnableOptSetInterval == null && com.tk.core.a.oP().getTKSwitch() != null) {
            sEnableOptSetInterval = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
        }
        Boolean bool = sEnableOptSetInterval;
        return bool != null && bool.booleanValue();
    }

    static class b {
        final long Qv;
        final String YM;
        int ahr;
        volatile boolean ahs;
        final boolean aht;
        final String mBundleId;
        final JsValueRef<V8Function> mV8FunctionRef;

        b(long j, boolean z, JsValueRef<V8Function> jsValueRef, String str, String str2) {
            this.Qv = j;
            this.aht = z;
            this.mV8FunctionRef = jsValueRef;
            this.YM = str;
            this.mBundleId = str2;
        }

        public final void dX(int i) {
            this.ahr = i;
        }
    }
}
