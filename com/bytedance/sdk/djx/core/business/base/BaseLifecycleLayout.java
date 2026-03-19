package com.bytedance.sdk.djx.core.business.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy;
import com.bytedance.sdk.djx.params.DJXWidgetParam;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseLifecycleLayout.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u001e\u001a\u0002H\u001f\"\b\b\u0001\u0010\u001f*\u00020\r2\b\b\u0001\u0010 \u001a\u00020\n¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H\u0004J\b\u0010$\u001a\u00020#H$J\b\u0010%\u001a\u00020#H$J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020#H$J\b\u0010)\u001a\u00020\nH%R\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/base/BaseLifecycleLayout;", "P", "Lcom/bytedance/sdk/djx/params/DJXWidgetParam;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/sdk/djx/core/business/base/ILifecycleEventProxy;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "layoutContainer", "Landroid/view/View;", "getLayoutContainer", "()Landroid/view/View;", "setLayoutContainer", "(Landroid/view/View;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroid/arch/lifecycle/LifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "widgetParam", "getWidgetParam", "()Lcom/bytedance/sdk/djx/params/DJXWidgetParam;", "setWidgetParam", "(Lcom/bytedance/sdk/djx/params/DJXWidgetParam;)V", "Lcom/bytedance/sdk/djx/params/DJXWidgetParam;", "findView", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "id", "(I)Landroid/view/View;", PointCategory.INIT, "", "initData", "initView", "onCreate", "onRegisterLifecycle", "processLogic", "setLayoutId", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseLifecycleLayout<P extends DJXWidgetParam> extends FrameLayout implements ILifecycleEventProxy {
    public Map<Integer, View> _$_findViewCache;
    protected View layoutContainer;

    /* renamed from: lifecycleRegistry$delegate, reason: from kotlin metadata */
    private final Lazy lifecycleRegistry;
    private P widgetParam;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseLifecycleLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseLifecycleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        if (viewFindViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void processLogic();

    protected abstract int setLayoutId();

    public /* synthetic */ BaseLifecycleLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleProxy, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return ILifecycleEventProxy.DefaultImpls.getLifecycle(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        ILifecycleEventProxy.DefaultImpls.onDestroy(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        ILifecycleEventProxy.DefaultImpls.onPause(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        ILifecycleEventProxy.DefaultImpls.onResume(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        ILifecycleEventProxy.DefaultImpls.onStart(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        ILifecycleEventProxy.DefaultImpls.onStop(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLifecycleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lifecycleRegistry = LazyKt.lazy(new Function0<LifecycleRegistry>(this) { // from class: com.bytedance.sdk.djx.core.business.base.BaseLifecycleLayout$lifecycleRegistry$2
            final /* synthetic */ BaseLifecycleLayout<P> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final LifecycleRegistry m351invoke() {
                return this.this$0.onRegisterLifecycle();
            }
        });
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleProxy
    public LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.lifecycleRegistry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LifecycleRegistry onRegisterLifecycle() {
        return new LifecycleRegistry(this);
    }

    protected final View getLayoutContainer() {
        View view = this.layoutContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutContainer");
        return null;
    }

    protected final void setLayoutContainer(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.layoutContainer = view;
    }

    public final P getWidgetParam() {
        return this.widgetParam;
    }

    public final void setWidgetParam(P p) {
        this.widgetParam = p;
    }

    public final <V extends View> V findView(int id) {
        V v = (V) findViewById(id);
        Intrinsics.checkNotNullExpressionValue(v, "this.findViewById(id)");
        return v;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ILifecycleEventProxy
    public void onCreate() {
        ILifecycleEventProxy.DefaultImpls.onCreate(this);
        removeAllViews();
        View viewInflate = LayoutInflater.from(getContext()).inflate(setLayoutId(), (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(setLayoutId(), this, true)");
        setLayoutContainer(viewInflate);
        init();
    }

    protected final void init() {
        initData();
        initView();
        processLogic();
    }
}
