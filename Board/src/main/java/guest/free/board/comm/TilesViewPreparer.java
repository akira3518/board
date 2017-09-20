package guest.free.board.comm;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TilesViewPreparer implements ViewPreparer{

	@Override
	public void execute(Request request, AttributeContext context) {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		if( StringUtils.containsIgnoreCase(req.getRequestURI(), ".none") ){
			context.putAttribute("none", new Attribute("true"));
		}
	}
}
