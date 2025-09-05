import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tictactoe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton newGameButton = new JButton("New Game");

    JButton [] buttons = new JButton[9];
    boolean player1_turn;


    Tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());

        JPanel bottom_panel = new JPanel();
        bottom_panel.setLayout(new BorderLayout());
        bottom_panel.add(newGameButton, BorderLayout.CENTER);
        frame.add(bottom_panel, BorderLayout.SOUTH);

        frame.setVisible(true);

        newGameButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(this);


        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("MV Boli",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));

        for (int i = 0 ; i<9 ; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton){
            resetGame();
        }
        for (int i = 0 ; i<9 ; i++){
            if (e.getSource()==buttons[i]){
                if (player1_turn){
                    if ("".equals(buttons[i].getText())){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X turn");
                        check();
                }
            }

        }
    }

    public void firstTurn (){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2)==0){
            player1_turn = true;
            textField.setText("X turn");
        }
        else {
            player1_turn = false;
            textField.setText("O turn");
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
            textField.setText("DRAW");
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
        }
    }


    public void xWins (int a , int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0 ; i<9 ; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X WINS");
    }

    public void oWins (int a , int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0 ; i<9 ; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O WINS");
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