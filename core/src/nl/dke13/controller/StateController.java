package nl.dke13.controller;

import com.badlogic.gdx.Game;
import nl.dke13.screens.*;

/**
 * Switches between different screens
 * Has logic for screen switching and loading
 */
public class StateController
{
    //GameController
    //Display
    //needs to know every screen
    //methods that create the screens
    private Game display;

    public StateController()
    {
        display = new Display();
    }

    public Game getDisplay()
    {
        return display;
    }

    public void displayMenuScreen()
    {
        display.setScreen(new MenuScreen(this));
    }

    public void displayEditorScreen()
    {
        display.setScreen(new EditorScreen(this));
    }

    public void displayHoleSelectionScreen()
    {
        display.setScreen(new HoleSelectionScreen(this));
    }

    public void displayGameOverScreen(int player1Turn, int player2Turn, boolean multiplayer)
    {
        if(multiplayer)
            display.setScreen(new GameOverScreen(player1Turn, player2Turn, this));
        else
            display.setScreen(new GameOverScreen(player1Turn, this));
    }

    public void displayInstructions()
    {
        display.setScreen(new Instructions(this));
    }

    public void displayGameDisplay(boolean multiplayer)
    {
        display.setScreen(new GameDisplay());
    }

}
