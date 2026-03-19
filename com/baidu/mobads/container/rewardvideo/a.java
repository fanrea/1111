package com.baidu.mobads.container.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.style.widget.viewpager2.State;
import com.style.widget.viewpager2.ViewPager2;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements IActivityImpl {
    private static final String a = "MultiReward";
    private final com.baidu.mobads.container.adrequest.t b;
    private final List<com.baidu.mobads.container.adrequest.ac> c = new ArrayList();
    private final List<dk> d = new ArrayList();
    private Activity e;
    private RelativeLayout f;
    private Context g;
    private ViewPager2 h;
    private NativeRewardActivity i;
    private boolean j;
    private boolean k;

    public a(com.baidu.mobads.container.adrequest.o oVar, List<com.baidu.mobads.container.adrequest.j> list) {
        this.j = false;
        this.k = true;
        this.b = oVar;
        if (list.size() > 0) {
            com.baidu.mobads.container.adrequest.j jVar = list.get(0);
            this.j = "image".equals(jVar.getMaterialType());
            this.k = jVar.getOriginJsonObject().optInt("multirewards", 1) != 0;
        }
        Iterator<com.baidu.mobads.container.adrequest.j> it = list.iterator();
        while (it.hasNext()) {
            this.c.add(new com.baidu.mobads.container.adrequest.ac(oVar, it.next()));
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        this.e = activity;
        if (this.b != null) {
            this.b.a(this.e);
        }
        Iterator<com.baidu.mobads.container.adrequest.ac> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(activity);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String stringExtra;
        Intent intent;
        this.g = this.e.getApplicationContext();
        NativeRewardActivity.initScreenConfiguration(this.e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f = new RelativeLayout(this.g);
        if (this.e != null && (intent = this.e.getIntent()) != null) {
            stringExtra = intent.getStringExtra("orientation");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = NativeRewardActivity.SCREEN_PORTRAIT;
            }
        } else {
            stringExtra = "";
        }
        if (com.baidu.mobads.container.util.bv.j(this.e) && stringExtra.equals(NativeRewardActivity.SCREEN_PORTRAIT)) {
            this.e.setContentView(com.baidu.mobads.container.util.bv.a(this.e, this.f, false));
        } else {
            this.e.setContentView(this.f);
        }
        this.d.clear();
        C0132a c0132a = new C0132a();
        dk dkVar = null;
        for (int i = 0; i < this.c.size(); i++) {
            dk dkVarA = dk.a(this.c.get(i), i, this.c.size(), this.j);
            dkVarA.a(c0132a);
            this.d.add(dkVarA);
            if (i == 0) {
                dkVar = dkVarA;
            }
        }
        com.baidu.mobads.container.util.cn cnVarS = this.b.s();
        this.h = new ViewPager2(cnVarS, this.g);
        RewardFragmentAdapter rewardFragmentAdapter = new RewardFragmentAdapter(cnVarS, this.e, this.d);
        ViewGroup viewPager2 = this.h.getInstance();
        Object rewardFragmentAdapter2 = rewardFragmentAdapter.getInstance();
        if ((viewPager2 == null || rewardFragmentAdapter2 == null) && dkVar != null) {
            this.i = dkVar.a();
            this.i.onCreate(null);
            if (this.i != null && this.i.getRootView() != null) {
                this.f.addView(this.i.getRootView(), layoutParams);
                return;
            }
            return;
        }
        this.h.setId(com.baidu.mobads.container.util.cf.a());
        if (!this.j) {
            this.h.setOrientation(1);
        } else {
            this.h.setOrientation(0);
            this.h.setOffscreenPageLimit(1);
        }
        this.h.setCurrentItem(0);
        this.h.setAdapter(rewardFragmentAdapter);
        this.h.registerOnPageChangeCallback(new b(this));
        this.h.setOnOverScrollListener(new c(this));
        if (this.j && rewardFragmentAdapter.getItemCount() <= 1) {
            this.h.setUserInputEnabled(false);
        }
        com.component.a.d.c cVar = new com.component.a.d.c(this.g, null);
        if (dkVar != null && this.j) {
            d dVar = new d(this, cVar, rewardFragmentAdapter.getRegisteredLifeCycle(), dkVar.a(), cVar, layoutParams);
            Iterator<dk> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(dVar);
            }
        }
        this.f.addView(viewPager2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, com.component.a.f.d dVar) {
        NativeRewardActivity nativeRewardActivityA = a();
        if (nativeRewardActivityA == null) {
            return false;
        }
        if (dVar != null) {
            nativeRewardActivityA.a(false, z, dVar.a());
            return true;
        }
        nativeRewardActivityA.a(false, z, (com.baidu.mobads.container.o.b) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        NativeRewardActivity nativeRewardActivityA = a();
        if (nativeRewardActivityA != null) {
            nativeRewardActivityA.a(i);
            return true;
        }
        return false;
    }

    private NativeRewardActivity a() {
        int currentItem;
        dk dkVar;
        if (this.h != null && this.d.size() > (currentItem = this.h.getCurrentItem()) && (dkVar = this.d.get(currentItem)) != null) {
            return dkVar.a();
        }
        return null;
    }

    /* renamed from: com.baidu.mobads.container.rewardvideo.a$a, reason: collision with other inner class name */
    public class C0132a {
        private volatile boolean b = false;
        private volatile boolean c = false;
        private volatile int d = 0;
        private volatile int e = 0;
        private volatile boolean f = false;

        public C0132a() {
        }

        public boolean a() {
            return a.this.k;
        }

        public boolean b() {
            return this.f;
        }

        public boolean a(int i, int i2) {
            if (i2 <= 0) {
                this.f = true;
            }
            if (!a.this.k) {
                Iterator it = a.this.d.iterator();
                while (it.hasNext()) {
                    ((dk) it.next()).a().onUserRewardTimeUpdate(i, i2);
                }
            }
            return !a.this.k;
        }

        public int c() {
            return this.d;
        }

        public void a(int i) {
            this.d = i;
        }

        public int d() {
            return this.e;
        }

        public void b(int i) {
            this.e = i;
        }

        public boolean a(com.baidu.mobads.container.adrequest.j jVar) {
            if (!this.b) {
                this.b = true;
                a.this.b.s().dispatchEvent(new com.baidu.mobads.container.util.cm(com.baidu.mobads.container.components.k.b.v));
            }
            return true;
        }

        public void b(com.baidu.mobads.container.adrequest.j jVar) {
        }

        public boolean a(com.baidu.mobads.container.adrequest.j jVar, float f) {
            return false;
        }

        public boolean b(com.baidu.mobads.container.adrequest.j jVar, float f) {
            return false;
        }

        public boolean c(com.baidu.mobads.container.adrequest.j jVar) {
            return false;
        }

        public boolean a(com.baidu.mobads.container.adrequest.j jVar, String str) {
            if (!a.this.k) {
                if (this.c) {
                    return true;
                }
                this.c = true;
                Iterator it = a.this.d.iterator();
                while (it.hasNext()) {
                    ((dk) it.next()).a().a();
                }
                return false;
            }
            return false;
        }

        public void d(com.baidu.mobads.container.adrequest.j jVar) {
            if (a.this.h != null) {
                a.this.h.setCurrentItem(a.this.h.getCurrentItem() + 1);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
        if (this.i != null) {
            this.i.onStart();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        int currentItem;
        if (this.i != null) {
            this.i.onResume();
        } else if (this.h != null && (currentItem = this.h.getCurrentItem()) >= 0 && currentItem < this.d.size()) {
            this.d.get(currentItem).getLifecycle().moveToState(State.RESUMED);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        if (this.i != null) {
            this.i.onPause();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
        if (this.i != null) {
            this.i.onStop();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        if (this.i != null) {
            this.i.onDestroy();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
        if (this.i != null) {
            this.i.onNewIntent(intent);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        if (this.i != null) {
            return this.i.onBackPressed();
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i != null) {
            return this.i.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.i != null) {
            return this.i.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.i != null) {
            this.i.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        if (this.i != null) {
            this.i.onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
        if (this.i != null) {
            this.i.onAttachedToWindow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        if (this.i != null) {
            this.i.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.i != null) {
            return this.i.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.i != null) {
            return this.i.onKeyDown(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.i != null) {
            return this.i.onKeyUp(i, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
        if (this.i != null) {
            this.i.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
        if (this.i != null) {
            this.i.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
        if (this.i != null) {
            this.i.onRestoreInstanceState(bundle);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i, int i2) {
        if (this.i != null) {
            this.i.overridePendingTransition(i, i2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
        if (this.i != null) {
            this.i.setLpBussParam(jSONObject);
        }
    }
}
