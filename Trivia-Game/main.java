import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;


public class Main{
    //JFrame frame = new JFrame("A Bouncing Ball");
    public static void main(String [] args){
        Quiz quiz = new Quiz();

    }
}



class Quiz implements ActionListener {
    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;



    private static final int UPDATE_RATE = 30; // Number of refresh per second

    String[] questions = {
            "Which NBA player has the most regular-season points?",
            "Which NBA player has the most made 3-point shots of all time?",
            "Which NBA player has the most rebounds of all time?",
            "Which NBA player has the most Championships of all time?",
            "Which NBA player has the most points scored in a single game?",
            "Which NBA player has the most NBA Finals MVP awards?",
            "Who was the shortest player in NBA history?",
            "Which NBA player has the most dunks in NBA history?",
            "Which NBA player has the most 3-point shots made in a single game?",
            "When was the NBA established?",
            "Which NBA player has more finals MVP awards than triple-doubles?",
            "Which NBA player almost stopped playing basketball to become a garbage man?",
            "College sensation Lew Alcindor got which move banned from college basketball?",
            "Which team has the longest single-game winning streak in NBA history?",
            "How many times did Wilt Chamberlain foul out in his NBA career?",
            "Which NBA player has the most games played?",
            "Which NBA player has the most 3-point shots attempted?",
            "Which NBA player has the highest career field goal percentage?",
            "Which NBA player has the most turnovers of all time",
            "Which NBA player has the most free throws attempted in NBA history?",
            "Which NBA player has committed the most personal fouls?",
            "Which NBA player has the most blocks of all time?",
            "Which NBA player has the most assists in a single game?",
            "What is the single game rebound record?",
            "What is the single game assist record?",
            "Which team won the first NBA game?",
            "Which NBA player was the first to win MVP with a unanimous vote?",
            "Which player did the Los Angeles Lakers Draft twice?",
            "Which NBA player was drafted by the Bucks, but refused to play for them?",
            "Who is the only NBA player to retire with more blocks than points?",
            "Who is the only teenager in NBA history with 10 consecutive 20 point games?",
            "Who is the only Harlem Globetrotter to win a league MVP in the NBA?",
            "Who is the only non-center in NBA history to record a quadruple double?",
            "Who is the only 40 year old player to score 40 points in a game?",
            "Which NBA player recorded two quadruple doubles in one month?",
            "Which NBA player has the record, 127 ejections?",
            "Who is the only player with an MVP in the ABA and NBA?",
            "Who is the only NBA player to lead all players in a playoff series in the 5 major statistics?",
            "Which NBA player has the most league MVP awards?",
            "Who is the only rookie to win a Finals MVP award?",
            "Who was the oldest NBA player to have a 50 point game?",
            "Who was the first NBA player to get COVID-19?",
            "Who has the most coaching wins?",
            "Which player has the most blocked shots in a season?",
            "Who has the single season steals record",
            "Who is the tallest player of all time?",
            "Who is the lowest seeded team to make the NBA finals?",
            "Which team won the first NBA championship?",
            "Which current franchise has the worst win%?",
            "Who has the most career playoff points?"



    };

