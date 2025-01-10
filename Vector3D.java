public class Vector3D {
    double x;
    double y;
    double z;

    public Vector3D(double x, double y, double z) {
        x = this.x;
        y = this.y;
        z = this.z;
    }

    @Override
    public String toString() {
        return "(" +
                String.format("%.2f", x) + ", " +
                String.format("%.2f", y) + ", " +
                String.format("%.2f", z) +
            ")";
    }

    Double getX() {
        System.out.println(x);
        return x;
    }

    Double getY() {
        System.out.println(y);
        return y;
    }

    Double getZ() {
        System.out.println(z);
        return z;
    }

    Double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    Vector3D normalize() {
        if (getMagnitude() > 0) {
            return new Vector3D(
                    this.x / getMagnitude(),
                    this.y / getMagnitude(),
                    this.z / getMagnitude()
            );
        }
        else {
            throw new IllegalStateException("Cannot normalize if vector magnitude is zero!");
        }
    }

    Vector3D add(Vector3D other) {
        return new Vector3D(
                this.x + other.x,
                this.y + other.y,
                this.z + other.z
        );
    }

    Vector3D multiply(Double constant) {
        return new Vector3D(
                constant * this.x,
                constant * this.y,
                constant * this.z
        );
    }

    Double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    Double angleBetween(Vector3D other) {
        return Math.acos(dotProduct(other) / (this.getMagnitude() * other.getMagnitude()));
    }

    Vector3D crossProduct(Vector3D other) {
        return new Vector3D(
                this.y * other.z - other.y * this.z,
                this.x * other.z - other.x * this.z,
                this.x * other.y - other.x * this.y
        );
    }
}