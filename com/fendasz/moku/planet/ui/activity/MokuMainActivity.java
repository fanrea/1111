package com.fendasz.moku.planet.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.BuildConfig;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.helper.MokuHelper;
import com.fendasz.moku.planet.interf.Error;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.interf.observer.TagObserver;
import com.fendasz.moku.planet.interf.observer.TagObserverable;
import com.fendasz.moku.planet.source.bean.AppConfig;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.source.bean.TagForm;
import com.fendasz.moku.planet.source.bean.VideoConfig;
import com.fendasz.moku.planet.ui.adapter.MyFragmentPagerAdapter;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.dialog.GuideDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.ui.dialog.TaskDialog;
import com.fendasz.moku.planet.ui.fragment.ToBeCompletedFragment;
import com.fendasz.moku.planet.ui.popupwindow.LabelSearchPopupwindow;
import com.fendasz.moku.planet.utils.DateUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StatusBarUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import com.pandora.common.utils.Times;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuMainActivity extends BaseBackActivity implements TagObserverable {
    private static final String TAG = "MokuMainActivity";
    public static final String TASK_GROUP_TIPS_DATE_SP = "task_group_tips_date_sp";
    public static final String TASK_GROUP_TIPS_IMAGE_VIEW_SP = "task_group_tips_image_view_sp";
    private HashMap<Integer, ItemConfig> lableMap;
    private Context mContext;
    private List<Fragment> mFragments;
    private GuideDialog mGuideDialog;
    private ImageView mIvRightImage;
    private ImageView mIvVideoClose;
    private MediaPlayer mMediaPlayer;
    private MokuOptions mMokuOptions;
    private int mPagePosition;
    private PopupWindow mPuwUpdateTip;
    private RelativeLayout mRlVideoContainer;
    private RelativeLayout mRlVideoTipContainer;
    private TaskDialog mTaskDialog;
    private ImageView mTaskGroupTipsImageView;
    private ArrayList<String> mTitles;
    private MokuIconTextView mTvRightTextView;
    private TextView mTvVideoTip;
    private ViewPager mViewPager;
    private boolean needAliyunDevice;
    private List<TagObserver> observerList;
    private int onReadyState;
    private long resumeTime;
    private RelativeLayout rlContent;
    private volatile TagForm selectTagForm;
    private LabelSearchPopupwindow tagPopupwindow;
    private static final Integer ONREADYSTATE_WAITING = 0;
    private static final Integer ONREADYSTATE_START = 1;
    private static final Integer ONREADYSTATE_COMPLETE = 2;
    private static final Integer ONREADYSTATE_WATING_EXPIRED = 3;
    private boolean mIsDestroyed = false;
    private boolean mIsPlay = false;
    private boolean mIsPlayCompleted = true;
    private int uploadDeviceInfoSate = 0;
    private Integer reSubmittedStatus = 0;
    private boolean isOnReadStateInterrupt = false;

    private void initData() {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public boolean needLightSensor() {
        return true;
    }

    private void initStaticView() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i = SharedPreferencesUtils.getInstance(this.mContext).getInt(TASK_GROUP_TIPS_IMAGE_VIEW_SP, 0);
        String str = DateUtils.getFormatDate(SharedPreferencesUtils.getInstance(this.mContext).getLong("mokuTime", System.currentTimeMillis()), Times.YYYY_MM_DD) + " 00:00:00";
        String string = SharedPreferencesUtils.getInstance(this.mContext).getString(TASK_GROUP_TIPS_DATE_SP, str);
        this.mTaskGroupTipsImageView = (ImageView) this.rlContent.findViewById(R.id.task_group_tips_image_view);
        if (i == 1) {
            if ((DateUtils.getDate(str, "yyyy-MM-dd HH:mm:ss").getTime() - DateUtils.getDate(string, "yyyy-MM-dd HH:mm:ss").getTime()) / 86400000 >= 1) {
                this.mTaskGroupTipsImageView.setVisibility(0);
                this.mTaskGroupTipsImageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.m411xc7c389eb(view);
                    }
                });
            }
        }
        getRootView().requestFocus();
        this.mViewPager = (ViewPager) this.rlContent.findViewById(R.id.viewpager);
        Log.i(TAG, "ViewPager package name >> " + this.mViewPager.getClass().getName());
        LinearLayout linearLayout = (LinearLayout) this.rlContent.findViewById(R.id.ll_container);
        if (SharedPreferencesUtils.getInstance(this.mContext).getBoolean(this.mContext.getString(R.string.moku_sp_is_show_video), true)) {
            addVideoTipView(linearLayout);
        }
        addTabLayout(linearLayout);
    }

    /* renamed from: lambda$initStaticView$0$com-fendasz-moku-planet-ui-activity-MokuMainActivity, reason: not valid java name */
    /* synthetic */ void m411xc7c389eb(View view) {
        SharedPreferencesUtils.getInstance(this.mContext).putInt(TASK_GROUP_TIPS_IMAGE_VIEW_SP, -1);
        this.mTaskGroupTipsImageView.setVisibility(8);
    }

    private void initSearchTagLayout() {
        LinearLayout linearLayout = (LinearLayout) this.rlContent.findViewById(R.id.ll_container);
        final LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout.addView(linearLayout2, 1);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        ScreenAdaptationUtils.setSize(this.mContext, linearLayout2, -1, 100);
        int color = Color.parseColor(this.mMokuOptions.getString("tabTextColor", "#D2E5CF"));
        ImageView imageView = new ImageView(this);
        linearLayout2.addView(imageView);
        ScreenAdaptationUtils.setSize(this.mContext, imageView, 80, 80);
        imageView.setBackgroundResource(R.drawable.moku_tag_search);
        Drawable background = imageView.getBackground();
        if (Build.VERSION.SDK_INT >= 21) {
            background.setTint(color);
        }
        TextView textView = new TextView(this);
        linearLayout2.addView(textView);
        ScreenAdaptationUtils.setSize(this.mContext, textView, -2, -2);
        textView.setTextColor(color);
        textView.setText("筛选");
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("searchLayout", "show search layout");
                MokuMainActivity.this.mViewPager.setAlpha(0.5f);
                MokuMainActivity.this.tagPopupwindow.showAsDropDown(linearLayout2);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() throws NoSuchMethodException, SecurityException {
        super.onStart();
        Log.d(TAG, "set userdevice info taskDataId null");
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, null);
        TaskDialog taskDialog = this.mTaskDialog;
        if (taskDialog != null) {
            taskDialog.setDian(false);
        }
    }

    private void addTabLayout(LinearLayout linearLayout) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i;
        Class<?> cls = null;
        try {
            cls = Class.forName("com.google.android.material.tabs.TabLayout");
            Log.i(TAG, "isAndroidX >> false");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.google.android.material.tabs.TabLayout");
                Log.i(TAG, "isAndroidX >> true");
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        if (cls != null) {
            String str = TAG;
            Log.i(str, "got TabLayout Class");
            Log.i(str, "TabLayout Constructor size >> " + cls.getConstructors().length);
            for (int i2 = 0; i2 < cls.getConstructors().length; i2++) {
                Log.i(TAG, cls.getConstructors()[i2].getName());
                for (int i3 = 0; i3 < cls.getConstructors()[i2].getParameterTypes().length; i3++) {
                    Log.i(TAG, cls.getConstructors()[i2].getParameterTypes()[i3].getName());
                }
            }
            try {
                Constructor<?> constructor = cls.getConstructor(Context.class);
                String str2 = TAG;
                Log.i(str2, "found constructor >> " + constructor.getName());
                try {
                    try {
                        try {
                            View view = (View) constructor.newInstance(this.mContext);
                            Log.i(str2, "got TabLayout instance");
                            linearLayout.addView(view, 0);
                            ScreenAdaptationUtils.setSize(this.mContext, view, -1, 120);
                            ScreenAdaptationUtils.setPaddingBottom(this.mContext, view, 6);
                            try {
                                cls.getMethod("setSelectedTabIndicatorHeight", Integer.TYPE).invoke(view, Integer.valueOf(this.phoneScreenUtils.getScale(this.mContext, 6.0f)));
                            } catch (NoSuchMethodException e3) {
                                e3.printStackTrace();
                            }
                            try {
                                Method method = cls.getMethod("setTabMode", Integer.TYPE);
                                try {
                                    i = cls.getDeclaredField("MODE_FIXED").getInt(view);
                                } catch (NoSuchFieldException e4) {
                                    e4.printStackTrace();
                                    i = 1;
                                }
                                method.invoke(view, Integer.valueOf(i));
                            } catch (NoSuchMethodException e5) {
                                e5.printStackTrace();
                            }
                            try {
                                cls.getMethod("setBackgroundColor", Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabBackgroundColor", "#efefef"))));
                            } catch (NoSuchMethodException e6) {
                                e6.printStackTrace();
                            }
                            try {
                                cls.getMethod("setSelectedTabIndicatorColor", Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabIndicatorColor", "#FB823B"))));
                            } catch (NoSuchMethodException e7) {
                                e7.printStackTrace();
                            }
                            try {
                                cls.getMethod("setTabTextColors", Integer.TYPE, Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabTextColor", "#6E6E6E"))), Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabSelectedTextColor", "#000000"))));
                            } catch (NoSuchMethodException e8) {
                                e8.printStackTrace();
                            }
                            try {
                                cls.getMethod("setupWithViewPager", this.mViewPager.getClass()).invoke(view, this.mViewPager);
                            } catch (NoSuchMethodException e9) {
                                e9.printStackTrace();
                            }
                        } catch (InvocationTargetException e10) {
                            e10.printStackTrace();
                        }
                    } catch (IllegalAccessException e11) {
                        e11.printStackTrace();
                    }
                } catch (InstantiationException e12) {
                    e12.printStackTrace();
                }
            } catch (NoSuchMethodException e13) {
                e13.printStackTrace();
            }
        }
    }

    private void addVideoTipView(LinearLayout linearLayout) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mRlVideoTipContainer = relativeLayout;
        linearLayout.addView(relativeLayout, 0);
        ScreenAdaptationUtils.setSize(this.mContext, this.mRlVideoTipContainer, -1, 80);
        this.mRlVideoTipContainer.setBackgroundColor(this.mContext.getResources().getColor(R.color.moku_gray_light));
        TextView textView = new TextView(this.mContext);
        this.mTvVideoTip = textView;
        textView.setTextColor(this.mContext.getResources().getColor(R.color.moku_blue_dark));
        this.mRlVideoTipContainer.addView(this.mTvVideoTip);
        this.mTvVideoTip.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTvVideoTip.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.leftMargin = this.phoneScreenUtils.getScale(this.mContext, 15.0f);
        this.mTvVideoTip.setLayoutParams(layoutParams);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.moku_close_black);
        if (bitmapDecodeResource != null) {
            ImageView imageView = new ImageView(this.mContext);
            this.mIvVideoClose = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.mIvVideoClose.setImageBitmap(bitmapDecodeResource);
            this.mRlVideoTipContainer.addView(this.mIvVideoClose);
            ScreenAdaptationUtils.setSize(this.mContext, this.mIvVideoClose, 40, 40);
            ScreenAdaptationUtils.setMarginRight(this.mContext, this.mIvVideoClose, 15);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mIvVideoClose.getLayoutParams();
            layoutParams2.addRule(15);
            layoutParams2.addRule(11);
            this.mIvVideoClose.setLayoutParams(layoutParams2);
        }
    }

    private void destroy() {
        if (this.mIsDestroyed) {
            return;
        }
        PopupWindow popupWindow = this.mPuwUpdateTip;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPuwUpdateTip.dismiss();
        }
        Log.i(TAG, "start CloseDisposable");
        this.mIsDestroyed = true;
        TaskDialog taskDialog = this.mTaskDialog;
        if (taskDialog != null) {
            taskDialog.onDestroy();
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onMokuMainActivityPause");
        if (isFinishing()) {
            destroy();
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.i(TAG, "onMokuMainActivityDestroy");
        destroy();
        super.onDestroy();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_main, viewGroup, false);
        this.rlContent = relativeLayout;
        return relativeLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, android.app.Activity
    public void finish() {
        try {
            ApiDataHelper.getInstance(this.mContext).closeDisposable();
        } catch (MokuException e) {
            e.printStackTrace();
        }
        super.finish();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        String string;
        if (textView == null || (string = this.mMokuOptions.getString("titleText", null)) == null) {
            return;
        }
        textView.setText(string);
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
        this.mTvRightTextView = mokuIconTextView;
        mokuIconTextView.setVisibility(0);
        this.mTvRightTextView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        this.mTvRightTextView.setText(((Object) this.mTvRightTextView.getText()) + "我参与的");
        this.mTvRightTextView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m410x5ab1f256(view);
            }
        });
        showUpdateTip();
    }

    /* renamed from: lambda$initRightView$1$com-fendasz-moku-planet-ui-activity-MokuMainActivity, reason: not valid java name */
    /* synthetic */ void m410x5ab1f256(View view) {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyParticipateInActivity.class));
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView, ImageView imageView) {
        super.initRightView(mokuIconTextView, imageView);
        this.mIvRightImage = imageView;
    }

    private void showUpdateTip() {
        MokuIconTextView mokuIconTextView;
        if (SharedPreferencesUtils.getInstance(this.mContext).getString(this.mContext.getString(R.string.moku_sp_version_name), "").equals(BuildConfig.VERSION_NAME) || (mokuIconTextView = this.mTvRightTextView) == null) {
            return;
        }
        mokuIconTextView.post(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(MokuMainActivity.this.mContext.getResources(), R.drawable.moku_img_update_tip);
                if (bitmapDecodeResource == null || MokuMainActivity.this.mTvRightTextView == null) {
                    return;
                }
                int[] iArr = new int[2];
                MokuMainActivity.this.mTvRightTextView.getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                int scale = MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 50.0f);
                float f = i - scale;
                float height = (bitmapDecodeResource.getHeight() * f) / bitmapDecodeResource.getWidth();
                ImageView imageView = new ImageView(MokuMainActivity.this.mContext);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int i3 = (int) f;
                int i4 = (int) height;
                imageView.setLayoutParams(new ViewGroup.LayoutParams(i3, i4));
                imageView.setImageBitmap(bitmapDecodeResource);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (MokuMainActivity.this.mPuwUpdateTip != null && MokuMainActivity.this.mPuwUpdateTip.isShowing()) {
                            MokuMainActivity.this.mPuwUpdateTip.dismiss();
                        }
                        SharedPreferencesUtils.getInstance(MokuMainActivity.this.mContext).putString(MokuMainActivity.this.mContext.getString(R.string.moku_sp_version_name), BuildConfig.VERSION_NAME);
                    }
                });
                MokuMainActivity.this.mPuwUpdateTip = new PopupWindow(imageView, i3, i4);
                MokuMainActivity.this.mPuwUpdateTip.setOutsideTouchable(false);
                MokuMainActivity.this.mPuwUpdateTip.showAtLocation(MokuMainActivity.this.getRootView(), 0, scale, i2 + MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 20.0f));
            }
        });
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        initStaticView();
        initData();
        initListener();
        this.onReadyState = ONREADYSTATE_WAITING.intValue();
        new Handler().postDelayed(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.3
            @Override // java.lang.Runnable
            public void run() throws NoSuchMethodException, SecurityException {
                Log.d(MokuMainActivity.TAG, "onLoad_isOnReadStateInterrupt=>" + MokuMainActivity.this.isOnReadStateInterrupt);
                if (MokuMainActivity.this.isOnReadStateInterrupt) {
                    return;
                }
                Log.d(MokuMainActivity.TAG, "onLoad_waiting time finished,upload optical at -1");
                MokuConfigure.getInstance().updateOptical(MokuMainActivity.this.mContext, "-1");
                MokuMainActivity.this.uploadDeviceInfo();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReady() throws Resources.NotFoundException {
        Log.d(TAG, "onReady==>");
        this.onReadyState = ONREADYSTATE_START.intValue();
        if (this.mTvVideoTip != null) {
            getVideoConfig(null, new Error() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.4
                @Override // com.fendasz.moku.planet.interf.Error
                public void error(Integer num, String str) {
                }
            }, null);
        }
        final int integer = MokuConfigure.getInstance().getMokuOptions(this.mContext).getInteger("cutInType", 0);
        if (integer == 0) {
            try {
                MokuHelper.getMokuTaskDialog(this.mContext, new Consumer<TaskDialog>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.5
                    @Override // com.fendasz.moku.planet.interf.functions.Consumer
                    public void accept(TaskDialog taskDialog) throws Exception {
                        MokuMainActivity.this.mTaskDialog = taskDialog;
                        MokuMainActivity.this.mTaskDialog.setDian(false);
                        MokuMainActivity.this.mTaskDialog.setOnDialogClosed(new TaskDialog.OnDialogClosed() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.5.1
                            @Override // com.fendasz.moku.planet.ui.dialog.TaskDialog.OnDialogClosed
                            public void onClosed(boolean z) {
                                if (z) {
                                    MokuMainActivity.this.setFragmentResult(200, 300, null);
                                }
                                MokuMainActivity.this.mTaskDialog = null;
                            }
                        });
                        MokuMainActivity.this.mTaskDialog.show();
                    }
                });
            } catch (MokuException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        if (integer == -1) {
            ArrayList arrayList = new ArrayList();
            AppConfig appConfig = new AppConfig();
            appConfig.setLableName("全部");
            appConfig.setLableParam(0);
            arrayList.add(appConfig);
            AppConfig appConfig2 = new AppConfig();
            appConfig2.setLableName("简单");
            appConfig2.setLableParam(1);
            arrayList.add(appConfig2);
            AppConfig appConfig3 = new AppConfig();
            appConfig3.setLableName("高额");
            appConfig3.setLableParam(2);
            arrayList.add(appConfig3);
            initTabData(arrayList, integer);
            LoadingDialog.dismiss();
            getReSubmittedStatus();
            return;
        }
        Log.d(TAG, "getItemConfig invoke");
        ApiDataHelper.getApiDataHelper().getItemConfig(this, new ApiDataCallBack<List<ItemConfig>>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ItemConfig> list) throws Exception {
                LoadingDialog.dismiss();
                Log.d(MokuMainActivity.TAG, "getItemConfig success");
                MokuMainActivity.this.initTabDataWithTag(list, integer);
                MokuMainActivity.this.onReadyState = MokuMainActivity.ONREADYSTATE_COMPLETE.intValue();
                MokuMainActivity.this.getReSubmittedStatus();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                Log.e(MokuMainActivity.TAG, "getItemConfig success");
                MokuMainActivity.this.onReadyState = MokuMainActivity.ONREADYSTATE_COMPLETE.intValue();
                MokuMainActivity.this.getReSubmittedStatus();
            }
        });
    }

    private void initTabData(List<AppConfig> list, int i) throws Resources.NotFoundException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            AppConfig appConfig = list.get(i2);
            this.mTitles.add(appConfig.getLableName());
            ToBeCompletedFragment toBeCompletedFragment = new ToBeCompletedFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("tag", appConfig.getLableParam());
            bundle.putInt("pageIndex", i2);
            bundle.putInt("cutInType", i);
            toBeCompletedFragment.setArguments(bundle);
            this.mFragments.add(toBeCompletedFragment);
        }
        this.mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), this.mFragments, this.mTitles));
        this.mViewPager.setOffscreenPageLimit(this.mFragments.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTabDataWithTag(List<ItemConfig> list, int i) throws Resources.NotFoundException {
        this.lableMap = new HashMap<>();
        this.observerList = new ArrayList(list.size());
        int itemId = -1;
        List<TagForm> tagForm = null;
        if (list != null && list.size() > 0) {
            int i2 = 0;
            for (ItemConfig itemConfig : list) {
                this.mTitles.add(itemConfig.getItemName());
                ToBeCompletedFragment toBeCompletedFragment = new ToBeCompletedFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("tag", itemConfig.getItemId().intValue());
                bundle.putInt("pageIndex", i2);
                bundle.putString("tagData", JSON.toJSONString(itemConfig));
                bundle.putInt("cutInType", i);
                if (i2 == 0) {
                    bundle.putBoolean("isAllConfig", true);
                } else {
                    bundle.putBoolean("isAllConfig", false);
                }
                toBeCompletedFragment.setArguments(bundle);
                this.mFragments.add(toBeCompletedFragment);
                registerObserver(toBeCompletedFragment);
                this.lableMap.put(Integer.valueOf(i2), itemConfig);
                if (i2 == 0) {
                    tagForm = itemConfig.getTagForm();
                    itemId = itemConfig.getItemId();
                }
                i2++;
            }
            this.mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), this.mFragments, this.mTitles));
            this.mViewPager.setOffscreenPageLimit(this.mFragments.size());
        }
        if (this.tagPopupwindow == null) {
            LabelSearchPopupwindow labelSearchPopupwindow = new LabelSearchPopupwindow(this, tagForm);
            this.tagPopupwindow = labelSearchPopupwindow;
            labelSearchPopupwindow.setConfigId(itemId);
            this.tagPopupwindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.7
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    MokuMainActivity.this.mViewPager.setAlpha(1.0f);
                }
            });
            this.tagPopupwindow.setOnTagFormSelectLisenter(new LabelSearchPopupwindow.OnTagFormSelectLisenter() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity$$ExternalSyntheticLambda2
                @Override // com.fendasz.moku.planet.ui.popupwindow.LabelSearchPopupwindow.OnTagFormSelectLisenter
                public final void onTagFormSelect(TagForm tagForm2) {
                    this.f$0.m412x3d593e87(tagForm2);
                }
            });
        }
        initSearchTagLayout();
    }

    /* renamed from: lambda$initTabDataWithTag$2$com-fendasz-moku-planet-ui-activity-MokuMainActivity, reason: not valid java name */
    /* synthetic */ void m412x3d593e87(TagForm tagForm) {
        this.tagPopupwindow.dismiss();
        this.selectTagForm = tagForm;
        notifyObserver();
    }

    private void initListener() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.8
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i, float f, int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    MokuMainActivity.this.mPagePosition = i;
                    if (MokuMainActivity.this.lableMap != null) {
                        ItemConfig itemConfig = (ItemConfig) MokuMainActivity.this.lableMap.get(Integer.valueOf(i));
                        MokuMainActivity.this.tagPopupwindow.setLabelList(itemConfig.getTagForm());
                        MokuMainActivity.this.tagPopupwindow.setConfigId(itemConfig.getItemId());
                        MokuMainActivity.this.itemLog("0", itemConfig.getItemId().intValue(), itemConfig.getTagIdList());
                    }
                }
            });
        }
        RelativeLayout relativeLayout = this.mRlVideoTipContainer;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LoadingDialog.show(MokuMainActivity.this.mContext);
                    MokuMainActivity.this.getVideoConfig(new Success<VideoConfig>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.9.1
                        @Override // com.fendasz.moku.planet.interf.Success
                        public void success(Integer num, VideoConfig videoConfig) {
                            if (videoConfig != null) {
                                MokuMainActivity.this.startVideoActivity(videoConfig);
                            }
                        }
                    }, new Error() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.9.2
                        @Override // com.fendasz.moku.planet.interf.Error
                        public void error(Integer num, String str) {
                            Toast.makeText(MokuMainActivity.this.mContext, str + num, 0).show();
                        }
                    }, new Finish() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.9.3
                        @Override // com.fendasz.moku.planet.interf.Finish
                        public void finish() {
                            LoadingDialog.dismiss();
                        }
                    });
                }
            });
        }
        ImageView imageView = this.mIvVideoClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SharedPreferencesUtils.getInstance(MokuMainActivity.this.mContext).putBoolean(MokuMainActivity.this.mContext.getString(R.string.moku_sp_is_show_video), false);
                    if (MokuMainActivity.this.mRlVideoTipContainer != null) {
                        MokuMainActivity.this.mRlVideoTipContainer.setVisibility(8);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startVideoActivity(VideoConfig videoConfig) {
        Intent intent = new Intent(this.mContext, (Class<?>) VideoActivity.class);
        intent.putExtra(this.mContext.getString(R.string.moku_intent_extra__video_url), Uri.parse(videoConfig.getVideoUrl()).toString());
        this.mContext.startActivity(intent);
    }

    private void showVideo(VideoConfig videoConfig) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        RelativeLayout rootView;
        String videoUrl = videoConfig.getVideoUrl();
        if (TextUtils.isEmpty(videoUrl) || (rootView = getRootView()) == null) {
            return;
        }
        Context context = this.mContext;
        StatusBarUtils.setStatusBarColor((Activity) context, context.getResources().getColor(R.color.black));
        this.mMediaPlayer = new MediaPlayer();
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mRlVideoContainer = relativeLayout;
        rootView.addView(relativeLayout);
        PopupWindow popupWindow = this.mPuwUpdateTip;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPuwUpdateTip.dismiss();
        }
        ScreenAdaptationUtils.setSize(this.mContext, this.mRlVideoContainer, -1, -1);
        this.mRlVideoContainer.setBackgroundColor(this.mContext.getResources().getColor(R.color.black));
        final SurfaceView surfaceView = new SurfaceView(this.mContext);
        this.mRlVideoContainer.addView(surfaceView);
        ImageView imageView = new ImageView(this.mContext);
        this.mRlVideoContainer.addView(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.moku_close_white));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        imageView.setLayoutParams(layoutParams);
        ScreenAdaptationUtils.setSize(this.mContext, imageView, 100, 100);
        ScreenAdaptationUtils.setMarginTop(this.mContext, imageView, 20);
        ScreenAdaptationUtils.setMarginRight(this.mContext, imageView, 20);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IllegalStateException {
                if (MokuMainActivity.this.mIsPlay && MokuMainActivity.this.mMediaPlayer != null) {
                    MokuMainActivity.this.mMediaPlayer.stop();
                }
                MokuMainActivity.this.onVideoEnd();
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.12
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(final MediaPlayer mediaPlayer) throws IllegalStateException {
                Log.i(MokuMainActivity.TAG, "onPrepared");
                LoadingDialog.dismiss();
                float videoHeight = mediaPlayer.getVideoHeight();
                float videoWidth = mediaPlayer.getVideoWidth();
                if (videoHeight <= 0.0f || videoWidth <= 0.0f) {
                    return;
                }
                float width = MokuMainActivity.this.mRlVideoContainer.getWidth();
                float height = MokuMainActivity.this.mRlVideoContainer.getHeight();
                float f = videoHeight / videoWidth >= height / width ? height / videoHeight : width / videoWidth;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (videoWidth * f), (int) (videoHeight * f));
                layoutParams2.addRule(13);
                surfaceView.setLayoutParams(layoutParams2);
                mediaPlayer.start();
                MokuMainActivity.this.mIsPlay = true;
                MokuMainActivity.this.mIsPlayCompleted = false;
                MokuMainActivity.this.mRlVideoContainer.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.12.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) throws IllegalStateException {
                        if (!MokuMainActivity.this.mIsPlay || !mediaPlayer.isPlaying()) {
                            MokuMainActivity.this.mIsPlay = true;
                            mediaPlayer.start();
                        } else {
                            MokuMainActivity.this.mIsPlay = false;
                            mediaPlayer.pause();
                        }
                    }
                });
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.13
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.i(MokuMainActivity.TAG, "play complete");
                MokuMainActivity.this.onVideoEnd();
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.14
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                Log.i(MokuMainActivity.TAG, "play error");
                MokuMainActivity.this.onVideoEnd();
                return false;
            }
        });
        try {
            this.mMediaPlayer.setDataSource(Uri.parse(videoUrl).toString());
        } catch (IOException e) {
            e.printStackTrace();
            onVideoEnd();
        }
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.15
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) throws IllegalStateException {
                Log.i(MokuMainActivity.TAG, "onSurfaceCreated");
                MokuMainActivity.this.mMediaPlayer.setDisplay(surfaceView.getHolder());
                if (MokuMainActivity.this.mIsPlayCompleted) {
                    MokuMainActivity.this.mMediaPlayer.prepareAsync();
                    LoadingDialog.show(MokuMainActivity.this.mContext);
                } else if (MokuMainActivity.this.mMediaPlayer != null) {
                    MokuMainActivity.this.mMediaPlayer.start();
                    MokuMainActivity.this.mIsPlay = true;
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.i(MokuMainActivity.TAG, "onSurfaceChanged");
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) throws IllegalStateException {
                Log.i(MokuMainActivity.TAG, "onSurfaceDestroyed");
                if (MokuMainActivity.this.mMediaPlayer == null || !MokuMainActivity.this.mMediaPlayer.isPlaying()) {
                    return;
                }
                MokuMainActivity.this.mMediaPlayer.pause();
                MokuMainActivity.this.mIsPlay = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoEnd() {
        RelativeLayout rootView;
        Log.i(TAG, "onVideoEnd");
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mMediaPlayer = null;
        }
        if (this.mRlVideoContainer != null && (rootView = getRootView()) != null) {
            rootView.removeView(this.mRlVideoContainer);
            this.mRlVideoContainer = null;
        }
        this.mIsPlay = false;
        this.mIsPlayCompleted = true;
        initStatusBarColor();
        PopupWindow popupWindow = this.mPuwUpdateTip;
        if (popupWindow == null || !popupWindow.isShowing()) {
            showUpdateTip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVideoConfig(final Success<VideoConfig> success, final Error error, final Finish finish) {
        ApiDataHelper.getApiDataHelper().getVideoConfig(this.mContext, new ApiDataCallBack<VideoConfig>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.16
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, VideoConfig videoConfig) throws Exception {
                if (videoConfig != null) {
                    String title = videoConfig.getTitle();
                    if (!TextUtils.isEmpty(title) && MokuMainActivity.this.mTvVideoTip != null) {
                        MokuMainActivity.this.mTvVideoTip.setText(title);
                    }
                }
                Success success2 = success;
                if (success2 != null) {
                    success2.success(Integer.valueOf(i), videoConfig);
                }
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                if (MokuMainActivity.this.mTvVideoTip != null) {
                    MokuMainActivity.this.mTvVideoTip.setText(MokuMainActivity.this.mContext.getString(R.string.moku_video_tip_default));
                }
                Error error2 = error;
                if (error2 != null) {
                    error2.error(Integer.valueOf(i), str);
                }
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        this.resumeTime = System.currentTimeMillis();
        if (this.mTvRightTextView != null) {
            showGuideMyParticipateInTip();
        }
        getReSubmittedStatus();
    }

    private void showGuideMyParticipateInTip() {
        if (SharedPreferencesUtils.getInstance(this.mContext).getInt(this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 0) == 1) {
            final LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_masking_button, (ViewGroup) null);
            final TextView textView = (TextView) linearLayout.findViewById(R.id.tv_btn_masking);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.white));
            textView.setTextSize(this.phoneScreenUtils.getBigTextSize(this.mContext));
            textView.setText(this.mContext.getString(R.string.moku_masking_btn_text__i_know));
            ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, textView, 15);
            ScreenAdaptationUtils.setPaddingLeftAndRight(this.mContext, textView, 70);
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.17
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    float height = textView.getHeight() / 2;
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{height, height, height, height, height, height, height, height}, null, null));
                    shapeDrawable.getPaint().setColor(MokuMainActivity.this.mContext.getResources().getColor(R.color.white));
                    shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
                    shapeDrawable.getPaint().setStrokeWidth(2.0f);
                    textView.setBackground(shapeDrawable);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MokuMainActivity.this.mGuideDialog == null || !MokuMainActivity.this.mGuideDialog.isShowing()) {
                        return;
                    }
                    MokuMainActivity.this.mGuideDialog.dismiss();
                }
            });
            this.mTvRightTextView.post(new Runnable() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.19
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (MokuMainActivity.this.mTvRightTextView == null || linearLayout == null) {
                        return;
                    }
                    Integer[] numArr = {Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 0.0f)), Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 0.0f)), Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 0.0f)), Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 0.0f))};
                    Integer[] numArr2 = {Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 10.0f)), Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 100.0f)), Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 0.0f)), Integer.valueOf(MokuMainActivity.this.phoneScreenUtils.getScale(MokuMainActivity.this.mContext, 150.0f))};
                    SharedPreferencesUtils.getInstance(MokuMainActivity.this.mContext).putInt(MokuMainActivity.this.mContext.getString(R.string.moku_sp_is_show_guide_my_participate_in_tip), 4);
                    MokuMainActivity mokuMainActivity = MokuMainActivity.this;
                    mokuMainActivity.showMasking(mokuMainActivity.mTvRightTextView, false, BitmapFactory.decodeResource(MokuMainActivity.this.mContext.getResources(), R.drawable.moku_img_masking_my_participate_in_tip), GuideDialog.Orientation.BOTTOM_LEFT, numArr, numArr2, linearLayout);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMasking(View view, Boolean bool, Bitmap bitmap, GuideDialog.Orientation orientation, Integer[] numArr, Integer[] numArr2, View view2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        GuideDialog.Builder builder = new GuideDialog.Builder(this.mContext);
        if (view != null) {
            builder.setHighlightView(view);
        }
        if (bool != null) {
            builder.setIsHighlight(bool.booleanValue());
        }
        if (bitmap != null) {
            builder.setGuideBitmap(bitmap);
        }
        if (orientation != null) {
            builder.setOrientation(orientation);
        }
        if (numArr != null) {
            builder.setHighlightViewMargin(numArr[0], numArr[1], numArr[2], numArr[3]);
        }
        if (numArr2 != null) {
            builder.setGuideBitMapMargin(numArr2[0], numArr2[1], numArr2[2], numArr2[3]);
        }
        if (view2 != null) {
            builder.setView(view2);
        }
        GuideDialog guideDialogCreate = builder.create();
        this.mGuideDialog = guideDialogCreate;
        guideDialogCreate.show();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onRestart() throws NoSuchMethodException, SecurityException {
        super.onRestart();
        TaskDialog taskDialog = this.mTaskDialog;
        if (taskDialog != null) {
            taskDialog.onRestart();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mMediaPlayer != null) {
            onVideoEnd();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        this.mPagePosition = 0;
        this.mFragments = new ArrayList();
        this.mTitles = new ArrayList<>();
        Log.d(TAG, "on supercreate,start to get oaid");
        updateOaid();
        if (bundle != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            List<Fragment> fragments = supportFragmentManager.getFragments();
            try {
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < fragments.size(); i++) {
                    fragmentTransactionBeginTransaction.remove(fragments.get(i));
                }
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mMokuOptions = MokuConfigure.getInstance().getMokuOptions(this.mContext);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setFragmentResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFragmentResult(int i, int i2, Intent intent) {
        for (int i3 = 0; i3 < this.mFragments.size(); i3++) {
            ((ToBeCompletedFragment) this.mFragments.get(i3)).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.fendasz.moku.planet.interf.observer.TagObserverable
    public void registerObserver(TagObserver tagObserver) {
        this.observerList.add(tagObserver);
    }

    @Override // com.fendasz.moku.planet.interf.observer.TagObserverable
    public void removeObserver(TagObserver tagObserver) {
        this.observerList.remove(tagObserver);
    }

    @Override // com.fendasz.moku.planet.interf.observer.TagObserverable
    public void notifyObserver() {
        synchronized (this.selectTagForm) {
            Iterator<TagObserver> it = this.observerList.iterator();
            while (it.hasNext()) {
                it.next().select(this.tagPopupwindow.getConfigId(), this.selectTagForm);
            }
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void acceptLightData(float f) throws NoSuchMethodException, SecurityException {
        super.acceptLightData(f);
        if (this.uploadDeviceInfoSate == 0) {
            this.uploadDeviceInfoSate = 1;
            MokuConfigure.getInstance().updateOptical(this.mContext, String.valueOf(f));
            uploadDeviceInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemLog(String str, int i, List<Integer> list) {
        ApiDataHelper.getApiDataHelper().itemLog(this.mContext, str, null, i, list, null, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.20
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i2, Object obj) throws Exception {
                Log.d(MokuMainActivity.TAG, "itemLog success");
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i2, String str2) throws Exception {
                Log.e(MokuMainActivity.TAG, "itemLog_error,msg =>" + str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void uploadDeviceInfo() {
        String str = TAG;
        Log.d(str, "uploadDeviceInfo==>" + this.uploadDeviceInfoSate);
        if (this.onReadyState != ONREADYSTATE_WAITING.intValue()) {
            Log.d(str, "onReadyState is not waiting");
            return;
        }
        Log.d(str, "start upload device info,make isOnReadStateInterrupt is true and inovke onready");
        this.isOnReadStateInterrupt = true;
        int i = SharedPreferencesUtils.getInstance(this.mContext).getInt(MokuConstants.SP_DIAN_USER_TYPE_KEY, -1);
        LogUtils.longLogD(str, "uploadDeviceInfo,get user type from local,userType is=>" + i);
        if (i == -1 || i == 0) {
            Log.d(str, "uploadDeviceInfo,user type is -1 or 0,need to request server");
            ApiDataHelper.getApiDataHelper().getUserType(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.21
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i2, Object obj) throws Exception {
                    Log.e(MokuMainActivity.TAG, "uploadDeviceInfo_getUserType success,getUsertype method invoke success,code is 0");
                    MokuConfigure.getInstance().updateUserType(MokuMainActivity.this.mContext, 0);
                    MokuMainActivity.this.uploadUserDviceInfo();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i2, String str2) throws Exception {
                    Log.d(MokuMainActivity.TAG, "uploadDeviceInfo_getUserType error,code=>" + i2);
                    int i3 = 0;
                    if (i2 != 6004 && i2 == 6005) {
                        i3 = 1;
                    }
                    MokuConfigure.getInstance().updateUserType(MokuMainActivity.this.mContext, i3);
                    SharedPreferencesUtils.getInstance(MokuMainActivity.this.mContext).putInt(MokuConstants.SP_DIAN_USER_TYPE_KEY, i3);
                    MokuMainActivity.this.uploadUserDviceInfo();
                }
            });
        } else {
            Log.d(str, "uploadDeviceInfo,user type not -1 and 0,don't request server");
            MokuConfigure.getInstance().updateUserType(this.mContext, i);
            uploadUserDviceInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadUserDviceInfo() throws NoSuchMethodException, SecurityException {
        Log.d(TAG, "uploadUserDviceInfo invoke");
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.22
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                Log.d(MokuMainActivity.TAG, "uploadUserDviceInfo,uploade device info success");
                MokuMainActivity.this.uploadDeviceInfoSate = 2;
                MokuMainActivity.this.onReady();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                Log.e(MokuMainActivity.TAG, "uploadUserDviceInfo,uploade device info error=>" + str);
                MokuMainActivity.this.uploadDeviceInfoSate = 3;
                MokuMainActivity.this.onReady();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getReSubmittedStatus() {
        ApiDataHelper.getApiDataHelper().getReSubmittedStatus(this.mContext, new ApiDataCallBack<Integer>() { // from class: com.fendasz.moku.planet.ui.activity.MokuMainActivity.23
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Integer num) throws Exception {
                if (num != null) {
                    MokuMainActivity.this.reSubmittedStatus = num;
                } else {
                    MokuMainActivity.this.reSubmittedStatus = 0;
                }
                if (MokuMainActivity.this.reSubmittedStatus.intValue() > 0) {
                    MokuMainActivity.this.mIvRightImage.setVisibility(0);
                } else {
                    MokuMainActivity.this.mIvRightImage.setVisibility(4);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                MokuMainActivity.this.mIvRightImage.setVisibility(4);
            }
        });
    }
}
