let curStuNo = 0;
let students = null;

$(document).ready(function(){
    curStuNo = getUrlSearch("stuNo");

    $.ajax({
        type: "post",
        url: "StudentServlet?method=SearchOneByStuNo",
        data: "stuNo="+curStuNo,
        dataType: "json",
        success: function (data) {
            students = data;
            $("#stuNoText").val(students.stuNo);
            $("#stuNameText").val(students.stuName);
            $("#stuClassText").val(students.stuClass);
            if(students.stuSex=="男"){
                $("#femaleRadio").removeAttr("checked");
                $("#maleRadio").attr("checked","checked");
            }else{
                $("#maleRadio").removeAttr("checked");
                $("#femaleRadio").attr("checked","checked");
            }
            $("#stuDormText").val(students.stuDorm);
            $("#stuDepartText").val(students.stuDepart);
            $("#stuTelText").val(students.stuTel);
        }
    });

    $(".backButton").click(function(){
        window.location.href = "SystemServlet?method=toMainView";
    });
    $(".saveButton").click(function(){
        let data = null;
        data = $("#updateForm").serialize();
        data = data;
        $.ajax({
            type: "post",
            url: "StudentServlet?method=Update",
            data: data,
            dataType: "text",
            success: function(msg){
                if(msg=="updateSuccess"){
                    alert("修改成功！");
                    window.location.href = "SystemServlet?method=toMainView";
                }
                else if(msg=="updateBlank"){
                    alert("请保证数据不为空！");
                }
            }
        });
    });

    function getUrlSearch(name) {
        if (!name) return null;
        let after = window.location.search;
        after = after.substr(1) || window.location.hash.split('?')[1];
        if (!after) return null;
        if (after.indexOf(name) === -1) return null;
        let reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)');
        let r = decodeURI(after).match(reg);
        if (!r) return null;
        return r[2];
    }
});