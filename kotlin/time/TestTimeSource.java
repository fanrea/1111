package kotlin.time;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;

/* compiled from: TimeSources.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1940plusAssignLRDsOJo(long duration) {
        long jM1850toLongimpl = Duration.m1850toLongimpl(duration, getUnit());
        if (!(((jM1850toLongimpl - 1) | 1) == LocationRequestCompat.PASSIVE_INTERVAL)) {
            long j = this.reading;
            long j2 = j + jM1850toLongimpl;
            if ((jM1850toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m1939overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM1807divUwyO8pc = Duration.m1807divUwyO8pc(duration, 2);
        if (!((1 | (Duration.m1850toLongimpl(jM1807divUwyO8pc, getUnit()) - 1)) == LocationRequestCompat.PASSIVE_INTERVAL)) {
            long j3 = this.reading;
            try {
                m1940plusAssignLRDsOJo(jM1807divUwyO8pc);
                m1940plusAssignLRDsOJo(Duration.m1839minusLRDsOJo(duration, jM1807divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j3;
                throw e;
            }
        }
        m1939overflowLRDsOJo(duration);
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1939overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1853toStringimpl(duration)) + '.');
    }
}
