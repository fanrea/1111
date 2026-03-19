package com.luck.picture.lib.basic;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.R;
import com.luck.picture.lib.utils.ActivityCompatHelper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FragmentInjectManager {
    public static void injectFragment(FragmentActivity fragmentActivity, String str, Fragment fragment) {
        if (ActivityCompatHelper.checkFragmentNonExits(fragmentActivity, str)) {
            fragmentActivity.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, str).addToBackStack(str).commitAllowingStateLoss();
        }
    }

    public static void injectSystemRoomFragment(FragmentManager fragmentManager, String str, Fragment fragment) {
        fragmentManager.beginTransaction().add(android.R.id.content, fragment, str).addToBackStack(str).commitAllowingStateLoss();
    }
}
