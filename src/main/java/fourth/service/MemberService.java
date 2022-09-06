package fourth.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fourth.bean.MemberBean;
import fourth.dao.MemberDao;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao mDao;
	

	// 會員註冊Service
	public MemberBean registerUser(MemberBean newRegister) {
		return mDao.newRegister(newRegister);

	}

	// 會員登入
	public MemberBean checkLogin(String loginAccount, String loginPassword) {
		return mDao.queryAccountAndPassword(loginAccount, loginPassword);
	}

	// 新增會員
	public MemberBean insertUser(MemberBean memberBean) {
		return mDao.insertUser(memberBean);
	}

	// 查詢所有會員
	public List<MemberBean> selectAllMembers() {
		return mDao.selectAllMembers();
	}

	// 刪除會員
	public boolean deleteUser(String account) {
		return mDao.deleteUser(account);
	}

	// 會員更新前找到帳號
	public MemberBean selectUserByAccount(String account) {
		System.out.println("selectuseraccount service");
		return mDao.selectUserByAccount(account);
	}


	// 會員更新
	public MemberBean updateUser(MemberBean memberBean) {
		return mDao.updateUser(memberBean);
	}

	// 會員查詢(帳號)Service
	public List<MemberBean> QueryUserByAccount(String account) {
		return mDao.QueryUserByAccount(account);
	}

	//註冊驗證
	public MemberBean checkRegister(String account, String password, String email) {
		return mDao.queryRegister(account, password,email);
	}

	
}
