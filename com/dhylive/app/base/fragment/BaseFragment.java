package com.dhylive.app.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.container.util.cm;
import com.dhylive.app.base.dialog.LoadingDialog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\fH\u0004J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J&\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\u001a\u0010*\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u00192\b\b\u0002\u0010,\u001a\u00020-R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/dhylive/app/base/fragment/BaseFragment;", "DB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/Fragment;", "()V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "isFirst", "", "()Z", "setFirst", "(Z)V", "loadingDialog", "Lcom/dhylive/app/base/dialog/LoadingDialog;", "mContentView", "Landroid/view/View;", "getMContentView", "()Landroid/view/View;", "setMContentView", "(Landroid/view/View;)V", "dismissLoadingDialog", "", "initLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initListener", "initObserve", "initView", "view", "isDataBinding", "lazyLoadData", "loadData", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "showLoadingDialog", cm.V, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseFragment<DB extends ViewDataBinding> extends Fragment {
    protected DB dataBinding;
    private boolean isFirst = true;
    private LoadingDialog loadingDialog;
    private View mContentView;

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

    /* renamed from: isFirst, reason: from getter */
    protected final boolean getIsFirst() {
        return this.isFirst;
    }

    protected final void setFirst(boolean z) {
        this.isFirst = z;
    }

    protected final View getMContentView() {
        return this.mContentView;
    }

    protected final void setMContentView(View view) {
        this.mContentView = view;
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
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<DB of com.dhylive.app.base.fragment.BaseFragment>");
            Object objInvoke = ((Class) type).getMethod("inflate", LayoutInflater.class).invoke(null, getLayoutInflater());
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type DB of com.dhylive.app.base.fragment.BaseFragment");
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
        this.isFirst = true;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.loadingDialog = new LoadingDialog(contextRequireContext);
        initView(view);
        initListener();
        initObserve();
        loadData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isFirst) {
            this.isFirst = false;
            lazyLoadData();
        }
    }

    public static /* synthetic */ void showLoadingDialog$default(BaseFragment baseFragment, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        baseFragment.showLoadingDialog(str);
    }

    public final void showLoadingDialog(String message) {
        Intrinsics.checkNotNullParameter(message, cm.V);
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null) {
            LoadingDialog loadingDialog2 = null;
            if (loadingDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                loadingDialog = null;
            }
            if (loadingDialog.isShowing()) {
                return;
            }
            if (message.length() == 0) {
                LoadingDialog loadingDialog3 = this.loadingDialog;
                if (loadingDialog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                } else {
                    loadingDialog2 = loadingDialog3;
                }
                loadingDialog2.show();
                return;
            }
            LoadingDialog loadingDialog4 = this.loadingDialog;
            if (loadingDialog4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
            } else {
                loadingDialog2 = loadingDialog4;
            }
            loadingDialog2.showWithMessage(message);
        }
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

    protected final boolean isDataBinding() {
        return this.dataBinding != null;
    }
}
