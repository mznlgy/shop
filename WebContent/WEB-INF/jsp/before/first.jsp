<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta chatset="UTF-8">
<title>首页</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/before/font-awesome.css"></link>
<link href="<%=request.getContextPath()%>/css/before/first2.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/before/first.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="top_all" id="top_all">
	<div class="top_main">
		<div id="mokuai_3">
			<div>
<ul class='menu clearfix'>
	<li><a href="#">首页</a></li>
	<li><a href="#">网站介绍</a></li>
	<li><a href="#">联系我们</a></li>
	<li><a href="#">投诉及建议</a></li>
	<li><a href="#">反馈</a></li>
</ul></div></div>
<div id="mokuai_4">
	<div>
     <div id="tb_last_box_4"><a href="first.php"></a>
     <a href="${pageContext.request.contextPath}/before/first"><img class="logo" alt="" src="<%=request.getContextPath()%>/images/logo.jpg"></a></div>
</div></div>
		 <div id="mokuai_5" style="height:90px;border-right-style: none;">
                <form action="${pageContext.request.contextPath}/before/search?requestpage=1" method="post">
                <input type="hidden" value="goods">
                <input type="text" class="bt_inp" placeholder="搜索商品" name="product_name">
                <input type="submit" class="bt_search" value="搜索">
                </form>
            </div>
		<div id="mokuai_6" style="left:70%;">
			<div>
                <span><span>
                <a href="#"><strong>${username}</strong></a>,欢迎来到桃子商城！
                </span> 
                <span>|</span>
                <a href="${pageContext.request.contextPath}/before/logout">退出登录</a>
                <span>|</span>
                <a href="${pageContext.request.contextPath}/before/myorders">我的订单</a>
                <span>|</span>
                <a href="${pageContext.request.contextPath}/before/shoppingcart">购物车</a>
            </div>	
		</div>
	</div>
</div>
<div class="fullSlide">
        <div class="bdfullscreen">
            <ul>
                <li><a href="#"><image class="topimg" src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1283627744,1907709348&fm=26&gp=0.jpg"/></a></li>
            </ul>
</div>
    <div class="hdfullscreen"><ul></ul></div>
    <span class="prev"></span><span class="next"></span>
</div>
<div id="boxes">
<div class="main_css">
		<div class="box_css_1">
			<div class="box_css_main_1">
            <div>
            <a href="${pageContext.request.contextPath}/before/search?product_name=手表&requestpage=1"><img class="zhuanqu" alt="" src="<%=request.getContextPath()%>/images/watch.jpg"></a></div>
            </div>
		</div>
		<div class="box_css_1" style="position:absolute;width:463px; height:198px; top:11px; left:494px; z-index:1; overflow:hidden">       
			<div class="box_css_main_1">
            <div id="last_box_3">
            <a href="${pageContext.request.contextPath}/before/search?product_name=手机&requestpage=1"><img class="zhuanqu"alt="" src="<%=request.getContextPath()%>/images/phone.jpg"></a></div>
            </div>
		</div>
		<div class="box_css_1" style="position:absolute;width:465px; height:199px; top:229px; left:7px; z-index:1; overflow:hidden">
			<div class="box_css_main_1">
            <div id="last_box_4">
            <a href="${pageContext.request.contextPath}/before/search?product_name=美妆&requestpage=1"><img alt="" class="zhuanqu" src="<%=request.getContextPath()%>/images/meizhuang.jpg"></a></div>
            </div>
		</div>
		<div class="box_css_1" id="mokuai_5" style="position:absolute;width:465px; height:199px; top:170px; left:100px; z-index:1; overflow:hidden">  
			<div class="box_css_main_1">
            <div>
            <a href="${pageContext.request.contextPath}/before/search?product_name=服饰&requestpage=1"><img alt="" class="zhuanqu" src="<%=request.getContextPath()%>/images/cloth.jpg"></a></div>
            </div>
		</div>
		<div class="box_css_2 box_dq" style="position:absolute;width:676px; height:258px; top:443px; left:0px; z-index:1; overflow:hidden">
            <div class="box_css_top_2  clearfix">家用电器</div>
			<div class="box_css_main_2">
            <div id="last_box_6" class="shop_tw1_css_6">
<ul id="ul_box_6" class="clearfix">
<li><a href="${pageContext.request.contextPath}/before/product?product_id=1"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/2206505144097/O1CN01E1Dyb01g8TKGGTzqc_!!2206505144097.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=1">宿舍出租房用小电冰箱</a></span><div><b>￥1699</b><i class="scj">￥4699</i></div></li>
<li><a href="${pageContext.request.contextPath}/before/product?product_id=2"><img src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3626434161/O1CN01iZfKf21gbmfsfw2SH_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=2">美的空调大1匹挂机家用</a></span><div><b>￥2199</b><i class="scj">￥3999</i></div></li>
<li><a href="${pageContext.request.contextPath}/before/product?product_id=3"><img src="https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/1714128138/O1CN0194Iy5229zFpJ3ll8V_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=3">小米电视4A60英寸4k液晶</a></span><div><b>￥2499</b><i class="scj">￥3699</i></div></li>
<li><a href="${pageContext.request.contextPath}/before/product?product_id=4"><img src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3619883037/O1CN01AZZPOP1YIzRllECCx_!!3619883037.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=4">苹果电脑一体2机1.5 27寸</a></span><div><b>￥8699</b><i class="scj">￥10999</i></div></li></ul>
</div>
</div>
</div>
<div class="box_css_2" id="mokuai_7" style="position:absolute;width:676px; height:259px; top:702px; left:0px; z-index:1; overflow:hidden">
        <div class="box_css_top_2  clearfix">电子产品</div>
		<div class="box_css_main_2" style="">
        <div id="last_box_7" class="shop_tw1_css_6">
