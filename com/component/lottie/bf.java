package com.component.lottie;

import android.util.Pair;
import java.util.Comparator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bf implements Comparator<Pair<String, Float>> {
    final /* synthetic */ be a;

    bf(be beVar) {
        this.a = beVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
        float fFloatValue = ((Float) pair.second).floatValue();
        float fFloatValue2 = ((Float) pair2.second).floatValue();
        if (fFloatValue2 > fFloatValue) {
            return 1;
        }
        if (fFloatValue > fFloatValue2) {
            return -1;
        }
        return 0;
    }
}
