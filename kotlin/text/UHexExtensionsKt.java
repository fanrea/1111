package kotlin.text;

import com.kwai.video.player.KsMediaMeta;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UHexExtensions.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a2\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"hexToUByte", "Lkotlin/UByte;", "", KsMediaMeta.KSM_KEY_FORMAT, "Lkotlin/text/HexFormat;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "hexToUByteArray", "Lkotlin/UByteArray;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "hexToUInt", "Lkotlin/UInt;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "hexToULong", "Lkotlin/ULong;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "hexToUShort", "Lkotlin/UShort;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "toHexString", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class UHexExtensionsKt {
    /* renamed from: toHexString-zHuV2wU, reason: not valid java name */
    private static final String m1787toHexStringzHuV2wU(byte[] bArr, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toHexString");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(bArr, hexFormat);
    }

    /* renamed from: toHexString-zHuV2wU$default, reason: not valid java name */
    static /* synthetic */ String m1788toHexStringzHuV2wU$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(bArr, "$this$toHexString");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(bArr, hexFormat);
    }

    /* renamed from: toHexString-lZCiFrA$default, reason: not valid java name */
    static /* synthetic */ String m1784toHexStringlZCiFrA$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.getSize-impl(bArr);
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(bArr, "$this$toHexString");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(bArr, i, i2, hexFormat);
    }

    /* renamed from: toHexString-lZCiFrA, reason: not valid java name */
    private static final String m1783toHexStringlZCiFrA(byte[] bArr, int i, int i2, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toHexString");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(bArr, i, i2, hexFormat);
    }

    static /* synthetic */ byte[] hexToUByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UByteArray.constructor-impl(HexExtensionsKt.hexToByteArray(str, hexFormat));
    }

    private static final byte[] hexToUByteArray(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UByteArray.constructor-impl(HexExtensionsKt.hexToByteArray(str, hexFormat));
    }

    /* renamed from: toHexString-ZQbaR00, reason: not valid java name */
    private static final String m1781toHexStringZQbaR00(byte b, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(b, hexFormat);
    }

    /* renamed from: toHexString-ZQbaR00$default, reason: not valid java name */
    static /* synthetic */ String m1782toHexStringZQbaR00$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(b, hexFormat);
    }

    private static final byte hexToUByte(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UByte.constructor-impl(HexExtensionsKt.hexToByte(str, hexFormat));
    }

    static /* synthetic */ byte hexToUByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UByte.constructor-impl(HexExtensionsKt.hexToByte(str, hexFormat));
    }

    /* renamed from: toHexString-r3ox_E0, reason: not valid java name */
    private static final String m1785toHexStringr3ox_E0(short s, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(s, hexFormat);
    }

    /* renamed from: toHexString-r3ox_E0$default, reason: not valid java name */
    static /* synthetic */ String m1786toHexStringr3ox_E0$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(s, hexFormat);
    }

    private static final short hexToUShort(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UShort.constructor-impl(HexExtensionsKt.hexToShort(str, hexFormat));
    }

    static /* synthetic */ short hexToUShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UShort.constructor-impl(HexExtensionsKt.hexToShort(str, hexFormat));
    }

    /* renamed from: toHexString-8M7LxHw, reason: not valid java name */
    private static final String m1777toHexString8M7LxHw(int i, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(i, hexFormat);
    }

    /* renamed from: toHexString-8M7LxHw$default, reason: not valid java name */
    static /* synthetic */ String m1778toHexString8M7LxHw$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(i, hexFormat);
    }

    private static final int hexToUInt(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UInt.constructor-impl(HexExtensionsKt.hexToInt(str, hexFormat));
    }

    static /* synthetic */ int hexToUInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return UInt.constructor-impl(HexExtensionsKt.hexToInt(str, hexFormat));
    }

    /* renamed from: toHexString-8UJCm-I, reason: not valid java name */
    private static final String m1779toHexString8UJCmI(long j, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(j, hexFormat);
    }

    /* renamed from: toHexString-8UJCm-I$default, reason: not valid java name */
    static /* synthetic */ String m1780toHexString8UJCmI$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return HexExtensionsKt.toHexString(j, hexFormat);
    }

    private static final long hexToULong(String str, HexFormat hexFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return ULong.constructor-impl(HexExtensionsKt.hexToLong(str, hexFormat));
    }

    static /* synthetic */ long hexToULong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(hexFormat, KsMediaMeta.KSM_KEY_FORMAT);
        return ULong.constructor-impl(HexExtensionsKt.hexToLong(str, hexFormat));
    }
}
