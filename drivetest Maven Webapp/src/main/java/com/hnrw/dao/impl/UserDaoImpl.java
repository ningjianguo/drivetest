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
}