    String[][] options = {
            {"Kareem Abdul-Jabbar", "Michael Jordan", "LeBron James", "Karl Malone"},
            {"Ray Allen", "Stephen Curry", "Klay Thompson", "Reggie Miller"},
            {"Bill Russell", "Kareem Abdul-Jabbar", "Wilt Chamberlain", "Shaquille O'Neal"},
            {"Michael Jordan", "John Havlicek", "Bill Russell", "Kobe Bryant"},
            {"Michael Jordan", "Wilt Chamberlain", "Kobe Bryant", "James Harden"},
            {"Bill Russell", "Kareem Abdul-Jabbar", "LeBron James", "Michael Jordan"},
            {"Muggsy Bouges", "Chris Paul", "Earl Boykins", "Spud Webb"},
            {"Shaquille O'Neal", "Michael Jordan", "Dwight Howard", "DeAndre Jordan"},
            {"Stephen Curry", "Ray Allen", "Kobe Bryant", "Klay Thompson"},
            {"1939", "1956", "1872", "1946"},
            {"Kevin Durant", "Kawhi Leonard", "Chauncey Billups", "Joe Dumars"},
            {"Dennis Rodman", "Ron Artest", "Bob Pettit", "Larry Bird"},
            {"Slam Dunk", "Hook Shot", "Jump shot", "3 Point Shot"},
            {"Philadelphia Warriors", "Golden State Warriors", "Chicago Bulls", "Los Angeles Lakers"},
            {"47", "39", "0", "14"},
            {"Robert Parish", "Kareem Abdul Jabbar", "LeBron James", "Vince Carter"},
            {"Stephen Curry", "Kobe Bryant", "Kyle Korver", "Ray Allen"},
            {"Shaquille O'Neal", "DeAndre Jordan", "Artis Gilmore", "Rudy Gobert"},
            {"Russell Westbrook", "Kobe Bryant", "LeBron James", "James Harden"},
            {"Wilt Chamberlain", "Karl Malone", "LeBron James", "Dwight Howard"},
            {"Kareem Abdul-Jabbar", "Robert Parish", "Charles Oakley", "Hakeem Olajuwon"},
            {"Hakeem Olajuwon", "Dikimbe Mutumbo", "Tim Duncan", "Patrick Ewing"},
            {"Chris Paul", "Magic Johnson", "John Stockton", "Scott Skiles"},
            {"47", "55", "50", "37"},
            {"35", "24", "30", "39"},
            {"Philadelphia Warriors", "Boston Celtics", "Minneapolis Lakers", "New York Knicks"},
            {"Stephen Curry", "LeBron James", "Shaquille O'Neal", "Allen Iverson"},
            {"Jerry West", "Elgin Baylor", "Magic Johnson", "James Worthy"},
            {"Wilt Chamberlain", "Jerry West", "Julius Erving", "Wes Unseld"},
            {"Gheorge Muresan", "Shawn Bradley", "Yao Ming", "Manute Bol"},
            {"Zion Williamson", "LeBron James", "Kobe Bryant", "J.R. Smith"},
            {"Wes Unseld", "Bob Pettit", "Wilt Chamberlain", "Bill Russel"},
            {"Russell Westbrook", "Alvin Robinson", "Michael Jordan", "LeBron James"},
            {"Jamal Crawford", "Vince Carter", "Kareem Abdul-Jabbar", "Michael Jordan"},
            {"David Robinson", "Hakeem Olajuwon", "Kareem Abdul-Jabbar", "Nate Thurmond"},
            {"Ron Artest", "Vern Mikkelsen", "DeMarcus Cousins", "Dennis Rodman"},
            {"Bob McAdoo", "Willis Reed", "Oscar Robertson", "Julius Erving"},
            {"LeBron James", "Hakeem Olajuwon", "Michael Jordan", "Shaquille O'Neal"},
            {"LeBron James", "Michael Jordan", "Kareem Abdul-Jabbar", "Magic Johnson"},
            {"Magic Johnson", "Larry Bird", "Wilt Chamberlain", "John Havlicek"},
            {"Kobe Bryant", "Michael Jordan", "Jamal Crawford", "LeBron James"},
            {"Rudy Gay", "Rudy Gobert", "Donovan Mitchell", "Mike Conley"},
            {"Gregg Popovich", "Don Nelson", "Doc Rivers", "Steve Kerr"},
            {"Mark Eaton", "Manute Bol", "Dikimbe Mutumbo", "Hakeem Olajuwon"},
            {"Alvin Robinson", "Chris Paul", "John Stockton", "Michael Jordan"},
            {"Manute Bol", "Shawn Bradley", "Yao Ming", "Gheorge Muresan"},
            {"Golden State Warriors", "New York Knicks", "Houston Rockets", "Boston Celtics"},
            {"New York Knicks", "Boston Celtics", "Philadelphia Warriors", "Minneapolis Lakers"},
            {"Brooklyn Nets", "Minnesota Timberwolves", "Orlando Magic", "Los Angeles Clippers"},
            {"Michael Jordan", "Kobe Bryant", "LeBron James", "Kareem Abdul-Jabbar"}






    };

