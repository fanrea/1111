package kotlin.time;

import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.p0.b;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* compiled from: longSaturatedMath.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", b.d, "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", LiveConfigKey.ORIGIN, "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == LocationRequestCompat.PASSIVE_INTERVAL;
    }

    /* renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m1933saturatingAddNuflL3o(long j, DurationUnit durationUnit, long j2) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        long jM1850toLongimpl = Duration.m1850toLongimpl(j2, durationUnit);
        if (((j - 1) | 1) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return m1932checkInfiniteSumDefinedPjuGub4(j, j2, jM1850toLongimpl);
        }
        if ((1 | (jM1850toLongimpl - 1)) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return m1934saturatingAddInHalvesNuflL3o(j, durationUnit, j2);
        }
        long j3 = j + jM1850toLongimpl;
        if (((j ^ j3) & (jM1850toLongimpl ^ j3)) >= 0) {
            return j3;
        }
        if (j < 0) {
            return Long.MIN_VALUE;
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    /* renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1932checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m1836isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m1934saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long jM1807divUwyO8pc = Duration.m1807divUwyO8pc(j2, 2);
        long jM1850toLongimpl = Duration.m1850toLongimpl(jM1807divUwyO8pc, durationUnit);
        return ((1 | (jM1850toLongimpl - 1)) > LocationRequestCompat.PASSIVE_INTERVAL ? 1 : ((1 | (jM1850toLongimpl - 1)) == LocationRequestCompat.PASSIVE_INTERVAL ? 0 : -1)) == 0 ? jM1850toLongimpl : m1933saturatingAddNuflL3o(m1933saturatingAddNuflL3o(j, durationUnit, jM1807divUwyO8pc), durationUnit, Duration.m1839minusLRDsOJo(j2, jM1807divUwyO8pc));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.INSTANCE.m1906getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.INSTANCE.m1905getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if ((1 | (j2 - 1)) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return Duration.m1857unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return saturatingFiniteDiff(j, j2, durationUnit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "unit");
        if (((j2 - 1) | 1) == LocationRequestCompat.PASSIVE_INTERVAL) {
            if (j == j2) {
                return Duration.INSTANCE.m1907getZEROUwyO8pc();
            }
            return Duration.m1857unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        if ((1 | (j - 1)) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return infinityOfSign(j);
        }
        return saturatingFiniteDiff(j, j2, durationUnit);
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            if (durationUnit.compareTo(DurationUnit.MILLISECONDS) < 0) {
                long jConvertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, durationUnit);
                long j4 = (j / jConvertDurationUnit) - (j2 / jConvertDurationUnit);
                long j5 = (j % jConvertDurationUnit) - (j2 % jConvertDurationUnit);
                Duration.Companion companion = Duration.INSTANCE;
                return Duration.m1840plusLRDsOJo(DurationKt.toDuration(j4, DurationUnit.MILLISECONDS), DurationKt.toDuration(j5, durationUnit));
            }
            return Duration.m1857unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnit);
    }
}