<ul id="ul_box_7" class="clearfix">
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=5"><img src="https://g-search1.alicdn.com/img/bao/uploaded/i4/i2/2697452977/O1CN01qUaMJy1XrVjRitP1x_!!2697452977.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=5">Canon/佳能EO码单相机</a></span><div><b>￥1780</b><i class="scj">￥2699</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=6"><img src="https://g-search1.alicdn.com/img/bao/uploaded/i4/i3/4092701337/O1CN01PJWEco1LkOAn6b5dM_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=6">华为智能手环运动手表</a></span><div><b>￥1780</b><i class="scj">￥1999</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=7"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/2210062873941/O1CN01zYzx7R1ez1XXRWMP9_!!2210062873941-0-picasso.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=7">HUAWEIMate30Pro5G</a></span><div><b>￥5758</b><i class="scj">￥6099</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=8"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i3/2924891464/O1CN01HFduvd1MgYUBuG9BJ_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=8">Pad Pro+5G系列平板电脑</a></span><div><b>￥998</b><i class="scj">￥1699</i></div></li></ul></div></div>
</div>
<div class="box_css_2" id="mokuai_8" style="position:absolute;width:677px; height:260px; top:963px; left:0px; z-index:1; overflow:hidden">
       <div class="box_css_top_2  clearfix">美妆</div>
	   <div class="box_css_main_2" style="">
       <div id="last_box_8" class="shop_tw1_css_6">
<ul id="ul_box_8" class="clearfix">
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=9"><img src="https://g-search1.alicdn.com/img/bao/uploaded/i4/i4/2206768087628/O1CN011mGALh26DfoIRu9j6_!!2206768087628-0-lubanu-s.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=9">花西子百鸟朝凤浮雕彩妆盘</a></span><div><b>￥259</b><i class="scj">￥279</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=10"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/298292444/O1CN01bxFGal1TvOcTitdPH_!!298292444.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=10">完美日记白胖子卸妆水</a></span><div><b>￥69.9</b><i class="scj">￥69.9</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=11"><img src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i1/2210025511581/O1CN01C9s8Xi1NY8pGya6Lh_!!2210025511581.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=11">ysl圣罗兰口红小金条</a></span><div><b>￥148</b><i class="scj">￥199</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=12"><img src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/3375170974/O1CN01zByWJ81J48OClH90s_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=12">完美日记双头六角眉笔防水</a></span><div><b>￥29.9</b><i class="scj">￥39.9</i></div></li></ul>
</div>
        </div>
		</div>
		<div class="box_css_2" id="mokuai_9" style="position:absolute;width:676px; height:258px; top:1226px; left:0px; z-index:1; overflow:hidden">
            <div class="box_css_top_2  clearfix">生活用品</div>
			<div class="box_css_main_2" style="">
            <div id="last_box_9" class="shop_tw1_css_6">
<ul id="ul_box_9" class="clearfix">
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=13"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/3044862122/O1CN016UtUlg1RXv2YAY39o_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=13">厨帮宝鸡翅木筷子家用</a></span><div><b>￥16.6</b><i class="scj">￥20.9</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=14"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/2949212121/O1CN01cMF0LD1RXSg3knZPE_!!2949212121-0-lubanu-s.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=14">毛衣男宽松针织</a></span><div><b>￥68</b><i class="scj">￥78</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=15"><img src="https://g-search3.alicdn.com/img/bao/uploaded/i4/i1/2206766499708/O1CN01LSAeeU2LaJePlsCND_!!0-item_pic.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=15">扫把套装家用扫帚</a></span><div><b>￥34.9</b><i class="scj">￥3
4.9</i></div></li>
	<li><a href="${pageContext.request.contextPath}/before/product?product_id=16"><img src="https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/730650594/O1CN01S7V5b71GG5uHtWVvP_!!730650594.jpg_580x580Q90.jpg_.webp" border="0" alt=""></a><span><a href="${pageContext.request.contextPath}/before/product?product_id=16">日本资生堂头皮生机洗发露</a></span><div><b>￥119</b><i class="scj">￥219</i></div></li></ul></div></div>
