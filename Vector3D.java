public class Vector3D {
    double x;
    double y;
    double z;

    public Vector3D(double init_x, double init_y, double init_z) {
        this.x = init_x;
        this.y = init_y;
        this.z = init_z;
    }

    public static void main (String[] args) {
        Vector3D vector = new Vector3D(1, 2, 3);
        System.out.println(vector.getX());
        System.out.println(vector.getY());
        System.out.println(vector.getZ());
        System.out.println(vector.normalize());
        System.out.println(vector.add(vector));
        System.out.println(vector.multiply(3.0));
        System.out.println(vector.angleBetween(vector));
        System.out.println(vector.crossProduct(new Vector3D(-1, 30, 3)));
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
        return this.x;
    }

    Double getY() {
        return this.y;
    }

    Double getZ() {
        return this.z;
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
