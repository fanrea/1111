package com.bytedance.d.hc.u;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.d.hc.gb.tc;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements Handler.Callback {
    private static Printer d;
    private static u hc;
    private static final Printer tc = new Printer() { // from class: com.bytedance.d.hc.u.u.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                u.d().d(str);
            } else if (str.startsWith("<<<<< Finished")) {
                u.d().hc(str);
            }
            if (u.d == null || u.d == u.tc) {
                return;
            }
            u.d.println(str);
        }
    };
    private long an;
    private boolean mq;
    private long u;
    private int c = 0;
    private final SparseArray<List<Runnable>> h = new SparseArray<>();
    private final List<Printer> gb = new LinkedList();
    private final List<Printer> tt = new LinkedList();
    private boolean mk = false;
    private Handler b = new Handler(h.d().getLooper(), this);

    private u() throws NoSuchFieldException {
        hc();
    }

    public static u d() {
        if (hc == null) {
            synchronized (u.class) {
                if (hc == null) {
                    hc = new u();
                }
            }
        }
        return hc;
    }

    public void hc() throws NoSuchFieldException {
        if (this.mk) {
            return;
        }
        this.mk = true;
        Printer printerU = u();
        d = printerU;
        Printer printer = tc;
        if (printerU == printer) {
            d = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private Printer u() throws NoSuchFieldException {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            tc.hc(e);
            return null;
        }
    }

    public void d(long j, Runnable runnable) {
        d(j, runnable, 1, 0L);
    }

    public void d(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.h.get(i3);
            if (linkedList == null) {
                synchronized (this.h) {
                    linkedList = this.h.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.h.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    void d(String str) {
        if (!this.mq) {
            an.d(32L);
            this.mq = true;
        }
        this.u = SystemClock.uptimeMillis();
        try {
            d(this.gb, str);
            this.b.sendEmptyMessage(0);
        } catch (Exception e) {
            tc.d(e);
        }
    }

    void hc(String str) {
        this.an = SystemClock.uptimeMillis();
        try {
            this.b.removeMessages(2);
            d(this.tt, str);
            this.b.sendEmptyMessage(1);
        } catch (Exception e) {
            tc.hc(e);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.b.hasMessages(0)) {
            return true;
        }
        int i = message.what;
        if (i == 0) {
            this.c = 0;
            if (this.h.size() != 0 && this.h.keyAt(0) == 0) {
                d(this.h.valueAt(0));
                this.c++;
            }
        } else {
            if (i == 1) {
                this.b.removeMessages(2);
                if (this.h.size() != 0) {
                    SparseArray<List<Runnable>> sparseArray = this.h;
                    if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                        d(this.h.get(Integer.MAX_VALUE));
                    }
                }
                return true;
            }
            if (i == 2) {
                d(this.h.valueAt(this.c));
                this.c++;
            }
        }
        if (this.c >= this.h.size()) {
            return true;
        }
        long jKeyAt = this.h.keyAt(this.c);
        if (jKeyAt != 2147483647L) {
            this.b.sendEmptyMessageAtTime(2, this.u + jKeyAt);
        }
        return true;
    }

    private static void d(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            tc.d(e);
        }
    }

    private synchronized void d(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    tc.d(e);
                }
            }
        }
    }
}
