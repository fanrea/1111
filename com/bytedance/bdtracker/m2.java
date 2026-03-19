package com.bytedance.bdtracker;

import android.os.Handler;
import com.bytedance.applog.aggregation.Metrics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class m2 extends Lambda implements Function1<List<? extends Metrics>, Unit> {
    public final /* synthetic */ n2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m2(n2 n2Var) {
        super(1);
        this.a = n2Var;
    }

    public Object invoke(Object obj) {
        List<Metrics> list = (List) obj;
        Intrinsics.checkParameterIsNotNull(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Metrics metrics : list) {
            h4 h4Var = new h4();
            this.a.c.n.a(this.a.c.d, h4Var);
            h4Var.o = metrics.toParams();
            arrayList.add(h4Var);
        }
        Handler handler = this.a.a;
        handler.sendMessage(handler.obtainMessage(1, arrayList));
        this.a.a.sendEmptyMessage(2);
        return Unit.INSTANCE;
    }
}
