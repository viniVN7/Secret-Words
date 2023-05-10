import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class TelasJogo extends JFrame {

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

	public TelasJogo() {
		initImages();

		JFrame menuInicial = new JFrame();
		menuInicial.setSize(800, 600); // dimens�es
		menuInicial.setTitle("Secret Words: Edição Distribuída"); // t�tulo da aplica��o
		menuInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar e encerrar a execu��o
		menuInicial.setIconImage(logo.getImage());
		menuInicial.getContentPane().setBackground(BACKGROUND_COLOR);
		menuInicial.setResizable(false); // n�o permite que a janela seja redimensionada,

		// Centraliza a janela na tela
		menuInicial.setLocationRelativeTo(null);

		// Torna a janela vis�vel
		// menuInicial.setLayout(null);

		// ImageIcon imagem = new ImageIcon("resources/images/tema.png");
		JLabel labelSilvioSantos = new JLabel();
		labelSilvioSantos.setIcon(avatarSilvioSantos);
		labelSilvioSantos.setBounds(380, 90, 1000, 550);
		// label.setHorizontalAlignment(JLabel.RIGHT);

		JLabel titulo = new JLabel();
		titulo.setIcon(logo);
		titulo.setBounds(10, 20, 500, 300);

		JButton btnCriarSala = new JButton("Criar Sala");
		btnCriarSala.setBounds(180, 350, 150, 60);
		btnCriarSala.setFont(TITLE_FONT);
		btnCriarSala.setBackground(new Color(231, 231, 231));

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(180, 440, 150, 60);
		btnEntrar.setFont(TITLE_FONT);
		btnEntrar.setBackground(new Color(231, 231, 231));

		JLayeredPane pane = new JLayeredPane();
		pane.add(labelSilvioSantos);
		pane.add(titulo);
		pane.add(btnCriarSala);
		pane.add(btnEntrar);

		menuInicial.add(pane);
		menuInicial.setVisible(true);
		
		URL soundUrl = TelasJogo.class.getResource("sounds/ma_oe.wav");
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
                menuCriarSala.getContentPane().setBackground(BACKGROUND_COLOR);
                menuCriarSala.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuInicial.dispose();
                
                JLayeredPane sala = new JLayeredPane();

                JLabel numberPlayersLabel = new JLabel("Nº de jogadores:");
                numberPlayersLabel.setFont(LABEL_FONT);
                numberPlayersLabel.setForeground(new Color(231, 231, 231));
                numberPlayersLabel.setBounds(20, 230, 150, 20);
                sala.add(numberPlayersLabel);

                JTextField numberPlayersText = new JTextField();
                numberPlayersText.setBounds(180, 230, 150, 20);
                numberPlayersText.setFont(new Font("Cambria", Font.BOLD, 14));
                sala.add(numberPlayersText);

                JLabel themeLabel = new JLabel("Tema:");
                themeLabel.setFont(LABEL_FONT);
                themeLabel.setForeground(new Color(231, 231, 231));
                themeLabel.setBounds(20, 260, 150, 20);
                sala.add(themeLabel);

                JComboBox<String> themeComboBox = new JComboBox<String>();
                themeComboBox.setBackground(new Color(255, 254, 254));
                themeComboBox.setBounds(180, 260, 150, 20);
                themeComboBox.setFont(new Font("Cambria", Font.BOLD, 14));
                themeComboBox.addItem("Tema 1");
                themeComboBox.addItem("Tema 2");
                themeComboBox.addItem("Tema 3");
                themeComboBox.addItem("Tema 4");
                themeComboBox.addItem("Tema 5");
                sala.add(themeComboBox);

                JLabel codeRoomLabel = new JLabel("Código:");
                codeRoomLabel.setFont(LABEL_FONT);
                codeRoomLabel.setForeground(new Color(231, 231, 231));
                codeRoomLabel.setBounds(20, 290, 150, 20);
                sala.add(codeRoomLabel);

                // Gera um n�mero aleat�rio e o converte em uma string
                int codigo = new Random().nextInt(10000);
                String codigoStr = String.format("%04d", codigo);

                // Cria um JLabel para exibir o c�digo gerado
                JLabel codigoLabel = new JLabel(codigoStr);
                codigoLabel.setBounds(180, 290, 150, 20);
                codigoLabel.setForeground(new Color(231, 231, 231));
                codigoLabel.setFont(new Font("Cambria", Font.BOLD, 15));
                sala.add(codigoLabel);

                JLabel label4 = new JLabel();
                label4.setIcon(iconSala);
                // label.setHorizontalAlignment(JLabel.RIGHT);
                label4.setBounds(10, 1, 400, 300);
                sala.add(label4);

                JButton btnCriar = new JButton("Criar");
                btnCriar.setBounds(200, 340, 100, 40);
                btnCriar.setFont(TITLE_FONT);
                btnCriar.setBackground(new Color(18, 199, 118));
                btnCriar.setForeground(new Color(255, 254, 254));
                sala.add(btnCriar);

                JLabel label5 = new JLabel();
                label5.setIcon(logoMenor);
                label5.setBounds(175, 220, 500, 400);
                sala.add(label5);

                URL quemQuerDinheiro = TelasJogo.class.getResource("sounds/quem_quer_dinheiro.wav");
                @SuppressWarnings("deprecation")
				AudioClip bordao = Applet.newAudioClip(quemQuerDinheiro);
                btnCriar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bordao.play();
                    }
                });
                
                menuCriarSala.add(sala);
                menuCriarSala.setVisible(true);

                btnCriar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        matchFrame(menuCriarSala);
                    }

                });

            }

        });

	}
	
	private void matchFrame(JFrame menuCriarSala) {
		JFrame matchFrame = new JFrame("Nova Janela");
        matchFrame.setSize(900, 600);
        matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        matchFrame.getContentPane().setBackground(new Color(0x123456));
        menuCriarSala.setLocationRelativeTo(null);
        menuCriarSala.setResizable(false);
        menuCriarSala.dispose();

        // Cria um JLayeredPane para colocar os componentes em camadas
        JLayeredPane layeredPane = new JLayeredPane();

        // Cria um JLabel para exibir a imagem de fundo
        //ImageIcon imagem = new ImageIcon(getClass().getResource("tema.png"));
        JLabel labelImagem = new JLabel(imgTema);
        labelImagem.setBounds(-65, 260, 800, 500);

        // Cria um JLabel para o input
        JLabel labelInput = new JLabel("Animal");
        labelInput.setBounds(285, 500, 200, 30);
        labelInput.setForeground(new Color(0x12346));
        labelInput.setFont(new Font("Georgia", Font.BOLD, 30));

        JLabel silvio = new JLabel();
        silvio.setIcon(avatarSilvioSantos);
        silvio.setBounds(510, 70, 1000, 550);

        JLabel jlPlacas = new JLabel();
        jlPlacas.setIcon(placas);
        jlPlacas.setBounds(-150, 70, 800, 500);

        JLabel jlJogadores = new JLabel();
        jlJogadores.setIcon(jogadores);
        jlJogadores.setBounds(60, -180, 800, 500);

        int quantidadeJogadores = 3;
        int[] pontuacao = new int[quantidadeJogadores];
        JLabel[] jogador = new JLabel[quantidadeJogadores];

        for (int i = 0; i < quantidadeJogadores; i++) {
            pontuacao[i] = 0;
            jogador[i] = new JLabel(String.valueOf(pontuacao[i]));
            jogador[i].setBounds(318 + (i * 95), 30, 200, 30);
            jogador[i].setForeground(new Color(255, 254, 254));
            jogador[i].setFont(new Font("Georgia", Font.BOLD, 30));
            layeredPane.add(jogador[i], JLayeredPane.PALETTE_LAYER);
        }

        String palavra = "Cachorro";
        JLabel[] letras = new JLabel[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            letras[i] = new JLabel("_");
            letras[i].setBounds(140 + (i * 40), 320, 200, 30);
            letras[i].setForeground(new Color(255, 0, 0));
            letras[i].setFont(new Font("Georgia", Font.BOLD, 30));
            layeredPane.add(letras[i], JLayeredPane.PALETTE_LAYER);
        }

        JTextField campoLetra = new JTextField();
        campoLetra.setBounds(380, 200, 100, 30);
        layeredPane.add(campoLetra, JLayeredPane.PALETTE_LAYER);

        JButton botaoChute = new JButton("Chutar");
        botaoChute.setBounds(500, 200, 80, 30);
        botaoChute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String letra = campoLetra.getText().toUpperCase();
                if (letra.length() == 1) {
                    boolean acertou = false;
                    int indiceLetra = 0;
                    int jogadorAtual = indiceLetra % quantidadeJogadores; // armazena o índice do jogador atual
                    for (int i = 0; i < palavra.length(); i++) {
                        if (String.valueOf(palavra.charAt(i)).toUpperCase().equals(letra)) {
                            letras[i].setText(letra);
                            acertou = true;
                            indiceLetra++; // incrementa o índice da letra
                        }
                    }
                    if (acertou) {
                        pontuacao[jogadorAtual] += 100; // adiciona 100 pontos ao jogador atual
                        jogador[jogadorAtual].setText(String.valueOf(pontuacao[jogadorAtual])); // atualiza o JLabel do
                                                                                                // jogador atual
                    } else {
                        JOptionPane.showMessageDialog(null, "A letra " + letra + " não existe na palavra!");
                        indiceLetra++; // incrementa o índice da letra para passar para o próximo jogador
                        jogadorAtual = indiceLetra % quantidadeJogadores; // atualiza o índice do jogador atual
                        jogador[jogadorAtual].setText(String.valueOf(pontuacao[jogadorAtual])); // atualiza o JLabel do
                                                                                                // jogador atual
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Insira apenas uma letra!");
                }
                campoLetra.setText("");

            }
        });

        layeredPane.add(botaoChute, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(silvio, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(labelInput, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(labelImagem, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(jlPlacas, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(jlJogadores, JLayeredPane.DEFAULT_LAYER);

        matchFrame.add(layeredPane);
        matchFrame.setVisible(true);
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
	
	public static void main(String[] args) {
		TelasJogo tela = new TelasJogo();
		
	}
}
