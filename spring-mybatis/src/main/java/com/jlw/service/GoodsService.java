package com.jlw.service;

import com.jlw.domain.Goods;
import com.jlw.domain.Sale;

import java.util.List;

public interface GoodsService {
    Goods queryGood(Integer goodId);
    Sale queryNums(Integer gid);
    int setNums(Integer gid);
    Boolean buy(Integer id , Float money);
}
