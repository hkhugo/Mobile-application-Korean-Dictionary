package com.example.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PhraseDB {
    private Context context;
    private static final int MaxCategoryNumber = 30;
    private static final int MaxCategorySize = 30;
    public static Phrase[][] database = new Phrase[MaxCategoryNumber][MaxCategorySize];

    public PhraseDB(Context current) {
        context = current;

        //init all the phrase data in the database
        database[0][0] = new Phrase(context,0,0,"I need to reset my password","비밀번호를 재발급 하고 싶어요","bimilbeonhoreul jaebalgeup hago sipeoyo","audio_bimilbeonhoreul_jaebalgeup_hago_sipeoyo");
        database[0][1] = new Phrase(context,0,1,"I would like an ATM card","체크 카드를 만들고 싶어요","chekeu kadeureul mandeulgo sipeoyo","audio_chekeu_kadeureul_mandeulgo_sipeoyo");
        database[0][2] = new Phrase(context,0,2,"I need to make a withdrawal","출금 해주세요","chulgeum haejuseyo","audio_chulgeum_haejuseyo");
        database[0][3] = new Phrase(context,0,3,"I would like to apply for a public certificate","공인인증서 발급하고 싶어요","gongininjeungseo balgeuphago sipeoyo","audio_gongininjeungseo_balgeuphago_sipeoyo");
        database[0][4] = new Phrase(context,0,4,"Do you need internet banking?","인터넷 뱅킹 필요해요?","inteonet baenking piryohaeyo?","audio_inteonet_baenking_piryohaeyo");
        database[0][5] = new Phrase(context,0,5,"I need to make a deposit","입금 해주세요","ipgeum haejuseyo","audio_ipgeum_haejuseyo");
        database[0][6] = new Phrase(context,0,6,"I want to send money to Philippines","필리핀에 돈 보내려고 왔어요","pillipine don bonaeryeogo wasseoyo","audio_pillipine_don_bonaeryeogo_wasseoyo");
        database[0][7] = new Phrase(context,0,7,"Do you have an ID card","신분증 있어요?","sinbunjeung isseoyo?","audio_sinbunjeung_isseoyo");
        database[0][8] = new Phrase(context,0,8,"Please give me your ID card","신분증 주세요","sinbunjeung juseyo","audio_sinbunjeung_juseyo");
        database[0][9] = new Phrase(context,0,9,"Can I apply for a credit card?","신용 카드 신청할 수 있어요?","sinyong kadeu sincheonghal su isseoyo?","audio_sinyong_kadeu_sincheonghal_su_isseoyo");
        database[0][10] = new Phrase(context,0,10,"How much is the wire transfer charge?","송금 수수료는 얼마예요?","songgeum susuryoneun eolmayeyo?","audio_songgeum_susuryoneun_eolmayeyo");
        database[0][11] = new Phrase(context,0,11,"Are there monthly fees?","수수료 있어요?","susuryo isseoyo?","audio_susuryo_isseoyo");
        database[0][12] = new Phrase(context,0,12,"I would like to open a new bank account","통장을 만들고 싶어요","tongjangeul mandeulgo sipeoyo","audio_tongjangeul_mandeulgo_sipeoyo");
        database[1][0] = new Phrase(context,1,0,"Maybe","아마도","amado","audio_amado");
        database[1][1] = new Phrase(context,1,1,"No","아니요","aniyo","audio_aniyo");
        database[1][2] = new Phrase(context,1,2,"Hello","안녕하세요?","annyeonghaseyo?","audio_annyeonghaseyo");
        database[1][3] = new Phrase(context,1,3,"Good morning","안녕하세요?","annyeonghaseyo?","audio_annyeonghaseyo");
        database[1][4] = new Phrase(context,1,4,"Good evening","안녕하세요?","annyeonghaseyo?","audio_annyeonghaseyo");
        database[1][5] = new Phrase(context,1,5,"Goodbye (to person leaving)","안녕히 가세요","annyeonghi gaseyo","audio_annyeonghigaseyo");
        database[1][6] = new Phrase(context,1,6,"Goodbye (to person staying)","안녕히 계세요","annyeonghi gyeseyo","audio_annyeonghigyeseyo");
        database[1][7] = new Phrase(context,1,7,"I feel sick","아파요","apayo","audio_apayo");
        database[1][8] = new Phrase(context,1,8,"Take me to the hospital (to taxi)","병원에 가주세요","byeongwone gajuseyo","audio_byeongwone_gajuseyo");
        database[1][9] = new Phrase(context,1,9,"Don’t mention it","천만에요","cheonmaneyo","audio_cheonmaneyo");
        database[1][10] = new Phrase(context,1,10,"Thank You","고맙습니다","gomapseumnida","audio_gomapseumnida");
        database[1][11] = new Phrase(context,1,11,"That’s OK","괜찮아요","gwaenchanayo","audio_gwaenchanayo");
        database[1][12] = new Phrase(context,1,12,"Welcome","환영합니다","hwanyeonghamnida","audio_hwanyeonghamnida");
        database[1][13] = new Phrase(context,1,13,"Get home safely","잘 가요","jal gayo","audio_jal_gayo");
        database[1][14] = new Phrase(context,1,14,"Sleep well","잘 자요","jal jayo","audio_jaljayo");
        database[1][15] = new Phrase(context,1,15,"Just a moment!","잠깐만요!","jamkkanmanyo!","audio_jamkkanmanyo");
        database[1][16] = new Phrase(context,1,16,"Excuse me (to pass someone)","잠시만요","jamsimanyo","audio_jamsimanyo");
        database[1][17] = new Phrase(context,1,17,"Excuse me (to get attention)","저기요","jeogiyo","audio_jeogiyo");
        database[1][18] = new Phrase(context,1,18,"Have a nice day","좋은 하루 보내세요","joeun haru bonaeseyo","audio_joeun_haru_bonaeseyo");
        database[1][19] = new Phrase(context,1,19,"Sweet dreams","좋은 꿈 꿔요","joeun kkum kkwoyo","audio_joeun_kkum_kkwoyo");
        database[1][20] = new Phrase(context,1,20,"Sorry","미안합니다","mianhamnida","audio_mianhamnida");
        database[1][21] = new Phrase(context,1,21,"Yes","네","ne","audio_ne");
        database[1][22] = new Phrase(context,1,22,"Excuse me (to apologize)","실례합니다","sillyehamnida","audio_sillyehamnida");
        database[1][23] = new Phrase(context,1,23,"I need a doctor","의사가 필요해요","uisaga piryohaeyo","audio_uisaga_piryohaeyo");
        database[1][24] = new Phrase(context,1,24,"Hello (on phone)","여보세요","yeoboseyo","audio_yeoboseyo");
        database[1][25] = new Phrase(context,1,25,"Have a good trip!","여행 잘하세요","yeohaeng jalhaseyo","audio_yeohaeng_jalhaseyo");
        database[2][0] = new Phrase(context,2,0,"Where can I charge my bus card?","버스 카드 어디에서 충전할 수 있어요?","beoseu kadeu eodieseo chungjeonhal su isseoyo?","audio_beoseu_kadeu_eodieseo_chungjeonhal_su_isseoyo");
        database[2][1] = new Phrase(context,2,1,"Please open the bus door","버스 문 열어 주세요","beoseu mun yeoreo juseyo","audio_beoseu_mun_yeoreo_juseyo");
        database[2][2] = new Phrase(context,2,2,"How much is the bus fare?","버스 요금 얼마예요?","beoseu yogeum eolmayeyo?","audio_beoseu_yogeum_eolmayeyo");
        database[2][3] = new Phrase(context,2,3,"One ticket to Gangneung, please","강릉에 가는 표 한 장 주세요","gangneunge ganeun pyo han jang juseyo","audio_gangneunge_ganeun_pyo_han_jang_juseyo");
        database[2][4] = new Phrase(context,2,4,"Where does this bus go?","이 버스는 어디로 가요?","i beoseuneun eodiro gayo?","audio_i_beoseuneun_eodiro_gayo");
        database[2][5] = new Phrase(context,2,5,"Does this bus stop in Incheon International Airport?","이 버스는 인천국제공항에 서요?","i beoseuneun incheongukjegonghange seoyo?","audio_i_beoseuneun_incheongukjegonghange_seoyo");
        database[2][6] = new Phrase(context,2,6,"When will this bus arrive in the Namsan Tower?","이 버스는 남산타워에 언제 도착해요?","i beoseuneun namsantawoe eonje dochakaeyo?","audio_i_beoseuneun_namsantawoe_eonje_dochakaeyo");
        database[2][7] = new Phrase(context,2,7,"Where is the bus to Jinju?","진주에 가는 버스는 어디에 있어요?","jinjue ganeun beoseuneun eodie isseoyo?","audio_jinjue_ganeun_beoseuneun_eodie_isseoyo");
        database[2][8] = new Phrase(context,2,8,"What time is the last bus?","마지막 버스 언제예요?","majimak beoseu eonjeyeyo?","audio_majimak_beoseu_eonjeyeyo");
        database[2][9] = new Phrase(context,2,9,"How much is a bus ticket to Seoul?","서울에 가는 버스 표가 얼마예요?","seoure ganeun beoseu pyoga eolmayeyo?","audio_seoure_ganeun_beoseu_pyoga_eolmayeyo");
        database[2][10] = new Phrase(context,2,10,"Are there tickets available for the 3pm bus to Geo Je Island?","3시에 거제도 가는 버스 자리 있어요?","sesie geojedo ganeun beoseu jari isseoyo?","audio_sesie_geojedo_ganeun_beoseu_jari_isseoyo");
        database[2][11] = new Phrase(context,2,11,"When does the bus for Sokcho leave?","속초에 가는 버스는 언제 출발해요?","sokchoe ganeun beoseuneun eonje chulbalhaeyo?","audio_sokchoe_ganeun_beoseuneun_eonje_chulbalhaeyo");
        database[2][12] = new Phrase(context,2,12,"Please stop the bus here","여기서 세워 주세요","yeogiseo sewo juseyo","audio_yeogiseo_sewo_juseyo");
        database[2][13] = new Phrase(context,2,13,"When does bus number 605 arrive?","605번 버스는 언제 도착해요?","yukbaegobeon beoseuneun eonje dochakaeyo?","audio_yukbaegobeon_beoseuneun_eonje_dochakaeyo");
        database[3][0] = new Phrase(context,3,0,"Please give me 2 ice coffees","아이스 아메리카노 두잔 주세요","aiseu amerikano dujan juseyo","audio_aiseu_amerikano_dujan_juseyo");
        database[3][1] = new Phrase(context,3,1,"What is the wifi password?","비밀 번호 알려 주세요","bimil beonho allyeo juseyo","audio_bimil_beonho_allyeo_juseyo");
        database[3][2] = new Phrase(context,3,2,"Do you have non-caffeinated drinks?","카페인 없는 음료 있어요?","kapein eomneun eumnyo isseoyo?","audio_kapein_eomneun_eumnyo_isseoyo");
        database[3][3] = new Phrase(context,3,3,"Where are your electrical outlets?","콘센트 어디에 있어요?","konsenteu eodie isseoyo?","audio_konsenteu_isseoyo");
        database[3][4] = new Phrase(context,3,4,"Do you have electrical outlets?","콘센트 있어요?","konsenteu isseoyo?","audio_konsenteu_eodie_isseoyo");
        database[3][5] = new Phrase(context,3,5,"I’d like this to go (food and drink)","포장해 주세요","pojanghae juseyo","audio_pojanghae_juseyo");
        database[3][6] = new Phrase(context,3,6,"I’d like this to go (drink only)","테이크 아웃이에요","teikeu ausieyo","audio_teikeu_ausieyo");
        database[3][7] = new Phrase(context,3,7,"Please give me 1 hot coffee","따뜻한 아메리카노 한잔 주세요","ttatteutan amerikano hanjan juseyo","audio_ttatteutan_amerikano_hanjan_juseyo");
        database[3][8] = new Phrase(context,3,8,"Do you have wifi here?","와이파이 있어요?","waipai isseoyo?","audio_waipai_isseoyo");
        database[3][9] = new Phrase(context,3,9,"I’d like to eat here","여기서 먹고 갈게요","yeogiseo meokgo galgeyo","audio_yeogiseo_meokgo_galgeyo");
        database[3][10] = new Phrase(context,3,10,"Please throw away my receipt","영수증은 버려 주세요","yeongsujeungeun beoryeo juseyo","audio_yeongsujeungeun_beoryeo_juseyo");
        database[4][0] = new Phrase(context,4,0,"Bad","안 좋아요","an joayo","audio_an_joayo");
        database[4][1] = new Phrase(context,4,1,"I know","알아요","arayo","audio_arayo");
        database[4][2] = new Phrase(context,4,2,"Please speak slowly","천천히 말해 주세요","cheoncheonhi malhae juseyo","audio_cheoncheonhi_malhae_juseyo");
        database[4][3] = new Phrase(context,4,3,"Please repeat that","다시 말해 주세요","dasi malhae juseyo","audio_dasi_malhae_juseyo");
        database[4][4] = new Phrase(context,4,4,"Don’t worry!","걱정 하지 마세요!","geokjeong haji maseyo!","audio_geokjeong_haji_maseyo");
        database[4][5] = new Phrase(context,4,5,"So-so","그저 그래요","geujeo geuraeyo","audio_geujeo_geuraeyo");
        database[4][6] = new Phrase(context,4,6,"I’ll be right back!","금방 갔다 올거예요!","geumbang gatda olgeoyeyo!","audio_geumbang_gatda_olgeoyeyo");
        database[4][7] = new Phrase(context,4,7,"Can you speak Korean?","한국말을 할 수 있어요?","hangungmareul hal su isseoyo?","audio_hangungmareul_hal_su_isseoyo");
        database[4][8] = new Phrase(context,4,8,"I can speak a little Korean","한국말을 조금 할 수 있어요","hangungmareul jogeum hal su isseoyo","audio_hangungmareul_jogeum_hal_su_isseoyo");
        database[4][9] = new Phrase(context,4,9,"I can’t speak Korean","한국말을 못해요","hangungmareul motaeyo","audio_hangungmareul_motaeyo");
        database[4][10] = new Phrase(context,4,10,"Where is the bathroom?","화장실은 어디에 있어요?","hwajangsireun eodie isseoyo?","audio_hwajangsireun_eodie_isseoyo");
        database[4][11] = new Phrase(context,4,11,"What is this?","이게 뭐예요","ige mwoyeyo","audio_ige_mwoyeyo");
        database[4][12] = new Phrase(context,4,12,"How much is this?","이거 얼마예요?","igeo eolmayeyo?","audio_igeo_eolmayeyo");
        database[4][13] = new Phrase(context,4,13,"I don’t understand","이해 못해요","ihae mothaeyo","audio_ihae_mothaeyo");
        database[4][14] = new Phrase(context,4,14,"I understand","이해해요","ihaehaeyo","audio_ihaehaeyo");
        database[4][15] = new Phrase(context,4,15,"Please write it down","적어 주세요","jeogeo juseyo","audio_jeogeo_juseyo");
        database[4][16] = new Phrase(context,4,16,"Good","좋아요","joayo","audio_joayo");
        database[4][17] = new Phrase(context,4,17,"I don’t know","몰라요","mollayo","audio_mollayo");
        database[4][18] = new Phrase(context,4,18,"No problem!","문제 없어요","munje eopseoyo","audio_munje_eopseoyo");
        database[4][19] = new Phrase(context,4,19,"How do you say tiger in Korean?","타이거가 한국말로 뭐예요?","taigeoga hangungmallo mwoyeyo?","audio_taigeoga_hangungmallo_mwoyeyo");
        database[5][0] = new Phrase(context,5,0,"When shall we meet again?","언제 다시 볼까요?","eonje dasi bolkkayo?","audio_eonje_dasi_bolkkayo");
        database[5][1] = new Phrase(context,5,1,"Shall we get dinner together sometime?","언제 우리 같이 저녁 먹을까요?","eonje uri gachi jeonyeok meogeulkkayo?","audio_eonje_uri_gachi_jeonyeok_meogeulkkayo");
        database[5][2] = new Phrase(context,5,2,"What is your phone number?","핸드폰 번호가 뭐예요?","haendeupon beonhoga mwoyeyo?","audio_haendeupon_beonhoga_mwoyeyo");
        database[5][3] = new Phrase(context,5,3,"You are handsome!","잘 생겼어요!","jal saenggyeosseoyo!","audio_jal_saenggyeosseoyo");
        database[5][4] = new Phrase(context,5,4,"That was a great evening","즐거운 저녁이었어요","jeulgeoun jeonyeogieosseoyo","audio_jeulgeoun_jeonyeogieosseoyo");
        database[5][5] = new Phrase(context,5,5,"Do you have time this weekend?","주말에 시간 있어요?","jumare sigan isseoyo?","audio_jumare_sigan_isseoyo");
        database[5][6] = new Phrase(context,5,6,"You are charming!","매력적이에요!","maeryeokjeogieyo!","audio_maeryeokjeogieyo");
        database[5][7] = new Phrase(context,5,7,"Are you available break time?","쉬는 시간 시간 있어요?","swineun sigane sigan isseoyo?","audio_swineun_sigane_sigan_isseoyo");
        database[5][8] = new Phrase(context,5,8,"Shall we go on a date together?","우리 데이트 할까요?","uri deiteu halkkayo?","audio_uri_deiteu_halkkayo");
        database[5][9] = new Phrase(context,5,9,"Let’s talk on KakaoTalk","우리 카카오톡 해요","uri kakaotok haeyo","audio_uri_kakaotok_haeyo");
        database[5][10] = new Phrase(context,5,10,"Will you be my boyfriend/girlfriend?","우리 사귈래요?","uri sagwillaeyo?","audio_uri_sagwillaeyo");
        database[5][11] = new Phrase(context,5,11,"I’m busy on Monday","월요일에 바빠요","woryoire bappayo","audio_woryoire_bappayo");
        database[5][12] = new Phrase(context,5,12,"You are pretty!","예뻐요!","yeppeoyo!","audio_yeppeoyo");
        database[6][0] = new Phrase(context,6,0,"My lower tooth is senstive","아랫니가 시려요","araenniga siryeoyo","audio_araenniga_siryeoyo");
        database[6][1] = new Phrase(context,6,1,"I don’t have dental insurance","치과 보험 없어요","chigwa boheom eopseoyo","audio_chigwa_boheom_eopseoyo");
        database[6][2] = new Phrase(context,6,2,"I have dental insurance","치과 보험 있어요","chigwa boheom isseoyo","audio_chigwa_boheom_isseoyo");
        database[6][3] = new Phrase(context,6,3,"I'm here for a dental checkup","치과 검진 하러 왔어요","chigwa geomjin hareo wasseoyo","audio_chigwa_geomjin_hareo_wasseoyo");
        database[6][4] = new Phrase(context,6,4,"I think I have a cavity","충치가 생긴 것 같아요","chungchiga saengin geot gatayo","audio_chungchiga_saengin_geot_gatayo");
        database[6][5] = new Phrase(context,6,5,"How long do I have to wait?","얼마나 기다려야해요?","eolmana gidaryeoyahaeyo?","audio_eolmana_gidaryeoyahaeyo");
        database[6][6] = new Phrase(context,6,6,"My gums hurt","잇몸이 아파요","inmomi apayo","audio_inmomi_apayo");
        database[6][7] = new Phrase(context,6,7,"Can I pay with a credit card?","카드 돼요?","kadeu dwaeyo?","audio_kadeu_dwaeyo");
        database[6][8] = new Phrase(context,6,8,"My last checkup was 1 year ago","마지막 치과 검진한지 1년 됐어요","majimak chigwa geomjinhanji ilnyeon dwaesseoyo","audio_majimak_chigwa_geomjinhanji_ilnyeon_dwaesseoyo");
        database[6][9] = new Phrase(context,6,9,"My last cleaning was 6 months ago","마지막 스케일링한지 6개월 됐어요","majimak seukeillinghanji yukgaewol dwaesseoyo","audio_majimak_seukeillinghanji_yukgaewol_dwaesseoyo");
        database[6][10] = new Phrase(context,6,10,"I am here for a cleaning","스케일링 하러 왔어요","seukeilling hareo wasseoyo","audio_seukeilling_hareo_wasseoyo");
        database[6][11] = new Phrase(context,6,11,"My upper tooth hurts","윗니가 아파요","winniga apayo","audio_winniga_apayo");
        database[6][12] = new Phrase(context,6,12,"I’m here to make an appointment","예약하려고 왔는데요","yeyakaryeogo wanneundeyo","audio_yeyakaryeogo_wanneundeyo");
        database[7][0] = new Phrase(context,7,0,"I’m hungry","배고파요","baegopayo","audio_baegopayo");
        database[7][1] = new Phrase(context,7,1,"I can eat anything","다 먹을 수 있어요","da meogeul su isseoyo","audio_da_meogeul_su_isseoyo");
        database[7][2] = new Phrase(context,7,2,"I ate well","잘 먹었습니다","jal meogeotseumnida","audio_jal_meogeotseumnida");
        database[7][3] = new Phrase(context,7,3,"I will eat well!","잘 먹겠습니다","jal meokgetseumnida","audio_jal_meokgetseumnida");
        database[7][4] = new Phrase(context,7,4,"I’m a vegetarian","저는 채식주의자예요","jeoneun chaesikjuuijayeyo","audio_jeoneun_chaesikjuuijayeyo");
        database[7][5] = new Phrase(context,7,5,"I don’t eat meat","저는 고기를 못 먹어요","jeoneun gogireul mot meogeoyo","audio_jeoneun_gogireul_mot_meogeoyo");
        database[7][6] = new Phrase(context,7,6,"Give me coffee please","커피 주세요","keopi juseyo","audio_keopi_juseyo");
        database[7][7] = new Phrase(context,7,7,"Eat up!","많이 먹어요","mani meogeoyo","audio_mani_meogeoyo");
        database[7][8] = new Phrase(context,7,8,"It’s delicious!","맛있어요!","masisseoyo!","audio_masisseoyo");
        database[7][9] = new Phrase(context,7,9,"Bon appétit","맛있게 드세요","masitge deuseyo","audio_masitge_deuseyo");
        database[7][10] = new Phrase(context,7,10,"I’m thirsty","목 말라요","mok mallayo","audio_mok_mallayo");
        database[8][0] = new Phrase(context,8,0,"Do you know where Apgujeong station is?","압구정역 어디인지 아세요?","apgujeongyeok eodiinji aseyo?","audio_apgujeongyeok_eodiinji_aseyo");
        database[8][1] = new Phrase(context,8,1,"It’s close","가까워요","gakkawoyo","audio_gakkawoyo");
        database[8][2] = new Phrase(context,8,2,"It’s not within walking distance","걸어갈 만한 거리가 아니예요","georeogal manhan georiga aniyeyo","audio_georeogal_manhan_georiga_aniyeyo");
        database[8][3] = new Phrase(context,8,3,"It’s that way","그 쪽으로 가세요","geu jjogeuro gaseyo","audio_geu_jjogeuro_gaseyo");
        database[8][4] = new Phrase(context,8,4,"I’m lost","길을 잃어버렸어요","gireul ireobeoryeosseoyo","audio_gireul_ireobeoryeosseoyo");
        database[8][5] = new Phrase(context,8,5,"Excuse me (asking for help)","저기요","jeogiyo","audio_jeogiyo");
        database[8][6] = new Phrase(context,8,6,"Can you show me on the map?","지도로 보여 주시겠어요?","jidoro boyeo jusigesseoyo?","audio_jidoro_boyeo_jusigesseoyo");
        database[8][7] = new Phrase(context,8,7,"Go straight","쭉 가세요","jjuk gaseyo","audio_jjuk_gaseyo");
        database[8][8] = new Phrase(context,8,8,"It’s quite far","꽤 멀어요","kkwae meoreoyo","audio_kkwae_meoreoyo");
        database[8][9] = new Phrase(context,8,9,"It’s not far","멀지 않아요","meolji anayo","audio_meolji_anayo");
        database[8][10] = new Phrase(context,8,10,"I’m sorry, I’m not from around here","미안하지만 저는 이 근처 사람이 아니예요","mianhajiman jeoneun i geuncheo sarami aniyeyo","audio_mianhajiman_jeoneun_i_geuncheo_sarami_aniyeyo");
        database[8][11] = new Phrase(context,8,11,"Go left","왼쪽 가세요","oenjjok gaseyo","audio_oenjjok_gaseyo");
        database[8][12] = new Phrase(context,8,12,"Go right","오른쪽에 가세요","oreunjjoge gaseyo","audio_oreunjjoge_gaseyo");
        database[8][13] = new Phrase(context,8,13,"Excuse me (asking for help politely)","실례합니다","sillyehamnida","audio_sillyehamnida");
        database[8][14] = new Phrase(context,8,14,"How far is it from here?","여기에서 얼마나 걸리는지 아세요?","yeogieseo eolmana geollineunji aseyo?","audio_yeogieseo_eolmana_geollineunji_aseyo");
        database[8][15] = new Phrase(context,8,15,"It’s about 1 kilometer from here","여기에서 1킬로정도 멀어요","yeogieseo ilkillojeongdo meoreoyo","audio_yeogieseo_ilkillojeongdo_meoreoyo");
        database[8][16] = new Phrase(context,8,16,"Is it far from here?","여기에서 멀어요?","yeogieseo meoreoyo?","audio_yeogieseo_meoreoyo");
        database[9][0] = new Phrase(context,9,0,"Please sew on this button","단추 달아주세요","danchu darajuseyo","audio_danchu_darajuseyo");
        database[9][1] = new Phrase(context,9,1,"Please iron this for me","다림질 해 주세요","darimjil hae juseyo","audio_darimjil_hae_juseyo");
        database[9][2] = new Phrase(context,9,2,"Please dry clean this for me","드라이 해 주세요","deurai hae juseyo","audio_deurai_hae_juseyo");
        database[9][3] = new Phrase(context,9,3,"Can you remove this stain?","얼룩 뺄 수 있어요?","eolluk ppael su isseoyo?","audio_eolluk_ppael_su_isseoyo");
        database[9][4] = new Phrase(context,9,4,"How much is it?","얼마예요?","eolmayeyo?","audio_eolmayeyo");
        database[9][5] = new Phrase(context,9,5,"Please make this shorter","기장을 줄여 주세요.","gijangeul juryeo juseyo","audio_gijangeul_juryeo_juseyo");
        database[9][6] = new Phrase(context,9,6,"Please make this longer","기장을 늘려 주세요.","gijangeul neullyeo juseyo","audio_gijangeul_neullyeo_juseyo");
        database[9][7] = new Phrase(context,9,7,"I’m here to pick up my clothes","제 옷을 찾으러 왔어요","je oseul chajeureo wasseoyo","audio_je_oseul_chajeureo_wasseoyo");
        database[9][8] = new Phrase(context,9,8,"How much is the total?","모두 얼마예요?","modu eolmayeyo?","audio_modu_eolmayeyo");
        database[9][9] = new Phrase(context,9,9,"When can I pick up my clothes?","옷을 언제 받을 수 있어요?","oseul eonje badeul su isseoyo?","audio_oseul_eonje_badeul_su_isseoyo");
        database[10][0] = new Phrase(context,10,0,"This is an emergency","아주 급해요","aju geupaeyo","audio_aju_geupaeyo");
        database[10][1] = new Phrase(context,10,1,"Please take me to the hospital","병원에 데려가 주세요","byeongwone deryeoga juseyo","audio_byeongwone_deryeoga_juseyo");
        database[10][2] = new Phrase(context,10,2,"Please help me","도와주세요","dowajuseyo","audio_dowajuseyo");
        database[10][3] = new Phrase(context,10,3,"Where can I get help?","어디에서 도움을 구할 수 있어요?","eodieseo doumeul guhal su isseoyo?","audio_eodieseo_doumeul_guhal_su_isseoyo");
        database[10][4] = new Phrase(context,10,4,"Where is the closest hospital?","가장 가까운 병원이 어디예요?","gajang gakkaun byeongwoni eodiyeyo","audio_gajang_gakkaun_byeongwoni_eodiyeyo");
        database[10][5] = new Phrase(context,10,5,"Please call an ambulance","구급차를 불러 주세요","gugeupchareul bulleo juseyo","audio_gugeupchareul_bulleo_juseyo");
        database[10][6] = new Phrase(context,10,6,"Where is the nearest police station?","제일 가까운 경찰서가 어디예요?","jeil gakkaun gyeongchalseoga eodiyeyo","audio_jeil_gakkaun_gyeongchalseoga_eodiyeyo");
        database[10][7] = new Phrase(context,10,7,"I am a diabetic","저는 당뇨가 있어요","jeoneun dangnyoga isseoyo","audio_jeoneun_dangnyoga_isseoyo");
        database[10][8] = new Phrase(context,10,8,"Please call the US Embassy immediately","즉시 미국 대사관으로 전화해 주세요","jeuksi miguk daesagwaneuro jeonhwahae juseyo","audio_jeuksi_miguk_daesagwaneuro_jeonhwahae_juseyo");
        database[10][9] = new Phrase(context,10,9,"I am allergic to cucumber","오이에 알레르기가 있어요","oie allereugiga isseoyo","audio_oie_allereugiga_isseoyo");
        database[11][0] = new Phrase(context,11,0,"Oh my goodness!","아이고!","aigo!","audio_aigo");
        database[11][1] = new Phrase(context,11,1,"Yay! or Hurray!","아싸!","assa!","audio_assa");
        database[11][2] = new Phrase(context,11,2,"Ouch!","아야!","aya!","audio_aya");
        database[11][3] = new Phrase(context,11,3,"Amazing! or Unbelievable!","대박!","daebak!","audio_daebak");
        database[11][4] = new Phrase(context,11,4,"What?! or Oh my god!","헐!","heol!","audio_heol");
        database[11][5] = new Phrase(context,11,5,"Really?!","진짜요?","jinjjayo?","audio_jinjjayo");
        database[11][6] = new Phrase(context,11,6,"Unbelievable! or Impossible!","말도 안돼요!","maldo andwaeyo!","audio_maldo_andwaeyo");
        database[12][0] = new Phrase(context,12,0,"Please just trim my bangs","앞머리만 다듬어 주세요","ammeoriman dadeumeo juseyo","audio_ammeoriman_dadeumeo_juseyo");
        database[12][1] = new Phrase(context,12,1,"Leave the back long","뒷머리는 길게 남겨 두세요","dwinmeorineun gilge namgyeo duseyo","audio_dwinmeorineun_gilge_namgyeo_duseyo");
        database[12][2] = new Phrase(context,12,2,"Make it about this long","이 정도로 길게 해 주세요","i jeongdoro gilge hae juseyo","audio_i_jeongdoro_gilge_hae_juseyo");
        database[12][3] = new Phrase(context,12,3,"Dye my hair this color please","이 색깔로 염색 해 주세요","i saekkkallo yeomsaek hae juseyo","audio_i_saekkkallo_yeomsaek_hae_juseyo");
        database[12][4] = new Phrase(context,12,4,"Please just trim my hair","좀 다듬어 주세요","jom dadeumeo juseyo","audio_jom_dadeumeo_juseyo");
        database[12][5] = new Phrase(context,12,5,"Please give me a haircut","커트 해주세요","keoteu haejuseyo","audio_keoteu_haejuseyo");
        database[12][6] = new Phrase(context,12,6,"How much does a haircut cost?","머리 커트 얼마예요?","meori keoteu eolmayeyo?","audio_meori_keoteu_eolmayeyo");
        database[12][7] = new Phrase(context,12,7,"I’d like to make an appointment tomorrow at 2pm","내일 오후 2시로 예약을 하고싶은데요","naeil ohu dusiro yeyageul hagosipeundeyo","audio_naeil_ohu_dusiro_yeyageul_hagosipeundeyo");
        database[12][8] = new Phrase(context,12,8,"Please don’t cut it too short","너무 짧게 자르지 마세요","neomu jjalge jareuji maseyo","audio_neomu_jjalge_jareuji_maseyo");
        database[12][9] = new Phrase(context,12,9,"Please perm my hair","파마 해주세요","pama haejuseyo","audio_pama_haejuseyo");
        database[12][10] = new Phrase(context,12,10,"Dye only my roots please","뿌리 염색 해 주세요 (뿌염 해주세요)","ppuri yeomsaek hae juseyo (ppuyeom haejuseyo)","audio_ppuri_yeomsaek_hae_juseyo");
        database[12][11] = new Phrase(context,12,11,"I’d like my hair like this person in the picture","사진에 있는 사람처럼 머리를 잘라 주세요","sajine inneun saramcheoreom meorireul jalla juseyo","audio_sajine_inneun_saramcheoreom_meorireul_jalla_juseyo");
        database[12][12] = new Phrase(context,12,12,"How long will it take?","시간 얼마나 걸려요?","sigan eolmana geollyeoyo?","audio_sigan_eolmana_geollyeoyo");
        database[12][13] = new Phrase(context,12,13,"Please trim the sides and even out the top","위에는 그냥 두고 옆에만 다듬어주세요","wieneun geunyang dugo yeopeman dadeumeojuseyo","audio_wieneun_geunyang_dugo_yeopeman_dadeumeojuseyo");
        database[12][14] = new Phrase(context,12,14,"Please cut it a little shorter here","여기 조금 더 잘라 주세요","yeogi jogeum deo jalla juseyo","audio_yeogi_jogeum_deo_jalla_juseyo");
        database[12][15] = new Phrase(context,12,15,"Please dye my hair","염색 해주세요","yeomsaek haejuseyo","audio_yeomsaek_haejuseyo");
        database[13][0] = new Phrase(context,13,0,"I don’t have any allergies","알레르기가 없어요","allereugiga eopseoyo","audio_allereugiga_eopseoyo");
        database[13][1] = new Phrase(context,13,1,"I have a stomachache","배가 아파요","baega apayo","audio_baega_apayo");
        database[13][2] = new Phrase(context,13,2,"I have an upset stomach","체했어요","chehaesseoyo","audio_chehaesseoyo");
        database[13][3] = new Phrase(context,13,3,"I have a prescription to fill","처방전을 받아 왔어요","cheobangjeoneul bada wasseoyo","audio_cheobangjeoneul_bada_wasseoyo");
        database[13][4] = new Phrase(context,13,4,"Where can I get this prescription filled?","어디에서 약을 받을 수 있어요?","eodieseo yageul badeul su isseoyo?","audio_eodieseo_yageul_badeul_su_isseoyo");
        database[13][5] = new Phrase(context,13,5,"I have health insurance","건강 보험 있어요","geongang boheom isseoyo","audio_geongang_boheom_isseoyo");
        database[13][6] = new Phrase(context,13,6,"My nose is runny","자꾸 콧물이 나요","jakku konmuri nayo","audio_jakku_konmuri_nayo");
        database[13][7] = new Phrase(context,13,7,"I need to see a doctor","진찰을 받고 싶어요","jinchareul batgo sipeoyo","audio_jinchareul_batgo_sipeoyo");
        database[13][8] = new Phrase(context,13,8,"My nose is stuffy","코가 막혔어요","koga makyeosseoyo","audio_koga_makyeosseoyo");
        database[13][9] = new Phrase(context,13,9,"I have a headache","머리가 아파요","meoriga apayo","audio_meoriga_apayo");
        database[13][10] = new Phrase(context,13,10,"I have a sore throat","목이 아파요","mogi apayo","audio_mogi_apayo");
        database[13][11] = new Phrase(context,13,11,"My body aches all over","몸살 났어요","momsal nasseoyo","audio_momsal_nasseoyo");
        database[13][12] = new Phrase(context,13,12,"I am allergic to cucumber","오이에 알레르기가 있어요","oie allereugiga isseoyo","audio_oie_allereugiga_isseoyo");
        database[13][13] = new Phrase(context,13,13,"I have diarrhea","설사를 해요","seolsareul haeyo","audio_seolsareul_haeyo");
        database[14][0] = new Phrase(context,14,0,"I don’t have a reservation","아직 예약을 하지 않았어요","ajik yeyageul haji anasseoyo","audio_ajik_yeyageul_haji_anasseoyo");
        database[14][1] = new Phrase(context,14,1,"May I see the room first?","방을 먼저 봐도 돼요?","bangeul meonjeo bwado dwaeyo?","audio_bangeul_meonjeo_bwado_dwaeyo");
        database[14][2] = new Phrase(context,14,2,"Do you have any rooms available?","빈방 있어요?","binbang isseoyo?","audio_binbang_isseoyo");
        database[14][3] = new Phrase(context,14,3,"How much is a room for one night?","하루에 방이 얼마예요?","harue bangi eolmayeyo?","audio_harue_bangi_eolmayeyo");
        database[14][4] = new Phrase(context,14,4,"Can you wake me at 7 o'clock?","7시에 깨워주시겠어요?","ilgopsie kkaewojusigesseoyo?","audio_ilgopsie_kkaewojusigesseoyo");
        database[14][5] = new Phrase(context,14,5,"I want to check out now","지금 체크 아웃하고 싶어요","jigeum chekeu authago sipeoyo","audio_jigeum_chekeu_authago_sipeoyo");
        database[14][6] = new Phrase(context,14,6,"How long would you like to stay?","몇 박을 하실 겁니까?","myeot bageul hasil geomnikka?","audio_myeot_bageul_hasil_geomnikka");
        database[14][7] = new Phrase(context,14,7,"I have a reservation","네, 예약했어요","ne, yeyakhaesseoyo","audio_ne_yeyakhaesseoyo");
        database[14][8] = new Phrase(context,14,8,"I will stay for four night(s)","4일 묵겠어요","sail mukgesseoyo","audio_sail_mukgesseoyo");
        database[14][9] = new Phrase(context,14,9,"May I have your name?","성함을 말씀해주세요","seonghameul malsseumhaejuseyo","audio_seonghameul_malsseumhaejuseyo");
        database[14][10] = new Phrase(context,14,10,"I would like to make a reservation","예약을 하고 싶어요","yeyageul hago sipeoyo","audio_yeyageul_hago_sipeoyo");
        database[14][11] = new Phrase(context,14,11,"Did you have a reservation?","예약은 하셨습니까?","yeyageun hasyeotseumnikka?","audio_yeyageun_hasyeotseumnikka");
        database[14][12] = new Phrase(context,14,12,"Is breakfast included with the room?","요금에 조식은 포함되어 있어요?","yogeume josigeun pohamdoeeo isseoyo?","audio_yogeume_josigeun_pohamdoeeo_isseoyo");
        database[15][0] = new Phrase(context,15,0,"Have you eaten? (showing concern)","밥 먹었어요?","bap meogeosseoyo?","audio_bap_meogeosseoyo");
        database[15][1] = new Phrase(context,15,1,"Where shall we go?","어디로 갈까요?","eodiro galkkayo?","audio_eodiro_galkkayo");
        database[15][2] = new Phrase(context,15,2,"What have you been up to?","어떻게 지냈어요?","eotteoke jinaesseoyo?","audio_eotteoke_jinaesseoyo");
        database[15][3] = new Phrase(context,15,3,"Say hi to brother for me","형한테 안부 전해 주세요","hyeonghante anbu jeonhae juseyo","audio_hyeonghante_anbu_jeonhae_juseyo");
        database[15][4] = new Phrase(context,15,4,"How have you been?","잘 지냈어요?","jal jinaesseoyo?","audio_jal_jinaesseoyo");
        database[15][5] = new Phrase(context,15,5,"How are you?","잘 지내요?","jal jinaeyo?","audio_jal_jinaeyo");
        database[15][6] = new Phrase(context,15,6,"Get home safely","집에 잘 들어가요","jibe jal deureogayo","audio_jibe_jal_deureogayo");
        database[15][7] = new Phrase(context,15,7,"Long time no see","오랜만이에요","oraenmanieyo","audio_oraenmanieyo");
        database[16][0] = new Phrase(context,16,0,"I’d like two tickets for Train to Busan the movie","부산행 영화는 2장 주세요","busanhaeng yeonghwaneun dujang juseyo","audio_busanhaeng_yeonghwaneun_dujang_juseyo");
        database[16][1] = new Phrase(context,16,1,"What time is Parasite the movie showing?","기생충 영화는 언제 상영해요?","gisaengchungyeonghwaneun eonje sangyeonghaeyo?","audio_gisaengchung_yeonghwaneun_eonje_sangyeonghaeyo");
        database[16][2] = new Phrase(context,16,2,"Do you give discounts to students?","학생 할인 돼요?","haksaeng harin dwaeyo?","audio_haksaeng_harin_dwaeyo");
        database[16][3] = new Phrase(context,16,3,"Are there any seats available for the 7:30pm showing?","7시반 상영 자리 있어요?","ilgopsiban sangyeong jari isseoyo?","audio_ilgopsiban_sangyeong_jari_isseoyo");
        database[16][4] = new Phrase(context,16,4,"Where is the concession stand?","매점은 어디 있어요?","maejeomeun eodi isseoyo?","audio_maejeomeun_eodi_isseoyo");
        database[16][5] = new Phrase(context,16,5,"When is the last move playing?","마지막 영화는 언제예요?","majimak yeonghwaneun eonjeyeyo?","audio_majimak_yeonghwaneun_eonjeyeyo");
        database[16][6] = new Phrase(context,16,6,"How much are the Sweetbox seats?","스위트박스 자리는 얼마예요?","seuwiteubakseu jarineun eolmayeyo?","audio_seuwiteubakseu_jarineun_eolmayeyo");
        database[16][7] = new Phrase(context,16,7,"Are there subtitles for this movie?","영화 자막 있어요?","yeonghwa jamak isseoyo?","audio_yeonghwa_jamak_isseoyo");
        database[16][8] = new Phrase(context,16,8,"How long is the movie?","영화 상영 시간이 얼마나 돼요?","yeonghwa sangyeong sigani eolmana dwaeyo?","audio_yeonghwa_sangyeong_sigani_eolmana_dwaeyo");
        database[16][9] = new Phrase(context,16,9,"Where is Theater 12","영화관12관 어디에 있어요?","yeonghwagwansibigwan eodie isseoyo","audio_yeonghwagwansibigwan_eodie_isseoyo");
        database[16][10] = new Phrase(context,16,10,"What is the genre of the movie?","영화는 무슨 장르에요?","yeonghwaneun museun jangneueyo?","audio_yeonghwaneun_museun_jangneueyo");
        database[17][0] = new Phrase(context,17,0,"I don’t have any allergies","알레르기가 없어요","allereugiga eopseoyo","audio_allereugiga_eopseoyo");
        database[17][1] = new Phrase(context,17,1,"I have a stomachache","배가 아파요","baega apayo","audio_baega_apayo");
        database[17][2] = new Phrase(context,17,2,"I have a prescription to fill","처방전을 받아 왔어요","cheobangjeoneul bada wasseoyo","audio_cheobangjeoneul_bada_wasseoyo");
        database[17][3] = new Phrase(context,17,3,"I have a cold","감기에 걸렸어요","gamgie geollyeosseoyo","audio_gamgie_geollyeosseoyo");
        database[17][4] = new Phrase(context,17,4,"Take one pill twice a day","하루에 두 번 한 알씩 드세요","harue du beon han alssik deuseyo","audio_harue_du_beon_han_alssik_deuseyo");
        database[17][5] = new Phrase(context,17,5,"Take one pill three times a day with meals","하루에 세 번 식사할 때마다 한 알씩 드세요","harue se beon siksahal ttaemada han alssik deuseyo","audio_harue_se_beon_siksahal_ttaemada_han_alssik_deuseyo");
        database[17][6] = new Phrase(context,17,6,"I have been sick for two days","이틀 동안 아팠어요","iteul dongan apasseoyo","audio_iteul_dongan_apasseoyo");
        database[17][7] = new Phrase(context,17,7,"I have a runny nose","자꾸 콧물이 나요","jakku konmuri nayo","audio_jakku_konmuri_nayo");
        database[17][8] = new Phrase(context,17,8,"I have a stuffy nose","코가 막혔어요","koga makyeosseoyo.","audio_koga_makyeosseoyo");
        database[17][9] = new Phrase(context,17,9,"I have a headache","머리가 아파요","meoriga apayo","audio_meoriga_apayo");
        database[17][10] = new Phrase(context,17,10,"I have a sore throat","목이 아파요","mogi apayo","audio_mogi_apayo");
        database[17][11] = new Phrase(context,17,11,"My body aches all over","몸살 났어요","momsal nasseoyo","audio_momsal_nasseoyo");
        database[17][12] = new Phrase(context,17,12,"I am allergic to cucumber","오이에 알레르기가 있어요","oie allereugiga isseoyo","audio_oie_allereugiga_isseoyo");
        database[17][13] = new Phrase(context,17,13,"Do you have Tylenol?","타이레놀 있어요?","tairenol isseoyo?","audio_tairenol_isseoyo");
        database[18][0] = new Phrase(context,18,0,"How long will it take to be delivered?","배송기간은 얼마나 걸려요?","baesonggiganeun eolmana geollyeoyo?","audio_baesonggiganeun_eolmana_geollyeoyo");
        database[18][1] = new Phrase(context,18,1,"Please send this package by registered mail","등기로 소포 보내주세요","deunggiro sopo bonaejuseyo","audio_deunggiro_sopo_bonaejuseyo");
        database[18][2] = new Phrase(context,18,2,"How much is it to send by air mail?","항공우편으로 얼마예요?","hanggongupyeoneuro eolmayeyo?","audio_hanggongupyeoneuro_eolmayeyo");
        database[18][3] = new Phrase(context,18,3,"What is the zip code for this address?","이 주소의 우편번호가 뭐예요?","i jusoui upyeonbeonhoga mwoyeyo?","audio_i_jusoui_upyeonbeonhoga_mwoyeyo");
        database[18][4] = new Phrase(context,18,4,"How much is the least expensive shipping option?","제일 싼 우편 방법 얼마예요?","jeil ssan upyeon bangbeop eolmayeyo?","audio_jeil_ssan_upyeon_bangbeop_eolmayeyo");
        database[18][5] = new Phrase(context,18,5,"Please send this envelope to Canada by regular mail","캐나다에 봉투우편으로 보내주세요","kaenadae bongtuupyeoneuro bonaejuseyo","audio_kaenadae_bongtuupyeoneuro_bonaejuseyo");
        database[18][6] = new Phrase(context,18,6,"Please give me some bubble wrap","뽁뽁이 좀 주세요","ppokppogi jom juseyo","audio_ppokppogi_jom_juseyo");
        database[18][7] = new Phrase(context,18,7,"Do you sell envelopes?","편지 봉투 팔아요?","pyeonji bongtu parayo?","audio_pyeonji_bongtu_parayo");
        database[18][8] = new Phrase(context,18,8,"Please give me one size 3 box","3호 박스 1개 주세요","samho bakseu hangae juseyo","audio_samho_bakseu_hangae_juseyo");
        database[18][9] = new Phrase(context,18,9,"Do I need a customs form?","세관 서류 필요해요?","segwan seoryu piryohaeyo?","audio_segwan_seoryu_piryohaeyo");
        database[18][10] = new Phrase(context,18,10,"Where can I buy stamps?","우표는 어디에서 살 수 있어요?","upyeoneun eodieseo sal su isseoyo?","audio_upyeoneun_eodieseo_sal_su_isseoyo");
        database[18][11] = new Phrase(context,18,11,"Please give me 3 stamps","우표 3장 주세요","upyo sejang juseyo","audio_upyo_sejang_juseyo");
        database[19][0] = new Phrase(context,19,0,"Do you have vegetarian dishes?","채식주의자용 식사 있어요?","chaesikjuuijayong siksa isseoyo?","audio_chaesikjuuijayong_siksa_isseoyo");
        database[19][1] = new Phrase(context,19,1,"Please give me 4 orders of galbi","갈비 사인분 주세요","galbi sainbun juseyo","audio_galbi_sainbun_juseyo");
        database[19][2] = new Phrase(context,19,2,"Is this spicy?","이거 매워요?","igeo maewoyo?","audio_igeo_maewoyo");
        database[19][3] = new Phrase(context,19,3,"It was a delicious meal!","잘 먹었습니다!","jal meogeotseumnida!","audio_jal_meogeotseumnida");
        database[19][4] = new Phrase(context,19,4,"Do you take credit cards?","카드 돼요?","kadeu dwaeyo?","audio_kadeu_dwaeyo");
        database[19][5] = new Phrase(context,19,5,"Please do not make this spicy","맵지 않게 요리해 주세요","maepji anke yorihae juseyo","audio_maepji_anke_yorihae_juseyo");
        database[19][6] = new Phrase(context,19,6,"It’s delicious!","맛있어요!","masisseoyo!","audio_masisseoyo");
        database[19][7] = new Phrase(context,19,7,"Please give me a menu","메뉴판 주세요","menyupan juseyo","audio_menyupan_juseyo");
        database[19][8] = new Phrase(context,19,8,"What time do you close?","몇시에 문 닫아요?","myeotsie mun dadayo?","audio_myeotsie_mun_dadayo");
        database[19][9] = new Phrase(context,19,9,"Do you have a table for 4 people?","네명 자리 있어요?","nemyeong jari isseoyo?","audio_nemyeong_jari_isseoyo");
        database[19][10] = new Phrase(context,19,10,"Please give me 1 bottle of soju","소주 한병 주세요","soju hanbyeong juseyo","audio_soju_hanbyeong_juseyo");
        database[19][11] = new Phrase(context,19,11,"Please give me 3 glasses","유리잔 세개 주세요","yurijan segae juseyo","audio_yurijan_segae_juseyo");
        database[20][0] = new Phrase(context,20,0,"Put it in a bag","봉투에 넣어 주세요","bongtue neoeo juseyo","audio_bongtue_neoeo_juseyo");
        database[20][1] = new Phrase(context,20,1,"How much is it?","얼마예요?","eolmayeyo?","audio_eolmayeyo");
        database[20][2] = new Phrase(context,20,2,"Please exchange this","교환해 주세요","gyohwanhae juseyo","audio_gyohwanhae_juseyo");
        database[20][3] = new Phrase(context,20,3,"Please give me a refund","환불해 주세요","hwanbulhae juseyo","audio_hwanbulhae_juseyo");
        database[20][4] = new Phrase(context,20,4,"One-time payment","일시불","ilsibul","audio_ilsibul");
        database[20][5] = new Phrase(context,20,5,"Do you have wallet?","지갑 있어요?","jigap isseoyo?","audio_jigap_isseoyo");
        database[20][6] = new Phrase(context,20,6,"Please give me a discount","좀 깎아 주세요","jom kkakka juseyo","audio_jom_kkakka_juseyo");
        database[20][7] = new Phrase(context,20,7,"Can I pay with credit card?","카드 돼요?","kadeu dwaeyo?","audio_kadeu_dwaeyo");
        database[20][8] = new Phrase(context,20,8,"Please give me coffee","커피 주세요","keopi juseyo","audio_keopi_juseyo");
        database[20][9] = new Phrase(context,20,9,"Please wrap it for me","포장해 주세요","pojanghae juseyo","audio_pojanghae_juseyo");
        database[20][10] = new Phrase(context,20,10,"3 month installments","3개월 할부","samgaewol halbu","audio_samgaewol_halbu");
        database[20][11] = new Phrase(context,20,11,"Please give me a receipt","영수증 주세요","yeongsujeung juseyo","audio_yeongsujeung_juseyo");
        database[20][12] = new Phrase(context,20,12,"Throw away the receipt","영수증은 버려 주세요","yeongsujeungeun beoryeo juseyo","audio_yeongsujeungeun_beoryeo_juseyo");
        database[21][0] = new Phrase(context,21,0,"Goodbye (to the person leaving)","안녕히 가세요","annyeonghi gaseyo","audio_annyeonghigaseyo");
        database[21][1] = new Phrase(context,21,1,"Please go left at Apartment","아파트에서 좌회전해 주세요","apateueseo jwahoejeonhae juseyo","audio_apateueseo_jwahoejeonhae_juseyo");
        database[21][2] = new Phrase(context,21,2,"Please stop after aBus stop","버스정류장 지나서 세워 주세요","beoseujeongnyujang jinaseo sewo juseyo","audio_beoseujeongnyujang_jinaseo_sewo_juseyo");
        database[21][3] = new Phrase(context,21,3,"Please go right at Hospital","병원에서 우회전해 주세요","byeongwoneseo uhoejeonhae juseyo","audio_byeongwoneseo_uhoejeonhae_juseyo");
        database[21][4] = new Phrase(context,21,4,"Where shall I go?","어디로 갈까요?","eodiro galkkayo?","audio_eodiro_galkkayo");
        database[21][5] = new Phrase(context,21,5,"Please stop before Gang-nam station","강남역전에 세워 주세요","gangnamyeok jeone sewo juseyo","audio_gangnamyeok_jeone_sewo_juseyo");
        database[21][6] = new Phrase(context,21,6,"Taxi driver","기사님","gisanim","audio_gisanim");
        database[21][7] = new Phrase(context,21,7,"I will give you the address","주소를 알려 드릴게요","jusoreul allyeo deurilgeyo","audio_jusoreul_allyeo_deurilgeyo");
        database[21][8] = new Phrase(context,21,8,"Please make a u-turn at Cafe","카페에서 유턴해 주세요","kapeeseo yuteonhae juseyo","audio_kapeeseo_yuteonhae_juseyo");
        database[21][9] = new Phrase(context,21,9,"Please go straight at Crossroads","사거리에서 직진해 주세요","sageorieseo jikjinhae juseyo","audio_sageorieseo_jikjinhae_juseyo");
        database[21][10] = new Phrase(context,21,10,"Please stop at Seoul station","서울역에서 세워 주세요","seoullyeogeseo sewo juseyo","audio_seouryeogeseo_sewo_juseyo");
        database[21][11] = new Phrase(context,21,11,"Please take me to Sinsa-dong","신사동으로 가주세요","sinsadongeuro gajuseyo","audio_sinsadong_euro_gajuseyo");
        database[21][12] = new Phrase(context,21,12,"Please stop in front of Theater","영화관 앞에 세워 주세요","yeonghwagwan ape sewo juseyo","audio_yeonghwagwan_ape_sewo_juseyo");
    }

    public Phrase[] getList(int index) {
        int length = 0;
        for (int i = 0; i < database[index].length; i++) {
            if (database[index][i] != null)
                length++;
        }
        Phrase[] tempList = new Phrase[length];
        for (int i = 0; i < length; i++) {
            tempList[i] = database[index][i];
        }
        return tempList;
    }

    public Phrase[] getBookmarksList() {
        SharedPreferences prefs = context.getSharedPreferences("Database", 0);
        int length = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                if (database[i][j] != null && prefs.getBoolean("DateBase_" + String.valueOf(i)  + "_" + String.valueOf(j), false))
                    length++;
            }
        }
        Phrase[] tempList = new Phrase[length];
        int counter = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                if (database[i][j] != null && prefs.getBoolean("DateBase_" + String.valueOf(i)  + "_" + String.valueOf(j), false)) {
                    tempList[counter] = database[i][j];
                    counter++;
                }
            }
        }
        return tempList;
    }

    public Phrase[] getSearchByEnglishList(String target) {
        int length = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                if (database[i][j] != null && database[i][j].englishText.toLowerCase().contains(target.toLowerCase()))
                    length++;
            }
        }
        Phrase[] tempList = new Phrase[length];
        int counter = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                if (database[i][j] != null && database[i][j].englishText.toLowerCase().contains(target.toLowerCase())) {
                    tempList[counter] = database[i][j];
                    counter++;
                }
            }
        }
        return tempList;
    }

    public Phrase[] getSearchByKoreanList(String target) {
        int length = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                if (database[i][j] != null && database[i][j].koreanText.contains(target))
                    length++;
            }
        }
        Phrase[] tempList = new Phrase[length];
        int counter = 0;
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                if (database[i][j] != null && database[i][j].koreanText.contains(target)) {
                    tempList[counter] = database[i][j];
                    counter++;
                }
            }
        }
        return tempList;
    }
}
