<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加部门</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/public.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/zTree/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/plugin/css/index.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/zTree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/plugin/js/selectTree.js"></script>
</head>
<body class="childrenBody">
<form class="layui-form" method="post" id="frm">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">所在部门</label>
			<div class="layui-input-inline">
				<div id="deptTree" class="select-tree layui-form-select">
            	</div>
				<input type="hidden" id="deptid" name="deptid"  >
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">排序码</label>
			<div class="layui-input-inline">
				<input type="text" name="ordernum" lay-verify="required"  placeholder="排序码" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">领导部门</label>
			<div class="layui-input-inline">
				<div id="userMgrdeptTree" class="select-tree layui-form-select">
            	</div>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">领导名称</label>
			<div class="layui-input-inline">
				 <select name="mgr" id="mgr">
			      </select>
			</div>
		</div>
	</div>
	<div class="layui-form-item">
	<div class="layui-inline">
			<label class="layui-form-label">用户名称</label>
			<div class="layui-input-inline">
				<input type="text" name="name"  onblur="createLoginName(this)" id="name" lay-verify="required" autocomplete="off"
				   placeholder="请输入用户名称" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">登陆名称</label>
			<div class="layui-input-inline">
				 <input type="text" name="loginname" id="loginname" lay-verify="required" autocomplete="off"
				   placeholder="请输入登陆名称" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">用户备注</label>
		<div class="layui-input-block">
			<textarea placeholder="请输入用户备注" name="remark" class="layui-textarea"></textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">用户地址</label>
			<div class="layui-input-inline">
			<input type="text" name="address" lay-verify="required" autocomplete="off"
				   placeholder="请输入用户地址" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">用户性别</label>
			<div class="layui-input-inline">
				<input type="radio" name="sex" value="1" title="男" checked="">
				<input type="radio" name="sex" value="0" title="女">
			</div>
		</div>
		
	</div>
	
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">入职时间</label>
			<div class="layui-input-inline">
				<input type="text" name="hiredate" id="hiredate"  readonly="readonly" lay-verify="required" autocomplete="off"
				   placeholder="请选择入职时间" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">是否可用</label>
			<div class="layui-input-inline">
				<input type="radio" name="available" value="1" title="是" checked="">
				<input type="radio" name="available" value="0" title="否">
			</div>
		</div>
	</div>
	<div class="layui-form-item" style="text-align: center;">
		<button class="layui-btn" lay-submit="" lay-filter="addUser">提交</button>
		<button type="reset" class="layui-btn layui-btn-warm">重置</button>
	</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    layui.use(['form','jquery','layer','laydate'],function(){
        var form=layui.form;
        window.aaa=form;
        var laydate=layui.laydate;
        var $=layui.jquery;
        //如果父页面有layer就使用父页的  没有就自己导入
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        //渲染时间选择器
        laydate.render({
        	elem:'#hiredate'
        })
        
        
        //监听提交
        form.on('submit(addUser)', function(data){
        	//得到treeObj的对象
        	asyncDeptid();
            var data=$("#frm").serialize();
            //使用ajax提交
            $.ajax({
                url:'${pageContext.request.contextPath }/user/addUser.action',
                type:'POST',
                async:true,    //或false,是否异步
                data:data,
                timeout:5000,    //超时时间
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(data){
                	layer.msg(data.msg);
                    //关闭添加的弹出层
                    var addIndex = parent.layer.getFrameIndex(window.name);
                    window.parent.layer.close(addIndex);
                    //刷新父页面的table
                    window.parent.tableIns.reload();
                },
                error:function(xhr,textStatus){
                }
            })
            return false;
        });
    });

    $(function(){
    	var url="${pageContext.request.contextPath }/dept/loadLeftZtree.action"
        	$.post(url,function(zNodes){
        		initSelectTree("deptTree",zNodes, false);
        		initSelectTree("userMgrdeptTree",zNodes, false);
        		//必须是树初始化完成之后才会加事件
       		   $(".layui-nav-item a").bind("click", function () {
       	            if (!$(this).parent().hasClass("layui-nav-itemed") && !$(this).parent().parent().hasClass("layui-nav-child")) {
       	                $(".layui-nav-tree").find(".layui-nav-itemed").removeClass("layui-nav-itemed")
       	            }
       	        })
        	})
    })
    function asyncDeptid(){
    	var treeObj = $.fn.zTree.getZTreeObj("deptTreeTree");
    	//得到id的值
    	var node=treeObj.getSelectedNodes();
    	$("#deptid").val(node[0].id);
    }
    
    function initUserMrg(deptid){
    	//使用部门ID查询这个部门下的员工
    	var url="${pageContext.request.contextPath }/user/loadAllUserByDeptId.action"
    	$.post(url,{deptid:deptid},function(json){
    		var mgr=$("#mgr");
    		var html="";
    		if(json!=null){
    			for (var i = 0; i < json.length; i++) {
    				html+="<option value="+json[i].id+">"+json[i].name+"</option>";
				}
    		}
    		mgr.html(html);
    		//重新select
    		window.aaa.render("select");
    	})
    }
    //自动得到用户名的全拼
    function createLoginName(obj){
    	//得到用户名
    	var username=$(obj).val();
    	var url="${pageContext.request.contextPath }/user/createLoginName.action"
    	$.post(url,{name:username},function(str){
    		$("#loginname").val(str);
    	})
    }
</script>
</html>