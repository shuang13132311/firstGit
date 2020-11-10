package com.aim.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter("/EncodingFilter") 注解方式
public class EncodingFilter implements Filter {

	private String encoding;
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器销毁了！！！");
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("不好意思,你被过滤器拦截了！！！");
		System.out.println(encoding);
		//设置编码方式
		
		request.setCharacterEncoding(encoding);
		
		
		// pass the request along the filter chain 继续传递请求(放行请求)
		chain.doFilter(request, response);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器开始初始化");	//先执行init方法初始化，再执行doFilter方法，所以code值先被获取，再去doFilter中去使用
		encoding = fConfig.getInitParameter("encoding");	//字符串"encoding"与xml配置文件中encoding对应，意思就是，获取xml文件中encoding的值即utf-8
	}

}
