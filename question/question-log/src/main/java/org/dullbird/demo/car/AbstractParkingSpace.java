package org.dullbird.demo.car;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月03日 22:20:00
 */
public abstract class AbstractParkingSpace {
    private long startTime;
    public static AbstractParkingSpace createInstance(CarType type){
        if (CarType.CAR.equals(type)) {
            return new CarSpace();
        } else if (CarType.TRUCK.equals(type)) {
            return new TruckSpace();
        } else {
            throw new IllegalStateException("unsupported type=" + type);
        }
    }
    /**
     * 没小时的花费
     * @return
     */
    abstract long costForAnHour();

    /**
     * 收费上线上限
     * @return
     */
    abstract long maxCost();

    /**
     * 类型
     * @return
     */
    abstract CarType getCarType();
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "AbstractParkingSpace{" +
                "startTime=" + startTime +
                '}';
    }
}
