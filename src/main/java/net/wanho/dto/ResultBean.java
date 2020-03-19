package net.wanho.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by songb on 2019/11/4.
 */
public class ResultBean<T> {

    private String returnCode;
    private String returnMessage;

    private T bean;

    private List<T> rows;

    private Long total;

    private Map<String,Object> map;

    /*
    public Long getTotal() {
        if(total==null&&this.rows!=null && this.rows.size()>=0){
            total=(long)this.rows.size();
        }
        return total;
    }


    public List<T> getRows() {
        return rows=rows==null?new ArrayList<T>():rows;
    }
    */

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

    /**
     * javadoc
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
     }
}
