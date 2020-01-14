package lookid.server.dto;

public class ChildDTO {
   int c_pid;
   String c_name;
   double x;
   float y;

   public int getC_pid() {
      return c_pid;
   }

   public void setC_pid(int c_pid) {
      this.c_pid = c_pid;
   }

   public String getC_name() {
      return c_name;
   }

   public void setC_name(String c_name) {
      this.c_name = c_name;
   }

   public double getX() {
      return x;
   }

   public void setX(double x) {
      this.x = x;
   }

   public float getY() {
      return y;
   }

   public void setY(float y) {
      this.y = y;
   }

   @Override
   public String toString() {
      return "ChildDTO [c_pid=" + c_pid + ", c_name=" + c_name + ", x=" + x + ", y=" + y + "]";
   }

}