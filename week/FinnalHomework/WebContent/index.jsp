<%@page import="homework.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>服务器平台后台考核</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        h1 {
            height: 59px;
            line-height: 59px;
            border-bottom: 1px solid #ccc;
            box-shadow: 0 0 5px 3px #eee;
            background-color: #eee;
            color: #999;
            text-indent: 1.5em;
        }
        nav {
            background-color: rgb(19,20,21);
            color: #999;
            position: fixed;
            top: 60px;
            left: 0;
            bottom: 0;
            padding-top: 25px;
        }
        nav li {
            list-style: none;
            padding: 15px 50px 15px 25px;
        }
        nav li:hover {
            cursor: pointer;
            background-color: rgba(50,51,52,0.5);
        }
        nav .active {
            background-color: rgba(90,91,92,0.5) !important;
        }
        .content {
            margin-left: 180px;
            padding-left: 2em;
        }
        .content h2 {
            padding: 20px 0;
        }
        input, select {
            display: block;
            border-radius: 5px;
            background-color: white;
            border: 1px solid #ccc;
            margin-bottom: 30px;
            height: 35px;
            font-size: 18px;
            text-indent: 1em;
            width: 350px;
        }
        button {
            display: block;
            width: 150px;
            text-align: center;
            height: 40px;
            line-height: 40px;
            color: white;
            background-color: rgb(54,133,250);
            font-size: 18px;
            border: 0;
            border-radius: 5px;
        }
        .content section {
            display: none;
        }
        .content .active {
            display: block;
        }
        table {
            background-color: #eee;
            margin: 50px;
            border: 1px solid #999;
            border-collapse: collapse;
        }
        th,td {
            border: 1px solid #ccc;
            padding: 10px 25px;
            min-width: 100px;
            text-align: center;
        }
    </style>
</head>
<!-- 以上标签中包含的信息无需改动 -->

<body>

    <!-- 顶部导航栏，无需改动 -->
    <h1>服务器平台后台考核-信息管理</h1>

    <!-- 左侧导航栏，需要在合适的li标签上添加上 class="active" 字段，四个中只能选一个添加 -->
    <nav>
        <ul>
            <li class="active" data-id="add">添加学生</li>
            <li data-id="delete">删除学生</li>
            <li data-id="modify">修改学生信息</li>
            <li data-id="search">查找学生信息</li>
        </ul>
    </nav>

    <div class="content">

        <!-- 右侧显示的内容，需要在核实的section标签上添加上 class="active" 字段，需要和左侧导航栏的内容相吻合；此外只有查询信息部分需要额外的修改 -->

        <!-- 添加学生 -->
        <section id="add" class="active">
            <h2>添加学生</h2>
            <form action="http://localhost:8080/FinnalHomework/AddInformation" method="post">
                <input type="text" placeholder="姓名" name="name" />
                <input type="text" placeholder="年龄" name="age" />
                <input type="text" placeholder="学号" name="stdNumber" />
                <select name="major">
                    <option value="" disabled="disabled" selected="selected">请选择所在专业</option>
                    <option value="通信工程">通信工程</option>
                    <option value="电子信息工程">电子信息工程</option>
                    <option value="信息工程">信息工程</option>
                    <option value="广播电视工程">广播电视工程</option>
                </select>
                <button type="submit">确认添加</button>
            </form>
        </section>


        <!-- 删除学生 -->
        <section id="delete">
            <h2>删除学生</h2>
            <form action="http://localhost:8080/FinnalHomework/Delet" method="delete">
                <input type="text" placeholder="学号" name="stdNumber" />
                <button type="submit">确认删除</button>
            </form>
        </section>


        <!-- 修改学生信息 -->
        <section id="modify">
            <h2>修改学生信息</h2>
            <form action="http://localhost:8080/FinnalHomework/Update" method="post">
                <input type="text" placeholder="姓名" name="name" value="" />
                <input type="text" placeholder="年龄" name="age" value="" />
                <input type="text" placeholder="学号" name="stdNumber" value="" />
                <select name="major">
                    <option value="" disabled="disabled" selected="selected">请选择所在专业</option>
                    <option value="通信工程">通信工程</option>
                    <option value="电子信息工程">电子信息工程</option>
                    <option value="信息工程">信息工程</option>
                    <option value="广播电视工程">广播电视工程</option>
                </select>
                <button type="submit">确认修改</button>
            </form>
        </section>
        

        <!-- 查询学生信息 -->
              <%
 			String error=(String)request.getAttribute("error");
          	String error1=(String)request.getAttribute("error1");       	
			if(error!=null)
				out.print(error);
			if(error1!=null)
   			out.print(error1);						
%>
        <section id="search">
          <h2>查找学生信息(姓名/学号可二选一)</h2>
            <form action="http://localhost:8080/FinnalHomework/Select" method="post">
                <input type="text" placeholder="姓名" name="name" value="" />
                <input type="text" placeholder="学号" name="stdNumber" value="" />
                <button type="submit">确认查找</button>
                <%
                Student stu=new Student();
                stu=(Student)request.getAttribute("stu");
                %>
            </form>
                <table>
                    <thead>
                        <caption>查询结果</caption>
                        <tr>
                            <th>姓名</th>
                            <th>年龄</th>
                            <th>学号</th>
                            <th>专业</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${stu.studentname}</td>
                            <td>${stu.age}</td>
                            <td>${stu.studentId}</td>
                            <td>${stu.majors}</td>
                        </tr>
                    </tbody>
                </table>
            <!-- 
                以下信息只在点击查询时有效，其它时候可以忽略
                如果有查询结果就添加如下代码在此处：
                如果有多条记录，请为tbody标签添加多组tr标签
                如果么有记录，则添加如下代码在此处：
            -->
        </section>
    </div>


    <!-- 以下为浏览器js脚本，无需改动 -->
    <script>
        var lis = document.getElementsByTagName("li");
        var content =  document.getElementsByClassName("content")[0];
        for(var i=lis.length; i>0; i--){
            lis[i-1].onclick = function(){
                document.getElementsByTagName("nav")[0].getElementsByClassName("active")[0].className = "";
                this.className = "active";
                content.getElementsByClassName("active")[0].className = "";
                document.getElementById(this.getAttribute("data-id")).className = "active";
            }
        }
    </script>


</body>
</html>