package net.wanho.pojo;


import java.util.Date;

/**
 * 同义词实体
 * @author michael
 *
 */
public class RbSynonymConfigBean  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4988981933595130347L;

	/**
	 * 编码
	 */
	private String code;
	
	/**
	 * 同义词列表（,号隔开）
	 */
	private String words;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 创建者
	 */
	private String createrCode;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 遇到此词触发自定义方法
	 */
	private String method;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreaterCode() {
		return createrCode;
	}
	public void setCreaterCode(String createrCode) {
		this.createrCode = createrCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
}
