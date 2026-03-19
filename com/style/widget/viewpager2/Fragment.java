package com.style.widget.viewpager2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.adrequest.i;
import com.component.interfaces.RemoteDelegator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class Fragment extends RemoteDelegator<Object> {
    private static final String CALLBACK_ON_ACTIVITY_CREATED = "onActivityCreated";
    private static final String CALLBACK_ON_ATTACH = "onAttach";
    private static final String CALLBACK_ON_CREATE = "onCreate";
    private static final String CALLBACK_ON_CREATE_VIEW = "onCreateView";
    private static final String CALLBACK_ON_DESTROY = "onDestroy";
    private static final String CALLBACK_ON_DESTROY_VIEW = "onDestroyView";
    private static final String CALLBACK_ON_DETACH = "onDetach";
    private static final String CALLBACK_ON_PAUSE = "onPause";
    private static final String CALLBACK_ON_RESUME = "onResume";
    private static final String CALLBACK_ON_START = "onStart";
    private static final String CALLBACK_ON_STOP = "onStop";

    public Fragment(String str, i iVar) {
        super(str, iVar, new Object[0]);
        setCallback(new RemoteDelegator.Callback() { // from class: com.style.widget.viewpager2.Fragment.1
            @Override // com.component.interfaces.RemoteDelegator.Callback
            public Object onResult(String str2, Object[] objArr) {
                if (Fragment.CALLBACK_ON_ATTACH.equals(str2) && RemoteDelegator.validateArgs(objArr, Context.class)) {
                    Fragment.this.onAttach((Context) objArr[0]);
                    return null;
                }
                if (Fragment.CALLBACK_ON_CREATE.equals(str2) && RemoteDelegator.validateArgs(objArr, Bundle.class)) {
                    Fragment.this.onCreate((Bundle) objArr[0]);
                    return null;
                }
                if (Fragment.CALLBACK_ON_CREATE_VIEW.equals(str2) && RemoteDelegator.validateArgs(objArr, LayoutInflater.class, ViewGroup.class, Bundle.class)) {
                    return Fragment.this.onCreateView((LayoutInflater) objArr[0], (ViewGroup) objArr[1], (Bundle) objArr[2]);
                }
                if (Fragment.CALLBACK_ON_ACTIVITY_CREATED.equals(str2) && RemoteDelegator.validateArgs(objArr, Bundle.class)) {
                    Fragment.this.onActivityCreated((Bundle) objArr[0]);
                    return null;
                }
                if (Fragment.CALLBACK_ON_START.equals(str2)) {
                    Fragment.this.onStart();
                    return null;
                }
                if (Fragment.CALLBACK_ON_RESUME.equals(str2)) {
                    Fragment.this.onResume();
                    return null;
                }
                if (Fragment.CALLBACK_ON_PAUSE.equals(str2)) {
                    Fragment.this.onPause();
                    return null;
                }
                if (Fragment.CALLBACK_ON_STOP.equals(str2)) {
                    Fragment.this.onStop();
                    return null;
                }
                if (Fragment.CALLBACK_ON_DESTROY_VIEW.equals(str2)) {
                    Fragment.this.onDestroyView();
                    return null;
                }
                if (Fragment.CALLBACK_ON_DESTROY.equals(str2)) {
                    Fragment.this.onDestroy();
                    return null;
                }
                if (Fragment.CALLBACK_ON_DETACH.equals(str2)) {
                    Fragment.this.onDetach();
                    return null;
                }
                return null;
            }
        });
    }

    @Override // com.component.interfaces.RemoteDelegator
    protected Object transformInstance(Object obj) {
        return obj;
    }

    public void onAttach(Context context) {
    }

    public void onCreate(Bundle bundle) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onActivityCreated(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
    }

    public void onDetach() {
    }
}
