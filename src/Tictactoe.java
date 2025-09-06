import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tictactoe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JPanel score_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton newGameButton = new JButton("New Game");

    JLabel xScoreLabel = new JLabel("X: 0");
    JLabel oScoreLabel = new JLabel("O: 0");
    JLabel drawScoreLabel = new JLabel("Draw: 0");

    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    int xScore = 0;
    int oScore = 0;
    int drawScore = 0;

    Tictactoe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());


        newGameButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(this);


        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("MV Boli", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.add(textField, BorderLayout.CENTER);


        button_panel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        score_panel.setLayout(new GridLayout(1, 3));
        xScoreLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        xScoreLabel.setForeground(Color.RED);
        xScoreLabel.setHorizontalAlignment(JLabel.CENTER);

        oScoreLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        oScoreLabel.setForeground(Color.BLUE);
        oScoreLabel.setHorizontalAlignment(JLabel.CENTER);

        drawScoreLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        drawScoreLabel.setForeground(Color.GRAY);
        drawScoreLabel.setHorizontalAlignment(JLabel.CENTER);

        score_panel.add(xScoreLabel);
        score_panel.add(drawScoreLabel);
        score_panel.add(oScoreLabel);

        JPanel center_panel = new JPanel(new BorderLayout());
        center_panel.add(button_panel, BorderLayout.CENTER);
        center_panel.add(score_panel, BorderLayout.SOUTH);


        JPanel bottom_panel = new JPanel(new BorderLayout());
        bottom_panel.add(newGameButton, BorderLayout.CENTER);


        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(center_panel, BorderLayout.CENTER);
        frame.add(bottom_panel, BorderLayout.SOUTH);

        frame.setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            resetGame();
        }
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if ("".equals(buttons[i].getText())) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        textField.setForeground(new Color(0, 0, 255));
                        check();
                    }
                } else {
                    if ("".equals(buttons[i].getText())) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        textField.setForeground(new Color(255, 0, 0));
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
            textField.setForeground(new Color(255, 0, 0));
        } else {
            player1_turn = false;
            textField.setText("O turn");
            textField.setForeground(new Color(0, 0, 255));
        }
    }

    public void check(){
        if ((buttons[0].getText().equals("X"))&&
                (buttons[1].getText().equals("X"))&&
                (buttons[2].getText().equals("X"))
        ){
            xWins(0,1,2);
        }
        if ((buttons[3].getText().equals("X"))&&
                (buttons[4].getText().equals("X"))&&
                (buttons[5].getText().equals("X"))
        ){
            xWins(3,4,5);
        }
        if ((buttons[6].getText().equals("X"))&&
                (buttons[7].getText().equals("X"))&&
                (buttons[8].getText().equals("X"))
        ){
            xWins(6,7,8);
        }
        if ((buttons[0].getText().equals("X"))&&
                (buttons[3].getText().equals("X"))&&
                (buttons[6].getText().equals("X"))
        ){
            xWins(0,3,6);
        }
        if ((buttons[1].getText().equals("X"))&&
                (buttons[4].getText().equals("X"))&&
                (buttons[7].getText().equals("X"))
        ){
            xWins(1,4,7);
        }
        if ((buttons[2].getText().equals("X"))&&
                (buttons[5].getText().equals("X"))&&
                (buttons[8].getText().equals("X"))
        ){
            xWins(2,5,8);
        }
        if ((buttons[0].getText().equals("X"))&&
                (buttons[4].getText().equals("X"))&&
                (buttons[8].getText().equals("X"))
        ){
            xWins(0,4,8);
        }
        if ((buttons[2].getText().equals("X"))&&
                (buttons[4].getText().equals("X"))&&
                (buttons[6].getText().equals("X"))
        ){
            xWins(2,4,6);
        }
        if ((buttons[0].getText().equals("O"))&&
                (buttons[1].getText().equals("O"))&&
                (buttons[2].getText().equals("O"))
        ){
            oWins(0,1,2);
        }
        if ((buttons[3].getText().equals("O"))&&
                (buttons[4].getText().equals("O"))&&
                (buttons[5].getText().equals("O"))
        ){
            oWins(3,4,5);
        }
        if ((buttons[6].getText().equals("O"))&&
                (buttons[7].getText().equals("O"))&&
                (buttons[8].getText().equals("0"))
        ){
            oWins(6,7,8);
        }
        if ((buttons[0].getText().equals("O"))&&
                (buttons[3].getText().equals("O"))&&
                (buttons[6].getText().equals("O"))
        ){
            oWins(0,3,6);
        }
        if ((buttons[1].getText().equals("O"))&&
                (buttons[4].getText().equals("O"))&&
                (buttons[7].getText().equals("O"))
        ){
            oWins(1,4,7);
        }
        if ((buttons[2].getText().equals("O"))&&
                (buttons[5].getText().equals("O"))&&
                (buttons[8].getText().equals("O"))
        ){
            oWins(2,5,8);
        }
        if ((buttons[0].getText().equals("O"))&&
                (buttons[4].getText().equals("O"))&&
                (buttons[8].getText().equals("O"))
        ){
            oWins(0,4,8);
        }
        if ((buttons[2].getText().equals("O"))&&
                (buttons[4].getText().equals("O"))&&
                (buttons[6].getText().equals("O"))
        ){
            oWins(2,4,6);
        }
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if ("".equals(buttons[i].getText())) {
                tie = false;
                break;
            }
        }

        if (tie) {
            textField.setForeground(new Color(125,125,125));
            textField.setText("DRAW");
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
            drawScore++;
            drawScoreLabel.setText("DRAW: " +drawScore);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X WINS");
        textField.setForeground(new Color(255, 0, 0));
        xScore++;
        xScoreLabel.setText("X: " + xScore);
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O WINS");
        textField.setForeground(new Color(0, 0, 255));
        oScore++;
        oScoreLabel.setText("O: " + oScore);
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(null);
            buttons[i].setEnabled(true);
            buttons[i].setFocusable(false);
        }
        firstTurn();
    }
}
