//登录
$("#login_b").click(function () {

    var userId = $("#user").val();
    var pwd = $("#password").val();
    var type = $("input[name='inlineRadioOptions']:checked").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data: {"id": userId, "pwd": pwd, "type": type},
        dataType: "json",
        success: function (resp) {
            if (resp.status != 200) {
                $(".errorMsg").show();
                $(".ts").html($(".ts").html() + resp.msg);
            } else {
                window.location.href = "/views/main.html";
            }
        },
        error: function (resp) {
            $(".errorMsg").show();
            $(".ts").html($(".ts").html() + "访问出错！");
        }
    });
});

//点击注册
$("#a_register").click(function () {
    $(".login-box").load("/views/main/signup.html");
});

//注册
$("#register_b").click(function () {

    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    var userId = $("#user").val();
    var pwd = $("#password").val();
    var r_pwd = $("#re_password").val();
    var type = $("input[name='inlineRadioOptions']:checked").val();

    if (userId == null || pwd == null || r_pwd == null || type == null) {
        alert("请填写完整信息")
    } else if (pwd != r_pwd) {
        alert("两次密码不同")
    } else if (!myreg.test(userId)) {
        alert('提示\n\n请输入有效的E_mail！');
    } else {
        $.ajax({
            type: "POST",
            url: "/register",
            data: {"id": userId, "pwd": pwd, "type": type},
            dataType: "json",
            success: function (resp) {
                if (resp.status != 200) {
                    $(".errorMsg").show();
                    $(".ts").html($(".ts").html() + resp.msg);
                } else {
                    alert("注册成功");
                    window.location.href = "/";
                }
            },
            error: function (resp) {
                $(".errorMsg").show();
                $(".ts").html($(".ts").html() + "访问出错！");
            }
        });
    }

});

//查看所有招聘信息
function allRecruitment() {

    $("#main").load("/views/equipment/listall.html");
}

//我的投递
function myApply() {
    $("#main").load("/views/equipment/myList.html");

}

//基本信息
function myBaseInfo() {
    $("#main").load("/views/home/baseInfo.html");
}

//教育经历
function myEducation() {

    $("#main").load("/views/home/education.html");
}

//奖学金
function myScholarship() {
    $("#main").load("/views/home/scholarship.html");
}

//项目经历
function myPractice() {

    $("#main").load("/views/home/practice.html");
}

//工作经历
function myWork() {
    $("#main").load("/views/home/work.html");
}

//其他信息
function otherInfo() {
    $("#main").load("/views/home/otherInfo.html");
}

//添加招聘信息
function addRecruitMent() {

    $("#main").load("/views/repair/addCom.html");
}

//管理招聘信息
function myRecruit() {

    $("#main").load("/views/repair/myRecruitList.html");
}

//查看投递信息
function allApply() {

    $("#main").load("/views/repair/allApply.html");
}




