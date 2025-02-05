public sealed interface Shape
        permits Square, Circle {

    double surface();
}

