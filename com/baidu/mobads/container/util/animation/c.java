package com.baidu.mobads.container.util.animation;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;
import com.baidu.mobads.container.util.bq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c implements com.baidu.mobads.container.util.animation.a.c {
    private float a;
    private View b;
    private a c;
    private final Map<String, Object> d = new HashMap();

    public c(View view, a aVar) {
        this.b = view;
        this.c = aVar;
        if (this.b instanceof com.baidu.mobads.container.util.animation.a.d) {
            ((com.baidu.mobads.container.util.animation.a.d) this.b).a(this);
        }
    }

    public ValueAnimator a(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.addUpdateListener(new d(this));
        return valueAnimatorOfFloat;
    }

    public void a(float f) {
        this.a = f;
        b();
        if (this.b != null) {
            this.b.invalidate();
        }
    }

    public Object a(String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.container.util.animation.a.c
    public void a(Canvas canvas, String str, Object obj) {
        this.d.put(str, obj);
        a(canvas, this.d);
        this.d.clear();
    }

    @Override // com.baidu.mobads.container.util.animation.a.c
    public void a(Canvas canvas, Map<String, Object> map) {
        if (this.c != null) {
            try {
                this.c.a(this.a, canvas, this);
            } catch (Throwable th) {
                bq.a().b(th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.container.util.animation.a.c
    public void b(Canvas canvas, String str, Object obj) {
        this.d.put(str, obj);
        b(canvas, this.d);
        this.d.clear();
    }

    @Override // com.baidu.mobads.container.util.animation.a.c
    public void b(Canvas canvas, Map<String, Object> map) {
        if (this.c != null) {
            try {
                this.c.b(this.a, canvas, this);
            } catch (Throwable th) {
                bq.a().b(th.getMessage());
            }
        }
    }

    private void b() {
        if (this.b != null && this.c != null) {
            try {
                this.c.a(this.a, this.b);
            } catch (Throwable th) {
                bq.a().b(th.getMessage());
            }
        }
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public static abstract class a implements com.baidu.mobads.container.util.animation.a.a {
        @Override // com.baidu.mobads.container.util.animation.a.a
        public void a(float f, View view) {
        }

        @Override // com.baidu.mobads.container.util.animation.a.a
        public void a(float f, Canvas canvas, c cVar) {
        }

        @Override // com.baidu.mobads.container.util.animation.a.a
        public void b(float f, Canvas canvas, c cVar) {
        }
    }
}
