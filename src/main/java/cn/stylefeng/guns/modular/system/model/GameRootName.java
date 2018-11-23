package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 游戏房间类型
 * </p>
 *
 * @author stylefeng
 * @since 2018-11-15
 */
@TableName("game_root_name")
public class GameRootName extends Model<GameRootName> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 游戏编码
     */
    private Integer gameCode;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 游戏对于的数据库
     */
    private String gameTable;
    /**
     * 房间倍率
     */
    private Integer rootRate;
    /**
     * 房间名称
     */
    private String rootName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameCode() {
        return gameCode;
    }

    public void setGameCode(Integer gameCode) {
        this.gameCode = gameCode;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameTable() {
        return gameTable;
    }

    public void setGameTable(String gameTable) {
        this.gameTable = gameTable;
    }

    public Integer getRootRate() {
        return rootRate;
    }

    public void setRootRate(Integer rootRate) {
        this.rootRate = rootRate;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "GameRootName{" +
        ", id=" + id +
        ", gameCode=" + gameCode +
        ", gameName=" + gameName +
        ", gameTable=" + gameTable +
        ", rootRate=" + rootRate +
        ", rootName=" + rootName +
        "}";
    }
}
