package com.uuider.mappers.jfreechart;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uuider.model.jfreechart.Xzqh;

/**
 * @author  <a href="mailto:xingsan.zhang@gmail.com">zhangpl</a>
 * @version 2015年7月5日
 */
@Repository
public interface XzqhMapper {
	/** 得到省级 */
	public List<Xzqh> getProvince();
}
