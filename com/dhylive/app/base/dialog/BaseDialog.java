package com.dhylive.app.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.dhylive.app.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDialog.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B?\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001bH\u0014J\b\u0010\"\u001a\u00020\u001bH\u0014J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010'\u001a\u00020\bR\u001b\u0010\u000f\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/dhylive/app/base/dialog/BaseDialog;", "DB", "Landroidx/databinding/ViewDataBinding;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "gravity", "", "displayWidth", "displayHeight", "isCancelable", "", "themeResId", "(Landroid/content/Context;IIIZI)V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "dataBinding$delegate", "Lkotlin/Lazy;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "initData", "", "initListener", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setDimAmount", "dimAmount", "", "setWindowAnimations", "id", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseDialog<DB extends ViewDataBinding> extends Dialog implements LifecycleOwner {

    /* renamed from: dataBinding$delegate, reason: from kotlin metadata */
    private final Lazy dataBinding;
    private final int displayHeight;
    private final int displayWidth;
    private final int gravity;
    private final boolean isCancelable;
    private final LifecycleRegistry mLifecycleRegistry;

    public void initData() {
    }

    public abstract void initListener();

    public /* synthetic */ BaseDialog(Context context, int i, int i2, int i3, boolean z, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i5 & 2) != 0 ? 17 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? false : z, (i5 & 32) != 0 ? R.style.PublicDialogTheme : i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog(Context context, int i, int i2, int i3, boolean z, int i4) {
        super(context, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gravity = i;
        this.displayWidth = i2;
        this.displayHeight = i3;
        this.isCancelable = z;
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.dataBinding = LazyKt.lazy(new Function0<DB>(this) { // from class: com.dhylive.app.base.dialog.BaseDialog$dataBinding$2
            final /* synthetic */ BaseDialog<DB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TDB; */
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ViewDataBinding m371invoke() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                Type genericSuperclass = this.this$0.getClass().getGenericSuperclass();
                Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<DB of com.dhylive.app.base.dialog.BaseDialog>");
                Object objInvoke = ((Class) type).getMethod("inflate", LayoutInflater.class).invoke(null, this.this$0.getLayoutInflater());
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type DB of com.dhylive.app.base.dialog.BaseDialog");
                return (ViewDataBinding) objInvoke;
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    protected final DB getDataBinding() {
        return (DB) this.dataBinding.getValue();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        initView();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    private final void initView() {
        setContentView(getDataBinding().getRoot());
        getDataBinding().setLifecycleOwner(this);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Window window = getWindow();
        if (window != null) {
            if (this.gravity == 17) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                int i = this.displayWidth;
                if (i == 0) {
                    i = (int) (displayMetrics.widthPixels * 0.8d);
                }
                attributes.width = i;
            } else {
                window.getAttributes().width = -1;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            int i2 = this.displayHeight;
            if (i2 == 0) {
                i2 = -2;
            }
            attributes2.height = i2;
            window.setGravity(this.gravity);
        }
        setCancelable(this.isCancelable);
        setCanceledOnTouchOutside(this.isCancelable);
        initData();
        initListener();
    }

    public BaseDialog<DB> setDimAmount(float dimAmount) {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
            attributes.dimAmount = dimAmount;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        return this;
    }

    public final BaseDialog<DB> setWindowAnimations(int id) {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(id);
        }
        return this;
    }
}
