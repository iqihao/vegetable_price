package net.ioage.vegetable.core.orm;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@SuppressWarnings("ALL")
public interface GenericMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
