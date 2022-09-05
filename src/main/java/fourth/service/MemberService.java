package fourth.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fourth.bean.MemberBean;
import fourth.dao.MemberDao;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao mDao;
	
	public MemberService() {
		//this.mDao=new MemberDao();
	}

	public MemberBean checkLogin(String loginAccount, String loginPassword)  {
		return mDao.queryAccountAndPassword(loginAccount, loginPassword);
	}

	
	public MemberBean insertUser(MemberBean memberBean) {
		return mDao.insertUser(memberBean);
	}

	public List<MemberBean> selectAllMembers() {
		return mDao.selectAllMembers();
	}

	public boolean deleteUser(String account) {
		return mDao.deleteUser(account);
	}

	public MemberBean selectUserByAccount(String account) {
		System.out.println("selectuseraccount service");
		return mDao.selectUserByAccount(account);
	}

	public MemberBean updateUser(MemberBean memberBean) {
				return mDao.updateUser(memberBean);
	}
		

	public MemberBean registerUser(MemberBean newRegister) {
		return mDao.newRegister(newRegister);
		
	}

	public List<MemberBean> QueryUserByAccount(String account) {
		return mDao.QueryUserByAccount(account);
	}

	
}
