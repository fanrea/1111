package com.bytedance.sdk.djx.core.business.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sdk.djx.core.business.base.BaseViewModel;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.params.DJXWidgetParam;
import com.bytedance.sdk.djx.utils.InnerManager;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class FragMVVMProxy<VM extends BaseViewModel, Param extends DJXWidgetParam> extends FragProxy implements LifecycleOwner, ViewModelStoreOwner {
    private static final String TAG = "FragMVVMProxy";
    protected Map<String, Object> mCommonParams = null;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    protected Param mParam;
    protected FrameLayout mRootView;
    LifecycleOwner mViewLifecycleOwner;
    LifecycleRegistry mViewLifecycleRegistry;
    protected VM mViewModel;
    ViewModelStore mViewModelStore;

    protected VM createViewModel() {
        return null;
    }

    public void dismissLoadingProgress() {
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initData(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void initView(View view) {
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onViewCreated(View view, Bundle bundle) {
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
    }

    public void showLoadingProgress() {
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        instantiateViewModel();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = (FrameLayout) super.onCreateView(layoutInflater, viewGroup, bundle);
        LifecycleOwner lifecycleOwner = new LifecycleOwner() { // from class: com.bytedance.sdk.djx.core.business.base.FragMVVMProxy.1
            @Override // androidx.lifecycle.LifecycleOwner
            public Lifecycle getLifecycle() {
                if (FragMVVMProxy.this.mViewLifecycleRegistry == null) {
                    FragMVVMProxy.this.mViewLifecycleRegistry = new LifecycleRegistry(FragMVVMProxy.this.mViewLifecycleOwner);
                }
                return FragMVVMProxy.this.mViewLifecycleRegistry;
            }
        };
        this.mViewLifecycleOwner = lifecycleOwner;
        this.mViewLifecycleRegistry = null;
        if (this.mRootView != null) {
            lifecycleOwner.getLifecycle();
            return this.mRootView;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initData(bundle);
        initView(this.mContentView);
        listenUIData();
        processLogic();
    }

    protected void listenUIData() {
        this.mViewModel.mUiData.observe(getViewLifecycleOwner(), new Observer<BaseViewModel.DataWrapper<BaseViewModel.UIEvent>>() { // from class: com.bytedance.sdk.djx.core.business.base.FragMVVMProxy.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(BaseViewModel.DataWrapper<BaseViewModel.UIEvent> dataWrapper) {
                if (dataWrapper == null) {
                    return;
                }
                int i = AnonymousClass3.$SwitchMap$com$bytedance$sdk$djx$core$business$base$BaseViewModel$UIEvent[dataWrapper.getData().ordinal()];
                if (i == 1) {
                    String str = (String) dataWrapper.getExtra();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    ToastUtil.show(InnerManager.getContext(), str);
                    return;
                }
                if (i == 2) {
                    FragMVVMProxy.this.showLoadingProgress();
                } else {
                    if (i != 3) {
                        return;
                    }
                    FragMVVMProxy.this.dismissLoadingProgress();
                }
            }
        });
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.base.FragMVVMProxy$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$core$business$base$BaseViewModel$UIEvent;

        static {
            int[] iArr = new int[BaseViewModel.UIEvent.values().length];
            $SwitchMap$com$bytedance$sdk$djx$core$business$base$BaseViewModel$UIEvent = iArr;
            try {
                iArr[BaseViewModel.UIEvent.SHOW_TOAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$business$base$BaseViewModel$UIEvent[BaseViewModel.UIEvent.SHOW_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$business$base$BaseViewModel$UIEvent[BaseViewModel.UIEvent.DISMISS_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (this.mRootView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onStart() {
        super.onStart();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.mRootView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onResume() {
        super.onResume();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.mRootView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onPause() {
        super.onPause();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        if (this.mRootView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onStop() {
        super.onStop();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        if (this.mRootView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDestroyView() {
        super.onDestroyView();
        if (this.mRootView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDestroy() {
        super.onDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        Activity myActivity = getMyActivity();
        boolean z = myActivity != null && myActivity.isChangingConfigurations();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null || z) {
            return;
        }
        viewModelStore.clear();
    }

    public void instantiateViewModel() {
        try {
            this.mViewModel = (VM) new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        } catch (Throwable th) {
            Log.e(TAG, "instantiateViewModel throwable: " + th.getMessage());
            this.mViewModel = (VM) createViewModel();
        }
        if (this.mViewModel == null) {
            throw new NullPointerException("we can not get view model instance.");
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getContext() == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mViewModelStore == null) {
            this.mViewModelStore = new ViewModelStore();
        }
        return this.mViewModelStore;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        LifecycleOwner lifecycleOwner = this.mViewLifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        throw new IllegalStateException("in FragMVVMProxy, Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public void finishActivity() {
        Activity myActivity = getMyActivity();
        if (myActivity != null) {
            myActivity.finish();
        }
    }

    public final void setParam(Param param, Map<String, Object> map) {
        this.mParam = param;
        this.mCommonParams = map;
    }

    public Context getGlobalContext() {
        Context context;
        Context context2 = InnerManager.getContext();
        return (context2 != null || (context = getContext()) == null) ? context2 : context.getApplicationContext();
    }
}
