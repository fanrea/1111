package com.baidu.mobads.upgrade.remote.location;

import android.content.Context;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.x;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static final long a = 10000;
    private static final String b = "loc tiny String";
    private static Method e = null;
    private static Method f = null;
    private static Method g = null;
    private static Class<?> h = null;
    private static char[] j = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private TelephonyManager c;
    private C0145a d = new C0145a();
    private String i;

    public a(Context context, String str) {
        this.c = null;
        this.i = null;
        if (context != null) {
            this.i = com.alipay.sdk.m.s.a.n + str + "&null";
            try {
                this.c = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            } catch (Exception e2) {
                bq.a().a(e2.getMessage());
            }
        }
    }

    public String a() {
        if (!com.baidu.mobads.container.h.a.a().f()) {
            return "";
        }
        try {
            return a(10);
        } catch (Exception e2) {
            bq.a().a(e2.getMessage());
            return null;
        }
    }

    private String a(int i) {
        String strA;
        try {
            C0145a c0145aB = b();
            if (c0145aB == null || !c0145aB.b()) {
                a(this.c.getCellLocation());
            } else {
                bq.a().a("new cell api is valid = " + c0145aB.a());
                this.d = c0145aB;
            }
            strA = this.d.a();
        } catch (Exception e2) {
            bq.a().a(e2.getMessage());
            strA = null;
        }
        if (strA == null) {
            bq.a().a("cell info = null");
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
        return a(strA + "t" + System.currentTimeMillis() + this.i);
    }

    private void a(CellLocation cellLocation) {
        if (cellLocation == null || this.c == null) {
            return;
        }
        C0145a c0145a = new C0145a();
        String strF = x.a(null).f();
        if (strF != null && strF.length() > 0) {
            try {
                if (strF.length() >= 3) {
                    int iIntValue = Integer.valueOf(strF.substring(0, 3)).intValue();
                    if (iIntValue < 0) {
                        iIntValue = this.d.c;
                    }
                    c0145a.c = iIntValue;
                }
                String strSubstring = strF.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    int iIntValue2 = Integer.valueOf(strSubstring.substring(0, i)).intValue();
                    if (iIntValue2 < 0) {
                        iIntValue2 = this.d.d;
                    }
                    c0145a.d = iIntValue2;
                }
            } catch (Exception e2) {
                bq.a().a(e2.getMessage());
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            c0145a.a = gsmCellLocation.getLac();
            c0145a.b = gsmCellLocation.getCid();
            c0145a.e = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            c0145a.e = 'w';
            if (h == null) {
                try {
                    h = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    e = h.getMethod("getBaseStationId", new Class[0]);
                    f = h.getMethod("getNetworkId", new Class[0]);
                    g = h.getMethod("getSystemId", new Class[0]);
                } catch (Exception e3) {
                    h = null;
                    return;
                }
            }
            if (h != null && h.isInstance(cellLocation)) {
                try {
                    int iIntValue3 = ((Integer) g.invoke(cellLocation, new Object[0])).intValue();
                    if (iIntValue3 < 0) {
                        iIntValue3 = this.d.d;
                    }
                    c0145a.d = iIntValue3;
                    c0145a.b = ((Integer) e.invoke(cellLocation, new Object[0])).intValue();
                    c0145a.a = ((Integer) f.invoke(cellLocation, new Object[0])).intValue();
                } catch (Exception e4) {
                    return;
                }
            }
        }
        if (c0145a.b()) {
            this.d = c0145a;
        }
    }

    private C0145a b() {
        if (x.a(null).a() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.c.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            C0145a c0145aA = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered() && (c0145aA = a(cellInfo)) != null) {
                    if (!c0145aA.b()) {
                        return null;
                    }
                    return c0145aA;
                }
            }
            return c0145aA;
        } catch (Throwable th) {
            bq.a().a(th.getMessage());
            return null;
        }
    }

    private C0145a a(CellInfo cellInfo) {
        int iA = x.a(null).a();
        if (iA < 17) {
            return null;
        }
        C0145a c0145a = new C0145a();
        boolean z = true;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            c0145a.c = b(cellIdentity.getMcc());
            c0145a.d = b(cellIdentity.getMnc());
            c0145a.a = b(cellIdentity.getLac());
            c0145a.b = b(cellIdentity.getCid());
            c0145a.e = 'g';
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            c0145a.d = b(cellIdentity2.getSystemId());
            c0145a.a = b(cellIdentity2.getNetworkId());
            c0145a.b = b(cellIdentity2.getBasestationId());
            c0145a.e = 'w';
        } else if (!(cellInfo instanceof CellInfoLte)) {
            z = false;
        } else {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            c0145a.c = b(cellIdentity3.getMcc());
            c0145a.d = b(cellIdentity3.getMnc());
            c0145a.a = b(cellIdentity3.getTac());
            c0145a.b = b(cellIdentity3.getCi());
            c0145a.e = 'g';
        }
        if (iA >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c0145a.c = b(cellIdentity4.getMcc());
                    c0145a.d = b(cellIdentity4.getMnc());
                    c0145a.a = b(cellIdentity4.getLac());
                    c0145a.b = b(cellIdentity4.getCid());
                    c0145a.e = 'g';
                }
            } catch (Exception e2) {
                bq.a().a(e2.getMessage());
            }
        }
        return c0145a;
    }

    private int b(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* renamed from: com.baidu.mobads.upgrade.remote.location.a$a, reason: collision with other inner class name */
    private class C0145a {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;

        private C0145a() {
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = (char) 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return this.a > -1 && this.b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.e);
            stringBuffer.append("h");
            if (this.c != 460) {
                stringBuffer.append(this.c);
            }
            stringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)));
            return stringBuffer.toString();
        }
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte bNextInt = (byte) new Random().nextInt(255);
        byte bNextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ bNextInt);
            i++;
            i2++;
        }
        bArr[i2] = bNextInt;
        bArr[i2 + 1] = bNextInt2;
        return a(bArr);
    }

    private static String a(byte[] bArr) {
        boolean z;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 >= bArr.length) {
                z = false;
            } else {
                i3 |= bArr[i4] & 255;
                z = true;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 >= bArr.length) {
                z2 = false;
            } else {
                i5 |= bArr[i6] & 255;
            }
            int i7 = 64;
            cArr[i2 + 3] = j[z2 ? 63 - (i5 & 63) : 64];
            int i8 = i5 >> 6;
            int i9 = i2 + 2;
            char[] cArr2 = j;
            if (z) {
                i7 = 63 - (i8 & 63);
            }
            cArr[i9] = cArr2[i7];
            int i10 = i8 >> 6;
            cArr[i2 + 1] = j[63 - (i10 & 63)];
            cArr[i2 + 0] = j[63 - ((i10 >> 6) & 63)];
            i += 3;
            i2 += 4;
        }
        return new String(cArr);
    }
}
