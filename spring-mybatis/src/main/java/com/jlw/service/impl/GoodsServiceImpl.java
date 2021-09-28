package com.jlw.service.impl;

import com.jlw.dao.GoodsDao;
import com.jlw.dao.SaleDao;
import com.jlw.domain.Goods;
import com.jlw.domain.Sale;
import com.jlw.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public Goods queryGood(Integer goodId) {
        Goods good = goodsDao.selectGood(goodId);
        return good;
    }

    @Override
    public Sale queryNums(Integer gid) {
        return saleDao.selectNums(gid);
    }

    @Override
    public int setNums(Integer gid) {
        return saleDao.updateNums(gid);
    }

    @Override
    public Boolean buy(Integer id, Float money) {

        //通过ID查询商品价格
        Goods goods = goodsDao.selectGood(id);
        Float price = goods.getPrice();
        //通过ID查询商品库存
        Sale sale = saleDao.selectNums(id);
        Integer nums = sale.getNums();
        //判断价格是否足够,判断库存是否足够
        if (nums <= 0) {
            System.out.println("库存不足");
            System.out.println("当前库存:" + nums);
            return false;
        }
        if (money < price) {
            System.out.println("金额不足");
            return false;
        }
        //库存足够，返回购买成功
        saleDao.updateNums(id);
        System.out.println("购买成功");
        return true;
    }
}
