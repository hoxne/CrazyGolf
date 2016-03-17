package nl.dke13.physics;

import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class Physics
{
    private ArrayList<Ball> Balls;
    private ArrayList<StaticObject> staticObjects;
    private Vector3 minVelocity = new Vector3(1f,1f,0f);
    private ModelBatch renderer;
    private int i;

    public Physics(ModelBatch renderer, ArrayList<Ball> Balls, ArrayList<StaticObject> staticObjects)
    {
        this.Balls = Balls;
        this.staticObjects = staticObjects;
        this.renderer = renderer;
        i = 0;
    }

    public void render()
    {
        for(Ball ball : Balls)
        {
            ball.update();
            hasCollided(ball);
            renderer.render(ball.getModel());
        }
        for(StaticObject staticObject : staticObjects)
        {
            renderer.render(staticObject.getModel());
        }
    }

    /*
    * not final because only for side wall collision
    */
    public void hasCollided(Ball ball)
    {

        if(isColliding(ball))
        {
            //Hole is the 1st entry in staticObject array-list
            if(i == 1)
            {
                if(Math.abs(ball.getVelocity().x) <= minVelocity.x && Math.abs(ball.getVelocity().y) <= minVelocity.y)
                {
                    ball.setVelocity(new Vector3(0f, 0f, -0.1f));
                    return;
                }
                return;
            }

            Vector3 velocityChange = ball.getVelocity();

            if(ball.getBox().isBumpX())
            {
                velocityChange.x = 0 - velocityChange.x;
            }
            if(ball.getBox().isBumpY())
            {
                velocityChange.y = 0 - velocityChange.y;
            }

            //todo: fix Z next period
            //todo: corners are a bit fucked :3
            //velocityChange.z = 0 - velocityChange.z;
            ball.updateVelocity(velocityChange);
        }
    }

    public boolean isColliding(Ball ball)
    {
        ObjectBox box;
        box = ball.getBox();
        i = 0;
        for(StaticObject staticObject: staticObjects)
        {
            i++;
            if (box.overlaps(staticObject.getBox()))
            {
                return true;
            }
        }
        return false;
    }
}