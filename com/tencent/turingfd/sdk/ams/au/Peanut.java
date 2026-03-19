package com.tencent.turingfd.sdk.ams.au;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Peanut {
    public static Equuleus a(Equuleus equuleus, byte[] bArr) throws IOException {
        Object objA;
        if (bArr == null || bArr.length == 0) {
            Log.w("TuringDebug", "u1");
            return equuleus;
        }
        byte[] bArrA = Cstatic.a(bArr, Cstatic.a());
        if (bArrA == null || bArrA.length == 0) {
            Log.w("TuringDebug", "u2");
            return equuleus;
        }
        byte[] bArrB = Cnative.b(bArrA);
        if (bArrB == null || bArrB.length == 0) {
            Log.w("TuringDebug", "u3");
            return equuleus;
        }
        Bergamot bergamot = new Bergamot();
        new HashMap();
        HashMap map = new HashMap();
        bergamot.a = (short) 3;
        bergamot.d = 3;
        if (bArrB.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            Draco draco = new Draco(bArrB, 4);
            draco.b = "UTF-8";
            bergamot.a(draco);
            draco.a = ByteBuffer.wrap(bergamot.g);
            if (Peach.a == null) {
                HashMap<String, byte[]> map2 = new HashMap<>();
                Peach.a = map2;
                map2.put("", new byte[0]);
            }
            HashMap mapA = draco.a((Map) Peach.a, 0, false);
            try {
                if (!mapA.containsKey("resp")) {
                    objA = null;
                } else if (map.containsKey("resp")) {
                    objA = map.get("resp");
                } else {
                    byte[] bArr2 = (byte[]) mapA.get("resp");
                    try {
                        Draco draco2 = new Draco();
                        draco2.a = ByteBuffer.wrap(bArr2);
                        draco2.b = "UTF-8";
                        objA = draco2.a((Draco) equuleus, 0, true);
                        if (objA != null) {
                            map.put("resp", objA);
                        }
                    } catch (Exception e) {
                        throw new Exception(e);
                    }
                }
                return (Equuleus) objA;
            } catch (Throwable th) {
                Log.w("TuringDebug", th);
                return equuleus;
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
