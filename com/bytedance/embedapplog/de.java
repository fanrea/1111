package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class de implements Handler.Callback, Comparator<to> {
    private static de hc;
    private static long uo;
    private ra an;
    private rf b;
    private fs c;
    public Application d;
    private Handler gb;
    private ba h;
    private Handler mk;
    private np mq;
    private com.bytedance.embedapplog.util.d tc;
    private yi tt;
    private final ArrayList<to> u = new ArrayList<>(32);

    public static void d() {
        if (hc != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - uo) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                uo = jCurrentTimeMillis;
                hc.d((String[]) null, true);
            }
        }
    }

    private de() {
    }

    public Context hc() {
        return this.d;
    }

    public ra b() {
        return this.an;
    }

    public fs c() {
        return this.c;
    }

    public ba u() {
        return this.h;
    }

    public static de an() {
        if (hc == null) {
            synchronized (de.class) {
                if (hc == null) {
                    hc = new de();
                }
            }
        }
        return hc;
    }

    public yi h() {
        return this.tt;
    }

    public com.bytedance.embedapplog.util.d gb() {
        if (this.tc == null) {
            com.bytedance.embedapplog.util.d dVarMk = this.c.wl().mk();
            this.tc = dVarMk;
            if (dVarMk == null) {
                this.tc = com.bytedance.embedapplog.util.hc.d(0);
            }
        }
        return this.tc;
    }

    public void d(Application application, fs fsVar, ba baVar, yo yoVar) {
        this.d = application;
        this.an = new ra(this);
        this.c = fsVar;
        this.h = baVar;
        this.tt = new yi(this.h, this.c);
        this.d.registerActivityLifecycleCallbacks(yoVar);
        Looper looperD = fv.d(fsVar);
        if (looperD == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperD = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperD, this);
        this.mk = handler;
        handler.sendEmptyMessage(1);
        gw.d(fsVar.gb() != 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (i == 1) {
                um.d = this.c.de();
                if (this.h.an()) {
                    if (this.c.w()) {
                        Looper looperHc = fv.hc(this.c);
                        if (looperHc == null) {
                            HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                            handlerThread.start();
                            looperHc = handlerThread.getLooper();
                        }
                        Handler handler = new Handler(looperHc, this);
                        this.gb = handler;
                        handler.sendEmptyMessage(2);
                        if (this.u.size() > 0) {
                            this.mk.removeMessages(4);
                            this.mk.sendEmptyMessageDelayed(4, 1000L);
                        }
                        um.c("net|worker start", null);
                    }
                } else {
                    this.mk.removeMessages(1);
                    this.mk.sendEmptyMessageDelayed(1, 1000L);
                }
                vv.d();
            } else if (i == 2) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(new v(this));
                arrayList.add(new sy(this));
                np npVar = new np(this);
                this.mq = npVar;
                arrayList.add(npVar);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jh jhVar = (jh) it.next();
                    if (jhVar instanceof np) {
                        this.mq.d(fv.d());
                    }
                    long jH = jhVar.h();
                    if (jH < 864000000) {
                        this.gb.sendMessageDelayed(this.mk.obtainMessage(6, jhVar), jH);
                    }
                }
                this.mq.d(true);
                tc();
            } else if (i == 4) {
                d((String[]) null, false);
            } else if (i == 5) {
                d((String[]) message.obj, false);
            } else if (i == 6) {
                jh jhVar2 = (jh) message.obj;
                if (!jhVar2.an()) {
                    long jH2 = jhVar2.h();
                    if (jH2 < 864000000) {
                        this.gb.sendMessageDelayed(this.mk.obtainMessage(6, jhVar2), jH2);
                    }
                    tc();
                }
                this.mq.d(true);
            } else if (i == 7) {
                synchronized (this.u) {
                    this.u.add(yi.u());
                }
                d((String[]) null, false);
            } else if (i == 89) {
                ba baVar = this.h;
                if (baVar != null) {
                    baVar.u();
                }
            } else {
                um.hc((Throwable) null);
            }
        } catch (Throwable th) {
            um.d("engine:" + th.getMessage());
        }
        return true;
    }

    private void tc() {
        if (this.c.sy()) {
            if (this.b == null) {
                rf rfVar = new rf(this);
                this.b = rfVar;
                this.gb.obtainMessage(6, rfVar).sendToTarget();
                return;
            }
            return;
        }
        rf rfVar2 = this.b;
        if (rfVar2 != null) {
            rfVar2.u();
            this.b = null;
        }
    }

    private void d(String[] strArr, boolean z) {
        ArrayList<to> arrayList;
        synchronized (this.u) {
            arrayList = (ArrayList) this.u.clone();
            this.u.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(to.d(str));
            }
        }
        boolean zD = this.c.d(arrayList);
        if (arrayList.size() > 0) {
            if (this.c.w()) {
                if (zD || arrayList.size() > 100) {
                    Collections.sort(arrayList, this);
                    ArrayList<to> arrayList2 = new ArrayList<>(arrayList.size());
                    Iterator<to> it = arrayList.iterator();
                    boolean zD2 = false;
                    boolean zD3 = false;
                    while (it.hasNext()) {
                        to next = it.next();
                        zD2 |= this.tt.d(next, arrayList2);
                        if (next instanceof i) {
                            zD3 = yi.d(next);
                            i = 1;
                        }
                    }
                    this.an.d(arrayList2);
                    if (i != 0) {
                        if (zD3) {
                            this.mk.removeMessages(7);
                        } else if (!fv.hc() && fv.d()) {
                            this.mk.sendEmptyMessageDelayed(7, this.c.v());
                        }
                    }
                    if (zD2 || z) {
                        mk();
                        return;
                    }
                    return;
                }
                synchronized (this.u) {
                    this.u.addAll(arrayList);
                }
                return;
            }
            Intent intent = new Intent(this.d, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i < size) {
                String string = arrayList.get(i).u().toString();
                strArr2[i] = string;
                length += string.length();
                i++;
            }
            if (length >= 307200) {
                um.hc((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.d.sendBroadcast(intent);
            } catch (Exception e) {
                um.hc(e);
            }
        }
    }

    private void mk() {
        if (um.hc) {
            um.d("packAndSend once, " + this.tt.d() + ", hadUI:" + this.tt.hc(), null);
        }
        np npVar = this.mq;
        if (npVar != null) {
            npVar.gb();
        }
        if (this.gb != null) {
            this.mq.d(fv.d());
            this.gb.sendMessage(this.mk.obtainMessage(6, this.mq));
        }
    }

    public static void d(to toVar) {
        int size;
        Handler handler;
        de deVar = hc;
        if (deVar == null) {
            um.hc("Init comes First!", null);
            vv.d(toVar);
            return;
        }
        if (toVar.hc == 0) {
            um.hc((Throwable) null);
        }
        synchronized (deVar.u) {
            size = deVar.u.size();
            deVar.u.add(toVar);
        }
        if (size % 10 != 0 || (handler = deVar.mk) == null) {
            return;
        }
        handler.removeMessages(4);
        deVar.mk.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void d(String[] strArr) {
        de deVar = hc;
        if (deVar == null) {
            um.hc(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = deVar.mk;
        if (handler != null) {
            handler.removeMessages(4);
            deVar.mk.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compare(to toVar, to toVar2) {
        long j = toVar.hc - toVar2.hc;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public void tt() {
        Handler handler = this.mk;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.mk.sendEmptyMessage(89);
    }
}
