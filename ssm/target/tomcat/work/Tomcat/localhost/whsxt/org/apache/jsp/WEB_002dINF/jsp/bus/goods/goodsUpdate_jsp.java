/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-08 14:29:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.bus.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class goodsUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<title>修改商品</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/css/metroStyle/metroStyle.css\" type=\"text/css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/css/index.css\">\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery-1.4.4.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/zTree/js/jquery.ztree.core.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/js/selectTree.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body class=\"childrenBody\">\n");
      out.write("<form class=\"layui-form\" method=\"post\" id=\"frm\">\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t<div class=\"layui-inline\">\n");
      out.write("\t\t <label class=\"layui-form-label\">供应商</label>\n");
      out.write("    \t<div class=\"layui-input-inline\">\n");
      out.write("     \t<select name=\"providerid\" lay-filter=\"provider\">\n");
      out.write("\t\t\t \t\t<option value=\"0\">---请选择供应商---</option>\n");
      out.write("\t\t\t \t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </select>\n");
      out.write("    \t</div>\t\n");
      out.write("    </div>\n");
      out.write("\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品名称</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"goodsname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入商品名称\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div style=\"margin-bottom:0px;pupdateing:0px;position:absolute;top: 0px;left:105%\" >\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("       \t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">生产地址</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"produceplace\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.produceplace }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入生产地址\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">生产编号</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"productcode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.productcode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入生产编号\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">规格</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"size\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.size }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入规格\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">包装</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"goodspackage\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodspackage }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入包装\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">销售价格</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"price\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   lay-verify=\"required/number\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入销售价格\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">库存</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"number\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.number }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required/number\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入库存\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">预警库存</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"dangernum\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.dangernum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required/number\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入预警库存\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">批准文号</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"promitcode\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.promitcode }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入批准文号\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<label class=\"layui-form-label\">描述</label>\n");
      out.write("\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t <input type=\"text\" name=\"description\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.description }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入商品描述\" class=\"layui-input\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-upload\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">商品图片</label>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"layui-btn layui-btn-normal \" id=\"test1\">选择图片</button>\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"layui-btn\" id=\"test2\">\n");
      out.write("\t\t\t\t \t<i class=\"layui-icon\">&#xe67c;</i>开始上传\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<input type=\"hidden\" name=\"goodsimg\" id=\"goodsimg\"  class=\"layui-input\">\n");
      out.write("\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">是否可用</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"available\" value=\"1\" title=\"是\" checked=\"\">\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"available\" value=\"0\" title=\"否\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\" style=\"text-align: center;\">\n");
      out.write("\t\t<button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"updateGoods\">提交</button>\n");
      out.write("\t\t<button type=\"reset\" class=\"layui-btn layui-btn-warm\">重置</button>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    layui.use(['form','jquery','layer','upload'],function(){\n");
      out.write("        var form=layui.form;\n");
      out.write("        window.aaa=form;\n");
      out.write("        var laydate=layui.laydate;\n");
      out.write("        var $=layui.jquery;\n");
      out.write("        //如果父页面有layer就使用父页的  没有就自己导入\n");
      out.write("        var layer = parent.layer === undefined ? layui.layer : top.layer;\n");
      out.write("        //渲染时间选择器\n");
      out.write("        var upload = layui.upload;\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        //监听提交\n");
      out.write("        form.on('submit(updateGoods)', function(data){\n");
      out.write("            var data=$(\"#frm\").serialize();\n");
      out.write("            //使用ajax提交\n");
      out.write("            $.ajax({\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/goods/updateGoods.action',\n");
      out.write("                type:'POST',\n");
      out.write("                async:true,    //或false,是否异步\n");
      out.write("                data:data,\n");
      out.write("                timeout:5000,    //超时时间\n");
      out.write("                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text\n");
      out.write("                success:function(data){\n");
      out.write("                \tlayer.msg(data.msg);\n");
      out.write("                    //关闭修改的弹出层\n");
      out.write("                    var updateIndex = parent.layer.getFrameIndex(window.name);\n");
      out.write("                    window.parent.layer.close(updateIndex);\n");
      out.write("                    //刷新父页面的table\n");
      out.write("                    window.parent.tableIns.reload();\n");
      out.write("                },\n");
      out.write("                error:function(xhr,textStatus){\n");
      out.write("                }\n");
      out.write("            })\n");
      out.write("            return false;\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("       \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        //上传图片\n");
      out.write("        upload.render({\n");
      out.write("            elem: '#test1'\n");
      out.write("            ,url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/upload/uploadFile.action'\n");
      out.write("            ,auto: false\n");
      out.write("            ,accept:'images'\n");
      out.write("\t\t\t,acceptMime:'image/*'\n");
      out.write("            ,field:'mf'\n");
      out.write("            ,before : function(obj) {\n");
      out.write("\t\t\t\t\t//预读本地文件示例，不支持ie8\n");
      out.write("\t\t\t\tobj.preview(function(index, file,\n");
      out.write("\t\t\t\t\t\tresult) {\n");
      out.write("\t\t\t\t\t$('#goods_img').attr('src', result); //图片链接（base64）\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t }\n");
      out.write("            ,bindAction: '#test2'\n");
      out.write("            ,done: function(res){\n");
      out.write("            \t//如果上传失败\n");
      out.write("\t\t\t\tif (res.code > 0) {\n");
      out.write("\t\t\t\t\treturn layer.msg('上传失败');\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t//上传成功\n");
      out.write("\t\t\t\t$('#goods_img').attr('src', res.data.src); //图片链接（base64）\n");
      out.write("\t\t\t\t$('#goodsimg').val(res.data.src);\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\terror : function() {\n");
      out.write("\t\t\t\t//演示失败状态，并实现重传\n");
      out.write("\t\t\t\tvar goodsText = $('#goodsText');\n");
      out.write("\t\t\t\tgoodsText.html('<span style=\"color: #FF5722;\">上传失败</span> <a class=\"layui-btn layui-btn-xs goods-reload\">重试</a>');\n");
      out.write("\t\t\t\tgoodsText.find('.goods-reload').on(\n");
      out.write("\t\t\t\t\t\t'click', function() {\n");
      out.write("\t\t\t\t\t\t\tuploadInst.upload();\n");
      out.write("\t\t\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("          });\n");
      out.write("    });\n");
      out.write("\n");
      out.write("  /*   //设置商品图片\n");
      out.write("    $(function (){\n");
      out.write("    \t if(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsimg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("!=null&&");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsimg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("!=\"\"){\n");
      out.write("        \t $(\"#goods_img\").attr({src:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('\'');
      out.write('+');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsimg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("});\n");
      out.write("         }else{\n");
      out.write("        \t $(\"#goods_img\").attr({src:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/images/defaulttitle.jpg'});\n");
      out.write("         }\n");
      out.write("\t}) */\n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/bus/goods/goodsUpdate.jsp(25,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${providers }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /WEB-INF/jsp/bus/goods/goodsUpdate.jsp(25,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("provider");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t  \t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${provider.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${provider.id==goods.providerid?'selected':\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${provider.providername }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\n");
          out.write("\t\t\t \t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/jsp/bus/goods/goodsUpdate.jsp(39,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsimg!=null&&goods.goodsimg!=''}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("         \t\t<img alt=\"商品图片\" width=\"220px\" id=\"goods_img\" height=\"270px\" style=\"border-radius:5px\" \n");
        out.write("         \t\tsrc=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.goodsimg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\">\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<img alt=\"商品图片\" width=\"220px\" id=\"goods_img\" height=\"270px\" style=\"border-radius:5px\" \n");
        out.write("         \t\tsrc=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("/resources/images/defaulttitle.jpg\">\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
