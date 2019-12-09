package app;
import service.Monitor;
import memento.Originator;
import memento.CareTaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame {

    private Monitor monitor;
    private memento.Originator originator;
    private memento.CareTaker careTaker;

    private JTextArea logi;
    private JButton startButton;
    private JButton stopButton;
    private boolean bool;
    private Thread test;

    public GUI(Monitor monitor, memento.Originator originator, memento.CareTaker careTaker) {
        this.monitor = monitor;
        this.originator = originator;
        this.careTaker = careTaker;

        start();
    }

    public void start() {

        JFrame frame = new JFrame();
        frame.setTitle("BYT9_s17181 URL MONITOR");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        logi = new JTextArea("");
        logi.setBounds(10, 50, 400, 250);
        logi.setEditable(false);
        logi.setLineWrap(true);
        logi.setOpaque(false);

        startButton = new JButton("START");
        startButton.setBounds(0, 0, 100, 20);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool = true;
                run();
            }
        });

        stopButton = new JButton("STOP");
        stopButton.setBounds(120, 0, 100, 20);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool = false;

            }
        });

        frame.add(logi);
        frame.add(startButton);
        frame.add(stopButton);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void run() {

        test = new Thread(() -> {
            int state = 0;
            while (bool) {
                try {
                    monitor.checkForModification(logi);
                    if (state == 1) {
                        originator.setState(monitor.getObserversMap());
                        careTaker.add(originator.saveStateToMemento());
                    }
                    state++;
                    Thread.sleep(5000);
                    if (state == 3) {
                        monitor.setObserversMap(careTaker.get().getState());
                    }
                    logi.append("\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        test.start();

    }

}
