package com.hnrw.dao.impl;

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
															        .setString(2, validateUser.getUserRole());
				ExamUser user = (ExamUser) query.uniqueResult();
			return user == null ? null:user;
	}

		@Override
		public void saveUser(ExamUser user){
			save(user);
		}

		@Override
		public void updateUser(ExamUser user) {
			update(user);
		}

		@Override
		public void deleteUser(ExamUser user) {
			delete(user);
		}

		@Override
		public boolean isExistUserByUserAccountName(String userAccountName) {
			String queryHql = "SELECT COUNT(*) FROM ExamUser WHERE userAccountName=?";
			Long count = (Long) getSession().createQuery(queryHql).setString(0, userAccountName).uniqueResult();
			return count.intValue() == 0 ? false:true;
		}
}
