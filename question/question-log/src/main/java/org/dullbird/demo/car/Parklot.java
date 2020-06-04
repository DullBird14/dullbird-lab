package org.dullbird.demo.car;

import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.dullbird.demo.car.CarType.CAR;
import static org.dullbird.demo.car.CarType.TRUCK;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月03日 22:17:00
 */
public class Parklot {
    private Map<CarType, List<AbstractParkingSpace>> spaceMap = new HashMap<>();
    private Map<String, AbstractParkingSpace> alreadyUsedSpacesMap = new HashMap<>();
    private int carSpaceNumber;
    private int truckSpaceNumber;

    /**
     * 一小时的毫秒值
     */
    private static final long ONE_HOUR_TIME_MILLIS = 60 * 60 * 1000;

    public Parklot(int carSpaceNumber, int truckSpaceNumber) {
        if (carSpaceNumber == 0 && truckSpaceNumber == 0) {
            throw new IllegalStateException("停车场不能为空");
        }
        this.carSpaceNumber = carSpaceNumber;
        this.truckSpaceNumber = truckSpaceNumber;
        init();
    }

    private void init() {
        ArrayList<AbstractParkingSpace> carSpaces = new ArrayList<>();
        for (int i = 0; i < carSpaceNumber; i++) {
            carSpaces.add(AbstractParkingSpace.createInstance(CAR));
        }
        ArrayList<AbstractParkingSpace> truckSpaces = new ArrayList<>();
        for (int i = 0; i < truckSpaceNumber; i++) {
            carSpaces.add(AbstractParkingSpace.createInstance(CAR));
        }
        spaceMap.putIfAbsent(TRUCK, truckSpaces);
        spaceMap.putIfAbsent(CAR, carSpaces);
    }

    public static void main(String[] args) {
        Parklot parklot = new Parklot(5, 5);
        parklot.dealCarJoin(CAR, "110");
        System.out.println(parklot.leaveCar("110"));
    }

    public long leaveCar(String carNo) {
        AbstractParkingSpace space = alreadyUsedSpacesMap.remove(carNo);
        Calendar startTime = Calendar.getInstance();
        startTime.setTimeInMillis(space.getStartTime());
//        startTime.set(Calendar.HOUR_OF_DAY, 20);
        startTime.set(Calendar.DAY_OF_MONTH, 1);
        Calendar leaveTime = Calendar.getInstance();
        long differDay = ChronoUnit.DAYS.between(startTime.toInstant(), leaveTime.toInstant());
        if (differDay > 0) {
            //跨天金额计算
            Calendar startTimeNight = modifyCalendarTime(startTime, 23, 59, 59);
            long startDayCost = calculateOneDayCost(space, startTime, startTimeNight);
            Calendar leaveTimeMorning = modifyCalendarTime(leaveTime, 0, 0, 0);
            long endDayCost = calculateOneDayCost(space, leaveTimeMorning, leaveTime);
            long total = (differDay - 1) * space.maxCost() + startDayCost + endDayCost;
            spaceMap.get(space.getCarType()).add(AbstractParkingSpace.createInstance(space.getCarType()));
            return total;
        }
        //当天计算
        long differHour = ChronoUnit.HOURS.between(startTime.toInstant(), leaveTime.toInstant());
        long ceil = differHour + 1;
        spaceMap.get(space.getCarType()).add(AbstractParkingSpace.createInstance(space.getCarType()));
        return Math.min(space.costForAnHour() * ceil, space.maxCost());
    }


    private Calendar modifyCalendarTime(Calendar startTime,
                                        int hour, int minute, int second) {
        Calendar startTimeNight = Calendar.getInstance();
        startTimeNight.setTimeInMillis(startTime.getTimeInMillis());
        startTimeNight.set(Calendar.HOUR_OF_DAY, hour);
        startTimeNight.set(Calendar.MINUTE, minute);
        startTimeNight.set(Calendar.SECOND, second);
        return startTimeNight;
    }

    private long calculateOneDayCost(AbstractParkingSpace space, Calendar startTime, Calendar leaveTime) {
        long differHour = ChronoUnit.HOURS.between(startTime.toInstant(), leaveTime.toInstant());
        long ceil = differHour + 1;
        return Math.min(ceil * space.costForAnHour(), space.maxCost());
    }

    public AbstractParkingSpace dealCarJoin(CarType type, String carNo) {
        List<AbstractParkingSpace> parkingSpaces = spaceMap.get(type);
        if (!Objects.isNull(parkingSpaces)
                && parkingSpaces.size() > 0) {
            AbstractParkingSpace space = parkingSpaces.remove(0);
            space.setStartTime(System.currentTimeMillis());
            alreadyUsedSpacesMap.put(carNo, space);
            return space;
        }
        throw new IllegalStateException("have no space!");
    }
}

