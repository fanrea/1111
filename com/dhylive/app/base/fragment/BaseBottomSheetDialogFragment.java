package com.dhylive.app.base.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.dhylive.app.R;
import com.dhylive.app.base.dialog.LoadingDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBottomSheetDialogFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0016H\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\u0012\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\u001a\u0010.\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010/\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0006\u00102\u001a\u00020\u001dR\u001c\u0010\f\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/dhylive/app/base/fragment/BaseBottomSheetDialogFragment;", "DB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "gravity", "", "displayWidth", "displayHeight", "mIsCancelable", "", "themeResId", "(IIIZI)V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "loadingDialog", "Lcom/dhylive/app/base/dialog/LoadingDialog;", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "mContentView", "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "dismissLoadingDialog", "", "initLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initListener", "initObserve", "initView", "view", "lazyLoadData", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "onStart", "onViewCreated", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "showLoadingDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseBottomSheetDialogFragment<DB extends ViewDataBinding> extends AppCompatDialogFragment {
    protected DB dataBinding;
    private final int displayHeight;
    private final int displayWidth;
    private final int gravity;
    private LoadingDialog loadingDialog;
    private BottomSheetBehavior<View> mBehavior;
    private View mContentView;
    private final boolean mIsCancelable;
    private final int themeResId;

    public BaseBottomSheetDialogFragment() {
        this(0, 0, 0, false, 0, 31, null);
    }

    public void initListener() {
    }

    public void initObserve() {
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void lazyLoadData() {
    }

    public void loadData() {
    }

    public /* synthetic */ BaseBottomSheetDialogFragment(int i, int i2, int i3, boolean z, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 17 : i, (i5 & 2) != 0 ? -1 : i2, (i5 & 4) != 0 ? -2 : i3, (i5 & 8) != 0 ? true : z, (i5 & 16) != 0 ? R.style.CustomBottomSheetLightStyle : i4);
    }

    public BaseBottomSheetDialogFragment(int i, int i2, int i3, boolean z, int i4) {
        this.gravity = i;
        this.displayWidth = i2;
        this.displayHeight = i3;
        this.mIsCancelable = z;
        this.themeResId = i4;
    }

    protected final DB getDataBinding() {
        DB db = this.dataBinding;
        if (db != null) {
            return db;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dataBinding");
        return null;
    }

    protected final void setDataBinding(DB db) {
        Intrinsics.checkNotNullParameter(db, "<set-?>");
        this.dataBinding = db;
    }

    protected final View getMContentView() {
        return this.mContentView;
    }

    protected final void setMContentView(View view) {
        this.mContentView = view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(this.mIsCancelable);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(this.mIsCancelable);
        }
        setStyle(0, this.themeResId);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = this.mContentView;
        return view != null ? view : initLayout(inflater, container);
    }

    public View initLayout(LayoutInflater inflater, ViewGroup container) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<DB of com.dhylive.app.base.fragment.BaseBottomSheetDialogFragment>");
            Object objInvoke = ((Class) type).getMethod("inflate", LayoutInflater.class).invoke(null, getLayoutInflater());
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type DB of com.dhylive.app.base.fragment.BaseBottomSheetDialogFragment");
            setDataBinding((ViewDataBinding) objInvoke);
            getDataBinding().setLifecycleOwner(this);
        }
        View root = getDataBinding().getRoot();
        this.mContentView = root;
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.loadingDialog = new LoadingDialog(contextRequireContext);
        initView(view);
        initListener();
        initObserve();
        loadData();
    }

    public void show(FragmentManager manager) {
        if (isAdded()) {
            return;
        }
        Intrinsics.checkNotNull(manager);
        show(manager, getClass().getSimpleName());
    }

    public final void showLoadingDialog() {
        LoadingDialog loadingDialog = this.loadingDialog;
        LoadingDialog loadingDialog2 = null;
        if (loadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            loadingDialog = null;
        }
        if (loadingDialog.isShowing()) {
            return;
        }
        LoadingDialog loadingDialog3 = this.loadingDialog;
        if (loadingDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        } else {
            loadingDialog2 = loadingDialog3;
        }
        loadingDialog2.show();
    }

    public final void dismissLoadingDialog() {
        LoadingDialog loadingDialog = this.loadingDialog;
        LoadingDialog loadingDialog2 = null;
        if (loadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            loadingDialog = null;
        }
        if (loadingDialog.isShowing()) {
            LoadingDialog loadingDialog3 = this.loadingDialog;
            if (loadingDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            } else {
                loadingDialog2 = loadingDialog3;
            }
            loadingDialog2.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onStart() {
        /*
            r12 = this;
            super.onStart()
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            androidx.fragment.app.FragmentActivity r1 = r12.requireActivity()
            android.view.WindowManager r1 = r1.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            r1.getMetrics(r0)
            android.app.Dialog r0 = r12.getDialog()
            r1 = 0
            if (r0 == 0) goto L29
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L29
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            goto L2a
        L29:
            r0 = r1
        L2a:
            if (r0 != 0) goto L2d
            goto L31
        L2d:
            int r2 = r12.gravity
            r0.gravity = r2
        L31:
            android.app.Dialog r2 = r12.getDialog()
            if (r2 == 0) goto L3b
            android.view.Window r1 = r2.getWindow()
        L3b:
            if (r1 != 0) goto L3e
            goto L41
        L3e:
            r1.setAttributes(r0)
        L41:
            int r0 = r12.displayWidth
            r1 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            r3 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            r7 = -11
            r8 = -22
            r9 = -33
            if (r0 == r9) goto L6a
            if (r0 == r8) goto L63
            if (r0 == r7) goto L5c
            goto L71
        L5c:
            int r0 = com.blankj.utilcode.util.ScreenUtils.getScreenWidth()
            double r10 = (double) r0
            double r10 = r10 * r1
            goto L70
        L63:
            int r0 = com.blankj.utilcode.util.ScreenUtils.getScreenWidth()
            double r10 = (double) r0
            double r10 = r10 * r3
            goto L70
        L6a:
            int r0 = com.blankj.utilcode.util.ScreenUtils.getScreenWidth()
            double r10 = (double) r0
            double r10 = r10 * r5
        L70:
            int r0 = (int) r10
        L71:
            int r10 = r12.displayHeight
            if (r10 == r9) goto L89
            if (r10 == r8) goto L82
            if (r10 == r7) goto L7a
            goto L90
        L7a:
            int r3 = com.blankj.utilcode.util.ScreenUtils.getScreenHeight()
            double r3 = (double) r3
            double r3 = r3 * r1
            int r10 = (int) r3
            goto L90
        L82:
            int r1 = com.blankj.utilcode.util.ScreenUtils.getScreenHeight()
            double r1 = (double) r1
            double r1 = r1 * r3
            goto L8f
        L89:
            int r1 = com.blankj.utilcode.util.ScreenUtils.getScreenHeight()
            double r1 = (double) r1
            double r1 = r1 * r5
        L8f:
            int r10 = (int) r1
        L90:
            android.app.Dialog r1 = r12.getDialog()
            if (r1 == 0) goto L9f
            android.view.Window r1 = r1.getWindow()
            if (r1 == 0) goto L9f
            r1.setLayout(r0, r10)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dhylive.app.base.fragment.BaseBottomSheetDialogFragment.onStart():void");
    }
}
