package com.baidu.mobads.container.rewardvideo;

import com.style.widget.viewpager2.ViewPager2;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        Iterator it = this.a.d.iterator();
        while (it.hasNext()) {
            ((dk) it.next()).a(i);
        }
    }
}
