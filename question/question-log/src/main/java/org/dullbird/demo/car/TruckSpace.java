package org.dullbird.demo.car;

import static org.dullbird.demo.car.CarType.TRUCK;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月03日 23:23:00
 */
class TruckSpace extends AbstractParkingSpace {

    @Override
    long costForAnHour() {
        return 10;
    }

    @Override
    long maxCost() {
        return 120;
    }

    @Override
    CarType getCarType() {
        return TRUCK;
    }
}
