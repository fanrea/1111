package com.fendasz.moku.planet.ui.base.activity;

import androidx.fragment.app.Fragment;
import com.fendasz.moku.planet.utils.LogUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "MK_BaseFragment==>";

    public <A> A getAppActivity(Class<A> cls) {
        A a = (A) getActivity();
        if (a.getClass().isAssignableFrom(cls)) {
            return a;
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        LogUtils.logD(TAG, "onDestroy");
        super.onDestroy();
    }
}
