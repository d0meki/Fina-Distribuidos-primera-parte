package Formulario;

import Cliente.Cliente;
import Cliente.DataListenner;
import Cliente.MyEventoDataCliente;
import Cliente.TareaCliente;
import Objetos.SuperClase;
import Protocolos.AsigId;
import Protocolos.Login;
import Protocolos.Matriz;
import Protocolos.Notificacion;
import Protocolos.Register;
import Protocolos.Start;
import Protocolos.Usuario;
import Protocolos.Winner;
import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import socketTCP.MyEvento;
import javax.swing.JOptionPane;

public class FloginCliente extends javax.swing.JFrame implements DataListenner {

    private Cliente cliente;
    private String clienteId;
    private String nickCliente;
    private final int[] dados = new int[5];
    private final int[] dadosElegidos = new int[5];
    // private boolean turno = false;
    private int turno = -1;
    private int nroDeLanzamientos = 0;
    private HashMap<String, String> listaJugadores;
    private HashMap<String, JScrollPane> listaScrollPane;
    Gson gson = new Gson();
    private int x = 20;
    boolean myTabla[][] = {{
        false, false, false},
    {false, false, false},
    {false, false, false},
    {false, false, false}
    };

    public FloginCliente() throws IOException {
        initComponents();
        //--OCULATAMOS COMPONENTES
        this.setLocationRelativeTo(null);
        habilitar(false);
        this.setSize(450, 260);
        listaJugadores = new HashMap();
        listaScrollPane = new HashMap();
        //--INICIALIZAMOS CLIENTE..   
        this.cliente = new Cliente(5000, "127.0.0.1");
        this.cliente.conectarCliente(this);
        this.clienteId = "";
        this.nickCliente = "";

        //OCULTAMOS LOS 3 BOTONES DEL INICIO DEL JUEGO
        this.jButton5.setVisible(false);
        this.jButton6.setVisible(false);
        this.jButton7.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        labelCorreo = new javax.swing.JLabel();
        correoField = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        telefonoField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelUsuario.setText("Usuario");

        labelPassword.setText("Contraseña");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrarse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        labelTitulo.setText("LOGIN");

        labelNombre.setText("Nombre");

        labelCorreo.setText("Correo");

        labelTelefono.setText("Telefono");

        jButton3.setText("Completar Registro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Volver Login");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Jugar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Lanzar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Lanzar 2");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton5)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(186, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(usuarioField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCorreo))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombreField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonoField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correoField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelNombre)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(correoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCorreo))
                        .addGap(18, 18, 18)
                        .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTelefono, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //BOTON LOGIN
        String user = this.usuarioField.getText();
        String password = this.passwordField.getText();
        Login pl = new Login(this.clienteId, user, password);
        this.cliente.Login(pl);
        limpiarCampos();
        ocultarTodo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.labelTitulo.setText("Registro");
        this.setSize(450, 400);
        habilitar(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.labelTitulo.setText("Login");
        this.setSize(450, 260);
        habilitar(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //AQUI EL PROCESO DE REGISTRO
        String nombre = this.nombreField.getText();
        String correo = this.correoField.getText();
        String user = this.usuarioField.getText();
        String password = this.passwordField.getText();
        String telefono = this.telefonoField.getText();
        Register r = new Register(this.clienteId, nombre, correo, user, password, telefono);
        this.cliente.Register(r);
        limpiarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here: JUGAR
        inicializarDados();
        ElegirJugada();
        // this.jButton6.setEnabled(true);
        this.jButton5.setEnabled(false);
        //AVISAR A TODOS QUE EMPEZÓ EL JUEGO
        Start start = new Start(this.clienteId, true);
        this.cliente.empezarJuego(start);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here: LANZAR
        primerLazamiento();
        this.remove(this.listaScrollPane.get("dados"));
        inicializarDados();
        this.jButton6.setEnabled(false);
        this.jButton7.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:LANZAR 2
        SegundoLanzamiento();
        this.remove(this.listaScrollPane.get("dados"));
        inicializarDados();
        this.jButton7.setEnabled(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    public void inicializarDados() {
        String[] columnNames = {"1r dado", "2do dado", "3r dado", "4to dado", "5to dado"};
        Object[][] datos = {
            {this.dados[0], this.dados[1], this.dados[2], this.dados[3], this.dados[4]},};
        DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
        final JTable table = new JTable(dtm);
        //table.getTableHeader().setVisible(false);
        table.setPreferredScrollableViewportSize(new Dimension(150, 50));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 320, 300, 50);
        scrollPane.setName("dados");
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = (JTableHeader) e.getSource();
                int column = header.columnAtPoint(e.getPoint());
                System.out.println("Le di click a la columna: " + column);
                dadosElegidos[column] = 1;
            }
        });
        this.listaScrollPane.put(scrollPane.getName(), scrollPane);
        this.add(scrollPane);
    }

