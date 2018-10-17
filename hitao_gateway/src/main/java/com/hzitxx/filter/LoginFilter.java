package com.hzitxx.filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.reflect.UnlockSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.hzitxx.util.JwtTokenUtil;
import com.hzitxx.utils.ServerResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 登陆拦截
 * @author Shinelon
 *
 */
@Configuration
public class LoginFilter extends ZuulFilter{
    /**
     * 执行过滤逻辑操作
     */
	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();  //获取请求上下文对象
		HttpServletRequest request=context.getRequest(); //获取请求对象
		//获取token
		String token=request.getParameter("token");
		//设置返回编码
		context.getResponse().setContentType("application/json;charset=utf-8");
		//空值判断
		if(StringUtils.isEmpty(token)) {
			//拦截
			context.setSendZuulResponse(false);
			//返回信息
			Map<String , Object> map=new HashMap<>();
			map.put("code", 1000);
			map.put("msg", "token不能为空!");
		    context.setResponseBody(JSON.toJSONString(map));
		}
		else {
			try {
				//解析token
				Map<String, Claim> map=JwtTokenUtil.parseToken(token);
				if(map==null) {
					//token不匹配   拦截
					context.setSendZuulResponse(false);
					//返回信息
					Map<String , Object> map1=new HashMap<>();
					map1.put("code", 1000);
					map1.put("msg", "token错误!");
				    context.setResponseBody(JSON.toJSONString(map));
				}
				else {
					//放行
					return null;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
    /**
     * 是否进行过滤  true:过滤，交给网关处理    false:不过滤，不交给风头处理
     */
	@Override
	public boolean shouldFilter() {
		RequestContext context=RequestContext.getCurrentContext();  //获取请求上下文对象
		HttpServletRequest request=context.getRequest(); //获取请求对象
		String uri=request.getRequestURI(); //获取求救路径
		if(uri.contains("/login")) {
			//放行，不过滤
			return false;
		}
		return true;
	}
    /**
     * 过滤顺序   值越小越早执行
     */
	@Override
	public int filterOrder() {
		return 0;
	}
    /**
     * 过滤器类型（pre,routing,post,error）
     */
	@Override
	public String filterType() {
		return FilterType.PRE;
	}

}
