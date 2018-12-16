<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改商品</title>
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
		 <label class="layui-form-label">供应商</label>
    	<div class="layui-input-inline">
     	<select name="providerid" lay-filter="provider">
			 		<option value="0">---请选择供应商---</option>
			 		<c:forEach items="${providers }" var="provider">
			  		<option value="${provider.id }" ${provider.id==goods.providerid?'selected':"" }>${provider.providername }</option>
			 		</c:forEach>
        </select>
    	</div>	
    </div>
	<div class="layui-inline">
			<label class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input type="text" name="goodsname" value="${goods.goodsname }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入商品名称" class="layui-input">
			</div>
			<div style="margin-bottom:0px;pupdateing:0px;position:absolute;top: 0px;left:105%" >
			<c:choose>
			<c:when test="${goods.goodsimg!=null&&goods.goodsimg!=''}">
         		<img alt="商品图片" width="220px" id="goods_img" height="270px" style="border-radius:5px" 
         		src="${goods.goodsimg}">
			</c:when>
			<c:otherwise>
			<img alt="商品图片" width="220px" id="goods_img" height="270px" style="border-radius:5px" 
         		src="${pageContext.request.contextPath }/resources/images/defaulttitle.jpg">
			</c:otherwise>
			</c:choose>
       		</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">生产地址</label>
			<div class="layui-input-inline">
				<input type="text" name="produceplace" value="${goods.produceplace }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入生产地址" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">生产编号</label>
			<div class="layui-input-inline">
				 <input type="text" name="productcode" value="${goods.productcode }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入生产编号" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">规格</label>
			<div class="layui-input-inline">
				<input type="text" name="size"  value="${goods.size }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入规格" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">包装</label>
			<div class="layui-input-inline">
				 <input type="text" name="goodspackage"  value="${goods.goodspackage }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入包装" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">销售价格</label>
			<div class="layui-input-inline">
				<input type="text" name="price"  value="${goods.price }"   lay-verify="required/number" autocomplete="off"
				   placeholder="请输入销售价格" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">库存</label>
			<div class="layui-input-inline">
				 <input type="text" name="number"  value="${goods.number }"  lay-verify="required/number" autocomplete="off"
				   placeholder="请输入库存" class="layui-input">
			</div>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">预警库存</label>
			<div class="layui-input-inline">
				<input type="text" name="dangernum"  value="${goods.dangernum }"  lay-verify="required/number" autocomplete="off"
				   placeholder="请输入预警库存" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">批准文号</label>
			<div class="layui-input-inline">
				 <input type="text" name="promitcode"  value="${goods.promitcode }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入批准文号" class="layui-input">
			</div>
			
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">描述</label>
		<div class="layui-input-block">
			 <input type="text" name="description" value="${goods.description }"  lay-verify="required" autocomplete="off"
				   placeholder="请输入商品描述" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item">
		<div class="layui-upload">
			<label class="layui-form-label">商品图片</label>
				<button type="button" class="layui-btn layui-btn-normal " id="test1">选择图片</button>
				<button type="button" class="layui-btn" id="test2">
				 	<i class="layui-icon">&#xe67c;</i>开始上传
				</button>
		</div>
		<input type="hidden" name="goodsimg" id="goodsimg"  class="layui-input">
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
		<button class="layui-btn" lay-submit="" lay-filter="updateGoods">提交</button>
		<button type="reset" class="layui-btn layui-btn-warm">重置</button>
	</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
</body>
<script type="text/javascript">
    layui.use(['form','jquery','layer','upload'],function(){
        var form=layui.form;
        window.aaa=form;
        var laydate=layui.laydate;
        var $=layui.jquery;
        //如果父页面有layer就使用父页的  没有就自己导入
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        //渲染时间选择器
        var upload = layui.upload;
        
        
        //监听提交
        form.on('submit(updateGoods)', function(data){
            var data=$("#frm").serialize();
            //使用ajax提交
            $.ajax({
                url:'${pageContext.request.contextPath }/goods/updateGoods.action',
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
        
       
        
        
        //上传图片
        upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath }/upload/uploadFile.action'
            ,auto: false
            ,accept:'images'
			,acceptMime:'image/*'
            ,field:'mf'
            ,before : function(obj) {
					//预读本地文件示例，不支持ie8
				obj.preview(function(index, file,
						result) {
					$('#goods_img').attr('src', result); //图片链接（base64）
				});
			 }
            ,bindAction: '#test2'
            ,done: function(res){
            	//如果上传失败
				if (res.code > 0) {
					return layer.msg('上传失败');
				}
				//上传成功
				$('#goods_img').attr('src', res.data.src); //图片链接（base64）
				$('#goodsimg').val(res.data.src);
			},
			error : function() {
				//演示失败状态，并实现重传
				var goodsText = $('#goodsText');
				goodsText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs goods-reload">重试</a>');
				goodsText.find('.goods-reload').on(
						'click', function() {
							uploadInst.upload();
						});
			}
          });
    });

  /*   //设置商品图片
    $(function (){
    	 if(${goods.goodsimg}!=null&&${goods.goodsimg}!=""){
        	 $("#goods_img").attr({src:'${pageContext.request.contextPath }'+${goods.goodsimg}});
         }else{
        	 $("#goods_img").attr({src:'${pageContext.request.contextPath }/resources/images/defaulttitle.jpg'});
         }
	}) */
</script>
</html>