/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-08 03:21:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.bus.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<title>修改部门</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/css/layui.css\" media=\"all\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/public.css\" media=\"all\" />\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/plugin/css/index.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"childrenBody\">\n");
      out.write("<form class=\"layui-form\" method=\"post\" id=\"frm\">\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">客户名称</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"customername\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.customername }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" lay-verify=\"required\"  placeholder=\"客户名称\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">邮政编号</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"zip\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.zip }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" placeholder=\"邮政编号\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">客户地址</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"name\" lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入客户地址\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">电话</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"telephone\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.telephone }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"loginname\" lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入联系电话\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">联系人</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"connectionperson\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.connectionperson }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  lay-verify=\"required\" autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入练习人\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">联系人电话</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"phone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.phone }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入联系人电话\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">银行</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"bank\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.bank }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"     autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入银行\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">银行账号</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"account\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.account }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"     autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入银行账号\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">邮箱</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入邮箱\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">传真</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t <input type=\"text\" name=\"fax\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.fax }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   autocomplete=\"off\"\n");
      out.write("\t\t\t\t   placeholder=\"请输入传真号\" class=\"layui-input\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\">\n");
      out.write("\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t<label class=\"layui-form-label\">是否可用</label>\n");
      out.write("\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"available\" value=\"1\" title=\"是\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.available==1?'checked':\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"available\" value=\"0\" title=\"否\"  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.available==0?'checked':\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"layui-form-item\" style=\"text-align: center;\">\n");
      out.write("\t\t<button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"updateCustomer\">提交</button>\n");
      out.write("\t\t<button type=\"reset\" class=\"layui-btn layui-btn-warm\">重置</button>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layui/layui.js\"></script>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    layui.use(['form','jquery','layer'],function(){\n");
      out.write("        var form=layui.form;\n");
      out.write("        var laydate=layui.laydate;\n");
      out.write("        var $=layui.jquery;\n");
      out.write("        //如果父页面有layer就使用父页的  没有就自己导入\n");
      out.write("        var layer = parent.layer === undefined ? layui.layer : top.layer;\n");
      out.write("        //监听提交\n");
      out.write("        form.on('submit(updateCustomer)', function(data){\n");
      out.write("            var data=$(\"#frm\").serialize();\n");
      out.write("            //使用ajax提交\n");
      out.write("            $.ajax({\n");
      out.write("                url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/updateCustomer.action',\n");
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
      out.write("    });\n");
      out.write("\n");
      out.write("    \n");
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
}
