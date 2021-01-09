$(document).ready(function(){
    //登录按钮
    $("#loginSubmitButton").click(
        function(){
            let data = $("#form").serialize();
            $.ajax({
                type: "post",
                url: "LoginServlet",
                data: data,
                dataType: "text",
                success: function(msg){
                    if(msg=="blankError"){
                        alert("用户名或密码不可为空！");
                        $("input[name='admusername']").val("");		//清空用户名输入框
                        $("input[name='admpassword']").val("");		//清空密码输入框
                    }
                    else if(msg=="loginSuccess"){
                        window.location.href = "SystemServlet?method=toMainView";
                    }
                    else if(msg=="loginFailed"){
                        alert("请检查用户名或密码是否有误！");
                    }
                }
            })
        }
    );
});
