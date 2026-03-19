package com.kwai.kanas.interfaces;

import com.kwai.kanas.interfaces.d;
import com.kwai.kanas.location.Location;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.function.Supplier;
import com.kwai.middleware.azeroth.utils.ArrayUtils;
import com.kwai.middleware.azeroth.utils.DeviceIDUtil;
import com.kwai.middleware.azeroth.utils.Utils;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class KanasConfig {
    private static final int a = 1;

    public abstract String deviceId();

    public abstract List<String> hosts();

    public abstract Supplier<Location> location();

    public abstract KanasLogger logger();

    public abstract long newSessionBkgIntervalMs();

    public abstract Supplier<String> oaid();

    public abstract int platform();

    public abstract Builder toBuilder();

    public abstract boolean useRealMetrics();

    public static Builder builder() {
        return new d.a().platform(1).logger(new KanasLogger() { // from class: com.kwai.kanas.interfaces.KanasConfig.2
        }).hosts(ArrayUtils.asArrayList("open.kuaishouzt.com", "open.kwaizt.com")).deviceId(DeviceIDUtil.getDeviceId(Azeroth.get().getContext())).newSessionBkgIntervalMs(TimeUnit.MILLISECONDS.convert(30L, TimeUnit.SECONDS)).useRealMetrics(false).location(new Supplier<Location>() { // from class: com.kwai.kanas.interfaces.KanasConfig.1
            @Override // com.kwai.middleware.azeroth.function.Supplier
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Location get() {
                return new Location();
            }
        });
    }

    public static abstract class Builder {
        abstract KanasConfig a();

        public abstract Builder deviceId(String str);

        public abstract Builder hosts(List<String> list);

        public abstract Builder location(Supplier<Location> supplier);

        public abstract Builder logger(KanasLogger kanasLogger);

        public abstract Builder newSessionBkgIntervalMs(long j);

        public abstract Builder oaid(Supplier<String> supplier);

        public abstract Builder platform(int i);

        public abstract Builder useRealMetrics(boolean z);

        public KanasConfig build() {
            KanasConfig kanasConfigA = a();
            Utils.checkAllNotNullOrEmpty(kanasConfigA.logger(), kanasConfigA.hosts());
            boolean[] zArr = new boolean[1];
            zArr[0] = kanasConfigA.newSessionBkgIntervalMs() > 0;
            Utils.checkAllArgument(zArr);
            return kanasConfigA;
        }
    }
}
