package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class TuringIDService {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.TuringIDService$do, reason: invalid class name */
    public class Cdo implements Caelum {
        public final /* synthetic */ ITuringDIDCallback a;
    }

    public static ITuringDID a(Context context) {
        int iA = Melon.a();
        return new Longan(iA != 0 ? Gooseberry.a(iA) : Hickory.l.a(context, true, 1));
    }

    public static ITuringDID b(Context context) {
        Gooseberry gooseberryA;
        int iA = Melon.a();
        if (iA != 0) {
            gooseberryA = Gooseberry.a(iA);
        } else {
            Hickory hickory = Hickory.l;
            gooseberryA = hickory.a(context);
            if (hickory.a == null) {
                gooseberryA = Gooseberry.a(-10002);
            } else {
                int iA2 = hickory.a(gooseberryA);
                if (iA2 != 1) {
                    if (iA2 == 2) {
                        hickory.a();
                        gooseberryA = Gooseberry.a(-10009);
                    } else if (iA2 == 3) {
                        hickory.a();
                    }
                }
            }
        }
        return new Longan(gooseberryA);
    }
}
