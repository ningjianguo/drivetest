package com.hnrw.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hnrw.dao.IUser;
import com.hnrw.entity.ExaminationUser;

@Repository
public class UserDaoImpl extends BaseDaoImpl<ExaminationUser> implements IUser{
	
		@Override
		public ExaminationUser isExistUser(ExaminationUser validateUser) {
				String queryHql = "FROM ExaminationUser WHERE userAccountName=? " +
								  "AND userAccountPassword=? AND userRole=?";
				Query query = getSession().createQuery(queryHql).setString(0, validateUser.getUserAccountName())
															        .setString(1, validateUser.getUserAccountPassword())
															        .setString(2, validateUser.getUserRole());
				ExaminationUser user = (ExaminationUser) query.uniqueResult();
			return user == null ? null:user;
	}

		@Override
		public void saveUser(ExaminationUser user){
			save(user);
		}

		@Override
		public void updateUser(ExaminationUser user) {
			update(user);
		}

		@Override
		public void deleteUser(ExaminationUser user) {
			delete(user);
		}

		@Override
		public boolean isExistUserByUserAccountName(String userAccountName) {
			String queryHql = "SELECT COUNT(*) FROM ExaminationUser WHERE userAccountName=?";
			Long count = (Long) getSession().createQuery(queryHql).setString(0, userAccountName).uniqueResult();
			return count.intValue() == 0 ? false:true;
		}
}
