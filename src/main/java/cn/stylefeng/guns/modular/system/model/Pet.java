package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 宠物管理表
 * </p>
 *
 * @author zhao
 * @since 2019-01-11
 */
@TableName("sys_pet")
public class Pet extends Model<Pet> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String pname;
    private String pgender;
    private String page;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Pet{" +
        ", id=" + id +
        ", pname=" + pname +
        ", pgender=" + pgender +
        ", page=" + page +
        "}";
    }
}
