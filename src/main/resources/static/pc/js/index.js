//�����л�
$(".nav li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
  //  $(".typezixun ul").eq($(this).index()).addClass("cur");
   // $(".typezixun ul").eq($(this).index()).siblings().removeClass("cur");
});


//��Ѷ�ʴ�ר���л�
$(".typenav li").click(function () {
    $(this).addClass("cur").siblings().removeClass("cur");
    $(".typezixun ul").eq($(this).index()).addClass("cur");
    $(".typezixun ul").eq($(this).index()).siblings().removeClass("cur");
});