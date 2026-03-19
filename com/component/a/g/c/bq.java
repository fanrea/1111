package com.component.a.g.c;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bq implements Observer {
    final /* synthetic */ bo a;

    bq(bo boVar) {
        this.a = boVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.a.f.b != null) {
                this.a.f.b.a(iIntValue);
            }
            if (this.a.j && this.a.h != null) {
                this.a.h.setText(String.format(Locale.getDefault(), this.a.m, Integer.valueOf(iIntValue / 1000)));
            }
            if (!this.a.a()) {
                return;
            }
            this.a.i.a(this.a.f.a, iIntValue);
        }
    }
}
