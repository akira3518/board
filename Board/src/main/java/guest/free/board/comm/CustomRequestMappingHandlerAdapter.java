package guest.free.board.comm;

import java.util.ArrayList;

import org.springframework.web.method.annotation.MapMethodProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * 컨트롤러 메소드 Map param을 처리하기 위한 클래스
 * @author song ji-ho
 */
public class CustomRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {
	@Override
    public void afterPropertiesSet() {
		super.afterPropertiesSet();

		if(getArgumentResolvers() != null){
			ArrayList<HandlerMethodArgumentResolver> list = new ArrayList<HandlerMethodArgumentResolver>(getArgumentResolvers().getResolvers());

			MapMethodProcessor mapMethodProcessor = null;
			int size = list.size();
			for(int i = 0; i < size; i++){
				HandlerMethodArgumentResolver resolver = list.get(i);
				if(resolver instanceof MapMethodProcessor){
					mapMethodProcessor = (MapMethodProcessor)list.remove(i);
					break;
				}
			}
			
			if(mapMethodProcessor != null){
				for(int i = 1; i < size; i++){
					HandlerMethodArgumentResolver resolver = list.get(i);
					if(resolver instanceof MapArgumentResolver){
						if(i + 1 < size){
							list.add(i+1, mapMethodProcessor);
						}else{
							list.add(i, mapMethodProcessor);
						}
						break;
					}
				}
			}
			
			setArgumentResolvers(list);
		}
    }
}
