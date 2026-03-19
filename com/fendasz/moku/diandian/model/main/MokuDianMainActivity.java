package com.fendasz.moku.diandian.model.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.fendasz.moku.adapter.MokuMainAdapter;
import com.fendasz.moku.diandian.commons.MokuDianActivity;
import com.fendasz.moku.diandian.commons.MokuDianFragment;
import com.fendasz.moku.diandian.model.detail.DianCPLDetailActivity;
import com.fendasz.moku.diandian.model.detail.DianCpaDetailActivity;
import com.fendasz.moku.diandian.model.ferret.FerretActivity;
import com.fendasz.moku.diandian.model.participate.DianParticipateActivity;
import com.fendasz.moku.planet.BuildConfig;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.constants.MokuConstants;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.exception.MokuException;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.helper.MokuHelper;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.ui.dialog.TaskDialog;
import com.fendasz.moku.planet.utils.ImageUtils;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuDianMainActivity extends MokuDianActivity {
    private static final int HANDER_WHAT_TASK_DIALOG = 1000;
    public static final int REQUEST_CODE_FOR_MOKU_DETAIL = 200;
    private static final String TAG = "Moku_dian_MAIN=>";
    private Integer cutType;
    private List<MokuDianFragment> fragmentList;
    private Context mContext;
    private MokuOptions mMokuOptions;
    private PopupWindow mPuwUpdateTip;
    private TaskDialog mTaskDialog;
    private MokuIconTextView mTvRightTextView;
    private MokuMainAdapter mainAdapter;
    private MyHander myHander;
    private TextView playTips;
    private LinearLayout playingLinearLayout;
    private LinearLayout rootView;
    private ViewPager viewPager;
    private int uploadDeviceInfoSate = 0;
    private boolean fragmentDataFlag = false;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public boolean needLightSensor() {
        return true;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        super.onSuperCreate(bundle);
        updateOaid();
        this.mContext = this;
        this.myHander = new MyHander(this);
        this.uploadDeviceInfoSate = 0;
        this.mMokuOptions = MokuConfigure.getInstance().getMokuOptions(this.mContext);
        this.cutType = Integer.valueOf(MokuConfigure.getInstance().getMokuOptions(this.mContext).getInteger("cutInType", 0));
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_dian_main, viewGroup, false);
        this.rootView = linearLayout;
        return linearLayout;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        String string;
        super.initTitle(textView);
        if (textView == null || (string = this.mMokuOptions.getString("titleText", null)) == null) {
            return;
        }
        textView.setText(string);
        textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MokuDianMainActivity.this.finish();
            }
        });
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
        this.mTvRightTextView = mokuIconTextView;
        mokuIconTextView.setVisibility(0);
        this.mTvRightTextView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 50.0f)));
        this.mTvRightTextView.setText(((Object) this.mTvRightTextView.getText()) + "我参与的");
        this.mTvRightTextView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m398xd2f1e904(view);
            }
        });
        showUpdateTip();
    }

    /* renamed from: lambda$initRightView$0$com-fendasz-moku-diandian-model-main-MokuDianMainActivity, reason: not valid java name */
    /* synthetic */ void m398xd2f1e904(View view) {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) DianParticipateActivity.class));
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.initView();
        LogUtils.logD(TAG, "initView invoke");
        this.rootView.setBackgroundColor(-1);
        this.viewPager = (ViewPager) this.rootView.findViewById(R.id.moku_dian_viewpager);
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.moku_ll_playing);
        this.playingLinearLayout = linearLayout;
        ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).setMargins(20, 0, 0, 20);
        addTabLayout((LinearLayout) this.rootView.findViewById(R.id.moku_ll_task));
        this.rootView.findViewById(R.id.moku_ll_search).setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MokuDianMainActivity.this.fragmentDataFlag) {
                    MokuDianMainActivity.this.startActivityForResult(new Intent(MokuDianMainActivity.this, (Class<?>) FerretActivity.class), 10000);
                }
            }
        });
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() throws NoSuchMethodException, SecurityException {
        super.onLoad();
        initData();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void acceptLightData(float f) throws NoSuchMethodException, SecurityException {
        super.acceptLightData(f);
        MokuConfigure.getInstance().updateOptical(this.mContext, String.valueOf(f));
    }

    public void updateDataFlagSuccess() {
        this.fragmentDataFlag = true;
    }

    protected void initData() throws NoSuchMethodException, SecurityException {
        LogUtils.logD(TAG, "initData_id:" + Thread.currentThread().getId());
        Executors.newFixedThreadPool(5).execute(new DianRunable());
        this.uploadDeviceInfoSate = 1;
        int i = SharedPreferencesUtils.getInstance(this.mContext).getInt(MokuConstants.SP_USER_TYPE_KEY, -1);
        LogUtils.longLogD(TAG, "uploadDeviceInfo,get user type from local,userType is=>" + i);
        if (i == -1 || i == 0) {
            LogUtils.logD(TAG, "uploadDeviceInfo,user type is -1 or 0,need to request server");
            ApiDataHelper.getApiDataHelper().getUserType(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.3
                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void success(int i2, Object obj) throws Exception {
                    LogUtils.logE(MokuDianMainActivity.TAG, "uploadDeviceInfo_getUserType success,getUsertype method invoke success,code is 0");
                    MokuConfigure.getInstance().updateUserType(MokuDianMainActivity.this.mContext, 0);
                    MokuDianMainActivity.this.uploadUserDviceInfo();
                }

                @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
                public void error(int i2, String str) throws Exception {
                    LogUtils.logD(MokuDianMainActivity.TAG, "uploadDeviceInfo_getUserType error,code=>" + i2);
                    int i3 = 0;
                    if (i2 != 6004 && i2 == 6005) {
                        i3 = 1;
                        MokuConfigure.getInstance().updateSubmitTaskDataId(MokuDianMainActivity.this.mContext, null);
                    }
                    MokuConfigure.getInstance().updateUserType(MokuDianMainActivity.this.mContext, i3);
                    SharedPreferencesUtils.getInstance(MokuDianMainActivity.this.mContext).putInt(MokuConstants.SP_USER_TYPE_KEY, i3);
                    MokuDianMainActivity.this.uploadUserDviceInfo();
                }
            });
        } else {
            LogUtils.logD(TAG, "uploadDeviceInfo,user type not -1 and 0,don't request server");
            MokuConfigure.getInstance().updateUserType(this.mContext, i);
            uploadUserDviceInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadUserDviceInfo() throws NoSuchMethodException, SecurityException {
        LoadingDialog.show(this.mContext);
        LogUtils.logD(TAG, "uploadUserDviceInfo invoke");
        ApiDataHelper.getApiDataHelper().uploadDeviceInfo(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.4
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                LogUtils.logD(MokuDianMainActivity.TAG, "uploadUserDviceInfo,uploade device info success");
                MokuDianMainActivity.this.uploadDeviceInfoSate = 2;
                MokuDianMainActivity.this.loadInitData();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LogUtils.logE(MokuDianMainActivity.TAG, "uploadUserDviceInfo,uploade device info error=>" + str);
                MokuDianMainActivity.this.uploadDeviceInfoSate = 3;
                MokuDianMainActivity.this.loadInitData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInitData() {
        LogUtils.logD(TAG, "loadInitData invoke");
        final int integer = MokuConfigure.getInstance().getMokuOptions(this.mContext).getInteger("cutInType", 0);
        ApiDataHelper.getApiDataHelper().dianGetItemConfig(this, new ApiDataCallBack<List<ItemConfig>>() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ItemConfig> list) throws Exception {
                LoadingDialog.dismiss();
                LogUtils.logD(MokuDianMainActivity.TAG, "getItemConfig success");
                if (list == null || list.isEmpty()) {
                    LogUtils.logI(MokuDianMainActivity.TAG, "getItemConfig success,but data is null,use default");
                    list = new ArrayList<>();
                    ItemConfig itemConfig = new ItemConfig();
                    itemConfig.setItemName("全部");
                    list.add(itemConfig);
                }
                MokuDianMainActivity.this.initDianMainView(list, integer);
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                Log.e(MokuDianMainActivity.TAG, "getItemConfig error,code:" + i + ",msg:" + str);
                ArrayList arrayList = new ArrayList();
                ItemConfig itemConfig = new ItemConfig();
                itemConfig.setItemName("全部");
                arrayList.add(itemConfig);
                MokuDianMainActivity.this.initDianMainView(arrayList, integer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDianMainView(List<ItemConfig> list, int i) throws Resources.NotFoundException {
        LogUtils.logD(TAG, "initDianMainView invoke");
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.moku_ll_search);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = 120;
        layoutParams.setMargins(20, 20, 20, 20);
        GradientDrawable gradientDrawable = new GradientDrawable();
        int color = Color.parseColor(this.mMokuOptions.getString("titleColor", "#D2E5CF"));
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(3, color);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setShape(0);
        linearLayout.setBackground(gradientDrawable);
        ImageView imageView = (ImageView) this.rootView.findViewById(R.id.moku_iv_search);
        imageView.setBackgroundResource(R.drawable.moku_dian_search);
        Drawable background = imageView.getBackground();
        if (Build.VERSION.SDK_INT >= 21) {
            background.setTint(color);
        }
        ((LinearLayout.LayoutParams) imageView.getLayoutParams()).setMargins(20, 0, 0, 0);
        TextView textView = (TextView) this.rootView.findViewById(R.id.moku_tv_search);
        textView.setText("搜索");
        textView.setTextColor(color);
        setPlayingData();
        if (list != null && !list.isEmpty()) {
            LogUtils.logD(TAG, "initDianMainView init tab");
            ArrayList arrayList = new ArrayList(list.size());
            this.fragmentList = new ArrayList(list.size());
            Iterator<ItemConfig> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getItemName());
                this.fragmentList.add(new DianTaskFragment());
            }
            MokuMainAdapter mokuMainAdapter = new MokuMainAdapter(getSupportFragmentManager(), this.fragmentList, arrayList);
            this.mainAdapter = mokuMainAdapter;
            this.viewPager.setAdapter(mokuMainAdapter);
            this.viewPager.setOffscreenPageLimit(this.fragmentList.size());
        }
        LoadingDialog.dismiss();
        if (i == 3) {
            try {
                LogUtils.logD(TAG, "dianGetMokuTaskDialog invoke");
                MokuHelper.dianGetMokuTaskDialog(this.mContext, new Consumer<TaskDialog>() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.6
                    @Override // com.fendasz.moku.planet.interf.functions.Consumer
                    public void accept(TaskDialog taskDialog) throws Exception {
                        MokuDianMainActivity.this.mTaskDialog = taskDialog;
                        if (taskDialog != null) {
                            MokuDianMainActivity.this.mTaskDialog.setDian(true);
                            MokuDianMainActivity.this.mTaskDialog.setOnDialogClosed(new TaskDialog.OnDialogClosed() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.6.1
                                @Override // com.fendasz.moku.planet.ui.dialog.TaskDialog.OnDialogClosed
                                public void onClosed(boolean z) {
                                    if (z) {
                                        MokuDianMainActivity.this.setFragmentResult(200, 300, null);
                                    }
                                    MokuDianMainActivity.this.mTaskDialog = null;
                                }
                            });
                            MokuDianMainActivity.this.mTaskDialog.show();
                        }
                    }
                });
            } catch (MokuException e) {
                LogUtils.logE(TAG, e.getMessage());
            }
        }
    }

    private void setPlayingData() {
        int color = Color.parseColor(this.mMokuOptions.getString("titleColor", "#D2E5CF"));
        TextView textView = (TextView) this.rootView.findViewById(R.id.moku_tv_playing);
        textView.setText("正在玩");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MokuDianMainActivity.this.mContext.startActivity(new Intent(MokuDianMainActivity.this.mContext, (Class<?>) DianParticipateActivity.class));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 100);
        layoutParams.setMargins(20, 0, 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setPadding(20, 0, 20, 0);
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(15.0f);
        gradientDrawable.setShape(0);
        textView.setBackground(gradientDrawable);
        TextView textView2 = (TextView) this.rootView.findViewById(R.id.moku_tv_playing_tips);
        this.playTips = textView2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams2.setMargins(50, 0, 0, 0);
        this.playTips.setLayoutParams(layoutParams2);
        this.playTips.setText("快去开始任务吧~");
        this.playTips.setTextColor(color);
        updatePlayingView(this.playTips);
    }

    private void updatePlayingView(final TextView textView) {
        ApiDataHelper.getApiDataHelper().dianMyPartInList(this.mContext, new ApiDataCallBack<List<ClientSampleTaskData>>() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<ClientSampleTaskData> list) throws Exception {
                if (list != null && !list.isEmpty()) {
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    if (MokuDianMainActivity.this.playingLinearLayout != null) {
                        int widthPixels = ((PhoneScreenUtils.getInstance().getWidthPixels(MokuDianMainActivity.this.mContext) - 40) - 70) / 5;
                        MokuDianMainActivity.this.playingLinearLayout.removeAllViews();
                        int i2 = 0;
                        for (final ClientSampleTaskData clientSampleTaskData : list) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthPixels, widthPixels);
                            if (i2 == 0) {
                                layoutParams.setMargins(0, 10, 10, 10);
                            } else if (i2 == 4) {
                                layoutParams.setMargins(10, 10, 0, 10);
                            } else {
                                layoutParams.setMargins(10, 10, 10, 10);
                            }
                            final ImageView imageView = new ImageView(MokuDianMainActivity.this.mContext);
                            imageView.setLayoutParams(layoutParams);
                            float f = widthPixels;
                            ImageUtils.getInstance().setImageView(MokuDianMainActivity.this.mContext, clientSampleTaskData.getIcon(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.8.1
                                @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                public void accept(Bitmap bitmap) {
                                    imageView.setImageBitmap(bitmap);
                                }
                            }, Float.valueOf(f), Float.valueOf(f));
                            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.8.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    MokuDianMainActivity.this.gotoDetail(clientSampleTaskData);
                                }
                            });
                            MokuDianMainActivity.this.playingLinearLayout.addView(imageView);
                            i2++;
                        }
                        MokuDianMainActivity.this.playingLinearLayout.setVisibility(0);
                        return;
                    }
                    return;
                }
                TextView textView3 = textView;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                if (MokuDianMainActivity.this.playingLinearLayout != null) {
                    MokuDianMainActivity.this.playingLinearLayout.setVisibility(8);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                TextView textView2 = textView;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (MokuDianMainActivity.this.playingLinearLayout != null) {
                    MokuDianMainActivity.this.playingLinearLayout.setVisibility(8);
                }
            }
        });
    }

    private void addTabLayout(LinearLayout linearLayout) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i;
        Class<?> cls = null;
        try {
            cls = Class.forName("com.google.android.material.tabs.TabLayout");
            LogUtils.log(TAG, "isAndroidX >> false");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.google.android.material.tabs.TabLayout");
                LogUtils.log(TAG, "isAndroidX >> true");
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        if (cls != null) {
            LogUtils.log(TAG, "got TabLayout Class");
            LogUtils.log(TAG, "TabLayout Constructor size >> " + cls.getConstructors().length);
            for (int i2 = 0; i2 < cls.getConstructors().length; i2++) {
                LogUtils.log(TAG, cls.getConstructors()[i2].getName());
                for (int i3 = 0; i3 < cls.getConstructors()[i2].getParameterTypes().length; i3++) {
                    LogUtils.log(TAG, cls.getConstructors()[i2].getParameterTypes()[i3].getName());
                }
            }
            try {
                Constructor<?> constructor = cls.getConstructor(Context.class);
                LogUtils.log(TAG, "found constructor >> " + constructor.getName());
                try {
                    try {
                        View view = (View) constructor.newInstance(this.mContext);
                        LogUtils.log(TAG, "got TabLayout instance");
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
                            cls.getMethod("setTabTextColors", Integer.TYPE, Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("titleColor", "#6E6E6E"))), Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabSelectedTextColor", "#000000"))));
                        } catch (NoSuchMethodException e8) {
                            e8.printStackTrace();
                        }
                        try {
                            cls.getMethod("setupWithViewPager", this.viewPager.getClass()).invoke(view, this.viewPager);
                        } catch (NoSuchMethodException e9) {
                            e9.printStackTrace();
                        }
                    } catch (InstantiationException e10) {
                        e10.printStackTrace();
                    } catch (InvocationTargetException e11) {
                        e11.printStackTrace();
                    }
                } catch (IllegalAccessException e12) {
                    e12.printStackTrace();
                }
            } catch (NoSuchMethodException e13) {
                e13.printStackTrace();
            }
        }
    }

    private void showUpdateTip() {
        MokuIconTextView mokuIconTextView;
        if (SharedPreferencesUtils.getInstance(this.mContext).getString(this.mContext.getString(R.string.moku_sp_version_name), "").equals(BuildConfig.VERSION_NAME) || (mokuIconTextView = this.mTvRightTextView) == null) {
            return;
        }
        mokuIconTextView.post(new Runnable() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.9
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(MokuDianMainActivity.this.mContext.getResources(), R.drawable.moku_img_update_tip_dian);
                if (bitmapDecodeResource == null || MokuDianMainActivity.this.mTvRightTextView == null) {
                    return;
                }
                int[] iArr = new int[2];
                MokuDianMainActivity.this.mTvRightTextView.getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                int scale = MokuDianMainActivity.this.phoneScreenUtils.getScale(MokuDianMainActivity.this.mContext, 50.0f);
                float f = i - scale;
                float height = (bitmapDecodeResource.getHeight() * f) / bitmapDecodeResource.getWidth();
                ImageView imageView = new ImageView(MokuDianMainActivity.this.mContext);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int i3 = (int) f;
                int i4 = (int) height;
                imageView.setLayoutParams(new ViewGroup.LayoutParams(i3, i4));
                imageView.setImageBitmap(bitmapDecodeResource);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.main.MokuDianMainActivity.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (MokuDianMainActivity.this.mPuwUpdateTip != null && MokuDianMainActivity.this.mPuwUpdateTip.isShowing()) {
                            MokuDianMainActivity.this.mPuwUpdateTip.dismiss();
                        }
                        SharedPreferencesUtils.getInstance(MokuDianMainActivity.this.mContext).putString(MokuDianMainActivity.this.mContext.getString(R.string.moku_sp_version_name), BuildConfig.VERSION_NAME);
                    }
                });
                MokuDianMainActivity.this.mPuwUpdateTip = new PopupWindow(imageView, i3, i4);
                MokuDianMainActivity.this.mPuwUpdateTip.setOutsideTouchable(false);
                MokuDianMainActivity.this.mPuwUpdateTip.showAtLocation(MokuDianMainActivity.this.getRootView(), 0, scale, i2 + MokuDianMainActivity.this.phoneScreenUtils.getScale(MokuDianMainActivity.this.mContext, 20.0f));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFragmentResult(int i, int i2, Intent intent) {
        for (int i3 = 0; i3 < this.fragmentList.size(); i3++) {
            this.fragmentList.get(i3).onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setFragmentResult(i, i2, intent);
    }

    private class MyHander extends Handler {
        private WeakReference<MokuDianMainActivity> weakReference;

        public MyHander(MokuDianMainActivity mokuDianMainActivity) {
            this.weakReference = new WeakReference<>(mokuDianMainActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            MokuDianMainActivity mokuDianMainActivity = this.weakReference.get();
            if (mokuDianMainActivity == null || mokuDianMainActivity.isFinishing()) {
                return;
            }
            int i = message.what;
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.myHander.removeCallbacksAndMessages(null);
        this.myHander = null;
    }

    @Override // android.app.Activity
    protected void onRestart() throws NoSuchMethodException, SecurityException {
        super.onRestart();
        TaskDialog taskDialog = this.mTaskDialog;
        if (taskDialog != null) {
            taskDialog.onRestart();
        }
        LogUtils.logD(TAG, "onRestart");
        updatePlayingView(this.playTips);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        StorageUtils.cleanSearchTaskList(this.mContext);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() throws NoSuchMethodException, SecurityException {
        super.onStart();
        MokuConfigure.getInstance().updateSubmitTaskDataId(this.mContext, null);
        TaskDialog taskDialog = this.mTaskDialog;
        if (taskDialog != null) {
            taskDialog.setDian(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoDetail(ClientSampleTaskData clientSampleTaskData) {
        Intent intent;
        Integer taskDataId = clientSampleTaskData.getTaskDataId();
        if (clientSampleTaskData.getCpl() != null && clientSampleTaskData.getCpl().booleanValue()) {
            intent = new Intent(this, (Class<?>) DianCPLDetailActivity.class);
        } else if (clientSampleTaskData.getTaskType() != null && clientSampleTaskData.getTaskType().intValue() == 1) {
            Toast.makeText(this, "任务配置信息错误，请联系客服处理", 0).show();
            intent = null;
        } else {
            intent = new Intent(this, (Class<?>) DianCpaDetailActivity.class);
        }
        intent.putExtra("taskDataId", taskDataId.intValue());
        String gateType = clientSampleTaskData.getGateType();
        if (!TextUtils.isEmpty(gateType)) {
            intent.putExtra("gateType", gateType);
        }
        intent.putExtra("operationType", 100);
        startActivityForResult(intent, 200);
    }

    private class DianRunable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        private DianRunable() {
        }
    }
}
