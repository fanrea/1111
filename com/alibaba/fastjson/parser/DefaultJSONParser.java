package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.mobads.container.o.j;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    private int objectKeyLevel;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this(str, new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this(cArr, new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.objectKeyLevel = 0;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) this.input);
        }
        return obj.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x029d, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02a8, code lost:
    
        if (r4.token() != 13) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02aa, code lost:
    
        r4.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02b5, code lost:
    
        if ((r16.config.getDeserializer(r7) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02b7, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r17, (java.lang.Class<java.lang.Object>) r7, r16.config);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02be, code lost:
    
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02bf, code lost:
    
        if (r0 != null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02c3, code lost:
    
        if (r7 != java.lang.Cloneable.class) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02c5, code lost:
    
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02d1, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02d3, code lost:
    
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02de, code lost:
    
        if ("java.util.Collections$UnmodifiableMap".equals(r6) == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02e0, code lost:
    
        r0 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02ea, code lost:
    
        r0 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02f1, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02f2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02fa, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02fb, code lost:
    
        setResolveStatus(2);
        r3 = r16.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0301, code lost:
    
        if (r3 == null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0303, code lost:
    
        if (r18 == null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0307, code lost:
    
        if ((r18 instanceof java.lang.Integer) != false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x030d, code lost:
    
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x030f, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0316, code lost:
    
        if (r17.size() <= 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0318, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r17, (java.lang.Class<java.lang.Object>) r7, r16.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0328, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0329, code lost:
    
        r0 = r16.config.getDeserializer(r7);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0339, code lost:
    
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x033d, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0341, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0343, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x034a, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x034c, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0357, code lost:
    
        return r0.deserialze(r16, r7, r18);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x022a A[Catch: all -> 0x06a2, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0455 A[Catch: all -> 0x06a2, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0481 A[Catch: all -> 0x06a2, TRY_ENTER, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04dd A[Catch: all -> 0x06a2, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x05e5 A[Catch: all -> 0x06a2, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05f1 A[Catch: all -> 0x06a2, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x05fd A[Catch: all -> 0x06a2, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0612 A[Catch: all -> 0x06a2, TRY_ENTER, TryCatch #0 {all -> 0x06a2, blocks: (B:24:0x0078, B:26:0x007c, B:29:0x0086, B:32:0x0099, B:36:0x00b2, B:115:0x022a, B:116:0x0230, B:118:0x023b, B:120:0x0243, B:124:0x0259, B:126:0x0267, B:141:0x0297, B:142:0x029d, B:144:0x02aa, B:145:0x02ad, B:147:0x02b7, B:152:0x02c5, B:153:0x02cb, B:155:0x02d3, B:156:0x02d8, B:158:0x02e0, B:159:0x02ea, B:163:0x02f3, B:164:0x02fa, B:165:0x02fb, B:168:0x0305, B:170:0x0309, B:172:0x030f, B:173:0x0312, B:175:0x0318, B:178:0x0329, B:184:0x0343, B:188:0x0350, B:185:0x0348, B:187:0x034c, B:128:0x026e, B:130:0x0274, B:135:0x0281, B:138:0x0287, B:196:0x0361, B:198:0x0367, B:200:0x036f, B:202:0x0379, B:204:0x038a, B:206:0x0395, B:208:0x039d, B:210:0x03a1, B:212:0x03a7, B:215:0x03ac, B:217:0x03b0, B:237:0x0402, B:239:0x040a, B:242:0x0413, B:243:0x0430, B:219:0x03b7, B:221:0x03bf, B:223:0x03c3, B:224:0x03c6, B:225:0x03d2, B:228:0x03db, B:230:0x03df, B:231:0x03e2, B:233:0x03e6, B:234:0x03ea, B:235:0x03f6, B:244:0x0431, B:245:0x0451, B:248:0x0455, B:250:0x0459, B:252:0x045d, B:254:0x0463, B:255:0x0466, B:259:0x046e, B:265:0x0481, B:267:0x0490, B:269:0x049b, B:270:0x04a3, B:271:0x04a6, B:283:0x04d2, B:285:0x04dd, B:289:0x04ea, B:292:0x04fa, B:293:0x051c, B:278:0x04b6, B:280:0x04c0, B:282:0x04cf, B:281:0x04c5, B:296:0x0521, B:298:0x052b, B:300:0x0533, B:301:0x0536, B:303:0x0541, B:304:0x0545, B:306:0x0550, B:309:0x0557, B:312:0x0564, B:313:0x0569, B:316:0x056e, B:318:0x0573, B:322:0x057e, B:324:0x0586, B:326:0x059b, B:330:0x05ba, B:332:0x05c0, B:335:0x05c6, B:337:0x05cc, B:339:0x05d4, B:342:0x05e5, B:345:0x05ed, B:347:0x05f1, B:348:0x05f8, B:350:0x05fd, B:351:0x0600, B:353:0x0608, B:356:0x0612, B:359:0x061c, B:360:0x0621, B:361:0x0626, B:362:0x0643, B:327:0x05a6, B:328:0x05ad, B:363:0x0644, B:365:0x0656, B:368:0x065d, B:371:0x066b, B:372:0x068d, B:39:0x00c4, B:40:0x00e6, B:43:0x00eb, B:45:0x00f6, B:47:0x00fa, B:49:0x00fe, B:51:0x0104, B:52:0x0107, B:59:0x0116, B:61:0x011e, B:64:0x012e, B:65:0x0148, B:66:0x0149, B:67:0x014e, B:78:0x0163, B:79:0x0169, B:81:0x0170, B:83:0x0179, B:90:0x018b, B:93:0x0193, B:94:0x01ad, B:88:0x0186, B:82:0x0175, B:95:0x01ae, B:96:0x01c8, B:102:0x01d2, B:104:0x01da, B:107:0x01eb, B:108:0x020f, B:109:0x0210, B:110:0x0215, B:111:0x0216, B:113:0x0220, B:373:0x068e, B:374:0x0695, B:375:0x0696, B:376:0x069b, B:377:0x069c, B:378:0x06a1), top: B:382:0x0078, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x04e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0608 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 1703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                T t = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t;
            }
            if (type == char[].class) {
                String strStringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) strStringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() == JavaBeanDeserializer.class) {
                if (this.lexer.token() != 12 && this.lexer.token() != 14) {
                    throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                }
                return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
            }
            return (T) deserializer.deserialze(this, type, obj);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i != 14) {
            throw new JSONException("expect '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
        if (Integer.TYPE == type) {
            deserializer = IntegerCodec.instance;
            this.lexer.nextToken(2);
        } else if (String.class == type) {
            deserializer = StringCodec.instance;
            this.lexer.nextToken(4);
        } else {
            deserializer = this.config.getDeserializer(type);
            this.lexer.nextToken(deserializer.getFastMatchToken());
        }
        ParseContext parseContext = this.context;
        setContext(collection, obj);
        int i2 = 0;
        while (true) {
            try {
                if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (this.lexer.token() == 16) {
                        this.lexer.nextToken();
                    }
                }
                if (this.lexer.token() != 15) {
                    Object objDeserialze = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            objDeserialze = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object obj2 = parse();
                            if (obj2 != null) {
                                objDeserialze = obj2.toString();
                            }
                        }
                        collection.add(objDeserialze);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            objDeserialze = deserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(objDeserialze);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i2++;
                } else {
                    setContext(parseContext);
                    this.lexer.nextToken(16);
                    return;
                }
            } catch (Throwable th) {
                setContext(parseContext);
                throw th;
            }
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object objCast;
        Class<?> componentType;
        boolean zIsArray;
        Class cls;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() != 14) {
            throw new JSONException("syntax error : " + this.lexer.tokenName());
        }
        Object[] objArr = new Object[typeArr.length];
        if (typeArr.length == 0) {
            this.lexer.nextToken(15);
            if (this.lexer.token() != 15) {
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(16);
            return new Object[0];
        }
        this.lexer.nextToken(2);
        int i3 = 0;
        while (i3 < typeArr.length) {
            if (this.lexer.token() == i) {
                this.lexer.nextToken(16);
                objCast = null;
            } else {
                Type type = typeArr[i3];
                if (type == Integer.TYPE || type == Integer.class) {
                    if (this.lexer.token() == 2) {
                        objCast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        objCast = TypeUtils.cast(parse(), type, this.config);
                    }
                } else if (type == String.class) {
                    if (this.lexer.token() == 4) {
                        objCast = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        objCast = TypeUtils.cast(parse(), type, this.config);
                    }
                } else {
                    if (i3 == typeArr.length - 1 && (type instanceof Class) && (((cls = (Class) type) != byte[].class && cls != char[].class) || this.lexer.token() != 4)) {
                        zIsArray = cls.isArray();
                        componentType = cls.getComponentType();
                    } else {
                        componentType = null;
                        zIsArray = false;
                    }
                    if (zIsArray && this.lexer.token() != i2) {
                        ArrayList arrayList = new ArrayList();
                        ObjectDeserializer deserializer = this.config.getDeserializer(componentType);
                        int fastMatchToken = deserializer.getFastMatchToken();
                        if (this.lexer.token() != 15) {
                            while (true) {
                                arrayList.add(deserializer.deserialze(this, type, null));
                                if (this.lexer.token() != 16) {
                                    break;
                                }
                                this.lexer.nextToken(fastMatchToken);
                            }
                            if (this.lexer.token() != 15) {
                                throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                            }
                        }
                        objCast = TypeUtils.cast(arrayList, type, this.config);
                    } else {
                        objCast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                    }
                }
            }
            objArr[i3] = objCast;
            if (this.lexer.token() == 15) {
                break;
            }
            if (this.lexer.token() != 16) {
                throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
            }
            if (i3 == typeArr.length - 1) {
                this.lexer.nextToken(15);
            } else {
                this.lexer.nextToken(2);
            }
            i3++;
            i = 8;
            i2 = 14;
        }
        if (this.lexer.token() != 15) {
            throw new JSONException("syntax error");
        }
        this.lexer.nextToken(16);
        return objArr;
    }

    public void parseObject(Object obj) {
        Object objDeserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String strScanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (strScanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() != 16 || !this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(strScanSymbol) : null;
            if (fieldDeserializer == null) {
                if (!this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + strScanSymbol);
                }
                this.lexer.nextTokenWithColon();
                parse();
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken();
                    return;
                }
            } else {
                Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                Type type = fieldDeserializer.fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    objDeserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    objDeserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    objDeserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, objDeserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            throw new JSONException("not support type " + type);
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            ArrayList arrayList = new ArrayList();
            parseArray((Class<?>) type2, (Collection) arrayList);
            return arrayList;
        }
        if (type2 instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type2;
            Type type3 = wildcardType.getUpperBounds()[0];
            if (Object.class.equals(type3)) {
                if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                }
                throw new JSONException("not support type : " + type);
            }
            ArrayList arrayList2 = new ArrayList();
            parseArray((Class<?>) type3, (Collection) arrayList2);
            return arrayList2;
        }
        if (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 1) {
                throw new JSONException("not support : " + typeVariable);
            }
            Type type4 = bounds[0];
            if (type4 instanceof Class) {
                ArrayList arrayList3 = new ArrayList();
                parseArray((Class<?>) type4, (Collection) arrayList3);
                return arrayList3;
            }
        }
        if (type2 instanceof ParameterizedType) {
            ArrayList arrayList4 = new ArrayList();
            parseArray((ParameterizedType) type2, arrayList4);
            return arrayList4;
        }
        throw new JSONException("TODO : " + type);
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        }
        if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
                return;
            }
            return;
        }
        throw new JSONException("type not match error");
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                int size = collection.size() - 1;
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        Object object = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (object instanceof JSONObject) {
            return (JSONObject) object;
        }
        if (object == null) {
            return null;
        }
        return new JSONObject((Map<String, Object>) object);
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number numberDecimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() != 14) {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
        jSONLexer.nextToken(4);
        ParseContext parseContext = this.context;
        if (parseContext != null && parseContext.level > 512) {
            throw new JSONException("array level > 512");
        }
        ParseContext parseContext2 = this.context;
        setContext(collection, obj);
        int i = 0;
        while (true) {
            try {
                if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                int i2 = jSONLexer.token();
                Object object = null;
                object = null;
                if (i2 == 2) {
                    Number numberIntegerValue = jSONLexer.integerValue();
                    jSONLexer.nextToken(16);
                    object = numberIntegerValue;
                } else if (i2 == 3) {
                    if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                        numberDecimalValue = jSONLexer.decimalValue(true);
                    } else {
                        numberDecimalValue = jSONLexer.decimalValue(false);
                    }
                    object = numberDecimalValue;
                    jSONLexer.nextToken(16);
                } else if (i2 == 4) {
                    String strStringVal = jSONLexer.stringVal();
                    jSONLexer.nextToken(16);
                    object = strStringVal;
                    if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                        JSONScanner jSONScanner = new JSONScanner(strStringVal);
                        Object time = strStringVal;
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            time = jSONScanner.getCalendar().getTime();
                        }
                        jSONScanner.close();
                        object = time;
                    }
                } else if (i2 == 6) {
                    Boolean bool = Boolean.TRUE;
                    jSONLexer.nextToken(16);
                    object = bool;
                } else if (i2 == 7) {
                    Boolean bool2 = Boolean.FALSE;
                    jSONLexer.nextToken(16);
                    object = bool2;
                } else if (i2 == 8) {
                    jSONLexer.nextToken(4);
                } else if (i2 == 12) {
                    object = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                } else {
                    if (i2 == 20) {
                        throw new JSONException("unclosed jsonArray");
                    }
                    if (i2 == 23) {
                        jSONLexer.nextToken(4);
                    } else if (i2 == 14) {
                        JSONArray jSONArray = new JSONArray();
                        parseArray(jSONArray, Integer.valueOf(i));
                        object = jSONArray;
                        if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                            object = jSONArray.toArray();
                        }
                    } else {
                        if (i2 == 15) {
                            jSONLexer.nextToken(16);
                            return;
                        }
                        object = parse();
                    }
                }
                collection.add(object);
                checkListResolve(collection);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
                i++;
            } finally {
                setContext(parseContext2);
            }
        }
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i = this.contextArrayIndex;
        if (i <= 0) {
            return;
        }
        int i2 = i - 1;
        this.contextArrayIndex = i2;
        this.contextArray[i2] = null;
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse(null);
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String strStringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return strStringVal;
        }
        return parse(null);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number numberIntegerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return numberIntegerValue;
        }
        if (i == 3) {
            Number numberDecimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return numberDecimalValue;
        }
        if (i == 4) {
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(strStringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return strStringVal;
        }
        if (i == 12) {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
        if (i == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
        }
        if (i == 18) {
            if ("NaN".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                return null;
            }
            throw new JSONException("syntax error, " + jSONLexer.info());
        }
        if (i != 26) {
            switch (i) {
                case 6:
                    jSONLexer.nextToken();
                    return Boolean.TRUE;
                case 7:
                    jSONLexer.nextToken();
                    return Boolean.FALSE;
                case 8:
                    jSONLexer.nextToken();
                    return null;
                case 9:
                    jSONLexer.nextToken(18);
                    if (jSONLexer.token() != 18) {
                        throw new JSONException("syntax error");
                    }
                    jSONLexer.nextToken(10);
                    accept(10);
                    long jLongValue = jSONLexer.integerValue().longValue();
                    accept(2);
                    accept(11);
                    return new Date(jLongValue);
                default:
                    switch (i) {
                        case 20:
                            if (jSONLexer.isBlankInput()) {
                                return null;
                            }
                            throw new JSONException("unterminated json string, " + jSONLexer.info());
                        case 21:
                            jSONLexer.nextToken();
                            HashSet hashSet = new HashSet();
                            parseArray(hashSet, obj);
                            return hashSet;
                        case 22:
                            jSONLexer.nextToken();
                            TreeSet treeSet = new TreeSet();
                            parseArray(treeSet, obj);
                            return treeSet;
                        case 23:
                            jSONLexer.nextToken();
                            return null;
                        default:
                            throw new JSONException("syntax error, " + jSONLexer.info());
                    }
            }
        }
        byte[] bArrBytesValue = jSONLexer.bytesValue();
        jSONLexer.nextToken();
        return bArrBytesValue;
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object resolveReference(java.lang.String r5) {
        /*
            r4 = this;
            com.alibaba.fastjson.parser.ParseContext[] r0 = r4.contextArray
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r0 = 0
        L7:
            com.alibaba.fastjson.parser.ParseContext[] r2 = r4.contextArray
            int r3 = r2.length
            if (r0 >= r3) goto L22
            int r3 = r4.contextArrayIndex
            if (r0 >= r3) goto L22
            r2 = r2[r0]
            java.lang.String r3 = r2.toString()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L1f
            java.lang.Object r5 = r2.object
            return r5
        L1f:
            int r0 = r0 + 1
            goto L7
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.resolveReference(java.lang.String):java.lang.Object");
    }

    public void handleResovleTask(Object obj) {
        Object objEval;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i);
            String str = resolveTask.referenceValue;
            Object obj2 = resolveTask.ownerContext != null ? resolveTask.ownerContext.object : null;
            if (str.startsWith(j.a)) {
                objEval = getObject(str);
                if (objEval == null) {
                    try {
                        JSONPath jSONPathCompile = JSONPath.compile(str);
                        if (jSONPathCompile.isRef()) {
                            objEval = jSONPathCompile.eval(obj);
                        }
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                objEval = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (objEval != null && objEval.getClass() == JSONObject.class && fieldDeserializer.fieldInfo != null && !Map.class.isAssignableFrom(fieldDeserializer.fieldInfo.fieldClass)) {
                    Object obj3 = this.contextArray[0].object;
                    JSONPath jSONPathCompile2 = JSONPath.compile(str);
                    if (jSONPathCompile2.isRef()) {
                        objEval = jSONPathCompile2.eval(obj3);
                    }
                }
                fieldDeserializer.setValue(obj2, objEval);
            }
        }
    }

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public void parseExtra(Object obj, String str) {
        Object object;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type extraType = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                extraType = it.next().getExtraType(obj, str);
            }
        }
        if (extraType == null) {
            object = parse();
        } else {
            object = parseObject(extraType);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, object);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, object);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0246, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }
}
