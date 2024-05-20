package sealedxample;

public sealed  class Vechile  permits Car, Truck,Bike{
}

non-sealed class Car extends Vechile{

}

final class Truck extends Vechile{

}

sealed abstract class Bike extends Vechile permits Scotty{
    abstract void print();
}

final class Scotty extends Bike{

    @Override
    void print() {

    }
}
