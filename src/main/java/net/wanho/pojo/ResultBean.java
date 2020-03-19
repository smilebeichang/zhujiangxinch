package net.wanho.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
public class ResultBean<T> implements Serializable {

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


	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public T getBean() {
		return bean;
	}

	public void setBean(T bean) {
		this.bean = bean;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
}
