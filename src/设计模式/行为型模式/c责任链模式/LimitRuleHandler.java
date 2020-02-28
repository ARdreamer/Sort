package 设计模式.行为型模式.c责任链模式;

public class LimitRuleHandler extends RuleHandler {
    public void apply(Context context) {
        ActivityService activityService = new ActivityService();
        int remainedTimes = activityService.queryRemainedTimes(context); // 查询剩余奖品
        if (remainedTimes > 0) {
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("您来得太晚了，奖品被领完了");
        }
    }

}
