package com.bytedance.applog.exposure;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.applog.InitConfig;
import com.bytedance.bdtracker.a1;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.d5;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.p0;
import com.bytedance.bdtracker.r0;
import com.bytedance.bdtracker.s0;
import com.bytedance.bdtracker.t0;
import com.bytedance.bdtracker.u0;
import com.bytedance.bdtracker.v0;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\bJ\b\u0010 \u001a\u0004\u0018\u00010\u0007J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\bJ\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u000fR,\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/applog/exposure/ViewExposureManager;", "", "appLog", "Lcom/bytedance/applog/AppLogInstance;", "(Lcom/bytedance/applog/AppLogInstance;)V", "activitiesMap", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroid/view/View;", "Lcom/bytedance/applog/exposure/ViewExposureHolder;", "getActivitiesMap$agent_liteChinaRelease", "()Ljava/util/WeakHashMap;", "getAppLog", "()Lcom/bytedance/applog/AppLogInstance;", "globalConfig", "Lcom/bytedance/applog/exposure/ViewExposureConfig;", "started", "", "task", "Lcom/bytedance/applog/exposure/task/ViewExposureTask;", "getTask", "()Lcom/bytedance/applog/exposure/task/ViewExposureTask;", "task$delegate", "Lkotlin/Lazy;", "viewTreeChangeObserver", "Lcom/bytedance/applog/exposure/ViewTreeChangeObserver;", "checkViewExposureFromActivity", "", "activity", "checkViewExposureFromActivity$agent_liteChinaRelease", "disposeViewExposure", "view", "getCurrActivity", "observeViewExposure", "data", "Lcom/bytedance/applog/exposure/ViewExposureData;", "sendViewExposureEvent", "start", "updateExposureCheckStrategy", "exposureCheckType", "Lcom/bytedance/applog/exposure/ExposureCheckType;", "updateViewExposureConfig", "viewExposureConfig", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ViewExposureManager {
    public final WeakHashMap<Activity, WeakHashMap<View, s0>> a;
    public boolean b;
    public v0 c;
    public ViewExposureConfig d;
    public final Lazy e;
    public final d f;
    public static final /* synthetic */ KProperty[] g = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ViewExposureManager.class), "task", "getTask()Lcom/bytedance/applog/exposure/task/ViewExposureTask;"))};
    public static final ViewExposureConfig h = new ViewExposureConfig(Float.valueOf(1.0f), null, 2, null);

    public static final class b extends Lambda implements Function0<a1> {
        public b() {
            super(0);
        }

        public Object invoke() {
            return new a1(ViewExposureManager.this);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
    public ViewExposureManager(d dVar) throws TypeCastException {
        Intrinsics.checkParameterIsNotNull(dVar, "appLog");
        this.f = dVar;
        this.a = new WeakHashMap<>();
        Application application = dVar.n;
        if (application == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        this.c = new v0(application);
        this.d = h;
        this.e = LazyKt.lazy(new b());
        InitConfig initConfig = dVar.getInitConfig();
        if (initConfig == null || !initConfig.isExposureEnabled() || this.b) {
            return;
        }
        this.c.b(new t0(this));
        this.c.a(new u0(this));
        this.b = true;
    }

    public static final /* synthetic */ a1 access$getTask$p(ViewExposureManager viewExposureManager) {
        Lazy lazy = viewExposureManager.e;
        KProperty kProperty = g[0];
        return (a1) lazy.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r10, com.bytedance.applog.exposure.ViewExposureData r11) {
        /*
            r9 = this;
            com.bytedance.bdtracker.d r0 = r9.f
            r1 = 7
            r2 = 0
            if (r11 == 0) goto L10
            java.lang.String r3 = r11.getEventName()     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L10
            goto L12
        Ld:
            r10 = move-exception
            goto La1
        L10:
            java.lang.String r3 = "$bav2b_exposure"
        L12:
            r4 = 1
            com.bytedance.bdtracker.v3 r10 = com.bytedance.bdtracker.l0.b.a(r10, r4)     // Catch: java.lang.Throwable -> Ld
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld
            r5.<init>()     // Catch: java.lang.Throwable -> Ld
            java.lang.String r6 = "page_key"
            java.lang.String r7 = r10.v     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.lang.String r6 = "page_title"
            java.lang.String r7 = r10.w     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.lang.String r6 = "element_path"
            java.lang.String r7 = r10.x     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.lang.String r6 = "element_width"
            int r7 = r10.C     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.lang.String r6 = "element_height"
            int r7 = r10.D     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.lang.String r6 = "element_id"
            java.lang.String r7 = r10.y     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.lang.String r6 = "element_type"
            java.lang.String r7 = r10.z     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.util.ArrayList<java.lang.String> r6 = r10.B     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            if (r6 == 0) goto L5a
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            if (r6 == 0) goto L58
            goto L5a
        L58:
            r6 = r2
            goto L5b
        L5a:
            r6 = r4
        L5b:
            if (r6 != 0) goto L69
            java.lang.String r6 = "positions"
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.util.ArrayList<java.lang.String> r8 = r10.B     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
        L69:
            java.util.ArrayList<java.lang.String> r6 = r10.A     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            if (r6 == 0) goto L75
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            if (r6 == 0) goto L74
            goto L75
        L74:
            r4 = r2
        L75:
            if (r4 != 0) goto L83
            java.lang.String r4 = "texts"
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            java.util.ArrayList<java.lang.String> r10 = r10.A     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r6.<init>(r10)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            r5.put(r4, r6)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
        L83:
            if (r11 == 0) goto L9b
            org.json.JSONObject r10 = r11.getProperties()     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            if (r10 == 0) goto L9b
            com.bytedance.bdtracker.l0.b.b(r10, r5)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L8f
            goto L9b
        L8f:
            r10 = move-exception
            com.bytedance.bdtracker.d r11 = r9.f     // Catch: java.lang.Throwable -> Ld
            com.bytedance.applog.log.IAppLogLogger r11 = r11.D     // Catch: java.lang.Throwable -> Ld
            java.lang.String r4 = "JSON handle failed"
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Ld
            r11.error(r1, r4, r10, r6)     // Catch: java.lang.Throwable -> Ld
        L9b:
            com.bytedance.bdtracker.d r10 = r9.f     // Catch: java.lang.Throwable -> Ld
            r10.onEventV3(r3, r5, r2)     // Catch: java.lang.Throwable -> Ld
            goto Laa
        La1:
            com.bytedance.applog.log.IAppLogLogger r11 = r0.D
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "Run task failed"
            r11.error(r1, r2, r10, r0)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.exposure.ViewExposureManager.a(android.view.View, com.bytedance.applog.exposure.ViewExposureData):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkViewExposureFromActivity$agent_liteChinaRelease(android.app.Activity r14) {
        /*
            r13 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            com.bytedance.bdtracker.d r0 = r13.f
            r1 = 7
            r2 = 0
            java.util.WeakHashMap<android.app.Activity, java.util.WeakHashMap<android.view.View, com.bytedance.bdtracker.s0>> r3 = r13.a     // Catch: java.lang.Throwable -> Le8
            java.lang.Object r14 = r3.get(r14)     // Catch: java.lang.Throwable -> Le8
            java.util.WeakHashMap r14 = (java.util.WeakHashMap) r14     // Catch: java.lang.Throwable -> Le8
            if (r14 == 0) goto Lf2
            java.lang.String r3 = "activitiesMap[activity] ?: return@runSafely"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r3)     // Catch: java.lang.Throwable -> Le8
            java.util.Set r14 = r14.entrySet()     // Catch: java.lang.Throwable -> Le8
            java.util.Iterator r14 = r14.iterator()     // Catch: java.lang.Throwable -> Le8
        L20:
            boolean r3 = r14.hasNext()     // Catch: java.lang.Throwable -> Le8
            if (r3 == 0) goto Lf2
            java.lang.Object r3 = r14.next()     // Catch: java.lang.Throwable -> Le8
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> Le8
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> Le8
            android.view.View r4 = (android.view.View) r4     // Catch: java.lang.Throwable -> Le8
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Le8
            com.bytedance.bdtracker.s0 r3 = (com.bytedance.bdtracker.s0) r3     // Catch: java.lang.Throwable -> Le8
            com.bytedance.applog.exposure.ViewExposureData r5 = r3.a     // Catch: java.lang.Throwable -> Le8
            boolean r6 = r3.b     // Catch: java.lang.Throwable -> Le8
            java.lang.String r7 = "view"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r7)     // Catch: java.lang.Throwable -> Le8
            com.bytedance.applog.exposure.ViewExposureConfig r7 = r5.getConfig()     // Catch: java.lang.Throwable -> Le8
            r8 = 0
            if (r7 == 0) goto L4d
            java.lang.Float r7 = r7.getAreaRatio()     // Catch: java.lang.Throwable -> Le8
            goto L4e
        L4d:
            r7 = r8
        L4e:
            java.lang.String r9 = "$this$isVisibleInViewport"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r9)     // Catch: java.lang.Throwable -> Le8
            boolean r9 = com.bytedance.bdtracker.l0.b.e(r4)     // Catch: java.lang.Throwable -> Le8
            r10 = 1
            if (r9 == 0) goto L88
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch: java.lang.Throwable -> Le8
            r9.<init>()     // Catch: java.lang.Throwable -> Le8
            boolean r11 = r4.getLocalVisibleRect(r9)     // Catch: java.lang.Throwable -> Le8
            if (r11 == 0) goto L88
            int r11 = r9.width()     // Catch: java.lang.Throwable -> Le8
            int r9 = r9.height()     // Catch: java.lang.Throwable -> Le8
            int r9 = r9 * r11
            float r9 = (float) r9     // Catch: java.lang.Throwable -> Le8
            int r11 = r4.getMeasuredHeight()     // Catch: java.lang.Throwable -> Le8
            int r12 = r4.getMeasuredWidth()     // Catch: java.lang.Throwable -> Le8
            int r12 = r12 * r11
            float r11 = (float) r12     // Catch: java.lang.Throwable -> Le8
            if (r7 == 0) goto L80
            float r7 = r7.floatValue()     // Catch: java.lang.Throwable -> Le8
            goto L81
        L80:
            r7 = 0
        L81:
            float r11 = r11 * r7
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 < 0) goto L88
            r7 = r10
            goto L89
        L88:
            r7 = r2
        L89:
            if (r6 == r7) goto L20
            boolean r6 = r3.b     // Catch: java.lang.Throwable -> Le8
            if (r6 != 0) goto L94
            r13.a(r4, r5)     // Catch: java.lang.Throwable -> Le8
            r6 = r10
            goto L95
        L94:
            r6 = r2
        L95:
            r3.b = r6     // Catch: java.lang.Throwable -> Le8
            com.bytedance.applog.exposure.ViewExposureConfig r6 = r5.getConfig()     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto La1
            java.lang.Boolean r8 = r6.getVisualDiagnosis()     // Catch: java.lang.Throwable -> Le8
        La1:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Throwable -> Le8
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r6)     // Catch: java.lang.Throwable -> Le8
            if (r6 == 0) goto Lb0
            boolean r6 = r3.b     // Catch: java.lang.Throwable -> Le8
            com.bytedance.bdtracker.l0.b.b(r4, r6)     // Catch: java.lang.Throwable -> Le8
        Lb0:
            com.bytedance.bdtracker.d r6 = r13.f     // Catch: java.lang.Throwable -> Le8
            com.bytedance.applog.log.IAppLogLogger r6 = r6.D     // Catch: java.lang.Throwable -> Le8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le8
            r7.<init>()     // Catch: java.lang.Throwable -> Le8
            java.lang.String r8 = "[ViewExposure] visible change to "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: java.lang.Throwable -> Le8
            boolean r3 = r3.b     // Catch: java.lang.Throwable -> Le8
            java.lang.StringBuilder r3 = r7.append(r3)     // Catch: java.lang.Throwable -> Le8
            java.lang.String r7 = ", config="
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> Le8
            com.bytedance.applog.exposure.ViewExposureConfig r5 = r5.getConfig()     // Catch: java.lang.Throwable -> Le8
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> Le8
            java.lang.String r5 = " view="
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> Le8
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Le8
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Le8
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Le8
            r6.debug(r1, r3, r4)     // Catch: java.lang.Throwable -> Le8
            goto L20
        Le8:
            r14 = move-exception
            com.bytedance.applog.log.IAppLogLogger r0 = r0.D
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Run task failed"
            r0.error(r1, r3, r14, r2)
        Lf2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.exposure.ViewExposureManager.checkViewExposureFromActivity$agent_liteChinaRelease(android.app.Activity):void");
    }

    public final void disposeViewExposure(View view) {
        Activity activityA;
        s0 s0VarRemove;
        Intrinsics.checkParameterIsNotNull(view, "view");
        d dVar = this.f;
        if (view == null) {
            activityA = null;
        } else {
            try {
                activityA = l0.b.a(view.getContext());
            } catch (Throwable th) {
                dVar.D.error(7, "Run task failed", th, new Object[0]);
                return;
            }
        }
        if (activityA != null) {
            Intrinsics.checkExpressionValueIsNotNull(activityA, "ActivityUtil.findActivit…view) ?: return@runSafely");
            WeakHashMap<View, s0> weakHashMap = this.a.get(activityA);
            if (weakHashMap == null || (s0VarRemove = weakHashMap.remove(view)) == null) {
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(s0VarRemove, "activitiesMap[activity]?…view) ?: return@runSafely");
            ViewExposureConfig config = s0VarRemove.a.getConfig();
            if (Intrinsics.areEqual(config != null ? config.getVisualDiagnosis() : null, true)) {
                l0.b.a(view);
            }
        }
    }

    public final WeakHashMap<Activity, WeakHashMap<View, s0>> getActivitiesMap$agent_liteChinaRelease() {
        return this.a;
    }

    /* renamed from: getAppLog, reason: from getter */
    public final d getF() {
        return this.f;
    }

    public final Activity getCurrActivity() {
        return this.c.a.get();
    }

    public final void observeViewExposure(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        observeViewExposure(view, null);
    }

    public final void observeViewExposure(View view, ViewExposureData data) {
        Float areaRatio;
        Boolean visualDiagnosis;
        Intrinsics.checkParameterIsNotNull(view, "view");
        d dVar = this.f;
        try {
            InitConfig initConfig = dVar.getInitConfig();
            if (initConfig != null && initConfig.isExposureEnabled()) {
                Activity activityA = view == null ? null : l0.b.a(view.getContext());
                if (activityA == null) {
                    this.f.D.warn(7, "[ViewExposure] observe failed: The view context is not Activity.", new Object[0]);
                    return;
                }
                if (d5.b(view)) {
                    this.f.D.warn(7, "[ViewExposure] observe failed: The view is ignored.", new Object[0]);
                    return;
                }
                WeakHashMap<View, s0> weakHashMap = this.a.get(activityA);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap<>();
                    this.a.put(activityA, weakHashMap);
                }
                ViewExposureConfig viewExposureConfig = this.d;
                ViewExposureConfig config = data != null ? data.getConfig() : null;
                Intrinsics.checkParameterIsNotNull(viewExposureConfig, "$this$copyWith");
                if (config == null || (areaRatio = config.getAreaRatio()) == null) {
                    areaRatio = viewExposureConfig.getAreaRatio();
                }
                if (config == null || (visualDiagnosis = config.getVisualDiagnosis()) == null) {
                    visualDiagnosis = viewExposureConfig.getVisualDiagnosis();
                }
                ViewExposureConfig viewExposureConfig2 = new ViewExposureConfig(areaRatio, visualDiagnosis);
                weakHashMap.put(view, new s0(new ViewExposureData(data != null ? data.getEventName() : null, data != null ? data.getProperties() : null, viewExposureConfig2), false, 2));
                if (Intrinsics.areEqual(viewExposureConfig2.getVisualDiagnosis(), true)) {
                    Intrinsics.checkParameterIsNotNull(view, "$this$enableViewExposureDebugMode");
                    if (Build.VERSION.SDK_INT >= 16) {
                        if (view instanceof ImageView) {
                            ImageView imageView = (ImageView) view;
                            imageView.setImageDrawable(new p0(imageView.getDrawable()));
                        }
                        view.setBackground(new p0(view.getBackground()));
                    }
                }
                checkViewExposureFromActivity$agent_liteChinaRelease(activityA);
                this.c.a(view);
                this.f.D.debug(7, "[ViewExposure] observe successful, data=" + data + ", view=" + view, new Object[0]);
                return;
            }
            this.f.D.warn(7, "[ViewExposure] observe failed: InitConfig.exposureEnabled is not true.", new Object[0]);
        } catch (Throwable th) {
            dVar.D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    public final void updateExposureCheckStrategy(r0 r0Var) {
        Lazy lazy = this.e;
        KProperty kProperty = g[0];
        ((a1) lazy.getValue()).a(r0Var);
    }

    public final void updateViewExposureConfig(ViewExposureConfig viewExposureConfig) {
        Intrinsics.checkParameterIsNotNull(viewExposureConfig, "viewExposureConfig");
        this.d = viewExposureConfig;
    }
}
