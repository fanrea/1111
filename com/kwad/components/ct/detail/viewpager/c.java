package com.kwad.components.ct.detail.viewpager;

import android.database.DataSetObserver;
import com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends b {
    private final DataSetObserver azP;
    private int mStartIndex;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return 10000;
    }

    public c(KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.mStartIndex = 5000;
        this.azP = new DataSetObserver() { // from class: com.kwad.components.ct.detail.viewpager.c.1
            @Override // android.database.DataSetObserver
            public final void onChanged() {
                super.onChanged();
                com.kwad.sdk.core.d.c.d("SlidePlaySmoothUpdatePagerAdapter", "onChanged");
                c.this.azN = -1;
                c.this.azM = -1;
                c.this.amK.a(SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_SCROLL_END);
            }
        };
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final void a(SlidePlayViewPager slidePlayViewPager) {
        super.a(slidePlayViewPager);
        slidePlayViewPager.a(this.azP);
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final void a(List<CtAdTemplate> list, CtAdTemplate ctAdTemplate, CtAdTemplate ctAdTemplate2, int i, int i2) {
        boolean z;
        super.a(list, ctAdTemplate, ctAdTemplate2, i, i2);
        if (list == null || list.size() < 2 || ctAdTemplate == null || ctAdTemplate2 == null || ctAdTemplate == ctAdTemplate2) {
            return;
        }
        synchronized (this.azJ) {
            int iIndexOf = list.indexOf(ctAdTemplate);
            int iIndexOf2 = list.indexOf(ctAdTemplate2);
            com.kwad.sdk.core.d.c.d("SlidePlaySmoothUpdatePagerAdapter", "changePosition index1: " + iIndexOf + ", index2: " + iIndexOf2 + " , offset1: " + i + ", offset2: " + i2);
            if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                int i3 = iIndexOf + i;
                int i4 = iIndexOf2 + i2;
                if (i3 >= 0 && i3 < list.size() && i4 >= 0 && i4 < list.size() && i3 != i4) {
                    if (i != 0) {
                        ctAdTemplate = list.get(i3);
                    }
                    if (i2 != 0) {
                        ctAdTemplate2 = list.get(i4);
                    }
                    list.set(i3, ctAdTemplate2);
                    list.set(i4, ctAdTemplate);
                    com.kwad.sdk.core.d.c.d("SlidePlaySmoothUpdatePagerAdapter", "changePosition success index1: " + i3 + ", index2: " + i4);
                    this.azJ.clear();
                    this.azJ.addAll(list);
                    z = true;
                } else {
                    com.kwad.sdk.core.d.c.d("SlidePlaySmoothUpdatePagerAdapter", "changePosition failed index1: " + i3 + ", index2: " + i4);
                    z = false;
                }
                if (z) {
                    this.azN = -2;
                    this.azM = this.amK.getCurrentItem();
                    notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[Catch: all -> 0x00e2, TryCatch #0 {, blocks: (B:10:0x0011, B:15:0x0027, B:19:0x0063, B:22:0x0072, B:24:0x007d, B:25:0x0087, B:14:0x0023, B:23:0x0079), top: B:40:0x0011 }] */
    @Override // com.kwad.components.ct.detail.viewpager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.util.List<com.kwad.components.ct.response.model.CtAdTemplate> r5, com.kwad.components.ct.response.model.CtAdTemplate r6, int r7, int r8, boolean r9) {
        /*
            r4 = this;
            r4.azO = r7
            if (r5 == 0) goto Le5
            boolean r7 = r5.isEmpty()
            if (r7 == 0) goto Lc
            goto Le5
        Lc:
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r7 = r4.azJ
            monitor-enter(r7)
            if (r6 == 0) goto L79
            com.kwad.components.ct.detail.viewpager.SlidePlayViewPager r0 = r4.amK     // Catch: java.lang.Throwable -> Le2
            int r0 = r0.getCurrentItem()     // Catch: java.lang.Throwable -> Le2
            int r0 = r4.bO(r0)     // Catch: java.lang.Throwable -> Le2
            int r1 = r4.azO     // Catch: java.lang.Throwable -> Le2
            if (r1 != 0) goto L23
            if (r8 < 0) goto L23
            r6 = r8
            goto L27
        L23:
            int r6 = r5.indexOf(r6)     // Catch: java.lang.Throwable -> Le2
        L27:
            java.lang.String r1 = "SlidePlaySmoothUpdatePagerAdapter"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le2
            java.lang.String r3 = "mStartIndex="
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Le2
            int r3 = r4.mStartIndex     // Catch: java.lang.Throwable -> Le2
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r3 = "--beforeUpdatedIndex="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Le2
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r3 = "--afterUpdatedIndex"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Le2
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r3 = "--feedReplacedIndex="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Le2
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r2 = "--mSourceType="
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch: java.lang.Throwable -> Le2
            int r2 = r4.azO     // Catch: java.lang.Throwable -> Le2
            if (r2 != 0) goto L61
            java.lang.String r2 = "FEED"
            goto L63
        L61:
            java.lang.String r2 = "PROFILE"
        L63:
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Le2
            com.kwad.sdk.core.d.c.d(r1, r8)     // Catch: java.lang.Throwable -> Le2
            if (r0 < 0) goto L79
            if (r6 < 0) goto L79
            int r8 = r4.mStartIndex     // Catch: java.lang.Throwable -> Le2
            int r0 = r0 - r6
            int r8 = r8 + r0
            r4.mStartIndex = r8     // Catch: java.lang.Throwable -> Le2
            goto L7d
        L79:
            r6 = 5000(0x1388, float:7.006E-42)
            r4.mStartIndex = r6     // Catch: java.lang.Throwable -> Le2
        L7d:
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r6 = r4.azJ     // Catch: java.lang.Throwable -> Le2
            r6.clear()     // Catch: java.lang.Throwable -> Le2
            com.kwad.sdk.lib.widget.b<com.kwad.components.ct.response.model.CtAdTemplate> r6 = r4.azJ     // Catch: java.lang.Throwable -> Le2
            r6.addAll(r5)     // Catch: java.lang.Throwable -> Le2
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le2
            int r5 = r4.azO
            r6 = 1
            if (r5 != r6) goto Lbb
            com.kwad.components.ct.detail.viewpager.SlidePlayViewPager r5 = r4.amK
            int r5 = r5.getCurrentItem()
            int r5 = r4.bO(r5)
            com.kwad.components.ct.response.model.CtAdTemplate r5 = r4.bU(r5)
            if (r5 != 0) goto Lbb
            com.kwad.components.ct.detail.viewpager.SlidePlayViewPager r5 = r4.amK
            int r5 = r5.getCurrentItem()
            r4.mStartIndex = r5
            java.lang.String r5 = "SlidePlaySmoothUpdatePagerAdapter"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "correct mStartIndex:"
            r6.<init>(r7)
            int r7 = r4.mStartIndex
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.kwad.sdk.core.d.c.d(r5, r6)
        Lbb:
            r5 = -2
            r4.azN = r5
            if (r9 != 0) goto Lc8
            com.kwad.components.ct.detail.viewpager.SlidePlayViewPager r5 = r4.amK
            int r5 = r5.getCurrentItem()
            r4.azM = r5
        Lc8:
            java.lang.String r5 = "SlidePlaySmoothUpdatePagerAdapter"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "replaceFeed notifyDataSetChanged mStartIndex:"
            r6.<init>(r7)
            int r7 = r4.mStartIndex
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.kwad.sdk.core.d.c.d(r5, r6)
            r4.notifyDataSetChanged()
            return
        Le2:
            r5 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le2
            throw r5
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.c.a(java.util.List, com.kwad.components.ct.response.model.CtAdTemplate, int, int, boolean):void");
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int bO(int i) {
        return i - this.mStartIndex;
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int bP(int i) {
        return i + this.mStartIndex;
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final void bQ(int i) {
        super.bQ(i);
        this.mStartIndex += i;
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int getFirstValidItemPosition() {
        return this.mStartIndex;
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final int getLastValidItemPosition() {
        return (getFirstValidItemPosition() + CR()) - 1;
    }

    @Override // com.kwad.components.ct.detail.viewpager.b
    public final void bF(boolean z) {
        super.bF(z);
        this.amK.b(this.azP);
    }
}
