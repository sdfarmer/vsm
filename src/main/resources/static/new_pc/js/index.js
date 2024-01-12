//µ¼º½ÇÐ»»
$(".nav li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
  //  $(".typezixun ul").eq($(this).index()).addClass("cur");
   // $(".typezixun ul").eq($(this).index()).siblings().removeClass("cur");
});


//×ÊÑ¶ÎÊ´ð×¨ÌâÇÐ»»
$(".typenav li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
    $(".typezixun ul").eq($(this).index()).addClass("cur");
    $(".typezixun ul").eq($(this).index()).siblings().removeClass("cur");
});
//保险产品切换
$(".baoxian .navlist li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
    $(".baoxianpro ul").eq($(this).index()).addClass("cur");
    $(".baoxianpro ul").eq($(this).index()).siblings().removeClass("cur");
});

//贷款产品切换
$(".daikuan .navlist li").click(function () {
   $(this).addClass("cur").siblings().removeClass("cur");
   $(".daikuanpro ul").eq($(this).index()).addClass("cur");
   $(".daikuanpro ul").eq($(this).index()).siblings().removeClass("cur");
});
//信用卡产品切换
$(".xinyongka .navlist li").click(function () {
   $(this).addClass("cur").siblings().removeClass("cur");
   $(".xinyongkapro ul").eq($(this).index()).addClass("cur");
   $(".xinyongkapro ul").eq($(this).index()).siblings().removeClass("cur");
});