    public void ElegirJugada() {
        String[] columnNames = {"Balas", "Duque", "Trenes", "Escalera", "Full", "poker", "Cuadra", "Quina", "Cena", "grande"};
        Object[][] datos = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
        final JTable table = new JTable(dtm);
        //table.getTableHeader().setVisible(false);
        table.setVisible(false);
        table.setPreferredScrollableViewportSize(new Dimension(150, 50));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 370, 520, 50);
        scrollPane.setName("opciones");
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = (JTableHeader) e.getSource();
                int column = header.columnAtPoint(e.getPoint());
                JScrollPane scrollPane = listaScrollPane.get(clienteId);
                //EDITAR DESDE AQUI LA TABLA DEPENDIENDO LO QUE ELIJA
                switch (column) {
                    case 0:
                        System.out.println("Elegí Bala");
                        if (myTabla[0][0] == false) {
                            myTabla[0][0] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 0, 0, sumarJugada(1));
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }
                        break;
                    case 1:
                        System.out.println("Elegí Duke");
                        if (myTabla[1][0] == false) {
                            myTabla[1][0] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 1, 0, sumarJugada(2));
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }
                        break;
                    case 2:
                        System.out.println("Elegí Trenes");
                        if (myTabla[2][0] == false) {
                            myTabla[2][0] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 2, 0, sumarJugada(3));
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }
                        break;
                    case 3:
                        System.out.println("Elegí Escaleras");
                        if (myTabla[0][1] == false) {
                            if (esEscalera()) {
                                myTabla[0][1] = true;
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 0, 1, 20);
                            } else {
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 0, 1, 0);
                                JOptionPane.showMessageDialog(null, "Usted no tiene Escalera tiene 0 puntos");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                            
                        }
                        break;
                    case 4:
                        System.out.println("Elegí Full");
                        if (myTabla[1][1] == false) {
                            myTabla[1][1] = true;
                            if (esFull()) {
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 1, 1, 35);
                            }else{
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 1, 1, 0);
                                JOptionPane.showMessageDialog(null, "Usted no tiene Full tiene 0 puntos");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }

                        break;
                    case 5:
                        System.out.println("Elegí Poker");
                        if (myTabla[2][1] == false) {
                            myTabla[2][1] = true;
                            if (esPoker()) {
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 2, 1, 45);
                            } else {
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 2, 1, 0);
                                JOptionPane.showMessageDialog(null, "Usted no tiene Poker tiene 0 puntos");
                            }
                        } else {
                              JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }

                        break;
                    case 6:
                        System.out.println("Elegí Cuadra");
                        if (myTabla[0][2] == false) {
                            myTabla[2][1] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 0, 2, sumarJugada(4));
                        } else {
                           JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }
                        break;
                    case 7:
                        System.out.println("Elegí Quina");
                        if (myTabla[1][2] == false) {
                            myTabla[1][2] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 1, 2, sumarJugada(5));
                        } else {
                           JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }
                        break;
                    case 8:
                        System.out.println("Elegí Cena");
                        if (myTabla[2][2] == false) {
                            myTabla[2][2] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 2, 2, sumarJugada(6));
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                        }
                        break;
                    case 9:
                        System.out.println("Elegí Grande");
                        if (grande() == 50) {
                            if (myTabla[3][2] == false) {
                                myTabla[3][2] = true;
                                AcutlizarTabla(scrollPane, scrollPane.getName(), 3, 2, 50);
                            } else {
                               JOptionPane.showMessageDialog(null, "No puede reescribir un Jugada");
                            }
                        } else if(grande() == 100){
                            //GANO EL JUEGO AVISAR A TODOS
                            Winner w = new Winner(clienteId,true);
                            cliente.ganador(w);
                        }else{
                            myTabla[3][2] = true;
                            AcutlizarTabla(scrollPane, scrollPane.getName(), 3, 2, 0);
                            JOptionPane.showMessageDialog(null, "Usted no tiene Grande tiene 0 puntos");
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        this.listaScrollPane.put(scrollPane.getName(), scrollPane);
        this.add(scrollPane);
    }

    public int grande() {
        int cant = 0;
        for (int i = 0; i < dados.length; i++) {
            for (int j = 0; j < dados.length; j++) {
                if ((i + 1) == dados[j]) {
                    cant++;
                }
            }
            if ((cant ==5) && (this.nroDeLanzamientos==1)) {
                return 100;
            }
            if ((cant ==5) && (this.nroDeLanzamientos==2)) {
                return 50;
            }
            cant = 0;
        }
        this.nroDeLanzamientos = 0;
        return -1;
    }

    public boolean esEscalera() {
        int opcion1[] = {1, 2, 3, 4, 5};
        int opcion2[] = {2, 3, 4, 5, 6};
        int opcion3[] = {1, 3, 4, 5, 6};
        boolean estadoFinal = false;
        Arrays.sort(dados);
        if (Arrays.equals(dados, opcion1)) {
            estadoFinal = true;
        }
        if (Arrays.equals(dados, opcion2)) {
            estadoFinal = true;
        }
        if (Arrays.equals(dados, opcion3)) {
            estadoFinal = true;
        }
        return estadoFinal;
    }

    public boolean esFull() {
        int opcion[] = {0, 0, 0, 0, 0, 0};
        int cant = 0;
        for (int i = 0; i < dados.length+1; i++) {
            for (int j = 0; j < dados.length; j++) {
                if ((i + 1) == dados[j]) {
                    cant++;
                }
            }
            opcion[i] = cant;
            cant = 0;
        }
        int catCero = 0;
        for (int i = 0; i < opcion.length; i++) {
            if (opcion[i] == 0) {
                catCero++;
            }
        }
        return catCero == 4;
    }

    public boolean esPoker() {
        int cant = 0;
        for (int i = 0; i < dados.length+1; i++) {
            for (int j = 0; j < dados.length; j++) {
                if ((i + 1) == dados[j]) {
                    cant++;
                }
            }

            if (cant == 4) {
                return true;
            }
            cant = 0;
        }
        return false;
    }

    public void AcutlizarTabla(JScrollPane jsp, String usuario, int fila, int columna, int valor) {
        JViewport viewport = jsp.getViewport();
        JTable mytable = (JTable) viewport.getView();
        mytable.setValueAt(valor, fila, columna);
        int matriz[][] = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = (int) mytable.getValueAt(i, j);
            }
        }
        this.remove(jsp);
        JScrollPane scrollPane2 = new JScrollPane(mytable);
        String borderTitle = this.nickCliente;
        scrollPane2.setName(usuario);
        Border etchedBorder = BorderFactory.createEtchedBorder();
        Border etchedTitledBorder = BorderFactory.createTitledBorder(etchedBorder, borderTitle);
        scrollPane2.setBorder(etchedTitledBorder);
        scrollPane2.setBounds(100, 200, 300, 115);
        this.add(scrollPane2);
        this.listaScrollPane.put(usuario, scrollPane2);
        this.repaint();
        int turnoAMandar = this.turno;
        if (this.listaJugadores.size() == turnoAMandar) {
            turnoAMandar = 1;
        } else {
            turnoAMandar++;
        }
        this.jButton6.setEnabled(false);
        this.nroDeLanzamientos=0;
        Matriz m = new Matriz(this.clienteId, matriz, turnoAMandar);
        this.cliente.enviarTabla(m);
    }
    public int sumarJugada(int num) {
        int sum = 0;
        for (int i = 0; i < this.dados.length; i++) {
            if (num == this.dados[i]) {
                sum += this.dados[i];
            }
        }
        return sum;
    }
    public void primerLazamiento() {
        for (int i = 0; i < dados.length; i++) {
            this.dados[i] = numRandom();
        }
        this.nroDeLanzamientos++;
    }
    public void SegundoLanzamiento() {
        for (int i = 0; i < dados.length; i++) {
            if (this.dadosElegidos[i] == 0) {
                this.dados[i] = numRandom();
                System.out.println("Se Actualizao el dado #: " + i +" por el valor: "+this.dados[i]);
            }
        }
        for (int i = 0; i < dadosElegidos.length; i++) {
            this.dadosElegidos[i] = 0;
        }
        this.nroDeLanzamientos++;
    }

    public int numRandom() {
        return (int) ((Math.random() * ((6 - 1) + 1)) + 1);
    }

    public static void main(String args[]) {
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FloginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FloginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FloginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FloginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FloginCliente().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FloginCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correoField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField telefonoField;
    private javax.swing.JTextField usuarioField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void OnRead(MyEventoDataCliente evt) {

        // TareaSwitchCliente tsc = new TareaSwitchCliente(evt);
        SuperClase sc = gson.fromJson(evt.getMensaje(), SuperClase.class);
        String json = gson.toJson(sc.getClase());
        switch (sc.getIdentificador()) {
            case "Id":
                //almacenar ese ID para que persista mientra exista la conexion
                AsigId aid = gson.fromJson(json, AsigId.class);
                this.clienteId = aid.getId();
                this.jLabel3.setText("id de connecion: " + this.clienteId);
                break;
            case "Notificacion":
                Notificacion not = gson.fromJson(json, Notificacion.class);
                JOptionPane.showMessageDialog(null, not.getMensaje());
                break;
            case "Lista":
                EliminarJscrollPanes();
                this.listaJugadores = gson.fromJson(json, HashMap.class);
                redibujar();
                break;
            case "Matriz":
                Matriz ma = gson.fromJson(json, Matriz.class);
                System.out.println("Le toca Al jugador #: " + ma.getTurno());
                System.out.println("Tu turno es: " + this.turno);
                if (this.turno == ma.getTurno()) {
                    JOptionPane.showMessageDialog(null, "Es tu turno Puedes lanzar");
                    this.jButton6.setEnabled(true);
                } else {
                    System.out.println("No Es tu turno No Puedes lanzar");
                    this.jButton6.setEnabled(false);
                }
                ActualizarTable(ma);
                break;
            case "Juego":
                Start s = gson.fromJson(json, Start.class);
                if (s.isStart()) {
                    inicializarDados();
                    ElegirJugada();
                }
                break;
            case "Ganador":
                Winner win = gson.fromJson(json, Winner.class);
                if (win.isWin()) {
                    JOptionPane.showMessageDialog(null, this.listaJugadores.get(win.getKey()) + "Saco Grande en el Primer Turno, Es el ganador");
                }
                break;    
            default:
                System.out.println("default");
        }
    }

    public void ActualizarTable(Matriz matriz) {
        JScrollPane scrollPane = listaScrollPane.get(matriz.getKey());
        JViewport viewport = scrollPane.getViewport();
        JTable mytable = (JTable) viewport.getView();
        int tablita[][] = matriz.getMatriz();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                mytable.setValueAt(tablita[i][j], i, j);
            }
        }
        scrollPane.removeAll();
        viewport.add(mytable);
        scrollPane.add(viewport);
        this.repaint();
    }

    public void redibujar() {
        if (this.listaJugadores.size() == 1) {
            this.jButton5.setEnabled(true);
            this.jButton6.setEnabled(true);
        }
        if (this.turno == -1) {
            this.turno = this.listaJugadores.size();
        }
        int index = this.listaJugadores.size();
        for (HashMap.Entry<String, String> usuario : this.listaJugadores.entrySet()) {
            String[] columnNames = {"null", "null", "null"};
            Object[][] datos = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            };
            DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
            final JTable table = new JTable();
            table.setModel(dtm);
            table.getTableHeader().setVisible(false);
            table.setPreferredScrollableViewportSize(new Dimension(150, 150));
            JScrollPane scrollPane = new JScrollPane(table);
            Usuario user = gson.fromJson(usuario.getValue(), Usuario.class);
            String borderTitle = user.getUsuario();
            scrollPane.setName(usuario.getKey());
            Border etchedBorder = BorderFactory.createEtchedBorder();
            Border etchedTitledBorder = BorderFactory.createTitledBorder(etchedBorder, borderTitle);
            scrollPane.setBorder(etchedTitledBorder);
            if (this.clienteId.equals(usuario.getKey())) {
                this.nickCliente = user.getUsuario();
                scrollPane.setBounds(100, 200, 300, 115);
            } else {
                scrollPane.setBounds(this.x, 50, 150, 115);
                this.x += 250;
            }
            this.listaScrollPane.put(scrollPane.getName(), scrollPane);
            this.add(scrollPane);
            index--;
        }
        this.repaint();
    }

    public void EliminarJscrollPanes() {
        for (HashMap.Entry<String, JScrollPane> scrollPane : this.listaScrollPane.entrySet()) {
            this.remove(scrollPane.getValue());
        }
        this.x = 20;
        this.listaScrollPane = new HashMap();
    }

    public void habilitar(boolean valor) {
        this.jButton2.setVisible(!valor);
        this.jButton1.setVisible(!valor);
        this.nombreField.setVisible(valor);
        this.correoField.setVisible(valor);
        this.telefonoField.setVisible(valor);
        this.labelNombre.setVisible(valor);
        this.labelCorreo.setVisible(valor);
        this.labelTelefono.setVisible(valor);
        this.jButton3.setVisible(valor);
        this.jButton4.setVisible(valor);

    }

    public void ocultarTodo() {
        this.jButton2.setVisible(false);
        this.jButton1.setVisible(false);
        this.nombreField.setVisible(false);
        this.correoField.setVisible(false);
        this.telefonoField.setVisible(false);
        this.labelNombre.setVisible(false);
        this.labelCorreo.setVisible(false);
        this.labelTelefono.setVisible(false);
        this.jButton1.setVisible(false);
        this.jButton3.setVisible(false);
        this.jButton4.setVisible(false);
        this.jLabel3.setVisible(false);
        this.labelUsuario.setVisible(false);
        this.labelPassword.setVisible(false);
        this.labelTitulo.setVisible(false);
        this.passwordField.setVisible(false);
        this.usuarioField.setVisible(false);
        this.setSize(650, 600);
        this.setTitle("JUEGO DE CACHOS");
        this.jButton5.setVisible(true);
        this.jButton6.setVisible(true);
        this.jButton7.setVisible(true);
        // this.jButton5.setEnabled(false);
        this.jButton5.setEnabled(false);
        this.jButton6.setEnabled(false);
        this.jButton7.setEnabled(false);
        this.jButton5.setBounds(750, 100, 100, 100);
        this.jButton6.setBounds(750, 150, 100, 100);
        this.jButton7.setBounds(750, 200, 100, 100);
    }

    public void limpiarCampos() {
        this.nombreField.setText("");
        this.correoField.setText("");
        this.passwordField.setText("");
        this.telefonoField.setText("");
        this.usuarioField.setText("");
    }
}
