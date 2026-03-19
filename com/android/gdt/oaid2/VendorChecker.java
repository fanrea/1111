package com.android.gdt.oaid2;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;
import com.android.gdt.qone.b.c;
import com.bytedance.common.utility.DeviceUtils;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class VendorChecker {
    public static final String BRAND;
    public static final VendorChecker HONOR_TYPE;
    public static final VendorChecker HS_TYPE;
    public static final VendorChecker HW_TYPE;
    public static final VendorChecker LX_TYPE;
    public static final String MANUFACTURER;
    public static final VendorChecker MSA_TYPE;
    public static final VendorChecker MZ_TYPE;
    public static final VendorChecker NB_TYPE;
    public static final VendorChecker OP_TYPE;
    public static final int OS_VERSION;
    public static final VendorChecker SX_TYPE;
    public static final VendorChecker UNSUPPORTED;
    public static final VendorChecker VV_TYPE;
    public static final VendorChecker XM_TYPE;
    public static final /* synthetic */ VendorChecker[] a;
    public final int index;

    static {
        VendorChecker vendorChecker = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.1
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                return TextUtils.isEmpty(VendorChecker.MANUFACTURER) && TextUtils.isEmpty(VendorChecker.BRAND);
            }
        };
        UNSUPPORTED = vendorChecker;
        VendorChecker vendorChecker2 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.2
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                String str = VendorChecker.MANUFACTURER;
                return (str.equalsIgnoreCase("XIAOMI") || VendorChecker.BRAND.equalsIgnoreCase("XIAOMI")) || (str.equalsIgnoreCase("REDMI") || VendorChecker.BRAND.equalsIgnoreCase("REDMI")) || (str.equalsIgnoreCase("BLACKSHARK") || VendorChecker.BRAND.equalsIgnoreCase("BLACKSHARK")) || str.equalsIgnoreCase("MEITU") || !TextUtils.isEmpty(c.a("ro.miui.ui.version.name"));
            }
        };
        XM_TYPE = vendorChecker2;
        VendorChecker vendorChecker3 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.3
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                return VendorChecker.MANUFACTURER.equalsIgnoreCase(DeviceUtils.ROM_VIVO) || VendorChecker.BRAND.equalsIgnoreCase(DeviceUtils.ROM_VIVO) || !TextUtils.isEmpty(c.a("ro.vivo.os.version"));
            }
        };
        VV_TYPE = vendorChecker3;
        VendorChecker vendorChecker4 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.4
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                String str = VendorChecker.MANUFACTURER;
                boolean z = str.equalsIgnoreCase("HUAWEI") || VendorChecker.BRAND.equalsIgnoreCase("HUAWEI");
                boolean z2 = str.equalsIgnoreCase("HONOR") || VendorChecker.BRAND.equalsIgnoreCase("HONOR");
                boolean z3 = VendorChecker.OS_VERSION < 31;
                boolean zIsEmpty = TextUtils.isEmpty(c.a(a.a));
                if (z || (z2 && z3)) {
                    return true;
                }
                return (zIsEmpty || z2) ? false : true;
            }
        };
        HW_TYPE = vendorChecker4;
        VendorChecker vendorChecker5 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.5
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                String str = VendorChecker.MANUFACTURER;
                return (str.equalsIgnoreCase(DeviceUtils.ROM_OPPO) || VendorChecker.BRAND.equalsIgnoreCase(DeviceUtils.ROM_OPPO) || !TextUtils.isEmpty(c.a("ro.build.version.opporom"))) || (str.equalsIgnoreCase("REALME") || VendorChecker.BRAND.equalsIgnoreCase("REALME")) || (str.equalsIgnoreCase("ONEPLUS") || VendorChecker.BRAND.equalsIgnoreCase("ONEPLUS"));
            }
        };
        OP_TYPE = vendorChecker5;
        VendorChecker vendorChecker6 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.6
            /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
            @Override // com.android.gdt.oaid2.VendorChecker
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean a() {
                /*
                    r5 = this;
                    java.lang.String r0 = com.android.gdt.oaid2.VendorChecker.MANUFACTURER
                    java.lang.String r1 = "LENOVO"
                    boolean r2 = r0.equalsIgnoreCase(r1)
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L1f
                    java.lang.String r2 = com.android.gdt.oaid2.VendorChecker.BRAND
                    boolean r1 = r2.equalsIgnoreCase(r1)
                    if (r1 != 0) goto L1f
                    java.lang.String r1 = "ZUK"
                    boolean r1 = r2.equalsIgnoreCase(r1)
                    if (r1 == 0) goto L1d
                    goto L1f
                L1d:
                    r1 = 0
                    goto L20
                L1f:
                    r1 = 1
                L20:
                    java.lang.String r2 = "MOTOROLA"
                    boolean r0 = r0.equalsIgnoreCase(r2)
                    if (r0 != 0) goto L33
                    java.lang.String r0 = com.android.gdt.oaid2.VendorChecker.BRAND
                    boolean r0 = r0.equalsIgnoreCase(r2)
                    if (r0 == 0) goto L31
                    goto L33
                L31:
                    r0 = 0
                    goto L34
                L33:
                    r0 = 1
                L34:
                    if (r1 != 0) goto L38
                    if (r0 == 0) goto L39
                L38:
                    r3 = 1
                L39:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.oaid2.VendorChecker.AnonymousClass6.a():boolean");
            }
        };
        LX_TYPE = vendorChecker6;
        VendorChecker vendorChecker7 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.7
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                return VendorChecker.MANUFACTURER.equalsIgnoreCase("ASUS") || VendorChecker.BRAND.equalsIgnoreCase("ASUS");
            }
        };
        HS_TYPE = vendorChecker7;
        VendorChecker vendorChecker8 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.8
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                return VendorChecker.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || VendorChecker.BRAND.equalsIgnoreCase("SAMSUNG");
            }
        };
        SX_TYPE = vendorChecker8;
        VendorChecker vendorChecker9 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.9
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                String str = VendorChecker.MANUFACTURER;
                return (str.equalsIgnoreCase("MEIZU") || VendorChecker.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains(DeviceUtils.ROM_FLYME)) || (str.equalsIgnoreCase("ALPS") || VendorChecker.BRAND.equalsIgnoreCase("ALPS"));
            }
        };
        MZ_TYPE = vendorChecker9;
        VendorChecker vendorChecker10 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.10
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                return VendorChecker.MANUFACTURER.equalsIgnoreCase("NUBIA") || VendorChecker.BRAND.equalsIgnoreCase("NUBIA");
            }
        };
        NB_TYPE = vendorChecker10;
        VendorChecker vendorChecker11 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.11
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                String str = VendorChecker.MANUFACTURER;
                return (str.equalsIgnoreCase("ZTE") || VendorChecker.BRAND.equalsIgnoreCase("ZTE")) || (!TextUtils.isEmpty(c.a("ro.build.freeme.label")) || str.equalsIgnoreCase("freemeos")) || str.equalsIgnoreCase("SSUI");
            }
        };
        MSA_TYPE = vendorChecker11;
        VendorChecker vendorChecker12 = new VendorChecker() { // from class: com.android.gdt.oaid2.VendorChecker.12
            @Override // com.android.gdt.oaid2.VendorChecker
            public final boolean a() {
                return VendorChecker.OS_VERSION >= 31 && (VendorChecker.MANUFACTURER.equalsIgnoreCase("HONOR") || VendorChecker.BRAND.equalsIgnoreCase("HONOR"));
            }
        };
        HONOR_TYPE = vendorChecker12;
        a = new VendorChecker[]{vendorChecker, vendorChecker2, vendorChecker3, vendorChecker4, vendorChecker5, vendorChecker6, vendorChecker7, vendorChecker8, vendorChecker9, vendorChecker10, vendorChecker11, vendorChecker12};
        String str = Build.BRAND;
        BRAND = TextUtils.isEmpty(str) ? "" : str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = TextUtils.isEmpty(str2) ? "" : str2;
        OS_VERSION = Build.VERSION.SDK_INT;
    }

    public VendorChecker(String str, int i, int i2) {
        this.index = i2;
    }

    public static VendorChecker valueOf(String str) {
        return (VendorChecker) Enum.valueOf(VendorChecker.class, str);
    }

    public static VendorChecker[] values() {
        return (VendorChecker[]) a.clone();
    }

    public abstract boolean a();
}