</div>
	<div class="box_css_3" id="mokuai_10" style="position:absolute;width:267px; height:301px; top:441px; left:691px; z-index:1; overflow:hidden">
            <div class="box_css_top_3  clearfix">本周热销</div>
			<div class="box_css_main_3" style="">
            <div id="last_box_10">
            <ul>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=14"><img class="logo2" src="<%=request.getContextPath()%>/images/fire.png"/><em style="font-size:15px;color:red;">1</em>毛衣男半高领宽松针织衫春秋款线衫冬季内搭打底衫毛衫潮流毛线衣</a></li>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=9"><img class="logo2" src="<%=request.getContextPath()%>/images/fire.png"/><em style="font-size:15px;color:red;">2</em>花西子百鸟朝凤浮雕彩妆盘/雕花眼影盘高光珠光修容腮红多功能盘</a></li>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=16"><img class="logo2" src="<%=request.getContextPath()%>/images/fire.png"/><em style="font-size:15px;color:red;">3</em>华为通用智能手环蓝牙通话运动手表血压心率苹果oppo小米vivo医疗级防水男女款多功能睡眠监测音乐播放卡路里</a></li>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=11"><img class="logo2" src="<%=request.getContextPath()%>/images/fire.png"/><em style="font-size:15px;color:red;">4</em>ysl圣罗兰口红小金条21/28/12杨树林23细管30银条107粉条大牌正品</a></li> 
</ul></div></div></div>

		<div class="box_css_3" id="mokuai_11" style="position:absolute;width:266px; height:354px; top:754px; left:692px; z-index:1; overflow:hidden">
            <div class="box_css_top_3  clearfix"><span><a target="_blank" href="index9.html"></a></span>推荐新品</div>
			<div class="box_css_main_3">
            <div id="last_box_11">
<ul id="ul_box_11" class="a_css_2 clearfix">
       <li><a href="${pageContext.request.contextPath}/before/product?product_id=21"><i class="fa fa-hand-o-right"></i>小金刚品质保证，天玑800U处理器【note9pro火热抢购中】</a></li>
       <li><a href="${pageContext.request.contextPath}/before/product?product_id=24"><i class="fa fa-hand-o-right"></i>【原创国风礼盒包装】【100%羊毛围巾+真皮触屏手套】</a></li>
       <li><a href="${pageContext.request.contextPath}/before/product?product_id=25"><i class="fa fa-hand-o-right"></i>A14仿生芯片，6.1英寸超视网膜XDR显示屏,升维大提速，现实力登场！通过以旧换新购买值享焕新版iPhone</a></li>
       <li><a href="${pageContext.request.contextPath}/before/product?product_id=26"><i class="fa fa-hand-o-right"></i>天玑820高性能处理器，双5G待机【note9pro火热抢购中】</a></li>   
       <li><a href="${pageContext.request.contextPath}/before/product?product_id=2337"><i class="fa fa-hand-o-right"></i>艾叶泡脚药包艾灸盒家用宫寒去湿气祛湿神器足浴粉艾草泡脚粉泡澡 2包装款式随机（60小包）</a></li>   
</ul></div></div>
</div>
		<div class="box_css_3" id="mokuai_12" style="position:absolute;width:265px; height:357px; top:1118px; left:693px; z-index:1; overflow:hidden">
            <div class="box_css_top_3  clearfix">超值好物</div>
 				<li><a href="${pageContext.request.contextPath}/before/product?product_id=1444"><i class="fa fa-hand-o-right"></i><em style="font-size:16px;">1&nbsp;【微波炉就选格兰仕】不锈钢内胆，一抹即净，更坚固，更耐用，更安全，微烤一体，一机两用，光波烧烤，外焦里嫩，经典侧拉门，外观时尚</em></a></li>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=1449"><i class="fa fa-hand-o-right"></i><em style="font-size:16px;">2&nbsp;摩飞多功能锅MR9088，下单再送厨具套装、防烫手套和电子食谱！</em></a></li>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=745"><i class="fa fa-hand-o-right"></i><em style="font-size:16px;">3&nbsp;花花公子羽绒服男外套2020冬季新款士加厚大码休闲轻薄羽绒服男白鸭绒保暖商务男装潮流上衣服男士短款</em></a></li>
            	<li><a href="${pageContext.request.contextPath}/before/product?product_id=756"><i class="fa fa-hand-o-right"></i><em style="font-size:16px;">4&nbsp;AEMAPE棉衣男加厚保暖男装大码棉服男潮流修身连帽外套男棉袄</em></a></li>
			<div class="box_css_1" id="mokuai_13" style="position:absolute;width:953px; height:95px; top:1487px; left:2px; z-index:1; overflow:hidden">
			<div class="box_css_main_1" style="">
            <div id="last_box_13"><p align="center">
	<img alt="" src="../img/shouyeggao.gif">
</p></div></div></div></div>
</div>
<div class="bot_all" id="bot_all">
	<div class="bot_main" id="bot_main" style="position:relative;width: 100%;margin-left: 60px;">
		<div style="position:absolute;width:956px; height:75px; top:12px; left:2px; z-index:1;overflow:hidden;left: 130px;">
			<div>
                <div id="tb_last_box_2"><p align="center">
	<span style="color:#666666;">地址：中山大学新华学院（东莞校区）&nbsp;&nbsp;&nbsp;&nbsp; 联系邮箱：1134173134@qq.com</span><br>		
</p></div>
            </div>
		</div>
	</div>
</div>
</body>
</html>