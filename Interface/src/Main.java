import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) throws Exception {
        ImageIcon logo = new ImageIcon("Logotipo_Secret_Words.png");
        ImageIcon image = new ImageIcon("silvio_santos-removebg.png");
        ImageIcon iconSala = new ImageIcon("logo_criar_sala_branca.png");
        ImageIcon logoMenor = new ImageIcon("logo_menor.png");
        ImageIcon placas = new ImageIcon("placas.png");
        ImageIcon imgTema = new ImageIcon("Tema.png");
        ImageIcon roda = new ImageIcon("roda.png");
        ImageIcon jogadores = new ImageIcon("jogadores.png");

        JFrame frame = new JFrame();
        frame.setSize(800, 600); // dimensões
        frame.setTitle("Secret Words: Edição Distribuída"); // título da aplicação
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar e encerrar a execução
        // frame.setResizable(false); //não permite que a janela seja redimensionada,
        // mantendo ela fixa com os valores definidos anteriormente (420,420)

        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(0x123456));

        // Centraliza a janela na tela
        frame.setLocationRelativeTo(null);

        // Torna a janela visível
        frame.setVisible(true);
        frame.setLayout(null);
        // frame.getContentPane().setBackground(new Color(0x12345));

        JLabel label = new JLabel();
        label.setIcon(image);
        // label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(380, 90, 1000, 550);

        JLabel titulo = new JLabel();
        titulo.setIcon(logo);
        titulo.setBounds(10, 20, 500, 300);

        JButton button = new JButton("Criar Sala");
        button.setBounds(180, 350, 150, 60);
        button.setFont(new Font("Georgia", Font.BOLD, 20));
        button.setBackground(new Color(231, 231, 231));

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(180, 440, 150, 60);
        btnEntrar.setFont(new Font("Georgia", Font.BOLD, 20));
        btnEntrar.setBackground(new Color(231, 231, 231));

        frame.add(label, BorderLayout.CENTER);
        frame.add(titulo);
        frame.add(button);
        frame.add(btnEntrar);

        
          URL soundUrl = Main.class.getResource("audio/ma_oe.wav");
         // URL soundUrl =
          // Main.class.getClassLoader().getResource("audio/silvio-santos-esta-certo-disso.wav");
          AudioClip sound = Applet.newAudioClip(soundUrl);
          button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          sound.play();
         }
         });
         
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame();
                newFrame.setTitle("Criar Sala");
                newFrame.setSize(500, 500);
                newFrame.setLocationRelativeTo(frame);
                newFrame.setVisible(true);
                newFrame.setLayout(null);
                newFrame.getContentPane().setBackground(new Color(0x123456));
                newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.dispose();
                //button.setEnabled(false);

                JLabel label1 = new JLabel("Nº de jogadores:");
                label1.setFont(new Font("Georgia", Font.BOLD, 16));
                label1.setForeground(new Color(231, 231, 231));
                label1.setBounds(20, 230, 150, 20);
                newFrame.add(label1);

                JTextField textField1 = new JTextField();
                textField1.setBounds(180, 230, 150, 20);
                textField1.setFont(new Font("Cambria", Font.BOLD, 14));
                newFrame.add(textField1);

                JLabel label2 = new JLabel("Tema:");
                label2.setFont(new Font("Georgia", Font.BOLD, 16));
                label2.setForeground(new Color(231, 231, 231));
                label2.setBounds(20, 260, 150, 20);
                newFrame.add(label2);

                JComboBox<String> comboBox = new JComboBox<String>();
                comboBox.setBackground(new Color(255, 254, 254));
                comboBox.setBounds(180, 260, 150, 20);
                comboBox.setFont(new Font("Cambria", Font.BOLD, 14));
                comboBox.addItem("Tema 1");
                comboBox.addItem("Tema 2");
                comboBox.addItem("Tema 3");
                comboBox.addItem("Tema 4");
                comboBox.addItem("Tema 5");
                newFrame.add(comboBox);

                JLabel label3 = new JLabel("Código:");
                label3.setFont(new Font("Georgia", Font.BOLD, 16));
                label3.setForeground(new Color(231, 231, 231));
                label3.setBounds(20, 290, 150, 20);
                newFrame.add(label3);

                // Gera um número aleatório e o converte em uma string
                int codigo = new Random().nextInt(10000);
                String codigoStr = String.format("%04d", codigo);

                // Cria um JLabel para exibir o código gerado
                JLabel codigoLabel = new JLabel(codigoStr);
                codigoLabel.setBounds(180, 290, 150, 20);
                codigoLabel.setForeground(new Color(231,231,231));
                codigoLabel.setFont(new Font("Cambria", Font.BOLD, 15));
                newFrame.add(codigoLabel);

                JLabel label4 = new JLabel();
                label4.setIcon(iconSala);
                // label.setHorizontalAlignment(JLabel.RIGHT);
                label4.setBounds(10, 1, 400, 300);
                newFrame.add(label4);

                JButton btnCriar = new JButton("Criar");
                btnCriar.setBounds(200, 340, 100, 40);
                btnCriar.setFont(new Font("Georgia", Font.BOLD, 20));
                btnCriar.setBackground(new Color(18, 199, 118));
                btnCriar.setForeground(new Color(255, 254, 254));
                newFrame.add(btnCriar);

               JLabel label5 = new JLabel();
                label5.setIcon(logoMenor);
                // label.setHorizontalAlignment(JLabel.RIGHT);
                label5.setBounds(175, 220, 500, 400);
                newFrame.add(label5);

                URL quemQuerDinheiro = Main.class.getResource("audio/quem_quer_dinheiro.wav");
                // URL soundUrl =
                 // Main.class.getClassLoader().getResource("audio/silvio-santos-esta-certo-disso.wav");
                 AudioClip bordao = Applet.newAudioClip(quemQuerDinheiro);
                 btnCriar.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                 bordao.play();
                }
                });

                btnCriar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame novaJanela = new JFrame("Nova Janela");
                        novaJanela.setSize(900, 600);
                        novaJanela.setLocationRelativeTo(null);
                        novaJanela.setVisible(true);
                        novaJanela.setLayout(null);
                        novaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                        
                        newFrame.dispose();

                        novaJanela.getContentPane().setBackground(new Color(0x123456));
                        
                        JLabel silvio = new JLabel();
                        silvio.setIcon(image);
                        // label.setHorizontalAlignment(JLabel.RIGHT);
                        silvio.setBounds(510, 70, 1000, 550);

                        novaJanela.add(silvio);
                        

                        JLabel rodaLabel = new JLabel();
                        rodaLabel.setIcon(placas);
                        rodaLabel.setBounds(-150, 70, 800, 500);
                        novaJanela.add(rodaLabel);

                        JLabel jlTema = new JLabel();
                        jlTema.setIcon(imgTema);
                        jlTema.setBounds(-140, 260, 800, 500);
                        novaJanela.add(jlTema);

                        JLabel jlRoda = new JLabel();
                        jlRoda.setIcon(roda);
                        jlRoda.setBounds(-320, -130, 800, 500);
                        novaJanela.add(jlRoda);

                        JLabel jlJogadores = new JLabel();
                        jlJogadores.setIcon(jogadores);
                        jlJogadores.setBounds(60, -180, 800, 500);
                        novaJanela.add(jlJogadores);


                    }
                });
                
            }
            
        });

        // Adiciona o label ao centro do container, utilizando o layout manager
        // BorderLayout
        // Define a cor de fundo do container para uma cor cinza claro
    }
}
