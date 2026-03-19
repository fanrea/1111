package com.bytedance.msdk.core.d;

import android.util.SparseArray;
import com.bytedance.msdk.api.c.d.b.b;
import com.bytedance.sdk.openadsdk.w.c;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static b d(final Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            return new b() { // from class: com.bytedance.msdk.core.d.d.1
                @Override // com.bytedance.msdk.api.c.d.h.u
                public void d(long j) {
                    function.apply(c.d().d(8166).d(Void.class).d(8074, Long.valueOf(j)).hc());
                }

                @Override // com.bytedance.msdk.api.c.d.h.u
                public void hc(long j) {
                    function.apply(c.d().d(8167).d(Void.class).d(8074, Long.valueOf(j)).hc());
                }

                @Override // com.bytedance.msdk.api.c.d.h.u
                public void d() {
                    function.apply(c.d().d(8168).d(Void.class).hc());
                }

                @Override // com.bytedance.msdk.api.c.d.h.u
                public void b(long j) {
                    function.apply(c.d().d(8169).d(Void.class).d(8074, Long.valueOf(j)).hc());
                }

                @Override // com.bytedance.msdk.api.c.d.h.u
                public void hc() {
                    function.apply(c.d().d(8170).d(Void.class).hc());
                }

                @Override // com.bytedance.msdk.api.c.d.h.u
                public void d(int i, int i2) {
                    function.apply(c.d().d(8171).d(Void.class).d(8014, Integer.valueOf(i)).d(8075, Integer.valueOf(i2)).hc());
                }

                @Override // com.bytedance.msdk.api.c.d.h.u
                public void d(long j, int i, int i2) {
                    function.apply(c.d().d(8172).d(Void.class).d(8014, Integer.valueOf(i)).d(8075, Integer.valueOf(i2)).d(8074, Long.valueOf(j)).hc());
                }
            };
        }
        return null;
    }
}
