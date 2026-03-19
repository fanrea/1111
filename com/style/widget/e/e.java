package com.style.widget.e;

import android.view.View;
import com.baidu.mobads.container.util.ci;
import com.component.a.g.c.m;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e implements ci.a, Runnable {
    private m.a a;
    private View b;
    private int c = 0;
    private int d = 200;
    private boolean e = false;

    @Override // com.baidu.mobads.container.util.ci.b
    public void a(View view, boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    @Override // com.baidu.mobads.container.util.ci.a
    public void a(View view) {
        a();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null && this.e && this.a.i()) {
            this.c += this.d;
            this.a.b(this.c);
            if (!this.a.j()) {
                this.a.postDelayed(this, this.d);
            }
        }
    }

    private void b() {
        if (this.a != null && this.a.i()) {
            this.e = true;
            this.a.b(this.c);
            this.a.postDelayed(this, this.d);
        }
    }

    private void c() {
        this.e = false;
        if (this.a != null && this.a.i()) {
            this.a.removeCallbacks(this);
        }
    }

    public void b(View view) {
        try {
            this.b = view;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("window_focus", true);
            jSONObject.put("visible_percent", 100);
            ci.a().a(this.b, this, jSONObject);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
        }
    }

    public void a(m.a aVar) {
        this.a = aVar;
    }

    public void a() {
        if (this.a != null) {
            ci.a().b(this.b);
            this.a.removeCallbacks(this);
            this.a.c();
            this.e = false;
        }
    }
}
