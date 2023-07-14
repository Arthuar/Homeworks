package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class NextWindow {


    private Map<Character, List<String>> playerMap;
    public ComputerMove move = new ComputerMove();

    private Character first;
    private Character last;
    private String responsesFromTextField;
    private int player = 0;
    private int computer = 0;

    public String getResponsesFromTextField() {
        return responsesFromTextField;
    }

    {
        try {
            playerMap=new CityFromWikipedia().getCities();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public char getFirst() {
        return first;
    }
    public char getLast() {
        return last;
    }

    public void secondWindow(){
        JFrame jf1 = new JFrame("Міста");
        JButton jb1 = new JButton("Зробити хід");
        JTextField jt1 = new JTextField();
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responsesFromTextField = jt1.getText();
                if(responsesFromTextField.equalsIgnoreCase("Здаюсь")){
                    JOptionPane.showMessageDialog(jf1, "Ви здались!!! Комп'ютер переміг", "Помилка", JOptionPane.ERROR_MESSAGE);
                    jf1.setVisible(false);
                    return;
                }
                if(responsesFromTextField.length()==0){
                    JOptionPane.showMessageDialog(jf1, "Ви нічого не ввели.Введіть назву міста", "Помилка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                first = responsesFromTextField.toUpperCase().charAt(0);
                last = responsesFromTextField.toUpperCase().charAt(responsesFromTextField.length()-1);

                if (playerMap.containsKey(first)){
                    if(!playerMap.get(first).contains(responsesFromTextField)){
                        JOptionPane.showMessageDialog(jf1, "Місто вказане з не вірно,або такого міста не має", "Помилка", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                checkAnswer();
                System.out.println("first = " + first);
                System.out.println("last = " + last);
                jf1.dispose();
                }
        });

        JLabel jl1 = new JLabel("     Введіть назву міста");
        JLabel jl2 = new JLabel("     Комп'ютер :");
        jb1.setBounds(30,38,140,26);
        jt1.setBounds(30,5,140,26);
        jl1.setBounds(200,5,140,26);
        jl2.setBounds(200,38,200,26);
        jf1.add(jb1);
        jf1.add(jt1);
        jf1.add(jl1);
        jf1.add(jl2);
        jf1.setSize(600,120);
        jf1.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int windowWidth = jf1.getWidth();
        int windowHeight = jf1.getHeight();
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        jf1.setLocation(windowX, windowY);
        jf1.setVisible(true);
    }

    public int getComputer() {
        return computer;
    }

    private void checkAnswer(){
        if(playerMap.containsKey(first)){
            if (playerMap.get(first).contains(responsesFromTextField)){
                player++;
                playerMap.get(first).remove(responsesFromTextField);
                move.computerStep(playerMap, last);
                computer++;
            }
        }
        secondWindowNext(move.responseComputerResult);
    }

    public void secondWindowNext(String s){
        JFrame jf1 = new JFrame("Міста");
        JButton jb1 = new JButton("Зробити хід");
        JTextField jt1 = new JTextField();
        JLabel jl1 = new JLabel("     Введіть назву міста");
        JLabel jl2 = new JLabel("     Комп'ютер :" + s);
        jb1.setBounds(30,38,140,26);
        jt1.setBounds(30,5,140,26);
        jl1.setBounds(200,5,140,26);
        jl2.setBounds(200,38,200,26);
        jf1.add(jb1);
        jf1.add(jt1);
        jf1.add(jl1);
        jf1.add(jl2);
        jf1.setSize(600,120);
        jf1.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int windowWidth = jf1.getWidth();
        int windowHeight = jf1.getHeight();
        int windowX = (screenWidth - windowWidth) / 2;
        int windowY = (screenHeight - windowHeight) / 2;

        jf1.setLocation(windowX, windowY);
        jf1.setVisible(true);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responsesFromTextField = jt1.getText();
                if(responsesFromTextField.equalsIgnoreCase("Здаюсь")){
                    JOptionPane.showMessageDialog(jf1, "Ви здались!!! Комп'ютер переміг", "Помилка", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if(responsesFromTextField.length()==0){
                    JOptionPane.showMessageDialog(jf1, "Ви нічого не ввели.Введіть назву міста", "Помилка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                first = s.toUpperCase().charAt(s.length() - 1);
                last = responsesFromTextField.toUpperCase().charAt(responsesFromTextField.length() - 1);

                if (playerMap.containsKey(first)){
                   if(!playerMap.get(first).contains(responsesFromTextField)){
                       JOptionPane.showMessageDialog(jf1, "Місто вказане з не вірно,або такого міста не має", "Помилка", JOptionPane.ERROR_MESSAGE);
                       return;
                   }
                }
                if (!first.equals(responsesFromTextField.charAt(0))) {
                    JOptionPane.showMessageDialog(jf1, "Місто вказане з не вірної першої букви. Вкажіть місто на першу букву,яка співпадає з останньою бувку відповіді міста компютера", "Помилка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                checkAnswer();
                jf1.dispose();
            }
        });
    }
}

