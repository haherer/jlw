package com.jlw.domain;

import java.util.Objects;

public class Sale {
    private Integer id;//订单编号
    private Integer gid;//商品编号
    private Integer nums;//商品库存

    public Sale() {}

    public Sale(Integer id, Integer gid, Integer nums) {
        this.id = id;
        this.gid = gid;
        this.nums = nums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", nums=" + nums +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id) && Objects.equals(gid, sale.gid) && Objects.equals(nums, sale.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gid, nums);
    }
}
