package com.tencent.turingfd.sdk.ams.au;

import com.kwai.video.player.NativeErrorCode;
import com.tencent.turingfd.sdk.ams.au.CanisMinor;
import com.tencent.turingfd.sdk.ams.au.Csynchronized;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Loquat {
    public static final Loquat b = new Loquat();
    public Foxnut a;

    public Mangosteen a(int i, byte[] bArr, int i2, int i3, Cassiopeia cassiopeia) {
        CanisMinor canisMinor = this.a.a;
        if (canisMinor == null) {
            return Mangosteen.a(NativeErrorCode.EKS_UNKNOWN_ERROR_BASE);
        }
        try {
            System.currentTimeMillis();
            CanisMinor.Cdo cdoA = ((Csynchronized.Cdo) canisMinor).a(bArr);
            int i4 = cdoA.a;
            return i4 != 0 ? Mangosteen.a(i4 + NativeErrorCode.EKS_UNKNOWN_ERROR_BASE) : Mangosteen.a(cdoA.b);
        } catch (Throwable unused) {
            return Mangosteen.a(NativeErrorCode.EKS_UNKNOWN_ERROR_BASE);
        }
    }
}
