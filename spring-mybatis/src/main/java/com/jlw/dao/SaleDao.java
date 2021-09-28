package com.jlw.dao;

import com.jlw.domain.Sale;

public interface SaleDao {
    Sale selectNums(Integer gid);
    int updateNums(Integer gid);
}
