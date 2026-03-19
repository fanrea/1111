package com.bytedance.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.bytedance.applog.R;
import com.ss.texturerender.TextureRenderKeys;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\b\u0010 \u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u001a\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0016J\u0018\u0010)\u001a\u00020\r2\u0006\u0010#\u001a\u00020\n2\u0006\u0010*\u001a\u00020%H\u0016J\u0010\u0010+\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010,\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0016J\u0012\u0010-\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u00100\u001a\u00020\r2\u0014\u00101\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\r0\fJ\u001a\u00102\u001a\u00020\r2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fJ\u0006\u00103\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/applog/exposure/ViewTreeChangeObserver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/view/View$OnAttachStateChangeListener;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "currentActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "onActivityStoppedCallback", "Lkotlin/Function1;", "", "onDrawListener", "Landroid/view/ViewTreeObserver$OnDrawListener;", "onGlobalFocusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onScrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "onWindowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "viewTreeChangeCallback", "Lcom/bytedance/applog/exposure/ViewTreeChangeCallback;", "checkObserveViewTree", "view", "Landroid/view/View;", "disposeViewTree", "rootView", "getCurrentActivity", "invokeCallback", "observeViewTree", "onActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onViewAttachedToWindow", "onViewDetachedFromWindow", "v", "registerActivityStoppedCallback", TextureRenderKeys.KEY_IS_CALLBACK, "subscribe", "unsubscribe", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class v0 implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener {
    public WeakReference<Activity> a;
    public ViewTreeObserver.OnDrawListener b;
    public ViewTreeObserver.OnGlobalLayoutListener c;
    public ViewTreeObserver.OnGlobalFocusChangeListener d;
    public ViewTreeObserver.OnScrollChangedListener e;
    public ViewTreeObserver.OnWindowFocusChangeListener f;
    public Function1<? super Activity, Unit> g;
    public Function1<? super Activity, Unit> h;
    public final Application i;

    public static final class a implements ViewTreeObserver.OnDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            v0.a(v0.this);
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View view, View view2) {
            v0.a(v0.this);
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            v0.a(v0.this);
        }
    }

    public static final class d implements ViewTreeObserver.OnScrollChangedListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            v0.a(v0.this);
        }
    }

    public static final class e implements ViewTreeObserver.OnWindowFocusChangeListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            v0.a(v0.this);
        }
    }

    public v0(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        this.i = application;
        this.a = new WeakReference<>(null);
        this.b = new a();
        this.c = new c();
        this.d = new b();
        this.e = new d();
        this.f = new e();
    }

    public static final /* synthetic */ void a(v0 v0Var) {
        Activity activity = v0Var.a.get();
        if (activity != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "currentActivityRef.get() ?: return");
            Function1<? super Activity, Unit> function1 = v0Var.g;
            if (function1 != null) {
            }
        }
    }

    public final void a(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (Build.VERSION.SDK_INT < 19 || !view.isAttachedToWindow()) {
            view.addOnAttachStateChangeListener(this);
            return;
        }
        View rootView = view.getRootView();
        Intrinsics.checkExpressionValueIsNotNull(rootView, "view.rootView");
        b(rootView);
    }

    public final void a(Function1<? super Activity, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, TextureRenderKeys.KEY_IS_CALLBACK);
        this.h = function1;
    }

    public final void b(View view) {
        if (Intrinsics.areEqual(view.getTag(R.id.applog_tag_view_exposure_observe_flag), true)) {
            return;
        }
        view.setTag(R.id.applog_tag_view_exposure_observe_flag, true);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalFocusChangeListener(this.d);
        viewTreeObserver.addOnScrollChangedListener(this.e);
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.addOnDrawListener(this.b);
            viewTreeObserver.addOnGlobalLayoutListener(this.c);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            viewTreeObserver.addOnWindowFocusChangeListener(this.f);
        }
    }

    public final void b(Function1<? super Activity, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, TextureRenderKeys.KEY_IS_CALLBACK);
        if (this.g == null) {
            this.g = function1;
            this.i.registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "activity.window.decorView");
        if (!Intrinsics.areEqual(decorView.getTag(R.id.applog_tag_view_exposure_observe_flag), true)) {
            return;
        }
        decorView.setTag(R.id.applog_tag_view_exposure_observe_flag, false);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        viewTreeObserver.removeOnGlobalFocusChangeListener(this.d);
        viewTreeObserver.removeOnScrollChangedListener(this.e);
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnDrawListener(this.b);
            viewTreeObserver.removeOnGlobalLayoutListener(this.c);
        }
        if (Build.VERSION.SDK_INT >= 18) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.f);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.a = new WeakReference<>(activity);
        Window window = activity.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "activity.window.decorView");
        b(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Function1<? super Activity, Unit> function1;
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (this.a.get() == null || !(!Intrinsics.areEqual(r0, activity)) || (function1 = this.h) == null) {
            return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (view != null) {
            View rootView = view.getRootView();
            Intrinsics.checkExpressionValueIsNotNull(rootView, "view.rootView");
            b(rootView);
            view.removeOnAttachStateChangeListener(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
    }
}
