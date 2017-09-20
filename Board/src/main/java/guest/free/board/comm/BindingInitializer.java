package guest.free.board.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * WebBindingInitializer : 자주 쓰이는 커스텀 형변환의 경우 매번 쓸 때 마다 선언할게 아니라 한번 선언으로 계속 쓸 수 있게 해 줄 수도 있다.
 * 사용법 : 먼저 커스텀 프로퍼티 에디터 클래스를 만든다.
 * 다음으로 WebBindingInitializer 를 구현해서 커스텀 프로퍼티 에디터를 특정 오브젝트와 연결하는 클래스를 만든다.
 * 이 클래스를 빈으로 등록한 다음 AnnotationMethodHandlerAdapter 핸들러의 webBindingInitializer 프로퍼티에 DI 해 주면 된다.]
 * 어차피 이 WebBindingInitializer 는 다른 곳에서 참조해 쓸 일이 없으므로 그냥 바로 프로퍼티로 주입하는 편이 좋다.
 * @author song ji-ho
 */
public class BindingInitializer implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

}
