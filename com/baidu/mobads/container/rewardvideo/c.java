package com.baidu.mobads.container.rewardvideo;

import android.widget.Toast;
import com.style.widget.viewpager2.ViewPager2;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements ViewPager2.OnOverScrollListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // com.style.widget.viewpager2.ViewPager2.OnOverScrollListener
    public void onOverScrollStart() {
    }

    @Override // com.style.widget.viewpager2.ViewPager2.OnOverScrollListener
    public void onOverScrollEnd() {
        String str;
        if (this.a.j) {
            str = "已经是最后一张图片了哦";
        } else {
            str = "已经是最后一条视频了哦";
        }
        Toast.makeText(this.a.g, str, 0).show();
    }
}
