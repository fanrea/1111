package com.dhylive.app.base.activity;

import android.R;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import com.baidu.mobads.container.util.cm;
import com.dhylive.app.base.dialog.LoadingDialog;
import com.gyf.barlibrary.ImmersionBar;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseActivity.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H&J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H&J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0014H\u0014J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0004J\u0010\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00028\u0000X\u0084.¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lcom/dhylive/app/base/activity/BaseActivity;", "DB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "barType", "", "(I)V", "dataBinding", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "loadingDialog", "Lcom/dhylive/app/base/dialog/LoadingDialog;", "getLoadingDialog", "()Lcom/dhylive/app/base/dialog/LoadingDialog;", "setLoadingDialog", "(Lcom/dhylive/app/base/dialog/LoadingDialog;)V", "dismissLoadingDialog", "", "finish", "getResources", "Landroid/content/res/Resources;", "initDataBinding", "initExtras", "initListener", "initObserve", "initTitle", "initViews", "loadData", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setBar", "showLoadingDialog", cm.V, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseActivity<DB extends ViewDataBinding> extends AppCompatActivity {
    private final int barType;
    protected DB dataBinding;
    private LoadingDialog loadingDialog;

    public BaseActivity() {
        this(0, 1, null);
    }

    public void initExtras() {
    }

    public void initListener() {
    }

    public abstract void initObserve();

    public void initTitle() {
    }

    public abstract void initViews();

    public void loadData() {
    }

    public /* synthetic */ BaseActivity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BaseActivity(int i) {
        this.barType = i;
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

    protected final LoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    protected final void setLoadingDialog(LoadingDialog loadingDialog) {
        this.loadingDialog = loadingDialog;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(savedInstanceState);
        overridePendingTransition(2130772086, 2130772088);
        setBar(this.barType);
        this.loadingDialog = new LoadingDialog(this);
        initExtras();
        initDataBinding();
        initTitle();
        initViews();
        initObserve();
        initListener();
        loadData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (!(newConfig.fontScale == 1.0f)) {
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Configuration configuration;
        Resources resources = super.getResources();
        if (resources != null) {
            if (!(resources.getConfiguration().fontScale == 1.0f) && (configuration = resources.getConfiguration()) != null) {
                if (!(configuration.fontScale == 1.0f)) {
                    configuration.fontScale = 1.0f;
                    resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                }
            }
        }
        Intrinsics.checkNotNull(resources);
        return resources;
    }

    public void initDataBinding() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<DB of com.dhylive.app.base.activity.BaseActivity>");
            Object objInvoke = ((Class) type).getMethod("inflate", LayoutInflater.class).invoke(null, getLayoutInflater());
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type DB of com.dhylive.app.base.activity.BaseActivity");
            setDataBinding((ViewDataBinding) objInvoke);
            setContentView(getDataBinding().getRoot());
            getDataBinding().setLifecycleOwner(this);
        }
    }

    protected final void setBar(int barType) {
        BaseActivity<DB> baseActivity = this;
        ImmersionBar.with(baseActivity).reset().init();
        if (barType == 0) {
            ImmersionBar.with(baseActivity).statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
        } else if (barType == 1) {
            ImmersionBar.with(baseActivity).statusBarColor(R.color.black).statusBarDarkFont(false).fitsSystemWindows(true).init();
        } else if (barType == 2) {
            ImmersionBar.with(baseActivity).statusBarColor(R.color.transparent).statusBarDarkFont(true).init();
        } else if (barType == 3) {
            ImmersionBar.with(baseActivity).statusBarColor(R.color.transparent).statusBarDarkFont(false).init();
        } else if (barType == 4) {
            ImmersionBar.with(baseActivity).statusBarColor(R.color.white).statusBarDarkFont(true).init();
        }
        ImmersionBar.with(baseActivity).navigationBarColor(R.color.white).init();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(2130772087, 2130772089);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        dismissLoadingDialog();
    }

    public static /* synthetic */ void showLoadingDialog$default(BaseActivity baseActivity, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
        }
        if ((i & 1) != 0) {
            str = "";
        }
        baseActivity.showLoadingDialog(str);
    }

    public final void showLoadingDialog(String message) {
        Intrinsics.checkNotNullParameter(message, cm.V);
        LoadingDialog loadingDialog = this.loadingDialog;
        if ((loadingDialog == null || loadingDialog.isShowing()) ? false : true) {
            if (message.length() == 0) {
                LoadingDialog loadingDialog2 = this.loadingDialog;
                if (loadingDialog2 != null) {
                    loadingDialog2.show();
                    return;
                }
                return;
            }
            LoadingDialog loadingDialog3 = this.loadingDialog;
            if (loadingDialog3 != null) {
                loadingDialog3.showWithMessage(message);
            }
        }
    }

    public final void dismissLoadingDialog() {
        LoadingDialog loadingDialog;
        LoadingDialog loadingDialog2 = this.loadingDialog;
        if (!(loadingDialog2 != null && loadingDialog2.isShowing()) || (loadingDialog = this.loadingDialog) == null) {
            return;
        }
        loadingDialog.dismiss();
    }
}
