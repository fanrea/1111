package com.baidu.mobads.container.w.e;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.FrameMetrics;
import android.view.Window;
import com.baidu.mobads.container.util.bo;
import com.baidu.mobads.container.w.b.d;
import com.baidu.mobads.container.w.b.f;
import com.baidu.mobads.container.w.b.h;
import com.baidu.mobads.container.w.c.g;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends g {
    public static float a = 60.0f;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    public static final int i = 8;
    public static final int j = 9;
    public static final int k = 1000000000;
    public static final int l = 1000000;
    private static final long n = 4611686018427387903L;
    private final Map<Integer, Window.OnFrameMetricsAvailableListener> m = new ConcurrentHashMap();
    private final ConcurrentHashMap<String, a> o = new ConcurrentHashMap<>();

    @Override // com.baidu.mobads.container.w.c.g
    protected void a() {
        super.a();
        d.b().c().registerActivityLifecycleCallbacks(this);
    }

    @Override // com.baidu.mobads.container.w.c.g
    protected void b() {
        super.b();
        d.b().c().unregisterActivityLifecycleCallbacks(this);
        this.m.clear();
    }

    @Override // com.baidu.mobads.container.w.c.g
    public void b(Activity activity, Bundle bundle, String str) {
        String simpleName;
        Class<?> cls;
        try {
            Object objA = bo.a(activity, "mRewardVideo");
            if (objA != null && (cls = objA.getClass()) != null) {
                simpleName = cls.getSimpleName();
            } else {
                simpleName = str;
            }
            this.o.put(str, new a(simpleName));
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(Window window) {
        return window.getWindowManager().getDefaultDisplay().getRefreshRate();
    }

    @Override // com.baidu.mobads.container.w.c.g
    public void d(Activity activity, String str) {
        try {
            if (this.m.containsKey(Integer.valueOf(activity.hashCode()))) {
                return;
            }
            a = a(activity.getWindow());
            c cVar = new c(this, str);
            this.m.put(Integer.valueOf(activity.hashCode()), cVar);
            activity.getWindow().addOnFrameMetricsAvailableListener(cVar, com.baidu.mobads.container.w.c.a.b());
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.mobads.container.w.c.g
    public void a(Activity activity, String str) {
    }

    @Override // com.baidu.mobads.container.w.c.g
    public void b(Activity activity, String str) {
    }

    @Override // com.baidu.mobads.container.w.c.g
    public void a(Activity activity, Bundle bundle, String str) {
    }

    @Override // com.baidu.mobads.container.w.c.g
    public void c(Activity activity, String str) {
        try {
            a aVar = this.o.get(str);
            if (aVar != null) {
                aVar.a();
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.m.remove(Integer.valueOf(activity.hashCode())));
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        private float c;
        private long e;
        private float f;
        private float g;
        private float h;
        private String i;
        private long k;
        private long l;
        private final int[] a = new int[5];
        private final int[] b = new int[5];
        private int d = 0;
        private int j = 0;
        private final LinkedList<Long> m = new LinkedList<>();

        a(String str) {
            this.i = str;
        }

        public void a(FrameMetrics frameMetrics, float f, float f2, long j) {
            if (this.d == 0) {
                this.e = SystemClock.uptimeMillis();
            }
            if (j > this.l) {
                this.l = j;
            }
            this.c += f;
            this.h += f2;
            this.g += Math.max(j, 1.0E9f / f2);
            this.d++;
            a(Math.round(f));
            if (j > 7.0E8d) {
                this.f += 1.0f;
            }
            Long lValueOf = 0L;
            if (this.m.size() < 3) {
                this.m.add(Long.valueOf(j));
            } else {
                Iterator<Long> it = this.m.iterator();
                while (it.hasNext()) {
                    lValueOf = Long.valueOf(lValueOf.longValue() + it.next().longValue());
                }
                z = j > (lValueOf.longValue() / 3) * 2;
                this.m.add(Long.valueOf(j));
                this.m.poll();
            }
            if (j > 83333332 && z) {
                this.j++;
                this.k += j;
            }
        }

        public synchronized void a() {
            if (this.d <= 20) {
                b();
                return;
            }
            int i = (int) (1.0E9f / (this.g / this.d));
            float f = this.f / this.d;
            float f2 = this.c / (this.d + this.c);
            float f3 = this.h / this.d;
            float f4 = this.k / this.g;
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                for (com.baidu.mobads.container.w.e.a aVar : com.baidu.mobads.container.w.e.a.values()) {
                    jSONObject2.put(aVar.c() + "", this.a[aVar.b()]);
                    jSONObject3.put(aVar.c() + "", this.b[aVar.b()]);
                }
                jSONObject.put("fps", i);
                jSONObject.put("freezeFrameRate", String.format("%.3f", Float.valueOf(f)));
                jSONObject.put("dropFrameRate", String.format("%.3f", Float.valueOf(f2)));
                jSONObject.put("refreshRate", f3);
                jSONObject.put("dropLevel", jSONObject2);
                jSONObject.put("dropSum", jSONObject3);
                jSONObject.put("longestFrameTime", this.l / 1000000);
                jSONObject.put("jank", this.j);
                jSONObject.put("stutter", String.format("%.3f", Float.valueOf(f4)));
                jSONObject.put("currentSceneName", this.i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h hVar = (h) d.b().a(h.class);
            if (hVar != null) {
                f fVar = new f();
                fVar.a(com.baidu.mobads.container.w.g.a.FRAME_TAG);
                fVar.a(jSONObject);
                hVar.a(fVar);
            }
            b();
        }

        private void b() {
            this.c = 0.0f;
            this.d = 0;
            this.e = 0L;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            this.i = "";
            this.l = 0L;
            this.j = 0;
            this.k = 0L;
            this.m.clear();
            Arrays.fill(this.a, 0);
            Arrays.fill(this.b, 0);
        }

        private void a(int i) {
            if (i >= 42) {
                int[] iArr = this.a;
                int iB = com.baidu.mobads.container.w.e.a.DROPPED_FROZEN.b();
                iArr[iB] = iArr[iB] + 1;
                int[] iArr2 = this.b;
                int iB2 = com.baidu.mobads.container.w.e.a.DROPPED_FROZEN.b();
                iArr2[iB2] = iArr2[iB2] + i;
                return;
            }
            if (i >= 24) {
                int[] iArr3 = this.a;
                int iB3 = com.baidu.mobads.container.w.e.a.DROPPED_HIGH.b();
                iArr3[iB3] = iArr3[iB3] + 1;
                int[] iArr4 = this.b;
                int iB4 = com.baidu.mobads.container.w.e.a.DROPPED_HIGH.b();
                iArr4[iB4] = iArr4[iB4] + i;
                return;
            }
            if (i >= 9) {
                int[] iArr5 = this.a;
                int iB5 = com.baidu.mobads.container.w.e.a.DROPPED_MIDDLE.b();
                iArr5[iB5] = iArr5[iB5] + 1;
                int[] iArr6 = this.b;
                int iB6 = com.baidu.mobads.container.w.e.a.DROPPED_MIDDLE.b();
                iArr6[iB6] = iArr6[iB6] + i;
                return;
            }
            if (i >= 3) {
                int[] iArr7 = this.a;
                int iB7 = com.baidu.mobads.container.w.e.a.DROPPED_NORMAL.b();
                iArr7[iB7] = iArr7[iB7] + 1;
                int[] iArr8 = this.b;
                int iB8 = com.baidu.mobads.container.w.e.a.DROPPED_NORMAL.b();
                iArr8[iB8] = iArr8[iB8] + i;
                return;
            }
            int[] iArr9 = this.a;
            int iB9 = com.baidu.mobads.container.w.e.a.DROPPED_BEST.b();
            iArr9[iB9] = iArr9[iB9] + 1;
            int[] iArr10 = this.b;
            int iB10 = com.baidu.mobads.container.w.e.a.DROPPED_BEST.b();
            iArr10[iB10] = iArr10[iB10] + Math.max(i, 0);
        }
    }
}
