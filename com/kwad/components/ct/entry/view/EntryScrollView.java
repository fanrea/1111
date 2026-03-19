package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.entry.view.EntryViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.glide.request.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryScrollView extends com.kwad.components.ct.entry.view.a {
    private com.kwad.sdk.lib.widget.b<CtAdTemplate> aDP;
    private boolean aEA;
    private c aEB;
    private CtAdTemplate aEC;
    private View.OnClickListener aED;
    private EntryViewPager aEy;
    private a aEz;

    protected int getAdShowStyle() {
        return 1;
    }

    protected boolean getEnableWebp() {
        return true;
    }

    protected int getItemPlayRes() {
        return 0;
    }

    protected float getPageItemWidth$255f285() {
        return 0.4f;
    }

    protected float getRatio() {
        return 0.68f;
    }

    public EntryScrollView(Context context) {
        super(context);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.aED = new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryScrollView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    public EntryScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.aED = new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryScrollView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    @Override // com.kwad.components.ct.entry.view.a, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    @Override // com.kwad.sdk.widget.KSLinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * ratio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.components.ct.entry.view.a
    public int getSourceRightMargin() {
        return com.kwad.sdk.c.a.a.a(getContext(), 16.0f);
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected final boolean El() {
        this.aDP.clear();
        int iDW = com.kwad.components.ct.entry.a.b.DW();
        byte b = 0;
        this.aEA = iDW > 0;
        for (CtAdTemplate ctAdTemplate : this.aCR.aVj) {
            if (!ctAdTemplate.needHide) {
                this.aDP.add(ctAdTemplate);
                if (this.aEA && this.aDP.size() >= iDW) {
                    break;
                }
            }
        }
        if (this.aEA && com.kwad.components.ct.entry.a.a.aDn.getValue().intValue() == 1) {
            com.kwad.sdk.lib.widget.b<CtAdTemplate> bVar = this.aDP;
            this.aEC = bVar.get(bVar.size() - 1);
        }
        if (this.aDP.size() < 3) {
            setVisibility(8);
            a aVar = this.aEz;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            return false;
        }
        setVisibility(0);
        this.aEz = new a(this, b);
        if (this.aEA) {
            if (com.kwad.components.ct.entry.a.a.aDo.getValue().intValue() == 1) {
                this.aEy.setFooterType(1);
                this.aEy.setSlideBounceEnable(false);
                c cVarEB = EB();
                if (com.kwad.components.ct.entry.a.a.aDn.getValue().intValue() == 1) {
                    cVarEB.setBlackStyle(true);
                    cVarEB.j(this.aEC);
                } else {
                    cVarEB.setBlackStyle(false);
                }
                cVarEB.setReportEntranceData(this.aCR);
                this.aEy.setFooterView(cVarEB);
            } else {
                this.aEy.setFooterType(2);
                if (com.kwad.components.ct.entry.a.a.aDn.getValue().intValue() == 1) {
                    this.aEy.setFooterSlideFrontColor(Color.parseColor("#CC000000"));
                    CtAdTemplate ctAdTemplate2 = this.aEC;
                    if (ctAdTemplate2 != null) {
                        String strAE = com.kwad.components.ct.response.a.a.aE(ctAdTemplate2);
                        if (!TextUtils.isEmpty(strAE)) {
                            com.kwad.sdk.glide.c.cy(getContext()).hh(strAE).b(new h<Drawable>() { // from class: com.kwad.components.ct.entry.view.EntryScrollView.1
                                @Override // com.kwad.sdk.glide.request.h
                                public final boolean a(GlideException glideException) {
                                    return false;
                                }

                                @Override // com.kwad.sdk.glide.request.h
                                public final /* bridge */ /* synthetic */ boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                                    return a(drawable);
                                }

                                private boolean a(Drawable drawable) {
                                    EntryScrollView.this.aEy.setFooterSlideBgDrawable(drawable);
                                    return true;
                                }
                            }).afl();
                        }
                    }
                }
            }
            this.aEy.setOnDragOpenListener(new EntryViewPager.c() { // from class: com.kwad.components.ct.entry.view.EntryScrollView.2
                @Override // com.kwad.components.ct.entry.view.EntryViewPager.c
                public final void EC() {
                    int size = EntryScrollView.this.aDP.size() - 1;
                    View viewFindViewById = EntryScrollView.this.aEy.findViewById(size);
                    EntryScrollView entryScrollView = EntryScrollView.this;
                    entryScrollView.b((CtAdTemplate) entryScrollView.aDP.get(size), size, viewFindViewById, 4);
                }

                @Override // com.kwad.components.ct.entry.view.EntryViewPager.c
                public final void ED() {
                    com.kwad.components.ct.e.b.JK().d(EntryScrollView.this.aCR);
                }
            });
        } else {
            this.aEy.setFooterType(0);
        }
        this.aEy.setAdapter(this.aEz);
        this.aEy.setOnPageChangeListener(this.aEz);
        return true;
    }

    private c EB() {
        c cVar = this.aEB;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(getContext());
        this.aEB = cVar2;
        cVar2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryScrollView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int size = EntryScrollView.this.aDP.size() - 1;
                View viewFindViewById = EntryScrollView.this.aEy.findViewById(size);
                EntryScrollView entryScrollView = EntryScrollView.this;
                entryScrollView.b((CtAdTemplate) entryScrollView.aDP.get(size), size, viewFindViewById, 5);
            }
        });
        return this.aEB;
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected List<CtAdTemplate> getRealShowData() {
        return this.aDP;
    }

    private void initView() {
        EntryViewPager entryViewPager = (EntryViewPager) findViewById(R.id.ksad_entry_viewpager);
        this.aEy = entryViewPager;
        entryViewPager.setPageMargin(com.kwad.sdk.c.a.a.a(getContext(), 7.0f));
        this.aEy.setOffscreenPageLimit(3);
    }

    class a extends PagerAdapter implements ViewPager.OnPageChangeListener {
        private List<EntryPhotoView> aEF;
        private List<EntryPhotoView> aEG;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
        }

        private a() {
            this.aEF = new ArrayList();
            this.aEG = new ArrayList();
        }

        /* synthetic */ a(EntryScrollView entryScrollView, byte b) {
            this();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return EntryScrollView.this.aDP.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int i) {
            EntryScrollView entryScrollView = EntryScrollView.this;
            getCount();
            return entryScrollView.getPageItemWidth$255f285();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            EntryPhotoView entryPhotoViewRemove;
            if (this.aEF.size() > 0) {
                entryPhotoViewRemove = this.aEF.remove(0);
                entryPhotoViewRemove.aqP();
            } else {
                entryPhotoViewRemove = (EntryPhotoView) View.inflate(EntryScrollView.this.getContext(), R.layout.ksad_view_entryphoto, null);
            }
            if (EntryScrollView.this.getItemPlayRes() > 0) {
                entryPhotoViewRemove.setPlayBtnRes(EntryScrollView.this.getItemPlayRes());
            }
            entryPhotoViewRemove.setAdShowStyle(EntryScrollView.this.getAdShowStyle());
            viewGroup.addView(entryPhotoViewRemove);
            CtAdTemplate ctAdTemplate = (CtAdTemplate) EntryScrollView.this.aDP.get(i);
            entryPhotoViewRemove.p(EntryScrollView.this.getEnableWebp(), true);
            entryPhotoViewRemove.s(i, EntryScrollView.this.aCR.entryId);
            entryPhotoViewRemove.setOnEntryClickListener(EntryScrollView.this.n(i, ctAdTemplate));
            entryPhotoViewRemove.a(ctAdTemplate, EntryScrollView.this.aCR);
            entryPhotoViewRemove.setLikeViewPos(EntryScrollView.this.aCR.aVd);
            if (i == getCount() - 1 && !EntryScrollView.this.aEA) {
                entryPhotoViewRemove.setLookMoreVisible(true);
            } else {
                entryPhotoViewRemove.setLookMoreVisible(false);
            }
            entryPhotoViewRemove.setId(i);
            this.aEG.add(entryPhotoViewRemove);
            return entryPhotoViewRemove;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.aEF.add((EntryPhotoView) obj);
                this.aEG.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            EntryScrollView.this.aEy.findViewById(i);
            Iterator<EntryPhotoView> it = this.aEG.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
