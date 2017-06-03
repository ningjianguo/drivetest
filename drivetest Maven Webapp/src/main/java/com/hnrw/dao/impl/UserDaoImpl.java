package com.hnrw.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hnrw.dao.IUser;
import com.hnrw.entity.ExamUser;

@Repository
public class UserDaoImpl extends BaseDaoImpl<ExamUser> implements IUser{
	
		@Override
		public ExamUser isExistUser(ExamUser validateUser) {
				String queryHql = "FROM ExamUser WHERE userAccountName=? " +
								  "AND userAccountPassword=? AND userRole=?";
				Query query = getSession().createQuery(queryHql).setString(0, validateUser.getUserAccountName())
															        .setString(1, validateUser.getUserAccountPassword())
															        .setInteger(2, validateUser.getUserRole());
				ExamUser user = (ExamUser) query.uniqueResult();
			return user == null ? null:user;
	}

		@Override
		public void saveUser(ExamUser user){
			save(user);
		}

		@Override
		public void updateUser(ExamUser user) {
			getSession().createSQLQuery("UPDATE EXAM_USER SET USER_ACCOUNT_PASSWORD=? WHERE USER_ID=?")
						.setString(0, user.getUserAccountPassword())
						.setString(1, user.getUserId()).executeUpdate();
		}

		@Override
		public void deleteUser(ExamUser user) {
			getSession().createSQLQuery("DELETE FROM EXAM_USER WHERE USER_ID=?")
						.setString(0, user.getUserId()).executeUpdate();
		}

		@Override
		public boolean isExistUserByUserAccountName(String userAccountName) {
			String queryHql = "SELECT COUNT(*) FROM ExamUser WHERE userAccountName=?";
			Long count = (Long) getSession().createQuery(queryHql).setString(0, userAccountName).uniqueResult();
			return count.intValue() == 0 ? false:true;
		}

		@Override
		public List<ExamUser> getUsersByArgs(int pageNo, int pageSize,
				String limitArgs) {
			return getPaging(pageNo, pageSize, limitArgs);
		}

		@Override
		public int getUserCountByArgs(String limitArgs) {
			String querySql = "SELECT COUNT(*) FROM ExamUser "+(limitArgs == null ? "":"WHERE "+limitArgs);
			Long count = (Long) getSession().createQuery(querySql).uniqueResult();
			return count.intValue();
		}
}
