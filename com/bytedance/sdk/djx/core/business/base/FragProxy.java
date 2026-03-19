package com.bytedance.sdk.djx.core.business.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.sdk.djx.DJXPlaySpeedScope;
import com.bytedance.sdk.djx.IDJXWidget;
import com.bytedance.sdk.djx.core.base.DJXFragV11;
import com.bytedance.sdk.djx.core.base.DJXFragV4;
import com.bytedance.sdk.djx.core.base.FLifeProxy;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class FragProxy extends FLifeProxy implements IDJXWidget {
    private static final String TAG = "FragProxy";
    private Activity mActivity;
    protected View mContentView;
    protected Fragment mFragment;
    protected android.app.Fragment mFragmentApp;
    protected FrameLayout mOtherLayout;
    private boolean mResumed = false;
    private boolean mIsVisibleHint = true;
    private boolean mHidden = false;
    private boolean mVisible = false;

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void backRefresh() {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public boolean canBackPress() {
        return true;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void destroy() {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public int getCurrentDramaIndex() {
        return 0;
    }

    protected abstract Object getLayoutId();

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public Fragment getReportFragment() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public android.app.Fragment getReportFragment2() {
        return null;
    }

    protected abstract void initData(Bundle bundle);

    protected abstract void initView(View view);

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void openDramaGallery() {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void openMoreDialog() {
    }

    protected abstract void processLogic();

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void refresh() {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void scrollToTop() {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void seekTo(long j) {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void setCurrentDramaIndex(int i) {
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public boolean setCurrentPage(int i) {
        return false;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public void setSpeedPlay(float f, DJXPlaySpeedScope dJXPlaySpeedScope) {
    }

    protected void addOtherView(View view) {
        FrameLayout frameLayout;
        if (view == null || (frameLayout = this.mOtherLayout) == null) {
            return;
        }
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object layoutId = getLayoutId();
        if (layoutId instanceof View) {
            this.mContentView = (View) layoutId;
        } else {
            this.mContentView = layoutInflater.inflate(((Integer) layoutId).intValue(), viewGroup, false);
        }
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        frameLayout.addView(this.mContentView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(layoutInflater.getContext());
        this.mOtherLayout = frameLayout2;
        frameLayout.addView(frameLayout2);
        return frameLayout;
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData(bundle);
        initView(this.mContentView);
        processLogic();
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mActivity = (Activity) context;
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        ToastUtil.cancelAll(getMyActivity());
        this.mActivity = null;
    }

    public boolean isV4Support() {
        return this.mFragment != null;
    }

    public boolean isAdded() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.isAdded();
        }
        android.app.Fragment fragment2 = this.mFragmentApp;
        if (fragment2 != null) {
            return fragment2.isAdded();
        }
        return false;
    }

    public Activity getMyActivity() {
        if (this.mActivity == null) {
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                this.mActivity = fragment.getActivity();
            } else {
                android.app.Fragment fragment2 = this.mFragmentApp;
                if (fragment2 != null) {
                    this.mActivity = fragment2.getActivity();
                }
            }
        }
        return this.mActivity;
    }

    public Context getContext() {
        Context activity;
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            activity = fragment.getContext();
        } else if (this.mFragmentApp == null) {
            activity = null;
        } else if (Build.VERSION.SDK_INT >= 23) {
            activity = this.mFragmentApp.getContext();
        } else {
            activity = this.mFragmentApp.getActivity();
        }
        if (activity != null) {
            return activity;
        }
        Activity activity2 = this.mActivity;
        return activity2 != null ? activity2 : InnerManager.getContext();
    }

    public <T extends View> T findById(int i) {
        return (T) this.mContentView.findViewById(i);
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mIsVisibleHint = z;
        onVisibilityChanged();
        LG.i(TAG, "setUserVisibleHint = " + z);
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.mHidden = z;
        onVisibilityChanged();
        LG.i(TAG, "onHiddenChanged = " + z);
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        onVisibilityChanged();
        LG.i(TAG, "frag proxy resume");
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        onVisibilityChanged();
        LG.i(TAG, "frag proxy pause");
    }

    private void onVisibilityChanged() {
        boolean z = this.mIsVisibleHint && this.mResumed && !this.mHidden;
        if (z != this.mVisible) {
            this.mVisible = z;
            if (z) {
                onFragmentShow();
            } else {
                onFragmentHide();
            }
        }
    }

    public boolean isFragVisible() {
        return this.mVisible;
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public Bundle getArguments() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.getArguments();
        }
        android.app.Fragment fragment2 = this.mFragmentApp;
        if (fragment2 != null) {
            return fragment2.getArguments();
        }
        return super.getArguments();
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            fragment.setArguments(bundle);
            return;
        }
        android.app.Fragment fragment2 = this.mFragmentApp;
        if (fragment2 != null) {
            fragment2.setArguments(bundle);
        }
    }

    @Override // com.bytedance.sdk.djx.core.base.FLifeProxy
    public Resources getResources() {
        return getContext().getResources();
    }

    protected void onFragmentShow() {
        LG.d(getClass().getSimpleName(), "onFragmentShow");
    }

    protected void onFragmentHide() {
        LG.d(getClass().getSimpleName(), "onFragmentHide");
    }

    public void editAdKey() {
        LG.d(getClass().getSimpleName(), "editAdKey");
    }

    protected FragmentManager getFragmentManagerV4() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            return fragment.getChildFragmentManager();
        }
        return null;
    }

    protected android.app.FragmentManager getFragmentManagerV11() {
        if (this.mFragmentApp == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return this.mFragmentApp.getChildFragmentManager();
        }
        return this.mFragmentApp.getFragmentManager();
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public Fragment getFragment() {
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            if (fragment instanceof DJXFragV4) {
                ((DJXFragV4) fragment).setFragProxy(this);
            }
            return this.mFragment;
        }
        DJXFragV4 dJXFragV4 = new DJXFragV4();
        dJXFragV4.setFragProxy(this);
        this.mFragment = dJXFragV4;
        return dJXFragV4;
    }

    @Override // com.bytedance.sdk.djx.IDJXWidget
    public android.app.Fragment getFragment2() {
        android.app.Fragment fragment = this.mFragmentApp;
        if (fragment != null) {
            if (fragment instanceof DJXFragV11) {
                ((DJXFragV11) fragment).setFragProxy(this);
            }
            return this.mFragmentApp;
        }
        DJXFragV11 dJXFragV11 = new DJXFragV11();
        dJXFragV11.setFragProxy(this);
        this.mFragmentApp = dJXFragV11;
        return dJXFragV11;
    }
}
