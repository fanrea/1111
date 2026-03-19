package com.bytedance.msdk.core.h;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.msdk.an.hc.c;
import com.bytedance.msdk.core.d.d.u;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.gb.us;
import com.bytedance.msdk.gb.zw;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static String b = "KEY_LOAD_SEQ_TIME";
    private static Comparator<com.bytedance.msdk.hc.b> d = null;
    private static String hc = "KEY_LOAD_SEQ";

    public static boolean hc(String str) {
        return true;
    }

    public static Comparator<com.bytedance.msdk.hc.b> d() {
        Comparator<com.bytedance.msdk.hc.b> comparator = d;
        return comparator != null ? comparator : hc();
    }

    public static Comparator<com.bytedance.msdk.hc.b> hc() {
        Comparator<com.bytedance.msdk.hc.b> comparator = new Comparator<com.bytedance.msdk.hc.b>() { // from class: com.bytedance.msdk.core.h.b.1
            @Override // java.util.Comparator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.hc.b bVar2) {
                if (bVar.kb() > bVar2.kb()) {
                    return -1;
                }
                if (bVar.kb() < bVar2.kb()) {
                    return 1;
                }
                return (bVar.kb() == bVar2.kb() && bVar.t() == 1) ? -1 : 0;
            }
        };
        d = comparator;
        return comparator;
    }

    public static void d(List<com.bytedance.msdk.hc.b> list, Comparator<com.bytedance.msdk.hc.b> comparator) {
        if (comparator == null) {
            us.d(list);
        } else {
            us.d(list, comparator);
        }
    }

    public static String d(String str, String str2, String str3) {
        if (TextUtils.equals("pangle", com.bytedance.msdk.hc.d.d(str2)) && com.bytedance.msdk.core.d.mk().mt()) {
            return "com.bytedance.msdk.adapter.panglecustom.".concat(String.valueOf(String.format(str, "PangleCustom", str3)));
        }
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.hc.d.d(str2) + "." + String.format(str, str2, str3);
    }

    public static boolean d(tc tcVar) {
        if (tcVar != null && TextUtils.equals(tcVar.e(), "pangle")) {
            return true;
        }
        if (tcVar != null && u.d(tcVar.e())) {
            return true;
        }
        if (tcVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionH = com.bytedance.msdk.core.mk.d.d().h();
        if (functionH != null) {
            String strHc = hc(tcVar);
            String strHc2 = c.hc(tcVar.e());
            if (TextUtils.isEmpty(strHc)) {
                return false;
            }
            com.bykv.d.d.d.d.d dVarD = com.bykv.d.d.d.d.d.d();
            dVarD.d(8010, strHc);
            dVarD.d(8560, strHc2);
            dVarD.d(-99999987, 8229);
            dVarD.d(-99999985, Boolean.class);
            return ((Boolean) functionH.apply(dVarD.hc().sparseArray())).booleanValue();
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "load ad check class loader is null ");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String hc(com.bytedance.msdk.core.tc.tc r17) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.h.b.hc(com.bytedance.msdk.core.tc.tc):java.lang.String");
    }

    public static String d(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static tc d(String str, String str2, int i, int i2) {
        tc tcVar = new tc();
        tcVar.b(str2);
        tcVar.u(str);
        tcVar.tc(0);
        tcVar.an("0");
        tcVar.hc("1");
        tcVar.mk(i);
        tcVar.mq(i2);
        tcVar.tt(3);
        tcVar.d("%1$s%2$sAdapter");
        return tcVar;
    }

    private static boolean d(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    public static int c() {
        long jHc = zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).hc(b, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zD = d(new Date(jHc), new Date(jCurrentTimeMillis));
        zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).d(b, jCurrentTimeMillis);
        int iHc = (zD ? zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).hc(hc, 0) : 0) + 1;
        zw.d((String) null, com.bytedance.msdk.core.hc.getContext()).d(hc, iHc);
        return iHc;
    }

    public static void d(com.bytedance.msdk.api.d dVar, tc tcVar) {
        if (!com.bytedance.msdk.core.hc.hc().tr() || dVar == null || tcVar == null) {
            return;
        }
        if (820001 == dVar.d) {
            com.bytedance.msdk.api.c.d(com.bytedance.msdk.core.hc.getContext(), String.format("error_adn:%1$s no ads，please check ad network", tcVar.w()));
        } else {
            com.bytedance.msdk.api.c.d(com.bytedance.msdk.core.hc.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", tcVar.w(), tcVar.yo(), Integer.valueOf(dVar.b), dVar.c));
        }
    }

    public static void d(String str, tc tcVar, com.bytedance.msdk.hc.b bVar) {
        if (com.bytedance.msdk.core.hc.hc().tr() && tcVar != null && hc(str, bVar)) {
            com.bytedance.msdk.api.c.d(com.bytedance.msdk.core.hc.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", tcVar.e(), Integer.valueOf(tcVar.rf())));
        }
    }

    public static void d(String str, com.bytedance.msdk.hc.b bVar) {
        if (com.bytedance.msdk.core.hc.hc().tr() && bVar != null && hc(str, bVar)) {
            com.bytedance.msdk.api.c.d(com.bytedance.msdk.core.hc.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.hc.d.d(bVar.t()), bVar.ph()));
        }
    }

    private static boolean hc(String str, com.bytedance.msdk.hc.b bVar) {
        if (bVar == null) {
            return false;
        }
        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.core.hc.hc().d(str, bVar.el(), 101);
        return com.bytedance.msdk.core.hc.hc().hc(str, bVar.el()) && hcVarD != null && hcVarD.z() != null && hcVarD.z().size() > 0 && hcVarD.yi() != null && hcVarD.yi().size() > 0;
    }
}
