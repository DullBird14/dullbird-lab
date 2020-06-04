package org.dullbird.demo.car;

import static org.dullbird.demo.car.CarType.CAR;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月03日 23:22:00
 */
class CarSpace extends AbstractParkingSpace {

    @Override
    long costForAnHour() {
        return 5;
    }

    @Override
    long maxCost() {
        return 60;
    }

    @Override
    CarType getCarType() {
        return CAR;
    }
}
