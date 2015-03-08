package com.microsys.app.model.entity.customtype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import com.microsys.app.common.customenum.RecordStatusEnum;

public class RecordStatusType implements UserType {

	public final static String USER_TYPE = "com.microsys.app.model.entity.customtype.RecordStatusType";

	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		return null;
	}

	public Object deepCopy(Object arg0) throws HibernateException {
		return arg0;
	}

	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		return arg0.equals(arg1);
	}

	public int hashCode(Object arg0) throws HibernateException {
		return arg0.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet arg0, String[] arg1,
			SessionImplementor arg2, Object arg3) throws HibernateException,
			SQLException {
		final String dbCode = arg0.getString(arg1[0]);
		final RecordStatusEnum recordStatus = RecordStatusEnum
				.getRecordStatusByDBCode(dbCode);
		return recordStatus;
	}

	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2,
			SessionImplementor arg3) throws HibernateException, SQLException {
		if (arg1 == null) {
			arg0.setNull(arg2, Types.VARCHAR);
		} else {
			RecordStatusEnum status = ((RecordStatusEnum) arg1);
			arg0.setString(arg2, status.getDbCode());
		}

	}

	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	public Class<RecordStatusEnum> returnedClass() {
		return RecordStatusEnum.class;
	}

	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return new int[]{Types.VARCHAR};
	}

}
