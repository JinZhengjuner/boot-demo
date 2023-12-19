package com.example.demo.controller.test;

import java.util.HashMap;
import java.util.Map;

public enum StockFlowBizType {

    SALE_ORDER_LOCK(1, "销售订单预占", 1),
    SALE_ORDER_UNLOCK(2, "销售订单释放", 2),
    SALE_ORDER_UNLOCK_RELEASE(3, "销售订单释放出库", 3),
    ERP_STOCK_SYNC(4, "ERP库存同步", 4),
    GOODS_INFO_CHANGE(5, "商品设置变更", 5),
    MANUAL_OPERATION(6, "手动修改库存", 6),
    QNH_STOCK_LOG(7, "老牵牛花库存日志", 7);

    private final int val;
    private final String desc;
    private final int order;
    private static Map<Integer, StockFlowBizType> map = new HashMap();

    private StockFlowBizType(int val, String desc, int order) {
        this.val = val;
        this.desc = desc;
        this.order = order;
    }

    public static StockFlowBizType valueOf(int val) {
        return (StockFlowBizType)map.get(val);
    }

    public int getVal() {
        return this.val;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getOrder() {
        return this.order;
    }

    public static Map<Integer, StockFlowBizType> getMap() {
        return map;
    }

    static {
        StockFlowBizType[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            StockFlowBizType entry = var0[var2];
            map.put(entry.val, entry);
        }

    }
}
