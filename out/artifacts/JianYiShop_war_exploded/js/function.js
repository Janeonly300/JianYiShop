function setImage(thisImage) {
    thisImage.src = '/JianYiShop/checkCode?code='+new Date().getMilliseconds();
}

/**
 * 当聚焦的时候，移除错误属性
 * @param obj
 */
function onfocusItem(obj){
    $(obj).next("span").html('').removeClass("error")
}

/**
 * 当失去焦点，添加错误属性。
 * @param obj
 */
function onblurItem(obj){
    var msgBox = $(obj).next("span"); //获取span
    var flag = true;
    switch ($(obj).attr("name")) {
        case 'userName':
            if($(obj).val() === ""){
                msgBox.html("用户名输入内容不能为空");
                msgBox.addClass("error");
                return  false;
            }else{
                //发送ajax请求
                var url  = "/JianYiShop/userNameChecked";
                $.post(url,{username:$(obj).val()},function (data) {
                    if(data == 'false'){
                        msgBox.html("用户名不唯一");
                        msgBox.addClass("error");
                        return  false;
                    }else{
                        //唯一的用户名
                        msgBox.html('');
                        flag = true;
                    }
                });
            }
            break;
        case'name':
            if($(obj).val() === ""){
                msgBox.html("真实姓名不能为空");
                msgBox.addClass("error");
                return  false;
            }else{
                flag = true;
            }
            break;
        case 'pwd':
            if($(obj).val() === ""){
                msgBox.html("用户密码不能为空");
                msgBox.addClass("error");
                return  false;
            }else{
                flag = true;
            }
            break;
        case 'rePwd':
            if($(obj).val() !== $("#pwd").val()){
                msgBox.html("两次密码输入不一致，请重新输入");
                msgBox.addClass("error");
                return  false;
            }else{
                flag = true;
            }
            break;
        case 'phone':
            if ($(obj).val().length !== 11){
                msgBox.html("您输入的手机号码格式不正确");
                msgBox.addClass("error");
                return  false;
            }else{
                flag = true;
            }
            break;
        case 'code':
            if($(obj).val().length !==4){
                msgBox.html("您输入的验证码一定是错误的");
                msgBox.addClass("error")
                return  false;
            }else{
                var url = "/JianYiShop/checkCodeChecked";
                $.post(url,{codeNum:$(obj).val()},function (data) {
                    if(data == "false"){ //验证失败
                        msgBox.html("您输入的验证码有误");
                        msgBox.addClass("error");
                      return  false;
                    }else{ //验证成功
                        msgBox.html("");
                        flag = true;
                    }
                });
            }
            break;
    }
    return flag;
}

function checkedFromAll(frm){
    var els = frm.getElementsByTagName('input');
    var flag = false;
    // onblur
    for(var i = 0; i<els.length;i++){
        if(els[i].getAttribute("onblur")){
           flag =  onblurItem(els[i]); //检查
        }
    }
    return flag;
}