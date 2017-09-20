package guest.free.board.comm;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 컨트롤러 메소드 Map param을 처리하기 위한 클래스
 * @author song ji-ho
 */
public class MapArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mvc, NativeWebRequest webRequest,
			WebDataBinderFactory wdbf) throws Exception {
		
		if( methodParameter.getParameterType().equals(Map.class) ){
			Map<String, Object> paramMap = new HashMap<String, Object>();
			HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

			Enumeration<?> enumeration = request.getParameterNames();
 
			while(enumeration.hasMoreElements()){
				String key = (String) enumeration.nextElement();
				String[] values = request.getParameterValues(key);
				if(values!=null){
					paramMap.put(key, (values.length > 1) ? values : values[0]);
				}
			}

			return paramMap;
		}
		
		return new HashMap<String, Object>();
	}

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return Map.class.isAssignableFrom(methodParameter.getParameterType());
	}
}
