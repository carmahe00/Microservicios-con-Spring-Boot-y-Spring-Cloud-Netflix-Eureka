package com.formaciondi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juan
 * ZuulFilter registra como filtro de zuul
 */
@Component
@Slf4j
public class PreTiempoTranscurridoFilter extends ZuulFilter{

	/**
	 * método para ajecutar el filtro
	 * @return true | false si se ejecuta este filtro
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		//atravez del contexto obtenmos el request
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		//guarda tiempo de inicio como "tiempoInicio"
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		
		return null;
	}

	/**
	 * definimos el tipo de filtro "Pre"
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * orden del filtro
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

	
}
