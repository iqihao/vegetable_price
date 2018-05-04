package net.ioage.vegetable.core.orm;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SuppressWarnings("ALL")
public abstract class BaseDao<B, M extends GenericMapper<B>> {
    @Autowired
    private M m;

    public List<B> select(B b) {
        return m.select(b);
    }

    public List<B> selectAll() {
        return m.selectAll();
    }

    public List<B> selectByExample(Object obj) {
        return m.selectByExample(obj);
    }

    public B selectByPrimaryKey(Object obj) {
        return m.selectByPrimaryKey(obj);
    }

    public List<B> selectByExampleAndRowBounds(Object obj, RowBounds rowBounds) {
        return m.selectByExampleAndRowBounds(obj, rowBounds);
    }

    public List<B> selectByRowBounds(B b, RowBounds rowBounds) {
        return m.selectByRowBounds(b, rowBounds);
    }

    public int selectCount(B b) {
        return m.selectCount(b);
    }

    public int selectCountByExample(Object obj) {
        return m.selectCountByExample(obj);
    }

    public B selectOne(B b) {
        return m.selectOne(b);
    }

    public boolean existsWithPrimaryKey(Object obj) {
        return m.existsWithPrimaryKey(obj);
    }

    public int insert(B b) {
        return m.insert(b);
    }

    public int insertList(List<B> list) {
        return m.insertList(list);
    }

    public int insertSelective(B b) {
        return m.insertSelective(b);
    }

    public int insertUseGeneratedKeys(B b) {
        return m.insertUseGeneratedKeys(b);
    }

    public int updateByExample(B b, Object obj) {
        return m.updateByExample(b, obj);
    }

    public int updateByExampleSelective(B b, Object obj) {
        return m.updateByExampleSelective(b, obj);
    }

    public int updateByPrimaryKey(B b) {
        return m.updateByPrimaryKey(b);
    }

    public int updateByPrimaryKeySelective(B b) {
        return m.updateByPrimaryKeySelective(b);
    }

    public int delete(B b) {
        return m.delete(b);
    }

    public int deleteByExample(Object obj) {
        return m.deleteByExample(obj);
    }

    public int deleteByPrimaryKey(Object obj) {
        return m.deleteByPrimaryKey(obj);
    }

    public B selectFist(B b) {
        List<B> res = m.select(b);
        return CollectionUtils.isEmpty(res) ? null : res.get(0);
    }
}
