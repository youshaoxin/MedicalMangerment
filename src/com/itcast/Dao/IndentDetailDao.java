package com.itcast.Dao;

import java.util.List;

import com.itcast.entity.IndentDetail;

public interface IndentDetailDao {

	void addIndentDetail(IndentDetail indentDetail);

	List<IndentDetail> findByIndentId(String indentid);

}
