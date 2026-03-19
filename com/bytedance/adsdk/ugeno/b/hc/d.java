package com.bytedance.adsdk.ugeno.b.hc;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public String d = "GesThrough_";
    private List<MotionEvent> hc = new ArrayList();
    private Set<String> b = Collections.synchronizedSet(new HashSet());

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar, MotionEvent motionEvent) {
        if (bVar == null || motionEvent == null || this.hc == null) {
            return;
        }
        this.d = "GesThrough_" + bVar.us();
        int[] iArr = new int[2];
        bVar.tt().getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.hc.clear();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i, i2);
        this.hc.add(motionEventObtain);
    }

    public boolean d(MotionEvent motionEvent) {
        if (motionEvent == null || this.b == null) {
            return false;
        }
        return this.b.contains(motionEvent.getDownTime() + Config.replace + motionEvent.getPointerId(motionEvent.getActionIndex()));
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        if (this.hc.isEmpty() || this.b == null || bVar == null || bVar.tt() == null || bVar.tt().getRootView() == null) {
            return;
        }
        final View rootView = bVar.tt().getRootView();
        this.hc.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.b.hc.d.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : d.this.hc) {
                    if (motionEvent != null) {
                        d.this.b.add(motionEvent.getDownTime() + Config.replace + motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                d.this.hc.clear();
            }
        }, 300L);
    }
}
