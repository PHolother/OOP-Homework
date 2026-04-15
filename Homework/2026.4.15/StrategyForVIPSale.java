public enum StrategyForVIPSale {
    BRONZE {
        @Override
        public double getDiscount(double price) {
            return price * 0.95; // 95折
        }
    },
    SILVER {
        @Override
        public double getDiscount(double price) {
            return price * 0.88; // 88折
        }
    },
    GOLD {
        @Override
        public double getDiscount(double price) {
            return price * 0.80; // 8折
        }
    },
    DIAMOND {
        @Override
        public double getDiscount(double price) {
            return price * 0.70; // 7折
        }
    };

    public abstract double getDiscount(double price);
}

// 使用：根据会员等级自动计算折扣价，无需 if/else
// double finalPrice = VIPSale.GOLD.getDiscount(1000);

class SaleTest {
    public static void main(String[] args) {
        double originalPrice = 10000D;

        System.out.println("商品原价：" + originalPrice);

        // 铜牌会员
        double bronzePrice = StrategyForVIPSale.BRONZE.getDiscount(originalPrice);
        System.out.println("铜牌会员折后价：" + bronzePrice);

        // 银牌会员
        double silverPrice = StrategyForVIPSale.SILVER.getDiscount(originalPrice);
        System.out.println("银牌会员折后价：" + silverPrice);

        // 金牌会员
        double goldPrice = StrategyForVIPSale.GOLD.getDiscount(originalPrice);
        System.out.println("金牌会员折后价：" + goldPrice );

        // 钻石会员
        double diamondPrice = StrategyForVIPSale.DIAMOND.getDiscount(originalPrice);
        System.out.println("钻石会员折后价：" + diamondPrice);

        // 输出折扣价格
        System.out.println("\n假设当前用户等级为金");  // 假设从数据库或前端获取
        String userLevel = "GOLD";
        StrategyForVIPSale level = StrategyForVIPSale.valueOf(userLevel);
        double finalPrice = level.getDiscount(originalPrice);
        System.out.println("当前用户等级：" + level);
        System.out.println("最终支付金额：" + finalPrice + "元");
    }
}