package com.fendasz.moku.planet.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.GridSpaceItemDecoration;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.functions.Consumer;
import com.fendasz.moku.planet.source.bean.ClientDetailTaskData;
import com.fendasz.moku.planet.source.bean.TaskDataStep;
import com.fendasz.moku.planet.ui.activity.TaskDetailActivity;
import com.fendasz.moku.planet.ui.adapter.FloatImageAdapter;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FloatingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "FloatingUtil==>";
    public static final int TASK_TYPE_CPA_ANSWER = 2;
    public static final int TASK_TYPE_CPA_NOL = 1;
    public static final int TASK_TYPE_CPL = 4;
    public static final int TASK_TYPE_HP = 3;
    public static final int TASK_TYPE_KEYWORD = 5;
    private static FloatingUtil floatingUtil;
    private OnFloatingListener onFloatingListener;

    public interface OnFloatingListener {
        void onFloating();
    }

    private FloatingUtil() {
    }

    public static synchronized FloatingUtil getInstance() {
        if (floatingUtil == null) {
            floatingUtil = new FloatingUtil();
        }
        return floatingUtil;
    }

    public LinearLayout addBaseView(Activity activity, ClientDetailTaskData clientDetailTaskData, final OnFloatingListener onFloatingListener) {
        LinearLayout linearLayout = new LinearLayout(activity);
        int widthPixels = (PhoneScreenUtils.getInstance().getWidthPixels(activity) * 70) / 100;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, -2));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout.addView(linearLayout2);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(400, 130));
        linearLayout2.setPadding(dp2px(10), 0, 0, 0);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(19);
        linearLayout2.setBackgroundResource(R.drawable.moku_shape_floating_watch_detail);
        Drawable background = linearLayout2.getBackground();
        int color = Color.parseColor(MokuConfigure.getInstance().getMokuOptions(activity).getString("tabTextColor", "#FE9A20"));
        if (Build.VERSION.SDK_INT >= 21) {
            background.setTint(color);
        }
        ImageView imageView = new ImageView(activity);
        linearLayout2.addView(imageView);
        ScreenAdaptationUtils.setLayoutParams(activity, imageView, 60, 60, 0, 0, 0, 0);
        imageView.setImageResource(R.drawable.moku_icon_floating_back);
        imageView.setPadding(ViewUtil.dp2px(10), 0, 0, 0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnFloatingListener onFloatingListener2 = onFloatingListener;
                if (onFloatingListener2 != null) {
                    onFloatingListener2.onFloating();
                }
            }
        });
        TextView textView = new TextView(activity);
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setId(View.generateViewId());
        }
        textView.setText("任务详情页");
        textView.setTextColor(-1);
        linearLayout2.addView(textView);
        ScreenAdaptationUtils.setMargin(activity, textView, 0, 10, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnFloatingListener onFloatingListener2 = onFloatingListener;
                if (onFloatingListener2 != null) {
                    onFloatingListener2.onFloating();
                }
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout.addView(linearLayout3);
        linearLayout3.setPadding(dp2px(5), 0, 0, 0);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(230, 80));
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(19);
        linearLayout3.setBackgroundResource(R.drawable.moku_shape_floating_watch_setp);
        TextView textView2 = new TextView(activity);
        linearLayout3.addView(textView2);
        if (Build.VERSION.SDK_INT >= 17) {
            textView2.setId(View.generateViewId());
        }
        textView2.setText("查看步骤");
        textView2.setTextColor(-1);
        ImageView imageView2 = new ImageView(activity);
        linearLayout3.addView(imageView2);
        ScreenAdaptationUtils.setLayoutParams(activity, imageView2, Integer.valueOf(dp2px(15)), Integer.valueOf(dp2px(15)), 0, 0, 0, 0);
        Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.moku_arrow_right);
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(-1);
        }
        imageView2.setBackground(drawable);
        int i = (int) ((Double.parseDouble(String.valueOf(PhoneScreenUtils.getInstance().getWidthPixels(activity) - dp2px(9))) * 60.0d) / 100.0d);
        int heightPixels = PhoneScreenUtils.getInstance().getHeightPixels(activity) / 2;
        final NestedScrollView nestedScrollView = new NestedScrollView(activity);
        linearLayout.addView(nestedScrollView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, heightPixels);
        layoutParams.setMargins(dp2px(9), dp2px(3), 0, 0);
        nestedScrollView.setLayoutParams(layoutParams);
        nestedScrollView.setBackgroundResource(R.drawable.moku_shape_floating_step);
        nestedScrollView.setPadding(0, 0, 0, dp2px(12));
        nestedScrollView.setVisibility(8);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        nestedScrollView.addView(linearLayout4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, heightPixels);
        layoutParams2.leftMargin = dp2px(9);
        linearLayout4.setLayoutParams(layoutParams2);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(1);
        int iDp2px = dp2px(12);
        linearLayout4.setPadding(0, iDp2px, iDp2px, iDp2px);
        if (clientDetailTaskData.getClassify() == null) {
            Boolean cpl = clientDetailTaskData.getCpl();
            if (cpl != null && cpl.booleanValue()) {
                linearLayout3.setVisibility(8);
            }
        } else if ("cpa".equals(clientDetailTaskData.getClassify()) || "hp".equals(clientDetailTaskData.getClassify())) {
            initCPAView(linearLayout4, clientDetailTaskData, activity);
        } else if ("keyword".equals(clientDetailTaskData.getClassify())) {
            initKeyword(linearLayout4, clientDetailTaskData, activity);
        } else {
            Boolean cpl2 = clientDetailTaskData.getCpl();
            if (cpl2 != null && cpl2.booleanValue()) {
                linearLayout3.setVisibility(8);
            } else {
                Integer listenerTime = clientDetailTaskData.getListenerTime();
                if (listenerTime == null) {
                    listenerTime = 30;
                }
                ViewGroup.LayoutParams layoutParams3 = nestedScrollView.getLayoutParams();
                layoutParams3.height = dp2px(60);
                nestedScrollView.setLayoutParams(layoutParams3);
                initListenerTimeView(linearLayout4, listenerTime.intValue(), activity);
            }
        }
        final ImageView imageView3 = new ImageView(activity);
        linearLayout.addView(imageView3);
        int iDp2px2 = dp2px(30);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iDp2px2, iDp2px2);
        layoutParams4.gravity = 1;
        layoutParams4.setMargins(0, 0, dp2px(10), 0);
        imageView3.setLayoutParams(layoutParams4);
        imageView3.setImageResource(R.drawable.moku_floating_close);
        imageView3.setVisibility(8);
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nestedScrollView.setVisibility(8);
                imageView3.setVisibility(8);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (nestedScrollView.getVisibility() == 8) {
                    nestedScrollView.setVisibility(0);
                    imageView3.setVisibility(0);
                } else {
                    nestedScrollView.setVisibility(8);
                    imageView3.setVisibility(8);
                }
            }
        });
        WindowManager.LayoutParams layoutParams5 = new WindowManager.LayoutParams(widthPixels, -2, 0, 0, -2);
        layoutParams5.flags = 524328;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams5.type = 2038;
        } else {
            layoutParams5.type = 2002;
        }
        layoutParams5.format = 1;
        layoutParams5.gravity = 51;
        layoutParams5.x = 0;
        layoutParams5.y = 500;
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        linearLayout.setOnTouchListener(new SuspendOnTouchListener(windowManager, layoutParams5));
        linearLayout3.setOnTouchListener(new SuspendOnTouchListener(windowManager, layoutParams5));
        windowManager.addView(linearLayout, layoutParams5);
        return linearLayout;
    }

    public LinearLayout createSuspendLayout(Activity activity, ClientDetailTaskData clientDetailTaskData, final OnFloatingListener onFloatingListener) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams((PhoneScreenUtils.getInstance().getWidthPixels(activity) * 70) / 100, -2));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout.addView(linearLayout2);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(340, 100));
        linearLayout2.setPadding(dp2px(5), 0, 0, 0);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(19);
        linearLayout2.setBackgroundResource(R.drawable.moku_shape_floating_watch_detail);
        Drawable background = linearLayout2.getBackground();
        int color = Color.parseColor(MokuConfigure.getInstance().getMokuOptions(activity).getString("tabTextColor", "#FE9A20"));
        if (Build.VERSION.SDK_INT >= 21) {
            background.setTint(color);
        }
        ImageView imageView = new ImageView(activity);
        linearLayout2.addView(imageView);
        ScreenAdaptationUtils.setLayoutParams(activity, imageView, 40, 40, 0, 0, 0, 20);
        imageView.setImageResource(R.drawable.moku_icon_floating_back);
        TextView textView = new TextView(activity);
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setId(View.generateViewId());
        }
        textView.setText("任务详情页");
        textView.setTextColor(-1);
        linearLayout2.addView(textView);
        ScreenAdaptationUtils.setMargin(activity, textView, 0, 10, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnFloatingListener onFloatingListener2 = onFloatingListener;
                if (onFloatingListener2 != null) {
                    onFloatingListener2.onFloating();
                }
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout.addView(linearLayout3);
        linearLayout3.setPadding(dp2px(5), 0, 0, 0);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(230, 80));
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(19);
        linearLayout3.setBackgroundResource(R.drawable.moku_shape_floating_watch_setp);
        TextView textView2 = new TextView(activity);
        linearLayout3.addView(textView2);
        if (Build.VERSION.SDK_INT >= 17) {
            textView2.setId(View.generateViewId());
        }
        textView2.setText("查看步骤");
        textView2.setTextColor(-1);
        ImageView imageView2 = new ImageView(activity);
        linearLayout3.addView(imageView2);
        ScreenAdaptationUtils.setLayoutParams(activity, imageView2, Integer.valueOf(dp2px(15)), Integer.valueOf(dp2px(15)), 0, 0, 0, 0);
        Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.moku_arrow_right);
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(-1);
        }
        imageView2.setBackground(drawable);
        int i = (int) ((Double.parseDouble(String.valueOf(PhoneScreenUtils.getInstance().getWidthPixels(activity) - dp2px(9))) * 60.0d) / 100.0d);
        int heightPixels = PhoneScreenUtils.getInstance().getHeightPixels(activity) / 2;
        final NestedScrollView nestedScrollView = new NestedScrollView(activity);
        linearLayout.addView(nestedScrollView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, heightPixels);
        layoutParams.setMargins(dp2px(9), dp2px(3), 0, 0);
        nestedScrollView.setLayoutParams(layoutParams);
        nestedScrollView.setBackgroundResource(R.drawable.moku_shape_floating_step);
        nestedScrollView.setPadding(0, 0, 0, dp2px(12));
        nestedScrollView.setVisibility(8);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        nestedScrollView.addView(linearLayout4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, heightPixels);
        layoutParams2.leftMargin = dp2px(9);
        linearLayout4.setLayoutParams(layoutParams2);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(1);
        int iDp2px = dp2px(12);
        linearLayout4.setPadding(0, iDp2px, iDp2px, iDp2px);
        if (clientDetailTaskData.getClassify() == null) {
            Boolean cpl = clientDetailTaskData.getCpl();
            if (cpl != null && cpl.booleanValue()) {
                linearLayout3.setVisibility(8);
            }
        } else if ("cpa".equals(clientDetailTaskData.getClassify()) || "hp".equals(clientDetailTaskData.getClassify())) {
            initCPAView(linearLayout4, clientDetailTaskData, activity);
        } else if ("keyword".equals(clientDetailTaskData.getClassify())) {
            initKeyword(linearLayout4, clientDetailTaskData, activity);
        } else {
            Boolean cpl2 = clientDetailTaskData.getCpl();
            if (cpl2 != null && cpl2.booleanValue()) {
                linearLayout3.setVisibility(8);
            } else {
                Integer listenerTime = clientDetailTaskData.getListenerTime();
                if (listenerTime == null) {
                    listenerTime = 30;
                }
                ViewGroup.LayoutParams layoutParams3 = nestedScrollView.getLayoutParams();
                layoutParams3.height = dp2px(60);
                nestedScrollView.setLayoutParams(layoutParams3);
                initListenerTimeView(linearLayout4, listenerTime.intValue(), activity);
            }
        }
        final ImageView imageView3 = new ImageView(activity);
        linearLayout.addView(imageView3);
        int iDp2px2 = dp2px(30);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iDp2px2, iDp2px2);
        layoutParams4.gravity = 1;
        layoutParams4.setMargins(0, 0, dp2px(10), 0);
        imageView3.setLayoutParams(layoutParams4);
        imageView3.setImageResource(R.drawable.moku_floating_close);
        imageView3.setVisibility(8);
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nestedScrollView.setVisibility(8);
                imageView3.setVisibility(8);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (nestedScrollView.getVisibility() == 8) {
                    nestedScrollView.setVisibility(0);
                    imageView3.setVisibility(0);
                } else {
                    nestedScrollView.setVisibility(8);
                    imageView3.setVisibility(8);
                }
            }
        });
        return linearLayout;
    }

    private static void initListenerTimeView(LinearLayout linearLayout, int i, Context context) {
        TextView textView = new TextView(context);
        linearLayout.addView(textView);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = dp2px(60);
        linearLayout.setLayoutParams(layoutParams);
        textView.setText("试玩" + i + "s，返回详情页提交任务");
        textView.setTextColor(-1);
    }

    private void initCPAView(LinearLayout linearLayout, ClientDetailTaskData clientDetailTaskData, Context context) {
        String str;
        Integer num;
        int i;
        Integer num2;
        List<TaskDataStep> list;
        PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
        ArrayList arrayList = new ArrayList();
        int color = Color.parseColor(MokuConfigure.getInstance().getMokuOptions(context).getString("tabIndicatorColor", "#AEC7B1"));
        Map<Integer, List<TaskDataStep>> integerListMap = clientDetailTaskData.getIntegerListMap();
        Integer num3 = 30;
        String str2 = TAG;
        int i2 = 0;
        if (integerListMap != null) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < integerListMap.size()) {
                int i5 = i3 + 1;
                List<TaskDataStep> list2 = integerListMap.get(Integer.valueOf(i5));
                if (list2 == null || list2.size() <= 0) {
                    str = str2;
                    num = num3;
                } else {
                    i4++;
                    String taskDataCustomDesc = list2.get(i2).getTaskDataCustomDesc();
                    list2.get(i2).getTaskDataStepConfigType().intValue();
                    List<TaskDataStep> list3 = list2;
                    int i6 = 2;
                    str = str2;
                    Integer num4 = num3;
                    setChildProcessDesc(linearLayout, i4, taskDataCustomDesc, true, context);
                    int i7 = i2;
                    while (i7 < list3.size()) {
                        List<TaskDataStep> list4 = list3;
                        TaskDataStep taskDataStep = list4.get(i7);
                        if (taskDataStep.isExamplePicStep()) {
                            if (!TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                arrayList.add(taskDataStep.getTaskDataSampleScreenshotUrl());
                            }
                            i = i7;
                            num2 = num4;
                            list = list4;
                        } else if (taskDataStep.getType().intValue() == i6) {
                            if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 3 && i7 == 0) {
                                LogUtils.logD(str, "the type is copy type");
                                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                linearLayout.addView(linearLayout2);
                                RelativeLayout relativeLayout = new RelativeLayout(context);
                                int scale = PhoneScreenUtils.getInstance().getScale(context, 100.0f);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, scale);
                                i = i7;
                                layoutParams.setMargins(0, PhoneScreenUtils.getInstance().getScale(context, 10.0f), 0, 0);
                                relativeLayout.setLayoutParams(layoutParams);
                                int scale2 = PhoneScreenUtils.getInstance().getScale(context, 100.0f);
                                relativeLayout.setPadding(scale2, 0, scale2, 0);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(PhoneScreenUtils.getInstance().getScale(context, 150.0f), scale);
                                layoutParams2.addRule(11);
                                TextView textView = new TextView(context);
                                textView.setGravity(17);
                                textView.setTextColor(-1);
                                textView.setText("复制");
                                textView.setLayoutParams(layoutParams2);
                                StyleUtils.setGradientDrawable(textView, 20, color);
                                relativeLayout.addView(textView);
                                int scale3 = PhoneScreenUtils.getInstance().getScale(context, 200.0f);
                                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, scale);
                                layoutParams3.setMargins(0, 0, scale3, 0);
                                TextView textView2 = new TextView(context);
                                textView2.setLayoutParams(layoutParams3);
                                textView2.setText(taskDataStep.getAdditionalContent());
                                textView2.setGravity(17);
                                textView2.setBackgroundColor(context.getResources().getColor(R.color.moku_gray_dark));
                                textView2.setTextColor(-1);
                                layoutParams3.addRule(15);
                                layoutParams3.addRule(9);
                                relativeLayout.addView(textView2);
                                linearLayout2.addView(relativeLayout);
                                final ImageView imageView = new ImageView(context);
                                linearLayout2.addView(imageView);
                                num2 = num4;
                                ScreenAdaptationUtils.setMarginTop(context, imageView, num2);
                                ScreenAdaptationUtils.setSize(context, imageView, 300, 300);
                                imageView.setBackgroundResource(R.color.moku_transparent);
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                list = list4;
                                ImageUtils.getInstance().setImageView(context, taskDataStep.getTaskDataSampleScreenshotUrl(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.8
                                    @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                    public void accept(Bitmap bitmap) throws Exception {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                }, null, null);
                            } else {
                                i = i7;
                                num2 = num4;
                                list = list4;
                                if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 1 && taskDataStep.getTaskDataStepOpeningMode() != null && taskDataStep.getTaskDataStepOpeningMode().intValue() == 2) {
                                    LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                    linearLayout.addView(linearLayout3);
                                    LinearLayout linearLayout4 = new LinearLayout(context);
                                    linearLayout4.setOrientation(0);
                                    linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, PhoneScreenUtils.getInstance().getScale(context, 100.0f)));
                                    ScreenAdaptationUtils.setMarginTop(context, linearLayout4, 50);
                                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
                                    layoutParams4.weight = 1.0f;
                                    layoutParams4.gravity = 16;
                                    TextView textView3 = new TextView(context);
                                    textView3.setText("打开链接");
                                    textView3.setLayoutParams(layoutParams4);
                                    textView3.setTextSize(phoneScreenUtils.getNormalTextSize(context));
                                    textView3.setGravity(17);
                                    textView3.setTextColor(-1);
                                    StyleUtils.setGradientDrawable(textView3, 20, color);
                                    linearLayout4.addView(textView3);
                                    linearLayout3.addView(linearLayout4);
                                    TextView textView4 = new TextView(context);
                                    textView4.setText("复制链接");
                                    textView4.setLayoutParams(layoutParams4);
                                    textView4.setTextSize(phoneScreenUtils.getNormalTextSize(context));
                                    textView4.setGravity(17);
                                    StyleUtils.setGradientDrawable(textView4, 20, color);
                                    linearLayout4.addView(textView4);
                                } else {
                                    LogUtils.logD(str, "the type is not copy type");
                                    if (!TextUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                                        LinearLayout linearLayout5 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                        linearLayout.addView(linearLayout5);
                                        final ImageView imageView2 = new ImageView(context);
                                        linearLayout5.addView(imageView2);
                                        ScreenAdaptationUtils.setMarginTop(context, imageView2, num2);
                                        ScreenAdaptationUtils.setSize(context, imageView2, 300, 300);
                                        imageView2.setBackgroundResource(R.color.moku_transparent);
                                        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                                        ImageUtils.getInstance().setImageView(context, taskDataStep.getTaskDataSampleScreenshotUrl(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.9
                                            @Override // com.fendasz.moku.planet.interf.functions.Consumer
                                            public void accept(Bitmap bitmap) throws Exception {
                                                imageView2.setImageBitmap(bitmap);
                                            }
                                        }, null, null);
                                    }
                                }
                            }
                        } else {
                            i = i7;
                            num2 = num4;
                            list = list4;
                            if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepOpeningMode() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 1 && taskDataStep.getTaskDataStepOpeningMode().intValue() == 2) {
                                LinearLayout linearLayout6 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                linearLayout.addView(linearLayout6);
                                LinearLayout linearLayout7 = new LinearLayout(context);
                                linearLayout7.setOrientation(0);
                                linearLayout7.setLayoutParams(new LinearLayout.LayoutParams(-1, PhoneScreenUtils.getInstance().getScale(context, 100.0f)));
                                int scale4 = PhoneScreenUtils.getInstance().getScale(context, 50.0f);
                                linearLayout7.setPadding(scale4, 0, scale4, 0);
                                ScreenAdaptationUtils.setMarginTop(context, linearLayout7, 50);
                                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1);
                                layoutParams5.weight = 1.0f;
                                layoutParams5.gravity = 16;
                                layoutParams5.setMargins(0, 0, dp2px(5), 0);
                                TextView textView5 = new TextView(context);
                                textView5.setText("打开链接");
                                textView5.setLayoutParams(layoutParams5);
                                float f = 12;
                                textView5.setTextSize(f);
                                textView5.setGravity(17);
                                StyleUtils.setGradientDrawable(textView5, 20, color);
                                linearLayout7.addView(textView5);
                                linearLayout6.addView(linearLayout7);
                                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1);
                                layoutParams6.weight = 1.0f;
                                layoutParams6.gravity = 16;
                                layoutParams6.setMargins(dp2px(5), 0, 0, 0);
                                TextView textView6 = new TextView(context);
                                textView6.setText("复制链接");
                                textView6.setLayoutParams(layoutParams6);
                                textView6.setTextSize(f);
                                textView6.setGravity(17);
                                StyleUtils.setGradientDrawable(textView6, 20, color);
                                linearLayout7.addView(textView6);
                            } else if (taskDataStep.getTaskDataStepConfigType() != null && taskDataStep.getTaskDataStepOpeningMode() != null && taskDataStep.getTaskDataStepConfigType().intValue() == 3 && i == 0) {
                                LinearLayout linearLayout8 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
                                linearLayout.addView(linearLayout8);
                                LinearLayout linearLayout9 = new LinearLayout(context);
                                linearLayout9.setOrientation(1);
                                linearLayout9.setGravity(17);
                                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
                                layoutParams7.setMargins(0, PhoneScreenUtils.getInstance().getScale(context, 10.0f), 0, 0);
                                linearLayout9.setLayoutParams(layoutParams7);
                                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
                                int iDp2px = dp2px(20);
                                layoutParams8.setMargins(iDp2px, 0, iDp2px, 0);
                                TextView textView7 = new TextView(context);
                                textView7.setLayoutParams(layoutParams8);
                                textView7.setText(taskDataStep.getAdditionalContent());
                                textView7.setGravity(17);
                                textView7.setBackgroundColor(context.getResources().getColor(R.color.moku_gray_dark));
                                textView7.setTextColor(-1);
                                linearLayout9.addView(textView7);
                                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(PhoneScreenUtils.getInstance().getScale(context, 150.0f), -2);
                                layoutParams9.setMargins(0, dp2px(10), 0, 0);
                                TextView textView8 = new TextView(context);
                                textView8.setGravity(17);
                                textView8.setText("复制");
                                textView8.setLayoutParams(layoutParams9);
                                StyleUtils.setGradientDrawable(textView8, 20, color);
                                linearLayout9.addView(textView8);
                                linearLayout8.addView(linearLayout9);
                            }
                        }
                        i7 = i + 1;
                        list3 = list;
                        num4 = num2;
                        i6 = 2;
                    }
                    num = num4;
                }
                num3 = num;
                str2 = str;
                i3 = i5;
                i2 = 0;
            }
        }
        String str3 = str2;
        if (arrayList.size() > 0) {
            LogUtils.logD(str3, "init image gridview");
            RecyclerView recyclerView = new RecyclerView(context);
            if (Build.VERSION.SDK_INT >= 17) {
                recyclerView.setId(View.generateViewId());
            }
            linearLayout.addView(recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            int iDp2px2 = (linearLayout.getLayoutParams().width - dp2px(30)) - dp2px(4);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(iDp2px2, -2);
            layoutParams10.setMargins(0, dp2px(15), 0, 0);
            recyclerView.setLayoutParams(layoutParams10);
            recyclerView.addItemDecoration(new GridSpaceItemDecoration(dp2px(2), 2, dp2px(10)));
            FloatImageAdapter floatImageAdapter = new FloatImageAdapter(arrayList);
            floatImageAdapter.setRequWidth(Float.valueOf(Float.parseFloat(String.valueOf(iDp2px2 / 2))));
            recyclerView.setAdapter(floatImageAdapter);
        }
    }

    private void initKeyword(LinearLayout linearLayout, ClientDetailTaskData clientDetailTaskData, Context context) {
        PhoneScreenUtils.getInstance();
        setChildProcessDesc(linearLayout, 1, "打开 <font color=\"#ff0000\">" + clientDetailTaskData.getAppGalleryName() + "</font> 搜索 <font color=\"#ff0000\">" + clientDetailTaskData.getKeyword() + "</font> 找到该图标软件", true, context);
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_content, (ViewGroup) null);
        linearLayout.addView(linearLayout2);
        final ImageView imageView = new ImageView(context);
        linearLayout2.addView(imageView);
        ScreenAdaptationUtils.setMarginTop(context, imageView, 30);
        ScreenAdaptationUtils.setSize(context, imageView, 200, 200);
        ImageUtils.getInstance().setImageView(context, clientDetailTaskData.getIconUrl(), new Consumer<Bitmap>() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.10
            @Override // com.fendasz.moku.planet.interf.functions.Consumer
            public void accept(Bitmap bitmap) throws Exception {
                imageView.setImageBitmap(bitmap);
            }
        }, null, null);
        TextView textView = new TextView(context);
        linearLayout2.addView(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ScreenAdaptationUtils.setMarginTop(context, textView, 30);
        textView.setTextSize(13.0f);
        textView.setText(Html.fromHtml("【软件排在第 <font color=\"#ff0000\">" + clientDetailTaskData.getRank() + "</font> 位】"));
        textView.setTextColor(-7829368);
        setChildProcessDesc(linearLayout, 2, "部分机型使用指定搜索词无法搜到对应软件，<font color=\"#ff0000\">请勿使用其他词搜索！</font>更换别的任务做哦！", true, context);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        ScreenAdaptationUtils.setMargin(context, linearLayout3, 30, 30, null, 30);
        ScreenAdaptationUtils.setHeight(context, linearLayout3, 110);
        TextView textView2 = new TextView(context);
        linearLayout3.addView(textView2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams.gravity = 17;
        layoutParams.weight = 6.0f;
        layoutParams.height = -1;
        textView2.setText(clientDetailTaskData.getKeyword());
        textView2.setTextSize(13.0f);
        textView2.setTextColor(SupportMenu.CATEGORY_MASK);
        textView2.setGravity(17);
        textView2.setBackgroundResource(R.drawable.moku_gray_dash_border_rectangle_shape);
        TextView textView3 = new TextView(context);
        linearLayout3.addView(textView3);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        layoutParams2.height = -1;
        textView3.setGravity(17);
        textView3.setText("点击复制");
        textView3.setTextColor(-1);
        textView3.setTextSize(13.0f);
        textView3.setBackgroundResource(R.drawable.moku_gray_rectangle_shape);
        Map<Integer, List<TaskDataStep>> integerListMap = clientDetailTaskData.getIntegerListMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, List<TaskDataStep>>> it = integerListMap.entrySet().iterator();
        while (it.hasNext()) {
            for (TaskDataStep taskDataStep : it.next().getValue()) {
                if (!StringUtils.isEmpty(taskDataStep.getTaskDataSampleScreenshotUrl())) {
                    arrayList.add(taskDataStep.getTaskDataSampleScreenshotUrl());
                }
            }
        }
        if (arrayList.size() > 0) {
            LogUtils.logD(TAG, "init image gridview");
            RecyclerView recyclerView = new RecyclerView(context);
            if (Build.VERSION.SDK_INT >= 17) {
                recyclerView.setId(View.generateViewId());
            }
            linearLayout.addView(recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            int iDp2px = (linearLayout.getLayoutParams().width - dp2px(30)) - dp2px(4);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iDp2px, -2);
            layoutParams3.gravity = 1;
            layoutParams3.setMargins(0, dp2px(15), 0, 0);
            recyclerView.setLayoutParams(layoutParams3);
            recyclerView.addItemDecoration(new GridSpaceItemDecoration(dp2px(2), 2, dp2px(10)));
            FloatImageAdapter floatImageAdapter = new FloatImageAdapter(arrayList);
            floatImageAdapter.setRequWidth(Float.valueOf(Float.parseFloat(String.valueOf(iDp2px / 2))));
            recyclerView.setAdapter(floatImageAdapter);
        }
    }

    private class SuspendOnTouchListener implements View.OnTouchListener {
        private int startX;
        private int startY;
        private WindowManager windowManager;
        private WindowManager.LayoutParams windowParams;

        public SuspendOnTouchListener(WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
            this.windowParams = layoutParams;
            this.windowManager = windowManager;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.startX = (int) motionEvent.getRawX();
                this.startY = (int) motionEvent.getRawY();
            } else if (action == 1) {
                this.windowParams.x = 0;
                this.windowManager.updateViewLayout(view, this.windowParams);
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i = rawX - this.startX;
                int i2 = rawY - this.startY;
                this.startX = rawX;
                this.startY = rawY;
                this.windowParams.x += i;
                this.windowParams.y += i2;
                this.windowManager.updateViewLayout(view, this.windowParams);
            }
            return false;
        }
    }

    private void setChildProcessDesc(LinearLayout linearLayout, int i, String str, boolean z, final Context context) {
        LogUtils.log(TAG, "task process desc before parse >> " + str);
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.moku_child_process_desc, (ViewGroup) linearLayout, false);
        linearLayout.addView(linearLayout2);
        TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_child_process_index);
        if (i > 1) {
            ScreenAdaptationUtils.setMarginTop(context, linearLayout2, 30);
        }
        textView.setText(String.valueOf(i));
        ScreenAdaptationUtils.setSize(context, textView, 55, 55);
        PhoneScreenUtils.getInstance();
        textView.setTextSize(13.0f);
        if (!z) {
            textView.setVisibility(8);
        }
        final TextView textView2 = (TextView) linearLayout2.findViewById(R.id.tv_child_process_desc);
        textView2.setTextColor(-1);
        textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.11
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                textView2.setSelected(true);
                try {
                    SystemUtils.copyToClipboard(context, textView2.getText().toString(), textView2.getText().toString());
                    Toast.makeText(context, "内容复制到剪贴板", 0).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        Spanned spanned = MokuUtils.parserXml(str);
        textView2.setLinksClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setText(getClickableHtml(spanned, context));
        textView2.setTextSize(13.0f);
    }

    private CharSequence getClickableHtml(Spanned spanned, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class)) {
            setLinkClickable(spannableStringBuilder, uRLSpan, context);
        }
        return spannableStringBuilder;
    }

    private void setLinkClickable(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan, final Context context) {
        int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
        int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
        int spanFlags = spannableStringBuilder.getSpanFlags(uRLSpan);
        final String url = uRLSpan.getURL();
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.12
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LogUtils.log(FloatingUtil.TAG, "截取到超链接点击事件");
                Context context2 = context;
                if (context2 instanceof TaskDetailActivity) {
                    ((TaskDetailActivity) context2).showGalleryTipDialog(new Finish() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.12.1
                        @Override // com.fendasz.moku.planet.interf.Finish
                        public void finish() {
                            SystemUtils.openBrowser(context, url);
                        }
                    });
                }
            }
        }, spanStart, spanEnd, spanFlags);
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    public static boolean isNeedShowFloatnigDialog(Activity activity, ClientDetailTaskData clientDetailTaskData) {
        boolean z = SharedPreferencesUtils.getInstance(activity).getBoolean("floating_dilag_show_flag_" + MokuConfigure.getInstance().getPhoneInfo(activity).getAppId(), true);
        return (!z || Build.VERSION.SDK_INT < 23) ? z : !Settings.canDrawOverlays(activity);
    }

    public static boolean canDrawOverlays(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(activity);
        }
        return false;
    }

    public static void showFloatingDialog(final Activity activity) {
        new CustomBuildDialog.DialogBuilder(activity).setTitleText("开启【悬浮窗权限】即可使用悬浮窗功能，帮助您更便捷的完成任务").setDetailText("  \n\n\n                      ").setRightBtn("同意", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.14
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                if (Build.VERSION.SDK_INT >= 23) {
                    boolean zCanDrawOverlays = Settings.canDrawOverlays(activity);
                    LogUtils.logD(FloatingUtil.TAG, "draw over lays==>" + zCanDrawOverlays);
                    if (zCanDrawOverlays) {
                        return;
                    }
                    SharedPreferencesUtils.getInstance(activity).putBoolean("floating_dilag_show_flag_" + MokuConfigure.getInstance().getPhoneInfo(activity).getAppId(), false);
                    Intent intent = new Intent();
                    intent.setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    activity.startActivityForResult(intent, 605);
                    customBuildDialog.dismiss();
                }
            }
        }).setLeftBtn("取消", new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.utils.FloatingUtil.13
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                SharedPreferencesUtils.getInstance(activity).putBoolean("floating_dilag_show_flag_" + MokuConfigure.getInstance().getPhoneInfo(activity).getAppId(), false);
                customBuildDialog.dismiss();
            }
        }).setCancelable(false).create().show();
    }

    public boolean isAppRunningForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            LogUtils.logD(TAG, "processName==>" + runningAppProcessInfo.processName + ",floatingUtilName==>" + context.getApplicationInfo().processName);
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getApplicationInfo().processName)) {
                return true;
            }
        }
        return false;
    }

    public void moveAppToFront(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(100);
            if (runningTasks == null || runningTasks.isEmpty()) {
                return;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                    activityManager.moveTaskToFront(runningTaskInfo.id, 0);
                    if (isAppRunningForeground(context)) {
                        break;
                    }
                }
            }
            if (isAppRunningForeground(context)) {
                return;
            }
            LogUtils.logD(TAG, "move over,app is not running foreground,do it again");
            moveAppToFront(context);
        } catch (Exception unused) {
            LogUtils.logE(TAG, "move app to front error");
        }
    }

    private static int dp2px(int i) {
        return (int) ((i * ((int) Resources.getSystem().getDisplayMetrics().density)) + 0.5f);
    }
}
