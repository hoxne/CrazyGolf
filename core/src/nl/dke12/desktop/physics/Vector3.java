package nl.dke12.desktop.physics;

/**
 * Created by baxie on 15-4-16.
 */

@Deprecated
public class Vector3
{
    public static void main(String[] args)
    {
        Vector3 vector = new Vector3(1,2,3);
        System.out.println(vector);
        vector.add(2,3,4);
        System.out.println(vector +" Addition");
        vector.substract(1,2,3);
        System.out.println(vector + " Substraction");
        vector.scaleI(5);
        System.out.println(vector + " Scaled Vector");

    }

    private double x,y,z;

    public Vector3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public String toString()
    {
        return String.format("[%f, %f, %f]", x, y, z);
    }

    public Vector3 copy()
    {
        return new Vector3(x,y,z);
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public void add(Vector3 v)
    {

    }

    public void add(double x, double y, double z)
    {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    //just call add() with minus x, y, z
    public void substract(Vector3 v)
    {

    }

    public void substract(double x, double y, double z)
    {
        this.x -= x;
        this.y -= y;
        this.z -= z;
    }

    public void scaleI(int scaler)
    {
        this.x = getX()*scaler;
        this.y = getY()*scaler;
        this.z = getZ()*scaler;
    }

    public void scaleD(double scaler)
    {
        this.x = getX()*scaler;
        this.y = getY()*scaler;
        this.z = getZ()*scaler;
    }

    public int dotProduct(Vector3 v)
    {
        return 0;
    }


    public Vector3 crossProduct(Vector3 v)
    {
        return new Vector3();
    }


    public void rotate(int degrees)
    {

    }

    public void normalise()
    {
        if(getX() == 1 && getY() == 1 && getZ() == 1){
            System.out.println("Vector is scaled : " + getX() + getY() + getZ());
        }
        else
            this.x = getX()/getX();
        this.y = getY()/getY();
        this.z = getZ()/getZ();
    }

}
