import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Memorygame extends JFrame {
  private final int GRID_SIZE = 4;
  private ArrayList<Color> cardValues;
  private JButton[][] buttons;
  private Color[] values;
  private JButton firstButton;
  private JButton secondButton;
  private boolean isFirstClick;

  public Memorygame() {
    initializeGame();
    createAndShowGUI();
  }

  private void initializeGame() {
    // Set up card values and shuffle them
    values = new Color[] {
        Color.RED, Color.RED, Color.BLUE, Color.BLUE,
        Color.GREEN, Color.GREEN, Color.YELLOW, Color.YELLOW,
        Color.ORANGE, Color.ORANGE, Color.PINK, Color.PINK,
        Color.MAGENTA, Color.MAGENTA, Color.CYAN, Color.CYAN
    };
    cardValues = new ArrayList<>();
    Collections.addAll(cardValues, values);
    Collections.shuffle(cardValues);

    buttons = new JButton[GRID_SIZE][GRID_SIZE];
    isFirstClick = true;
  }

  private void createAndShowGUI() {
    setTitle("Memory Game");
    setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create buttons and add them to the frame
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        buttons[i][j] = new JButton();
        buttons[i][j].putClientProperty("value", cardValues.remove(0));
        buttons[i][j].setBackground(Color.LIGHT_GRAY);
        buttons[i][j].addActionListener(new CardFlipListener());
        add(buttons[i][j]);
      }
    }

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private class CardFlipListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton clickedButton = (JButton) e.getSource();
      Color value = (Color) clickedButton.getClientProperty("value");

      if (clickedButton == firstButton) {
        return; // Clicking the same button twice does nothing
      }

      clickedButton.setBackground(value);

      if (isFirstClick) {
        firstButton = clickedButton;
        isFirstClick = false;
      } else {
        secondButton = clickedButton;
        Timer timer = new Timer(1000, new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            checkForMatch();
          }
        });
        timer.setRepeats(false);
        timer.start();
      }
    }
  }

  private void checkForMatch() {
    Color firstValue = (Color) firstButton.getClientProperty("value");
    Color secondValue = (Color) secondButton.getClientProperty("value");

    if (!firstValue.equals(secondValue)) {
      firstButton.setBackground(Color.LIGHT_GRAY);
      secondButton.setBackground(Color.LIGHT_GRAY);
    } else {
      firstButton.setEnabled(false);
      secondButton.setEnabled(false);
    }

    firstButton = null;
    secondButton = null;
    isFirstClick = true;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Memorygame();
      }
    });
  }
}
