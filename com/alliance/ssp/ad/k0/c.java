package com.alliance.ssp.ad.k0;

import androidx.fragment.app.Fragment;
import com.alliance.ssp.ad.oaidgithub.ykrank.androidlifecycle.event.InitSate;

/* compiled from: LifeCycleManagerSupportFragment.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends Fragment {
    public a a;
    public com.alliance.ssp.ad.i0.a b;
    public InitSate c = InitSate.CREATED;
    public boolean d = false;

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.alliance.ssp.ad.i0.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.alliance.ssp.ad.i0.a aVar = this.b;
        if (aVar != null) {
            aVar.getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.alliance.ssp.ad.i0.a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.d) {
            if (this.c == InitSate.RESUMED) {
                this.d = true;
                return;
            }
            this.d = true;
        }
        com.alliance.ssp.ad.i0.a aVar = this.b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.d) {
            InitSate initSate = this.c;
            if (initSate == InitSate.RESUMED) {
                return;
            }
            if (initSate == InitSate.STARTED) {
                this.d = true;
                return;
            }
            this.d = true;
        }
        com.alliance.ssp.ad.i0.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.alliance.ssp.ad.i0.a aVar = this.b;
        if (aVar != null) {
            aVar.e();
        }
    }
}
