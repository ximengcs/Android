package applicationexam.java.main.exam;

import java.util.HashMap;

public class Data {
    public static int model = 0;//模式: 0:练习模式  1:考试模式

    public static HashMap<String,String> answer;

    public static void initial_answer() {
        answer = new HashMap<>();
        answer.put("1","请大家按顺序排队。\n");
        answer.put("2","抱歉，您的车票超程了（余额不足）请补足车票。\n");
        answer.put("3","我建议您买一张一卡通，因为一卡通可以在其他的公共交通车上使用\n");
        answer.put("4","如果您需要更多的帮助的话请随时与我联系，我的员工号是007\n");
        answer.put("5","请与车站工作人员联系，他们会帮助您\n");
        answer.put("6","打扰了，请问怎样换乘2号线\n");
        answer.put("7","standard；smile；\n");
        answer.put("8","请在票务中心排队购买\n");
        answer.put("9","在站厅的另一端有站内小银行\n");
        answer.put("10","单程票必须在出闸时回收\n");
        answer.put("11","地铁所至；爱心相随\n");
        answer.put("12","您好；谢谢\n");
        answer.put("13","10人；3分钟\n");
        answer.put("14","员工服务；运营政策\n");
        answer.put("15","利益损害；负有责任的\n");
        answer.put("16","1日；驻站公安\n");
        answer.put("17","B类有责；A类有责\n");
        answer.put("18","欺瞒；B类有责\n");
        answer.put("19","服务设备；设施故障\n");
        answer.put("20","1天；自行处理\n");
        answer.put("21","运营网；企业发展部\n");
        answer.put("22","运营网；驻站公安\n");
        answer.put("23","腐蚀；剧毒\n");
        answer.put("24","值班站长；核对失物\n");
        answer.put("25","车站值班员；值班站长\n");
        answer.put("26","本人身份证；乘客遗失物品登记台账\n");
        answer.put("27","站立乘车；仪容仪表\n");
        answer.put("28","进入车控室；上岗时的规定\n");
        answer.put("29","耐心有礼；面带微笑\n");
        answer.put("30","剃光头；前不遮眉\n");
        answer.put("31","黄色安全线；维护站台秩序\n");
        answer.put("32","话到；手到\n");
        answer.put("33","三步一回头；车控室\n");
        answer.put("34","黑；夸张的装饰 \n");
        answer.put("35","精神饱满；剪指甲\n");
        answer.put("36","30；0.15\n");
        answer.put("37","遗留硬币；车站营收日报表\n");
        answer.put("38","一人一票；发售当站\n");
        answer.put("39","普通单程票；预制单程票\n");
        answer.put("40","谁使用谁加封；谁保管谁加封\n");
        answer.put("41","私款；私人车票\n");
        answer.put("42","站名章；日期章\n");
        answer.put("43","七日内；特殊车票退款记录表\n");
        answer.put("44","盖章确认；签字确认\n");
        answer.put("45","210；全程最高单程票价\n");
        answer.put("46","客运值班员；客运值班员交接班本\n");
        answer.put("47","概不退换；特殊车票退款记录表\n");
        answer.put("48","准备工作；5分钟\n");
        answer.put("49","规章制度；票务事故\n");
        answer.put("50","二唱；四找零\n");
        answer.put("51","付费区；非付费区\n");
        answer.put("52","7：00-9:00；17:00-19:00\n");
        answer.put("53","中华人民共和国残疾军人证；中华人民共和国伤残疾人民警察证\n");
        answer.put("54","两倍；五倍；\n");
        answer.put("55","副券；正券\n");
        answer.put("56","建筑限界；设备限界\n");
        answer.put("57","双线；双线单向右侧\n");
        answer.put("58","11\n");
        answer.put("59","4040\n");
        answer.put("60","站内；区间\n");
        answer.put("61","电话记录号；发车手信号\n");
        answer.put("62","正线；折返线\n");
        answer.put("63","行调；运营时刻表\n");
        answer.put("64","零时；有效\n");
        answer.put("65","行调；车辆段调度\n");
        answer.put("66","只挂不锁；正常锁闭\n");
        answer.put("67","前进方向第二个车门处；司机动车\n");
        answer.put("68","端墙门内；发车手信号\n");
        answer.put("69","25km/h；40km/h\n");
        answer.put("70","先通后复；好了\n");
        answer.put("71","24道（48扇）；6道（12扇）\n");
        answer.put("72","车站；施工部门\n");
        answer.put("73","本站客流情况；行车值班员\n");
        answer.put("74","紧急停车按钮；IBP控制盘\n");
        answer.put("75","运营时刻表；2min\n");
        answer.put("76","35.2km\n");
        answer.put("77","左位；右位\n");
        answer.put("78","相同运行方向两架相邻出站信号机间\n");
        answer.put("79","前后瞭望；道岔尖轨\n");
        answer.put("80","应急疏散通道；防火卷帘门 \n");
        answer.put("81","扒乘；3米\n");
        answer.put("82","常开；无人\n");
        answer.put("83","安抚乘客；擅自拾取\n");
        answer.put("84","空气呼吸器；有害\n");
        answer.put("85","隔绝助燃物；消除着火源\n");
        answer.put("86","钩锁器；红闪灯\n");
        answer.put("87","防消结合；谁使用，谁管理\n");
        answer.put("88","放射性；腐蚀性\n");
        answer.put("89","辅助线；工程列车\n");
        answer.put("90","停电\n");
        answer.put("91","安全防护；恢复正常\n");
        answer.put("92","辅站；7\n");
        answer.put("93","主站；登记\n");
        answer.put("94","辅站；登记\n");
        answer.put("95","紧停；司机立即停车\n");
        answer.put("96","30；40\n");
        answer.put("97","爆炸品；易燃液体\n");
        answer.put("98","橙色；蓝色\n");
        answer.put("99","旁路状态；相邻的滑动门\n");
        answer.put("100","屏蔽门专用钥匙手动操作；就地控制盘即站台级\n");
        answer.put("101","抓稳扶好；按压紧停按钮\n");
        answer.put("102","车控室；跟车进入折返线\n");
        answer.put("103","超充；欠压\n");
        answer.put("104","绿色灯光上弧线向列车方向作圆形转动\n");
        answer.put("105","CBTC 移动闭塞；BM固定闭塞；联锁控制\n");
        answer.put("106","B\n");
        answer.put("107","C\n");
        answer.put("108","A\n");
        answer.put("109","A \n");
        answer.put("110","C\n");
        answer.put("111","A\n");
        answer.put("112","C\n");
        answer.put("113","A \n");
        answer.put("114","C\n");
        answer.put("115","C\n");
        answer.put("116","A");
        answer.put("117","C\n");
        answer.put("118","A\n");
        answer.put("119","A \n");
        answer.put("120","C\n");
        answer.put("121","A\n");
        answer.put("122","C \n");
        answer.put("123","A\n");
        answer.put("124","C \n");
        answer.put("125","D\n");
        answer.put("126","B\n");
        answer.put("127","B\n");
        answer.put("131","B\n");
        answer.put("132","C\n");
        answer.put("133","A\n");
        answer.put("134","D\n");
        answer.put("135","B\n");
        answer.put("136","C\n");
        answer.put("137","A\n");
        answer.put("138","B\n");
        answer.put("139","C\n");
        answer.put("140","A\n");
        answer.put("141","C \n");
        answer.put("142","B\n");
        answer.put("143","D\n");
        answer.put("144","A \n");
        answer.put("145","A\n");
        answer.put("146","C\n");
        answer.put("147","B \n");
        answer.put("148","B\n");
        answer.put("149","B\n");
        answer.put("150","B\n");
        answer.put("151","A\n");
        answer.put("152","A\n");
        answer.put("153","C\n");
        answer.put("154","C\n");
        answer.put("155","D\n");
        answer.put("156","D\n");
        answer.put("157","B\n");
        answer.put("158","C\n");
        answer.put("159","D\n");
        answer.put("160","C\n");
        answer.put("161","B\n");
        answer.put("162","D\n");
        answer.put("163","C\n");
        answer.put("164","D\n");
        answer.put("165","C\n");
        answer.put("166","A\n");
        answer.put("167","B\n");
        answer.put("168","B\n");
        answer.put("169","D\n");
        answer.put("170","A\n");
        answer.put("171","C\n");
        answer.put("172","C\n");
        answer.put("173","C\n");
        answer.put("174","C\n");
        answer.put("175","B\n");
        answer.put("176","D\n");
        answer.put("177","B\n");
        answer.put("178","A\n");
        answer.put("179","A\n");
        answer.put("180","C\n");
        answer.put("181","C\n");
        answer.put("182","A\n");
        answer.put("183","B\n");
        answer.put("184","C\n");
        answer.put("185","C\n");
        answer.put("186","B\n");
        answer.put("187","B\n");
        answer.put("188","C\n");
        answer.put("189","B\n");
        answer.put("190","D\n");
        answer.put("191","B\n");
        answer.put("192","C\n");
        answer.put("193","B\n");
        answer.put("194","C\n");
        answer.put("195","D\n");
        answer.put("196","B\n");
        answer.put("197","A\n");
        answer.put("198","B\n");
        answer.put("199","B\n");
        answer.put("200","C \n");
        answer.put("201","D\n");
        answer.put("202","A\n");
        answer.put("203","B\n");
        answer.put("204","A\n");
        answer.put("205","A\n");
        answer.put("206","A\n");
        answer.put("207","D\n");
        answer.put("208","A\n");
        answer.put("209","ABCE\n");
        answer.put("210","ABC\n");
        answer.put("211","ABD\n");
        answer.put("212","ABC\n");
        answer.put("213","ABD\n");
        answer.put("214","ABCD\n");
        answer.put("215","AB\n");
        answer.put("216","ABC\n");
        answer.put("217","AB\n");
        answer.put("218","ABD\n");
        answer.put("219","ABD\n");
        answer.put("220","ABCD\n");
        answer.put("221","ABC\n");
        answer.put("222","AB\n");
        answer.put("223","ABCD\n");
        answer.put("224","ABCD\n");
        answer.put("225","ACDE\n");
        answer.put("226","ABD\n");
        answer.put("227","ABD\n");
        answer.put("228","ABD\n");
        answer.put("229","ABCDEF\n");
        answer.put("230","ABCD\n");
        answer.put("231","BC\n");
        answer.put("232","AD\n");
        answer.put("233","ACD\n");
        answer.put("234","BC\n");
        answer.put("235","ABCD\n");
        answer.put("236","BCD\n");
        answer.put("237","ABC\n");
        answer.put("238","DE\n");
        answer.put("239","BCEF\n");
        answer.put("240","ABCD\n");
        answer.put("241","ABCE\n");
        answer.put("242","AB\n");
        answer.put("243","ABCDE\n");
        answer.put("244","ACD\n");
        answer.put("245","ABCF\n");
        answer.put("246","BCD\n");
        answer.put("247","AB\n");
        answer.put("248","ABCDE\n");
        answer.put("249","ABCD\n");
        answer.put("250","ABCD\n");
        answer.put("251","ABC\n");
        answer.put("252","ABCD\n");
        answer.put("253","ABCD\n");
        answer.put("254","ABCE\n");
        answer.put("255","BCD\n");
        answer.put("256","BCDE\n");
        answer.put("257","ABC\n");
        answer.put("258","ABCDE\n");
        answer.put("259","AC\n");
        answer.put("260","ABCD\n");
        answer.put("261","CD\n");
        answer.put("262","ABC\n");
        answer.put("263","ABCDE\n");
        answer.put("264","ABCDE\n");
        answer.put("265","AC\n");
        answer.put("266","ABCE\n");
        answer.put("267","ABCDE\n");
        answer.put("268","BCE \n");
        answer.put("269","BCDE\n");
        answer.put("270","ABCD\n");
        answer.put("271","AB\n");
        answer.put("272","ABCD\n");
        answer.put("273","ABCD\n");
        answer.put("274","ABC\n");
        answer.put("275","ABCDE\n");
        answer.put("276","ABCD\n");
        answer.put("277","ABCE\n");
        answer.put("278","ACDE\n");
        answer.put("279","ABC\n");
        answer.put("280","BCD\n");
        answer.put("281","BC\n");
        answer.put("282","ABCE\n");
        answer.put("283","BCD\n");
        answer.put("284","ABCDE\n");
        answer.put("285","ABCD\n");
        answer.put("286","CB\n");
        answer.put("287","ACD\n");
        answer.put("288","BC\n");
        answer.put("289","ABC\n");
        answer.put("290","ABCDEF\n");
        answer.put("291","ABCD\n");
        answer.put("292","ABCD\n");
        answer.put("293","ABCD\n");
        answer.put("294","AB\n");
        answer.put("295","F\n");
        answer.put("296","F\n");
        answer.put("297","T\n");
        answer.put("298","F\n");
        answer.put("299","F\n");
        answer.put("300","F\n");
        answer.put("301","T\n");
        answer.put("302","F\n");
        answer.put("303","T\n");
        answer.put("304","F\n");
        answer.put("305","T\n");
        answer.put("306","F\n");
        answer.put("307","T\n");
        answer.put("308","F\n");
        answer.put("309","F\n");
        answer.put("310","F\n");
        answer.put("311","F\n");
        answer.put("312","T\n");
        answer.put("313","T\n");
        answer.put("314","F\n");
        answer.put("315","F\n");
        answer.put("316","T\n");
        answer.put("317","F\n");
        answer.put("318","F\n");
        answer.put("319","T\n");
        answer.put("320","T\n");
        answer.put("321","F\n");
        answer.put("322","F\n");
        answer.put("323","F\n");
        answer.put("324","F\n");
        answer.put("325","T\n");
        answer.put("326","T\n");
        answer.put("327","T\n");
        answer.put("328","F\n");
        answer.put("329","T\n");
        answer.put("330","T\n");
        answer.put("331","F\n");
        answer.put("332","T\n");
        answer.put("333","F\n");
        answer.put("334","F\n");
        answer.put("335","T\n");
        answer.put("336","T\n");
        answer.put("337","F\n");
        answer.put("338","F\n");
        answer.put("339","T\n");
        answer.put("340","F\n");
        answer.put("341","T\n");
        answer.put("342","T\n");
        answer.put("343","T\n");
        answer.put("344","F\n");
        answer.put("345","T\n");
        answer.put("346","F\n");
        answer.put("347","T\n");
        answer.put("348","F\n");
        answer.put("349","T\n");
        answer.put("350","T\n");
        answer.put("351","T\n");
        answer.put("352","T\n");
        answer.put("353","T\n");
        answer.put("354","F\n");
        answer.put("355","F\n");
        answer.put("356","T\n");
        answer.put("357","F\n");
        answer.put("358","T\n");
        answer.put("359","F\n");
        answer.put("360","T\n");
        answer.put("361","F\n");
        answer.put("362","F\n");
        answer.put("363","T\n");
        answer.put("364","F\n");
        answer.put("365","F\n");
        answer.put("366","F\n");
        answer.put("367","T\n");
        answer.put("368","F\n");
        answer.put("369","F\n");
        answer.put("370","F\n");
        answer.put("371","T\n");
        answer.put("372","F\n");
        answer.put("373","F\n");
        answer.put("374","T\n");
        answer.put("375","F\n");
        answer.put("376","T\n");
        answer.put("377","F\n");
        answer.put("378","F\n");
        answer.put("379","F\n");
        answer.put("380","T\n");
        answer.put("381","F\n");
        answer.put("382","T\n");
        answer.put("383","T\n");
        answer.put("384","F\n");
        answer.put("385","T\n");
        answer.put("386","T\n");
        answer.put("387","T\n");
        answer.put("388","T\n");
        answer.put("389","F\n");
        answer.put("390","T\n");
        answer.put("391","F\n");
        answer.put("392","F\n");
        answer.put("393","F\n");
        answer.put("394","T\n");
        answer.put("395","F\n");
        answer.put("396","T\n");
        answer.put("397","F\n");
        answer.put("398","T\n");
        answer.put("399","F\n");
    }
}
