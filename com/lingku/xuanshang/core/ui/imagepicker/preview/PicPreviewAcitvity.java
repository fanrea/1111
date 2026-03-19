package com.lingku.xuanshang.core.ui.imagepicker.preview;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lingku.xuanshang.core.data.model.PicItem;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.imagepicker.preview.photoview.PhotoView;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import lkxssdk.e.i;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PicPreviewAcitvity extends BaseActivity {
    public List<String> d;
    public List<Integer> e;
    public int f;
    public GalleryViewPager g;
    public TextView h;
    public TextView i;
    public boolean j;
    public TextView k;

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PicPreviewAcitvity picPreviewAcitvity = PicPreviewAcitvity.this;
            if (picPreviewAcitvity.f != i) {
                picPreviewAcitvity.f = i;
                String str = picPreviewAcitvity.d.get(i);
                PicPreviewAcitvity.this.b(i.b().d(str), str);
                PicPreviewAcitvity.this.k.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(PicPreviewAcitvity.this.f + 1), Integer.valueOf(PicPreviewAcitvity.this.d.size())));
            }
        }
    }

    public class b extends PagerAdapter {
        public b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return PicPreviewAcitvity.this.d.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PhotoView photoView = new PhotoView(viewGroup.getContext());
            viewGroup.addView(photoView, -1, -1);
            lkxssdk.a.a.a(PicPreviewAcitvity.this.d.get(i), photoView, lkxssdk.b.a.a, PicPreviewAcitvity.this.e.get(i).intValue(), new lkxssdk.f.a(this, photoView));
            return photoView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.j = true;
        String str = this.d.get(this.f);
        boolean zD = i.b().d(str);
        if (zD) {
            i.b().n.remove(str);
        } else {
            if (i.b().n.size() >= i.b().d) {
                lkxssdk.m0.b.a().a("最多只能选择" + i.b().d + "张图片", 0);
                return;
            }
            HashMap<String, PicItem> map = i.b().q;
            PicItem picItem = map != null ? map.get(str) : null;
            if (picItem != null) {
                i.b().a(str, picItem.dateAdd, picItem.dateModify);
            } else {
                i.b().a(str);
            }
        }
        h();
        b(true ^ zD, str);
    }

    @Override // lkxssdk.d.b
    public void a() {
        i.b().r = null;
        i.b().p = null;
        finish();
        overridePendingTransition(0, lkxssdk.a.a.a(1, false));
    }

    @Override // lkxssdk.d.b
    public void b() {
        e eVarA = e.a();
        this.g = (GalleryViewPager) findViewById(eVarA.b.getResources().getIdentifier("viewPager", "id", eVarA.c));
        e eVarA2 = e.a();
        ((ImageView) findViewById(eVarA2.b.getResources().getIdentifier("backBtn", "id", eVarA2.c))).setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.PicPreviewAcitvity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        e eVarA3 = e.a();
        TextView textView = (TextView) findViewById(eVarA3.b.getResources().getIdentifier("confirmBtn", "id", eVarA3.c));
        this.h = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.PicPreviewAcitvity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        e eVarA4 = e.a();
        TextView textView2 = (TextView) findViewById(eVarA4.b.getResources().getIdentifier("selectedCount", "id", eVarA4.c));
        this.i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lingku.xuanshang.core.ui.imagepicker.preview.PicPreviewAcitvity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                this.f$0.c(view);
            }
        });
        e eVarA5 = e.a();
        TextView textView3 = (TextView) findViewById(eVarA5.b.getResources().getIdentifier("titleIndex", "id", eVarA5.c));
        this.k = textView3;
        textView3.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(this.f + 1), Integer.valueOf(this.d.size())));
    }

    @Override // lkxssdk.d.b
    public void d() {
        setResult(0, new Intent().putExtra("dataChange", this.j));
        a();
    }

    @Override // lkxssdk.d.b
    public void e() {
    }

    @Override // lkxssdk.d.b
    public int f() {
        e eVarA = e.a();
        return eVarA.b.getResources().getIdentifier("lkxs_aty_preview_pic", "layout", eVarA.c);
    }

    public final void h() {
        if (i.b().n.size() > 0) {
            this.h.getBackground().setAlpha(255);
            this.h.setClickable(true);
            this.h.setText(String.format(Locale.getDefault(), "确定 (%d/%d)", Integer.valueOf(i.b().n.size()), Integer.valueOf(i.b().d)));
        } else {
            this.h.setClickable(false);
            this.h.setText("确定");
            this.h.getBackground().setAlpha(125);
        }
    }

    @Override // lkxssdk.d.b
    public void a(Bundle bundle) {
        this.d = i.b().p;
        this.e = i.b().r;
        this.f = getIntent().getIntExtra("index", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        setResult(-1);
        a();
    }

    public final void b(boolean z, String str) {
        if (z) {
            TextView textView = this.i;
            e eVarA = e.a();
            textView.setBackgroundResource(eVarA.b.getResources().getIdentifier("lkxs_picker_seleted_more", "drawable", eVarA.c));
            this.i.setText(String.valueOf(i.b().n.indexOf(str) + 1));
            return;
        }
        TextView textView2 = this.i;
        e eVarA2 = e.a();
        textView2.setBackgroundResource(eVarA2.b.getResources().getIdentifier("lkxs_picker_unselected", "drawable", eVarA2.c));
        this.i.setText("");
    }

    @Override // lkxssdk.d.b
    public void c() throws Resources.NotFoundException {
        this.g.setAdapter(new b());
        this.g.setOffscreenPageLimit(2);
        this.g.setCurrentItem(this.f);
        this.g.addOnPageChangeListener(new a());
        h();
        String str = this.d.get(this.f);
        if (i.b().d(str)) {
            TextView textView = this.i;
            e eVarA = e.a();
            textView.setBackgroundResource(eVarA.b.getResources().getIdentifier("lkxs_picker_seleted_more", "drawable", eVarA.c));
            this.i.setText(i.b().b(str));
            return;
        }
        TextView textView2 = this.i;
        e eVarA2 = e.a();
        textView2.setBackgroundResource(eVarA2.b.getResources().getIdentifier("lkxs_picker_unselected", "drawable", eVarA2.c));
        this.i.setText("");
    }
}
