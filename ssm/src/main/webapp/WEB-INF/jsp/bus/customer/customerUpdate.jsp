<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改部门</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/public.css" media="all" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/plugin/css/index.css">
</head>
<body class="childrenBody">
<form class="layui-form" method="post" id="frm">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">客户名称</label>
			<div class="layui-input-inline">
				<input type="text" name="customername" value="${customer.customername }" lay-verify="required"  placeholder="客户名称" autocomplete="off" class="layui-input">
			</div>
			<input type="hidden" name="id" value="${customer.id }">
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">邮政编号</label>
			<div class="layui-input-inline">
				<input type="text" name="zip" value="${customer.zip }" placeholder="邮政编号" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">客户地址</label>
			<div class="layui-input-inline">
				<input type="text" name="address" value="${customer.address }" id="name" lay-verify="required" autocomplete="off"
				   placeholder="请输入客户地址" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-inline">
				 <input type="text" name="telephone"  value="${customer.telephone }" id="loginname" lay-verify="required" autocomplete="off"
				   placeholder="请输入联系电话" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">联系人</label>
			<div class="layui-input-inline">
				<input type="text" name="connectionperson"  value="${customer.connectionperson }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入练习人" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">联系人电话</label>
			<div class="layui-input-inline">
				 <input type="text" name="phone" value="${customer.phone }"   autocomplete="off"
				   placeholder="请输入联系人电话" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">银行</label>
			<div class="layui-input-inline">
				<input type="text" name="bank" value="${customer.bank }"     autocomplete="off"
				   placeholder="请输入银行" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">银行账号</label>
			<div class="layui-input-inline">
				 <input type="text" name="account" value="${customer.account }"     autocomplete="off"
				   placeholder="请输入银行账号" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-inline">
				<input type="text" name="email" value="${customer.email }"   autocomplete="off"
				   placeholder="请输入邮箱" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">传真</label>
			<div class="layui-input-inline">
				 <input type="text" name="fax" value="${customer.fax }"   autocomplete="off"
				   placeholder="请输入传真号" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">是否可用</label>
			<div class="layui-input-inline">
				<input type="radio" name="available" value="1" title="是" ${customer.available==1?'checked':"" }>
				<input type="radio" name="available" value="0" title="否"  ${customer.available==0?'checked':"" }>
			</div>
		</div>
	</div>
	<div class="layui-form-item" style="text-align: center;">
		<button class="layui-btn" lay-submit="" lay-filter="updateCustomer">提交</button>
		<button type="reset" class="layui-btn layui-btn-warm">重置</button>
	</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    layui.use(['form','jquery','layer'],function(){
        var form=layui.form;
        var laydate=layui.laydate;
        var $=layui.jquery;
        //如果父页面有layer就使用父页的  没有就自己导入
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        //监听提交
        form.on('submit(updateCustomer)', function(data){
            var data=$("#frm").serialize();
            //使用ajax提交
            $.ajax({
                url:'${pageContext.request.contextPath }/customer/updateCustomer.action',
                type:'POST',
                async:true,    //或false,是否异步
                data:data,
                timeout:5000,    //超时时间
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(data){
                	layer.msg(data.msg);
                    //关闭修改的弹出层
                    var updateIndex = parent.layer.getFrameIndex(window.name);
                    window.parent.layer.close(updateIndex);
                    //刷新父页面的table
                    window.parent.tableIns.reload();
                },
                error:function(xhr,textStatus){
                }
            })
            return false;
        });
    });

    
</script>
</html>