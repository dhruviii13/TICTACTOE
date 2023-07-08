import java.awt. *;
import java.awt.event. *;
import javax.swing. *;
import java.util. *;
 class TICTAC implements ActionListener {
    Random random = new Random();
        JFrame frame = new JFrame();
        JPanel title_panel= new JPanel();
        JPanel button_panel= new JPanel();
        JLabel textfield = new JLabel();
        JButton[] buttons = new JButton[9];
        boolean player1_turn;//player2 var not needed as if this value will be false it automatically means player 2
    TICTAC()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
         frame.getContentPane().setBackground(new Color(50,50,50));
          frame.setLayout(new BorderLayout());
          frame.setVisible(true);
          textfield.setBackground(new Color(25,25,25));
          textfield.setForeground(new Color(25,255,0));
          textfield.setFont(new Font("Ink Free", Font.BOLD,50));
          textfield.setHorizontalAlignment(JLabel.CENTER);
          textfield.setText("TIC-TAC-TOE");
          textfield.setOpaque(true);

          title_panel.setLayout(new BorderLayout());
           title_panel.setBounds(0,0,800,100);

           button_panel.setLayout(new GridLayout(3,3));
           button_panel.setBackground(new Color(150,150,150));

           for(int i=0;i<9;i++)
           {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MY Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
         title_panel.add(textfield);
           frame.add(title_panel, BorderLayout.NORTH);
           frame.add(button_panel);
           firstTurn();
    }


    public void actionPerformed(ActionEvent e){
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])//By comparing e.getSource() with buttons[i], the code checks if the button that triggered the event is the same as the i-th button in the buttons array.
            {
                
    for (int j = 0; j < 9; j++) {
        if (e.getSource() == buttons[j]) {
            if (player1_turn && buttons[i].getText().equals(""))////just passing player1_turn as it is a boolean value and get text is a method which returns the text of the button at ith position as a string so the equals fn compares is it and returns a boolean value
             {
                buttons[j].setForeground(new Color(255, 0, 0));
                buttons[j].setText("X");
                player1_turn = false;
                textfield.setText("O turn");
                check();
            } else if (!player1_turn && buttons[j].getText().equals("")) {
                buttons[j].setForeground(new Color(0, 0, 255));
                buttons[j].setText("O");
                player1_turn = true;
                textfield.setText("X turn");
                check();
            }
        }
    }
}
        }
    }

                
    public void firstTurn()
    { try{
        Thread.sleep(2000);//this statement makes the titactoe title appear only for 2000 miliseconds and then shows X turn and O turn as titles.
    }catch(InterruptedException e)
    {
        e.printStackTrace();
    }


       if(random.nextInt(2)==0)
        {
            player1_turn = true;
            textfield.setText("X turn");

        }
        else{
            player1_turn=false;
            textfield.setText("0 turn");

        }

    }
    public void check()
    {
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
        {
            xwins(0,1,2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
        {
            xwins(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xwins(6,7,8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xwins(0,3,6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
        {
            xwins(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xwins(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xwins(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xwins(2,4,6);
        }

          if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
        {
            owins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
        {
            owins(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
        {
            owins(6,7,8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
        {
            owins(0,3,6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
        {
            owins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
        {
            owins(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
        {
            owins(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
        {
            owins(2,4,6);
        }

    

    }
    public void xwins(int a, int b, int c){
        buttons[a].setBackground(Color.PINK);
         buttons[b].setBackground(Color.PINK);
          buttons[c].setBackground(Color.PINK);
        
    for(int i=0; i<9;i++){
        buttons[i].setEnabled(false);
    }
    textfield.setText("X wins");
 }

    public void owins(int a, int b, int c)
    {
          buttons[a].setBackground(Color.PINK);
         buttons[b].setBackground(Color.PINK);
          buttons[c].setBackground(Color.PINK);
        
    for(int i=0; i<9;i++){
        buttons[i].setEnabled(false);
    }
    textfield.setText("O wins");
 }

    }

 
public class ttt{
     public static void main(String[] args)

    {
       TICTAC tictactoe=new TICTAC();  
    }
}
