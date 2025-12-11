public class Display {
  private final int width;
  private final int height;
  private final float ppi;
  private final String model;

  public Display(int width, int height, float ppi, String model) {
    this.width = width;
    this.height = height;
    this.ppi = ppi;
    this.model = model;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public float getPpi() {
    return ppi;
  }

  public String getModel() {
    return model;
  }

  public void compareSize(Display m) {
    int thisPixels = this.width * this.height;
    int otherPixels = m.width * m.height;

    if (thisPixels > otherPixels) {
      System.out.println(this.model + " has a larger display than " + m.model);
    } else if (thisPixels < otherPixels) {
      System.out.println(this.model + " has a smaller display than " + m.model);
    } else {
      System.out.println(this.model + " and " + m.model + " have the same display size.");
    }
  }

  public void compareSharpness(Display m) {
    if (ppi > m.ppi) {
      System.out.println(this.model + " has a sharper display than " + m.model);
    } else if (ppi < m.ppi) {
      System.out.println(this.model + " has a less sharp display than " + m.model);
    } else {
      System.out.println(this.model + " and " + m.model + " have the same display sharpness.");
    }
  }
  
  public void compareWithMonitor(Display m) {
    compareSize(m);
    compareSharpness(m);
  }
}
