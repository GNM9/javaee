let curPage = 0;
let sumPage = 9999;
let maxItemPerPage = 6;
let students=new Array();

$(document).ready(function(){
    $("#searchButtonID").click(function() {
        startSearching();
    })

    $("#preButtonID").click(function() {
        if(curPage!=0 && curPage!=1){
            let data = $("#searchForm").serialize();
            curPage = curPage - 1;
            $.ajax({
                type: "post",
                url: "StudentServlet?method=Search&curPage="+curPage,
                data: data,
                dataType: "json",
                success: function (data) {
                    students = data;
                    showDisplayRows();
                }
            })
        }
    })

    $("#nextButtonID").click(function() {
        if(curPage!=0 && curPage<sumPage){
            let data = $("#searchForm").serialize();
            curPage = curPage + 1;
            $.ajax({
                type: "post",
                url: "StudentServlet?method=Search&curPage="+curPage,
                data: data,
                dataType: "json",
                success: function (data) {
                    students = data;
                    showDisplayRows();
                }
            })
        }
    })

    $("#insertButtonID").click(function() {
        window.location.href = "insert.jsp";
    })

    $(".container").on('click','.updateButton',function(){
        let data = $(this).parents(".displayRow").find(".stuNo").text();
        window.location.href = "update.jsp?stuNo="+data;
    });

    $(".container").on('click','.deleteButton',function(){
        let data = $(this).parents(".displayRow").find(".stuNo").text();
        $.ajax({
            type: "post",
            url: "StudentServlet?method=Delete",
            data: "stuNo="+data,
            dataType: "text",
            success: function(msg){
                if(msg=="deleteSuccess"){
                    alert("删除成功！");
                    startSearching();
                }
                else if(msg=="deleteFailed"){
                    alert("删除失败！");
                }
            }
        })
    });
    
    function startSearching() {
        let data = $("#searchForm").serialize();
        curPage = 1;
        sumPage = 9999;
        $.ajax({
            type: "post",
            url: "StudentServlet?method=Search&curPage="+curPage,
            data: data,
            dataType: "json",
            success: function (data) {
                students = data;
                showDisplayRows();
            }
        })
    }
    
    function showDisplayRows(){
        if(students.length==0){
            sumPage = curPage-1;
            return;
        }
        $(".displayRow").remove();
        for(let i=0;i<6;i++){
            if(i>=students.length){
                sumPage = curPage;
                return;
            }
            let stuNo = students[i].stuNo;
            let stuName = students[i].stuName;
            let stuClass = students[i].stuClass;
            let stuSex = students[i].stuSex;
            let stuDorm = students[i].stuDorm;
            let stuDepart = students[i].stuDepart;
            let stuTel = students[i].stuTel;
            let stuPhoto = students[i].stuPhoto;

            let displayRowDiv = $('<tr class="displayRow"></tr>');
            let stuNoTd = $('<td class="stuNo">'+stuNo+'</td>');
            displayRowDiv.append(stuNoTd);
            let stuNameTd = $('<td class="stuName">'+stuName+'</td>');
            displayRowDiv.append(stuNameTd);
            let stuClassTd = $('<td class="stuClass">'+stuClass+'</td>');
            displayRowDiv.append(stuClassTd);
            let stuSexTd = $('<td class="stuSex">'+stuSex+'</td>');
            displayRowDiv.append(stuSexTd);
            let stuDormTd = $('<td class="stuDorm">'+stuDorm+'</td>');
            displayRowDiv.append(stuDormTd);
            let stuDepartTd = $('<td class="stuDepart">'+stuDepart+'</td>');
            displayRowDiv.append(stuDepartTd);
            let stuTelTd = $('<td class="stuTel">'+stuTel+'</td>');
            displayRowDiv.append(stuTelTd);
            let imgTd = $('<td></td>');
            let stuPhotoImg = null;
            stuPhotoImg = $('<img src="'+stuPhoto+'"></img>');
            imgTd.append(stuPhotoImg);
            displayRowDiv.append(imgTd);
            let btnTd = $('<td><div class="row"><button class="btn btn-default updateButton" type="button">修改</button></div><div class="row"><button class="btn btn-default deleteButton" type="button">删除</button></div></td>');
            displayRowDiv.append(btnTd);
            $("#showTable").append(displayRowDiv);
        }
    }
})