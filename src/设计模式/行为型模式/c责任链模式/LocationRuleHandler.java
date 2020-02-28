package 设计模式.行为型模式.c责任链模式;


public class LocationRuleHandler extends RuleHandler {
    public void apply(Context context) {
        ActivityService activityService = new ActivityService();
        boolean allowed = activityService.isSupportedLocation(context.getLocation);
        if (allowed) {
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("非常抱歉，您所在的地区无法参与本次活动");
        }
    }

}
