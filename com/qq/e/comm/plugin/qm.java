package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.callback.biz.LoadStatusCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qm implements ACTD, os {
    private static final String x = "qm";
    private final Activity a;
    private String b;
    private String c;
    private o d;
    private RecyclerView e;
    private k f;
    private rm h;
    private int i;
    private NativeExpressADView j;
    private long t;
    private List<j> g = new ArrayList();
    private boolean m = false;
    private final AtomicBoolean n = new AtomicBoolean(false);
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private final ns r = new ns();
    private long s = 0;
    private int u = 0;
    private int v = 0;
    private final Runnable w = new g();

    /* compiled from: A */
    private interface m {
        void a();
    }

    /* compiled from: A */
    private interface n {
        void a();

        void a(int i, boolean z);

        void a(boolean z, int i);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    static /* synthetic */ int o(qm qmVar) {
        int i2 = qmVar.u;
        qmVar.u = i2 + 1;
        return i2;
    }

    private void e() {
        this.e = new RecyclerView(this.a);
        o oVar = new o(this.a, 1);
        this.d = oVar;
        oVar.a(new b());
        this.e.setLayoutManager(this.d);
        List<j> list = this.g;
        if (list != null) {
            list.add(new j());
        }
        a(this.h.b());
        List<j> list2 = this.g;
        if (list2 != null && list2.size() <= 1) {
            f();
        }
        k kVar = new k(this.g);
        this.f = kVar;
        kVar.a(this.c);
        ((LoadStatusCallback) x5.b(this.c, LoadStatusCallback.class)).v().a(new c(this));
        this.f.a(new d());
        this.e.setAdapter(this.f);
        this.e.setBackgroundColor(-16777216);
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        this.a.setContentView(frameLayout);
    }

    public qm(Activity activity) {
        this.a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.c = String.valueOf(ks.a());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.a.getIntent().getStringExtra("objectId");
        this.b = stringExtra;
        rm rmVarA = ((sm) zm.a(stringExtra, sm.class)).a();
        this.h = rmVarA;
        if (rmVarA == null) {
            if (this.m) {
                return;
            }
            this.m = true;
            this.a.finish();
            return;
        }
        this.t = rmVarA.c() * 1000;
        this.h.a(new a());
        e();
    }

    /* compiled from: A */
    class a implements ADListener {
        a() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            NativeExpressADView nativeExpressADView;
            int type = aDEvent.getType();
            if (type == 100) {
                List list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    qm.this.a((List<NativeExpressADView>) list);
                }
                qm.this.n.compareAndSet(true, false);
                return;
            }
            if (type == 101) {
                String unused = qm.x;
                qm.this.n.compareAndSet(true, false);
                qm.this.j();
                return;
            }
            if (type == 103) {
                if (qm.this.j == null && qm.this.e != null) {
                    qm.this.e.post(new RunnableC0720a());
                }
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    String unused2 = qm.x;
                    nativeExpressADView2.hashCode();
                    qm.this.j = nativeExpressADView2;
                    qm.o(qm.this);
                    qm.this.c(nativeExpressADView2);
                    return;
                }
                return;
            }
            if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    String unused3 = qm.x;
                    nativeExpressADView3.hashCode();
                    qm.this.b(nativeExpressADView3);
                    return;
                }
                return;
            }
            if (type != 109) {
                if (type == 110 && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
                    String unused4 = qm.x;
                    nativeExpressADView.hashCode();
                    return;
                }
                return;
            }
            NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
            if (nativeExpressADView4 != null) {
                String unused5 = qm.x;
                nativeExpressADView4.hashCode();
                View childAt = nativeExpressADView4.getChildAt(0);
                if (childAt != null) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    layoutParams.height = -1;
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.qm$a$a, reason: collision with other inner class name */
        class RunnableC0720a implements Runnable {
            RunnableC0720a() {
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                qm.this.c();
            }
        }
    }

    /* compiled from: A */
    class b implements n {
        private boolean a = false;

        b() {
        }

        @Override // com.qq.e.comm.plugin.qm.n
        public void a(boolean z, int i) {
            String unused = qm.x;
            int unused2 = qm.this.i;
            this.a = z;
            qm.this.b();
        }

        @Override // com.qq.e.comm.plugin.qm.n
        public void a(int i, boolean z) throws JSONException {
            boolean z2 = !this.a && z && qm.this.i == i;
            this.a = false;
            qm.this.i = i;
            String unused = qm.x;
            qm.this.o = false;
            if (qm.this.p) {
                qm.this.d();
            }
            if (!z2) {
                qm.this.h();
            }
            qm.this.g();
        }

        @Override // com.qq.e.comm.plugin.qm.n
        public void a() {
            String unused = qm.x;
        }
    }

    /* compiled from: A */
    class c extends ms<Void> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            qm.this.f();
        }
    }

    /* compiled from: A */
    class d implements m {
        d() {
        }

        @Override // com.qq.e.comm.plugin.qm.m
        public void a() {
            qm.this.onBackPressed();
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ j a;

        e(j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iIndexOf;
            if (this.a == null || qm.this.g == null || qm.this.f == null || (iIndexOf = qm.this.g.indexOf(this.a)) < 0 || !qm.this.g.remove(this.a)) {
                return;
            }
            qm.this.f.notifyItemRemoved(iIndexOf);
            String unused = qm.x;
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qm.this.h();
        }
    }

    /* compiled from: A */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qm.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.n.compareAndSet(false, true)) {
            this.h.g();
        }
        l();
    }

    private void l() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        ((LoadStatusCallback) x5.b(this.c, LoadStatusCallback.class)).e().b("{\"loadingVis\":\"0\", \"failVis\":\"2\"}");
        rm rmVar = this.h;
        if (rmVar == null || this.e == null) {
            return;
        }
        int iF = rmVar.f();
        this.e.removeCallbacks(this.w);
        this.e.postDelayed(this.w, iF * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        ((LoadStatusCallback) x5.b(this.c, LoadStatusCallback.class)).e().b("{\"loadingVis\":\"2\", \"failVis\":\"0\"}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        rm rmVar = this.h;
        if (rmVar == null || this.g == null) {
            return;
        }
        if ((this.g.size() - this.i) - 2 <= rmVar.e()) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int iD;
        int i2;
        List<j> list;
        NativeExpressADView nativeExpressADView;
        rm rmVar = this.h;
        if (rmVar == null || this.g == null || (iD = rmVar.d()) <= 0 || (i2 = this.i - iD) <= 0 || (list = this.g) == null || list.size() <= i2 || this.f == null) {
            return;
        }
        List<j> listSubList = this.g.subList(0, i2);
        int size = listSubList.size();
        for (int i3 = 0; i3 < listSubList.size(); i3++) {
            j jVar = listSubList.get(i3);
            if (jVar != null && (nativeExpressADView = jVar.b) != null) {
                nativeExpressADView.destroy();
            }
        }
        listSubList.clear();
        this.f.notifyItemRangeRemoved(0, size);
    }

    /* compiled from: A */
    class h implements Comparator<NativeExpressADView> {
        h() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(NativeExpressADView nativeExpressADView, NativeExpressADView nativeExpressADView2) {
            return qm$h$$ExternalSyntheticBackport0.m(nativeExpressADView2.getECPM(), nativeExpressADView.getECPM());
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        this.q = true;
        m();
        List<j> list = this.g;
        if (list != null) {
            Iterator<j> it = list.iterator();
            while (it.hasNext()) {
                NativeExpressADView nativeExpressADView = it.next().b;
                if (nativeExpressADView != null) {
                    nativeExpressADView.destroy();
                }
            }
            this.g = null;
        }
        k kVar = this.f;
        if (kVar != null) {
            kVar.a();
        }
        rm rmVar = this.h;
        if (rmVar != null) {
            rmVar.a((ADListener) null);
            this.h.a(false);
        }
        if (!TextUtils.isEmpty(this.c)) {
            x5.c(this.c, LoadStatusCallback.class);
        }
        zm.b(this.b, sm.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws JSONException {
        List<j> list;
        if (!this.p || (list = this.g) == null || list.isEmpty()) {
            return;
        }
        j jVar = this.g.get(0);
        jn jnVar = new jn();
        jnVar.a("bindData", "{'dlInfo':{'slidingGuideVis':'2'}}");
        a(jnVar.a(), jVar == null ? null : jVar.b);
        this.p = false;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        Activity activity = this.a;
        if (activity == null || this.m) {
            return;
        }
        this.m = true;
        activity.finish();
    }

    /* compiled from: A */
    private static class o extends LinearLayoutManager {
        private final PagerSnapHelper a;
        private n b;
        private int c;
        private final RecyclerView.OnChildAttachStateChangeListener d;

        /* compiled from: A */
        class a implements RecyclerView.OnChildAttachStateChangeListener {
            a() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                if (o.this.b == null || o.this.getChildCount() != 1) {
                    return;
                }
                o.this.b.a();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                if (o.this.c >= 0) {
                    if (o.this.b != null) {
                        o.this.b.a(true, o.this.getPosition(view));
                    }
                } else if (o.this.b != null) {
                    o.this.b.a(false, o.this.getPosition(view));
                }
            }
        }

        public o(Context context, int i) {
            super(context, i, false);
            this.d = new a();
            this.a = new PagerSnapHelper();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onAttachedToWindow(RecyclerView recyclerView) {
            super.onAttachedToWindow(recyclerView);
            this.a.attachToRecyclerView(recyclerView);
            recyclerView.addOnChildAttachStateChangeListener(this.d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onScrollStateChanged(int i) {
            if (i == 0) {
                int position = getPosition(this.a.findSnapView(this));
                if (this.b != null) {
                    if (getChildCount() == 1) {
                        this.b.a(position, position == getItemCount() - 1);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            this.c = i;
            return super.scrollVerticallyBy(i, recycler, state);
        }

        public void a(n nVar) {
            this.b = nVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() throws JSONException {
        List<j> list;
        if (!this.o || (list = this.g) == null || list.isEmpty()) {
            return;
        }
        j jVar = this.g.get(0);
        jn jnVar = new jn();
        jnVar.a("startAnimationGroup", "slidingGuide");
        a(jnVar.a(), jVar == null ? null : jVar.b);
        this.o = false;
        this.p = true;
    }

    private void m() {
        b10.a(1430001, null, Integer.valueOf(this.u));
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.r;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.q;
    }

    /* compiled from: A */
    private static class i extends RecyclerView.ViewHolder {
        public FrameLayout a;
        public View b;

        public i(View view, View view2) {
            super(view);
            this.a = (FrameLayout) view;
            this.b = view2;
        }
    }

    /* compiled from: A */
    private static class l extends RecyclerView.ViewHolder {
        public View a;
        public f9 b;

        public l(View view, f9 f9Var) {
            super(view);
            this.a = view;
            this.b = f9Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NativeExpressADView nativeExpressADView) {
        if (nativeExpressADView == null || nativeExpressADView.getTag(2131755015) == null) {
            return;
        }
        Integer num = (Integer) nativeExpressADView.getTag(2131755015);
        num.intValue();
        b10.a(1430003, null, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        NativeExpressADView nativeExpressADView;
        Pair<Integer, j> pairA;
        List<j> list;
        NativeExpressADView nativeExpressADView2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.s > this.t && (nativeExpressADView = this.j) != null && (pairA = a(nativeExpressADView)) != null && (list = this.g) != null && list.size() - 1 > ((Integer) pairA.first).intValue()) {
            ArrayList arrayList = null;
            for (int iIntValue = ((Integer) pairA.first).intValue() + 1; iIntValue < this.g.size() - 1; iIntValue++) {
                j jVar = this.g.get(iIntValue);
                if (jVar != null && (nativeExpressADView2 = jVar.b) != null && !nativeExpressADView2.isValid()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(jVar);
                }
            }
            if (arrayList != null && this.f != null && this.e != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    this.e.post(new e((j) arrayList.get(i2)));
                }
                this.e.post(new f());
            }
        }
        this.s = jElapsedRealtime;
    }

    /* compiled from: A */
    private static class j {
        public int a = 2;
        public NativeExpressADView b;

        public j() {
        }

        public j(NativeExpressADView nativeExpressADView) {
            this.b = nativeExpressADView;
        }
    }

    /* compiled from: A */
    private static class k extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements os {
        private final List<j> a;
        private String b;
        private final ns c = new ns();
        private boolean d = false;
        private m e;

        public k(List<j> list) {
            this.a = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.a.get(i).a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View viewL;
            if (i != 1) {
                FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(-1);
                f9 f9VarA = q8.a().a(viewGroup.getContext());
                if (f9VarA != null) {
                    if (!TextUtils.isEmpty(this.b)) {
                        ((LoadStatusCallback) x5.b(this.b, LoadStatusCallback.class)).e().a(new a(this, f9VarA));
                    }
                    f9VarA.a(new b(f9VarA));
                    ((LoadStatusCallback) x5.b(this.b, LoadStatusCallback.class)).e().b("{\"loadingVis\":\"0\", \"failVis\":\"2\"}");
                    viewL = f9VarA.l();
                } else {
                    viewL = null;
                }
                if (viewL != null) {
                    frameLayout.addView(viewL, new FrameLayout.LayoutParams(-1, -1));
                }
                frameLayout.addView(a(viewGroup.getContext()));
                return new l(frameLayout, f9VarA);
            }
            FrameLayout frameLayout2 = new FrameLayout(viewGroup.getContext());
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new i(frameLayout2, a(viewGroup.getContext()));
        }

        /* compiled from: A */
        class a extends ms<String> {
            final /* synthetic */ f9 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(os osVar, f9 f9Var) {
                super(osVar);
                this.b = f9Var;
            }

            @Override // com.qq.e.comm.plugin.ms
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(String str) {
                if (this.b == null || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    this.b.a(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        }

        /* compiled from: A */
        class b extends gf {
            b(f9 f9Var) {
                super(f9Var);
            }

            @Override // com.qq.e.comm.plugin.gf
            public void k(h8 h8Var) {
                String unused = qm.x;
                if (TextUtils.isEmpty(k.this.b)) {
                    return;
                }
                ((LoadStatusCallback) x5.b(k.this.b, LoadStatusCallback.class)).v().a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof i) {
                a(i, (i) viewHolder);
            }
        }

        /* compiled from: A */
        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.e != null) {
                    k.this.e.a();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // com.qq.e.comm.plugin.os
        public ns i() {
            return this.c;
        }

        @Override // com.qq.e.comm.plugin.os
        public boolean k() {
            return this.d;
        }

        private View a(Context context) {
            if (context == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(yu.a(context, 18), yu.a(context, 36), 0, 0);
            linearLayout.setGravity(16);
            linearLayout.setOrientation(0);
            linearLayout.setLayoutParams(layoutParams);
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(yu.a(context, 16), yu.a(context, 16)));
            byte[] bArrDecode = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAACXBIWXMAABYlAAAWJQFJUiTwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAKSSURBVHgB7VbNihpBEO7xZ3ddd3Y24wgRTDBgEuIlBxPIxSD5ewMvuXoSwWcQ9BCSCOIlIPgKiiCIt5A3kCR6lZiL6MFEBBWdSdVYHQaz7ka355CwBU0P047fV1VfVTVj1/YfmGTZJbajOdieZhiG+X02m0VQJ+0SvN+LyK6GAEjeFYlEDmA/xIXP8Xjcxa7g2KWGHiYSCSc8umF5YMnFYvF2oVC4Bc9eJELnthj33E1gaqvVeqbr+hiIGf1+/zWRcjHRaaDcomcHfr//BHZfo9F4sVqtfhhkk8nkAxETS4DA0XPMN4Jr9Xr9pRV8uVx+q1arD+HsmHQgzCRQOAdH73yb4IvFol+pVB7BmRIOh1GQGKmrR4B7Tko/2QZeLpcfw9kZLE80GkV9CKsCDm56XqvVXp0HrijKjWAw6BFdgmadwzqGpV7guUq/4eBCxMdrHb1Xms3m803wUqn0xALuZoLLziy5UCh0BAIMWcHn8/n3fD7/1Ov13lRV9ZStu+DeYb/ww16vZ3rlcDhO+Tsot0m73f45nU65SA0LaWFmlh6VlDIcDt8ZFpvNZl+TyeQDRikg8Uk0oISZKcJAIIA59g0Gg/dWEpCKL6lU6v4ZGJybFYARoagIJcFbr7aNBFv3gCNmgxh/k4AlbyORTqfvwZmCvYBROQpLB/4RliQ2JIyELMvnpiOTydwlkofUusUOI+oLKEqzJW+SgN7wOZfL3SHN2DOO+VCiSPyRjvF4/IbZMY6tJBjdCdg6EupoNHrLCQChlGUm/BWBnea2JGGVGTruoAnW6XR0TdPy3W73k9PpNGKx2EeIjA4REtsQthhGwkXNCtWPZcjvg7bfihmBmOKkkPNpaN+N+DIyludr+3fsF6/AuZffgffzAAAAAElFTkSuQmCC", 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            linearLayout.addView(imageView);
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(yu.a(context, 2), 0, 0, 0);
            textView.setLayoutParams(layoutParams2);
            textView.setTextSize(14.0f);
            textView.setTextColor(-1);
            textView.getPaint().setFakeBoldText(true);
            textView.setText("返回");
            linearLayout.addView(textView);
            linearLayout.setOnClickListener(new c());
            return linearLayout;
        }

        public void a() {
            this.d = true;
        }

        private void a(int i, i iVar) {
            NativeExpressADView nativeExpressADView = this.a.get(i).b;
            if (nativeExpressADView.getParent() != null) {
                ((FrameLayout) nativeExpressADView.getParent()).removeAllViews();
            }
            iVar.a.removeAllViews();
            iVar.a.addView(nativeExpressADView, new FrameLayout.LayoutParams(-1, -1));
            nativeExpressADView.render();
            iVar.a.addView(iVar.b);
        }

        public void a(m mVar) {
            this.e = mVar;
        }

        public void a(String str) {
            this.b = str;
        }
    }

    private Pair<Integer, j> a(NativeExpressADView nativeExpressADView) {
        List<j> list;
        NativeExpressADView nativeExpressADView2;
        if (nativeExpressADView == null || (list = this.g) == null || list.isEmpty()) {
            return null;
        }
        for (int size = this.g.size() - 1; size >= 0; size--) {
            j jVar = this.g.get(size);
            if (jVar != null && (nativeExpressADView2 = jVar.b) != null && nativeExpressADView2 == nativeExpressADView) {
                nativeExpressADView.hashCode();
                return new Pair<>(Integer.valueOf(size), jVar);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NativeExpressADView nativeExpressADView) {
        if (nativeExpressADView == null || nativeExpressADView.getTag(2131755015) == null) {
            return;
        }
        Integer num = (Integer) nativeExpressADView.getTag(2131755015);
        num.intValue();
        b10.a(1430002, null, num);
    }

    private void a(JSONObject jSONObject, NativeExpressADView nativeExpressADView) {
        jSONObject.toString();
        if (nativeExpressADView instanceof jq) {
            ((jq) nativeExpressADView).a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NativeExpressADView> list) {
        j jVarRemove;
        if (list == null || list.isEmpty() || this.g == null) {
            return;
        }
        list.size();
        this.v++;
        if (this.g.isEmpty()) {
            jVarRemove = null;
        } else {
            List<j> list2 = this.g;
            jVarRemove = list2.remove(list2.size() - 1);
        }
        ArrayList arrayList = new ArrayList(list);
        int i2 = 0;
        while (i2 < arrayList.size()) {
            NativeExpressADView nativeExpressADView = (NativeExpressADView) arrayList.get(i2);
            if (nativeExpressADView != null) {
                int i3 = this.v;
                if (i3 == 1) {
                    i2++;
                    nativeExpressADView.setTag(2131755015, Integer.valueOf(i2));
                } else {
                    nativeExpressADView.setTag(2131755015, Integer.valueOf(i3));
                }
            }
            i2++;
        }
        Pair<Integer, j> pairA = a(this.j);
        if (pairA != null) {
            int iIntValue = ((Integer) pairA.first).intValue() + 1;
            int size = this.g.size();
            for (int i4 = iIntValue; i4 < size; i4++) {
                arrayList.add(this.g.get(i4).b);
            }
            this.g.subList(iIntValue, size).clear();
        }
        Collections.sort(arrayList, new h());
        boolean z = false;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            NativeExpressADView nativeExpressADView2 = (NativeExpressADView) arrayList.get(i5);
            if (nativeExpressADView2.isValid()) {
                this.g.add(new j(nativeExpressADView2));
                z = true;
            }
        }
        if (jVarRemove != null) {
            this.g.add(jVarRemove);
        }
        if (!z || this.f == null) {
            return;
        }
        int iIntValue2 = pairA != null ? ((Integer) pairA.first).intValue() + 1 : 0;
        arrayList.size();
        this.f.notifyItemChanged(iIntValue2, Integer.valueOf(arrayList.size()));
    }
}
