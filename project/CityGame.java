package project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



    class CityGame extends JFrame implements ActionListener {
        private JTextField inputField;
        private JTextArea outputArea;

        public CityGame() {
            setTitle("Игра в города");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            inputField = new JTextField();
            inputField.addActionListener(this);

            outputArea = new JTextArea();
            outputArea.setEditable(false);
            outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

            JScrollPane scrollPane = new JScrollPane(outputArea);

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(inputField, BorderLayout.NORTH);
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            processUserInput(input);
            inputField.setText("");
        }

        private void processUserInput(String input) {
            // Здесь можно реализовать логику обработки введенного пользователем города
            // и хода компьютера. Можно использовать базу данных городов или просто
            // предопределенный список городов.

            // Пример:
            if(input.equalsIgnoreCase("Здаюсь")){
                JOptionPane.showMessageDialog (new JFrame(), "Ви здались", "помилка",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            String computerCity = "Москва"; // Пусть компьютер всегда называет "Москву"
            String userCity = input;

            outputArea.append("Вы: " + userCity + "\n");
            outputArea.append("Компьютер: " + computerCity + "\n");

        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new CityGame();
            });
        }
    }
