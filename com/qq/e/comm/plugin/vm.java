package com.qq.e.comm.plugin;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class vm extends v4 {
    @Override // com.qq.e.comm.plugin.v4
    protected int a() {
        return pro.getIresult(504, 0, this);
    }

    int b(String str) {
        return pro.getIresult(TypedValues.PositionType.TYPE_SIZE_PERCENT, 0, this, str);
    }

    @Override // com.qq.e.comm.plugin.v4
    protected Map<String, Integer> b() {
        return (Map) pro.getobjresult(TypedValues.PositionType.TYPE_PERCENT_X, 0, this);
    }

    vm() {
    }
}
