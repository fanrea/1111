package com.netease.htprotect.p010Ooo.p012O8;

import androidx.core.app.NotificationCompat;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.C00oOOo;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O8oO888;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.o0O0O;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.o0o0;
import com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.oO;
import com.netease.htprotect.p010Ooo.p017oO.O;
import com.netease.htprotect.p010Ooo.p017oO.O8;
import com.sigmob.sdk.base.mta.PointCategory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.netease.htprotect.〇Ooo.〇O8.〇Ooo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ooo {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final Set f264O8oO888 = new HashSet(Arrays.asList("screenOrientation", "configChanges", "windowSoftInputMode", "launchMode", "installLocation", "protectionLevel"));
    private final Oo0 Oo0;

    /* renamed from: 〇O, reason: contains not printable characters */
    private Locale f265O = O8.f522O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private String[] f266O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p014o0o0.Oo0 f267Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private ByteBuffer f268o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private o0O0O f269oO;

    public Ooo(ByteBuffer byteBuffer, Oo0 oo0) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        this.f268o0o0 = byteBufferDuplicate;
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        this.Oo0 = oo0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m740O8oO888(String str, String str2) throws NumberFormatException {
        int i;
        StringBuilder sb;
        String str3;
        i = Integer.parseInt(str2);
        str.hashCode();
        switch (str) {
            case "windowSoftInputMode":
                int i2 = i & 240;
                int i3 = i & 15;
                ArrayList arrayList = new ArrayList(2);
                if (i2 != 0) {
                    arrayList.add(i2 != 16 ? i2 != 32 ? i2 != 48 ? "WindowInputModeAdjust:" + Integer.toHexString(i2) : "adjustNothing" : "adjustPan" : "adjustResize");
                }
                if (i3 != 0) {
                    arrayList.add(i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "WindowInputModeState:" + Integer.toHexString(i3) : "stateAlwaysVisible" : "stateVisible" : "stateAlwaysHidden" : "stateHidden" : "stateUnchanged");
                }
                return O.m1053O8oO888((Iterable) arrayList, "|");
            case "installLocation":
                if (i == 0) {
                    return "auto";
                }
                if (i == 1) {
                    return "internalOnly";
                }
                if (i == 2) {
                    return "preferExternal";
                }
                sb = new StringBuilder("installLocation:");
                break;
            case "configChanges":
                ArrayList arrayList2 = new ArrayList();
                if ((i & 4096) != 0) {
                    str3 = "density";
                } else if ((1073741824 & i) != 0) {
                    str3 = "fontScale";
                } else if ((i & 16) != 0) {
                    str3 = "keyboard";
                } else if ((i & 32) != 0) {
                    str3 = "keyboardHidden";
                } else if ((i & 8192) != 0) {
                    str3 = "direction";
                } else if ((i & 4) != 0) {
                    str3 = "locale";
                } else if ((i & 1) != 0) {
                    str3 = "mcc";
                } else if ((i & 2) != 0) {
                    str3 = "mnc";
                } else if ((i & 64) != 0) {
                    str3 = NotificationCompat.CATEGORY_NAVIGATION;
                } else if ((i & 128) != 0) {
                    str3 = "orientation";
                } else if ((i & 256) != 0) {
                    str3 = "screenLayout";
                } else if ((i & 1024) != 0) {
                    str3 = "screenSize";
                } else if ((i & 2048) != 0) {
                    str3 = "smallestScreenSize";
                } else {
                    if ((i & 8) == 0) {
                        if ((i & 512) != 0) {
                            str3 = "uiMode";
                        }
                        return O.m1053O8oO888((Iterable) arrayList2, "|");
                    }
                    str3 = "touchscreen";
                }
                arrayList2.add(str3);
                return O.m1053O8oO888((Iterable) arrayList2, "|");
            case "screenOrientation":
                switch (i) {
                    case -1:
                        return "unspecified";
                    case 0:
                        return NativeRewardActivity.SCREEN_LANDSCAPE;
                    case 1:
                        return NativeRewardActivity.SCREEN_PORTRAIT;
                    case 2:
                        return "user";
                    case 3:
                        return "behind";
                    case 4:
                        return "sensor";
                    case 5:
                        return "nosensor";
                    case 6:
                        return "sensorLandscape";
                    case 7:
                        return "sensorPortrait";
                    case 8:
                        return "reverseLandscape";
                    case 9:
                        return "reversePortrait";
                    case 10:
                        return "fullSensor";
                    case 11:
                        return "userLandscape";
                    case 12:
                        return "userPortrait";
                    case 13:
                        return "fullUser";
                    case 14:
                        return PointCategory.LOCKED;
                    default:
                        sb = new StringBuilder("ScreenOrientation:");
                        break;
                }
            case "launchMode":
                if (i == 0) {
                    return "standard";
                }
                if (i == 1) {
                    return "singleTop";
                }
                if (i == 2) {
                    return "singleTask";
                }
                if (i == 3) {
                    return "singleInstance";
                }
                sb = new StringBuilder("LaunchMode:");
                break;
            case "protectionLevel":
                ArrayList arrayList3 = new ArrayList(3);
                if ((i & 16) != 0) {
                    i ^= 16;
                    arrayList3.add("system");
                }
                if ((i & 32) != 0) {
                    i ^= 32;
                    arrayList3.add("development");
                }
                arrayList3.add(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "ProtectionLevel:" + Integer.toHexString(i) : "signatureOrSystem" : "signature" : "dangerous" : "normal");
                return O.m1053O8oO888((Iterable) arrayList3, "|");
            default:
                return str2;
        }
        return sb.append(Integer.toHexString(i)).toString();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private long[] m741O8oO888(C00oOOo c00oOOo) {
        int i = c00oOOo.m969O8oO888() / 4;
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0);
        }
        return jArr;
    }

    private com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.Oo0 Oo0() {
        int i = this.f268o0o0.getInt();
        int i2 = this.f268o0o0.getInt();
        com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.Oo0 oo0 = new com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.Oo0();
        if (i > 0) {
            oo0.m985O8oO888(this.f267Ooo.m954O8oO888(i));
        }
        if (i2 > 0) {
            oo0.m987Ooo(this.f267Ooo.m954O8oO888(i2));
        }
        return oo0;
    }

    /* renamed from: 〇00oOOo, reason: contains not printable characters */
    private o0O0O m74200oOOo() {
        return this.f269oO;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private oO m743O() {
        int i = this.f268o0o0.getInt();
        int i2 = this.f268o0o0.getInt();
        oO oOVar = new oO();
        if (i > 0) {
            oOVar.m1007O8oO888(this.f267Ooo.m954O8oO888(i));
        }
        if (i2 > 0) {
            oOVar.m1009Ooo(this.f267Ooo.m954O8oO888(i2));
        }
        return oOVar;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O m744O8() {
        com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O o = new com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O();
        int i = this.f268o0o0.getInt();
        int i2 = this.f268o0o0.getInt();
        if (i > 0) {
            o.m989O8oO888(this.f267Ooo.m954O8oO888(i));
        }
        o.m991Ooo(this.f267Ooo.m954O8oO888(i2));
        o0O0O o0o0o = this.f269oO;
        if (o0o0o != null) {
            o0o0o.mo733O8oO888(o);
        }
        return o;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O8 m745Ooo() {
        com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O8 o8 = new com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.O8();
        int i = this.f268o0o0.getInt();
        if (i > 0) {
            o8.m998O8oO888(this.f267Ooo.m954O8oO888(i));
        }
        o8.m997O8oO888(com.netease.htprotect.p010Ooo.p017oO.oO.m1073O8oO888(this.f268o0o0, this.f267Ooo));
        return o8;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.netease.htprotect.p010Ooo.p014o0o0.p016Ooo.C0681 m746o0o0() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.p010Ooo.p012O8.Ooo.m746o0o0():com.netease.htprotect.〇Ooo.〇o0〇o0.〇Ooo.〇〇");
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private O8oO888 m747oO() {
        String[] strArr;
        int i = this.f268o0o0.getInt();
        int i2 = this.f268o0o0.getInt();
        O8oO888 o8oO888 = new O8oO888();
        if (i > 0) {
            o8oO888.m977O8oO888(this.f267Ooo.m954O8oO888(i));
        }
        o8oO888.m981Ooo(this.f267Ooo.m954O8oO888(i2));
        if (o8oO888.m980Ooo().isEmpty() && (strArr = this.f266O8) != null && i2 < strArr.length) {
            o8oO888.m981Ooo(strArr[i2]);
        }
        int i3 = this.f268o0o0.getInt();
        if (i3 > 0) {
            o8oO888.m979O8(this.f267Ooo.m954O8oO888(i3));
        }
        o8oO888.m976O8oO888(com.netease.htprotect.p010Ooo.p017oO.oO.m1073O8oO888(this.f268o0o0, this.f267Ooo));
        return o8oO888;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private com.netease.htprotect.p010Ooo.p014o0o0.Ooo m748o0O0O() throws com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888 {
        com.netease.htprotect.p010Ooo.p014o0o0.O o;
        if (!this.f268o0o0.hasRemaining()) {
            return null;
        }
        long jPosition = this.f268o0o0.position();
        int i = this.f268o0o0.getShort() & 65535;
        int i2 = 65535 & this.f268o0o0.getShort();
        long jM1066Ooo = com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0);
        if (i == 1) {
            com.netease.htprotect.p010Ooo.p014o0o0.O o2 = new com.netease.htprotect.p010Ooo.p014o0o0.O(i, i2, jM1066Ooo);
            o2.m958O8oO888(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
            o2.m960Ooo(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
            o2.m959O8(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
            o2.m962o0o0(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
            o2.m964oO(com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
            o = o2;
        } else {
            if (i == 3) {
                return new o0o0(i, i2, jM1066Ooo);
            }
            if (i == 384) {
                this.f268o0o0.position((int) (jPosition + i2));
                return new C00oOOo(i, i2, jM1066Ooo);
            }
            switch (i) {
                case 256:
                case 257:
                case 258:
                case 259:
                case 260:
                    o0O0O o0o0o = new o0O0O(i, i2, jM1066Ooo);
                    o0o0o.m1012O8oO888((int) com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
                    o0o0o.m1013Ooo((int) com.netease.htprotect.p010Ooo.p017oO.Ooo.m1066Ooo(this.f268o0o0));
                    o = o0o0o;
                    break;
                default:
                    throw new com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888("Unexpected chunk type:".concat(String.valueOf(i)));
            }
        }
        this.f268o0o0.position((int) (jPosition + i2));
        return o;
    }

    /* renamed from: 〇〇, reason: contains not printable characters */
    private Locale m749() {
        return this.f265O;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0169 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x013e -> B:56:0x014a). Please report as a decompilation issue!!! */
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m750O8oO888() throws com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.p010Ooo.p012O8.Ooo.m750O8oO888():void");
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m751O8oO888(o0O0O o0o0o) {
        this.f269oO = o0o0o;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m752O8oO888(Locale locale) {
        if (locale != null) {
            this.f265O = locale;
        }
    }
}
