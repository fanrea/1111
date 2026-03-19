package com.sigmob.sdk.videoAd;

import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends AdTracker implements Serializable, Comparable<d> {
    private static final long serialVersionUID = 0;
    private final float a;

    public d(final String event, float trackingFraction) {
        super(AdTracker.MessageType.QUARTILE_EVENT, (String) null, event, (String) null);
        Preconditions.NoThrow.checkArgument(trackingFraction >= 0.0f);
        this.a = trackingFraction;
    }

    private float a() {
        return this.a;
    }

    public static List<d> a(List<d> fractionalTrackers, String event, long currentPosition, long duration) {
        if (duration <= 0 || currentPosition < 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        d dVar = new d(event, currentPosition / duration);
        int size = fractionalTrackers.size();
        for (int i = 0; i < size; i++) {
            d dVar2 = fractionalTrackers.get(i);
            if (dVar2.compareTo(dVar) > 0) {
                break;
            }
            if (!dVar2.isTracked()) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(final d other) {
        return Double.compare(a(), other.a());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", Float.valueOf(this.a), getUrl());
    }
}
