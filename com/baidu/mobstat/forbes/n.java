package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.baidu.mobstat.forbes.MtjConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class n {
    private static final n u = new n();
    private Context a;
    private WeakReference<Activity> b;
    private Handler c;
    private long g;
    private long h;
    private long i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private String o;
    private boolean p;
    private boolean q;
    private a v;
    private ViewTreeObserver.OnScrollChangedListener w;
    private boolean d = true;
    private List<WeakReference<View>> e = Collections.synchronizedList(new ArrayList());
    private volatile MtjConfig.FeedTrackStrategy f = MtjConfig.FeedTrackStrategy.TRACK_ALL;
    private List<WeakReference<View>> r = new ArrayList();
    private HashMap<WeakReference<View>, ArrayList<j>> s = new HashMap<>();
    private HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> t = new HashMap<>();
    private Runnable x = null;
    private float y = 0.0f;
    private float z = 0.0f;
    private Object A = new Object();

    public interface a {
        void a(i iVar);

        void a(ArrayList<j> arrayList);

        void b(ArrayList<k> arrayList);
    }

    public static n a() {
        return u;
    }

    private n() {
        HandlerThread handlerThread = new HandlerThread("feedViewCrawlerThread");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    public void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        this.f = feedTrackStrategy;
    }

    public boolean b() {
        if (this.f != MtjConfig.FeedTrackStrategy.TRACK_NONE) {
            return false;
        }
        return true;
    }

    private boolean a(View view) {
        if (this.f == MtjConfig.FeedTrackStrategy.TRACK_ALL) {
            return false;
        }
        return (this.f == MtjConfig.FeedTrackStrategy.TRACK_SINGLE && ae.u(view)) ? false : true;
    }

    public void a(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.forbes.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.d = true;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    n.this.a(activity2, jCurrentTimeMillis);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, long j) {
        this.a = activity.getApplicationContext();
        this.b = new WeakReference<>(activity);
        this.g = j;
        String strB = ae.b(activity);
        if (ae.a(strB, this.j)) {
            this.p = false;
            if (a(strB, this.k, this.j, this.i, this.g, activity)) {
                this.p = true;
            }
        }
    }

    public void b(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.forbes.n.8
            @Override // java.lang.Runnable
            public void run() {
                n.this.d = false;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    n.this.b(activity2, jCurrentTimeMillis);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, long j) {
        this.h = j;
        String strB = ae.b(activity);
        this.j = strB;
        if (!TextUtils.isEmpty(this.k) && !this.k.equals(strB)) {
            this.i = 0L;
        }
        if (this.p) {
            a(activity, this.g, j, this.r);
            this.r.clear();
            this.q = false;
        }
        a(this.s, this.t, j);
        b(this.s);
        c(this.s);
        e(this.t);
        f(this.t);
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.forbes.n.9
                @Override // java.lang.Runnable
                public void run() {
                    n.this.a((List<WeakReference<View>>) n.this.e, n.this.d());
                }
            });
        }
    }

    public void c(Activity activity) {
        if (activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.forbes.n.10
            @Override // java.lang.Runnable
            public void run() throws ClassNotFoundException {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    n.this.c(activity2, jCurrentTimeMillis);
                }
            }
        });
    }

    public void a(final View view, Activity activity) {
        if (view == null || activity == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(activity);
        final WeakReference weakReference2 = new WeakReference(view);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.c.post(new Runnable() { // from class: com.baidu.mobstat.forbes.n.11
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null && ((View) weakReference2.get()) != null) {
                    n.this.a(view, activity2, jCurrentTimeMillis);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, Activity activity, long j) {
        View viewA = ae.a(view, activity);
        View viewN = ae.n(viewA);
        if (viewN == null) {
            if (!this.p) {
                c();
                return;
            }
            return;
        }
        if (a(viewN)) {
            if (!this.p) {
                c();
                return;
            }
            return;
        }
        this.i = j;
        this.k = ae.b(activity);
        this.l = "";
        Map<String, String> mapS = ae.s(viewA);
        if (mapS != null && mapS.size() > 0 && !TextUtils.isEmpty(mapS.get("title"))) {
            this.l = mapS.get("title");
        }
        this.m = ae.c(viewN, this.k);
        this.n = ae.r(viewN);
        this.o = a(activity, viewA, viewN);
    }

    public String a(Activity activity, View view, View view2) {
        String str;
        Map<String, String> mapS = ae.s(view);
        if (mapS != null && mapS.size() > 0 && !TextUtils.isEmpty(mapS.get("title"))) {
            str = mapS.get("title");
        } else {
            str = "";
        }
        String strT = ae.t(view);
        String strB = ae.b(activity);
        boolean zR = ae.r(view2);
        return k.a(strT, strB, ae.a(activity, view), str, ae.a(view, ae.b(view2)), ae.c(view2, ae.b(activity)), zR);
    }

    private void c() {
        this.i = 0L;
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = false;
        this.o = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewTreeObserver.OnScrollChangedListener d() {
        if (this.w == null) {
            this.w = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.mobstat.forbes.n.12
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    n.this.a(n.this.b);
                }
            };
        }
        return this.w;
    }

    public void a(final WeakReference<Activity> weakReference) {
        if (weakReference == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.forbes.n.13
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    n.this.d(activity, jCurrentTimeMillis);
                }
            }
        };
        if (this.x != null) {
            this.c.removeCallbacks(this.x);
        }
        this.x = runnable;
        this.c.postDelayed(runnable, 350L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<WeakReference<View>> list, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        WeakReference<View> weakReference;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                weakReference = list.get(i);
            } catch (Exception e) {
                weakReference = null;
            }
            if (weakReference != null) {
                a(weakReference.get(), onScrollChangedListener);
            }
        }
        list.clear();
    }

    private void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        ViewTreeObserver viewTreeObserver;
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || onScrollChangedListener == null) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<WeakReference<View>> list) {
        WeakReference<View> weakReference;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            try {
                weakReference = list.get(i);
            } catch (Exception e) {
                weakReference = null;
            }
            if (weakReference == null) {
                arrayList.add(weakReference);
            } else {
                View view = weakReference.get();
                if (view == null) {
                    arrayList.add(weakReference);
                } else {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                        arrayList.add(weakReference);
                    }
                }
            }
        }
        list.removeAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, List<WeakReference<View>> list) {
        ViewTreeObserver viewTreeObserver;
        if (view == null || a(list, view) || a(view) || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || onScrollChangedListener == null || list == null) {
            return;
        }
        try {
            viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
            list.add(new WeakReference<>(view));
        } catch (Exception e) {
        }
    }

    private boolean a(List<WeakReference<View>> list, View view) {
        WeakReference<View> weakReference;
        if (list == null || list.size() <= 0) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                weakReference = list.get(i);
            } catch (Exception e) {
                weakReference = null;
            }
            if (weakReference != null && view == weakReference.get()) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, String str2, String str3, long j, long j2, Activity activity) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str.equals(str2) || !str2.equals(str3) || (activity instanceof IIgnoreAutoTrace)) {
            return false;
        }
        long j3 = j2 - j;
        return j3 > 0 && j3 < 5000;
    }

    private boolean a(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > 0 && j3 > 50) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Activity activity, final long j) throws ClassNotFoundException {
        HashMap<View, Integer> map = new HashMap<>();
        final ArrayList<View> arrayList = new ArrayList<>();
        final ArrayList<View> arrayList2 = new ArrayList<>();
        View viewA = ae.a(activity);
        a(activity, viewA, map, arrayList, arrayList2);
        if (this.p && !this.q && a(this.g, j)) {
            ArrayList<WeakReference<View>> arrayListA = a(map);
            arrayListA.add(new WeakReference<>(viewA));
            this.r = arrayListA;
            this.q = true;
        }
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.forbes.n.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        n.this.a((View) it.next(), n.this.d(), (List<WeakReference<View>>) n.this.e);
                    }
                    n.this.c.post(new Runnable() { // from class: com.baidu.mobstat.forbes.n.2.1
                        @Override // java.lang.Runnable
                        public void run() throws JSONException {
                            n.this.a((List<WeakReference<View>>) n.this.e);
                            if (n.this.d) {
                                n.this.a((WeakReference<Activity>) n.this.b, j);
                                n.this.d = false;
                            }
                            n.this.a((HashMap<WeakReference<View>, ArrayList<j>>) n.this.s, j);
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                n.this.b((View) it2.next(), activity, j);
                            }
                        }
                    });
                }
            });
        }
    }

    private void a(Activity activity, View view, HashMap<View, Integer> map, ArrayList<View> arrayList, ArrayList<View> arrayList2) throws ClassNotFoundException {
        int width;
        if (view == null || ae.c(activity, view)) {
            return;
        }
        boolean zM = ae.m(view);
        if (zM && !a(view) && ae.d(view)) {
            arrayList.add(view);
        }
        if (zM) {
            arrayList2.add(view);
        }
        if ((zM || (view instanceof WebView) || (view instanceof ScrollView)) && (width = view.getWidth() * view.getHeight()) != 0) {
            map.put(view, Integer.valueOf(width));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                try {
                    a(activity, viewGroup.getChildAt(i), map, arrayList, arrayList2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ArrayList<WeakReference<View>> a(HashMap<View, Integer> map) {
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<View, Integer>>() { // from class: com.baidu.mobstat.forbes.n.3
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Map.Entry<View, Integer> entry, Map.Entry<View, Integer> entry2) {
                return entry2.getValue().compareTo(entry.getValue());
            }
        });
        ArrayList<WeakReference<View>> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new WeakReference<>(((Map.Entry) it.next()).getKey()));
        }
        return arrayList2;
    }

    private void a(Activity activity, long j, long j2, List<WeakReference<View>> list) {
        View view;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            list.add(new WeakReference<>(ae.a(activity)));
        }
        Iterator<WeakReference<View>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            WeakReference<View> next = it.next();
            if (next != null && (view = next.get()) != null) {
                break;
            }
        }
        if (TextUtils.isEmpty(this.l)) {
            return;
        }
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = ae.b(activity);
        String strC = ae.c(activity);
        ArrayList<Integer> arrayListA = a(activity, view);
        int iA = d.a(this.a, arrayListA.get(0).intValue());
        int iA2 = d.a(this.a, arrayListA.get(1).intValue());
        ArrayList<Integer> arrayListB = ae.b(activity, view);
        int iA3 = d.a(this.a, arrayListB.get(0).intValue());
        int iA4 = d.a(this.a, arrayListB.get(1).intValue());
        if (iA3 > iA) {
            iA = iA3;
        }
        if (iA4 > iA2) {
            iA2 = iA4;
        }
        if (iA != 0 && iA2 != 0) {
            a(this.a, new i(strB, strC, this.l, j2 - j, j, iA3, iA4, iA, iA2, str, this.n, this.o));
        }
    }

    private void a(Context context, i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.v != null) {
            this.v.a(iVar);
        }
        q.a().a(context, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, Activity activity, long j) {
        if (view == null || !ae.d(view)) {
            return;
        }
        a(this.s, view, new j(ae.c(view, ae.b(activity)), j, j, j, ae.r(view)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<WeakReference<View>, ArrayList<j>> map, long j) {
        if (map == null || map.size() == 0) {
            return;
        }
        Iterator<Map.Entry<WeakReference<View>, ArrayList<j>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<j> value = it.next().getValue();
            if (value != null && value.size() != 0) {
                Iterator<j> it2 = value.iterator();
                while (it2.hasNext()) {
                    j next = it2.next();
                    if (next.e() == next.c()) {
                        next.a(j);
                    }
                }
            }
        }
    }

    private LinkedHashMap<WeakReference<View>, ArrayList<j>> a(HashMap<WeakReference<View>, ArrayList<j>> map, View view) {
        View view2;
        for (Map.Entry<WeakReference<View>, ArrayList<j>> entry : map.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key != null && (view2 = key.get()) != null && view2 == view) {
                ArrayList<j> value = entry.getValue();
                LinkedHashMap<WeakReference<View>, ArrayList<j>> linkedHashMap = new LinkedHashMap<>(1);
                linkedHashMap.put(key, value);
                return linkedHashMap;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.HashMap<java.lang.ref.WeakReference<android.view.View>, java.util.ArrayList<com.baidu.mobstat.forbes.j>> r17, android.view.View r18, com.baidu.mobstat.forbes.j r19) {
        /*
            r16 = this;
            java.lang.String r0 = r19.a()
            long r1 = r19.c()
            long r3 = r19.e()
            boolean r5 = r19.d()
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L17
            return
        L17:
            java.util.LinkedHashMap r6 = r16.a(r17, r18)
            if (r6 == 0) goto L47
            int r8 = r6.size()
            if (r8 <= 0) goto L47
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L47
            java.lang.Object r6 = r6.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r8 = r6.getKey()
            java.lang.ref.WeakReference r8 = (java.lang.ref.WeakReference) r8
            java.lang.Object r6 = r6.getValue()
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            goto L49
        L47:
            r6 = 0
            r8 = 0
        L49:
            if (r6 == 0) goto L81
            java.util.Iterator r9 = r6.iterator()
        L4f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L81
            java.lang.Object r10 = r9.next()
            com.baidu.mobstat.forbes.j r10 = (com.baidu.mobstat.forbes.j) r10
            java.lang.String r11 = r10.a()
            long r12 = r10.c()
            long r14 = r10.e()
            boolean r7 = r10.d()
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L72
            goto L4f
        L72:
            if (r5 == r7) goto L75
            goto L4f
        L75:
            int r7 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r7 >= 0) goto L7e
            int r7 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r7 == 0) goto L7e
            goto L4f
        L7e:
            r7 = r10
            goto L82
        L81:
            r7 = 0
        L82:
            if (r7 != 0) goto L9f
            if (r6 != 0) goto L8b
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L8b:
            r0 = r19
            r6.add(r0)
            if (r8 != 0) goto L99
            java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference
            r0 = r18
            r8.<init>(r0)
        L99:
            r0 = r17
            r0.put(r8, r6)
            goto La5
        L9f:
            r7.a(r1)
            r7.b(r3)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.n.a(java.util.HashMap, android.view.View, com.baidu.mobstat.forbes.j):void");
    }

    private void b(HashMap<WeakReference<View>, ArrayList<j>> map) {
        d(map);
    }

    private void c(HashMap<WeakReference<View>, ArrayList<j>> map) {
        Iterator<Map.Entry<WeakReference<View>, ArrayList<j>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<j> value = it.next().getValue();
            if (value != null) {
                value.clear();
            }
        }
        map.clear();
    }

    private void d(HashMap<WeakReference<View>, ArrayList<j>> map) {
        ArrayList<j> arrayList = new ArrayList<>();
        Iterator<Map.Entry<WeakReference<View>, ArrayList<j>>> it = this.s.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<j> value = it.next().getValue();
            if (value != null && value.size() != 0) {
                arrayList.addAll(value);
            }
        }
        Collections.sort(arrayList, new Comparator<j>() { // from class: com.baidu.mobstat.forbes.n.4
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(j jVar, j jVar2) {
                long jB = jVar.b() - jVar2.b();
                if (jB > 0) {
                    return 1;
                }
                if (jB < 0) {
                    return -1;
                }
                return 0;
            }
        });
        if (this.v != null) {
            this.v.a(arrayList);
        }
        q.a().a(this.a, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, long j) throws JSONException {
        WeakReference<View> weakReference;
        View view;
        b(this.t, j);
        if (this.e == null || this.e.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.e.size(); i++) {
            try {
                weakReference = this.e.get(i);
            } catch (Exception e) {
                weakReference = null;
            }
            if (weakReference != null && (view = weakReference.get()) != null && ae.d(view) && !a(view) && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null && ae.d(childAt)) {
                        a(view, childAt, activity, j);
                    }
                }
            }
        }
    }

    private void b(HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> map, long j) {
        if (map == null || map.size() == 0) {
            return;
        }
        Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<k>>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, ArrayList<k>> value = it.next().getValue();
            if (value != null) {
                Iterator<Map.Entry<String, ArrayList<k>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    ArrayList<k> value2 = it2.next().getValue();
                    if (value2 != null && value2.size() != 0) {
                        Iterator<k> it3 = value2.iterator();
                        while (it3.hasNext()) {
                            k next = it3.next();
                            if (next.k() == next.j()) {
                                next.a(j);
                                next.a(String.valueOf(next.j() - next.i()));
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(View view, View view2, Activity activity, long j) throws JSONException {
        String str;
        JSONArray jSONArray;
        String str2;
        if (view == null || view2 == null || !ae.a(view2, m.a().c())) {
            return;
        }
        Map<String, String> mapS = ae.s(view2);
        String str3 = "";
        if (mapS == null || mapS.size() <= 0) {
            str = "";
        } else {
            if (TextUtils.isEmpty(mapS.get("title"))) {
                str2 = "";
            } else {
                str2 = mapS.get("title");
            }
            if (TextUtils.isEmpty(mapS.get("content"))) {
                str = str2;
            } else {
                str3 = mapS.get("content");
                str = str2;
            }
        }
        String strT = ae.t(view2);
        String strB = ae.b(activity);
        boolean zR = ae.r(view);
        String strC = ae.c(view, ae.b(activity));
        JSONArray jSONArrayA = ae.a(activity, view2);
        String strA = ae.a(view2, ae.b(view));
        String strValueOf = String.valueOf(j - j);
        JSONArray jSONArray2 = new JSONArray();
        try {
            List<String> listA = ae.a(view2, true);
            if (listA != null && listA.size() > 0) {
                try {
                    jSONArray2 = new JSONArray(listA.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            jSONArray = jSONArray2;
        } catch (Exception e2) {
            jSONArray = jSONArray2;
        }
        k kVar = new k(strT, strB, jSONArrayA, str, str3, strA, strC, zR, 1, j, j, j, strValueOf, "", jSONArray);
        q.a().b(str3);
        a(this.t, view, kVar);
    }

    private LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> b(HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> map, View view) {
        View view2;
        for (Map.Entry<WeakReference<View>, HashMap<String, ArrayList<k>>> entry : map.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key != null && (view2 = key.get()) != null && view2 == view) {
                LinkedHashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put(key, entry.getValue());
                return linkedHashMap;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.HashMap<java.lang.ref.WeakReference<android.view.View>, java.util.HashMap<java.lang.String, java.util.ArrayList<com.baidu.mobstat.forbes.k>>> r19, android.view.View r20, com.baidu.mobstat.forbes.k r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            if (r1 != 0) goto L9
            return
        L9:
            long r3 = r21.k()
            long r5 = r21.j()
            java.lang.String r7 = r21.d()
            java.lang.String r8 = r21.f()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L10c
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            if (r7 == 0) goto L27
            goto L10c
        L27:
            java.util.LinkedHashMap r7 = r18.b(r19, r20)
            r8 = 0
            if (r7 == 0) goto L5b
            int r9 = r7.size()
            if (r9 <= 0) goto L5b
        L39:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L5b
        L48:
            java.lang.Object r7 = r7.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            java.lang.Object r7 = r7.getValue()
            java.util.HashMap r7 = (java.util.HashMap) r7
            goto L5d
        L5b:
            r7 = r8
            r9 = r7
        L5d:
            if (r7 == 0) goto Lb1
            java.util.Set r10 = r7.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L67:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lb1
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r11 = r11.getValue()
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            if (r11 == 0) goto L67
            int r12 = r11.size()
            if (r12 != 0) goto L82
            goto L67
        L82:
            java.util.Iterator r11 = r11.iterator()
        L86:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto Lb0
            java.lang.Object r12 = r11.next()
            com.baidu.mobstat.forbes.k r12 = (com.baidu.mobstat.forbes.k) r12
            long r13 = r12.k()
            long r15 = r12.j()
            boolean r17 = r0.a(r12, r2)
            if (r17 != 0) goto La1
            goto L86
        La1:
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto Lae
            long r13 = r21.j()
            int r17 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r17 == 0) goto Lae
            goto L86
        Lae:
            r8 = r12
        Lb0:
            goto L67
        Lb1:
            if (r8 != 0) goto Lf5
            java.lang.String r3 = r0.a(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto Lbe
            return
        Lbe:
            if (r7 != 0) goto Ldd
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r5.add(r2)
            r4.put(r3, r5)
            if (r9 != 0) goto Ld7
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference
            r9.<init>(r1)
        Ld7:
            r1 = r19
            r1.put(r9, r4)
            goto Lf4
        Ldd:
            java.lang.Object r1 = r7.get(r3)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            if (r1 != 0) goto Lf1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r2)
            r7.put(r3, r1)
            goto Lf4
        Lf1:
            r1.add(r2)
        Lf4:
            goto L10b
        Lf5:
            r8.a(r5)
            r8.b(r3)
            long r1 = r8.j()
            long r3 = r8.i()
            long r1 = r1 - r3
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r8.a(r1)
        L10b:
            return
        L10c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.n.a(java.util.HashMap, android.view.View, com.baidu.mobstat.forbes.k):void");
    }

    private boolean a(k kVar, k kVar2) {
        return a(kVar.a(), kVar2.a()) && a(kVar.b(), kVar2.b()) && a(kVar.c(), kVar2.c()) && a(kVar.d(), kVar2.d()) && a(kVar.e(), kVar2.e()) && a(kVar.f(), kVar2.f()) && kVar.g() == kVar2.g();
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray != null && jSONArray2 != null) {
            return a(jSONArray.toString(), jSONArray2.toString());
        }
        return false;
    }

    private void e(HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> map) {
        g(map);
    }

    private void f(HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> map) {
        Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<k>>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            HashMap<String, ArrayList<k>> value = it.next().getValue();
            if (value != null) {
                Iterator<Map.Entry<String, ArrayList<k>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    it2.next().getValue().clear();
                }
                value.clear();
            }
        }
        map.clear();
    }

    private String a(k kVar) {
        return k.a(kVar.a(), kVar.b(), kVar.c(), kVar.d(), kVar.e(), kVar.f(), kVar.g());
    }

    private void g(HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> map) {
        ArrayList<k> arrayList = new ArrayList<>();
        Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<k>>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(h(it.next().getValue()));
        }
        Collections.sort(arrayList, new Comparator<k>() { // from class: com.baidu.mobstat.forbes.n.5
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(k kVar, k kVar2) {
                long jI = kVar.i() - kVar2.i();
                if (jI > 0) {
                    return 1;
                }
                if (jI < 0) {
                    return -1;
                }
                return 0;
            }
        });
        if (this.v != null) {
            this.v.b(arrayList);
        }
        q.a().b(this.a, arrayList);
    }

    private ArrayList<k> h(HashMap<String, ArrayList<k>> map) {
        ArrayList<k> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<k>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            k kVarA = a(it.next().getValue());
            if (kVarA != null) {
                arrayList.add(kVarA);
            }
        }
        return arrayList;
    }

    private k a(ArrayList<k> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<k>() { // from class: com.baidu.mobstat.forbes.n.6
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(k kVar, k kVar2) {
                long jI = kVar.i() - kVar2.i();
                if (jI > 0) {
                    return 1;
                }
                if (jI < 0) {
                    return -1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Iterator<k> it = arrayList.iterator();
        k kVar = null;
        long j = 0;
        int iH = 0;
        while (it.hasNext()) {
            k next = it.next();
            long jI = next.i();
            String strL = next.l();
            if (Long.valueOf(strL).longValue() >= m.a().d()) {
                if (j == 0) {
                    kVar = next;
                    j = jI;
                }
                long j2 = jI - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    sb2.append(strL);
                } else {
                    sb2.append("|" + strL);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append("" + j2);
                } else {
                    sb.append("|" + j2);
                }
                iH += next.h();
            }
        }
        if (kVar != null) {
            kVar.a(sb2.toString());
            kVar.b(sb.toString());
            kVar.a(iH);
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeakReference<Activity> weakReference, long j) throws JSONException {
        Activity activity;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        d(activity, j);
    }

    private void a(HashMap<WeakReference<View>, ArrayList<j>> map, HashMap<WeakReference<View>, HashMap<String, ArrayList<k>>> map2, long j) {
        HashMap<String, ArrayList<k>> value;
        ArrayList<j> value2;
        try {
            Iterator<Map.Entry<WeakReference<View>, ArrayList<j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    value2 = it.next().getValue();
                } catch (Exception e) {
                    value2 = null;
                }
                if (value2 != null && value2.size() != 0) {
                    Iterator<j> it2 = value2.iterator();
                    while (it2.hasNext()) {
                        j next = it2.next();
                        if (next.e() == next.c()) {
                            next.a(j);
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        try {
            Iterator<Map.Entry<WeakReference<View>, HashMap<String, ArrayList<k>>>> it3 = map2.entrySet().iterator();
            while (it3.hasNext()) {
                try {
                    value = it3.next().getValue();
                } catch (Exception e2) {
                    value = null;
                }
                if (value != null && value.size() != 0) {
                    Iterator<Map.Entry<String, ArrayList<k>>> it4 = value.entrySet().iterator();
                    while (it4.hasNext()) {
                        ArrayList<k> value3 = it4.next().getValue();
                        if (value3 != null && value3.size() != 0) {
                            Iterator<k> it5 = value3.iterator();
                            while (it5.hasNext()) {
                                k next2 = it5.next();
                                if (next2.k() == next2.j()) {
                                    next2.a(j);
                                    next2.a(String.valueOf(next2.j() - next2.i()));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void a(Activity activity, final WebView webView) {
        activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobstat.forbes.n.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (n.this.A) {
                    n.this.y = webView.getContentHeight();
                    n.this.z = webView.getScale();
                    n.this.A.notifyAll();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<java.lang.Integer> a(android.app.Activity r8, android.view.View r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            if (r9 == 0) goto La8
            if (r8 != 0) goto L10
            goto La8
        L10:
            int r2 = r9.getWidth()
            int r3 = r9.getHeight()
            boolean r4 = r9 instanceof android.webkit.WebView
            if (r4 == 0) goto L3d
            java.lang.Object r4 = r7.A
            monitor-enter(r4)
            android.webkit.WebView r9 = (android.webkit.WebView) r9     // Catch: java.lang.Throwable -> L3a
            r7.a(r8, r9)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r8 = r7.A     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3a
            r5 = 5000(0x1388, double:2.4703E-320)
            r8.wait(r5)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L3a
            goto L2f
        L2e:
            r8 = move-exception
        L2f:
            float r8 = r7.y     // Catch: java.lang.Throwable -> L3a
            float r9 = r7.z     // Catch: java.lang.Throwable -> L3a
            float r8 = r8 * r9
            int r8 = (int) r8     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3a
            r9 = r8
            r8 = 0
            goto L8a
        L3a:
            r8 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3a
            throw r8
        L3d:
            boolean r8 = r9 instanceof android.widget.ScrollView
            if (r8 == 0) goto L5d
            android.widget.ScrollView r9 = (android.widget.ScrollView) r9
            int r8 = r9.getChildCount()
            if (r8 <= 0) goto L5a
            android.view.View r8 = r9.getChildAt(r1)
            int r8 = r8.getWidth()
            android.view.View r9 = r9.getChildAt(r1)
            int r9 = r9.getHeight()
            goto L5c
        L5a:
            r8 = 0
            r9 = 0
        L5c:
            goto L8a
        L5d:
            boolean r8 = r9 instanceof android.widget.ListView
            if (r8 == 0) goto L6a
            android.widget.ListView r9 = (android.widget.ListView) r9
            int r8 = com.baidu.mobstat.forbes.ae.a(r9)
            r9 = r8
            r8 = 0
            goto L8a
        L6a:
            boolean r8 = r9 instanceof android.widget.GridView
            if (r8 == 0) goto L71
            android.widget.GridView r9 = (android.widget.GridView) r9
            goto L88
        L71:
            boolean r8 = com.baidu.mobstat.forbes.ae.q(r9)
            if (r8 == 0) goto L88
            android.support.v7.widget.RecyclerView r9 = (android.support.v7.widget.RecyclerView) r9     // Catch: java.lang.Exception -> L84
            int r8 = r9.computeHorizontalScrollRange()     // Catch: java.lang.Exception -> L84
            int r9 = r9.computeVerticalScrollRange()     // Catch: java.lang.Exception -> L82
            goto L8a
        L82:
            r9 = move-exception
            goto L86
        L84:
            r8 = move-exception
            r8 = 0
        L86:
            r9 = 0
            goto L8a
        L88:
            r8 = 0
            r9 = 0
        L8a:
            if (r8 != 0) goto L8d
            goto L8e
        L8d:
            r2 = r8
        L8e:
            if (r9 != 0) goto L91
            goto L92
        L91:
            r3 = r9
        L92:
            if (r2 <= 0) goto L95
            goto L96
        L95:
            r2 = 0
        L96:
            if (r3 <= 0) goto L99
            r1 = r3
        L99:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r0.add(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r0.add(r8)
            return r0
        La8:
            r0.add(r2)
            r0.add(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.n.a(android.app.Activity, android.view.View):java.util.ArrayList");
    }
}
