package com.luck.picture.lib.basic;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface IBridgeViewLifecycle {
    void onDestroy(Fragment fragment);

    void onViewCreated(Fragment fragment, View view, Bundle bundle);
}
