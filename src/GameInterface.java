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

public class GameInterface {

    private static final Color BACKGROUND_COLOR = new Color(0x123456);
    private static final Font TITLE_FONT = new Font("Georgia", Font.BOLD, 20);
    private static final Font LABEL_FONT = new Font("Georgia", Font.BOLD, 16);
    private static final Font TEXTFIELD_FONT = new Font("Cambria", Font.BOLD, 14);

    private static ImageIcon logo;
    private static ImageIcon avatarSilvioSantos;
    private static ImageIcon iconSala;
    private static ImageIcon logoMenor;
    private static ImageIcon placas;
    private static ImageIcon imgTema;
    private static ImageIcon roda;
    private static ImageIcon jogadores;

    private static JFrame frame;
    private static JLabel label;
    private static JLabel titulo;
    private static JButton criarSalaButton;
    private static JButton entrarButton;
    
    
    public static void main(String[] args) throws Exception {

        initComponents();
        initImages();

        JFrame menuInicial = new JFrame();
        menuInicial.setSize(800, 600); // dimens�es
        menuInicial.setTitle("Secret Words: Edição Distribuída"); // t�tulo da aplica��o
        menuInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar e encerrar a execu��o
        menuInicial.setIconImage(logo.getImage());
        menuInicial.getContentPane().setBackground(BACKGROUND_COLOR);
        // menuInicial.setResizable(false); //n�o permite que a janela seja
        // redimensionada,
        // mantendo ela fixa com os valores definidos anteriormente (420,420)

        // Centraliza a janela na tela
        menuInicial.setLocationRelativeTo(null);

        // Torna a janela vis�vel
        menuInicial.setVisible(true);
        menuInicial.setLayout(null);

        JLabel labelSilvioSantos = new JLabel();
        labelSilvioSantos.setIcon(avatarSilvioSantos);
        labelSilvioSantos.setBounds(380, 90, 1000, 550);
        // label.setHorizontalAlignment(JLabel.RIGHT);

        JLabel titulo = new JLabel();
        titulo.setIcon(logo);
        titulo.setBounds(10, 20, 500, 300);

        JButton btnCriarSala = new JButton("Criar Sala");
        btnCriarSala.setBounds(180, 350, 150, 60);
        btnCriarSala.setFont(new Font("Georgia", Font.BOLD, 20));
        btnCriarSala.setBackground(new Color(231, 231, 231));

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(180, 440, 150, 60);
        btnEntrar.setFont(new Font("Georgia", Font.BOLD, 20));
        btnEntrar.setBackground(new Color(231, 231, 231));

        menuInicial.add(labelSilvioSantos, BorderLayout.CENTER);
        menuInicial.add(titulo);
        menuInicial.add(btnCriarSala);
        menuInicial.add(btnEntrar);

        URL soundUrl = GameInterface.class.getResource("sounds/ma_oe.wav");
        AudioClip sound = Applet.newAudioClip(soundUrl);

        btnCriarSala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sound.play();
            }
        });

        btnCriarSala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame menuCriarSala = new JFrame();
                menuCriarSala.setTitle("Criar Sala");
                menuCriarSala.setSize(500, 500);
                menuCriarSala.setLocationRelativeTo(menuInicial);
                menuCriarSala.setVisible(true);
                menuCriarSala.setLayout(null);
                menuCriarSala.getContentPane().setBackground(BACKGROUND_COLOR);
                menuCriarSala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuInicial.dispose();
                // button.setEnabled(false);

                JLabel numberPlayersLabel = new JLabel("Nº de jogadores:");
                numberPlayersLabel.setFont(LABEL_FONT);
                numberPlayersLabel.setForeground(new Color(231, 231, 231));
                numberPlayersLabel.setBounds(20, 230, 150, 20);
                menuCriarSala.add(numberPlayersLabel);

                JTextField numberPlayersText = new JTextField();
                numberPlayersText.setBounds(180, 230, 150, 20);
                numberPlayersText.setFont(new Font("Cambria", Font.BOLD, 14));
                menuCriarSala.add(numberPlayersText);

                JLabel themeLabel = new JLabel("Tema:");
                themeLabel.setFont(LABEL_FONT);
                themeLabel.setForeground(new Color(231, 231, 231));
                themeLabel.setBounds(20, 260, 150, 20);
                menuCriarSala.add(themeLabel);

                JComboBox<String> themeComboBox = new JComboBox<String>();
                themeComboBox.setBackground(new Color(255, 254, 254));
                themeComboBox.setBounds(180, 260, 150, 20);
                themeComboBox.setFont(new Font("Cambria", Font.BOLD, 14));
                themeComboBox.addItem("Tema 1");
                themeComboBox.addItem("Tema 2");
                themeComboBox.addItem("Tema 3");
                themeComboBox.addItem("Tema 4");
                themeComboBox.addItem("Tema 5");
                menuCriarSala.add(themeComboBox);

                JLabel codeRoomLabel = new JLabel("Código:");
                codeRoomLabel.setFont(LABEL_FONT);
                codeRoomLabel.setForeground(new Color(231, 231, 231));
                codeRoomLabel.setBounds(20, 290, 150, 20);
                menuCriarSala.add(codeRoomLabel);

                // Gera um n�mero aleat�rio e o converte em uma string
                int codigo = new Random().nextInt(10000);
                String codigoStr = String.format("%04d", codigo);

                // Cria um JLabel para exibir o c�digo gerado
                JLabel codigoLabel = new JLabel(codigoStr);
                codigoLabel.setBounds(180, 290, 150, 20);
                codigoLabel.setForeground(new Color(231, 231, 231));
                codigoLabel.setFont(new Font("Cambria", Font.BOLD, 15));
                menuCriarSala.add(codigoLabel);

                JLabel label4 = new JLabel();
                label4.setIcon(iconSala);
                // label.setHorizontalAlignment(JLabel.RIGHT);
                label4.setBounds(10, 1, 400, 300);
                menuCriarSala.add(label4);

                JButton btnCriar = new JButton("Criar");
                btnCriar.setBounds(200, 340, 100, 40);
                btnCriar.setFont(new Font("Georgia", Font.BOLD, 20));
                btnCriar.setBackground(new Color(18, 199, 118));
                btnCriar.setForeground(new Color(255, 254, 254));
                menuCriarSala.add(btnCriar);

                JLabel label5 = new JLabel();
                label5.setIcon(logoMenor);
                // label.setHorizontalAlignment(JLabel.RIGHT);
                label5.setBounds(175, 220, 500, 400);
                menuCriarSala.add(label5);

                URL quemQuerDinheiro = GameInterface.class.getResource("sounds/quem_quer_dinheiro.wav");
                @SuppressWarnings("deprecation")
				AudioClip bordao = Applet.newAudioClip(quemQuerDinheiro);
                btnCriar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bordao.play();
                    }
                });

                btnCriar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame matchFrame = new JFrame("Nova Janela");
                        matchFrame.setSize(900, 600);
                        matchFrame.setLocationRelativeTo(null);
                        matchFrame.setVisible(true);
                        matchFrame.setLayout(null);
                        matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        menuCriarSala.dispose();

                        matchFrame.getContentPane().setBackground(BACKGROUND_COLOR);

                        JLabel silvio = new JLabel();
                        silvio.setIcon(avatarSilvioSantos);
                        // label.setHorizontalAlignment(JLabel.RIGHT);
                        silvio.setBounds(510, 70, 1000, 550);

                        matchFrame.add(silvio);

                        JLabel rodaLabel = new JLabel();
                        rodaLabel.setIcon(placas);
                        rodaLabel.setBounds(-150, 70, 800, 500);
                        matchFrame.add(rodaLabel);

                        JLabel jlTema = new JLabel();
                        jlTema.setIcon(imgTema);
                        jlTema.setFont(LABEL_FONT);
                        jlTema.setBounds(-140, 260, 800, 500);
                        matchFrame.add(jlTema);

                        JLabel jlRoda = new JLabel();
                        jlRoda.setIcon(roda);
                        jlRoda.setBounds(-320, -130, 800, 500);
                        matchFrame.add(jlRoda);

                        JLabel jlJogadores = new JLabel();
                        jlJogadores.setIcon(jogadores);
                        jlJogadores.setBounds(60, -180, 800, 500);
                        matchFrame.add(jlJogadores);

                        /*
                         * JTextField PortText = null;
                         * JLabel PortLabel = new JLabel("");
                         * PortLabel.setVisible(false);
                         * PortLabel.setIcon(imgTema);
                         * PortLabel.setLabelFor(PortText);
                         * PortLabel.setBounds(-140, 260, 800, 500);
                         * 
                         * PortText = new JTextField();
                         * PortText.setFont(new Font("Unispace", Font.PLAIN, 24));
                         * PortText.setText(codigoStr);
                         * PortText.setHorizontalAlignment(SwingConstants.LEFT);
                         * PortText.setColumns(10);
                         * PortText.setBorder(new EmptyBorder(0, 0, 0, 0));
                         * PortText.setBounds(141, 353, 172, 42);
                         * 
                         * novaJanela.add(PortText);
                         * novaJanela.add(PortLabel);
                         * 
                         * novaJanela.repaint();
                         */
                    }
                });

            }

        });

        // Adiciona o label ao centro do container, utilizando o layout manager
        // BorderLayout
        // Define a cor de fundo do container para uma cor cinza claro
    }

    public static void initImages() {
        logo = new ImageIcon("resources/images/Logotipo_Secret_Words.png");
        avatarSilvioSantos = new ImageIcon("resources/images/silvio_santos-removebg.png");
        iconSala = new ImageIcon("resources/images/logo_criar_sala_branca.png");
        logoMenor = new ImageIcon("resources/images/logo_menor.png");
        placas = new ImageIcon("resources/images/placas.png");
        imgTema = new ImageIcon("resources/images/Tema.png");
        roda = new ImageIcon("resources/images/roda.png");
        jogadores = new ImageIcon("resources/images/jogadores.png");
    }

    public static void initComponents() {
        frame = new JFrame();
        label = new JLabel(avatarSilvioSantos);
        titulo = new JLabel(logo);
        criarSalaButton = new JButton("Criar Sala");
        entrarButton = new JButton("Entrar");
    }

}
