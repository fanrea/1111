package com.tachikoma.lottie.a.b;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends f<Integer> {
    public b(List<com.tachikoma.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tachikoma.lottie.a.b.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(com.tachikoma.lottie.e.a<Integer> aVar, float f) {
        return Integer.valueOf(c(aVar, f));
    }

    private int c(com.tachikoma.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.NG == null || aVar.NH == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = aVar.NG.intValue();
        int iIntValue2 = aVar.NH.intValue();
        if (this.JG != null && (num = (Integer) this.JG.b(aVar.GT, aVar.NJ.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, kd(), getProgress())) != null) {
            return num.intValue();
        }
        return com.tachikoma.lottie.d.b.a(com.tachikoma.lottie.d.e.d(f, 0.0f, 1.0f), iIntValue, iIntValue2);
    }

    public final int getIntValue() {
        return c(kc(), ke());
    }
}
