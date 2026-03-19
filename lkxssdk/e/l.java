package lkxssdk.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lingku.xuanshang.core.ui.imagepicker.PickerActivity;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class l extends lkxssdk.b0.b<e, lkxssdk.b0.c> {
    public int f;
    public PickerActivity g;

    public class a extends lkxssdk.b0.d<e> {
        public a(l lVar) {
        }
    }

    public l(PickerActivity pickerActivity, List<e> list) {
        super((List) null);
        this.g = pickerActivity;
        a(new a(this));
        a().a(1, lkxssdk.l0.e.a().a("lkxs_view_pic_item"));
        a().a(2, lkxssdk.l0.e.a().a("lkxs_view_video_item"));
        a().a(4, lkxssdk.l0.e.a().a("lkxs_view_takephoto_item"));
        this.f = (lkxssdk.b.a.a - ((i.b().a() + 1) * lkxssdk.a0.b.a(2.0f))) / i.b().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar, lkxssdk.b0.c cVar, View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (eVar.h) {
            eVar.h = false;
            i.b().n.remove(eVar.b);
            this.g.h();
            notifyDataSetChanged();
            return;
        }
        if (i.b().n.size() >= i.b().d) {
            lkxssdk.m0.b.a().a("最多只能选择" + i.b().d + "个视频", 0);
            return;
        }
        if (i.b().i > 0 && eVar.f / 1000 > i.b().i) {
            lkxssdk.m0.b.a().a("请选择" + i.b().i + "秒内的视频", 0);
            return;
        }
        eVar.h = true;
        i.b().a(eVar.b);
        if (i.b().d > 1) {
            lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
            int identifier = eVarA.b.getResources().getIdentifier("selectedCount", "id", eVarA.c);
            lkxssdk.l0.e eVarA2 = lkxssdk.l0.e.a();
            cVar.a(identifier).setBackgroundResource(eVarA2.b.getResources().getIdentifier("lkxs_picker_seleted_more", "drawable", eVarA2.c));
            lkxssdk.l0.e eVarA3 = lkxssdk.l0.e.a();
            cVar.a(eVarA3.b.getResources().getIdentifier("selectedCount", "id", eVarA3.c), i.b().b(eVar.b));
        } else {
            lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
            int identifier2 = eVarA4.b.getResources().getIdentifier("selectedCount", "id", eVarA4.c);
            lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
            cVar.a(identifier2).setBackgroundResource(eVarA5.b.getResources().getIdentifier("lkxs_picker_seleted_single", "drawable", eVarA5.c));
            lkxssdk.l0.e eVarA6 = lkxssdk.l0.e.a();
            cVar.a(eVarA6.b.getResources().getIdentifier("selectedCount", "id", eVarA6.c), "");
        }
        this.g.h();
    }

    @Override // lkxssdk.b0.b
    public /* bridge */ /* synthetic */ void a(lkxssdk.b0.c cVar, e eVar, int i) {
        a(cVar, eVar);
    }

    public void a(final lkxssdk.b0.c cVar, final e eVar) {
        String str;
        String strValueOf;
        String str2;
        String strValueOf2;
        String str3;
        String strValueOf3;
        int identifier;
        lkxssdk.l0.e eVarA;
        lkxssdk.l0.e eVarA2;
        lkxssdk.l0.e eVarA3;
        int i = eVar.e;
        if (i == 1) {
            lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
            ((RelativeLayout) cVar.a(eVarA4.b.getResources().getIdentifier("picRL", "id", eVarA4.c))).getLayoutParams().height = this.f;
            lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
            ImageView imageView = (ImageView) cVar.a(eVarA5.b.getResources().getIdentifier("image", "id", eVarA5.c));
            lkxssdk.a.a.a(eVar.b, imageView, this.f, eVar.g, new m(this, imageView));
            lkxssdk.l0.e eVarA6 = lkxssdk.l0.e.a();
            cVar.a(eVarA6.b.getResources().getIdentifier("selecteRL", "id", eVarA6.c)).setOnClickListener(new View.OnClickListener() { // from class: lkxssdk.e.l$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                    this.f$0.a(eVar, cVar, view);
                }
            });
            if (!eVar.h) {
                lkxssdk.l0.e eVarA7 = lkxssdk.l0.e.a();
                cVar.a(eVarA7.b.getResources().getIdentifier("selectedCount", "id", eVarA7.c), "");
                lkxssdk.l0.e eVarA8 = lkxssdk.l0.e.a();
                identifier = eVarA8.b.getResources().getIdentifier("selectedCount", "id", eVarA8.c);
                eVarA = lkxssdk.l0.e.a();
                cVar.a(identifier).setBackgroundResource(eVarA.b.getResources().getIdentifier("lkxs_picker_unselected", "drawable", eVarA.c));
                return;
            }
            if (i.b().d > 1) {
                lkxssdk.l0.e eVarA9 = lkxssdk.l0.e.a();
                int identifier2 = eVarA9.b.getResources().getIdentifier("selectedCount", "id", eVarA9.c);
                lkxssdk.l0.e eVarA10 = lkxssdk.l0.e.a();
                cVar.a(identifier2).setBackgroundResource(eVarA10.b.getResources().getIdentifier("lkxs_picker_seleted_more", "drawable", eVarA10.c));
                eVarA3 = lkxssdk.l0.e.a();
                cVar.a(eVarA3.b.getResources().getIdentifier("selectedCount", "id", eVarA3.c), i.b().b(eVar.b));
                return;
            }
            lkxssdk.l0.e eVarA11 = lkxssdk.l0.e.a();
            int identifier3 = eVarA11.b.getResources().getIdentifier("selectedCount", "id", eVarA11.c);
            lkxssdk.l0.e eVarA12 = lkxssdk.l0.e.a();
            cVar.a(identifier3).setBackgroundResource(eVarA12.b.getResources().getIdentifier("lkxs_picker_seleted_single", "drawable", eVarA12.c));
            eVarA2 = lkxssdk.l0.e.a();
            str = "";
            cVar.a(eVarA2.b.getResources().getIdentifier("selectedCount", "id", eVarA2.c), str);
        }
        if (i != 2) {
            if (i == 4) {
                lkxssdk.l0.e eVarA13 = lkxssdk.l0.e.a();
                ((RelativeLayout) cVar.a(eVarA13.b.getResources().getIdentifier("takePhotoRL", "id", eVarA13.c))).getLayoutParams().height = this.f;
                if (i.b().l) {
                    lkxssdk.l0.e eVarA14 = lkxssdk.l0.e.a();
                    cVar.a(eVarA14.b.getResources().getIdentifier("takePhoto", "id", eVarA14.c), "拍摄照片");
                    return;
                } else {
                    lkxssdk.l0.e eVarA15 = lkxssdk.l0.e.a();
                    cVar.a(eVarA15.b.getResources().getIdentifier("takePhoto", "id", eVarA15.c), "拍摄视频");
                    return;
                }
            }
            return;
        }
        lkxssdk.l0.e eVarA16 = lkxssdk.l0.e.a();
        ((RelativeLayout) cVar.a(eVarA16.b.getResources().getIdentifier("videoRL", "id", eVarA16.c))).getLayoutParams().height = this.f;
        lkxssdk.l0.e eVarA17 = lkxssdk.l0.e.a();
        ImageView imageView2 = (ImageView) cVar.a(eVarA17.b.getResources().getIdentifier("image", "id", eVarA17.c));
        lkxssdk.a.a.a(eVar.b, imageView2, this.f, new n(this, imageView2));
        lkxssdk.l0.e eVarA18 = lkxssdk.l0.e.a();
        int identifier4 = eVarA18.b.getResources().getIdentifier("duration", "id", eVarA18.c);
        long j = eVar.f / 1000;
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        long j4 = j % 60;
        if (j2 > 9) {
            strValueOf = String.valueOf(j2);
            str = "";
        } else {
            str = "";
            strValueOf = String.format(Locale.getDefault(), "0%d", Long.valueOf(j2));
        }
        if (j3 > 9) {
            strValueOf2 = String.valueOf(j3);
            str2 = "lkxs_picker_seleted_single";
        } else {
            str2 = "lkxs_picker_seleted_single";
            strValueOf2 = String.format(Locale.getDefault(), "0%d", Long.valueOf(j3));
        }
        if (j4 > 9) {
            strValueOf3 = String.valueOf(j4);
            str3 = "lkxs_picker_seleted_more";
        } else {
            str3 = "lkxs_picker_seleted_more";
            strValueOf3 = String.format(Locale.getDefault(), "0%d", Long.valueOf(j4));
        }
        cVar.a(identifier4, String.format(Locale.getDefault(), "%s:%s:%s", strValueOf, strValueOf2, strValueOf3));
        lkxssdk.l0.e eVarA19 = lkxssdk.l0.e.a();
        cVar.a(eVarA19.b.getResources().getIdentifier("selecteRL", "id", eVarA19.c)).setOnClickListener(new View.OnClickListener() { // from class: lkxssdk.e.l$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                this.f$0.b(eVar, cVar, view);
            }
        });
        if (!eVar.h) {
            lkxssdk.l0.e eVarA20 = lkxssdk.l0.e.a();
            cVar.a(eVarA20.b.getResources().getIdentifier("selectedCount", "id", eVarA20.c), str);
            lkxssdk.l0.e eVarA21 = lkxssdk.l0.e.a();
            identifier = eVarA21.b.getResources().getIdentifier("selectedCount", "id", eVarA21.c);
            eVarA = lkxssdk.l0.e.a();
            cVar.a(identifier).setBackgroundResource(eVarA.b.getResources().getIdentifier("lkxs_picker_unselected", "drawable", eVarA.c));
            return;
        }
        if (i.b().d > 1) {
            lkxssdk.l0.e eVarA22 = lkxssdk.l0.e.a();
            int identifier5 = eVarA22.b.getResources().getIdentifier("selectedCount", "id", eVarA22.c);
            lkxssdk.l0.e eVarA23 = lkxssdk.l0.e.a();
            cVar.a(identifier5).setBackgroundResource(eVarA23.b.getResources().getIdentifier(str3, "drawable", eVarA23.c));
            eVarA3 = lkxssdk.l0.e.a();
            cVar.a(eVarA3.b.getResources().getIdentifier("selectedCount", "id", eVarA3.c), i.b().b(eVar.b));
            return;
        }
        lkxssdk.l0.e eVarA24 = lkxssdk.l0.e.a();
        int identifier6 = eVarA24.b.getResources().getIdentifier("selectedCount", "id", eVarA24.c);
        lkxssdk.l0.e eVarA25 = lkxssdk.l0.e.a();
        cVar.a(identifier6).setBackgroundResource(eVarA25.b.getResources().getIdentifier(str2, "drawable", eVarA25.c));
        eVarA2 = lkxssdk.l0.e.a();
        cVar.a(eVarA2.b.getResources().getIdentifier("selectedCount", "id", eVarA2.c), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, lkxssdk.b0.c cVar, View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (eVar.h) {
            eVar.h = false;
            i.b().n.remove(eVar.b);
            this.g.h();
            notifyDataSetChanged();
            return;
        }
        if (i.b().n.size() >= i.b().d) {
            lkxssdk.m0.b.a().a("最多只能选择" + i.b().d + "张图片", 0);
            return;
        }
        eVar.h = true;
        i.b().a(eVar.b, eVar.c, eVar.d);
        if (i.b().d > 1) {
            lkxssdk.l0.e eVarA = lkxssdk.l0.e.a();
            int identifier = eVarA.b.getResources().getIdentifier("selectedCount", "id", eVarA.c);
            lkxssdk.l0.e eVarA2 = lkxssdk.l0.e.a();
            cVar.a(identifier).setBackgroundResource(eVarA2.b.getResources().getIdentifier("lkxs_picker_seleted_more", "drawable", eVarA2.c));
            lkxssdk.l0.e eVarA3 = lkxssdk.l0.e.a();
            cVar.a(eVarA3.b.getResources().getIdentifier("selectedCount", "id", eVarA3.c), i.b().b(eVar.b));
        } else {
            lkxssdk.l0.e eVarA4 = lkxssdk.l0.e.a();
            int identifier2 = eVarA4.b.getResources().getIdentifier("selectedCount", "id", eVarA4.c);
            lkxssdk.l0.e eVarA5 = lkxssdk.l0.e.a();
            cVar.a(identifier2).setBackgroundResource(eVarA5.b.getResources().getIdentifier("lkxs_picker_seleted_single", "drawable", eVarA5.c));
            lkxssdk.l0.e eVarA6 = lkxssdk.l0.e.a();
            cVar.a(eVarA6.b.getResources().getIdentifier("selectedCount", "id", eVarA6.c), "");
        }
        this.g.h();
    }
}
