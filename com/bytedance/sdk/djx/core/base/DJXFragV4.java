package com.bytedance.sdk.djx.core.base;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.sdk.djx.utils.ZeusUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXFragV4 extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new FragmentClear(this);
    private FLifeProxy mFragProxy;

    public void setFragProxy(FLifeProxy fLifeProxy) {
        this.mFragProxy = fLifeProxy;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            fragmentTransactionBeginTransaction.remove(it.next());
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onViewStateRestored(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            return fLifeProxy.onCreateView(layoutInflater, viewGroup, bundle);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onViewCreated(view, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            Application appApplication = ZeusUtils.getAppApplication();
            if (appApplication != null) {
                appApplication.registerActivityLifecycleCallbacks(this.callbacks);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        try {
            Application appApplication = ZeusUtils.getAppApplication();
            if (appApplication != null) {
                appApplication.unregisterActivityLifecycleCallbacks(this.callbacks);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetach();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onDetach();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.setUserVisibleHint(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onHiddenChanged(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onDestroyView();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onDestroy();
        }
    }
}
