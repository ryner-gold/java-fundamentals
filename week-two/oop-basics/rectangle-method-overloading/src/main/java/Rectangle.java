import java.awt.geom.Area;

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

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }

  // TODO: Implement area() method
  public double area() {
    return this.width * this.height;
  }

  // TODO: Implement overloaded area(double scale) method
  public double overloadArea(double scale) {
    return this.width * this.height * scale * scale;
  }

  // TODO: Implement resize(double factor) method
  public void resize(double scale) {
    this.width *= scale;
    this.height *= scale;
    System.out.println("New lengths, width: " + this.width + ", height: " + this.height);
  }

  // TODO: Implement overloaded resize(double widthFactor, double heightFactor) method
  public void resize(double widthFactor, double heightFactor) {
    this.width *= widthFactor;
    this.height *= heightFactor;
    System.out.println(
        "New lengths after resize: \n width: " + this.width + "\n height: " + this.height);
  }

  public double perimeter(){
    return 2*(width + height);
  }

  public double perimeter(double area, double width, double height) {
    double perimeter = 0;
    // Check what variables are not null or 0
    if (area == 0 || Double.isNaN(area)) {
      return 0;
    } else if (width == 0 && height == 0){
      return 0;
    } else if (width == 0){
        return 2*((area / height) + width);
    } else if (height == 0){
        return 2*((area / width) + height);
    }
    return perimeter;
  }

  // TODO: Implement display() method
  public void display() {
    System.out.println("Width: " + this.width + "\nHeight: " + this.height);
  }

  public static void main(String[] args) {
    // TODO: Create Rectangle objects and test your methods here
    Rectangle myRectangle = new Rectangle();

    System.out.println("Displaying initialised rectangle");
    myRectangle.display();

    System.out.println("Displaying current area: " + myRectangle.area());

    double scale = 3;
    System.out.println("Scaling rectangle by: " + scale);
    myRectangle.overloadArea(scale);

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
