package com.lingku.xuanshang.core.ui.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.lingku.xuanshang.core.data.model.PicItem;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.imagepicker.crop.CropActivity;
import com.lingku.xuanshang.core.ui.imagepicker.preview.PicPreviewAcitvity;
import com.lingku.xuanshang.core.ui.imagepicker.preview.VideoPreviewActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lkxssdk.b0.b;
import lkxssdk.e.i;
import lkxssdk.e.j;
import lkxssdk.e.k;
import lkxssdk.e.k.c;
import lkxssdk.e.k.d;
import lkxssdk.e.l;
import lkxssdk.e.o;
import lkxssdk.e.u;
import lkxssdk.e.v;
import lkxssdk.e.x;
import lkxssdk.e.y;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PickerActivity extends BaseActivity implements lkxssdk.i0.a {
    public static final /* synthetic */ int d = 0;
    public ImageView e;
    public TextView f;
    public TextView g;
    public LinearLayout h;
    public ImageView i;
    public View j;
    public RecyclerView k;
    public RecyclerView l;
    public lkxssdk.e.d m;
    public List<lkxssdk.e.a> n;
    public l o;
    public int p;
    public boolean q;
    public x r;
    public y s;
    public v t;
    public boolean u;
    public TextView v;
    public LinearLayout w;
    public LinearLayout x;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PickerActivity pickerActivity;
            TextView textView;
            lkxssdk.l0.e eVarA;
            String str;
            PickerActivity pickerActivity2 = PickerActivity.this;
            if (pickerActivity2.n != null) {
                if (pickerActivity2.j.getVisibility() != 0) {
                    PickerActivity pickerActivity3 = PickerActivity.this;
                    if (pickerActivity3.q) {
                        for (lkxssdk.e.a aVar : pickerActivity3.n) {
                            Iterator<lkxssdk.e.e> it = aVar.c.iterator();
                            int i = 0;
                            while (it.hasNext()) {
                                if (it.next().h) {
                                    i++;
                                }
                            }
                            aVar.d = i;
                        }
                    }
                    PickerActivity.this.m.notifyDataSetChanged();
                    PickerActivity.this.j.setVisibility(0);
                    pickerActivity = PickerActivity.this;
                    textView = pickerActivity.f;
                    eVarA = lkxssdk.l0.e.a();
                    str = "lkxs_picker_up";
                } else {
                    PickerActivity.this.j.setVisibility(8);
                    pickerActivity = PickerActivity.this;
                    textView = pickerActivity.f;
                    eVarA = lkxssdk.l0.e.a();
                    str = "lkxs_picker_down";
                }
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pickerActivity.getDrawable(eVarA.b.getResources().getIdentifier(str, "drawable", eVarA.c)), (Drawable) null);
            }
        }
    }

    public class b implements b.a {
        public b() {
        }

        @Override // lkxssdk.b0.b.a
        public void a(lkxssdk.b0.b bVar, View view, int i) {
            PickerActivity pickerActivity = PickerActivity.this;
            if (i != pickerActivity.p) {
                pickerActivity.j.setVisibility(4);
                pickerActivity.f.setText(pickerActivity.n.get(i).b);
                TextView textView = pickerActivity.f;
                lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pickerActivity.getDrawable(eVarA.b.getResources().getIdentifier("lkxs_picker_down", "drawable", eVarA.c)), (Drawable) null);
                pickerActivity.p = i;
                pickerActivity.o.a(pickerActivity.n.get(i).c);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PickerActivity.this.j.getVisibility() == 0) {
                PickerActivity.this.j.setVisibility(8);
                PickerActivity pickerActivity = PickerActivity.this;
                TextView textView = pickerActivity.f;
                lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pickerActivity.getDrawable(eVarA.b.getResources().getIdentifier("lkxs_picker_down", "drawable", eVarA.c)), (Drawable) null);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PickerActivity.this.a();
        }
    }

    public class e implements b.a {
        public e() {
        }

        @Override // lkxssdk.b0.b.a
        public void a(lkxssdk.b0.b bVar, View view, int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            if (!i.b().h || i != 0) {
                PickerActivity.a(PickerActivity.this, i);
                return;
            }
            if (i.b().n.size() >= i.b().d) {
                if (i.b().l) {
                    lkxssdk.m0.b.a().a("最多只能选择" + i.b().d + "张图片", 0);
                    return;
                } else {
                    lkxssdk.m0.b.a().a("最多只能选择" + i.b().d + "个视频", 0);
                    return;
                }
            }
            PickerActivity pickerActivity = PickerActivity.this;
            v vVar = pickerActivity.t;
            vVar.b = new o(pickerActivity);
            vVar.c = 2;
            vVar.a();
        }
    }

    public class f implements v.c {
        public f() {
        }

        @Override // lkxssdk.e.v.c
        public void a() {
            PickerActivity pickerActivity = PickerActivity.this;
            int i = PickerActivity.d;
            pickerActivity.b("");
            List<lkxssdk.e.a> listB = null;
            if (i.b().b > 0) {
                if (i.b().l) {
                    k kVarA = k.a();
                    long j = i.b().b;
                    kVarA.getClass();
                    new j(kVarA, j).start();
                }
                pickerActivity.f.setVisibility(0);
                pickerActivity.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                pickerActivity.f.setText("选择图片");
                pickerActivity.f.setClickable(false);
            } else {
                pickerActivity.w.setVisibility(0);
                k kVarA2 = k.a();
                if (!kVarA2.o && lkxssdk.j0.d.b(kVarA2.d)) {
                    kVarA2.o = true;
                    kVarA2.f = kVarA2.new c(kVarA2.e);
                    kVarA2.g = kVarA2.new d(kVarA2.e);
                    kVarA2.d.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, kVarA2.f);
                    kVarA2.d.getContentResolver().registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, false, kVarA2.g);
                }
                listB = i.b().l ? k.a().b() : k.a().c();
            }
            if (listB != null) {
                pickerActivity.g();
                pickerActivity.n = new ArrayList();
                Iterator<lkxssdk.e.a> it = listB.iterator();
                while (it.hasNext()) {
                    pickerActivity.n.add(it.next().clone());
                }
                pickerActivity.p = 0;
                pickerActivity.k();
            }
        }
    }

    public class g implements x.a {
        public g() {
        }

        public void a(String str) {
            lkxssdk.h0.c.b("takeFail:" + str);
        }
    }

    public static void a(PickerActivity pickerActivity, int i) {
        Class cls;
        int i2;
        pickerActivity.getClass();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        HashMap<String, PicItem> map = new HashMap<>();
        Iterator<lkxssdk.e.e> it = pickerActivity.n.get(pickerActivity.p).c.iterator();
        while (it.hasNext()) {
            lkxssdk.e.e next = it.next();
            if (next.e != 4) {
                arrayList.add(next.b);
                if (i.b().l) {
                    PicItem picItem = new PicItem();
                    String str = next.b;
                    picItem.path = str;
                    picItem.dateAdd = next.c;
                    picItem.dateModify = next.d;
                    map.put(str, picItem);
                }
                arrayList2.add(Integer.valueOf(next.g));
            }
        }
        Bundle bundle = new Bundle();
        if (i.b().h) {
            i--;
        }
        bundle.putInt("index", i);
        i.b().p = arrayList;
        if (i.b().l) {
            i.b().q = map;
            i.b().r = arrayList2;
            cls = PicPreviewAcitvity.class;
            i2 = KSTubeParamInner.FREE_ALL;
        } else {
            cls = VideoPreviewActivity.class;
            i2 = FraudVerifyCode.RerwardFraudUnknown;
        }
        lkxssdk.a.a.a(pickerActivity, (Class<?>) cls, i2, 1, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        i();
    }

    @Override // lkxssdk.d.b
    public void b() {
        lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
        this.e = (ImageView) findViewById(eVarA.b.getResources().getIdentifier("backBtn", "id", eVarA.c));
        lkxssdk.l0.e eVarA2 = lkxssdk.l0.e.a();
        this.f = (TextView) findViewById(eVarA2.b.getResources().getIdentifier("folderNameTv", "id", eVarA2.c));
        lkxssdk.l0.e eVarA3 = lkxssdk.l0.e.a();
        this.g = (TextView) findViewById(eVarA3.b.getResources().getIdentifier("confirmBtn", "id", eVarA3.c));
        lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
        this.j = findViewById(eVarA4.b.getResources().getIdentifier("dirBgRL", "id", eVarA4.c));
        lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
        RecyclerView recyclerView = (RecyclerView) findViewById(eVarA5.b.getResources().getIdentifier("dirRecyclerView", "id", eVarA5.c));
        this.l = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        lkxssdk.l0.e eVarA6 = lkxssdk.l0.e.a();
        lkxssdk.e.d dVar = new lkxssdk.e.d(eVarA6.b.getResources().getIdentifier("lkxs_view_dir_item", "layout", eVarA6.c));
        this.m = dVar;
        this.l.setAdapter(dVar);
        lkxssdk.l0.e eVarA7 = lkxssdk.l0.e.a();
        RecyclerView recyclerView2 = (RecyclerView) findViewById(eVarA7.b.getResources().getIdentifier("picRecyclerView", "id", eVarA7.c));
        this.k = recyclerView2;
        recyclerView2.setLayoutManager(new GridLayoutManager(getApplicationContext(), i.b().e));
        this.k.addOnScrollListener(new lkxssdk.g0.b(false, true, null));
        l lVar = new l(this, null);
        this.o = lVar;
        this.k.setAdapter(lVar);
        this.j.setVisibility(4);
        this.f.setVisibility(4);
        new Handler(getMainLooper());
        lkxssdk.l0.e eVarA8 = lkxssdk.l0.e.a();
        this.h = (LinearLayout) findViewById(eVarA8.b.getResources().getIdentifier("cropLL", "id", eVarA8.c));
        lkxssdk.l0.e eVarA9 = lkxssdk.l0.e.a();
        this.i = (ImageView) findViewById(eVarA9.b.getResources().getIdentifier("cropImage", "id", eVarA9.c));
        lkxssdk.l0.e eVarA10 = lkxssdk.l0.e.a();
        LinearLayout linearLayout = (LinearLayout) findViewById(eVarA10.b.getResources().getIdentifier("noPicLL", "id", eVarA10.c));
        this.x = linearLayout;
        linearLayout.setVisibility(4);
        lkxssdk.l0.e eVarA11 = lkxssdk.l0.e.a();
        LinearLayout linearLayout2 = (LinearLayout) findViewById(eVarA11.b.getResources().getIdentifier("refreshLL", "id", eVarA11.c));
        this.w = linearLayout2;
        linearLayout2.setVisibility(4);
        lkxssdk.l0.e eVarA12 = lkxssdk.l0.e.a();
        TextView textView = (TextView) findViewById(eVarA12.b.getResources().getIdentifier("refreshMedia", "id", eVarA12.c));
        this.v = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.PickerActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickerActivity.a(view);
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.PickerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        int i = i.b().c;
        if (i == 3 || i == 4) {
            this.h.setSelected(false);
            ImageView imageView = this.i;
            lkxssdk.l0.e eVarA13 = lkxssdk.l0.e.a();
            imageView.setBackgroundResource(eVarA13.b.getResources().getIdentifier("lkxs_crop_off", "drawable", eVarA13.c));
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(4);
        }
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.PickerActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        this.f.setOnClickListener(new a());
        this.m.e = new b();
        this.j.setOnClickListener(new c());
        this.e.setOnClickListener(new d());
        h();
        this.o.e = new e();
    }

    @Override // com.lingku.xuanshang.core.ui.base.BaseActivity
    public void b(String str) {
        if (this.s == null) {
            this.s = new y(this);
        }
        this.s.a(str, true, true);
    }

    @Override // lkxssdk.d.b
    public void c() {
        v vVar = this.t;
        vVar.b = new f();
        vVar.c = 1;
        vVar.a();
    }

    @Override // lkxssdk.d.b
    public void d() {
        setResult(0);
        a();
    }

    @Override // lkxssdk.d.b
    public void e() {
        y yVar = this.s;
        if (yVar != null) {
            yVar.b();
        }
        List<lkxssdk.e.a> list = this.n;
        if (list != null) {
            list.clear();
        }
        lkxssdk.i0.b bVarA = lkxssdk.i0.b.a();
        bVarA.getClass();
        bVarA.b.remove(this);
    }

    @Override // lkxssdk.d.b
    public int f() {
        lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
        return eVarA.b.getResources().getIdentifier("lkxs_aty_picker", "layout", eVarA.c);
    }

    @Override // com.lingku.xuanshang.core.ui.base.BaseActivity
    public void g() {
        y yVar = this.s;
        if (yVar != null) {
            yVar.b();
        }
    }

    public void h() {
        TextView textView;
        String str;
        this.q = true;
        if (i.b().n.size() > 0) {
            this.g.getBackground().setAlpha(255);
            this.g.setClickable(true);
            this.g.setText(String.format(Locale.getDefault(), "确定 (%d/%d)", Integer.valueOf(i.b().n.size()), Integer.valueOf(i.b().d)));
            return;
        }
        this.g.setClickable(true);
        if (i.b().b > 0) {
            textView = this.g;
            str = "请选择";
        } else {
            textView = this.g;
            str = "确定";
        }
        textView.setText(str);
        this.g.getBackground().setAlpha(125);
    }

    public void i() {
        lkxssdk.h0.c.b("clickConfirm");
        int i = i.b().c;
        if (i != 1 && i != 2 && ((i != 3 && i != 4) || !this.h.isSelected())) {
            setResult(-1);
            a();
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("picPath", i.b().n.get(0));
            bundle.putBoolean("keepRate", i == 1 || i == 3);
            lkxssdk.a.a.a(this, (Class<?>) CropActivity.class, 1, bundle);
        }
    }

    public final x j() {
        if (this.r == null) {
            this.r = new x(this, new g());
        }
        return this.r;
    }

    public final void k() {
        if (i.b().b == 0) {
            this.m.a(this.n);
            this.f.setVisibility(0);
            this.f.setText(this.n.get(this.p).b);
            TextView textView = this.f;
            lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(eVarA.b.getResources().getIdentifier("lkxs_picker_down", "drawable", eVarA.c)), (Drawable) null);
        }
        if (i.b().h) {
            for (lkxssdk.e.a aVar : this.n) {
                lkxssdk.e.e eVar = new lkxssdk.e.e();
                eVar.e = 4;
                aVar.c.add(0, eVar);
            }
        }
        this.o.a(this.n.get(this.p).c);
        if (this.n.get(0).c.size() == 0) {
            this.x.setVisibility(0);
        }
    }

    @Override // com.lingku.xuanshang.core.ui.base.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x xVarJ = j();
        xVarJ.getClass();
        if (i == 1000001 || i == 1000002) {
            if (i2 == -1) {
                Activity activity = xVarJ.a;
                Uri uri = xVarJ.c;
                String absolutePath = uri == null ? null : TextUtils.equals(uri.getAuthority(), new StringBuilder().append(activity.getPackageName()).append(".lkxs.fileprovider").toString()) ? new File(uri.getPath().replace("root_path/", "")).getAbsolutePath() : uri.getPath();
                boolean zIsEmpty = TextUtils.isEmpty(absolutePath);
                g gVar = (g) xVarJ.b;
                if (zIsEmpty) {
                    gVar.a("获取图片路径失败");
                } else {
                    gVar.getClass();
                    lkxssdk.h0.c.b("takeSuccess:" + absolutePath);
                    if (i.b().l) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        i.b().a(absolutePath, jCurrentTimeMillis, jCurrentTimeMillis);
                    } else {
                        i iVarB = i.b();
                        if (!iVarB.n.contains(absolutePath)) {
                            iVarB.n.add(absolutePath);
                        }
                    }
                    PickerActivity.this.u = true;
                    PickerActivity.this.i();
                }
            } else {
                ((g) xVarJ.b).getClass();
                lkxssdk.h0.c.b("takeCancel");
            }
        }
        if (i == 100000 || i == 100001) {
            if (i2 == -1) {
                i();
                return;
            }
            int i3 = 0;
            if (intent.getBooleanExtra("dataChange", false)) {
                List<T> list = this.o.b;
                if (list != 0) {
                    int i4 = 0;
                    for (T t : list) {
                        if (i.b().d(t.b)) {
                            t.h = true;
                            i4++;
                        } else {
                            t.h = false;
                        }
                    }
                    i3 = i4;
                }
                this.n.get(this.p).d = i3;
                this.o.notifyDataSetChanged();
                h();
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        v vVar = this.t;
        if (vVar == null || !vVar.d) {
            return;
        }
        int i = 0;
        vVar.d = false;
        if (vVar.c == 1 && lkxssdk.j0.d.a()) {
            i = 1000;
        }
        lkxssdk.l.j.a.postDelayed(new u(vVar), i);
    }

    @Override // lkxssdk.d.b
    public void a() {
        finish();
        overridePendingTransition(0, lkxssdk.a.a.a(1, false));
    }

    @Override // lkxssdk.d.b
    public void a(Bundle bundle) {
        this.s = new y(this);
        lkxssdk.i0.b bVarA = lkxssdk.i0.b.a();
        bVarA.getClass();
        if (!bVarA.b.contains(this)) {
            bVarA.b.add(this);
        }
        this.t = new v(this);
        int i = getResources().getDisplayMetrics().widthPixels;
        lkxssdk.b.a.a = i;
        lkxssdk.h0.c.b(Integer.valueOf(i));
    }

    public static void a(View view) {
        if (i.b().l) {
            k.a().a(true);
        } else {
            k.a().b(true);
        }
    }

    @Override // lkxssdk.i0.a
    public void a(int i, int i2, int i3, Object obj) {
        String str;
        listC = null;
        List<lkxssdk.e.a> listC = null;
        int i4 = 0;
        switch (i) {
            case 21:
            case 23:
                if (this.u) {
                    this.u = false;
                    i iVarB = i.b();
                    if (iVarB.n.size() > 0) {
                        iVarB.n.remove(0);
                        break;
                    }
                }
                break;
            case 22:
                String string = obj.toString();
                String str2 = i.b().n.size() > 0 ? i.b().n.get(0) : null;
                i iVarB2 = i.b();
                if (iVarB2.n.size() > 0) {
                    iVarB2.n.remove(0);
                }
                PicItem picItemC = i.b().c(str2);
                i.b().a(string, picItemC.dateAdd, picItemC.dateModify);
                setResult(-1);
                a();
                break;
            default:
                if (i == 25) {
                    this.n = k.a().l;
                    this.p = 0;
                    g();
                    k();
                }
                if (i.b().b <= 0) {
                    if (i == 20) {
                        if (i.b().l) {
                            if (i2 == 1) {
                                listC = k.a().b();
                            }
                        } else if (i2 == 2) {
                            listC = k.a().c();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (listC != null) {
                            Iterator<lkxssdk.e.a> it = listC.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().clone());
                            }
                            i iVarB3 = i.b();
                            for (int size = iVarB3.n.size() - 1; size > -1; size--) {
                                if (!new File(iVarB3.n.get(size)).exists()) {
                                    iVarB3.n.remove(size);
                                }
                            }
                            if (i.b().n.size() > 0) {
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    lkxssdk.e.a aVar = (lkxssdk.e.a) it2.next();
                                    Iterator<lkxssdk.e.e> it3 = aVar.c.iterator();
                                    int i5 = 0;
                                    while (it3.hasNext()) {
                                        lkxssdk.e.e next = it3.next();
                                        if (i.b().d(next.b)) {
                                            next.h = true;
                                            i5++;
                                        }
                                    }
                                    aVar.d = i5;
                                }
                            }
                            List<lkxssdk.e.a> list = this.n;
                            String lowerCase = (list == null || list.size() <= 0) ? "" : this.n.get(this.p).b.toLowerCase(Locale.getDefault());
                            if (TextUtils.isEmpty(lowerCase)) {
                                this.p = i4;
                            } else {
                                while (i4 < arrayList.size()) {
                                    if (((lkxssdk.e.a) arrayList.get(i4)).b.toLowerCase(Locale.getDefault()).equals(lowerCase)) {
                                        this.p = i4;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                            h();
                            this.n = arrayList;
                            g();
                            k();
                            break;
                        }
                    } else if (i == 201) {
                        if (i.b().l) {
                            str = i2 == 1 ? "图片数据刷新中..." : "视频数据刷新中...";
                        } else if (i2 == 2) {
                        }
                        b(str);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        ImageView imageView;
        lkxssdk.l0.e eVarA;
        String str;
        if (this.h.isSelected()) {
            this.h.setSelected(false);
            imageView = this.i;
            eVarA = lkxssdk.l0.e.a();
            str = "lkxs_crop_off";
        } else {
            this.h.setSelected(true);
            imageView = this.i;
            eVarA = lkxssdk.l0.e.a();
            str = "lkxs_crop_on";
        }
        imageView.setBackgroundResource(eVarA.b.getResources().getIdentifier(str, "drawable", eVarA.c));
    }
}
