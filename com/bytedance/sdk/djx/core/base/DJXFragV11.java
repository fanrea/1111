package com.bytedance.sdk.djx.core.base;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.utils.ZeusUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXFragV11 extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks = new FragmentClear(this);
    private FLifeProxy mFragProxy;

    public void setFragProxy(FLifeProxy fLifeProxy) {
        this.mFragProxy = fLifeProxy;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onCreate(bundle);
        }
    }

    @Override // android.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onViewStateRestored(bundle);
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            return fLifeProxy.onCreateView(layoutInflater, viewGroup, bundle);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onViewCreated(view, bundle);
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onActivityCreated(bundle);
        }
    }

    @Override // android.app.Fragment
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

    @Override // android.app.Fragment
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

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.setUserVisibleHint(z);
        }
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onHiddenChanged(z);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onResume();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onPause();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onStop();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onDestroyView();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        FLifeProxy fLifeProxy = this.mFragProxy;
        if (fLifeProxy != null) {
            fLifeProxy.onDestroy();
        }
    }
}
