import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tictactoe 
{
    int boardWidth=700;
    int boardHeight=800;
    JFrame frame= new JFrame("TACKY TACK GAME");
    JLabel textlabel= new JLabel();
    JPanel textpanel= new JPanel();
    JPanel boardpanel=new JPanel();

    JButton [][] board = new JButton[3][3];
    String player_X="X";
    String player_O="O";
    String currentplayer=player_X;

    boolean gameover=false;
    int counter=0;
    tictactoe()
    {
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textlabel.setBackground(Color.GRAY);
        textlabel.setForeground(Color.white);
        textlabel.setFont(new Font("Arial", Font.BOLD, 60));
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setText("TACKY TACK GAME");
        textlabel.setOpaque(true);


        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlabel);
        frame.add(textpanel, BorderLayout.NORTH);

        boardpanel.setLayout(new GridLayout(3,3));
        boardpanel.setBackground(Color.PINK);
        frame.add(boardpanel);

        for(int r=0;r<3;r++)
        {
            for(int c=0;c<3;c++)
            {
                JButton tile= new JButton();
                board[r][c]=tile;
                boardpanel.add(tile);

                tile.setBackground(Color.PINK);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial",Font.BOLD,150));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if (gameover)
                        return;
                        JButton tile= (JButton)e.getSource();
                        if(tile.getText()=="")
                        {
                        tile.setText(currentplayer);
                        counter++;
                        checkwinner();
                        if (!gameover){
                        currentplayer= currentplayer==player_X? player_O:player_X;
                        textlabel.setText(currentplayer+ "'s turn");
                        } 
                    }
                    }

                    
                });
            }
        }
    }


    void checkwinner() {
    
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText() == "") continue;

            if (board[r][0].getText() == board[r][1].getText() &&
                board[r][1].getText() == board[r][2].getText()) {
                for (int i = 0; i < 3; i++) {
                    setwinner(board[r][i]);
                }
                gameover = true;
                return;
            }
        }
         
         for (int c = 0; c < 3; c++) {
            if (board[0][c].getText() == "") continue;
            
            if (board[0][c].getText() == board[1][c].getText() &&
                board[1][c].getText() == board[2][c].getText()) {
                for (int i = 0; i < 3; i++) {
                    setwinner(board[i][c]);
                }
                gameover = true;
                return;
            }
        }

  
        if (board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != "") {
            for (int i = 0; i < 3; i++) {
                setwinner(board[i][i]);
            }
            gameover = true;
            return;
        }

     
        if (board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != "") {
            setwinner(board[0][2]);
            setwinner(board[1][1]);
            setwinner(board[2][0]);
            gameover = true;
            return;
        }

        if (counter == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    settie(board[r][c]);
                }
            }
            gameover = true;
        }
    }
        

   
    void setwinner(JButton tile)
    {
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.DARK_GRAY);
        textlabel.setText(currentplayer+ " aced it!!!");

    }

    void settie(JButton tile) {
        tile.setForeground(Color.orange);
        tile.setBackground(Color.DARK_GRAY);
        textlabel.setText("It's a tie breder!!!");
    }
}