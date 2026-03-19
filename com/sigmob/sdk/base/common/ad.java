package com.sigmob.sdk.base.common;

import com.google.android.material.timepicker.TimeModel;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class ad implements r {
    public static final String a = "RewardVideoViewAbilitySession";
    private boolean c;
    private int d;
    private int b = 0;
    private int e = 0;

    ad() {
    }

    private String a(int millis) {
        return millis == 0 ? "0" : String.valueOf(millis / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, BaseAdUnit baseAdUnit, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setVtime(b(this.b));
            pointEntitySigmob.setSkip_show_time(b(this.d));
            pointEntitySigmob.setCurrent_time(b(i));
            pointEntitySigmob.setPlay_process(String.valueOf((i * 1.0d) / b()));
            if (str.equals("start")) {
                pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
                pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
                pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
            }
            pointEntitySigmob.setPlay_time(a(i));
            pointEntitySigmob.setSet_close_time(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(this.e)));
            pointEntitySigmob.setIs_truncation(a() ? "1" : "0");
            pointEntitySigmob.setIs_force(this.c ? "1" : "0");
        }
    }

    private void a(final BaseAdUnit adUnit, final String event, final int playHeadMillis, String sub) {
        ac.a(event, sub, adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.ad$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                this.f$0.a(playHeadMillis, event, adUnit, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(HashMap map, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (com.sigmob.sdk.base.utils.e.b(map)) {
                pointEntitySigmob.getOptions().putAll(map);
            }
        }
    }

    private boolean a() {
        int i = this.e;
        return i > 0 && i * 1000 < this.b;
    }

    private int b() {
        int i = this.e;
        return (i <= 0 || i * 1000 >= this.b) ? this.b : i * 1000;
    }

    private String b(int millis) {
        return millis == 0 ? "0" : String.format(Locale.getDefault(), "%.2f", Float.valueOf(millis / 1000.0f));
    }

    private void b(BaseAdUnit adUnit, String event, int playHeadMillis) {
        a(adUnit, event, playHeadMillis, (String) null);
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, int duration, int end_time) {
        this.b = duration;
        this.e = adUnit.getEndTime();
        adUnit.getMacroCommon().addMarcoKey(SigMacroCommon._VIDEOTIME_, a(this.b));
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04bf A[Catch: all -> 0x07b2, TryCatch #0 {all -> 0x07b2, blocks: (B:3:0x0009, B:7:0x0020, B:10:0x002c, B:13:0x0038, B:16:0x0044, B:19:0x0050, B:22:0x005c, B:25:0x0068, B:28:0x0071, B:31:0x007a, B:34:0x0083, B:37:0x008f, B:40:0x009b, B:43:0x00a7, B:46:0x00b3, B:49:0x00be, B:52:0x00c9, B:55:0x00d2, B:58:0x00dd, B:61:0x00e9, B:64:0x00f2, B:67:0x00fc, B:70:0x0105, B:73:0x0111, B:76:0x011c, B:79:0x0127, B:85:0x015d, B:230:0x070b, B:86:0x0162, B:87:0x0167, B:88:0x017c, B:89:0x0181, B:90:0x0197, B:91:0x01ad, B:92:0x01c3, B:93:0x01c8, B:95:0x01ce, B:96:0x01dd, B:97:0x01e5, B:98:0x01ed, B:100:0x01f8, B:102:0x01fe, B:105:0x020b, B:107:0x021d, B:106:0x021a, B:109:0x0232, B:111:0x0238, B:113:0x023f, B:115:0x0245, B:116:0x025a, B:119:0x026d, B:121:0x027f, B:120:0x027c, B:123:0x0295, B:124:0x0299, B:128:0x02a7, B:130:0x02d1, B:131:0x02de, B:133:0x02ea, B:134:0x02f9, B:136:0x0305, B:137:0x0314, B:140:0x0326, B:141:0x0336, B:144:0x0345, B:145:0x0349, B:149:0x0353, B:151:0x0381, B:152:0x038c, B:154:0x0398, B:155:0x03a5, B:157:0x03b1, B:158:0x03be, B:161:0x03ce, B:162:0x03de, B:165:0x03ed, B:166:0x03f1, B:170:0x03fb, B:173:0x0435, B:174:0x046a, B:179:0x04b9, B:181:0x04bf, B:182:0x04ca, B:184:0x04d6, B:185:0x04e3, B:187:0x04ef, B:188:0x04fc, B:191:0x050c, B:193:0x051e, B:195:0x057a, B:196:0x05a7, B:200:0x05db, B:197:0x05ab, B:199:0x05b9, B:192:0x051b, B:175:0x046e, B:177:0x047c, B:178:0x04a7, B:203:0x063b, B:204:0x063f, B:208:0x0649, B:210:0x0677, B:211:0x0682, B:213:0x068e, B:214:0x069b, B:216:0x06a7, B:217:0x06b4, B:220:0x06c4, B:221:0x06d4, B:223:0x06db, B:225:0x06e1, B:228:0x06f9, B:229:0x0708, B:232:0x0712, B:235:0x071c, B:237:0x0723, B:241:0x0730, B:246:0x073f, B:249:0x0748, B:252:0x0760, B:253:0x076f, B:254:0x0773, B:258:0x07ad), top: B:264:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04d6 A[Catch: all -> 0x07b2, TryCatch #0 {all -> 0x07b2, blocks: (B:3:0x0009, B:7:0x0020, B:10:0x002c, B:13:0x0038, B:16:0x0044, B:19:0x0050, B:22:0x005c, B:25:0x0068, B:28:0x0071, B:31:0x007a, B:34:0x0083, B:37:0x008f, B:40:0x009b, B:43:0x00a7, B:46:0x00b3, B:49:0x00be, B:52:0x00c9, B:55:0x00d2, B:58:0x00dd, B:61:0x00e9, B:64:0x00f2, B:67:0x00fc, B:70:0x0105, B:73:0x0111, B:76:0x011c, B:79:0x0127, B:85:0x015d, B:230:0x070b, B:86:0x0162, B:87:0x0167, B:88:0x017c, B:89:0x0181, B:90:0x0197, B:91:0x01ad, B:92:0x01c3, B:93:0x01c8, B:95:0x01ce, B:96:0x01dd, B:97:0x01e5, B:98:0x01ed, B:100:0x01f8, B:102:0x01fe, B:105:0x020b, B:107:0x021d, B:106:0x021a, B:109:0x0232, B:111:0x0238, B:113:0x023f, B:115:0x0245, B:116:0x025a, B:119:0x026d, B:121:0x027f, B:120:0x027c, B:123:0x0295, B:124:0x0299, B:128:0x02a7, B:130:0x02d1, B:131:0x02de, B:133:0x02ea, B:134:0x02f9, B:136:0x0305, B:137:0x0314, B:140:0x0326, B:141:0x0336, B:144:0x0345, B:145:0x0349, B:149:0x0353, B:151:0x0381, B:152:0x038c, B:154:0x0398, B:155:0x03a5, B:157:0x03b1, B:158:0x03be, B:161:0x03ce, B:162:0x03de, B:165:0x03ed, B:166:0x03f1, B:170:0x03fb, B:173:0x0435, B:174:0x046a, B:179:0x04b9, B:181:0x04bf, B:182:0x04ca, B:184:0x04d6, B:185:0x04e3, B:187:0x04ef, B:188:0x04fc, B:191:0x050c, B:193:0x051e, B:195:0x057a, B:196:0x05a7, B:200:0x05db, B:197:0x05ab, B:199:0x05b9, B:192:0x051b, B:175:0x046e, B:177:0x047c, B:178:0x04a7, B:203:0x063b, B:204:0x063f, B:208:0x0649, B:210:0x0677, B:211:0x0682, B:213:0x068e, B:214:0x069b, B:216:0x06a7, B:217:0x06b4, B:220:0x06c4, B:221:0x06d4, B:223:0x06db, B:225:0x06e1, B:228:0x06f9, B:229:0x0708, B:232:0x0712, B:235:0x071c, B:237:0x0723, B:241:0x0730, B:246:0x073f, B:249:0x0748, B:252:0x0760, B:253:0x076f, B:254:0x0773, B:258:0x07ad), top: B:264:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04ef A[Catch: all -> 0x07b2, TryCatch #0 {all -> 0x07b2, blocks: (B:3:0x0009, B:7:0x0020, B:10:0x002c, B:13:0x0038, B:16:0x0044, B:19:0x0050, B:22:0x005c, B:25:0x0068, B:28:0x0071, B:31:0x007a, B:34:0x0083, B:37:0x008f, B:40:0x009b, B:43:0x00a7, B:46:0x00b3, B:49:0x00be, B:52:0x00c9, B:55:0x00d2, B:58:0x00dd, B:61:0x00e9, B:64:0x00f2, B:67:0x00fc, B:70:0x0105, B:73:0x0111, B:76:0x011c, B:79:0x0127, B:85:0x015d, B:230:0x070b, B:86:0x0162, B:87:0x0167, B:88:0x017c, B:89:0x0181, B:90:0x0197, B:91:0x01ad, B:92:0x01c3, B:93:0x01c8, B:95:0x01ce, B:96:0x01dd, B:97:0x01e5, B:98:0x01ed, B:100:0x01f8, B:102:0x01fe, B:105:0x020b, B:107:0x021d, B:106:0x021a, B:109:0x0232, B:111:0x0238, B:113:0x023f, B:115:0x0245, B:116:0x025a, B:119:0x026d, B:121:0x027f, B:120:0x027c, B:123:0x0295, B:124:0x0299, B:128:0x02a7, B:130:0x02d1, B:131:0x02de, B:133:0x02ea, B:134:0x02f9, B:136:0x0305, B:137:0x0314, B:140:0x0326, B:141:0x0336, B:144:0x0345, B:145:0x0349, B:149:0x0353, B:151:0x0381, B:152:0x038c, B:154:0x0398, B:155:0x03a5, B:157:0x03b1, B:158:0x03be, B:161:0x03ce, B:162:0x03de, B:165:0x03ed, B:166:0x03f1, B:170:0x03fb, B:173:0x0435, B:174:0x046a, B:179:0x04b9, B:181:0x04bf, B:182:0x04ca, B:184:0x04d6, B:185:0x04e3, B:187:0x04ef, B:188:0x04fc, B:191:0x050c, B:193:0x051e, B:195:0x057a, B:196:0x05a7, B:200:0x05db, B:197:0x05ab, B:199:0x05b9, B:192:0x051b, B:175:0x046e, B:177:0x047c, B:178:0x04a7, B:203:0x063b, B:204:0x063f, B:208:0x0649, B:210:0x0677, B:211:0x0682, B:213:0x068e, B:214:0x069b, B:216:0x06a7, B:217:0x06b4, B:220:0x06c4, B:221:0x06d4, B:223:0x06db, B:225:0x06e1, B:228:0x06f9, B:229:0x0708, B:232:0x0712, B:235:0x071c, B:237:0x0723, B:241:0x0730, B:246:0x073f, B:249:0x0748, B:252:0x0760, B:253:0x076f, B:254:0x0773, B:258:0x07ad), top: B:264:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x051b A[Catch: all -> 0x07b2, TryCatch #0 {all -> 0x07b2, blocks: (B:3:0x0009, B:7:0x0020, B:10:0x002c, B:13:0x0038, B:16:0x0044, B:19:0x0050, B:22:0x005c, B:25:0x0068, B:28:0x0071, B:31:0x007a, B:34:0x0083, B:37:0x008f, B:40:0x009b, B:43:0x00a7, B:46:0x00b3, B:49:0x00be, B:52:0x00c9, B:55:0x00d2, B:58:0x00dd, B:61:0x00e9, B:64:0x00f2, B:67:0x00fc, B:70:0x0105, B:73:0x0111, B:76:0x011c, B:79:0x0127, B:85:0x015d, B:230:0x070b, B:86:0x0162, B:87:0x0167, B:88:0x017c, B:89:0x0181, B:90:0x0197, B:91:0x01ad, B:92:0x01c3, B:93:0x01c8, B:95:0x01ce, B:96:0x01dd, B:97:0x01e5, B:98:0x01ed, B:100:0x01f8, B:102:0x01fe, B:105:0x020b, B:107:0x021d, B:106:0x021a, B:109:0x0232, B:111:0x0238, B:113:0x023f, B:115:0x0245, B:116:0x025a, B:119:0x026d, B:121:0x027f, B:120:0x027c, B:123:0x0295, B:124:0x0299, B:128:0x02a7, B:130:0x02d1, B:131:0x02de, B:133:0x02ea, B:134:0x02f9, B:136:0x0305, B:137:0x0314, B:140:0x0326, B:141:0x0336, B:144:0x0345, B:145:0x0349, B:149:0x0353, B:151:0x0381, B:152:0x038c, B:154:0x0398, B:155:0x03a5, B:157:0x03b1, B:158:0x03be, B:161:0x03ce, B:162:0x03de, B:165:0x03ed, B:166:0x03f1, B:170:0x03fb, B:173:0x0435, B:174:0x046a, B:179:0x04b9, B:181:0x04bf, B:182:0x04ca, B:184:0x04d6, B:185:0x04e3, B:187:0x04ef, B:188:0x04fc, B:191:0x050c, B:193:0x051e, B:195:0x057a, B:196:0x05a7, B:200:0x05db, B:197:0x05ab, B:199:0x05b9, B:192:0x051b, B:175:0x046e, B:177:0x047c, B:178:0x04a7, B:203:0x063b, B:204:0x063f, B:208:0x0649, B:210:0x0677, B:211:0x0682, B:213:0x068e, B:214:0x069b, B:216:0x06a7, B:217:0x06b4, B:220:0x06c4, B:221:0x06d4, B:223:0x06db, B:225:0x06e1, B:228:0x06f9, B:229:0x0708, B:232:0x0712, B:235:0x071c, B:237:0x0723, B:241:0x0730, B:246:0x073f, B:249:0x0748, B:252:0x0760, B:253:0x076f, B:254:0x0773, B:258:0x07ad), top: B:264:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x057a A[Catch: all -> 0x07b2, TryCatch #0 {all -> 0x07b2, blocks: (B:3:0x0009, B:7:0x0020, B:10:0x002c, B:13:0x0038, B:16:0x0044, B:19:0x0050, B:22:0x005c, B:25:0x0068, B:28:0x0071, B:31:0x007a, B:34:0x0083, B:37:0x008f, B:40:0x009b, B:43:0x00a7, B:46:0x00b3, B:49:0x00be, B:52:0x00c9, B:55:0x00d2, B:58:0x00dd, B:61:0x00e9, B:64:0x00f2, B:67:0x00fc, B:70:0x0105, B:73:0x0111, B:76:0x011c, B:79:0x0127, B:85:0x015d, B:230:0x070b, B:86:0x0162, B:87:0x0167, B:88:0x017c, B:89:0x0181, B:90:0x0197, B:91:0x01ad, B:92:0x01c3, B:93:0x01c8, B:95:0x01ce, B:96:0x01dd, B:97:0x01e5, B:98:0x01ed, B:100:0x01f8, B:102:0x01fe, B:105:0x020b, B:107:0x021d, B:106:0x021a, B:109:0x0232, B:111:0x0238, B:113:0x023f, B:115:0x0245, B:116:0x025a, B:119:0x026d, B:121:0x027f, B:120:0x027c, B:123:0x0295, B:124:0x0299, B:128:0x02a7, B:130:0x02d1, B:131:0x02de, B:133:0x02ea, B:134:0x02f9, B:136:0x0305, B:137:0x0314, B:140:0x0326, B:141:0x0336, B:144:0x0345, B:145:0x0349, B:149:0x0353, B:151:0x0381, B:152:0x038c, B:154:0x0398, B:155:0x03a5, B:157:0x03b1, B:158:0x03be, B:161:0x03ce, B:162:0x03de, B:165:0x03ed, B:166:0x03f1, B:170:0x03fb, B:173:0x0435, B:174:0x046a, B:179:0x04b9, B:181:0x04bf, B:182:0x04ca, B:184:0x04d6, B:185:0x04e3, B:187:0x04ef, B:188:0x04fc, B:191:0x050c, B:193:0x051e, B:195:0x057a, B:196:0x05a7, B:200:0x05db, B:197:0x05ab, B:199:0x05b9, B:192:0x051b, B:175:0x046e, B:177:0x047c, B:178:0x04a7, B:203:0x063b, B:204:0x063f, B:208:0x0649, B:210:0x0677, B:211:0x0682, B:213:0x068e, B:214:0x069b, B:216:0x06a7, B:217:0x06b4, B:220:0x06c4, B:221:0x06d4, B:223:0x06db, B:225:0x06e1, B:228:0x06f9, B:229:0x0708, B:232:0x0712, B:235:0x071c, B:237:0x0723, B:241:0x0730, B:246:0x073f, B:249:0x0748, B:252:0x0760, B:253:0x076f, B:254:0x0773, B:258:0x07ad), top: B:264:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05ab A[Catch: all -> 0x07b2, TryCatch #0 {all -> 0x07b2, blocks: (B:3:0x0009, B:7:0x0020, B:10:0x002c, B:13:0x0038, B:16:0x0044, B:19:0x0050, B:22:0x005c, B:25:0x0068, B:28:0x0071, B:31:0x007a, B:34:0x0083, B:37:0x008f, B:40:0x009b, B:43:0x00a7, B:46:0x00b3, B:49:0x00be, B:52:0x00c9, B:55:0x00d2, B:58:0x00dd, B:61:0x00e9, B:64:0x00f2, B:67:0x00fc, B:70:0x0105, B:73:0x0111, B:76:0x011c, B:79:0x0127, B:85:0x015d, B:230:0x070b, B:86:0x0162, B:87:0x0167, B:88:0x017c, B:89:0x0181, B:90:0x0197, B:91:0x01ad, B:92:0x01c3, B:93:0x01c8, B:95:0x01ce, B:96:0x01dd, B:97:0x01e5, B:98:0x01ed, B:100:0x01f8, B:102:0x01fe, B:105:0x020b, B:107:0x021d, B:106:0x021a, B:109:0x0232, B:111:0x0238, B:113:0x023f, B:115:0x0245, B:116:0x025a, B:119:0x026d, B:121:0x027f, B:120:0x027c, B:123:0x0295, B:124:0x0299, B:128:0x02a7, B:130:0x02d1, B:131:0x02de, B:133:0x02ea, B:134:0x02f9, B:136:0x0305, B:137:0x0314, B:140:0x0326, B:141:0x0336, B:144:0x0345, B:145:0x0349, B:149:0x0353, B:151:0x0381, B:152:0x038c, B:154:0x0398, B:155:0x03a5, B:157:0x03b1, B:158:0x03be, B:161:0x03ce, B:162:0x03de, B:165:0x03ed, B:166:0x03f1, B:170:0x03fb, B:173:0x0435, B:174:0x046a, B:179:0x04b9, B:181:0x04bf, B:182:0x04ca, B:184:0x04d6, B:185:0x04e3, B:187:0x04ef, B:188:0x04fc, B:191:0x050c, B:193:0x051e, B:195:0x057a, B:196:0x05a7, B:200:0x05db, B:197:0x05ab, B:199:0x05b9, B:192:0x051b, B:175:0x046e, B:177:0x047c, B:178:0x04a7, B:203:0x063b, B:204:0x063f, B:208:0x0649, B:210:0x0677, B:211:0x0682, B:213:0x068e, B:214:0x069b, B:216:0x06a7, B:217:0x06b4, B:220:0x06c4, B:221:0x06d4, B:223:0x06db, B:225:0x06e1, B:228:0x06f9, B:229:0x0708, B:232:0x0712, B:235:0x071c, B:237:0x0723, B:241:0x0730, B:246:0x073f, B:249:0x0748, B:252:0x0760, B:253:0x076f, B:254:0x0773, B:258:0x07ad), top: B:264:0x0009 }] */
    @Override // com.sigmob.sdk.base.common.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.sigmob.sdk.base.models.BaseAdUnit r24, java.lang.String r25, int r26) {
        /*
            Method dump skipped, instructions count: 2156
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.ad.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, int):boolean");
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean a(BaseAdUnit adUnit, boolean isForceShow, int playHeadMillis) {
        this.c = isForceShow;
        this.d = playHeadMillis;
        return true;
    }

    @Override // com.sigmob.sdk.base.common.r
    public boolean b(BaseAdUnit adUnit) {
        com.sigmob.sdk.base.network.g.a(adUnit, "ad_close");
        a(adUnit, "ad_close", b(), (String) null);
        return true;
    }
}
