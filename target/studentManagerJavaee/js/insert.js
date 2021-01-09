$(document).ready(function(){

    $(".backButton").click(function(){
        window.location.href = "SystemServlet?method=toMainView";
    });
    $(".saveButton").click(function(){
        let data = null;
        data = $("#insertForm").serialize();
        data = data;
        $.ajax({
            type: "post",
            url: "StudentServlet?method=Insert",
            data: data,
            dataType: "text",
            success: function(msg){
                if(msg=="insertSuccess"){
                    alert("保存成功！");
                    window.location.href = "SystemServlet?method=toMainView";
                }
                else if(msg=="insertBlank"){
                    alert("请保证数据不为空！");
                }
            }
        });
    });
});