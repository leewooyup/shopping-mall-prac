package app.cust;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.ServiceFrame;

public class CustServiceImpl implements ServiceFrame<String, Cust> {
	DaoFrame<String, Cust> dao;
	SqlSession session;
	
	public CustServiceImpl() {
		dao = new CustDaoImpl();
	}

	@Override
	public void register(Cust v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int moidfy(Cust v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cust get(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cust> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
