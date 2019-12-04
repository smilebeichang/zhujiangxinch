package net.wanho.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 结果返回对象
 * @author michael
 *
 * @param <T>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultBean<T> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6509656654099701456L;
	
	/**
	 * 返回码
	 */
	private String returnCode;
	/**
	 * 返回信息
	 */
	private String returnMessage;

	/**
	 * 返回对象
	 */
	private T bean;

	/**
	 * 返回本页行数
	 */
	private List<T> rows;

	/**
	 * 总条数
	 */
	private Long total;

	private Map<String,Object> map;
	

	

		




}
