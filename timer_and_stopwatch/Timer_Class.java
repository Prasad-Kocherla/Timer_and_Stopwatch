package timer_and_stopwatch;


import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Prasad Kocherla
 */
@SuppressWarnings("serial")
public class Timer_Class extends javax.swing.JFrame {
    
    //variables:
    int counter = 25;
    Boolean isIt = false;
    
    public Timer_Class() {
        initComponents();
    }


    private void initComponents() {

        timerName = new javax.swing.JLabel();
        timeLeft = new javax.swing.JLabel();
        btnStop = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timerName.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        timerName.setText("Timer : ");

        timeLeft.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        timeLeft.setText("00:00");

        btnStop.setText("Stop");
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.setActionCommand("Start");
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStartMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(47, 47, 47)
                        .addComponent(btnStop))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timerName)
                        .addGap(18, 18, 18)
                        .addComponent(timeLeft)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timerName)
                    .addComponent(timeLeft))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnStartMouseClicked(java.awt.event.MouseEvent evt) {
        Timer timer = new Timer(); //new timer
        counter = 30; //setting counter to 30 sec
        TimerTask task = new TimerTask() {         
            public void run() {                
                timeLeft.setText(Integer.toString(counter)); 
                counter --;
                if (counter == -1){
                    timer.cancel();                                       
                } else if(isIt){
                    timer.cancel();
                    isIt = false;
                }
            }
        };
    timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {
        isIt = true; 
    }
    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Timer_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Timer_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Timer_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Timer_Class.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Timer_Class().setVisible(true);
            } 
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel timeLeft;
    private javax.swing.JLabel timerName;
    
}

