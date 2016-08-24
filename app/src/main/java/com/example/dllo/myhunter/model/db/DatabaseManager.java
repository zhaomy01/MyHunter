package com.example.dllo.myhunter.model.db;

import com.example.dllo.myhunter.app.MyApp;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import java.util.List;

/**
 * 数据库  工具类
 */
public class DatabaseManager {

    private static LiteOrm liteOrm;
    private static DatabaseManager ourInstance = new DatabaseManager();

    private DatabaseManager() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newCascadeInstance(MyApp.getContext(), "myhunter.db");
        }
    }

    public static DatabaseManager getOurInstance() {
        return ourInstance;
    }

    /**
     * 插入一条记录
     */
    public <T> long insert(T t) {
        return liteOrm.save(t);
    }

    /**
     * 插入所有记录
     */
    public <T> List<T> getQueryAll(Class<T> clas) {
        return liteOrm.query(clas);
    }

    /**
     * 查询  某字段 等于 Value的值
     */
    public <T> List<T> getQueryByWhereLength(Class<T> clas, String field, String[] value, int start, int length) {
        return liteOrm.<T>query(new QueryBuilder(clas).where(field + "=?", value).limit(start, length));
    }

    /**
     * 删除一个数据
     */
    public <T> void delete(T t) {
        liteOrm.delete(t);
    }

    /**
     * 删除一个表
     */
    public <T> void delete(Class<T> clas){
        liteOrm.delete(clas);
    }

    /**
     * 删除集合中的数据
     */
    public <T> void deleteList(List<T> list){
        liteOrm.delete(list);
    }

}
