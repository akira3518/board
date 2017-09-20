package guest.free.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import guest.free.board.dao.GuestBoardDAO;

@Service("guestBoardService")
public class GuestBoardService extends EgovAbstractServiceImpl {
	
	@Resource(name="guestBoardDAO")
	private GuestBoardDAO guestBoardDAO;
	
}
