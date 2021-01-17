package com.formaciondi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PostTiempoTranscurridoFilter extends ZuulFilter{
	
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
		
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("Entrando a post filter");
		
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTransucrrido = tiempoFinal - tiempoInicio;
		
		log.info(String.format("Tiempo transucrrido en segundos %s seg.", tiempoTransucrrido.doubleValue()/1000.00));
		log.info(String.format("Tiempo transucrrido en milisegundos %s ms.", tiempoTransucrrido));
		return null;
	}

	/**
	 * tipo de filtro "post"
	 */
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
