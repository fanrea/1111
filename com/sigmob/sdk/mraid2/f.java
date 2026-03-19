package com.sigmob.sdk.mraid2;

import android.view.View;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f extends com.sigmob.sdk.mraid.j {
    private static final String c = "motion_shake_start";
    private static final String d = "motion_shake_end";
    private static final String e = "motion_twist_start";
    private static final String f = "motion_twist_end";
    private i g;
    private ak.a h;

    public f(String uniqueId, String type) {
        super(uniqueId);
        type.hashCode();
        switch (type) {
            case "shake":
                f();
                break;
            case "slope":
                g();
                break;
            case "swing":
                h();
                break;
            case "twist":
                e();
                break;
        }
    }

    private void e() {
        this.h = new ak.a(com.sigmob.sdk.b.e(), new ak.b() { // from class: com.sigmob.sdk.mraid2.f.1
            @Override // com.sigmob.sdk.base.common.ak.b
            public void a() {
                HashMap<String, Object> map = new HashMap<>();
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "twist", "began", map);
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(float progress) {
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(Map<String, Number> info) {
                if (info == null) {
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                Number number = info.get("turn_x");
                Number number2 = info.get("turn_y");
                Number number3 = info.get("turn_z");
                Number number4 = info.get("turn_time");
                map.put("x", number);
                map.put("y", number2);
                map.put("z", number3);
                map.put("time", number4);
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "twist", PointCategory.END, map);
            }
        }, ak.c.WRING);
    }

    private void f() {
        ak.a aVar = new ak.a(com.sigmob.sdk.b.e(), new ak.b() { // from class: com.sigmob.sdk.mraid2.f.2
            @Override // com.sigmob.sdk.base.common.ak.b
            public void a() {
                HashMap<String, Object> map = new HashMap<>();
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "shake", "began", map);
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(float progress) {
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(Map<String, Number> info) {
                if (info == null) {
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                Number number = info.get("x_max_acc");
                Number number2 = info.get("y_max_acc");
                Number number3 = info.get("z_max_acc");
                map.put("x", String.valueOf(number));
                map.put("y", String.valueOf(number2));
                map.put("z", String.valueOf(number3));
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "shake", PointCategory.END, map);
            }
        }, ak.c.SHAKE);
        this.h = aVar;
        aVar.a(1);
    }

    private void g() {
        ak.a aVar = new ak.a(com.sigmob.sdk.b.e(), new ak.b() { // from class: com.sigmob.sdk.mraid2.f.3
            @Override // com.sigmob.sdk.base.common.ak.b
            public void a() {
                HashMap<String, Object> map = new HashMap<>();
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "slope", "began", map);
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(float progress) {
                if (f.this.g == null) {
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("progress", Integer.valueOf((int) (progress * 100.0f)));
                f.this.g.a(f.this.a, "slope", "progress", map);
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(Map<String, Number> info) {
                if (info == null) {
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                Number number = info.get("turn_x");
                Number number2 = info.get("turn_y");
                Number number3 = info.get("turn_z");
                Number number4 = info.get("turn_time");
                map.put("x", String.valueOf(number));
                map.put("y", String.valueOf(number2));
                map.put("z", String.valueOf(number3));
                map.put("time", number4);
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "slope", PointCategory.END, map);
            }
        }, ak.c.SLOPE);
        this.h = aVar;
        aVar.a(1);
    }

    private void h() {
        ak.a aVar = new ak.a(com.sigmob.sdk.b.e(), new ak.b() { // from class: com.sigmob.sdk.mraid2.f.4
            @Override // com.sigmob.sdk.base.common.ak.b
            public void a() {
                HashMap<String, Object> map = new HashMap<>();
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "swing", "began", map);
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(float progress) {
                if (f.this.g == null) {
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("progress", Integer.valueOf((int) (progress * 100.0f)));
                f.this.g.a(f.this.a, "swing", "progress", map);
            }

            @Override // com.sigmob.sdk.base.common.ak.b
            public void a(Map<String, Number> info) {
                if (info == null) {
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                Number number = info.get("x_max_acc");
                Number number2 = info.get("y_max_acc");
                Number number3 = info.get("z_max_acc");
                map.put("x", String.valueOf(number));
                map.put("y", String.valueOf(number2));
                map.put("z", String.valueOf(number3));
                if (f.this.g == null) {
                    return;
                }
                f.this.g.a(f.this.a, "swing", PointCategory.END, map);
            }
        }, ak.c.SWING);
        this.h = aVar;
        aVar.a(1);
    }

    public void a() {
        ak.a aVar = this.h;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public void a(int level) {
        ak.a aVar = this.h;
        if (aVar == null) {
            return;
        }
        aVar.c(level);
    }

    public void a(i mraidBridgeMotionListener) {
        this.g = mraidBridgeMotionListener;
    }

    @Override // com.sigmob.sdk.mraid.j
    public View b() {
        return null;
    }

    public void b(int sensitivity_raw) {
        ak.a aVar = this.h;
        if (aVar == null) {
            return;
        }
        aVar.b(sensitivity_raw);
    }

    @Override // com.sigmob.sdk.mraid.j
    public void c() {
        this.g = null;
        ak.a aVar = this.h;
        if (aVar == null) {
            return;
        }
        aVar.c();
    }
}
