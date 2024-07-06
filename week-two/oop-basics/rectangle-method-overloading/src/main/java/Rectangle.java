public class Rectangle {
  private double width;
  private double height;

  public Rectangle() {
    this(3, 5);
  }

  public Rectangle(double width, double height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive");
    }
    this.width = width;
    this.height = height;
  }

  public final double getWidth() {
    return this.width;
  }

  public final double getHeight() {
    return this.height;
  }

  // TODO: Implement area() method
  public final double area() {
    return this.width * this.height;
  }

  // TODO: Implement overloaded area(double scale) method
  public final double area(double scale) {
    return this.width * this.height * scale * scale;
  }

  // TODO: Implement resize(double factor) method
  public final void resize(double scale) {
    this.width *= scale;
    this.height *= scale;
    System.out.println("New lengths, width: " + this.width + ", height: " + this.height);
  }

  // TODO: Implement overloaded resize(double widthFactor, double heightFactor) method
  public final void resize(double widthFactor, double heightFactor) {
    this.width *= widthFactor;
    this.height *= heightFactor;
    System.out.println(
        "New lengths after resize: \n width: " + this.width + "\n height: " + this.height);
  }

  public final Rectangle resize(double scale, double widthFactor, double heightFactor) {
    Rectangle resizeRectangle = new Rectangle();
    if (scale <= 0) {
      resizeRectangle.width *= scale;
      resizeRectangle.height *= scale;
    } else if (widthFactor <= 0 || heightFactor <= 0) {
      resizeRectangle.width *= widthFactor;
      resizeRectangle.height *= heightFactor;
    } else {
      return null;
    }
    return resizeRectangle;
  }

  public final double perimeter() {
    return 2 * (width + height);
  }

  public final double perimeter(double area, double width, double height) {
    double perimeter = 0;
    // Check what variables are not null or 0
    if (!(area <= 0) && !Double.isNaN(area) && !(width == 0) && !(height == 0)) {
      perimeter = width + height;
    }
    if (!(area <= 0) && !(width == 0)) {
      perimeter = 2 * ((area / width) + width);
    }
    if (!(area <= 0) && !(height == 0)) {
      perimeter = 2 * ((area / height) + width);
    }

    return perimeter;
  }

  // TODO: Implement display() method
  public void display() {
    System.out.println("Width: " + this.width + "\nHeight: " + this.height);
  }

  @Override
  public String toString() {
    return "Rectangle height: "
        + this.height
        + " width: "
        + this.width
        + " perimeter: "
        + this.perimeter();
  }

  public static void main(String[] args) {
    // TODO: Create Rectangle objects and test your methods here
    Rectangle myRectangle = new Rectangle();

    System.out.println("Displaying initialised rectangle");
    myRectangle.display();

    System.out.println("Displaying current area: " + myRectangle.area());

    double scale = 3;
    System.out.println("Scaling rectangle by: " + scale);
    double area = myRectangle.area(scale);
    System.out.println("Scaled area: " + area);

    System.out.println("Resize rectangle by scale of: " + scale);
    myRectangle.resize(scale);

    double widthFactor = 3;
    double heightFactor = 4;
    System.out.println(
        "Overload method resize with scale variables heightFactor: "
            + heightFactor
            + ", widthFactor: "
            + widthFactor);
    myRectangle.resize(widthFactor, heightFactor);
  }
}
