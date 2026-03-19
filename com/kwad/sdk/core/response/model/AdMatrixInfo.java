package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdMatrixInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -1399297421861223421L;
    public Styles styles = new Styles();
    public AdDataV2 adDataV2 = new AdDataV2();
    public List<MatrixTag> tag = new ArrayList();

    public static class ActionBarInfoNew extends BaseMatrixTemplate {
        private static final long serialVersionUID = -2897900789505229105L;
        public int cardType;
        public long maxTimeOut;
    }

    public static class ActivityMiddlePageInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -7126817779477974119L;
        public boolean showHeaderBar;
    }

    public static class AdBannerTKInfo extends BaseMatrixTemplate {
    }

    public static class AdDataV2 extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8017805390945915342L;
        public List<TemplateData> templateDataList = new ArrayList();
        public BottomBannerInfo bottomBannerInfo = new BottomBannerInfo();
        public ActionBarInfoNew actionBarInfo = new ActionBarInfoNew();
        public AggregationCardInfo aggregationCardInfo = new AggregationCardInfo();
        public BaseMatrixTemplate halfCardInfo = new BaseMatrixTemplate();
        public EndCardInfo endCardInfo = new EndCardInfo();
        public InterstitialCardInfo interstitialCardInfo = new InterstitialCardInfo();
        public FeedInfo feedInfo = new FeedInfo();
        public FeedTKInfo feedTKCardInfo = new FeedTKInfo();
        public DrawTKInfo drawTKCardInfo = new DrawTKInfo();
        public FeedInfo adUnionFeedLiveMediaInfo = new FeedInfo();
        public FeedInfo adUnionFeedLiveTemplateInfo = new FeedInfo();
        public NativeMatrixAdInfo nativeAdInfo = new NativeMatrixAdInfo();
        public BaseMatrixTemplate complianceCardInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate downloadConfirmCardInfo = new BaseMatrixTemplate();
        public SplashInfo splashInfo = new SplashInfo();
        public NeoVideoInfo neoVideoInfo = new NeoVideoInfo();
        public FullScreenInfo fullScreenInfo = new FullScreenInfo();
        public BaseMatrixTemplate middleTKCardInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate actionBarTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate topBarTKInfo = new BaseMatrixTemplate();
        public SplashPlayCardTKInfo splashPlayCardTKInfo = new SplashPlayCardTKInfo();
        public SplashEndCardTKInfo splashEndCardTKInfo = new SplashEndCardTKInfo();
        public TopFloorTKInfo topFloorTKInfo = new TopFloorTKInfo();
        public ActivityMiddlePageInfo activityMiddlePageInfo = new ActivityMiddlePageInfo();
        public AdBannerTKInfo bannerTKInfo = new AdBannerTKInfo();
        public BaseMatrixTemplate confirmTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate playendTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate activityTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate neoTKInfo = new BaseMatrixTemplate();
        public RewardVideoInteractInfo rewardVideoInteractInfo = new RewardVideoInteractInfo();
        public RewardVideoTaskInfo rewardVideoTaskInfo = new RewardVideoTaskInfo();
        public RewardWebTaskCloseInfo rewardWebTaskCloseInfo = new RewardWebTaskCloseInfo();
        public MerchantLiveReservationInfo merchantLiveReservationInfo = new MerchantLiveReservationInfo();
        public PushTKInfo pushTKInfo = new PushTKInfo();
        public BaseMatrixTemplate splashActionBarInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate videoLiveTKInfo = new BaseMatrixTemplate();
        public PreLandingPageTKInfo preLandingPageTKInfo = new PreLandingPageTKInfo();
        public InstalledActivateInfo installedActivateInfo = new InstalledActivateInfo();
        public BaseMatrixTemplate videoImageTKInfo = new BaseMatrixTemplate();
        public DynamicAdStyleInfo dynamicAdStyleInfo = new DynamicAdStyleInfo();
        public StyleComponentInfo styleComponentInfo = new StyleComponentInfo();
    }

    public static class AdInteractionInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8105791433429537031L;
        public int interactiveStyle;
        public int interactivityDefaultStyle;
        public boolean isMediaDisable;
        public long switchDefaultTime;
        public long tkDefaultTimeout;
        public ShakeInfo shakeInfo = new ShakeInfo();
        public RotateInfo rotateInfo = new RotateInfo();
        public SplashSlideInfo slideInfo = new SplashSlideInfo();
        public SplashActionBarInfo splashActionBarInfo = new SplashActionBarInfo();
    }

    public static class AggregationCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6065340139053228242L;
        public int changeTime;
        public long intervalTime;
        public int maxTimesPerDay;
    }

    public static class BaseMatrixTemplate extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 3594661163877934414L;
        public int renderType;
        public String templateId;
    }

    public static class BottomBannerInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 9099955467009566699L;
        public int bannerAdType;
        public int bannerSizeType;
    }

    public static class ComponentTemplateInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -3398581722356429112L;
        public long pageId;
    }

    public static class CycleAggregateInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 3365726199254620321L;
        public String convertIconUrl;
        public String cutIconUrl;
        public String refreshIconUrl;
    }

    public static class DownloadTexts extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -4102977044762642151L;
        public String adActionDescription;
        public String installAppLabel;
        public String openAppLabel;
    }

    public static class DrawTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1723968281998535281L;
    }

    public static class DynamicAdStyleInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 7232188889951146059L;
        public SlideInfo slideInfo = new SlideInfo();
    }

    public static class EndCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1534468715847534303L;
        public int cardShowPlayCount;
        public int cardType;
    }

    public static class FeedInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -299328228771513399L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    public static class FeedTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -7328588644194532249L;
    }

    public static class FullScreenInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    public static class InstalledActivateInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -959583814667849237L;
        public boolean cardSwitch;
        public long showTime;
    }

    public static class InterstitialCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -5881505827627373593L;
        public boolean closeAfterClick;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
        public CycleAggregateInfo cycleAggregateInfo = new CycleAggregateInfo();
    }

    public static class MatrixTag extends com.kwad.sdk.core.response.a.a implements Serializable {
        public boolean isHide;
        public int styleId;
        public String type;
    }

    public static class MatrixTemplate extends BaseMatrixTemplate {
        private static final long serialVersionUID = 1943039524913069727L;
        public int publishType;
        public String templateMd5;
        public String templateUrl;
        public String templateVersion;
        public long templateVersionCode;
    }

    public static class NativeMatrixAdInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 5885576699867745221L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    public static class NeoVideoInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    public static class PushTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1907990715102735992L;
    }

    public static class RewardVideoInteractInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 8875349394489272055L;
        public int dayMaxLimit;
        public int duration;
        public String errorMsg;
        public int intervalShow;
        public int rewardTime;
        public int showTime;
        public int style;
        public StyleInfo styleInfo = new StyleInfo();
        public String successfulMsg;
        public String templateId;
    }

    public static class RewardVideoTaskInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 2487245975856269581L;
        public int duration;
        public int showTime;
        public int taskType;
        public String templateId;
        public int thresholdTime;
    }

    public static class RewardWebTaskCloseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -2697443981301300766L;
        public String templateId;
        public int webConfirmCardType;
    }

    public static class RotateDegreeInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 64198654819103772L;
        public int direction;
        public int rotateDegree;
    }

    public static class RotateInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -237926423883960071L;
        public boolean enable;
        public String subTitle;
        public String title;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public RotateDegreeInfo x = new RotateDegreeInfo();
        public RotateDegreeInfo y = new RotateDegreeInfo();
        public RotateDegreeInfo z = new RotateDegreeInfo();
    }

    public static class ShakeInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 4528782399998808588L;
        public int acceleration;
        public boolean clickDisabled;
        public int componentIndex;
        public boolean enable;
        public String subtitle;
        public String title;
    }

    public static class SlideInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 4115207086563665676L;
        public List<Integer> angle;
    }

    public static class SplashActionBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -8978521089375262615L;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public String title;
    }

    public static class SplashEndCardTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 3536091976265473949L;
        public int endCardCountDaily;
        public boolean endCardFullScreenClick;
        public boolean endCardShowCountDown;
        public int endCardShowSecond;
    }

    public static class SplashInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 240426032769377332L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    public static class SplashPlayCardTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 2182484890680464601L;
        public int tkTimeout;
    }

    public static class SplashSlideInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6853322623324615011L;
        public int convertDistance;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public int style;
        public String subtitle;
        public String title;
    }

    public static class StyleComponentInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 8981726105664791969L;
        public boolean styleComponentFlag;
        public ComponentTemplateInfo playCardInfo = new ComponentTemplateInfo();
        public ComponentTemplateInfo endCardInfo = new ComponentTemplateInfo();
    }

    public static class StyleInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 7597936730431611526L;
        public String title;
    }

    public static class Styles extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 1713930699658485883L;
        public List<MatrixTemplate> templateList = new ArrayList();
    }

    public static class TemplateData extends BaseMatrixTemplate {
        private static final long serialVersionUID = -3330357033837521996L;
        public String data;
        public long templateDelayTime;
        public long templateShowTime;
    }

    public static class TopFloorTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 341571719184500541L;
    }

    public static class MerchantLiveReservationInfo extends BaseMatrixTemplate implements Serializable {
        private static final int MIN_COUNT = 50;
        private static final long serialVersionUID = -6879010521415024815L;
        public int bookUserCount;
        public List<String> bookUserUrlList;
        public boolean displayBookCount;
        public boolean displayWeakCard;
        public String liveStartTime;
        public LiveReservationPlayEndInfo playEndCard;
        public String title;
        public String userHeadUrl;

        public static class LiveReservationPlayEndInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 1682477964084325954L;
            public String detailBtnTitle = "查看详情";
            public String reservationBtnTitle = "立即预约";
        }

        public boolean needShowSubscriberCount() {
            return this.displayBookCount && this.bookUserCount >= 50;
        }

        public String getFormattedLiveSubscribeCount() {
            int i = this.bookUserCount;
            if (i < 50) {
                return null;
            }
            if (i < 10000) {
                return this.bookUserCount + "人";
            }
            return new DecimalFormat("#.#").format(this.bookUserCount / 10000.0f) + "万人";
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.liveStartTime) && TextUtils.isEmpty(this.userHeadUrl);
        }
    }

    public static class PreLandingPageTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -6610860492486529913L;
        public int preLandingPageShowType = 1;

        public boolean isSkipShow() {
            int i = this.preLandingPageShowType;
            return i == 3 || i == 1;
        }

        public boolean isPlayEndShow() {
            int i = this.preLandingPageShowType;
            return i == 2 || i == 1;
        }
    }

    public static class ComponentParam extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 8705799417201787199L;
        public long endPageId;
        public long pageId;

        public static ComponentParam obtain() {
            return new ComponentParam();
        }

        public ComponentParam setPageId(Long l) {
            this.pageId = l.longValue();
            return this;
        }

        public ComponentParam setEndCardPageId(Long l) {
            this.endPageId = l.longValue();
            return this;
        }
    }
}
