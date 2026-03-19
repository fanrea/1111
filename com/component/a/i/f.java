package com.component.a.i;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.b.a;
import com.baidu.mobads.container.util.d.d;
import com.component.a.f.e;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends com.component.a.b.e implements Animator.AnimatorListener, d.InterfaceC0136d<Bitmap> {
    int a;
    private final com.component.a.f.e b;
    private final List<a> c;
    private final a.C0134a d;
    private Animator e;
    private Object f;
    private boolean g;
    private final boolean h;
    private long i;
    private AtomicBoolean j;
    private Handler k;
    private long l;
    private int m;
    private boolean n;

    static /* synthetic */ long a(f fVar, long j) {
        long j2 = fVar.l + j;
        fVar.l = j2;
        return j2;
    }

    @Override // com.baidu.mobads.container.util.b.a.c
    public /* synthetic */ Object b(Object obj) {
        return c((f) obj);
    }

    public f(com.component.a.f.e eVar) {
        super(eVar != null ? eVar.l("") : "");
        this.d = new a.C0134a();
        boolean z = false;
        this.a = 0;
        this.g = false;
        this.j = new AtomicBoolean(false);
        this.l = 0L;
        this.m = 0;
        this.n = false;
        this.b = eVar;
        this.c = new CopyOnWriteArrayList();
        if (this.b != null && this.b.j().c(0) < 0) {
            z = true;
        }
        this.h = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f a(View view) {
        if (view instanceof com.component.a.c.c) {
            return ((com.component.a.c.c) view).getLifeCycle();
        }
        return null;
    }

    public static JSONObject b(View view) {
        com.component.a.f.e eVarB;
        f fVarA = a(view);
        if (fVarA != null && (eVarB = fVarA.b()) != null) {
            return eVarB.c();
        }
        return null;
    }

    public static com.component.a.f.e c(View view) {
        f fVarA = a(view);
        if (fVarA != null) {
            return fVarA.b();
        }
        return new com.component.a.f.e("");
    }

    public static int a(View view, String str, int i) {
        JSONObject jSONObjectB = b(view);
        if (jSONObjectB != null) {
            return jSONObjectB.optInt(str, i);
        }
        return i;
    }

    public static double a(View view, String str, double d) {
        JSONObject jSONObjectB = b(view);
        if (jSONObjectB != null) {
            return jSONObjectB.optDouble(str, d);
        }
        return d;
    }

    public static String a(View view, String str, String str2) {
        JSONObject jSONObjectB = b(view);
        if (jSONObjectB != null) {
            return jSONObjectB.optString(str, str2);
        }
        return str2;
    }

    public com.component.a.f.e b() {
        return this.b;
    }

    public long c() {
        return this.i;
    }

    public static void a(View view, Object obj) {
        f fVarA = a(view);
        if (fVarA != null) {
            fVarA.a(obj);
        }
    }

    public static Object d(View view) {
        f fVarA = a(view);
        if (fVarA != null) {
            return fVarA.d();
        }
        return null;
    }

    public Object d() {
        return this.f;
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public void a(Animator animator) {
        if (this.e != null) {
            this.e.cancel();
            this.e.removeListener(this);
        }
        this.e = animator;
        if (this.e != null) {
            this.e.addListener(this);
        }
    }

    @Override // com.component.a.b.n
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals("timer", str) && this.l >= 0;
    }

    @Override // com.component.a.b.n
    public Object b(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals("timer", str)) {
            return Long.valueOf(this.l);
        }
        return null;
    }

    public void a(a aVar) {
        this.c.add(aVar);
    }

    public void b(a aVar) {
        this.c.remove(aVar);
    }

    public static View a(View view, long j) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewB = b(viewGroup.getChildAt(i), j);
                if (viewB != null) {
                    return viewB;
                }
            }
        }
        return view;
    }

    private static View b(View view, long j) {
        f fVarA = a(view);
        if (fVarA != null && fVarA.c() == j) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View viewB = b(viewGroup.getChildAt(i), j);
                    if (viewB != null) {
                        return viewB;
                    }
                }
            }
            return view;
        }
        return null;
    }

    public void a(ViewGroup.LayoutParams layoutParams) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(layoutParams);
        }
    }

    private void g(View view) {
        if (view != null) {
            view.post(new g(this, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.j.compareAndSet(!z, z)) {
            synchronized (this) {
                if (this.j.get()) {
                    a(com.component.a.g.b.c.b);
                    if (c(com.component.a.g.b.c.g.a())) {
                        this.l = 0L;
                        a(com.component.a.g.b.c.g, new com.component.a.b.o().b("timer", Long.valueOf(this.l)));
                        this.k = new Handler(Looper.getMainLooper());
                        this.k.postDelayed(new h(this), 100L);
                    }
                } else {
                    if (this.k != null) {
                        this.k.removeCallbacksAndMessages(null);
                    }
                    a(com.component.a.g.b.c.c);
                }
            }
        }
    }

    public void a(View view, boolean z) {
        g(view);
    }

    public void a(View view, int i) {
        g(view);
    }

    public void e(View view) {
        if (view != null) {
            g(view);
        }
        if (this.g && !this.n && this.m != 0) {
            this.g = false;
            e();
        }
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(view);
        }
    }

    public void f(View view) {
        if (view != null && view.isShown()) {
            a(false);
        }
        this.g = true;
        f();
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b(view);
        }
        if (this.k != null) {
            this.k.removeCallbacksAndMessages(null);
            this.k = null;
        }
    }

    public void b(View view, int i) {
        if (view != null && view.isAttachedToWindow()) {
            g(view);
        }
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(view, i);
        }
    }

    public void a(MotionEvent motionEvent, boolean z) {
        if (!z && motionEvent != null && motionEvent.getAction() == 0) {
            this.i = motionEvent.getDownTime();
        }
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(motionEvent, z);
        }
    }

    public void b(MotionEvent motionEvent, boolean z) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b(motionEvent, z);
        }
    }

    @Override // com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, int i) {
        com.baidu.mobads.container.util.h.a(new i(this, str2, view, i));
    }

    @Override // com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
        com.baidu.mobads.container.util.h.a(new j(this, str2, view, cVar));
    }

    @Override // com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, Bitmap bitmap) {
        com.baidu.mobads.container.util.h.a(new k(this, str2, view, bitmap));
    }

    @Override // com.baidu.mobads.container.util.b.a.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap b(File file) {
        return this.d.b(file);
    }

    public <D> Bitmap c(D d) {
        return this.d.a((a.C0134a) d);
    }

    public void e() {
        if (this.e != null) {
            com.baidu.mobads.container.util.h.a(new l(this));
        }
    }

    public void f() {
        if (this.e != null) {
            com.baidu.mobads.container.util.h.a(new m(this));
        }
    }

    public void g() {
        this.g = false;
        f();
        this.c.clear();
    }

    public int h() {
        return this.m;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.m = 1;
        if (this.b != null && this.b.e() == e.d.LOTTIE) {
            a(com.component.a.g.b.c.e);
        }
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.m != 2) {
            this.m = 3;
            if (!this.h) {
                this.n = true;
            }
        }
        if (this.b != null && this.b.e() == e.d.LOTTIE) {
            a(com.component.a.g.b.c.f);
        }
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(animator, this.m == 2);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.m = 2;
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b(animator);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.m = 1;
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().c(animator);
        }
    }

    public static abstract class a {
        public void a(ViewGroup.LayoutParams layoutParams) {
        }

        public void a(View view) {
        }

        public void b(View view) {
        }

        public void a(View view, int i) {
        }

        public void a(MotionEvent motionEvent, boolean z) {
        }

        public void b(MotionEvent motionEvent, boolean z) {
        }

        public void a(String str, View view, int i) {
        }

        public void a(String str, View view, com.baidu.mobads.container.util.d.c cVar) {
        }

        public void a(String str, View view, Bitmap bitmap) {
        }

        public void a(Animator animator) {
        }

        public void a(Animator animator, boolean z) {
        }

        public void b(Animator animator) {
        }

        public void c(Animator animator) {
        }
    }
}
