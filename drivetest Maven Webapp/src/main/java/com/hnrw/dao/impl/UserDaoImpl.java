package com.hnrw.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hnrw.dao.IUser;
import com.hnrw.entity.ExaminationUser;

@Repository
public class UserDaoImpl extends BaseDaoImpl<ExaminationUser> implements IUser{
	
		@Override
		public ExaminationUser isExistUser(ExaminationUser validateUser) {
				String queryHql = "FROM ExaminationUser WHERE userAccountName=USERNAME " +
								  "AND userAccountPassword=USERPASSWORD AND userRole=ROLE";
				Query query = getSession().createQuery(queryHql).setString("USERNAME", validateUser.getUserAccountName())
														        .setString("USERPASSWORD", validateUser.getUserAccountPassword())
														        .setString("ROLE", validateUser.getUserRole());
				ExaminationUser user = (ExaminationUser) query.uniqueResult();
			return user == null ? null:user;
	}
}
