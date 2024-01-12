//导航切换
$(".nav li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
  //  $(".typezixun ul").eq($(this).index()).addClass("cur");
   // $(".typezixun ul").eq($(this).index()).siblings().removeClass("cur");
});


//资讯问答专题切换
$(".typenav li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
    $(".typezixun ul").eq($(this).index()).addClass("cur");
    $(".typezixun ul").eq($(this).index()).siblings().removeClass("cur");
});