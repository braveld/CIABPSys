package com.ciabp.idaos;

import java.util.List;

import com.ciabp.models.Qresult;

public interface IQreslutDao {

	public boolean add(Qresult qresult);
	public List<Qresult> listByQ(String qno,String questionno);
	public List<Qresult> listBySql(String sql,Object[] params);
	public boolean delete(String qno,String questionno,String xuanxiang);
	public boolean update(String qno,String questionno,String xuanxiang);
	public boolean adds(String qno,String questionno,String xuanxiang);
}