    char[] answers = {
            'A',
            'B',
            'C',
            'C',
            'B',
            'D',
            'A',
            'C',
            'D',
            'D',
            'B',
            'D',
            'A',
            'D',
            'C',
            'A',
            'D',
            'B',
            'C',
            'B',
            'A',
            'A',
            'D',
            'B',
            'C',
            'D',
            'A',
            'B',
            'C',
            'D',
            'A',
            'C',
            'B',
            'D',
            'B',
            'B',
            'D',
            'A',
            'C',
            'A',
            'C',
            'B',
            'A',
            'A',
            'A',
            'D',
            'B',
            'C',
            'B',
            'C'






    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int seconds=10;

    //int increaseValue = (int)(Math.random()*4)+1;

    int score;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();



    private static final int UPDATE = 30; // Number of refresh per second

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }
        }
    });
    int[] questionsArray = {
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            (int)(Math.random()*48)+1,
            50
    };

    public int[] arrayInit(int[] questionsArray){
//

        Arrays.sort(questionsArray);
        for(int i=0; i<questionsArray.length-1; i++){
            if(questionsArray[i] == questionsArray[i+1]){
                questionsArray[i+1] = questionsArray[i+1] + 1;
            }

        }
        return questionsArray;
    }







    public Quiz(){


        arrayInit(questionsArray);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);


        textfield.setBounds(0, 0, 650, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setBackground(new Color(168, 105, 50));
        textfield.setFont(new Font("Ink Free",Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);


        textarea.setBounds(0, 50, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(168, 105, 50));;
        textarea.setFont(new Font("MV Boli ",Font.BOLD, 15));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        //textarea.setText("Sample ETxt");

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 100, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(168, 105, 50));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
        //answer_labelA.setText("");

        answer_labelB.setBounds(125, 200, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(168, 105, 50));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
        //answer_labelB.setText("");

        answer_labelC.setBounds(125, 300, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(168, 105, 50));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
        //answer_labelC.setText("");

        answer_labelD.setBounds(125, 400, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(168, 105, 50));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
        //answer_labelD.setText("");

        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0,0));
        seconds_left.setFont(new Font("Ink free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535, 475, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        //time_label.setText("");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(120, 325, 400, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        //frame.add
        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);
        nextQuestion();
    }
    public void nextQuestion(){

        if(questionsArray[index] >= total_questions){
            results();
        }
        else{
            textfield.setText("Question: " + (index+1));
            textarea.setText(questions[questionsArray[index]]);
            answer_labelA.setText(options[questionsArray[index]][0]);
            answer_labelB.setText(options[questionsArray[index]][1]);
            answer_labelC.setText(options[questionsArray[index]][2]);
            answer_labelD.setText(options[questionsArray[index]][3]);
            timer.start();
        }


    }
    @Override
    public void actionPerformed(ActionEvent e){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if(e.getSource()==buttonA){
            answer='A';
            if(answer==answers[questionsArray[index]]){
                correct_guesses++;
                score = score +1000 +(seconds*25);
            }

        }
        if(e.getSource()==buttonB){
            answer='B';
            if(answer==answers[questionsArray[index]]){
                correct_guesses++;
                score = score +1000 +(seconds*25);
            }

        }
        if(e.getSource()==buttonC){
            answer='C';
            if(answer==answers[questionsArray[index]]){
                correct_guesses++;
                score = score +1000 +(seconds*25);
            }

        }
        if(e.getSource()==buttonD){
            answer='D';
            if(answer==answers[questionsArray[index]]){
                correct_guesses++;
                score = score +1000 +(seconds*25);
            }

        }
        displayAnswer();


    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if(answers[questionsArray[index]] == 'A'){
            answer_labelA.setForeground(new Color(25, 255, 0));
        }
        if(answers[questionsArray[index]] == 'B'){
            answer_labelB.setForeground(new Color(25, 255, 0));
        }
        if(answers[questionsArray[index]] == 'C'){
            answer_labelC.setForeground(new Color(25, 255, 0));
        }
        if(answers[questionsArray[index]] == 'D'){
            answer_labelD.setForeground(new Color(25, 255, 0));
        }
        if(answers[questionsArray[index]] != 'A'){
            answer_labelA.setForeground(new Color(255, 0, 0));
        }
        if(answers[questionsArray[index]] != 'B'){
            answer_labelB.setForeground(new Color(255, 0, 0));
        }
        if(answers[questionsArray[index]] != 'C'){
            answer_labelC.setForeground(new Color(255, 0, 0));
        }
        if(answers[questionsArray[index]] != 'D'){
            answer_labelD.setForeground(new Color(255, 0, 0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(168, 105, 50));
                answer_labelB.setForeground(new Color(168, 105, 50));
                answer_labelC.setForeground(new Color(168, 105, 50));
                answer_labelD.setForeground(new Color(168, 105, 50));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();


            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    //    public void animate(){
//        Timer pause = new Timer(2000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                answer_labelA.setForeground(new Color(25, 255, 0));
//                answer_labelB.setForeground(new Color(25, 255, 0));
//                answer_labelC.setForeground(new Color(25, 255, 0));
//                answer_labelD.setForeground(new Color(25, 255, 0));
//
//                answer = ' ';
//                seconds = 10;
//                seconds_left.setText(String.valueOf(seconds));
//
//                buttonA.setEnabled(true);
//                buttonB.setEnabled(true);
//                buttonC.setEnabled(true);
//                buttonD.setEnabled(true);
//                index++;
//                nextQuestion();
//
//
//            }
//        });
//        pause.setRepeats(false);
//        pause.start();
//    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        double result = (double)(correct_guesses/(int)total_questions) *100;

        textfield.setText("RESULTS");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("("+correct_guesses+"/"+10+")");
        percentage.setText("Score:" +score);

        frame.add(percentage);
        frame.add(number_right);
        

    }

}
