package net.wanho.pojo;


import java.util.Date;

/**
 * 参数字典对象
 * @author michael
 *
 */
public class DictionaryBean {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8248481289692280526L;
	
	/**
	 * ID
	 */
	private String id;
	
	/**
	 * 父级ID
	 */
	private String  parentId;
	
	/**
	 * 参数编码
	 */
	private String  code;
	
	/**
	 * 参数值
	 */
	private String  value;
	
	/**
	 * 描述
	 */
	private String  description;
	
	/**
	 * 序号
	 */
	private String  orderNo;
	
	/**
	 * 状态
	 */
	private String  status;
	
	/**
	 * 更新日期
	 */
	private Date  updateDate;
	
	/**
	 * 创建日期
	 */
	private Date  createDate;
	
	/**
	 * 参数路径
	 */
	private String codePath;
	
	/**
	 * 是否有子节点
	 * <li>0:NO</li>
	 * <li>1:YES</li>
	 */
	private String hasChild;
	
	/**
	 * 是否可编辑
	 * <li>0:NO</li>
	 * <li>1:YES</li>
	 */
	private String editable;
	/**
	 * 业务类型
	 */
	private Integer bussType;
	
	public String getCodePath() {
		return codePath;
	}
	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getHasChild() {
		return hasChild;
	}
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
	public String getEditable() {
		return editable;
	}
	public void setEditable(String editable) {
		this.editable = editable;
	}
	public Integer getBussType() {
		return bussType;
	}
	public void setBussType(Integer bussType) {
		this.bussType = bussType;
	}
	
}
